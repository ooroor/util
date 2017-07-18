// Copyright (C) 2014 barakiroth.net
// All rights reserved
package net.barakiroth.oorutil.tuples;

import java.util.Iterator;
import java.util.Random;

import net.barakiroth.oorutil.ArrUt;

/** Common, mostly recursion, functionality for concrete subclasses.
 * A permutator may be regarded as a collection of all possible permutations
 * of Tuplennn-tuples with a given set of possible values.
 * Example:
 * <code>
 * final Tuple002Permutator<String, Integer> tuple002Permutator =
 *			new Tuple002Permutator<String, Integer>(
 *					  new String []{"Hei", null}
 *					, new Integer[]{null, 8}
 *			);
 *
 *	for (final Tuple002<String, Integer> tuple : tuple002Permutator) {
 *		// ... do stuff with the tuple...
 *	}
 * </code>
 * @param <PERMUTATORNMINUSONE> The type of the 
 * permutator treting tuples of size 1 less than 
 * the descentant of this one.
 * @param <TN> The type of the n'th element.
 * @param <TUPLEMINUSONE> The preceding type of the tuple being treated by the descendant.
 * @param <TUPLE> The type of the tuple being treated by the descendant.
 */
abstract class ATuplePermutator<
	  PERMUTATORNMINUSONE extends ATuplePermutator<?, ?, ?, TUPLEMINUSONE>
	, TN
	, TUPLEMINUSONE extends ATuple<?, ?>
	, TUPLE         extends ATuple<TUPLEMINUSONE, TN>>
	implements Iterable<TUPLE> {
	//// =======================================================================
	//// BEGIN nested classes and enums
	////
	/** A tuple specific implementation of the iterator 
	 * needed to satisfy the permutator's iterability.
	 * @param <TN> The type of the element on this level.
	 * @param <PERMUTATORNMINUSONE> The type of the permutator on the level below.
	 * @param <TUPLEMINUSONE> The type of the tuple on the level below.
	 * @param <TUPLE> The type of the tuple on this level.
	 */
	protected final static class TuplePermutatorIterator<
		  TN
		, PERMUTATORNMINUSONE extends ATuplePermutator<?, ?, ?, TUPLEMINUSONE>
		, TUPLEMINUSONE extends ATuple<?, ?>
		, TUPLE extends ATuple<TUPLEMINUSONE, TN>>
		implements Iterator<TUPLE> {

		/**
		 * The indeces used to access the permutator's aray of possible values.
		 */
		private final Integer[] indeces;		
		
		/** The permutator having created this iterator.
		 */
		private final
			ATuplePermutator<PERMUTATORNMINUSONE, TN, TUPLEMINUSONE, TUPLE>
				creatorPermutator;

		/** The iterator on the level below. 
		 */
		private final Iterator<TUPLEMINUSONE> iteratorMinusOne;

		/** To be used for shuffling the 
		 * possible elements in the permutations.
		 */
		private final Random                  random;
		
		/** The index into the array of indeces into the array of possible values.
		 */
		private int                           currIndecesIndex    = -1; // Showing: "Not set".
		
		/** Indicates that {@link #next()} has been called at least once.
		 */
		private boolean hasDelivered        = false;
		
		/**
		 * When iterating on the index on this level, the iterator on the level
		 * below will return the same tuple each time. There for, this tuple
		 * is cashed.
		 */
		private TUPLEMINUSONE cachedTupleMinusOne = null;

		// =====================================================================
		// == BEGIN Constructors ==
		//
		/** Constructor.
		 * @param creatorPermutator The permutator having created this iterator. 
		 * @param random To be used for shuffling the 
		 * possible elements in the permutations.
		 * If not <code>null</code>, the tuple elements 
		 * will be returned in a random manner.
		 */
		@SuppressWarnings("unchecked")
		private TuplePermutatorIterator(
				final ATuplePermutator<
				  PERMUTATORNMINUSONE
				, TN
				, TUPLEMINUSONE
				, TUPLE> creatorPermutator, final Random random) {
			// =================================================================
			this.creatorPermutator = creatorPermutator;
			this.indeces = new Integer[this.creatorPermutator.getVNs().length];
			this.setCurrIndecesIndex(this.indeces.length - 1);
			this.random = random;
			// =================================================================
			for (int i = 0; i < indeces.length; i++) {
				this.indeces[i] = i;
			}
			// =================================================================
			if (this.isTheLastIteratorInTheChain()) {
				this.iteratorMinusOne = (TuplePermutatorIterator<?, ?, ?, TUPLEMINUSONE>)this;
			} else {
				this.iteratorMinusOne =
					this.creatorPermutator.getPermutatorNMinusOne().iterator();
			}
			// =================================================================
		}
		//
		// == END Constructors ==
		// =====================================================================

		/** {@inheritDoc}
		 */
		@Override
		public boolean hasNext() {

			final boolean hasNext;
			// Performance is taken into account 
			// when deciding the sequence of tests:
			if (this.isCurrentlyAtTheLastElement()) {
				if (this.isTheLastIteratorInTheChain()) {
					hasNext = false;
				} else {
					if (hasDelivered) {
						hasNext = this.iteratorMinusOne.hasNext();
					} else {
						hasNext = true;
					}
				}
			} else {
				hasNext = true;
			}

			return hasNext;
		}

		/** {@inheritDoc}
		 * Assume next is not called without
		 * the user having tested
		 * with {@link #hasNext()} first.
		 */
		@SuppressWarnings("unchecked")
		@Override
		public TUPLE next() {

			final TUPLEMINUSONE tupleMinusOne;
			if (this.isTheLastIteratorInTheChain()) {
				tupleMinusOne = (TUPLEMINUSONE)Tuple000.createInstance();
			} else {
				if (this.isCurrentlyAtTheLastElement()) {
					this.setCurrIndecesIndex(0);
					if (this.random != null) {
						ArrUt.shuffle(this.indeces, this.random);
					}
					tupleMinusOne = this.iteratorMinusOne.next();
					this.cachedTupleMinusOne = tupleMinusOne; 
				} else {
					this.increaseIndecesIndex();
					tupleMinusOne = this.cachedTupleMinusOne;
				}
			}

			final TUPLE next =
				this.creatorPermutator.createTuple(
					  tupleMinusOne
					, this.creatorPermutator.getVN(this.getCurrIndex()));

			hasDelivered = true;

			return next;
		}

		/** Returns whether this is a tuple with 1 element or not.
		 * @return Whether this is a tuple with 1 element or not.
		 */
		private boolean isTheLastIteratorInTheChain() {
			return this.creatorPermutator.getSize() == 0;
		}

		// =====================================================================
		// Index related methods:

		/** The index is pointing to the last 
		 * value of the possible values to permutate over.
		 * @return Whether the index is pointing to the last 
		 * value of the possible values to permutate over.
		 */
		private boolean isCurrentlyAtTheLastElement() {
			return this.currIndecesIndex + 1 == this.indeces.length;
		}

		/** Returns the index currently pointing into the possible values of this level.
		 * @return The index currently pointing into the possible values of this level.
		 */
		private int getCurrIndex() {
			return this.indeces[currIndecesIndex];
		}

		/**Increase the index into the collection of indexes to be used.
		 */
		private void increaseIndecesIndex() {
			this.currIndecesIndex++;
		}

		/** Set the index into the collection of indexes to be used.
		 * @param indecesIndex the index into the collection of indexes to be used.
		 */
		private void setCurrIndecesIndex(final int indecesIndex) {
			this.currIndecesIndex = indecesIndex;
		}

		// =====================================================================
	} // END TuplePermutatorIterator class
	////
	//// END nested classes and enums
	//// =======================================================================
	////
	//// S T A T I C
	//// =======================================================================
	//// BEGIN static variables
	//// =======================================================================
	//// BEGIN static public variables
	////
	////
	//// END static public variables
	//// =======================================================================
	//// BEGIN static protected variables
	////
	////
	//// END static protected variables
	//// =======================================================================
	//// BEGIN static package variables
	////
	////
	//// END static package variables
	//// =======================================================================
	//// BEGIN static private variables
	////	////
	//// END static private variables
	//// =======================================================================
	//// END static variables
	//// =======================================================================
	////
	//// I N S T A N C E
	//// =======================================================================
	//// BEGIN instance variables
	//// =======================================================================
	//// BEGIN instance public variables
	////
	////
	//// END instance public variables
	//// =======================================================================
	//// BEGIN instance protected variables
	////
	////
	//// END instance protected variables
	//// =======================================================================
	//// BEGIN instance package variables
	////
	////
	//// END instance package variables
	//// =======================================================================
	//// BEGIN instance private variables
	////
	/** The permutator on the level below.
	 */
	private final PERMUTATORNMINUSONE permutatorNMinusOne;
	
	/** The possible values on this level of the permutator.
	 */
	private final TN[] vNs;
	
	/** Used if shuffling of the elements are wanted upon iteration.
	 */
	private final Random random;
	
	/**The number of elements of the tuples supported by this permutator.
	 */
	private int size = -1;
	////
	//// END instance private variables
	//// =======================================================================
	//// END instance variables
	//// =======================================================================
	//// =======================================================================
	//// BEGIN Constructors
	////
	/** A constructor setting state pertinent to 
	 * this level in the permutator.
	 * @param permutatorNMinusOne 
	 * @param vNs The possible values on this level of the permutator.
	 * @param random Used if shuffling of the elemts are wanted upon iteration.
	 */
	@SuppressWarnings("unchecked")
	protected ATuplePermutator(
			  final PERMUTATORNMINUSONE permutatorNMinusOne
			, final TN[]                vNs
			, final Random              random) {

		this.random = random;
		// Remove duplicates in the array:
		this.vNs = ArrUt.removeDuplicates(vNs);
		if (permutatorNMinusOne == null) {
			// This is ugly cheating. May be done because
			// this constructor is not for public use
			// and is used internally by the tuple designer.
			// (May only be null when the descendant is a Tuple0001Permutator.)
			this.permutatorNMinusOne = (PERMUTATORNMINUSONE)this;
		} else {
			this.permutatorNMinusOne = permutatorNMinusOne;
		}
	}
	////
	//// END Constructors
	//// =======================================================================
	//// =======================================================================
	//// BEGIN Methods
	////
	/** {@inheritDoc}
	 */
	@Override
	public Iterator<TUPLE> iterator() {
		return new TuplePermutatorIterator<TN, PERMUTATORNMINUSONE, TUPLEMINUSONE, TUPLE>(
			  this
			, this.random == null ? null : new Random(random.nextLong()));
	}

	/** Create a tuple corresponding to this level,
	 * containing values as given by the possible
	 * values set by the constructor.
	 * @param tupleNMinusOne The permutator on the level below.
	 * @param vN The value to be used on this level for the permutated tuple to return.
	 * @return A tuple corresponding to this level,
	 * containing values as given by the possible
	 * values set by the constructor. 
	 */
	protected abstract TUPLE createTuple(final TUPLEMINUSONE tupleNMinusOne, final TN vN);

	/** Used internally by the constructors to check that 
	 * a constructor array parameter
	 * is passed as not empty to super.
	 * @param vNs The possible values on this level of the permutator.
	 * @param <TN> The type of the elements in the array as passed as a parameter.
	 * @return The same as passed as input by tha parameter <code>vNs</code>
	 */
	protected static <TN> TN[] checkEmpty(final TN[] vNs) {
		if (vNs.length == 0) {
			throw new IllegalArgumentException(
					  "The array of possible values for "
					+ "one of the elements in the tuple is empty.");
		} else {
			return vNs;
		}
	}

	/** Used internally by the constructors to check that a constructor parameter
	 * is passed as not null to super.
	 * @param vNs The possible values on this level of the permutator.
	 * @param <TN> The type of the elements in the array as passed as a parameter.
	 * @return The same as passed as input by tha parameter <code>vNs</code>
	 */
	protected static <TN> TN[] checkNull(final TN[] vNs) {
		if (vNs == null) {
			throw new NullPointerException(
					  "The array of possible values for "
					+ "one of the elements in the tuple is null.");
		} else {
			return vNs;
		}
	}

	/** Returns the permutator on the level below.
	 * @return the permutatorNMinusOne
	 */
	private PERMUTATORNMINUSONE getPermutatorNMinusOne() {
		return this.permutatorNMinusOne;
	}

	/**
	 * Returns the next possible value of this level's element,
	 * as given by the index parameter.
	 * @param index The index into the array of possible values.
	 * @return The next possible value of this level's element.
	 */
	protected TN getVN(final int index) {
		return getVNs()[index];
	}

	/**
	 * @return the vNs
	 */
	private TN[] getVNs() {
		return this.vNs;
	}

	/** Returns the number of elements in the 
	 * tuples to be produced by the permutator.
	 * Since it is rather expensive to
	 * get the size (recursively), it is cached
	 * which benefits subsequent size queries.
	 * @return The number of elements in the 
	 * tuples to be produced by the permutator.
	 * E.g. the tuple [1, "Hello", true] has a size of 3. 
	 */
	protected int getSize() {
		if (this.size == -1) {
			this.size = this.permutatorNMinusOne.getSize() + 1;
		}
		return this.size;
	}
	////
	//// END Methods
	//// =======================================================================
}
// Copyright (C) 2014 barakiroth.net
// All rights reserved
package net.barakiroth.oorutil.tuples;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.javatuples.Decade;
import org.javatuples.Ennead;
import org.javatuples.Octet;
import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Septet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;
import org.javatuples.Tuple;
import org.javatuples.Unit;

/**
 * Utilities pertinent to tuples in general and the
 * {@link org.javatuples.Tuple} descendants in special. 
 */
public class TupUt {
	//// =======================================================================
	//// BEGIN nested classes and enums
	////
	// =====================================================================
	////
	/**
	 * The heart of the concept, returning a tuple with the permuted values.
	 *
	 * @param <THISPERMUTATOR> The type of the tuple on this level.
	 * @param <THISTUPLE> The type of the tuple.
	 * @param <THISVALUE> The type of the values in this tuple element.
	 * @param <INNERPERMUTATOR> The type of the permutator for 
	 * the tuple at the left level of this one.
	 * @param <INNERTUPLE> The type of the inner tuple.
	 */
	private static class PermutatorIterator<
		  THISPERMUTATOR extends IPermutator<THISPERMUTATOR
		                                   , THISTUPLE
		                                   , THISVALUE
		                                   , INNERPERMUTATOR
		                                   , INNERTUPLE>
		, THISTUPLE       extends Tuple
		, THISVALUE
		, INNERPERMUTATOR extends Iterable<INNERTUPLE>
	    , INNERTUPLE      extends Tuple
	>
		implements java.util.Iterator<THISTUPLE> {

		/**
		 * The iterator giving the tuple to the left of this level.
		 */
		private final java.util.Iterator<INNERTUPLE> innerIterator;

		/**
		 * Makes an instance of this class stateful with respect to iteration.
		 * It points to the legal values to be used in the generated tuple.  
		 */
		private java.util.Iterator<THISVALUE> iterator;
		
		/**
		 * The possible values of the tuple element on this level.
		 */
		private final List<THISVALUE> valueCollection;
		
		/**
		 * The last instantiated tuple of the elements to the left.
		 */
		private INNERTUPLE lastInnerValue;
		
		/**
		 * The permutator having instantiated this iterator.
		 */
		private final THISPERMUTATOR thisPermutator;
		
		/**
		 * Used in case of the contents of the tuple is to be randomized.
		 * May be <code>null</code>, in which case no randomization is done.
		 */
		private final Random random;

		/**
		 * Takes care of the calling permutator.
		 * @param thisPermutator The permutator calling the generation of this iterator.  
		 */
		private PermutatorIterator(final THISPERMUTATOR  thisPermutator) {

			this.innerIterator = thisPermutator.getInnerPermutator().iterator();
			this.valueCollection = thisPermutator.getValueCollection();
			this.random = thisPermutator.getRandom();

			if (this.random != null) {
				Collections.shuffle(this.valueCollection, this.random);
			}

			this.iterator       = this.valueCollection.iterator();
			this.lastInnerValue = this.innerIterator.next();
			this.thisPermutator = thisPermutator;
		}

		@Override
		public boolean hasNext() {
			return iterator.hasNext() || innerIterator.hasNext();
		}

		@Override
		public THISTUPLE next() {

			if (!hasNext()) {
				throw new NoSuchElementException("next() is called on an iterator where hasNext() returned false.");
			}

			final THISTUPLE nextTuple;
			if (!this.iterator.hasNext()) {
				this.lastInnerValue = innerIterator.next();
				if (random != null) {
					Collections.shuffle(this.valueCollection, this.random);
				}
				this.iterator = valueCollection.iterator();
			}

			final THISVALUE lastValue = this.iterator.next();
			nextTuple = this.thisPermutator.add(this.lastInnerValue, lastValue);

			return nextTuple;
		}
	}

	// =====================================================================

	/**
	 * Common methods for the permutators.
	 *
	 * @param <THISPERMUTATOR> The ascendant permutator type.
	 * @param <THISTUPLE> The tuple type on this level.
	 * @param <THISVALUE> The type of the values stored in this position of the tuple.
	 * @param <INNERPERMUTATOR> The type of the permutator for the tuple elements to the left of this level.
	 * @param <INNERTUPLE> The tuple type on on the left.
	 */
	private interface IPermutator<
		  THISPERMUTATOR extends IPermutator<
		  								THISPERMUTATOR
							          , THISTUPLE
							          , THISVALUE
							          , INNERPERMUTATOR
							          , INNERTUPLE
							     >
		, THISTUPLE       extends Tuple
		, THISVALUE
		, INNERPERMUTATOR extends Iterable<INNERTUPLE>
		, INNERTUPLE      extends Tuple
	>
		extends Iterable<THISTUPLE> {

		/**
		 * Extends the tuple to the left with one element to 
		 * yield a tuple of the type pertinent to thi level.
		 * @param innerTuple The tuple to the left in the tuple hierarchy.
		 * @param thisValue The actual value to put into the last element of the tuple.
		 * @return The newly generated tuple of this level's type.
		 */
		public THISTUPLE add(final INNERTUPLE innerTuple, final THISVALUE thisValue);

		/**
		 * @return the random
		 */
		public Random getRandom();

		/**
		 * @return the valueCollection
		 */
		public List<THISVALUE> getValueCollection();

		/**
		 * @return the innerPermutator
		 */
		public INNERPERMUTATOR getInnerPermutator();
	}

	// =====================================================================

	/**
	 * Taking care of the functionality common to all descendants.
	 *
	 * @param <THISPERMUTATOR> The ascendant permutator type.
	 * @param <THISTUPLE> The tuple type on this level.
	 * @param <THISVALUE> The type of the values stored in this position of the tuple.
	 * @param <INNERPERMUTATOR> The type of the permutator for the tuple elements to the left of this level.
	 * @param <INNERTUPLE> The tuple type on on the left.
	 */
	private abstract static class APermutator<
		  THISPERMUTATOR extends IPermutator<
		  							  THISPERMUTATOR
		  							, THISTUPLE
		  							, THISVALUE
		  							, INNERPERMUTATOR
		  							, INNERTUPLE>
		, THISTUPLE      extends Tuple
		, THISVALUE
		, INNERPERMUTATOR extends Iterable<INNERTUPLE>
		, INNERTUPLE      extends Tuple
	>
		implements IPermutator<
			  THISPERMUTATOR
			, THISTUPLE
			, THISVALUE
			, INNERPERMUTATOR
			, INNERTUPLE
		> {	
		/**
		 * If not <code>null</code>, used to randomized the {@link #valueCollection}.  
		 */
		private final Random random;

		/**
		 * The set of possible values for the current level element.
		 */
		private final List<THISVALUE> valueCollection;

		/**
		 * Supplier of permuted tuples of the preceding elements.
		 */
		private final INNERPERMUTATOR innerPermutator;

		/**
		 * Taking care of values of interest for al descendants.
		 * @param valueCollection The possible values on this level in the tuple.
		 * @param innerPermutator The iterator iterating on the lower levels (farther to the left).
		 * @param random The randomizer in case the client wants the permutations to be randomized.
		 */
		protected APermutator(
				  final THISVALUE[]     valueCollection
				, final INNERPERMUTATOR innerPermutator
				, final Random          random) {

			if (valueCollection == null) {
				throw new NullPointerException("A set of legal values is null");
			}

			if (valueCollection.length == 0) {
				throw new IllegalArgumentException("A set of legal values is empty");
			}

			this.random = random;
			this.valueCollection = Arrays.asList(valueCollection);
			this.innerPermutator = innerPermutator;
			if (this.random != null) {
				Collections.shuffle(this.valueCollection, random);
			}
		}

		/**
		 * @return the random
		 */
		@Override
		public Random getRandom() {
			return random;
		}

		/**
		 * @return the valueCollection
		 */
		@Override
		public List<THISVALUE> getValueCollection() {
			return valueCollection;
		}

		/**
		 * @return the innerPermutator
		 */
		@Override
		public INNERPERMUTATOR getInnerPermutator() {
			return innerPermutator;
		}
	}

	// =========================================================================

	/**
	 * A Recursive "stopper class" of {@link Tuple} for recursive use.
	 */
	private static class Void<A>
		extends Tuple {

		/**
		 * To satisfy the serialization functionality.
		 */
		private static final long serialVersionUID = 5880454277224991708L;

		/**
		 * {@inheritDoc}
		 */
		@Override
		public int getSize() {
			return 0;
		}

		/**
		 * Makes a tuple which is one element bigger
		 * containing the value as given by the parameter.
		 * @param value The value to store in the tuple.
		 * @return The newly generated tuple containing the value as given in the parameter.
		 */
		public Unit<A> add(final A value) {
			final Unit<A> tuple = new Unit<A>(value);
			return tuple;
		}
	}

	// =========================================================================

	/**
	 * A Recursive "stopper class" of {@link IPermutator} for recursive use.
	 */
	private static class VoidPermutator<Z>
		extends APermutator<VoidPermutator<Z>, Void<Z>, Z, VoidPermutator<Z>, Void<Z>> {

		/**
		 * Default constructor.
		 */
		@SuppressWarnings("unchecked")
		private VoidPermutator() {
			super((Z[])new Object[]{null}, null, null);
		}

		@Override
		public Void<Z> add(Void<Z> innerTuple, Z thisValue) {
			return null;
		}

		@Override
		public Iterator<Void<Z>> iterator() {
			Iterator<Void<Z>> iterator = new Iterator<Void<Z>>() {
				@Override
				public boolean hasNext() {
					return false;
				}

				@Override
				public Void<Z> next() {
					final Void<Z> voidInstance = new Void<Z>();
					return voidInstance;
				}
			};

			return iterator;
		}
	}

	// =========================================================================

	public static class UnitPermutator<A>
		extends APermutator<UnitPermutator<A>, Unit<A>, A, VoidPermutator<A>, Void<A>>
	{
		/**
		 * Constructor taking the possible values for the elements as parameters.
		 *
		 * @param as The possible 1. values
		 */
		public UnitPermutator(final A[] as) {
			this(as, null);
		}

		/**
		 * Constructor taking the possible values for the elements as parameters.
		 *
		 * @param as The possible 1. values
		 * @param random If not <code>null</code>, the tuples will be randomized.
		 * There is no guarantee for the degree of randomness, however.
		 */
		public UnitPermutator(final A[] as, final Random random) {
			super(as, new VoidPermutator<A>(), random);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public java.util.Iterator<Unit<A>> iterator() {
			return new PermutatorIterator<
				  UnitPermutator<A>
				, Unit<A>
				, A
				, VoidPermutator<A>
			    , Void<A>
			>(this);
		}

		@Override
		public Unit<A> add(final Void<A> innerTuple, A thisValue) {
			final Unit<A> newTuple = innerTuple.add(thisValue);
			return newTuple;
		}
	}

	// =========================================================================

	public static class PairPermutator<A, B>
		extends APermutator<PairPermutator<A, B>, Pair<A, B>, B, UnitPermutator<A>, Unit<A>>
	{
		/**
		 * Constructor taking the possible values for the elements as parameters.
		 *
		 * @param as The possible 1. values
		 * @param bs The possible 2. values
		 */
		public PairPermutator(final A[] as, final B[] bs) {
			this(as, bs, null);
		}

		/**
		 * Constructor taking the possible values for the elements as parameters.
		 *
		 * @param as The possible 1. values
		 * @param bs The possible 2. values
		 * @param random If not <code>null</code>, the tuples will be randomized.
		 * There is no guarantee for the degree of randomness, however.
		 */
		public PairPermutator(final A[] as, final B[] bs, final Random random) {
			super(bs, new UnitPermutator<A>(as, random), random);
		}
		
		/**
		 * {@inheritDoc}
		 */
		@Override
		public java.util.Iterator<Pair<A, B>> iterator() {
			return new PermutatorIterator<
				  PairPermutator<A, B>
				, Pair<A, B>
				, B
				, UnitPermutator<A>
			    , Unit<A>
			>(this);
		}

		@Override
		public Pair<A, B> add(final Unit<A> innerTuple, B thisValue) {
			final Pair<A, B> newTuple = innerTuple.add(thisValue);
			return newTuple;
		}
	}
	
	// =====================================================================

	/**
	 * Lets you iterate on all permutations of given values of the tuple wanted.
	 * Example:
	 * Wanting
	 * {@link Triplet<String, Integer, Boolean>} instances
	 * where
	 * the values of the String element can be "a", "b" and
	 * the values of the Integer element can be 1, 2 and 3 and
	 * the values of the Boolean element can be true, null and false
	 * <BR/>
	 * <code>
	 * final TupUt.TripletPermutator<String, Integer, Boolean> innerPermutator =
	 *   new TupUt.TripletPermutator<String, Integer, Boolean>(
	 *       new String [] {"a", "b"}
	 *     , new Integer[] {1, 2, 3}
	 *     , new Boolean[] {true, null, false}
	 *   );
	 *
	 * for (final Triplet<String, Integer, Boolean> triplet : innerPermutator) {
	 *   System.out.println(triplet);
	 * }
	 * </code>
	 * would give:
	 * <code>
	 * [a, 1, true]
	 * [a, 1, null]
	 * [a, 1, false]
	 * [a, 2, true]
	 * [a, 2, null]
	 * [a, 2, false]
	 * [a, 3, true]
	 * [a, 3, null]
	 * [a, 3, false]
	 * [b, 1, true]
	 * [b, 1, null]
	 * [b, 1, false]
	 * [b, 2, true]
	 * [b, 2, null]
	 * [b, 2, false]
	 * [b, 3, true]
	 * [b, 3, null]
	 * [b, 3, false]
	 * </code>
	 *
	 * @param <A> The type of the 1. element of the tuples.
	 * @param <B> The type of the 2. element of the tuples.
	 * @param <C> The type of the 3. element of the tuples.
	 */
	public static class TripletPermutator<A, B, C>
		extends APermutator<TripletPermutator<A, B, C>, Triplet<A, B, C>, C, PairPermutator<A, B>, Pair<A, B>> {

		/**
		 * Constructor taking all actual possible values for each of the tuple's elements.
		 *
		 * @param as All legal 1. values of the tuple.
		 * @param bs All legal 2. values of the tuple.
		 * @param cs All legal 3. values of the tuple.
		 */
		public TripletPermutator(final A[] as, final B[] bs, final C[] cs) {
			this(as, bs, cs, null);
		}

		/**
		 * Constructor taking all actual possible values for each of the tuple's elements.
		 *
		 * @param as All legal 1. values of the tuple.
		 * @param bs All legal 2. values of the tuple.
		 * @param cs All legal 3. values of the tuple.
		 * @param random If not <code>null</code>, the tuples will be randomized.
		 * There is no guarantee for the degree of randomness, however.
		 */
		public TripletPermutator(final A[] as, final B[] bs, final C[] cs, final Random random) {
			super(cs, new PairPermutator<A, B>(as, bs, random), random);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public java.util.Iterator<Triplet<A, B, C>> iterator() {
			return new PermutatorIterator<
					TripletPermutator<A, B, C>
				, Triplet<A, B, C>
				, C
				, PairPermutator<A, B>
			    , Pair<A, B>
			>(this);
		}

		@Override
		public Triplet<A, B, C> add(final Pair<A, B> innerTuple, C thisValue) {
			final Triplet<A, B, C> newTuple = innerTuple.add(thisValue);
			return newTuple;
		}
	}
	
	// =====================================================================
	
	public static class QuartetPermutator<A, B, C, D>
		extends APermutator<QuartetPermutator<A, B, C, D>, Quartet<A, B, C, D>, D, TripletPermutator<A, B, C>, Triplet<A, B, C>> {

		/**
		 * Constructor taking all actual possible values for each of the tuple's elements.
		 *
		 * @param as All legal 1. values of the tuple.
		 * @param bs All legal 2. values of the tuple.
		 * @param cs All legal 3. values of the tuple.
		 * @param ds All legal 4. values of the tuple.
		 */
		public QuartetPermutator(final A[] as, final B[] bs, final C[] cs, final D[] ds) {			
			this(as, bs, cs, ds, null);
		}

		/**
		 * Constructor taking all actual possible values for each of the tuple's elements.
		 *
		 * @param as All legal 1. values of the tuple.
		 * @param bs All legal 2. values of the tuple.
		 * @param cs All legal 3. values of the tuple.
		 * @param ds All legal 4. values of the tuple.
		 * @param random If not <code>null</code>, the tuples will be randomized.
		 * There is no guarantee for the degree of randomness, however.
		 */
		public QuartetPermutator(final A[] as, final B[] bs, final C[] cs, final D[] ds, final Random random) {
			super(ds, new TripletPermutator<A, B, C>(as, bs, cs, random), random);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public java.util.Iterator<Quartet<A, B, C, D>> iterator() {
			return new PermutatorIterator<
				  QuartetPermutator<A, B, C, D>
				, Quartet<A, B, C, D>
				, D
				, TripletPermutator<A, B, C>
			    , Triplet<A, B, C>
			>(this);
		}

		@Override
		public Quartet<A, B, C, D> add(final Triplet<A, B, C> innerTuple, D thisValue) {
			final Quartet<A, B, C, D> newTuple = innerTuple.add(thisValue);
			return newTuple;
		}
	}
	
	// =====================================================================
	
	public static class  QuintetPermutator<A, B, C, D, E>
		extends APermutator<
			  QuintetPermutator<A, B, C, D, E>
			, Quintet<A, B, C, D, E>
			, E
			, QuartetPermutator<A, B, C, D>
			, Quartet<A, B, C, D>> {

		/**
		 * Constructor taking all actual possible values for each of the tuple's elements.
		 *
		 * @param as All legal 1. values of the tuple.
		 * @param bs All legal 2. values of the tuple.
		 * @param cs All legal 3. values of the tuple.
		 * @param ds All legal 4. values of the tuple.
		 * @param es All legal 5. values of the tuple.
		 */
		public QuintetPermutator(final A[] as, final B[] bs, final C[] cs, final D[] ds, final E[] es) {
			this(as, bs, cs, ds, es, null);
		}

		/**
		 * Constructor taking all actual possible values for each of the tuple's elements.
		 *
		 * @param as All legal 1. values of the tuple.
		 * @param bs All legal 2. values of the tuple.
		 * @param cs All legal 3. values of the tuple.
		 * @param ds All legal 4. values of the tuple.
		 * @param es All legal 5. values of the tuple.
		 * @param random If not <code>null</code>, the tuples will be randomized.
		 * There is no guarantee for the degree of randomness, however.
		 */
		public QuintetPermutator(final A[] as, final B[] bs, final C[] cs, final D[] ds, final E[] es, final Random random) {
			super(es, new QuartetPermutator<A, B, C, D>(as, bs, cs, ds, random), random);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public java.util.Iterator<Quintet<A, B, C, D, E>> iterator() {
			return new PermutatorIterator<
				  QuintetPermutator<A, B, C, D, E>
				, Quintet<A, B, C, D, E>
				, E
				, QuartetPermutator<A, B, C, D>
			    , Quartet<A, B, C, D>
			>(this);
		}

		@Override
		public Quintet<A, B, C, D, E> add(final Quartet<A, B, C, D> innerTuple, E thisValue) {
			final Quintet<A, B, C, D, E> newTuple = innerTuple.add(thisValue);
			return newTuple;
		}
	}

	// =====================================================================

	public static class  SextetPermutator<A, B, C, D, E, F>
		extends APermutator<
		      SextetPermutator<A, B, C, D, E, F>
			, Sextet<A, B, C, D, E, F>
			, F
			, QuintetPermutator<A, B, C, D, E>
			, Quintet<A, B, C, D, E>> {

		/**
		 * Constructor taking all actual possible values for each of the tuple's elements.
		 *
		 * @param as All legal 1. values of the tuple.
		 * @param bs All legal 2. values of the tuple.
		 * @param cs All legal 3. values of the tuple.
		 * @param ds All legal 4. values of the tuple.
		 * @param es All legal 5. values of the tuple.
		 * @param fs All legal 6. values of the tuple.
		 */
		public SextetPermutator(final A[] as, final B[] bs, final C[] cs, final D[] ds, final E[] es, final F[] fs) {
			this(as, bs, cs, ds, es, fs, null);
		}

		/**
		 * Constructor taking all actual possible values for each of the tuple's elements.
		 *
		 * @param as All legal 1. values of the tuple.
		 * @param bs All legal 2. values of the tuple.
		 * @param cs All legal 3. values of the tuple.
		 * @param ds All legal 4. values of the tuple.
		 * @param es All legal 5. values of the tuple.
		 * @param fs All legal 6. values of the tuple.
		 * @param random If not <code>null</code>, the tuples will be randomized.
		 * There is no guarantee for the degree of randomness, however.
		 */
		public SextetPermutator(final A[] as, final B[] bs, final C[] cs, final D[] ds, final E[] es, final F[] fs, final Random random) {
			super(fs, new QuintetPermutator<A, B, C, D, E>(as, bs, cs, ds, es, random), random);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public java.util.Iterator<Sextet<A, B, C, D, E, F>> iterator() {
			return new PermutatorIterator<
				  SextetPermutator<A, B, C, D, E, F>
				, Sextet<A, B, C, D, E, F>
				, F
				, QuintetPermutator<A, B, C, D, E>
			    , Quintet<A, B, C, D, E>
			>(this);
		}

		@Override
		public Sextet<A, B, C, D, E, F> add(Quintet<A, B, C, D, E> innerTuple,
				F thisValue) {
			final Sextet<A, B, C, D, E, F> newTuple = innerTuple.add(thisValue);
			return newTuple;
		}
	}

	// =====================================================================

	public static class  SeptetPermutator<A, B, C, D, E, F, G>
		extends APermutator<
		      SeptetPermutator<A, B, C, D, E, F, G>
			, Septet<A, B, C, D, E, F, G>
			, G
			, SextetPermutator<A, B, C, D, E, F>
			, Sextet<A, B, C, D, E, F>> {

		/**
		 * Constructor taking all actual possible values for each of the tuple's elements.
		 *
		 * @param as All legal 1. values of the tuple.
		 * @param bs All legal 2. values of the tuple.
		 * @param cs All legal 3. values of the tuple.
		 * @param ds All legal 4. values of the tuple.
		 * @param es All legal 5. values of the tuple.
		 * @param fs All legal 6. values of the tuple.
		 * @param gs All legal 7. values of the tuple.
		 */
		public SeptetPermutator(final A[] as, final B[] bs, final C[] cs, final D[] ds, final E[] es, final F[] fs, final G[] gs) {
			this(as, bs, cs, ds, es, fs, gs, null);
		}

		/**
		 * Constructor taking all actual possible values for each of the tuple's elements.
		 *
		 * @param as All legal 1. values of the tuple.
		 * @param bs All legal 2. values of the tuple.
		 * @param cs All legal 3. values of the tuple.
		 * @param ds All legal 4. values of the tuple.
		 * @param es All legal 5. values of the tuple.
		 * @param fs All legal 6. values of the tuple.
		 * @param gs All legal 7. values of the tuple.
		 * @param random If not <code>null</code>, the tuples will be randomized.
		 * There is no guarantee for the degree of randomness, however.
		 */
		public SeptetPermutator(final A[] as, final B[] bs, final C[] cs, final D[] ds, final E[] es, final F[] fs, final G[] gs, final Random random) {
			super(gs, new SextetPermutator<A, B, C, D, E, F>(as, bs, cs, ds, es, fs, random), random);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public java.util.Iterator<Septet<A, B, C, D, E, F, G>> iterator() {
			return new PermutatorIterator<
				  SeptetPermutator<A, B, C, D, E, F, G>
				, Septet<A, B, C, D, E, F, G>
				, G
				, SextetPermutator<A, B, C, D, E, F>
			    , Sextet<A, B, C, D, E, F>
			>(this);
		}

		@Override
		public Septet<A, B, C, D, E, F, G> add(Sextet<A, B, C, D, E, F> innerTuple,
				G thisValue) {
			final Septet<A, B, C, D, E, F, G> newTuple = innerTuple.add(thisValue);
			return newTuple;
		}
	}

	// =====================================================================

	public static class  OctetPermutator<A, B, C, D, E, F, G, H>
		extends APermutator<
		      OctetPermutator<A, B, C, D, E, F, G, H>
			, Octet<A, B, C, D, E, F, G, H>
			, H
			, SeptetPermutator<A, B, C, D, E, F, G>
			, Septet<A, B, C, D, E, F, G>> {

		/**
		 * Constructor taking all actual possible values for each of the tuple's elements.
		 *
		 * @param as All legal 1. values of the tuple.
		 * @param bs All legal 2. values of the tuple.
		 * @param cs All legal 3. values of the tuple.
		 * @param ds All legal 4. values of the tuple.
		 * @param es All legal 5. values of the tuple.
		 * @param fs All legal 6. values of the tuple.
		 * @param gs All legal 7. values of the tuple.
		 * @param hs All legal 8. values of the tuple.
		 */
		public OctetPermutator(final A[] as, final B[] bs, final C[] cs, final D[] ds, final E[] es, final F[] fs, final G[] gs, final H[] hs) {
			this(as, bs, cs, ds, es, fs, gs, hs, null);
		}

		/**
		 * Constructor taking all actual possible values for each of the tuple's elements.
		 *
		 * @param as All legal 1. values of the tuple.
		 * @param bs All legal 2. values of the tuple.
		 * @param cs All legal 3. values of the tuple.
		 * @param ds All legal 4. values of the tuple.
		 * @param es All legal 5. values of the tuple.
		 * @param fs All legal 6. values of the tuple.
		 * @param gs All legal 7. values of the tuple.
		 * @param hs All legal 8. values of the tuple.
		 * @param random If not <code>null</code>, the tuples will be randomized.
		 * There is no guarantee for the degree of randomness, however.
		 */
		public OctetPermutator(final A[] as, final B[] bs, final C[] cs, final D[] ds, final E[] es, final F[] fs, final G[] gs, final H[] hs, final Random random) {
			super(hs, new SeptetPermutator<A, B, C, D, E, F, G>(as, bs, cs, ds, es, fs, gs, random), random);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public java.util.Iterator<Octet<A, B, C, D, E, F, G, H>> iterator() {
			return new PermutatorIterator<
				  OctetPermutator<A, B, C, D, E, F, G, H>
				, Octet<A, B, C, D, E, F, G, H>
				, H
				, SeptetPermutator<A, B, C, D, E, F, G>
			    , Septet<A, B, C, D, E, F, G>
			>(this);
		}

		@Override
		public Octet<A, B, C, D, E, F, G, H> add(Septet<A, B, C, D, E, F, G> innerTuple,
				H thisValue) {
			final Octet<A, B, C, D, E, F, G, H> newTuple = innerTuple.add(thisValue);
			return newTuple;
		}
	}

	// =====================================================================

	public static class  EnneadPermutator<A, B, C, D, E, F, G, H, I>
		extends APermutator<
		      EnneadPermutator<A, B, C, D, E, F, G, H, I>
			, Ennead<A, B, C, D, E, F, G, H, I>
			, I
			, OctetPermutator<A, B, C, D, E, F, G, H>
			, Octet<A, B, C, D, E, F, G, H>> {

		/**
		 * Constructor taking all actual possible values for each of the tuple's elements.
		 *
		 * @param as All legal 1. values of the tuple.
		 * @param bs All legal 2. values of the tuple.
		 * @param cs All legal 3. values of the tuple.
		 * @param ds All legal 4. values of the tuple.
		 * @param es All legal 5. values of the tuple.
		 * @param fs All legal 6. values of the tuple.
		 * @param gs All legal 7. values of the tuple.
		 * @param hs All legal 8. values of the tuple.
		 * @param is All legal 9. values of the tuple.
		 */
		public EnneadPermutator(final A[] as, final B[] bs, final C[] cs, final D[] ds, final E[] es, final F[] fs, final G[] gs, final H[] hs, final I[] is) {
			this(as, bs, cs, ds, es, fs, gs, hs, is, null);
		}

		/**
		 * Constructor taking all actual possible values for each of the tuple's elements.
		 *
		 * @param as All legal 1. values of the tuple.
		 * @param bs All legal 2. values of the tuple.
		 * @param cs All legal 3. values of the tuple.
		 * @param ds All legal 4. values of the tuple.
		 * @param es All legal 5. values of the tuple.
		 * @param fs All legal 6. values of the tuple.
		 * @param gs All legal 7. values of the tuple.
		 * @param hs All legal 8. values of the tuple.
		 * @param is All legal 9. values of the tuple.
		 * @param random If not <code>null</code>, the tuples will be randomized.
		 * There is no guarantee for the degree of randomness, however.
		 */
		public EnneadPermutator(final A[] as, final B[] bs, final C[] cs, final D[] ds, final E[] es, final F[] fs, final G[] gs, final H[] hs, final I[] is, final Random random) {
			super(is, new OctetPermutator<A, B, C, D, E, F, G, H>(as, bs, cs, ds, es, fs, gs, hs, random), random);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public java.util.Iterator<Ennead<A, B, C, D, E, F, G, H, I>> iterator() {
			return new PermutatorIterator<
				  EnneadPermutator<A, B, C, D, E, F, G, H, I>
				, Ennead<A, B, C, D, E, F, G, H, I>
				, I
				, OctetPermutator<A, B, C, D, E, F, G, H>
			    , Octet<A, B, C, D, E, F, G, H>
			>(this);
		}

		@Override
		public Ennead<A, B, C, D, E, F, G, H, I> add(Octet<A, B, C, D, E, F, G, H> innerTuple,
				I thisValue) {
			final Ennead<A, B, C, D, E, F, G, H, I> newTuple = innerTuple.add(thisValue);
			return newTuple;
		}
	}

	// =====================================================================

	public static class  DecadePermutator<A, B, C, D, E, F, G, H, I, J>
		extends APermutator<
		DecadePermutator<A, B, C, D, E, F, G, H, I, J>
			, Decade<A, B, C, D, E, F, G, H, I, J>
			, J
			, EnneadPermutator<A, B, C, D, E, F, G, H, I>
			, Ennead<A, B, C, D, E, F, G, H, I>> {

		/**
		 * Constructor taking all actual possible values for each of the tuple's elements.
		 *
		 * @param as All legal  1. values of the tuple.
		 * @param bs All legal  2. values of the tuple.
		 * @param cs All legal  3. values of the tuple.
		 * @param ds All legal  4. values of the tuple.
		 * @param es All legal  5. values of the tuple.
		 * @param fs All legal  6. values of the tuple.
		 * @param gs All legal  7. values of the tuple.
		 * @param hs All legal  8. values of the tuple.
		 * @param is All legal  9. values of the tuple.
		 * @param js All legal 10. values of the tuple.
		 */
		public DecadePermutator(final A[] as, final B[] bs, final C[] cs, final D[] ds, final E[] es, final F[] fs, final G[] gs, final H[] hs, final I[] is, final J[] js) {
			this(as, bs, cs, ds, es, fs, gs, hs, is, js, null);
		}

		/**
		 * Constructor taking all actual possible values for each of the tuple's elements.
		 *
		 * @param as All legal  1. values of the tuple.
		 * @param bs All legal  2. values of the tuple.
		 * @param cs All legal  3. values of the tuple.
		 * @param ds All legal  4. values of the tuple.
		 * @param es All legal  5. values of the tuple.
		 * @param fs All legal  6. values of the tuple.
		 * @param gs All legal  7. values of the tuple.
		 * @param hs All legal  8. values of the tuple.
		 * @param is All legal  9. values of the tuple.
		 * @param js All legal 10. values of the tuple.
		 * @param random If not <code>null</code>, the tuples will be randomized.
		 * There is no guarantee for the degree of randomness, however.
		 */
		public DecadePermutator(final A[] as, final B[] bs, final C[] cs, final D[] ds, final E[] es, final F[] fs, final G[] gs, final H[] hs, final I[] is, final J[] js, final Random random) {
			super(js, new EnneadPermutator<A, B, C, D, E, F, G, H, I>(as, bs, cs, ds, es, fs, gs, hs, is, random), random);
		}

		/**
		 * {@inheritDoc}
		 */
		@Override
		public java.util.Iterator<Decade<A, B, C, D, E, F, G, H, I, J>> iterator() {
			return new PermutatorIterator<
					DecadePermutator<A, B, C, D, E, F, G, H, I, J>
				, Decade<A, B, C, D, E, F, G, H, I, J>
				, J
				, EnneadPermutator<A, B, C, D, E, F, G, H, I>
			    , Ennead<A, B, C, D, E, F, G, H, I>
			>(this);
		}

		@Override
		public Decade<A, B, C, D, E, F, G, H, I, J> add(Ennead<A, B, C, D, E, F, G, H, I> innerTuple,
				J thisValue) {
			final Decade<A, B, C, D, E, F, G, H, I, J> newTuple = innerTuple.add(thisValue);
			return newTuple;
		}
	}
	////
	//// =======================================================================
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
	////
	////
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
	////
	//// END instance private variables
	//// =======================================================================
	//// END instance variables
	//// =======================================================================
	//// =======================================================================
	//// BEGIN Constructors
	////
	////
	//// END Constructors
	//// =======================================================================
	//// =======================================================================
	//// BEGIN Methods
	////
	/**
	 * Make string with a value as a concatenation of all the elements of the tuple.
	 * @param tuple The tuple with the elements to be concatenated.
	 * @param separator Used as separated between the concatenated elements.
	 * @return A string concatenation of the tuple elements.
	 */
	public static String concatenate(final Tuple tuple, final String separator) {
		String target = null;
		for (final Object object : tuple) {
			if (object != null) {
				if (target == null) {
					target = String.valueOf(object);
				} else {
					if (separator == null) {
						target += String.valueOf(object);
					} else {
						target += String.valueOf(separator) + String.valueOf(object);
					}
				}
			}
		}

		return target;
	}
	////
	//// END Methods
	//// =======================================================================
}
/*
Revision history:
$Log:$
*/
// Copyright (C) 2014 barakiroth.net
// All rights reserved
package net.barakiroth.oorutil.tuples;

import java.util.Random;

import org.slf4j.LoggerFactory;
import ch.qos.logback.classic.Logger;
/**
 * 
 * @param <T000> A "non-existing-element" type.
 * Just to achieve some parameter and type consistency.
 */
class Tuple000Permutator<T000>
	extends ATuplePermutator<Tuple000Permutator<Object>, Object, Tuple000<Object>, Tuple000<Object>> {
	//// =======================================================================
	//// BEGIN nested classes and enums
	////
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
	/**
	 * For logging purposes, e.g. to file.
	 */
	@SuppressWarnings("unused")
	private final static Logger logger =
		(Logger)LoggerFactory.getLogger(Tuple000Permutator.class);

	/** A singleton instance of this tuple permutator.
	 */
	private final static Tuple000Permutator<Object> SINGLETONTUPLE000PERMUTATOR =
		new Tuple000Permutator<Object>(new Object[]{null});
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
	/** Constructor, setting all the element's possible values.
	 * @param v000s The possible values of the 0. tuple element, which are just nulls. 
	 */
	private Tuple000Permutator(final T000[] v000s) {
		this(v000s, null);
	}

	/** Constructor, setting all the elements' possible values .
	 * @param v000s The possible values of the 0. tuple element.
	 * Technical "invisible" internal trick.
	 * @param random Used if the iterator is to shuffle
	 * the retrieval of the individual element values.
	 * May be <code>null</code>, if no such randomness is wanted. 
	 */
	private Tuple000Permutator(final T000[] v000s, final Random random) {
		super(Tuple000Permutator.createInstance(), v000s, random);
	}
	////
	//// END Constructors
	//// =======================================================================
	//// =======================================================================
	//// BEGIN Methods
	////
	/** Semantically creates an instance of an instance of {@link Tuple000Permutator}.
	 * Implementatorily just returns a singleton.
	 * @return Returns a singleton {@link Tuple000Permutator}.
	 */
	protected static Tuple000Permutator<Object> createInstance() {
		return SINGLETONTUPLE000PERMUTATOR;
	}

	/** {@inheritDoc}
	 */
	@Override
	protected Tuple000<Object> createTuple(final Tuple000<Object> tupleNMinusOne,
			Object tN) {
		final Tuple000<Object> tuple = Tuple000.createInstance();

		return tuple;
	}

	/** {@inheritDoc} 
	 */
	@Override
	protected int getSize() {
		return 0;
	}
	////
	//// END Methods
	//// =======================================================================
}
// Copyright (C) 2014 barakiroth.net
// All rights reserved
package net.barakiroth.oorutil.tuples;

import java.util.Random;

/** @see {@link ATuplePermutator}.
 * @param <T001> The type of the 1. element in the tuple permutations.
 */
public class Tuple001Permutator<T001>
	extends ATuplePermutator<Tuple000Permutator<Object>, T001, Tuple000<Object>, Tuple001<T001>> {
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
	/** Constructor, setting all the element's possible values .
	 * @param v001s The possible values of the 1. tuple element. 
	 */
	public Tuple001Permutator(final T001[] v001s) {
		this(v001s, null);
	}

	/** Constructor, setting all the elements' possible values .
	 * @param v001s The possible values of the 1. tuple element.
	 * @param random Used if the iterator is to shuffle
	 * the retrieval of the individual element values.
	 * May be <code>null</code>, if no such randomness is wanted. 
	 */
	public Tuple001Permutator(final T001[] v001s, final Random random) {
		super(Tuple000Permutator.createInstance(), checkEmpty(checkNull(v001s)), random);
	}
	////
	//// END Constructors
	//// =======================================================================
	//// =======================================================================
	//// BEGIN Methods
	////
	@Override
	protected Tuple001<T001> createTuple(final Tuple000<Object> tupleNMinusOne, final T001 v001) {
		final Tuple001<T001> tuple = new Tuple001<T001>(tupleNMinusOne, v001);
		return tuple;
	}
	////
	//// END Methods
	//// =======================================================================
}
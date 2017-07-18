// Copyright (C) 2014 barakiroth.net
// All rights reserved
package net.barakiroth.oorutil.tuples;

import java.util.Random;

/** @see {@link ATuplePermutator}.
 * @param <T001> The type of the 1. element in the tuple permutations.
 * @param <T002> The type of the 2. element in the tuple permutations.
 * @param <T003> The type of the 3. element in the tuple permutations.
 */
public class Tuple003Permutator<T001, T002, T003>
	extends ATuplePermutator<Tuple002Permutator<T001, T002>, T003, Tuple002<T001, T002>, Tuple003<T001, T002, T003>> {
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
	/** Constructor, setting all the elements' possible values .
	 * @param v001s The possible values of the 1. tuple element.
	 * @param v002s The possible values of the 2. tuple element.
	 * @param v003s The possible values of the 3. tuple element. 
	 */
	public Tuple003Permutator(final T001[] v001s, final T002[] v002s, final T003[] v003s) {
		this(v001s, v002s, v003s, null);
	}

	/** Constructor, setting all the elements' possible values .
	 * @param v001s The possible values of the 1. tuple element.
	 * @param v002s The possible values of the 2. tuple element.
	 * @param v003s The possible values of the 3. tuple element.
	 * @param random Used if the iterator is to shuffle
	 * the retrieval of the individual element values.
	 * May be <code>null</code>, if no such randomness is wanted. 
	 */
	public Tuple003Permutator(final T001[] v001s, final T002[] v002s, final T003[] v003s, final Random random) {
		super(new Tuple002Permutator<T001, T002>(v001s, v002s, random), checkEmpty(checkNull(v003s)), random);
	}
	////
	//// END Constructors
	//// =======================================================================
	//// =======================================================================
	//// BEGIN Methods
	////
	@Override
	protected Tuple003<T001, T002, T003> createTuple(final Tuple002<T001, T002> tupleNMinusOne, final T003 v003) {

		final Tuple003<T001, T002, T003> tuple =
				new Tuple003<T001, T002, T003>(tupleNMinusOne, v003);

		return tuple;
	}
	////
	//// END Methods
	//// =======================================================================
}
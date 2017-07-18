// Copyright (C) 2014 barakiroth.net
// All rights reserved
package net.barakiroth.oorutil.tuples;

import java.util.Random;

/** @see {@link ATuplePermutator}.
 * @param <T001> The type of the 1. element in the tuple permutations.
 * @param <T002> The type of the 2. element in the tuple permutations.
 * @param <T003> The type of the 3. element in the tuple permutations.
 * @param <T004> The type of the 4. element in the tuple permutations.
 */
public class Tuple004Permutator<T001, T002, T003, T004>
	extends ATuplePermutator<Tuple003Permutator<T001, T002, T003>, T004, Tuple003<T001, T002, T003>, Tuple004<T001, T002, T003, T004>> {
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
	 * @param v004s The possible values of the 4. tuple element. 
	 */
	public Tuple004Permutator(final T001[] v001s, final T002[] v002s, final T003[] v003s, final T004[] v004s) {
		this(v001s, v002s, v003s, v004s, null);
	}

	/** Constructor, setting all the elements' possible values .
	 * @param v001s The possible values of the 1. tuple element.
	 * @param v002s The possible values of the 2. tuple element.
	 * @param v003s The possible values of the 3. tuple element.
	 * @param v004s The possible values of the 4. tuple element.
	 * @param random Used if the iterator is to shuffle
	 * the retrieval of the individual element values.
	 * May be <code>null</code>, if no such randomness is wanted. 
	 */
	public Tuple004Permutator(final T001[] v001s, final T002[] v002s, final T003[] v003s, final T004[] v004s, final Random random) {
		super(new Tuple003Permutator<T001, T002, T003>(v001s, v002s, v003s, random), checkEmpty(checkNull(v004s)), random);
	}
	////
	//// END Constructors
	//// =======================================================================
	//// =======================================================================
	//// BEGIN Methods
	////
	@Override
	protected Tuple004<T001, T002, T003, T004> createTuple(final Tuple003<T001, T002, T003> tupleNMinusOne, final T004 v004) {

		final Tuple004<T001, T002, T003, T004> tuple =
				new Tuple004<T001, T002, T003, T004>(tupleNMinusOne, v004);

		return tuple;
	}
	////
	//// END Methods
	//// =======================================================================
}
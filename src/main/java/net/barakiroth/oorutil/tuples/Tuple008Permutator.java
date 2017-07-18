// Copyright (C) 2014 barakiroth.net
// All rights reserved
package net.barakiroth.oorutil.tuples;

import java.util.Random;

/** @see {@link ATuplePermutator}.
 * @param <T001> The type of the 1. element in the tuple permutations.
 * @param <T002> The type of the 2. element in the tuple permutations.
 * @param <T003> The type of the 3. element in the tuple permutations.
 * @param <T004> The type of the 4. element in the tuple permutations.
 * @param <T005> The type of the 5. element in the tuple permutations.
 * @param <T006> The type of the 6. element in the tuple permutations.
 * @param <T007> The type of the 7. element in the tuple permutations.
 * @param <T008> The type of the 8. element in the tuple permutations.
 */
public class Tuple008Permutator<T001, T002, T003, T004, T005, T006, T007, T008>
extends ATuplePermutator<Tuple007Permutator<T001, T002, T003, T004, T005, T006, T007>, T008, Tuple007<T001, T002, T003, T004, T005, T006, T007>, Tuple008<T001, T002, T003, T004, T005, T006, T007, T008>> {
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
	 * @param v005s The possible values of the 5. tuple element.
	 * @param v006s The possible values of the 6. tuple element.
	 * @param v007s The possible values of the 7. tuple element.
	 * @param v008s The possible values of the 8. tuple element. 
	 */
	public Tuple008Permutator(final T001[] v001s, final T002[] v002s, final T003[] v003s, final T004[] v004s, final T005[] v005s, final T006[] v006s, final T007[] v007s, final T008[] v008s) {
		this(v001s, v002s, v003s, v004s, v005s, v006s, v007s, v008s, null);
	}

	/** Constructor, setting all the elements' possible values .
	 * @param v001s The possible values of the 1. tuple element.
	 * @param v002s The possible values of the 2. tuple element.
	 * @param v003s The possible values of the 3. tuple element.
	 * @param v004s The possible values of the 4. tuple element.
	 * @param v005s The possible values of the 5. tuple element.
	 * @param v006s The possible values of the 6. tuple element.
	 * @param v007s The possible values of the 7. tuple element.
	 * @param v008s The possible values of the 8. tuple element.
	 * @param random Used if the iterator is to shuffle
	 * the retrieval of the individual element values.
	 * May be <code>null</code>, if no such randomness is wanted. 
	 */
	public Tuple008Permutator(final T001[] v001s, final T002[] v002s, final T003[] v003s, final T004[] v004s, final T005[] v005s, final T006[] v006s, final T007[] v007s, final T008[] v008s, final Random random) {
		super(new Tuple007Permutator<T001, T002, T003, T004, T005, T006, T007>(v001s, v002s, v003s, v004s, v005s, v006s, v007s, random), checkEmpty(checkNull(v008s)), random);
	}
	////
	//// END Constructors
	//// =======================================================================
	//// =======================================================================
	//// BEGIN Methods
	////
	@Override
	protected Tuple008<T001, T002, T003, T004, T005, T006, T007, T008> createTuple(final Tuple007<T001, T002, T003, T004, T005, T006, T007> tupleNMinusOne, final T008 v008) {

		final Tuple008<T001, T002, T003, T004, T005, T006, T007, T008> tuple =
				new Tuple008<T001, T002, T003, T004, T005, T006, T007, T008>(tupleNMinusOne, v008);

		return tuple;
	}
	////
	//// END Methods
	//// =======================================================================
}
// Copyright (C) 2014 barakiroth.net
// All rights reserved
package net.barakiroth.oorutil.tuples;

/**
 * A tuple with 5 elements.
 * @param <T001> The type of the 1. element in the tuple
 * @param <T002> The type of the 2. element in the tuple
 * @param <T003> The type of the 3. element in the tuple
 * @param <T004> The type of the 4. element in the tuple
 * @param <T005> The type of the 5. element in the tuple
 */
public class Tuple005<T001, T002, T003, T004, T005>
	extends ATuple<Tuple004<T001, T002, T003, T004>, T005> {
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
	/** Performance saving singleton tuple with all elements <code>null</code>.
	 */
	private static Tuple005<?, ?, ?, ?, ?> nullTuple = null;
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
	/** Constructor initializing all the elements of the tuple 
	 * with values as given by the passed parameters.
	 * @param v001 The value of the 1. element.
	 * @param v002 The value of the 2. element.
	 * @param v003 The value of the 3. element.
	 * @param v004 The value of the 4. element.
	 * @param v005 The value of the 5. element.
	 */
	public Tuple005(final T001 v001, final T002 v002, final T003 v003, final T004 v004, final T005 v005) {
		this(new Tuple004<T001, T002, T003, T004>(v001, v002, v003, v004), v005);
	}

	/** Constructor initializing all the elements of the tuple 
	 * with values as given by the passed parameters.
	 * @param tupleMinusOne The tuple minus one from which to 
	 * initialize the first 4 element values.
	 * @param v005 The value of the 5. element.
	 */
	protected Tuple005(Tuple004<T001, T002, T003, T004> tupleMinusOne, final T005 v005) {
		super(checkTupleNotNull(tupleMinusOne), v005);
	}
	////
	//// END Constructors
	//// =======================================================================
	//// =======================================================================
	//// BEGIN Methods
	////
	/**
	 * Performance saving singleton tuple with all elements <code>null</code>. 
	 * @param <T001> The type of the 1. element in the tuple
	 * @param <T002> The type of the 2. element in the tuple
	 * @param <T003> The type of the 3. element in the tuple
	 * @param <T004> The type of the 4. element in the tuple
	 * @param <T005> The type of the 5. element in the tuple
	 * @return A tuple with all elements <code>null</code>.
	 */
	@SuppressWarnings("unchecked")
	public static <T001, T002, T003, T004, T005> Tuple005<T001, T002, T003, T004, T005> nullTuple() {
		if (Tuple005.nullTuple == null) {
			Tuple005.nullTuple =
					new Tuple005<Object, Object, Object, Object, Object>(
						  (Object)null, (Object)null, (Object)null
						, (Object)null, (Object)null);
		}

		return (Tuple005<T001, T002, T003, T004, T005>)nullTuple;
	}

	/**
	 * Returns the value of the 1.element in the tuple.
	 * @return The value of the 1.element in the tuple.
	 */
	public T001 getV001() {
		return getTupleNMinusOne().getV001();
	}
	/**
	 * Returns the value of the 2.element in the tuple.
	 * @return The value of the 2.element in the tuple.
	 */
	public T002 getV002() {
		return getTupleNMinusOne().getV002();
	}
	/**
	 * Returns the value of the 3.element in the tuple.
	 * @return The value of the 3.element in the tuple.
	 */
	public T003 getV003() {
		return getTupleNMinusOne().getV003();
	}
	/**
	 * Returns the value of the 4.element in the tuple.
	 * @return The value of the 4.element in the tuple.
	 */
	public T004 getV004() {
		return getTupleNMinusOne().getV004();
	}
	/**
	 * Returns the value of the 5.element in the tuple.
	 * @return The value of the 5.element in the tuple.
	 */
	public T005 getV005() {
		return getVN();
	}
	////
	//// END Methods
	//// =======================================================================
}
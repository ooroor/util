// Copyright (C) 2014 barakiroth.net
// All rights reserved
package net.barakiroth.oorutil.tuples;

/** A tuple with 10 elements. 
 * @param <T001> The type of the 1. element in the tuple
 * @param <T002> The type of the 2. element in the tuple
 * @param <T003> The type of the 3. element in the tuple
 * @param <T004> The type of the 4. element in the tuple
 * @param <T005> The type of the 5. element in the tuple
 * @param <T006> The type of the 6. element in the tuple
 * @param <T007> The type of the 7. element in the tuple
 * @param <T008> The type of the 8. element in the tuple
 * @param <T009> The type of the 9. element in the tuple
 * @param <T010> The type of the 10. element in the tuple
 */
public class Tuple010<T001, T002, T003, T004, T005, T006, T007, T008, T009, T010>
	extends ATuple<Tuple009<T001, T002, T003, T004, T005, T006, T007, T008, T009>, T010> {
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
	private static Tuple010<?, ?, ?, ?, ?, ?, ?, ?, ?, ?> nullTuple = null;
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
	 * @param v006 The value of the 6. element.
	 * @param v007 The value of the 7. element.
	 * @param v008 The value of the 8. element.
	 * @param v009 The value of the 9. element.
	 * @param v010 The value of the 10. element.
	 */
	public Tuple010(final T001 v001, final T002 v002, final T003 v003, final T004 v004, final T005 v005, final T006 v006, final T007 v007, final T008 v008, final T009 v009, final T010 v010) {
		this(new Tuple009<T001, T002, T003, T004, T005, T006, T007, T008, T009>(v001, v002, v003, v004, v005, v006, v007, v008, v009), v010);
	}

	/** Constructor initializing all the elements of the tuple 
	 * with values as given by the passed parameters.
	 * @param tupleMinusOne The tuple minus one from which to 
	 * initialize the first 9 element values.
	 * @param v010 The value of the 10. element.
	 */
	protected Tuple010(Tuple009<T001, T002, T003, T004, T005, T006, T007, T008, T009> tupleMinusOne, final T010 v010) {
		super(checkTupleNotNull(tupleMinusOne), v010);
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
	 * @param <T006> The type of the 6. element in the tuple
	 * @param <T007> The type of the 7. element in the tuple
	 * @param <T008> The type of the 8. element in the tuple
	 * @param <T009> The type of the 9. element in the tuple
	 * @param <T010> The type of the 10. element in the tuple
	 * @return A tuple with all elements <code>null</code>.
	 */
	@SuppressWarnings("unchecked")
	public static <T001, T002, T003, T004, T005, T006, T007, T008, T009, T010> Tuple010<T001, T002, T003, T004, T005, T006, T007, T008, T009, T010> nullTuple() {
		if (Tuple010.nullTuple == null) {
			Tuple010.nullTuple =
					new Tuple010<Object, Object, Object, Object, Object
					           , Object, Object, Object, Object, Object>(
					            	  (Object)null, (Object)null, (Object)null, (Object)null, (Object)null
					            	, (Object)null, (Object)null, (Object)null, (Object)null, (Object)null);
		}

		return (Tuple010<T001, T002, T003, T004, T005, T006, T007, T008, T009, T010>)nullTuple;
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
		return getTupleNMinusOne().getV005();
	}
	/**
	 * Returns the value of the 6.element in the tuple.
	 * @return The value of the 6.element in the tuple.
	 */
	public T006 getV006() {
		return getTupleNMinusOne().getV006();
	}
	/**
	 * Returns the value of the 7.element in the tuple.
	 * @return The value of the 7.element in the tuple.
	 */
	public T007 getV007() {
		return getTupleNMinusOne().getV007();
	}
	/**
	 * Returns the value of the 8.element in the tuple.
	 * @return The value of the 8.element in the tuple.
	 */
	public T008 getV008() {
		return getTupleNMinusOne().getV008();
	}
	/**
	 * Returns the value of the 9.element in the tuple.
	 * @return The value of the 9.element in the tuple.
	 */
	public T009 getV009() {
		return getTupleNMinusOne().getV009();
	}
	/**
	 * Returns the value of the 10.element in the tuple.
	 * @return The value of the 10.element in the tuple.
	 */
	public T010 getV010() {
		return getVN();
	}
	////
	//// END Methods
	//// =======================================================================
}
// Copyright (C) 2014 barakiroth.net
// All rights reserved
package net.barakiroth.oorutil.tuples;

/**
 * A tuple with 1 element.
 * @param <T001> The type of the 1. element in the tuple
 */
public class Tuple001<T001>
	extends ATuple<Tuple000<Object>, T001> {
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
	private static Tuple001<?> nullTuple = null;
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
	/** Constructor initializing the element of the tuple 
	 * with a value as given by the passed parameter.
	 * @param v001 The value of the 1. element.
	 */
	public Tuple001(final T001 v001) {
		this(Tuple000.createInstance(), v001);
	}

	/** Constructor initializing all the elements of the tuple 
	 * with values as given by the passed parameters.
	 * @param tupleMinusOne The tuple minus one recursion stopping tuple.
	 * @param v001 The value of the 1. element.
	 */
	protected Tuple001(final Tuple000<Object> tupleMinusOne, final T001 v001) {
		super(checkTupleNotNull(tupleMinusOne), v001);
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
	 * @return A tuple with all elements <code>null</code>.
	 */
	@SuppressWarnings("unchecked")
	public static <T001> Tuple001<T001> nullTuple() {
		if (Tuple001.nullTuple == null) {
			Tuple001.nullTuple = new Tuple001<Object>((Object)null);
		}

		return (Tuple001<T001>)nullTuple;
	}

	/**
	 * Returns the value of the 1.element in the tuple.
	 * @return The value of the 1.element in the tuple.
	 */
	public T001 getV001() {
		return getVN();
	}
	////
	//// END Methods
	//// =======================================================================
}
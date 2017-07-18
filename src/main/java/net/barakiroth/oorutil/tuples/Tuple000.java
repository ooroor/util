// Copyright (C) 2014 barakiroth.net
// All rights reserved
package net.barakiroth.oorutil.tuples;

/**
 * A tuple that is used for recursion stopping reasons and design consistency.
 */
class Tuple000<T000>
	extends ATuple<Tuple000<T000>, Object> {
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
	/** The singleton instance of this tuple.
	 */
	private final static Tuple000<Object> SINGLETONTUPLE000 =
			new Tuple000<Object>(null, null);
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
	/** Constructor initializing the recursion stopping propeties of the tuple. 
	 * with values as given by the passed parameters.
	 * @param tupleNMinusOne The tuple minus one recursion stopping tuple,
	 * @param v000 The value of the "non-existing" 0. element.
	 */
	private Tuple000(final Tuple000<T000> tupleNMinusOne, final T000 v000) {
		super(tupleNMinusOne, v000);
	}
	////
	//// END Constructors
	//// =======================================================================
	//// =======================================================================
	//// BEGIN Methods
	////
	/**
	 * Creates an instance of this tuple.
	 * @return An instance of this tuple.
	 */
	protected static Tuple000<Object> createInstance() {
		return SINGLETONTUPLE000;
	}

	/** {@inheritDoc} 
	 */
	@Override
	protected int getSize() {
		return 0;
	}

	/** {@inheritDoc}
	 */
	@Override
	public boolean isNullTuple() {
		return true;
	}
	////
	//// END Methods
	//// =======================================================================
}
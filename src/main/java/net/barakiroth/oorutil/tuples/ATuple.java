// Copyright (C) 2014 barakiroth.net
// All rights reserved
package net.barakiroth.oorutil.tuples;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/** General implementation of all the n-tuples.
 * Very much based on recursion.
 * Every (n)-tuple is composed of an (n-1)-tuple and the 
 * value of the n'th element.
 * @param <TUPLENMINUSONE> The type of the preceding tuple.
 * E.g., if this represents a TUPLE006 instance,
 * the TUPLENMINUSONE type is a TUPLE005 type. 
 * @param <TN> The type of the n'th element.
 */
abstract class ATuple<TUPLENMINUSONE extends ATuple<?, ?>, TN> {
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
	/** Makes this tuple together with {@link #vN}.
	 */
	private final TUPLENMINUSONE tupleNMinusOne;

	/** Makes this tuple together with {@link #tupleNMinusOne}.
	 */
	private final TN vN;

	/** The number of elements in this tuple.
	 * Lazily set, as it is relatively expensive to 
	 * recursively calculate the size. E.g. for a 7-tuple,
	 * the size is 7.
	 */
	private int size = -1;

	/** <code>true</code> if all elements in the tuple
	 * is <code>null</code>, <code>false</code> otherwise.
	 * Lazily initialized.
	 */
	private Boolean isNullTuple;
	////
	//// END instance private variables
	//// =======================================================================
	//// END instance variables
	//// =======================================================================
	//// =======================================================================
	//// BEGIN Constructors
	////
	/** The preceding tuple and the value of this element, which together make this tuple.
	 * @param tupleNMinusOne The preceding tuple. If this is a 4-tuple, tupleNMinusOne is a 3-tuple. 
	 * @param vN The value of this element.
	 */
	@SuppressWarnings("unchecked")
	protected ATuple(final TUPLENMINUSONE tupleNMinusOne, final TN vN) {
		if (tupleNMinusOne == null) {
			this.tupleNMinusOne = (TUPLENMINUSONE)this;
		} else {
			this.tupleNMinusOne = tupleNMinusOne;
		}
		this.vN = vN;
	}
	////
	//// END Constructors
	//// =======================================================================
	//// =======================================================================
	//// BEGIN Methods
	////
	/** Used in the constructors to check that the preceding tuple is not <code>null</code>.
	 * @param <TUPLEMINUSONE> The type of the tuple of the level below.
	 * @param tuple The preceding tuple in this tuple.
	 * @return The same as the input parameter, if the value is checked OK_NOTUSINGDEF.
	 */
	protected static <TUPLEMINUSONE> TUPLEMINUSONE checkTupleNotNull(final TUPLEMINUSONE tuple) {
		
		final TUPLEMINUSONE tupleMinusOne;
		if (tuple == null) {
			throw new NullPointerException("The tuple used as tuple minus one cannot be null");
		} else {
			tupleMinusOne = tuple;
		}
		
		return tupleMinusOne;
	}
	
	/** Returns the value stored in the actual element in the tuple.
	 * @return The value stored in the actual element in the tuple.
	 */
	protected TN getVN() {
		return vN;
	}

	/** Returns the number of elements in the 
	 * tuple. Since it is rather expensive to
	 * get the size (recursively), it is cached
	 * which benefits subsequent size queries.
	 * @return The number of elements in the 
	 * tuple.
	 * E.g. the tuple [1, "Hello", true] has a size of 3. 
	 */
	protected int getSize() {

		if (this.size == -1) {
			this.size = this.tupleNMinusOne.getSize() + 1;
		}

		return this.size;
	}

	/** Returns the preceding tuple in this tuple.
	 * If this is a 5-tuple, tupleNMinusOne is a 4-tuple. 
	 * @return The preceding tuple in this tuple.
	 * If this is a 5-tuple.
	 */
	protected TUPLENMINUSONE getTupleNMinusOne() {
		return tupleNMinusOne;
	}

	/** returns <code>true</code> if all elements in the tuple are <code>null</code>.
	 * @return <code>true</code> if all elements in the tuple are <code>null</code>.
	 */
	public boolean isNullTuple() {
		if (this.isNullTuple == null) {
			this.isNullTuple = getVN() == null && getTupleNMinusOne().isNullTuple();
		}

		return this.isNullTuple;
	}

	/** {@inheritDoc}
	 */
	@Override
	public int hashCode() {

		HashCodeBuilder hashCodeBuilder =
			new HashCodeBuilder().append(this.getVN());
		final int thisSize = this.getSize();
		if (thisSize > 1) {
			hashCodeBuilder =
				hashCodeBuilder.append(this.getTupleNMinusOne());
		}

		final int hashCode = hashCodeBuilder.hashCode();

		return hashCode;
	};
	
	/** {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object other) {

		final boolean equals;
		if (!(other instanceof ATuple)) {
			equals = false;
		} else {
			@SuppressWarnings("unchecked")
			final ATuple<TUPLENMINUSONE, TN> otherTuple =
				(ATuple<TUPLENMINUSONE, TN>)other;
			final int thisSize = this.getSize();
			if (thisSize != otherTuple.getSize()) {
				equals = false;
			} else {
				EqualsBuilder equalsBuilder =
					new EqualsBuilder().append(this.getVN(), otherTuple.getVN());
				if (thisSize > 1) {
					equalsBuilder =
						equalsBuilder
							.append(this.getTupleNMinusOne(), otherTuple.getTupleNMinusOne());
				}

				equals = equalsBuilder.isEquals();
			}
		}

		return equals;  
	}

	/** {@inheritDoc}
	 */
	@Override
	public String toString() {
		final String recursive =
			(getTupleNMinusOne() instanceof Tuple000 ? "" : getTupleNMinusOne().toString()).replace("]", ", ").replace("[", "");
		final String str =
			"[" + recursive + getVN() + "]";

		return str;
	}
	////
	//// END Methods
	//// =======================================================================
}
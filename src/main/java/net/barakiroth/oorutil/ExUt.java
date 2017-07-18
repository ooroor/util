// Copyright (C) 2014 barakiroth.net
// All rights reserved
package net.barakiroth.oorutil;

public class ExUt {
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
	////
	//// END Constructors
	//// =======================================================================
	//// =======================================================================
	//// BEGIN Methods
	////
	/**
	 * Runs through all causes until a {@link Throwable}
	 * of a type as the parameter <code>clazz</code>. If no such {@link Throwable}
	 * is found, <code>null</code> is returned.
	 *
	 * @see <a href="http://stackoverflow.com/questions/3437897/how-to-get-class-instance-of-generics-type-t">how to get class instance of generics type T</a>
	 * @see <a href="http://stackoverflow.com/questions/3403909/get-generic-type-of-class-at-runtime">Get generic type of class at runtime</a>
	 *
	 * @param throwable The instance to investigate for root or 
	 * cause being of class as given by the parameter <code>clazz</code>.
	 * May well be <code>null</code>.
	 * @param clazz The class indicating what is to be looked for.
	 * May well be <code>null</code>.
	 * @param <T> Indicates the (sub)type of the {@link Throwable}
	 * to be extracted from the recursive {@link Throwable#getCause()} chain.  
	 * @return  The root or the first cause of a 
	 * type as the parameter <code>clazz</code>.
	 * If no such {@link Throwable}
	 * is found, <code>null</code> is returned.
	 */
	@SuppressWarnings("unchecked")
	public static <T extends Throwable> T extract(
			  final Throwable throwable
			, final Class<T> clazz
			) {
		Throwable cause = throwable;
		while (cause != null) {
			if (cause.getClass().equals(clazz)) {
				return (T)cause;
			}
			cause = cause.getCause();
		}
		return null;
	}
	////
	//// END Methods
	//// =======================================================================
}
/*
Revision history:
$Log:$
*/
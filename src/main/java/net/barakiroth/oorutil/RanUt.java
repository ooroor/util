// Copyright (C) 2014 barakiroth.net
// All rights reserved
package net.barakiroth.oorutil;

import java.util.PrimitiveIterator.OfInt;
import java.util.Random;
import java.util.stream.IntStream;

/**
 * Random utilities.
 */
public class RanUt {
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
	 * Generates a random string.
	 * @param length The length of the random string to be generated.
	 * @param start The lowest character to use in the string to be generated.
	 * @param stop The highest character to use in the string to be generated.
	 * @return The generated string.
	 */
	public static String randomString(final long length, final char start, final char stop) {
		final IntStream intStream =
				new Random(System.currentTimeMillis()).ints(length, (int)start, (int)stop + 1);
		final OfInt intStreamIterator = intStream.iterator();
		final StringBuffer stringBuffer = new StringBuffer();
		while (intStreamIterator.hasNext()) {
			stringBuffer.append((char)(intStreamIterator.next().intValue()));
		}
		final String randomString = stringBuffer.toString();

		return randomString;
	}
	////
	//// END Methods
	//// =======================================================================
}
/*
Revision history:
$Log:$
*/
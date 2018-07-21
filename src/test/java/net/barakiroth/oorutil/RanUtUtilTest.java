// Copyright (C) 2014 barakiroth.net
// All rights reserved
/**
 * 
 */
package net.barakiroth.oorutil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.javatuples.Triplet;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.barakiroth.oortestutil.IUnitTestCategory;
import net.barakiroth.oorutil.tuples.TupUt.TripletPermutator;

/**
 * Tests {@link RanUt}.
 */
public class RanUtUtilTest {
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
	 * @throws java.lang.Exception If something unexpected occurs.
	 */
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception If something unexpected occurs.
	 */
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception If something unexpected occurs.
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception If something unexpected occurs.
	 */
	@AfterEach
	public void tearDown() throws Exception {
	}

	// =========================================================================

	/**
	 * Test method for
	 * {@link net.barakiroth.util.RanUt#randomString(long, char, char)}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testRandomString() {
		
		final TripletPermutator<Long, Character, Character> tripletPermutator =
				new TripletPermutator<Long, Character, Character>(
						  new Long     [] {new Long(0L), new Long(1L), new Long(2L), new Long(4L), new Long(8L), new Long(97L)}
						, new Character[] {new Character('a'), new Character('b'), new Character('Z')}
						, new Character[] {new Character('W'), new Character('X'), new Character('Z')}
						);

		for(final Triplet<Long, Character, Character> triplet : tripletPermutator) {
			System.out.println("triplet: " + triplet);
			final long length    = triplet.getValue0();
			final char startChar = triplet.getValue1();
			final char endChar   = triplet.getValue2();
			try {
				final String randomString =
						RanUt.randomString(length, startChar, endChar);
				assertNotNull(randomString);
				assertEquals(length, randomString.length());
				for (int index = 0; index < randomString.length(); index++) {
					final char actualChar = randomString.charAt(index);
					assertTrue(actualChar >= startChar);
					assertTrue(actualChar <= endChar);
				}
				if (startChar > endChar) {
					fail("Expected exception not received");
				}
			} catch (AssertionError e) {
				throw e;
			} catch (IllegalArgumentException exception) {
				if (startChar <= endChar) {
					fail("Unexpected exception received");
				} // ELSE: OK_NOTUSINGDEF
			} catch (Throwable e) {
				fail("Unexpected exception received");
			}
		}
	}

	/**
	 * Test method for 
	 * {@link net.barakiroth.util.RanUt#RanUt()}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testStrUt() {
		new RanUt();
	}
	////
	//// END Methods
	//// =======================================================================
}
/*
Revision history:
$Log:$
*/
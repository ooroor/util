// Copyright (C) 2014 barakiroth.net
// All rights reserved
/**
 * 
 */
package net.barakiroth.oorutil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import net.barakiroth.oortestutil.IUnitTestCategory;

/**
 * 
 */
public class ArrUtUnitTest {
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
	 * @throws java.lang.Exception when something unexpected occurs.
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception when something unexpected occurs.
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception when something unexpected occurs.
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception when something unexpected occurs.
	 */
	@After
	public void tearDown() throws Exception {
	}

	//// =======================================================================

	/** Tests
	 * {@link ArrUt#removeDuplicates(Object[])}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testRemoveDuplicates_1() {
		final String[] strings =
				new String[]{"a", "b", "b", "c", "a", "b", "b", "b", "c"};
		final String[] actualStrings = ArrUt.removeDuplicates(strings, new String[0]);
		assertEquals(3, actualStrings.length);
		assertTrue(ArrUt.contains(actualStrings, "a"));
		assertTrue(ArrUt.contains(actualStrings, "b"));
		assertTrue(ArrUt.contains(actualStrings, "c"));
	}
	/** Tests
	 * {@link ArrUt#removeDuplicates()}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testRemoveDuplicates_2() {

		final String[] strings =
				new String[]{"a", "b", "b", "c", "a", "b", "b", "b", "c"};
		final String[] expectedStrings =
				new String[]{"a", "b", "c", };
		doTemplateBasedRemoveDuplicatesTest(strings, expectedStrings);

		final Integer[] ints         = new Integer[]{1, 2, 3, 4, 5, 6, 7, 7, 7, 7, 8, 8, 9, 9};
		final Integer[] expectedInts = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
		doTemplateBasedRemoveDuplicatesTest(ints, expectedInts);
	}

	/** Template based version of {@link #testRemoveDuplicates_2()}.
	 * @param arr The array from which to remove duplicates.
	 * @param expectedArr The expected result.
	 * @param <T> The type of the elements in the array.
	 */
	private <T> void doTemplateBasedRemoveDuplicatesTest(final T[] arr, final T[] expectedArr) {

		final T[] actualStrings = ArrUt.removeDuplicates(arr);
		assertEquals(expectedArr.length, actualStrings.length);
		for (final T elm : expectedArr) {
			assertTrue(ArrUt.contains(actualStrings, elm));
		}
	}

	/**
	 * Tests
	 * {@link ArrUt#contains(Object[], Object)}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testContains_nullParameter() {

		final String[] strings = null;
		try {
			ArrUt.contains(strings, "a");
			fail("Expected exception not received");
		} catch (AssertionError e) {
			throw e;
		} catch (NullPointerException e) {
			// OK_NOTUSINGDEF
		} catch (Throwable e) {
			fail("Erroneous exception received: " + e.getMessage());
		}
	}
	
	/**
	 * Tests
	 * {@link ArrUt#contains(Object[], Object)}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testContains_null() {
		final String[] strings = new String[] {null};
		assertTrue(ArrUt.contains(strings, null));
		assertFalse(ArrUt.contains(strings, "a"));
	}
	
	/**
	 * Tests
	 * {@link ArrUt#contains(Object[], Object)}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testContains_1() {
		final String[] strings = new String[] {};
		assertFalse(ArrUt.contains(strings, null));
		assertFalse(ArrUt.contains(strings, "a"));
	}
	
	/**
	 * Tests
	 * {@link ArrUt#contains(Object[], Object)}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testContains_2() {
		final String[] strings = new String[] {"a"};
		assertFalse(ArrUt.contains(strings, null));
		assertTrue(ArrUt.contains(strings, "a"));
		assertFalse(ArrUt.contains(strings, "b"));
	}
	
	/**
	 * Tests
	 * {@link ArrUt#contains(Object[], Object)}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testContains_3() {
		final String[] strings = new String[] {"a", "b", "c", "d", "e", "e", "e", "f"};
		assertFalse(ArrUt.contains(strings, null));
		assertTrue(ArrUt.contains(strings, "a"));
		assertTrue(ArrUt.contains(strings, "e"));
		assertTrue(ArrUt.contains(strings, "f"));
		assertFalse(ArrUt.contains(strings, "r"));
	}

	/**
	 * Tests {@link ArrUt#shuffle(Object[], java.util.Random)}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testShuffle() {
		final String[] origStrings = new String[] {"a", "b", "c", "d", "e", "f"};
		final String[] strings     = new String[] {"a", "b", "c", "d", "e", "f"};
		
		// A shuffling could actually make an identic array!
		// Testing this with a predefined and tested Random
		// asserts that at least one element has been moved.
		ArrUt.shuffle(strings, new Random(11));
		boolean atLeastOneElementIsMoved = false;
		int i = 0;
		for (final String str : origStrings) {
			if (!str.equals(strings[i++])) {
				atLeastOneElementIsMoved = true;
			}
		}
		assertTrue(atLeastOneElementIsMoved);
		
	}
	
	/**
	 * Tests the default constructor {@link ArrUt#ArrUt()} just to satisfy code coverage.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testDefaultConstructor() {
		new ArrUt();
		// Nothing to assert.
	}
	////
	//// END Methods
	//// =======================================================================
}
/*
Revision history:
$Log:$
*/
// Copyright (C) 2014 barakiroth.net
// All rights reserved
/**
 * 
 */
package net.barakiroth.oorutil.tuples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.javatuples.Decade;
import org.javatuples.Ennead;
import org.javatuples.Octet;
import org.javatuples.Pair;
import org.javatuples.Quartet;
import org.javatuples.Quintet;
import org.javatuples.Septet;
import org.javatuples.Sextet;
import org.javatuples.Triplet;
import org.javatuples.Tuple;
import org.javatuples.Unit;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.barakiroth.oortestutil.IUnitTestCategory;

/**
 * 
 */
public class TupUtUnitTest {
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
	 * {@link net.barakiroth.util.TupUt#UnitPermutator}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testUnitPermutator() {

		final Set<Unit<String>> expecteds = new HashSet<Unit<String>>();		

		for (final boolean shouldRandomize : new boolean[]{false, true}) {
			
			expecteds.add(new Unit<String>("a"));
			expecteds.add(new Unit<String>("b"));
			expecteds.add(new Unit<String>("c"));
			expecteds.add(new Unit<String>("d"));
			expecteds.add(new Unit<String>("e"));
			expecteds.add(new Unit<String>("f"));
			expecteds.add(new Unit<String>("g"));
			expecteds.add(new Unit<String>("h"));
			final int expectedsSize = expecteds.size();

			final TupUt.UnitPermutator<String> unitPermutator =
					shouldRandomize
					?
					new TupUt.UnitPermutator<String>(
						  new String [] {"a", "b", "c", "d", "e", "f", "g", "h"}
						, new Random(121)
					)
					:
					new TupUt.UnitPermutator<String>(
						new String [] {"a", "b", "c", "d", "e", "f", "g", "h"}
					);

			int cnt = 0;
			for (final Unit<String> unit : unitPermutator) {
				cnt++;
				assertTrue(expecteds.remove(unit));
			}
			assertTrue(expecteds.isEmpty());
			assertEquals(expectedsSize, cnt);
			
			final java.util.Iterator<Unit<String>> unitIterator =
					unitPermutator.iterator();
			cnt = 0;
			for (; unitIterator.hasNext(); unitIterator.next()) {
				cnt++;
			}
			assertEquals(expectedsSize, cnt);
			assertFalse(unitIterator.hasNext());
			try {
				unitIterator.next();
				fail("Expected exception received");
			} catch (AssertionError exception) {
				throw exception;
			} catch (NoSuchElementException exception) {
				// OK_NOTUSINGDEF
			} catch (Throwable exception) {
				fail("Erroneous exception received");
			}
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#UnitPermutator}
	 * using an empty set of legal values.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testUnitPermutatorWithEmptyValuesSet() {
		
		for (final boolean shouldRandomize : new boolean[]{false, true}) {
			try {
				if (shouldRandomize) {
					new TupUt.UnitPermutator<String>(
						new String [] {}
					);
				} else {
					new TupUt.UnitPermutator<String>(
							  new String [] {}
							, new Random(37)
						);
				}	
				fail("Expected exception received");
			} catch (AssertionError exception) {
				throw exception;
			} catch (IllegalArgumentException exception) {
				// OK_NOTUSINGDEF
			} catch (Throwable exception) {
				fail("Erroneous exception received");
			}
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#UnitPermutator}
	 * using <code>null</code> for a set of legal values.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testUnitPermutatorWithNullValuesSet() {

		try {
			new TupUt.UnitPermutator<String>(
						null
				);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (NullPointerException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#PairPermutator}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testPairPermutator() {

		final Set<Pair<String, Integer>> expecteds =
				new HashSet<Pair<String, Integer>>();

		for (final boolean shouldRandomize : new boolean[]{false, true}) {
			
			expecteds.add(new Pair<String, Integer>("a", 1));
			expecteds.add(new Pair<String, Integer>("a", 2));
			expecteds.add(new Pair<String, Integer>("a", 3));
			expecteds.add(new Pair<String, Integer>("b", 1));
			expecteds.add(new Pair<String, Integer>("b", 2));
			expecteds.add(new Pair<String, Integer>("b", 3));
			
			final int expectedsSize = expecteds.size(); 

			final TupUt.PairPermutator<String, Integer> pairPermutator =
				shouldRandomize
				?
				new TupUt.PairPermutator<String, Integer>(
						    new String [] {"a", "b"}
						  , new Integer[] {1, 2, 3}
						  , new Random(97)
				)
				:
				new TupUt.PairPermutator<String, Integer>(
						  new String [] {"a", "b"}
						, new Integer[] {1, 2, 3}
				);

			int cnt = 0;
			for (final Pair<String, Integer> pair : pairPermutator) {
				cnt++;
				assertTrue(expecteds.remove(pair));
			}
			assertTrue(expecteds.isEmpty());
			assertEquals(expectedsSize, cnt);
			
			final java.util.Iterator<Pair<String, Integer>> pairIterator =
					pairPermutator.iterator();
			cnt = 0;
			for (; pairIterator.hasNext(); pairIterator.next()) {
				cnt++;
			}
			assertEquals(expectedsSize, cnt);
			assertFalse(pairIterator.hasNext());
			try {
				pairIterator.next();
				fail("Expected exception received");
			} catch (AssertionError exception) {
				throw exception;
			} catch (NoSuchElementException exception) {
				// OK_NOTUSINGDEF
			} catch (Throwable exception) {
				fail("Erroneous exception received");
			}
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#PairPermutator}
	 * using an empty set of legal values.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testPairPermutatorWithEmptyValuesSet() {

		try {
			new TupUt.PairPermutator<String, Integer>(
							  new String [] {"a", "b"}
							, new Integer[] {}
					);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (IllegalArgumentException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#PairPermutator}
	 * using <code>null</code> for a set of legal values.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testPairPermutatorWithNullValuesSet() {

		try {
			new TupUt.PairPermutator<String, Integer>(
							  new String [] {"a", "b"}
							, null
					);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (NullPointerException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#TripletPermutator}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testTripletPermutator() {

		final Set<Triplet<String, Integer, Boolean>> expecteds =
				new HashSet<Triplet<String, Integer, Boolean>>();
		
		for (final boolean shouldRandomize : new boolean[]{false, true}) {
			
			expecteds.add(new Triplet<String, Integer, Boolean>("a", 1, true));
			expecteds.add(new Triplet<String, Integer, Boolean>("a", 1, null));
			expecteds.add(new Triplet<String, Integer, Boolean>("a", 1, false));
			expecteds.add(new Triplet<String, Integer, Boolean>("a", 2, true));
			expecteds.add(new Triplet<String, Integer, Boolean>("a", 2, null));
			expecteds.add(new Triplet<String, Integer, Boolean>("a", 2, false));
			expecteds.add(new Triplet<String, Integer, Boolean>("a", 3, true));
			expecteds.add(new Triplet<String, Integer, Boolean>("a", 3, null));
			expecteds.add(new Triplet<String, Integer, Boolean>("a", 3, false));
			expecteds.add(new Triplet<String, Integer, Boolean>("b", 1, true));
			expecteds.add(new Triplet<String, Integer, Boolean>("b", 1, null));
			expecteds.add(new Triplet<String, Integer, Boolean>("b", 1, false));
			expecteds.add(new Triplet<String, Integer, Boolean>("b", 2, true));
			expecteds.add(new Triplet<String, Integer, Boolean>("b", 2, null));
			expecteds.add(new Triplet<String, Integer, Boolean>("b", 2, false));
			expecteds.add(new Triplet<String, Integer, Boolean>("b", 3, true));
			expecteds.add(new Triplet<String, Integer, Boolean>("b", 3, null));
			expecteds.add(new Triplet<String, Integer, Boolean>("b", 3, false));
			
			final int expectedsSize = expecteds.size(); 

			final TupUt.TripletPermutator<String, Integer, Boolean> tripletPermutator =
					shouldRandomize
					?
					new TupUt.TripletPermutator<String, Integer, Boolean>(
							  new String [] {"a", "b"}
							, new Integer[] {1, 2, 3}
							, new Boolean[] {true, null, false}
							, new Random(7)
					)
					:
					new TupUt.TripletPermutator<String, Integer, Boolean>(
							  new String [] {"a", "b"}
							, new Integer[] {1, 2, 3}
							, new Boolean[] {true, null, false}
					);

			int cnt = 0;
			for (final Triplet<String, Integer, Boolean> triplet : tripletPermutator) {
				cnt++;
				assertTrue(expecteds.remove(triplet));
			}
			assertTrue(expecteds.isEmpty());
			assertEquals(expectedsSize, cnt);
			
			final java.util.Iterator<Triplet<String, Integer, Boolean>> tripletIterator =
					tripletPermutator.iterator();
			cnt = 0;
			for (; tripletIterator.hasNext(); tripletIterator.next()) {
				cnt++;
			}
			assertEquals(expectedsSize, cnt);
			assertFalse(tripletIterator.hasNext());
			try {
				tripletIterator.next();
				fail("Expected exception received");
			} catch (AssertionError exception) {
				throw exception;
			} catch (NoSuchElementException exception) {
				// OK_NOTUSINGDEF
			} catch (Throwable exception) {
				fail("Erroneous exception received");
			}
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#TripletPermutator}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testTripletPermutatorWithDecreasinValueCount() {

		final Set<Triplet<String, Integer, Boolean>> expecteds =
				new HashSet<Triplet<String, Integer, Boolean>>();
		
		for (final boolean shouldRandomize : new boolean[]{false, true}) {

			expecteds.add(new Triplet<String, Integer, Boolean>("a", 1, true));
			expecteds.add(new Triplet<String, Integer, Boolean>("a", 1, false));
			expecteds.add(new Triplet<String, Integer, Boolean>("a", 2, true));
			expecteds.add(new Triplet<String, Integer, Boolean>("a", 2, false));

			expecteds.add(new Triplet<String, Integer, Boolean>("b", 1, true));
			expecteds.add(new Triplet<String, Integer, Boolean>("b", 1, false));
			expecteds.add(new Triplet<String, Integer, Boolean>("b", 2, true));
			expecteds.add(new Triplet<String, Integer, Boolean>("b", 2, false));

			expecteds.add(new Triplet<String, Integer, Boolean>("c", 1, true));
			expecteds.add(new Triplet<String, Integer, Boolean>("c", 1, false));
			expecteds.add(new Triplet<String, Integer, Boolean>("c", 2, true));
			expecteds.add(new Triplet<String, Integer, Boolean>("c", 2, false));
			
			final int expectedsSize = expecteds.size(); 

			final TupUt.TripletPermutator<String, Integer, Boolean> tripletPermutator =
					shouldRandomize
					?
					new TupUt.TripletPermutator<String, Integer, Boolean>(
							  new String [] {"a", "b", "c"}
							, new Integer[] {1, 2}
							, new Boolean[] {true, false}
							, new Random(7)
					)
					:
					new TupUt.TripletPermutator<String, Integer, Boolean>(
							  new String [] {"a", "b", "c"}
							, new Integer[] {1, 2}
							, new Boolean[] {true, false}
					);

			int cnt = 0;
			for (final Triplet<String, Integer, Boolean> triplet : tripletPermutator) {
				cnt++;
				assertTrue(expecteds.remove(triplet));
			}
			assertTrue(expecteds.isEmpty());
			assertEquals(expectedsSize, cnt);
			
			final java.util.Iterator<Triplet<String, Integer, Boolean>> tripletIterator =
					tripletPermutator.iterator();
			cnt = 0;
			for (; tripletIterator.hasNext(); tripletIterator.next()) {
				cnt++;
			}
			assertEquals(expectedsSize, cnt);
			assertFalse(tripletIterator.hasNext());
			try {
				tripletIterator.next();
				fail("Expected exception received");
			} catch (AssertionError exception) {
				throw exception;
			} catch (NoSuchElementException exception) {
				// OK_NOTUSINGDEF
			} catch (Throwable exception) {
				fail("Erroneous exception received");
			}
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#TripletPermutator}
	 * using an empty set of legal values.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testTripletPermutatorWithEmptyValuesSet() {

		try {
			new TupUt.TripletPermutator<String, Integer, Boolean>(
							  new String [] {"a", "b"}
							, new Integer[] {1, 2, 3}
							, new Boolean[] {}
					);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (IllegalArgumentException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#TripletPermutator}
	 * using <code>null</code> for a set of legal values.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testTripletPermutatorWithNullValuesSet() {

		try {
			new TupUt.TripletPermutator<String, Integer, Boolean>(
							  new String [] {"a", "b"}
							, new Integer[] {1, 2, 3}
							, null
					);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (NullPointerException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	// =========================================================================

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#TripletPermutator}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testQuartetPermutator() {

		final Set<Quartet<String, Integer, Boolean, Double>> expecteds =
				new HashSet<Quartet<String, Integer, Boolean, Double>>();
		
		for (final boolean shouldRandomize : new boolean[]{false, true}) {
			
			expecteds.add(new Quartet<String, Integer, Boolean, Double>("a", 1, true, 1.2));
			expecteds.add(new Quartet<String, Integer, Boolean, Double>("a", 1, true, 3.4));
			expecteds.add(new Quartet<String, Integer, Boolean, Double>("a", 1, false, 1.2));
			expecteds.add(new Quartet<String, Integer, Boolean, Double>("a", 1, false, 3.4));
			
			expecteds.add(new Quartet<String, Integer, Boolean, Double>("a", 2, true, 1.2));
			expecteds.add(new Quartet<String, Integer, Boolean, Double>("a", 2, true, 3.4));
			expecteds.add(new Quartet<String, Integer, Boolean, Double>("a", 2, false, 1.2));
			expecteds.add(new Quartet<String, Integer, Boolean, Double>("a", 2, false, 3.4));

			expecteds.add(new Quartet<String, Integer, Boolean, Double>("b", 1, true, 1.2));
			expecteds.add(new Quartet<String, Integer, Boolean, Double>("b", 1, true, 3.4));
			expecteds.add(new Quartet<String, Integer, Boolean, Double>("b", 1, false, 1.2));
			expecteds.add(new Quartet<String, Integer, Boolean, Double>("b", 1, false, 3.4));
			
			expecteds.add(new Quartet<String, Integer, Boolean, Double>("b", 2, true, 1.2));
			expecteds.add(new Quartet<String, Integer, Boolean, Double>("b", 2, true, 3.4));
			expecteds.add(new Quartet<String, Integer, Boolean, Double>("b", 2, false, 1.2));
			expecteds.add(new Quartet<String, Integer, Boolean, Double>("b", 2, false, 3.4));
			
			final int expectedsSize = expecteds.size();

			final TupUt.QuartetPermutator<String, Integer, Boolean, Double> quartetPermutator =
					shouldRandomize
					?
					new TupUt.QuartetPermutator<String, Integer, Boolean, Double>(
							  new String [] {"a", "b"}
							, new Integer[] {1, 2}
							, new Boolean[] {true, false}
							, new Double[] {1.2, 3.4}
							, new Random(11)
					)
					:	
					new TupUt.QuartetPermutator<String, Integer, Boolean, Double>(
							  new String [] {"a", "b"}
							, new Integer[] {1, 2}
							, new Boolean[] {true, false}
							, new Double[] {1.2, 3.4}
					);

			int cnt = 0;
			for (final Quartet<String, Integer, Boolean, Double> quartet : quartetPermutator) {
				cnt++;
				assertTrue(expecteds.remove(quartet));
			}
			assertTrue(expecteds.isEmpty());
			assertEquals(expectedsSize, cnt);
			
			final java.util.Iterator<Quartet<String, Integer, Boolean, Double>> quartetIterator =
					quartetPermutator.iterator();
			cnt = 0;
			for (; quartetIterator.hasNext(); quartetIterator.next()) {
				cnt++;
			}
			assertEquals(expectedsSize, cnt);
			assertFalse(quartetIterator.hasNext());
			try {
				quartetIterator.next();
				fail("Expected exception received");
			} catch (AssertionError exception) {
				throw exception;
			} catch (NoSuchElementException exception) {
				// OK_NOTUSINGDEF
			} catch (Throwable exception) {
				fail("Erroneous exception received");
			}
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#QuartetPermutator}
	 * using an empty set of legal values.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testQuartetPermutatorWithEmptyValuesSet() {

		try {
			new TupUt.QuartetPermutator<String, Integer, Boolean, Double>(
							  new String [] {"a", "b"}
							, new Integer[] {1, 2}
							, new Boolean[] {true, false}
							, new Double[] {}
					);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (IllegalArgumentException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#QuartetPermutator}
	 * using an empty set of legal values for A.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testQuartetPermutatorWithEmptyValuesSetForA() {

		try {
			new TupUt.QuartetPermutator<String, Integer, Boolean, Double>(
							  new String [] {}
							, new Integer[] {1, 2}
							, new Boolean[] {true, false}
							, new Double[] {1.2}
					);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (IllegalArgumentException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#QuartetPermutator}
	 * using an empty set of legal values for B.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testQuartetPermutatorWithEmptyValuesSetForB() {

		try {
			new TupUt.QuartetPermutator<String, Integer, Boolean, Double>(
							  new String [] {"nm", "lkjklj"}
							, new Integer[] {}
							, new Boolean[] {true, false}
							, new Double[] {1.2}
					);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (IllegalArgumentException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#QuartetPermutator}
	 * using an empty set of legal values for C.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testQuartetPermutatorWithEmptyValuesSetForC() {

		try {
			new TupUt.QuartetPermutator<String, Integer, Boolean, Double>(
							  new String [] {"nm", "lkjklj"}
							, new Integer[] {1, 2, 3}
							, new Boolean[] {}
							, new Double[] {1.2}
					);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (IllegalArgumentException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#QuartetPermutator}
	 * using <code>null</code> for a set of legal values.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testQuartetPermutatorWithNullValuesSet() {

		try {
			new TupUt.QuartetPermutator<String, Integer, Boolean, Double>(
							  new String [] {"a", "b"}
							, new Integer[] {1, 2}
							, new Boolean[] {true, false}
							, null
					);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (NullPointerException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#QuartetPermutator}
	 * using <code>null</code> for legal of A.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testQuartetPermutatorWithNullValuesSetForA() {

		try {
			new TupUt.QuartetPermutator<String, Integer, Boolean, Double>(
							  null
							, new Integer[] {1, 2}
							, new Boolean[] {true, false}
							, new Double[] {1.2}
					);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (NullPointerException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#QuartetPermutator}
	 * using <code>null</code> for legal of B.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testQuartetPermutatorWithNullValuesSetForB() {

		try {
			new TupUt.QuartetPermutator<String, Integer, Boolean, Double>(
							  new String [] {"a", "b"}
							, null
							, new Boolean[] {true, false}
							, new Double[] {1.2}
					);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (NullPointerException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#QuartetPermutator}
	 * using <code>null</code> for legal of C.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testQuartetPermutatorWithNullValuesSetForC() {

		try {
			new TupUt.QuartetPermutator<String, Integer, Boolean, Double>(
							  new String [] {"a", "b"}
							, new Integer[] {1, 2}
							, null
							, new Double[] {1.2}
					);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (NullPointerException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	// =========================================================================

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#QuintetPermutator}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testQuintetPermutator() {

		final Set<Quintet<String, Integer, Boolean, Double, String>> expecteds =
				new HashSet<Quintet<String, Integer, Boolean, Double, String>>();
		
		for (final boolean shouldRandomize : new boolean[]{false, true}) {
			
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("a", 1, true, 1.2, "1"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("a", 1, true, 3.4, "1"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("a", 1, false, 1.2, "1"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("a", 1, false, 3.4, "1"));
			
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("a", 2, true, 1.2, "1"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("a", 2, true, 3.4, "1"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("a", 2, false, 1.2, "1"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("a", 2, false, 3.4, "1"));

			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("b", 1, true, 1.2, "1"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("b", 1, true, 3.4, "1"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("b", 1, false, 1.2, "1"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("b", 1, false, 3.4, "1"));
			
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("b", 2, true, 1.2, "1"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("b", 2, true, 3.4, "1"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("b", 2, false, 1.2, "1"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("b", 2, false, 3.4, "1"));


			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("a", 1, true, 1.2, "2"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("a", 1, true, 3.4, "2"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("a", 1, false, 1.2, "2"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("a", 1, false, 3.4, "2"));
			
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("a", 2, true, 1.2, "2"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("a", 2, true, 3.4, "2"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("a", 2, false, 1.2, "2"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("a", 2, false, 3.4, "2"));

			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("b", 1, true, 1.2, "2"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("b", 1, true, 3.4, "2"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("b", 1, false, 1.2, "2"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("b", 1, false, 3.4, "2"));
			
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("b", 2, true, 1.2, "2"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("b", 2, true, 3.4, "2"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("b", 2, false, 1.2, "2"));
			expecteds.add(new Quintet<String, Integer, Boolean, Double, String>("b", 2, false, 3.4, "2"));		
			final int expectedsSize = expecteds.size();

			final TupUt.QuintetPermutator<String, Integer, Boolean, Double, String> quintetPermutator =
					shouldRandomize
					?
					new TupUt.QuintetPermutator<String, Integer, Boolean, Double, String>(
							  new String [] {"a", "b"}
							, new Integer[] {1, 2}
							, new Boolean[] {true, false}
							, new Double[] {1.2, 3.4}
							, new String[] {"1", "2"}
							, new Random(41)
					)
					:
					new TupUt.QuintetPermutator<String, Integer, Boolean, Double, String>(
							  new String [] {"a", "b"}
							, new Integer[] {1, 2}
							, new Boolean[] {true, false}
							, new Double[] {1.2, 3.4}
							, new String[] {"1", "2"}
					);

			int cnt = 0;
			for (final Quintet<String, Integer, Boolean, Double, String> quintet : quintetPermutator) {
				cnt++;
				assertTrue(expecteds.remove(quintet));
			}
			assertTrue(expecteds.isEmpty());
			assertEquals(expectedsSize, cnt);
			
			final java.util.Iterator<Quintet<String, Integer, Boolean, Double, String>> quintetIterator =
					quintetPermutator.iterator();
			cnt = 0;
			for (; quintetIterator.hasNext(); quintetIterator.next()) {
				cnt++;
			}
			assertEquals(expectedsSize, cnt);
			assertFalse(quintetIterator.hasNext());
			try {
				quintetIterator.next();
				fail("Expected exception received");
			} catch (AssertionError exception) {
				throw exception;
			} catch (NoSuchElementException exception) {
				// OK_NOTUSINGDEF
			} catch (Throwable exception) {
				fail("Erroneous exception received");
			}
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#QuintetPermutator}
	 * using an empty set of legal values.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testQuintetPermutatorWithEmptyValuesSet() {

		try {
			new TupUt.QuintetPermutator<String, Integer, Boolean, Double, String>(
							  new String [] {"a", "b"}
							, new Integer[] {1, 2}
							, new Boolean[] {true, false}
							, new Double[] {1.2, 3.4}
							, new String[] {}
					);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (IllegalArgumentException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#QuintetPermutator}
	 * using an empty set of legal values for A.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testQuintetPermutatorWithEmptyValuesSetForA() {

		try {
			new TupUt.QuintetPermutator<String, Integer, Boolean, Double, String>(
							  new String [] {}
							, new Integer[] {1, 2, 3, 4, 5}
							, new Boolean[] {true, false}
							, new Double[] {1.2, 3.4}
							, new String[] {"1", "2"}
					);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (IllegalArgumentException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#QuintetPermutator}
	 * using an empty set of legal values for B.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testQuintetPermutatorWithEmptyValuesSetForB() {

		try {
			new TupUt.QuintetPermutator<String, Integer, Boolean, Double, String>(
							  new String [] {"nm", "lkjklj"}
							, new Integer[] {}
							, new Boolean[] {true, false}
							, new Double[] {1.2}
							, new String[] {"1", "2"}
					);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (IllegalArgumentException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#QuintetPermutator}
	 * using an empty set of legal values for C.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testQuintetPermutatorWithEmptyValuesSetForC() {

		try {
			new TupUt.QuintetPermutator<String, Integer, Boolean, Double, String>(
							  new String [] {"nm", "lkjklj"}
							, new Integer[] {1, 2, 3}
							, new Boolean[] {}
							, new Double[] {1.2}
							, new String[] {"1", "2"}
					);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (IllegalArgumentException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#QuintetPermutator}
	 * using <code>null</code> for a set of legal values.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testQuintetPermutatorWithNullValuesSet() {

		try {
			new TupUt.QuintetPermutator<String, Integer, Boolean, Double, String>(
							  null
							, new Integer[] {1, 2, 3}
							, new Boolean[] {true, false}
							, new Double[] {1.2}
							, new String[] {"1", "2"}
					);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (NullPointerException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#QuintetPermutator}
	 * using <code>null</code> for legal of A.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testQuintetPermutatorWithNullValuesSetForA() {

		try {
			new TupUt.QuintetPermutator<String, Integer, Boolean, Double, String>(
							  null
							, new Integer[] {1, 2}
							, new Boolean[] {true, false}
							, new Double[] {1.2}
								, new String[] {"1", "2"}
					);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (NullPointerException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#QuintetPermutator}
	 * using <code>null</code> for legal of B.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testQuintetPermutatorWithNullValuesSetForB() {

		try {
			new TupUt.QuintetPermutator<String, Integer, Boolean, Double, String>(
							  new String [] {"a", "b"}
							, null
							, new Boolean[] {true, false}
							, new Double[] {1.2}
							, new String[] {"1", "2"}
					);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (NullPointerException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#QuintetPermutator}
	 * using <code>null</code> for legal of C.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testQuintetPermutatorWithNullValuesSetForC() {

		try {
			new TupUt.QuintetPermutator<String, Integer, Boolean, Double, String>(
							  new String [] {"a", "b"}
							, new Integer[] {1, 2}
							, null
							, new Double[] {1.2}
							, new String[] {"1", "2"}
					);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (NullPointerException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#QuintetPermutator}
	 * using <code>null</code> for legal of D.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testQuintetPermutatorWithNullValuesSetForD() {

		try {
			new TupUt.QuintetPermutator<String, Integer, Boolean, Double, String>(
							  new String [] {"a", "b"}
							, new Integer[] {1, 2}
							, new Boolean[] {true, false}
							, null
							, new String[] {"1", "2"}
					);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (NullPointerException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#QuintetPermutator}
	 * using <code>null</code> for legal of E.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testQuintetPermutatorWithNullValuesSetForE() {

		try {
			new TupUt.QuintetPermutator<String, Integer, Boolean, Double, String>(
							  new String [] {"a", "b"}
							, new Integer[] {1, 2}
							, new Boolean[] {true, false}
							, new Double[] {1.2}
							, null
					);
			fail("Expected exception received");
		} catch (AssertionError exception) {
			throw exception;
		} catch (NullPointerException exception) {
			// OK_NOTUSINGDEF
		} catch (Throwable exception) {
			fail("Erroneous exception received");
		}
	}

	/**
	 * Tests the private method {@link net.barakiroth.util.Void#getSize()}.
	 *
	 * @throws NoSuchMethodException If something goes wrong in the reflection.
	 * @throws SecurityException If something goes wrong in the reflection.
	 * @throws InstantiationException If something goes wrong in the reflection.
	 * @throws IllegalAccessException If something goes wrong in the reflection.
	 * @throws IllegalArgumentException If something goes wrong in the reflection.
	 * @throws InvocationTargetException If something goes wrong in the reflection.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testVoid() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		final Object voidOfString = constructTupUtVoidOfString();
		assertNotNull(voidOfString);
		final Method getSize = voidOfString.getClass().getMethod("getSize", new Class<?>[]{});
		final int size = (int) getSize.invoke(voidOfString, new Object[]{});
		assertEquals(0, size);
	}

	/**
	 * Tests the private method {@link net.barakiroth.util.VoidPermutator#add()}.
	 *
	 * @throws NoSuchMethodException If something goes wrong in the reflection.
	 * @throws SecurityException If something goes wrong in the reflection.
	 * @throws InstantiationException If something goes wrong in the reflection.
	 * @throws IllegalAccessException If something goes wrong in the reflection.
	 * @throws IllegalArgumentException If something goes wrong in the reflection.
	 * @throws InvocationTargetException If something goes wrong in the reflection.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testVoidPermutator() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		final Class<?>[] classes = TupUt.class.getDeclaredClasses();
		boolean found = false;
		for (final Class<?> clazz : classes) {
			/* TupUt.VoidPermutator */
			if (clazz.getName().endsWith("VoidPermutator")) {
				final Constructor<?> constructor =
						clazz.getDeclaredConstructor(new Class<?>[]{});
				constructor.setAccessible(true);
				final Object clazzInstance =
						constructor.newInstance(new Object[]{});
				
				final Method add = clazzInstance.getClass().getMethod("add", new Class<?>[]{Tuple.class, Object.class});
				
				final Object voidOfString = constructTupUtVoidOfString();
				final Object voidObject = add.invoke(clazzInstance, new Object[]{voidOfString, "Hello world!"});
				assertNull(voidObject);
				found = true;
				break;
			}
		}
		assertTrue(found);
	}

	// =========================================================================

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt.SextetPermutator}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testSextetPermutator() {

		final Set<Sextet<String, Integer, Boolean, Double, String, Integer>> expecteds =
				new HashSet<Sextet<String, Integer, Boolean, Double, String, Integer>>();
		
		for (final boolean shouldRandomize : new boolean[]{false, true}) {

			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 1, true, 1.2, "1" , 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 1, true, 3.4, "1" , 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 1, false, 1.2, "1", 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 1, false, 3.4, "1", 13));
			
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 2, true, 1.2, "1" , 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 2, true, 3.4, "1" , 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 2, false, 1.2, "1", 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 2, false, 3.4, "1", 13));

			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 1, true, 1.2, "1" , 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 1, true, 3.4, "1" , 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 1, false, 1.2, "1", 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 1, false, 3.4, "1", 13));
			
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 2, true, 1.2, "1" , 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 2, true, 3.4, "1" , 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 2, false, 1.2, "1", 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 2, false, 3.4, "1", 13));


			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 1, true, 1.2, "2" , 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 1, true, 3.4, "2" , 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 1, false, 1.2, "2", 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 1, false, 3.4, "2", 13));
			
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 2, true, 1.2, "2" , 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 2, true, 3.4, "2" , 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 2, false, 1.2, "2", 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 2, false, 3.4, "2", 13));

			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 1, true, 1.2, "2" , 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 1, true, 3.4, "2" , 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 1, false, 1.2, "2", 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 1, false, 3.4, "2", 13));
			
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 2, true, 1.2, "2" , 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 2, true, 3.4, "2" , 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 2, false, 1.2, "2", 13));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 2, false, 3.4, "2", 13));

			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 1, true, 1.2, "1" , 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 1, true, 3.4, "1" , 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 1, false, 1.2, "1", 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 1, false, 3.4, "1", 17));

			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 2, true, 1.2, "1" , 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 2, true, 3.4, "1" , 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 2, false, 1.2, "1", 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 2, false, 3.4, "1", 17));

			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 1, true, 1.2, "1" , 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 1, true, 3.4, "1" , 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 1, false, 1.2, "1", 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 1, false, 3.4, "1", 17));

			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 2, true, 1.2, "1" , 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 2, true, 3.4, "1" , 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 2, false, 1.2, "1", 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 2, false, 3.4, "1", 17));


			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 1, true, 1.2, "2" , 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 1, true, 3.4, "2" , 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 1, false, 1.2, "2", 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 1, false, 3.4, "2", 17));

			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 2, true, 1.2, "2" , 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 2, true, 3.4, "2" , 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 2, false, 1.2, "2", 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("a", 2, false, 3.4, "2", 17));

			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 1, true, 1.2, "2" , 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 1, true, 3.4, "2" , 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 1, false, 1.2, "2", 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 1, false, 3.4, "2", 17));

			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 2, true, 1.2, "2" , 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 2, true, 3.4, "2" , 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 2, false, 1.2, "2", 17));
			expecteds.add(new Sextet<String, Integer, Boolean, Double, String, Integer>("b", 2, false, 3.4, "2", 17));		
			final int expectedsSize = expecteds.size();

			final TupUt.SextetPermutator<String, Integer, Boolean, Double, String, Integer> sextetPermutator =
					shouldRandomize
					?
					new TupUt.SextetPermutator<String, Integer, Boolean, Double, String, Integer>(
							  new String [] {"a", "b"}
							, new Integer[] {1, 2}
							, new Boolean[] {true, false}
							, new Double[] {1.2, 3.4}
							, new String[] {"1", "2"}
							, new Integer[] {13, 17}
							, new Random(41)
					)
					:
					new TupUt.SextetPermutator<String, Integer, Boolean, Double, String, Integer>(
							  new String [] {"a", "b"}
							, new Integer[] {1, 2}
							, new Boolean[] {true, false}
							, new Double[] {1.2, 3.4}
							, new String[] {"1", "2"}
							, new Integer[] {13, 17}
					);

			int cnt = 0;
			for (final Sextet<String, Integer, Boolean, Double, String, Integer> sextet : sextetPermutator) {
				cnt++;
				assertTrue(expecteds.remove(sextet));
			}
			assertTrue(expecteds.isEmpty());
			assertEquals(expectedsSize, cnt);
			
			final java.util.Iterator<Sextet<String, Integer, Boolean, Double, String, Integer>> sextetIterator =
					sextetPermutator.iterator();
			cnt = 0;
			for (; sextetIterator.hasNext(); sextetIterator.next()) {
				cnt++;
			}
			assertEquals(expectedsSize, cnt);
			assertFalse(sextetIterator.hasNext());
			try {
				sextetIterator.next();
				fail("Expected exception received");
			} catch (AssertionError exception) {
				throw exception;
			} catch (NoSuchElementException exception) {
				// OK_NOTUSINGDEF
			} catch (Throwable exception) {
				fail("Erroneous exception received");
			}
		}
	}

	// =========================================================================

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt.SeptetPermutator}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testSeptetPermutator() {

		final Set<Septet<String, Integer, Boolean, Double, String, Integer, String>> expecteds =
				new HashSet<Septet<String, Integer, Boolean, Double, String, Integer, String>>();
		
		for (final boolean shouldRandomize : new boolean[]{false, true}) {

			expecteds.add(new Septet<String, Integer, Boolean, Double, String, Integer, String>("a", 1, true, 3.4, "1" , 13, "x"));
			expecteds.add(new Septet<String, Integer, Boolean, Double, String, Integer, String>("a", 1, true, 3.4, "2" , 13, "x"));
			expecteds.add(new Septet<String, Integer, Boolean, Double, String, Integer, String>("a", 1, true, 3.4, "1" , 17, "x"));
			expecteds.add(new Septet<String, Integer, Boolean, Double, String, Integer, String>("a", 1, true, 3.4, "2" , 17, "x"));
			expecteds.add(new Septet<String, Integer, Boolean, Double, String, Integer, String>("a", 1, true, 3.4, "1" , 13, "y"));
			expecteds.add(new Septet<String, Integer, Boolean, Double, String, Integer, String>("a", 1, true, 3.4, "2" , 13, "y"));
			expecteds.add(new Septet<String, Integer, Boolean, Double, String, Integer, String>("a", 1, true, 3.4, "1" , 17, "y"));
			expecteds.add(new Septet<String, Integer, Boolean, Double, String, Integer, String>("a", 1, true, 3.4, "2" , 17, "y"));

			final int expectedsSize = expecteds.size();

			final TupUt.SeptetPermutator<String, Integer, Boolean, Double, String, Integer, String> septetPermutator =
					shouldRandomize
					?
					new TupUt.SeptetPermutator<String, Integer, Boolean, Double, String, Integer, String>(
							  new String [] {"a"}
							, new Integer[] {1}
							, new Boolean[] {true}
							, new Double[] {3.4}
							, new String[] {"1", "2"}
							, new Integer[] {13, 17}
							, new String[] {"x", "y"}
							, new Random(41)
					)
					:
					new TupUt.SeptetPermutator<String, Integer, Boolean, Double, String, Integer, String>(
							  new String [] {"a"}
							, new Integer[] {1}
							, new Boolean[] {true}
							, new Double[] {3.4}
							, new String[] {"1", "2"}
							, new Integer[] {13, 17}
							, new String[] {"x", "y"}
					);

			int cnt = 0;
			for (final Septet<String, Integer, Boolean, Double, String, Integer, String> septet : septetPermutator) {
				cnt++;
				assertTrue(expecteds.remove(septet));
			}
			assertTrue(expecteds.isEmpty());
			assertEquals(expectedsSize, cnt);
			
			final java.util.Iterator<Septet<String, Integer, Boolean, Double, String, Integer, String>> septetIterator =
					septetPermutator.iterator();
			cnt = 0;
			for (; septetIterator.hasNext(); septetIterator.next()) {
				cnt++;
			}
			assertEquals(expectedsSize, cnt);
			assertFalse(septetIterator.hasNext());
			try {
				septetIterator.next();
				fail("Expected exception received");
			} catch (AssertionError exception) {
				throw exception;
			} catch (NoSuchElementException exception) {
				// OK_NOTUSINGDEF
			} catch (Throwable exception) {
				fail("Erroneous exception received");
			}
		}
	}

	// =========================================================================

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt.OctetPermutator}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testOctetPermutator() {

		final Set<Octet<String, Integer, Boolean, Double, String, Integer, String, Boolean>> expecteds =
				new HashSet<Octet<String, Integer, Boolean, Double, String, Integer, String, Boolean>>();
		
		for (final boolean shouldRandomize : new boolean[]{false, true}) {

			expecteds.add(new Octet<String, Integer, Boolean, Double, String, Integer, String, Boolean>("a", 1, true, 3.4, "1" , 13, "x", true));
			expecteds.add(new Octet<String, Integer, Boolean, Double, String, Integer, String, Boolean>("a", 1, true, 3.4, "2" , 13, "x", true));
			expecteds.add(new Octet<String, Integer, Boolean, Double, String, Integer, String, Boolean>("a", 1, true, 3.4, "1" , 17, "x", true));
			expecteds.add(new Octet<String, Integer, Boolean, Double, String, Integer, String, Boolean>("a", 1, true, 3.4, "2" , 17, "x", true));
			expecteds.add(new Octet<String, Integer, Boolean, Double, String, Integer, String, Boolean>("a", 1, true, 3.4, "1" , 13, "y", true));
			expecteds.add(new Octet<String, Integer, Boolean, Double, String, Integer, String, Boolean>("a", 1, true, 3.4, "2" , 13, "y", true));
			expecteds.add(new Octet<String, Integer, Boolean, Double, String, Integer, String, Boolean>("a", 1, true, 3.4, "1" , 17, "y", true));
			expecteds.add(new Octet<String, Integer, Boolean, Double, String, Integer, String, Boolean>("a", 1, true, 3.4, "2" , 17, "y", true));

			expecteds.add(new Octet<String, Integer, Boolean, Double, String, Integer, String, Boolean>("a", 1, true, 3.4, "1" , 13, "x", false));
			expecteds.add(new Octet<String, Integer, Boolean, Double, String, Integer, String, Boolean>("a", 1, true, 3.4, "2" , 13, "x", false));
			expecteds.add(new Octet<String, Integer, Boolean, Double, String, Integer, String, Boolean>("a", 1, true, 3.4, "1" , 17, "x", false));
			expecteds.add(new Octet<String, Integer, Boolean, Double, String, Integer, String, Boolean>("a", 1, true, 3.4, "2" , 17, "x", false));
			expecteds.add(new Octet<String, Integer, Boolean, Double, String, Integer, String, Boolean>("a", 1, true, 3.4, "1" , 13, "y", false));
			expecteds.add(new Octet<String, Integer, Boolean, Double, String, Integer, String, Boolean>("a", 1, true, 3.4, "2" , 13, "y", false));
			expecteds.add(new Octet<String, Integer, Boolean, Double, String, Integer, String, Boolean>("a", 1, true, 3.4, "1" , 17, "y", false));
			expecteds.add(new Octet<String, Integer, Boolean, Double, String, Integer, String, Boolean>("a", 1, true, 3.4, "2" , 17, "y", false));

			final int expectedsSize = expecteds.size();

			final TupUt.OctetPermutator<String, Integer, Boolean, Double, String, Integer, String, Boolean> permutator =
					shouldRandomize
					?
					new TupUt.OctetPermutator<String, Integer, Boolean, Double, String, Integer, String, Boolean>(
							  new String [] {"a"}
							, new Integer[] {1}
							, new Boolean[] {true}
							, new Double[] {3.4}
							, new String[] {"1", "2"}
							, new Integer[] {13, 17}
							, new String[] {"x", "y"}
							, new Boolean[] {false, true}
							, new Random(41)
					)
					:
					new TupUt.OctetPermutator<String, Integer, Boolean, Double, String, Integer, String, Boolean>(
							  new String [] {"a"}
							, new Integer[] {1}
							, new Boolean[] {true}
							, new Double[] {3.4}
							, new String[] {"1", "2"}
							, new Integer[] {13, 17}
							, new String[] {"x", "y"}
							, new Boolean[] {false, true}
					);

			int cnt = 0;
			for (final Octet<String, Integer, Boolean, Double, String, Integer, String, Boolean> tuple : permutator) {
				cnt++;
				assertTrue(expecteds.remove(tuple));
			}
			assertTrue(expecteds.isEmpty());
			assertEquals(expectedsSize, cnt);
			
			final java.util.Iterator<Octet<String, Integer, Boolean, Double, String, Integer, String, Boolean>> tupleIterator =
					permutator.iterator();
			cnt = 0;
			for (; tupleIterator.hasNext(); tupleIterator.next()) {
				cnt++;
			}
			assertEquals(expectedsSize, cnt);
			assertFalse(tupleIterator.hasNext());
			try {
				tupleIterator.next();
				fail("Expected exception received");
			} catch (AssertionError exception) {
				throw exception;
			} catch (NoSuchElementException exception) {
				// OK_NOTUSINGDEF
			} catch (Throwable exception) {
				fail("Erroneous exception received");
			}
		}
	}
	
	// =========================================================================

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt.EnneadPermutator}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testEnneadPermutator() {

		final Set<Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>> expecteds =
				new HashSet<Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>>();
		
		for (final boolean shouldRandomize : new boolean[]{false, true}) {

			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "1" , 13, "x", true, "A"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "2" , 13, "x", true, "A"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "1" , 17, "x", true, "A"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "2" , 17, "x", true, "A"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "1" , 13, "y", true, "A"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "2" , 13, "y", true, "A"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "1" , 17, "y", true, "A"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "2" , 17, "y", true, "A"));
                              
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "1" , 13, "x", false, "A"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "2" , 13, "x", false, "A"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "1" , 17, "x", false, "A"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "2" , 17, "x", false, "A"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "1" , 13, "y", false, "A"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "2" , 13, "y", false, "A"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "1" , 17, "y", false, "A"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "2" , 17, "y", false, "A"));
                              
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "1" , 13, "x", true, "B"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "2" , 13, "x", true, "B"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "1" , 17, "x", true, "B"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "2" , 17, "x", true, "B"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "1" , 13, "y", true, "B"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "2" , 13, "y", true, "B"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "1" , 17, "y", true, "B"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "2" , 17, "y", true, "B"));
                              
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "1" , 13, "x", false, "B"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "2" , 13, "x", false, "B"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "1" , 17, "x", false, "B"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "2" , 17, "x", false, "B"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "1" , 13, "y", false, "B"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "2" , 13, "y", false, "B"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "1" , 17, "y", false, "B"));
			expecteds.add(new Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>("a", 1, true, 3.4, "2" , 17, "y", false, "B"));

			final int expectedsSize = expecteds.size();

			final TupUt.EnneadPermutator<String, Integer, Boolean, Double, String, Integer, String, Boolean, String> permutator =
					shouldRandomize
					?
					new TupUt.EnneadPermutator<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>(
							  new String [] {"a"}
							, new Integer[] {1}
							, new Boolean[] {true}
							, new Double[] {3.4}
							, new String[] {"1", "2"}
							, new Integer[] {13, 17}
							, new String[] {"x", "y"}
							, new Boolean[] {false, true}
							, new String[] {"A", "B"}
							, new Random(41)
					)
					:
					new TupUt.EnneadPermutator<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>(
							  new String [] {"a"}
							, new Integer[] {1}
							, new Boolean[] {true}
							, new Double[] {3.4}
							, new String[] {"1", "2"}
							, new Integer[] {13, 17}
							, new String[] {"x", "y"}
							, new Boolean[] {false, true}
							, new String[] {"A", "B"}
					);

			int cnt = 0;
			for (final Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String> tuple : permutator) {
				cnt++;
				assertTrue(expecteds.remove(tuple));
			}
			assertTrue(expecteds.isEmpty());
			assertEquals(expectedsSize, cnt);
			
			final java.util.Iterator<Ennead<String, Integer, Boolean, Double, String, Integer, String, Boolean, String>> tupleIterator =
					permutator.iterator();
			cnt = 0;
			for (; tupleIterator.hasNext(); tupleIterator.next()) {
				cnt++;
			}
			assertEquals(expectedsSize, cnt);
			assertFalse(tupleIterator.hasNext());
			try {
				tupleIterator.next();
				fail("Expected exception received");
			} catch (AssertionError exception) {
				throw exception;
			} catch (NoSuchElementException exception) {
				// OK_NOTUSINGDEF
			} catch (Throwable exception) {
				fail("Erroneous exception received");
			}
		}
	}
	
	// =========================================================================

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt.DecadePermutator}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testDecadePermutator() {

		final Set<Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>> expecteds =
				new HashSet<Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>>();
		
		for (final boolean shouldRandomize : new boolean[]{false, true}) {

			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "1" , 13, "x", true, "A", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "2" , 13, "x", true, "A", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "1" , 17, "x", true, "A", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "2" , 17, "x", true, "A", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "1" , 13, "y", true, "A", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "2" , 13, "y", true, "A", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "1" , 17, "y", true, "A", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "2" , 17, "y", true, "A", 7));
                              
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "1" , 13, "x", false, "A", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "2" , 13, "x", false, "A", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "1" , 17, "x", false, "A", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "2" , 17, "x", false, "A", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "1" , 13, "y", false, "A", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "2" , 13, "y", false, "A", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "1" , 17, "y", false, "A", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "2" , 17, "y", false, "A", 7));
                              
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "1" , 13, "x", true, "B", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "2" , 13, "x", true, "B", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "1" , 17, "x", true, "B", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "2" , 17, "x", true, "B", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "1" , 13, "y", true, "B", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "2" , 13, "y", true, "B", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "1" , 17, "y", true, "B", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "2" , 17, "y", true, "B", 7));
                              
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "1" , 13, "x", false, "B", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "2" , 13, "x", false, "B", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "1" , 17, "x", false, "B", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "2" , 17, "x", false, "B", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "1" , 13, "y", false, "B", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "2" , 13, "y", false, "B", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "1" , 17, "y", false, "B", 7));
			expecteds.add(new Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>("a", 1, true, 3.4, "2" , 17, "y", false, "B", 7));

			final int expectedsSize = expecteds.size();

			final TupUt.DecadePermutator<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer> permutator =
					shouldRandomize
					?
					new TupUt.DecadePermutator<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>(
							  new String [] {"a"}
							, new Integer[] {1}
							, new Boolean[] {true}
							, new Double[] {3.4}
							, new String[] {"1", "2"}
							, new Integer[] {13, 17}
							, new String[] {"x", "y"}
							, new Boolean[] {false, true}
							, new String[] {"A", "B"}
							, new Integer[] {7}
							, new Random(41)
					)
					:
					new TupUt.DecadePermutator<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>(
							  new String [] {"a"}
							, new Integer[] {1}
							, new Boolean[] {true}
							, new Double[] {3.4}
							, new String[] {"1", "2"}
							, new Integer[] {13, 17}
							, new String[] {"x", "y"}
							, new Boolean[] {false, true}
							, new String[] {"A", "B"}
							, new Integer[] {7}
					);

			int cnt = 0;
			for (final Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer> tuple : permutator) {
				cnt++;
				assertTrue(expecteds.remove(tuple));
			}
			assertTrue(expecteds.isEmpty());
			assertEquals(expectedsSize, cnt);
			
			final java.util.Iterator<Decade<String, Integer, Boolean, Double, String, Integer, String, Boolean, String, Integer>> tupleIterator =
					permutator.iterator();
			cnt = 0;
			for (; tupleIterator.hasNext(); tupleIterator.next()) {
				cnt++;
			}
			assertEquals(expectedsSize, cnt);
			assertFalse(tupleIterator.hasNext());
			try {
				tupleIterator.next();
				fail("Expected exception received");
			} catch (AssertionError exception) {
				throw exception;
			} catch (NoSuchElementException exception) {
				// OK_NOTUSINGDEF
			} catch (Throwable exception) {
				fail("Erroneous exception received");
			}
		}
	}
	
	// =========================================================================

	/**
	 * Creates an instance of the private class {@link TupUt.Void}. 
	 * @return An instance of the private class {@link TupUt.Void}.
	 * @throws InstantiationException If something goes wrong in the reflection.
	 * @throws IllegalAccessException If something goes wrong in the reflection.
	 * @throws IllegalArgumentException If something goes wrong in the reflection.
	 * @throws InvocationTargetException If something goes wrong in the reflection.
	 * @throws NoSuchMethodException If something goes wrong in the reflection.
	 * @throws SecurityException If something goes wrong in the reflection.
	 */
	private Object constructTupUtVoidOfString() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {

		final Class<?>[] classes = TupUt.class.getDeclaredClasses();
		Object clazzInstance = null;
		for (final Class<?> clazz : classes) {
			/* TupUt.Void */
			if (clazz.getName().endsWith("Void")) {
				final Constructor<?> constructor =
						clazz.getDeclaredConstructor(new Class<?>[]{});
				constructor.setAccessible(true);
				clazzInstance =
						constructor.newInstance(new Object[]{});
				break;
			}
		}
		return clazzInstance;
	}

	// =========================================================================

	/**
	 * Tests {@link TupUt#concatenate(Tuple, String)}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testTupUtConcatenate() {

		final Set<Triplet<? extends Tuple, String, String>> data =
				new HashSet<Triplet<? extends Tuple, String, String>>();
		data.add(new Triplet<Tuple, String, String>(new Unit<String>(""), "", ""));
		data.add(new Triplet<Tuple, String, String>(new Unit<String>(" "), " ", " "));
		data.add(new Triplet<Tuple, String, String>(new Unit<String>(null), null, null));
		data.add(new Triplet<Tuple, String, String>(new Unit<String>("a"), "a", "a"));
		data.add(new Triplet<Tuple, String, String>(new Pair<String, String>(null, "a"), "a", "a"));
		data.add(new Triplet<Tuple, String, String>(new Pair<String, String>("a", null), "a", "a"));
		data.add(new Triplet<Tuple, String, String>(new Pair<String, String>(null, null), null, null));
		data.add(new Triplet<Tuple, String, String>(new Pair<String, String>("", ""), "", "-"));
		data.add(new Triplet<Tuple, String, String>(new Pair<String, String>(" ", ""), " ", " -"));
		data.add(new Triplet<Tuple, String, String>(new Pair<String, String>(" ", " "), "  ", " - "));
		data.add(new Triplet<Tuple, String, String>(new Pair<String, String>("a", "b"), "ab", "a-b"));
		data.add(new Triplet<Tuple, String, String>(new Decade<String, String, String, String, String, String, String, String, Integer, String>("a", "  ", "cde", null, "", " ", "f", "gh", 79, "i"), "a  cde fgh79i", "a-  cde-- f-gh-79-i"));

		for (final Tuple datum : data) {
			final String expected1 = (String)datum.getValue(1);
			final String actual = TupUt.concatenate((Tuple)(datum.getValue(0)), null);
			assertEquals(expected1, actual);
		}
	}
	
	// =========================================================================

	/**
	 * Test method for
	 * {@link net.barakiroth.util.TupUt#TupUt()}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testTupUtConstructorJustToSatisfyJaCoCo() {
		new TupUt();
	}
	////
	//// END Methods
	//// =======================================================================
}
/*
Revision history:
$Log:$
*/
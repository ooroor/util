// Copyright (C) 2014 barakiroth.net
// All rights reserved
/**
 * 
 */
package net.barakiroth.oorutil.tuples;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import net.barakiroth.oortestutil.IUnitTestCategory;

/**
 * 
 */
public class Tuple001PermutatorUnitTest {
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
	/**
	 * For logging purposes, e.g. to file.
	 */
	@SuppressWarnings("unused")
	private final static Logger logger =
		(Logger)LoggerFactory.getLogger(Tuple001PermutatorUnitTest.class);
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
	 * @throws java.lang.Exception if something unexpected occurs.
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception if something unexpected occurs.
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception if something unexpected occurs.
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception if something unexpected occurs.
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	//// =======================================================================

	/** Tests 
	 * {@link Tuple002Permutator}
	 * for erroneous parameters.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple001Permutator_0() {
		try {
			new Tuple001Permutator<String>(
					  new String []{}
			);
			fail("Expected exception not received");
		} catch (AssertionError e) {
			throw e;
		} catch (IllegalArgumentException e) {
			// OK_NOTUSINGDEF
		} catch (Throwable e) {
			fail("Erroneous exception received");
		}
	}

	/** Tests that all permutations are covered for
	 * {@link Tuple002Permutator}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple001Permutator_1_1() {

		final Tuple001Permutator<String> tuple001Permutator =
				new Tuple001Permutator<String>(
						  new String []{"Hei"}
				);

		@SuppressWarnings("serial")
		final Set<Tuple001<String>> allPermutations =
				new HashSet<Tuple001<String>>() {{
					add(new Tuple001<String>("Hei"));
				}};
		for (final Tuple001<String> tuple : tuple001Permutator) {
			boolean atLeastOneEquals = false;
			for (final Tuple001<String> settedTuple : allPermutations) {
				if (settedTuple.equals(tuple)) {
					atLeastOneEquals = true;
					break;
				}
			}
			assertTrue(atLeastOneEquals);
			assertTrue(allPermutations.contains(tuple));
			assertTrue(allPermutations.remove(tuple));
		}
		assertTrue(allPermutations.isEmpty());
	}

	/** Tests that all permutations are covered for
	 * {@link Tuple002Permutator}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple001Permutator_1_2() {

		final Tuple001Permutator<String> tuple001Permutator =
				new Tuple001Permutator<String>(
						  new String []{null}
				);

		@SuppressWarnings("serial")
		final Set<Tuple001<String>> allPermutations =
				new HashSet<Tuple001<String>>() {{
					add(new Tuple001<String>(null));
				}};
		for (final Tuple001<String> tuple : tuple001Permutator) {
			boolean atLeastOneEquals = false;
			for (final Tuple001<String> settedTuple : allPermutations) {
				if (settedTuple.equals(tuple)) {
					atLeastOneEquals = true;
					break;
				}
			}
			assertTrue(atLeastOneEquals);
			assertTrue(allPermutations.contains(tuple));
			assertTrue(allPermutations.remove(tuple));
		}
		assertTrue(allPermutations.isEmpty());
	}

	/** Tests that all permutations are covered for
	 * {@link Tuple002Permutator}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple001Permutator_2_1() {

		final Tuple001Permutator<String> tuple001Permutator =
				new Tuple001Permutator<String>(
						  new String []{null, "Hei"}
				);

		@SuppressWarnings("serial")
		final Set<Tuple001<String>> allPermutations =
				new HashSet<Tuple001<String>>() {{
					add(new Tuple001<String>(null));
					add(new Tuple001<String>("Hei"));
				}};
		for (final Tuple001<String> tuple : tuple001Permutator) {
			boolean atLeastOneEquals = false;
			for (final Tuple001<String> settedTuple : allPermutations) {
				if (settedTuple.equals(tuple)) {
					atLeastOneEquals = true;
					break;
				}
			}
			assertTrue(atLeastOneEquals);
			assertTrue(allPermutations.contains(tuple));
			assertTrue(allPermutations.remove(tuple));
		}
		assertTrue(allPermutations.isEmpty());
	}

	/** Tests that all permutations are covered for
	 * {@link Tuple002Permutator}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple001Permutator_2_2() {

		final Tuple001Permutator<String> tuple001Permutator =
				new Tuple001Permutator<String>(
						  new String []{"Hei", null}
				);

		@SuppressWarnings("serial")
		final Set<Tuple001<String>> allPermutations =
				new HashSet<Tuple001<String>>() {{
					add(new Tuple001<String>(null));
					add(new Tuple001<String>("Hei"));
				}};
		for (final Tuple001<String> tuple : tuple001Permutator) {
			boolean atLeastOneEquals = false;
			for (final Tuple001<String> settedTuple : allPermutations) {
				if (settedTuple.equals(tuple)) {
					atLeastOneEquals = true;
					break;
				}
			}
			assertTrue(atLeastOneEquals);
			assertTrue(allPermutations.contains(tuple));
			assertTrue(allPermutations.remove(tuple));
		}
		assertTrue(allPermutations.isEmpty());
	}

	/** Tests that all permutations are covered for
	 * {@link Tuple002Permutator}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple001Permutator_2_3() {

		final Tuple001Permutator<String> tuple001Permutator =
				new Tuple001Permutator<String>(
						  new String []{"Hei", "på"}
				);

		@SuppressWarnings("serial")
		final Set<Tuple001<String>> allPermutations =
				new HashSet<Tuple001<String>>() {{
					add(new Tuple001<String>("på"));
					add(new Tuple001<String>("Hei"));
				}};
		for (final Tuple001<String> tuple : tuple001Permutator) {
			boolean atLeastOneEquals = false;
			for (final Tuple001<String> settedTuple : allPermutations) {
				if (settedTuple.equals(tuple)) {
					atLeastOneEquals = true;
					break;
				}
			}
			assertTrue(atLeastOneEquals);
			assertTrue(allPermutations.contains(tuple));
			assertTrue(allPermutations.remove(tuple));
		}
		assertTrue(allPermutations.isEmpty());
	}

	/** Tests that all permutations are covered for
	 * {@link Tuple002Permutator}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple001Permutator_2_4() {

		final Tuple001Permutator<String> tuple001Permutator =
				new Tuple001Permutator<String>(
						  new String []{"Hei", "Hei"}
				);

		@SuppressWarnings("serial")
		final Set<Tuple001<String>> allPermutations =
				new HashSet<Tuple001<String>>() {{
					add(new Tuple001<String>("Hei"));
				}};
		for (final Tuple001<String> tuple : tuple001Permutator) {
			boolean atLeastOneEquals = false;
			for (final Tuple001<String> settedTuple : allPermutations) {
				if (settedTuple.equals(tuple)) {
					atLeastOneEquals = true;
					break;
				}
			}
			assertTrue(atLeastOneEquals);
			assertTrue(allPermutations.contains(tuple));
			assertTrue(allPermutations.remove(tuple));
		}
		assertTrue(allPermutations.isEmpty());
	}

	/** Tests that all permutations are covered for
	 * {@link Tuple002Permutator}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple001Permutator_2_5() {

		final Tuple001Permutator<String> tuple001Permutator =
				new Tuple001Permutator<String>(
						  new String []{null, null}
				);

		@SuppressWarnings("serial")
		final Set<Tuple001<String>> allPermutations =
				new HashSet<Tuple001<String>>() {{
					add(new Tuple001<String>(null));
				}};
		for (final Tuple001<String> tuple : tuple001Permutator) {
			boolean atLeastOneEquals = false;
			for (final Tuple001<String> settedTuple : allPermutations) {
				if (settedTuple.equals(tuple)) {
					atLeastOneEquals = true;
					break;
				}
			}
			assertTrue(atLeastOneEquals);
			assertTrue(allPermutations.contains(tuple));
			assertTrue(allPermutations.remove(tuple));
		}
		assertTrue(allPermutations.isEmpty());
	}
	////
	//// END Methods
	//// =======================================================================
}
/*
Revision history:
$Log:$
*/
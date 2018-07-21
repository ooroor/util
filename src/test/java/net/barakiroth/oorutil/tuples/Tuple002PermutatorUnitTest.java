// Copyright (C) 2014 barakiroth.net
// All rights reserved
/**
 * 
 */
package net.barakiroth.oorutil.tuples;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import net.barakiroth.oortestutil.IUnitTestCategory;

/**
 * 
 */
public class Tuple002PermutatorUnitTest {
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
		(Logger)LoggerFactory.getLogger(Tuple002PermutatorUnitTest.class);
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
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception if something unexpected occurs.
	 */
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception if something unexpected occurs.
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception if something unexpected occurs.
	 */
	@AfterEach
	public void tearDown() throws Exception {
	}
	
	//// =======================================================================

	/** Tests 
	 * {@link Tuple002Permutator}
	 * for erroneous parameters.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple002Permutator_0_2() {
		try {
			new Tuple002Permutator<String, Integer>(
					  new String []{}
					, new Integer[]{null, 8}
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

	/** Tests 
	 * {@link Tuple002Permutator}
	 * for erroneous parameters
	 * with randomization.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple002Permutator_0_2_R() {
		try {
			new Tuple002Permutator<String, Integer>(
					  new String []{}
					, new Integer[]{null, 8}
					, new Random(23)
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

	/** Tests 
	 * {@link Tuple002Permutator}
	 * for erroneous parameters.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple002Permutator_2_0() {

		try {
			new Tuple002Permutator<String, Integer>(
					  new String []{"Hei", null}
					, new Integer[]{}
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

	/** Tests 
	 * {@link Tuple002Permutator}
	 * for erroneous parameters
	 * with randomization.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple002Permutator_2_0_R() {

		try {
			new Tuple002Permutator<String, Integer>(
					  new String []{"Hei", null}
					, new Integer[]{}
					, new Random(23)
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
	public final void testTuple002Permutator_1_2_1() {

		final Tuple002Permutator<String, Integer> tuple002Permutator =
				new Tuple002Permutator<String, Integer>(
						  new String []{"Hei"}
						, new Integer[]{null, 8}
				);

		@SuppressWarnings("serial")
		final Set<Tuple002<String, Integer>> allPermutations =
				new HashSet<Tuple002<String, Integer>>() {{
					add(new Tuple002<String, Integer>("Hei", (Integer)null));
					add(new Tuple002<String, Integer>("Hei", 8));
				}};
		for (final Tuple002<String, Integer> tuple : tuple002Permutator) {
			boolean atLeastOneEquals = false;
			for (final Tuple002<String, Integer> settedTuple : allPermutations) {
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
	 * {@link Tuple002Permutator}
	 * with randomization.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple002Permutator_1_2_1_R() {

		final Tuple002Permutator<String, Integer> tuple002Permutator =
				new Tuple002Permutator<String, Integer>(
						  new String []{"Hei"}
						, new Integer[]{null, 8}
						, new Random(23)
				);

		@SuppressWarnings("serial")
		final Set<Tuple002<String, Integer>> allPermutations =
				new HashSet<Tuple002<String, Integer>>() {{
					add(new Tuple002<String, Integer>("Hei", (Integer)null));
					add(new Tuple002<String, Integer>("Hei", 8));
				}};
		for (final Tuple002<String, Integer> tuple : tuple002Permutator) {
			boolean atLeastOneEquals = false;
			for (final Tuple002<String, Integer> settedTuple : allPermutations) {
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
	public final void testTuple002Permutator_1_2_2() {

		final Tuple002Permutator<String, Integer> tuple002Permutator =
				new Tuple002Permutator<String, Integer>(
						  new String []{null}
						, new Integer[]{null, 8}
				);

		@SuppressWarnings("serial")
		final Set<Tuple002<String, Integer>> allPermutations =
				new HashSet<Tuple002<String, Integer>>() {{
					add(new Tuple002<String, Integer>((String)null, (Integer)null));
					add(new Tuple002<String, Integer>((String)null, 8));
				}};
		for (final Tuple002<String, Integer> tuple : tuple002Permutator) {
			boolean atLeastOneEquals = false;
			for (final Tuple002<String, Integer> settedTuple : allPermutations) {
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
	 * {@link Tuple002Permutator}
	 * with randomization.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple002Permutator_1_2_2_R() {

		final Tuple002Permutator<String, Integer> tuple002Permutator =
				new Tuple002Permutator<String, Integer>(
						  new String []{null}
						, new Integer[]{null, 8}
						, new Random(23)
				);

		@SuppressWarnings("serial")
		final Set<Tuple002<String, Integer>> allPermutations =
				new HashSet<Tuple002<String, Integer>>() {{
					add(new Tuple002<String, Integer>((String)null, (Integer)null));
					add(new Tuple002<String, Integer>((String)null, 8));
				}};
		for (final Tuple002<String, Integer> tuple : tuple002Permutator) {
			boolean atLeastOneEquals = false;
			for (final Tuple002<String, Integer> settedTuple : allPermutations) {
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
	public final void testTuple002Permutator_2_1_1() {

		final Tuple002Permutator<String, Integer> tuple002Permutator =
				new Tuple002Permutator<String, Integer>(
						  new String []{"Hei", null}
						, new Integer[]{8}
				);

		@SuppressWarnings("serial")
		final Set<Tuple002<String, Integer>> allPermutations =
				new HashSet<Tuple002<String, Integer>>() {{
					add(new Tuple002<String, Integer>("Hei", 8));
					add(new Tuple002<String, Integer>((String)null, 8));
				}};
		for (final Tuple002<String, Integer> tuple : tuple002Permutator) {
			boolean atLeastOneEquals = false;
			for (final Tuple002<String, Integer> settedTuple : allPermutations) {
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
	 * {@link Tuple002Permutator}
	 * with randomization.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple002Permutator_2_1_1_R() {

		final Tuple002Permutator<String, Integer> tuple002Permutator =
				new Tuple002Permutator<String, Integer>(
						  new String []{"Hei", null}
						, new Integer[]{8}
						, new Random(19)
				);

		@SuppressWarnings("serial")
		final Set<Tuple002<String, Integer>> allPermutations =
				new HashSet<Tuple002<String, Integer>>() {{
					add(new Tuple002<String, Integer>("Hei", 8));
					add(new Tuple002<String, Integer>((String)null, 8));
				}};
		for (final Tuple002<String, Integer> tuple : tuple002Permutator) {
			boolean atLeastOneEquals = false;
			for (final Tuple002<String, Integer> settedTuple : allPermutations) {
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
	public final void testTuple002Permutator_2_1_2() {

		final Tuple002Permutator<String, Integer> tuple002Permutator =
				new Tuple002Permutator<String, Integer>(
						  new String []{"Hei", null}
						, new Integer[]{null}
				);

		@SuppressWarnings("serial")
		final Set<Tuple002<String, Integer>> allPermutations =
				new HashSet<Tuple002<String, Integer>>() {{
					add(new Tuple002<String, Integer>("Hei", (Integer)null));
					add(new Tuple002<String, Integer>((String)null, (Integer)null));
				}};
		for (final Tuple002<String, Integer> tuple : tuple002Permutator) {
			boolean atLeastOneEquals = false;
			for (final Tuple002<String, Integer> settedTuple : allPermutations) {
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
	 * {@link Tuple002Permutator}
	 * with randomization.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple002Permutator_2_1_2_R() {

		final Tuple002Permutator<String, Integer> tuple002Permutator =
				new Tuple002Permutator<String, Integer>(
						  new String []{"Hei", null}
						, new Integer[]{null}
						, new Random(17)
				);

		@SuppressWarnings("serial")
		final Set<Tuple002<String, Integer>> allPermutations =
				new HashSet<Tuple002<String, Integer>>() {{
					add(new Tuple002<String, Integer>("Hei", (Integer)null));
					add(new Tuple002<String, Integer>((String)null, (Integer)null));
				}};
		for (final Tuple002<String, Integer> tuple : tuple002Permutator) {
			boolean atLeastOneEquals = false;
			for (final Tuple002<String, Integer> settedTuple : allPermutations) {
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
	public final void testTuple002Permutator_2_2() {

		final Tuple002Permutator<String, Integer> tuple002Permutator =
				new Tuple002Permutator<String, Integer>(
						  new String []{"Hei", null}
						, new Integer[]{null, 8}
				);
		@SuppressWarnings("serial")
		final Set<Tuple002<String, Integer>> allPermutations =
				new HashSet<Tuple002<String, Integer>>() {{
					add(new Tuple002<String, Integer>("Hei", (Integer)null));
					add(new Tuple002<String, Integer>("Hei", 8));
					add(new Tuple002<String, Integer>((String)null, (Integer)null));
					add(new Tuple002<String, Integer>((String)null, 8));
				}};
		for (final Tuple002<String, Integer> tuple : tuple002Permutator) {
			boolean atLeastOneEquals = false;
			for (final Tuple002<String, Integer> settedTuple : allPermutations) {
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
	 * {@link Tuple002Permutator}
	 * with randomization.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple002Permutator_2_2_R() {

		final Tuple002Permutator<String, Integer> tuple002Permutator =
				new Tuple002Permutator<String, Integer>(
						  new String []{"Hei", null}
						, new Integer[]{null, 8}
						, new Random(13)
				);
		@SuppressWarnings("serial")
		final Set<Tuple002<String, Integer>> allPermutations =
				new HashSet<Tuple002<String, Integer>>() {{
					add(new Tuple002<String, Integer>("Hei", (Integer)null));
					add(new Tuple002<String, Integer>("Hei", 8));
					add(new Tuple002<String, Integer>((String)null, (Integer)null));
					add(new Tuple002<String, Integer>((String)null, 8));
				}};
		for (final Tuple002<String, Integer> tuple : tuple002Permutator) {
			boolean atLeastOneEquals = false;
			for (final Tuple002<String, Integer> settedTuple : allPermutations) {
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
// Copyright (C) 2014 barakiroth.net
// All rights reserved
/**
 * 
 */
package net.barakiroth.oorutil.tuples;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;
import java.util.Random;
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

/** Tests {@link Tuple005Permutator}.
 */
public class Tuple005PermutatorUnitTest {
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
		(Logger)LoggerFactory.getLogger(Tuple005PermutatorUnitTest.class);
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
	 * {@link final Tuple005Permutator#iterator()}
	 * for performance not using random.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple005PermutatorNoRandom() {

		@SuppressWarnings("serial")
		final Set<Tuple005<String, Integer, Boolean, Long, Character>> someExpecteds =
				new HashSet<Tuple005<String, Integer, Boolean, Long, Character>>() {{
					add(new Tuple005<String, Integer, Boolean, Long, Character>(null, null, null, null, null));
					add(new Tuple005<String, Integer, Boolean, Long, Character>("a" , null, null, null, null));
					add(new Tuple005<String, Integer, Boolean, Long, Character>(null, 1, null, null, null));
					add(new Tuple005<String, Integer, Boolean, Long, Character>(null, null, true, null, null));
					add(new Tuple005<String, Integer, Boolean, Long, Character>(null, null, null, 21L, null));
					add(new Tuple005<String, Integer, Boolean, Long, Character>(null, null, null, null, 'x'));
					add(new Tuple005<String, Integer, Boolean, Long, Character>("a", 1, true, 21L, 'x'));
				}};

		final Tuple005Permutator<String, Integer, Boolean, Long, Character> perm =
			new Tuple005Permutator<String, Integer, Boolean, Long, Character>(
					  new String[]{null, "a"}
					, new Integer[]{null, 1}
					, new Boolean[]{null, true}
					, new Long[]{null, 21L}
					, new Character[]{null, 'x'}
			);

		for (final Tuple005<String, Integer, Boolean, Long, Character> tuple : perm) {
			someExpecteds.remove(tuple);
		}

		assertTrue(someExpecteds.isEmpty());
	}

	/** Tests
	 * {@link final Tuple005Permutator#iterator()}
	 * for performance using random.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple005PermutatorRandom() {

		@SuppressWarnings("serial")
		final Set<Tuple005<String, Integer, Boolean, Long, Character>> someExpecteds =
				new HashSet<Tuple005<String, Integer, Boolean, Long, Character>>() {{
					add(new Tuple005<String, Integer, Boolean, Long, Character>(null, null, null, null, null));
					add(new Tuple005<String, Integer, Boolean, Long, Character>("a" , null, null, null, null));
					add(new Tuple005<String, Integer, Boolean, Long, Character>(null,    1, null, null, null));
					add(new Tuple005<String, Integer, Boolean, Long, Character>(null, null, true, null, null));
					add(new Tuple005<String, Integer, Boolean, Long, Character>(null, null, null,  21L, null));
					add(new Tuple005<String, Integer, Boolean, Long, Character>(null, null, null, null,  'x'));
					add(new Tuple005<String, Integer, Boolean, Long, Character>("a" ,    1, true,  21L,  'x'));
				}};

		final Tuple005Permutator<String, Integer, Boolean, Long, Character> perm =
			new Tuple005Permutator<String, Integer, Boolean, Long, Character>(
					  new String[]{null, "a"}
					, new Integer[]{null, 1}
					, new Boolean[]{null, true}
					, new Long[]{null, 21L}
					, new Character[]{null, 'x'}
					, new Random(17)
			);

		for (final Tuple005<String, Integer, Boolean, Long, Character> tuple : perm) {
			someExpecteds.remove(tuple);
		}

		assertTrue(someExpecteds.isEmpty());
	}

	/** Tests
	 * {@link final Tuple005Permutator#iterator()}
	 * with one of the arrays <code>null</code>.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple005PermutatorOneArrayNull_1() {
		try {
			new Tuple005Permutator<String, Integer, Boolean, Long, Character>(
					  null
					, new Integer[]{null, 1}
					, new Boolean[]{null, true}
					, new Long[]{null, 21L}
					, new Character[]{null, 'x'});
			fail("Expected exception not received");
		} catch (AssertionError e) {
			throw e;
		} catch (NullPointerException e) {
			// OK
		} catch (Throwable e) {
			fail("Erroneous exception received");
		}
	}

	/** Tests
	 * {@link final Tuple005Permutator#iterator()}
	 * with one of the arrays <code>null</code>.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple005PermutatorOneArrayNull_2() {
		try {
			new Tuple005Permutator<String, Integer, Boolean, Long, Character>(
					  new String[]{null, "a"}
					, null
					, new Boolean[]{null, true}
					, new Long[]{null, 21L}
					, new Character[]{null, 'x'});
			fail("Expected exception not received");
		} catch (AssertionError e) {
			throw e;
		} catch (NullPointerException e) {
			// OK
		} catch (Throwable e) {
			fail("Erroneous exception received");
		}
	}

	/** Tests
	 * {@link final Tuple005Permutator#iterator()}
	 * with one of the arrays <code>null</code>.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple005PermutatorOneArrayNull_3() {
		try {
			new Tuple005Permutator<String, Integer, Boolean, Long, Character>(
					  new String[]{null, "a"}
					, new Integer[]{null, 1}
					, null
					, new Long[]{null, 21L}
					, new Character[]{null, 'x'});
			fail("Expected exception not received");
		} catch (AssertionError e) {
			throw e;
		} catch (NullPointerException e) {
			// OK
		} catch (Throwable e) {
			fail("Erroneous exception received");
		}
	}

	/** Tests
	 * {@link final Tuple005Permutator#iterator()}
	 * with one of the arrays <code>null</code>.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple005PermutatorOneArrayNull_4() {
		try {
			new Tuple005Permutator<String, Integer, Boolean, Long, Character>(
					  new String[]{null, "a"}
					, new Integer[]{null, 1}
					, new Boolean[]{null, true}
					, null
					, new Character[]{null, 'x'});
			fail("Expected exception not received");
		} catch (AssertionError e) {
			throw e;
		} catch (NullPointerException e) {
			// OK
		} catch (Throwable e) {
			fail("Erroneous exception received");
		}
	}

	/** Tests
	 * {@link final Tuple005Permutator#iterator()}
	 * with one of the arrays <code>null</code>.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple005PermutatorOneArrayNull_5() {
		try {
			new Tuple005Permutator<String, Integer, Boolean, Long, Character>(
					  new String[]{null, "a"}
					, new Integer[]{null, 1}
					, new Boolean[]{null, true}
					, new Long[]{null, 21L}
					, null);
			fail("Expected exception not received");
		} catch (AssertionError e) {
			throw e;
		} catch (NullPointerException e) {
			// OK
		} catch (Throwable e) {
			fail("Erroneous exception received");
		}
	}
	////
	//// END Methods
	//// =======================================================================
}
/*
Revision history:
$Log:$
*/
// Copyright (C) 2014 barakiroth.net
// All rights reserved
/**
 * 
 */
package net.barakiroth.oorutil.tuples;

import static org.junit.Assert.assertTrue;

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

/** Tests {@link Tuple007Permutator}.
 */
public class Tuple007PermutatorUnitTest {
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
		(Logger)LoggerFactory.getLogger(Tuple007PermutatorUnitTest.class);
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
	/** @throws java.lang.Exception if something unexpected occurs.
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/** @throws java.lang.Exception if something unexpected occurs.
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/** @throws java.lang.Exception if something unexpected occurs.
	 */
	@Before
	public void setUp() throws Exception {
	}

	/** @throws java.lang.Exception if something unexpected occurs.
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	//// =======================================================================
	/** Tests
	 * {@link final Tuple007Permutator#iterator()}
	 * for performance not using random.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple007PermutatorNoRandom() {

		@SuppressWarnings({ "serial" })
		final Set<Tuple007<String, Integer, Boolean, Long, Character, String, String>> someExpecteds =
				new HashSet<Tuple007<String, Integer, Boolean, Long, Character, String, String>>() {{
					add(new Tuple007<String, Integer, Boolean, Long, Character, String, String>(null, null, null, null, null, null, null));
					add(new Tuple007<String, Integer, Boolean, Long, Character, String, String>("a" , null, null, null, null, null, null));
					add(new Tuple007<String, Integer, Boolean, Long, Character, String, String>(null,    1, null, null, null, null, null));
					add(new Tuple007<String, Integer, Boolean, Long, Character, String, String>(null, null, true, null, null, null, null));
					add(new Tuple007<String, Integer, Boolean, Long, Character, String, String>(null, null, null,  21L, null, null, null));
					add(new Tuple007<String, Integer, Boolean, Long, Character, String, String>(null, null, null, null,  'x', null, null));
					add(new Tuple007<String, Integer, Boolean, Long, Character, String, String>(null, null, null, null, null,  "p", null));
					add(new Tuple007<String, Integer, Boolean, Long, Character, String, String>(null, null, null, null, null, null,  "q"));
					add(new Tuple007<String, Integer, Boolean, Long, Character, String, String>("a" ,    1, true,  21L,  'x',  "p",  "q"));
				}};

		final Tuple007Permutator<String, Integer, Boolean, Long, Character, String, String> perm =
			new Tuple007Permutator<String, Integer, Boolean, Long, Character, String, String>(
					  new String[]{null, "a"}
					, new Integer[]{null, 1}
					, new Boolean[]{null, true}
					, new Long[]{null, 21L}
					, new Character[]{null, 'x'}
					, new String[]{null, "p"}
					, new String[]{null, "q"}
			);

		for (final Tuple007<String, Integer, Boolean, Long, Character, String, String> tuple : perm) {
			someExpecteds.remove(tuple);
		}

		assertTrue(someExpecteds.isEmpty());
	}

	/** Tests
	 * {@link final Tuple007Permutator#iterator()}
	 * for performance using random.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple007PermutatorRandom() {

		@SuppressWarnings({ "serial" })
		final Set<Tuple007<String, Integer, Boolean, Long, Character, String, String>> someExpecteds =
				new HashSet<Tuple007<String, Integer, Boolean, Long, Character, String, String>>() {{
					add(new Tuple007<String, Integer, Boolean, Long, Character, String, String>(null, null, null, null, null, null, null));
					add(new Tuple007<String, Integer, Boolean, Long, Character, String, String>("a" , null, null, null, null, null, null));
					add(new Tuple007<String, Integer, Boolean, Long, Character, String, String>(null,    1, null, null, null, null, null));
					add(new Tuple007<String, Integer, Boolean, Long, Character, String, String>(null, null, true, null, null, null, null));
					add(new Tuple007<String, Integer, Boolean, Long, Character, String, String>(null, null, null,  21L, null, null, null));
					add(new Tuple007<String, Integer, Boolean, Long, Character, String, String>(null, null, null, null,  'x', null, null));
					add(new Tuple007<String, Integer, Boolean, Long, Character, String, String>(null, null, null, null, null,  "p", null));
					add(new Tuple007<String, Integer, Boolean, Long, Character, String, String>(null, null, null, null, null, null,  "q"));
					add(new Tuple007<String, Integer, Boolean, Long, Character, String, String>("a" ,    1, true,  21L,  'x',  "p",  "q"));
				}};

		final Tuple007Permutator<String, Integer, Boolean, Long, Character, String, String> perm =
			new Tuple007Permutator<String, Integer, Boolean, Long, Character, String, String>(
					  new String[]{null, "a"}
					, new Integer[]{null, 1}
					, new Boolean[]{null, true}
					, new Long[]{null, 21L}
					, new Character[]{null, 'x'}
					, new String[]{null, "p"}
					, new String[]{null, "q"}
					, new Random(29)
			);

		for (final Tuple007<String, Integer, Boolean, Long, Character, String, String> tuple : perm) {
			someExpecteds.remove(tuple);
		}

		assertTrue(someExpecteds.isEmpty());
	}
	////
	//// END Methods
	//// =======================================================================
}
/*
Revision history:
$Log:$
*/
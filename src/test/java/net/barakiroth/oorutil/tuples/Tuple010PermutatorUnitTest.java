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

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.experimental.categories.Category;
import org.slf4j.LoggerFactory;


import ch.qos.logback.classic.Logger;
import net.barakiroth.oortestutil.IUnitTestCategory;

/** Tests {@link Tuple010Permutator}.
 */
public class Tuple010PermutatorUnitTest {
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
		(Logger)LoggerFactory.getLogger(Tuple010PermutatorUnitTest.class);
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
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	/** @throws java.lang.Exception if something unexpected occurs.
	 */
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	/** @throws java.lang.Exception if something unexpected occurs.
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	/** @throws java.lang.Exception if something unexpected occurs.
	 */
	@AfterEach
	public void tearDown() throws Exception {
	}
	
	//// =======================================================================

	/** Tests
	 * {@link final Tuple010Permutator#iterator()}
	 * for performance not using random.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple009PermutatorNoRandom() {

		@SuppressWarnings("serial")
		final Set<Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>> someExpecteds =
				new HashSet<Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>>() {{
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>(null, null, null, null, null, null, null, null, null, null));
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>("a" , null, null, null, null, null, null, null, null, null));
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>(null,    1, null, null, null, null, null, null, null, null));
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>(null, null, true, null, null, null, null, null, null, null));
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>(null, null, null,  21L, null, null, null, null, null, null));
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>(null, null, null, null,  'x', null, null, null, null, null));
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>(null, null, null, null, null,  "p", null, null, null, null));
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>(null, null, null, null, null, null,  "q", null, null, null));
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>(null, null, null, null, null, null, null,  "r", null, null));
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>(null, null, null, null, null, null, null, null,  "s", null));
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>(null, null, null, null, null, null, null, null, null,  "t"));
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>("a" ,    1, true,  21L,  'x',  "p",  "q",  "r",  "s",  "t"));
				}};

		final Tuple010Permutator<String, Integer, Boolean, Long, Character, String, String, String, String, String> perm =
			new Tuple010Permutator<String, Integer, Boolean, Long, Character, String, String, String, String, String>(
					  new String[]{null, "a"}
					, new Integer[]{null, 1}
					, new Boolean[]{null, true}
					, new Long[]{null, 21L}
					, new Character[]{null, 'x'}
					, new String[]{null, "p"}
					, new String[]{null, "q"}
					, new String[]{null, "r"}
					, new String[]{null, "s"}
					, new String[]{null, "t"}
			);

		for (final Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String> tuple : perm) {
			someExpecteds.remove(tuple);
		}

		assertTrue(someExpecteds.isEmpty());
	}

	/** Tests
	 * {@link final Tuple010Permutator#iterator()}
	 * for performance using random.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple009PermutatorRandom() {

		@SuppressWarnings("serial")
		final Set<Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>> someExpecteds =
				new HashSet<Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>>() {{
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>(null, null, null, null, null, null, null, null, null, null));
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>("a" , null, null, null, null, null, null, null, null, null));
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>(null,    1, null, null, null, null, null, null, null, null));
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>(null, null, true, null, null, null, null, null, null, null));
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>(null, null, null,  21L, null, null, null, null, null, null));
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>(null, null, null, null,  'x', null, null, null, null, null));
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>(null, null, null, null, null,  "p", null, null, null, null));
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>(null, null, null, null, null, null,  "q", null, null, null));
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>(null, null, null, null, null, null, null,  "r", null, null));
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>(null, null, null, null, null, null, null, null,  "s", null));
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>(null, null, null, null, null, null, null, null, null,  "t"));
					add(new Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String>("a" ,    1, true,  21L,  'x',  "p",  "q",  "r",  "s",  "t"));
				}};

		final Tuple010Permutator<String, Integer, Boolean, Long, Character, String, String, String, String, String> perm =
			new Tuple010Permutator<String, Integer, Boolean, Long, Character, String, String, String, String, String>(
					  new String[]{null, "a"}
					, new Integer[]{null, 1}
					, new Boolean[]{null, true}
					, new Long[]{null, 21L}
					, new Character[]{null, 'x'}
					, new String[]{null, "p"}
					, new String[]{null, "q"}
					, new String[]{null, "r"}
					, new String[]{null, "s"}
					, new String[]{null, "t"}
					, new Random(29)
			);

		for (final Tuple010<String, Integer, Boolean, Long, Character, String, String, String, String, String> tuple : perm) {
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
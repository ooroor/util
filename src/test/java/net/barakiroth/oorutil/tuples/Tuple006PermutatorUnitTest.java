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

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import net.barakiroth.oortestutil.IUnitTestCategory;

/** Tests {@link Tuple006Permutator}.
 */
public class Tuple006PermutatorUnitTest {
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
		(Logger)LoggerFactory.getLogger(Tuple006PermutatorUnitTest.class);
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
	 * {@link final Tuple006Permutator#iterator()}
	 * for performance not using random.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple006PermutatorNoRandom() {

		@SuppressWarnings({ "serial" })
		final Set<Tuple006<String, Integer, Boolean, Long, Character, String>> someExpecteds =
				new HashSet<Tuple006<String, Integer, Boolean, Long, Character, String>>() {{
					add(new Tuple006<String, Integer, Boolean, Long, Character, String>(null, null, null, null, null, null));
					add(new Tuple006<String, Integer, Boolean, Long, Character, String>("a" , null, null, null, null, null));
					add(new Tuple006<String, Integer, Boolean, Long, Character, String>(null,    1, null, null, null, null));
					add(new Tuple006<String, Integer, Boolean, Long, Character, String>(null, null, true, null, null, null));
					add(new Tuple006<String, Integer, Boolean, Long, Character, String>(null, null, null,  21L, null, null));
					add(new Tuple006<String, Integer, Boolean, Long, Character, String>(null, null, null, null,  'x', null));
					add(new Tuple006<String, Integer, Boolean, Long, Character, String>(null, null, null, null, null,  "p"));
					add(new Tuple006<String, Integer, Boolean, Long, Character, String>("a" ,    1, true,  21L,  'x',  "p"));
				}};

		final Tuple006Permutator<String, Integer, Boolean, Long, Character, String> perm =
			new Tuple006Permutator<String, Integer, Boolean, Long, Character, String>(
					  new String[]{null, "a"}
					, new Integer[]{null, 1}
					, new Boolean[]{null, true}
					, new Long[]{null, 21L}
					, new Character[]{null, 'x'}
					, new String[]{null, "p"}
			);

		for (final Tuple006<String, Integer, Boolean, Long, Character, String> tuple : perm) {
			someExpecteds.remove(tuple);
		}

		assertTrue(someExpecteds.isEmpty());
	}

	/** Tests
	 * {@link final Tuple006Permutator#iterator()}
	 * for performance using random.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple006PermutatorRandom() {

		@SuppressWarnings({ "serial" })
		final Set<Tuple006<String, Integer, Boolean, Long, Character, String>> someExpecteds =
				new HashSet<Tuple006<String, Integer, Boolean, Long, Character, String>>() {{
					add(new Tuple006<String, Integer, Boolean, Long, Character, String>(null, null, null, null, null, null));
					add(new Tuple006<String, Integer, Boolean, Long, Character, String>("a" , null, null, null, null, null));
					add(new Tuple006<String, Integer, Boolean, Long, Character, String>(null,    1, null, null, null, null));
					add(new Tuple006<String, Integer, Boolean, Long, Character, String>(null, null, true, null, null, null));
					add(new Tuple006<String, Integer, Boolean, Long, Character, String>(null, null, null,  21L, null, null));
					add(new Tuple006<String, Integer, Boolean, Long, Character, String>(null, null, null, null,  'x', null));
					add(new Tuple006<String, Integer, Boolean, Long, Character, String>(null, null, null, null, null,  "p"));
					add(new Tuple006<String, Integer, Boolean, Long, Character, String>("a" ,    1, true,  21L,  'x',  "p"));
				}};

		final Tuple006Permutator<String, Integer, Boolean, Long, Character, String> perm =
			new Tuple006Permutator<String, Integer, Boolean, Long, Character, String>(
					  new String[]{null, "a"}
					, new Integer[]{null, 1}
					, new Boolean[]{null, true}
					, new Long[]{null, 21L}
					, new Character[]{null, 'x'}
					, new String[]{null, "p"}
					, new Random(29)
			);

		for (final Tuple006<String, Integer, Boolean, Long, Character, String> tuple : perm) {
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
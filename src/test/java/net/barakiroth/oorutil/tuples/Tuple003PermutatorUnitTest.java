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

/** Tests {@link Tuple003Permutator}.
 */
public class Tuple003PermutatorUnitTest {
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
		(Logger)LoggerFactory.getLogger(Tuple003PermutatorUnitTest.class);
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
	 * {@link final Tuple003Permutator#iterator()}
	 * for performance not using random.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple003PermutatorNoRandom() {

		@SuppressWarnings({ "serial" })
		final Set<Tuple003<String, Integer, Boolean>> someExpecteds =
				new HashSet<Tuple003<String, Integer, Boolean>>() {{
					add(new Tuple003<String, Integer, Boolean>(null, null, null));
					add(new Tuple003<String, Integer, Boolean>("a" , null, null));
					add(new Tuple003<String, Integer, Boolean>(null,    1, null));
					add(new Tuple003<String, Integer, Boolean>(null, null, true));
					add(new Tuple003<String, Integer, Boolean>("a" ,    1, true));
				}};

		final Tuple003Permutator<String, Integer, Boolean> perm =
			new Tuple003Permutator<String, Integer, Boolean>(
					  new String[]{null, "a"}
					, new Integer[]{null, 1}
					, new Boolean[]{null, true}
			);

		for (final Tuple003<String, Integer, Boolean> tuple : perm) {
			someExpecteds.remove(tuple);
		}

		assertTrue(someExpecteds.isEmpty());
	}

	/** Tests
	 * {@link final Tuple003Permutator#iterator()}
	 * for performance using random.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple003PermutatorRandom() {

		@SuppressWarnings({ "serial" })
		final Set<Tuple003<String, Integer, Boolean>> someExpecteds =
				new HashSet<Tuple003<String, Integer, Boolean>>() {{
					add(new Tuple003<String, Integer, Boolean>(null, null, null));
					add(new Tuple003<String, Integer, Boolean>("a" , null, null));
					add(new Tuple003<String, Integer, Boolean>(null,    1, null));
					add(new Tuple003<String, Integer, Boolean>(null, null, true));
					add(new Tuple003<String, Integer, Boolean>("a" ,    1, true));
				}};

		final Tuple003Permutator<String, Integer, Boolean> perm =
			new Tuple003Permutator<String, Integer, Boolean>(
					  new String[]{null, "a"}
					, new Integer[]{null, 1}
					, new Boolean[]{null, true}
					, new Random(29)
			);

		for (final Tuple003<String, Integer, Boolean> tuple : perm) {
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
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
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import ch.qos.logback.classic.Logger;
import net.barakiroth.oortestutil.IUnitTestCategory;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

/** Tests {@link Tuple001}.
 */
public class Tuple001UnitTest {
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
		(Logger)LoggerFactory.getLogger(Tuple001UnitTest.class);

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
	////
	//// END Methods
	//// =======================================================================
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

	/**
	 * Tests {@link Tuple001#equals(Object)}.
	 */
	@SuppressWarnings("unlikely-arg-type")
	@Test
	@Category({IUnitTestCategory.class})
	public final void testEquals_1() {

		final Tuple001<Integer> tuple1 = new Tuple001<Integer>(null);
		final Tuple001<Integer> tuple2 = new Tuple001<Integer>(null);
		final Tuple001<Integer> tuple3 = tuple1;

		assertEquals(1, tuple1.getSize());
		assertEquals(1, tuple2.getSize());
		assertEquals(1, tuple3.getSize());

		assertTrue(tuple1.equals(tuple1));
		assertTrue(tuple2.equals(tuple2));
		assertTrue(tuple3.equals(tuple3));
		assertTrue(tuple1.equals(tuple3));
		
		assertTrue(tuple1.equals(tuple2));
		assertTrue(tuple2.equals(tuple3));

		assertFalse(tuple1.equals(null));
		assertFalse(tuple2.equals(null));
		assertFalse(tuple3.equals(null));
		assertFalse(tuple1.equals("lknlnkln"));
		assertFalse(tuple2.equals("lknlnkln"));
		assertFalse(tuple3.equals("lknlnkln"));

		assertTrue(tuple1.isNullTuple());
		assertTrue(tuple2.isNullTuple());
		assertTrue(tuple3.isNullTuple());
	}

	/**
	 * Tests {@link Tuple001#equals(Object)}.
	 */
	@SuppressWarnings("unlikely-arg-type")
	@Test
	@Category({IUnitTestCategory.class})
	public final void testEquals_2() {

		final Tuple001<Integer> tuple1 = new Tuple001<Integer>(7);
		final Tuple001<Integer> tuple2 = new Tuple001<Integer>(7);
		final Tuple001<Integer> tuple3 = tuple1;

		assertEquals(1, tuple1.getSize());
		assertEquals(1, tuple2.getSize());
		assertEquals(1, tuple3.getSize());

		assertTrue(tuple1.equals(tuple1));
		assertTrue(tuple2.equals(tuple2));
		assertTrue(tuple3.equals(tuple3));
		assertTrue(tuple1.equals(tuple3));

		assertTrue(tuple1.equals(tuple2));
		assertTrue(tuple2.equals(tuple3));

		assertFalse(tuple1.equals(null));
		assertFalse(tuple2.equals(null));
		assertFalse(tuple3.equals(null));
		assertFalse(tuple1.equals("lknlnkln"));
		assertFalse(tuple2.equals("lknlnkln"));
		assertFalse(tuple3.equals("lknlnkln"));

		assertFalse(tuple1.isNullTuple());
		assertFalse(tuple2.isNullTuple());
		assertFalse(tuple3.isNullTuple());
	}

	/**
	 * Tests {@link Tuple001#getV001()}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testGet() {
		final Tuple001<Integer> tuple1 = new Tuple001<Integer>(7);
		assertEquals(1, tuple1.getSize());
		assertEquals(new Integer(7), tuple1.getV001());
	}

	/** Tests {@link Tuple001}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testConstructorWithNullParameter() {
		try {
			new Tuple001<Integer>(null, 7);
			fail("Expected exception not received");
		} catch (AssertionError e) {
			throw e;
		} catch (NullPointerException e) {
			// OK
		} catch (Throwable e) {
			fail("Erroneous exception received");
		}
	}

	/** Tests {@link Tuple001#toString()}. 
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testToString() {
		final Tuple001<Integer> tuple1 = new Tuple001<Integer>(7);
		final String str = tuple1.toString();
		assertNotNull(str);
	}

	/** Tests {@link Tuple001#nullTuple()}. 
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testNullTuple() {

		final Tuple001<String> nullTuple1 = Tuple001.nullTuple();
		assertNull(nullTuple1.getV001());
		assertNull(nullTuple1.getVN());
		
		final Tuple001<String> nullTuple2 = Tuple001.nullTuple();
		// Should be a singleton:
		assertSame(nullTuple1, nullTuple2);
		
		final Tuple001<String> nullTuple3 = new Tuple001<String>(null);
		assertEquals(nullTuple1, nullTuple3);
		assertEquals(nullTuple2, nullTuple3);
	}
}
/*
Revision history:
$Log:$
*/
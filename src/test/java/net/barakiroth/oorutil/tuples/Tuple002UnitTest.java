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

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import net.barakiroth.oortestutil.IUnitTestCategory;

/** Tests {@link Tuple002}.
 */
public class Tuple002UnitTest {
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
		(Logger)LoggerFactory.getLogger(Tuple002UnitTest.class);
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

	/** Tests {@link Tuple002#equals(Object)}
	 * for tuples of different sizes.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testEqualsDifferentSizes_1() {

		final Tuple001<String> tuple1 = new Tuple001<String>("Hei");

		final Tuple002<String, String> tuple2 =
			new Tuple002<String, String>("Hei", "på deg");
		
		assertEquals(1, tuple1.getSize());
		assertEquals(2, tuple2.getSize());

		assertTrue(tuple1.equals(tuple1));
		assertTrue(tuple2.equals(tuple2));

		assertFalse(tuple1.equals(tuple2));
		assertFalse(tuple2.equals(tuple1));

		assertFalse(tuple1.equals(null));
		assertFalse(tuple2.equals(null));
		assertFalse(tuple1.equals("lknlnkln"));
		assertFalse(tuple2.equals("lknlnkln"));

		assertFalse(tuple1.isNullTuple());
		assertFalse(tuple2.isNullTuple());
	}

	/** Tests {@link Tuple002#equals(Object)}
	 * for tuples of different sizes.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testEqualsDifferentSizes_2() {

		final Tuple001<String> tuple1 = new Tuple001<String>(null);

		final Tuple002<String, String> tuple2 =
			new Tuple002<String, String>("Hei", "på deg");
		
		assertEquals(1, tuple1.getSize());
		assertEquals(2, tuple2.getSize());

		assertTrue(tuple1.equals(tuple1));
		assertTrue(tuple2.equals(tuple2));

		assertFalse(tuple1.equals(tuple2));
		assertFalse(tuple2.equals(tuple1));

		assertFalse(tuple1.equals(null));
		assertFalse(tuple2.equals(null));
		assertFalse(tuple1.equals("lknlnkln"));
		assertFalse(tuple2.equals("lknlnkln"));

		assertTrue(tuple1.isNullTuple());
		assertFalse(tuple2.isNullTuple());
	}

	/** Tests {@link Tuple002#equals(Object)}
	 * for tuples of different sizes.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testEqualsDifferentSizes_3() {

		final Tuple001<String> tuple1 = new Tuple001<String>("Hei");

		final Tuple002<String, String> tuple2 =
			new Tuple002<String, String>((String)null, "på deg");
		
		assertEquals(1, tuple1.getSize());
		assertEquals(2, tuple2.getSize());

		assertTrue(tuple1.equals(tuple1));
		assertTrue(tuple2.equals(tuple2));

		assertFalse(tuple1.equals(tuple2));
		assertFalse(tuple2.equals(tuple1));

		assertFalse(tuple1.equals(null));
		assertFalse(tuple2.equals(null));
		assertFalse(tuple1.equals("lknlnkln"));
		assertFalse(tuple2.equals("lknlnkln"));

		assertFalse(tuple1.isNullTuple());
		assertFalse(tuple2.isNullTuple());
	}

	/** Tests {@link Tuple002#equals(Object)}
	 * for tuples of different sizes.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testEqualsDifferentSizes_4() {

		final Tuple001<String> tuple1 = new Tuple001<String>("Hei");

		final Tuple002<String, String> tuple2 =
			new Tuple002<String, String>("Hei", (String)null);
		
		assertEquals(1, tuple1.getSize());
		assertEquals(2, tuple2.getSize());

		assertTrue(tuple1.equals(tuple1));
		assertTrue(tuple2.equals(tuple2));

		assertFalse(tuple1.equals(tuple2));
		assertFalse(tuple2.equals(tuple1));

		assertFalse(tuple1.equals(null));
		assertFalse(tuple2.equals(null));
		assertFalse(tuple1.equals("lknlnkln"));
		assertFalse(tuple2.equals("lknlnkln"));

		assertFalse(tuple1.isNullTuple());
		assertFalse(tuple2.isNullTuple());
	}

	/** Tests {@link Tuple002#equals(Object)}
	 * for tuples of different sizes.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testEqualsDifferentSizes_5() {

		final Tuple001<String> tuple1 = new Tuple001<String>("Hei");

		final Tuple002<String, String> tuple2 =
			new Tuple002<String, String>((String)null, (String)null);
		
		assertEquals(1, tuple1.getSize());
		assertEquals(2, tuple2.getSize());

		assertTrue(tuple1.equals(tuple1));
		assertTrue(tuple2.equals(tuple2));

		assertFalse(tuple1.equals(tuple2));
		assertFalse(tuple2.equals(tuple1));

		assertFalse(tuple1.equals(null));
		assertFalse(tuple2.equals(null));
		assertFalse(tuple1.equals("lknlnkln"));
		assertFalse(tuple2.equals("lknlnkln"));

		assertFalse(tuple1.isNullTuple());
		assertTrue(tuple2.isNullTuple());
	}

	/** Tests {@link Tuple002#equals(Object)}
	 * for tuples of different sizes.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testEqualsDifferentSizes_6() {

		final Tuple001<String> tuple1 = new Tuple001<String>((String)null);

		final Tuple002<String, String> tuple2 =
			new Tuple002<String, String>((String)null, (String)null);
		
		assertEquals(1, tuple1.getSize());
		assertEquals(2, tuple2.getSize());

		assertTrue(tuple1.equals(tuple1));
		assertTrue(tuple2.equals(tuple2));

		assertFalse(tuple1.equals(tuple2));
		assertFalse(tuple2.equals(tuple1));

		assertFalse(tuple1.equals(null));
		assertFalse(tuple2.equals(null));
		assertFalse(tuple1.equals("lknlnkln"));
		assertFalse(tuple2.equals("lknlnkln"));

		assertTrue(tuple1.isNullTuple());
		assertTrue(tuple2.isNullTuple());
	}

	/** Tests {@link Tuple002#equals(Object)}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testEquals_1() {

		final Tuple002<String, Integer> tuple1 =
			new Tuple002<String, Integer>("Hei", (Integer)null);

		final Tuple002<String, Integer> tuple2 =
			new Tuple002<String, Integer>("Hei", (Integer)null);

		final Tuple002<String, Integer> tuple3 = tuple1;

		assertEquals(2, tuple1.getSize());
		assertEquals(2, tuple2.getSize());
		assertEquals(2, tuple3.getSize());

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

	/** Tests {@link Tuple002#equals(Object)}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testEquals_2() {

		final Tuple002<String, Integer> tuple1 =
			new Tuple002<String, Integer>((String)null, (Integer)null);

		final Tuple002<String, Integer> tuple2 =
			new Tuple002<String, Integer>((String)null, (Integer)null);

		final Tuple002<String, Integer> tuple3 = tuple1;

		assertEquals(2, tuple1.getSize());
		assertEquals(2, tuple2.getSize());
		assertEquals(2, tuple3.getSize());

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

	/** Tests {@link Tuple002#equals(Object)}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testEquals_3() {

		final Tuple002<String, Integer> tuple1 =
			new Tuple002<String, Integer>((String)null, 7);

		final Tuple002<String, Integer> tuple2 =
			new Tuple002<String, Integer>((String)null, 7);

		final Tuple002<String, Integer> tuple3 = tuple1;

		assertEquals(2, tuple1.getSize());
		assertEquals(2, tuple2.getSize());
		assertEquals(2, tuple3.getSize());

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

	/** Tests {@link Tuple002#equals(Object)}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testEquals_4() {

		final Tuple002<String, Integer> tuple1 =
			new Tuple002<String, Integer>("Hei", 7);

		final Tuple002<String, Integer> tuple2 =
			new Tuple002<String, Integer>("Hei", 7);

		final Tuple002<String, Integer> tuple3 = tuple1;

		assertEquals(2, tuple1.getSize());
		assertEquals(2, tuple2.getSize());
		assertEquals(2, tuple3.getSize());

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

	/** Tests {@link Tuple002#equals(Object)}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testEquals_5() {

		final Tuple002<String, Integer> tuple1 =
			new Tuple002<String, Integer>("Hei", 7);

		final Tuple002<String, Integer> tuple2 =
			new Tuple002<String, Integer>("Hei", 8);

		final Tuple002<String, Integer> tuple3 = tuple1;

		assertEquals(2, tuple1.getSize());
		assertEquals(2, tuple2.getSize());
		assertEquals(2, tuple3.getSize());

		assertTrue(tuple1.equals(tuple1));
		assertTrue(tuple2.equals(tuple2));
		assertTrue(tuple3.equals(tuple3));
		assertTrue(tuple1.equals(tuple3));

		assertFalse(tuple1.equals(tuple2));
		assertFalse(tuple2.equals(tuple3));

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

	/** Tests {@link Tuple002#equals(Object)}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testEquals_6() {

		final Tuple002<String, Integer> tuple1 =
			new Tuple002<String, Integer>("Heix", 7);

		final Tuple002<String, Integer> tuple2 =
			new Tuple002<String, Integer>("Hei", 7);

		final Tuple002<String, Integer> tuple3 = tuple1;

		assertEquals(2, tuple1.getSize());
		assertEquals(2, tuple2.getSize());
		assertEquals(2, tuple3.getSize());

		assertTrue(tuple1.equals(tuple1));
		assertTrue(tuple2.equals(tuple2));
		assertTrue(tuple3.equals(tuple3));
		assertTrue(tuple1.equals(tuple3));

		assertFalse(tuple1.equals(tuple2));
		assertFalse(tuple2.equals(tuple3));

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

	/** Tests {@link Tuple002#equals(Object)}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testEquals_7() {

		final Tuple002<String, Integer> tuple1 =
			new Tuple002<String, Integer>("Heix", 7);

		final Tuple002<String, Integer> tuple2 =
			new Tuple002<String, Integer>("Hei", 11);

		final Tuple002<String, Integer> tuple3 = tuple1;

		assertEquals(2, tuple1.getSize());
		assertEquals(2, tuple2.getSize());
		assertEquals(2, tuple3.getSize());

		assertTrue(tuple1.equals(tuple1));
		assertTrue(tuple2.equals(tuple2));
		assertTrue(tuple3.equals(tuple3));
		assertTrue(tuple1.equals(tuple3));

		assertFalse(tuple1.equals(tuple2));
		assertFalse(tuple2.equals(tuple3));

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

	/** Tests {@link Tuple002#equals(Object)}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testEquals_8() {

		final Tuple002<String, Integer> tuple1 =
			new Tuple002<String, Integer>("Hei", 7);

		final Tuple002<String, Integer> tuple2 =
			new Tuple002<String, Integer>("Hei", null);

		final Tuple002<String, Integer> tuple3 = tuple1;

		assertEquals(2, tuple1.getSize());
		assertEquals(2, tuple2.getSize());
		assertEquals(2, tuple3.getSize());

		assertTrue(tuple1.equals(tuple1));
		assertTrue(tuple2.equals(tuple2));
		assertTrue(tuple3.equals(tuple3));
		assertTrue(tuple1.equals(tuple3));

		assertFalse(tuple1.equals(tuple2));
		assertFalse(tuple2.equals(tuple3));

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

	/** Tests {@link Tuple002#equals(Object)}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testEquals_9() {

		final Tuple002<String, Integer> tuple1 =
			new Tuple002<String, Integer>("Hei", 7);

		final Tuple002<String, Integer> tuple2 =
			new Tuple002<String, Integer>((String)null, 7);

		final Tuple002<String, Integer> tuple3 = tuple1;

		assertEquals(2, tuple1.getSize());
		assertEquals(2, tuple2.getSize());
		assertEquals(2, tuple3.getSize());

		assertTrue(tuple1.equals(tuple1));
		assertTrue(tuple2.equals(tuple2));
		assertTrue(tuple3.equals(tuple3));
		assertTrue(tuple1.equals(tuple3));

		assertFalse(tuple1.equals(tuple2));
		assertFalse(tuple2.equals(tuple3));

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

	/** Tests {@link Tuple002#equals(Object)}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testEquals_10() {

		final Tuple002<String, Integer> tuple1 =
			new Tuple002<String, Integer>("Hei", null);

		final Tuple002<String, Integer> tuple2 =
			new Tuple002<String, Integer>("Hei", 7);

		final Tuple002<String, Integer> tuple3 = tuple1;

		assertEquals(2, tuple1.getSize());
		assertEquals(2, tuple2.getSize());
		assertEquals(2, tuple3.getSize());

		assertTrue(tuple1.equals(tuple1));
		assertTrue(tuple2.equals(tuple2));
		assertTrue(tuple3.equals(tuple3));
		assertTrue(tuple1.equals(tuple3));

		assertFalse(tuple1.equals(tuple2));
		assertFalse(tuple2.equals(tuple3));

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

	/** Tests {@link Tuple002#equals(Object)}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testEquals_11() {

		final Tuple002<String, Integer> tuple1 =
			new Tuple002<String, Integer>((String)null, 7);

		final Tuple002<String, Integer> tuple2 =
			new Tuple002<String, Integer>("Hei", 7);

		final Tuple002<String, Integer> tuple3 = tuple1;

		assertEquals(2, tuple1.getSize());
		assertEquals(2, tuple2.getSize());
		assertEquals(2, tuple3.getSize());

		assertTrue(tuple1.equals(tuple1));
		assertTrue(tuple2.equals(tuple2));
		assertTrue(tuple3.equals(tuple3));
		assertTrue(tuple1.equals(tuple3));

		assertFalse(tuple1.equals(tuple2));
		assertFalse(tuple2.equals(tuple3));

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

	/** Tests {@link Tuple002#equals(Object)}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testEquals_12() {

		final Tuple002<String, Integer> tuple1 =
			new Tuple002<String, Integer>((String)null, (Integer)null);

		final Tuple002<String, Integer> tuple2 =
			new Tuple002<String, Integer>("Hei", 7);

		final Tuple002<String, Integer> tuple3 = tuple1;

		assertEquals(2, tuple1.getSize());
		assertEquals(2, tuple2.getSize());
		assertEquals(2, tuple3.getSize());

		assertTrue(tuple1.equals(tuple1));
		assertTrue(tuple2.equals(tuple2));
		assertTrue(tuple3.equals(tuple3));
		assertTrue(tuple1.equals(tuple3));

		assertFalse(tuple1.equals(tuple2));
		assertFalse(tuple2.equals(tuple3));

		assertFalse(tuple1.equals(null));
		assertFalse(tuple2.equals(null));
		assertFalse(tuple3.equals(null));
		assertFalse(tuple1.equals("lknlnkln"));
		assertFalse(tuple2.equals("lknlnkln"));
		assertFalse(tuple3.equals("lknlnkln"));

		assertTrue(tuple1.isNullTuple());
		assertFalse(tuple2.isNullTuple());
		assertTrue(tuple3.isNullTuple());
	}

	/** Tests {@link Tuple002#equals(Object)}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testEquals_13() {
		
		final Tuple002<String, Integer> tuple1 =
			new Tuple002<String, Integer>("Hei", 7);

		final Tuple002<String, Integer> tuple2 =
			new Tuple002<String, Integer>((String)null, (Integer)null);

		final Tuple002<String, Integer> tuple3 = tuple1;

		assertEquals(2, tuple1.getSize());
		assertEquals(2, tuple2.getSize());
		assertEquals(2, tuple3.getSize());

		assertTrue(tuple1.equals(tuple1));
		assertTrue(tuple2.equals(tuple2));
		assertTrue(tuple3.equals(tuple3));
		assertTrue(tuple1.equals(tuple3));

		assertFalse(tuple1.equals(tuple2));
		assertFalse(tuple2.equals(tuple3));

		assertFalse(tuple1.equals(null));
		assertFalse(tuple2.equals(null));
		assertFalse(tuple3.equals(null));
		assertFalse(tuple1.equals("lknlnkln"));
		assertFalse(tuple2.equals("lknlnkln"));
		assertFalse(tuple3.equals("lknlnkln"));

		assertFalse(tuple1.isNullTuple());
		assertTrue(tuple2.isNullTuple());
		assertFalse(tuple3.isNullTuple());
	}

	/** Tests
	 * {@link Tuple002#nullTuple()}
	 * and
	 * {@link Tuple002#isNullTuple()}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testNullTuple() {

		final Tuple002<String, Integer> nullTuple1 =
				new Tuple002<String, Integer>((String)null, (Integer)null);

		final Tuple002<String, Integer> nullTuple2 = Tuple002.nullTuple();

		assertEquals(nullTuple1, nullTuple2);

		assertNull(nullTuple1.getV001());
		assertNull(nullTuple1.getV002());
		assertTrue(nullTuple1.isNullTuple());

		assertNull(nullTuple2.getV001());
		assertNull(nullTuple2.getV002());
		assertTrue(nullTuple2.isNullTuple());

		// Again, because of potential laziness:

		assertEquals(nullTuple1, nullTuple2);

		assertNull(nullTuple1.getV001());
		assertNull(nullTuple1.getV002());
		assertTrue(nullTuple1.isNullTuple());

		assertNull(nullTuple2.getV001());
		assertNull(nullTuple2.getV002());
		assertTrue(nullTuple2.isNullTuple());
	}

	/** Tests {@link Tuple002#nullTuple()}. 
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testNullTuple_2() {

		final Tuple002<String, String> nullTuple1 =
				Tuple002.nullTuple();
		assertNull(nullTuple1.getV001());
		assertNull(nullTuple1.getV002());
		assertNull(nullTuple1.getVN());
		
		final Tuple002<String, String> nullTuple2 =
				Tuple002.nullTuple();
		// Should be a singleton:
		assertSame(nullTuple1, nullTuple2);
		
		final Tuple002<String, String> nullTuple3 =
				new Tuple002<String, String>((String)null, (String)null);
		assertEquals(nullTuple1, nullTuple3);
		assertEquals(nullTuple2, nullTuple3);
	}

	/** Tests {@link Tuple001#toString()}. 
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testToString() {

		final Tuple002<String, Integer> tuple =
			new Tuple002<String, Integer>("Hei", 7);
		final String str = tuple.toString();

		assertNotNull(str);
	}
	////
	//// END Methods
	//// =======================================================================
}
/*
Revision history:
$Log:$
*/
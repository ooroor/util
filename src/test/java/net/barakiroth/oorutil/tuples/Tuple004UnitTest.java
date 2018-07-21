// Copyright (C) 2014 barakiroth.net
// All rights reserved
/**
 * 
 */
package net.barakiroth.oorutil.tuples;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import net.barakiroth.oortestutil.IUnitTestCategory;

/** Tests {@link Tuple004}.
 */
public class Tuple004UnitTest {
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
		(Logger)LoggerFactory.getLogger(Tuple004UnitTest.class);
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
	 * {@link Tuple004#getV001()},
	 * {@link Tuple004#getV002()},
	 * {@link Tuple004#getV003()},
	 * {@link Tuple004#getV004()},
	 * {@link Tuple004#equals(Object)}
	 * and
	 * {@link Tuple004#hashCode()}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple004() {

		final String expectedV1 = "ABC";
		final Boolean expectedV2 = true;
		final String expectedV3 = "DEF nskldc s";
		final Integer expectedV4 = 117;

		final Tuple004<String, Boolean, String, Integer> tuple004V1 =
			new Tuple004<String, Boolean, String, Integer>(expectedV1, expectedV2, expectedV3, expectedV4);

		final Tuple004<String, Boolean, String, Integer> tuple004V2 =
			new Tuple004<String, Boolean, String, Integer>(expectedV1, expectedV2, expectedV3, expectedV4);

		final Tuple004<String, Boolean, String, Integer> tuple004V3 =
				new Tuple004<String, Boolean, String, Integer>(expectedV1, expectedV2, expectedV3, -1);

		final Tuple003<String, Boolean, String> tuple003V4 =
				new Tuple003<String, Boolean, String>(expectedV1, expectedV2, expectedV3);		

		final Tuple004<String, Boolean, String, Integer> tuple004V5 =
				new Tuple004<String, Boolean, String, Integer>(expectedV1, expectedV2, null, null);

		final Tuple003<String, Boolean, String> tuple003V6 =
				new Tuple003<String, Boolean, String>(expectedV1, expectedV2, null);

		final String actualV1 = tuple004V1.getV001();
		final Boolean actualV2 = tuple004V1.getV002();
		final String actualV3 = tuple004V1.getV003();
		final Integer actualV4 = tuple004V1.getV004();

		assertEquals(expectedV1, actualV1);
		assertEquals(expectedV2, actualV2);
		assertEquals(expectedV3, actualV3);
		assertEquals(expectedV4, actualV4);

		assertEquals(tuple004V1, tuple004V1);
		assertEquals(tuple004V1.hashCode(), tuple004V1.hashCode());
		assertEquals(tuple004V2, tuple004V2);
		assertEquals(tuple004V2.hashCode(), tuple004V2.hashCode());
		assertEquals(tuple004V3, tuple004V3);
		assertEquals(tuple004V3.hashCode(), tuple004V3.hashCode());
		assertEquals(tuple003V4, tuple003V4);
		assertEquals(tuple003V4.hashCode(), tuple003V4.hashCode());
		assertEquals(tuple004V5, tuple004V5);
		assertEquals(tuple004V5.hashCode(), tuple004V5.hashCode());
		assertEquals(tuple003V6, tuple003V6);
		assertEquals(tuple003V6.hashCode(), tuple003V6.hashCode());

		assertEquals(tuple004V1, tuple004V2);
		assertEquals(tuple004V1.hashCode(), tuple004V2.hashCode());
		assertNotEquals(tuple004V1, tuple004V3);
		assertNotEquals(tuple004V1.hashCode(), tuple004V3.hashCode());
		assertNotEquals(tuple004V1, tuple003V4);
		assertNotEquals(tuple004V1.hashCode(), tuple003V4.hashCode());
		assertNotEquals(tuple004V5, tuple003V6);
		assertNotEquals(tuple004V5.hashCode(), tuple003V6.hashCode());
	}

	/** Tests {@link Tuple004#nullTuple()}. 
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testNullTuple() {

		final Tuple004<String, String, String, String> nullTuple1 = Tuple004.nullTuple();
		assertNull(nullTuple1.getV001());
		assertNull(nullTuple1.getV002());
		assertNull(nullTuple1.getV003());
		assertNull(nullTuple1.getV004());
		assertNull(nullTuple1.getVN());
		
		final Tuple004<String, String, String, String> nullTuple2 = Tuple004.nullTuple();
		// Should be a singleton:
		assertSame(nullTuple1, nullTuple2);
		
		final Tuple004<String, String, String, String> nullTuple3 =
				new Tuple004<String, String, String, String>(null, null, null, null);
		assertEquals(nullTuple1, nullTuple3);
		assertEquals(nullTuple2, nullTuple3);
	}
	////
	//// END Methods
	//// =======================================================================
}
/*
Revision history:
$Log:$
*/
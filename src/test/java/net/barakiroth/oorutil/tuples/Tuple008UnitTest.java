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

/** Tests {@link Tuple008}.
 */
public class Tuple008UnitTest {
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
		(Logger)LoggerFactory.getLogger(Tuple008UnitTest.class);
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

	/** Tests {@link Tuple008#getV001()},
	 * {@link Tuple008#getV002()},
	 * {@link Tuple008#getV003()},
	 * {@link Tuple008#getV004()},
	 * {@link Tuple008#getV005()},
	 * {@link Tuple008#getV006()},
	 * {@link Tuple008#getV007()},
	 * {@link Tuple008#getV008()},
	 * {@link Tuple008#equals(Object)}
	 * and
	 * {@link Tuple008#hashCode()}.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testTuple008() {

		final String expectedV1 = "ABC";
		final Boolean expectedV2 = true;
		final String expectedV3 = "DEF nskldc s";
		final Integer expectedV4 = 117;
		final String expectedV5 = "    ";
		final String expectedV6 = "  x  ";
		final String expectedV7 = " Goodbye abc x  ";
		final String expectedV8 = " Hello abc x  ";

		final Tuple008<String, Boolean, String, Integer, String, String, String, String> tuple004V1 =
			new Tuple008<String, Boolean, String, Integer, String, String, String, String>(expectedV1, expectedV2, expectedV3, expectedV4, expectedV5, expectedV6, expectedV7, expectedV8);

		final Tuple008<String, Boolean, String, Integer, String, String, String, String> tuple004V2 =
				new Tuple008<String, Boolean, String, Integer, String, String, String, String>(expectedV1, expectedV2, expectedV3, expectedV4, expectedV5, expectedV6, expectedV7, expectedV8);

		final Tuple008<String, Boolean, String, Integer, String, String, String, String> tuple004V3 =
				new Tuple008<String, Boolean, String, Integer, String, String, String, String>(expectedV1, expectedV2, expectedV3, -1, expectedV5, expectedV6, expectedV7, expectedV8);

		final Tuple007<String, Boolean, String, Integer, String, String, String> tuple003V4 =
				new Tuple007<String, Boolean, String, Integer, String, String, String>(expectedV1, expectedV2, expectedV3, expectedV4, expectedV5, expectedV6, expectedV7);		

		final Tuple008<String, Boolean, String, Integer, String, String, String, String> tuple004V5 =
				new Tuple008<String, Boolean, String, Integer, String, String, String, String>(expectedV1, expectedV2, expectedV3, expectedV4, expectedV5, expectedV6, null, null);

		final Tuple007<String, Boolean, String, Integer, String, String, String> tuple003V6 =
				new Tuple007<String, Boolean, String, Integer, String, String, String>(expectedV1, expectedV2, expectedV3, expectedV4, expectedV5, expectedV6, null);

		final String actualV1 = tuple004V1.getV001();
		final Boolean actualV2 = tuple004V1.getV002();
		final String actualV3 = tuple004V1.getV003();
		final Integer actualV4 = tuple004V1.getV004();
		final String actualV5 = tuple004V1.getV005();
		final String actualV6 = tuple004V1.getV006();
		final String actualV7 = tuple004V1.getV007();
		final String actualV8 = tuple004V1.getV008();

		assertEquals(expectedV1, actualV1);
		assertEquals(expectedV2, actualV2);
		assertEquals(expectedV3, actualV3);
		assertEquals(expectedV4, actualV4);
		assertEquals(expectedV5, actualV5);
		assertEquals(expectedV6, actualV6);
		assertEquals(expectedV7, actualV7);
		assertEquals(expectedV8, actualV8);

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

	/** Tests {@link Tuple008#nullTuple()}. 
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testNullTuple() {

		final Tuple008<String, String, String, String, String, String, String, String> nullTuple1 =
				Tuple008.nullTuple();
		assertNull(nullTuple1.getV001());
		assertNull(nullTuple1.getV002());
		assertNull(nullTuple1.getV003());
		assertNull(nullTuple1.getV004());
		assertNull(nullTuple1.getV005());
		assertNull(nullTuple1.getV006());
		assertNull(nullTuple1.getV007());
		assertNull(nullTuple1.getV008());
		assertNull(nullTuple1.getVN());
		
		final Tuple008<String, String, String, String, String, String, String, String> nullTuple2 =
				Tuple008.nullTuple();
		// Should be a singleton:
		assertSame(nullTuple1, nullTuple2);
		
		final Tuple008<String, String, String, String, String, String, String, String> nullTuple3 =
				new Tuple008<String, String, String, String, String, String, String, String>(null, null, null, null, null, null, null, null);
		assertEquals(nullTuple1, nullTuple3);
		assertEquals(nullTuple2, nullTuple3);
	}
}
/*
Revision history:
$Log:$
*/
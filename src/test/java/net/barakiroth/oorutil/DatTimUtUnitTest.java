// Copyright (C) 2014 barakiroth.net
// All rights reserved
/**
 * 
 */
package net.barakiroth.oorutil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Calendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/** Tests {@link DatTimUt}.
 */
public class DatTimUtUnitTest {
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
	/** @throws java.lang.Exception if something unexpected occurs
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/** @throws java.lang.Exception if something unexpected occurs
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
	// =========================================================================

	/**
	 * @throws java.lang.Exception if something unexpected occurs
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception if something unexpected occurs
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	// =========================================================================

	/**
	 * Test method for
	 * {@link net.barakiroth.util.DatTimUt#convLocDatToUtDat(java.time.LocalDate)}.
	 */
	@Test
	public final void testConvertLocalDateToJavaUtilDate() {
		
		assertNull(DatTimUt.convLocDatToUtDat(null));
		
		final LocalDate localDate =
				LocalDate.of(1956, Month.DECEMBER, 19);
		final java.util.Date actualDate =
				DatTimUt.convLocDatToUtDat(localDate);
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(1956, 11, 19);
		final java.util.Date expectedDate = calendar.getTime();
		assertEquals(expectedDate, actualDate);
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.DatTimUt#convLocDatToTS(java.time.LocalDate)}.
	 */
	@Test
	public final void testConvertLocalDateToTimestamp() {
		
		assertNull(DatTimUt.convLocDatToTS(null));
		
		final LocalDate localDate =
				LocalDate.of(1956, Month.DECEMBER, 19);
		final java.util.Date actualDate =
				DatTimUt.convLocDatToTS(localDate);
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(1956, 11, 19);
		final java.util.Date expectedDate = calendar.getTime();
		assertEquals(expectedDate, actualDate);
	}

	/**
	 * Test method for {@link net.barakiroth.util.DatTimUt#convLocDatTimToUtDat(java.time.LocalDateTime)}.
	 */
	@Test
	public final void testConvertLocalDateTimeToJavaUtilDateTime() {
		
		assertNull(DatTimUt.convLocDatTimToUtDat(null));
		
		final LocalDateTime localDateTime =
				LocalDateTime.of(1956, Month.DECEMBER, 19, 13, 37, 23);
		final java.util.Date actualDate =
				DatTimUt.convLocDatTimToUtDat(localDateTime);
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(1956, 11, 19, 13, 37, 23);
		final java.util.Date expectedDate = calendar.getTime();
		assertEquals(expectedDate, actualDate);
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.DatTimUt#convLocDatTimToTS(java.time.LocalDateTime)}.
	 */
	@Test
	public final void testConvertLocalDateTimeToTimestamp() {
		
		assertNull(DatTimUt.convLocDatTimToTS(null));
		
		final LocalDateTime localDateTime =
				LocalDateTime.of(1956, Month.DECEMBER, 19, 13, 37, 23);
		final Timestamp actualTimestamp =
				DatTimUt.convLocDatTimToTS(localDateTime);
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(1956, 11, 19, 13, 37, 23);
		final Timestamp expectedTimestamp = Timestamp.valueOf(localDateTime);
		assertEquals(expectedTimestamp, actualTimestamp);
	}
	
	// =========================================================================

	/**
	 * Test method for {@link net.barakiroth.util.DatTimUt#convUtDatToLocDat(java.util.Date)}.
	 */
	@Test
	public final void testConvertJavaUtilDateToLocalDate() {
		
		assertNull(DatTimUt.convUtDatToLocDat(null));
		
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(1956, 11, 19);
		final java.util.Date date = calendar.getTime();
		final LocalDate actualLocalDate =
				DatTimUt.convUtDatToLocDat(date);
		final LocalDate expectedLocalDate =
				LocalDate.of(1956, Month.DECEMBER, 19);
		assertEquals(expectedLocalDate, actualLocalDate);
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.DatTimUt#convUtDatToLocDatTim(java.util.Date)}.
	 */
	@Test
	public final void testConvertJavaUtilDateToLocalDateTime() {
		
		assertNull(DatTimUt.convUtDatToLocDatTim(null));
		
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(1956, 11, 19, 13, 14, 15);
		final java.util.Date date = calendar.getTime();
		final LocalDateTime actualLocalDateTime =
				DatTimUt.convUtDatToLocDatTim(date);
		final LocalDateTime expectedLocalDateTime =
				LocalDateTime.of(1956, Month.DECEMBER, 19, 13, 14, 15);
		assertEquals(expectedLocalDateTime, actualLocalDateTime);
	}

	/**
	 * Test method for {@link net.barakiroth.util.DatTimUt#convTSToLocDat(java.sql.Timestamp)}.
	 */
	@Test
	public final void testConvertTimestampToLocalDate() {
		
		assertNull(DatTimUt.convTSToLocDat(null));
		
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(1956, 11, 19);
		final Timestamp timestamp =  new Timestamp(calendar.getTimeInMillis());
		final LocalDate actualLocalDate =
				DatTimUt.convTSToLocDat(timestamp);
		final LocalDate expectedLocalDate =
				LocalDate.of(1956, Month.DECEMBER, 19);
		assertEquals(expectedLocalDate, actualLocalDate);
	}

	/**
	 * Test method for {@link net.barakiroth.util.DatTimUt#convTSToLocDatTim(java.sql.Timestamp)}.
	 */
	@Test
	public final void testConvertTimestampToLocalDateTime() {
		
		assertNull(DatTimUt.convTSToLocDatTim(null));
		
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(1956, 11, 19, 11, 13, 17);
		final Timestamp timestamp =  new Timestamp(calendar.getTimeInMillis());
		final LocalDateTime actualLocalDateTime =
				DatTimUt.convTSToLocDatTim(timestamp);
		final LocalDateTime expectedLocalDateTime =
				LocalDateTime.of(1956, Month.DECEMBER, 19, 11, 13, 17);
		assertEquals(expectedLocalDateTime, actualLocalDateTime);
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.DatTimUt#DatTimUt()}.
	 * Mostly to satisfy Jacoco.
	 */
	@Test
	public final void testDatTimUt() {
		assertNotNull(new DatTimUt());
	}
	////
	//// END Methods
	//// =======================================================================
}
/*
Revision history:
$Log:$
*/
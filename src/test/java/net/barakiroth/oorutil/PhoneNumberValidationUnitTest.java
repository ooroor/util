// Copyright (C) 2014 barakiroth.net
// All rights reserved
package net.barakiroth.oorutil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import net.barakiroth.oortestutil.IUnitTestCategory;
import net.barakiroth.oorutil.PhoneNumber.PhoneNoValRes;
import net.barakiroth.oorutil.tuples.Tuple002;
import net.barakiroth.oorutil.tuples.Tuple003;
import net.barakiroth.oorutil.tuples.Tuple004;

/**
 * Tests {@link net.barakiroth.util.PhonUt}.
 */
public class PhoneNumberValidationUnitTest {
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
	/** @throws java.lang.Exception If something unexpected occurs.
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/** @throws java.lang.Exception If something unexpected occurs.
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/** @throws java.lang.Exception If something unexpected occurs.
	 */
	@Before
	public void setUp() throws Exception {
	}

	/** @throws java.lang.Exception If something unexpected occurs.
	 */
	@After
	public void tearDown() throws Exception {
	}
	
	//// =======================================================================

	/**
	 * Test method for
	 * {@link net.barakiroth.util.PhonUt#parseAndValidatePhoneNumber(java.lang.String, java.lang.String)}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testParseAndValidatePhoneNumber() {

		@SuppressWarnings("serial")
		final List<Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>> testDataAndExpecteds =
				new ArrayList<Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>>() {{
					// ---------------------------------------------------------
					/* 1*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>("47" , "99213907"      , new Tuple004<String, String, String, PhoneNoValRes>("47",  null, "99213907"  , PhoneNoValRes.OK_USINGDEF)));
					/* 2*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>("47" , "4799213907"    , new Tuple004<String, String, String, PhoneNoValRes>("47",  null, "99213907"  , PhoneNoValRes.OK_NOTUSINGDEF)));
					/* 3*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>(null , "4799213907"    , new Tuple004<String, String, String, PhoneNoValRes>("47",  null, "99213907"  , PhoneNoValRes.OK_NOTUSINGDEF)));
					/* 4*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>(null , "99213907"      , new Tuple004<String, String, String, PhoneNoValRes>(null,  null, null        , PhoneNoValRes.INVALID)));
					/* 5*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>("47" , "12345678901"   , new Tuple004<String, String, String, PhoneNoValRes>("1" , "234", "5678901"   , PhoneNoValRes.OK_NOTUSINGDEF)));
					/* 6*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>("1"  , "2345678901"    , new Tuple004<String, String, String, PhoneNoValRes>(null,  null, null        , PhoneNoValRes.INVALID)));
					/* 7*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>("1"  , "12345678901"   , new Tuple004<String, String, String, PhoneNoValRes>("1",  "234", "5678901"   , PhoneNoValRes.OK_NOTUSINGDEF)));
					/* 8*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>(null , "12345678901"   , new Tuple004<String, String, String, PhoneNoValRes>("1",  "234", "5678901"   , PhoneNoValRes.OK_NOTUSINGDEF)));
					/* 9*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>("46" , "123456789"     , new Tuple004<String, String, String, PhoneNoValRes>("46",  null, "123456789" , PhoneNoValRes.OK_USINGDEF)));
					/*10*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>("46" , "1234567890"    , new Tuple004<String, String, String, PhoneNoValRes>("46",  null, "1234567890", PhoneNoValRes.OK_USINGDEF)));
					/*11*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>("46" , "12345678"      , new Tuple004<String, String, String, PhoneNoValRes>(null,  null, null        , PhoneNoValRes.INVALID)));
					/*12*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>("46" , "12345678901"   , new Tuple004<String, String, String, PhoneNoValRes>("1",  "234", "5678901"   , PhoneNoValRes.OK_NOTUSINGDEF)));
					/*13*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>(null , "461234567890"  , new Tuple004<String, String, String, PhoneNoValRes>("46",  null, "1234567890", PhoneNoValRes.OK_NOTUSINGDEF)));
					/*14*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>(null , "46123456789"   , new Tuple004<String, String, String, PhoneNoValRes>("46",  null, "123456789" , PhoneNoValRes.OK_NOTUSINGDEF)));
					/*15*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>(null , "4612345678"    , new Tuple004<String, String, String, PhoneNoValRes>(null,  null, null        , PhoneNoValRes.INVALID)));
					/*16*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>(null , "4612345678901" , new Tuple004<String, String, String, PhoneNoValRes>(null,  null, null        , PhoneNoValRes.INVALID)));
					/*17*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>("251", "12345"         , new Tuple004<String, String, String, PhoneNoValRes>(null,  null, null        , PhoneNoValRes.INVALID)));
					/*18*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>("47" , "251123456789"  , new Tuple004<String, String, String, PhoneNoValRes>("251", "12", "3456789"   , PhoneNoValRes.OK_NOTUSINGDEF)));
					/*19*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>(null , "251123456789"  , new Tuple004<String, String, String, PhoneNoValRes>("251", "12", "3456789"   , PhoneNoValRes.OK_NOTUSINGDEF)));
					/*20*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>(null , "251"           , new Tuple004<String, String, String, PhoneNoValRes>(null,  null, null        , PhoneNoValRes.INVALID)));
					/*21*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>(null , "2511"          , new Tuple004<String, String, String, PhoneNoValRes>(null,  null, null        , PhoneNoValRes.INVALID)));
					/*22*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>(null , "2511234567890" , new Tuple004<String, String, String, PhoneNoValRes>(null,  null, null        , PhoneNoValRes.INVALID)));
					/*23*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>("132", "12345678901"   , new Tuple004<String, String, String, PhoneNoValRes>("1",  "234", "5678901"   , PhoneNoValRes.OK_NOTUSINGDEF)));
					/*24*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>(null , "77712345678901", new Tuple004<String, String, String, PhoneNoValRes>(null,  null, null        , PhoneNoValRes.INVALID)));
					/*25*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>(null , null            , new Tuple004<String, String, String, PhoneNoValRes>(null,  null, null        , PhoneNoValRes.INVALID)));
					// ---------------------------------------------------------
					/*26*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>("993",  "993097393", new Tuple004<String, String, String, PhoneNoValRes>("993", null, "097393"   , PhoneNoValRes.OK_NOTUSINGDEF)));
					/*27*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>(null ,  "993097393", new Tuple004<String, String, String, PhoneNoValRes>("993", null, "097393", PhoneNoValRes.OK_NOTUSINGDEF)));
					/*28*/ add(new Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>>("47" ,  "993097393", new Tuple004<String, String, String, PhoneNoValRes>("993", null, "097393", PhoneNoValRes.OK_NOTUSINGDEF)));
					// ---------------------------------------------------------
				}};

		int cnt = 0;
		for (final Tuple003<String, String, Tuple004<String, String, String, PhoneNoValRes>> testDataAndExpected : testDataAndExpecteds) {
			cnt++;
			
			final String defaultCountryCode = testDataAndExpected.getV001();
			final String defaultAreaCode = null;
			final String rawPhoneNumber = testDataAndExpected.getV002();
			final Tuple004<String, String, String, PhoneNoValRes> expected = testDataAndExpected.getV003();
			final Tuple004<String, String, String, PhoneNoValRes> actual =
				PhoneNumber.parseAndValidatePhoneNumber(defaultCountryCode, defaultAreaCode, rawPhoneNumber);

			assertEquals("cnt: " + cnt, expected, actual);
		}
	}

	/** Test method for
	 * {@link net.barakiroth.util.PhonUt#parseAndValidatePhoneNumber(String, String, String))}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testParseAndValidatePhoneNumber_2() {

		@SuppressWarnings("serial")
		final List<Tuple004<String, String, String, PhoneNoValRes>> testDataAndExpectedResults =
			new ArrayList<Tuple004<String, String, String, PhoneNoValRes>>() {{

				add(new Tuple004<String, String, String, PhoneNoValRes>("1"    , "833",   "123456", PhoneNoValRes.INVALID));
				add(new Tuple004<String, String, String, PhoneNoValRes>("1"    , "833",  "1234567", PhoneNoValRes.OK_USINGDEF));
				add(new Tuple004<String, String, String, PhoneNoValRes>("1"    , "833", "12345678", PhoneNoValRes.INVALID));
				add(new Tuple004<String, String, String, PhoneNoValRes>("1"    , "83" , "31234567", PhoneNoValRes.INVALID));
				add(new Tuple004<String, String, String, PhoneNoValRes>(null   , "833",  "1234567", PhoneNoValRes.INVALID));
				add(new Tuple004<String, String, String, PhoneNoValRes>(null   , "833", "12345678", PhoneNoValRes.INVALID));
				add(new Tuple004<String, String, String, PhoneNoValRes>("1"    , "833",       null, PhoneNoValRes.INVALID));
				add(new Tuple004<String, String, String, PhoneNoValRes>(null   , "833",       null, PhoneNoValRes.INVALID));
				add(new Tuple004<String, String, String, PhoneNoValRes>(null   ,  null,       null, PhoneNoValRes.INVALID));
				add(new Tuple004<String, String, String, PhoneNoValRes>("993"  ,  null,       null, PhoneNoValRes.INVALID));
				add(new Tuple004<String, String, String, PhoneNoValRes>("00993",  null,       null, PhoneNoValRes.INVALID));
				add(new Tuple004<String, String, String, PhoneNoValRes>("993"  ,  null,   "097393", PhoneNoValRes.OK_USINGDEF));			 			
				 /*
				  * OK, but fail on equals
				  * add(new Tuple004<String, String, String, PhoneNoValRes>("993",  "34", "993097393", PhoneNoValRes.OK_NOTUSINGDEF));
				  * add(new Tuple004<String, String, String, PhoneNoValRes>("993",  null, "993097393", PhoneNoValRes.OK_NOTUSINGDEF));
				  * add(new Tuple004<String, String, String, PhoneNoValRes>(null ,  null, "993097393", PhoneNoValRes.OK_NOTUSINGDEF));
				  * add(new Tuple004<String, String, String, PhoneNoValRes>(null ,  "34", "993097393", PhoneNoValRes.OK_NOTUSINGDEF));
				  * add(new Tuple004<String, String, String, PhoneNoValRes>("47" ,  null, "993097393", PhoneNoValRes.OK_NOTUSINGDEF));
*/
		}};

		int turn = 0;
		for (final Tuple004<String, String, String, PhoneNoValRes> testDataAndExpectedResult : testDataAndExpectedResults) {
			turn++;
			final String        defaultCountryCode    = testDataAndExpectedResult.getV001();
			final String        defaultAreaCode       = testDataAndExpectedResult.getV002();
			final String        rawPhoneNumber        = testDataAndExpectedResult.getV003();
			final PhoneNoValRes expectedPhoneNoValRes = testDataAndExpectedResult.getV004();
			final Tuple004<String, String, String, PhoneNoValRes> res =
				PhoneNumber.parseAndValidatePhoneNumber(defaultCountryCode, defaultAreaCode, rawPhoneNumber);
			final PhoneNoValRes actualPhoneNoValRes = res.getV004();
			assertEquals(
				  "turn              : " + turn
				+ System.lineSeparator()
				+ "defaultCountryCode: " + defaultCountryCode
				+ System.lineSeparator()
				+ "defaultAreaCode   : " + defaultAreaCode
				+ System.lineSeparator()
				+ "rawPhoneNumber    : " + rawPhoneNumber
				+ System.lineSeparator()
				, expectedPhoneNoValRes, actualPhoneNoValRes);
			if (expectedPhoneNoValRes.equals(PhoneNoValRes.INVALID)) {
				assertNull(res.getV001());
				assertNull(res.getV002());
				assertNull(res.getV003());
			} else {
				assertEquals(defaultCountryCode, res.getV001());
				assertEquals(defaultAreaCode   , res.getV002());
				assertEquals(rawPhoneNumber    , res.getV003());
			}
		}
	}

	/** Test method for
	 * {@link net.barakiroth.util.PhonUt#validateStrict(String, String, String)))}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testValidateStrict() {

		@SuppressWarnings("serial")
		final List<Tuple004<String, String, String, PhoneNoValRes>> testDataAndExpectedResults =
			new ArrayList<Tuple004<String, String, String, PhoneNoValRes>>() {{
				add(new Tuple004<String, String, String, PhoneNoValRes>("1" , "833",   "123456", PhoneNoValRes.INVALID));
				add(new Tuple004<String, String, String, PhoneNoValRes>("1" , "833",  "1234567", PhoneNoValRes.OK_USINGDEF));
				add(new Tuple004<String, String, String, PhoneNoValRes>("1" , "833", "12345678", PhoneNoValRes.INVALID));
				add(new Tuple004<String, String, String, PhoneNoValRes>("1" ,  "83", "31234567", PhoneNoValRes.INVALID));
				add(new Tuple004<String, String, String, PhoneNoValRes>(null, "833",  "1234567", PhoneNoValRes.INVALID));
				add(new Tuple004<String, String, String, PhoneNoValRes>(null, "833", "12345678", PhoneNoValRes.INVALID));
				add(new Tuple004<String, String, String, PhoneNoValRes>("1" , "833",       null, PhoneNoValRes.INVALID));
				add(new Tuple004<String, String, String, PhoneNoValRes>(null, "833",       null, PhoneNoValRes.INVALID));
				add(new Tuple004<String, String, String, PhoneNoValRes>(null,  null,       null, PhoneNoValRes.INVALID));
				add(new Tuple004<String, String, String, PhoneNoValRes>("993",  null, "993097393", PhoneNoValRes.INVALID));
				add(new Tuple004<String, String, String, PhoneNoValRes>(null ,  "34", "993097393", PhoneNoValRes.INVALID));
				add(new Tuple004<String, String, String, PhoneNoValRes>(null ,  null, "993097393", PhoneNoValRes.INVALID));
				add(new Tuple004<String, String, String, PhoneNoValRes>(null ,  null, "097393", PhoneNoValRes.INVALID));
				add(new Tuple004<String, String, String, PhoneNoValRes>("993",  null, "097393", PhoneNoValRes.OK_USINGDEF));
		}};

		for (final Tuple004<String, String, String, PhoneNoValRes> testDataAndExpectedResult : testDataAndExpectedResults) {

			final String        defaultCountryCode    = testDataAndExpectedResult.getV001();
			final String        defaultAreaCode       = testDataAndExpectedResult.getV002();
			final String        rawPhoneNumber        = testDataAndExpectedResult.getV003();
			final PhoneNoValRes expectedPhoneNoValRes = testDataAndExpectedResult.getV004();
			final Tuple004<String, String, String, PhoneNoValRes> res =
				PhoneNumber.validateStrict(defaultCountryCode, defaultAreaCode, rawPhoneNumber);
			final PhoneNoValRes actualPhoneNoValRes = res.getV004();
			assertEquals(expectedPhoneNoValRes, actualPhoneNoValRes);

			if (expectedPhoneNoValRes.equals(PhoneNoValRes.INVALID)) {
				assertNull(res.getV001());
				assertNull(res.getV002());
				assertNull(res.getV003());
			} else {
				assertEquals(defaultCountryCode, res.getV001());
				assertEquals(defaultAreaCode   , res.getV002());
				assertEquals(rawPhoneNumber    , res.getV003());
			}
		}
	}

	/** Test method for
	 * {@link net.barakiroth.util.PhonUt#PhoneNoValRes}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testPhonUtPhoneNoValRes() {
		
		final Set<PhoneNoValRes> knownPhoneNoValRes =
				new HashSet<PhoneNoValRes>();
		knownPhoneNoValRes.add(PhoneNoValRes.INVALID);
		knownPhoneNoValRes.add(PhoneNoValRes.OK_EMAIL);
		knownPhoneNoValRes.add(PhoneNoValRes.OK_NOTUSINGDEF);
		knownPhoneNoValRes.add(PhoneNoValRes.OK_USINGDEF);

		for (final PhoneNoValRes phoneNoValRes : PhoneNoValRes.values()) {
			assertTrue(knownPhoneNoValRes.remove(phoneNoValRes));
		}

		assertTrue(knownPhoneNoValRes.isEmpty());
	}

	/** Test method for
	 * {@link net.barakiroth.util.PhonUt#PhoneNoValRes}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testPhonUtPhoneNoValResStrs() {
		
		final Set<Tuple002<String, PhoneNoValRes>> stringsAndEnums =
				new HashSet<Tuple002<String, PhoneNoValRes>>();
		stringsAndEnums.add(new Tuple002<String, PhoneNoValRes>("INVALID", PhoneNoValRes.INVALID));
		stringsAndEnums.add(new Tuple002<String, PhoneNoValRes>("OK_EMAIL", PhoneNoValRes.OK_EMAIL));
		stringsAndEnums.add(new Tuple002<String, PhoneNoValRes>("OK_NOTUSINGDEF", PhoneNoValRes.OK_NOTUSINGDEF));
		stringsAndEnums.add(new Tuple002<String, PhoneNoValRes>("OK_USINGDEF", PhoneNoValRes.OK_USINGDEF));

		for (final Tuple002<String, PhoneNoValRes> stringAndEnum : stringsAndEnums) {
			assertEquals(PhoneNoValRes.valueOf(stringAndEnum.getV001()), stringAndEnum.getV002());
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
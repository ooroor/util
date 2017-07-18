// Copyright (C) 2014 barakiroth.net
// All rights reserved
/**
 * 
 */
package net.barakiroth.oorutil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import net.barakiroth.oortestutil.IUnitTestCategory;
import net.barakiroth.oorutil.tuples.Tuple005;
import net.barakiroth.oorutil.tuples.Tuple006;
import net.barakiroth.oorutil.tuples.Tuple007;

/** Tests {@link PhoneNumber}.
 */
public class PhoneNumberUnitTest {
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

	/** Returns <code>true</code> if the format of any of the 
	 * phone number elements are invalid.
	 * @param countryCode Country code of the phone number
	 * @param areaCode Area code of the phone number
	 * @param noLocal Local number code of the phone number
	 * @return <code>true</code> if the format of any of the 
	 * phone number elements are invalid.
	 */
	private static boolean phoneNumberPropertiesHaveFormatErrors(
		  final String countryCode
		, final String areaCode
		, final String noLocal) {

		final boolean hasFormatError;
		if (
				   (countryCode != null && "".equals(countryCode))
			       ||
			       (areaCode != null && "".equals(areaCode))
			       ||
			       (noLocal != null && "".equals(noLocal))
			       ||
			       (countryCode != null && countryCode.contains(" "))
			       ||
			       (areaCode != null && areaCode.contains(" "))
			       ||
			       (noLocal != null && noLocal.contains(" "))
			   ) {
				hasFormatError = true;
			} else {
				hasFormatError = false;
			}
		return hasFormatError;
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

	// =========================================================================

	/** Test method for {@link net.barakiroth.util.PhoneNumber#hashCode()}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testHashCode() {
		final PhoneNumber phoneNumber1 = PhoneNumber.createInstance(
			  PhoneNumber.normalizeElement("4 7")
			, PhoneNumber.normalizeElement("2 3 4")
			, PhoneNumber.normalizeElement("99 21 39 07"));
		assertFalse(phoneNumber1.isValid());
		assertEquals(phoneNumber1.hashCode(), phoneNumber1.hashCode());
		final PhoneNumber phoneNumber2 = PhoneNumber.createInstance("47", "234", "99213907");
		assertFalse(phoneNumber2.isValid());
		assertEquals(phoneNumber2.hashCode(), phoneNumber2.hashCode());

		assertEquals(phoneNumber1.hashCode(), phoneNumber2.hashCode());
	}

	/** Test method for
	 * {@link net.barakiroth.util.PhoneNumber#PhoneNumber(java.lang.String, java.lang.String, java.lang.String, boolean)}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testPhoneNumberStringStringStringBoolean() {
		final PhoneNumber notNormalizedPhoneNumber =
			PhoneNumber.createInstance(
				  PhoneNumber.normalizeElement("4 7")
				, PhoneNumber.normalizeElement("2 3 4")
				, PhoneNumber.normalizeElement("99 21 39 07"));
		assertFalse(notNormalizedPhoneNumber.isValid());
		final PhoneNumber normalizedPhoneNumber =
			PhoneNumber.createInstance(
				  PhoneNumber.normalizeElement("4 7")
				, PhoneNumber.normalizeElement("2 3 4")
				, PhoneNumber.normalizeElement("99 21 39 07"));
		assertFalse(normalizedPhoneNumber.isValid());
	}

	/** Test method for {@link net.barakiroth.util.PhoneNumber#PhoneNumber(java.lang.String, java.lang.String, java.lang.String)}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testPhoneNumberStringStringString() {
		final PhoneNumber notNormalizedPhoneNumber =
			PhoneNumber.createInstance(
				  PhoneNumber.normalizeElement("4 7")
				, PhoneNumber.normalizeElement("2 3 4")
				, PhoneNumber.normalizeElement("99 21 39 07"));
		assertFalse(notNormalizedPhoneNumber.isValid());
	}

	/** Test method for
	 * {@link net.barakiroth.util.PhoneNumber#getCountryCode()}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testGetCountryCode() {
		final PhoneNumber notNormalizedPhoneNumber =
			PhoneNumber.createInstance(
				  PhoneNumber.normalizeElement("4 7")
				, PhoneNumber.normalizeElement("2 3 4")
				, PhoneNumber.normalizeElement("99 21 39 07"));
		assertFalse(notNormalizedPhoneNumber.isValid());
		assertEquals("47", notNormalizedPhoneNumber.getCountryCode());
		final PhoneNumber normalizedPhoneNumber =
			PhoneNumber.createInstance(
				  PhoneNumber.normalizeElement("4 7")
				, PhoneNumber.normalizeElement("2 3 4")
				, PhoneNumber.normalizeElement("99 21 39 07"));
		assertFalse(normalizedPhoneNumber.isValid());
		assertEquals("47", normalizedPhoneNumber.getCountryCode());
		assertEquals(notNormalizedPhoneNumber, normalizedPhoneNumber);
	}

	/** Test method for
	 * {@link net.barakiroth.util.PhoneNumber#getAreaCode()}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testGetAreaCode_1() {
		final PhoneNumber notNormalizedPhoneNumber =
			PhoneNumber.createInstance(
				  PhoneNumber.normalizeElement("4 7")
				, PhoneNumber.normalizeElement("2 3 4")
				, PhoneNumber.normalizeElement("99 21 39 07"));
		assertFalse(notNormalizedPhoneNumber.isValid());
		assertEquals("47", notNormalizedPhoneNumber.getCountryCode());
		final PhoneNumber normalizedPhoneNumber =
			PhoneNumber.createInstance(
				  PhoneNumber.normalizeElement("4 7")
				, PhoneNumber.normalizeElement("2 3 4")
				, PhoneNumber.normalizeElement("99 21 39 07"));
		assertFalse(normalizedPhoneNumber.isValid());
		assertEquals("47", normalizedPhoneNumber.getCountryCode());
		assertEquals(notNormalizedPhoneNumber, normalizedPhoneNumber);
	}

	/** Test method for
	 * {@link net.barakiroth.util.PhoneNumber#getAreaCode()}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testGetAreaCode_2() {
		final PhoneNumber notNormalizedPhoneNumber =
			PhoneNumber.createInstance(
				  PhoneNumber.normalizeElement("4 7")
				, PhoneNumber.normalizeElement("       ")
				, PhoneNumber.normalizeElement("99 21 39 07"));
		assertTrue(notNormalizedPhoneNumber.isValid());
		assertNull(notNormalizedPhoneNumber.getAreaCode());
		final PhoneNumber normalizedPhoneNumber =
			PhoneNumber.createInstance(
					PhoneNumber.normalizeElement("4 7")
				, PhoneNumber.normalizeElement("       ")
				, PhoneNumber.normalizeElement("99 21 39 07"));
		assertTrue(normalizedPhoneNumber.isValid());
		assertNull(normalizedPhoneNumber.getAreaCode());
		assertEquals(notNormalizedPhoneNumber, normalizedPhoneNumber);
	}

	/** Test method for {@link net.barakiroth.util.PhoneNumber#getNoLocal()}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testGetNoLocal() {
		final PhoneNumber notNormalizedPhoneNumber =
			PhoneNumber.createInstance(
				  PhoneNumber.normalizeElement("4 7")
				, PhoneNumber.normalizeElement("2 3 4")
				, PhoneNumber.normalizeElement("99 21 39 07"));
		assertFalse(notNormalizedPhoneNumber.isValid());
		assertNotEquals("99 21 39 07", notNormalizedPhoneNumber.getNoLocal());
		final PhoneNumber normalizedPhoneNumber =
				PhoneNumber.createInstance(
					  PhoneNumber.normalizeElement("4 7")
					, PhoneNumber.normalizeElement("2 3 4")
					, PhoneNumber.normalizeElement("99 21 39 07"));
		assertFalse(normalizedPhoneNumber.isValid());
		assertEquals("99213907", normalizedPhoneNumber.getNoLocal());
		assertEquals(notNormalizedPhoneNumber, normalizedPhoneNumber);
	}

	/** Test method for {@link net.barakiroth.util.PhoneNumber#isNormalized()}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testIsNormalized() {
		final PhoneNumber notNormalizedPhoneNumber =
			PhoneNumber.createInstance(
				  PhoneNumber.normalizeElement("4 7")
				, PhoneNumber.normalizeElement("2 3 4")
				, PhoneNumber.normalizeElement("99 21 39 07"));
		assertFalse(notNormalizedPhoneNumber.isValid());
		final PhoneNumber normalizedPhoneNumber =
			PhoneNumber.createInstance(
				  PhoneNumber.normalizeElement("4 7")
				, PhoneNumber.normalizeElement("2 3 4")
				, PhoneNumber.normalizeElement("99 21 39 07"));
		assertFalse(normalizedPhoneNumber.isValid());
	}

	/** Test method for
	 * {@link net.barakiroth.util.PhoneNumber#normalizedInstance()}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testNormalizedInstance() {
		final PhoneNumber phoneNumber =
			PhoneNumber.createInstance(
				  PhoneNumber.normalizeElement("4 7")
				, PhoneNumber.normalizeElement("2 3 4")
				, PhoneNumber.normalizeElement("99 21 39 07"));
		assertFalse(phoneNumber.isValid());
		assertEquals("47", phoneNumber.getCountryCode());
		assertEquals("234", phoneNumber.getAreaCode());
		assertEquals("99213907", phoneNumber.getNoLocal());
	}

	/** Test method for
	 * {@link net.barakiroth.util.PhoneNumber#equals(java.lang.Object)}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testEqualsObject() {

		final PhoneNumber notNormalizedPhoneNumber1 =
			PhoneNumber.createInstance("47", "234", "99213907");
		assertFalse(notNormalizedPhoneNumber1.isValid());
		final PhoneNumber notNormalizedPhoneNumber2 =
			PhoneNumber.createInstance("47", "234", "99213907");
		assertFalse(notNormalizedPhoneNumber2.isValid());
		assertEquals(notNormalizedPhoneNumber1, notNormalizedPhoneNumber2);
		assertEquals(notNormalizedPhoneNumber1.getCountryCode(), notNormalizedPhoneNumber2.getCountryCode());
		assertEquals(notNormalizedPhoneNumber1.getAreaCode()   , notNormalizedPhoneNumber2.getAreaCode());
		assertEquals(notNormalizedPhoneNumber1.getNoLocal()    , notNormalizedPhoneNumber2.getNoLocal());
		assertNotEquals(notNormalizedPhoneNumber1, null);
		assertNotEquals(notNormalizedPhoneNumber1, "something");
	}

	/** Test method for {@link net.barakiroth.util.PhoneNumber#toString()}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testToString() {
		final PhoneNumber notNormalizedPhoneNumber =
				PhoneNumber.createInstance("47", "234", "99213907");
		assertFalse(notNormalizedPhoneNumber.isValid());
		assertNotNull(notNormalizedPhoneNumber.toString());
	}

	/** Test method for {@link net.barakiroth.util.PhoneNumber#isValid()}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testIsValid() {
		final PhoneNumber notNormalizedPhoneNumber1 =
				PhoneNumber.createInstance("47", "234", "99213907");
		assertFalse(notNormalizedPhoneNumber1.isValid());

		final PhoneNumber notNormalizedPhoneNumber2 =
				PhoneNumber.createInstance("47", "234", "99213907");
		assertNotNull(notNormalizedPhoneNumber2.isValid());
		assertFalse(notNormalizedPhoneNumber2.isValid());
		assertEquals("47", notNormalizedPhoneNumber2.getCountryCode());
		assertEquals("234", notNormalizedPhoneNumber2.getAreaCode());
		assertEquals("99213907", notNormalizedPhoneNumber2.getNoLocal());

		final PhoneNumber notNormalizedPhoneNumber3 =
				PhoneNumber.createInstance("47", null, "99213907");
		assertNotNull(notNormalizedPhoneNumber3.isValid());
		assertTrue(notNormalizedPhoneNumber3.isValid());
		assertEquals("47", notNormalizedPhoneNumber3.getCountryCode());
		assertEquals(null, notNormalizedPhoneNumber3.getAreaCode());
		assertEquals("99213907", notNormalizedPhoneNumber3.getNoLocal());

		final PhoneNumber notNormalizedPhoneNumber4 =
				PhoneNumber.createInstance("1", "123", "1234567");
		assertNotNull(notNormalizedPhoneNumber4.isValid());
		assertTrue(notNormalizedPhoneNumber4.isValid());
		assertEquals("1", notNormalizedPhoneNumber4.getCountryCode());
		assertEquals("123", notNormalizedPhoneNumber4.getAreaCode());
		assertEquals("1234567", notNormalizedPhoneNumber4.getNoLocal());

		final PhoneNumber normalizedPhoneNumber5 =
				PhoneNumber.createInstance("1", null, "1231234567");
		assertFalse(normalizedPhoneNumber5.isValid());
		assertEquals("1", normalizedPhoneNumber5.getCountryCode());
		assertNull(normalizedPhoneNumber5.getAreaCode());
		assertEquals("1231234567", normalizedPhoneNumber5.getNoLocal());

		final PhoneNumber normalizedPhoneNumber6 =
			PhoneNumber.createInstance("1", null, "1231234567");
		assertEquals(normalizedPhoneNumber5, normalizedPhoneNumber6);

		final PhoneNumber normalizedPhoneNumber7 =
			PhoneNumber.createInstance(null, null, "11231234567");
		assertFalse(normalizedPhoneNumber7.isValid());
		assertNotEquals(normalizedPhoneNumber5, normalizedPhoneNumber7);
		assertNull(normalizedPhoneNumber7.getCountryCode());
		assertNull(normalizedPhoneNumber7.getAreaCode());
		assertEquals("11231234567", normalizedPhoneNumber7.getNoLocal());
	}

	/** Test method for
	 * {@link net.barakiroth.util.PhoneNumber#createInstanceFromConcatenation(String))}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testCreateInstanceFromConcatenation() {

		@SuppressWarnings("serial")
		final List<Tuple005<String, String, String, String, Boolean>> testDataAndResults =
			new ArrayList<Tuple005<String, String, String, String, Boolean>>() {{
				/* 1*/ add(new Tuple005<String, String, String, String, Boolean>(null         ,  null,  null,          null, false));
				/* 2*/ add(new Tuple005<String, String, String, String, Boolean>(""           ,  null,  null,          null, false));
				/* 3*/ add(new Tuple005<String, String, String, String, Boolean>(" "          ,  null,  null,          null, false));
				/* 4*/ add(new Tuple005<String, String, String, String, Boolean>("      "     ,  null,  null,          null, false));
				/* 5*/ add(new Tuple005<String, String, String, String, Boolean>(" a b c "    ,  null,  null,         "abc", false));
				/* 6*/ add(new Tuple005<String, String, String, String, Boolean>("4799213907" ,  "47",  null,    "99213907", true));
				/* 7*/ add(new Tuple005<String, String, String, String, Boolean>("479921390"  ,  null,  null,   "479921390", false));
				/* 8*/ add(new Tuple005<String, String, String, String, Boolean>("47992139071",  null,  null, "47992139071", false));
				/* 9*/ add(new Tuple005<String, String, String, String, Boolean>("4799213"    ,  "47",  null,       "99213", true));
				/*10*/ add(new Tuple005<String, String, String, String, Boolean>("479913"     ,  "47",  null,        "9913", true));
				/*11*/ add(new Tuple005<String, String, String, String, Boolean>("12031234567",   "1", "203",     "1234567", true));
				/*12*/ add(new Tuple005<String, String, String, String, Boolean>("2031234567" ,  null,  null,  "2031234567", false));
				/*13*/ add(new Tuple005<String, String, String, String, Boolean>("993097393"  , "993",  null,      "097393", true));
				/*14*/ add(new Tuple005<String, String, String, String, Boolean>("99309739"   , "993",  null,       "09739", true));
				/*15*/ add(new Tuple005<String, String, String, String, Boolean>("99309739"   , "993",  null,       "09739", true));
				/*16*/ add(new Tuple005<String, String, String, String, Boolean>("9930973"    , "993",  null,        "0973", true));
			}};
		
		int turn = 0;
		for (final Tuple005<String, String, String, String, Boolean> testDataAndResult : testDataAndResults) {
			turn++;
			final String concatenatedPhoneNumber = testDataAndResult.getV001();
			final String expectedCountryCode = testDataAndResult.getV002();
			final String expectedAreaCode = testDataAndResult.getV003();
			final String expectedNoLocal = testDataAndResult.getV004();
			final boolean expectedValid = testDataAndResult.getV005();
			final PhoneNumber actualPhoneNumber =
					PhoneNumber.createInstanceFromConcatenation(concatenatedPhoneNumber);
			assertEquals("turn: " + turn, expectedCountryCode, actualPhoneNumber.getCountryCode());
			assertEquals("turn: " + turn, expectedAreaCode, actualPhoneNumber.getAreaCode());
			assertEquals("turn: " + turn, expectedNoLocal, actualPhoneNumber.getNoLocal());
			assertEquals("turn: " + turn, expectedValid, actualPhoneNumber.isValid());
		}
	}

	/** Test method for
	 * {@link net.barakiroth.util.PhoneNumber#createInstanceFromCountryCodeAndnConcatenationOfRest(String, String))))}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testCreateInstanceFromCountryCodeAndConcatenationOfRest() {

		final List<Tuple006<String, String, String, String, String, Boolean>> testDataAndResults =
			new ArrayList<Tuple006<String, String, String, String, String, Boolean>>();
		testDataAndResults.add(new Tuple006<String, String, String, String, String, Boolean>(null         , null                 , null         , null , null        , false));
		testDataAndResults.add(new Tuple006<String, String, String, String, String, Boolean>(""           , null                 , null         , null , null        , false));
		testDataAndResults.add(new Tuple006<String, String, String, String, String, Boolean>(" "          , null                 , null         , null , null        , false));
		testDataAndResults.add(new Tuple006<String, String, String, String, String, Boolean>("      "     , null                 , null         , null , null        , false));
		testDataAndResults.add(new Tuple006<String, String, String, String, String, Boolean>(" a b c "    , null                 , "abc"        , null , null        , false));
		testDataAndResults.add(new Tuple006<String, String, String, String, String, Boolean>("4799213907" , null                 , "4799213907" , null , null        , false));
		testDataAndResults.add(new Tuple006<String, String, String, String, String, Boolean>("479921390"  , null                 , "479921390"  , null , null        , false));
		testDataAndResults.add(new Tuple006<String, String, String, String, String, Boolean>("47992139071", null                 , "47992139071", null , null        , false));
		testDataAndResults.add(new Tuple006<String, String, String, String, String, Boolean>("4799213"    , null                 , "4799213"    , null , null        , false));
		testDataAndResults.add(new Tuple006<String, String, String, String, String, Boolean>("479913"     , null                 , "479913"     , null , null        , false));
		testDataAndResults.add(new Tuple006<String, String, String, String, String, Boolean>("12031234567", null                 , "12031234567", null , null        , false));
		testDataAndResults.add(new Tuple006<String, String, String, String, String, Boolean>("2031234567" , null                 , "2031234567" , null , null        , false));
		testDataAndResults.add(new Tuple006<String, String, String, String, String, Boolean>(null         , "99213907"           , null         , null , "99213907"  , false));
		testDataAndResults.add(new Tuple006<String, String, String, String, String, Boolean>(null         , "4799213907"         , null         , null , "4799213907", false));
		testDataAndResults.add(new Tuple006<String, String, String, String, String, Boolean>("1"          , "2"                  , "1"          , null , "2"         , false));
		testDataAndResults.add(new Tuple006<String, String, String, String, String, Boolean>("1"          , "1231234567"         , "1"          , "123", "1234567"   , true));
		testDataAndResults.add(new Tuple006<String, String, String, String, String, Boolean>("47"         , "99213907"           , "47"         , null , "99213907"  , true));
		testDataAndResults.add(new Tuple006<String, String, String, String, String, Boolean>("11"         , "231234567"          , "11"         , null , "231234567" , false));
		testDataAndResults.add(new Tuple006<String, String, String, String, String, Boolean>("1 1"        , " 2 3 1 2 3 4 5 6 7 ", "11"         , null , "231234567" , false));

		for (final Tuple006<String, String, String, String, String, Boolean> testDataAndResult : testDataAndResults) {
			final String  countryCode                   = testDataAndResult.getV001();
			final String  concatenatedAreaCodeAndNoLocal = testDataAndResult.getV002();
			final String  expectedCountryCode            = testDataAndResult.getV003();
			final String  expectedAreaCode               = testDataAndResult.getV004();
			final String  expectedNoLocal                = testDataAndResult.getV005();
			final boolean expectedValid                  = testDataAndResult.getV006();

			final PhoneNumber actualPhoneNumber =
				PhoneNumber.createInstanceFromCountryCodeAndConcatenationOfRest(countryCode, concatenatedAreaCodeAndNoLocal);
			assertEquals(expectedCountryCode, actualPhoneNumber.getCountryCode());
			assertEquals(expectedAreaCode, actualPhoneNumber.getAreaCode());
			assertEquals(expectedNoLocal, actualPhoneNumber.getNoLocal());
			assertEquals(expectedValid, actualPhoneNumber.isValid());
		}
	}

	/** Test method for
	 * {@link net.barakiroth.util.PhoneNumber#createInstance(String, String, String))))}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testCreateInstance() {
		final List<Tuple007<String, String, String, String, String, String, Boolean>> testDataAndResults =
				new ArrayList<Tuple007<String, String, String, String, String, String, Boolean>>();
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
			  null, null, null
			, null, null, null, false));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
			  "", null, null
			, null, null, null, false));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
			  " ", null, null
			, null, null, null, false));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
			  "      ", null, null
			, null, null, null, false));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
			  "4 7", "123", "12345678"
			, null, null, null, false));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
			  "47", "1 23", "12345678"
			, null, null, null, false));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
			  "47", "123", "1 2345678"
			, null, null, null, false));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
		      " a b c ", null, null
			, "abc", null, null, false));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
			  "4799213907", null, null
			, "4799213907", null, null, false));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
			  "479921390", null, null
			, "479921390", null, null, false));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
			  "47992139071", null, null
			, "47992139071", null, null, false));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
			  "4799213", null, null
			, "4799213", null, null, false));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
			  "479913", null, null
			, "479913", null, null, false));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
			  "12031234567", null, null
			, "12031234567", null, null, false));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
			  "2031234567", null, null
			, "2031234567", null, null, false));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
			  null, "99213907", null
			, null, "99213907", null, false));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
			  null, "4799213907", null
			, null, "4799213907", null, false));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
			  "1", "2", null
			, "1", "2", null, false));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
			  "1", "1231234567", null
			, "1", "1231234567", null, false));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
		      "47", "99213907", null
			, "47", "99213907", null, false));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
			  "1", "123", "1234567"
			, "1", "123", "1234567", true));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
			  "1", null, "1231234567"
			, "1", null, "1231234567", false));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
			  "11", null, "231234567"
			, "11", null, "231234567", false));
		testDataAndResults.add(new Tuple007<String, String, String, String, String, String, Boolean>(
			  "11", null, "231234567"
			, "11", null, "231234567", false));

		for (final Tuple007<String, String, String, String, String, String, Boolean> testDataAndResult : testDataAndResults) {
			final String countryCode         = testDataAndResult.getV001();
			final String areaCode            = testDataAndResult.getV002();
			final String noLocal             = testDataAndResult.getV003();
			final String expectedCountryCode = testDataAndResult.getV004();
			final String expectedAreaCode    = testDataAndResult.getV005();
			final String expectedNoLocal     = testDataAndResult.getV006();
			final boolean expectedValid      = testDataAndResult.getV007();
			final boolean shouldThrowIllegalArgumentException =
				phoneNumberPropertiesHaveFormatErrors(countryCode, areaCode, noLocal);
			try {
				final PhoneNumber actualPhoneNumber =
					PhoneNumber.createInstance(countryCode, areaCode, noLocal);
				if (shouldThrowIllegalArgumentException) {
					fail("Expected exception not received.");
				}
				assertEquals(expectedCountryCode, actualPhoneNumber.getCountryCode());
				assertEquals(expectedAreaCode, actualPhoneNumber.getAreaCode());
				assertEquals(expectedNoLocal, actualPhoneNumber.getNoLocal());
				assertEquals(expectedValid, actualPhoneNumber.isValid());
			} catch (AssertionError exception) {
				throw exception;
			} catch (IllegalArgumentException exception) {
				if (!shouldThrowIllegalArgumentException) {
					fail("Unexpected exception received: " + exception.getMessage());
				}
			} catch (Throwable exception) {
				fail("Unexpected exception received: " + exception.getMessage());
			}
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
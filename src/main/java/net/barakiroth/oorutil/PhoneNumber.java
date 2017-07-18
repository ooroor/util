// Copyright (C) 2014 barakiroth.net
// All rights reserved
/**
 * 
 */
package net.barakiroth.oorutil;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import net.barakiroth.oorutil.tuples.Tuple002;
import net.barakiroth.oorutil.tuples.Tuple003;
import net.barakiroth.oorutil.tuples.Tuple004;
/** An immutable class gathering the three elements 
 * country code, area code and local number.
 * Two instances are considered equal if the 
 * normalized versions of them are equal.
 */
public class PhoneNumber {
	//// =======================================================================
	//// BEGIN nested classes and enums
	////
	/** The outcome of the call to {@link #parseAndValidatePhoneNumber(String, String)}.
	 */
	public static enum PhoneNoValRes {

		/** The validation and treatment of 
		 * the total phone number
		 * indicates a legal phone number,
		 * but the default country and area codes
		 * passed as a parameters were not used.
		 */
		  OK_NOTUSINGDEF

		/** The validation and treatment of the total phone number
		 * indicates a legal phone number,
		 * and the default country and area codes were used 
		 * passed as a parameter was used.
		 */
		, OK_USINGDEF

		/** The validation and treatment of the total phone number 
		 * indicates an illegal phone number, 
		 * but it represents on the other hand a legal e-mail address.
		 * This is the case when an MS is sent from a 
		 * non-Apple to an Apple terminal.
		 */
		, OK_EMAIL

		/** The total phone number cannot be interpreted as a
		 * legal phone number or as a legal e-mail address.
		 */
		, INVALID
	}
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
	/** The regex of the concatenated area code and local number for a given country code.
	 * TODO: Hard coding.
	 * TODO: Should be read from a configuration file.
	 */
	public static final Map<String, Tuple002<Pattern, Integer>> PHONENUMBERONCOUNTRYCODE;
	static {
		final Map<String, Tuple002<Pattern, Integer>> phoneNumberOnCountryCode =
			new HashMap<String, Tuple002<Pattern, Integer>>();

		// Ethiopia (This is wrong, but the correct algorithm is too complicated):
		phoneNumberOnCountryCode.put("251",
			new Tuple002<Pattern, Integer>(Pattern.compile("^\\d{9}$"), 2));

		// Sweden (This is wrong, but the correct algorithm is too complicated):
		phoneNumberOnCountryCode.put("46",
			new Tuple002<Pattern, Integer>(Pattern.compile("^\\d{9,10}$"), 0));

		// Norway:
		phoneNumberOnCountryCode.put("47",
			new Tuple002<Pattern, Integer>(
				Pattern.compile("^(110)|(112)|(113)|(177)|([1-9]\\d{3,3})|(\\d{5,6})|([1-9]\\d{7})$"), 0));

		// USA:
		phoneNumberOnCountryCode.put("1",
			new Tuple002<Pattern, Integer>(Pattern.compile("^\\d{10}$"), 3));

		// Turkmenistan:
		phoneNumberOnCountryCode.put("993",
			new Tuple002<Pattern, Integer>(Pattern.compile("^\\d{4,8}$"), 0));

		PHONENUMBERONCOUNTRYCODE =
			Collections.unmodifiableMap(phoneNumberOnCountryCode);
	}
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
	/** E.g.: "47" for Norway.
	 */
	private final String countryCode;

	/** E.g.:
	 * <code>null</code> for not used in Norway
	 * and
	 * "201" for New Jersey in USA.
	 */
	private final String areaCode;

	/** E.g.:
	 * "99213907" for Norway
	 * and
	 * "1234567" for USA.
	 */
	private final String noLocal;

	/** May have one of three semantically well defined distinct values.
	 * <ul>
	 * <li><code>null</code>: Has not been validated.</li>
	 * <li><code>true</code>: Has been validated and found valid.</li>
	 * <li><code>false</code>: Has been validated and found invalid.</li>
	 * </ul>
	 */
	private final boolean isValid;
	////
	//// END instance private variables
	//// =======================================================================
	//// END instance variables
	//// =======================================================================
	//// =======================================================================
	//// BEGIN Constructors
	////
	/** Constructor setting the immutable fields as not normalized .
	 * @param countryCode Country code part of the phone number.
	 * @param areaCode Area code part of the phone number.
	 * @param noLocal Local number code part of the phone number.
	 * @param isValid Whether this is a valid phone number or not.
	 */
	private PhoneNumber(
			  final String countryCode
			, final String areaCode
			, final String noLocal
			, final boolean isValid) {

		this.countryCode = countryCode;
		this.areaCode    = areaCode;
		this.noLocal     = noLocal;
		this.isValid     = isValid;
	}
	////
	//// END Constructors
	//// =======================================================================
	//// =======================================================================
	//// BEGIN Methods
	////
	/** Removes blanks from all positions and converts to <code>null</code> if
	 * the result is an empty string.
	 * @param element The string to normalize, possibly containing blanks.
	 * @return The element stripped for blanks, possibly <code>null</code>.
	 */
	public static String normalizeElement(final String element) {

		String normalizedElement =
			StrUt.removeAllWhiteSpacesAndConvertBlanksToNull(element);

		return normalizedElement;
	}

	/** Finds out whether the phone number as given by the 
	 * parameter <code>rawPhoneNumber</code> satisfy one of:
	 * <ol>
	 * <li>The concatenated parameters <code>defaultCountryCode</code>, <code>defaultAreaCode</code> and <code>rawPhoneNumber</code> is a legal phone number ({@link PhoneNoValRes#OK_USINGDEF})</li>
	 * <li><code>rawPhoneNumber</code> is a legal concatenation of country and area code and local number ({@link PhoneNoValRes#OK_NOTUSINGDEF})</li>
	 * <li><code>rawPhoneNumber</code> is a legal e-mail address (used as to number when sending an MMS to an iPhone({@link PhoneNoValRes#OK_EMAIL})</li>
	 * </ol>
	 * The legality is decided using a map of regex'es for the
	 * concatenation of area code and local number on country code.
	 * @param defaultCountryCodeParm Used to find out whether the
	 * concatenation with the other parameters
	 * (<code>defaultAreaCodeParm</code> and <code>rawPhoneNumber</code>)
	 * gives a legal phone number.
	 * @param defaultAreaCodeParm Used to find out whether the
	 * concatenation with the other parameters
	 * (<code>defaultCountryCodeParm</code> and <code>rawPhoneNumber</code>)
	 * gives a legal phone number.
	 * @param rawPhoneNumberParm May be a complete phone number or a
	 * local number which, when appended to the given parameters
	 * <code>defaultCountryCode</code> and
	 * <code>defaultAreaCode</code> gives a legal phone number.
	 * @return A {@link Tuple004} of country code, area code, 
	 * local number, and result code ({@link PhoneNoValRes}).
	 * If the <code>rawPhoneNumber</code> is a legal e-mail address,
	 * country code and area codes are <code>null</code>. 
	 */
	public static Tuple004<String, String, String, PhoneNoValRes> parseAndValidatePhoneNumber(
		  final String defaultCountryCodeParm
		, final String defaultAreaCodeParm
		, final String rawPhoneNumberParm) {

		final String rawPhoneNumber =
			StrUt.convertBlanksToNull(rawPhoneNumberParm == null ? null : rawPhoneNumberParm.replaceAll("\\b", ""));

		final Tuple004<String, String, String, PhoneNoValRes> ret;
		if (rawPhoneNumber == null) {

			ret = new Tuple004<String, String, String, PhoneNoValRes>(null, null, null, PhoneNoValRes.INVALID);
		} else {

			final String defaultCountryCode =
					StrUt.convertBlanksToNull(defaultCountryCodeParm == null ? null : defaultCountryCodeParm.replaceAll("\\b", ""));
			final String defaultAreaCode =
					StrUt.convertBlanksToNull(defaultAreaCodeParm == null ? null : defaultAreaCodeParm.replaceAll("\\b", ""));
			final Tuple004<String, String, String, PhoneNoValRes> strictRes =
					validateStrict(defaultCountryCode, defaultAreaCode, rawPhoneNumber);

			if (strictRes.getV004().equals(PhoneNoValRes.INVALID)) {
				ret = parseAndValidateSoloPhoneNumber(rawPhoneNumber);
			} else {
				ret = strictRes;
			}
		}

		return ret;
	}

	/** Validates a phone number consisting of the
	 * three parts country code, area code and local number.
	 * @param countryCode The phone number's country code.
	 * @param areaCode The phone number's area code.
	 * @param noLocal The phone number's local number.
	 * @return A 4-tuple with normalized country and area codes, local number and the result code.
	 */
	public static Tuple004<String, String, String, PhoneNoValRes> validateStrict(final String countryCode, final String areaCode, final String noLocal) {

		final Tuple004<String, String, String, PhoneNoValRes> res;
		final String normalizedCountryCode = countryCode  == null ? null : StrUt.convertBlanksToNull(countryCode.replaceAll("\\b", ""));
		final Tuple002<Pattern, Integer> regExAndAreaCodeLength = PHONENUMBERONCOUNTRYCODE.get(normalizedCountryCode);
		if (regExAndAreaCodeLength == null) {
			res = new Tuple004<String, String, String, PhoneNoValRes>(null, null, null, PhoneNoValRes.INVALID);
		} else {
			final String normalizedNoLocal  = noLocal  == null ? null : StrUt.convertBlanksToNull(noLocal.replaceAll("\\b", ""));
			if (normalizedNoLocal == null) {
				res = new Tuple004<String, String, String, PhoneNoValRes>(null, null, null, PhoneNoValRes.INVALID);
			} else {
				final String  normalizedAreaCode       =
					areaCode == null ? null : StrUt.convertBlanksToNull(areaCode.replaceAll("\\b", ""));
				final int     expectedLengthOfAreaCode = regExAndAreaCodeLength.getV002();
				final Pattern areaCodeAndNoLocalRegEx  = regExAndAreaCodeLength.getV001();
				if (normalizedAreaCode == null) {
					if (expectedLengthOfAreaCode == 0) {
						if (areaCodeAndNoLocalRegEx.matcher(normalizedNoLocal).matches()) {
							res = new Tuple004<String, String, String, PhoneNoValRes>(normalizedCountryCode, normalizedAreaCode, normalizedNoLocal, PhoneNoValRes.OK_USINGDEF);
						} else {
							res = new Tuple004<String, String, String, PhoneNoValRes>(null, null, null, PhoneNoValRes.INVALID);
						}
					} else {
						res = new Tuple004<String, String, String, PhoneNoValRes>(null, null, null, PhoneNoValRes.INVALID);
					}
				} else if (normalizedAreaCode.length() == expectedLengthOfAreaCode) {
					if (areaCodeAndNoLocalRegEx.matcher(normalizedAreaCode + normalizedNoLocal).matches()) {
						res = new Tuple004<String, String, String, PhoneNoValRes>(normalizedCountryCode, normalizedAreaCode, normalizedNoLocal, PhoneNoValRes.OK_USINGDEF);
					} else {
						res = new Tuple004<String, String, String, PhoneNoValRes>(null, null, null, PhoneNoValRes.INVALID);
					}
				} else {
					res = new Tuple004<String, String, String, PhoneNoValRes>(null, null, null, PhoneNoValRes.INVALID);
				}
			}
		}

		return res;
	}

	/** @param rawPhoneNumberParm An assumed concatenation of a phone number's
	 * country code, area code and local number.
	 * @return The parameter <code>rawPhoneNumberParm</code> split into its three 
	 * individual parts and the outcome of the parsing.
	 * If the phone number was not possible to interpreted,
	 * the first three elements are <code>null</code>.
	 */
	private static Tuple004<String, String, String, PhoneNoValRes> parseAndValidateSoloPhoneNumber(final String rawPhoneNumberParm) {
		
		final Tuple002<String, String> split = splitCountryCodeFromCompletePhoneNumber(rawPhoneNumberParm);
		final Tuple004<String, String, String, PhoneNoValRes> ret;
		final String countryCode = split.getV001();
		if (countryCode == null) {
			ret = new Tuple004<String, String, String, PhoneNoValRes>(null, null, null, PhoneNoValRes.INVALID);
		} else {
			final Tuple002<Pattern, Integer> regExAndAreaCodeLength =
					PHONENUMBERONCOUNTRYCODE.get(countryCode);
			final Pattern regEx = regExAndAreaCodeLength.getV001();
			if (regEx.matcher(split.getV002()).matches()) {
				final Tuple003<String, String, String> res =
						splitConcatenationOfAreaCodeAndLocalNumber(countryCode, split.getV002());
				ret = new Tuple004<String, String, String, PhoneNoValRes>(
					res.getV001(), res.getV002(), res.getV003(), PhoneNoValRes.OK_NOTUSINGDEF);
			} else {
				ret = new Tuple004<String, String, String, PhoneNoValRes>(
						  null
						, null
						, null
						, PhoneNoValRes.INVALID);
			}
		}

		return ret;
	}

	/** Splits the parameter <code>rawPhoneNumberParm</code> into
	 * a country code and a concatenation of the area code and the local number.
	 * @param rawPhoneNumberParm An assumed concatenation of a country code,
	 * area code and a local number.
	 * @return A two elements tuple containing a country code and a 
	 * concatenation of an area code and a local number.
	 */
	private static Tuple002<String, String> splitCountryCodeFromCompletePhoneNumber(final String rawPhoneNumberParm) {
		Tuple002<String, String> split = new Tuple002<String, String>(null, null);
		for (final String countryCode : PHONENUMBERONCOUNTRYCODE.keySet()) {
			if (rawPhoneNumberParm.startsWith(countryCode)) {
				final String areaCodeAndLocalNumber =
					rawPhoneNumberParm.substring(countryCode.length());
				split = new Tuple002<String, String>(countryCode, areaCodeAndLocalNumber);
				break;
			} // END if
		} // END for

		return split;		
	}

	/** Assuming that the passed country code is correct, and that the passed
	 * parameter <code>areaCodeAndLocalNumberParm</code> is a legal concatenation
	 * of the area code and the local number, this method splits the
	 * <code>areaCodeAndLocalNumberParm</code> into an area code and a local number.
	 * @param countryCodeParm The assumed correct country code of the phone number.
	 * @param areaCodeAndLocalNumberParm The assumed correct concatenation
	 * of the area code and the local number of the phone number.
	 * @return A three elements tuple containing the 
	 * country code, area code and the local number
	 */
	private static Tuple003<String, String, String> splitConcatenationOfAreaCodeAndLocalNumber(
			  final String countryCodeParm
			, final String areaCodeAndLocalNumberParm) {

		final int areaCodeLength =
			PHONENUMBERONCOUNTRYCODE.get(countryCodeParm).getV002();
		final String areaCode =
				StrUt.convertBlanksToNull(areaCodeAndLocalNumberParm.substring(0, areaCodeLength));
		final String localNumber =
				areaCodeAndLocalNumberParm.substring(areaCodeLength);
		final Tuple003<String, String, String> split =
				new Tuple003<String, String, String>(countryCodeParm, areaCode, localNumber);

		return split;
	}
	// =========================================================================

	/** @return the countryCode.
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/** @return the areaCode.
	 */
	public String getAreaCode() {
		return areaCode;
	}

	/** @return the noLocal.
	 */
	public String getNoLocal() {
		return noLocal;
	}

	/** @return the isValid
	 */
	public boolean isValid() {
		return isValid;
	}

	/** Creates a new normalized and validated instance and returns it.
	 * @param countryCode Country code part of the phone number.
	 * @param areaCode Area code part of the phone number.
	 * @param noLocal Local number code part of the phone number.
	 * @return a normalized {@link PhoneNumber}.
	 */
	public static PhoneNumber createInstance(
		  final String countryCode
		, final String areaCode
		, final String noLocal) {

		final String      normalizedCountryCode = normalizeElement(countryCode);
		if (ObjectUtils.notEqual(countryCode, normalizedCountryCode)) {
			throw new IllegalArgumentException("Illegal format of country code: \"" + countryCode + "\"");
		}

		final String      normalizedAreaCode    = normalizeElement(areaCode);
		if (ObjectUtils.notEqual(areaCode, normalizedAreaCode)) {
			throw new IllegalArgumentException("Illegal format of area code: \"" + areaCode + "\"");
		}

		final String      normalizedNoLocal     = normalizeElement(noLocal);
		if (ObjectUtils.notEqual(noLocal, normalizedNoLocal)) {
			throw new IllegalArgumentException("Illegal format of local number: \"" + noLocal + "\"");
		}

		final PhoneNumber phoneNumber;
		if ((normalizedCountryCode == null) || (normalizedNoLocal == null)) {
			phoneNumber = new PhoneNumber(normalizedCountryCode, normalizedAreaCode, normalizedNoLocal, false);
		} else {
			final Tuple004<String, String, String, PhoneNoValRes> res =
				parseAndValidateSoloPhoneNumber(
					StrUt.concatAcceptingNulls(normalizedCountryCode, normalizedAreaCode, normalizedNoLocal));
			if (
					!res.getV004().equals(PhoneNoValRes.INVALID)
					&&
					normalizedCountryCode.equals(res.getV001())
					&&
					normalizedNoLocal.equals(res.getV003())
			) {
				phoneNumber =
					new PhoneNumber(normalizedCountryCode, normalizedAreaCode, normalizedNoLocal, true);
			} else {
				phoneNumber =
					new PhoneNumber(normalizedCountryCode, normalizedAreaCode, normalizedNoLocal, false);
			}
		}

		return phoneNumber;
	}

	/** Creates an instance of {@link PhoneNumber} for a given country code and
	 * a concatenation of an area code and the local number. 
	 * @param countryCode The phone number's country code. Will be normalized.
	 * @param concatenatedAreaCodeAndNoLocal The phone number's 
	 * concatenation of an area code and the local number. Will be normalized.
	 * @return An instance of {@link PhoneNumber} which is valid or not
	 * valid.
	 */
	public static PhoneNumber createInstanceFromCountryCodeAndConcatenationOfRest(
		  final String countryCode
		, final String concatenatedAreaCodeAndNoLocal) {

		final String normalizedCountryCode = normalizeElement(countryCode);
		final String normalizedConcatenatedAreaCodeAndNoLocal =
				normalizeElement(concatenatedAreaCodeAndNoLocal);
		final PhoneNumber phoneNumber;
		if (
			(countryCode == null)
			||
			(concatenatedAreaCodeAndNoLocal == null)
		) {
			phoneNumber =
				new PhoneNumber(normalizedCountryCode, null, normalizedConcatenatedAreaCodeAndNoLocal, false);
		} else {
			final String normalizedConcatenatedPhoneNumber =
				normalizedCountryCode + normalizedConcatenatedAreaCodeAndNoLocal;
			final Tuple004<String, String, String, PhoneNoValRes> res =
				parseAndValidateSoloPhoneNumber(normalizedConcatenatedPhoneNumber);
			if (res.getV004().equals(PhoneNoValRes.INVALID)) {
				phoneNumber = new PhoneNumber(normalizedCountryCode, null, normalizedConcatenatedAreaCodeAndNoLocal, false);
			} else {
				if (normalizedCountryCode.equals(res.getV001())) {
					phoneNumber = new PhoneNumber(res.getV001(), res.getV002(), res.getV003(), true);
				} else {
					phoneNumber = new PhoneNumber(normalizedCountryCode, null, normalizedConcatenatedAreaCodeAndNoLocal, false);
				}
			}
		}

		return phoneNumber;
	}

	/** Creates an instance of {@link PhoneNumber} for a concatenation of
	 * a country code, an area code and a local number.
	 * @param concatenatedPhoneNumber The concatenation of
	 * a country code, an area code and a local number. Will be normalized.
	 * @return An instance of {@link PhoneNumber} which is valid or not
	 * valid.
	 */
	public static PhoneNumber createInstanceFromConcatenation(final String concatenatedPhoneNumber) {

		final PhoneNumber phoneNumber;
		if (concatenatedPhoneNumber == null) {
			phoneNumber = new PhoneNumber(null, null, null, false);
		} else {
			final String normalizedConcatenatedPhoneNumber =
					normalizeElement(concatenatedPhoneNumber);
			if (normalizedConcatenatedPhoneNumber == null) {
				phoneNumber = new PhoneNumber(null, null, null, false);
			} else {
				final Tuple004<String, String, String, PhoneNoValRes> res =
					parseAndValidateSoloPhoneNumber(normalizedConcatenatedPhoneNumber);
				
				if (res.getV004().equals(PhoneNoValRes.INVALID)) {
					phoneNumber = new PhoneNumber(null, null, normalizedConcatenatedPhoneNumber, false);
				} else {
					phoneNumber = new PhoneNumber(res.getV001(), res.getV002(), res.getV003(), true);
				}
			}
		}

		return phoneNumber;
	}

	/** {@inheritDoc}
	 */
	@Override
	public int hashCode() {

		final HashCodeBuilder hashCodeBuilder = new HashCodeBuilder();
		hashCodeBuilder
			.append(getCountryCode())	
			.append(getAreaCode())
			.append(getNoLocal());
		final int hashCode = hashCodeBuilder.hashCode();

		return hashCode;
	}

	/** {@inheritDoc}
	 */
	@Override
	public boolean equals(final Object other) {

		final boolean equals;
		if (other instanceof PhoneNumber) {
			final PhoneNumber otherPhoneNumber = (PhoneNumber)other;
			final EqualsBuilder equalsBuilder = new EqualsBuilder();
			equalsBuilder
				.append(getCountryCode(), otherPhoneNumber.getCountryCode())	
				.append(getAreaCode(), otherPhoneNumber.getAreaCode())
				.append(getNoLocal(), otherPhoneNumber.getNoLocal());
			equals = equalsBuilder.isEquals(); 
		} else {
			equals = false;
		}

		return equals;	
	}

	/** {@inheritDoc}
	 */
	@Override
	public String toString() {
		final String str =
			  "PhoneNumber:"                     + System.lineSeparator()
			+ "countryCode: " + getCountryCode() + System.lineSeparator()
			+ "areaCode   : " + getAreaCode()    + System.lineSeparator()
			+ "noLocal    : " + getNoLocal()     + System.lineSeparator()
			+ "isValid    : " + isValid();

		return str;
	}
	////
	//// END Methods
	//// =======================================================================
}
/*
Revision history:
$Log:$
*/
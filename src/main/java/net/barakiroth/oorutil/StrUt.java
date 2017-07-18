// Copyright (C) 2014 barakiroth.net
// All rights reserved
package net.barakiroth.oorutil;

/**
 * Miscellaneous {@link String} utility functionality.
 */
public class StrUt {
	//// =======================================================================
	//// BEGIN nested classes and enums
	//// END nested classes and enums
	////=======================================================================
	////
	//// S T A T I C
	//// =======================================================================
	//// BEGIN static variables
	////=======================================================================
	//// BEGIN static public variables
	//// END static public variables
	////=======================================================================
	//// BEGIN static protected variables
	//// END static protected variables
	////=======================================================================
	//// BEGIN static package variables
	//// END static package variables
	////=======================================================================
	//// BEGIN static private variables
	////
	////
	//// END static private variables
	////=======================================================================
	//// END static variables
	////=======================================================================
	////
	//// I N S T A N C E
	//// =======================================================================
	//// BEGIN instance variables
	////=======================================================================
	//// BEGIN instance public variables
	//// END instance public variables
	////=======================================================================
	//// BEGIN instance protected variables
	//// END instance protected variables
	////=======================================================================
	//// BEGIN instance package variables
	//// END instance package variables
	////=======================================================================
	//// BEGIN instance private variables
	//// END instance private variables
	////=======================================================================
	//// END instance variables
	////=======================================================================
	//// =======================================================================
	//// BEGIN Constructors
	////
	/**
	 * A do-nothing default constructor.
	 */
	public StrUt() {
	}
	////
	//// END Constructors
	//// =======================================================================
	//// =======================================================================
	//// BEGIN Methods
	////
	/**
	 * Returns a new {@link String} with all characters after the first 
	 * occurrence of the character as given by the parameter
	 * <code>splitChar</code> removed.
	 * Examples for the <code>splitChar</code> parameter equal to <code>'#'</code>:
	 * <br/>null -> null
	 * <br/>"abc#" -> "abc"
	 * <br/>"abc #" -> "abc "
	 * <br/>"abc #xxx" -> "abc "
	 * <br/>"#" -> ""
	 * <br/>"#abc" -> ""
	 * <br/>"# abc" -> ""
	 * <br/>" # abc" -> " "
	 *
	 * @param str The string in which to search for split character for cutting.
	 * @param splitChar The character used for splitting the string given as a parameter.
	 *
	 * @return A new {@link String} with all characters after the first 
	 * occurrence of the character as given by the parameter
	 * <code>splitChar</code> removed.
	 * If the input parameter <code>str</code> is <code>null</code>,
	 * <code>null</code> will be returned.
	 */
	public static String removeTrailing(final String str, final char splitChar) {
		final String trimmedStr;
		if (str == null) {
			trimmedStr = null;
		} else {
			final int commentStartPos = str.indexOf(splitChar);
			trimmedStr = (commentStartPos == -1) ? str : str.substring(0, commentStartPos);
		}

		return trimmedStr;	
	}
	
	/**
	 * Surrounds a string with single quotes.
	 * For example:
	 * "abc" -> "'abc'"
	 *
	 * @param source Some {@link String} or <code>null</code>.
	 * @return a {@link String} surrounded by single quotes,
	 * or <code>null</code> if the <code>source</code> 
	 * parameter was <code>null</code>.
	 */
	public static String surroundWithSingleQuotes(final String source) {
		final String target = surroundWith(source, '\''); 
		return target;
	}
	
	/**
	 * Surrounds a string with curly brackets.
	 * For example:
	 * "abc" -> "{abc}"
	 *
	 * @param source Some {@link String} or <code>null</code>.
	 * @return a {@link String} surrounded by curly brackets,
	 * or <code>null</code> if the <code>source</code> 
	 * parameter was <code>null</code>.
	 */
	public static String surroundWithCurlyBrackets(final String source) {
		if (source == null) {
			return null;
		}

		final StringBuffer stringBuffer = new StringBuffer(source.length() + 2);
		stringBuffer.append('{').append(source).append('}');
		final String target = stringBuffer.toString(); 
		return target;
	}
	
	/**
	 * Surrounds a string with a character as given by the parameter <code>surrounder</code>.
	 * For example:
	 * surroundWith("abc", '%') -> "%abc%"
	 *
	 * @param source Some {@link String} or <code>null</code>.
	 * @param surrounder The character to surround 
	 * the given source parameter with.
	 * @return A {@link String} surrounded
	 * with a character as given by the
	 * parameter <code>surrounder</code>,
	 * or <code>null</code> if the <code>source</code> 
	 * parameter was <code>null</code>.
	 */
	public static String surroundWith(final String source, final char surrounder) {
		if (source == null) {
			return null;
		}
		final StringBuffer stringBuffer = new StringBuffer(source.length() + 2);
		stringBuffer.append(surrounder).append(source).append(surrounder);
		final String target = stringBuffer.toString(); 
		return target;
	}
	
	/**
	 * Returns the given <code>source</code> {@link String}
	 * stripped of a beginning <code>'{'</code>
	 * and trailing <code>'}'</code>. 
	 * @param source The {@link String} to strip.
	 * @return he given <code>source</code> {@link String}
	 * stripped of a beginning <code>'{'</code>
	 * and trailing <code>'}'</code>. If <code>null</code> is passed as a parameter,
	 * <code>null</code> is returned. If <code>source</code> is not surrounded with
	 * curly brackets, the original {@link String} is returned.
	 */
	public static String removeCurlyBrackets(final String source) {
		final String target;
		if (source == null) {
			target = null;
		} else {
			final int originalLength = source.length();
			if (originalLength < 2) {
				target = source;
			} else {
				final StringBuffer sourceStringBuffer = new StringBuffer(source);
				if (
					   (sourceStringBuffer.charAt(0) == '{') 
					&& (sourceStringBuffer.charAt(originalLength - 1) == '}')
				) {
					if (originalLength == 2) {
						target = "";
					} else {
						target = sourceStringBuffer.substring(1, originalLength - 1);
					}
				} else {
					target = source;
				}
			}
		}

		return target;
	}

	/**
	 * If the source contains nothing but blank space
	 * (blank(s), tab(s), lf(s), cr(s) etc.),
	 * a <code>null</code> is returned.
	 *
	 * @param source The string potentially to be converted to <code>null</code>.  
	 * @return <code>null</code> if the source contains nothing but blank space
	 * (blank(s), tab(s), lf(s), cr(s) etc.), otherwise the 
	 * source is returned unchanged.
	 * Trailing or leading blank space(s) are not removed if there is
	 * something else than blank space(s).
	 */
	public static String convertBlanksToNull(final String source) {

		String target;
		if (source == null) {
			target = null;
		} else {
			target = source.replaceAll("[\\s]*", "");
			if ("".equals(target)) {
				target = null;
			} else {
				target = source;
			}
		}

		return target;
	}

	/** Removes all white spaces from the string.
	 * If the result then consists of only an empty string,
	 * a <code>null</code> is returned.
	 * @param str The string to be treated.
	 * @return The same string stripped for white spaces,
	 * or <code>null</code> if the string only consisted 
	 * of white spaces or <code>null</code>.
	 */
	public static String removeAllWhiteSpacesAndConvertBlanksToNull(final String str) {

		final String ret =
			str == null ? null : StrUt.convertBlanksToNull(str.replaceAll("\\s", ""));

		return ret;
	}

	/** Concatenates the strings passed as a variable number of parameters.
	 * If a parameter is <code>null</code>, it is treated as an empty string.
	 * @param strs The strings to be concatenated. A string may be <code>null</code>.
	 * @return A concatenation of the strings passed as a variable number of parameters.
	 * If <code>null</code> is passed, or if all the strings 
	 * are <code>null</code>, <code>null</code> is returned. 
	 */
	public static String concatAcceptingNulls(final String ... strs) {

		final StringBuilder sb = new StringBuilder();
		if (strs == null) {
			sb.append("");
		} else {
			for (final String str : strs) {
				sb.append(str == null ? "" : str);
			}
		}

		final String rawStr = sb.toString();
		return "".equals(rawStr) ? null : rawStr;
	}
	////
	//// END Methods
	//// =======================================================================
}
/*
Revision history:
$Log:$
*/
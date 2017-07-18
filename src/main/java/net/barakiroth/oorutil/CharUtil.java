package net.barakiroth.oorutil;

public class CharUtil {

	/**
	 * Converts a string consisting of an equal number of
	 * characters in the interval '0'..'f', capital or
	 * to an array of bytes in the form of characters.
	 * I.e. A string of length of 2n would produce a char array of length n. 
	 * @param hexString E.g.: "00", "00ff99aa9aa9".
	 *                  No validity test is carried out on the input.
	 *                  An invalid input coulwill cause unpredictable
	 *                  results.
	 * @return The byte representation of the input.
	 *                  The strings in the input example above 
	 *                  would return the following character array:
	 *                  {(char0)} and 
	 *                  {(char)0, (char)255, (char)153, (char)170, (char)154, (char)169}
	 */
	public static char[] hexString2NChar(final String hexString) {

		final char[] chars = new char[hexString.length()/2];
		for (int ix = 0; ix < hexString.length(); ix+=2) {
			final String part = hexString.substring(ix, ix + 2);
			final char c = hexString2Char(part);
			chars[ix/2] = c;
		}

		return chars;
	}

	/**
	 *  Converts a two characters hexadecimal String to a char.
	 *  
	 * @param string2 Two letters hex code, e.g.: "00", "ff", "0f", "f0", ...
	 *                The two letters are assumed to be valid in the interval "00".."ff".
	 * 				  Capital or small letters are both OK. 
	 *				  NB! No validation carried out. Invalid input,
	 *                like <code>null</code> has unpredictable consequences.
	 * @return "00" -> char(00) (== char(0)), "ff" -> char(ff) (== char(255)), ...
	 */
	public static char hexString2Char(final String code2) {
		
		int i1 = Integer.parseUnsignedInt(code2.substring(0, 1), 16);
		int i2 = Integer.parseUnsignedInt(code2.substring(1, 2), 16);
		final int charInt = i1*16 + i2;
		char charValue = (char)charInt;
		
		return charValue;
	}
}
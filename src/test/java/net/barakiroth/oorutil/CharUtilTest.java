package net.barakiroth.oorutil;

import static org.junit.Assert.assertArrayEquals;

import org.junit.jupiter.api.Test;

import net.barakiroth.oortestutil.TestUtil;

public class CharUtilTest {

	/**
	 * Test that a correct input string returns what is expected.
	 */
	@Test
	public void testHexString2NChar() {

		TestUtil.forLevels(
			() -> {

				final char[] expectedChars =
					new char[] {
						  (char)0
						, (char)255
						, (char)153
						, (char)170
						, (char)154
						, (char)169
					};

				final char [] actualChars =
					CharUtil.hexString2NChar("00ff99aa9aa9");

				assertArrayEquals(expectedChars, actualChars);
			}
			, CharUtil.class
		);
	}

	/**
	 * Just see that the constructor does not crash.
	 */
	@Test
	public void testHexString2NChar_constructor() {
		new CharUtil();
	}
}
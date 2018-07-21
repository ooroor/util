// Copyright (C) 2014 barakiroth.net
// All rights reserved
/**
 * 
 */
package net.barakiroth.oorutil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.javatuples.Septet;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.barakiroth.oortestutil.IUnitTestCategory;
import net.barakiroth.oorutil.tuples.TupUt;
import net.barakiroth.oorutil.tuples.TupUt.SeptetPermutator;

/**
 * Tests the {@link StrUt} class.
 */
public class StrUtUnitTest {
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
	//// END Constructors
	//// =======================================================================
	//// =======================================================================
	//// BEGIN Methods
	////
	/**
	 * @throws java.lang.Exception If something unexpected occurs.
	 */
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception If something unexpected occurs.
	 */
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception If something unexpected occurs.
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception If something unexpected occurs.
	 */
	@AfterEach
	public void tearDown() throws Exception {
	}
	
	// =========================================================================

	/**
	 * Test method for
	 * {@link net.barakiroth.util.StrUt#removeTrailing(java.lang.String, char)}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testRemoveTrailing() {
		assertNull(StrUt.removeTrailing(null, 'R'));
		assertEquals(" ", StrUt.removeTrailing(" ", '@'));
		assertEquals("A", StrUt.removeTrailing("A", '@'));
		assertEquals("    A      C ", StrUt.removeTrailing("    A      C ", '@'));
		assertEquals("    A  ", StrUt.removeTrailing("    A  @    C ", '@'));
		assertEquals("", StrUt.removeTrailing("@    A  @    C ", '@'));
		assertEquals("", StrUt.removeTrailing("@", '@'));
		assertEquals("", StrUt.removeTrailing("", '@'));
		assertEquals("abc", StrUt.removeTrailing("abc@def", '@'));
		assertEquals("   ", StrUt.removeTrailing("   @   ", '@'));
		assertEquals("abc", StrUt.removeTrailing("abc@def@ghi@jkl", '@'));
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.StrUt#surroundWithSingleQuotes(java.lang.String)}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testSurroundWithSingleQuotes() {
		assertNull(StrUt.surroundWithSingleQuotes(null));
		assertEquals("''", StrUt.surroundWithSingleQuotes(""));
		assertEquals("'''", StrUt.surroundWithSingleQuotes("'"));
		assertEquals("'       '", StrUt.surroundWithSingleQuotes("       "));
		assertEquals("'abc#@#@#@'", StrUt.surroundWithSingleQuotes("abc#@#@#@"));
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.StrUt#surroundWithSingleQuotes(java.lang.String)}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testSurroundWithCurlyBrackets() {
		assertNull(StrUt.surroundWithCurlyBrackets(null));
		assertEquals("{}", StrUt.surroundWithCurlyBrackets(""));
		assertEquals("{'}", StrUt.surroundWithCurlyBrackets("'"));
		assertEquals("{       }", StrUt.surroundWithCurlyBrackets("       "));
		assertEquals("{abc#@#@#@}", StrUt.surroundWithCurlyBrackets("abc#@#@#@"));
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.StrUt#surroundWith(java.lang.String, char)}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testSurroundWith() {
		assertNull(StrUt.surroundWith(null, '@'));
		assertEquals("@@", StrUt.surroundWith("", '@'));
		assertEquals("@'@", StrUt.surroundWith("'", '@'));
		assertEquals("@       @", StrUt.surroundWith("       ", '@'));
		assertEquals("@abcJKLkhjhv@", StrUt.surroundWith("abcJKLkhjhv", '@'));
	}

	/**
	 * Test method for 
	 * {@link net.barakiroth.util.StrUt#testRemoveCurlyBrackets()}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testRemoveCurlyBrackets() {
		assertNull(StrUt.removeCurlyBrackets(null));
		assertEquals("", StrUt.removeCurlyBrackets(""));
		assertEquals(" ", StrUt.removeCurlyBrackets(" "));
		assertEquals("  ", StrUt.removeCurlyBrackets("  "));
		assertEquals("   ", StrUt.removeCurlyBrackets("   "));
		assertEquals("{", StrUt.removeCurlyBrackets("{"));
		assertEquals("}", StrUt.removeCurlyBrackets("}"));
		assertEquals("", StrUt.removeCurlyBrackets("{}"));
		assertEquals("x", StrUt.removeCurlyBrackets("{x}"));
		assertEquals("a{x}", StrUt.removeCurlyBrackets("a{x}"));
		assertEquals("a{x}b", StrUt.removeCurlyBrackets("a{x}b"));
		assertEquals("{x}b", StrUt.removeCurlyBrackets("{x}b"));
	}

	/**
	 * Test method for 
	 * {@link net.barakiroth.util.StrUt#StrUt()}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testStrUt() {
		new StrUt();
	}

	/**
	 * Test method for 
	 * {@link net.barakiroth.util.StrUt#convertBlanksToNull(String)}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testConvertBlanksToNull() {
		
		final SeptetPermutator<String, String, String, String, String, String, String> septetPermutator =
				new SeptetPermutator<String, String, String, String, String, String, String>(
						  new String[] {"", " ", "      ", "\n", "\t", "\r", null, "W"}
						, new String[] {"", " ", "      ", "\n", "\t", "\r", null, "W"}
						, new String[] {"", " ", "      ", "\n", "\t", "\r", null, "W"}
						, new String[] {"", " ", "      ", "\n", "\t", "\r", null, "W"}
						, new String[] {"", " ", "      ", "\n", "\t", "\r", null, "W"}
						, new String[] {"", " ", "      ", "\n", "\t", "\r", null, "W"}
						, new String[] {"", " ", "      ", "\n", "\t", "\r", null, "W"}
				);

		for (final Septet<String, String, String, String, String, String, String> septet : septetPermutator) {
			final String source = TupUt.concatenate(septet, "");
			final String target = StrUt.convertBlanksToNull(source);
			if (source == null) {
				assertNull(target);
			} else {
				if (source.contains("W")) {
					assertEquals(target, source);
				} else {
					assertNull(target);
				}
			}
		}
	}

	/** Test method for 
	 * {@link net.barakiroth.util.StrUt#concatAcceptingNulls(String...)}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testConcatAcceptingNulls() {
		assertNull(StrUt.concatAcceptingNulls((String[])null));
		assertNull(StrUt.concatAcceptingNulls(""));
		assertNull(StrUt.concatAcceptingNulls("", ""));
		assertEquals("a", StrUt.concatAcceptingNulls("a", ""));
		assertEquals("a", StrUt.concatAcceptingNulls("a", null));
		assertEquals("a", StrUt.concatAcceptingNulls(null, "a", null));
		assertEquals(" a ", StrUt.concatAcceptingNulls(null, " a ", null));
		assertEquals("b a ", StrUt.concatAcceptingNulls("b", null, " a ", null));
		assertEquals("abc", StrUt.concatAcceptingNulls("a", "b", "c"));
		assertEquals("abc", StrUt.concatAcceptingNulls(null, null, null, "a", null, null, "b", null, null, null, "c", null, null, null, null));
	}

	/** Test method for 
	 * {@link net.barakiroth.util.StrUt#removeAllWhiteSpacesAndConvertBlanksToNull(String))}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testRemoveAllWhiteSpacesAndConvertBlanksToNull() {
		assertNull(StrUt.removeAllWhiteSpacesAndConvertBlanksToNull(null));
		assertNull(StrUt.removeAllWhiteSpacesAndConvertBlanksToNull(""));
		assertNull(StrUt.removeAllWhiteSpacesAndConvertBlanksToNull(" "));
		assertNull(StrUt.removeAllWhiteSpacesAndConvertBlanksToNull(" \t"));
		assertNull(StrUt.removeAllWhiteSpacesAndConvertBlanksToNull(" \n"));
		assertEquals("abc", StrUt.removeAllWhiteSpacesAndConvertBlanksToNull(" a b c "));
		assertEquals("abc", StrUt.removeAllWhiteSpacesAndConvertBlanksToNull(" \t\na  \t\nb  \t\nc  \t\n"));
	}
	////
	//// END Methods
	//// =======================================================================
}
/*
Revision history:
$Log:$
*/
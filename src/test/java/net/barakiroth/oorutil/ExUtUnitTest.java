// Copyright (C) 2014 barakiroth.net
// All rights reserved
/**
 * 
 */
package net.barakiroth.oorutil;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import javax.activity.InvalidActivityException;
import javax.validation.ConstraintViolationException;
import net.barakiroth.oortestutil.IUnitTestCategory;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Tests {@link net.barakiroth.util.ExUt}.
 */
public class ExUtUnitTest {
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
	 * {@link net.barakiroth.util.ExUt#extract(java.lang.Throwable, java.lang.Class)}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testExtract() {
		assertNull(ExUt.extract(null, InvalidActivityException.class));
		assertNull(ExUt.extract(null, null));
		Throwable throwable = new Throwable();
		assertNull(ExUt.extract(throwable, null));
		assertNull(ExUt.extract(throwable, ConstraintViolationException.class));
		final IOException ioException = new IOException("Hello error!");
		throwable = new Throwable(ioException);
		throwable = ExUt.extract(throwable, IOException.class);
		assertNotNull(throwable);
		assertTrue(throwable instanceof IOException);
		throwable = ExUt.extract(throwable, InvalidActivityException.class);
		assertNull(throwable);
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.ExUt#ExUt()}.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testRunTheConstructorJustToSatisfyJaCoCo() {
		new ExUt();
	}
	////
	//// END Methods
	//// =======================================================================
}
/*
Revision history:
$Log:$
*/
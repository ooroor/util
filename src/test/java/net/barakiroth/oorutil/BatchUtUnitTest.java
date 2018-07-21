// Copyright (C) 2014 barakiroth.net
// All rights reserved
/**
 * 
 */
package net.barakiroth.oorutil;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import net.barakiroth.oortestutil.ISlowTestCategory;
import net.barakiroth.oortestutil.IUnitTestCategory;

/**
 * Tests the {@link BatchUt}.
 */
public class BatchUtUnitTest {

	/**
	 * Contact populated by the yaml test data file.
	 */
	public static class ContactRawTestClass {
		public String code;
		public String nameFirst;
		public String nameMiddle;
		public String nameLast;
		public String note;
		public final List<GeographicalAddressRawTestClass> geographicalAddresses = new ArrayList<>();
		public final List<EmailAddressRawTestClass> emailAddresses = new ArrayList<>();
		public final List<PhoneSubscriptionRawTestClass> phoneSubscriptions = new ArrayList<>();
		public final List<RelationshipRaw> relationships = new ArrayList<>();
	}

	/**
	 * Geographical address populated by the yaml test data file.
	 */
	public static class GeographicalAddressRawTestClass {
		public String address01;
		public String address02;
		public String address03;
		public String postalCode;
		public String postalCodeName;
		public String note;
	}

	/**
	 * Phone subscription populated by the yaml test data file.
	 */
	public static class PhoneSubscriptionRawTestClass {
		public String countryCode;
		public String areaCode;
		public String localNumber;
		public String note;
	}

	/**
	 * E-mail address populated by the yaml test data file.
	 */
	public static class EmailAddressRawTestClass {
		public String emailAddress;
		public String note;
	}

	/**
	 * Relationship between contacts populated by the yaml test data file.
	 */
	public static class RelationshipRaw {
		public String role;
		public ContactRawTestClass contact;
	}
	
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
	 * @throws java.lang.Exception when something unexpected occurs.
	 */
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception when something unexpected occurs.
	 */
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception when something unexpected occurs.
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception when something unexpected occurs.
	 */
	@AfterEach
	public void tearDown() throws Exception {
	}
	
	// =========================================================================

	/**
	 * Test method for
	 * {@link net.barakiroth.util.BatchUt#parseYamlResource(java.lang.String)}.
	 *
	 * @throws URISyntaxException If the resource file name cannot 
	 * successfully be converted to a {@link java.net.URI}.
	 * @throws IOException When error in the stream handling. 
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testParseYamlResource() throws IOException, URISyntaxException {
        final String fileName = "contacts.batch.001.txt";
        final BatchUt dataBatch = new BatchUt();
        final Iterable<Object> yamlData =
        		dataBatch.parseYamlResource(fileName);
        assertYamlObjects(yamlData);
    }

	/**
	 * Test method for
	 * {@link net.barakiroth.util.BatchUt#parseYamlFile(java.lang.String)}.
	 *
	 * @throws IOException When error in the stream handling.
	 */
	@Test
	@Category(IUnitTestCategory.class)
	public final void testParseYamlFileString() throws IOException {

        final String fileName = "src/test/resources/contacts.batch.001.txt";
        final BatchUt dataBatch = new BatchUt();
        final Iterable<Object> yamlData =
    		dataBatch.parseYamlFile(fileName);
        assertYamlObjects(yamlData);
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.BatchUt#parseYamlBytes(byte[])}.
	 * A legal object is parsed.
	 */
	@Test
	@Category({IUnitTestCategory.class})
	public final void testParseYamlBytes(){
		final String lines =
				  "# ==============================================================================" + System.lineSeparator()
				+ "# ==============================================================================" + System.lineSeparator()
				+ "- &uteteamet !!net.barakiroth.oorutil.BatchUtUnitTest$ContactRawTestClass" + System.lineSeparator() 
				+ "    code                 :" + System.lineSeparator()
				+ "    nameLast             :" + System.lineSeparator()
				+ "    nameMiddle           :" + System.lineSeparator()
				+ "    nameFirst            : Uteteamet vakttelefon" + System.lineSeparator()
				+ "    note                 :" + System.lineSeparator()
				+ "    emailAddresses       :" + System.lineSeparator()
				+ "    - {emailAddress : uteteam.barnevern@bsr.oslo.kommune.no, note: null}" + System.lineSeparator()
				+ "    geographicalAddresses:" + System.lineSeparator()
				+ "    - {address01: Kallegata 17, address02: Nede i dumpa, address03: Ved kafeen, postalCode: 2231, postalCodeName: Nedrigaard, note: }" + System.lineSeparator()
				+ "    phoneSubscriptions   :" + System.lineSeparator()
				+ "    - {countryCode: 47, areaCode: null, localNumber: 90244471, note: }" + System.lineSeparator()
  		        + "    relationships        : []" + System.lineSeparator()
				+ "# ==============================================================================" + System.lineSeparator()
				+ "# ==============================================================================";

        final BatchUt dataBatch = new BatchUt();
		final Iterable<Object> yamlData = dataBatch.parseYamlBytes(lines.getBytes());

		int noObjs = 0;
		for (Object obj : yamlData) {
			noObjs++;
			assertEquals(1, noObjs);
			assertTrue(obj instanceof List);
			@SuppressWarnings("unchecked")
			final List<ContactRawTestClass> contacts = (List<ContactRawTestClass>)obj;
			assertEquals(1, contacts.size());
			final ContactRawTestClass contact = contacts.iterator().next();
			assertEquals(1, contact.emailAddresses.size());
			assertEquals(1, contact.geographicalAddresses.size());
			assertEquals(1, contact.phoneSubscriptions.size());
			assertEquals(0, contact.relationships.size());
		}
	}

	/**
	 * Test method for
	 * {@link net.barakiroth.util.BatchUt#parseYamlFile(java.lang.String)}.
	 * The file contains more data than supported by this yaml functionality.
	 *
	 * @throws IOException When error in the stream handling.
	 */
	@Test
	@Category({IUnitTestCategory.class, ISlowTestCategory.class})
	public final void testParseTooBigYamlFileString() throws IOException {

		final File tooBigFile =
			File.createTempFile("DataBatchUnitTestData_", ".txt");
		tooBigFile.deleteOnExit();
    	final OutputStream outputStream = new FileOutputStream(tooBigFile);
    	long writtenLength = 0;
    	final int noBytesPerWriteTime = 10000000;
    	byte[] bytes = new byte[noBytesPerWriteTime];
    	while (writtenLength <= Integer.MAX_VALUE) {
    		outputStream.write(bytes);
    		writtenLength += noBytesPerWriteTime;
    	}
    	outputStream.close();
        final BatchUt dataBatch = new BatchUt();
        try {
            @SuppressWarnings("unused")
			final Iterable<Object> yamlData =
        		dataBatch.parseYamlFile(tooBigFile);
            fail("Expected exception not received when trying to parse a yaml file that is too big");
        } catch (AssertionError exception) {
        	throw exception;
        } catch (IOException exception) {
        	// OK_NOTUSINGDEF
        } catch (Throwable exception) {
        	fail("Erroneous exception received when trying to parse a yaml file that is too big");
        }
	}

	/**
	 * Asserts a correct wiring of objects read from the yaml file through different
	 * mechanisms like file or resource).
	 *
	 * @param documents The parsed yaml data for assertion.
	 */
	private void assertYamlObjects(final Iterable<Object> documents) {
		int numberOfObjects = 0;
		for (final Object documentObj : documents) {
			numberOfObjects++;
			assertTrue(documentObj instanceof List);
			@SuppressWarnings({ "unchecked", "rawtypes" })
			final List<Object> document = (List)documentObj;
			int numberOfContacts = 0;
			for (final Object contactObj : document) {
				assertTrue(contactObj instanceof ContactRawTestClass);
				@SuppressWarnings("unused")
				final ContactRawTestClass contact = (ContactRawTestClass)contactObj; 
				numberOfContacts++;
			}
			assertEquals(25, numberOfContacts);
		}

		assertEquals(1, numberOfObjects);
	}
	////
	//// END Methods
	//// =======================================================================
}
/*
Revision history:
$Log:$
*/
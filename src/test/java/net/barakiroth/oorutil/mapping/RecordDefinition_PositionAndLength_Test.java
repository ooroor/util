package net.barakiroth.oorutil.mapping;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import net.barakiroth.oorutil.recordparser.IRecordDefinition;
import net.barakiroth.oorutil.recordparser.RecordDefinition_PositionAndLength;
import net.barakiroth.oorutil.recordparser.exceptions.DuplicateKeyRecordParserException;
import net.barakiroth.oorutil.recordparser.exceptions.IllegalArgumentRecordParserException;
import net.barakiroth.oorutil.recordparser.exceptions.StringTooShortRecordParserException;
import net.barakiroth.oorutil.tuples.Tuple002;

public class RecordDefinition_PositionAndLength_Test {

	@Test
	public void testAddFieldDefinition_ExceptionIfIllegalParameters() {

		final IRecordDefinition<String> recordDefinition =
			new RecordDefinition_PositionAndLength<>();

		assertThrows(
				IllegalArgumentRecordParserException.class,
				() -> recordDefinition.addFieldDefinition("Name")
		);

		assertThrows(
				IllegalArgumentRecordParserException.class,
				() -> recordDefinition.addFieldDefinition("Name", "x")
		);

		assertThrows(
				IllegalArgumentRecordParserException.class,
				() -> recordDefinition.addFieldDefinition("Name", 1)
		);

		assertThrows(
				IllegalArgumentRecordParserException.class,
				() -> recordDefinition.addFieldDefinition("Name", "x", 2)
		);

		assertThrows(
				IllegalArgumentRecordParserException.class,
				() -> recordDefinition.addFieldDefinition("Name", 1, "y")
		);

		assertThrows(
				IllegalArgumentRecordParserException.class,
				() -> recordDefinition.addFieldDefinition("Name", 1, 2, "z")
		);

		assertThrows(
				IllegalArgumentRecordParserException.class,
				() -> recordDefinition.addFieldDefinition("Name", null, 2)
		);

		assertThrows(
				IllegalArgumentRecordParserException.class,
				() -> recordDefinition.addFieldDefinition("Name", 1, null)
		);

		assertThrows(
				IllegalArgumentRecordParserException.class,
				() -> recordDefinition.addFieldDefinition("Name", null, null)
		);
	}

	@Test
	public void testAddFieldDefinition_ExceptionIfDuplicateName() {

		final IRecordDefinition<String> recordDefinition =
			new RecordDefinition_PositionAndLength<>();
		
		recordDefinition.addFieldDefinition("Name", 0, 10);

		assertThrows(
			DuplicateKeyRecordParserException.class,
			() -> recordDefinition.addFieldDefinition("Name", 17, 10)
		);
	}

	@Test
	public void testReturnedMapFromParse() {

		final IRecordDefinition<String> recordDefinition =
			new RecordDefinition_PositionAndLength<String>();
		
		recordDefinition.addFieldDefinition("Name1", 0,  7);
		recordDefinition.addFieldDefinition("Name2", 7, 11);

		final Map<String, String> map =
			recordDefinition.parse("Øyvind Roth       ");

		assertEquals("Øyvind "    , map.get("Name1"));
		assertEquals("Roth       ", map.get("Name2"));
	}

	@Test
	public void testParseNullString() {

		final IRecordDefinition<String> recordDefinition =
			new RecordDefinition_PositionAndLength<String>();
		
		recordDefinition.addFieldDefinition("Name1", 0,  7);
		recordDefinition.addFieldDefinition("Name2", 7, 11);

		assertThrows(
				NullPointerException.class,
				() -> recordDefinition.parse(null)
			);
	}

	@Test
	public void testParseEmptyString() {

		final IRecordDefinition<String> recordDefinition =
			new RecordDefinition_PositionAndLength<String>();
		
		recordDefinition.addFieldDefinition("Name1", 0,  7);
		recordDefinition.addFieldDefinition("Name2", 7, 11);

		assertThrows(
				StringTooShortRecordParserException.class,
				() -> recordDefinition.parse("")
			);
	}

	@Test
	public void testParseTooShortString() {

		final IRecordDefinition<String> recordDefinition =
			new RecordDefinition_PositionAndLength<String>();
		
		recordDefinition.addFieldDefinition("Name1", 0,  7);
		recordDefinition.addFieldDefinition("Name2", 7, 11);

		assertThrows(
				StringTooShortRecordParserException.class,
				() -> recordDefinition.parse("Øyvin")
			);
	}

	@Test
	public void testParseStringWithoutFieldDefinitions() {

		final IRecordDefinition<String> recordDefinition =
			new RecordDefinition_PositionAndLength<String>();

		final Map<String, String> map = recordDefinition.parse("");
		
		assertEquals(0, map.size());
	}

	@Test
	public void testParseNullStringWithoutFieldDefinitions() {

		final IRecordDefinition<String> recordDefinition =
			new RecordDefinition_PositionAndLength<String>();

		assertThrows(
				NullPointerException.class,
				() -> recordDefinition.parse(null)
			);
	}

	@Test
	@DisplayName("Test that two keys may refer to the same record field")
	public void testThatTwoKeysMayReferToTheSameRecordField() {

		final IRecordDefinition<String> recordDefinition =
			new RecordDefinition_PositionAndLength<String>();
		
		recordDefinition.addFieldDefinition("Name1", 0, 7);
		recordDefinition.addFieldDefinition("Name2", 0, 7);
		
		final Map<String, String> fieldMap =
			recordDefinition.parse("Tom Per");
		
		assertEquals(2, fieldMap.size());
		assertEquals("Tom Per", fieldMap.get("Name1"));
		assertEquals(fieldMap.get("Name1"), fieldMap.get("Name2"));
		
	}

	@Test
	@DisplayName("Test that the added field definitions are retrieved in correct order using the iterator")
	public void testThatTheAddedFieldDefinitionsAreRetrievedInCorrectOrderUsingTheIterator() {
		final IRecordDefinition<String> recordDefinition =
				new RecordDefinition_PositionAndLength<String>();
			
			recordDefinition.addFieldDefinition("N1", 0,  7);
			recordDefinition.addFieldDefinition("N4", 1,  5);
			recordDefinition.addFieldDefinition("N3", 1,  3);
			recordDefinition.addFieldDefinition("N2", 0,  9);
			recordDefinition.addFieldDefinition("N5", 6, 11);
			recordDefinition.addFieldDefinition("N6", 6, 11);
			recordDefinition.addFieldDefinition("N0", 0,  7);
			
			final String record = "abcdefghijklmnopqrstuvwxyz";
			
			final Iterator<Tuple002<String, String>> it =
				recordDefinition.iterator(record);
			
			Tuple002<String, String> keyValue;
			
			keyValue = it.next();
			assertEquals("N0", keyValue.getV001());
			assertEquals("abcdefg", keyValue.getV002());
			
			keyValue = it.next();
			assertEquals("N1", keyValue.getV001());
			assertEquals("abcdefg", keyValue.getV002());
			
			keyValue = it.next();
			assertEquals("N2", keyValue.getV001());
			assertEquals("abcdefghi", keyValue.getV002());
			
			keyValue = it.next();
			assertEquals("N3", keyValue.getV001());
			assertEquals("bcd", keyValue.getV002());
			
			keyValue = it.next();
			assertEquals("N4", keyValue.getV001());
			assertEquals("bcdef", keyValue.getV002());
			
			keyValue = it.next();
			assertEquals("N5", keyValue.getV001());
			assertEquals("ghijklmnopq", keyValue.getV002());
			
			keyValue = it.next();
			assertEquals("N6", keyValue.getV001());
			assertEquals("ghijklmnopq", keyValue.getV002());
			
			assertThrows(NoSuchElementException.class, () -> it.next());
	}

	@Test
	public void testFieldDefinitionComparedToNull() {
		final RecordDefinition_PositionAndLength.FieldDefinition<String> fieldDefinition =
			new RecordDefinition_PositionAndLength.FieldDefinition<String>("a", 1, 2);
		
		assertThrows(
				NullPointerException.class,
				() -> fieldDefinition.compareTo(null));
	}
}
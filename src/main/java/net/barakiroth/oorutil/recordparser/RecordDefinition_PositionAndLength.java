package net.barakiroth.oorutil.recordparser;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.common.collect.SortedMultiset;
import com.google.common.collect.TreeMultiset;

import lombok.AccessLevel;
import lombok.Getter;
import net.barakiroth.oorutil.recordparser.exceptions.AbstractRecordParserException;
import net.barakiroth.oorutil.recordparser.exceptions.DuplicateKeyRecordParserException;
import net.barakiroth.oorutil.recordparser.exceptions.IllegalArgumentRecordParserException;
import net.barakiroth.oorutil.recordparser.exceptions.StringTooShortRecordParserException;
import net.barakiroth.oorutil.tuples.Tuple002;

public class RecordDefinition_PositionAndLength<KEYTYPE extends Comparable<KEYTYPE>>
	implements IRecordDefinition<KEYTYPE> {
	
	public static class FieldDefinition<KEYTYPE extends Comparable<KEYTYPE>>
		implements IFieldDefinition<KEYTYPE>, Comparable<FieldDefinition<KEYTYPE>> {

		private final KEYTYPE key;

		@Getter(AccessLevel.PUBLIC)
		private final int     position;

		@Getter(AccessLevel.PUBLIC)
		private final int     length;
		
		public FieldDefinition(
				final KEYTYPE key,
				final int     position,
				final int     length
		) {
			this.key      = key;
			this.position = position;
			this.length   = length;
		}

		@Override
		public KEYTYPE getKey() {
			return this.key;
		}

		@Override
		public int compareTo(final FieldDefinition<KEYTYPE> otherFieldDefinition) {
			if (otherFieldDefinition == null) {
				throw new NullPointerException();
			} else {
				return
						(this.position < otherFieldDefinition.position)
						?
						-1
						:
							(this.position > otherFieldDefinition.position)
							?
							1
							:
								(this.length < otherFieldDefinition.length)
								?
								-1
								:
									(this.length > otherFieldDefinition.length)
									?
									1
									:
									(this.key.compareTo(otherFieldDefinition.key))
						;
			
			}
		}
	}

	private final Set<KEYTYPE> keys = new HashSet<KEYTYPE>();

	private final SortedMultiset<FieldDefinition<KEYTYPE>> fieldDefinitions =
		TreeMultiset.create();	
	
	@Override
	public void addFieldDefinition(
			final KEYTYPE   key,
			final Object... fieldDefinitionParameters) {

		try {
			if (fieldDefinitionParameters.length != 2) {
				throw new IllegalArgumentException("Illegal number of arguments");
			}
			if (
					(key == null)
					||
					(fieldDefinitionParameters[0] == null)
					||
					(fieldDefinitionParameters[1] == null)
			) {
				throw new NullPointerException("One or more parameters is null");
			}
			addFieldDefinition(
					key,
					(Integer)fieldDefinitionParameters[0],
					(Integer)fieldDefinitionParameters[1]
			);
		} catch(Throwable e) {
			if (e instanceof AbstractRecordParserException) {
				throw e;
			} else {
				throw new IllegalArgumentRecordParserException(e);
			}
		}
	}

	@Override
	public Map<KEYTYPE, String> parse(final String record) {
		
		if (record == null) {
			throw new NullPointerException("The record method parameter is null");
		}

		final Iterator<Tuple002<KEYTYPE, String>> iterator = iterator(record);
		final Map<KEYTYPE, String> map = new HashMap<KEYTYPE, String>();
		while (iterator.hasNext()) {
			final Tuple002<KEYTYPE, String> entry = iterator.next();
			map.put(entry.getV001(), entry.getV002());
		}

		return Collections.unmodifiableMap(map);
	}

	public Iterator<Tuple002<KEYTYPE, String>> iterator(final String record) {
		
		final Iterator<Tuple002<KEYTYPE, String>> iterator =
			new Iterator<Tuple002<KEYTYPE, String>>() {
			
				final Iterator<FieldDefinition<KEYTYPE>> fieldDefinitionIterator =
					fieldDefinitions.iterator();

				@Override
				public boolean hasNext() {
					
					return fieldDefinitionIterator.hasNext();
				}

				@Override
				public Tuple002<KEYTYPE, String> next() {

					final FieldDefinition<KEYTYPE> fieldDefinition =
							fieldDefinitionIterator.next();
					final String field;
					try {
						field =
							record.substring(
								fieldDefinition.getPosition(),
								fieldDefinition.getPosition() + fieldDefinition.getLength()
							);
					} catch (StringIndexOutOfBoundsException e) {
						throw new StringTooShortRecordParserException(e, record);
					}
					
					final Tuple002<KEYTYPE, String> entry =
						new Tuple002<KEYTYPE, String>(fieldDefinition.getKey(), field);

					return entry;
				}
		};
		
		return iterator;
	}

	public void addFieldDefinition(
			final KEYTYPE key,
			final Integer position,
			final Integer length) {

		
		if (!keys.add(key)) {
			throw new DuplicateKeyRecordParserException();
		} else {
			final FieldDefinition<KEYTYPE> fieldDefinition =
				new FieldDefinition<KEYTYPE>(key, position, length);
			this.fieldDefinitions.add(fieldDefinition);
		}
	}
}
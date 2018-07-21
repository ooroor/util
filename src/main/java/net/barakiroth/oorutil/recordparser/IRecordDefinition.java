package net.barakiroth.oorutil.recordparser;

import java.util.Iterator;
import java.util.Map;

import net.barakiroth.oorutil.tuples.Tuple002;

public interface IRecordDefinition<KEYTYPE> {

	void addFieldDefinition(
			final KEYTYPE   key,
			final Object... fieldDefinitionParameters);

	Map<KEYTYPE, String> parse(final String record);
	
	Iterator<Tuple002<KEYTYPE, String>> iterator(final String record);
}
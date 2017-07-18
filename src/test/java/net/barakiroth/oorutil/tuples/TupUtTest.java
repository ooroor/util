package net.barakiroth.oorutil.tuples;

import static org.junit.Assert.assertEquals;

import org.javatuples.Pair;
import org.javatuples.Tuple;
import org.junit.Test;

public class TupUtTest {

	@Test
	public void testConcatenate() {
		
		final Tuple tuple =
			new Pair<Integer, String>((Integer)1, "hello world!");
		final String separator = "¤";
		
		final String expectedConcatenation = "1" + separator + "hello world!";
		final String actualConcatenation = TupUt.concatenate(tuple, separator);
		
		assertEquals(expectedConcatenation, actualConcatenation);
	}

	@Test
	public void testConcatenate_firstNull() {
		
		final Tuple tuple =
			new Pair<Integer, String>((Integer)null, "hello world!");
		final String separator = "¤";
		
		final String expectedConcatenation = "hello world!";
		final String actualConcatenation = TupUt.concatenate(tuple, separator);
		
		assertEquals(expectedConcatenation, actualConcatenation);
	}

	@Test
	public void testConcatenate_secondNull() {
		
		final Tuple tuple =
			new Pair<Integer, String>((Integer)1, (String)null);
		final String separator = "¤";
		
		final String expectedConcatenation = "1";
		final String actualConcatenation = TupUt.concatenate(tuple, separator);
		
		assertEquals(expectedConcatenation, actualConcatenation);
	}

	@Test
	public void testConcatenate_separatorNull() {
		
		final Tuple tuple =
			new Pair<Integer, String>((Integer)1, "hello world!");
		final String separator = null;
		
		final String expectedConcatenation = "1hello world!";
		final String actualConcatenation = TupUt.concatenate(tuple, separator);
		
		assertEquals(expectedConcatenation, actualConcatenation);
	}
	
	// =========================================================================

	/**
	 * Confirm that the constructor does not crash.
	 */
	@Test
	public void testTupUt_constructor() {
		
		new TupUt();
	}
	
	// =========================================================================
	/*
	@Test
	public void testTupUt_decadePermutator() {
		final DecadePermutator decadePermutator =
			new DecadePermutator(
				  new Integer[]{1,3}
				, new String[]{"a", "b"}
				);
		new TupUt();
	}
	*/
}
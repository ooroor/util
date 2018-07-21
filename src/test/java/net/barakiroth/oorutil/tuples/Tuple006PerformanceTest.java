// Copyright (C) 2014 barakiroth.net
// All rights reserved
package net.barakiroth.oorutil.tuples;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.javatuples.Sextet;
import org.junit.experimental.categories.Category;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;
import net.barakiroth.oortestutil.IPerformanceTestCategory;
import net.barakiroth.oortestutil.ISlowTestCategory;

/** Tests {@link Tuple006Permutator}.
 */
public class Tuple006PerformanceTest {
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
	/**
	 * For logging purposes, e.g. to file.
	 */
	@SuppressWarnings("unused")
	private final static Logger logger =
		(Logger)LoggerFactory.getLogger(Tuple006PerformanceTest.class);
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
	 * @throws java.lang.Exception if something unexpected occurs.
	 */
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception if something unexpected occurs.
	 */
	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception if something unexpected occurs.
	 */
	@BeforeEach
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception if something unexpected occurs.
	 */
	@AfterEach
	public void tearDown() throws Exception {
	}
	
	//// =======================================================================
	/**
	 * Tests {@link Tuple004}.
	 */
	@Test
	@Category({IPerformanceTestCategory.class, ISlowTestCategory.class})
	public final void testCompareTuple006PerformanceWithJavatuples() {

		final String expectedT1 = "ABC";
		final Boolean expectedT2 = true;
		final String expectedT3 = "ABC";
		final Integer expectedT4 = 117;
		final Long expectedT5 = 312L;
		final String expectedT6 = "ABC";
		
		// =====================================================================

		final DescriptiveStatistics stats = new DescriptiveStatistics();
		final int numberOfTests = 300;
		final int numberOfStatements = 300000;
		final double[] ratios = new double[numberOfTests];
		String all = null;
		final int[] dummys = new int[]{1000};
		for (int j = 0; j < numberOfTests; j++) {

			long startTime;
			long stopTime;

			// =================================================================

			startTime = System.currentTimeMillis();
			for(int i = 0; i < numberOfStatements; i++) {
				final Tuple006<String, Boolean, String, Integer, Long, String> tuple =
						new Tuple006<String, Boolean, String, Integer, Long, String>(expectedT1, expectedT2, expectedT3, expectedT4, expectedT5, expectedT6);
				final String t1 = tuple.getV001();
				final Boolean t2 = tuple.getV002();
				final String t3 = tuple.getV003();
				final Integer t4 = tuple.getV004();
				final Long t5 = tuple.getV005();
				final String t6 = tuple.getV006();
				if (dummys[0] == 0) {
					all = t1 + t2 + t3 + t4 + t5 + t6;
				}
			} // END for

			stopTime = System.currentTimeMillis();
			final long elapsed1 = stopTime - startTime;

			// =================================================================

			startTime = System.currentTimeMillis();
			for(int i = 0; i < numberOfStatements; i++) {
				final Sextet<String, Boolean, String, Integer, Long, String> tuple =
						new Sextet<String, Boolean, String, Integer, Long, String>(expectedT1, expectedT2, expectedT3, expectedT4, expectedT5, expectedT6);
				final String t1 = tuple.getValue0();
				final Boolean t2 = tuple.getValue1();
				final String t3 = tuple.getValue2();
				final Integer t4 = tuple.getValue3();
				final Long t5 = tuple.getValue4();
				final String t6 = tuple.getValue5();
				if (dummys[0] == 0) {
					all = t1 + t2 + t3 + t4 + t5 + t6;
				}
			} // END for

			stopTime = System.currentTimeMillis();
			final long elapsed2 = stopTime - startTime;

			// =================================================================

			ratios[j] = ((double)(elapsed2 - elapsed1)*100.0)/(double)elapsed1;
			stats.addValue(ratios[j]);
			System.out.println(
					  System.lineSeparator()
					+ "elapsed1 (Tuple004)                                    : " + elapsed1 + System.lineSeparator()
					+ "elapsed2 (Quartet)                                     : " + elapsed2 + System.lineSeparator()
					+ "delta(elapsed2 - elapsed1) [delta(Quartet - Tuple004)] : " + (elapsed2 - elapsed1) + System.lineSeparator()
					+ "delta*100/elapsed1                                     : " + ratios[j] + "%" + System.lineSeparator()
					);
		} // END for

		System.out.println(
				  System.lineSeparator()
				+ "numberOfStatements (of ratios): " + numberOfStatements + System.lineSeparator()
				+ "n                  (of ratios): " + stats.getN() + System.lineSeparator()
				+ "min                (of ratios): " + stats.getMin() + System.lineSeparator()
				+ "max                (of ratios): " + stats.getMax() + System.lineSeparator()
				+ "median             (of ratios): " + stats.getPercentile(50) + System.lineSeparator()
				+ "mean               (of ratios): " + stats.getMean() + System.lineSeparator()
				+ "std                (of ratios): " + stats.getStandardDeviation() + System.lineSeparator()
				+ "variance           (of ratios): " + stats.getVariance() + System.lineSeparator()
				+ "[all               (of ratios): " + all + "]" + System.lineSeparator()
				);		
	}
	////
	//// END Methods
	//// =======================================================================
}
/*
Revision history:
$Log:$
*/
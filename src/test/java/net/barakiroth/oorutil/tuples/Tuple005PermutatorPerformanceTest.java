// Copyright (C) 2014 barakiroth.net
// All rights reserved
package net.barakiroth.oorutil.tuples;

import java.time.LocalDateTime;
import java.time.Month;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.javatuples.Quintet;
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
import net.barakiroth.oorutil.tuples.TupUt.QuintetPermutator;

public class Tuple005PermutatorPerformanceTest {
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
		(Logger)LoggerFactory.getLogger(Tuple005PermutatorPerformanceTest.class);
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
	 * Tests
	 * {@link QuintetPermutator}
	 * against
	 * {@link Tuple005Permutator}
	 * as to performance.
	 */
	@Test
	@Category({IPerformanceTestCategory.class, ISlowTestCategory.class})
	public void testCompareT005WithJavatuples() {
		
		// =====================================================================

		final DescriptiveStatistics stats = new DescriptiveStatistics();

		final QuintetPermutator<String, Integer, Boolean, Long, LocalDateTime> jtPerm =
				new QuintetPermutator<String, Integer, Boolean, Long, LocalDateTime>(
						  new String[]{null, "Hei", "Kløne"}
						, new Integer[]{1, 3, 5, 7, 11, 13}
						, new Boolean[]{null, true, false}
						, new Long[]{23L, 29L, 31L, 37L, 41L, 43L}
						, new LocalDateTime[]{LocalDateTime.of(1956, Month.DECEMBER, 19, 12, 32, 14), LocalDateTime.of(1964, Month.APRIL, 1, 7, 11, 59)}
						);

		final Tuple005Permutator<String, Integer, Boolean, Long, LocalDateTime> t5Perm =
				new Tuple005Permutator<String, Integer, Boolean, Long, LocalDateTime>(
						  new String[]{null, "Hei", "Kløne"}
						, new Integer[]{1, 3, 5, 7, 11, 13}
						, new Boolean[]{null, true, false}
						, new Long[]{23L, 29L, 31L, 37L, 41L, 43L}
						, new LocalDateTime[]{LocalDateTime.of(1956, Month.DECEMBER, 19, 12, 32, 14), LocalDateTime.of(1964, Month.APRIL, 1, 7, 11, 59)}
						);
		
		// =====================================================================

		final int numberOfTests = 15;
		final int numberOfStatements = 1000;
		final double[] ratios = new double[numberOfTests];
		String all = null;
		final int[] dummys = new int[]{1000};
		
		for (int j = 0; j < numberOfTests; j++) {
				
				long start = System.currentTimeMillis();
				for (int runCnt2 = 0; runCnt2 < numberOfTests; runCnt2++) {
					start = System.currentTimeMillis();
					for (int permCnt = 0; permCnt < numberOfStatements; permCnt++) {
						for (final Tuple005<String, Integer, Boolean, Long, LocalDateTime> tuple : t5Perm) {
							final String s = tuple.getV001();
							final Integer i = tuple.getV002();
							final Boolean b = tuple.getV003();
							final Long l = tuple.getV004();
							final LocalDateTime d = tuple.getV005();
							if (dummys[0] == 0) {
								all = s + i + b + l + d + d;
							}
						}
					}
				}
				long stop = System.currentTimeMillis();
				final long elapsed1 = stop - start;

				start = System.currentTimeMillis();
				for (int permCnt = 0; permCnt < numberOfStatements; permCnt++) {
					for (final Quintet<String, Integer, Boolean, Long, LocalDateTime> tuple : jtPerm) {
						final String s = tuple.getValue0();
						final Integer i = tuple.getValue1();
						final Boolean b = tuple.getValue2();
						final Long l = tuple.getValue3();
						final LocalDateTime d = tuple.getValue4();
						if (dummys[0] == 0) {
							all = s + i + b + l + d + d;
						}
					}
				}
				stop = System.currentTimeMillis();
				final long elapsed2 = stop - start;

				// =================================================================

				ratios[j] = ((double)(elapsed2 - elapsed1)*100.0)/(double)elapsed1;
				stats.addValue(ratios[j]);
				System.out.println(
						  System.lineSeparator()
						+ "elapsed1 (Tuple005)                                    : " + elapsed1 + System.lineSeparator()
						+ "elapsed2 (Quintet)                                     : " + elapsed2 + System.lineSeparator()
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
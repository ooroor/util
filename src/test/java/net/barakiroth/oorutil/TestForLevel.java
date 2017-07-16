package net.barakiroth.oorutil;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.Logger;

public class TestForLevel {
	
	private final static List<Level> testLevels =
		Collections.unmodifiableList(Arrays.asList(new Level[]{Level.DEBUG, Level.OFF}));
	
	public static <T, R> void testForLevels(
	    final Runnable     runnable
	  , final Class<?> ... clazzes) {
		
		for (final Class<?> clazz : clazzes) {
			testLevels.forEach(
				level ->
				{
					((Logger) LoggerFactory.getLogger(clazz.getName())).setLevel(level);
					runnable.run();
				}
			);
		};
	}
}
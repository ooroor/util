package net.barakiroth.oorutil;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class VerySmartLibraryTest {
	
	@Test
	public void testReturnSame() {

		TestForLevel.testForLevels(
			() ->
			{
				final VerySmartLibrary verySmartLibrary =
					new VerySmartLibrary();
				final String expected ="Hello world!";
				final String actual = verySmartLibrary.returnSame(expected);
				assertEquals(expected, actual);
			}
			, VerySmartLibrary.class
		);

	}
}
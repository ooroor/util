package net.barakiroth.oorutil;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SomeTemplateBeanTest {
	
	// =========================================================================
	
	@Test
	public void testGetA() {

		TestForLevel.testForLevels(
			() ->
			{
				final SomeTemplateBean someTemplateBean = new SomeTemplateBean();
				final String expected = "xyz";
				someTemplateBean.setS(expected);
				final String actual = someTemplateBean.getS();
				assertEquals(expected, actual);
			}
			, SomeTemplateBean.class
		);
	}
	
	// =========================================================================

	@Test
	public void testEquals() {

		TestForLevel.testForLevels(
			() ->
			{
				final SomeTemplateBean someTemplateBean1 = new SomeTemplateBean();
				someTemplateBean1.setS("ax12");
				final SomeTemplateBean someTemplateBean2 = new SomeTemplateBean();
				someTemplateBean2.setS("ax12");
				assertTrue(someTemplateBean1.equals(someTemplateBean2));
				assertTrue(someTemplateBean2.equals(someTemplateBean1));
			}
			, SomeTemplateBean.class
		);
	}

	@Test
	public void testEquals_sameObject() {

		TestForLevel.testForLevels(
			() ->
			{
				final SomeTemplateBean someTemplateBean1 = new SomeTemplateBean();
				someTemplateBean1.setS("ax12");
				assertTrue(someTemplateBean1.equals(someTemplateBean1));
			}
			, SomeTemplateBean.class
		);
	}

	@Test
	public void testEquals_differentClasses() {

		TestForLevel.testForLevels(
			() ->
			{
				final SomeTemplateBean someTemplateBean1 = new SomeTemplateBean();
				someTemplateBean1.setS("ax12");
				final String s = "abc";
				assertFalse(someTemplateBean1.equals(s));
				assertFalse(s.equals(someTemplateBean1));
			}
			, SomeTemplateBean.class
		);
	}

	@Test
	public void testEquals_differentObjects() {

		TestForLevel.testForLevels(
			() ->
			{
				final SomeTemplateBean someTemplateBean1 = new SomeTemplateBean();
				someTemplateBean1.setS("ax12");
				final SomeTemplateBean someTemplateBean2 = new SomeTemplateBean();
				someTemplateBean2.setS("ax11");
				assertFalse(someTemplateBean1.equals(someTemplateBean2));
				assertFalse(someTemplateBean2.equals(someTemplateBean1));
			}
			, SomeTemplateBean.class
		);
	}

	@Test
	public void testEquals_differentObjectsOneNotNullValueOtherNullValue() {

		TestForLevel.testForLevels(
			() ->
			{
				final SomeTemplateBean someTemplateBean1 = new SomeTemplateBean();
				someTemplateBean1.setS("ax12");
				final SomeTemplateBean someTemplateBean2 = new SomeTemplateBean();
				someTemplateBean2.setS(null);
				assertFalse(someTemplateBean1.equals(someTemplateBean2));
				assertFalse(someTemplateBean2.equals(someTemplateBean1));
			}
			, SomeTemplateBean.class
		);
	}

	@Test
	public void testEquals_differentObjectsBothNullValue() {

		TestForLevel.testForLevels(
			() ->
			{
				final SomeTemplateBean someTemplateBean1 = new SomeTemplateBean();
				someTemplateBean1.setS(null);
				final SomeTemplateBean someTemplateBean2 = new SomeTemplateBean();
				someTemplateBean2.setS(null);
				assertTrue(someTemplateBean1.equals(someTemplateBean2));
				assertTrue(someTemplateBean2.equals(someTemplateBean1));
			}
			, SomeTemplateBean.class
		);
	}

	@Test
	public void testEquals_equal_sub() {

		TestForLevel.testForLevels(
			() ->
			{
				final SomeTemplateBean someTemplateBean1 = new SomeTemplateBean();
				someTemplateBean1.setS("ax12");
				final SomeTemplateBeanSub someTemplateBean2 = new SomeTemplateBeanSub();
				someTemplateBean2.setS("ax12");
				assertFalse(someTemplateBean1.equals(someTemplateBean2));
				assertFalse(someTemplateBean2.equals(someTemplateBean1));
			}
			, SomeTemplateBean.class
		);
	}	
	
	// =========================================================================	

	@Test
	public void testHashCode_different_same_class() {

		TestForLevel.testForLevels(
			() ->
			{
				final SomeTemplateBean someTemplateBean1 = new SomeTemplateBean();
				someTemplateBean1.setS("ax12");
				final SomeTemplateBean someTemplateBean2 = new SomeTemplateBean();
				someTemplateBean2.setS("ax13");
				assertNotEquals(someTemplateBean1.hashCode(), someTemplateBean2.hashCode());
			}
			, SomeTemplateBean.class
		);
	}

	@Test
	public void testHashCode_equal_same_class() {

		TestForLevel.testForLevels(
			() ->
			{
				final SomeTemplateBean someTemplateBean1 = new SomeTemplateBean();
				someTemplateBean1.setS("ax13");
				final SomeTemplateBean someTemplateBean2 = new SomeTemplateBean();
				someTemplateBean2.setS("ax13");
				assertEquals(someTemplateBean1.hashCode(), someTemplateBean2.hashCode());
			}
			, SomeTemplateBean.class
		);
	}

	@Test
	public void testHashCode_null_s_same_class() {

		TestForLevel.testForLevels(
			() ->
			{
				final SomeTemplateBean someTemplateBean1 = new SomeTemplateBean();
				someTemplateBean1.setS(null);
				final SomeTemplateBean someTemplateBean2 = new SomeTemplateBean();
				someTemplateBean2.setS("ax13");
				assertNotEquals(someTemplateBean1.hashCode(), someTemplateBean2.hashCode());
			}
			, SomeTemplateBean.class
		);
	}
	
	// =========================================================================

	@Test
	public void testToString() {

		TestForLevel.testForLevels(
			() ->
			{
				final SomeTemplateBean someTemplateBean1 = new SomeTemplateBean();
				someTemplateBean1.setS("ax12");
				final SomeTemplateBean someTemplateBean2 = new SomeTemplateBean();
				someTemplateBean2.setS("ax12");
				assertEquals(someTemplateBean1.toString(), someTemplateBean2.toString());
			}
			, SomeTemplateBean.class
		);
	}
	
	// =========================================================================
}
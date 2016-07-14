package org.eclipse.xtend.ide.tests.data.highlighting;

import org.junit.Test;

@Deprecated
public class TestClassDeprecated {
	@Deprecated
	public static String DEPRECATED_CONSTANT = "foo";
	
	@Deprecated
	public static String CONSTANT = "foo";

	@Deprecated
	@Test
	public void testMethodDeprecated() {
	}

	@Test
	public void testMethodNotDeprecated() {
	}

	@Deprecated
	public static void testMethodStaticDeprecated() {
	}

	public static void testMethodStaticNotDeprecated() {
	}
};
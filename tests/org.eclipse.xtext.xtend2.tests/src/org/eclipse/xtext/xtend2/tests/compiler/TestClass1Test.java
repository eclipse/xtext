package org.eclipse.xtext.xtend2.tests.compiler;

import junit.framework.TestCase;

public class TestClass1Test extends TestCase {
	public void testFunction() throws Exception {
		assertEquals(42,new TestClass1().testFunction1().intValue());
		assertEquals(42,new TestClass1().testFunction2().intValue());
		assertEquals(42,new TestClass1().testFunction2().intValue());
	}
}

package org.eclipse.xtext.xtend2.tests.compiler;

import junit.framework.TestCase;

public class TestClass1Test extends TestCase {
	public void testFunction() throws Exception {
		assertEquals(42,new TestClass1().testFunction1());
		assertEquals(42,new TestClass1().testFunction2());
		assertEquals(42,new TestClass1().testFunction3().intValue());
		assertEquals(42,new TestClass1().testFunction4().intValue());
	}
}

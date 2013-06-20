package org.eclipse.xtend.core.tests.compiler;

import org.junit.Assert;
import org.junit.Test;

public class TestClass1Test extends Assert {
	@Test public void testFunction() throws Exception {
		assertEquals(42,new TestClass1().testFunction1());
		assertEquals(42,new TestClass1().testFunction2());
		assertEquals(42,new TestClass1().testFunction3().intValue());
		assertEquals(42,new TestClass1().testFunction4().intValue());
	}
}

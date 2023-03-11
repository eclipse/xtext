/*******************************************************************************
 * Copyright (c) 2010, 2022 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
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

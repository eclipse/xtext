/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PrimitivesTest extends Assert {

	@Test public void testForName_01() {
		for(Class<?> expected: Primitives.ALL_PRIMITIVE_TYPES) {
			assertSame(expected, Primitives.forName(expected.getName()));
		}
	}
	
	@Test public void testForName_02() {
		assertNull(Primitives.forName("unknown"));
	}
	
	@Test public void testAllPrimitiveTypes() {
		assertEquals(9, Primitives.ALL_PRIMITIVE_TYPES.size());
	}
}

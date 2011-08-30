/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types.access.impl;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PrimitivesTest extends TestCase {

	public void testForName_01() {
		for(Class<?> expected: Primitives.ALL_PRIMITIVE_TYPES) {
			assertSame(expected, Primitives.forName(expected.getName()));
		}
	}
	
	public void testForName_02() {
		assertNull(Primitives.forName("unknown"));
	}
	
	public void testAllPrimitiveTypes() {
		assertEquals(9, Primitives.ALL_PRIMITIVE_TYPES.length);
	}
}

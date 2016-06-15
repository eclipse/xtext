/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmPrimitiveTypeTest extends Assert {

	private JvmPrimitiveType primitiveType;

	@Before
	public void setUp() throws Exception {
		primitiveType = TypesFactory.eINSTANCE.createJvmPrimitiveType();
	}
	
	@Test public void testGetIdentifier_01() {
		assertNull(primitiveType.getIdentifier());
	}
	
	@Test public void testGetIdentifier_02() {
		primitiveType.setSimpleName("int");
		assertEquals("int", primitiveType.getIdentifier());
	}
	
	@Test public void testQualifiedName() {
		primitiveType.setSimpleName("int");
		assertEquals("int", primitiveType.getQualifiedName());
		assertEquals("int", primitiveType.getQualifiedName('$'));
	}
}

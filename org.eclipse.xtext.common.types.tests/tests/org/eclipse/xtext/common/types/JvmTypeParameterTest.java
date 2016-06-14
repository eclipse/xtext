/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmTypeParameterTest extends JvmComponentTypeTest {

	private JvmTypeParameter typeParameter;

	@Before
	public void setUp() throws Exception {
		typeParameter = TypesFactory.eINSTANCE.createJvmTypeParameter();
	}
	
	@Override
	protected JvmTypeParameter getObjectUnderTest() {
		return typeParameter;
	}
	
	@Test public void testGetIdentifier_01() {
		assertNull(typeParameter.getIdentifier());
	}
	
	@Test public void testGetIdentifier_02() {
		String name = "T";
		typeParameter.setName(name);
		assertEquals("T", typeParameter.getIdentifier());
	}
}

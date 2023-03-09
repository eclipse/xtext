/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmFormalParameterTest extends Assert {

	private JvmFormalParameter formalParameter;

	@Before
	public void setUp() throws Exception {
		formalParameter = TypesFactory.eINSTANCE.createJvmFormalParameter();
	}
	
	@Test public void testGetIdentifier_01() {
		assertNull(formalParameter.getIdentifier());
	}
	
	@Test
	public void testGetIdentifier_02() {
		formalParameter.setName("param");
		assertEquals("param", formalParameter.getQualifiedName());
		assertEquals("param", formalParameter.getSimpleName());
		assertEquals("param", formalParameter.getIdentifier());
	}
	
	@Test public void testToString_01() {
		assertNotNull("toString() should not throw NPE and not return null", formalParameter.toString());
	}
}

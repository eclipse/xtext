/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class WildcardTypeParameterTest extends TestCase {

	private WildcardTypeParameter typeParameter;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		typeParameter = TypesFactory.eINSTANCE.createWildcardTypeParameter();
	}
	
	public void testCanonicalName_01() {
		assertNull(typeParameter.getCanonicalName());
	}
	
	public void testCanonicalName_02() {
		typeParameter.setWildcard(TypesFactory.eINSTANCE.createWildcard());
		assertEquals("?", typeParameter.getCanonicalName());
	}
	
}

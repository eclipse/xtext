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
public class ParameterizedTypeTest extends TestCase {

	private ParameterizedType parameterizedType;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		parameterizedType = TypesFactory.eINSTANCE.createParameterizedType();
	}
	
	public void testCanonicalName_01() {
		assertNull(parameterizedType.getCanonicalName());
	}
	
	public void testCanonicalName_02() {
		parameterizedType.setFullyQualifiedName("java.util.List<T>");
		assertEquals("java.util.List<T>", parameterizedType.getCanonicalName());
	}
	
}

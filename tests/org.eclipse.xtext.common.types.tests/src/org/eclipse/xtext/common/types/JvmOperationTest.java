/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.eclipse.xtext.common.types.impl.JvmOperationImpl;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmOperationTest extends TestCase {

	private JvmOperationImpl operation;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		operation = (JvmOperationImpl) TypesFactory.eINSTANCE.createJvmOperation();
	}
	
	public void testCanonicalName_01() {
		assertNull(operation.getIdentifier(), operation.getIdentifier());
	}

//	public void testCanonicalName_02() {
//		operation.setCanonicalName("java.lang.String.charAt(int)");
//		assertEquals("java.lang.String.charAt(int)", operation.getCanonicalName());
//	}
//	
//	public void testGetSimpleName_01() {
//		assertNull(operation.getSimpleName());
//	}
//	
//	public void testGetSimpleName_02() {
//		operation.setCanonicalName("java.lang.String.charAt(int)");
//		assertEquals("charAt", operation.getSimpleName());
//	}
}

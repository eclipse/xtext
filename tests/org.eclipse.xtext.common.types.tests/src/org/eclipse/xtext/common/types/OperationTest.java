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
public class OperationTest extends TestCase {

	private Operation operation;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		operation = TypesFactory.eINSTANCE.createOperation();
	}
	
	public void testCanonicalName_01() {
		assertNull(operation.getCanonicalName(), operation.getCanonicalName());
	}
	
	public void testCanonicalName_02() {
		operation.setFullyQualifiedName("java.lang.String.charAt(int)");
		assertEquals("java.lang.String.charAt(int)", operation.getCanonicalName());
	}
	
	public void testGetSimpleName_01() {
		assertNull(operation.getSimpleName());
	}
	
	public void testGetSimpleName_02() {
		operation.setFullyQualifiedName("java.lang.String.charAt(int)");
		assertEquals("charAt", operation.getSimpleName());
	}
}

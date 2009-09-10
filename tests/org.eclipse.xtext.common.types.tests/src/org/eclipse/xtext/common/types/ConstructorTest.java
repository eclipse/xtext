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
public class ConstructorTest extends TestCase {

	private Constructor constructor;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		constructor = TypesFactory.eINSTANCE.createConstructor();
	}
	
	public void testCanonicalName_01() {
		assertNull(constructor.getCanonicalName(), constructor.getCanonicalName());
	}
	
	public void testCanonicalName_02() {
		constructor.setFullyQualifiedName("java.lang.String()");
		assertEquals("java.lang.String()", constructor.getCanonicalName());
	}
	
}

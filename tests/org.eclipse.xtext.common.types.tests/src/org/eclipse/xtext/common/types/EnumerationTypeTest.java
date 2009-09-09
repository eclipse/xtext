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
public class EnumerationTypeTest extends TestCase {

	private EnumerationType enumerationType;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		enumerationType = TypesFactory.eINSTANCE.createEnumerationType();
	}
	
	public void testCanonicalName_01() {
		assertNull(enumerationType.getCanonicalName());
	}
	
	public void testCanonicalName_02() {
		enumerationType.setFullyQualifiedName("java.lang.annotation.RetentionPolicy");
		assertEquals("java.lang.annotation.RetentionPolicy", enumerationType.getCanonicalName());
	}
	
	public void testCanonicalName_03() {
		GenericType outerType = TypesFactory.eINSTANCE.createGenericType();
		outerType.getMembers().add(enumerationType);
		enumerationType.setFullyQualifiedName("java.lang.annotation.RetentionPolicy.Something");
		assertEquals("java.lang.annotation.RetentionPolicy.Something", enumerationType.getCanonicalName());
	}
	
}

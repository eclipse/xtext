/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.eclipse.xtext.common.types.impl.JvmEnumerationTypeImpl;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmEnumerationTypeTest extends TestCase {

	private JvmEnumerationTypeImpl enumerationType;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		enumerationType = (JvmEnumerationTypeImpl) TypesFactory.eINSTANCE.createJvmEnumerationType();
	}
	
	public void testCanonicalName_01() {
		assertNull(enumerationType.getIdentifier());
	}
	
	public void testCanonicalName_02() {
		enumerationType.internalSetIdentifier("java.lang.annotation.RetentionPolicy");
		assertEquals("java.lang.annotation.RetentionPolicy", enumerationType.getIdentifier());
	}
	
	public void testCanonicalName_03() {
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.getMembers().add(enumerationType);
		enumerationType.internalSetIdentifier("java.lang.annotation.RetentionPolicy.Something");
		assertEquals("java.lang.annotation.RetentionPolicy.Something", enumerationType.getIdentifier());
	}
	
}

/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.eclipse.xtext.common.types.impl.JvmAnnotationTypeImpl;

import junit.framework.TestCase;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmAnnotationTypeTest extends TestCase {

	private JvmAnnotationType annotationType;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		annotationType = TypesFactory.eINSTANCE.createJvmAnnotationType();
	}
	
	public void testCanonicalName_01() {
		assertNull(annotationType.getIdentifier());
	}
	
	public void testCanonicalName_02() {
		annotationType.internalSetIdentifier("java.lang.Override");
		assertEquals("java.lang.Override", annotationType.getIdentifier());
	}
	
	public void testCanonicalName_03() {
		JvmGenericType outerType = TypesFactory.eINSTANCE.createJvmGenericType();
		outerType.getMembers().add(annotationType);
		annotationType.internalSetIdentifier("java.lang.Override.Something");
		assertEquals("java.lang.Override.Something", annotationType.getIdentifier());
	}
	
}

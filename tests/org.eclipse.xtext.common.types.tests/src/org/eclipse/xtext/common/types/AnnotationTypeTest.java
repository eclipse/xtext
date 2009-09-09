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
public class AnnotationTypeTest extends TestCase {

	private AnnotationType annotationType;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		annotationType = TypesFactory.eINSTANCE.createAnnotationType();
	}
	
	public void testCanonicalName_01() {
		assertNull(annotationType.getCanonicalName());
	}
	
	public void testCanonicalName_02() {
		annotationType.setFullyQualifiedName("java.lang.Override");
		assertEquals("java.lang.Override", annotationType.getCanonicalName());
	}
	
	public void testCanonicalName_03() {
		GenericType outerType = TypesFactory.eINSTANCE.createGenericType();
		outerType.getMembers().add(annotationType);
		annotationType.setFullyQualifiedName("java.lang.Override.Something");
		assertEquals("java.lang.Override.Something", annotationType.getCanonicalName());
	}
	
}

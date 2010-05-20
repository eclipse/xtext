/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
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
public class JvmByteAnnotationValueTest extends TestCase {

	private JvmByteAnnotationValue byteAnnotationValue;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		byteAnnotationValue = TypesFactory.eINSTANCE.createJvmByteAnnotationValue();
	}	
	
	public void testMultiValue() {
		byteAnnotationValue.getValues().add((byte)1);
		byteAnnotationValue.getValues().add((byte)1);
		assertEquals(2, byteAnnotationValue.getValues().size());
	}
}

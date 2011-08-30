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
public class JvmDoubleAnnotationValueTest extends TestCase {

	private JvmDoubleAnnotationValue doubleAnnotationValue;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		doubleAnnotationValue = TypesFactory.eINSTANCE.createJvmDoubleAnnotationValue();
	}	
	
	public void testMultiValue() {
		doubleAnnotationValue.getValues().add(1d);
		doubleAnnotationValue.getValues().add(1d);
		assertEquals(2, doubleAnnotationValue.getValues().size());
	}
}

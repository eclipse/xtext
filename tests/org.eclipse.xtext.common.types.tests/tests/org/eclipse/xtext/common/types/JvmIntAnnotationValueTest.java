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
public class JvmIntAnnotationValueTest extends TestCase {

	private JvmIntAnnotationValue intAnnotationValue;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		intAnnotationValue = TypesFactory.eINSTANCE.createJvmIntAnnotationValue();
	}	
	
	public void testMultiValue() {
		intAnnotationValue.getValues().add(1);
		intAnnotationValue.getValues().add(1);
		assertEquals(2, intAnnotationValue.getValues().size());
	}
}

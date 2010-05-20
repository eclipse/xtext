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
public class JvmCharAnnotationValueTest extends TestCase {

	private JvmCharAnnotationValue charAnnotationValue;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		charAnnotationValue = TypesFactory.eINSTANCE.createJvmCharAnnotationValue();
	}	
	
	public void testMultiValue() {
		charAnnotationValue.getValues().add('1');
		charAnnotationValue.getValues().add('1');
		assertEquals(2, charAnnotationValue.getValues().size());
	}
}

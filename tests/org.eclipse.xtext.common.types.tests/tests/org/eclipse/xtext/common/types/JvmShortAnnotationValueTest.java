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
public class JvmShortAnnotationValueTest extends TestCase {

	private JvmShortAnnotationValue shortAnnotationValue;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		shortAnnotationValue = TypesFactory.eINSTANCE.createJvmShortAnnotationValue();
	}	
	
	public void testMultiValue() {
		shortAnnotationValue.getValues().add((short)1);
		shortAnnotationValue.getValues().add((short)1);
		assertEquals(2, shortAnnotationValue.getValues().size());
	}
}

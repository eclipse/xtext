/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmDoubleAnnotationValueTest extends Assert {

	private JvmDoubleAnnotationValue doubleAnnotationValue;

	@Before
	public void setUp() throws Exception {
		doubleAnnotationValue = TypesFactory.eINSTANCE.createJvmDoubleAnnotationValue();
	}	
	
	@Test public void testMultiValue() {
		doubleAnnotationValue.getValues().add(1d);
		doubleAnnotationValue.getValues().add(1d);
		assertEquals(2, doubleAnnotationValue.getValues().size());
	}
}

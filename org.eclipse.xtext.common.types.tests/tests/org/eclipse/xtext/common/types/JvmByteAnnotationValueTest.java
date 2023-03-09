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
public class JvmByteAnnotationValueTest extends Assert {

	private JvmByteAnnotationValue byteAnnotationValue;

	@Before
	public void setUp() throws Exception {
		byteAnnotationValue = TypesFactory.eINSTANCE.createJvmByteAnnotationValue();
	}	
	
	@Test public void testMultiValue() {
		byteAnnotationValue.getValues().add((byte)1);
		byteAnnotationValue.getValues().add((byte)1);
		assertEquals(2, byteAnnotationValue.getValues().size());
	}
}

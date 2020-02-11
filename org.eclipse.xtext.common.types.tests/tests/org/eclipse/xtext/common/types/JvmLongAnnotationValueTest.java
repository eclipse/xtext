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
public class JvmLongAnnotationValueTest extends Assert {

	private JvmLongAnnotationValue longAnnotationValue;

	@Before
	public void setUp() throws Exception {
		longAnnotationValue = TypesFactory.eINSTANCE.createJvmLongAnnotationValue();
	}	
	
	@Test public void testMultiValue() {
		longAnnotationValue.getValues().add(1l);
		longAnnotationValue.getValues().add(1l);
		assertEquals(2, longAnnotationValue.getValues().size());
	}
}

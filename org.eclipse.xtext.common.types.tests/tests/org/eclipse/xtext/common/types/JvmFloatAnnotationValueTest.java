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
public class JvmFloatAnnotationValueTest extends Assert {

	private JvmFloatAnnotationValue floatAnnotationValue;

	@Before
	public void setUp() throws Exception {
		floatAnnotationValue = TypesFactory.eINSTANCE.createJvmFloatAnnotationValue();
	}	
	
	@Test public void testMultiValue() {
		floatAnnotationValue.getValues().add(1f);
		floatAnnotationValue.getValues().add(1f);
		assertEquals(2, floatAnnotationValue.getValues().size());
	}
}

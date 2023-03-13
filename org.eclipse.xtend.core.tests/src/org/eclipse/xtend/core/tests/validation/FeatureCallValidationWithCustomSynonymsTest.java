/*******************************************************************************
 * Copyright (c) 2013, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation;

import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.tests.typesystem.RuntimeInjectorProviderWithCustomSynonyms;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@InjectWith(RuntimeInjectorProviderWithCustomSynonyms.class)
public class FeatureCallValidationWithCustomSynonymsTest extends AbstractXtendTestCase {

	@Inject
	private ValidationTestHelper helper;
	
	@Test
	public void testBigIntegerAssignableToBigDecimal() throws Exception {
		XtendClass clazz = clazz("import java.math.* class X { def void m(BigDecimal bd) { var bi = 1bi m(bi) } }");
		helper.assertNoErrors(clazz);
	}
	
}

/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtend.core.tests.validation;

import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.tests.typesystem.RuntimeInjectorProviderWithCustomSynonyms;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
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

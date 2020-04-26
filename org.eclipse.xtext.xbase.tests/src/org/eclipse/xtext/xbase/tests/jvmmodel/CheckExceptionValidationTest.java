/**
 * Copyright (c) 2011, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.jvmmodel;

import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;

public class CheckExceptionValidationTest extends AbstractJvmModelTest {
	@Inject
	private ValidationTestHelper helper;

	private MapBasedPreferenceValues preferences;

	@Inject
	public void setPreferences(IPreferenceValuesProvider.SingletonPreferenceValuesProvider prefProvider) {
		this.preferences = prefProvider.getPreferenceValues(null);
	}

	@Before
	public void setSeverity() {
		preferences.put(IssueCodes.UNHANDLED_EXCEPTION, "error");
	}

	@After
	public void clearPreferences() {
		preferences.clear();
	}

	@Test
	public void testSimple() throws Exception {
		XExpression expression = expression("throw new java.io.IOException()", false);
		helper.assertError(expression, XbasePackage.Literals.XTHROW_EXPRESSION, IssueCodes.UNHANDLED_EXCEPTION);
	}
}

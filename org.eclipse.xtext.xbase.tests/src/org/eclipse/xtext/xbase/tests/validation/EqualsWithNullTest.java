/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation;

import static org.eclipse.xtext.xbase.XbasePackage.Literals.*;
import static org.eclipse.xtext.xbase.validation.IssueCodes.*;

import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider.SingletonPreferenceValuesProvider;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EqualsWithNullTest extends AbstractXbaseTestCase {
	
	@Inject
	protected ValidationTestHelper helper;
	
	private MapBasedPreferenceValues preferences;
	
	@Inject
	public void setPreferences(SingletonPreferenceValuesProvider prefProvider) {
		preferences = prefProvider.getPreferenceValues(null);
	}
	
	@Before
	public void setSeverity() {
		preferences.put(EQUALS_WITH_NULL, "warning");
	}
	
	@After
	public void clearPreferences() {
		preferences.clear();
	}
	
	@Test public void testObjectEqualsNull_01() throws Exception {
		XExpression expression = expression("{ val Object x = null x==null }");
		helper.assertWarning(expression, XBINARY_OPERATION, EQUALS_WITH_NULL, "'=='", "'==='");
	}
	
	@Test public void testObjectEqualsNull_02() throws Exception {
		XExpression expression = expression("{ val Object x = null x!=null }");
		helper.assertWarning(expression, XBINARY_OPERATION, EQUALS_WITH_NULL, "'!='", "'!=='");
	}
	
	@Test public void testObjectEqualsNull_03() throws Exception {
		XExpression expression = expression("{ val Object x = null x==null }");
		helper.assertWarning(expression, XBINARY_OPERATION, EQUALS_WITH_NULL, "'=='", "'==='");
	}
	
	@Test public void testObjectEqualsNull_04() throws Exception {
		XExpression expression = expression("{ val Object x = null x!=null }");
		helper.assertWarning(expression, XBINARY_OPERATION, EQUALS_WITH_NULL, "'!='", "'!=='");
	}

}

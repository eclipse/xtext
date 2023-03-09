/**
 * Copyright (c) 2014, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.validation;

import com.google.inject.Inject;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
public class CodeStyleValidationTest extends AbstractXbaseTestCase {
	@Inject
	private ValidationTestHelper helper;

	private MapBasedPreferenceValues preferences;

	@Inject
	public MapBasedPreferenceValues setPreferences(IPreferenceValuesProvider.SingletonPreferenceValuesProvider prefProvider) {
		return preferences = prefProvider.getPreferenceValues(null);
	}

	@Before
	public void setSeverity() {
		preferences.put(IssueCodes.OPERATION_WITHOUT_PARENTHESES, "warning");
	}

	@After
	public void clearPreferences() {
		preferences.clear();
	}

	@Test
	public void testMethodCallWithoutParenthesis01() throws Exception {
		// @formatter:off
		String model = 
				"{\n" + 
				"	val x = 'foo'\n" +
				"	x.length\n" +
				"}";
		// @formatter:on
		helper.assertWarning(expression(model), XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.OPERATION_WITHOUT_PARENTHESES);
	}

	@Test
	public void testMethodCallWithoutParenthesis02() throws Exception {
		// @formatter:off
		String model = 
				"{\n" +
				"	val it = 'foo'\n" +
				"	length\n" +
				"}";
		// @formatter:on
		helper.assertWarning(expression(model), XbasePackage.Literals.XFEATURE_CALL, IssueCodes.OPERATION_WITHOUT_PARENTHESES);
	}

	@Test
	public void testSugaredPropertyAccess01() throws Exception {
		// @formatter:off
		String model = 
				"{\n" +
				"	val x = 'foo'\n" +
				"	x.bytes\n" +
				"}";
		// @formatter:on
		helper.assertNoIssues(expression(model));
	}

	@Test
	public void testSugaredPropertyAccess02() throws Exception {
		// @formatter:off
		String model = 
				"{\n" +
				"	val it = 'foo'\n" +
				"	bytes\n" +
				"}";
		// @formatter:on
		helper.assertNoIssues(expression(model));
	}

	@Test
	public void testMethodCallWithParenthesis01() throws Exception {
		// @formatter:off
		String model = 
				"{\n" +
				"	val x = 'foo'\n" +
				"	x.length()\n" +
				"}";
		// @formatter:on
		helper.assertNoIssues(expression(model));
	}

	@Test
	public void testMethodCallWithParenthesis02() throws Exception {
		// @formatter:off
		String model = 
				"{\n" +
				"	val it = 'foo'\n" +
				"	length()\n" +
				"}";
		// @formatter:on
		helper.assertNoIssues(expression(model));
	}

	@Test
	public void testMethodCallWithBuilderSyntax01() throws Exception {
		// @formatter:off
		String model = 
				"{\n" +
				"	val x = #['foo', 'bar']\n" +
				"	x.forEach[]\n" +
				"}";
		// @formatter:on
		helper.assertNoIssues(expression(model));
	}

	@Test
	public void testMethodCallWithBuilderSyntax02() throws Exception {
		// @formatter:off
		String model = 
				"{\n" +
				"	val it = #['foo', 'bar']\n" +
				"	forEach[]\n" +
				"}";
		// @formatter:on
		helper.assertNoIssues(expression(model));
	}

	@Test
	public void testConstructorCallWithoutParenthesis() throws Exception {
		// @formatter:off
		String model = 
				"{\n" +
				"	new String\n" +
				"}";
		// @formatter:on
		helper.assertWarning(expression(model), XbasePackage.Literals.XCONSTRUCTOR_CALL, IssueCodes.OPERATION_WITHOUT_PARENTHESES);
	}

	@Test
	public void testConstructorCallWithParenthesis() throws Exception {
		// @formatter:off
		String model = 
				"{\n" +
				"	new String()\n" +
				"}";
		// @formatter:on
		helper.assertNoIssues(expression(model));
	}

	@Test
	public void testConstructorCallWithBuilderSyntax() throws Exception {
		// @formatter:off
		String model = 
				"{\n" +
				"	new Thread[|]\n" +
				"}";
		// @formatter:on
		helper.assertNoIssues(expression(model));
	}
}

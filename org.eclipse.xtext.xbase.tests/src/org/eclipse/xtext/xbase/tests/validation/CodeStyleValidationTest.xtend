/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xbase.tests.validation

import com.google.inject.Inject
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.preferences.MapBasedPreferenceValues
import org.eclipse.xtext.xbase.XbasePackage
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase
import org.eclipse.xtext.xbase.validation.IssueCodes
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.eclipse.xtext.preferences.IPreferenceValuesProvider

/**
 * @author Stefan Oehme - Initial contribution and API
 */
class CodeStyleValidationTest extends AbstractXbaseTestCase {

	@Inject
	extension ValidationTestHelper helper
	
	MapBasedPreferenceValues preferences;
	
	@Inject
	def setPreferences(IPreferenceValuesProvider.SingletonPreferenceValuesProvider prefProvider) {
		preferences = prefProvider.getPreferenceValues(null);
	}
	
	@Before
	def setSeverity() {
		preferences.put(IssueCodes.OPERATION_WITHOUT_PARENTHESES, "warning");
	}
	
	@After
	def clearPreferences() {
		preferences.clear();
	}
	
	@Test def void testMethodCallWithoutParenthesis01() {
		'''{
			val x = "foo"
			x.length
		}'''.expression.assertWarning(XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.OPERATION_WITHOUT_PARENTHESES)
	}
	
	@Test def void testMethodCallWithoutParenthesis02() {
		'''{
			val it = "foo"
			length
		}'''.expression.assertWarning(XbasePackage.Literals.XFEATURE_CALL, IssueCodes.OPERATION_WITHOUT_PARENTHESES)
	}
	
	@Test def void testSugaredPropertyAccess01() {
		'''{
			val x = "foo"
			x.bytes
		}'''.expression.assertNoIssues
	}
	@Test def void testSugaredPropertyAccess02() {
		'''{
			val it = "foo"
			bytes
		}'''.expression.assertNoIssues
	}
	
	@Test def void testMethodCallWithParenthesis01() {
		'''{
			val x = "foo"
			x.length()
		}'''.expression.assertNoIssues
	}
	@Test def void testMethodCallWithParenthesis02() {
		'''{
			val it = "foo"
			length()
		}'''.expression.assertNoIssues
	}
	
	@Test def void testMethodCallWithBuilderSyntax01() {
		'''{
			val x = #["foo", "bar"]
			x.forEach[]
		}'''.expression.assertNoIssues
	}
	@Test def void testMethodCallWithBuilderSyntax02() {
		'''{
			val it = #["foo", "bar"]
			forEach[]
		}'''.expression.assertNoIssues
	}
	
	@Test def void testConstructorCallWithoutParenthesis() {
		'''{
			new String
		}'''.expression.assertWarning(XbasePackage.Literals.XCONSTRUCTOR_CALL, IssueCodes.OPERATION_WITHOUT_PARENTHESES)
	}
	
	@Test def void testConstructorCallWithParenthesis() {
		'''{
			new String()
		}'''.expression.assertNoIssues
	}
	
	@Test def void testConstructorCallWithBuilderSyntax() {
		'''{
			new Thread[|]
		}'''.expression.assertNoIssues
	}
	
}
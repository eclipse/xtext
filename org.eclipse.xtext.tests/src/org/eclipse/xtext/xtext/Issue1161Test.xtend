/*******************************************************************************
 * Copyright (c) 2019 Malardalen University (http://www.mdh.se) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext

import com.google.inject.Guice
import com.google.inject.Inject
import org.eclipse.xtext.Grammar
import org.eclipse.xtext.XtextPackage
import org.eclipse.xtext.XtextRuntimeModule
import org.eclipse.xtext.XtextStandaloneSetup
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.preferences.IPreferenceValuesProvider
import org.eclipse.xtext.preferences.IPreferenceValuesProvider.SingletonPreferenceValuesProvider
import org.eclipse.xtext.preferences.MapBasedPreferenceValues
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.XtextRunner
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.tests.AbstractXtextTests
import org.eclipse.xtext.tests.XtextInjectorProvider
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * @author Lorenzo Addazi - Initial contribution and API
 */
@RunWith(XtextRunner)
@InjectWith(XtextInjectorProvider)
class Issue1161Test extends AbstractXtextTests {

	@Inject extension ValidationTestHelper
	@Inject extension ParseHelper<Grammar> 
	
	@Inject MapBasedPreferenceValues preferences

	override setUp() throws Exception {
		super.setUp();
		with(Issue1161StandaloneSetup)
	}

	@Before def void setPreferences() {
		preferences = get(SingletonPreferenceValuesProvider).getPreferenceValues(null)
	}

	@After def void clearPreferences() {
		preferences.clear
	}

	@Test def void testValidJavaPackageNamingConventionsWithIgnoreSeverity() {
		grammarWithValidJavaPackageNamingConventions.assertNoIssue
	}

	@Test def void testInvalidJavaPackageNamingConventionsWithIgnoreSeverity() {
		grammarWithInvalidJavaPackageNamingConventions.assertNoIssue
	}

	@Test def void testValidJavaPackageNamingConventionsWithErrorSeverity() {
		severity = "error"
		grammarWithValidJavaPackageNamingConventions.assertNoIssue

	}

	@Test def void testInvalidJavaPackageNamingConventionsWithErrorSeverity() {
		severity = "error"
		grammarWithInvalidJavaPackageNamingConventions.assertError
	}

	@Test def void testValidJavaPackageNamingConventionsWithWarningSeverity() {
		severity = "warning"
		grammarWithValidJavaPackageNamingConventions.assertNoIssue

	}

	@Test def void testInvalidJavaPackageNamingConventionsWithWarningSeverity() {
		severity = "warning"
		grammarWithInvalidJavaPackageNamingConventions.assertWarning
	}

	@Test def void testValidJavaPackageNamingConventionsWithInfoSeverity() {
		severity = "info"
		grammarWithValidJavaPackageNamingConventions.assertNoIssue

	}

	@Test def void testInvalidJavaPackageNamingConventionsWithInfoSeverity() {
		severity = "info"
		grammarWithInvalidJavaPackageNamingConventions.assertInfo
	}

	private def assertError(CharSequence grammar) {
		grammar.assertIssue(Severity.ERROR)
	}

	private def assertWarning(CharSequence grammar) {
		grammar.assertIssue(Severity.WARNING)
	}

	private def assertInfo(CharSequence grammar) {
		grammar.assertIssue(Severity.INFO)
	}

	private def assertIssue(CharSequence grammar, Severity severity) {
		grammar.parse.assertIssue(XtextPackage.Literals.GENERATED_METAMODEL,
			XtextConfigurableIssueCodes.INVALID_JAVAPACKAGE_NAME, severity)
	}

	private def assertNoIssue(CharSequence grammar) {
		grammar.parse.assertNoIssue(XtextPackage.Literals.GENERATED_METAMODEL,
			XtextConfigurableIssueCodes.INVALID_JAVAPACKAGE_NAME)
	}

	private def grammarWithValidJavaPackageNamingConventions() {
		grammarWithGeneratedMetamodelName("testissue1161")
	}

	private def grammarWithInvalidJavaPackageNamingConventions() {
		grammarWithGeneratedMetamodelName("testIssue1161")
	}

	private def grammarWithGeneratedMetamodelName(String generatedMetamodelName) '''
		grammar test.Issue1161 with org.eclipse.xtext.common.Terminals
		generate «generatedMetamodelName» "http://issue1161"
		A : {A};
	'''

	private def setSeverity(String severity) {
		preferences.put(XtextConfigurableIssueCodes.INVALID_JAVAPACKAGE_NAME, severity)
	}

	/**
	 * @author Lorenzo Addazi - Initial contribution and API
	 */
	static class Issue1161StandaloneSetup extends XtextStandaloneSetup {
		override createInjector() {
			return Guice.createInjector(new XtextRuntimeModule() {
				def Class<? extends IPreferenceValuesProvider> bindIPreferenceValuesProvider() {
					SingletonPreferenceValuesProvider
				}
			});
		}
	}

}

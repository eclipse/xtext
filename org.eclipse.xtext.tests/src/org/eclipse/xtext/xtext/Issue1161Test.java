/**
 * Copyright (c) 2019, 2020 Malardalen University (http://www.mdh.se) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext;

import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.XtextPackage;
import org.eclipse.xtext.XtextRuntimeModule;
import org.eclipse.xtext.XtextStandaloneSetup;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.testing.AbstractXtextTests;
import org.eclipse.xtext.tests.XtextInjectorProvider;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author Lorenzo Addazi - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtextInjectorProvider.class)
public class Issue1161Test extends AbstractXtextTests {
	/**
	 * @author Lorenzo Addazi - Initial contribution and API
	 */
	public static class Issue1161StandaloneSetup extends XtextStandaloneSetup {
		@Override
		public Injector createInjector() {
			XtextRuntimeModule module = new XtextRuntimeModule() {
				@SuppressWarnings("unused")
				public Class<? extends IPreferenceValuesProvider> bindIPreferenceValuesProvider() {
					return IPreferenceValuesProvider.SingletonPreferenceValuesProvider.class;
				}
			};
			return Guice.createInjector(module);
		}
	}

	@Inject
	private ValidationTestHelper validationTestHelper;

	@Inject
	private ParseHelper<Grammar> parseHelper;

	@Inject
	private MapBasedPreferenceValues preferences;

	@Override
	public void setUp() throws Exception {
		super.setUp();
		with(Issue1161Test.Issue1161StandaloneSetup.class);
	}

	@Before
	public void setPreferences() {
		preferences = get(IPreferenceValuesProvider.SingletonPreferenceValuesProvider.class).getPreferenceValues(null);
	}

	@After
	public void clearPreferences() {
		preferences.clear();
	}

	@Test
	public void testValidJavaPackageNamingConventionsWithIgnoreSeverity() throws Exception {
		assertNoIssue(grammarWithValidJavaPackageNamingConventions());
	}

	@Test
	public void testInvalidJavaPackageNamingConventionsWithIgnoreSeverity() throws Exception {
		assertNoIssue(grammarWithInvalidJavaPackageNamingConventions());
	}

	@Test
	public void testValidJavaPackageNamingConventionsWithErrorSeverity() throws Exception {
		setSeverity("error");
		assertNoIssue(grammarWithValidJavaPackageNamingConventions());
	}

	@Test
	public void testInvalidJavaPackageNamingConventionsWithErrorSeverity() throws Exception {
		setSeverity("error");
		assertError(grammarWithInvalidJavaPackageNamingConventions());
	}

	@Test
	public void testValidJavaPackageNamingConventionsWithWarningSeverity() throws Exception {
		setSeverity("warning");
		assertNoIssue(grammarWithValidJavaPackageNamingConventions());
	}

	@Test
	public void testInvalidJavaPackageNamingConventionsWithWarningSeverity() throws Exception {
		setSeverity("warning");
		assertWarning(grammarWithInvalidJavaPackageNamingConventions());
	}

	@Test
	public void testValidJavaPackageNamingConventionsWithInfoSeverity() throws Exception {
		setSeverity("info");
		assertNoIssue(grammarWithValidJavaPackageNamingConventions());
	}

	@Test
	public void testInvalidJavaPackageNamingConventionsWithInfoSeverity() throws Exception {
		setSeverity("info");
		assertInfo(grammarWithInvalidJavaPackageNamingConventions());
	}

	private void assertError(final CharSequence grammar) throws Exception {
		assertIssue(grammar, Severity.ERROR);
	}

	private void assertWarning(final CharSequence grammar) throws Exception {
		assertIssue(grammar, Severity.WARNING);
	}

	private void assertInfo(final CharSequence grammar) throws Exception {
		assertIssue(grammar, Severity.INFO);
	}

	private void assertIssue(final CharSequence grammar, final Severity severity) throws Exception {
			validationTestHelper.assertIssue(parseHelper.parse(grammar), XtextPackage.Literals.GENERATED_METAMODEL,
					XtextConfigurableIssueCodes.INVALID_JAVAPACKAGE_NAME, severity);
	}

	private void assertNoIssue(final CharSequence grammar) throws Exception {
			validationTestHelper.assertNoIssue(parseHelper.parse(grammar), XtextPackage.Literals.GENERATED_METAMODEL,
					XtextConfigurableIssueCodes.INVALID_JAVAPACKAGE_NAME);
	}

	private CharSequence grammarWithValidJavaPackageNamingConventions() {
		return grammarWithGeneratedMetamodelName("testissue1161");
	}

	private CharSequence grammarWithInvalidJavaPackageNamingConventions() {
		return grammarWithGeneratedMetamodelName("testIssue1161");
	}

	private CharSequence grammarWithGeneratedMetamodelName(final String generatedMetamodelName) {
		// @formatter:off
		String model =
				"grammar test.Issue1161 with org.eclipse.xtext.common.Terminals\n" +
				"generate " + generatedMetamodelName + " 'http://issue1161'n" +
				"A : {A};";
		// @formatter:on
		return model;
	}

	private void setSeverity(final String severity) {
		preferences.put(XtextConfigurableIssueCodes.INVALID_JAVAPACKAGE_NAME, severity);
	}
}

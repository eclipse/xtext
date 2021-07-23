/**
 * Copyright (c) 2018, 2021 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.validation.ValidatorFragment2;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.14
 */
public class ValidatorFragment2Tests extends AbstractGeneratorFragmentTests {
	public static class TestableValidatorFragment2 extends ValidatorFragment2 {
		@Override
		protected List<AbstractRule> getDeprecatedRulesFromGrammar() {
			return super.getDeprecatedRulesFromGrammar();
		}

		@Override
		protected StringConcatenationClient generateValidationToDeprecateRules() {
			return super.generateValidationToDeprecateRules();
		}

		@Override
		protected GeneratedJavaFileAccess generateGenValidator() {
			return super.generateGenValidator();
		}

		@Override
		protected GeneratedJavaFileAccess generateIssueProvider() {
			return super.generateIssueProvider();
		}

		@Override
		protected GeneratedJavaFileAccess generateValidationConfigurationBlock() {
			return super.generateValidationConfigurationBlock();
		}
	}

	@Test
	public void testGenerateNoValidation() throws Exception {
		String grammar =
				"grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://org.xtext/foo'\n" +
				"Model: rules+=Rule;\n" +
				"Rule: name=ID;\n";
		TestableValidatorFragment2 fragment = initializeFragmentWithGrammarFromString(TestableValidatorFragment2.class,
				grammar);
		List<AbstractRule> deprecatedRules = fragment.getDeprecatedRulesFromGrammar();
		Assert.assertTrue(deprecatedRules.isEmpty());
		String expectation =
				"package org.xtext.validation;\n" +
				"\n" +
				"import java.util.ArrayList;\n" +
				"import java.util.List;\n" +
				"import org.eclipse.emf.ecore.EPackage;\n" +
				"import org.eclipse.xtext.validation.AbstractDeclarativeValidator;\n" +
				"\n" +
				"public abstract class AbstractFooValidator extends AbstractDeclarativeValidator {\n" +
				"	\n" +
				"	@Override\n" +
				"	protected List<EPackage> getEPackages() {\n" +
				"		List<EPackage> result = new ArrayList<EPackage>();\n" +
				"		result.add(org.xtext.foo.FooPackage.eINSTANCE);\n" +
				"		return result;\n" +
				"	}\n" +
				"}\n";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation),
				concatenationClientToString(fragment.generateGenValidator()));
	}

	@Test
	public void testGenerateValidation() throws Exception {
		String grammar =
				"grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://org.xtext/foo'\n" +
				"Model: rules+=Rule;\n" +
				"@Deprecated\n" +
				"Rule: name=ID;\n" +
				"@Deprecated\n" +
				"CustomRule returns Rule: name=ID;\n";
		TestableValidatorFragment2 fragment = initializeFragmentWithGrammarFromString(TestableValidatorFragment2.class,
				grammar);
		fragment.setGenerateDeprecationValidation(true);
		List<AbstractRule> deprecatedRulesFromGrammar = fragment.getDeprecatedRulesFromGrammar();
		Assert.assertEquals(1, deprecatedRulesFromGrammar.size());
		String expectation =
				"package org.xtext.validation;\n" +
				"\n" +
				"import java.util.ArrayList;\n" +
				"import java.util.List;\n" +
				"import org.eclipse.emf.ecore.EPackage;\n" +
				"import org.eclipse.xtext.validation.AbstractDeclarativeValidator;\n" +
				"import org.eclipse.xtext.validation.Check;\n" +
				"import org.xtext.foo.Rule;\n" +
				"\n" +
				"public abstract class AbstractFooValidator extends AbstractDeclarativeValidator {\n" +
				"	\n" +
				"	@Override\n" +
				"	protected List<EPackage> getEPackages() {\n" +
				"		List<EPackage> result = new ArrayList<EPackage>();\n" +
				"		result.add(org.xtext.foo.FooPackage.eINSTANCE);\n" +
				"		return result;\n" +
				"	}\n" +
				"	\n" +
				"	@Check\n" +
				"	public void checkDeprecatedRule(Rule element) {\n" +
				"		addIssue(\"This part of the language is marked as deprecated and might get removed in the future!\", element, FooConfigurableIssueCodesProvider.DEPRECATED_MODEL_PART);\n" +
				"	}\n" +
				"}\n";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation),
				concatenationClientToString(fragment.generateGenValidator()));
	}

	@Test
	public void testGenerateConfigurableIssueProvider() throws Exception {
		String grammar =
				"grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://org.xtext/foo'\n" +
				"Model: rules+=Rule;\n" +
				"@Deprecated\n" +
				"Rule: name=ID;\n" +
				"@Deprecated\n" +
				"CustomRule returns Rule: name=ID;\n";
		TestableValidatorFragment2 fragment = initializeFragmentWithGrammarFromString(TestableValidatorFragment2.class,
				grammar);
		fragment.setGenerateDeprecationValidation(true);
		String expectation =
				"package org.xtext.validation;\n" +
				"\n" +
				"import org.eclipse.xtext.preferences.PreferenceKey;\n" +
				"import org.eclipse.xtext.util.IAcceptor;\n" +
				"import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;\n" +
				"import org.eclipse.xtext.validation.SeverityConverter;\n" +
				"\n" +
				"public class FooConfigurableIssueCodesProvider extends ConfigurableIssueCodesProvider {\n" +
				"	protected static final String ISSUE_CODE_PREFIX = \"org.xtext.\";\n" +
				"\n" +
				"	public static final String DEPRECATED_MODEL_PART = ISSUE_CODE_PREFIX + \"deprecatedModelPart\";\n" +
				"\n" +
				"	@Override\n" +
				"	protected void initialize(IAcceptor<PreferenceKey> acceptor) {\n" +
				"		super.initialize(acceptor);\n" +
				"		acceptor.accept(create(DEPRECATED_MODEL_PART, SeverityConverter.SEVERITY_WARNING));\n" +
				"	}\n" +
				"}\n";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation),
				concatenationClientToString(fragment.generateIssueProvider()));
	}

	@Test
	public void testGenerateConfigurableIssueProviderWithoutDeprecation() throws Exception {
		String grammar =
				"grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://org.xtext/foo'\n" +
				"Model: rules+=Rule;\n" +
				"@Deprecated\n" +
				"Rule: name=ID;\n" +
				"@Deprecated\n" +
				"CustomRule returns Rule: name=ID;\n";
		TestableValidatorFragment2 fragment = initializeFragmentWithGrammarFromString(TestableValidatorFragment2.class,
				grammar);
		fragment.setGeneratePropertyPage(true);
		String expectation =
				"package org.xtext.validation;\n" +
				"\n" +
				"import org.eclipse.xtext.preferences.PreferenceKey;\n" +
				"import org.eclipse.xtext.util.IAcceptor;\n" +
				"import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;\n" +
				"\n" +
				"public class FooConfigurableIssueCodesProvider extends ConfigurableIssueCodesProvider {\n" +
				"	protected static final String ISSUE_CODE_PREFIX = \"org.xtext.\";\n" +
				"\n" +
				"\n" +
				"	@Override\n" +
				"	protected void initialize(IAcceptor<PreferenceKey> acceptor) {\n" +
				"		super.initialize(acceptor);\n" +
				"	}\n" +
				"}\n";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation),
				concatenationClientToString(fragment.generateIssueProvider()));
	}

	@Test
	public void testGenerateConfigurableIssueProvideXbase() throws Exception {
		String grammar =
				"grammar org.xtext.Foo with org.eclipse.xtext.xbase.Xbase\n" +
				"generate foo 'http://org.xtext/foo'\n" +
				"Model: rules+=Rule;\n" +
				"@Deprecated\n" +
				"Rule: name=ID;\n" +
				"@Deprecated\n" +
				"CustomRule returns Rule: name=ID;\n";
		TestableValidatorFragment2 fragment = initializeFragmentWithGrammarFromStringWithXbase(
				TestableValidatorFragment2.class, grammar);
		fragment.setGenerateDeprecationValidation(true);
		String expectation =
				"package org.xtext.validation;\n" +
				"\n" +
				"import org.eclipse.xtext.preferences.PreferenceKey;\n" +
				"import org.eclipse.xtext.util.IAcceptor;\n" +
				"import org.eclipse.xtext.validation.SeverityConverter;\n" +
				"import org.eclipse.xtext.xbase.validation.XbaseConfigurableIssueCodes;\n" +
				"\n" +
				"@SuppressWarnings(\"restriction\")\n" +
				"public class FooConfigurableIssueCodesProvider extends XbaseConfigurableIssueCodes {\n" +
				"	protected static final String ISSUE_CODE_PREFIX = \"org.xtext.\";\n" +
				"\n" +
				"	public static final String DEPRECATED_MODEL_PART = ISSUE_CODE_PREFIX + \"deprecatedModelPart\";\n" +
				"\n" +
				"	@Override\n" +
				"	protected void initialize(IAcceptor<PreferenceKey> acceptor) {\n" +
				"		super.initialize(acceptor);\n" +
				"		acceptor.accept(create(DEPRECATED_MODEL_PART, SeverityConverter.SEVERITY_WARNING));\n" +
				"	}\n" +
				"}\n";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation),
				concatenationClientToString(fragment.generateIssueProvider()));
	}

	@Test
	public void testGenerateConfigurableIssueProvideXbaseWithoutDeprecation() throws Exception {
		String grammar =
				"grammar org.xtext.Foo with org.eclipse.xtext.xbase.Xbase\n" +
				"generate foo 'http://org.xtext/foo'\n" +
				"Model: rules+=Rule;\n" +
				"@Deprecated\n" +
				"Rule: name=ID;\n" +
				"@Deprecated\n" +
				"CustomRule returns Rule: name=ID;\n";
		TestableValidatorFragment2 fragment = initializeFragmentWithGrammarFromStringWithXbase(
				TestableValidatorFragment2.class, grammar);
		fragment.setGeneratePropertyPage(true);
		String expectation =
				"package org.xtext.validation;\n" +
				"\n" +
				"import org.eclipse.xtext.preferences.PreferenceKey;\n" +
				"import org.eclipse.xtext.util.IAcceptor;\n" +
				"import org.eclipse.xtext.xbase.validation.XbaseConfigurableIssueCodes;\n" +
				"\n" +
				"@SuppressWarnings(\"restriction\")\n" +
				"public class FooConfigurableIssueCodesProvider extends XbaseConfigurableIssueCodes {\n" +
				"	protected static final String ISSUE_CODE_PREFIX = \"org.xtext.\";\n" +
				"\n" +
				"\n" +
				"	@Override\n" +
				"	protected void initialize(IAcceptor<PreferenceKey> acceptor) {\n" +
				"		super.initialize(acceptor);\n" +
				"	}\n" +
				"}\n";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation),
				concatenationClientToString(fragment.generateIssueProvider()));
	}

	@Test
	public void testGenerateValidationConfigurationBlock() throws Exception {
		String grammar =
				"grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://org.xtext/foo'\n" +
				"Model: rules+=Rule;\n" +
				"@Deprecated\n" +
				"Rule: name=ID;\n" +
				"@Deprecated\n" +
				"CustomRule returns Rule: name=ID;\n";
		TestableValidatorFragment2 fragment = initializeFragmentWithGrammarFromString(TestableValidatorFragment2.class,
				grammar);
		fragment.setGenerateDeprecationValidation(true);
		String expectation =
				"package org.xtext.validation;\n" +
				"\n" +
				"import org.eclipse.jface.dialogs.IDialogSettings;\n" +
				"import org.eclipse.swt.widgets.Composite;\n" +
				"import org.eclipse.xtext.ui.validation.AbstractValidatorConfigurationBlock;\n" +
				"\n" +
				"@SuppressWarnings(\"restriction\")\n" +
				"public class FooValidatorConfigurationBlock extends AbstractValidatorConfigurationBlock {\n" +
				"\n" +
				"	protected static final String SETTINGS_SECTION_NAME = \"Foo\";\n" +
				"\n" +
				"	@Override\n" +
				"	protected void fillSettingsPage(Composite composite, int nColumns, int defaultIndent) {\n" +
				"		addComboBox(FooConfigurableIssueCodesProvider.DEPRECATED_MODEL_PART, \"Deprecated Model Part\", composite, defaultIndent);\n" +
				"	}\n" +
				"\n" +
				"	@Override\n" +
				"	public void dispose() {\n" +
				"		storeSectionExpansionStates(getDialogSettings());\n" +
				"		super.dispose();\n" +
				"	}\n" +
				"\n" +
				"	@Override\n" +
				"	protected IDialogSettings getDialogSettings() {\n" +
				"		IDialogSettings dialogSettings = super.getDialogSettings();\n" +
				"		IDialogSettings section = dialogSettings.getSection(SETTINGS_SECTION_NAME);\n" +
				"		if (section == null) {\n" +
				"			return dialogSettings.addNewSection(SETTINGS_SECTION_NAME);\n" +
				"		}\n" +
				"		return section;\n" +
				"	}\n" +
				"}\n";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation),
				concatenationClientToString(fragment.generateValidationConfigurationBlock()));
	}

	@Test
	public void testGenerateValidationConfigurationBlockWithoutDeprecation() throws Exception {
		String grammar =
				"grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals\n" +
				"generate foo 'http://org.xtext/foo'\n" +
				"Model: rules+=Rule;\n" +
				"@Deprecated\n" +
				"Rule: name=ID;\n" +
				"@Deprecated\n" +
				"CustomRule returns Rule: name=ID;\n";
		TestableValidatorFragment2 fragment = initializeFragmentWithGrammarFromString(TestableValidatorFragment2.class,
				grammar);
		fragment.setGeneratePropertyPage(true);
		String expectation =
				"package org.xtext.validation;\n" +
				"\n" +
				"import org.eclipse.jface.dialogs.IDialogSettings;\n" +
				"import org.eclipse.swt.widgets.Composite;\n" +
				"import org.eclipse.xtext.ui.validation.AbstractValidatorConfigurationBlock;\n" +
				"\n" +
				"@SuppressWarnings(\"restriction\")\n" +
				"public class FooValidatorConfigurationBlock extends AbstractValidatorConfigurationBlock {\n" +
				"\n" +
				"	protected static final String SETTINGS_SECTION_NAME = \"Foo\";\n" +
				"\n" +
				"	@Override\n" +
				"	protected void fillSettingsPage(Composite composite, int nColumns, int defaultIndent) {\n" +
				"	}\n" +
				"\n" +
				"	@Override\n" +
				"	public void dispose() {\n" +
				"		storeSectionExpansionStates(getDialogSettings());\n" +
				"		super.dispose();\n" +
				"	}\n" +
				"\n" +
				"	@Override\n" +
				"	protected IDialogSettings getDialogSettings() {\n" +
				"		IDialogSettings dialogSettings = super.getDialogSettings();\n" +
				"		IDialogSettings section = dialogSettings.getSection(SETTINGS_SECTION_NAME);\n" +
				"		if (section == null) {\n" +
				"			return dialogSettings.addNewSection(SETTINGS_SECTION_NAME);\n" +
				"		}\n" +
				"		return section;\n" +
				"	}\n" +
				"}\n";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation),
				concatenationClientToString(fragment.generateValidationConfigurationBlock()));
	}

	@Test
	public void testGenerateValidationConfigurationBlockXbase() throws Exception {
		String grammar =
				"grammar org.xtext.Foo with org.eclipse.xtext.xbase.Xbase\n" +
				"generate foo 'http://org.xtext/foo'\n" +
				"Model: rules+=Rule;\n" +
				"@Deprecated\n" +
				"Rule: name=ID;\n" +
				"@Deprecated\n" +
				"CustomRule returns Rule: name=ID;\n";
		TestableValidatorFragment2 fragment = initializeFragmentWithGrammarFromStringWithXbase(
				TestableValidatorFragment2.class, grammar);
		fragment.setGenerateDeprecationValidation(true);
		String expectation =
				"package org.xtext.validation;\n" +
				"\n" +
				"import org.eclipse.jface.dialogs.IDialogSettings;\n" +
				"import org.eclipse.swt.widgets.Composite;\n" +
				"import org.eclipse.xtext.xbase.ui.validation.XbaseValidationConfigurationBlock;\n" +
				"\n" +
				"@SuppressWarnings(\"restriction\")\n" +
				"public class FooValidatorConfigurationBlock extends XbaseValidationConfigurationBlock {\n" +
				"\n" +
				"	protected static final String SETTINGS_SECTION_NAME = \"Foo\";\n" +
				"\n" +
				"	@Override\n" +
				"	protected void fillSettingsPage(Composite composite, int nColumns, int defaultIndent) {\n" +
				"		addComboBox(FooConfigurableIssueCodesProvider.DEPRECATED_MODEL_PART, \"Deprecated Model Part\", composite, defaultIndent);\n" +
				"		super.fillSettingsPage(composite, nColumns, defaultIndent);\n" +
				"	}\n" +
				"\n" +
				"	@Override\n" +
				"	public void dispose() {\n" +
				"		storeSectionExpansionStates(getDialogSettings());\n" +
				"		super.dispose();\n" +
				"	}\n" +
				"\n" +
				"	@Override\n" +
				"	protected IDialogSettings getDialogSettings() {\n" +
				"		IDialogSettings dialogSettings = super.getDialogSettings();\n" +
				"		IDialogSettings section = dialogSettings.getSection(SETTINGS_SECTION_NAME);\n" +
				"		if (section == null) {\n" +
				"			return dialogSettings.addNewSection(SETTINGS_SECTION_NAME);\n" +
				"		}\n" +
				"		return section;\n" +
				"	}\n" +
				"}\n";
		Assert.assertEquals(Strings.toPlatformLineSeparator(expectation),
				concatenationClientToString(fragment.generateValidationConfigurationBlock()));
	}
}

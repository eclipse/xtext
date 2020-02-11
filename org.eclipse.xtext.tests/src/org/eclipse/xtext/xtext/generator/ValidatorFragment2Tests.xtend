/*******************************************************************************
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xtext.generator

import org.eclipse.xtext.xtext.generator.validation.ValidatorFragment2
import org.junit.Test

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.14
 */
class ValidatorFragment2Tests extends AbstractGeneratorFragmentTests {

	static class TestableValidatorFragment2 extends ValidatorFragment2 {

		override protected getDeprecatedRulesFromGrammar() {
			super.getDeprecatedRulesFromGrammar()
		}

		override protected generateValidationToDeprecateRules() {
			super.generateValidationToDeprecateRules()
		}

		override protected generateGenValidator() {
			super.generateGenValidator()
		}
		
		override protected generateIssueProvider() {
			super.generateIssueProvider()
		}
		
		override protected generateValidationConfigurationBlock() {
			super.generateValidationConfigurationBlock()
		}

	}

	@Test
	def testGenerateNoValidation() {
		val fragment = initializeFragmentWithGrammarFromString(TestableValidatorFragment2, '''
			grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals
			generate foo "http://org.xtext/foo"
			Model: rules+=Rule;
			Rule: name=ID;
		''')
		val deprecatedRules = fragment.deprecatedRulesFromGrammar
		assertTrue(deprecatedRules.empty)
		assertEquals('''
			package org.xtext.validation;
			
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.emf.ecore.EPackage;
			import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
			
			public abstract class AbstractFooValidator extends AbstractDeclarativeValidator {
				
				@Override
				protected List<EPackage> getEPackages() {
					List<EPackage> result = new ArrayList<EPackage>();
					result.add(org.xtext.foo.FooPackage.eINSTANCE);
					return result;
				}
			}
		'''.toString, concatenationClientToString(fragment.generateGenValidator))
	}

	@Test
	def testGenerateValidation() {
		val fragment = initializeFragmentWithGrammarFromString(TestableValidatorFragment2, '''
			grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals
			generate foo "http://org.xtext/foo"
			Model: rules+=Rule;
			@Deprecated
			Rule: name=ID;
			@Deprecated
			CustomRule returns Rule: name=ID;
		''')
		fragment.generateDeprecationValidation = true
		val deprecatedRulesFromGrammar = fragment.deprecatedRulesFromGrammar
		assertEquals(1, deprecatedRulesFromGrammar.size)
		assertEquals('''
			package org.xtext.validation;
			
			import java.util.ArrayList;
			import java.util.List;
			import org.eclipse.emf.ecore.EPackage;
			import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
			import org.eclipse.xtext.validation.Check;
			import org.xtext.foo.Rule;
			
			public abstract class AbstractFooValidator extends AbstractDeclarativeValidator {
				
				@Override
				protected List<EPackage> getEPackages() {
					List<EPackage> result = new ArrayList<EPackage>();
					result.add(org.xtext.foo.FooPackage.eINSTANCE);
					return result;
				}
				
				@Check
				public void checkDeprecatedRule(Rule element) {
					addIssue("This part of the language is marked as deprecated and might get removed in the future!", element, FooConfigurableIssueCodesProvider.DEPRECATED_MODEL_PART);
				}
			}
		'''.toString,concatenationClientToString(fragment.generateGenValidator))
	}

	@Test
	def testGenerateConfigurableIssueProvider() {
		val fragment = initializeFragmentWithGrammarFromString(TestableValidatorFragment2, '''
			grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals
			generate foo "http://org.xtext/foo"
			Model: rules+=Rule;
			@Deprecated
			Rule: name=ID;
			@Deprecated
			CustomRule returns Rule: name=ID;
		''')
		fragment.generateDeprecationValidation = true
		assertEquals('''
			package org.xtext.validation;
			
			import org.eclipse.xtext.preferences.PreferenceKey;
			import org.eclipse.xtext.util.IAcceptor;
			import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;
			import org.eclipse.xtext.validation.SeverityConverter;
			
			@SuppressWarnings("restriction")
			public class FooConfigurableIssueCodesProvider extends ConfigurableIssueCodesProvider {
				protected static final String ISSUE_CODE_PREFIX = "org.xtext.";
			
				public static final String DEPRECATED_MODEL_PART = ISSUE_CODE_PREFIX + "deprecatedModelPart";
			
				@Override
				protected void initialize(IAcceptor<PreferenceKey> acceptor) {
					super.initialize(acceptor);
					acceptor.accept(create(DEPRECATED_MODEL_PART, SeverityConverter.SEVERITY_WARNING));
				}
			}
		'''.toString, concatenationClientToString(fragment.generateIssueProvider))
	}
	
	@Test
	def testGenerateConfigurableIssueProviderWithoutDeprecation() {
		val fragment = initializeFragmentWithGrammarFromString(TestableValidatorFragment2, '''
			grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals
			generate foo "http://org.xtext/foo"
			Model: rules+=Rule;
			@Deprecated
			Rule: name=ID;
			@Deprecated
			CustomRule returns Rule: name=ID;
		''')
		fragment.generatePropertyPage = true
		assertEquals('''
			package org.xtext.validation;
			
			import org.eclipse.xtext.preferences.PreferenceKey;
			import org.eclipse.xtext.util.IAcceptor;
			import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;
			
			@SuppressWarnings("restriction")
			public class FooConfigurableIssueCodesProvider extends ConfigurableIssueCodesProvider {
				protected static final String ISSUE_CODE_PREFIX = "org.xtext.";
			
			
				@Override
				protected void initialize(IAcceptor<PreferenceKey> acceptor) {
					super.initialize(acceptor);
				}
			}
		'''.toString, concatenationClientToString(fragment.generateIssueProvider))
	}
	
	@Test
	def testGenerateConfigurableIssueProvideXbase() {
		val fragment = initializeFragmentWithGrammarFromStringWithXbase(TestableValidatorFragment2, '''
			grammar org.xtext.Foo with org.eclipse.xtext.xbase.Xbase
			generate foo "http://org.xtext/foo"
			Model: rules+=Rule;
			@Deprecated
			Rule: name=ID;
			@Deprecated
			CustomRule returns Rule: name=ID;
		''')
		fragment.generateDeprecationValidation = true
		assertEquals('''
			package org.xtext.validation;
			
			import org.eclipse.xtext.preferences.PreferenceKey;
			import org.eclipse.xtext.util.IAcceptor;
			import org.eclipse.xtext.validation.SeverityConverter;
			import org.eclipse.xtext.xbase.validation.XbaseConfigurableIssueCodes;
			
			@SuppressWarnings("restriction")
			public class FooConfigurableIssueCodesProvider extends XbaseConfigurableIssueCodes {
				protected static final String ISSUE_CODE_PREFIX = "org.xtext.";
			
				public static final String DEPRECATED_MODEL_PART = ISSUE_CODE_PREFIX + "deprecatedModelPart";
			
				@Override
				protected void initialize(IAcceptor<PreferenceKey> acceptor) {
					super.initialize(acceptor);
					acceptor.accept(create(DEPRECATED_MODEL_PART, SeverityConverter.SEVERITY_WARNING));
				}
			}
		'''.toString, concatenationClientToString(fragment.generateIssueProvider))
	}
	
	@Test
	def testGenerateConfigurableIssueProvideXbaseWithoutDeprecation() {
		val fragment = initializeFragmentWithGrammarFromStringWithXbase(TestableValidatorFragment2, '''
			grammar org.xtext.Foo with org.eclipse.xtext.xbase.Xbase
			generate foo "http://org.xtext/foo"
			Model: rules+=Rule;
			@Deprecated
			Rule: name=ID;
			@Deprecated
			CustomRule returns Rule: name=ID;
		''')
		fragment.generatePropertyPage = true
		assertEquals('''
			package org.xtext.validation;
			
			import org.eclipse.xtext.preferences.PreferenceKey;
			import org.eclipse.xtext.util.IAcceptor;
			import org.eclipse.xtext.xbase.validation.XbaseConfigurableIssueCodes;
			
			@SuppressWarnings("restriction")
			public class FooConfigurableIssueCodesProvider extends XbaseConfigurableIssueCodes {
				protected static final String ISSUE_CODE_PREFIX = "org.xtext.";
			
			
				@Override
				protected void initialize(IAcceptor<PreferenceKey> acceptor) {
					super.initialize(acceptor);
				}
			}
		'''.toString, concatenationClientToString(fragment.generateIssueProvider))
	}
	
	@Test
	def testGenerateValidationConfigurationBlock() {
		val fragment = initializeFragmentWithGrammarFromString(TestableValidatorFragment2, '''
			grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals
			generate foo "http://org.xtext/foo"
			Model: rules+=Rule;
			@Deprecated
			Rule: name=ID;
			@Deprecated
			CustomRule returns Rule: name=ID;
		''')
		fragment.generateDeprecationValidation = true
		assertEquals('''
			package org.xtext.validation;
			
			import org.eclipse.jface.dialogs.IDialogSettings;
			import org.eclipse.swt.widgets.Composite;
			import org.eclipse.xtext.ui.validation.AbstractValidatorConfigurationBlock;

			@SuppressWarnings("restriction")
			public class FooValidatorConfigurationBlock extends AbstractValidatorConfigurationBlock {
			
				protected static final String SETTINGS_SECTION_NAME = "Foo";
			
				@Override
				protected void fillSettingsPage(Composite composite, int nColumns, int defaultIndent) {
					addComboBox(FooConfigurableIssueCodesProvider.DEPRECATED_MODEL_PART, "Deprecated Model Part", composite, defaultIndent);
				}
			
				@Override
				public void dispose() {
					storeSectionExpansionStates(getDialogSettings());
					super.dispose();
				}
			
				@Override
				protected IDialogSettings getDialogSettings() {
					IDialogSettings dialogSettings = super.getDialogSettings();
					IDialogSettings section = dialogSettings.getSection(SETTINGS_SECTION_NAME);
					if (section == null) {
						return dialogSettings.addNewSection(SETTINGS_SECTION_NAME);
					}
					return section;
				}
			}
		'''.toString, concatenationClientToString(fragment.generateValidationConfigurationBlock))
	}
	
	@Test
	def testGenerateValidationConfigurationBlockWithoutDeprecation() {
		val fragment = initializeFragmentWithGrammarFromString(TestableValidatorFragment2, '''
			grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals
			generate foo "http://org.xtext/foo"
			Model: rules+=Rule;
			@Deprecated
			Rule: name=ID;
			@Deprecated
			CustomRule returns Rule: name=ID;
		''')
		fragment.generatePropertyPage = true
		assertEquals('''
			package org.xtext.validation;
			
			import org.eclipse.jface.dialogs.IDialogSettings;
			import org.eclipse.swt.widgets.Composite;
			import org.eclipse.xtext.ui.validation.AbstractValidatorConfigurationBlock;
			
			@SuppressWarnings("restriction")
			public class FooValidatorConfigurationBlock extends AbstractValidatorConfigurationBlock {
			
				protected static final String SETTINGS_SECTION_NAME = "Foo";
			
				@Override
				protected void fillSettingsPage(Composite composite, int nColumns, int defaultIndent) {
				}
			
				@Override
				public void dispose() {
					storeSectionExpansionStates(getDialogSettings());
					super.dispose();
				}
			
				@Override
				protected IDialogSettings getDialogSettings() {
					IDialogSettings dialogSettings = super.getDialogSettings();
					IDialogSettings section = dialogSettings.getSection(SETTINGS_SECTION_NAME);
					if (section == null) {
						return dialogSettings.addNewSection(SETTINGS_SECTION_NAME);
					}
					return section;
				}
			}
		'''.toString, concatenationClientToString(fragment.generateValidationConfigurationBlock))
	}
	
	@Test
	def testGenerateValidationConfigurationBlockXbase() {
		val fragment = initializeFragmentWithGrammarFromStringWithXbase(TestableValidatorFragment2, '''
			grammar org.xtext.Foo with org.eclipse.xtext.xbase.Xbase
			generate foo "http://org.xtext/foo"
			Model: rules+=Rule;
			@Deprecated
			Rule: name=ID;
			@Deprecated
			CustomRule returns Rule: name=ID;
		''')
		fragment.generateDeprecationValidation = true
		assertEquals('''
			package org.xtext.validation;
			
			import org.eclipse.jface.dialogs.IDialogSettings;
			import org.eclipse.swt.widgets.Composite;
			import org.eclipse.xtext.xbase.ui.validation.XbaseValidationConfigurationBlock;
			
			@SuppressWarnings("restriction")
			public class FooValidatorConfigurationBlock extends XbaseValidationConfigurationBlock {
			
				protected static final String SETTINGS_SECTION_NAME = "Foo";
			
				@Override
				protected void fillSettingsPage(Composite composite, int nColumns, int defaultIndent) {
					addComboBox(FooConfigurableIssueCodesProvider.DEPRECATED_MODEL_PART, "Deprecated Model Part", composite, defaultIndent);
					super.fillSettingsPage(composite, nColumns, defaultIndent);
				}
			
				@Override
				public void dispose() {
					storeSectionExpansionStates(getDialogSettings());
					super.dispose();
				}
			
				@Override
				protected IDialogSettings getDialogSettings() {
					IDialogSettings dialogSettings = super.getDialogSettings();
					IDialogSettings section = dialogSettings.getSection(SETTINGS_SECTION_NAME);
					if (section == null) {
						return dialogSettings.addNewSection(SETTINGS_SECTION_NAME);
					}
					return section;
				}
			}
		'''.toString, concatenationClientToString(fragment.generateValidationConfigurationBlock))
	}

}

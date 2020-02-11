/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.generator;

import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtend2.lib.StringConcatenationClient;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.xtext.generator.AbstractGeneratorFragmentTests;
import org.eclipse.xtext.xtext.generator.model.GeneratedJavaFileAccess;
import org.eclipse.xtext.xtext.generator.validation.ValidatorFragment2;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.14
 */
@SuppressWarnings("all")
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
  public void testGenerateNoValidation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate foo \"http://org.xtext/foo\"");
    _builder.newLine();
    _builder.append("Model: rules+=Rule;");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    final ValidatorFragment2Tests.TestableValidatorFragment2 fragment = this.<ValidatorFragment2Tests.TestableValidatorFragment2>initializeFragmentWithGrammarFromString(ValidatorFragment2Tests.TestableValidatorFragment2.class, _builder.toString());
    final List<AbstractRule> deprecatedRules = fragment.getDeprecatedRulesFromGrammar();
    Assert.assertTrue(deprecatedRules.isEmpty());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package org.xtext.validation;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import java.util.ArrayList;");
    _builder_1.newLine();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.emf.ecore.EPackage;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.validation.AbstractDeclarativeValidator;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("public abstract class AbstractFooValidator extends AbstractDeclarativeValidator {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected List<EPackage> getEPackages() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("List<EPackage> result = new ArrayList<EPackage>();");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("result.add(org.xtext.foo.FooPackage.eINSTANCE);");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("return result;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this.concatenationClientToString(fragment.generateGenValidator()));
  }
  
  @Test
  public void testGenerateValidation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate foo \"http://org.xtext/foo\"");
    _builder.newLine();
    _builder.append("Model: rules+=Rule;");
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("CustomRule returns Rule: name=ID;");
    _builder.newLine();
    final ValidatorFragment2Tests.TestableValidatorFragment2 fragment = this.<ValidatorFragment2Tests.TestableValidatorFragment2>initializeFragmentWithGrammarFromString(ValidatorFragment2Tests.TestableValidatorFragment2.class, _builder.toString());
    fragment.setGenerateDeprecationValidation(true);
    final List<AbstractRule> deprecatedRulesFromGrammar = fragment.getDeprecatedRulesFromGrammar();
    Assert.assertEquals(1, deprecatedRulesFromGrammar.size());
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package org.xtext.validation;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import java.util.ArrayList;");
    _builder_1.newLine();
    _builder_1.append("import java.util.List;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.emf.ecore.EPackage;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.validation.AbstractDeclarativeValidator;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.validation.Check;");
    _builder_1.newLine();
    _builder_1.append("import org.xtext.foo.Rule;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("public abstract class AbstractFooValidator extends AbstractDeclarativeValidator {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected List<EPackage> getEPackages() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("List<EPackage> result = new ArrayList<EPackage>();");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("result.add(org.xtext.foo.FooPackage.eINSTANCE);");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("return result;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Check");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public void checkDeprecatedRule(Rule element) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("addIssue(\"This part of the language is marked as deprecated and might get removed in the future!\", element, FooConfigurableIssueCodesProvider.DEPRECATED_MODEL_PART);");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this.concatenationClientToString(fragment.generateGenValidator()));
  }
  
  @Test
  public void testGenerateConfigurableIssueProvider() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate foo \"http://org.xtext/foo\"");
    _builder.newLine();
    _builder.append("Model: rules+=Rule;");
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("CustomRule returns Rule: name=ID;");
    _builder.newLine();
    final ValidatorFragment2Tests.TestableValidatorFragment2 fragment = this.<ValidatorFragment2Tests.TestableValidatorFragment2>initializeFragmentWithGrammarFromString(ValidatorFragment2Tests.TestableValidatorFragment2.class, _builder.toString());
    fragment.setGenerateDeprecationValidation(true);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package org.xtext.validation;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.preferences.PreferenceKey;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.util.IAcceptor;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.validation.SeverityConverter;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"restriction\")");
    _builder_1.newLine();
    _builder_1.append("public class FooConfigurableIssueCodesProvider extends ConfigurableIssueCodesProvider {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected static final String ISSUE_CODE_PREFIX = \"org.xtext.\";");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public static final String DEPRECATED_MODEL_PART = ISSUE_CODE_PREFIX + \"deprecatedModelPart\";");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected void initialize(IAcceptor<PreferenceKey> acceptor) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("super.initialize(acceptor);");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("acceptor.accept(create(DEPRECATED_MODEL_PART, SeverityConverter.SEVERITY_WARNING));");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this.concatenationClientToString(fragment.generateIssueProvider()));
  }
  
  @Test
  public void testGenerateConfigurableIssueProviderWithoutDeprecation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate foo \"http://org.xtext/foo\"");
    _builder.newLine();
    _builder.append("Model: rules+=Rule;");
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("CustomRule returns Rule: name=ID;");
    _builder.newLine();
    final ValidatorFragment2Tests.TestableValidatorFragment2 fragment = this.<ValidatorFragment2Tests.TestableValidatorFragment2>initializeFragmentWithGrammarFromString(ValidatorFragment2Tests.TestableValidatorFragment2.class, _builder.toString());
    fragment.setGeneratePropertyPage(true);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package org.xtext.validation;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.preferences.PreferenceKey;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.util.IAcceptor;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"restriction\")");
    _builder_1.newLine();
    _builder_1.append("public class FooConfigurableIssueCodesProvider extends ConfigurableIssueCodesProvider {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected static final String ISSUE_CODE_PREFIX = \"org.xtext.\";");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected void initialize(IAcceptor<PreferenceKey> acceptor) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("super.initialize(acceptor);");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this.concatenationClientToString(fragment.generateIssueProvider()));
  }
  
  @Test
  public void testGenerateConfigurableIssueProvideXbase() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.Foo with org.eclipse.xtext.xbase.Xbase");
    _builder.newLine();
    _builder.append("generate foo \"http://org.xtext/foo\"");
    _builder.newLine();
    _builder.append("Model: rules+=Rule;");
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("CustomRule returns Rule: name=ID;");
    _builder.newLine();
    final ValidatorFragment2Tests.TestableValidatorFragment2 fragment = this.<ValidatorFragment2Tests.TestableValidatorFragment2>initializeFragmentWithGrammarFromStringWithXbase(ValidatorFragment2Tests.TestableValidatorFragment2.class, _builder.toString());
    fragment.setGenerateDeprecationValidation(true);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package org.xtext.validation;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.preferences.PreferenceKey;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.util.IAcceptor;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.validation.SeverityConverter;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.validation.XbaseConfigurableIssueCodes;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"restriction\")");
    _builder_1.newLine();
    _builder_1.append("public class FooConfigurableIssueCodesProvider extends XbaseConfigurableIssueCodes {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected static final String ISSUE_CODE_PREFIX = \"org.xtext.\";");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public static final String DEPRECATED_MODEL_PART = ISSUE_CODE_PREFIX + \"deprecatedModelPart\";");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected void initialize(IAcceptor<PreferenceKey> acceptor) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("super.initialize(acceptor);");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("acceptor.accept(create(DEPRECATED_MODEL_PART, SeverityConverter.SEVERITY_WARNING));");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this.concatenationClientToString(fragment.generateIssueProvider()));
  }
  
  @Test
  public void testGenerateConfigurableIssueProvideXbaseWithoutDeprecation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.Foo with org.eclipse.xtext.xbase.Xbase");
    _builder.newLine();
    _builder.append("generate foo \"http://org.xtext/foo\"");
    _builder.newLine();
    _builder.append("Model: rules+=Rule;");
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("CustomRule returns Rule: name=ID;");
    _builder.newLine();
    final ValidatorFragment2Tests.TestableValidatorFragment2 fragment = this.<ValidatorFragment2Tests.TestableValidatorFragment2>initializeFragmentWithGrammarFromStringWithXbase(ValidatorFragment2Tests.TestableValidatorFragment2.class, _builder.toString());
    fragment.setGeneratePropertyPage(true);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package org.xtext.validation;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.preferences.PreferenceKey;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.util.IAcceptor;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.validation.XbaseConfigurableIssueCodes;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"restriction\")");
    _builder_1.newLine();
    _builder_1.append("public class FooConfigurableIssueCodesProvider extends XbaseConfigurableIssueCodes {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected static final String ISSUE_CODE_PREFIX = \"org.xtext.\";");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected void initialize(IAcceptor<PreferenceKey> acceptor) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("super.initialize(acceptor);");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this.concatenationClientToString(fragment.generateIssueProvider()));
  }
  
  @Test
  public void testGenerateValidationConfigurationBlock() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate foo \"http://org.xtext/foo\"");
    _builder.newLine();
    _builder.append("Model: rules+=Rule;");
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("CustomRule returns Rule: name=ID;");
    _builder.newLine();
    final ValidatorFragment2Tests.TestableValidatorFragment2 fragment = this.<ValidatorFragment2Tests.TestableValidatorFragment2>initializeFragmentWithGrammarFromString(ValidatorFragment2Tests.TestableValidatorFragment2.class, _builder.toString());
    fragment.setGenerateDeprecationValidation(true);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package org.xtext.validation;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.jface.dialogs.IDialogSettings;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.swt.widgets.Composite;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.ui.validation.AbstractValidatorConfigurationBlock;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"restriction\")");
    _builder_1.newLine();
    _builder_1.append("public class FooValidatorConfigurationBlock extends AbstractValidatorConfigurationBlock {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected static final String SETTINGS_SECTION_NAME = \"Foo\";");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected void fillSettingsPage(Composite composite, int nColumns, int defaultIndent) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("addComboBox(FooConfigurableIssueCodesProvider.DEPRECATED_MODEL_PART, \"Deprecated Model Part\", composite, defaultIndent);");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public void dispose() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("storeSectionExpansionStates(getDialogSettings());");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("super.dispose();");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected IDialogSettings getDialogSettings() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("IDialogSettings dialogSettings = super.getDialogSettings();");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("IDialogSettings section = dialogSettings.getSection(SETTINGS_SECTION_NAME);");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("if (section == null) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("return dialogSettings.addNewSection(SETTINGS_SECTION_NAME);");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("return section;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this.concatenationClientToString(fragment.generateValidationConfigurationBlock()));
  }
  
  @Test
  public void testGenerateValidationConfigurationBlockWithoutDeprecation() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.Foo with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate foo \"http://org.xtext/foo\"");
    _builder.newLine();
    _builder.append("Model: rules+=Rule;");
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("CustomRule returns Rule: name=ID;");
    _builder.newLine();
    final ValidatorFragment2Tests.TestableValidatorFragment2 fragment = this.<ValidatorFragment2Tests.TestableValidatorFragment2>initializeFragmentWithGrammarFromString(ValidatorFragment2Tests.TestableValidatorFragment2.class, _builder.toString());
    fragment.setGeneratePropertyPage(true);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package org.xtext.validation;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.jface.dialogs.IDialogSettings;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.swt.widgets.Composite;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.ui.validation.AbstractValidatorConfigurationBlock;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"restriction\")");
    _builder_1.newLine();
    _builder_1.append("public class FooValidatorConfigurationBlock extends AbstractValidatorConfigurationBlock {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected static final String SETTINGS_SECTION_NAME = \"Foo\";");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected void fillSettingsPage(Composite composite, int nColumns, int defaultIndent) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public void dispose() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("storeSectionExpansionStates(getDialogSettings());");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("super.dispose();");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected IDialogSettings getDialogSettings() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("IDialogSettings dialogSettings = super.getDialogSettings();");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("IDialogSettings section = dialogSettings.getSection(SETTINGS_SECTION_NAME);");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("if (section == null) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("return dialogSettings.addNewSection(SETTINGS_SECTION_NAME);");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("return section;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this.concatenationClientToString(fragment.generateValidationConfigurationBlock()));
  }
  
  @Test
  public void testGenerateValidationConfigurationBlockXbase() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.Foo with org.eclipse.xtext.xbase.Xbase");
    _builder.newLine();
    _builder.append("generate foo \"http://org.xtext/foo\"");
    _builder.newLine();
    _builder.append("Model: rules+=Rule;");
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("Rule: name=ID;");
    _builder.newLine();
    _builder.append("@Deprecated");
    _builder.newLine();
    _builder.append("CustomRule returns Rule: name=ID;");
    _builder.newLine();
    final ValidatorFragment2Tests.TestableValidatorFragment2 fragment = this.<ValidatorFragment2Tests.TestableValidatorFragment2>initializeFragmentWithGrammarFromStringWithXbase(ValidatorFragment2Tests.TestableValidatorFragment2.class, _builder.toString());
    fragment.setGenerateDeprecationValidation(true);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package org.xtext.validation;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.jface.dialogs.IDialogSettings;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.swt.widgets.Composite;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.ui.validation.XbaseValidationConfigurationBlock;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"restriction\")");
    _builder_1.newLine();
    _builder_1.append("public class FooValidatorConfigurationBlock extends XbaseValidationConfigurationBlock {");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected static final String SETTINGS_SECTION_NAME = \"Foo\";");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected void fillSettingsPage(Composite composite, int nColumns, int defaultIndent) {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("addComboBox(FooConfigurableIssueCodesProvider.DEPRECATED_MODEL_PART, \"Deprecated Model Part\", composite, defaultIndent);");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("super.fillSettingsPage(composite, nColumns, defaultIndent);");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("public void dispose() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("storeSectionExpansionStates(getDialogSettings());");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("super.dispose();");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("protected IDialogSettings getDialogSettings() {");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("IDialogSettings dialogSettings = super.getDialogSettings();");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("IDialogSettings section = dialogSettings.getSection(SETTINGS_SECTION_NAME);");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("if (section == null) {");
    _builder_1.newLine();
    _builder_1.append("\t\t\t");
    _builder_1.append("return dialogSettings.addNewSection(SETTINGS_SECTION_NAME);");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("\t\t");
    _builder_1.append("return section;");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this.concatenationClientToString(fragment.generateValidationConfigurationBlock()));
  }
}

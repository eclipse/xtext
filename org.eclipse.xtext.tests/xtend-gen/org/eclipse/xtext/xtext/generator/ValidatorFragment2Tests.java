/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
  }
  
  @Test
  public void testGenerateNothing() {
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
  public void testGenerate() {
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
    _builder_1.append("warning(\"This part of the language is marked as deprecated and might get removed in the future!\", element, null);");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this.concatenationClientToString(fragment.generateGenValidator()));
  }
  
  @Test
  public void testGenerate_NoValidation() {
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
    fragment.setGenerateDeprecationValidation(false);
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
}

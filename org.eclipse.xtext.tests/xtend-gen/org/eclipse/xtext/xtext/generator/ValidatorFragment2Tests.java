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
    final String generatedString = this.concatenationClientToString(fragment.generateValidationToDeprecateRules());
    int _length = generatedString.length();
    boolean _tripleEquals = (_length == 0);
    Assert.assertTrue(_tripleEquals);
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
    _builder_1.newLine();
    _builder_1.append("@interface org.eclipse.xtext.validation.Check");
    _builder_1.newLine();
    _builder_1.append("public void checkDeprecatedRule(org.xtext.foo.Rule element) {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("warning(\"This part of the language is marked as deprecated and might get removed in the future!\", element, null);");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    Assert.assertEquals(_builder_1.toString(), this.concatenationClientToString(fragment.generateValidationToDeprecateRules()));
  }
}

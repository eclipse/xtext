/**
 * Copyright (c) 2019, 2020 RCP Vision s.r.l. (http://www.rcp-vision.com) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xtext.ui.editor.quickfix;

import com.google.inject.Injector;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.IInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractQuickfixTest;
import org.eclipse.xtext.xtext.XtextConfigurableIssueCodes;
import org.eclipse.xtext.xtext.ui.Activator;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author loradd - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(XtextGrammarQuickfixTest.InjectorProvider.class)
@SuppressWarnings("all")
public class XtextGrammarQuickfixTest extends AbstractQuickfixTest {
  public static class InjectorProvider implements IInjectorProvider {
    @Override
    public Injector getInjector() {
      return Activator.getDefault().getInjector(Activator.ORG_ECLIPSE_XTEXT_XTEXT);
    }
  }
  
  @Test
  public void test_fix_missing_rule() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.newLine();
    _builder.append("generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Model:");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("greetings+=Greeting*;");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("generate myDsl \"http://www.xtext.org/example/mydsl/MyDsl\"");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("Model:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("greetings+=Greeting*;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("Greeting:");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.newLine();
    _builder_1.append(";");
    _builder_1.newLine();
    AbstractQuickfixTest.Quickfix _quickfix = new AbstractQuickfixTest.Quickfix("Create rule \'Greeting\'", "Create rule \'Greeting\'", _builder_1.toString());
    this.testQuickfixesOn(_builder, "org.eclipse.xtext.grammar.UnresolvedRule", _quickfix);
  }
  
  @Test
  public void test_fix_empty_keyword() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate myDsl \"http://www.xtext.org/mydsl/MyDsl\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Model: \"\" a=ID;");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals");
    _builder_1.newLine();
    _builder_1.append("generate myDsl \"http://www.xtext.org/mydsl/MyDsl\"");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("Model:  a=ID;");
    _builder_1.newLine();
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals");
    _builder_2.newLine();
    _builder_2.append("generate myDsl \"http://www.xtext.org/mydsl/MyDsl\"");
    _builder_2.newLine();
    _builder_2.newLine();
    _builder_2.append("Model: \"model\" a=ID;");
    _builder_2.newLine();
    this.testQuickfixesOn(_builder, XtextConfigurableIssueCodes.EMPTY_KEYWORD, 
      this.removeEmptyKeywordQuickfix(_builder_1.toString()), 
      this.replaceEmptyKeywordWithRuleNameQuickfix(_builder_2.toString()));
  }
  
  @Test
  public void fix_keyword_with_spaces() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate myDsl \"http://www.xtext.org/mydsl/MyDsl\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Model: \' a b c d \' a=ID;");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals");
    _builder_1.newLine();
    _builder_1.append("generate myDsl \"http://www.xtext.org/mydsl/MyDsl\"");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("Model: \'a\' \'b\' \'c\' \'d\' a=ID;");
    _builder_1.newLine();
    this.applyKeywordWithSpacesQuickfix(_builder, _builder_1.toString());
  }
  
  @Test
  public void fix_empty_keyword_with_spaces() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate myDsl \"http://www.xtext.org/mydsl/MyDsl\"");
    _builder.newLine();
    _builder.newLine();
    _builder.append("Model: \'    \' a=ID;");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals");
    _builder_1.newLine();
    _builder_1.append("generate myDsl \"http://www.xtext.org/mydsl/MyDsl\"");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("Model: \'model\' a=ID;");
    _builder_1.newLine();
    this.applyKeywordWithSpacesQuickfix(_builder, _builder_1.toString());
  }
  
  private AbstractQuickfixTest.Quickfix removeEmptyKeywordQuickfix(final String result) {
    return new AbstractQuickfixTest.Quickfix("Remove empty keyword", "Remove empty keyword", result);
  }
  
  private AbstractQuickfixTest.Quickfix replaceEmptyKeywordWithRuleNameQuickfix(final String result) {
    return new AbstractQuickfixTest.Quickfix("Replace empty keyword with rule name", "Replace empty keyword with rule name", result);
  }
  
  private void applyKeywordWithSpacesQuickfix(final CharSequence input, final String result) {
    final String issueCode = XtextConfigurableIssueCodes.SPACES_IN_KEYWORD;
    final String label = "Fix keyword with spaces";
    final String description = "Fix keyword with spaces";
    AbstractQuickfixTest.Quickfix _quickfix = new AbstractQuickfixTest.Quickfix(label, description, result);
    this.testQuickfixesOn(input, issueCode, _quickfix);
  }
}

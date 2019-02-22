/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xtext.ui.editor.quickfix;

import com.google.inject.Injector;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.IInjectorProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.testing.AbstractQuickfixTest;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
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
  public void testFixKeywordWithSpaces() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Model: \' a b c d \' a=ID;");
    String _grammarWithRules = this.grammarWithRules(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Model: \'a\' \'b\' \'c\' \'d\' a=ID;");
    String _grammarWithRules_1 = this.grammarWithRules(_builder_1);
    AbstractQuickfixTest.Quickfix _quickfix = new AbstractQuickfixTest.Quickfix("Fix keyword with spaces", "Fix keyword with spaces", _grammarWithRules_1);
    this.testQuickfixesOn(_grammarWithRules, XtextConfigurableIssueCodes.SPACES_IN_KEYWORD, _quickfix);
  }
  
  @Test
  public void testFixEmptyKeywordWithSpaces() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("Model: \'    \' a=ID;");
    String _grammarWithRules = this.grammarWithRules(_builder);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("Model: \'\' a=ID;");
    String _grammarWithRules_1 = this.grammarWithRules(_builder_1);
    AbstractQuickfixTest.Quickfix _quickfix = new AbstractQuickfixTest.Quickfix("Fix keyword with spaces", "Fix keyword with spaces", _grammarWithRules_1);
    this.testQuickfixesOn(_grammarWithRules, XtextConfigurableIssueCodes.SPACES_IN_KEYWORD, _quickfix);
  }
  
  private String grammarWithRules(final CharSequence... rules) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("grammar org.xtext.example.mydsl.MyDsl with org.eclipse.xtext.common.Terminals");
    _builder.newLine();
    _builder.append("generate myDsl \"http://www.xtext.org/mydsl/MyDsl\"");
    _builder.newLine();
    String _join = IterableExtensions.join(((Iterable<?>)Conversions.doWrapArray(rules)), "\n");
    _builder.append(_join);
    _builder.newLineIfNotEmpty();
    return _builder.toString();
  }
}

/**
 * Copyright (c) 2019, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.xmleditor;

import javax.inject.Inject;
import javax.inject.Named;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.LexerUIBindings;
import org.eclipse.xtext.ui.tests.xmleditor.AbstractXmlLexerTest;
import org.eclipse.xtext.ui.tests.xmleditor.ui.tests.XmlUiInjectorProvider;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(XmlUiInjectorProvider.class)
@SuppressWarnings("all")
public class XmlContentAssistLexerTests extends AbstractXmlLexerTest {
  @Inject
  @Named(LexerUIBindings.CONTENT_ASSIST)
  private Lexer lexer;
  
  @Override
  public org.antlr.runtime.Lexer lexer() {
    return this.lexer;
  }
  
  @Override
  public void test022() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\"/>");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("RULE_TAG_START_OPEN \'<\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'a\'");
    _builder_1.newLine();
    _builder_1.append("RULE_WS \' \'");
    _builder_1.newLine();
    _builder_1.append("RULE_ID \'b\'");
    _builder_1.newLine();
    _builder_1.append("RULE_ATTR_EQ \'=\'");
    _builder_1.newLine();
    _builder_1.append("RULE_TAG_EMPTY_CLOSE \'/>\'");
    _builder_1.newLine();
    this.assertLexing(_builder, _builder_1);
  }
}

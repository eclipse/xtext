/**
 * Copyright (c) 2013, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.editor;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.jface.text.Document;
import org.eclipse.xtend.core.parser.antlr.XtendAntlrTokenFileProvider;
import org.eclipse.xtend.core.parser.antlr.internal.FlexerFactory;
import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;
import org.eclipse.xtend.ide.editor.model.XtendDocumentTokenSource;
import org.eclipse.xtend.ide.tests.RuntimeInjectorProvider;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.testing.AbstractDamagerRepairerTest;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(RuntimeInjectorProvider.class)
@SuppressWarnings("all")
public class PresentationDamagerTest extends AbstractDamagerRepairerTest {
  @Inject
  private FlexerFactory flexerFactory;

  @Override
  protected Lexer createLexer() {
    return new InternalXtendLexer();
  }

  @Test
  public void testRichString_0() {
    try {
      this.assertEquals(5, 14, this.check("text \'\'\'rich\ntext\'\'\'", 6, 1, ""));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testRichString_1() {
    try {
      this.assertEquals(5, 14, this.check("text \'\'\'rich\ntext\'\'\'", 7, 1, ""));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testRichString_2() {
    try {
      this.assertEquals(4, 16, this.check("text \'\'rich\ntext\'\'\'", 5, 0, "\'"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testRichString_3() {
    try {
      this.assertEquals(5, 15, this.check("text \'\'rich\ntext\'\'\'", 6, 0, "\'"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testRichString_4() {
    try {
      this.assertEquals(0, 19, this.check("\'\'\'rich\ntext\'\'\' text", 14, 1, ""));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testRichString_5() {
    try {
      this.assertEquals(0, 19, this.check("\'\'\'rich\ntext\'\'\' text", 13, 1, ""));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testRichString_6() {
    try {
      this.assertEquals(0, 20, this.check("\'\'\'rich\ntext\'\' text", 14, 0, "\'"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testRichString_7() {
    try {
      this.assertEquals(0, 20, this.check("\'\'\'rich\ntext\'\' text", 13, 0, "\'"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testRichString_8() {
    try {
      this.assertEquals(5, 20, this.check("text \'\'\'rich\ntext\'\'\' text", 11, 1, "«text»"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testRichString_9() {
    try {
      this.assertEquals(4, 20, this.check("text\'\'\'rich\ntext\'\'\' text", 10, 1, "«text»"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testString_0() {
    try {
      this.assertEquals(4, 17, this.check("text \'string\ntext\'text", 5, 1, ""));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testString_1() {
    try {
      this.assertEquals(4, 17, this.check("text string\ntext\'text", 5, 1, "\'"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testString_2() {
    try {
      this.assertEquals(4, 26, this.check("text string\ntext\'text\'\'string", 5, 0, "\'"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testOverlapingMultilineTokens() {
    try {
      this.assertEquals(4, 37, this.check("text/* comment\ncomment\' */\n\'string\'text", 14, 0, "*/"));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Override
  public Document createDocument(final String before) throws Exception {
    XtextDocument _xblockexpression = null;
    {
      XtendDocumentTokenSource _xtendDocumentTokenSource = new XtendDocumentTokenSource();
      final Procedure1<XtendDocumentTokenSource> _function = (XtendDocumentTokenSource it) -> {
        AntlrTokenDefProvider _antlrTokenDefProvider = new AntlrTokenDefProvider();
        final Procedure1<AntlrTokenDefProvider> _function_1 = (AntlrTokenDefProvider it_1) -> {
          XtendAntlrTokenFileProvider _xtendAntlrTokenFileProvider = new XtendAntlrTokenFileProvider();
          it_1.setAntlrTokenFileProvider(_xtendAntlrTokenFileProvider);
        };
        AntlrTokenDefProvider _doubleArrow = ObjectExtensions.<AntlrTokenDefProvider>operator_doubleArrow(_antlrTokenDefProvider, _function_1);
        it.setTokenDefProvider(_doubleArrow);
        final Provider<Lexer> _function_2 = () -> {
          return this.createLexer();
        };
        it.setLexer(_function_2);
        it.setFlexerFactory(this.flexerFactory);
      };
      final XtendDocumentTokenSource source = ObjectExtensions.<XtendDocumentTokenSource>operator_doubleArrow(_xtendDocumentTokenSource, _function);
      final XtextDocument document = new XtextDocument(source, null, this.outdatedStateManager, this.operationCanceledManager);
      document.set(before);
      _xblockexpression = document;
    }
    return _xblockexpression;
  }
}

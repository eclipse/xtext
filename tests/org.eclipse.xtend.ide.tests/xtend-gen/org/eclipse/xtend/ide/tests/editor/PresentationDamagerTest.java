package org.eclipse.xtend.ide.tests.editor;

import com.google.inject.Inject;
import com.google.inject.Provider;
import org.eclipse.jface.text.Document;
import org.eclipse.jface.text.IRegion;
import org.eclipse.xtend.core.parser.antlr.XtendAntlrTokenFileProvider;
import org.eclipse.xtend.core.parser.antlr.internal.FlexerFactory;
import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend.ide.editor.model.XtendDocumentTokenSource;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.ui.AbstractDamagerRepairerTest;
import org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
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
  
  protected Lexer createLexer() {
    return new InternalXtendLexer();
  }
  
  @Test
  public void testRichString_0() {
    try {
      IRegion _check = this.check("text \'\'\'rich\ntext\'\'\'", 6, 1, "");
      this.assertEquals(5, 14, _check);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRichString_1() {
    try {
      IRegion _check = this.check("text \'\'\'rich\ntext\'\'\'", 7, 1, "");
      this.assertEquals(5, 14, _check);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRichString_2() {
    try {
      IRegion _check = this.check("text \'\'rich\ntext\'\'\'", 5, 0, "\'");
      this.assertEquals(4, 16, _check);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRichString_3() {
    try {
      IRegion _check = this.check("text \'\'rich\ntext\'\'\'", 6, 0, "\'");
      this.assertEquals(5, 15, _check);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRichString_4() {
    try {
      IRegion _check = this.check("\'\'\'rich\ntext\'\'\' text", 14, 1, "");
      this.assertEquals(0, 19, _check);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRichString_5() {
    try {
      IRegion _check = this.check("\'\'\'rich\ntext\'\'\' text", 13, 1, "");
      this.assertEquals(0, 19, _check);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRichString_6() {
    try {
      IRegion _check = this.check("\'\'\'rich\ntext\'\' text", 14, 0, "\'");
      this.assertEquals(0, 20, _check);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRichString_7() {
    try {
      IRegion _check = this.check("\'\'\'rich\ntext\'\' text", 13, 0, "\'");
      this.assertEquals(0, 20, _check);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRichString_8() {
    try {
      IRegion _check = this.check("text \'\'\'rich\ntext\'\'\' text", 11, 1, "«text»");
      this.assertEquals(5, 20, _check);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRichString_9() {
    try {
      IRegion _check = this.check("text\'\'\'rich\ntext\'\'\' text", 10, 1, "«text»");
      this.assertEquals(4, 20, _check);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testString_0() {
    try {
      IRegion _check = this.check("text \'string\ntext\'text", 5, 1, "");
      this.assertEquals(4, 17, _check);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testString_1() {
    try {
      IRegion _check = this.check("text string\ntext\'text", 5, 1, "\'");
      this.assertEquals(4, 17, _check);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testString_2() {
    try {
      IRegion _check = this.check("text string\ntext\'text\'\'string", 5, 0, "\'");
      this.assertEquals(4, 26, _check);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOverlapingMultilineTokens() {
    try {
      IRegion _check = this.check("text/* comment\ncomment\' */\n\'string\'text", 14, 0, "*/");
      this.assertEquals(4, 37, _check);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public Document createDocument(final String before) throws Exception {
    XtextDocument _xblockexpression = null;
    {
      XtendDocumentTokenSource _xtendDocumentTokenSource = new XtendDocumentTokenSource();
      final Procedure1<XtendDocumentTokenSource> _function = new Procedure1<XtendDocumentTokenSource>() {
        public void apply(final XtendDocumentTokenSource it) {
          AntlrTokenDefProvider _antlrTokenDefProvider = new AntlrTokenDefProvider();
          final Procedure1<AntlrTokenDefProvider> _function = new Procedure1<AntlrTokenDefProvider>() {
            public void apply(final AntlrTokenDefProvider it) {
              XtendAntlrTokenFileProvider _xtendAntlrTokenFileProvider = new XtendAntlrTokenFileProvider();
              it.setAntlrTokenFileProvider(_xtendAntlrTokenFileProvider);
            }
          };
          AntlrTokenDefProvider _doubleArrow = ObjectExtensions.<AntlrTokenDefProvider>operator_doubleArrow(_antlrTokenDefProvider, _function);
          it.setTokenDefProvider(_doubleArrow);
          final Provider<Lexer> _function_1 = new Provider<Lexer>() {
            public Lexer get() {
              return PresentationDamagerTest.this.createLexer();
            }
          };
          it.setLexer(_function_1);
          it.setFlexerFactory(PresentationDamagerTest.this.flexerFactory);
        }
      };
      final XtendDocumentTokenSource source = ObjectExtensions.<XtendDocumentTokenSource>operator_doubleArrow(_xtendDocumentTokenSource, _function);
      final XtextDocument document = new XtextDocument(source, null);
      document.set(before);
      _xblockexpression = document;
    }
    return _xblockexpression;
  }
}

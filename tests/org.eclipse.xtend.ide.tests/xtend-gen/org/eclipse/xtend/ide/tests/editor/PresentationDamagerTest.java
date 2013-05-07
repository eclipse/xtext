package org.eclipse.xtend.ide.tests.editor;

import org.eclipse.jface.text.IRegion;
import org.eclipse.xtend.core.parser.antlr.internal.InternalXtendLexer;
import org.eclipse.xtext.junit4.ui.AbstractDamagerRepairerTest;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Test;

@SuppressWarnings("all")
public class PresentationDamagerTest extends AbstractDamagerRepairerTest {
  protected Lexer createLexer() {
    InternalXtendLexer _internalXtendLexer = new InternalXtendLexer();
    return _internalXtendLexer;
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
      this.assertEquals(5, 15, _check);
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
      IRegion _check = this.check("text \'\'\'rich\ntext\'\'\' text", 11, 1, "\u00ABtext\u00BB");
      this.assertEquals(5, 20, _check);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testRichString_9() {
    try {
      IRegion _check = this.check("text\'\'\'rich\ntext\'\'\' text", 10, 1, "\u00ABtext\u00BB");
      this.assertEquals(4, 20, _check);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testString_0() {
    try {
      IRegion _check = this.check("text \'string\ntext\'text", 5, 1, "");
      this.assertEquals(5, 16, _check);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testString_1() {
    try {
      IRegion _check = this.check("text string\ntext\'text", 5, 1, "\'");
      this.assertEquals(5, 16, _check);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testString_2() {
    try {
      IRegion _check = this.check("text string\ntext\'text\'\'string", 5, 0, "\'");
      this.assertEquals(5, 25, _check);
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
}

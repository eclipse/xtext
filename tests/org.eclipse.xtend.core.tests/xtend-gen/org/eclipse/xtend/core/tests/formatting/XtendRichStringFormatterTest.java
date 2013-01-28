package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend.core.tests.formatting.AbstractXtendFormatterTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendRichStringFormatterTest extends AbstractXtendFormatterTest {
  @Test
  public void testSimple() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = ```foo```;");
    _builder.newLine();
    this.assertFormattedRichStringExpression(_builder);
  }
  
  @Test
  public void testSimpleVar() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = ```foo<<newArrayList()>>>bar```");
    _builder.newLine();
    this.assertFormattedRichStringExpression(_builder);
  }
  
  @Test
  public void testIndentation1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = ```");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("foo");
    _builder.newLine();
    _builder.append("```");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val x = ```");
    _builder_1.newLine();
    _builder_1.append("foo");
    _builder_1.newLine();
    _builder_1.append("```");
    _builder_1.newLine();
    this.assertFormattedRichStringExpression(_builder, _builder_1);
  }
  
  @Test
  public void testIndentation2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = ```x");
    _builder.newLine();
    _builder.append("foo");
    _builder.newLine();
    _builder.append("```");
    _builder.newLine();
    this.assertFormattedRichStringExpression(_builder);
  }
  
  @Test
  public void testIndentation3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = ```x");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("foo");
    _builder.newLine();
    _builder.append("```");
    _builder.newLine();
    this.assertFormattedRichStringExpression(_builder);
  }
  
  @Test
  public void testIndentation4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = ```");
    _builder.newLine();
    _builder.append("  ");
    _builder.append("foo");
    _builder.newLine();
    _builder.append("x```");
    _builder.newLine();
    this.assertFormattedRichStringExpression(_builder);
  }
  
  @Test
  public void testIf1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = ```");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<<IF 1 == 1>>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("bar");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<<ENDIF>>");
    _builder.newLine();
    _builder.append("```");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val x = ```");
    _builder_1.newLine();
    _builder_1.append("foo");
    _builder_1.newLine();
    _builder_1.append("<<IF 1 == 1>>");
    _builder_1.newLine();
    _builder_1.append("bar");
    _builder_1.newLine();
    _builder_1.append("<<ENDIF>>");
    _builder_1.newLine();
    _builder_1.append("```");
    _builder_1.newLine();
    this.assertFormattedRichStringExpression(_builder, _builder_1);
  }
  
  @Test
  public void testIf2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = ```");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("foo");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("<<IF 1 == 1>>");
    _builder.newLine();
    _builder.append("\t  \t");
    _builder.append("bar");
    _builder.newLine();
    _builder.append("\t  ");
    _builder.append("<<ENDIF>>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("baz");
    _builder.newLine();
    _builder.append("```");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val x = ```");
    _builder_1.newLine();
    _builder_1.append("foo");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("<<IF 1 == 1>>");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("bar");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("<<ENDIF>>");
    _builder_1.newLine();
    _builder_1.append("baz");
    _builder_1.newLine();
    _builder_1.append("```");
    _builder_1.newLine();
    this.assertFormattedRichStringExpression(_builder, _builder_1);
  }
  
  @Test
  public void testIfElse() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = ```");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<<IF 1 == 1>>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("bar");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<<ELSE>>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("baz");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<<ENDIF>>");
    _builder.newLine();
    _builder.append("```");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val x = ```");
    _builder_1.newLine();
    _builder_1.append("foo");
    _builder_1.newLine();
    _builder_1.append("<<IF 1 == 1>>");
    _builder_1.newLine();
    _builder_1.append("bar");
    _builder_1.newLine();
    _builder_1.append("<<ELSE>>");
    _builder_1.newLine();
    _builder_1.append("baz");
    _builder_1.newLine();
    _builder_1.append("<<ENDIF>>");
    _builder_1.newLine();
    _builder_1.append("```");
    _builder_1.newLine();
    this.assertFormattedRichStringExpression(_builder, _builder_1);
  }
  
  @Test
  public void testIfElseIfElse() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = ```");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<<IF 1 == 1>>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("bar");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<<ELSEIF 1 == 1>>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("baz");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<<ELSE>>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("buz");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<<ENDIF>>");
    _builder.newLine();
    _builder.append("```");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val x = ```");
    _builder_1.newLine();
    _builder_1.append("foo");
    _builder_1.newLine();
    _builder_1.append("<<IF 1 == 1>>");
    _builder_1.newLine();
    _builder_1.append("bar");
    _builder_1.newLine();
    _builder_1.append("<<ELSEIF 1 == 1>>");
    _builder_1.newLine();
    _builder_1.append("baz");
    _builder_1.newLine();
    _builder_1.append("<<ELSE>>");
    _builder_1.newLine();
    _builder_1.append("buz");
    _builder_1.newLine();
    _builder_1.append("<<ENDIF>>");
    _builder_1.newLine();
    _builder_1.append("```");
    _builder_1.newLine();
    this.assertFormattedRichStringExpression(_builder, _builder_1);
  }
  
  @Test
  public void testIfElseIfElseInline() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = ```");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("foo<<IF 1 == 1>>bar<<ELSEIF 1 == 1>>baz<<ELSE>>buz<<ENDIF>>");
    _builder.newLine();
    _builder.append("```");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val x = ```");
    _builder_1.newLine();
    _builder_1.append("foo<<IF 1 == 1>>bar<<ELSEIF 1 == 1>>baz<<ELSE>>buz<<ENDIF>>");
    _builder_1.newLine();
    _builder_1.append("```");
    _builder_1.newLine();
    this.assertFormattedRichStringExpression(_builder, _builder_1);
  }
  
  @Test
  public void testIfNested() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = ```");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<<IF 1 == 1>>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("bar");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<<IF 1 == 1>>");
    _builder.newLine();
    _builder.append("\t\t\t");
    _builder.append("baz");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<<ENDIF>>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<<ENDIF>>");
    _builder.newLine();
    _builder.append("```");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("val x = ```");
    _builder_1.newLine();
    _builder_1.append("foo");
    _builder_1.newLine();
    _builder_1.append("<<IF 1 == 1>>");
    _builder_1.newLine();
    _builder_1.append("bar");
    _builder_1.newLine();
    _builder_1.append("<<IF 1 == 1>>");
    _builder_1.newLine();
    _builder_1.append("baz");
    _builder_1.newLine();
    _builder_1.append("<<ENDIF>>");
    _builder_1.newLine();
    _builder_1.append("<<ENDIF>>");
    _builder_1.newLine();
    _builder_1.append("```");
    _builder_1.newLine();
    this.assertFormattedRichStringExpression(_builder, _builder_1);
  }
  
  @Test
  public void testForLoop() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = ```");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<<FOR String y : newArrayList(\"a\")>>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<<ENDFOR>>");
    _builder.newLine();
    _builder.append("```");
    _builder.newLine();
    this.assertFormattedRichStringExpression(_builder);
  }
  
  @Test
  public void testForLoopInline() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = ```");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<<FOR String y : newArrayList(\"a\")>>foo<<ENDFOR>>");
    _builder.newLine();
    _builder.append("```");
    _builder.newLine();
    this.assertFormattedRichStringExpression(_builder);
  }
  
  @Test
  public void testForLoopNested() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = ```");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<<FOR String y : newArrayList(\"a\")>>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("foo");
    _builder.newLine();
    _builder.append("\t\t  ");
    _builder.append("<<FOR String y : newArrayList(\"a\")>>");
    _builder.newLine();
    _builder.append("\t\t  \t");
    _builder.append("bar");
    _builder.newLine();
    _builder.append("\t\t  ");
    _builder.append("<<ENDFOR>>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<<ENDFOR>>");
    _builder.newLine();
    _builder.append("```");
    _builder.newLine();
    this.assertFormattedRichStringExpression(_builder);
  }
  
  @Test
  public void testForLoopParams() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = ```");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<<FOR String y : newArrayList(\"a\") BEFORE 1 + 1 SEPARATOR 1 + 1 AFTER 1 + 1>>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<<ENDFOR>>");
    _builder.newLine();
    _builder.append("```");
    _builder.newLine();
    this.assertFormattedRichStringExpression(_builder);
  }
  
  @Ignore(value = "https://bugs.eclipse.org/bugs/show_bug.cgi?id=394277")
  @Test
  public void testForEmpty() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = ```");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<<>>");
    _builder.newLine();
    _builder.append("```");
    _builder.newLine();
    this.assertFormattedRichStringExpression(_builder);
  }
  
  @Test
  public void testForSyntaxErrors() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = ```");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<<");
    _builder.newLine();
    _builder.append("```");
    _builder.newLine();
    this.assertFormattedRichStringExpressionWithErrors(_builder);
  }
}

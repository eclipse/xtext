package org.eclipse.xtend.core.tests.formatting;

import org.eclipse.xtend.core.tests.formatting.AbstractFormatterTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.junit.Test;

@SuppressWarnings("all")
public class XtendRichStringFormatterTest extends AbstractFormatterTest {
  private String decode(final CharSequence seq) {
    String _string = seq.toString();
    String _replace = _string.replace("<<", "\u00AB");
    String _replace_1 = _replace.replace(">>", "\u00BB");
    String _replace_2 = _replace_1.replace("```", "\'\'\'");
    return _replace_2;
  }
  
  public void assertFormattedRichStringExpression(final CharSequence seq) {
    String _decode = this.decode(seq);
    this.assertFormattedExpression(_decode);
  }
  
  public void assertFormattedRichStringExpression(final CharSequence expected, final CharSequence actual) {
    String _decode = this.decode(expected);
    String _decode_1 = this.decode(actual);
    this.assertFormattedExpression(_decode, _decode_1);
  }
  
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
  public void testIndentation5() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val x = ```");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("foo");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<<IF true>>");
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
    _builder_1.append("<<IF true>>");
    _builder_1.newLine();
    _builder_1.append("bar");
    _builder_1.newLine();
    _builder_1.append("<<ENDIF>>");
    _builder_1.newLine();
    _builder_1.append("```");
    _builder_1.newLine();
    this.assertFormattedRichStringExpression(_builder, _builder_1);
  }
}

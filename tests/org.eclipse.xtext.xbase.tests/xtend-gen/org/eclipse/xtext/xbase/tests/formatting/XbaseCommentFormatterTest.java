package org.eclipse.xtext.xbase.tests.formatting;

import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.xbase.tests.formatting.AbstractXbaseFormatterTest;
import org.junit.Test;

@SuppressWarnings("all")
public class XbaseCommentFormatterTest extends AbstractXbaseFormatterTest {
  @Test
  public void commentInIfExpression() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if (true)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"foo\")");
    _builder.newLine();
    _builder.append("else // if (true)");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("println(\"bar\")");
    _builder.newLine();
    _builder.append("println(\"end\")");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void commentAfterForExpression1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("for (f : #[])");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("if (1 < 2) {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("// foo");
    _builder.newLine();
    _builder.append("var lastOffset = \"\"");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
  
  @Test
  public void commentAfterForExpression3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("val ll = #[].map(e|e.toString) // error here");
    _builder.newLine();
    this.assertFormattedExpression(_builder);
  }
}

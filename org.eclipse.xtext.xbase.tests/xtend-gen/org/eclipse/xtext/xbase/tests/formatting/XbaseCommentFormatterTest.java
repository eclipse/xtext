package org.eclipse.xtext.xbase.tests.formatting;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.formatter.FormatterTestRequest;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.tests.formatting.XbaseFormatterTestInjectorProvider;
import org.eclipse.xtext.xbase.tests.formatting.XbaseFormatterTester;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(XbaseFormatterTestInjectorProvider.class)
@SuppressWarnings("all")
public class XbaseCommentFormatterTest {
  @Inject
  @Extension
  private XbaseFormatterTester _xbaseFormatterTester;
  
  @Test
  public void commentInIfExpression() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
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
      it.setToBeFormatted(_builder);
    };
    this._xbaseFormatterTester.assertFormattedExpression(_function);
  }
  
  @Test
  public void commentAfterForExpression1() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
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
      it.setToBeFormatted(_builder);
    };
    this._xbaseFormatterTester.assertFormattedExpression(_function);
  }
  
  @Test
  public void commentAfterForExpression3() {
    final Procedure1<FormatterTestRequest> _function = (FormatterTestRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("val ll = #[].map(e|e.toString) // error here");
      _builder.newLine();
      it.setToBeFormatted(_builder);
    };
    this._xbaseFormatterTester.assertFormattedExpression(_function);
  }
}

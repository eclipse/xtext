package org.eclipse.xtend.ide.tests.contentassist;

import java.util.List;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtend.ide.tests.contentassist.AbstractXtendContentAssistBugTest;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class JavaDocContentAssistTest extends AbstractXtendContentAssistBugTest {
  @Test
  public void testTypeInJavaDoc() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @see java.util.Dat");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo {}");
      _builder.newLine();
      ContentAssistProcessorTestBuilder _applyProposal = _newBuilder.append(_builder.toString()).assertTextAtCursorPosition(37, "java.util.Date").applyProposal(37);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package foo");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import java.util.Date");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("/**");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("* @see Date");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("*/");
      _builder_1.newLine();
      _builder_1.append("class Foo {}");
      _builder_1.newLine();
      _applyProposal.expectContent(_builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTypeInJavaDoc_2() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @see java.lang.StringBuff");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo {}");
      _builder.newLine();
      ContentAssistProcessorTestBuilder _applyProposal = _newBuilder.append(_builder.toString()).assertTextAtCursorPosition(44, "StringBuffer").applyProposal(44);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package foo");
      _builder_1.newLine();
      _builder_1.append("/**");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("* @see StringBuffer");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("*/");
      _builder_1.newLine();
      _builder_1.append("class Foo {}");
      _builder_1.newLine();
      _applyProposal.expectContent(_builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTypeInJavaDoc_3() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* java.lang.StringBuff");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo {}");
      _builder.newLine();
      Assert.assertTrue(
        ((List<ICompletionProposal>)Conversions.doWrapArray(_newBuilder.append(_builder.toString()).computeCompletionProposals(39))).isEmpty());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTypeInJavaDoc_4() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* @see    java.lang.StringBuff");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo {}");
      _builder.newLine();
      ContentAssistProcessorTestBuilder _applyProposal = _newBuilder.append(_builder.toString()).assertTextAtCursorPosition(47, "StringBuffer").applyProposal(47);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package foo");
      _builder_1.newLine();
      _builder_1.append("/**");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("* @see    StringBuffer");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("*/");
      _builder_1.newLine();
      _builder_1.append("class Foo {}");
      _builder_1.newLine();
      _applyProposal.expectContent(_builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTypeInJavaDoc_5() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* {@link java.lang.StringBuff");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo {}");
      _builder.newLine();
      ContentAssistProcessorTestBuilder _applyProposal = _newBuilder.append(_builder.toString()).assertTextAtCursorPosition(46, "StringBuffer").applyProposal(46);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package foo");
      _builder_1.newLine();
      _builder_1.append("/**");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("* {@link StringBuffer");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("*/");
      _builder_1.newLine();
      _builder_1.append("class Foo {}");
      _builder_1.newLine();
      _applyProposal.expectContent(_builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testTypeInJavaDoc_6() {
    try {
      ContentAssistProcessorTestBuilder _newBuilder = this.newBuilder();
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo");
      _builder.newLine();
      _builder.append("/**");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("* {@link    java.lang.StringBuff");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("*/");
      _builder.newLine();
      _builder.append("class Foo {}");
      _builder.newLine();
      ContentAssistProcessorTestBuilder _applyProposal = _newBuilder.append(_builder.toString()).assertTextAtCursorPosition(49, "StringBuffer").applyProposal(49);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package foo");
      _builder_1.newLine();
      _builder_1.append("/**");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("* {@link    StringBuffer");
      _builder_1.newLine();
      _builder_1.append(" ");
      _builder_1.append("*/");
      _builder_1.newLine();
      _builder_1.append("class Foo {}");
      _builder_1.newLine();
      _applyProposal.expectContent(_builder_1.toString());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

/**
 * Copyright (c) 2013, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.ide.tests.contentassist;

import java.util.Collections;
import java.util.List;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.ui.testing.ContentAssistProcessorTestBuilder;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class JavaDocContentAssistTest extends AbstractXtendContentAssistBugTest {
  private final String c = new Function0<String>() {
    @Override
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<|>");
      return _builder.toString();
    }
  }.apply();

  @Test
  public void testTypeInJavaDoc_1() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @see java.util.Dat");
    _builder.append(this.c, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {}");
    _builder.newLine();
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
    this.testContentAssistant(_builder, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("java.util.Date")), _builder_1.toString());
  }

  @Test
  public void testTypeInJavaDoc_2() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @see java.lang.StringBuff");
    _builder.append(this.c, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {}");
    _builder.newLine();
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
    this.testContentAssistant(_builder, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("StringBuffer")), _builder_1.toString());
  }

  @Test
  public void testTypeInJavaDoc_3() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* java.lang.StringBuff");
    _builder.append(this.c, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {}");
    _builder.newLine();
    this.testEmptyContentAssistant(_builder);
  }

  @Test
  public void testTypeInJavaDoc_4() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @see    java.lang.StringBuff");
    _builder.append(this.c, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {}");
    _builder.newLine();
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
    this.testContentAssistant(_builder, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("StringBuffer")), _builder_1.toString());
  }

  @Test
  public void testTypeInJavaDoc_5() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link java.lang.StringBuff");
    _builder.append(this.c, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {}");
    _builder.newLine();
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
    this.testContentAssistant(_builder, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("StringBuffer")), _builder_1.toString());
  }

  @Test
  public void testTypeInJavaDoc_6() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link    java.lang.StringBuff");
    _builder.append(this.c, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {}");
    _builder.newLine();
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
    this.testContentAssistant(_builder, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList("StringBuffer")), _builder_1.toString());
  }

  private void testEmptyContentAssistant(final CharSequence it) {
    this.testContentAssistant(it, Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList()), null, null);
  }

  private void testContentAssistant(final CharSequence it, final List<String> expectedProposals, final String expectedContent) {
    this.testContentAssistant(it, expectedProposals, IterableExtensions.<String>head(expectedProposals), expectedContent);
  }

  private void testContentAssistant(final CharSequence text, final List<String> expectedProposals, final String proposalToApply, final String expectedContent) {
    try {
      final int cursorPosition = text.toString().indexOf(this.c);
      if ((cursorPosition == (-1))) {
        Assert.fail((("Can\'t locate cursor position symbols \'" + this.c) + "\' in the input text."));
      }
      final String content = text.toString().replace(this.c, "");
      final ContentAssistProcessorTestBuilder builder = this.newBuilder().append(content).assertTextAtCursorPosition(cursorPosition, ((String[])Conversions.unwrapArray(expectedProposals, String.class)));
      if ((proposalToApply != null)) {
        builder.applyProposal(cursorPosition, proposalToApply).expectContent(expectedContent);
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

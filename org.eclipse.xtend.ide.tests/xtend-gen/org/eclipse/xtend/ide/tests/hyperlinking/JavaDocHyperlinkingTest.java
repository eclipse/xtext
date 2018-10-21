/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.ide.tests.hyperlinking;

import com.google.inject.Inject;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jface.text.hyperlink.IHyperlink;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.ide.tests.AbstractXtendUITestCase;
import org.eclipse.xtend.ide.tests.WorkbenchTestHelper;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.xtext.ui.JdtHyperlink;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function0;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author miklossy - Initial contribution and API
 */
@SuppressWarnings("all")
public class JavaDocHyperlinkingTest extends AbstractXtendUITestCase {
  private final String c = new Function0<String>() {
    public String apply() {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("<|>");
      return _builder.toString();
    }
  }.apply();
  
  @Inject
  @Extension
  private IHyperlinkHelper _iHyperlinkHelper;
  
  @Inject
  @Extension
  private WorkbenchTestHelper _workbenchTestHelper;
  
  @Test
  public void import_statement() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import ");
    _builder.append(this.c);
    _builder.append("java.util.Date");
    _builder.append(this.c);
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Date date");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.containsHyperlinkToJavaDate(_builder);
  }
  
  @Test
  public void member_type() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link java.util.Date}");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(this.c, "\t");
    _builder.append("Date");
    _builder.append(this.c, "\t");
    _builder.append(" date");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    this.containsHyperlinkToJavaDate(_builder);
  }
  
  @Test
  public void multi_line_comment_link() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link ");
    _builder.append(this.c, " ");
    _builder.append("Date");
    _builder.append(this.c, " ");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.containsHyperlinkToJavaDate(_builder);
  }
  
  @Test
  public void multi_line_comment_see() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/*");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @see ");
    _builder.append(this.c, " ");
    _builder.append("Date");
    _builder.append(this.c, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.containsHyperlinkToJavaDate(_builder);
  }
  
  @Test
  public void javadoc_link_no_hyperlink_if_the_type_cannot_be_resolved() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link ");
    _builder.append(this.c, " ");
    _builder.append("Date");
    _builder.append(this.c, " ");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.containsNoHyperlinks(_builder);
  }
  
  @Test
  public void javadoc_see_no_hyperlink_if_the_type_cannot_be_resolved() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @see ");
    _builder.append(this.c, " ");
    _builder.append("Date");
    _builder.append(this.c, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.containsNoHyperlinks(_builder);
  }
  
  @Test
  public void javadoc_link01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link ");
    _builder.append(this.c, " ");
    _builder.append("java.util.Date");
    _builder.append(this.c, " ");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Date date");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.containsHyperlinkToJavaDate(_builder);
  }
  
  @Test
  public void javadoc_link02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link ");
    _builder.append(this.c, " ");
    _builder.append("java.util.Date");
    _builder.append(this.c, " ");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* {@link java.lang.StringBuffer}");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.containsHyperlinkToJavaDate(_builder);
  }
  
  @Test
  public void javadoc_link03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link java.lang.StringBuffer}");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link ");
    _builder.append(this.c, " ");
    _builder.append("java.util.Date");
    _builder.append(this.c, " ");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.containsHyperlinkToJavaDate(_builder);
  }
  
  @Test
  public void javadoc_link04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link ");
    _builder.append(this.c, " ");
    _builder.append("Date");
    _builder.append(this.c, " ");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Date date");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.containsHyperlinkToJavaDate(_builder);
  }
  
  @Test
  public void javadoc_link05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* {@link ");
    _builder.append(this.c, "\t ");
    _builder.append("Date");
    _builder.append(this.c, "\t ");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val a = 1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.containsHyperlinkToJavaDate(_builder);
  }
  
  @Test
  public void javadoc_link06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Date date");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link ");
    _builder.append(this.c, " ");
    _builder.append("Date");
    _builder.append(this.c, " ");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    this.containsHyperlinkToJavaDate(_builder);
  }
  
  @Test
  public void javadoc_link07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* {@link ");
    _builder.append(this.c, " ");
    _builder.append("Date");
    _builder.append(this.c, " ");
    _builder.append("}");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    this.containsHyperlinkToJavaDate(_builder);
  }
  
  @Test
  public void javadoc_see01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @see ");
    _builder.append(this.c, " ");
    _builder.append("java.util.Date");
    _builder.append(this.c, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Date date");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.containsHyperlinkToJavaDate(_builder);
  }
  
  @Test
  public void javadoc_see02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @see ");
    _builder.append(this.c, " ");
    _builder.append("java.util.Date");
    _builder.append(this.c, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("* @see java.lang.StringBuffer");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.containsHyperlinkToJavaDate(_builder);
  }
  
  @Test
  public void javadoc_see03() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @see java.lang.StringBuffer");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @see ");
    _builder.append(this.c, " ");
    _builder.append("java.util.Date");
    _builder.append(this.c, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.containsHyperlinkToJavaDate(_builder);
  }
  
  @Test
  public void javadoc_see04() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @see ");
    _builder.append(this.c, " ");
    _builder.append("Date");
    _builder.append(this.c, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Date date");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.containsHyperlinkToJavaDate(_builder);
  }
  
  @Test
  public void javadoc_see05() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/**");
    _builder.newLine();
    _builder.append("\t ");
    _builder.append("* @see ");
    _builder.append(this.c, "\t ");
    _builder.append("Date");
    _builder.append(this.c, "\t ");
    _builder.newLineIfNotEmpty();
    _builder.append("\t ");
    _builder.append("*/");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("val a = 1");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    this.containsHyperlinkToJavaDate(_builder);
  }
  
  @Test
  public void javadoc_see06() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class A {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("Date date");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @see ");
    _builder.append(this.c, " ");
    _builder.append("Date");
    _builder.append(this.c, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    this.containsHyperlinkToJavaDate(_builder);
  }
  
  @Test
  public void javadoc_see07() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import java.util.Date");
    _builder.newLine();
    _builder.append("/**");
    _builder.newLine();
    _builder.append(" ");
    _builder.append("* @see ");
    _builder.append(this.c, " ");
    _builder.append("Date");
    _builder.append(this.c, " ");
    _builder.newLineIfNotEmpty();
    _builder.append(" ");
    _builder.append("*/");
    _builder.newLine();
    this.containsHyperlinkToJavaDate(_builder);
  }
  
  private void containsNoHyperlinks(final CharSequence it) {
    Assert.assertNull(this.determineHyperlinks(it, (IterableExtensions.<Integer>head(this.getExpectedPositionInformation(it))).intValue()));
  }
  
  private void containsHyperlinkToJavaDate(final CharSequence it) {
    final List<Integer> expected = this.getExpectedPositionInformation(it);
    final Integer expectedOffset = IterableExtensions.<Integer>head(expected);
    final Integer expectedLength = IterableExtensions.<Integer>last(expected);
    final IHyperlink[] hyperlinks = this.determineHyperlinks(it, (expectedOffset).intValue());
    Assert.assertNotNull("No hyperlinks found!", hyperlinks);
    Assert.assertEquals(1, hyperlinks.length);
    final IHyperlink hyperlink = IterableExtensions.<IHyperlink>head(((Iterable<IHyperlink>)Conversions.doWrapArray(hyperlinks)));
    Assert.assertEquals("Date", hyperlink.getHyperlinkText());
    Assert.assertEquals((expectedOffset).intValue(), hyperlink.getHyperlinkRegion().getOffset());
    Assert.assertEquals((expectedLength).intValue(), hyperlink.getHyperlinkRegion().getLength());
    Assert.assertTrue((hyperlink instanceof JdtHyperlink));
    final JdtHyperlink jdtHyperlink = ((JdtHyperlink) hyperlink);
    final IJavaElement javaElement = jdtHyperlink.getJavaElement();
    Assert.assertEquals("Date", javaElement.getElementName());
  }
  
  private List<Integer> getExpectedPositionInformation(final CharSequence input) {
    List<Integer> _xblockexpression = null;
    {
      final String text = input.toString();
      final int first = text.indexOf(this.c);
      if ((first == (-1))) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Can\'t locate first position symbols \'");
        _builder.append(this.c);
        _builder.append("\' in the input text.");
        Assert.fail(_builder.toString());
      }
      final int second = text.lastIndexOf(this.c);
      if ((first == second)) {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("Can\'t locate second position symbols \'");
        _builder_1.append(this.c);
        _builder_1.append("\' in the input text.");
        Assert.fail(_builder_1.toString());
      }
      final int offset = first;
      int _length = this.c.length();
      final int length = ((second - first) - _length);
      _xblockexpression = Collections.<Integer>unmodifiableList(CollectionLiterals.<Integer>newArrayList(Integer.valueOf(offset), Integer.valueOf(length)));
    }
    return _xblockexpression;
  }
  
  private IHyperlink[] determineHyperlinks(final CharSequence text, final int offset) {
    try {
      IHyperlink[] _xblockexpression = null;
      {
        final String content = text.toString().replace(this.c, "");
        final XtendFile xtendFile = this._workbenchTestHelper.xtendFile("Foo", content);
        Resource _eResource = xtendFile.eResource();
        final XtextResource resource = ((XtextResource) _eResource);
        _xblockexpression = this._iHyperlinkHelper.createHyperlinksByOffset(resource, offset, true);
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

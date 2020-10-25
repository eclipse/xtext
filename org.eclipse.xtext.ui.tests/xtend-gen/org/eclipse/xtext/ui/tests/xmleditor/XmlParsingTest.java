/**
 * Copyright (c) 2019, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ui.tests.xmleditor;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.ui.tests.xmleditor.simplexml.XmlDocument;
import org.eclipse.xtext.ui.tests.xmleditor.tests.XmlInjectorProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(XmlInjectorProvider.class)
@SuppressWarnings("all")
public class XmlParsingTest {
  @Inject
  @Extension
  private ParseHelper<XmlDocument> _parseHelper;
  
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void test001() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }
  
  @Test
  public void test002() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a/>");
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }
  
  @Test
  public void test003() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\"\"/>");
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }
  
  @Test
  public void test004() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\"c\"/>");
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }
  
  @Test
  public void test005() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\'c\'/>");
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }
  
  @Test
  public void test006() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\"c\" d=\'e\'/>");
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }
  
  @Test
  public void test007() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\'c\' d=\"e\"/>");
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }
  
  @Test
  public void test008() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a></a>");
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }
  
  @Test
  public void test009() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\"c\"></a>");
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }
  
  @Test
  public void test010() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\'c\'></a>");
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }
  
  @Test
  public void test011() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\'c\' d=\"e\"></a>");
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }
  
  @Test
  public void test012() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\"c\" d=\'e\'></a>");
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }
  
  @Test
  public void test013() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a>text</a>");
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }
  
  @Test
  public void test014() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\"c\">text</a>");
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }
  
  @Test
  public void test015() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<b>text</b>");
    _builder.newLine();
    _builder.append("</a>");
    _builder.newLine();
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }
  
  @Test
  public void test016() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<b/>");
    _builder.newLine();
    _builder.append("</a>");
    _builder.newLine();
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }
  
  @Test
  public void test017() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a b=\"c\">");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<d e=\"f\"/>");
    _builder.newLine();
    _builder.append("</a>");
    _builder.newLine();
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }
  
  @Test
  public void test018() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<b>c</b>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<d>e</d>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<f/>");
    _builder.newLine();
    _builder.append("</a>");
    _builder.newLine();
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }
  
  @Test
  public void test019() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<b>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<c/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<d>e</d>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</b>");
    _builder.newLine();
    _builder.append("</a>");
    _builder.newLine();
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }
  
  @Test
  public void test020() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<b>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<c>d</c>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<d/>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</b>");
    _builder.newLine();
    _builder.append("</a>");
    _builder.newLine();
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }
  
  @Test
  public void test021() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("<a>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("<b>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<c>d</c>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<d e=\'f\'/>");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("<g>h</g>");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("</b>");
    _builder.newLine();
    _builder.append("</a>");
    _builder.newLine();
    this._validationTestHelper.assertNoErrors(this._parseHelper.parse(_builder));
  }
}

/**
 * Copyright (c) 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.inject.Inject;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Eva Poell - Initial contribution and API
 */
@SuppressWarnings("all")
public class ValidationIssue397Test extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  @Inject
  @Extension
  private ParseHelper<XtendFile> _parseHelper;

  @Inject
  private MapBasedPreferenceValues preferences;

  @Inject
  public MapBasedPreferenceValues setPreferences(final IPreferenceValuesProvider.SingletonPreferenceValuesProvider prefProvider) {
    return this.preferences = prefProvider.getPreferenceValues(null);
  }

  @Before
  public void setSeverity() {
    this.preferences.put(IssueCodes.TERNARY_EXPRESSION_NOT_ALLOWED, "error");
  }

  @After
  public void clearPreferences() {
    this.preferences.clear();
  }

  @Test
  public void test_normalIfExp() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def fooMethod(boolean bool) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var c = if(bool) 1 else 2");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return c");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_ternExpSimple1() {
    this.issue("bool? 1 : 2");
  }

  @Test
  public void test_ternExpSimple2() {
    this.issue("(bool)? 1 : 2");
  }

  @Test
  public void test_ternExpSimple3() {
    this.issue("a < b? 1 : 2");
  }

  @Test
  public void test_ternExpNoElse() {
    this.issue("bool? 1");
  }

  @Test
  public void test_ternExpNoElse2() {
    this.issue("!bool? 1");
  }

  @Test
  public void test_ternExpNoElse3() {
    this.issue("a < b? 1");
  }

  @Test
  public void test_ternExpNestedThen() {
    this.issue("bool? if (!bool) 3 else 4 : 2");
  }

  @Test
  public void test_ternExpNestedElse() {
    this.issue("bool? 1 : if(!bool) 5 else 6");
  }

  @Test
  public void test_ternExpNestedBoth() {
    this.issue("bool? if (!bool) 3 else 4 : if(!bool) 5 else 6");
  }

  @Test
  public void test_ternExpNestedInThen1() {
    this.issue("if (bool) (!bool)? 3 : 4 else 2");
  }

  @Test
  public void test_ternExpNestedInThen2() {
    this.issue("if bool a < b? 3 : 4 else 2");
  }

  @Test
  public void test_ternExpNestedInThenBrackets1() {
    this.issue("if (bool) (bool? 1) else 2");
  }

  @Test
  public void test_ternExpNestedInThenBrackets2() {
    this.issue("if (bool) (bool? 3 : 4) else 2");
  }

  @Test
  public void test_ternExpNestedInElse() {
    this.issue("if (bool) 1 else (!bool)? 5 : 6");
  }

  @Test
  public void test_ternExpNestedInElseBrackets() {
    this.issue("if (bool) 1 else ((bool)? 5 : 6)");
  }

  @Test
  public void test_ternExpNestedDoubleTrouble() {
    this.issue("bool? !bool? 5 : 7 : (bool)? 4 : 6");
  }

  @Test
  public void test_ternExpDoubleNestedInThenBrackets() {
    this.issue("if (bool) (bool? if (a < b) 8 else 9 : 4) else 2");
  }

  @Test
  public void test_ternExpSpaces1() {
    this.issue("bool  ?         1   :    2");
  }

  @Test
  public void test_ternExpSpaces2() {
    this.issue("if (bool ) (!bool  )?    3    :   4  else       2");
  }

  private void issue(final CharSequence input) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo  {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var a = 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var a = 2");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def fooMethod(boolean bool) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("var c = ");
      final String start = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("return c");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final String end = _builder_1.toString();
      final String toTest = ((start + input) + end);
      this._validationTestHelper.assertError(this._parseHelper.parse(toTest), XbasePackage.Literals.XIF_EXPRESSION, IssueCodes.TERNARY_EXPRESSION_NOT_ALLOWED, "ternary operator");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

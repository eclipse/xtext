/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.tests.validation;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.MapBasedPreferenceValues;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.tests.AbstractXbaseTestCase;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@SuppressWarnings("all")
public class CodeStyleValidationTest extends AbstractXbaseTestCase {
  @Inject
  @Extension
  private ValidationTestHelper helper;
  
  private MapBasedPreferenceValues preferences;
  
  @Inject
  public MapBasedPreferenceValues setPreferences(final IPreferenceValuesProvider.SingletonPreferenceValuesProvider prefProvider) {
    return this.preferences = prefProvider.getPreferenceValues(null);
  }
  
  @Before
  public void setSeverity() {
    this.preferences.put(IssueCodes.OPERATION_WITHOUT_PARENTHESES, "warning");
  }
  
  @After
  public void clearPreferences() {
    this.preferences.clear();
  }
  
  @Test
  public void testMethodCallWithoutParenthesis01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("val x = \"foo\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("x.length");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      this.helper.assertWarning(this.expression(_builder), XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.OPERATION_WITHOUT_PARENTHESES);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMethodCallWithoutParenthesis02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("val it = \"foo\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("length");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      this.helper.assertWarning(this.expression(_builder), XbasePackage.Literals.XFEATURE_CALL, IssueCodes.OPERATION_WITHOUT_PARENTHESES);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSugaredPropertyAccess01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("val x = \"foo\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("x.bytes");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      this.helper.assertNoIssues(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSugaredPropertyAccess02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("val it = \"foo\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("bytes");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      this.helper.assertNoIssues(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMethodCallWithParenthesis01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("val x = \"foo\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("x.length()");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      this.helper.assertNoIssues(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMethodCallWithParenthesis02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("val it = \"foo\"");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("length()");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      this.helper.assertNoIssues(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMethodCallWithBuilderSyntax01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("val x = #[\"foo\", \"bar\"]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("x.forEach[]");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      this.helper.assertNoIssues(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMethodCallWithBuilderSyntax02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("val it = #[\"foo\", \"bar\"]");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("forEach[]");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      this.helper.assertNoIssues(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConstructorCallWithoutParenthesis() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("new String");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      this.helper.assertWarning(this.expression(_builder), XbasePackage.Literals.XCONSTRUCTOR_CALL, IssueCodes.OPERATION_WITHOUT_PARENTHESES);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConstructorCallWithParenthesis() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("new String()");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      this.helper.assertNoIssues(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testConstructorCallWithBuilderSyntax() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("{");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("new Thread[|]");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      this.helper.assertNoIssues(this.expression(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

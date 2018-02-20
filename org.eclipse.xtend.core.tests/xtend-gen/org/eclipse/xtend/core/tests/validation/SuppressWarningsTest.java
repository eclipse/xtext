/**
 * Copyright (c) 2018 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.inject.Inject;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Test;

/**
 * Test that the SuppressWarnings annotation is considered for raised warnings.
 * @author Karsten Thoms (karsten.thoms@itemis.de) - Initial contribution and API
 */
@SuppressWarnings("all")
public class SuppressWarningsTest extends AbstractXtendTestCase {
  @Inject
  private ValidationTestHelper helper;
  
  @Inject
  private ParseHelper<XtendFile> parser;
  
  @Test
  public void test_MissingAnnotationRaisesWarning() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface IAdaptable {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <T> T getAdapter(Class<T> adapter)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class FooAdapter implements IAdaptable {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override getAdapter(Class adapter) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertWarning(file, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.RAW_TYPE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface IAdaptable {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <T> T getAdapter(Class<T> adapter)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class FooAdapter implements IAdaptable {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override getAdapter(@SuppressWarnings(\"rawtypes\") Class adapter) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertNoIssues(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void test_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface IAdaptable {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <T> T getAdapter(Class<T> adapter)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class FooAdapter implements IAdaptable {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override getAdapter(@SuppressWarnings(\"all\") Class adapter) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertNoIssues(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Test: Place annotation on the method, not direct at the parameter
   */
  @Test
  public void test_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface IAdaptable {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <T> T getAdapter(Class<T> adapter)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class FooAdapter implements IAdaptable {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@SuppressWarnings(\"rawtypes\")");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override getAdapter(Class adapter) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertNoIssues(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Test: Place annotation on the class, not direct at the parameter
   */
  @Test
  public void test_04() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface IAdaptable {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <T> T getAdapter(Class<T> adapter)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("@SuppressWarnings(\"rawtypes\")");
      _builder.newLine();
      _builder.append("class FooAdapter implements IAdaptable {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override getAdapter(Class adapter) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertNoIssues(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Test: Raw variable
   */
  @Test
  public void test_05() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@SuppressWarnings(\"rawtypes\")");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val Class foo = null");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertNoIssues(file, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.RAW_TYPE, Severity.WARNING);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Test: Raw variable, missing annotation raises warning
   */
  @Test
  public void test_06() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val Class foo = null");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertIssue(file, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.RAW_TYPE, Severity.WARNING);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * Test: SuppressWarnings present, but with ignored value
   */
  @Test
  public void test_IgnoredSuppressedWarnings() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface IAdaptable {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <T> T getAdapter(Class<T> adapter)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class FooAdapter implements IAdaptable {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override getAdapter(@SuppressWarnings(\"dummy\") Class adapter) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.parser.parse(_builder);
      this.helper.assertWarning(file, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE, IssueCodes.RAW_TYPE);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

/**
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.inject.Inject;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Test;

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
@SuppressWarnings("all")
public class ValidationBug435020Test extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ValidationTestHelper helper;

  @Inject
  private ParseHelper<XtendFile> parser;

  @Test
  public void test_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Object {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("static val x = 1");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("def void bar() {");
      _builder.newLine();
      _builder.append("\t\t\t\t");
      _builder.append("println(x)");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile c = this.parser.parse(_builder);
      this.helper.assertNoIssues(c);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Object {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("static var x = 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String source = _builder.toString();
      final XtendFile c = this.parser.parse(source);
      this.helper.assertError(c, XtendPackage.Literals.XTEND_FIELD, IssueCodes.ANONYMOUS_CLASS_STATIC_FIELD, 
        source.indexOf("x"), 1, 
        "A static field of an anonymous class must be final");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_03() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Object {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("static val x = Math.max(1, 2)");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String source = _builder.toString();
      final XtendFile c = this.parser.parse(source);
      this.helper.assertError(c, XtendPackage.Literals.XTEND_FIELD, IssueCodes.ANONYMOUS_CLASS_STATIC_FIELD, 
        source.indexOf("Math.max(1, 2)"), "Math.max(1, 2)".length(), 
        "must be initialized with a constant expression");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_04() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Object {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("static def bar() {");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String source = _builder.toString();
      final XtendFile c = this.parser.parse(source);
      this.helper.assertError(c, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.ANONYMOUS_CLASS_STATIC_METHOD, 
        source.indexOf("bar"), "bar".length(), 
        "A method of an anonymous class cannot be static");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

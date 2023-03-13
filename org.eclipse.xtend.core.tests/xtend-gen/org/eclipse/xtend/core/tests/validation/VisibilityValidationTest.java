/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class VisibilityValidationTest extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ParseHelper<XtendFile> _parseHelper;

  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  @Test
  public void test_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo { protected int foo = 1 }");
      _builder.newLine();
      _builder.append("class Bar { public val bar = new Foo().foo }");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void test_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Test {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def assertFooBar() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val bar = new Bar");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("bar.somePublicMethodInFoo");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("bar.someProtectedMethodInBar()");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("(bar as Foo).someProtectedMethodInFoo");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected def someProtectedMethodInFoo() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def somePublicMethodInFoo() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class Bar extends Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("protected def someProtectedMethodInBar() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this._parseHelper.parse(_builder));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

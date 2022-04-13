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
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.validation.IssueCodes;
import org.junit.Test;

/**
 * @author Miro Spoenemann - Initial contribution and API
 */
@SuppressWarnings("all")
public class ValidationBug378818Test extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ValidationTestHelper helper;

  @Test
  public void testAbstractMethodInvocation_01() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("abstract class AbstractTest {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("abstract def void foo()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class Test extends AbstractTest {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super.foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.helper.assertError(this.file(_builder.toString()), XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.ABSTRACT_METHOD_INVOCATION, 
        "Cannot directly invoke the abstract method foo() of the type AbstractTest");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testAbstractMethodInvocation_02() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("abstract class AbstractTest {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("abstract def void foo()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class Test extends AbstractTest {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override foo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("Test.super.foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this.helper.assertError(this.file(_builder.toString()), XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.ABSTRACT_METHOD_INVOCATION, 
        "Cannot directly invoke the abstract method foo() of the type AbstractTest");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

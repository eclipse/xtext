/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
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
      XtendFile _file = this.file(_builder.toString());
      this.helper.assertError(_file, XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.ABSTRACT_METHOD_INVOCATION, 
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
      XtendFile _file = this.file(_builder.toString());
      this.helper.assertError(_file, XbasePackage.Literals.XMEMBER_FEATURE_CALL, IssueCodes.ABSTRACT_METHOD_INVOCATION, 
        "Cannot directly invoke the abstract method foo() of the type AbstractTest");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

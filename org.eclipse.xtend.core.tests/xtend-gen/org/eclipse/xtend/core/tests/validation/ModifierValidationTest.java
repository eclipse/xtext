/**
 * Copyright (c) 2013, 2018 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Test;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class ModifierValidationTest extends AbstractXtendTestCase {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  @Test
  public void testClassAllowedModifiers() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private class Foo{}");
      this._validationTestHelper.assertError(this.clazz(_builder.toString()), XtendPackage.Literals.XTEND_CLASS, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package class Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(_builder_1.toString()));
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected class Foo{}");
      this._validationTestHelper.assertError(this.clazz(_builder_2.toString()), XtendPackage.Literals.XTEND_CLASS, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public class Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(_builder_3.toString()));
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("static class Foo{}");
      this._validationTestHelper.assertError(this.clazz(_builder_4.toString()), XtendPackage.Literals.XTEND_CLASS, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("abstract class Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(_builder_5.toString()));
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("dispatch class Foo{}");
      this._validationTestHelper.assertError(this.clazz(_builder_6.toString()), XtendPackage.Literals.XTEND_CLASS, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("final class Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(_builder_7.toString()));
      StringConcatenation _builder_8 = new StringConcatenation();
      _builder_8.append("public class Foo{}");
      this._validationTestHelper.assertWarning(this.clazz(_builder_8.toString()), XtendPackage.Literals.XTEND_CLASS, IssueCodes.UNNECESSARY_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testNestedClassAllowedModifiers() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private class Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder)), IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package class Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder_1)), IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected class Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder_2)), IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public class Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder_3)), IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("static class Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder_4)), IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("abstract class Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder_5)), IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("dispatch class Foo{}");
      this._validationTestHelper.assertError(this.clazz(this.toNestedType(_builder_6)), XtendPackage.Literals.XTEND_CLASS, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("final class Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder_7)), IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testNestedClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo { class Bar {} }");
      this._validationTestHelper.assertError(this.clazz(_builder.toString()), XtendPackage.Literals.XTEND_CLASS, IssueCodes.MISSING_STATIC_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class Foo { static class Bar {} }");
      this._validationTestHelper.assertNoErrors(this.clazz(_builder_1.toString()));
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("interface Foo { class Bar {} }");
      this._validationTestHelper.assertNoErrors(this.interfaze(_builder_2.toString()));
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("annotation Foo { class Bar {} }");
      this._validationTestHelper.assertNoErrors(this.annotationType(_builder_3.toString()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testInterfaceAllowedModifiers() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private interface Foo{}");
      this._validationTestHelper.assertError(this.interfaze(_builder.toString()), XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package interface Foo{}");
      this._validationTestHelper.assertNoErrors(this.interfaze(_builder_1.toString()));
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected interface Foo{}");
      this._validationTestHelper.assertError(this.interfaze(_builder_2.toString()), XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public interface Foo{}");
      this._validationTestHelper.assertNoErrors(this.interfaze(_builder_3.toString()));
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("static interface Foo{}");
      this._validationTestHelper.assertError(this.interfaze(_builder_4.toString()), XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("abstract interface Foo{}");
      this._validationTestHelper.assertNoErrors(this.interfaze(_builder_5.toString()));
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("dispatch interface Foo{}");
      this._validationTestHelper.assertError(this.interfaze(_builder_6.toString()), XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("final interface Foo{}");
      this._validationTestHelper.assertError(this.interfaze(_builder_7.toString()), XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testNestedInterfaceAllowedModifiers() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private interface Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder)));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package interface Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder_1)));
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected interface Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder_2)));
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public interface Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder_3)));
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("static interface Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder_4)));
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("abstract interface Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder_5)));
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("dispatch interface Foo{}");
      this._validationTestHelper.assertError(this.clazz(this.toNestedType(_builder_6)), XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("final interface Foo{}");
      this._validationTestHelper.assertError(this.clazz(this.toNestedType(_builder_7)), XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testEnumAllowedModifiers() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private enum Foo{}");
      this._validationTestHelper.assertError(this.enumeration(_builder.toString()), XtendPackage.Literals.XTEND_ENUM, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package enum Foo{}");
      this._validationTestHelper.assertNoErrors(this.enumeration(_builder_1.toString()));
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected enum Foo{}");
      this._validationTestHelper.assertError(this.enumeration(_builder_2.toString()), XtendPackage.Literals.XTEND_ENUM, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public enum Foo{}");
      this._validationTestHelper.assertNoErrors(this.enumeration(_builder_3.toString()));
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("static enum Foo{}");
      this._validationTestHelper.assertError(this.enumeration(_builder_4.toString()), XtendPackage.Literals.XTEND_ENUM, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("abstract enum Foo{}");
      this._validationTestHelper.assertError(this.enumeration(_builder_5.toString()), XtendPackage.Literals.XTEND_ENUM, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("dispatch enum Foo{}");
      this._validationTestHelper.assertError(this.enumeration(_builder_6.toString()), XtendPackage.Literals.XTEND_ENUM, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("final enum Foo{}");
      this._validationTestHelper.assertError(this.enumeration(_builder_7.toString()), XtendPackage.Literals.XTEND_ENUM, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testNestedEnumAllowedModifiers() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private enum Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder)));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package enum Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder_1)));
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected enum Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder_2)));
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public enum Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder_3)));
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("static enum Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder_4)));
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("abstract enum Foo{}");
      this._validationTestHelper.assertError(this.clazz(this.toNestedType(_builder_5)), XtendPackage.Literals.XTEND_ENUM, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("dispatch enum Foo{}");
      this._validationTestHelper.assertError(this.clazz(this.toNestedType(_builder_6)), XtendPackage.Literals.XTEND_ENUM, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("final enum Foo{}");
      this._validationTestHelper.assertError(this.clazz(this.toNestedType(_builder_7)), XtendPackage.Literals.XTEND_ENUM, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testAnnotationTypeAllowedModifiers() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private annotation Foo{}");
      this._validationTestHelper.assertError(this.annotationType(_builder.toString()), XtendPackage.Literals.XTEND_ANNOTATION_TYPE, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package annotation Foo{}");
      this._validationTestHelper.assertNoErrors(this.annotationType(_builder_1.toString()));
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected annotation Foo{}");
      this._validationTestHelper.assertError(this.annotationType(_builder_2.toString()), XtendPackage.Literals.XTEND_ANNOTATION_TYPE, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public annotation Foo{}");
      this._validationTestHelper.assertNoErrors(this.annotationType(_builder_3.toString()));
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("static annotation Foo{}");
      this._validationTestHelper.assertError(this.annotationType(_builder_4.toString()), XtendPackage.Literals.XTEND_ANNOTATION_TYPE, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("abstract annotation Foo{}");
      this._validationTestHelper.assertNoErrors(this.annotationType(_builder_5.toString()));
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("dispatch annotation Foo{}");
      this._validationTestHelper.assertError(this.annotationType(_builder_6.toString()), XtendPackage.Literals.XTEND_ANNOTATION_TYPE, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("final annotation Foo{}");
      this._validationTestHelper.assertError(this.annotationType(_builder_7.toString()), XtendPackage.Literals.XTEND_ANNOTATION_TYPE, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testNestedAnnotationTypeAllowedModifiers() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private annotation Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder)));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package annotation Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder_1)));
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected annotation Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder_2)));
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public annotation Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder_3)));
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("static annotation Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder_4)));
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("abstract annotation Foo{}");
      this._validationTestHelper.assertNoErrors(this.clazz(this.toNestedType(_builder_5)));
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("dispatch annotation Foo{}");
      this._validationTestHelper.assertError(this.clazz(this.toNestedType(_builder_6)), XtendPackage.Literals.XTEND_ANNOTATION_TYPE, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("final annotation Foo{}");
      this._validationTestHelper.assertError(this.clazz(this.toNestedType(_builder_7)), XtendPackage.Literals.XTEND_ANNOTATION_TYPE, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testMethodAllowedModifiers() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private def foo() {}");
      this._validationTestHelper.assertNoErrors(this.function(_builder.toString()));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package def foo() {}");
      this._validationTestHelper.assertNoErrors(this.function(_builder_1.toString()));
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected def foo() {}");
      this._validationTestHelper.assertNoErrors(this.function(_builder_2.toString()));
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public def foo() {}");
      this._validationTestHelper.assertNoErrors(this.function(_builder_3.toString()));
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("static def foo() {}");
      this._validationTestHelper.assertNoErrors(this.function(_builder_4.toString()));
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("abstract def foo()");
      this._validationTestHelper.assertNoError(this.function(_builder_5.toString()), IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("private def int foo();");
      this._validationTestHelper.assertError(this.abstractFunction(_builder_6.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("final def int foo();");
      this._validationTestHelper.assertError(this.abstractFunction(_builder_7.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_8 = new StringConcatenation();
      _builder_8.append("static def int foo();");
      this._validationTestHelper.assertError(this.abstractFunction(_builder_8.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_9 = new StringConcatenation();
      _builder_9.append("dispatch def foo (int i){}");
      this._validationTestHelper.assertNoErrors(this.function(_builder_9.toString()));
      StringConcatenation _builder_10 = new StringConcatenation();
      _builder_10.append("final def foo() {}");
      this._validationTestHelper.assertNoErrors(this.function(_builder_10.toString()));
      StringConcatenation _builder_11 = new StringConcatenation();
      _builder_11.append("public def foo() {}");
      this._validationTestHelper.assertWarning(this.function(_builder_11.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.UNNECESSARY_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testMethodInInterfaceAllowedModifiers() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private def foo() {}");
    this._validationTestHelper.assertError(this.memberInInterface(_builder.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package def foo() {}");
    this._validationTestHelper.assertError(this.memberInInterface(_builder_1.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("protected def foo() {}");
    this._validationTestHelper.assertError(this.memberInInterface(_builder_2.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("public def foo() {}");
    this._validationTestHelper.assertNoError(this.memberInInterface(_builder_3.toString()), IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("override def foo() {}");
    this._validationTestHelper.assertNoError(this.memberInInterface(_builder_4.toString()), IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append("static def foo() {}");
    this._validationTestHelper.assertError(this.memberInInterface(_builder_5.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_6 = new StringConcatenation();
    _builder_6.append("abstract def int foo()");
    this._validationTestHelper.assertNoErrors(this.memberInInterface(_builder_6.toString()));
    StringConcatenation _builder_7 = new StringConcatenation();
    _builder_7.append("dispatch def foo (int i){}");
    this._validationTestHelper.assertError(this.memberInInterface(_builder_7.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_8 = new StringConcatenation();
    _builder_8.append("final def foo() {}");
    this._validationTestHelper.assertError(this.memberInInterface(_builder_8.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_9 = new StringConcatenation();
    _builder_9.append("strictfp def foo() {}");
    this._validationTestHelper.assertError(this.memberInInterface(_builder_9.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_10 = new StringConcatenation();
    _builder_10.append("synchronized def foo() {}");
    this._validationTestHelper.assertError(this.memberInInterface(_builder_10.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_11 = new StringConcatenation();
    _builder_11.append("override def foo() {}");
    this._validationTestHelper.assertWarning(this.memberInInterface(_builder_11.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.UNNECESSARY_MODIFIER);
    StringConcatenation _builder_12 = new StringConcatenation();
    _builder_12.append("def override foo() {}");
    this._validationTestHelper.assertWarning(this.memberInInterface(_builder_12.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.UNNECESSARY_MODIFIER);
  }

  @Test
  public void testConstructorAllowedModifiers() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private new() {}");
      this._validationTestHelper.assertNoErrors(this.constructor(_builder.toString()));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package new() {}");
      this._validationTestHelper.assertNoErrors(this.constructor(_builder_1.toString()));
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected new() {}");
      this._validationTestHelper.assertNoErrors(this.constructor(_builder_2.toString()));
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public new() {}");
      this._validationTestHelper.assertNoErrors(this.constructor(_builder_3.toString()));
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("static new() {}");
      this._validationTestHelper.assertError(this.constructor(_builder_4.toString()), XtendPackage.Literals.XTEND_CONSTRUCTOR, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("abstract new() {}");
      this._validationTestHelper.assertError(this.constructor(_builder_5.toString()), XtendPackage.Literals.XTEND_CONSTRUCTOR, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("dispatch new (){}");
      this._validationTestHelper.assertError(this.constructor(_builder_6.toString()), XtendPackage.Literals.XTEND_CONSTRUCTOR, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("final new() {}");
      this._validationTestHelper.assertError(this.constructor(_builder_7.toString()), XtendPackage.Literals.XTEND_CONSTRUCTOR, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_8 = new StringConcatenation();
      _builder_8.append("strictfp new() {}");
      this._validationTestHelper.assertError(this.constructor(_builder_8.toString()), XtendPackage.Literals.XTEND_CONSTRUCTOR, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_9 = new StringConcatenation();
      _builder_9.append("synchronized new() {}");
      this._validationTestHelper.assertError(this.constructor(_builder_9.toString()), XtendPackage.Literals.XTEND_CONSTRUCTOR, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFieldAllowedModifiers() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private int foo");
      this._validationTestHelper.assertNoErrors(this.field(_builder.toString()));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package int foo");
      this._validationTestHelper.assertNoErrors(this.field(_builder_1.toString()));
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected int foo");
      this._validationTestHelper.assertNoErrors(this.field(_builder_2.toString()));
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public int foo");
      this._validationTestHelper.assertNoErrors(this.field(_builder_3.toString()));
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("static int foo");
      this._validationTestHelper.assertNoErrors(this.field(_builder_4.toString()));
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("abstract int foo");
      this._validationTestHelper.assertError(this.field(_builder_5.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("dispatch int foo");
      this._validationTestHelper.assertError(this.field(_builder_6.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("final int foo = 42");
      this._validationTestHelper.assertNoErrors(this.field(_builder_7.toString()));
      StringConcatenation _builder_8 = new StringConcatenation();
      _builder_8.append("extension Integer foo");
      this._validationTestHelper.assertNoErrors(this.field(_builder_8.toString()));
      StringConcatenation _builder_9 = new StringConcatenation();
      _builder_9.append("final volatile int foo = 42");
      this._validationTestHelper.assertError(this.field(_builder_9.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_10 = new StringConcatenation();
      _builder_10.append("volatile transient int foo");
      this._validationTestHelper.assertNoErrors(this.field(_builder_10.toString()));
      StringConcatenation _builder_11 = new StringConcatenation();
      _builder_11.append("private transient volatile int foo");
      this._validationTestHelper.assertNoErrors(this.field(_builder_11.toString()));
      StringConcatenation _builder_12 = new StringConcatenation();
      _builder_12.append("private int foo");
      this._validationTestHelper.assertWarning(this.field(_builder_12.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.UNNECESSARY_MODIFIER, "The private modifier is unnecessary on field foo");
      StringConcatenation _builder_13 = new StringConcatenation();
      _builder_13.append("private val foo=42");
      this._validationTestHelper.assertWarning(this.field(_builder_13.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.UNNECESSARY_MODIFIER, "The private modifier is unnecessary on field foo");
      StringConcatenation _builder_14 = new StringConcatenation();
      _builder_14.append("private extension Object");
      this._validationTestHelper.assertWarning(this.field(_builder_14.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.UNNECESSARY_MODIFIER, "The private modifier is unnecessary on extension field Object");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFieldInInterfaceAllowedModifiers() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private int foo");
    this._validationTestHelper.assertError(this.memberInInterface(_builder.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package int foo");
    this._validationTestHelper.assertError(this.memberInInterface(_builder_1.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("protected int foo");
    this._validationTestHelper.assertError(this.memberInInterface(_builder_2.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("public int foo = 42");
    this._validationTestHelper.assertNoErrors(this.memberInInterface(_builder_3.toString()));
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("static int foo = 42");
    this._validationTestHelper.assertNoErrors(this.memberInInterface(_builder_4.toString()));
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append("abstract int foo");
    this._validationTestHelper.assertError(this.memberInInterface(_builder_5.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_6 = new StringConcatenation();
    _builder_6.append("dispatch int foo");
    this._validationTestHelper.assertError(this.memberInInterface(_builder_6.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_7 = new StringConcatenation();
    _builder_7.append("final int foo = 42");
    this._validationTestHelper.assertNoErrors(this.memberInInterface(_builder_7.toString()));
    StringConcatenation _builder_8 = new StringConcatenation();
    _builder_8.append("extension int foo");
    this._validationTestHelper.assertError(this.memberInInterface(_builder_8.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_9 = new StringConcatenation();
    _builder_9.append("transient int foo");
    this._validationTestHelper.assertError(this.memberInInterface(_builder_9.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_10 = new StringConcatenation();
    _builder_10.append("volatile int foo");
    this._validationTestHelper.assertError(this.memberInInterface(_builder_10.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_11 = new StringConcatenation();
    _builder_11.append("strictfp int foo");
    this._validationTestHelper.assertError(this.memberInInterface(_builder_11.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_12 = new StringConcatenation();
    _builder_12.append("synchronized int foo");
    this._validationTestHelper.assertError(this.memberInInterface(_builder_12.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
  }

  @Test
  public void testFieldInAnnotationAllowedModifiers() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private int foo");
    this._validationTestHelper.assertError(this.memberInAnnotation(_builder.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package int foo");
    this._validationTestHelper.assertError(this.memberInAnnotation(_builder_1.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("protected int foo");
    this._validationTestHelper.assertError(this.memberInAnnotation(_builder_2.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("public int foo");
    this._validationTestHelper.assertNoErrors(this.memberInAnnotation(_builder_3.toString()));
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("static int foo");
    this._validationTestHelper.assertNoErrors(this.memberInAnnotation(_builder_4.toString()));
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append("abstract int foo");
    this._validationTestHelper.assertError(this.memberInAnnotation(_builder_5.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_6 = new StringConcatenation();
    _builder_6.append("dispatch int foo");
    this._validationTestHelper.assertError(this.memberInAnnotation(_builder_6.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_7 = new StringConcatenation();
    _builder_7.append("final int foo = 42");
    this._validationTestHelper.assertNoErrors(this.memberInAnnotation(_builder_7.toString()));
    StringConcatenation _builder_8 = new StringConcatenation();
    _builder_8.append("transient int foo");
    this._validationTestHelper.assertError(this.memberInAnnotation(_builder_8.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_9 = new StringConcatenation();
    _builder_9.append("volatile int foo");
    this._validationTestHelper.assertError(this.memberInAnnotation(_builder_9.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_10 = new StringConcatenation();
    _builder_10.append("strictfp int foo");
    this._validationTestHelper.assertError(this.memberInAnnotation(_builder_10.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_11 = new StringConcatenation();
    _builder_11.append("synchronized int foo");
    this._validationTestHelper.assertError(this.memberInAnnotation(_builder_11.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
  }

  @Test
  public void testDuplicateModifier() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private private def foo() {}");
      this._validationTestHelper.assertError(this.function(_builder.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package package def foo() {}");
      this._validationTestHelper.assertError(this.function(_builder_1.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected protected def foo() {}");
      this._validationTestHelper.assertError(this.function(_builder_2.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public public def foo() {}");
      this._validationTestHelper.assertError(this.function(_builder_3.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("static static def foo() {}");
      this._validationTestHelper.assertError(this.function(_builder_4.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("abstract abstract def foo() {}");
      this._validationTestHelper.assertError(this.function(_builder_5.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("dispatch dispatch def foo (int i){}");
      this._validationTestHelper.assertError(this.function(_builder_6.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("final final def foo() {}");
      this._validationTestHelper.assertError(this.function(_builder_7.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_8 = new StringConcatenation();
      _builder_8.append("strictfp strictfp def foo() {}");
      this._validationTestHelper.assertError(this.function(_builder_8.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_9 = new StringConcatenation();
      _builder_9.append("synchronized synchronized def foo() {}");
      this._validationTestHelper.assertError(this.function(_builder_9.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testDuplicateVisibility() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private package def foo() {}");
      this._validationTestHelper.assertError(this.function(_builder.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package protected def foo() {}");
      this._validationTestHelper.assertError(this.function(_builder_1.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected public def foo() {}");
      this._validationTestHelper.assertError(this.function(_builder_2.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public private def foo() {}");
      this._validationTestHelper.assertError(this.function(_builder_3.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testStaticVsAbstract() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("abstract static int foo=42");
      this._validationTestHelper.assertError(this.field(_builder.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("static abstract int foo=42");
      this._validationTestHelper.assertError(this.field(_builder_1.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFinalVsAbstract() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("abstract final def foo() ");
      this._validationTestHelper.assertError(this.function(_builder.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final abstract def foo() ");
      this._validationTestHelper.assertError(this.function(_builder_1.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testAbstractVsNoBody() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("abstract def foo() {}");
      this._validationTestHelper.assertError(this.function(_builder.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("abstract def foo()");
      this._validationTestHelper.assertNoError(this.function(_builder_1.toString()), IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testNativeVsNoBody() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("native def foo() {}");
      this._validationTestHelper.assertError(this.function(_builder.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("native def foo()");
      this._validationTestHelper.assertNoError(this.function(_builder_1.toString()), IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testStaticVsNative() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("native static int foo=42");
      this._validationTestHelper.assertError(this.field(_builder.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("static native int foo=42");
      this._validationTestHelper.assertError(this.field(_builder_1.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFinalVsNative() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("native final def int foo() ");
      this._validationTestHelper.assertNoErrors(this.function(_builder.toString()));
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final native def int foo() ");
      this._validationTestHelper.assertNoErrors(this.function(_builder_1.toString()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFinalVsNoBody() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("final def foo()");
      this._validationTestHelper.assertError(this.function(_builder.toString()), XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final def foo() {}");
      this._validationTestHelper.assertNoErrors(this.function(_builder_1.toString()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFinalValVsVar() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("final var int i=42");
      this._validationTestHelper.assertError(this.field(_builder.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("var final int i=42");
      this._validationTestHelper.assertError(this.field(_builder_1.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("final val int i=42");
      this._validationTestHelper.assertNoErrors(this.field(_builder_2.toString()));
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("val final int i=42");
      this._validationTestHelper.assertNoErrors(this.field(_builder_3.toString()));
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("final val int i=42");
      this._validationTestHelper.assertWarning(this.field(_builder_4.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.UNNECESSARY_MODIFIER);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("val final int i=42");
      this._validationTestHelper.assertWarning(this.field(_builder_5.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.UNNECESSARY_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected XtendMember memberInInterface(final String model) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Foo { ");
      _builder.append(model);
      _builder.append(" }");
      return this.interfaze(_builder.toString()).getMembers().get(0);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  protected XtendMember memberInAnnotation(final String model) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotation Foo { ");
      _builder.append(model);
      _builder.append(" }");
      return this.annotationType(_builder.toString()).getMembers().get(0);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  private String toNestedType(final CharSequence input) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append(input, "\t");
    _builder.newLineIfNotEmpty();
    _builder.append("}");
    _builder.newLine();
    return _builder.toString();
  }
}

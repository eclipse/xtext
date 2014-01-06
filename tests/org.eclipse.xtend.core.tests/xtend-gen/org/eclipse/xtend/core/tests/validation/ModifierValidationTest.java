/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.validation;

import com.google.inject.Inject;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendConstructor;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendFunction;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
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
      XtendClass _clazz = this.clazz(_builder.toString());
      this._validationTestHelper.assertError(_clazz, XtendPackage.Literals.XTEND_CLASS, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package class Foo{}");
      XtendClass _clazz_1 = this.clazz(_builder_1.toString());
      this._validationTestHelper.assertNoErrors(_clazz_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected class Foo{}");
      XtendClass _clazz_2 = this.clazz(_builder_2.toString());
      this._validationTestHelper.assertError(_clazz_2, XtendPackage.Literals.XTEND_CLASS, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public class Foo{}");
      XtendClass _clazz_3 = this.clazz(_builder_3.toString());
      this._validationTestHelper.assertNoErrors(_clazz_3);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("static class Foo{}");
      XtendClass _clazz_4 = this.clazz(_builder_4.toString());
      this._validationTestHelper.assertNoErrors(_clazz_4);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("abstract class Foo{}");
      XtendClass _clazz_5 = this.clazz(_builder_5.toString());
      this._validationTestHelper.assertNoErrors(_clazz_5);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("dispatch class Foo{}");
      XtendClass _clazz_6 = this.clazz(_builder_6.toString());
      this._validationTestHelper.assertError(_clazz_6, XtendPackage.Literals.XTEND_CLASS, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("final class Foo{}");
      XtendClass _clazz_7 = this.clazz(_builder_7.toString());
      this._validationTestHelper.assertNoErrors(_clazz_7);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInterfaceAllowedModifiers() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private interface Foo{}");
      XtendInterface _interfaze = this.interfaze(_builder.toString());
      this._validationTestHelper.assertError(_interfaze, XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package interface Foo{}");
      XtendInterface _interfaze_1 = this.interfaze(_builder_1.toString());
      this._validationTestHelper.assertNoErrors(_interfaze_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected interface Foo{}");
      XtendInterface _interfaze_2 = this.interfaze(_builder_2.toString());
      this._validationTestHelper.assertError(_interfaze_2, XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public interface Foo{}");
      XtendInterface _interfaze_3 = this.interfaze(_builder_3.toString());
      this._validationTestHelper.assertNoErrors(_interfaze_3);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("static interface Foo{}");
      XtendInterface _interfaze_4 = this.interfaze(_builder_4.toString());
      this._validationTestHelper.assertError(_interfaze_4, XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("abstract interface Foo{}");
      XtendInterface _interfaze_5 = this.interfaze(_builder_5.toString());
      this._validationTestHelper.assertNoErrors(_interfaze_5);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("dispatch interface Foo{}");
      XtendInterface _interfaze_6 = this.interfaze(_builder_6.toString());
      this._validationTestHelper.assertError(_interfaze_6, XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("final interface Foo{}");
      XtendInterface _interfaze_7 = this.interfaze(_builder_7.toString());
      this._validationTestHelper.assertError(_interfaze_7, XtendPackage.Literals.XTEND_INTERFACE, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnumAllowedModifiers() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private enum Foo{}");
      XtendEnum _enumeration = this.enumeration(_builder.toString());
      this._validationTestHelper.assertError(_enumeration, XtendPackage.Literals.XTEND_ENUM, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package enum Foo{}");
      XtendEnum _enumeration_1 = this.enumeration(_builder_1.toString());
      this._validationTestHelper.assertNoErrors(_enumeration_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected enum Foo{}");
      XtendEnum _enumeration_2 = this.enumeration(_builder_2.toString());
      this._validationTestHelper.assertError(_enumeration_2, XtendPackage.Literals.XTEND_ENUM, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public enum Foo{}");
      XtendEnum _enumeration_3 = this.enumeration(_builder_3.toString());
      this._validationTestHelper.assertNoErrors(_enumeration_3);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("static enum Foo{}");
      XtendEnum _enumeration_4 = this.enumeration(_builder_4.toString());
      this._validationTestHelper.assertError(_enumeration_4, XtendPackage.Literals.XTEND_ENUM, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("abstract enum Foo{}");
      XtendEnum _enumeration_5 = this.enumeration(_builder_5.toString());
      this._validationTestHelper.assertError(_enumeration_5, XtendPackage.Literals.XTEND_ENUM, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("dispatch enum Foo{}");
      XtendEnum _enumeration_6 = this.enumeration(_builder_6.toString());
      this._validationTestHelper.assertError(_enumeration_6, XtendPackage.Literals.XTEND_ENUM, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("final enum Foo{}");
      XtendEnum _enumeration_7 = this.enumeration(_builder_7.toString());
      this._validationTestHelper.assertError(_enumeration_7, XtendPackage.Literals.XTEND_ENUM, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAnnotationTypeAllowedModifiers() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private annotation Foo{}");
      XtendAnnotationType _annotationType = this.annotationType(_builder.toString());
      this._validationTestHelper.assertError(_annotationType, XtendPackage.Literals.XTEND_ANNOTATION_TYPE, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package annotation Foo{}");
      XtendAnnotationType _annotationType_1 = this.annotationType(_builder_1.toString());
      this._validationTestHelper.assertNoErrors(_annotationType_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected annotation Foo{}");
      XtendAnnotationType _annotationType_2 = this.annotationType(_builder_2.toString());
      this._validationTestHelper.assertError(_annotationType_2, XtendPackage.Literals.XTEND_ANNOTATION_TYPE, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public annotation Foo{}");
      XtendAnnotationType _annotationType_3 = this.annotationType(_builder_3.toString());
      this._validationTestHelper.assertNoErrors(_annotationType_3);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("static annotation Foo{}");
      XtendAnnotationType _annotationType_4 = this.annotationType(_builder_4.toString());
      this._validationTestHelper.assertError(_annotationType_4, XtendPackage.Literals.XTEND_ANNOTATION_TYPE, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("abstract annotation Foo{}");
      XtendAnnotationType _annotationType_5 = this.annotationType(_builder_5.toString());
      this._validationTestHelper.assertNoErrors(_annotationType_5);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("dispatch annotation Foo{}");
      XtendAnnotationType _annotationType_6 = this.annotationType(_builder_6.toString());
      this._validationTestHelper.assertError(_annotationType_6, XtendPackage.Literals.XTEND_ANNOTATION_TYPE, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("final annotation Foo{}");
      XtendAnnotationType _annotationType_7 = this.annotationType(_builder_7.toString());
      this._validationTestHelper.assertError(_annotationType_7, XtendPackage.Literals.XTEND_ANNOTATION_TYPE, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMethodAllowedModifiers() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private def foo() {}");
      XtendFunction _function = this.function(_builder.toString());
      this._validationTestHelper.assertNoErrors(_function);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package def foo() {}");
      XtendFunction _function_1 = this.function(_builder_1.toString());
      this._validationTestHelper.assertNoErrors(_function_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected def foo() {}");
      XtendFunction _function_2 = this.function(_builder_2.toString());
      this._validationTestHelper.assertNoErrors(_function_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public def foo() {}");
      XtendFunction _function_3 = this.function(_builder_3.toString());
      this._validationTestHelper.assertNoErrors(_function_3);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("static def foo() {}");
      XtendFunction _function_4 = this.function(_builder_4.toString());
      this._validationTestHelper.assertNoErrors(_function_4);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("abstract def foo()");
      XtendFunction _function_5 = this.function(_builder_5.toString());
      this._validationTestHelper.assertNoError(_function_5, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("dispatch def foo (int i){}");
      XtendFunction _function_6 = this.function(_builder_6.toString());
      this._validationTestHelper.assertNoErrors(_function_6);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("final def foo() {}");
      XtendFunction _function_7 = this.function(_builder_7.toString());
      this._validationTestHelper.assertNoErrors(_function_7);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testMethodInInterfaceAllowedModifiers() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private def foo() {}");
    XtendMember _memberInInterface = this.memberInInterface(_builder.toString());
    this._validationTestHelper.assertError(_memberInInterface, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package def foo() {}");
    XtendMember _memberInInterface_1 = this.memberInInterface(_builder_1.toString());
    this._validationTestHelper.assertError(_memberInInterface_1, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("protected def foo() {}");
    XtendMember _memberInInterface_2 = this.memberInInterface(_builder_2.toString());
    this._validationTestHelper.assertError(_memberInInterface_2, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("public def foo() {}");
    XtendMember _memberInInterface_3 = this.memberInInterface(_builder_3.toString());
    this._validationTestHelper.assertNoError(_memberInInterface_3, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("override def foo() {}");
    XtendMember _memberInInterface_4 = this.memberInInterface(_builder_4.toString());
    this._validationTestHelper.assertNoError(_memberInInterface_4, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append("static def foo() {}");
    XtendMember _memberInInterface_5 = this.memberInInterface(_builder_5.toString());
    this._validationTestHelper.assertError(_memberInInterface_5, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_6 = new StringConcatenation();
    _builder_6.append("abstract def int foo()");
    XtendMember _memberInInterface_6 = this.memberInInterface(_builder_6.toString());
    this._validationTestHelper.assertNoErrors(_memberInInterface_6);
    StringConcatenation _builder_7 = new StringConcatenation();
    _builder_7.append("dispatch def foo (int i){}");
    XtendMember _memberInInterface_7 = this.memberInInterface(_builder_7.toString());
    this._validationTestHelper.assertError(_memberInInterface_7, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_8 = new StringConcatenation();
    _builder_8.append("final def foo() {}");
    XtendMember _memberInInterface_8 = this.memberInInterface(_builder_8.toString());
    this._validationTestHelper.assertError(_memberInInterface_8, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
  }
  
  @Test
  public void testConstructorAllowedModifiers() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private new() {}");
      XtendConstructor _constructor = this.constructor(_builder.toString());
      this._validationTestHelper.assertNoErrors(_constructor);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package new() {}");
      XtendConstructor _constructor_1 = this.constructor(_builder_1.toString());
      this._validationTestHelper.assertNoErrors(_constructor_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected new() {}");
      XtendConstructor _constructor_2 = this.constructor(_builder_2.toString());
      this._validationTestHelper.assertNoErrors(_constructor_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public new() {}");
      XtendConstructor _constructor_3 = this.constructor(_builder_3.toString());
      this._validationTestHelper.assertNoErrors(_constructor_3);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("static new() {}");
      XtendConstructor _constructor_4 = this.constructor(_builder_4.toString());
      this._validationTestHelper.assertError(_constructor_4, XtendPackage.Literals.XTEND_CONSTRUCTOR, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("abstract new() {}");
      XtendConstructor _constructor_5 = this.constructor(_builder_5.toString());
      this._validationTestHelper.assertError(_constructor_5, XtendPackage.Literals.XTEND_CONSTRUCTOR, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("dispatch new (){}");
      XtendConstructor _constructor_6 = this.constructor(_builder_6.toString());
      this._validationTestHelper.assertError(_constructor_6, XtendPackage.Literals.XTEND_CONSTRUCTOR, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("final new() {}");
      XtendConstructor _constructor_7 = this.constructor(_builder_7.toString());
      this._validationTestHelper.assertError(_constructor_7, XtendPackage.Literals.XTEND_CONSTRUCTOR, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFieldAllowedModifiers() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private int foo");
      XtendField _field = this.field(_builder.toString());
      this._validationTestHelper.assertNoErrors(_field);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package int foo");
      XtendField _field_1 = this.field(_builder_1.toString());
      this._validationTestHelper.assertNoErrors(_field_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected int foo");
      XtendField _field_2 = this.field(_builder_2.toString());
      this._validationTestHelper.assertNoErrors(_field_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public int foo");
      XtendField _field_3 = this.field(_builder_3.toString());
      this._validationTestHelper.assertNoErrors(_field_3);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("static int foo");
      XtendField _field_4 = this.field(_builder_4.toString());
      this._validationTestHelper.assertNoErrors(_field_4);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("abstract int foo");
      XtendField _field_5 = this.field(_builder_5.toString());
      this._validationTestHelper.assertError(_field_5, XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("dispatch int foo");
      XtendField _field_6 = this.field(_builder_6.toString());
      this._validationTestHelper.assertError(_field_6, XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("final int foo = 42");
      XtendField _field_7 = this.field(_builder_7.toString());
      this._validationTestHelper.assertNoErrors(_field_7);
      StringConcatenation _builder_8 = new StringConcatenation();
      _builder_8.append("extension Integer foo");
      XtendField _field_8 = this.field(_builder_8.toString());
      this._validationTestHelper.assertNoErrors(_field_8);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFieldInInterfaceAllowedModifiers() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private int foo");
    XtendMember _memberInInterface = this.memberInInterface(_builder.toString());
    this._validationTestHelper.assertError(_memberInInterface, XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package int foo");
    XtendMember _memberInInterface_1 = this.memberInInterface(_builder_1.toString());
    this._validationTestHelper.assertError(_memberInInterface_1, XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("protected int foo");
    XtendMember _memberInInterface_2 = this.memberInInterface(_builder_2.toString());
    this._validationTestHelper.assertError(_memberInInterface_2, XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("public int foo = 42");
    XtendMember _memberInInterface_3 = this.memberInInterface(_builder_3.toString());
    this._validationTestHelper.assertNoErrors(_memberInInterface_3);
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("static int foo = 42");
    XtendMember _memberInInterface_4 = this.memberInInterface(_builder_4.toString());
    this._validationTestHelper.assertNoErrors(_memberInInterface_4);
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append("abstract int foo");
    XtendMember _memberInInterface_5 = this.memberInInterface(_builder_5.toString());
    this._validationTestHelper.assertError(_memberInInterface_5, XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_6 = new StringConcatenation();
    _builder_6.append("dispatch int foo");
    XtendMember _memberInInterface_6 = this.memberInInterface(_builder_6.toString());
    this._validationTestHelper.assertError(_memberInInterface_6, XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_7 = new StringConcatenation();
    _builder_7.append("final int foo = 42");
    XtendMember _memberInInterface_7 = this.memberInInterface(_builder_7.toString());
    this._validationTestHelper.assertNoErrors(_memberInInterface_7);
    StringConcatenation _builder_8 = new StringConcatenation();
    _builder_8.append("extension int foo");
    XtendMember _memberInInterface_8 = this.memberInInterface(_builder_8.toString());
    this._validationTestHelper.assertError(_memberInInterface_8, XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
  }
  
  @Test
  public void testFieldInAnnotationAllowedModifiers() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("private int foo");
    XtendMember _memberInAnnotation = this.memberInAnnotation(_builder.toString());
    this._validationTestHelper.assertError(_memberInAnnotation, XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package int foo");
    XtendMember _memberInAnnotation_1 = this.memberInAnnotation(_builder_1.toString());
    this._validationTestHelper.assertError(_memberInAnnotation_1, XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_2 = new StringConcatenation();
    _builder_2.append("protected int foo");
    XtendMember _memberInAnnotation_2 = this.memberInAnnotation(_builder_2.toString());
    this._validationTestHelper.assertError(_memberInAnnotation_2, XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_3 = new StringConcatenation();
    _builder_3.append("public int foo");
    XtendMember _memberInAnnotation_3 = this.memberInAnnotation(_builder_3.toString());
    this._validationTestHelper.assertNoErrors(_memberInAnnotation_3);
    StringConcatenation _builder_4 = new StringConcatenation();
    _builder_4.append("static int foo");
    XtendMember _memberInAnnotation_4 = this.memberInAnnotation(_builder_4.toString());
    this._validationTestHelper.assertNoErrors(_memberInAnnotation_4);
    StringConcatenation _builder_5 = new StringConcatenation();
    _builder_5.append("abstract int foo");
    XtendMember _memberInAnnotation_5 = this.memberInAnnotation(_builder_5.toString());
    this._validationTestHelper.assertError(_memberInAnnotation_5, XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_6 = new StringConcatenation();
    _builder_6.append("dispatch int foo");
    XtendMember _memberInAnnotation_6 = this.memberInAnnotation(_builder_6.toString());
    this._validationTestHelper.assertError(_memberInAnnotation_6, XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    StringConcatenation _builder_7 = new StringConcatenation();
    _builder_7.append("final int foo = 42");
    XtendMember _memberInAnnotation_7 = this.memberInAnnotation(_builder_7.toString());
    this._validationTestHelper.assertNoErrors(_memberInAnnotation_7);
  }
  
  @Test
  public void testDuplicateModifier() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private private def foo() {}");
      XtendFunction _function = this.function(_builder.toString());
      this._validationTestHelper.assertError(_function, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package package def foo() {}");
      XtendFunction _function_1 = this.function(_builder_1.toString());
      this._validationTestHelper.assertError(_function_1, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected protected def foo() {}");
      XtendFunction _function_2 = this.function(_builder_2.toString());
      this._validationTestHelper.assertError(_function_2, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public public def foo() {}");
      XtendFunction _function_3 = this.function(_builder_3.toString());
      this._validationTestHelper.assertError(_function_3, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("static static def foo() {}");
      XtendFunction _function_4 = this.function(_builder_4.toString());
      this._validationTestHelper.assertError(_function_4, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("abstract abstract def foo() {}");
      XtendFunction _function_5 = this.function(_builder_5.toString());
      this._validationTestHelper.assertError(_function_5, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("dispatch dispatch def foo (int i){}");
      XtendFunction _function_6 = this.function(_builder_6.toString());
      this._validationTestHelper.assertError(_function_6, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_7 = new StringConcatenation();
      _builder_7.append("final final def foo() {}");
      XtendFunction _function_7 = this.function(_builder_7.toString());
      this._validationTestHelper.assertError(_function_7, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateVisibility() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("private package def foo() {}");
      XtendFunction _function = this.function(_builder.toString());
      this._validationTestHelper.assertError(_function, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package protected def foo() {}");
      XtendFunction _function_1 = this.function(_builder_1.toString());
      this._validationTestHelper.assertError(_function_1, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected public def foo() {}");
      XtendFunction _function_2 = this.function(_builder_2.toString());
      this._validationTestHelper.assertError(_function_2, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("public private def foo() {}");
      XtendFunction _function_3 = this.function(_builder_3.toString());
      this._validationTestHelper.assertError(_function_3, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testStaticVsAbstract() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("abstract static int foo=42");
      XtendField _field = this.field(_builder.toString());
      this._validationTestHelper.assertError(_field, XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("static abstract int foo=42");
      XtendField _field_1 = this.field(_builder_1.toString());
      this._validationTestHelper.assertError(_field_1, XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFinalVsAbstract() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("abstract final def foo() ");
      XtendFunction _function = this.function(_builder.toString());
      this._validationTestHelper.assertError(_function, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final abstract def foo() ");
      XtendFunction _function_1 = this.function(_builder_1.toString());
      this._validationTestHelper.assertError(_function_1, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAbstractVsNoBody() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("abstract def foo() {}");
      XtendFunction _function = this.function(_builder.toString());
      this._validationTestHelper.assertError(_function, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("abstract def foo()");
      XtendFunction _function_1 = this.function(_builder_1.toString());
      this._validationTestHelper.assertNoError(_function_1, IssueCodes.INVALID_MODIFIER);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFinalVsNoBody() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("final def foo()");
      XtendFunction _function = this.function(_builder.toString());
      this._validationTestHelper.assertError(_function, XtendPackage.Literals.XTEND_FUNCTION, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final def foo() {}");
      XtendFunction _function_1 = this.function(_builder_1.toString());
      this._validationTestHelper.assertNoErrors(_function_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFinalValVsVar() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("final var int i=42");
      XtendField _field = this.field(_builder.toString());
      this._validationTestHelper.assertError(_field, XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("var final int i=42");
      XtendField _field_1 = this.field(_builder_1.toString());
      this._validationTestHelper.assertError(_field_1, XtendPackage.Literals.XTEND_FIELD, IssueCodes.INVALID_MODIFIER);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("final val int i=42");
      XtendField _field_2 = this.field(_builder_2.toString());
      this._validationTestHelper.assertNoErrors(_field_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("val final int i=42");
      XtendField _field_3 = this.field(_builder_3.toString());
      this._validationTestHelper.assertNoErrors(_field_3);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected XtendMember memberInInterface(final String model) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Foo { ");
      _builder.append(model, "");
      _builder.append(" }");
      XtendInterface _interfaze = this.interfaze(_builder.toString());
      EList<XtendMember> _members = _interfaze.getMembers();
      return _members.get(0);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected XtendMember memberInAnnotation(final String model) {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotation Foo { ");
      _builder.append(model, "");
      _builder.append(" }");
      XtendAnnotationType _annotationType = this.annotationType(_builder.toString());
      EList<XtendMember> _members = _annotationType.getMembers();
      return _members.get(0);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

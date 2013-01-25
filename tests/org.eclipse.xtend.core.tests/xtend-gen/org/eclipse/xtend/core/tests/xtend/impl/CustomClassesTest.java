package org.eclipse.xtend.core.tests.xtend.impl;

import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class CustomClassesTest extends AbstractXtendTestCase {
  @Test
  public void testClassAbstractFinal() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("abstract final class Foo {}");
      XtendClass _clazz = this.clazz(_builder.toString());
      boolean _isFinal = _clazz.isFinal();
      Assert.assertFalse(_isFinal);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("abstract final class Foo {}");
      XtendClass _clazz_1 = this.clazz(_builder_1.toString());
      boolean _isAbstract = _clazz_1.isAbstract();
      Assert.assertTrue(_isAbstract);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("final abstract class Foo {}");
      XtendClass _clazz_2 = this.clazz(_builder_2.toString());
      boolean _isFinal_1 = _clazz_2.isFinal();
      Assert.assertTrue(_isFinal_1);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("final abstract class Foo {}");
      XtendClass _clazz_3 = this.clazz(_builder_3.toString());
      boolean _isAbstract_1 = _clazz_3.isAbstract();
      Assert.assertFalse(_isAbstract_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testClassStatic() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {}");
      XtendClass _clazz = this.clazz(_builder.toString());
      boolean _isStatic = _clazz.isStatic();
      Assert.assertFalse(_isStatic);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("static class Foo {}");
      XtendClass _clazz_1 = this.clazz(_builder_1.toString());
      boolean _isStatic_1 = _clazz_1.isStatic();
      Assert.assertTrue(_isStatic_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testClassVisibility() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {}");
      XtendClass _clazz = this.clazz(_builder.toString());
      JvmVisibility _visibility = _clazz.getVisibility();
      Assert.assertEquals(JvmVisibility.PUBLIC, _visibility);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public class Foo {}");
      XtendClass _clazz_1 = this.clazz(_builder_1.toString());
      JvmVisibility _visibility_1 = _clazz_1.getVisibility();
      Assert.assertEquals(JvmVisibility.PUBLIC, _visibility_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected class Foo {}");
      XtendClass _clazz_2 = this.clazz(_builder_2.toString());
      JvmVisibility _visibility_2 = _clazz_2.getVisibility();
      Assert.assertEquals(JvmVisibility.PROTECTED, _visibility_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package class Foo {}");
      XtendClass _clazz_3 = this.clazz(_builder_3.toString());
      JvmVisibility _visibility_3 = _clazz_3.getVisibility();
      Assert.assertEquals(JvmVisibility.DEFAULT, _visibility_3);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("private class Foo {}");
      XtendClass _clazz_4 = this.clazz(_builder_4.toString());
      JvmVisibility _visibility_4 = _clazz_4.getVisibility();
      Assert.assertEquals(JvmVisibility.PRIVATE, _visibility_4);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAnnotationTypeStaticAbstract() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("static annotation Foo {}");
      XtendAnnotationType _annotationType = this.annotationType(_builder.toString());
      boolean _isStatic = _annotationType.isStatic();
      Assert.assertFalse(_isStatic);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final annotation Foo {}");
      XtendAnnotationType _annotationType_1 = this.annotationType(_builder_1.toString());
      boolean _isFinal = _annotationType_1.isFinal();
      Assert.assertFalse(_isFinal);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAnnotationTypeVisibility() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotation Foo {}");
      XtendAnnotationType _annotationType = this.annotationType(_builder.toString());
      JvmVisibility _visibility = _annotationType.getVisibility();
      Assert.assertEquals(JvmVisibility.PUBLIC, _visibility);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public annotation Foo {}");
      XtendAnnotationType _annotationType_1 = this.annotationType(_builder_1.toString());
      JvmVisibility _visibility_1 = _annotationType_1.getVisibility();
      Assert.assertEquals(JvmVisibility.PUBLIC, _visibility_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected annotation Foo {}");
      XtendAnnotationType _annotationType_2 = this.annotationType(_builder_2.toString());
      JvmVisibility _visibility_2 = _annotationType_2.getVisibility();
      Assert.assertEquals(JvmVisibility.PROTECTED, _visibility_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package annotation Foo {}");
      XtendAnnotationType _annotationType_3 = this.annotationType(_builder_3.toString());
      JvmVisibility _visibility_3 = _annotationType_3.getVisibility();
      Assert.assertEquals(JvmVisibility.DEFAULT, _visibility_3);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("private annotation Foo {}");
      XtendAnnotationType _annotationType_4 = this.annotationType(_builder_4.toString());
      JvmVisibility _visibility_4 = _annotationType_4.getVisibility();
      Assert.assertEquals(JvmVisibility.PRIVATE, _visibility_4);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testXtendFieldVisibility() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("int foo=42");
      XtendField _field = this.field(_builder.toString());
      JvmVisibility _visibility = _field.getVisibility();
      Assert.assertEquals(JvmVisibility.PRIVATE, _visibility);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public int foo=42");
      XtendField _field_1 = this.field(_builder_1.toString());
      JvmVisibility _visibility_1 = _field_1.getVisibility();
      Assert.assertEquals(JvmVisibility.PUBLIC, _visibility_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected int foo=42");
      XtendField _field_2 = this.field(_builder_2.toString());
      JvmVisibility _visibility_2 = _field_2.getVisibility();
      Assert.assertEquals(JvmVisibility.PROTECTED, _visibility_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package int foo=42");
      XtendField _field_3 = this.field(_builder_3.toString());
      JvmVisibility _visibility_3 = _field_3.getVisibility();
      Assert.assertEquals(JvmVisibility.DEFAULT, _visibility_3);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("private int foo=42");
      XtendField _field_4 = this.field(_builder_4.toString());
      JvmVisibility _visibility_4 = _field_4.getVisibility();
      Assert.assertEquals(JvmVisibility.PRIVATE, _visibility_4);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFieldExtension() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("int foo=42");
      XtendField _field = this.field(_builder.toString());
      boolean _isExtension = _field.isExtension();
      Assert.assertFalse(_isExtension);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("extension int foo=42");
      XtendField _field_1 = this.field(_builder_1.toString());
      boolean _isExtension_1 = _field_1.isExtension();
      Assert.assertTrue(_isExtension_1);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFieldFinal() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("int foo=42");
      XtendField _field = this.field(_builder.toString());
      boolean _isFinal = _field.isFinal();
      Assert.assertFalse(_isFinal);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final int foo=42");
      XtendField _field_1 = this.field(_builder_1.toString());
      boolean _isFinal_1 = _field_1.isFinal();
      Assert.assertTrue(_isFinal_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("val int foo=42");
      XtendField _field_2 = this.field(_builder_2.toString());
      boolean _isFinal_2 = _field_2.isFinal();
      Assert.assertTrue(_isFinal_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("var int foo=42");
      XtendField _field_3 = this.field(_builder_3.toString());
      boolean _isFinal_3 = _field_3.isFinal();
      Assert.assertFalse(_isFinal_3);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("var final int foo=42");
      XtendField _field_4 = this.field(_builder_4.toString());
      boolean _isFinal_4 = _field_4.isFinal();
      Assert.assertFalse(_isFinal_4);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

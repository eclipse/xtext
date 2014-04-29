package org.eclipse.xtend.core.tests.xtend.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendAnnotationType;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendInterface;
import org.eclipse.xtend.core.xtend.XtendMember;
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
  public void testInterfaceVisibility() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Foo {}");
      XtendInterface _interfaze = this.interfaze(_builder.toString());
      JvmVisibility _visibility = _interfaze.getVisibility();
      Assert.assertEquals(JvmVisibility.PUBLIC, _visibility);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public interface Foo {}");
      XtendInterface _interfaze_1 = this.interfaze(_builder_1.toString());
      JvmVisibility _visibility_1 = _interfaze_1.getVisibility();
      Assert.assertEquals(JvmVisibility.PUBLIC, _visibility_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected interface Foo {}");
      XtendInterface _interfaze_2 = this.interfaze(_builder_2.toString());
      JvmVisibility _visibility_2 = _interfaze_2.getVisibility();
      Assert.assertEquals(JvmVisibility.PROTECTED, _visibility_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package interface Foo {}");
      XtendInterface _interfaze_3 = this.interfaze(_builder_3.toString());
      JvmVisibility _visibility_3 = _interfaze_3.getVisibility();
      Assert.assertEquals(JvmVisibility.DEFAULT, _visibility_3);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("private interface Foo {}");
      XtendInterface _interfaze_4 = this.interfaze(_builder_4.toString());
      JvmVisibility _visibility_4 = _interfaze_4.getVisibility();
      Assert.assertEquals(JvmVisibility.PRIVATE, _visibility_4);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnumVisibility() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("enum Foo {}");
      XtendEnum _enumeration = this.enumeration(_builder.toString());
      JvmVisibility _visibility = _enumeration.getVisibility();
      Assert.assertEquals(JvmVisibility.PUBLIC, _visibility);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public enum Foo {}");
      XtendEnum _enumeration_1 = this.enumeration(_builder_1.toString());
      JvmVisibility _visibility_1 = _enumeration_1.getVisibility();
      Assert.assertEquals(JvmVisibility.PUBLIC, _visibility_1);
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected enum Foo {}");
      XtendEnum _enumeration_2 = this.enumeration(_builder_2.toString());
      JvmVisibility _visibility_2 = _enumeration_2.getVisibility();
      Assert.assertEquals(JvmVisibility.PROTECTED, _visibility_2);
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package enum Foo {}");
      XtendEnum _enumeration_3 = this.enumeration(_builder_3.toString());
      JvmVisibility _visibility_3 = _enumeration_3.getVisibility();
      Assert.assertEquals(JvmVisibility.DEFAULT, _visibility_3);
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("private enum Foo {}");
      XtendEnum _enumeration_4 = this.enumeration(_builder_4.toString());
      JvmVisibility _visibility_4 = _enumeration_4.getVisibility();
      Assert.assertEquals(JvmVisibility.PRIVATE, _visibility_4);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInterfaceFinalAndStatic() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Foo {}");
      XtendInterface _interfaze = this.interfaze(_builder.toString());
      boolean _isFinal = _interfaze.isFinal();
      Assert.assertFalse(_isFinal);
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("interface Foo {}");
      XtendInterface _interfaze_1 = this.interfaze(_builder_1.toString());
      boolean _isStatic = _interfaze_1.isStatic();
      Assert.assertTrue(_isStatic);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnumFinalAndStatic() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("enum Foo {}");
      XtendEnum _enumeration = this.enumeration(_builder.toString());
      boolean _isStatic = _enumeration.isStatic();
      Assert.assertTrue(_isStatic);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testEnumLiteralDefaults() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("enum Foo { BAR }");
      final XtendEnum enumeration = this.enumeration(_builder.toString());
      EList<XtendMember> _members = enumeration.getMembers();
      final XtendMember literal = _members.get(0);
      boolean _isStatic = literal.isStatic();
      Assert.assertTrue(_isStatic);
      boolean _isFinal = literal.isFinal();
      Assert.assertTrue(_isFinal);
      JvmVisibility _visibility = literal.getVisibility();
      Assert.assertEquals(JvmVisibility.PUBLIC, _visibility);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFieldInInterfaceDefaults() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Foo { int foo }");
      XtendInterface _interfaze = this.interfaze(_builder.toString());
      EList<XtendMember> _members = _interfaze.getMembers();
      XtendMember _get = _members.get(0);
      final XtendField field = ((XtendField) _get);
      boolean _isFinal = field.isFinal();
      Assert.assertTrue(_isFinal);
      boolean _isStatic = field.isStatic();
      Assert.assertTrue(_isStatic);
      JvmVisibility _visibility = field.getVisibility();
      Assert.assertEquals(JvmVisibility.PUBLIC, _visibility);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testFieldInAnnotationDefaults() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotation Foo { int foo }");
      XtendAnnotationType _annotationType = this.annotationType(_builder.toString());
      EList<XtendMember> _members = _annotationType.getMembers();
      XtendMember _get = _members.get(0);
      final XtendField field = ((XtendField) _get);
      boolean _isFinal = field.isFinal();
      Assert.assertTrue(_isFinal);
      boolean _isStatic = field.isStatic();
      Assert.assertTrue(_isStatic);
      JvmVisibility _visibility = field.getVisibility();
      Assert.assertEquals(JvmVisibility.PUBLIC, _visibility);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testAnnotationTypeStaticAndFinal() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("static annotation Foo {}");
      XtendAnnotationType _annotationType = this.annotationType(_builder.toString());
      boolean _isStatic = _annotationType.isStatic();
      Assert.assertTrue(_isStatic);
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

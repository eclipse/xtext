/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.xtend.impl;

import org.eclipse.xtend.core.tests.AbstractXtendTestCase;
import org.eclipse.xtend.core.xtend.XtendEnum;
import org.eclipse.xtend.core.xtend.XtendField;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.common.types.JvmVisibility;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class CustomClassesTest extends AbstractXtendTestCase {
  @Test
  public void testClassAbstractFinal() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("abstract final class Foo {}");
      Assert.assertFalse(this.clazz(_builder.toString()).isFinal());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("abstract final class Foo {}");
      Assert.assertTrue(this.clazz(_builder_1.toString()).isAbstract());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("final abstract class Foo {}");
      Assert.assertTrue(this.clazz(_builder_2.toString()).isFinal());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("final abstract class Foo {}");
      Assert.assertFalse(this.clazz(_builder_3.toString()).isAbstract());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testClassStatic() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {}");
      Assert.assertFalse(this.clazz(_builder.toString()).isStatic());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("static class Foo {}");
      Assert.assertTrue(this.clazz(_builder_1.toString()).isStatic());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testClassVisibility() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {}");
      Assert.assertEquals(JvmVisibility.PUBLIC, this.clazz(_builder.toString()).getVisibility());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public class Foo {}");
      Assert.assertEquals(JvmVisibility.PUBLIC, this.clazz(_builder_1.toString()).getVisibility());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected class Foo {}");
      Assert.assertEquals(JvmVisibility.PROTECTED, this.clazz(_builder_2.toString()).getVisibility());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package class Foo {}");
      Assert.assertEquals(JvmVisibility.DEFAULT, this.clazz(_builder_3.toString()).getVisibility());
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("private class Foo {}");
      Assert.assertEquals(JvmVisibility.PRIVATE, this.clazz(_builder_4.toString()).getVisibility());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testInterfaceVisibility() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Foo {}");
      Assert.assertEquals(JvmVisibility.PUBLIC, this.interfaze(_builder.toString()).getVisibility());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public interface Foo {}");
      Assert.assertEquals(JvmVisibility.PUBLIC, this.interfaze(_builder_1.toString()).getVisibility());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected interface Foo {}");
      Assert.assertEquals(JvmVisibility.PROTECTED, this.interfaze(_builder_2.toString()).getVisibility());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package interface Foo {}");
      Assert.assertEquals(JvmVisibility.DEFAULT, this.interfaze(_builder_3.toString()).getVisibility());
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("private interface Foo {}");
      Assert.assertEquals(JvmVisibility.PRIVATE, this.interfaze(_builder_4.toString()).getVisibility());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testEnumVisibility() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("enum Foo {}");
      Assert.assertEquals(JvmVisibility.PUBLIC, this.enumeration(_builder.toString()).getVisibility());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public enum Foo {}");
      Assert.assertEquals(JvmVisibility.PUBLIC, this.enumeration(_builder_1.toString()).getVisibility());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected enum Foo {}");
      Assert.assertEquals(JvmVisibility.PROTECTED, this.enumeration(_builder_2.toString()).getVisibility());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package enum Foo {}");
      Assert.assertEquals(JvmVisibility.DEFAULT, this.enumeration(_builder_3.toString()).getVisibility());
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("private enum Foo {}");
      Assert.assertEquals(JvmVisibility.PRIVATE, this.enumeration(_builder_4.toString()).getVisibility());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testInterfaceFinalAndStatic() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Foo {}");
      Assert.assertFalse(this.interfaze(_builder.toString()).isFinal());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("interface Foo {}");
      Assert.assertFalse(this.interfaze(_builder_1.toString()).isStatic());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testEnumFinalAndStatic() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("enum Foo {}");
      Assert.assertFalse(this.enumeration(_builder.toString()).isStatic());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("enum Foo {}");
      Assert.assertTrue(this.enumeration(_builder_1.toString()).isFinal());
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
      final XtendMember literal = enumeration.getMembers().get(0);
      Assert.assertTrue(literal.isStatic());
      Assert.assertTrue(literal.isFinal());
      Assert.assertEquals(JvmVisibility.PUBLIC, literal.getVisibility());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFieldInInterfaceDefaults() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("interface Foo { int foo }");
      XtendMember _get = this.interfaze(_builder.toString()).getMembers().get(0);
      final XtendField field = ((XtendField) _get);
      Assert.assertTrue(field.isFinal());
      Assert.assertTrue(field.isStatic());
      Assert.assertEquals(JvmVisibility.PUBLIC, field.getVisibility());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFieldInAnnotationDefaults() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotation Foo { int foo }");
      XtendMember _get = this.annotationType(_builder.toString()).getMembers().get(0);
      final XtendField field = ((XtendField) _get);
      Assert.assertTrue(field.isFinal());
      Assert.assertTrue(field.isStatic());
      Assert.assertEquals(JvmVisibility.PUBLIC, field.getVisibility());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testAnnotationTypeStaticAndFinal() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("static annotation Foo {}");
      Assert.assertFalse(this.annotationType(_builder.toString()).isStatic());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final annotation Foo {}");
      Assert.assertFalse(this.annotationType(_builder_1.toString()).isFinal());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testAnnotationTypeVisibility() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("annotation Foo {}");
      Assert.assertEquals(JvmVisibility.PUBLIC, this.annotationType(_builder.toString()).getVisibility());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public annotation Foo {}");
      Assert.assertEquals(JvmVisibility.PUBLIC, this.annotationType(_builder_1.toString()).getVisibility());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected annotation Foo {}");
      Assert.assertEquals(JvmVisibility.PROTECTED, this.annotationType(_builder_2.toString()).getVisibility());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package annotation Foo {}");
      Assert.assertEquals(JvmVisibility.DEFAULT, this.annotationType(_builder_3.toString()).getVisibility());
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("private annotation Foo {}");
      Assert.assertEquals(JvmVisibility.PRIVATE, this.annotationType(_builder_4.toString()).getVisibility());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testXtendFieldVisibility() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("int foo=42");
      Assert.assertEquals(JvmVisibility.PRIVATE, this.field(_builder.toString()).getVisibility());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("public int foo=42");
      Assert.assertEquals(JvmVisibility.PUBLIC, this.field(_builder_1.toString()).getVisibility());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("protected int foo=42");
      Assert.assertEquals(JvmVisibility.PROTECTED, this.field(_builder_2.toString()).getVisibility());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package int foo=42");
      Assert.assertEquals(JvmVisibility.DEFAULT, this.field(_builder_3.toString()).getVisibility());
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("private int foo=42");
      Assert.assertEquals(JvmVisibility.PRIVATE, this.field(_builder_4.toString()).getVisibility());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFieldExtension() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("int foo=42");
      Assert.assertFalse(this.field(_builder.toString()).isExtension());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("extension int foo=42");
      Assert.assertTrue(this.field(_builder_1.toString()).isExtension());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testFieldFinal() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("int foo=42");
      Assert.assertFalse(this.field(_builder.toString()).isFinal());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("final int foo=42");
      Assert.assertTrue(this.field(_builder_1.toString()).isFinal());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("val int foo=42");
      Assert.assertTrue(this.field(_builder_2.toString()).isFinal());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("var int foo=42");
      Assert.assertFalse(this.field(_builder_3.toString()).isFinal());
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("var final int foo=42");
      Assert.assertFalse(this.field(_builder_4.toString()).isFinal());
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

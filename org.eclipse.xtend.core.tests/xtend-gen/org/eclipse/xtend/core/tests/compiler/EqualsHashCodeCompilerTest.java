/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.compiler;

import com.google.inject.Inject;
import java.lang.reflect.Field;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class EqualsHashCodeCompilerTest extends AbstractXtendCompilerTest {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  @Test
  public void testEqualsHashCode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.EqualsHashCode");
      _builder.newLine();
      _builder.append("@EqualsHashCode class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static String ignoreMe");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("transient String ignoreMe2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def create {} ignoreMe3() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int a = 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("char b = \'a\'");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("short c = 2 as short");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("byte d = 3 as byte");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("long e = 4");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("float f = 5");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("double g = 6");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("boolean h = true");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Object i = \"Foo\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Object first = it.getCompiledClass().getDeclaredConstructor().newInstance();
          final Object second = it.getCompiledClass().getDeclaredConstructor().newInstance();
          Field _declaredField = it.getCompiledClass().getDeclaredField("ignoreMe");
          final Procedure1<Field> _function_1 = (Field it_1) -> {
            try {
              it_1.setAccessible(true);
              it_1.set(null, "Bar");
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          };
          ObjectExtensions.<Field>operator_doubleArrow(_declaredField, _function_1);
          Field _declaredField_1 = it.getCompiledClass().getDeclaredField("ignoreMe2");
          final Procedure1<Field> _function_2 = (Field it_1) -> {
            try {
              it_1.setAccessible(true);
              it_1.set(second, "Bar");
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          };
          ObjectExtensions.<Field>operator_doubleArrow(_declaredField_1, _function_2);
          final Object third = it.getCompiledClass().getDeclaredConstructor().newInstance();
          Field _declaredField_2 = it.getCompiledClass().getDeclaredField("i");
          final Procedure1<Field> _function_3 = (Field it_1) -> {
            try {
              it_1.setAccessible(true);
              it_1.set(third, "Bar");
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          };
          ObjectExtensions.<Field>operator_doubleArrow(_declaredField_2, _function_3);
          Assert.assertEquals(first, second);
          Assert.assertFalse(first.equals(third));
          Assert.assertEquals(first.hashCode(), second.hashCode());
          int _hashCode = first.hashCode();
          int _hashCode_1 = third.hashCode();
          boolean _equals = (_hashCode == _hashCode_1);
          Assert.assertFalse(_equals);
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      this.compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testEqualsWithSuperClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.EqualsHashCode");
      _builder.newLine();
      _builder.append("@EqualsHashCode class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int foo = 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("@EqualsHashCode class Bar extends Foo{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String bar = \"Foo\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Class<?> foo = it.getCompiledClass("Foo");
          final Class<?> bar = it.getCompiledClass("Bar");
          final Object first = bar.getDeclaredConstructor().newInstance();
          final Object second = bar.getDeclaredConstructor().newInstance();
          final Object third = bar.getDeclaredConstructor().newInstance();
          Field _declaredField = bar.getDeclaredField("bar");
          final Procedure1<Field> _function_1 = (Field it_1) -> {
            try {
              it_1.setAccessible(true);
              it_1.set(third, "Bar");
            } catch (Throwable _e) {
              throw Exceptions.sneakyThrow(_e);
            }
          };
          ObjectExtensions.<Field>operator_doubleArrow(_declaredField, _function_1);
          final Object fourth = foo.getDeclaredConstructor().newInstance();
          Assert.assertEquals(first, second);
          Assert.assertFalse(first.equals(third));
          Assert.assertFalse(first.equals(fourth));
          Assert.assertFalse(fourth.equals(first));
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      this.compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testSuperClassWithoutEquals() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.EqualsHashCode");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("@EqualsHashCode class Bar extends Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String bar = \"Foo\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        Assert.assertFalse(it.getGeneratedCode("Bar"), it.getGeneratedCode("Bar").contains("super.equals"));
        Assert.assertFalse(it.getGeneratedCode("Bar").contains("super.hashCode"));
      };
      this.compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testExistingEquals() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.EqualsHashCode");
      _builder.newLine();
      _builder.append("@EqualsHashCode class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int a = 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override equals(Object o) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("true");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      this._validationTestHelper.assertWarning(this.clazz(text), XAnnotationsPackage.Literals.XANNOTATION, "user.issue", "no effect");
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Object instance = it.getCompiledClass().getDeclaredConstructor().newInstance();
          Assert.assertEquals(instance, "foo");
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      this.compilationTestHelper.compile(text, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testExistingHashCode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.EqualsHashCode");
      _builder.newLine();
      _builder.append("@EqualsHashCode class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int a = 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override hashCode() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("0");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      this._validationTestHelper.assertWarning(this.clazz(text), XtendPackage.Literals.XTEND_CLASS, "user.issue", "no effect");
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Object instance = it.getCompiledClass().getDeclaredConstructor().newInstance();
          Assert.assertEquals(0, instance.hashCode());
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      this.compilationTestHelper.compile(text, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testGenericClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.EqualsHashCode");
      _builder.newLine();
      _builder.append("@EqualsHashCode class Foo<T> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int a = 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        Assert.assertTrue(it.getSingleGeneratedCode().contains("Foo<?> other = (Foo<?>) obj"));
      };
      this.compilationTestHelper.compile(text, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testArray() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.EqualsHashCode");
      _builder.newLine();
      _builder.append("@EqualsHashCode class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int[] a = #[1]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Object instance = it.getCompiledClass().getDeclaredConstructor().newInstance();
          final Object instance2 = it.getCompiledClass().getDeclaredConstructor().newInstance();
          Assert.assertEquals(instance, instance2);
          Assert.assertEquals(instance.hashCode(), instance2.hashCode());
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      this.compilationTestHelper.compile(text, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

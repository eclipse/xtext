/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler;

import com.google.inject.Inject;
import java.lang.reflect.Field;
import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
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
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          try {
            Class<?> _compiledClass = it.getCompiledClass();
            final Object first = _compiledClass.newInstance();
            Class<?> _compiledClass_1 = it.getCompiledClass();
            final Object second = _compiledClass_1.newInstance();
            Class<?> _compiledClass_2 = it.getCompiledClass();
            Field _declaredField = _compiledClass_2.getDeclaredField("ignoreMe");
            final Procedure1<Field> _function = new Procedure1<Field>() {
              public void apply(final Field it) {
                try {
                  it.setAccessible(true);
                  it.set(null, "Bar");
                } catch (Throwable _e) {
                  throw Exceptions.sneakyThrow(_e);
                }
              }
            };
            ObjectExtensions.<Field>operator_doubleArrow(_declaredField, _function);
            Class<?> _compiledClass_3 = it.getCompiledClass();
            Field _declaredField_1 = _compiledClass_3.getDeclaredField("ignoreMe2");
            final Procedure1<Field> _function_1 = new Procedure1<Field>() {
              public void apply(final Field it) {
                try {
                  it.setAccessible(true);
                  it.set(second, "Bar");
                } catch (Throwable _e) {
                  throw Exceptions.sneakyThrow(_e);
                }
              }
            };
            ObjectExtensions.<Field>operator_doubleArrow(_declaredField_1, _function_1);
            Class<?> _compiledClass_4 = it.getCompiledClass();
            final Object third = _compiledClass_4.newInstance();
            Class<?> _compiledClass_5 = it.getCompiledClass();
            Field _declaredField_2 = _compiledClass_5.getDeclaredField("i");
            final Procedure1<Field> _function_2 = new Procedure1<Field>() {
              public void apply(final Field it) {
                try {
                  it.setAccessible(true);
                  it.set(third, "Bar");
                } catch (Throwable _e) {
                  throw Exceptions.sneakyThrow(_e);
                }
              }
            };
            ObjectExtensions.<Field>operator_doubleArrow(_declaredField_2, _function_2);
            Assert.assertEquals(first, second);
            boolean _equals = first.equals(third);
            Assert.assertFalse(_equals);
            int _hashCode = first.hashCode();
            int _hashCode_1 = second.hashCode();
            Assert.assertEquals(_hashCode, _hashCode_1);
            int _hashCode_2 = first.hashCode();
            int _hashCode_3 = third.hashCode();
            boolean _equals_1 = (_hashCode_2 == _hashCode_3);
            Assert.assertFalse(_equals_1);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
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
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          try {
            final Class<?> foo = it.getCompiledClass("Foo");
            final Class<?> bar = it.getCompiledClass("Bar");
            final Object first = bar.newInstance();
            final Object second = bar.newInstance();
            final Object third = bar.newInstance();
            Field _declaredField = bar.getDeclaredField("bar");
            final Procedure1<Field> _function = new Procedure1<Field>() {
              public void apply(final Field it) {
                try {
                  it.setAccessible(true);
                  it.set(third, "Bar");
                } catch (Throwable _e) {
                  throw Exceptions.sneakyThrow(_e);
                }
              }
            };
            ObjectExtensions.<Field>operator_doubleArrow(_declaredField, _function);
            final Object fourth = foo.newInstance();
            Assert.assertEquals(first, second);
            boolean _equals = first.equals(third);
            Assert.assertFalse(_equals);
            boolean _equals_1 = first.equals(fourth);
            Assert.assertFalse(_equals_1);
            boolean _equals_2 = fourth.equals(first);
            Assert.assertFalse(_equals_2);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
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
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          String _generatedCode = it.getGeneratedCode("Bar");
          String _generatedCode_1 = it.getGeneratedCode("Bar");
          boolean _contains = _generatedCode_1.contains("super.equals");
          Assert.assertFalse(_generatedCode, _contains);
          String _generatedCode_2 = it.getGeneratedCode("Bar");
          boolean _contains_1 = _generatedCode_2.contains("super.hashCode");
          Assert.assertFalse(_contains_1);
        }
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
      XtendClass _clazz = this.clazz(text);
      this._validationTestHelper.assertWarning(_clazz, XAnnotationsPackage.Literals.XANNOTATION, "user.issue", "no effect");
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          try {
            Class<?> _compiledClass = it.getCompiledClass();
            final Object instance = _compiledClass.newInstance();
            Assert.assertEquals(instance, "foo");
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
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
      XtendClass _clazz = this.clazz(text);
      this._validationTestHelper.assertWarning(_clazz, XtendPackage.Literals.XTEND_CLASS, "user.issue", "no effect");
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          try {
            Class<?> _compiledClass = it.getCompiledClass();
            final Object instance = _compiledClass.newInstance();
            int _hashCode = instance.hashCode();
            Assert.assertEquals(0, _hashCode);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
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
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          String _singleGeneratedCode = it.getSingleGeneratedCode();
          boolean _contains = _singleGeneratedCode.contains("Foo<?> other = (Foo<?>) obj");
          Assert.assertTrue(_contains);
        }
      };
      this.compilationTestHelper.compile(text, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

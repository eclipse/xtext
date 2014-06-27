/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class SetterCompilerTest extends AbstractXtendCompilerTest {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testCreateSingleSetter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Setter int foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          try {
            Class<?> _compiledClass = it.getCompiledClass();
            final Object instance = _compiledClass.newInstance();
            Class<?> _compiledClass_1 = it.getCompiledClass();
            final Method setFoo = _compiledClass_1.getDeclaredMethod("setFoo", int.class);
            Class<?> _compiledClass_2 = it.getCompiledClass();
            Field _declaredField = _compiledClass_2.getDeclaredField("foo");
            final Procedure1<Field> _function = new Procedure1<Field>() {
              public void apply(final Field it) {
                it.setAccessible(true);
              }
            };
            final Field fooField = ObjectExtensions.<Field>operator_doubleArrow(_declaredField, _function);
            setFoo.invoke(instance, Integer.valueOf(1));
            Object _get = fooField.get(instance);
            Assert.assertEquals(Integer.valueOf(1), _get);
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
  public void testCreateGenericSingleSetter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo<T extends CharSequence> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Setter T foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          try {
            String _singleGeneratedCode = it.getSingleGeneratedCode();
            boolean _contains = _singleGeneratedCode.contains("setFoo(final T foo)");
            Assert.assertTrue(_contains);
            Class<?> _compiledClass = it.getCompiledClass();
            final Object instance = _compiledClass.newInstance();
            Class<?> _compiledClass_1 = it.getCompiledClass();
            final Method setFoo = _compiledClass_1.getDeclaredMethod("setFoo", CharSequence.class);
            Class<?> _compiledClass_2 = it.getCompiledClass();
            Field _declaredField = _compiledClass_2.getDeclaredField("foo");
            final Procedure1<Field> _function = new Procedure1<Field>() {
              public void apply(final Field it) {
                it.setAccessible(true);
              }
            };
            final Field fooField = ObjectExtensions.<Field>operator_doubleArrow(_declaredField, _function);
            setFoo.invoke(instance, "bar");
            Object _get = fooField.get(instance);
            Assert.assertEquals("bar", _get);
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
  public void testCreateStaticSetter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Setter static int foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          try {
            Class<?> _compiledClass = it.getCompiledClass();
            final Method setFoo = _compiledClass.getDeclaredMethod("setFoo", int.class);
            Class<?> _compiledClass_1 = it.getCompiledClass();
            Field _declaredField = _compiledClass_1.getDeclaredField("foo");
            final Procedure1<Field> _function = new Procedure1<Field>() {
              public void apply(final Field it) {
                it.setAccessible(true);
              }
            };
            final Field fooField = ObjectExtensions.<Field>operator_doubleArrow(_declaredField, _function);
            setFoo.invoke(null, Integer.valueOf(1));
            Object _get = fooField.get(null);
            Assert.assertEquals(Integer.valueOf(1), _get);
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
  public void testCreateAllSetters() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@Setter class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static String ignoreMe");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def create {} ignoreMe2() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String bar");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def setFoo(int foo) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("this.foo = 2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          try {
            Class<?> _compiledClass = it.getCompiledClass();
            Method[] _declaredMethods = _compiledClass.getDeclaredMethods();
            final Function1<Method, Boolean> _function = new Function1<Method, Boolean>() {
              public Boolean apply(final Method it) {
                String _name = it.getName();
                return Boolean.valueOf(Objects.equal(_name, "setIgnoreMe"));
              }
            };
            boolean _exists = IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(_declaredMethods)), _function);
            Assert.assertFalse(_exists);
            Class<?> _compiledClass_1 = it.getCompiledClass();
            final Object instance = _compiledClass_1.newInstance();
            Class<?> _compiledClass_2 = it.getCompiledClass();
            final Method setFoo = _compiledClass_2.getDeclaredMethod("setFoo", int.class);
            Class<?> _compiledClass_3 = it.getCompiledClass();
            Field _declaredField = _compiledClass_3.getDeclaredField("foo");
            final Procedure1<Field> _function_1 = new Procedure1<Field>() {
              public void apply(final Field it) {
                it.setAccessible(true);
              }
            };
            final Field fooField = ObjectExtensions.<Field>operator_doubleArrow(_declaredField, _function_1);
            Class<?> _compiledClass_4 = it.getCompiledClass();
            final Method setBar = _compiledClass_4.getDeclaredMethod("setBar", String.class);
            Class<?> _compiledClass_5 = it.getCompiledClass();
            Field _declaredField_1 = _compiledClass_5.getDeclaredField("bar");
            final Procedure1<Field> _function_2 = new Procedure1<Field>() {
              public void apply(final Field it) {
                it.setAccessible(true);
              }
            };
            final Field barField = ObjectExtensions.<Field>operator_doubleArrow(_declaredField_1, _function_2);
            setFoo.invoke(instance, Integer.valueOf(1));
            setBar.invoke(instance, "bar");
            Object _get = fooField.get(instance);
            Assert.assertEquals(Integer.valueOf(2), _get);
            Object _get_1 = barField.get(instance);
            Assert.assertEquals("bar", _get_1);
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
  public void testExistingSetter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Setter int foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def setFoo(int foo) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("this.foo = 2");
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
            Class<?> _compiledClass_1 = it.getCompiledClass();
            final Method setFoo = _compiledClass_1.getDeclaredMethod("setFoo", int.class);
            Class<?> _compiledClass_2 = it.getCompiledClass();
            Field _declaredField = _compiledClass_2.getDeclaredField("foo");
            final Procedure1<Field> _function = new Procedure1<Field>() {
              public void apply(final Field it) {
                it.setAccessible(true);
              }
            };
            final Field fooField = ObjectExtensions.<Field>operator_doubleArrow(_declaredField, _function);
            setFoo.invoke(instance, Integer.valueOf(1));
            Object _get = fooField.get(instance);
            Assert.assertEquals(Integer.valueOf(2), _get);
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
  public void testFinalField() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Setter val int foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      XtendClass _clazz = this.clazz(text);
      this._validationTestHelper.assertError(_clazz, XtendPackage.Literals.XTEND_FIELD, "user.issue", "final");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

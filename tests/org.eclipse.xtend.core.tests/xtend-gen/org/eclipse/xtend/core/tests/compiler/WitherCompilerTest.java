/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler;

import com.google.inject.Inject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class WitherCompilerTest extends AbstractXtendCompilerTest {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testCreateSingleWither() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
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
      _builder.append("@Wither String foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new(String foo) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("this.foo = foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def getFoo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("foo");
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
            Constructor<?> _declaredConstructor = _compiledClass.getDeclaredConstructor(String.class);
            final Object first = _declaredConstructor.newInstance("foo");
            Class<?> _compiledClass_1 = it.getCompiledClass();
            final Method withFoo = _compiledClass_1.getDeclaredMethod("withFoo", String.class);
            Class<?> _compiledClass_2 = it.getCompiledClass();
            final Method getFoo = _compiledClass_2.getDeclaredMethod("getFoo");
            final Object second = withFoo.invoke(first, "bar");
            Assert.assertNotSame(first, second);
            Object _invoke = getFoo.invoke(second);
            Assert.assertEquals("bar", _invoke);
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
  public void testCreateAllWithers() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@Wither");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static String ignoreMe");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("transient String ignoreMe2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int x");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new(String foo, int x) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("this.foo = foo");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("this.x = x");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def withX(int x) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Foo(foo, 5)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def getFoo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def getX() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("x");
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
            Constructor<?> _declaredConstructor = _compiledClass.getDeclaredConstructor(String.class, int.class);
            final Object first = _declaredConstructor.newInstance("foo", Integer.valueOf(1));
            Class<?> _compiledClass_1 = it.getCompiledClass();
            final Method withFoo = _compiledClass_1.getDeclaredMethod("withFoo", String.class);
            Class<?> _compiledClass_2 = it.getCompiledClass();
            final Method withX = _compiledClass_2.getDeclaredMethod("withX", int.class);
            Class<?> _compiledClass_3 = it.getCompiledClass();
            final Method getFoo = _compiledClass_3.getDeclaredMethod("getFoo");
            Class<?> _compiledClass_4 = it.getCompiledClass();
            final Method getX = _compiledClass_4.getDeclaredMethod("getX");
            Object _invoke = withFoo.invoke(first, "bar");
            final Object second = withX.invoke(_invoke, Integer.valueOf(2));
            Object _invoke_1 = getFoo.invoke(second);
            Assert.assertEquals("bar", _invoke_1);
            Object _invoke_2 = getX.invoke(second);
            Assert.assertEquals(Integer.valueOf(5), _invoke_2);
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
  public void testExstingWither() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Wither int x");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new(int x) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("this.x = x");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def withX(int x) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("new Foo(5)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def getX() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("x");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      XtendClass _clazz = this.clazz(text);
      this._validationTestHelper.assertWarning(_clazz, XtendPackage.Literals.XTEND_FIELD, "user.issue", "no effect");
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          try {
            Class<?> _compiledClass = it.getCompiledClass();
            Constructor<?> _declaredConstructor = _compiledClass.getDeclaredConstructor(int.class);
            final Object first = _declaredConstructor.newInstance(Integer.valueOf(1));
            Class<?> _compiledClass_1 = it.getCompiledClass();
            final Method withX = _compiledClass_1.getDeclaredMethod("withX", int.class);
            Class<?> _compiledClass_2 = it.getCompiledClass();
            final Method getX = _compiledClass_2.getDeclaredMethod("getX");
            final Object second = withX.invoke(first, Integer.valueOf(2));
            Object _invoke = getX.invoke(second);
            Assert.assertEquals(Integer.valueOf(5), _invoke);
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
  public void testExstingMethodNotMatching() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Wither String foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new(String foo) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("this.foo = foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def withFoo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("null");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def withFoo(int x) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("null");
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
            _compiledClass.getDeclaredMethod("withFoo", String.class);
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
  public void testInferredType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Wither var x = 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new(int x) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("this.x = x");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      XtendClass _clazz = this.clazz(text);
      this._validationTestHelper.assertError(_clazz, XtendPackage.Literals.XTEND_FIELD, "user.issue", "inferred");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

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
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Stefan Oehme - Initial contribution and API
 */
@SuppressWarnings("all")
public class FinalFieldsConstructorCompilerTest extends AbstractXtendCompilerTest {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testOnClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor");
      _builder.newLine();
      _builder.append("@FinalFieldsConstructor class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val int a");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val String b");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String source = _builder.toString();
      XtendClass _clazz = this.clazz(source);
      this._validationTestHelper.assertNoErrors(_clazz);
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          Class<?> _compiledClass = it.getCompiledClass();
          Constructor<?>[] _declaredConstructors = _compiledClass.getDeclaredConstructors();
          final Function1<Constructor<?>, Boolean> _function = new Function1<Constructor<?>, Boolean>() {
            public Boolean apply(final Constructor<?> it) {
              Class<?>[] _parameterTypes = it.getParameterTypes();
              List<Class<?>> _list = IterableExtensions.<Class<?>>toList(((Iterable<Class<?>>)Conversions.doWrapArray(_parameterTypes)));
              return Boolean.valueOf(Objects.equal(_list, Collections.<Class<? extends Object>>unmodifiableList(CollectionLiterals.<Class<? extends Object>>newArrayList(int.class, String.class))));
            }
          };
          boolean _exists = IterableExtensions.<Constructor<?>>exists(((Iterable<Constructor<?>>)Conversions.doWrapArray(_declaredConstructors)), _function);
          Assert.assertTrue(_exists);
        }
      };
      this.compilationTestHelper.compile(source, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOnConstructor() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor");
      _builder.newLine();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val int a");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val String b");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@FinalFieldsConstructor new() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String source = _builder.toString();
      XtendClass _clazz = this.clazz(source);
      this._validationTestHelper.assertNoErrors(_clazz);
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          Class<?> _compiledClass = it.getCompiledClass();
          Constructor<?>[] _declaredConstructors = _compiledClass.getDeclaredConstructors();
          final Function1<Constructor<?>, Boolean> _function = new Function1<Constructor<?>, Boolean>() {
            public Boolean apply(final Constructor<?> it) {
              Class<?>[] _parameterTypes = it.getParameterTypes();
              List<Class<?>> _list = IterableExtensions.<Class<?>>toList(((Iterable<Class<?>>)Conversions.doWrapArray(_parameterTypes)));
              return Boolean.valueOf(Objects.equal(_list, Collections.<Class<? extends Object>>unmodifiableList(CollectionLiterals.<Class<? extends Object>>newArrayList(int.class, String.class))));
            }
          };
          boolean _exists = IterableExtensions.<Constructor<?>>exists(((Iterable<Constructor<?>>)Conversions.doWrapArray(_declaredConstructors)), _function);
          Assert.assertTrue(_exists);
          Class<?> _compiledClass_1 = it.getCompiledClass();
          Constructor<?>[] _declaredConstructors_1 = _compiledClass_1.getDeclaredConstructors();
          final Function1<Constructor<?>, Boolean> _function_1 = new Function1<Constructor<?>, Boolean>() {
            public Boolean apply(final Constructor<?> it) {
              Class<?>[] _parameterTypes = it.getParameterTypes();
              return Boolean.valueOf(((List<Class<?>>)Conversions.doWrapArray(_parameterTypes)).isEmpty());
            }
          };
          boolean _exists_1 = IterableExtensions.<Constructor<?>>exists(((Iterable<Constructor<?>>)Conversions.doWrapArray(_declaredConstructors_1)), _function_1);
          Assert.assertFalse(_exists_1);
        }
      };
      this.compilationTestHelper.compile(source, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testOnGenericClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor");
      _builder.newLine();
      _builder.append("@FinalFieldsConstructor class C<T> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val T a");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String source = _builder.toString();
      XtendClass _clazz = this.clazz(source);
      this._validationTestHelper.assertNoErrors(_clazz);
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          String _singleGeneratedCode = it.getSingleGeneratedCode();
          boolean _contains = _singleGeneratedCode.contains("C(final T a)");
          Assert.assertTrue(_contains);
        }
      };
      this.compilationTestHelper.compile(source, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicate() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor");
      _builder.newLine();
      _builder.append("@FinalFieldsConstructor");
      _builder.newLine();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val int a");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@FinalFieldsConstructor new() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String source = _builder.toString();
      XtendClass _clazz = this.clazz(source);
      this._validationTestHelper.assertError(_clazz, XtendPackage.Literals.XTEND_CONSTRUCTOR, "user.issue", "FinalFieldsConstructor", "already defined");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicate2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor");
      _builder.newLine();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val int a");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@FinalFieldsConstructor new() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@FinalFieldsConstructor new() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String source = _builder.toString();
      XtendClass _clazz = this.clazz(source);
      this._validationTestHelper.assertError(_clazz, XtendPackage.Literals.XTEND_CONSTRUCTOR, "user.issue", "FinalFieldsConstructor", "already defined");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testParameterListValidation() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor");
      _builder.newLine();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val int a");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@FinalFieldsConstructor new(String a) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String source = _builder.toString();
      XtendClass _clazz = this.clazz(source);
      this._validationTestHelper.assertError(_clazz, XtendPackage.Literals.XTEND_CONSTRUCTOR, "user.issue", "Parameter list must be empty");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBodyValidation() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor");
      _builder.newLine();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val int a");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@FinalFieldsConstructor new() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("this.a = 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String source = _builder.toString();
      XtendClass _clazz = this.clazz(source);
      this._validationTestHelper.assertError(_clazz, XtendPackage.Literals.XTEND_CONSTRUCTOR, "user.issue", "Body must be empty");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIntegrationWithData() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder.newLine();
      _builder.append("@FinalFieldsConstructor @Data class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val int a");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val String b");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String source = _builder.toString();
      XtendClass _clazz = this.clazz(source);
      this._validationTestHelper.assertNoErrors(_clazz);
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          Class<?> _compiledClass = it.getCompiledClass();
          Constructor<?>[] _declaredConstructors = _compiledClass.getDeclaredConstructors();
          final Function1<Constructor<?>, Boolean> _function = new Function1<Constructor<?>, Boolean>() {
            public Boolean apply(final Constructor<?> it) {
              Class<?>[] _parameterTypes = it.getParameterTypes();
              List<Class<?>> _list = IterableExtensions.<Class<?>>toList(((Iterable<Class<?>>)Conversions.doWrapArray(_parameterTypes)));
              return Boolean.valueOf(Objects.equal(_list, Collections.<Class<? extends Object>>unmodifiableList(CollectionLiterals.<Class<? extends Object>>newArrayList(int.class, String.class))));
            }
          };
          boolean _exists = IterableExtensions.<Constructor<?>>exists(((Iterable<Constructor<?>>)Conversions.doWrapArray(_declaredConstructors)), _function);
          Assert.assertTrue(_exists);
        }
      };
      this.compilationTestHelper.compile(source, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIntegrationWithAccessors() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
      _builder.newLine();
      _builder.append("@FinalFieldsConstructor @Accessors class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val int a");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val String b");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String source = _builder.toString();
      XtendClass _clazz = this.clazz(source);
      this._validationTestHelper.assertNoErrors(_clazz);
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          Class<?> _compiledClass = it.getCompiledClass();
          Constructor<?>[] _declaredConstructors = _compiledClass.getDeclaredConstructors();
          final Function1<Constructor<?>, Boolean> _function = new Function1<Constructor<?>, Boolean>() {
            public Boolean apply(final Constructor<?> it) {
              Class<?>[] _parameterTypes = it.getParameterTypes();
              List<Class<?>> _list = IterableExtensions.<Class<?>>toList(((Iterable<Class<?>>)Conversions.doWrapArray(_parameterTypes)));
              return Boolean.valueOf(Objects.equal(_list, Collections.<Class<? extends Object>>unmodifiableList(CollectionLiterals.<Class<? extends Object>>newArrayList(int.class, String.class))));
            }
          };
          boolean _exists = IterableExtensions.<Constructor<?>>exists(((Iterable<Constructor<?>>)Conversions.doWrapArray(_declaredConstructors)), _function);
          Assert.assertTrue(_exists);
        }
      };
      this.compilationTestHelper.compile(source, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

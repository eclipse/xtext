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
import java.lang.reflect.Constructor;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
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
      this._validationTestHelper.assertNoErrors(this.clazz(source));
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        final Function1<Constructor<?>, Boolean> _function_1 = (Constructor<?> it_1) -> {
          List<Class<?>> _list = IterableExtensions.<Class<?>>toList(((Iterable<Class<?>>)Conversions.doWrapArray(it_1.getParameterTypes())));
          return Boolean.valueOf(Objects.equals(_list, Collections.<Class<? extends Object>>unmodifiableList(CollectionLiterals.<Class<? extends Object>>newArrayList(int.class, String.class))));
        };
        Assert.assertTrue(
          IterableExtensions.<Constructor<?>>exists(((Iterable<Constructor<?>>)Conversions.doWrapArray(it.getCompiledClass().getDeclaredConstructors())), _function_1));
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
      this._validationTestHelper.assertNoErrors(this.clazz(source));
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        final Function1<Constructor<?>, Boolean> _function_1 = (Constructor<?> it_1) -> {
          List<Class<?>> _list = IterableExtensions.<Class<?>>toList(((Iterable<Class<?>>)Conversions.doWrapArray(it_1.getParameterTypes())));
          return Boolean.valueOf(Objects.equals(_list, Collections.<Class<? extends Object>>unmodifiableList(CollectionLiterals.<Class<? extends Object>>newArrayList(int.class, String.class))));
        };
        Assert.assertTrue(
          IterableExtensions.<Constructor<?>>exists(((Iterable<Constructor<?>>)Conversions.doWrapArray(it.getCompiledClass().getDeclaredConstructors())), _function_1));
        final Function1<Constructor<?>, Boolean> _function_2 = (Constructor<?> it_1) -> {
          return Boolean.valueOf(((List<Class<?>>)Conversions.doWrapArray(it_1.getParameterTypes())).isEmpty());
        };
        Assert.assertFalse(
          IterableExtensions.<Constructor<?>>exists(((Iterable<Constructor<?>>)Conversions.doWrapArray(it.getCompiledClass().getDeclaredConstructors())), _function_2));
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
      this._validationTestHelper.assertNoErrors(this.clazz(source));
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        Assert.assertTrue(it.getSingleGeneratedCode().contains("C(final T a)"));
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
      this._validationTestHelper.assertError(this.clazz(source), XtendPackage.Literals.XTEND_CONSTRUCTOR, "user.issue", "FinalFieldsConstructor", "new(int)", "already exists");
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
      this._validationTestHelper.assertError(this.clazz(source), XtendPackage.Literals.XTEND_CONSTRUCTOR, "user.issue", "FinalFieldsConstructor", "new(int)", "already exists");
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
      this._validationTestHelper.assertError(this.clazz(source), XtendPackage.Literals.XTEND_CONSTRUCTOR, "user.issue", "Parameter list must be empty");
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
      this._validationTestHelper.assertError(this.clazz(source), XtendPackage.Literals.XTEND_CONSTRUCTOR, "user.issue", "Body must be empty");
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
      this._validationTestHelper.assertNoErrors(this.clazz(source));
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        final Function1<Constructor<?>, Boolean> _function_1 = (Constructor<?> it_1) -> {
          List<Class<?>> _list = IterableExtensions.<Class<?>>toList(((Iterable<Class<?>>)Conversions.doWrapArray(it_1.getParameterTypes())));
          return Boolean.valueOf(Objects.equals(_list, Collections.<Class<? extends Object>>unmodifiableList(CollectionLiterals.<Class<? extends Object>>newArrayList(int.class, String.class))));
        };
        Assert.assertTrue(
          IterableExtensions.<Constructor<?>>exists(((Iterable<Constructor<?>>)Conversions.doWrapArray(it.getCompiledClass().getDeclaredConstructors())), _function_1));
      };
      this.compilationTestHelper.compile(source, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testIntegrationWithData2() {
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
      _builder.append("\t");
      _builder.append("new() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("a = 1");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("b = \"Foo\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String source = _builder.toString();
      this._validationTestHelper.assertNoErrors(this.clazz(source));
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        final Function1<Constructor<?>, Boolean> _function_1 = (Constructor<?> it_1) -> {
          List<Class<?>> _list = IterableExtensions.<Class<?>>toList(((Iterable<Class<?>>)Conversions.doWrapArray(it_1.getParameterTypes())));
          return Boolean.valueOf(Objects.equals(_list, Collections.<Class<? extends Object>>unmodifiableList(CollectionLiterals.<Class<? extends Object>>newArrayList(int.class, String.class))));
        };
        Assert.assertTrue(
          IterableExtensions.<Constructor<?>>exists(((Iterable<Constructor<?>>)Conversions.doWrapArray(it.getCompiledClass().getDeclaredConstructors())), _function_1));
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
      this._validationTestHelper.assertNoErrors(this.clazz(source));
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        final Function1<Constructor<?>, Boolean> _function_1 = (Constructor<?> it_1) -> {
          List<Class<?>> _list = IterableExtensions.<Class<?>>toList(((Iterable<Class<?>>)Conversions.doWrapArray(it_1.getParameterTypes())));
          return Boolean.valueOf(Objects.equals(_list, Collections.<Class<? extends Object>>unmodifiableList(CollectionLiterals.<Class<? extends Object>>newArrayList(int.class, String.class))));
        };
        Assert.assertTrue(
          IterableExtensions.<Constructor<?>>exists(((Iterable<Constructor<?>>)Conversions.doWrapArray(it.getCompiledClass().getDeclaredConstructors())), _function_1));
      };
      this.compilationTestHelper.compile(source, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testNoFinalFields() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor");
      _builder.newLine();
      _builder.append("@FinalFieldsConstructor ");
      _builder.newLine();
      _builder.append("class Foo{}");
      _builder.newLine();
      final String source = _builder.toString();
      this._validationTestHelper.assertWarning(this.clazz(source), XAnnotationsPackage.Literals.XANNOTATION, "user.issue", "no final fields");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

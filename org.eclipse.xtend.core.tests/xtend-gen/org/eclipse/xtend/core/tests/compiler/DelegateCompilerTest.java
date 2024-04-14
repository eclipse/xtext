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
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import org.eclipse.xtend.core.validation.IssueCodes;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.IAcceptor;
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
public class DelegateCompilerTest extends AbstractXtendCompilerTest {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  @Test
  public void testDelegateField() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void m()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class B implements A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override m() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements A{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate B delegate");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      this._validationTestHelper.assertNoIssues(this.file(text));
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        final Function1<Method, Boolean> _function_1 = (Method it_1) -> {
          return Boolean.valueOf(((Objects.equals(it_1.getName(), "m") && ((List<Class<?>>)Conversions.doWrapArray(it_1.getParameterTypes())).isEmpty()) && Objects.equals(it_1.getReturnType(), void.class)));
        };
        Assert.assertTrue(IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(it.getCompiledClass().getDeclaredMethods())), _function_1));
      };
      this.compilationTestHelper.compile(text, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testMethodWithReturnType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def int m()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class B implements A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override m() {1}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements A{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate B delegate");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      this._validationTestHelper.assertNoIssues(this.file(text));
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        final Function1<Method, Boolean> _function_1 = (Method it_1) -> {
          return Boolean.valueOf(((Objects.equals(it_1.getName(), "m") && ((List<Class<?>>)Conversions.doWrapArray(it_1.getParameterTypes())).isEmpty()) && Objects.equals(it_1.getReturnType(), int.class)));
        };
        Assert.assertTrue(IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(it.getCompiledClass().getDeclaredMethods())), _function_1));
      };
      this.compilationTestHelper.compile(text, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testMethodWithParameters() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void m(String foo, Object bar)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class B implements A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override m(String foo, Object bar) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements A{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate B delegate");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      this._validationTestHelper.assertNoIssues(this.file(text));
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        final Function1<Method, Boolean> _function_1 = (Method it_1) -> {
          return Boolean.valueOf(((Objects.equals(it_1.getName(), "m") && Objects.equals(IterableExtensions.<Class<?>>toList(((Iterable<Class<?>>)Conversions.doWrapArray(it_1.getParameterTypes()))), Collections.<Class<?>>unmodifiableList(CollectionLiterals.<Class<?>>newArrayList(String.class, Object.class)))) && Objects.equals(it_1.getReturnType(), void.class)));
        };
        Assert.assertTrue(IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(it.getCompiledClass().getDeclaredMethods())), _function_1));
      };
      this.compilationTestHelper.compile(text, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testDelegateMethod() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void m()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class B implements A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override m() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements A{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate def B delegate() {null}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      this._validationTestHelper.assertNoIssues(this.file(text));
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        final Function1<Method, Boolean> _function_1 = (Method it_1) -> {
          String _name = it_1.getName();
          return Boolean.valueOf(Objects.equals(_name, "m"));
        };
        Assert.assertTrue(IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(it.getCompiledClass().getDeclaredMethods())), _function_1));
      };
      this.compilationTestHelper.compile(text, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testDelegateMethod2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void m()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class B implements A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override m() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements A{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate def B delegate(String name) {null}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      this._validationTestHelper.assertNoIssues(this.file(text));
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        final Function1<Method, Boolean> _function_1 = (Method it_1) -> {
          String _name = it_1.getName();
          return Boolean.valueOf(Objects.equals(_name, "m"));
        };
        Assert.assertTrue(IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(it.getCompiledClass().getDeclaredMethods())), _function_1));
      };
      this.compilationTestHelper.compile(text, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testDelegateMethod3() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void m(String foo)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class B implements A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override m(String foo) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements A{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate def B delegate(String name, Class<?>[] argTypes, Object... args) {null}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      this._validationTestHelper.assertNoIssues(this.file(text));
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        final Function1<Method, Boolean> _function_1 = (Method it_1) -> {
          String _name = it_1.getName();
          return Boolean.valueOf(Objects.equals(_name, "m"));
        };
        Assert.assertTrue(IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(it.getCompiledClass().getDeclaredMethods())), _function_1));
      };
      this.compilationTestHelper.compile(text, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testIllegalDelegateSignature() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void m()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class B implements A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override m() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements A{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate def B delegate(int i) {null}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.file(_builder.toString()), XtendPackage.Literals.XTEND_FUNCTION, "user.issue", "signature");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testInterfacesAreImplementedTransitively() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void m()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface B extends A{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void f()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements B {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override m() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override f() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class D implements B{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate C delegate");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this.file(_builder.toString()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testDuplicateInterfacesAreDetected() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void m()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface B extends A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void f()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface C extends A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void g()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class D implements B {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override m() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override f() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class E implements C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override m() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override f() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override g() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class F implements B,C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate D delegate1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate E delegate2");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.file(_builder.toString()), XtendPackage.Literals.XTEND_FIELD, "user.issue", "interface A", "also implemented");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testIgnoreNonDelegates() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void m()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class B implements A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override m() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override m() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class F implements A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate B delegate");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("C notADelegate");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoErrors(this.file(_builder.toString()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testIgnoreInterfacesNotDeclaredOnTargetClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void m()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface B {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void f()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements A, B {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override m() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override f() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class D implements A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate C delegate");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        final Function1<Method, Boolean> _function_1 = (Method it_1) -> {
          String _name = it_1.getName();
          return Boolean.valueOf(Objects.equals(_name, "f"));
        };
        Assert.assertFalse(IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(it.getCompiledClass().getDeclaredMethods())), _function_1));
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
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void m()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class B implements A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override m() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements A{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate val delegate = new B");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.file(_builder.toString()), XtendPackage.Literals.XTEND_FIELD, "user.issue", "inferred");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testListedInterfaceNotImplemented() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void m()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface B {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void f()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override m() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class D implements A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate(#[A, B]) C delegate");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final XtendFile file = this.file(_builder.toString());
      this._validationTestHelper.assertError(file, XtendPackage.Literals.XTEND_FIELD, "user.issue", "C", "does not implement", "B");
      this._validationTestHelper.assertError(file, XtendPackage.Literals.XTEND_FIELD, "user.issue", "D", "does not implement", "B");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testExplicitInterfaceListing() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void m()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface B {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void f()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements A, B {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override m() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override f() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class D implements A, B {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override m() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override f() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class E implements A, B{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate(#[A]) C delegate1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate(#[B]) D delegate2");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertNoIssues(this.file(_builder.toString()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testNoCommonInterfaces() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void m()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class B {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements A{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate B delegate");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.file(_builder.toString()), XtendPackage.Literals.XTEND_FIELD, "user.issue", "common", "interface");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testObjectMethodsAreIgnored() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override int hashCode()");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override boolean equals(Object other)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override String toString()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class B implements A {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements A{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate B delegate");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        final Function1<Method, Boolean> _function_1 = (Method it_1) -> {
          String _simpleName = it_1.getDeclaringClass().getSimpleName();
          return Boolean.valueOf(Objects.equals(_simpleName, "A"));
        };
        Assert.assertTrue(IterableExtensions.<Method>forall(((Iterable<Method>)Conversions.doWrapArray(it.getCompiledClass().getDeclaredMethods())), _function_1));
      };
      this.compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testObjectMethodsAreIgnored2() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override Object clone() throws CloneNotSupportedException");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override void finalize() throws Throwable");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class B implements A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override clone() throws CloneNotSupportedException {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super.clone");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override finalize() throws Throwable {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super.finalize");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate B delegate");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("import org.eclipse.xtend.lib.annotations.Delegate;");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("@SuppressWarnings(\"all\")");
        _builder_1.newLine();
        _builder_1.append("public class C implements A {");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("@Delegate");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("private B delegate;");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        Assert.assertEquals(
          _builder_1.toString(), it.getGeneratedCode("C"));
      };
      this.compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testGenericInterface() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface I<T, U extends T, E extends Throwable> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <V extends T> T foo(U foo, V bar) throws E");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class B implements I<CharSequence, String, Exception> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override <V extends CharSequence> foo(String foo, V bar) throws Exception {foo}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements I<CharSequence, String, Exception> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate(#[I]) B delegate = new B");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      this._validationTestHelper.assertNoIssues(this.file(text));
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          Assert.assertTrue(it.getGeneratedCode("C"), it.getGeneratedCode("C").contains("<V extends CharSequence> CharSequence foo(final String foo, final V bar) throws Exception"));
          final Object instance = it.getCompiledClass("C").getDeclaredConstructor().newInstance();
          final Method method = it.getCompiledClass("C").getDeclaredMethod("foo", String.class, CharSequence.class);
          Assert.assertEquals("bar", method.invoke(instance, "bar", "bar"));
          Assert.assertEquals(Exception.class, IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(method.getExceptionTypes()))));
          Assert.assertEquals(CharSequence.class, method.getReturnType());
          Assert.assertEquals(String.class, IterableExtensions.<Object>head(((Iterable<Object>)Conversions.doWrapArray(method.getParameterTypes()))));
          Assert.assertEquals(CharSequence.class, method.getParameterTypes()[1]);
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
  public void testGenericInterfaceAndClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface I<T> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def T foo(T foo)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class B<X> implements I<X> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override X foo(X foo) {foo}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C<Y extends CharSequence> implements I<Y> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate B<Y> delegate = new B<Y>");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      this._validationTestHelper.assertNoIssues(this.file(text));
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          Assert.assertTrue(it.getGeneratedCode("C").contains("Y foo(final Y foo)"));
          final Object instance = it.getCompiledClass("C").getDeclaredConstructor().newInstance();
          final Method method = it.getCompiledClass("C").getDeclaredMethod("foo", CharSequence.class);
          Assert.assertEquals("bar", method.invoke(instance, "bar"));
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
  public void testGenericSignatureNotMatching() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface I<T> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def T foo(T foo)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class B implements I<Integer> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override Integer foo(Integer foo) {1}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements I<String> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate B delegate");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertError(this.file(_builder.toString()), XtendPackage.Literals.XTEND_FIELD, "user.issue", "no", "common", "interfaces");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testMethodAlreadyDefined() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface I<T> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def T foo(T foo)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class B implements I<String> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override String foo(String foo) {\"\"}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements I<String> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate B delegate");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override String foo(String foo) {\"\"}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      this._validationTestHelper.assertWarning(this.file(_builder.toString()), XtendPackage.Literals.XTEND_FIELD, IssueCodes.UNUSED_PRIVATE_MEMBER, "delegate");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void implementingListSmokeTest() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("import java.util.List");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class DelegatingList<T> implements List<T>{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate List<T> delegate");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      this._validationTestHelper.assertNoIssues(this.file(text));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void recursiveGenerics() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <T extends Comparable<T>> T foo(T t)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Bar implements Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate Bar bar");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      this._validationTestHelper.assertNoIssues(this.file(text));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testStaticMethodsInInterfaces() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("import testdata.InterfaceWithStaticMethod");
      _builder.newLine();
      _builder.append("class Bar implements InterfaceWithStaticMethod {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate InterfaceWithStaticMethod delegate");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      this._validationTestHelper.assertNoIssues(this.file(text));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void genericsWithLowerBound() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface Matcher<T> {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("interface Matchers {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def <T> Matcher<T> both(Matcher<? super T> first, Matcher<? super T> second)");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Foo implements Matchers {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate Matchers delegate");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      this._validationTestHelper.assertNoIssues(this.file(text));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void noStackOverflowOnRecursiveSuperTypes() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("class Foo extends Bar {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Bar extends Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate Bar b");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      this.file(text);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void methodOrder() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Delegate");
      _builder.newLine();
      _builder.append("interface A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void c()");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void a()");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void b()");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class C implements A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Delegate A a");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      this._validationTestHelper.assertNoIssues(this.file(text));
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("import org.eclipse.xtend.lib.annotations.Delegate;");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("@SuppressWarnings(\"all\")");
        _builder_1.newLine();
        _builder_1.append("public class C implements A {");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("@Delegate");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("private A a;");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public void a() {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("this.a.a();");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public void b() {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("this.a.b();");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public void c() {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("this.a.c();");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        Assert.assertEquals(_builder_1.toString(), it.getGeneratedCode("C"));
      };
      this.compilationTestHelper.compile(text, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

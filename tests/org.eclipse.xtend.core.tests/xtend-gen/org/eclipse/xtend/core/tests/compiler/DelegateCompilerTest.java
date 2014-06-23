/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler;

import com.google.common.base.Objects;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest;
import org.eclipse.xtend.core.xtend.XtendFile;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
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
public class DelegateCompilerTest extends AbstractXtendCompilerTest {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testDelegateField() {
    try {
      StringConcatenation _builder = new StringConcatenation();
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
      XtendFile _file = this.file(text);
      this._validationTestHelper.assertNoIssues(_file);
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          Class<?> _compiledClass = it.getCompiledClass();
          Method[] _declaredMethods = _compiledClass.getDeclaredMethods();
          final Function1<Method, Boolean> _function = new Function1<Method, Boolean>() {
            public Boolean apply(final Method it) {
              boolean _and = false;
              boolean _and_1 = false;
              String _name = it.getName();
              boolean _equals = Objects.equal(_name, "m");
              if (!_equals) {
                _and_1 = false;
              } else {
                Class<?>[] _parameterTypes = it.getParameterTypes();
                boolean _isEmpty = ((List<Class<?>>)Conversions.doWrapArray(_parameterTypes)).isEmpty();
                _and_1 = _isEmpty;
              }
              if (!_and_1) {
                _and = false;
              } else {
                Class<?> _returnType = it.getReturnType();
                boolean _equals_1 = Objects.equal(_returnType, void.class);
                _and = _equals_1;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists = IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(_declaredMethods)), _function);
          Assert.assertTrue(_exists);
        }
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
      XtendFile _file = this.file(text);
      this._validationTestHelper.assertNoIssues(_file);
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          Class<?> _compiledClass = it.getCompiledClass();
          Method[] _declaredMethods = _compiledClass.getDeclaredMethods();
          final Function1<Method, Boolean> _function = new Function1<Method, Boolean>() {
            public Boolean apply(final Method it) {
              boolean _and = false;
              boolean _and_1 = false;
              String _name = it.getName();
              boolean _equals = Objects.equal(_name, "m");
              if (!_equals) {
                _and_1 = false;
              } else {
                Class<?>[] _parameterTypes = it.getParameterTypes();
                boolean _isEmpty = ((List<Class<?>>)Conversions.doWrapArray(_parameterTypes)).isEmpty();
                _and_1 = _isEmpty;
              }
              if (!_and_1) {
                _and = false;
              } else {
                Class<?> _returnType = it.getReturnType();
                boolean _equals_1 = Objects.equal(_returnType, int.class);
                _and = _equals_1;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists = IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(_declaredMethods)), _function);
          Assert.assertTrue(_exists);
        }
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
      XtendFile _file = this.file(text);
      this._validationTestHelper.assertNoIssues(_file);
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          Class<?> _compiledClass = it.getCompiledClass();
          Method[] _declaredMethods = _compiledClass.getDeclaredMethods();
          final Function1<Method, Boolean> _function = new Function1<Method, Boolean>() {
            public Boolean apply(final Method it) {
              boolean _and = false;
              boolean _and_1 = false;
              String _name = it.getName();
              boolean _equals = Objects.equal(_name, "m");
              if (!_equals) {
                _and_1 = false;
              } else {
                Class<?>[] _parameterTypes = it.getParameterTypes();
                List<Class<?>> _list = IterableExtensions.<Class<?>>toList(((Iterable<Class<?>>)Conversions.doWrapArray(_parameterTypes)));
                boolean _equals_1 = Objects.equal(_list, Collections.<Class<?>>unmodifiableList(Lists.<Class<?>>newArrayList(String.class, Object.class)));
                _and_1 = _equals_1;
              }
              if (!_and_1) {
                _and = false;
              } else {
                Class<?> _returnType = it.getReturnType();
                boolean _equals_2 = Objects.equal(_returnType, void.class);
                _and = _equals_2;
              }
              return Boolean.valueOf(_and);
            }
          };
          boolean _exists = IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(_declaredMethods)), _function);
          Assert.assertTrue(_exists);
        }
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
      XtendFile _file = this.file(text);
      this._validationTestHelper.assertNoIssues(_file);
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          Class<?> _compiledClass = it.getCompiledClass();
          Method[] _declaredMethods = _compiledClass.getDeclaredMethods();
          final Function1<Method, Boolean> _function = new Function1<Method, Boolean>() {
            public Boolean apply(final Method it) {
              String _name = it.getName();
              return Boolean.valueOf(Objects.equal(_name, "m"));
            }
          };
          boolean _exists = IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(_declaredMethods)), _function);
          Assert.assertTrue(_exists);
        }
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
      XtendFile _file = this.file(text);
      this._validationTestHelper.assertNoIssues(_file);
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          Class<?> _compiledClass = it.getCompiledClass();
          Method[] _declaredMethods = _compiledClass.getDeclaredMethods();
          final Function1<Method, Boolean> _function = new Function1<Method, Boolean>() {
            public Boolean apply(final Method it) {
              String _name = it.getName();
              return Boolean.valueOf(Objects.equal(_name, "m"));
            }
          };
          boolean _exists = IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(_declaredMethods)), _function);
          Assert.assertTrue(_exists);
        }
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
      _builder.append("@Delegate def B delegate(String name, Object... args) {null}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      XtendFile _file = this.file(text);
      this._validationTestHelper.assertNoIssues(_file);
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          Class<?> _compiledClass = it.getCompiledClass();
          Method[] _declaredMethods = _compiledClass.getDeclaredMethods();
          final Function1<Method, Boolean> _function = new Function1<Method, Boolean>() {
            public Boolean apply(final Method it) {
              String _name = it.getName();
              return Boolean.valueOf(Objects.equal(_name, "m"));
            }
          };
          boolean _exists = IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(_declaredMethods)), _function);
          Assert.assertTrue(_exists);
        }
      };
      this.compilationTestHelper.compile(text, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDelegateMethodWithParameters() {
    try {
      StringConcatenation _builder = new StringConcatenation();
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
      _builder.append("@Delegate def B delegate(String name, Object... args) {null}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      XtendFile _file = this.file(text);
      this._validationTestHelper.assertNoIssues(_file);
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          Class<?> _compiledClass = it.getCompiledClass();
          Method[] _declaredMethods = _compiledClass.getDeclaredMethods();
          final Function1<Method, Boolean> _function = new Function1<Method, Boolean>() {
            public Boolean apply(final Method it) {
              String _name = it.getName();
              return Boolean.valueOf(Objects.equal(_name, "m"));
            }
          };
          boolean _exists = IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(_declaredMethods)), _function);
          Assert.assertTrue(_exists);
        }
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
      XtendFile _file = this.file(_builder.toString());
      this._validationTestHelper.assertError(_file, XtendPackage.Literals.XTEND_FUNCTION, "user.issue", "signature");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInterfacesAreImplementedTransitively() {
    try {
      StringConcatenation _builder = new StringConcatenation();
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
      XtendFile _file = this.file(_builder.toString());
      this._validationTestHelper.assertNoIssues(_file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testDuplicateInterfacesAreDetected() {
    try {
      StringConcatenation _builder = new StringConcatenation();
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
      XtendFile _file = this.file(_builder.toString());
      this._validationTestHelper.assertError(_file, XtendPackage.Literals.XTEND_FIELD, "user.issue", "interface A", "also implemented");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIgnoreNonDelegates() {
    try {
      StringConcatenation _builder = new StringConcatenation();
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
      XtendFile _file = this.file(_builder.toString());
      this._validationTestHelper.assertNoErrors(_file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testIgnoreInterfacesNotDeclaredOnTargetClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
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
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          Class<?> _compiledClass = it.getCompiledClass();
          Method[] _declaredMethods = _compiledClass.getDeclaredMethods();
          final Function1<Method, Boolean> _function = new Function1<Method, Boolean>() {
            public Boolean apply(final Method it) {
              String _name = it.getName();
              return Boolean.valueOf(Objects.equal(_name, "f"));
            }
          };
          boolean _exists = IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(_declaredMethods)), _function);
          Assert.assertFalse(_exists);
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
      XtendFile _file = this.file(_builder.toString());
      this._validationTestHelper.assertError(_file, XtendPackage.Literals.XTEND_FIELD, "user.issue", "inferred");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testListedInterfaceNotImplemented() {
    try {
      StringConcatenation _builder = new StringConcatenation();
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
      XtendFile _file = this.file(_builder.toString());
      this._validationTestHelper.assertNoIssues(_file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNoCommonInterfaces() {
    try {
      StringConcatenation _builder = new StringConcatenation();
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
      XtendFile _file = this.file(_builder.toString());
      this._validationTestHelper.assertError(_file, XtendPackage.Literals.XTEND_FIELD, "user.issue", "common", "interface");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testObjectMethodsAreIgnored() {
    try {
      StringConcatenation _builder = new StringConcatenation();
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
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          Class<?> _compiledClass = it.getCompiledClass();
          Method[] _declaredMethods = _compiledClass.getDeclaredMethods();
          final Function1<Method, Boolean> _function = new Function1<Method, Boolean>() {
            public Boolean apply(final Method it) {
              Class<?> _declaringClass = it.getDeclaringClass();
              String _simpleName = _declaringClass.getSimpleName();
              return Boolean.valueOf(Objects.equal(_simpleName, "A"));
            }
          };
          boolean _forall = IterableExtensions.<Method>forall(((Iterable<Method>)Conversions.doWrapArray(_declaredMethods)), _function);
          Assert.assertTrue(_forall);
        }
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
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("import org.eclipse.xtend.lib.Delegate;");
          _builder.newLine();
          _builder.newLine();
          _builder.append("@SuppressWarnings(\"all\")");
          _builder.newLine();
          _builder.append("public class C implements A {");
          _builder.newLine();
          _builder.append("  ");
          _builder.append("@Delegate");
          _builder.newLine();
          _builder.append("  ");
          _builder.append("private B delegate;");
          _builder.newLine();
          _builder.append("}");
          _builder.newLine();
          String _string = _builder.toString();
          String _generatedCode = it.getGeneratedCode("C");
          Assert.assertEquals(_string, _generatedCode);
        }
      };
      this.compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

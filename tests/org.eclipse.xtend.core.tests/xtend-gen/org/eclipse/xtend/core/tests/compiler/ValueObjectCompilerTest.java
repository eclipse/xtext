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
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest;
import org.eclipse.xtend.core.xtend.XtendClass;
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
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

@SuppressWarnings("all")
public class ValueObjectCompilerTest extends AbstractXtendCompilerTest {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testExistingValueObjectConstructor() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@ValueObject class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new (int foo) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("this.foo = foo * 2");
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
            Constructor<?> _declaredConstructor = _compiledClass.getDeclaredConstructor(int.class);
            final Object instance = _declaredConstructor.newInstance(Integer.valueOf(2));
            Class<?> _compiledClass_1 = it.getCompiledClass();
            final Method getFoo = _compiledClass_1.getDeclaredMethod("getFoo");
            Object _invoke = getFoo.invoke(instance);
            Assert.assertEquals(Integer.valueOf(4), _invoke);
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
  public void testInitializedField() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@ValueObject class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int foo = 2");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          try {
            Class<?> _compiledClass = it.getCompiledClass();
            Constructor<?> _declaredConstructor = _compiledClass.getDeclaredConstructor();
            final Object instance = _declaredConstructor.newInstance();
            Class<?> _compiledClass_1 = it.getCompiledClass();
            final Method getFoo = _compiledClass_1.getDeclaredMethod("getFoo");
            Object _invoke = getFoo.invoke(instance);
            Assert.assertEquals(Integer.valueOf(2), _invoke);
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
  public void testIgnoredFields() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@ValueObject class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("transient int foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def create {} ignoreMe() {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          try {
            Class<?> _compiledClass = it.getCompiledClass();
            _compiledClass.getDeclaredConstructor();
            Class<?> _compiledClass_1 = it.getCompiledClass();
            Method[] _declaredMethods = _compiledClass_1.getDeclaredMethods();
            final Function1<Method, Boolean> _function = new Function1<Method, Boolean>() {
              public Boolean apply(final Method it) {
                String _name = it.getName();
                return Boolean.valueOf(_name.startsWith("get"));
              }
            };
            boolean _exists = IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(_declaredMethods)), _function);
            Assert.assertFalse(_exists);
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
  public void testExistingGetter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@ValueObject class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def getFoo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("5");
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
            Constructor<?> _declaredConstructor = _compiledClass.getDeclaredConstructor(int.class);
            final Object instance = _declaredConstructor.newInstance(Integer.valueOf(2));
            Class<?> _compiledClass_1 = it.getCompiledClass();
            final Method getFoo = _compiledClass_1.getDeclaredMethod("getFoo");
            Object _invoke = getFoo.invoke(instance);
            Assert.assertEquals(Integer.valueOf(5), _invoke);
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
  public void testExistingToString() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@ValueObject class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override toString() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("\"5\"");
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
            Constructor<?> _declaredConstructor = _compiledClass.getDeclaredConstructor(int.class);
            final Object instance = _declaredConstructor.newInstance(Integer.valueOf(2));
            Class<?> _compiledClass_1 = it.getCompiledClass();
            final Method toString = _compiledClass_1.getDeclaredMethod("toString");
            Object _invoke = toString.invoke(instance);
            Assert.assertEquals("5", _invoke);
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
  public void testExistingEquals() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@ValueObject class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int foo");
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
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          try {
            Class<?> _compiledClass = it.getCompiledClass();
            Constructor<?> _declaredConstructor = _compiledClass.getDeclaredConstructor(int.class);
            final Object instance = _declaredConstructor.newInstance(Integer.valueOf(2));
            Class<?> _compiledClass_1 = it.getCompiledClass();
            final Method equals = _compiledClass_1.getDeclaredMethod("equals", Object.class);
            Object _invoke = equals.invoke(instance, Integer.valueOf(1));
            Assert.assertEquals(Boolean.valueOf(true), _invoke);
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
  public void testExistingHashCode() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@ValueObject class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int foo");
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
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          try {
            Class<?> _compiledClass = it.getCompiledClass();
            Constructor<?> _declaredConstructor = _compiledClass.getDeclaredConstructor(int.class);
            final Object instance = _declaredConstructor.newInstance(Integer.valueOf(2));
            Class<?> _compiledClass_1 = it.getCompiledClass();
            final Method hashCode = _compiledClass_1.getDeclaredMethod("hashCode");
            Object _invoke = hashCode.invoke(instance);
            Assert.assertEquals(Integer.valueOf(0), _invoke);
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
  public void testExistingMethodsNotMatchingExactly() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@ValueObject class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new(String bar) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("foo = 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def getFoo(String bar) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def toString(String bar) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("\"1\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def hashCode(String bar) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def equals(String bar) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("true");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def equals(Object foo, String bar) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("true");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          Class<?> _compiledClass = it.getCompiledClass();
          final Procedure1<Class<?>> _function = new Procedure1<Class<?>>() {
            public void apply(final Class<?> it) {
              try {
                it.getDeclaredConstructor(int.class);
                it.getDeclaredMethod("equals", Object.class);
                it.getDeclaredMethod("hashCode");
                it.getDeclaredMethod("toString");
                it.getDeclaredMethod("getFoo");
              } catch (Throwable _e) {
                throw Exceptions.sneakyThrow(_e);
              }
            }
          };
          ObjectExtensions.<Class<?>>operator_doubleArrow(_compiledClass, _function);
        }
      };
      this.compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Ignore
  @Test
  public void testWithCreateExtension() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@ValueObject class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def create {} foo() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      XtendClass _clazz = this.clazz(text);
      this._validationTestHelper.assertNoIssues(_clazz);
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          Class<?> _compiledClass = it.getCompiledClass();
          Method[] _declaredMethods = _compiledClass.getDeclaredMethods();
          final Function1<Method, Boolean> _function = new Function1<Method, Boolean>() {
            public Boolean apply(final Method it) {
              String _name = it.getName();
              return Boolean.valueOf(_name.startsWith("get"));
            }
          };
          boolean _exists = IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(_declaredMethods)), _function);
          Assert.assertFalse(_exists);
        }
      };
      this.compilationTestHelper.compile(text, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testInheritanceForbidden() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import java.util.ArrayList");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@ValueObject class Foo extends ArrayList{");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendClass _clazz = this.clazz(_builder.toString());
      this._validationTestHelper.assertError(_clazz, XtendPackage.Literals.XTEND_CLASS, "user.issue", "inheritance");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testValueObjectWithStaticField() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@ValueObject class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static int foo = 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          Class<?> _compiledClass = it.getCompiledClass();
          final Procedure1<Class<?>> _function = new Procedure1<Class<?>>() {
            public void apply(final Class<?> it) {
              Field[] _declaredFields = it.getDeclaredFields();
              final Function1<Field, Boolean> _function = new Function1<Field, Boolean>() {
                public Boolean apply(final Field it) {
                  String _name = it.getName();
                  return Boolean.valueOf(Objects.equal(_name, "foo"));
                }
              };
              boolean _exists = IterableExtensions.<Field>exists(((Iterable<Field>)Conversions.doWrapArray(_declaredFields)), _function);
              Assert.assertTrue(_exists);
              Method[] _declaredMethods = it.getDeclaredMethods();
              final Function1<Method, Boolean> _function_1 = new Function1<Method, Boolean>() {
                public Boolean apply(final Method it) {
                  String _name = it.getName();
                  return Boolean.valueOf(Objects.equal(_name, "getFoo"));
                }
              };
              boolean _exists_1 = IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(_declaredMethods)), _function_1);
              Assert.assertFalse(_exists_1);
              Constructor<?>[] _declaredConstructors = it.getDeclaredConstructors();
              final Function1<Constructor<?>, Boolean> _function_2 = new Function1<Constructor<?>, Boolean>() {
                public Boolean apply(final Constructor<?> it) {
                  Class<?>[] _parameterTypes = it.getParameterTypes();
                  int _length = _parameterTypes.length;
                  return Boolean.valueOf((_length == 0));
                }
              };
              boolean _exists_2 = IterableExtensions.<Constructor<?>>exists(((Iterable<Constructor<?>>)Conversions.doWrapArray(_declaredConstructors)), _function_2);
              Assert.assertTrue(_exists_2);
            }
          };
          ObjectExtensions.<Class<?>>operator_doubleArrow(_compiledClass, _function);
        }
      };
      this.compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testBooleanProperties() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("@ValueObject class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("boolean foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Boolean bar");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          Class<?> _compiledClass = it.getCompiledClass();
          final Procedure1<Class<?>> _function = new Procedure1<Class<?>>() {
            public void apply(final Class<?> it) {
              Field[] _declaredFields = it.getDeclaredFields();
              final Function1<Field, Boolean> _function = new Function1<Field, Boolean>() {
                public Boolean apply(final Field it) {
                  String _name = it.getName();
                  return Boolean.valueOf(Objects.equal(_name, "foo"));
                }
              };
              boolean _exists = IterableExtensions.<Field>exists(((Iterable<Field>)Conversions.doWrapArray(_declaredFields)), _function);
              Assert.assertTrue(_exists);
              Field[] _declaredFields_1 = it.getDeclaredFields();
              final Function1<Field, Boolean> _function_1 = new Function1<Field, Boolean>() {
                public Boolean apply(final Field it) {
                  String _name = it.getName();
                  return Boolean.valueOf(Objects.equal(_name, "bar"));
                }
              };
              boolean _exists_1 = IterableExtensions.<Field>exists(((Iterable<Field>)Conversions.doWrapArray(_declaredFields_1)), _function_1);
              Assert.assertTrue(_exists_1);
              Method[] _declaredMethods = it.getDeclaredMethods();
              final Function1<Method, Boolean> _function_2 = new Function1<Method, Boolean>() {
                public Boolean apply(final Method it) {
                  String _name = it.getName();
                  return Boolean.valueOf(Objects.equal(_name, "isFoo"));
                }
              };
              boolean _exists_2 = IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(_declaredMethods)), _function_2);
              Assert.assertTrue(_exists_2);
              Method[] _declaredMethods_1 = it.getDeclaredMethods();
              final Function1<Method, Boolean> _function_3 = new Function1<Method, Boolean>() {
                public Boolean apply(final Method it) {
                  String _name = it.getName();
                  return Boolean.valueOf(Objects.equal(_name, "isBar"));
                }
              };
              boolean _exists_3 = IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(_declaredMethods_1)), _function_3);
              Assert.assertTrue(_exists_3);
            }
          };
          ObjectExtensions.<Class<?>>operator_doubleArrow(_compiledClass, _function);
        }
      };
      this.compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

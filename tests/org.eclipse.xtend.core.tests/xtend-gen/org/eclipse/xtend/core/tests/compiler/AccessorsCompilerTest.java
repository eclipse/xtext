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
import java.lang.reflect.Modifier;
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
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class AccessorsCompilerTest extends AbstractXtendCompilerTest {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testCreateSingleGetter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Accessors int foo = 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          try {
            Class<?> _compiledClass = it.getCompiledClass();
            final Object instance = _compiledClass.newInstance();
            Class<?> _compiledClass_1 = it.getCompiledClass();
            final Method getFoo = _compiledClass_1.getDeclaredMethod("getFoo");
            Object _invoke = getFoo.invoke(instance);
            Assert.assertEquals(Integer.valueOf(1), _invoke);
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
  public void testCreateGenericGetter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
      _builder.newLine();
      _builder.append("class Foo<T> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Accessors T foo = null");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          try {
            String _singleGeneratedCode = it.getSingleGeneratedCode();
            boolean _contains = _singleGeneratedCode.contains("T getFoo");
            Assert.assertTrue(_contains);
            Class<?> _compiledClass = it.getCompiledClass();
            final Object instance = _compiledClass.newInstance();
            Class<?> _compiledClass_1 = it.getCompiledClass();
            final Method getFoo = _compiledClass_1.getDeclaredMethod("getFoo");
            Object _invoke = getFoo.invoke(instance);
            Assert.assertEquals(null, _invoke);
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
  public void testCreateStaticGetter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Accessors static int foo = 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          try {
            Class<?> _compiledClass = it.getCompiledClass();
            final Method getFoo = _compiledClass.getDeclaredMethod("getFoo");
            Object _invoke = getFoo.invoke(null);
            Assert.assertEquals(Integer.valueOf(1), _invoke);
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
  public void testCannotOverrideFinalGetter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
      _builder.newLine();
      _builder.append("class Fizz {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def final String getFoo() {\"foo\"}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Buzz extends Fizz {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Accessors String foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _file = this.file(_builder.toString());
      this._validationTestHelper.assertError(_file, XtendPackage.Literals.XTEND_FIELD, "user.issue", "final", "Fizz", "getFoo");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCannotOverrideWithConflictingReturnType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def String getFoo() {\"foo\"}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Bar extends Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Accessors int foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _file = this.file(_builder.toString());
      this._validationTestHelper.assertError(_file, XtendPackage.Literals.XTEND_FIELD, "user.issue", "incompatible", "Foo", "getFoo");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCanSpecializeReturnType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def CharSequence getFoo() {\"foo\"}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Bar extends Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Accessors String foo");
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
  public void testCreateSingleSetter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Accessors int foo");
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
      _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
      _builder.newLine();
      _builder.append("class Foo<T extends CharSequence> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Accessors T foo");
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
      _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Accessors static int foo");
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
  public void testCannotOverrideFinalSetter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def final void setFoo(String foo) {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Bar extends Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Accessors String foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _file = this.file(_builder.toString());
      this._validationTestHelper.assertError(_file, XtendPackage.Literals.XTEND_FIELD, "user.issue", "final", "Foo", "setFoo(String)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testCannotOverrideSetterWithIncompatibleReturnType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def Object setFoo(String foo) {null}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Bar extends Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Accessors String foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendFile _file = this.file(_builder.toString());
      this._validationTestHelper.assertError(_file, XtendPackage.Literals.XTEND_FIELD, "user.issue", "not void", "Foo", "setFoo(String)");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testNoErrorsOnOverloadedSetter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def Object setFoo(String foo) {null}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class Bar extends Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Accessors int foo");
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
  public void testSpecifyingVisiblity() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
      _builder.newLine();
      _builder.append("import static org.eclipse.xtend.lib.annotations.AccessorType.*");
      _builder.newLine();
      _builder.append("@Accessors(PROTECTED_GETTER, PROTECTED_SETTER)");
      _builder.newLine();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int a");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Accessors(PRIVATE_GETTER, PUBLIC_SETTER) int b");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Accessors(NONE) int c");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          Class<?> _compiledClass = it.getCompiledClass();
          final Procedure1<Class<?>> _function = new Procedure1<Class<?>>() {
            public void apply(final Class<?> it) {
              try {
                Method _declaredMethod = it.getDeclaredMethod("getA");
                int _modifiers = _declaredMethod.getModifiers();
                boolean _isProtected = Modifier.isProtected(_modifiers);
                Assert.assertTrue(_isProtected);
                Method _declaredMethod_1 = it.getDeclaredMethod("setA", int.class);
                int _modifiers_1 = _declaredMethod_1.getModifiers();
                boolean _isProtected_1 = Modifier.isProtected(_modifiers_1);
                Assert.assertTrue(_isProtected_1);
                Method _declaredMethod_2 = it.getDeclaredMethod("getB");
                int _modifiers_2 = _declaredMethod_2.getModifiers();
                boolean _isPrivate = Modifier.isPrivate(_modifiers_2);
                Assert.assertTrue(_isPrivate);
                Method _declaredMethod_3 = it.getDeclaredMethod("setB", int.class);
                int _modifiers_3 = _declaredMethod_3.getModifiers();
                boolean _isPublic = Modifier.isPublic(_modifiers_3);
                Assert.assertTrue(_isPublic);
                Method[] _declaredMethods = it.getDeclaredMethods();
                final Function1<Method, Boolean> _function = new Function1<Method, Boolean>() {
                  public Boolean apply(final Method it) {
                    String _name = it.getName();
                    return Boolean.valueOf(Objects.equal(_name, "getC"));
                  }
                };
                boolean _exists = IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(_declaredMethods)), _function);
                Assert.assertFalse(_exists);
                Method[] _declaredMethods_1 = it.getDeclaredMethods();
                final Function1<Method, Boolean> _function_1 = new Function1<Method, Boolean>() {
                  public Boolean apply(final Method it) {
                    String _name = it.getName();
                    return Boolean.valueOf(Objects.equal(_name, "setC"));
                  }
                };
                boolean _exists_1 = IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(_declaredMethods_1)), _function_1);
                Assert.assertFalse(_exists_1);
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
  
  @Test
  public void testIntegrationWithData() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder.newLine();
      _builder.append("import static org.eclipse.xtend.lib.annotations.AccessorType.*");
      _builder.newLine();
      _builder.append("@Accessors(PROTECTED_GETTER, PROTECTED_SETTER)");
      _builder.newLine();
      _builder.append("@Data");
      _builder.newLine();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int a");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          Class<?> _compiledClass = it.getCompiledClass();
          final Procedure1<Class<?>> _function = new Procedure1<Class<?>>() {
            public void apply(final Class<?> it) {
              try {
                Method _declaredMethod = it.getDeclaredMethod("getA");
                int _modifiers = _declaredMethod.getModifiers();
                boolean _isProtected = Modifier.isProtected(_modifiers);
                Assert.assertTrue(_isProtected);
                Method[] _declaredMethods = it.getDeclaredMethods();
                final Function1<Method, Boolean> _function = new Function1<Method, Boolean>() {
                  public Boolean apply(final Method it) {
                    String _name = it.getName();
                    return Boolean.valueOf(Objects.equal(_name, "setA"));
                  }
                };
                boolean _exists = IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(_declaredMethods)), _function);
                Assert.assertFalse(_exists);
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
}

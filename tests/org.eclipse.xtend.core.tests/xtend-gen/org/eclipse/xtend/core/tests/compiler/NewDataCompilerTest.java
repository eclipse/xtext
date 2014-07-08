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
import java.util.Collections;
import java.util.List;
import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest;
import org.eclipse.xtend.core.xtend.XtendClass;
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
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class NewDataCompilerTest extends AbstractXtendCompilerTest {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testDataClasses_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("import org.eclipse.xtend.lib.annotations.Data");
    _builder.newLine();
    _builder.append("@Data class Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("String name");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("boolean myFlag");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("java.lang.Iterable<? extends Foo> references");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtend.lib.annotations.Data;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Pure;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@Data");
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Foo {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private final String name;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private final boolean myFlag;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private final Iterable<? extends Foo> references;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Foo(final String name, final boolean myFlag, final Iterable<? extends Foo> references) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("super();");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this.name = name;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this.myFlag = myFlag;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this.references = references;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Pure");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public int hashCode() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("final int prime = 31;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("int result = 1;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("result = prime * result + (this.myFlag ? 1231 : 1237);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("result = prime * result + ((this.references== null) ? 0 : this.references.hashCode());");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return result;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Pure");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public boolean equals(final Object obj) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (this == obj)");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return true;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (obj == null)");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (getClass() != obj.getClass())");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("Foo other = (Foo) obj;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (this.name == null) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("if (other.name != null)");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("return false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else if (!this.name.equals(other.name))");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (other.myFlag != this.myFlag)");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("if (this.references == null) {");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("if (other.references != null)");
    _builder_1.newLine();
    _builder_1.append("        ");
    _builder_1.append("return false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("} else if (!this.references.equals(other.references))");
    _builder_1.newLine();
    _builder_1.append("      ");
    _builder_1.append("return false;");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return true;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Override");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Pure");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String toString() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("ToStringBuilder b = new ToStringBuilder(this);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("b.add(\"name\", this.name);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("b.add(\"myFlag\", this.myFlag);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("b.add(\"references\", this.references);");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return b.toString();");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Pure");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String getName() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.name;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Pure");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public boolean isMyFlag() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.myFlag;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Pure");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Iterable<? extends Foo> getReferences() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this.references;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testExistingDataConstructor() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder.newLine();
      _builder.append("@Data class Foo {");
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
  public void testExistingGetter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder.newLine();
      _builder.append("@Data class Foo {");
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
      _builder.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder.newLine();
      _builder.append("@Data class Foo {");
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
      _builder.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder.newLine();
      _builder.append("@Data class Foo {");
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
      _builder.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder.newLine();
      _builder.append("@Data class Foo {");
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
      _builder.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder.newLine();
      _builder.append("@Data class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int foo");
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
  
  @Test
  public void testWithCreateExtension() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder.newLine();
      _builder.append("@Data class Foo {");
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
  public void testDataClassWithStaticField() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder.newLine();
      _builder.append("@Data class Foo {");
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
      _builder.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder.newLine();
      _builder.append("@Data class Foo {");
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
  
  @Test
  public void testParametrizedSuperConstructor() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder.newLine();
      _builder.append("@Data class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("@Data class Bar extends Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String bar");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          Class<?> _compiledClass = it.getCompiledClass("Bar");
          final Procedure1<Class<?>> _function = new Procedure1<Class<?>>() {
            public void apply(final Class<?> it) {
              Constructor<?>[] _declaredConstructors = it.getDeclaredConstructors();
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
          ObjectExtensions.<Class<?>>operator_doubleArrow(_compiledClass, _function);
        }
      };
      this.compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testSuperClassWithTypeParameters() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder.newLine();
      _builder.append("@Data class Foo<T> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("T foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("@Data class Bar extends Foo<String> {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          String _generatedCode = it.getGeneratedCode("Bar");
          boolean _contains = _generatedCode.contains("public Bar(final String foo) {");
          Assert.assertTrue(_contains);
        }
      };
      this.compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void testClassAndSuperClassWithTypeParameters() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder.newLine();
      _builder.append("@Data class Foo<T> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("T foo");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("@Data class Bar<X> extends Foo<X> {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          String _generatedCode = it.getGeneratedCode("Bar");
          boolean _contains = _generatedCode.contains("public Bar(final X foo) {");
          Assert.assertTrue(_contains);
        }
      };
      this.compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

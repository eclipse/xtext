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
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
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
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
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
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private final boolean myFlag;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private final Iterable<? extends Foo> references;");
    _builder_1.newLine();
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
    _builder_1.append("return prime * result + ((this.references== null) ? 0 : this.references.hashCode());");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
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
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Object instance = it.getCompiledClass().getDeclaredConstructor(int.class).newInstance(Integer.valueOf(2));
          final Method getFoo = it.getCompiledClass().getDeclaredMethod("getFoo");
          Assert.assertEquals(Integer.valueOf(4), getFoo.invoke(instance));
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
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
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Object instance = it.getCompiledClass().getDeclaredConstructor(int.class).newInstance(Integer.valueOf(2));
          final Method getFoo = it.getCompiledClass().getDeclaredMethod("getFoo");
          Assert.assertEquals(Integer.valueOf(5), getFoo.invoke(instance));
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      this.compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testExistingGetter2() {
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
      _builder.append("def getFoo() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("true");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Object instance = it.getCompiledClass().getDeclaredConstructor(boolean.class).newInstance(Boolean.valueOf(false));
          final Method getFoo = it.getCompiledClass().getDeclaredMethod("getFoo");
          Assert.assertEquals(Boolean.valueOf(true), getFoo.invoke(instance));
          final Function1<Method, Boolean> _function_1 = (Method it_1) -> {
            String _name = it_1.getName();
            return Boolean.valueOf(Objects.equals(_name, "isFoo"));
          };
          Assert.assertFalse(IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(it.getCompiledClass().getDeclaredMethods())), _function_1));
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
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
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Object instance = it.getCompiledClass().getDeclaredConstructor(int.class).newInstance(Integer.valueOf(2));
          final Method toString = it.getCompiledClass().getDeclaredMethod("toString");
          Assert.assertEquals("5", toString.invoke(instance));
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
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
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Object instance = it.getCompiledClass().getDeclaredConstructor(int.class).newInstance(Integer.valueOf(2));
          final Method equals = it.getCompiledClass().getDeclaredMethod("equals", Object.class);
          Assert.assertEquals(Boolean.valueOf(true), equals.invoke(instance, Integer.valueOf(1)));
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
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
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Object instance = it.getCompiledClass().getDeclaredConstructor(int.class).newInstance(Integer.valueOf(2));
          final Method hashCode = it.getCompiledClass().getDeclaredMethod("hashCode");
          Assert.assertEquals(Integer.valueOf(0), hashCode.invoke(instance));
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
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
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        Class<?> _compiledClass = it.getCompiledClass();
        final Procedure1<Class<?>> _function_1 = (Class<?> it_1) -> {
          try {
            it_1.getDeclaredConstructor(int.class);
            it_1.getDeclaredMethod("equals", Object.class);
            it_1.getDeclaredMethod("hashCode");
            it_1.getDeclaredMethod("toString");
            it_1.getDeclaredMethod("getFoo");
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        };
        ObjectExtensions.<Class<?>>operator_doubleArrow(_compiledClass, _function_1);
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
      this._validationTestHelper.assertNoIssues(this.clazz(text));
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        final Function1<Method, Boolean> _function_1 = (Method it_1) -> {
          return Boolean.valueOf(it_1.getName().startsWith("get"));
        };
        Assert.assertFalse(IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(it.getCompiledClass().getDeclaredMethods())), _function_1));
      };
      this.compilationTestHelper.compile(text, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testVariable() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder.newLine();
      _builder.append("@Data class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var foo = 3");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      this._validationTestHelper.assertError(this.clazz(text), XtendPackage.Literals.XTEND_FIELD, "user.issue", "\'var\'");
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
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        Class<?> _compiledClass = it.getCompiledClass();
        final Procedure1<Class<?>> _function_1 = (Class<?> it_1) -> {
          final Function1<Field, Boolean> _function_2 = (Field it_2) -> {
            String _name = it_2.getName();
            return Boolean.valueOf(Objects.equals(_name, "foo"));
          };
          Assert.assertTrue(IterableExtensions.<Field>exists(((Iterable<Field>)Conversions.doWrapArray(it_1.getDeclaredFields())), _function_2));
          final Function1<Method, Boolean> _function_3 = (Method it_2) -> {
            String _name = it_2.getName();
            return Boolean.valueOf(Objects.equals(_name, "getFoo"));
          };
          Assert.assertFalse(IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(it_1.getDeclaredMethods())), _function_3));
          final Function1<Constructor<?>, Boolean> _function_4 = (Constructor<?> it_2) -> {
            int _length = it_2.getParameterTypes().length;
            return Boolean.valueOf((_length == 0));
          };
          Assert.assertTrue(IterableExtensions.<Constructor<?>>exists(((Iterable<Constructor<?>>)Conversions.doWrapArray(it_1.getDeclaredConstructors())), _function_4));
        };
        ObjectExtensions.<Class<?>>operator_doubleArrow(_compiledClass, _function_1);
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
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        Class<?> _compiledClass = it.getCompiledClass();
        final Procedure1<Class<?>> _function_1 = (Class<?> it_1) -> {
          final Function1<Field, Boolean> _function_2 = (Field it_2) -> {
            String _name = it_2.getName();
            return Boolean.valueOf(Objects.equals(_name, "foo"));
          };
          Assert.assertTrue(IterableExtensions.<Field>exists(((Iterable<Field>)Conversions.doWrapArray(it_1.getDeclaredFields())), _function_2));
          final Function1<Field, Boolean> _function_3 = (Field it_2) -> {
            String _name = it_2.getName();
            return Boolean.valueOf(Objects.equals(_name, "bar"));
          };
          Assert.assertTrue(IterableExtensions.<Field>exists(((Iterable<Field>)Conversions.doWrapArray(it_1.getDeclaredFields())), _function_3));
          final Function1<Method, Boolean> _function_4 = (Method it_2) -> {
            String _name = it_2.getName();
            return Boolean.valueOf(Objects.equals(_name, "isFoo"));
          };
          Assert.assertTrue(IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(it_1.getDeclaredMethods())), _function_4));
          final Function1<Method, Boolean> _function_5 = (Method it_2) -> {
            String _name = it_2.getName();
            return Boolean.valueOf(Objects.equals(_name, "getBar"));
          };
          Assert.assertTrue(IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(it_1.getDeclaredMethods())), _function_5));
        };
        ObjectExtensions.<Class<?>>operator_doubleArrow(_compiledClass, _function_1);
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
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        Class<?> _compiledClass = it.getCompiledClass("Bar");
        final Procedure1<Class<?>> _function_1 = (Class<?> it_1) -> {
          final Function1<Constructor<?>, Boolean> _function_2 = (Constructor<?> it_2) -> {
            List<Class<?>> _list = IterableExtensions.<Class<?>>toList(((Iterable<Class<?>>)Conversions.doWrapArray(it_2.getParameterTypes())));
            return Boolean.valueOf(Objects.equals(_list, Collections.<Class<? extends Object>>unmodifiableList(CollectionLiterals.<Class<? extends Object>>newArrayList(int.class, String.class))));
          };
          Assert.assertTrue(IterableExtensions.<Constructor<?>>exists(((Iterable<Constructor<?>>)Conversions.doWrapArray(it_1.getDeclaredConstructors())), _function_2));
        };
        ObjectExtensions.<Class<?>>operator_doubleArrow(_compiledClass, _function_1);
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
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        Assert.assertTrue(it.getGeneratedCode("Bar").contains("public Bar(final String foo) {"));
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
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        Assert.assertTrue(it.getGeneratedCode("Bar").contains("public Bar(final X foo) {"));
      };
      this.compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void testBug449185() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder.newLine();
      _builder.append("@Data class A {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Data class C extends A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val int c");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Data class B {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val int b");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Data class D extends B {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val double d");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        final Class<?> d = it.getCompiledClass("D");
        final Class<?>[] parameterTypes = IterableExtensions.<Constructor<?>>head(((Iterable<Constructor<?>>)Conversions.doWrapArray(d.getDeclaredConstructors()))).getParameterTypes();
        Assert.assertArrayEquals(new Object[] { int.class, double.class }, parameterTypes);
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
      _builder.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("@Data class Bar extends Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String bar = \"Foo\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        Assert.assertFalse(it.getGeneratedCode("Bar"), it.getGeneratedCode("Bar").contains("super.equals"));
        Assert.assertFalse(it.getGeneratedCode("Bar").contains("super.hashCode"));
      };
      this.compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

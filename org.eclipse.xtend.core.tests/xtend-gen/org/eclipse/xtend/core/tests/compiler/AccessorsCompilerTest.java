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
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Objects;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
import org.eclipse.xtext.xbase.validation.IssueCodes;
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
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Object instance = it.getCompiledClass().getDeclaredConstructor().newInstance();
          final Method getFoo = it.getCompiledClass().getDeclaredMethod("getFoo");
          Assert.assertEquals(Integer.valueOf(1), getFoo.invoke(instance));
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
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          Assert.assertTrue(it.getSingleGeneratedCode().contains("T getFoo"));
          final Object instance = it.getCompiledClass().getDeclaredConstructor().newInstance();
          final Method getFoo = it.getCompiledClass().getDeclaredMethod("getFoo");
          Assert.assertEquals(null, getFoo.invoke(instance));
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
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Method getFoo = it.getCompiledClass().getDeclaredMethod("getFoo");
          Assert.assertEquals(Integer.valueOf(1), getFoo.invoke(null));
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
      final String source = _builder.toString();
      this._validationTestHelper.assertError(this.file(source), XtendPackage.Literals.XTEND_FIELD, IssueCodes.OVERRIDDEN_FINAL, 
        source.lastIndexOf("foo"), "foo".length(), 
        "final", "getFoo");
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
      final String source = _builder.toString();
      this._validationTestHelper.assertError(this.file(source), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INCOMPATIBLE_RETURN_TYPE, 
        source.indexOf("int"), "int".length(), 
        "incompatible", "getFoo");
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
      this._validationTestHelper.assertNoErrors(this.file(_builder.toString()));
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
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Object instance = it.getCompiledClass().getDeclaredConstructor().newInstance();
          final Method setFoo = it.getCompiledClass().getDeclaredMethod("setFoo", int.class);
          Field _declaredField = it.getCompiledClass().getDeclaredField("foo");
          final Procedure1<Field> _function_1 = (Field it_1) -> {
            it_1.setAccessible(true);
          };
          final Field fooField = ObjectExtensions.<Field>operator_doubleArrow(_declaredField, _function_1);
          setFoo.invoke(instance, Integer.valueOf(1));
          Assert.assertEquals(Integer.valueOf(1), fooField.get(instance));
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
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          Assert.assertTrue(it.getSingleGeneratedCode().contains("setFoo(final T foo)"));
          final Object instance = it.getCompiledClass().getDeclaredConstructor().newInstance();
          final Method setFoo = it.getCompiledClass().getDeclaredMethod("setFoo", CharSequence.class);
          Field _declaredField = it.getCompiledClass().getDeclaredField("foo");
          final Procedure1<Field> _function_1 = (Field it_1) -> {
            it_1.setAccessible(true);
          };
          final Field fooField = ObjectExtensions.<Field>operator_doubleArrow(_declaredField, _function_1);
          setFoo.invoke(instance, "bar");
          Assert.assertEquals("bar", fooField.get(instance));
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
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Method setFoo = it.getCompiledClass().getDeclaredMethod("setFoo", int.class);
          Field _declaredField = it.getCompiledClass().getDeclaredField("foo");
          final Procedure1<Field> _function_1 = (Field it_1) -> {
            it_1.setAccessible(true);
          };
          final Field fooField = ObjectExtensions.<Field>operator_doubleArrow(_declaredField, _function_1);
          setFoo.invoke(null, Integer.valueOf(1));
          Assert.assertEquals(Integer.valueOf(1), fooField.get(null));
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
      final String source = _builder.toString();
      this._validationTestHelper.assertError(this.file(source), XtendPackage.Literals.XTEND_FIELD, IssueCodes.OVERRIDDEN_FINAL, 
        source.lastIndexOf("foo"), "foo".length(), 
        "setFoo(String)", "final");
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
      final String source = _builder.toString();
      this._validationTestHelper.assertError(this.file(source), XtendPackage.Literals.XTEND_FIELD, IssueCodes.INCOMPATIBLE_RETURN_TYPE, 
        source.lastIndexOf("String"), "String".length(), 
        "setFoo(String)", "incompatible");
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
      this._validationTestHelper.assertNoErrors(this.file(_builder.toString()));
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
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        Class<?> _compiledClass = it.getCompiledClass();
        final Procedure1<Class<?>> _function_1 = (Class<?> it_1) -> {
          try {
            Assert.assertTrue(Modifier.isProtected(it_1.getDeclaredMethod("getA").getModifiers()));
            Assert.assertTrue(Modifier.isProtected(it_1.getDeclaredMethod("setA", int.class).getModifiers()));
            Assert.assertTrue(Modifier.isPrivate(it_1.getDeclaredMethod("getB").getModifiers()));
            Assert.assertTrue(Modifier.isPublic(it_1.getDeclaredMethod("setB", int.class).getModifiers()));
            final Function1<Method, Boolean> _function_2 = (Method it_2) -> {
              String _name = it_2.getName();
              return Boolean.valueOf(Objects.equals(_name, "getC"));
            };
            Assert.assertFalse(IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(it_1.getDeclaredMethods())), _function_2));
            final Function1<Method, Boolean> _function_3 = (Method it_2) -> {
              String _name = it_2.getName();
              return Boolean.valueOf(Objects.equals(_name, "setC"));
            };
            Assert.assertFalse(IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(it_1.getDeclaredMethods())), _function_3));
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
  public void testSpecifyingVisiblityNoStaticImport() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
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
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        Class<?> _compiledClass = it.getCompiledClass();
        final Procedure1<Class<?>> _function_1 = (Class<?> it_1) -> {
          try {
            Assert.assertTrue(Modifier.isProtected(it_1.getDeclaredMethod("getA").getModifiers()));
            Assert.assertTrue(Modifier.isProtected(it_1.getDeclaredMethod("setA", int.class).getModifiers()));
            Assert.assertTrue(Modifier.isPrivate(it_1.getDeclaredMethod("getB").getModifiers()));
            Assert.assertTrue(Modifier.isPublic(it_1.getDeclaredMethod("setB", int.class).getModifiers()));
            final Function1<Method, Boolean> _function_2 = (Method it_2) -> {
              String _name = it_2.getName();
              return Boolean.valueOf(Objects.equals(_name, "getC"));
            };
            Assert.assertFalse(IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(it_1.getDeclaredMethods())), _function_2));
            final Function1<Method, Boolean> _function_3 = (Method it_2) -> {
              String _name = it_2.getName();
              return Boolean.valueOf(Objects.equals(_name, "setC"));
            };
            Assert.assertFalse(IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(it_1.getDeclaredMethods())), _function_3));
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
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        Class<?> _compiledClass = it.getCompiledClass();
        final Procedure1<Class<?>> _function_1 = (Class<?> it_1) -> {
          try {
            Assert.assertTrue(Modifier.isProtected(it_1.getDeclaredMethod("getA").getModifiers()));
            final Function1<Method, Boolean> _function_2 = (Method it_2) -> {
              String _name = it_2.getName();
              return Boolean.valueOf(Objects.equals(_name, "setA"));
            };
            Assert.assertFalse(IterableExtensions.<Method>exists(((Iterable<Method>)Conversions.doWrapArray(it_1.getDeclaredMethods())), _function_2));
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
}

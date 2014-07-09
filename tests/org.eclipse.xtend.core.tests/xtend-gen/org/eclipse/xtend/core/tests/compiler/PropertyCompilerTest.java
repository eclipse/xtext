/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler;

import com.google.inject.Inject;
import java.lang.reflect.Method;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend.core.xtend.XtendMember;
import org.eclipse.xtend.core.xtend.XtendPackage;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.compiler.GeneratorConfig;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class PropertyCompilerTest extends AbstractXtendCompilerTest {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testBug438347_01() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Property var (T)=>void s");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtend.lib.Property;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Pure;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C<T extends Object> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Property");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private Procedure1<? super T> _s;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Pure");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Procedure1<? super T> getS() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this._s;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void setS(final Procedure1<? super T> s) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this._s = s;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testBug438347_02() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Property var (String)=>void s");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtend.lib.Property;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Pure;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Property");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private Procedure1<? super String> _s;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Pure");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public Procedure1<? super String> getS() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this._s;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void setS(final Procedure1<? super String> s) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this._s = s;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void compileProperty() {
    final GeneratorConfig generatorConfig = this.generatorConfigProvider.get(null);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("package foo");
    _builder.newLine();
    _builder.newLine();
    _builder.append("class Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Property");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("boolean generateExpressions = true");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("package foo;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtend.lib.Property;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Pure;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class Bar {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Property");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private boolean _generateExpressions = true;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Pure");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public boolean isGenerateExpressions() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this._generateExpressions;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void setGenerateExpressions(final boolean generateExpressions) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this._generateExpressions = generateExpressions;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1, generatorConfig);
  }
  
  @Test
  public void compileReadonlyPropertyWithoutType() {
    try {
      final GeneratorConfig generatorConfig = this.generatorConfigProvider.get(null);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Property");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("val string = \'\'");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String source = _builder.toString();
      XtendClass _clazz = this.clazz(source);
      this._validationTestHelper.assertWarning(_clazz, XtendPackage.Literals.XTEND_FIELD, "user.issue", "inferred");
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("import org.eclipse.xtend.lib.Property;");
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtext.xbase.lib.Pure;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@SuppressWarnings(\"all\")");
      _builder_1.newLine();
      _builder_1.append("public class C {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("@Property");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("private final String _string = \"\";");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("@Pure");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public String getString() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return this._string;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      this.assertCompilesTo(source, _builder_1, generatorConfig);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void compilePropertyWithoutType() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Property");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var string = \'\'");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendClass _clazz = this.clazz(_builder.toString());
      EList<XtendMember> _members = _clazz.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      this._validationTestHelper.assertError(_head, XtendPackage.Literals.XTEND_FIELD, "user.issue", "inferred");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void compilePropertyWithTypeParameter() {
    final GeneratorConfig generatorConfig = this.generatorConfigProvider.get(null);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Property");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var T t");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtend.lib.Property;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Pure;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C<T extends Object> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Property");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private T _t;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Pure");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public T getT() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this._t;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void setT(final T t) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this._t = t;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1, generatorConfig);
  }
  
  @Test
  public void compilePropertyWithoutTypeButTypeParameter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class C<T> {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Property");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var iterable = null as Iterable<T>");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      XtendClass _clazz = this.clazz(_builder.toString());
      EList<XtendMember> _members = _clazz.getMembers();
      XtendMember _head = IterableExtensions.<XtendMember>head(_members);
      this._validationTestHelper.assertError(_head, XtendPackage.Literals.XTEND_FIELD, "user.issue", "inferred");
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  @Test
  public void compilePropertyWithArrayType() {
    final GeneratorConfig generatorConfig = this.generatorConfigProvider.get(null);
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class C<T> {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Property");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("var String[] array = #[\'a\']");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtend.lib.Property;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Pure;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class C<T extends Object> {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Property");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private String[] _array = { \"a\" };");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Pure");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String[] getArray() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this._array;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public void setArray(final String[] array) {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("this._array = array;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1, generatorConfig);
  }
  
  @Test
  public void compileExplicitProperty() {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("class X {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("@Property val String x = \'hello\'");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("import org.eclipse.xtend.lib.Property;");
    _builder_1.newLine();
    _builder_1.append("import org.eclipse.xtext.xbase.lib.Pure;");
    _builder_1.newLine();
    _builder_1.newLine();
    _builder_1.append("@SuppressWarnings(\"all\")");
    _builder_1.newLine();
    _builder_1.append("public class X {");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Property");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("private final String _x = \"hello\";");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("@Pure");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("public String getX() {");
    _builder_1.newLine();
    _builder_1.append("    ");
    _builder_1.append("return this._x;");
    _builder_1.newLine();
    _builder_1.append("  ");
    _builder_1.append("}");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    this.assertCompilesTo(_builder, _builder_1);
  }
  
  @Test
  public void testExistingGetter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Property int foo");
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
            final Object instance = _compiledClass.newInstance();
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
  public void testExistingSetter() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Property int foo");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def setFoo(int foo) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("_foo = 5");
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
            final Object instance = _compiledClass.newInstance();
            Class<?> _compiledClass_1 = it.getCompiledClass();
            final Method setFoo = _compiledClass_1.getDeclaredMethod("setFoo", int.class);
            setFoo.invoke(instance, Integer.valueOf(1));
            Class<?> _compiledClass_2 = it.getCompiledClass();
            final Method getFoo = _compiledClass_2.getDeclaredMethod("getFoo");
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
  public void testStaticProperty() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Property static int foo = 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          try {
            Class<?> _compiledClass = it.getCompiledClass();
            final Method setFoo = _compiledClass.getDeclaredMethod("setFoo", int.class);
            setFoo.invoke(null, Integer.valueOf(1));
            Class<?> _compiledClass_1 = it.getCompiledClass();
            final Method getFoo = _compiledClass_1.getDeclaredMethod("getFoo");
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
}

/**
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.tests.compiler;

import com.google.inject.Inject;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.validation.ValidationTestHelper;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ToStringCompilerTest extends AbstractXtendCompilerTest {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;

  @Test
  public void testDefault() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.ToString");
      _builder.newLine();
      _builder.append("@ToString class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static String ignoreMe");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("transient String ignoreMe2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def create {} ignoreMe3() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int a = 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Object instance = it.getCompiledClass().getDeclaredConstructor().newInstance();
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("Foo [");
          _builder_1.newLine();
          _builder_1.append("  ");
          _builder_1.append("a = 1");
          _builder_1.newLine();
          _builder_1.append("]");
          Assert.assertEquals(Strings.toUnixLineSeparator(_builder_1), instance.toString());
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
  public void testSingleLine() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.ToString");
      _builder.newLine();
      _builder.append("@ToString(singleLine=true) class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static String ignoreMe");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("transient String ignoreMe2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def create {} ignoreMe3() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int a = 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Object instance = it.getCompiledClass().getDeclaredConstructor().newInstance();
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("Foo [a = 1]");
          Assert.assertEquals(Strings.toUnixLineSeparator(_builder_1), instance.toString());
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
  public void testHideFieldNames() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.ToString");
      _builder.newLine();
      _builder.append("@ToString(singleLine=true, hideFieldNames = true) class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static String ignoreMe");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("transient String ignoreMe2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def create {} ignoreMe3() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int a = 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Object instance = it.getCompiledClass().getDeclaredConstructor().newInstance();
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("Foo [1]");
          Assert.assertEquals(Strings.toUnixLineSeparator(_builder_1), instance.toString());
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
  public void testVerbatimValues() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.ToString");
      _builder.newLine();
      _builder.append("@ToString(singleLine=true, verbatimValues = true) class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int[] a = #[1, 2, 3]");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Object instance = it.getCompiledClass().getDeclaredConstructor().newInstance();
          Assert.assertTrue(instance.toString().contains("[I@"));
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
  public void testSkipNulls() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.ToString");
      _builder.newLine();
      _builder.append("@ToString(skipNulls = true) class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("static String ignoreMe");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("transient String ignoreMe2");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def create {} ignoreMe3() {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("Integer b = null");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Object instance = it.getCompiledClass().getDeclaredConstructor().newInstance();
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("Foo [");
          _builder_1.newLine();
          _builder_1.append("]");
          Assert.assertEquals(Strings.toUnixLineSeparator(_builder_1), instance.toString());
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
  public void testToStringWithSuperClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.ToString");
      _builder.newLine();
      _builder.append("class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int a = 1");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("@ToString class Bar extends Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String b = \"Bar\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Object instance = it.getCompiledClass("Bar").getDeclaredConstructor().newInstance();
          Assert.assertEquals(((("Bar [\n" + "  b = \"Bar\"\n") + "  a = 1\n") + "]"), instance.toString());
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
      _builder.append("import org.eclipse.xtend.lib.annotations.ToString");
      _builder.newLine();
      _builder.append("@ToString class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("int a = 1");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("override toString() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("\"foo\"");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final String text = _builder.toString();
      this._validationTestHelper.assertWarning(this.clazz(text), XAnnotationsPackage.Literals.XANNOTATION, "user.issue", "no effect");
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Object instance = it.getCompiledClass().getDeclaredConstructor().newInstance();
          Assert.assertEquals("foo", instance.toString());
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
  public void testIntegrationWithData() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import org.eclipse.xtend.lib.annotations.ToString");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.annotations.Data");
      _builder.newLine();
      _builder.append("@ToString(hideFieldNames=true) @Data class Foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("String b = \"Bar\"");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
        try {
          final Object instance = it.getCompiledClass().getDeclaredConstructor().newInstance();
          Assert.assertEquals((("Foo [\n" + "  \"Bar\"\n") + "]"), instance.toString());
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      this.compilationTestHelper.compile(_builder, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

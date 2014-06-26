/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.compiler;

import com.google.inject.Inject;
import org.eclipse.xtend.core.tests.compiler.AbstractXtendCompilerTest;
import org.eclipse.xtend.core.xtend.XtendClass;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.junit4.validation.ValidationTestHelper;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.annotations.xAnnotations.XAnnotationsPackage;
import org.eclipse.xtext.xbase.compiler.CompilationTestHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.Assert;
import org.junit.Test;

@SuppressWarnings("all")
public class ToStringCompilerTest extends AbstractXtendCompilerTest {
  @Inject
  @Extension
  private ValidationTestHelper _validationTestHelper;
  
  @Test
  public void testToString() {
    try {
      StringConcatenation _builder = new StringConcatenation();
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
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          try {
            Class<?> _compiledClass = it.getCompiledClass();
            final Object instance = _compiledClass.newInstance();
            String _string = instance.toString();
            Assert.assertEquals("Foo{a=1}", _string);
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
  public void testToStringWithSuperClass() {
    try {
      StringConcatenation _builder = new StringConcatenation();
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
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          try {
            Class<?> _compiledClass = it.getCompiledClass("Bar");
            final Object instance = _compiledClass.newInstance();
            String _string = instance.toString();
            Assert.assertEquals(((("Bar [\n" + "  b = \"Bar\"\n") + "  a = 1\n") + "]"), _string);
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
      XtendClass _clazz = this.clazz(text);
      this._validationTestHelper.assertWarning(_clazz, XAnnotationsPackage.Literals.XANNOTATION, "user.issue", "no effect");
      final IAcceptor<CompilationTestHelper.Result> _function = new IAcceptor<CompilationTestHelper.Result>() {
        public void accept(final CompilationTestHelper.Result it) {
          try {
            Class<?> _compiledClass = it.getCompiledClass();
            final Object instance = _compiledClass.newInstance();
            String _string = instance.toString();
            Assert.assertEquals("foo", _string);
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      this.compilationTestHelper.compile(text, _function);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

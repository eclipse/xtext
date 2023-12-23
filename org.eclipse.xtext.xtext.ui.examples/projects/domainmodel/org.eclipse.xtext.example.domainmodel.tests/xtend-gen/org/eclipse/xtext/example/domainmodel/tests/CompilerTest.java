/**
 * Copyright (c) 2012, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.example.domainmodel.tests;

import com.google.inject.Inject;
import java.util.Collections;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.util.ReflectExtensions;
import org.eclipse.xtext.xbase.testing.CompilationTestHelper;
import org.eclipse.xtext.xbase.testing.TemporaryFolder;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(XtextRunner.class)
@InjectWith(DomainmodelInjectorProvider.class)
@SuppressWarnings("all")
public class CompilerTest {
  @Rule
  @Inject
  public TemporaryFolder temporaryFolder;

  @Inject
  @Extension
  private CompilationTestHelper _compilationTestHelper;

  @Inject
  @Extension
  private ReflectExtensions _reflectExtensions;

  @Test
  public void testGeneratedJava() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("name : String");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op doStuff(String x) : String {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return x + \' \' + this.name");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
      try {
        final Object obj = it.getCompiledClass().getDeclaredConstructor().newInstance();
        this._reflectExtensions.invoke(obj, "setName", "Foo");
        Assert.assertEquals("Hello Foo", this._reflectExtensions.invoke(obj, "doStuff", "Hello"));
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    this._compilationTestHelper.compile(_builder, _function);
  }

  @Test
  public void testGeneratedJavaFromSeveralInputs() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("bar : Bar");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op doStuff(String x) : String {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return x + \' \' + bar.getName()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("entity Bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("name : String");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
      try {
        final Object barObj = it.getCompiledClass("Bar").getDeclaredConstructor().newInstance();
        this._reflectExtensions.invoke(barObj, "setName", "Bar");
        final Object fooObj = it.getCompiledClass("Foo").getDeclaredConstructor().newInstance();
        this._reflectExtensions.invoke(fooObj, "setBar", barObj);
        Assert.assertEquals("Hello Bar", this._reflectExtensions.invoke(fooObj, "doStuff", "Hello"));
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    this._compilationTestHelper.compile(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_builder.toString(), _builder_1.toString())), _function);
  }

  @Test
  public void testGeneratedJavaInheritedMethod() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity Foo extends Bar {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("// getName and setName inherited from Bar");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op doStuff(String x) : String {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return x + \' \' + getName()");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    StringConcatenation _builder_1 = new StringConcatenation();
    _builder_1.append("entity Bar {");
    _builder_1.newLine();
    _builder_1.append("\t");
    _builder_1.append("name : String");
    _builder_1.newLine();
    _builder_1.append("}");
    _builder_1.newLine();
    final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
      try {
        final Object fooObj = it.getCompiledClass("Foo").getDeclaredConstructor().newInstance();
        this._reflectExtensions.invoke(fooObj, "setName", "World");
        Assert.assertEquals("Hello World", this._reflectExtensions.invoke(fooObj, "doStuff", "Hello"));
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    this._compilationTestHelper.compile(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(_builder.toString(), _builder_1.toString())), _function);
  }

  @Test
  public void compareGeneratedJava() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("name : String");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;");
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("@SuppressWarnings(\"all\")");
      _builder_1.newLine();
      _builder_1.append("public class Foo {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public Foo() {");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public Foo(final Procedure1<Foo> initializer) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("initializer.apply(this);");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("private String name;");
      _builder_1.newLine();
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
      _builder_1.append("public void setName(final String name) {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("this.name = name;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("@Override");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("public String toString() {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("String result = new ToStringBuilder(this).addAllFields().toString();");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("return result;");
      _builder_1.newLine();
      _builder_1.append("  ");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      Assert.assertEquals(_builder_1.toString(), it.getSingleGeneratedCode());
    };
    this._compilationTestHelper.compile(_builder, _function);
  }

  @Test
  public void testGeneratedJavaWithOverloadedMethods() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op doStuff(String x) : String {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return x");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op doStuff(int i) : String {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("return \"int \"+i");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
      try {
        final Object obj = it.getCompiledClass().getDeclaredConstructor().newInstance();
        Assert.assertEquals("Hello", this._reflectExtensions.invoke(obj, "doStuff", "Hello"));
        Assert.assertEquals("int 10", this._reflectExtensions.invoke(obj, "doStuff", Integer.valueOf(10)));
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    this._compilationTestHelper.compile(_builder, _function);
  }

  @Test
  public void testExplicitGetterReplacesGeneratedOne() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("name : String");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/** explicit getter will replace the generated one */");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op getName() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("name.toFirstUpper");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
      try {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;");
        _builder_1.newLine();
        _builder_1.append("import org.eclipse.xtext.xbase.lib.StringExtensions;");
        _builder_1.newLine();
        _builder_1.append("import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("@SuppressWarnings(\"all\")");
        _builder_1.newLine();
        _builder_1.append("public class Foo {");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public Foo() {");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public Foo(final Procedure1<Foo> initializer) {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("initializer.apply(this);");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("private String name;");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public void setName(final String name) {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("this.name = name;");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("/**");
        _builder_1.newLine();
        _builder_1.append("   ");
        _builder_1.append("* explicit getter will replace the generated one");
        _builder_1.newLine();
        _builder_1.append("   ");
        _builder_1.append("*/");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public String getName() {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("return StringExtensions.toFirstUpper(this.name);");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("@Override");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public String toString() {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("String result = new ToStringBuilder(this).addAllFields().toString();");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("return result;");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        Assert.assertEquals(_builder_1.toString(), it.getSingleGeneratedCode());
        final Object obj = it.getCompiledClass().getDeclaredConstructor().newInstance();
        this._reflectExtensions.invoke(obj, "setName", "hello");
        Assert.assertEquals("Hello", this._reflectExtensions.invoke(obj, "getName"));
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    this._compilationTestHelper.compile(_builder, _function);
  }

  @Test
  public void testExplicitSetterReplacesGeneratedOne() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("name : String");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/** explicit setter will replace the generated one,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("even if it\'s not void */");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op setName(String name) : String {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.name = name.toFirstUpper");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
      try {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;");
        _builder_1.newLine();
        _builder_1.append("import org.eclipse.xtext.xbase.lib.StringExtensions;");
        _builder_1.newLine();
        _builder_1.append("import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("@SuppressWarnings(\"all\")");
        _builder_1.newLine();
        _builder_1.append("public class Foo {");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public Foo() {");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public Foo(final Procedure1<Foo> initializer) {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("initializer.apply(this);");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("private String name;");
        _builder_1.newLine();
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
        _builder_1.append("/**");
        _builder_1.newLine();
        _builder_1.append("   ");
        _builder_1.append("* explicit setter will replace the generated one,");
        _builder_1.newLine();
        _builder_1.append("   ");
        _builder_1.append("* even if it\'s not void");
        _builder_1.newLine();
        _builder_1.append("   ");
        _builder_1.append("*/");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public String setName(final String name) {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("return this.name = StringExtensions.toFirstUpper(name);");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("@Override");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public String toString() {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("String result = new ToStringBuilder(this).addAllFields().toString();");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("return result;");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        Assert.assertEquals(_builder_1.toString(), it.getSingleGeneratedCode());
        final Object obj = it.getCompiledClass().getDeclaredConstructor().newInstance();
        Assert.assertEquals("Hello", this._reflectExtensions.invoke(obj, "setName", "hello"));
        Assert.assertEquals("Hello", this._reflectExtensions.invoke(obj, "getName"));
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    this._compilationTestHelper.compile(_builder, _function);
  }

  @Test
  public void testExplicitGetterSetterReplaceGeneratedOnes() throws Exception {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("entity Foo {");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("name : String");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/** explicit getter will replace the generated one */");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op getName() {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("name.toUpperCase");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("/** explicit setter will replace the generated one,");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("even if it\'s not void */");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("op setName(String name) : String {");
    _builder.newLine();
    _builder.append("\t\t");
    _builder.append("this.name = name.toFirstUpper");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    final IAcceptor<CompilationTestHelper.Result> _function = (CompilationTestHelper.Result it) -> {
      try {
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;");
        _builder_1.newLine();
        _builder_1.append("import org.eclipse.xtext.xbase.lib.StringExtensions;");
        _builder_1.newLine();
        _builder_1.append("import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("@SuppressWarnings(\"all\")");
        _builder_1.newLine();
        _builder_1.append("public class Foo {");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public Foo() {");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public Foo(final Procedure1<Foo> initializer) {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("initializer.apply(this);");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("private String name;");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("/**");
        _builder_1.newLine();
        _builder_1.append("   ");
        _builder_1.append("* explicit getter will replace the generated one");
        _builder_1.newLine();
        _builder_1.append("   ");
        _builder_1.append("*/");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public String getName() {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("return this.name.toUpperCase();");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("/**");
        _builder_1.newLine();
        _builder_1.append("   ");
        _builder_1.append("* explicit setter will replace the generated one,");
        _builder_1.newLine();
        _builder_1.append("   ");
        _builder_1.append("* even if it\'s not void");
        _builder_1.newLine();
        _builder_1.append("   ");
        _builder_1.append("*/");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public String setName(final String name) {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("return this.name = StringExtensions.toFirstUpper(name);");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("@Override");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("public String toString() {");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("String result = new ToStringBuilder(this).addAllFields().toString();");
        _builder_1.newLine();
        _builder_1.append("    ");
        _builder_1.append("return result;");
        _builder_1.newLine();
        _builder_1.append("  ");
        _builder_1.append("}");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        Assert.assertEquals(_builder_1.toString(), it.getSingleGeneratedCode());
        final Object obj = it.getCompiledClass().getDeclaredConstructor().newInstance();
        Assert.assertEquals("Hello", this._reflectExtensions.invoke(obj, "setName", "hello"));
        Assert.assertEquals("HELLO", this._reflectExtensions.invoke(obj, "getName"));
      } catch (Throwable _e) {
        throw Exceptions.sneakyThrow(_e);
      }
    };
    this._compilationTestHelper.compile(_builder, _function);
  }
}

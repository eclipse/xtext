/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.tests.build;

import com.google.inject.Inject;
import com.google.inject.Injector;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.build.BuildRequest;
import org.eclipse.xtext.java.JavaSourceLanguageSetup;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.builder.AbstractIncrementalBuilderTest;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@InjectWith(RuntimeInjectorProvider.class)
@RunWith(XtextRunner.class)
@SuppressWarnings("all")
public class XtendIncrementalBuilderTest extends AbstractIncrementalBuilderTest {
  @Inject
  private IResourceServiceProvider.Registry registry;
  
  @Override
  public void setUp() {
    final JavaSourceLanguageSetup javaSetup = new JavaSourceLanguageSetup();
    final Injector injector = javaSetup.createInjector();
    javaSetup.register(injector, "java");
    super.setUp();
  }
  
  @Override
  public IResourceServiceProvider.Registry getLanguages() {
    return this.registry;
  }
  
  @Test
  public void testSimpleMixedBuild() {
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public mypack.MyClass someField");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/MyFile.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package mypack;");
      _builder_1.newLine();
      _builder_1.append("class MyClass {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public String a;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      URI _minus_1 = this.operator_minus(
        "src/mypack/MyClass.java", _builder_1.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1)));
    };
    final BuildRequest buildRequest = this.newBuildRequest(_function);
    this.build(buildRequest);
    Assert.assertTrue(this.issues.toString(), this.issues.isEmpty());
    Assert.assertEquals(2, this.generated.size());
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "xtend-gen/A.java"));
  }
  
  @Test
  public void testSimpleMixedBuild_02() {
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void doStuff(mypack.MyClass obj) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val A x = obj.a");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("println(\"Juhu \"+x)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/MyFile.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package mypack;");
      _builder_1.newLine();
      _builder_1.append("class MyClass {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public A a;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      URI _minus_1 = this.operator_minus(
        "src/mypack/MyClass.java", _builder_1.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1)));
    };
    final BuildRequest buildRequest = this.newBuildRequest(_function);
    this.build(buildRequest);
    Assert.assertTrue(this.issues.toString(), this.issues.isEmpty());
    Assert.assertEquals(2, this.generated.size());
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "xtend-gen/A.java"));
  }
  
  @Test
  public void testSimpleMixedBuild_03() {
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A extends mypack.MyClass {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("def void doStuff(A obj) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val A x = obj.a");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("val mypack.MyClass x2 = obj.myClass");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("println(\"Juhu \"+x+\' - \'+x2.a)");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/MyFile.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package mypack;");
      _builder_1.newLine();
      _builder_1.append("public class MyClass extends Third {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public A a;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      URI _minus_1 = this.operator_minus(
        "src/mypack/MyClass.java", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package mypack");
      _builder_2.newLine();
      _builder_2.append("class Third {");
      _builder_2.newLine();
      _builder_2.append("\t");
      _builder_2.append("public MyClass myClass");
      _builder_2.newLine();
      _builder_2.append("}");
      _builder_2.newLine();
      URI _minus_2 = this.operator_minus(
        "src/mypack/Third.xtend", _builder_2.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1, _minus_2)));
    };
    final BuildRequest buildRequest = this.newBuildRequest(_function);
    this.build(buildRequest);
    Assert.assertTrue(this.issues.toString(), this.issues.isEmpty());
    Assert.assertEquals(4, this.generated.size());
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "xtend-gen/A.java"));
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "xtend-gen/.A.java._trace"));
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "xtend-gen/mypack/Third.java"));
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "xtend-gen/mypack/.Third.java._trace"));
  }
  
  @Test
  public void testSimpleMixedBuild04() {
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("import b.B");
      _builder.newLine();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("def foo() {");
      _builder.newLine();
      _builder.append("      ");
      _builder.append("B.foo");
      _builder.newLine();
      _builder.append("   ");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/A.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package b;");
      _builder_1.newLine();
      _builder_1.append("public class B {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public static String foo;");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      URI _minus_1 = this.operator_minus("src/b/B.java", _builder_1.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1)));
    };
    final BuildRequest buildRequest = this.newBuildRequest(_function);
    this.build(buildRequest);
    Assert.assertTrue(this.issues.toString(), this.issues.isEmpty());
    Assert.assertEquals(2, this.generated.size());
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "xtend-gen/A.java"));
  }
  
  @Test
  public void testSimpleFullBuild() {
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public String a");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public B someB");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.append("class B {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/MyFile.xtend", _builder.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus)));
    };
    final BuildRequest buildRequest = this.newBuildRequest(_function);
    this.build(buildRequest);
    Assert.assertTrue(this.issues.toString(), this.issues.isEmpty());
    Assert.assertEquals(4, this.generated.size());
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "xtend-gen/B.java"));
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "xtend-gen/A.java"));
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "xtend-gen/.B.java._trace"));
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "xtend-gen/.A.java._trace"));
  }
  
  @Test
  public void testDelete_01() {
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public foo.B myField");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/A.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package foo");
      _builder_1.newLine();
      _builder_1.append("class B {");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      URI _minus_1 = this.operator_minus(
        "src/foo/B.xtend", _builder_1.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1)));
    };
    this.build(this.newBuildRequest(_function));
    final AtomicBoolean validateCalled = new AtomicBoolean(false);
    final Procedure1<BuildRequest> _function_1 = (BuildRequest it) -> {
      URI _delete = this.delete(this.uri("src/foo/B.xtend"));
      it.setDeletedFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_delete)));
      final BuildRequest.IPostValidationCallback _function_2 = (URI uri, Iterable<Issue> issues) -> {
        Assert.assertEquals(this.uri("src/A.xtend"), uri);
        Assert.assertTrue(IterableExtensions.<Issue>head(issues).getMessage(), IterableExtensions.<Issue>head(issues).getMessage().contains("foo.B cannot be resolved to a type"));
        validateCalled.set(true);
        return false;
      };
      it.setAfterValidate(_function_2);
    };
    this.build(this.newBuildRequest(_function_1));
    Assert.assertTrue(validateCalled.get());
  }
  
  @Test
  public void testIncrementalBuild() {
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A extends B {");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/A.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("class B { ");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("public A myReference");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      URI _minus_1 = this.operator_minus(
        "src/B.xtend", _builder_1.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1)));
    };
    this.build(this.newBuildRequest(_function));
    Assert.assertTrue(this.issues.toString(), this.issues.isEmpty());
    Assert.assertEquals(4, this.generated.size());
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "xtend-gen/B.java"));
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "xtend-gen/A.java"));
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "xtend-gen/.B.java._trace"));
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "xtend-gen/.A.java._trace"));
    final Procedure1<BuildRequest> _function_1 = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("// some comment");
      _builder.newLine();
      _builder.append("class A extends B { }");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/A.xtend", _builder.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus)));
    };
    this.build(this.newBuildRequest(_function_1));
    Assert.assertTrue(this.issues.toString(), this.issues.isEmpty());
    Assert.assertEquals(4, this.generated.size());
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "xtend-gen/B.java"));
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "xtend-gen/A.java"));
    final Procedure1<BuildRequest> _function_2 = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class X extends B { }");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/A.xtend", _builder.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus)));
    };
    this.build(this.newBuildRequest(_function_2));
    Assert.assertEquals(this.issues.toString(), 1, this.issues.size());
    Assert.assertEquals(2, this.generated.size());
    Assert.assertFalse(this.containsSuffix(this.generated.values(), "xtend-gen/B.java"));
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "xtend-gen/X.java"));
    Assert.assertTrue(IterableExtensions.<URI>toSet(this.indexState.getFileMappings().getGenerated(this.uri("src/A.xtend"))).contains(this.uri("xtend-gen/X.java")));
    Assert.assertEquals(2, this.deleted.size());
    Assert.assertTrue(this.containsSuffix(this.deleted, "xtend-gen/A.java"));
    Assert.assertTrue(this.containsSuffix(this.deleted, "xtend-gen/.A.java._trace"));
    final Procedure1<BuildRequest> _function_3 = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("class A extends B {\t}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/A.xtend", _builder.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus)));
    };
    this.build(this.newBuildRequest(_function_3));
    Assert.assertTrue(this.issues.toString(), this.issues.isEmpty());
    Assert.assertEquals(4, this.generated.size());
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "xtend-gen/B.java"));
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "xtend-gen/A.java"));
    Assert.assertTrue(this.containsSuffix(this.deleted, "xtend-gen/X.java"));
    final Procedure1<BuildRequest> _function_4 = (BuildRequest it) -> {
      URI _delete = this.delete(this.uri("src/A.xtend"));
      it.setDeletedFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_delete)));
    };
    this.build(this.newBuildRequest(_function_4));
    Assert.assertEquals(this.issues.toString(), 1, this.issues.size());
    Assert.assertEquals(0, this.generated.size());
    Assert.assertEquals(2, this.deleted.size());
    Assert.assertTrue(this.containsSuffix(this.deleted, "xtend-gen/A.java"));
  }
  
  @Test
  public void testPackageInfo() {
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package foo;");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/foo/package-info.java", _builder.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus)));
    };
    final BuildRequest buildRequest = this.newBuildRequest(_function);
    this.build(buildRequest);
    Assert.assertTrue(this.issues.toString(), this.issues.isEmpty());
  }
  
  /**
   * tests https://github.com/eclipse/xtext-core/issues/52
   */
  @Test
  public void testIssue52() {
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package a");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import b.B");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Accessors String version");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new (String x, B b) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Accessors");
      _builder.newLine();
      _builder.append("class A1 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var String a");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/a/A.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package b");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import a.A");
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.lib.annotations.Accessors");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class B {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("@Accessors String version");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def doSth() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("val a = new A");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("a.toString");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def doSomethingElse(String a) {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("a.length + 1");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      URI _minus_1 = this.operator_minus(
        "src/b/B.xtend", _builder_1.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1)));
    };
    this.build(this.newBuildRequest(_function));
    Assert.assertTrue(this.issues.toString(), this.issues.isEmpty());
    final Procedure1<BuildRequest> _function_1 = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package a");
      _builder.newLine();
      _builder.newLine();
      _builder.append("import b.B");
      _builder.newLine();
      _builder.append("import org.eclipse.xtend.lib.annotations.Accessors");
      _builder.newLine();
      _builder.newLine();
      _builder.append("class A {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("@Accessors String version");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new (String x, B b) {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("new() {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("@Accessors");
      _builder.newLine();
      _builder.append("class A1 {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("var String a");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/a/A.xtend", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package b");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import a.A");
      _builder_1.newLine();
      _builder_1.append("import org.eclipse.xtend.lib.annotations.Accessors");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class B {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("@Accessors String version");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def doSth() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("val a = new A");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("a.toString");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def doSomethingElse(String a) {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("a.length + 1");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      URI _minus_1 = this.operator_minus(
        "src/b/B.xtend", _builder_1.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1)));
    };
    this.build(this.newBuildRequest(_function_1));
    Assert.assertTrue(this.issues.toString(), this.issues.isEmpty());
  }
  
  @Test
  public void testGrammarAccessproblem() {
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypack;");
      _builder.newLine();
      _builder.append("public class FakeIssue60GrammarAccess {");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private final GreetingElements pGreeting;");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public FakeIssue60GrammarAccess() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("this.pGreeting = new GreetingElements();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public class GreetingElements {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("public String getHelloKeyword_0() { return null; }");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public GreetingElements getGreetingAccess() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("return pGreeting;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/mypack/FakeIssue60GrammarAccess.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package mypack");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("import mypack.FakeIssue60GrammarAccess$GreetingElements");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("class Demo {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("extension mypack.FakeIssue60GrammarAccess");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("GreetingElements elements");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def void format() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("greetingAccess.helloKeyword_0");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("println(elements)");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      URI _minus_1 = this.operator_minus(
        "src/mypack/Demo.xtend", _builder_1.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1)));
    };
    final BuildRequest buildRequest = this.newBuildRequest(_function);
    this.build(buildRequest);
    Assert.assertTrue(this.issues.toString(), this.issues.isEmpty());
    Assert.assertEquals(2, this.generated.size());
  }
  
  @Test
  public void testInnerClassEnumProblem() {
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package mypack;");
      _builder.newLine();
      _builder.append("public class EnumTest {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public enum AB {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("A,");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("B");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/mypack/EnumTest.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package mypack");
      _builder_1.newLine();
      _builder_1.append("class Demo {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("def void format() {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("var EnumTest.AB x = EnumTest.AB.A");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("println(x)");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      URI _minus_1 = this.operator_minus(
        "src/mypack/Demo.xtend", _builder_1.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1)));
    };
    final BuildRequest buildRequest = this.newBuildRequest(_function);
    this.build(buildRequest);
    Assert.assertTrue(this.issues.toString(), this.issues.isEmpty());
    Assert.assertEquals(2, this.generated.size());
  }
  
  @Test
  public void testBug487806() {
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("package test;");
      _builder.newLine();
      _builder.append("public class BaseException extends java.lang.Exception {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("private static final long serialVersionUID = 1L;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("public BaseException() {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("super();");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/test/BaseException.java", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("package test;");
      _builder_1.newLine();
      _builder_1.append("public interface ClientGame extends Game<ClientPlayer> {");
      _builder_1.newLine();
      _builder_1.append("}");
      URI _minus_1 = this.operator_minus(
        "src/test/ClientGame.java", _builder_1.toString());
      StringConcatenation _builder_2 = new StringConcatenation();
      _builder_2.append("package test;");
      _builder_2.newLine();
      _builder_2.append("public interface ClientPlayer extends Player {");
      _builder_2.newLine();
      _builder_2.append("}");
      URI _minus_2 = this.operator_minus(
        "src/test/ClientPlayer.java", _builder_2.toString());
      StringConcatenation _builder_3 = new StringConcatenation();
      _builder_3.append("package test;");
      _builder_3.newLine();
      _builder_3.append("import java.util.Collection;");
      _builder_3.newLine();
      _builder_3.append("public interface Game<P extends Player> extends IDElement {");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("Collection<P> getPlayers();");
      _builder_3.newLine();
      _builder_3.append("\t");
      _builder_3.append("void addPlayer(P player) throws BaseException;");
      _builder_3.newLine();
      _builder_3.append("}");
      URI _minus_3 = this.operator_minus(
        "src/test/Game.java", _builder_3.toString());
      StringConcatenation _builder_4 = new StringConcatenation();
      _builder_4.append("package test;");
      _builder_4.newLine();
      _builder_4.append("public interface IDElement {");
      _builder_4.newLine();
      _builder_4.append("\t");
      _builder_4.append("public int getId();");
      _builder_4.newLine();
      _builder_4.append("}");
      URI _minus_4 = this.operator_minus(
        "src/test/IDElement.java", _builder_4.toString());
      StringConcatenation _builder_5 = new StringConcatenation();
      _builder_5.append("package test;");
      _builder_5.newLine();
      _builder_5.append("public interface Player extends IDElement {");
      _builder_5.newLine();
      _builder_5.append("}");
      URI _minus_5 = this.operator_minus(
        "src/test/Player.java", _builder_5.toString());
      StringConcatenation _builder_6 = new StringConcatenation();
      _builder_6.append("package test");
      _builder_6.newLine();
      _builder_6.append("class BoardUpdateCommandProcessor  {");
      _builder_6.newLine();
      _builder_6.append("\t");
      _builder_6.append("new(ClientGame game) {");
      _builder_6.newLine();
      _builder_6.append("\t\t");
      _builder_6.append("var player = game.players.findFirst[it.id == 343]");
      _builder_6.newLine();
      _builder_6.append("\t\t");
      _builder_6.append("player = null");
      _builder_6.newLine();
      _builder_6.append("\t");
      _builder_6.append("}");
      _builder_6.newLine();
      _builder_6.append("}");
      URI _minus_6 = this.operator_minus(
        "src/test/BoardUpdateCommandProcessor.xtend", _builder_6.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1, _minus_2, _minus_3, _minus_4, _minus_5, _minus_6)));
    };
    final BuildRequest buildRequest = this.newBuildRequest(_function);
    this.build(buildRequest);
    Assert.assertTrue(this.issues.toString(), this.issues.isEmpty());
  }
}

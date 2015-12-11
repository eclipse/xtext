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
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.core.tests.RuntimeInjectorProvider;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.build.BuildRequest;
import org.eclipse.xtext.build.Source2GeneratedMapping;
import org.eclipse.xtext.java.JavaSourceLanguageSetup;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.build.AbstractIncrementalBuilderTest;
import org.eclipse.xtext.resource.IResourceServiceProvider;
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
    final Procedure1<BuildRequest> _function = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("class A {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public mypack.MyClass someField");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        URI _minus = XtendIncrementalBuilderTest.this.operator_minus(
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
        URI _minus_1 = XtendIncrementalBuilderTest.this.operator_minus(
          "src/mypack/MyClass.java", _builder_1.toString());
        it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1)));
      }
    };
    final BuildRequest buildRequest = this.newBuildRequest(_function);
    this.build(buildRequest);
    String _string = this.issues.toString();
    boolean _isEmpty = this.issues.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
    int _size = this.generated.size();
    Assert.assertEquals(2, _size);
    Collection<URI> _values = this.generated.values();
    boolean _containsSuffix = this.containsSuffix(_values, "xtend-gen/A.java");
    Assert.assertTrue(_containsSuffix);
  }
  
  @Test
  public void testSimpleMixedBuild_02() {
    final Procedure1<BuildRequest> _function = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
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
        URI _minus = XtendIncrementalBuilderTest.this.operator_minus(
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
        URI _minus_1 = XtendIncrementalBuilderTest.this.operator_minus(
          "src/mypack/MyClass.java", _builder_1.toString());
        it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1)));
      }
    };
    final BuildRequest buildRequest = this.newBuildRequest(_function);
    this.build(buildRequest);
    String _string = this.issues.toString();
    boolean _isEmpty = this.issues.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
    int _size = this.generated.size();
    Assert.assertEquals(2, _size);
    Collection<URI> _values = this.generated.values();
    boolean _containsSuffix = this.containsSuffix(_values, "xtend-gen/A.java");
    Assert.assertTrue(_containsSuffix);
  }
  
  @Test
  public void testSimpleMixedBuild_03() {
    final Procedure1<BuildRequest> _function = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
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
        URI _minus = XtendIncrementalBuilderTest.this.operator_minus(
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
        URI _minus_1 = XtendIncrementalBuilderTest.this.operator_minus(
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
        URI _minus_2 = XtendIncrementalBuilderTest.this.operator_minus(
          "src/mypack/Third.xtend", _builder_2.toString());
        it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1, _minus_2)));
      }
    };
    final BuildRequest buildRequest = this.newBuildRequest(_function);
    this.build(buildRequest);
    String _string = this.issues.toString();
    boolean _isEmpty = this.issues.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
    int _size = this.generated.size();
    Assert.assertEquals(4, _size);
    Collection<URI> _values = this.generated.values();
    boolean _containsSuffix = this.containsSuffix(_values, "xtend-gen/A.java");
    Assert.assertTrue(_containsSuffix);
    Collection<URI> _values_1 = this.generated.values();
    boolean _containsSuffix_1 = this.containsSuffix(_values_1, "xtend-gen/.A.java._trace");
    Assert.assertTrue(_containsSuffix_1);
    Collection<URI> _values_2 = this.generated.values();
    boolean _containsSuffix_2 = this.containsSuffix(_values_2, "xtend-gen/mypack/Third.java");
    Assert.assertTrue(_containsSuffix_2);
    Collection<URI> _values_3 = this.generated.values();
    boolean _containsSuffix_3 = this.containsSuffix(_values_3, "xtend-gen/mypack/.Third.java._trace");
    Assert.assertTrue(_containsSuffix_3);
  }
  
  @Test
  public void testSimpleMixedBuild04() {
    final Procedure1<BuildRequest> _function = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("import b.B");
        _builder.newLine();
        _builder.append("class A {");
        _builder.newLine();
        _builder.append("   ");
        _builder.append("@Override");
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
        URI _minus = XtendIncrementalBuilderTest.this.operator_minus(
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
        URI _minus_1 = XtendIncrementalBuilderTest.this.operator_minus("src/b/B.java", _builder_1.toString());
        it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1)));
      }
    };
    final BuildRequest buildRequest = this.newBuildRequest(_function);
    this.build(buildRequest);
    String _string = this.issues.toString();
    boolean _isEmpty = this.issues.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
    int _size = this.generated.size();
    Assert.assertEquals(2, _size);
    Collection<URI> _values = this.generated.values();
    boolean _containsSuffix = this.containsSuffix(_values, "xtend-gen/A.java");
    Assert.assertTrue(_containsSuffix);
  }
  
  @Test
  public void testSimpleFullBuild() {
    final Procedure1<BuildRequest> _function = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
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
        URI _minus = XtendIncrementalBuilderTest.this.operator_minus(
          "src/MyFile.xtend", _builder.toString());
        it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus)));
      }
    };
    final BuildRequest buildRequest = this.newBuildRequest(_function);
    this.build(buildRequest);
    String _string = this.issues.toString();
    boolean _isEmpty = this.issues.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
    int _size = this.generated.size();
    Assert.assertEquals(4, _size);
    Collection<URI> _values = this.generated.values();
    boolean _containsSuffix = this.containsSuffix(_values, "xtend-gen/B.java");
    Assert.assertTrue(_containsSuffix);
    Collection<URI> _values_1 = this.generated.values();
    boolean _containsSuffix_1 = this.containsSuffix(_values_1, "xtend-gen/A.java");
    Assert.assertTrue(_containsSuffix_1);
    Collection<URI> _values_2 = this.generated.values();
    boolean _containsSuffix_2 = this.containsSuffix(_values_2, "xtend-gen/.B.java._trace");
    Assert.assertTrue(_containsSuffix_2);
    Collection<URI> _values_3 = this.generated.values();
    boolean _containsSuffix_3 = this.containsSuffix(_values_3, "xtend-gen/.A.java._trace");
    Assert.assertTrue(_containsSuffix_3);
  }
  
  @Test
  public void testDelete_01() {
    final Procedure1<BuildRequest> _function = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("class A {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("public foo.B myField");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        URI _minus = XtendIncrementalBuilderTest.this.operator_minus(
          "src/A.xtend", _builder.toString());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("package foo");
        _builder_1.newLine();
        _builder_1.append("class B {");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        URI _minus_1 = XtendIncrementalBuilderTest.this.operator_minus(
          "src/foo/B.xtend", _builder_1.toString());
        it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1)));
      }
    };
    BuildRequest _newBuildRequest = this.newBuildRequest(_function);
    this.build(_newBuildRequest);
    final AtomicBoolean validateCalled = new AtomicBoolean(false);
    final Procedure1<BuildRequest> _function_1 = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        URI _uri = XtendIncrementalBuilderTest.this.uri("src/foo/B.xtend");
        URI _delete = XtendIncrementalBuilderTest.this.delete(_uri);
        it.setDeletedFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_delete)));
        final BuildRequest.IPostValidationCallback _function = new BuildRequest.IPostValidationCallback() {
          @Override
          public boolean afterValidate(final URI uri, final Iterable<Issue> issues) {
            URI _uri = XtendIncrementalBuilderTest.this.uri("src/A.xtend");
            Assert.assertEquals(_uri, uri);
            Issue _head = IterableExtensions.<Issue>head(issues);
            String _message = _head.getMessage();
            Issue _head_1 = IterableExtensions.<Issue>head(issues);
            String _message_1 = _head_1.getMessage();
            boolean _contains = _message_1.contains("foo.B cannot be resolved to a type");
            Assert.assertTrue(_message, _contains);
            validateCalled.set(true);
            return false;
          }
        };
        it.setAfterValidate(_function);
      }
    };
    BuildRequest _newBuildRequest_1 = this.newBuildRequest(_function_1);
    this.build(_newBuildRequest_1);
    boolean _get = validateCalled.get();
    Assert.assertTrue(_get);
  }
  
  @Test
  public void testIncrementalBuild() {
    final Procedure1<BuildRequest> _function = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("class A extends B {");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        URI _minus = XtendIncrementalBuilderTest.this.operator_minus(
          "src/A.xtend", _builder.toString());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("class B { ");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("public A myReference");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        URI _minus_1 = XtendIncrementalBuilderTest.this.operator_minus(
          "src/B.xtend", _builder_1.toString());
        it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1)));
      }
    };
    BuildRequest _newBuildRequest = this.newBuildRequest(_function);
    this.build(_newBuildRequest);
    String _string = this.issues.toString();
    boolean _isEmpty = this.issues.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
    int _size = this.generated.size();
    Assert.assertEquals(4, _size);
    Collection<URI> _values = this.generated.values();
    boolean _containsSuffix = this.containsSuffix(_values, "xtend-gen/B.java");
    Assert.assertTrue(_containsSuffix);
    Collection<URI> _values_1 = this.generated.values();
    boolean _containsSuffix_1 = this.containsSuffix(_values_1, "xtend-gen/A.java");
    Assert.assertTrue(_containsSuffix_1);
    Collection<URI> _values_2 = this.generated.values();
    boolean _containsSuffix_2 = this.containsSuffix(_values_2, "xtend-gen/.B.java._trace");
    Assert.assertTrue(_containsSuffix_2);
    Collection<URI> _values_3 = this.generated.values();
    boolean _containsSuffix_3 = this.containsSuffix(_values_3, "xtend-gen/.A.java._trace");
    Assert.assertTrue(_containsSuffix_3);
    final Procedure1<BuildRequest> _function_1 = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("// some comment");
        _builder.newLine();
        _builder.append("class A extends B { }");
        _builder.newLine();
        URI _minus = XtendIncrementalBuilderTest.this.operator_minus(
          "src/A.xtend", _builder.toString());
        it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus)));
      }
    };
    BuildRequest _newBuildRequest_1 = this.newBuildRequest(_function_1);
    this.build(_newBuildRequest_1);
    String _string_1 = this.issues.toString();
    boolean _isEmpty_1 = this.issues.isEmpty();
    Assert.assertTrue(_string_1, _isEmpty_1);
    int _size_1 = this.generated.size();
    Assert.assertEquals(4, _size_1);
    Collection<URI> _values_4 = this.generated.values();
    boolean _containsSuffix_4 = this.containsSuffix(_values_4, "xtend-gen/B.java");
    Assert.assertTrue(_containsSuffix_4);
    Collection<URI> _values_5 = this.generated.values();
    boolean _containsSuffix_5 = this.containsSuffix(_values_5, "xtend-gen/A.java");
    Assert.assertTrue(_containsSuffix_5);
    final Procedure1<BuildRequest> _function_2 = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("class X extends B { }");
        _builder.newLine();
        URI _minus = XtendIncrementalBuilderTest.this.operator_minus(
          "src/A.xtend", _builder.toString());
        it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus)));
      }
    };
    BuildRequest _newBuildRequest_2 = this.newBuildRequest(_function_2);
    this.build(_newBuildRequest_2);
    String _string_2 = this.issues.toString();
    int _size_2 = this.issues.size();
    Assert.assertEquals(_string_2, 1, _size_2);
    int _size_3 = this.generated.size();
    Assert.assertEquals(2, _size_3);
    Collection<URI> _values_6 = this.generated.values();
    boolean _containsSuffix_6 = this.containsSuffix(_values_6, "xtend-gen/B.java");
    Assert.assertFalse(_containsSuffix_6);
    Collection<URI> _values_7 = this.generated.values();
    boolean _containsSuffix_7 = this.containsSuffix(_values_7, "xtend-gen/X.java");
    Assert.assertTrue(_containsSuffix_7);
    Source2GeneratedMapping _fileMappings = this.indexState.getFileMappings();
    URI _uri = this.uri("src/A.xtend");
    List<URI> _generated = _fileMappings.getGenerated(_uri);
    Set<URI> _set = IterableExtensions.<URI>toSet(_generated);
    URI _uri_1 = this.uri("xtend-gen/X.java");
    boolean _contains = _set.contains(_uri_1);
    Assert.assertTrue(_contains);
    int _size_4 = this.deleted.size();
    Assert.assertEquals(2, _size_4);
    boolean _containsSuffix_8 = this.containsSuffix(this.deleted, "xtend-gen/A.java");
    Assert.assertTrue(_containsSuffix_8);
    boolean _containsSuffix_9 = this.containsSuffix(this.deleted, "xtend-gen/.A.java._trace");
    Assert.assertTrue(_containsSuffix_9);
    final Procedure1<BuildRequest> _function_3 = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("class A extends B {\t}");
        _builder.newLine();
        URI _minus = XtendIncrementalBuilderTest.this.operator_minus(
          "src/A.xtend", _builder.toString());
        it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus)));
      }
    };
    BuildRequest _newBuildRequest_3 = this.newBuildRequest(_function_3);
    this.build(_newBuildRequest_3);
    String _string_3 = this.issues.toString();
    boolean _isEmpty_2 = this.issues.isEmpty();
    Assert.assertTrue(_string_3, _isEmpty_2);
    int _size_5 = this.generated.size();
    Assert.assertEquals(4, _size_5);
    Collection<URI> _values_8 = this.generated.values();
    boolean _containsSuffix_10 = this.containsSuffix(_values_8, "xtend-gen/B.java");
    Assert.assertTrue(_containsSuffix_10);
    Collection<URI> _values_9 = this.generated.values();
    boolean _containsSuffix_11 = this.containsSuffix(_values_9, "xtend-gen/A.java");
    Assert.assertTrue(_containsSuffix_11);
    boolean _containsSuffix_12 = this.containsSuffix(this.deleted, "xtend-gen/X.java");
    Assert.assertTrue(_containsSuffix_12);
    final Procedure1<BuildRequest> _function_4 = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        URI _uri = XtendIncrementalBuilderTest.this.uri("src/A.xtend");
        URI _delete = XtendIncrementalBuilderTest.this.delete(_uri);
        it.setDeletedFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_delete)));
      }
    };
    BuildRequest _newBuildRequest_4 = this.newBuildRequest(_function_4);
    this.build(_newBuildRequest_4);
    String _string_4 = this.issues.toString();
    int _size_6 = this.issues.size();
    Assert.assertEquals(_string_4, 1, _size_6);
    int _size_7 = this.generated.size();
    Assert.assertEquals(0, _size_7);
    int _size_8 = this.deleted.size();
    Assert.assertEquals(2, _size_8);
    boolean _containsSuffix_13 = this.containsSuffix(this.deleted, "xtend-gen/A.java");
    Assert.assertTrue(_containsSuffix_13);
  }
  
  @Test
  public void testPackageInfo() {
    final Procedure1<BuildRequest> _function = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("package foo;");
        _builder.newLine();
        URI _minus = XtendIncrementalBuilderTest.this.operator_minus(
          "src/foo/package-info.java", _builder.toString());
        it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus)));
      }
    };
    final BuildRequest buildRequest = this.newBuildRequest(_function);
    this.build(buildRequest);
    String _string = this.issues.toString();
    boolean _isEmpty = this.issues.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
  }
}

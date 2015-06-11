/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.tests.incremental;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.builder.standalone.ILanguageConfiguration;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.LanguageAccessFactory;
import org.eclipse.xtext.builder.standalone.StandaloneBuilderInjectorProvider;
import org.eclipse.xtext.builder.standalone.StandaloneBuilderTest;
import org.eclipse.xtext.builder.standalone.incremental.BuildRequest;
import org.eclipse.xtext.builder.standalone.incremental.Source2GeneratedMapping;
import org.eclipse.xtext.builder.tests.incremental.AbstractIncrementalBuilderTest;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(StandaloneBuilderInjectorProvider.class)
@SuppressWarnings("all")
public class IncrementalBuilderTest extends AbstractIncrementalBuilderTest {
  @Inject
  protected LanguageAccessFactory languageAccessFactory;
  
  @Override
  public Iterable<? extends LanguageAccess> getLanguages() {
    StandaloneBuilderTest.TestLanguageConfiguration _testLanguageConfiguration = new StandaloneBuilderTest.TestLanguageConfiguration(false);
    Class<? extends IncrementalBuilderTest> _class = this.getClass();
    ClassLoader _classLoader = _class.getClassLoader();
    Map<String, LanguageAccess> _createLanguageAccess = this.languageAccessFactory.createLanguageAccess(Collections.<ILanguageConfiguration>unmodifiableList(CollectionLiterals.<ILanguageConfiguration>newArrayList(_testLanguageConfiguration)), _classLoader);
    Collection<LanguageAccess> _values = _createLanguageAccess.values();
    return IterableExtensions.<LanguageAccess>toList(_values);
  }
  
  @Test
  public void testSimpleFullBuild() {
    final Procedure1<BuildRequest> _function = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("namespace foo {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("object B");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("object A references foo.B");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        URI _minus = IncrementalBuilderTest.this.operator_minus(
          "src/MyFile.buildertestlanguage", _builder.toString());
        it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus)));
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
    boolean _containsSuffix = this.containsSuffix(_values, "src-gen/B.txt");
    Assert.assertTrue(_containsSuffix);
    Collection<URI> _values_1 = this.generated.values();
    boolean _containsSuffix_1 = this.containsSuffix(_values_1, "src-gen/A.txt");
    Assert.assertTrue(_containsSuffix_1);
  }
  
  @Test
  public void testDelete_01() {
    final Procedure1<BuildRequest> _function = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("namespace foo {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("object A references foo.B");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        URI _minus = IncrementalBuilderTest.this.operator_minus(
          "src/A.buildertestlanguage", _builder.toString());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("namespace foo {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("object B");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        URI _minus_1 = IncrementalBuilderTest.this.operator_minus(
          "src/B.buildertestlanguage", _builder_1.toString());
        it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1)));
      }
    };
    BuildRequest _newBuildRequest = this.newBuildRequest(_function);
    this.build(_newBuildRequest);
    final AtomicBoolean validateCalled = new AtomicBoolean(false);
    final Procedure1<BuildRequest> _function_1 = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        URI _uri = IncrementalBuilderTest.this.uri("src/B.buildertestlanguage");
        it.setDeletedFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_uri)));
        final BuildRequest.IPostValidationCallback _function = new BuildRequest.IPostValidationCallback() {
          @Override
          public boolean afterValidate(final URI uri, final Iterable<Issue> issues) {
            URI _uri = IncrementalBuilderTest.this.uri("src/A.buildertestlanguage");
            Assert.assertEquals(_uri, uri);
            Issue _head = IterableExtensions.<Issue>head(issues);
            String _message = _head.getMessage();
            boolean _contains = _message.contains("Couldn\'t resolve reference to Element \'foo.B\'");
            Assert.assertTrue(_contains);
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
        _builder.append("namespace foo {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("object A references foo.B");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        URI _minus = IncrementalBuilderTest.this.operator_minus(
          "src/A.buildertestlanguage", _builder.toString());
        StringConcatenation _builder_1 = new StringConcatenation();
        _builder_1.append("namespace foo {");
        _builder_1.newLine();
        _builder_1.append("\t");
        _builder_1.append("object B references foo.A");
        _builder_1.newLine();
        _builder_1.append("}");
        _builder_1.newLine();
        URI _minus_1 = IncrementalBuilderTest.this.operator_minus(
          "src/B.buildertestlanguage", _builder_1.toString());
        it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1)));
      }
    };
    BuildRequest _newBuildRequest = this.newBuildRequest(_function);
    this.build(_newBuildRequest);
    String _string = this.issues.toString();
    boolean _isEmpty = this.issues.isEmpty();
    Assert.assertTrue(_string, _isEmpty);
    int _size = this.generated.size();
    Assert.assertEquals(2, _size);
    Collection<URI> _values = this.generated.values();
    boolean _containsSuffix = this.containsSuffix(_values, "src-gen/B.txt");
    Assert.assertTrue(_containsSuffix);
    Collection<URI> _values_1 = this.generated.values();
    boolean _containsSuffix_1 = this.containsSuffix(_values_1, "src-gen/A.txt");
    Assert.assertTrue(_containsSuffix_1);
    final Procedure1<BuildRequest> _function_1 = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("namespace foo {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("object A references foo.B");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        URI _minus = IncrementalBuilderTest.this.operator_minus(
          "src/A.buildertestlanguage", _builder.toString());
        it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus)));
      }
    };
    BuildRequest _newBuildRequest_1 = this.newBuildRequest(_function_1);
    this.build(_newBuildRequest_1);
    String _string_1 = this.issues.toString();
    boolean _isEmpty_1 = this.issues.isEmpty();
    Assert.assertTrue(_string_1, _isEmpty_1);
    int _size_1 = this.generated.size();
    Assert.assertEquals(1, _size_1);
    Collection<URI> _values_2 = this.generated.values();
    boolean _containsSuffix_2 = this.containsSuffix(_values_2, "src-gen/B.txt");
    Assert.assertFalse(_containsSuffix_2);
    Collection<URI> _values_3 = this.generated.values();
    boolean _containsSuffix_3 = this.containsSuffix(_values_3, "src-gen/A.txt");
    Assert.assertTrue(_containsSuffix_3);
    final Procedure1<BuildRequest> _function_2 = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("namespace foo {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("object X references foo.B");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        URI _minus = IncrementalBuilderTest.this.operator_minus(
          "src/A.buildertestlanguage", _builder.toString());
        it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus)));
      }
    };
    BuildRequest _newBuildRequest_2 = this.newBuildRequest(_function_2);
    this.build(_newBuildRequest_2);
    String _string_2 = this.issues.toString();
    int _size_2 = this.issues.size();
    Assert.assertEquals(_string_2, 1, _size_2);
    int _size_3 = this.generated.size();
    Assert.assertEquals(1, _size_3);
    Collection<URI> _values_4 = this.generated.values();
    boolean _containsSuffix_4 = this.containsSuffix(_values_4, "src-gen/B.txt");
    Assert.assertFalse(_containsSuffix_4);
    Collection<URI> _values_5 = this.generated.values();
    boolean _containsSuffix_5 = this.containsSuffix(_values_5, "src-gen/X.txt");
    Assert.assertTrue(_containsSuffix_5);
    Source2GeneratedMapping _fileMappings = this.indexState.getFileMappings();
    URI _uri = this.uri("src/A.buildertestlanguage");
    Iterable<URI> _generated = _fileMappings.getGenerated(_uri);
    int _size_4 = IterableExtensions.size(_generated);
    Assert.assertEquals(1, _size_4);
    int _size_5 = this.deleted.size();
    Assert.assertEquals(1, _size_5);
    boolean _containsSuffix_6 = this.containsSuffix(this.deleted, "src-gen/A.txt");
    Assert.assertTrue(_containsSuffix_6);
    final Procedure1<BuildRequest> _function_3 = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("namespace foo {");
        _builder.newLine();
        _builder.append("\t");
        _builder.append("object A references foo.B");
        _builder.newLine();
        _builder.append("}");
        _builder.newLine();
        URI _minus = IncrementalBuilderTest.this.operator_minus(
          "src/A.buildertestlanguage", _builder.toString());
        it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus)));
      }
    };
    BuildRequest _newBuildRequest_3 = this.newBuildRequest(_function_3);
    this.build(_newBuildRequest_3);
    String _string_3 = this.issues.toString();
    boolean _isEmpty_2 = this.issues.isEmpty();
    Assert.assertTrue(_string_3, _isEmpty_2);
    int _size_6 = this.generated.size();
    Assert.assertEquals(2, _size_6);
    Collection<URI> _values_6 = this.generated.values();
    boolean _containsSuffix_7 = this.containsSuffix(_values_6, "src-gen/B.txt");
    Assert.assertTrue(_containsSuffix_7);
    Collection<URI> _values_7 = this.generated.values();
    boolean _containsSuffix_8 = this.containsSuffix(_values_7, "src-gen/A.txt");
    Assert.assertTrue(_containsSuffix_8);
    boolean _containsSuffix_9 = this.containsSuffix(this.deleted, "src-gen/X.txt");
    Assert.assertTrue(_containsSuffix_9);
    final Procedure1<BuildRequest> _function_4 = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        URI _uri = IncrementalBuilderTest.this.uri("src/A.buildertestlanguage");
        URI _delete = IncrementalBuilderTest.this.delete(_uri);
        it.setDeletedFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_delete)));
      }
    };
    BuildRequest _newBuildRequest_4 = this.newBuildRequest(_function_4);
    this.build(_newBuildRequest_4);
    String _string_4 = this.issues.toString();
    int _size_7 = this.issues.size();
    Assert.assertEquals(_string_4, 1, _size_7);
    int _size_8 = this.generated.size();
    Assert.assertEquals(0, _size_8);
    int _size_9 = this.deleted.size();
    Assert.assertEquals(1, _size_9);
    boolean _containsSuffix_10 = this.containsSuffix(this.deleted, "src-gen/A.txt");
    Assert.assertTrue(_containsSuffix_10);
  }
}

/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.build;

import com.google.inject.Inject;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.build.BuildRequest;
import org.eclipse.xtext.build.IndexState;
import org.eclipse.xtext.build.Source2GeneratedMapping;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.index.IndexTestLanguageInjectorProvider;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.XtextRunner;
import org.eclipse.xtext.testing.builder.AbstractIncrementalBuilderTest;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(IndexTestLanguageInjectorProvider.class)
@SuppressWarnings("all")
public class IncrementalBuilderTest extends AbstractIncrementalBuilderTest {
  private static class CancelOnFirstModel implements BuildRequest.IPostValidationCallback, CancelIndicator {
    private boolean canceled;
    
    @Override
    public boolean afterValidate(final URI validated, final Iterable<Issue> issues) {
      boolean _xblockexpression = false;
      {
        if (this.canceled) {
          Assert.fail("Builder didn\'t cancel");
        }
        _xblockexpression = this.canceled = true;
      }
      return _xblockexpression;
    }
    
    @Override
    public boolean isCanceled() {
      return this.canceled;
    }
  }
  
  @Inject
  private IResourceServiceProvider.Registry resourceServiceProviderFactory;
  
  @Override
  public IResourceServiceProvider.Registry getLanguages() {
    return this.resourceServiceProviderFactory;
  }
  
  @Test
  public void testNoCleanupBuild() {
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      final Procedure1<OutputConfiguration> _function_1 = (OutputConfiguration it_1) -> {
        it_1.setCleanUpDerivedResources(false);
      };
      this.withOutputConfig(it, _function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("entity B {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("entity A { foo.B myReference }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/MyFile.indextestlanguage", _builder.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus)));
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
    final Procedure1<BuildRequest> _function_1 = (BuildRequest it) -> {
      final Procedure1<OutputConfiguration> _function_2 = (OutputConfiguration it_1) -> {
        it_1.setCleanUpDerivedResources(false);
      };
      this.withOutputConfig(it, _function_2);
      URI _uri = this.uri("src/A.indextestlanguage");
      URI _delete = this.delete(_uri);
      it.setDeletedFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_delete)));
    };
    this.newBuildRequest(_function_1);
    String _string_1 = this.issues.toString();
    boolean _isEmpty_1 = this.issues.isEmpty();
    Assert.assertTrue(_string_1, _isEmpty_1);
    int _size_1 = this.generated.size();
    Assert.assertEquals(2, _size_1);
    Collection<URI> _values_2 = this.generated.values();
    boolean _containsSuffix_2 = this.containsSuffix(_values_2, "src-gen/B.txt");
    Assert.assertTrue(_containsSuffix_2);
    Collection<URI> _values_3 = this.generated.values();
    boolean _containsSuffix_3 = this.containsSuffix(_values_3, "src-gen/A.txt");
    Assert.assertTrue(_containsSuffix_3);
  }
  
  @Test
  public void testGeneratedOnceBuild() {
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      final Procedure1<OutputConfiguration> _function_1 = (OutputConfiguration it_1) -> {
        it_1.setOverrideExistingResources(false);
      };
      this.withOutputConfig(it, _function_1);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("entity B {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("entity A { foo.B myReference }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/MyFile.indextestlanguage", _builder.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus)));
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
    final Procedure1<BuildRequest> _function_1 = (BuildRequest it) -> {
      final Procedure1<OutputConfiguration> _function_2 = (OutputConfiguration it_1) -> {
        it_1.setOverrideExistingResources(false);
      };
      this.withOutputConfig(it, _function_2);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("entity B {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("entity A { foo.B someReference }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/MyFile.indextestlanguage", _builder.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus)));
      final Procedure2<URI, URI> _function_3 = (URI $0, URI $1) -> {
        Assert.fail();
      };
      it.setAfterGenerateFile(_function_3);
    };
    this.newBuildRequest(_function_1);
  }
  
  @Test
  public void testSimpleFullBuild() {
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("entity B {}");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("entity A { foo.B myReference }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/MyFile.indextestlanguage", _builder.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus)));
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
  
  @Test(expected = OperationCanceledException.class)
  public void testCancellation() {
    final IncrementalBuilderTest.CancelOnFirstModel cancelOnFirstModel = new IncrementalBuilderTest.CancelOnFirstModel();
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("entity A { foo.B myReference }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/MyFile.indextestlanguage", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("foo {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("entity B {}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      URI _minus_1 = this.operator_minus(
        "src/MyFile2.indextestlanguage", _builder_1.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1)));
      it.setCancelIndicator(cancelOnFirstModel);
      it.setAfterValidate(cancelOnFirstModel);
    };
    final BuildRequest buildRequest = this.newBuildRequest(_function);
    this.build(buildRequest);
  }
  
  @Test
  public void testIndexOnly() {
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      it.setIndexOnly(true);
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("entity A {}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/MyFile.indextestlanguage", _builder.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus)));
      final BuildRequest.IPostValidationCallback _function_1 = (URI $0, Iterable<Issue> $1) -> {
        throw new IllegalStateException();
      };
      it.setAfterValidate(_function_1);
      final Procedure2<URI, URI> _function_2 = (URI $0, URI $1) -> {
        throw new IllegalStateException();
      };
      it.setAfterGenerateFile(_function_2);
    };
    final BuildRequest buildRequest = this.newBuildRequest(_function);
    final IndexState result = this.build(buildRequest);
    ResourceDescriptionsData _resourceDescriptions = result.getResourceDescriptions();
    Iterable<IResourceDescription> _allResourceDescriptions = _resourceDescriptions.getAllResourceDescriptions();
    int _size = IterableExtensions.size(_allResourceDescriptions);
    Assert.assertEquals(1, _size);
  }
  
  @Test
  public void testDelete_01() {
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("entity A {foo.B references}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/A.indextestlanguage", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("foo {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("entity B");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      URI _minus_1 = this.operator_minus(
        "src/B.indextestlanguage", _builder_1.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1)));
    };
    BuildRequest _newBuildRequest = this.newBuildRequest(_function);
    this.build(_newBuildRequest);
    final AtomicBoolean validateCalled = new AtomicBoolean(false);
    final Procedure1<BuildRequest> _function_1 = (BuildRequest it) -> {
      URI _uri = this.uri("src/B.indextestlanguage");
      it.setDeletedFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_uri)));
      final BuildRequest.IPostValidationCallback _function_2 = (URI uri, Iterable<Issue> issues) -> {
        URI _uri_1 = this.uri("src/A.indextestlanguage");
        Assert.assertEquals(_uri_1, uri);
        String _string = issues.toString();
        Issue _head = IterableExtensions.<Issue>head(issues);
        String _message = _head.getMessage();
        boolean _contains = _message.contains("Couldn\'t resolve reference to Type \'foo.B\'");
        Assert.assertTrue(_string, _contains);
        validateCalled.set(true);
        return false;
      };
      it.setAfterValidate(_function_2);
    };
    BuildRequest _newBuildRequest_1 = this.newBuildRequest(_function_1);
    this.build(_newBuildRequest_1);
    boolean _get = validateCalled.get();
    Assert.assertTrue(_get);
  }
  
  @Test
  public void testIncrementalBuild() {
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("entity A {foo.B reference}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/A.indextestlanguage", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("foo {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("entity B {foo.A reference}");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      URI _minus_1 = this.operator_minus(
        "src/B.indextestlanguage", _builder_1.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1)));
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
    final Procedure1<BuildRequest> _function_1 = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("entity A {foo.B reference}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/A.indextestlanguage", _builder.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus)));
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
    final Procedure1<BuildRequest> _function_2 = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("entity X { foo.B reference }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/A.indextestlanguage", _builder.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus)));
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
    URI _uri = this.uri("src/A.indextestlanguage");
    List<URI> _generated = _fileMappings.getGenerated(_uri);
    int _size_4 = _generated.size();
    Assert.assertEquals(1, _size_4);
    int _size_5 = this.deleted.size();
    Assert.assertEquals(1, _size_5);
    boolean _containsSuffix_6 = this.containsSuffix(this.deleted, "src-gen/A.txt");
    Assert.assertTrue(_containsSuffix_6);
    final Procedure1<BuildRequest> _function_3 = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("foo {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("entity A { foo.B reference }");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/A.indextestlanguage", _builder.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus)));
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
    final Procedure1<BuildRequest> _function_4 = (BuildRequest it) -> {
      URI _uri_1 = this.uri("src/A.indextestlanguage");
      URI _delete = this.delete(_uri_1);
      it.setDeletedFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_delete)));
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

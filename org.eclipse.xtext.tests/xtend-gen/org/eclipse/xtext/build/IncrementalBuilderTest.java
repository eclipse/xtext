/**
 * Copyright (c) 2015, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.build;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicBoolean;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.build.BuildRequest;
import org.eclipse.xtext.build.IndexState;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.index.IndexTestLanguageInjectorProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
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
    Assert.assertTrue(this.issues.toString(), this.issues.isEmpty());
    Assert.assertEquals(2, this.generated.size());
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "src-gen/B.txt"));
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "src-gen/A.txt"));
    final Procedure1<BuildRequest> _function_1 = (BuildRequest it) -> {
      final Procedure1<OutputConfiguration> _function_2 = (OutputConfiguration it_1) -> {
        it_1.setCleanUpDerivedResources(false);
      };
      this.withOutputConfig(it, _function_2);
      URI _delete = this.delete(this.uri("src/A.indextestlanguage"));
      it.setDeletedFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_delete)));
    };
    this.newBuildRequest(_function_1);
    Assert.assertTrue(this.issues.toString(), this.issues.isEmpty());
    Assert.assertEquals(2, this.generated.size());
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "src-gen/B.txt"));
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "src-gen/A.txt"));
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
    Assert.assertTrue(this.issues.toString(), this.issues.isEmpty());
    Assert.assertEquals(2, this.generated.size());
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "src-gen/B.txt"));
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "src-gen/A.txt"));
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
    Assert.assertTrue(this.issues.toString(), this.issues.isEmpty());
    Assert.assertEquals(2, this.generated.size());
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "src-gen/B.txt"));
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "src-gen/A.txt"));
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
    Assert.assertEquals(1, IterableExtensions.size(result.getResourceDescriptions().getAllResourceDescriptions()));
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
    this.build(this.newBuildRequest(_function));
    final AtomicBoolean validateCalled = new AtomicBoolean(false);
    final Procedure1<BuildRequest> _function_1 = (BuildRequest it) -> {
      URI _uri = this.uri("src/B.indextestlanguage");
      it.setDeletedFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_uri)));
      final BuildRequest.IPostValidationCallback _function_2 = (URI uri, Iterable<Issue> issues) -> {
        URI _uri_1 = this.uri("src/A.indextestlanguage");
        boolean _equals = Objects.equal(_uri_1, uri);
        if (_equals) {
          Assert.assertTrue(issues.toString(), IterableExtensions.<Issue>head(issues).getMessage().contains("Couldn\'t resolve reference to Type \'foo.B\'"));
          validateCalled.set(true);
          return false;
        } else {
          URI _uri_2 = this.uri("src/B.indextestlanguage");
          boolean _equals_1 = Objects.equal(_uri_2, uri);
          if (_equals_1) {
            Assert.assertEquals("zero issues expected", 0, IterableExtensions.size(issues));
            return true;
          } else {
            throw new IllegalStateException(("unexpected issues for " + uri));
          }
        }
      };
      it.setAfterValidate(_function_2);
    };
    this.build(this.newBuildRequest(_function_1));
    Assert.assertTrue(validateCalled.get());
  }
  
  @Test
  public void testDeleteClearsReusedResourceSet() {
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("foo {");
      _builder.newLine();
      _builder.append("    ");
      _builder.append("entity A {foo.B references}");
      _builder.newLine();
      _builder.append("}");
      _builder.newLine();
      URI _minus = this.operator_minus(
        "src/A.indextestlanguage", _builder.toString());
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("foo {");
      _builder_1.newLine();
      _builder_1.append("    ");
      _builder_1.append("entity B");
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      URI _minus_1 = this.operator_minus(
        "src/B.indextestlanguage", _builder_1.toString());
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_minus, _minus_1)));
    };
    final BuildRequest req = this.newBuildRequest(_function);
    final XtextResourceSet resourceSet = req.getResourceSet();
    this.build(req);
    final AtomicBoolean validateCalled = new AtomicBoolean(false);
    final Procedure1<BuildRequest> _function_1 = (BuildRequest it) -> {
      URI _uri = this.uri("src/B.indextestlanguage");
      it.setDeletedFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_uri)));
      final BuildRequest.IPostValidationCallback _function_2 = (URI uri, Iterable<Issue> issues) -> {
        URI _uri_1 = this.uri("src/A.indextestlanguage");
        boolean _equals = Objects.equal(_uri_1, uri);
        if (_equals) {
          String _string = issues.toString();
          Assert.assertTrue(_string, ((!IterableExtensions.isEmpty(issues)) && IterableExtensions.<Issue>head(issues).getMessage().contains("Couldn\'t resolve reference to Type \'foo.B\'")));
          validateCalled.set(true);
          return false;
        } else {
          URI _uri_2 = this.uri("src/B.indextestlanguage");
          boolean _equals_1 = Objects.equal(_uri_2, uri);
          if (_equals_1) {
            Assert.assertEquals("zero issues expected", 0, IterableExtensions.size(issues));
            return true;
          } else {
            throw new IllegalStateException(("unexpected issues for " + uri));
          }
        }
      };
      it.setAfterValidate(_function_2);
      it.setResourceSet(resourceSet);
      final ChunkedResourceDescriptions desc = ChunkedResourceDescriptions.findInEmfObject(it.getResourceSet());
      desc.setContainer("test-project", it.getState().getResourceDescriptions());
    };
    this.build(this.newBuildRequest(_function_1));
    Assert.assertTrue(validateCalled.get());
    Assert.assertNull(resourceSet.getResource(this.uri("src/B.indextestlanguage"), false));
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
    this.build(this.newBuildRequest(_function));
    Assert.assertTrue(this.issues.toString(), this.issues.isEmpty());
    Assert.assertEquals(2, this.generated.size());
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "src-gen/B.txt"));
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "src-gen/A.txt"));
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
    this.build(this.newBuildRequest(_function_1));
    Assert.assertTrue(this.issues.toString(), this.issues.isEmpty());
    Assert.assertEquals(1, this.generated.size());
    Assert.assertFalse(this.containsSuffix(this.generated.values(), "src-gen/B.txt"));
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "src-gen/A.txt"));
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
    this.build(this.newBuildRequest(_function_2));
    Assert.assertEquals(this.issues.toString(), 1, this.issues.size());
    Assert.assertEquals(1, this.generated.size());
    Assert.assertFalse(this.containsSuffix(this.generated.values(), "src-gen/B.txt"));
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "src-gen/X.txt"));
    Assert.assertEquals(1, this.indexState.getFileMappings().getGenerated(this.uri("src/A.indextestlanguage")).size());
    Assert.assertEquals(1, this.deleted.size());
    Assert.assertTrue(this.containsSuffix(this.deleted, "src-gen/A.txt"));
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
    this.build(this.newBuildRequest(_function_3));
    Assert.assertTrue(this.issues.toString(), this.issues.isEmpty());
    Assert.assertEquals(2, this.generated.size());
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "src-gen/B.txt"));
    Assert.assertTrue(this.containsSuffix(this.generated.values(), "src-gen/A.txt"));
    Assert.assertTrue(this.containsSuffix(this.deleted, "src-gen/X.txt"));
    final Procedure1<BuildRequest> _function_4 = (BuildRequest it) -> {
      URI _delete = this.delete(this.uri("src/A.indextestlanguage"));
      it.setDeletedFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_delete)));
    };
    this.build(this.newBuildRequest(_function_4));
    Assert.assertEquals(this.issues.toString(), 1, this.issues.size());
    Assert.assertEquals(0, this.generated.size());
    Assert.assertEquals(1, this.deleted.size());
    Assert.assertTrue(this.containsSuffix(this.deleted, "src-gen/A.txt"));
  }
}

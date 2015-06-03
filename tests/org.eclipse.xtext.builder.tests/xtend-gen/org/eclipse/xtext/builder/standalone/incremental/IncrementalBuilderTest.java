/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.common.base.Objects;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.common.io.Files;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.builder.standalone.IIssueHandler;
import org.eclipse.xtext.builder.standalone.ILanguageConfiguration;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.LanguageAccessFactory;
import org.eclipse.xtext.builder.standalone.StandaloneBuilderInjectorProvider;
import org.eclipse.xtext.builder.standalone.StandaloneBuilderTest;
import org.eclipse.xtext.builder.standalone.incremental.BuildRequest;
import org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs;
import org.eclipse.xtext.builder.standalone.incremental.IncrementalBuilder;
import org.eclipse.xtext.builder.standalone.incremental.IndexState;
import org.eclipse.xtext.builder.standalone.incremental.Source2GeneratedMapping;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.TemporaryFolder;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@RunWith(XtextRunner.class)
@InjectWith(StandaloneBuilderInjectorProvider.class)
@SuppressWarnings("all")
public class IncrementalBuilderTest {
  @Rule
  @Inject
  public TemporaryFolder temporaryFolder;
  
  @Inject
  private IncrementalBuilder incrementalBuilder;
  
  @Inject
  private LanguageAccessFactory languageAccessFactory;
  
  @Inject
  private IndexState indexState;
  
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  private File tempDir;
  
  private Multimap<URI, URI> generated;
  
  private List<URI> deleted;
  
  private List<Issue> issues;
  
  @Before
  public void setUp() {
    try {
      File _newFolder = this.temporaryFolder.newFolder();
      this.tempDir = _newFolder;
      this.clean();
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected List<Issue> clean() {
    List<Issue> _xblockexpression = null;
    {
      ArrayListMultimap<URI, URI> _create = ArrayListMultimap.<URI, URI>create();
      this.generated = _create;
      ArrayList<URI> _newArrayList = CollectionLiterals.<URI>newArrayList();
      this.deleted = _newArrayList;
      ArrayList<Issue> _newArrayList_1 = CollectionLiterals.<Issue>newArrayList();
      _xblockexpression = this.issues = _newArrayList_1;
    }
    return _xblockexpression;
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
        it.setDeletedFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_uri)));
      }
    };
    BuildRequest _newBuildRequest_4 = this.newBuildRequest(_function_4);
    this.build(_newBuildRequest_4);
    String _string_4 = this.issues.toString();
    boolean _isEmpty_3 = this.issues.isEmpty();
    Assert.assertTrue(_string_4, _isEmpty_3);
    int _size_7 = this.generated.size();
    Assert.assertEquals(0, _size_7);
    int _size_8 = this.deleted.size();
    Assert.assertEquals(1, _size_8);
    boolean _containsSuffix_10 = this.containsSuffix(this.deleted, "src-gen/A.txt");
    Assert.assertTrue(_containsSuffix_10);
  }
  
  protected IndexState build(final BuildRequest buildRequest) {
    this.clean();
    StandaloneBuilderTest.TestLanguageConfiguration _testLanguageConfiguration = new StandaloneBuilderTest.TestLanguageConfiguration(false);
    Class<? extends IncrementalBuilderTest> _class = this.getClass();
    ClassLoader _classLoader = _class.getClassLoader();
    final Map<String, LanguageAccess> languages = this.languageAccessFactory.createLanguageAccess(Collections.<ILanguageConfiguration>unmodifiableList(CollectionLiterals.<ILanguageConfiguration>newArrayList(_testLanguageConfiguration)), _classLoader);
    IndexState _build = this.incrementalBuilder.build(buildRequest, languages);
    this.indexState = _build;
    return this.indexState;
  }
  
  protected BuildRequest newBuildRequest(final Procedure1<? super BuildRequest> init) {
    BuildRequest _buildRequest = new BuildRequest();
    final Procedure1<BuildRequest> _function = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        URI _asURI = FilesAndURIs.asURI(IncrementalBuilderTest.this.tempDir);
        it.setBaseDir(_asURI);
        it.setDefaultEncoding("UTF-8");
        XtextResourceSet _get = IncrementalBuilderTest.this.resourceSetProvider.get();
        it.setResourceSet(_get);
        it.setClassPath(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList()));
        File _file = new File(IncrementalBuilderTest.this.tempDir, "out");
        URI _asURI_1 = FilesAndURIs.asURI(_file);
        it.setOutputs(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_asURI_1)));
        File _file_1 = new File(IncrementalBuilderTest.this.tempDir, "src");
        URI _asURI_2 = FilesAndURIs.asURI(_file_1);
        it.setSourceRoots(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_asURI_2)));
        it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList()));
        it.setDeletedFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList()));
        final IIssueHandler _function = new IIssueHandler() {
          @Override
          public boolean handleIssue(final Iterable<Issue> issues) {
            Iterables.<Issue>addAll(IncrementalBuilderTest.this.issues, issues);
            return IterableExtensions.isEmpty(issues);
          }
        };
        it.setIssueHandler(_function);
        final Procedure1<URI> _function_1 = new Procedure1<URI>() {
          @Override
          public void apply(final URI it) {
            IncrementalBuilderTest.this.deleted.add(it);
          }
        };
        it.setAfterDeleteFile(_function_1);
        final Procedure2<URI, URI> _function_2 = new Procedure2<URI, URI>() {
          @Override
          public void apply(final URI source, final URI target) {
            IncrementalBuilderTest.this.generated.put(source, target);
          }
        };
        it.setAfterGenerateFile(_function_2);
        it.setPreviousState(IncrementalBuilderTest.this.indexState);
        it.setFailOnValidationError(false);
      }
    };
    final BuildRequest result = ObjectExtensions.<BuildRequest>operator_doubleArrow(_buildRequest, _function);
    init.apply(result);
    return result;
  }
  
  protected URI uri(final String path) {
    File _file = new File(this.tempDir, path);
    return FilesAndURIs.asURI(_file);
  }
  
  protected URI operator_minus(final String path, final String content) {
    try {
      final File file = new File(this.tempDir, path);
      boolean _exists = file.exists();
      if (_exists) {
        file.delete();
      }
      File _parentFile = file.getParentFile();
      this.mkdirIfNeccessary(_parentFile);
      file.createNewFile();
      Charset _forName = Charset.forName("UTF-8");
      Files.write(content, file, _forName);
      return FilesAndURIs.asURI(file);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected boolean containsSuffix(final Iterable<? extends URI> uris, final String... suffixes) {
    final Function1<String, Boolean> _function = new Function1<String, Boolean>() {
      @Override
      public Boolean apply(final String suffix) {
        final Function1<URI, Boolean> _function = new Function1<URI, Boolean>() {
          @Override
          public Boolean apply(final URI uri) {
            String _string = uri.toString();
            return Boolean.valueOf(_string.endsWith(suffix));
          }
        };
        return Boolean.valueOf(IterableExtensions.exists(uris, _function));
      }
    };
    return IterableExtensions.<String>forall(((Iterable<String>)Conversions.doWrapArray(suffixes)), _function);
  }
  
  private void mkdirIfNeccessary(final File file) {
    boolean _or = false;
    boolean _equals = Objects.equal(file, null);
    if (_equals) {
      _or = true;
    } else {
      boolean _exists = file.exists();
      _or = _exists;
    }
    if (_or) {
      return;
    }
    File _parentFile = file.getParentFile();
    this.mkdirIfNeccessary(_parentFile);
    file.mkdir();
  }
}

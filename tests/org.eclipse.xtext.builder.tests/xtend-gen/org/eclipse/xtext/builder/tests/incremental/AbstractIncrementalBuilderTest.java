/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.tests.incremental;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.incremental.BuildRequest;
import org.eclipse.xtext.builder.standalone.incremental.IncrementalBuilder;
import org.eclipse.xtext.builder.standalone.incremental.IndexState;
import org.eclipse.xtext.junit4.util.InMemoryURIHandler;
import org.eclipse.xtext.resource.FileExtensionProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
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
import org.junit.Before;

/**
 * Abstract base class for testing incremental builder.
 */
@SuppressWarnings("all")
public abstract class AbstractIncrementalBuilderTest {
  @Inject
  protected IncrementalBuilder incrementalBuilder;
  
  @Inject
  protected IndexState indexState;
  
  @Inject
  protected Provider<XtextResourceSet> resourceSetProvider;
  
  protected Multimap<URI, URI> generated;
  
  protected List<URI> deleted;
  
  protected List<Issue> issues;
  
  protected InMemoryURIHandler inMemoryURIHandler;
  
  @Before
  public void setUp() {
    this.clean();
    InMemoryURIHandler _inMemoryURIHandler = new InMemoryURIHandler();
    this.inMemoryURIHandler = _inMemoryURIHandler;
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
  
  protected IndexState build(final BuildRequest buildRequest) {
    this.clean();
    Iterable<? extends LanguageAccess> _languages = this.getLanguages();
    final Function1<LanguageAccess, String> _function = new Function1<LanguageAccess, String>() {
      @Override
      public String apply(final LanguageAccess it) {
        IResourceServiceProvider _resourceServiceProvider = it.getResourceServiceProvider();
        FileExtensionProvider _get = _resourceServiceProvider.<FileExtensionProvider>get(FileExtensionProvider.class);
        return _get.getPrimaryFileExtension();
      }
    };
    final Map<String, LanguageAccess> languages = IterableExtensions.<String, LanguageAccess>toMap(_languages, _function);
    IncrementalBuilder.Result _build = this.incrementalBuilder.build(buildRequest, languages);
    IndexState _indexState = _build.getIndexState();
    this.indexState = _indexState;
    return this.indexState;
  }
  
  protected abstract Iterable<? extends LanguageAccess> getLanguages();
  
  protected BuildRequest newBuildRequest(final Procedure1<? super BuildRequest> init) {
    BuildRequest _buildRequest = new BuildRequest();
    final Procedure1<BuildRequest> _function = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        URI _uri = AbstractIncrementalBuilderTest.this.uri("");
        it.setBaseDir(_uri);
        XtextResourceSet _get = AbstractIncrementalBuilderTest.this.resourceSetProvider.get();
        final Procedure1<XtextResourceSet> _function = new Procedure1<XtextResourceSet>() {
          @Override
          public void apply(final XtextResourceSet it) {
            URIConverter _uRIConverter = it.getURIConverter();
            EList<URIHandler> _uRIHandlers = _uRIConverter.getURIHandlers();
            _uRIHandlers.clear();
            URIConverter _uRIConverter_1 = it.getURIConverter();
            EList<URIHandler> _uRIHandlers_1 = _uRIConverter_1.getURIHandlers();
            _uRIHandlers_1.add(AbstractIncrementalBuilderTest.this.inMemoryURIHandler);
            ClassLoader _classLoader = AbstractIncrementalBuilderTest.class.getClassLoader();
            it.setClasspathURIContext(_classLoader);
          }
        };
        XtextResourceSet _doubleArrow = ObjectExtensions.<XtextResourceSet>operator_doubleArrow(_get, _function);
        it.setResourceSet(_doubleArrow);
        it.setClassPath(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList()));
        URI _uri_1 = AbstractIncrementalBuilderTest.this.uri("out");
        it.setOutputs(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(_uri_1)));
        it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList()));
        it.setDeletedFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList()));
        final BuildRequest.IPostValidationCallback _function_1 = new BuildRequest.IPostValidationCallback() {
          @Override
          public boolean afterValidate(final URI uri, final Iterable<Issue> issues) {
            Iterables.<Issue>addAll(AbstractIncrementalBuilderTest.this.issues, issues);
            return IterableExtensions.isEmpty(issues);
          }
        };
        it.setAfterValidate(_function_1);
        final Procedure1<URI> _function_2 = new Procedure1<URI>() {
          @Override
          public void apply(final URI it) {
            AbstractIncrementalBuilderTest.this.deleted.add(it);
          }
        };
        it.setAfterDeleteFile(_function_2);
        final Procedure2<URI, URI> _function_3 = new Procedure2<URI, URI>() {
          @Override
          public void apply(final URI source, final URI target) {
            AbstractIncrementalBuilderTest.this.generated.put(source, target);
          }
        };
        it.setAfterGenerateFile(_function_3);
        it.setPreviousState(AbstractIncrementalBuilderTest.this.indexState);
      }
    };
    final BuildRequest result = ObjectExtensions.<BuildRequest>operator_doubleArrow(_buildRequest, _function);
    init.apply(result);
    return result;
  }
  
  protected URI delete(final URI uri) {
    try {
      Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
      this.inMemoryURIHandler.delete(uri, _emptyMap);
      return uri;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected URI uri(final String path) {
    return URI.createURI(((InMemoryURIHandler.SCHEME + ":/") + path));
  }
  
  protected URI operator_minus(final String path, final String content) {
    try {
      final URI uri = this.uri(path);
      Map<Object, Object> _emptyMap = CollectionLiterals.<Object, Object>emptyMap();
      OutputStream _createOutputStream = this.inMemoryURIHandler.createOutputStream(uri, _emptyMap);
      final Procedure1<OutputStream> _function = new Procedure1<OutputStream>() {
        @Override
        public void apply(final OutputStream it) {
          try {
            byte[] _bytes = content.getBytes();
            it.write(_bytes);
            it.close();
          } catch (Throwable _e) {
            throw Exceptions.sneakyThrow(_e);
          }
        }
      };
      ObjectExtensions.<OutputStream>operator_doubleArrow(_createOutputStream, _function);
      return uri;
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
}

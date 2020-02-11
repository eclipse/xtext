/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.testing.builder;

import com.google.common.annotations.Beta;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;
import java.io.OutputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.URIHandler;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.build.BuildRequest;
import org.eclipse.xtext.build.IncrementalBuilder;
import org.eclipse.xtext.build.IndexState;
import org.eclipse.xtext.build.Source2GeneratedMapping;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.OutputConfigurationAdapter;
import org.eclipse.xtext.generator.OutputConfigurationProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.testing.util.InMemoryURIHandler;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Pair;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;

/**
 * Abstract base class for testing languages in the incremental builder.
 * 
 * @noreference
 * @noimplement
 */
@Beta
@SuppressWarnings("all")
public abstract class AbstractIncrementalBuilderTest {
  @Inject
  protected IncrementalBuilder incrementalBuilder;
  
  @Inject
  protected IndexState indexState;
  
  @Inject
  protected Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  @Named(Constants.LANGUAGE_NAME)
  private String languageName;
  
  @Inject
  private OutputConfigurationProvider configurationProvider;
  
  protected Multimap<URI, URI> generated;
  
  protected List<URI> deleted;
  
  protected List<Issue> issues;
  
  protected InMemoryURIHandler inMemoryURIHandler;
  
  @Before
  @BeforeEach
  public void setUp() {
    this.clean();
    InMemoryURIHandler _inMemoryURIHandler = new InMemoryURIHandler();
    this.inMemoryURIHandler = _inMemoryURIHandler;
  }
  
  protected List<Issue> clean() {
    List<Issue> _xblockexpression = null;
    {
      this.generated = ArrayListMultimap.<URI, URI>create();
      this.deleted = CollectionLiterals.<URI>newArrayList();
      _xblockexpression = this.issues = CollectionLiterals.<Issue>newArrayList();
    }
    return _xblockexpression;
  }
  
  protected IndexState build(final BuildRequest buildRequest) {
    this.clean();
    final Function1<URI, IResourceServiceProvider> _function = (URI it) -> {
      return this.getLanguages().getResourceServiceProvider(it);
    };
    this.indexState = this.incrementalBuilder.build(buildRequest, _function).getIndexState();
    return this.indexState;
  }
  
  protected void withOutputConfig(final BuildRequest it, final Procedure1<? super OutputConfiguration> init) {
    final OutputConfiguration config = IterableExtensions.<OutputConfiguration>head(this.configurationProvider.getOutputConfigurations());
    init.apply(config);
    Pair<String, Set<OutputConfiguration>> _mappedTo = Pair.<String, Set<OutputConfiguration>>of(this.languageName, Collections.<OutputConfiguration>unmodifiableSet(CollectionLiterals.<OutputConfiguration>newHashSet(config)));
    final OutputConfigurationAdapter adapter = new OutputConfigurationAdapter(Collections.<String, Set<OutputConfiguration>>unmodifiableMap(CollectionLiterals.<String, Set<OutputConfiguration>>newHashMap(_mappedTo)));
    EList<Adapter> _eAdapters = it.getResourceSet().eAdapters();
    _eAdapters.add(adapter);
  }
  
  protected abstract IResourceServiceProvider.Registry getLanguages();
  
  protected BuildRequest newBuildRequest(final Procedure1<? super BuildRequest> init) {
    BuildRequest _buildRequest = new BuildRequest();
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      final ResourceDescriptionsData newIndex = this.indexState.getResourceDescriptions().copy();
      it.setBaseDir(this.uri(""));
      XtextResourceSet _get = this.resourceSetProvider.get();
      final Procedure1<XtextResourceSet> _function_1 = (XtextResourceSet it_1) -> {
        it_1.getURIConverter().getURIHandlers().clear();
        EList<URIHandler> _uRIHandlers = it_1.getURIConverter().getURIHandlers();
        _uRIHandlers.add(this.inMemoryURIHandler);
        it_1.setClasspathURIContext(AbstractIncrementalBuilderTest.class.getClassLoader());
        ProjectDescription _projectDescription = new ProjectDescription();
        final Procedure1<ProjectDescription> _function_2 = (ProjectDescription it_2) -> {
          it_2.setName("test-project");
        };
        final ProjectDescription projectDescription = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription, _function_2);
        projectDescription.attachToEmfObject(it_1);
        Map<String, ResourceDescriptionsData> _emptyMap = CollectionLiterals.<String, ResourceDescriptionsData>emptyMap();
        final ChunkedResourceDescriptions index = new ChunkedResourceDescriptions(_emptyMap, it_1);
        index.setContainer(projectDescription.getName(), newIndex);
      };
      XtextResourceSet _doubleArrow = ObjectExtensions.<XtextResourceSet>operator_doubleArrow(_get, _function_1);
      it.setResourceSet(_doubleArrow);
      it.setDirtyFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList()));
      it.setDeletedFiles(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList()));
      final BuildRequest.IPostValidationCallback _function_2 = (URI uri, Iterable<Issue> issues) -> {
        Iterables.<Issue>addAll(this.issues, issues);
        return IterableExtensions.isEmpty(issues);
      };
      it.setAfterValidate(_function_2);
      final Procedure1<URI> _function_3 = (URI it_1) -> {
        this.deleted.add(it_1);
      };
      it.setAfterDeleteFile(_function_3);
      final Procedure2<URI, URI> _function_4 = (URI source, URI target) -> {
        this.generated.put(source, target);
      };
      it.setAfterGenerateFile(_function_4);
      Source2GeneratedMapping _copy = this.indexState.getFileMappings().copy();
      IndexState _indexState = new IndexState(newIndex, _copy);
      it.setState(_indexState);
    };
    final BuildRequest result = ObjectExtensions.<BuildRequest>operator_doubleArrow(_buildRequest, _function);
    init.apply(result);
    return result;
  }
  
  protected URI delete(final URI uri) {
    try {
      this.inMemoryURIHandler.delete(uri, CollectionLiterals.<Object, Object>emptyMap());
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
      OutputStream _createOutputStream = this.inMemoryURIHandler.createOutputStream(uri, CollectionLiterals.<Object, Object>emptyMap());
      final Procedure1<OutputStream> _function = (OutputStream it) -> {
        try {
          it.write(content.getBytes());
          it.close();
        } catch (Throwable _e) {
          throw Exceptions.sneakyThrow(_e);
        }
      };
      ObjectExtensions.<OutputStream>operator_doubleArrow(_createOutputStream, _function);
      return uri;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  protected boolean containsSuffix(final Iterable<? extends URI> uris, final String... suffixes) {
    final Function1<String, Boolean> _function = (String suffix) -> {
      final Function1<URI, Boolean> _function_1 = (URI uri) -> {
        return Boolean.valueOf(uri.toString().endsWith(suffix));
      };
      return Boolean.valueOf(IterableExtensions.exists(uris, _function_1));
    };
    return IterableExtensions.<String>forall(((Iterable<String>)Conversions.doWrapArray(suffixes)), _function);
  }
}

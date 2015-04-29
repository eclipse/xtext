/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.incremental.BuildContext;
import org.eclipse.xtext.builder.standalone.incremental.BuildRequest;
import org.eclipse.xtext.builder.standalone.incremental.IJavaDependencyFinder;
import org.eclipse.xtext.builder.standalone.incremental.JavaSupport;
import org.eclipse.xtext.builder.standalone.incremental.ResolvedResourceDescription;
import org.eclipse.xtext.builder.standalone.incremental.ResourceURICollector;
import org.eclipse.xtext.builder.standalone.incremental.Source2GeneratedMapping;
import org.eclipse.xtext.mwe.ResourceDescriptionsProvider;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 */
@Singleton
@SuppressWarnings("all")
public class Indexer {
  private final static Logger LOG = Logger.getLogger(Indexer.class);
  
  @Inject
  private ResourceURICollector uriCollector;
  
  @Inject
  private JavaSupport javaSupport;
  
  @Inject
  private CompilerPhases compilerPhases;
  
  @Inject
  private ResourceDescriptionsProvider resourceDescriptionsProvider;
  
  @Inject
  private IJavaDependencyFinder javaDependencyFinder;
  
  @Inject
  private Source2GeneratedMapping source2GeneratedMapping;
  
  private ResourceDescriptionsData index;
  
  public Iterable<URI> computeAndIndexAffected(final BuildRequest request, @Extension final BuildContext context) {
    boolean _or = false;
    boolean _isFullBuild = request.isFullBuild();
    if (_isFullBuild) {
      _or = true;
    } else {
      boolean _equals = Objects.equal(this.index, null);
      _or = _equals;
    }
    final boolean fullBuild = _or;
    Indexer.LOG.info("Creating new index");
    ResourceDescriptionsData _elvis = null;
    ResourceDescriptionsData _copy = null;
    if (this.index!=null) {
      _copy=this.index.copy();
    }
    if (_copy != null) {
      _elvis = _copy;
    } else {
      ArrayList<IResourceDescription> _newArrayList = CollectionLiterals.<IResourceDescription>newArrayList();
      ResourceDescriptionsData _resourceDescriptionsData = new ResourceDescriptionsData(_newArrayList);
      _elvis = _resourceDescriptionsData;
    }
    final ResourceDescriptionsData newIndex = _elvis;
    XtextResourceSet _resourceSet = context.getResourceSet();
    final IResourceDescriptions resourceDescriptions = this.installIndex(_resourceSet, newIndex);
    final Iterable<URI> allResources = this.uriCollector.collectAllResources(request, context);
    Map<String, LanguageAccess> _languages = context.getLanguages();
    Set<Map.Entry<String, LanguageAccess>> _entrySet = _languages.entrySet();
    final Function1<Map.Entry<String, LanguageAccess>, Boolean> _function = new Function1<Map.Entry<String, LanguageAccess>, Boolean>() {
      @Override
      public Boolean apply(final Map.Entry<String, LanguageAccess> it) {
        LanguageAccess _value = it.getValue();
        return Boolean.valueOf(_value.isLinksAgainstJava());
      }
    };
    Iterable<Map.Entry<String, LanguageAccess>> _filter = IterableExtensions.<Map.Entry<String, LanguageAccess>>filter(_entrySet, _function);
    final Function1<Map.Entry<String, LanguageAccess>, String> _function_1 = new Function1<Map.Entry<String, LanguageAccess>, String>() {
      @Override
      public String apply(final Map.Entry<String, LanguageAccess> it) {
        return it.getKey();
      }
    };
    Iterable<String> _map = IterableExtensions.<Map.Entry<String, LanguageAccess>, String>map(_filter, _function_1);
    final Set<String> jvmLanguageExtensions = IterableExtensions.<String>toSet(_map);
    final HashSet<URI> affectionCandidates = CollectionLiterals.<URI>newHashSet();
    Iterable<URI> directlyAffected = null;
    boolean isConsiderJava = false;
    if (fullBuild) {
      directlyAffected = allResources;
      final Function1<URI, Boolean> _function_2 = new Function1<URI, Boolean>() {
        @Override
        public Boolean apply(final URI it) {
          String _fileExtension = it.fileExtension();
          return Boolean.valueOf(jvmLanguageExtensions.contains(_fileExtension));
        }
      };
      boolean _exists = IterableExtensions.<URI>exists(allResources, _function_2);
      isConsiderJava = _exists;
    } else {
      List<URI> _dirtyFiles = request.getDirtyFiles();
      List<URI> _deletedFiles = request.getDeletedFiles();
      Iterable<URI> _plus = Iterables.<URI>concat(_dirtyFiles, _deletedFiles);
      final Set<URI> allModified = IterableExtensions.<URI>toSet(_plus);
      final Function1<URI, Boolean> _function_3 = new Function1<URI, Boolean>() {
        @Override
        public Boolean apply(final URI it) {
          boolean _contains = allModified.contains(it);
          return Boolean.valueOf((!_contains));
        }
      };
      Iterable<URI> _filter_1 = IterableExtensions.<URI>filter(allResources, _function_3);
      Iterables.<URI>addAll(affectionCandidates, _filter_1);
      List<URI> _dirtyFiles_1 = request.getDirtyFiles();
      directlyAffected = _dirtyFiles_1;
      final Function1<URI, Boolean> _function_4 = new Function1<URI, Boolean>() {
        @Override
        public Boolean apply(final URI it) {
          String _fileExtension = it.fileExtension();
          return Boolean.valueOf(jvmLanguageExtensions.contains(_fileExtension));
        }
      };
      boolean _exists_1 = IterableExtensions.<URI>exists(allModified, _function_4);
      isConsiderJava = _exists_1;
    }
    Indexer.LOG.info("Removing deleted files from index");
    final ArrayList<IResourceDescription.Delta> currentDeltas = CollectionLiterals.<IResourceDescription.Delta>newArrayList();
    List<URI> _deletedFiles_1 = request.getDeletedFiles();
    final Procedure1<URI> _function_5 = new Procedure1<URI>() {
      @Override
      public void apply(final URI it) {
        String _fileExtension = it.fileExtension();
        boolean _notEquals = (!Objects.equal(_fileExtension, "java"));
        if (_notEquals) {
          final IResourceDescription oldDescription = Indexer.this.index.getResourceDescription(it);
          boolean _notEquals_1 = (!Objects.equal(oldDescription, null));
          if (_notEquals_1) {
            DefaultResourceDescriptionDelta _defaultResourceDescriptionDelta = new DefaultResourceDescriptionDelta(oldDescription, null);
            currentDeltas.add(_defaultResourceDescriptionDelta);
          }
          newIndex.removeDescription(it);
        }
      }
    };
    IterableExtensions.<URI>forEach(_deletedFiles_1, _function_5);
    final HashSet<URI> allAffected = CollectionLiterals.<URI>newHashSet();
    Iterables.<URI>addAll(allAffected, directlyAffected);
    if (isConsiderJava) {
      List<URI> _sourceRoots = request.getSourceRoots();
      List<URI> _outputs = request.getOutputs();
      Iterable<URI> _plus_1 = Iterables.<URI>concat(_sourceRoots, _outputs);
      List<URI> _classPath = request.getClassPath();
      Iterable<URI> _plus_2 = Iterables.<URI>concat(_plus_1, _classPath);
      XtextResourceSet _resourceSet_1 = context.getResourceSet();
      this.javaSupport.installLocalOnlyTypeProvider(_plus_2, _resourceSet_1);
    }
    this.preIndexChangedResources(directlyAffected, newIndex, request, context);
    if (isConsiderJava) {
      final URI preCompiledClasses = this.javaSupport.preCompileJavaFiles(directlyAffected, newIndex, request, context);
      List<URI> _sourceRoots_1 = request.getSourceRoots();
      Iterable<URI> _plus_3 = Iterables.<URI>concat(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(preCompiledClasses)), _sourceRoots_1);
      List<URI> _outputs_1 = request.getOutputs();
      Iterable<URI> _plus_4 = Iterables.<URI>concat(_plus_3, _outputs_1);
      List<URI> _classPath_1 = request.getClassPath();
      Iterable<URI> _plus_5 = Iterables.<URI>concat(_plus_4, _classPath_1);
      XtextResourceSet _resourceSet_2 = context.getResourceSet();
      this.javaSupport.installTypeProvider(_plus_5, _resourceSet_2);
    }
    Indexer.LOG.info("Indexing changed and added files");
    final ArrayList<URI> toBeIndexed = CollectionLiterals.<URI>newArrayList();
    Iterables.<URI>addAll(toBeIndexed, directlyAffected);
    final HashSet<IResourceDescription.Delta> allDeltas = CollectionLiterals.<IResourceDescription.Delta>newHashSet();
    while ((!toBeIndexed.isEmpty())) {
      {
        allAffected.addAll(toBeIndexed);
        final Function1<Resource, Object> _function_6 = new Function1<Resource, Object>() {
          @Override
          public Object apply(final Resource resource) {
            Object _xblockexpression = null;
            {
              URI _uRI = resource.getURI();
              String _plus = ("Indexing " + _uRI);
              Indexer.LOG.info(_plus);
              DefaultResourceDescriptionDelta _addToIndex = Indexer.this.addToIndex(resource, false, newIndex, context);
              currentDeltas.add(_addToIndex);
              _xblockexpression = null;
            }
            return _xblockexpression;
          }
        };
        context.<Object>executeClustered(toBeIndexed, _function_6);
        toBeIndexed.clear();
        Iterables.<IResourceDescription.Delta>addAll(allDeltas, currentDeltas);
        if (isConsiderJava) {
        }
        final Function1<URI, Boolean> _function_7 = new Function1<URI, Boolean>() {
          @Override
          public Boolean apply(final URI it) {
            boolean _xblockexpression = false;
            {
              String _fileExtension = it.fileExtension();
              boolean _equals = Objects.equal(_fileExtension, "java");
              if (_equals) {
                return Boolean.valueOf(false);
              }
              Map<String, LanguageAccess> _languages = context.getLanguages();
              String _fileExtension_1 = it.fileExtension();
              LanguageAccess _get = _languages.get(_fileExtension_1);
              final IResourceDescription.Manager manager = _get.getResourceDescriptionManager();
              final IResourceDescription resourceDescription = Indexer.this.index.getResourceDescription(it);
              _xblockexpression = Indexer.this.isAffected(resourceDescription, manager, currentDeltas, allDeltas, resourceDescriptions);
            }
            return Boolean.valueOf(_xblockexpression);
          }
        };
        Iterable<URI> _filter_2 = IterableExtensions.<URI>filter(affectionCandidates, _function_7);
        Iterables.<URI>addAll(toBeIndexed, _filter_2);
        affectionCandidates.removeAll(toBeIndexed);
        currentDeltas.clear();
        boolean _isEmpty = toBeIndexed.isEmpty();
        boolean _not = (!_isEmpty);
        if (_not) {
          Indexer.LOG.info("Indexing affected files");
        }
      }
    }
    this.index = newIndex;
    return allAffected;
  }
  
  protected Iterable<Object> preIndexChangedResources(final Iterable<URI> directlyAffected, final ResourceDescriptionsData newIndex, final BuildRequest request, @Extension final BuildContext context) {
    Iterable<Object> _xblockexpression = null;
    {
      Indexer.LOG.info("Pre-indexing changed files");
      Iterable<Object> _xtrycatchfinallyexpression = null;
      try {
        Iterable<Object> _xblockexpression_1 = null;
        {
          XtextResourceSet _resourceSet = context.getResourceSet();
          this.compilerPhases.setIndexing(_resourceSet, true);
          final Function1<Resource, Object> _function = new Function1<Resource, Object>() {
            @Override
            public Object apply(final Resource it) {
              Object _xblockexpression = null;
              {
                Indexer.this.addToIndex(it, true, newIndex, context);
                _xblockexpression = null;
              }
              return _xblockexpression;
            }
          };
          _xblockexpression_1 = context.<Object>executeClustered(directlyAffected, _function);
        }
        _xtrycatchfinallyexpression = _xblockexpression_1;
      } finally {
        XtextResourceSet _resourceSet = context.getResourceSet();
        this.compilerPhases.setIndexing(_resourceSet, false);
      }
      _xblockexpression = _xtrycatchfinallyexpression;
    }
    return _xblockexpression;
  }
  
  protected DefaultResourceDescriptionDelta addToIndex(final Resource resource, final boolean isPreIndexing, final ResourceDescriptionsData newIndex, final BuildContext context) {
    DefaultResourceDescriptionDelta _xblockexpression = null;
    {
      final URI uri = resource.getURI();
      Map<String, LanguageAccess> _languages = context.getLanguages();
      String _fileExtension = uri.fileExtension();
      final LanguageAccess languageAccess = _languages.get(_fileExtension);
      final IResourceDescription.Manager manager = languageAccess.getResourceDescriptionManager();
      final IResourceDescription newDescription = manager.getResourceDescription(resource);
      IResourceDescription _xifexpression = null;
      if (isPreIndexing) {
        _xifexpression = new ResolvedResourceDescription(newDescription);
      } else {
        _xifexpression = newDescription;
      }
      final IResourceDescription toBeAdded = _xifexpression;
      newIndex.addDescription(uri, toBeAdded);
      IResourceDescription _resourceDescription = null;
      if (this.index!=null) {
        _resourceDescription=this.index.getResourceDescription(uri);
      }
      final DefaultResourceDescriptionDelta delta = new DefaultResourceDescriptionDelta(_resourceDescription, toBeAdded);
      _xblockexpression = delta;
    }
    return _xblockexpression;
  }
  
  protected IResourceDescriptions installIndex(final XtextResourceSet resourceSet, final ResourceDescriptionsData index) {
    IResourceDescriptions _xblockexpression = null;
    {
      ResourceDescriptionsData.ResourceSetAdapter.installResourceDescriptionsData(resourceSet, index);
      _xblockexpression = this.resourceDescriptionsProvider.get(resourceSet);
    }
    return _xblockexpression;
  }
  
  protected boolean isAffected(final IResourceDescription affectionCandidate, final IResourceDescription.Manager manager, final Collection<IResourceDescription.Delta> newDeltas, final Collection<IResourceDescription.Delta> allDeltas, final IResourceDescriptions resourceDescriptions) {
    if ((manager instanceof IResourceDescription.Manager.AllChangeAware)) {
      return ((IResourceDescription.Manager.AllChangeAware)manager).isAffectedByAny(allDeltas, affectionCandidate, resourceDescriptions);
    } else {
      boolean _isEmpty = newDeltas.isEmpty();
      if (_isEmpty) {
        return false;
      } else {
        return manager.isAffected(newDeltas, affectionCandidate, resourceDescriptions);
      }
    }
  }
}

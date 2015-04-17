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
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
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
import org.eclipse.xtext.builder.standalone.incremental.JavaSupport;
import org.eclipse.xtext.builder.standalone.incremental.ResolvedResourceDescription;
import org.eclipse.xtext.builder.standalone.incremental.ResourceURICollector;
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
  
  private ResourceDescriptionsData index;
  
  public Iterable<URI> computeAndIndexAffected(final BuildRequest request, @Extension final BuildContext context) {
    final boolean needsJava = context.isNeedsJava();
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
    final HashSet<URI> affectionCandidates = CollectionLiterals.<URI>newHashSet();
    if ((!fullBuild)) {
      List<URI> _dirtyFiles = request.getDirtyFiles();
      List<URI> _deletedFiles = request.getDeletedFiles();
      Iterable<URI> _plus = Iterables.<URI>concat(_dirtyFiles, _deletedFiles);
      final Set<URI> allModified = IterableExtensions.<URI>toSet(_plus);
      final Function1<URI, Boolean> _function = new Function1<URI, Boolean>() {
        @Override
        public Boolean apply(final URI it) {
          boolean _contains = allModified.contains(it);
          return Boolean.valueOf((!_contains));
        }
      };
      Iterable<URI> _filter = IterableExtensions.<URI>filter(allResources, _function);
      Iterables.<URI>addAll(affectionCandidates, _filter);
    }
    Iterable<URI> _xifexpression = null;
    if (fullBuild) {
      _xifexpression = allResources;
    } else {
      _xifexpression = request.getDirtyFiles();
    }
    final Iterable<URI> directlyAffected = _xifexpression;
    Indexer.LOG.info("Removing deleted files from index");
    final ArrayList<IResourceDescription.Delta> currentDeltas = CollectionLiterals.<IResourceDescription.Delta>newArrayList();
    List<URI> _deletedFiles_1 = request.getDeletedFiles();
    final Procedure1<URI> _function_1 = new Procedure1<URI>() {
      @Override
      public void apply(final URI it) {
        final IResourceDescription oldDescription = Indexer.this.index.getResourceDescription(it);
        boolean _notEquals = (!Objects.equal(oldDescription, null));
        if (_notEquals) {
          DefaultResourceDescriptionDelta _defaultResourceDescriptionDelta = new DefaultResourceDescriptionDelta(oldDescription, null);
          currentDeltas.add(_defaultResourceDescriptionDelta);
        }
        newIndex.removeDescription(it);
      }
    };
    IterableExtensions.<URI>forEach(_deletedFiles_1, _function_1);
    final HashSet<URI> allAffected = CollectionLiterals.<URI>newHashSet();
    Iterables.<URI>addAll(allAffected, directlyAffected);
    if (needsJava) {
      this.preprocessJavaResources(directlyAffected, newIndex, request, context);
    }
    Indexer.LOG.info("Indexing changed and added files");
    final ArrayList<URI> toBeIndexed = CollectionLiterals.<URI>newArrayList();
    Iterables.<URI>addAll(toBeIndexed, directlyAffected);
    final HashSet<IResourceDescription.Delta> allDeltas = CollectionLiterals.<IResourceDescription.Delta>newHashSet();
    while ((!toBeIndexed.isEmpty())) {
      {
        allAffected.addAll(toBeIndexed);
        final Function1<Resource, Object> _function_2 = new Function1<Resource, Object>() {
          @Override
          public Object apply(final Resource resource) {
            Object _xblockexpression = null;
            {
              DefaultResourceDescriptionDelta _addToIndex = Indexer.this.addToIndex(resource, newIndex, context);
              currentDeltas.add(_addToIndex);
              _xblockexpression = null;
            }
            return _xblockexpression;
          }
        };
        context.<Object>executeClustered(toBeIndexed, _function_2);
        toBeIndexed.clear();
        Iterables.<IResourceDescription.Delta>addAll(allDeltas, currentDeltas);
        final Function1<URI, Boolean> _function_3 = new Function1<URI, Boolean>() {
          @Override
          public Boolean apply(final URI it) {
            boolean _xblockexpression = false;
            {
              Map<String, LanguageAccess> _languages = context.getLanguages();
              String _fileExtension = it.fileExtension();
              LanguageAccess _get = _languages.get(_fileExtension);
              final IResourceDescription.Manager manager = _get.getResourceDescriptionManager();
              final IResourceDescription resourceDescription = Indexer.this.index.getResourceDescription(it);
              _xblockexpression = Indexer.this.isAffected(resourceDescription, manager, currentDeltas, allDeltas, resourceDescriptions);
            }
            return Boolean.valueOf(_xblockexpression);
          }
        };
        Iterable<URI> _filter_1 = IterableExtensions.<URI>filter(affectionCandidates, _function_3);
        Iterables.<URI>addAll(toBeIndexed, _filter_1);
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
  
  protected void preprocessJavaResources(final Iterable<URI> directlyAffected, final ResourceDescriptionsData newIndex, final BuildRequest request, @Extension final BuildContext context) {
    Indexer.LOG.info("Pre-indexing changed files");
    List<File> _sourceRoots = request.getSourceRoots();
    List<File> _classPath = request.getClassPath();
    final Iterable<File> allClasspathRoots = Iterables.<File>concat(_sourceRoots, _classPath);
    XtextResourceSet _resourceSet = context.getResourceSet();
    this.javaSupport.installLocalOnlyTypeProvider(allClasspathRoots, _resourceSet);
    try {
      XtextResourceSet _resourceSet_1 = context.getResourceSet();
      this.compilerPhases.setIndexing(_resourceSet_1, true);
      final Function1<Resource, Object> _function = new Function1<Resource, Object>() {
        @Override
        public Object apply(final Resource it) {
          Object _xblockexpression = null;
          {
            Indexer.this.addToIndex(it, newIndex, context);
            _xblockexpression = null;
          }
          return _xblockexpression;
        }
      };
      context.<Object>executeClustered(directlyAffected, _function);
    } finally {
      XtextResourceSet _resourceSet_2 = context.getResourceSet();
      this.compilerPhases.setIndexing(_resourceSet_2, false);
    }
    this.javaSupport.generateAndCompileJavaStubs(directlyAffected, newIndex, request, context);
    XtextResourceSet _resourceSet_3 = context.getResourceSet();
    this.javaSupport.installTypeProvider(allClasspathRoots, _resourceSet_3);
  }
  
  protected DefaultResourceDescriptionDelta addToIndex(final Resource resource, final ResourceDescriptionsData newIndex, final BuildContext context) {
    DefaultResourceDescriptionDelta _xblockexpression = null;
    {
      final URI uri = resource.getURI();
      Map<String, LanguageAccess> _languages = context.getLanguages();
      String _fileExtension = uri.fileExtension();
      final LanguageAccess languageAccess = _languages.get(_fileExtension);
      final IResourceDescription.Manager manager = languageAccess.getResourceDescriptionManager();
      final IResourceDescription newDescription = manager.getResourceDescription(resource);
      final IResourceDescription copiedDescription = new ResolvedResourceDescription(newDescription);
      newIndex.addDescription(uri, copiedDescription);
      IResourceDescription _resourceDescription = null;
      if (this.index!=null) {
        _resourceDescription=this.index.getResourceDescription(uri);
      }
      final DefaultResourceDescriptionDelta delta = new DefaultResourceDescriptionDelta(_resourceDescription, copiedDescription);
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

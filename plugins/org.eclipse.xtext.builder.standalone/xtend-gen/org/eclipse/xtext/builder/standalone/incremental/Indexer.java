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
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.builder.standalone.LanguageAccess;
import org.eclipse.xtext.builder.standalone.incremental.BuildContext;
import org.eclipse.xtext.builder.standalone.incremental.BuildRequest;
import org.eclipse.xtext.builder.standalone.incremental.FilesAndURIs;
import org.eclipse.xtext.builder.standalone.incremental.IClassFileBasedDependencyFinder;
import org.eclipse.xtext.builder.standalone.incremental.IndexState;
import org.eclipse.xtext.builder.standalone.incremental.JavaSupport;
import org.eclipse.xtext.builder.standalone.incremental.ResolvedResourceDescription;
import org.eclipse.xtext.builder.standalone.incremental.ResourceURICollector;
import org.eclipse.xtext.builder.standalone.incremental.Source2GeneratedMapping;
import org.eclipse.xtext.builder.standalone.incremental.TypeResourceDescription;
import org.eclipse.xtext.mwe.ResourceDescriptionsProvider;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
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
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 */
@Singleton
@SuppressWarnings("all")
public class Indexer {
  @Data
  public static class IndexResult {
    private final Set<IResourceDescription.Delta> resourceDeltas;
    
    private final Set<URI> affectedResources;
    
    private final ResourceDescriptionsData newIndex;
    
    public IndexResult(final Set<IResourceDescription.Delta> resourceDeltas, final Set<URI> affectedResources, final ResourceDescriptionsData newIndex) {
      super();
      this.resourceDeltas = resourceDeltas;
      this.affectedResources = affectedResources;
      this.newIndex = newIndex;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.resourceDeltas== null) ? 0 : this.resourceDeltas.hashCode());
      result = prime * result + ((this.affectedResources== null) ? 0 : this.affectedResources.hashCode());
      result = prime * result + ((this.newIndex== null) ? 0 : this.newIndex.hashCode());
      return result;
    }
    
    @Override
    @Pure
    public boolean equals(final Object obj) {
      if (this == obj)
        return true;
      if (obj == null)
        return false;
      if (getClass() != obj.getClass())
        return false;
      Indexer.IndexResult other = (Indexer.IndexResult) obj;
      if (this.resourceDeltas == null) {
        if (other.resourceDeltas != null)
          return false;
      } else if (!this.resourceDeltas.equals(other.resourceDeltas))
        return false;
      if (this.affectedResources == null) {
        if (other.affectedResources != null)
          return false;
      } else if (!this.affectedResources.equals(other.affectedResources))
        return false;
      if (this.newIndex == null) {
        if (other.newIndex != null)
          return false;
      } else if (!this.newIndex.equals(other.newIndex))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("resourceDeltas", this.resourceDeltas);
      b.add("affectedResources", this.affectedResources);
      b.add("newIndex", this.newIndex);
      return b.toString();
    }
    
    @Pure
    public Set<IResourceDescription.Delta> getResourceDeltas() {
      return this.resourceDeltas;
    }
    
    @Pure
    public Set<URI> getAffectedResources() {
      return this.affectedResources;
    }
    
    @Pure
    public ResourceDescriptionsData getNewIndex() {
      return this.newIndex;
    }
  }
  
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
  private IClassFileBasedDependencyFinder javaDependencyFinder;
  
  @Inject
  private IQualifiedNameConverter qualifiedNameConverter;
  
  public Indexer.IndexResult computeAndIndexAffected(final BuildRequest request, @Extension final BuildContext context) {
    final boolean fullBuild = request.isFullBuild();
    if (fullBuild) {
      Indexer.LOG.info("Performing full build");
    } else {
      Indexer.LOG.info("Performing incremental build");
    }
    Indexer.LOG.info("Creating new index");
    IndexState _previousState = request.getPreviousState();
    final Source2GeneratedMapping fileMappings = _previousState.getFileMappings();
    IndexState _previousState_1 = request.getPreviousState();
    final ResourceDescriptionsData oldIndex = _previousState_1.getResourceDescriptions();
    final ResourceDescriptionsData newIndex = oldIndex.copy();
    XtextResourceSet _resourceSet = context.getResourceSet();
    final IResourceDescriptions resourceDescriptions = this.installIndex(_resourceSet, newIndex);
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
    boolean _isEmpty = IterableExtensions.isEmpty(_filter);
    final boolean isConsiderJava = (!_isEmpty);
    final HashSet<URI> affectionCandidates = CollectionLiterals.<URI>newHashSet();
    Set<URI> directlyAffected = null;
    if (fullBuild) {
      Iterable<URI> _collectAllResources = this.uriCollector.collectAllResources(request, context);
      Set<URI> _set = IterableExtensions.<URI>toSet(_collectAllResources);
      directlyAffected = _set;
    } else {
      List<URI> _dirtyFiles = request.getDirtyFiles();
      List<URI> _deletedFiles = request.getDeletedFiles();
      Iterable<URI> _plus = Iterables.<URI>concat(_dirtyFiles, _deletedFiles);
      final Set<URI> allModified = IterableExtensions.<URI>toSet(_plus);
      Set<URI> _allURIs = oldIndex.getAllURIs();
      final Function1<URI, Boolean> _function_1 = new Function1<URI, Boolean>() {
        @Override
        public Boolean apply(final URI it) {
          boolean _contains = allModified.contains(it);
          return Boolean.valueOf((!_contains));
        }
      };
      Iterable<URI> _filter_1 = IterableExtensions.<URI>filter(_allURIs, _function_1);
      Iterables.<URI>addAll(affectionCandidates, _filter_1);
      List<URI> _dirtyFiles_1 = request.getDirtyFiles();
      final Function1<URI, Iterable<URI>> _function_2 = new Function1<URI, Iterable<URI>>() {
        @Override
        public Iterable<URI> apply(final URI it) {
          return Indexer.this.primarySources(it, fileMappings);
        }
      };
      List<Iterable<URI>> _map = ListExtensions.<URI, Iterable<URI>>map(_dirtyFiles_1, _function_2);
      Iterable<URI> _flatten = Iterables.<URI>concat(_map);
      Set<URI> _set_1 = IterableExtensions.<URI>toSet(_flatten);
      directlyAffected = _set_1;
    }
    final ArrayList<IResourceDescription.Delta> currentDeltas = CollectionLiterals.<IResourceDescription.Delta>newArrayList();
    ArrayList<IResourceDescription.Delta> _removeDeletedFilesFromIndex = this.removeDeletedFilesFromIndex(request, oldIndex, newIndex);
    Iterables.<IResourceDescription.Delta>addAll(currentDeltas, _removeDeletedFilesFromIndex);
    if (isConsiderJava) {
      List<URI> _sourceRoots = request.getSourceRoots();
      List<URI> _outputs = request.getOutputs();
      Iterable<URI> _plus_1 = Iterables.<URI>concat(_sourceRoots, _outputs);
      List<URI> _classPath = request.getClassPath();
      Iterable<URI> _plus_2 = Iterables.<URI>concat(_plus_1, _classPath);
      XtextResourceSet _resourceSet_1 = context.getResourceSet();
      this.javaSupport.installLocalOnlyTypeProvider(_plus_2, _resourceSet_1);
    }
    this.preIndexChangedResources(directlyAffected, oldIndex, newIndex, request, context);
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
    final HashSet<URI> allAffected = CollectionLiterals.<URI>newHashSet();
    Iterables.<URI>addAll(allAffected, directlyAffected);
    final HashSet<URI> toBeIndexed = CollectionLiterals.<URI>newHashSet();
    toBeIndexed.addAll(directlyAffected);
    final HashSet<IResourceDescription.Delta> allDeltas = CollectionLiterals.<IResourceDescription.Delta>newHashSet();
    while ((!toBeIndexed.isEmpty())) {
      {
        boolean _and = false;
        if (!isConsiderJava) {
          _and = false;
        } else {
          _and = (!fullBuild);
        }
        if (_and) {
          final Function1<URI, Iterable<URI>> _function_3 = new Function1<URI, Iterable<URI>>() {
            @Override
            public Iterable<URI> apply(final URI it) {
              return fileMappings.getGenerated(it);
            }
          };
          Iterable<Iterable<URI>> _map_1 = IterableExtensions.<URI, Iterable<URI>>map(toBeIndexed, _function_3);
          Iterable<URI> _flatten_1 = Iterables.<URI>concat(_map_1);
          Iterable<URI> _plus_6 = Iterables.<URI>concat(_flatten_1, toBeIndexed);
          final Function1<URI, Boolean> _function_4 = new Function1<URI, Boolean>() {
            @Override
            public Boolean apply(final URI it) {
              String _fileExtension = it.fileExtension();
              return Boolean.valueOf(Objects.equal(_fileExtension, "java"));
            }
          };
          Iterable<URI> _filter_2 = IterableExtensions.<URI>filter(_plus_6, _function_4);
          final Set<URI> affectedJavaFiles = IterableExtensions.<URI>toSet(_filter_2);
          List<URI> _deletedFiles_1 = request.getDeletedFiles();
          final Function1<URI, Iterable<URI>> _function_5 = new Function1<URI, Iterable<URI>>() {
            @Override
            public Iterable<URI> apply(final URI it) {
              return Indexer.this.primarySources(it, fileMappings);
            }
          };
          List<Iterable<URI>> _map_2 = ListExtensions.<URI, Iterable<URI>>map(_deletedFiles_1, _function_5);
          Iterable<URI> _flatten_2 = Iterables.<URI>concat(_map_2);
          final Function1<URI, Boolean> _function_6 = new Function1<URI, Boolean>() {
            @Override
            public Boolean apply(final URI it) {
              String _fileExtension = it.fileExtension();
              return Boolean.valueOf(Objects.equal(_fileExtension, "java"));
            }
          };
          final Iterable<URI> deletedPrimaryJavaFiles = IterableExtensions.<URI>filter(_flatten_2, _function_6);
          final Iterable<? extends URI> dependentJavaFiles = this.javaDependencyFinder.getDependentJavaFiles(affectedJavaFiles, deletedPrimaryJavaFiles);
          final Function1<URI, Iterable<URI>> _function_7 = new Function1<URI, Iterable<URI>>() {
            @Override
            public Iterable<URI> apply(final URI it) {
              return Indexer.this.primarySources(it, fileMappings);
            }
          };
          Iterable<Iterable<URI>> _map_3 = IterableExtensions.map(dependentJavaFiles, _function_7);
          Iterable<URI> _flatten_3 = Iterables.<URI>concat(_map_3);
          final Function1<URI, Boolean> _function_8 = new Function1<URI, Boolean>() {
            @Override
            public Boolean apply(final URI it) {
              boolean _or = false;
              String _fileExtension = it.fileExtension();
              boolean _equals = Objects.equal(_fileExtension, "java");
              if (_equals) {
                _or = true;
              } else {
                boolean _contains = affectionCandidates.contains(it);
                _or = _contains;
              }
              return Boolean.valueOf(_or);
            }
          };
          Iterable<URI> _filter_3 = IterableExtensions.<URI>filter(_flatten_3, _function_8);
          Iterables.<URI>addAll(toBeIndexed, _filter_3);
        }
        allAffected.addAll(toBeIndexed);
        affectionCandidates.removeAll(toBeIndexed);
        final Function1<Resource, Object> _function_9 = new Function1<Resource, Object>() {
          @Override
          public Object apply(final Resource resource) {
            Object _xblockexpression = null;
            {
              URI _uRI = resource.getURI();
              String _plus = ("Indexing " + _uRI);
              Indexer.LOG.info(_plus);
              DefaultResourceDescriptionDelta _addToIndex = Indexer.this.addToIndex(resource, false, oldIndex, newIndex, context);
              currentDeltas.add(_addToIndex);
              _xblockexpression = null;
            }
            return _xblockexpression;
          }
        };
        context.<Object>executeClustered(toBeIndexed, _function_9);
        final Function1<URI, Boolean> _function_10 = new Function1<URI, Boolean>() {
          @Override
          public Boolean apply(final URI it) {
            String _fileExtension = it.fileExtension();
            return Boolean.valueOf(Objects.equal(_fileExtension, "java"));
          }
        };
        Iterable<URI> _filter_4 = IterableExtensions.<URI>filter(toBeIndexed, _function_10);
        final Procedure1<URI> _function_11 = new Procedure1<URI>() {
          @Override
          public void apply(final URI it) {
            URI _findSourceRootRelativeURI = FilesAndURIs.findSourceRootRelativeURI(it, request);
            URI _trimFileExtension = _findSourceRootRelativeURI.trimFileExtension();
            final String javaPath = _trimFileExtension.toString();
            String _replace = javaPath.replace("/", ".");
            final QualifiedName fqn = Indexer.this.qualifiedNameConverter.toQualifiedName(_replace);
            TypeResourceDescription.ChangedDelta _changedDelta = new TypeResourceDescription.ChangedDelta(fqn);
            currentDeltas.add(_changedDelta);
          }
        };
        IterableExtensions.<URI>forEach(_filter_4, _function_11);
        Iterables.<IResourceDescription.Delta>addAll(allDeltas, currentDeltas);
        toBeIndexed.clear();
        final Function1<URI, Boolean> _function_12 = new Function1<URI, Boolean>() {
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
              final IResourceDescription resourceDescription = oldIndex.getResourceDescription(it);
              _xblockexpression = Indexer.this.isAffected(resourceDescription, manager, currentDeltas, allDeltas, resourceDescriptions);
            }
            return Boolean.valueOf(_xblockexpression);
          }
        };
        Iterable<URI> _filter_5 = IterableExtensions.<URI>filter(affectionCandidates, _function_12);
        Iterables.<URI>addAll(toBeIndexed, _filter_5);
        currentDeltas.clear();
        boolean _isEmpty_1 = toBeIndexed.isEmpty();
        boolean _not = (!_isEmpty_1);
        if (_not) {
          Indexer.LOG.info("Indexing affected files");
        }
      }
    }
    return new Indexer.IndexResult(allDeltas, allAffected, newIndex);
  }
  
  private Iterable<URI> primarySources(final URI uri, final Source2GeneratedMapping mappings) {
    Iterable<URI> _xblockexpression = null;
    {
      final Iterable<URI> sources = mappings.getSource(uri);
      Iterable<URI> _xifexpression = null;
      boolean _isEmpty = IterableExtensions.isEmpty(sources);
      if (_isEmpty) {
        _xifexpression = Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(uri));
      } else {
        _xifexpression = sources;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public ArrayList<IResourceDescription.Delta> removeDeletedFilesFromIndex(final BuildRequest request, final ResourceDescriptionsData oldIndex, final ResourceDescriptionsData newIndex) {
    Indexer.LOG.info("Removing deleted files from index");
    final ArrayList<IResourceDescription.Delta> deltas = CollectionLiterals.<IResourceDescription.Delta>newArrayList();
    List<URI> _deletedFiles = request.getDeletedFiles();
    final Procedure1<URI> _function = new Procedure1<URI>() {
      @Override
      public void apply(final URI it) {
        String _fileExtension = it.fileExtension();
        boolean _notEquals = (!Objects.equal(_fileExtension, "java"));
        if (_notEquals) {
          IResourceDescription _resourceDescription = null;
          if (oldIndex!=null) {
            _resourceDescription=oldIndex.getResourceDescription(it);
          }
          final IResourceDescription oldDescription = _resourceDescription;
          boolean _notEquals_1 = (!Objects.equal(oldDescription, null));
          if (_notEquals_1) {
            DefaultResourceDescriptionDelta _defaultResourceDescriptionDelta = new DefaultResourceDescriptionDelta(oldDescription, null);
            deltas.add(_defaultResourceDescriptionDelta);
          }
          newIndex.removeDescription(it);
        }
      }
    };
    IterableExtensions.<URI>forEach(_deletedFiles, _function);
    return deltas;
  }
  
  protected Iterable<Object> preIndexChangedResources(final Iterable<URI> directlyAffected, final ResourceDescriptionsData oldIndex, final ResourceDescriptionsData newIndex, final BuildRequest request, @Extension final BuildContext context) {
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
                Indexer.this.addToIndex(it, true, oldIndex, newIndex, context);
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
  
  protected DefaultResourceDescriptionDelta addToIndex(final Resource resource, final boolean isPreIndexing, final ResourceDescriptionsData oldIndex, final ResourceDescriptionsData newIndex, final BuildContext context) {
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
    if (oldIndex!=null) {
      _resourceDescription=oldIndex.getResourceDescription(uri);
    }
    final DefaultResourceDescriptionDelta delta = new DefaultResourceDescriptionDelta(_resourceDescription, toBeAdded);
    return delta;
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

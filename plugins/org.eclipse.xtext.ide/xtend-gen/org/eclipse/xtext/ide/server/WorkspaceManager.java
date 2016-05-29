/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import io.typefox.lsapi.TextEdit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.build.IncrementalBuilder;
import org.eclipse.xtext.build.IndexState;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.ProjectManager;
import org.eclipse.xtext.resource.IExternalContentSupport;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class WorkspaceManager {
  @Inject
  private Provider<ProjectManager> projectManagerProvider;
  
  private Map<URI, ProjectManager> baseDir2ProjectManager = CollectionLiterals.<URI, ProjectManager>newHashMap();
  
  private URI baseDir;
  
  private Map<URI, Document> openDocuments = CollectionLiterals.<URI, Document>newHashMap();
  
  private final IExternalContentSupport.IExternalContentProvider openedDocumentsContentProvider = new IExternalContentSupport.IExternalContentProvider() {
    @Override
    public IExternalContentSupport.IExternalContentProvider getActualContentProvider() {
      return this;
    }
    
    @Override
    public String getContent(final URI uri) {
      Document _get = WorkspaceManager.this.openDocuments.get(uri);
      String _contents = null;
      if (_get!=null) {
        _contents=_get.getContents();
      }
      return _contents;
    }
    
    @Override
    public boolean hasContent(final URI uri) {
      return WorkspaceManager.this.openDocuments.containsKey(uri);
    }
  };
  
  private Map<String, ResourceDescriptionsData> fullIndex = CollectionLiterals.<String, ResourceDescriptionsData>newHashMap();
  
  private final LinkedHashSet<URI> dirtyFiles = CollectionLiterals.<URI>newLinkedHashSet();
  
  private final LinkedHashSet<URI> deletedFiles = CollectionLiterals.<URI>newLinkedHashSet();
  
  protected void queue(final Set<URI> files, final Collection<URI> toRemove, final Collection<URI> toAdd) {
    Iterables.removeAll(files, toRemove);
    Iterables.<URI>addAll(files, toAdd);
  }
  
  public void initialize(final URI baseDir, final Procedure2<? super URI, ? super Iterable<Issue>> acceptor, final CancelIndicator cancelIndicator) {
    this.baseDir = baseDir;
    final ProjectManager projectManager = this.projectManagerProvider.get();
    final Provider<Map<String, ResourceDescriptionsData>> _function = () -> {
      return this.fullIndex;
    };
    final IncrementalBuilder.Result indexResult = projectManager.initialize(baseDir, acceptor, this.openedDocumentsContentProvider, _function, cancelIndicator);
    this.baseDir2ProjectManager.put(baseDir, projectManager);
    IndexState _indexState = indexResult.getIndexState();
    ResourceDescriptionsData _resourceDescriptions = _indexState.getResourceDescriptions();
    this.fullIndex.put("DEFAULT", _resourceDescriptions);
  }
  
  public void doBuild(final List<URI> dirtyFiles, final List<URI> deletedFiles, final CancelIndicator cancelIndicator) {
    this.queue(this.dirtyFiles, deletedFiles, dirtyFiles);
    this.queue(this.deletedFiles, dirtyFiles, deletedFiles);
    this.internalBuild(cancelIndicator);
  }
  
  protected void internalBuild(final CancelIndicator cancelIndicator) {
    final ArrayList<URI> allDirty = new ArrayList<URI>(this.dirtyFiles);
    Set<Map.Entry<URI, ProjectManager>> _entrySet = this.baseDir2ProjectManager.entrySet();
    for (final Map.Entry<URI, ProjectManager> entry : _entrySet) {
      {
        final Function1<URI, Boolean> _function = (URI it) -> {
          URI _key = entry.getKey();
          return Boolean.valueOf(this.isPrefix(it, _key));
        };
        Iterable<URI> _filter = IterableExtensions.<URI>filter(allDirty, _function);
        final List<URI> projectDirtyFiles = IterableExtensions.<URI>toList(_filter);
        final Function1<URI, Boolean> _function_1 = (URI it) -> {
          URI _key = entry.getKey();
          return Boolean.valueOf(this.isPrefix(it, _key));
        };
        Iterable<URI> _filter_1 = IterableExtensions.<URI>filter(this.deletedFiles, _function_1);
        final List<URI> projectDeletedFiles = IterableExtensions.<URI>toList(_filter_1);
        ProjectManager _value = entry.getValue();
        final IncrementalBuilder.Result result = _value.doBuild(projectDirtyFiles, projectDeletedFiles, cancelIndicator);
        List<IResourceDescription.Delta> _affectedResources = result.getAffectedResources();
        final Function1<IResourceDescription.Delta, URI> _function_2 = (IResourceDescription.Delta it) -> {
          return it.getUri();
        };
        List<URI> _map = ListExtensions.<IResourceDescription.Delta, URI>map(_affectedResources, _function_2);
        allDirty.addAll(_map);
        Iterables.removeAll(this.dirtyFiles, projectDirtyFiles);
        Iterables.removeAll(this.deletedFiles, projectDeletedFiles);
      }
    }
  }
  
  public IResourceDescriptions getIndex() {
    return new ChunkedResourceDescriptions(this.fullIndex);
  }
  
  public URI getProjectBaseDir(final URI candidate) {
    Set<URI> _keySet = this.baseDir2ProjectManager.keySet();
    final Function1<URI, Integer> _function = (URI it) -> {
      String _string = it.toString();
      int _length = _string.length();
      return Integer.valueOf((-_length));
    };
    List<URI> _sortBy = IterableExtensions.<URI, Integer>sortBy(_keySet, _function);
    for (final URI projectBaseDir : _sortBy) {
      boolean _isPrefix = this.isPrefix(candidate, projectBaseDir);
      if (_isPrefix) {
        return projectBaseDir;
      }
    }
    return this.baseDir;
  }
  
  protected boolean isPrefix(final URI candidate, final URI prefix) {
    String _string = candidate.toString();
    String _string_1 = prefix.toString();
    return _string.startsWith(_string_1);
  }
  
  public ProjectManager getProjectManager(final URI uri) {
    final URI projectBaseDir = this.getProjectBaseDir(uri);
    return this.baseDir2ProjectManager.get(projectBaseDir);
  }
  
  public void didChange(final URI uri, final int version, final Iterable<TextEdit> changes, final CancelIndicator cancelIndicator) {
    final Document contents = this.openDocuments.get(uri);
    Document _applyChanges = contents.applyChanges(changes);
    this.openDocuments.put(uri, _applyChanges);
    ArrayList<URI> _newArrayList = CollectionLiterals.<URI>newArrayList();
    this.doBuild(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(uri)), _newArrayList, cancelIndicator);
  }
  
  public void didOpen(final URI uri, final int version, final String contents, final CancelIndicator cancelIndicator) {
    Document _document = new Document(version, contents);
    this.openDocuments.put(uri, _document);
    ArrayList<URI> _newArrayList = CollectionLiterals.<URI>newArrayList();
    this.doBuild(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(uri)), _newArrayList, cancelIndicator);
  }
  
  public void didClose(final URI uri, final CancelIndicator cancelIndicator) {
    this.openDocuments.remove(uri);
    ArrayList<URI> _newArrayList = CollectionLiterals.<URI>newArrayList();
    this.doBuild(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(uri)), _newArrayList, cancelIndicator);
  }
  
  public Object didSave(final URI uri, final CancelIndicator cancelIndicator) {
    return null;
  }
  
  public <T extends Object> T doRead(final URI uri, final Function2<? super Document, ? super XtextResource, ? extends T> work) {
    final URI resourceURI = uri.trimFragment();
    final ProjectManager projectMnr = this.getProjectManager(resourceURI);
    final Document doc = this.openDocuments.get(resourceURI);
    Resource _resource = projectMnr.getResource(resourceURI);
    return work.apply(doc, ((XtextResource) _resource));
  }
  
  public <T extends Object> void doWrite(final URI uri, final Function2<? super Document, ? super XtextResource, ? extends T> work) {
  }
}

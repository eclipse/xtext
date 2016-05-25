/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import com.google.inject.Inject;
import com.google.inject.Provider;
import io.typefox.lsapi.DidChangeTextDocumentParams;
import io.typefox.lsapi.DidChangeWatchedFilesParams;
import io.typefox.lsapi.DidCloseTextDocumentParams;
import io.typefox.lsapi.DidOpenTextDocumentParams;
import io.typefox.lsapi.DidSaveTextDocumentParams;
import io.typefox.lsapi.FileEvent;
import io.typefox.lsapi.TextDocumentContentChangeEvent;
import io.typefox.lsapi.TextDocumentIdentifier;
import io.typefox.lsapi.TextDocumentItem;
import io.typefox.lsapi.VersionedTextDocumentIdentifier;
import java.util.ArrayList;
import java.util.Collections;
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
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
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
  
  public void initialize(final URI baseDir, final Procedure2<? super URI, ? super Iterable<Issue>> acceptor) {
    this.baseDir = baseDir;
    final ProjectManager projectManager = this.projectManagerProvider.get();
    final Provider<Map<String, ResourceDescriptionsData>> _function = new Provider<Map<String, ResourceDescriptionsData>>() {
      @Override
      public Map<String, ResourceDescriptionsData> get() {
        return WorkspaceManager.this.fullIndex;
      }
    };
    final IncrementalBuilder.Result indexResult = projectManager.initialize(baseDir, acceptor, this.openedDocumentsContentProvider, _function);
    this.baseDir2ProjectManager.put(baseDir, projectManager);
    IndexState _indexState = indexResult.getIndexState();
    ResourceDescriptionsData _resourceDescriptions = _indexState.getResourceDescriptions();
    this.fullIndex.put("DEFAULT", _resourceDescriptions);
  }
  
  public void didChangeWatchedFiles(final DidChangeWatchedFilesParams fileChanges) {
    final ArrayList<URI> dirtyFiles = CollectionLiterals.<URI>newArrayList();
    final ArrayList<URI> deletedFiles = CollectionLiterals.<URI>newArrayList();
    List<? extends FileEvent> _changes = fileChanges.getChanges();
    for (final FileEvent fileEvent : _changes) {
      int _type = fileEvent.getType();
      boolean _tripleEquals = (_type == FileEvent.TYPE_DELETED);
      if (_tripleEquals) {
        String _uri = fileEvent.getUri();
        URI _uri_1 = this.toUri(_uri);
        deletedFiles.add(_uri_1);
      } else {
        String _uri_2 = fileEvent.getUri();
        URI _uri_3 = this.toUri(_uri_2);
        dirtyFiles.add(_uri_3);
      }
    }
    this.doBuild(dirtyFiles, deletedFiles);
  }
  
  public void doBuild(final List<URI> dirtyFiles, final List<URI> deletedFiles) {
    final ArrayList<URI> allDirty = new ArrayList<URI>(dirtyFiles);
    Set<Map.Entry<URI, ProjectManager>> _entrySet = this.baseDir2ProjectManager.entrySet();
    for (final Map.Entry<URI, ProjectManager> entry : _entrySet) {
      {
        ProjectManager _value = entry.getValue();
        final Function1<URI, Boolean> _function = new Function1<URI, Boolean>() {
          @Override
          public Boolean apply(final URI it) {
            URI _key = entry.getKey();
            return Boolean.valueOf(WorkspaceManager.this.isPrefix(it, _key));
          }
        };
        Iterable<URI> _filter = IterableExtensions.<URI>filter(allDirty, _function);
        List<URI> _list = IterableExtensions.<URI>toList(_filter);
        final Function1<URI, Boolean> _function_1 = new Function1<URI, Boolean>() {
          @Override
          public Boolean apply(final URI it) {
            URI _key = entry.getKey();
            return Boolean.valueOf(WorkspaceManager.this.isPrefix(it, _key));
          }
        };
        Iterable<URI> _filter_1 = IterableExtensions.<URI>filter(deletedFiles, _function_1);
        List<URI> _list_1 = IterableExtensions.<URI>toList(_filter_1);
        final IncrementalBuilder.Result result = _value.doBuild(_list, _list_1);
        List<IResourceDescription.Delta> _affectedResources = result.getAffectedResources();
        final Function1<IResourceDescription.Delta, URI> _function_2 = new Function1<IResourceDescription.Delta, URI>() {
          @Override
          public URI apply(final IResourceDescription.Delta it) {
            return it.getUri();
          }
        };
        List<URI> _map = ListExtensions.<IResourceDescription.Delta, URI>map(_affectedResources, _function_2);
        allDirty.addAll(_map);
      }
    }
  }
  
  public URI getProjectBaseDir(final URI candidate) {
    Set<URI> _keySet = this.baseDir2ProjectManager.keySet();
    final Function1<URI, Integer> _function = new Function1<URI, Integer>() {
      @Override
      public Integer apply(final URI it) {
        String _string = it.toString();
        int _length = _string.length();
        return Integer.valueOf((-_length));
      }
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
  
  public URI toUri(final String path) {
    String _string = this.baseDir.toString();
    String _plus = (_string + path);
    return URI.createURI(_plus);
  }
  
  public String toPath(final URI uri) {
    String _string = uri.toString();
    String _string_1 = this.baseDir.toString();
    int _length = _string_1.length();
    return _string.substring(_length);
  }
  
  public void didChange(final DidChangeTextDocumentParams changeEvent) {
    VersionedTextDocumentIdentifier _textDocument = changeEvent.getTextDocument();
    String _uri = _textDocument.getUri();
    final URI uri = this.toUri(_uri);
    final Document contents = this.openDocuments.get(uri);
    List<? extends TextDocumentContentChangeEvent> _contentChanges = changeEvent.getContentChanges();
    Document _applyChanges = contents.applyChanges(_contentChanges);
    this.openDocuments.put(uri, _applyChanges);
    ArrayList<URI> _newArrayList = CollectionLiterals.<URI>newArrayList();
    this.doBuild(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(uri)), _newArrayList);
  }
  
  public void didOpen(final DidOpenTextDocumentParams changeEvent) {
    TextDocumentItem _textDocument = changeEvent.getTextDocument();
    String _uri = _textDocument.getUri();
    final URI uri = this.toUri(_uri);
    TextDocumentItem _textDocument_1 = changeEvent.getTextDocument();
    int _version = _textDocument_1.getVersion();
    TextDocumentItem _textDocument_2 = changeEvent.getTextDocument();
    String _text = _textDocument_2.getText();
    Document _document = new Document(_version, _text);
    this.openDocuments.put(uri, _document);
    ArrayList<URI> _newArrayList = CollectionLiterals.<URI>newArrayList();
    this.doBuild(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(uri)), _newArrayList);
  }
  
  public void didClose(final DidCloseTextDocumentParams changeEvent) {
    TextDocumentIdentifier _textDocument = changeEvent.getTextDocument();
    String _uri = _textDocument.getUri();
    final URI uri = this.toUri(_uri);
    this.openDocuments.remove(uri);
    ArrayList<URI> _newArrayList = CollectionLiterals.<URI>newArrayList();
    this.doBuild(Collections.<URI>unmodifiableList(CollectionLiterals.<URI>newArrayList(uri)), _newArrayList);
  }
  
  public Object didSave(final DidSaveTextDocumentParams changeEvent) {
    return null;
  }
  
  public <T extends Object> void doRead(final URI uri, final Function2<? super Document, ? super XtextResource, ? extends T> work) {
    final ProjectManager projectMnr = this.getProjectManager(uri);
    final Document doc = this.openDocuments.get(uri);
    Resource _resource = projectMnr.getResource(uri);
    work.apply(doc, ((XtextResource) _resource));
  }
  
  public <T extends Object> void doWrite(final URI uri, final Function2<? super Document, ? super XtextResource, ? extends T> work) {
  }
}

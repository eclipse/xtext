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
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.build.BuildRequest;
import org.eclipse.xtext.build.IncrementalBuilder;
import org.eclipse.xtext.build.IndexState;
import org.eclipse.xtext.build.Source2GeneratedMapping;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.IFileSystemScanner;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class WorkspaceManager {
  @Inject
  protected IncrementalBuilder incrementalBuilder;
  
  @Inject
  protected Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  protected IResourceServiceProvider.Registry languagesRegistry;
  
  @Inject
  protected IFileSystemScanner fileSystemScanner;
  
  private IndexState indexState = new IndexState();
  
  private URI baseDir;
  
  private Procedure2<? super URI, ? super Iterable<Issue>> issueAcceptor;
  
  private Map<URI, Document> openDocuments = CollectionLiterals.<URI, Document>newHashMap();
  
  public void initialize(final URI baseDir, final Procedure2<? super URI, ? super Iterable<Issue>> acceptor) {
    final ArrayList<URI> uris = CollectionLiterals.<URI>newArrayList();
    this.baseDir = baseDir;
    this.issueAcceptor = acceptor;
    final IAcceptor<URI> _function = new IAcceptor<URI>() {
      @Override
      public void accept(final URI it) {
        uris.add(it);
      }
    };
    this.fileSystemScanner.scan(baseDir, _function);
    List<URI> _emptyList = CollectionLiterals.<URI>emptyList();
    this.doBuild(uris, _emptyList);
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
    BuildRequest _newBuildRequest = this.newBuildRequest(dirtyFiles, deletedFiles);
    final Function1<URI, IResourceServiceProvider> _function = new Function1<URI, IResourceServiceProvider>() {
      @Override
      public IResourceServiceProvider apply(final URI it) {
        return WorkspaceManager.this.languagesRegistry.getResourceServiceProvider(it);
      }
    };
    final IncrementalBuilder.Result result = this.incrementalBuilder.build(_newBuildRequest, _function);
    IndexState _indexState = result.getIndexState();
    this.indexState = _indexState;
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
  
  public Document didOpen(final DidOpenTextDocumentParams changeEvent) {
    Document _xblockexpression = null;
    {
      TextDocumentItem _textDocument = changeEvent.getTextDocument();
      String _uri = _textDocument.getUri();
      final URI uri = this.toUri(_uri);
      TextDocumentItem _textDocument_1 = changeEvent.getTextDocument();
      int _version = _textDocument_1.getVersion();
      TextDocumentItem _textDocument_2 = changeEvent.getTextDocument();
      String _text = _textDocument_2.getText();
      Document _document = new Document(_version, _text);
      _xblockexpression = this.openDocuments.put(uri, _document);
    }
    return _xblockexpression;
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
  
  public Document didClose(final DidCloseTextDocumentParams changeEvent) {
    Document _xblockexpression = null;
    {
      TextDocumentIdentifier _textDocument = changeEvent.getTextDocument();
      String _uri = _textDocument.getUri();
      final URI uri = this.toUri(_uri);
      _xblockexpression = this.openDocuments.remove(uri);
    }
    return _xblockexpression;
  }
  
  public Object didSave(final DidSaveTextDocumentParams changeEvent) {
    return null;
  }
  
  protected BuildRequest newBuildRequest(final List<URI> changedFiles, final List<URI> deletedFiles) {
    BuildRequest _buildRequest = new BuildRequest();
    final Procedure1<BuildRequest> _function = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        it.setBaseDir(WorkspaceManager.this.baseDir);
        List<IResourceDescription> _emptyList = CollectionLiterals.<IResourceDescription>emptyList();
        ResourceDescriptionsData _resourceDescriptionsData = new ResourceDescriptionsData(_emptyList);
        XtextResourceSet _createFreshResourceSet = WorkspaceManager.this.createFreshResourceSet(_resourceDescriptionsData);
        it.setResourceSet(_createFreshResourceSet);
        ResourceDescriptionsData _resourceDescriptions = WorkspaceManager.this.indexState.getResourceDescriptions();
        ResourceDescriptionsData _copy = _resourceDescriptions.copy();
        Source2GeneratedMapping _fileMappings = WorkspaceManager.this.indexState.getFileMappings();
        Source2GeneratedMapping _copy_1 = _fileMappings.copy();
        IndexState _indexState = new IndexState(_copy, _copy_1);
        it.setState(_indexState);
        IndexState _state = it.getState();
        ResourceDescriptionsData _resourceDescriptions_1 = _state.getResourceDescriptions();
        XtextResourceSet _createFreshResourceSet_1 = WorkspaceManager.this.createFreshResourceSet(_resourceDescriptions_1);
        it.setResourceSet(_createFreshResourceSet_1);
        it.setDirtyFiles(changedFiles);
        it.setDeletedFiles(deletedFiles);
        final BuildRequest.IPostValidationCallback _function = new BuildRequest.IPostValidationCallback() {
          @Override
          public boolean afterValidate(final URI uri, final Iterable<Issue> issues) {
            WorkspaceManager.this.issueAcceptor.apply(uri, issues);
            return true;
          }
        };
        it.setAfterValidate(_function);
      }
    };
    return ObjectExtensions.<BuildRequest>operator_doubleArrow(_buildRequest, _function);
  }
  
  protected XtextResourceSet createFreshResourceSet(final ResourceDescriptionsData newIndex) {
    XtextResourceSet _get = this.resourceSetProvider.get();
    final Procedure1<XtextResourceSet> _function = new Procedure1<XtextResourceSet>() {
      @Override
      public void apply(final XtextResourceSet it) {
        ProjectDescription _projectDescription = new ProjectDescription();
        final Procedure1<ProjectDescription> _function = new Procedure1<ProjectDescription>() {
          @Override
          public void apply(final ProjectDescription it) {
            it.setName("test-project");
          }
        };
        final ProjectDescription projectDescription = ObjectExtensions.<ProjectDescription>operator_doubleArrow(_projectDescription, _function);
        projectDescription.attachToEmfObject(it);
        Map<String, ResourceDescriptionsData> _emptyMap = CollectionLiterals.<String, ResourceDescriptionsData>emptyMap();
        final ChunkedResourceDescriptions index = new ChunkedResourceDescriptions(_emptyMap, it);
        String _name = projectDescription.getName();
        index.setContainer(_name, newIndex);
      }
    };
    return ObjectExtensions.<XtextResourceSet>operator_doubleArrow(_get, _function);
  }
}

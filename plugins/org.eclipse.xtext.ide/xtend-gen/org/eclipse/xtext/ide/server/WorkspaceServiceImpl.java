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
import io.typefox.lsapi.DidChangeConfigurationParams;
import io.typefox.lsapi.DidChangeWatchedFilesParams;
import io.typefox.lsapi.FileEvent;
import io.typefox.lsapi.InitializeParams;
import io.typefox.lsapi.SymbolInformation;
import io.typefox.lsapi.WorkspaceService;
import io.typefox.lsapi.WorkspaceSymbolParams;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.build.BuildRequest;
import org.eclipse.xtext.build.IncrementalBuilder;
import org.eclipse.xtext.build.IndexState;
import org.eclipse.xtext.build.Source2GeneratedMapping;
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
 * @author efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class WorkspaceServiceImpl implements WorkspaceService {
  @Inject
  protected IncrementalBuilder incrementalBuilder;
  
  @Inject
  protected Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  protected IResourceServiceProvider.Registry languagesRegistry;
  
  protected IndexState indexState = new IndexState();
  
  @Inject
  private IFileSystemScanner fileSystemScanner;
  
  private URI baseDir;
  
  private Procedure2<? super URI, ? super Iterable<Issue>> issueAcceptor;
  
  public void initialize(final InitializeParams params, final Procedure2<? super URI, ? super Iterable<Issue>> acceptor) {
    final ArrayList<URI> uris = CollectionLiterals.<URI>newArrayList();
    String _rootPath = params.getRootPath();
    URI _createFileURI = URI.createFileURI(_rootPath);
    this.baseDir = _createFileURI;
    this.issueAcceptor = acceptor;
    String _rootPath_1 = params.getRootPath();
    URI _createFileURI_1 = URI.createFileURI(_rootPath_1);
    final IAcceptor<URI> _function = new IAcceptor<URI>() {
      @Override
      public void accept(final URI it) {
        uris.add(it);
      }
    };
    this.fileSystemScanner.scan(_createFileURI_1, _function);
    List<URI> _emptyList = CollectionLiterals.<URI>emptyList();
    BuildRequest _newBuildRequest = this.newBuildRequest(uris, _emptyList);
    final Function1<URI, IResourceServiceProvider> _function_1 = new Function1<URI, IResourceServiceProvider>() {
      @Override
      public IResourceServiceProvider apply(final URI it) {
        return WorkspaceServiceImpl.this.languagesRegistry.getResourceServiceProvider(it);
      }
    };
    final IncrementalBuilder.Result result = this.incrementalBuilder.build(_newBuildRequest, _function_1);
    IndexState _indexState = result.getIndexState();
    this.indexState = _indexState;
  }
  
  @Override
  public void didChangeConfiguraton(final DidChangeConfigurationParams param) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  @Override
  public void didChangeWatchedFiles(final DidChangeWatchedFilesParams fileChanges) {
    final ArrayList<URI> dirtyFiles = CollectionLiterals.<URI>newArrayList();
    final ArrayList<URI> deletedFiles = CollectionLiterals.<URI>newArrayList();
    List<? extends FileEvent> _changes = fileChanges.getChanges();
    for (final FileEvent fileEvent : _changes) {
      int _type = fileEvent.getType();
      boolean _tripleEquals = (_type == FileEvent.TYPE_DELETED);
      if (_tripleEquals) {
        String _uri = fileEvent.getUri();
        URI _createFileURI = URI.createFileURI(_uri);
        deletedFiles.add(_createFileURI);
      } else {
        String _uri_1 = fileEvent.getUri();
        URI _createFileURI_1 = URI.createFileURI(_uri_1);
        dirtyFiles.add(_createFileURI_1);
      }
    }
    BuildRequest _newBuildRequest = this.newBuildRequest(dirtyFiles, deletedFiles);
    final Function1<URI, IResourceServiceProvider> _function = new Function1<URI, IResourceServiceProvider>() {
      @Override
      public IResourceServiceProvider apply(final URI it) {
        return WorkspaceServiceImpl.this.languagesRegistry.getResourceServiceProvider(it);
      }
    };
    final IncrementalBuilder.Result result = this.incrementalBuilder.build(_newBuildRequest, _function);
    IndexState _indexState = result.getIndexState();
    this.indexState = _indexState;
  }
  
  @Override
  public List<? extends SymbolInformation> symbol(final WorkspaceSymbolParams param) {
    throw new UnsupportedOperationException("TODO: auto-generated method stub");
  }
  
  protected BuildRequest newBuildRequest(final List<URI> changedFiles, final List<URI> deletedFiles) {
    BuildRequest _buildRequest = new BuildRequest();
    final Procedure1<BuildRequest> _function = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        it.setBaseDir(WorkspaceServiceImpl.this.baseDir);
        List<IResourceDescription> _emptyList = CollectionLiterals.<IResourceDescription>emptyList();
        ResourceDescriptionsData _resourceDescriptionsData = new ResourceDescriptionsData(_emptyList);
        XtextResourceSet _createFreshResourceSet = WorkspaceServiceImpl.this.createFreshResourceSet(_resourceDescriptionsData);
        it.setResourceSet(_createFreshResourceSet);
        ResourceDescriptionsData _resourceDescriptions = WorkspaceServiceImpl.this.indexState.getResourceDescriptions();
        ResourceDescriptionsData _copy = _resourceDescriptions.copy();
        Source2GeneratedMapping _fileMappings = WorkspaceServiceImpl.this.indexState.getFileMappings();
        Source2GeneratedMapping _copy_1 = _fileMappings.copy();
        IndexState _indexState = new IndexState(_copy, _copy_1);
        it.setState(_indexState);
        IndexState _state = it.getState();
        ResourceDescriptionsData _resourceDescriptions_1 = _state.getResourceDescriptions();
        XtextResourceSet _createFreshResourceSet_1 = WorkspaceServiceImpl.this.createFreshResourceSet(_resourceDescriptions_1);
        it.setResourceSet(_createFreshResourceSet_1);
        it.setDirtyFiles(changedFiles);
        it.setDeletedFiles(deletedFiles);
        final BuildRequest.IPostValidationCallback _function = new BuildRequest.IPostValidationCallback() {
          @Override
          public boolean afterValidate(final URI uri, final Iterable<Issue> issues) {
            WorkspaceServiceImpl.this.issueAcceptor.apply(uri, issues);
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

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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.build.BuildRequest;
import org.eclipse.xtext.build.IncrementalBuilder;
import org.eclipse.xtext.build.IndexState;
import org.eclipse.xtext.build.Source2GeneratedMapping;
import org.eclipse.xtext.resource.IExternalContentSupport;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.IFileSystemScanner;
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
public class ProjectManager {
  @Inject
  protected IncrementalBuilder incrementalBuilder;
  
  @Inject
  protected Provider<XtextResourceSet> resourceSetProvider;
  
  @Inject
  protected IResourceServiceProvider.Registry languagesRegistry;
  
  @Inject
  protected IFileSystemScanner fileSystemScanner;
  
  @Inject
  protected IExternalContentSupport externalContentSupport;
  
  private IndexState indexState = new IndexState();
  
  private URI baseDir;
  
  private Procedure2<? super URI, ? super Iterable<Issue>> issueAcceptor;
  
  private Provider<Map<String, ResourceDescriptionsData>> indexProvider;
  
  private IExternalContentSupport.IExternalContentProvider openedDocumentsContentProvider;
  
  private XtextResourceSet resourceSet;
  
  public IncrementalBuilder.Result initialize(final URI baseDir, final Procedure2<? super URI, ? super Iterable<Issue>> acceptor, final IExternalContentSupport.IExternalContentProvider openedDocumentsContentProvider, final Provider<Map<String, ResourceDescriptionsData>> indexProvider) {
    final ArrayList<URI> uris = CollectionLiterals.<URI>newArrayList();
    this.baseDir = baseDir;
    this.issueAcceptor = acceptor;
    this.openedDocumentsContentProvider = openedDocumentsContentProvider;
    this.indexProvider = indexProvider;
    final IAcceptor<URI> _function = new IAcceptor<URI>() {
      @Override
      public void accept(final URI it) {
        uris.add(it);
      }
    };
    this.fileSystemScanner.scan(baseDir, _function);
    List<URI> _emptyList = CollectionLiterals.<URI>emptyList();
    return this.doBuild(uris, _emptyList);
  }
  
  public IncrementalBuilder.Result doBuild(final List<URI> dirtyFiles, final List<URI> deletedFiles) {
    final BuildRequest request = this.newBuildRequest(dirtyFiles, deletedFiles);
    final Function1<URI, IResourceServiceProvider> _function = new Function1<URI, IResourceServiceProvider>() {
      @Override
      public IResourceServiceProvider apply(final URI it) {
        return ProjectManager.this.languagesRegistry.getResourceServiceProvider(it);
      }
    };
    final IncrementalBuilder.Result result = this.incrementalBuilder.build(request, _function);
    IndexState _indexState = result.getIndexState();
    this.indexState = _indexState;
    XtextResourceSet _resourceSet = request.getResourceSet();
    this.resourceSet = _resourceSet;
    return result;
  }
  
  protected BuildRequest newBuildRequest(final List<URI> changedFiles, final List<URI> deletedFiles) {
    BuildRequest _buildRequest = new BuildRequest();
    final Procedure1<BuildRequest> _function = new Procedure1<BuildRequest>() {
      @Override
      public void apply(final BuildRequest it) {
        it.setBaseDir(ProjectManager.this.baseDir);
        List<IResourceDescription> _emptyList = CollectionLiterals.<IResourceDescription>emptyList();
        ResourceDescriptionsData _resourceDescriptionsData = new ResourceDescriptionsData(_emptyList);
        XtextResourceSet _createFreshResourceSet = ProjectManager.this.createFreshResourceSet(_resourceDescriptionsData);
        it.setResourceSet(_createFreshResourceSet);
        ResourceDescriptionsData _resourceDescriptions = ProjectManager.this.indexState.getResourceDescriptions();
        ResourceDescriptionsData _copy = _resourceDescriptions.copy();
        Source2GeneratedMapping _fileMappings = ProjectManager.this.indexState.getFileMappings();
        Source2GeneratedMapping _copy_1 = _fileMappings.copy();
        IndexState _indexState = new IndexState(_copy, _copy_1);
        it.setState(_indexState);
        IndexState _state = it.getState();
        ResourceDescriptionsData _resourceDescriptions_1 = _state.getResourceDescriptions();
        XtextResourceSet _createFreshResourceSet_1 = ProjectManager.this.createFreshResourceSet(_resourceDescriptions_1);
        it.setResourceSet(_createFreshResourceSet_1);
        it.setDirtyFiles(changedFiles);
        it.setDeletedFiles(deletedFiles);
        final BuildRequest.IPostValidationCallback _function = new BuildRequest.IPostValidationCallback() {
          @Override
          public boolean afterValidate(final URI uri, final Iterable<Issue> issues) {
            ProjectManager.this.issueAcceptor.apply(uri, issues);
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
        Map<String, ResourceDescriptionsData> _get = ProjectManager.this.indexProvider.get();
        final ChunkedResourceDescriptions index = new ChunkedResourceDescriptions(_get, it);
        String _name = projectDescription.getName();
        index.setContainer(_name, newIndex);
        ProjectManager.this.externalContentSupport.configureResourceSet(it, ProjectManager.this.openedDocumentsContentProvider);
      }
    };
    return ObjectExtensions.<XtextResourceSet>operator_doubleArrow(_get, _function);
  }
  
  public Resource getResource(final URI uri) {
    return this.resourceSet.getResource(uri, true);
  }
}

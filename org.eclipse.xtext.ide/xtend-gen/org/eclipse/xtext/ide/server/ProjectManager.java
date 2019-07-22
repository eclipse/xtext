/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.build.BuildRequest;
import org.eclipse.xtext.build.IncrementalBuilder;
import org.eclipse.xtext.build.IndexState;
import org.eclipse.xtext.build.Source2GeneratedMapping;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.IExternalContentSupport;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IFileSystemScanner;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.workspace.ProjectConfigAdapter;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
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
  
  @Accessors({ AccessorType.PUBLIC_GETTER, AccessorType.PROTECTED_SETTER })
  private IndexState indexState = new IndexState();
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private URI baseDir;
  
  @Accessors(AccessorType.PROTECTED_GETTER)
  private Procedure2<? super URI, ? super Iterable<Issue>> issueAcceptor;
  
  @Accessors(AccessorType.PROTECTED_GETTER)
  private Provider<Map<String, ResourceDescriptionsData>> indexProvider;
  
  @Accessors(AccessorType.PROTECTED_GETTER)
  private IExternalContentSupport.IExternalContentProvider openedDocumentsContentProvider;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private XtextResourceSet resourceSet;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private ProjectDescription projectDescription;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private IProjectConfig projectConfig;
  
  public void initialize(final ProjectDescription description, final IProjectConfig projectConfig, final Procedure2<? super URI, ? super Iterable<Issue>> acceptor, final IExternalContentSupport.IExternalContentProvider openedDocumentsContentProvider, final Provider<Map<String, ResourceDescriptionsData>> indexProvider, final CancelIndicator cancelIndicator) {
    this.projectDescription = description;
    this.projectConfig = projectConfig;
    this.baseDir = projectConfig.getPath();
    this.issueAcceptor = acceptor;
    this.openedDocumentsContentProvider = openedDocumentsContentProvider;
    this.indexProvider = indexProvider;
  }
  
  public IncrementalBuilder.Result doInitialBuild(final CancelIndicator cancelIndicator) {
    final ArrayList<URI> uris = CollectionLiterals.<URI>newArrayList();
    final Consumer<ISourceFolder> _function = (ISourceFolder it) -> {
      List<URI> _allResources = it.getAllResources(this.fileSystemScanner);
      Iterables.<URI>addAll(uris, _allResources);
    };
    this.projectConfig.getSourceFolders().forEach(_function);
    return this.doBuild(uris, CollectionLiterals.<URI>emptyList(), CollectionLiterals.<IResourceDescription.Delta>emptyList(), cancelIndicator);
  }
  
  public IncrementalBuilder.Result doBuild(final List<URI> dirtyFiles, final List<URI> deletedFiles, final List<IResourceDescription.Delta> externalDeltas, final CancelIndicator cancelIndicator) {
    final BuildRequest request = this.newBuildRequest(dirtyFiles, deletedFiles, externalDeltas, cancelIndicator);
    final Function1<URI, IResourceServiceProvider> _function = (URI it) -> {
      return this.languagesRegistry.getResourceServiceProvider(it);
    };
    final IncrementalBuilder.Result result = this.incrementalBuilder.build(request, _function);
    this.indexState = result.getIndexState();
    this.resourceSet = request.getResourceSet();
    this.indexProvider.get().put(this.projectDescription.getName(), this.indexState.getResourceDescriptions());
    return result;
  }
  
  protected BuildRequest newBuildRequest(final List<URI> changedFiles, final List<URI> deletedFiles, final List<IResourceDescription.Delta> externalDeltas, final CancelIndicator cancelIndicator) {
    BuildRequest _buildRequest = new BuildRequest();
    final Procedure1<BuildRequest> _function = (BuildRequest it) -> {
      it.setBaseDir(this.baseDir);
      ResourceDescriptionsData _copy = this.indexState.getResourceDescriptions().copy();
      Source2GeneratedMapping _copy_1 = this.indexState.getFileMappings().copy();
      IndexState _indexState = new IndexState(_copy, _copy_1);
      it.setState(_indexState);
      it.setResourceSet(this.createFreshResourceSet(it.getState().getResourceDescriptions()));
      it.setDirtyFiles(changedFiles);
      it.setDeletedFiles(deletedFiles);
      it.setExternalDeltas(externalDeltas);
      final BuildRequest.IPostValidationCallback _function_1 = (URI uri, Iterable<Issue> issues) -> {
        this.issueAcceptor.apply(uri, issues);
        return true;
      };
      it.setAfterValidate(_function_1);
      it.setCancelIndicator(cancelIndicator);
    };
    return ObjectExtensions.<BuildRequest>operator_doubleArrow(_buildRequest, _function);
  }
  
  public XtextResourceSet createNewResourceSet(final ResourceDescriptionsData newIndex) {
    XtextResourceSet _get = this.resourceSetProvider.get();
    final Procedure1<XtextResourceSet> _function = (XtextResourceSet it) -> {
      this.projectDescription.attachToEmfObject(it);
      ProjectConfigAdapter.install(it, this.projectConfig);
      Map<String, ResourceDescriptionsData> _get_1 = this.indexProvider.get();
      final ChunkedResourceDescriptions index = new ChunkedResourceDescriptions(_get_1, it);
      index.setContainer(this.projectDescription.getName(), newIndex);
      this.externalContentSupport.configureResourceSet(it, this.openedDocumentsContentProvider);
    };
    return ObjectExtensions.<XtextResourceSet>operator_doubleArrow(_get, _function);
  }
  
  protected XtextResourceSet createFreshResourceSet(final ResourceDescriptionsData newIndex) {
    if ((this.resourceSet == null)) {
      this.resourceSet = this.createNewResourceSet(newIndex);
    } else {
      final ChunkedResourceDescriptions resDescs = ChunkedResourceDescriptions.findInEmfObject(this.resourceSet);
      Set<Map.Entry<String, ResourceDescriptionsData>> _entrySet = this.indexProvider.get().entrySet();
      for (final Map.Entry<String, ResourceDescriptionsData> entry : _entrySet) {
        resDescs.setContainer(entry.getKey(), entry.getValue());
      }
      resDescs.setContainer(this.projectDescription.getName(), newIndex);
    }
    return this.resourceSet;
  }
  
  public Resource getResource(final URI uri) {
    final Resource resource = this.resourceSet.getResource(uri, true);
    resource.getContents();
    return resource;
  }
  
  public void reportProjectIssue(final String message, final String code, final Severity severity) {
    Issue.IssueImpl _issueImpl = new Issue.IssueImpl();
    final Procedure1<Issue.IssueImpl> _function = (Issue.IssueImpl it) -> {
      it.setMessage(message);
      it.setCode(code);
      it.setSeverity(severity);
      it.setUriToProblem(this.baseDir);
    };
    Issue.IssueImpl _doubleArrow = ObjectExtensions.<Issue.IssueImpl>operator_doubleArrow(_issueImpl, _function);
    this.issueAcceptor.apply(this.baseDir, Collections.<Issue>unmodifiableList(CollectionLiterals.<Issue>newArrayList(_doubleArrow)));
  }
  
  @Pure
  public IndexState getIndexState() {
    return this.indexState;
  }
  
  protected void setIndexState(final IndexState indexState) {
    this.indexState = indexState;
  }
  
  @Pure
  public URI getBaseDir() {
    return this.baseDir;
  }
  
  @Pure
  protected Procedure2<? super URI, ? super Iterable<Issue>> getIssueAcceptor() {
    return this.issueAcceptor;
  }
  
  @Pure
  protected Provider<Map<String, ResourceDescriptionsData>> getIndexProvider() {
    return this.indexProvider;
  }
  
  @Pure
  protected IExternalContentSupport.IExternalContentProvider getOpenedDocumentsContentProvider() {
    return this.openedDocumentsContentProvider;
  }
  
  @Pure
  public XtextResourceSet getResourceSet() {
    return this.resourceSet;
  }
  
  @Pure
  public ProjectDescription getProjectDescription() {
    return this.projectDescription;
  }
  
  @Pure
  public IProjectConfig getProjectConfig() {
    return this.projectConfig;
  }
}

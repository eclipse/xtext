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
import io.typefox.lsapi.TextEdit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.ide.server.BuildManager;
import org.eclipse.xtext.ide.server.Document;
import org.eclipse.xtext.ide.server.IProjectDescriptionFactory;
import org.eclipse.xtext.ide.server.IWorkspaceConfigFactory;
import org.eclipse.xtext.ide.server.ProjectManager;
import org.eclipse.xtext.resource.IExternalContentSupport;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function2;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
@SuppressWarnings("all")
public class WorkspaceManager {
  @Inject
  private Provider<ProjectManager> projectManagerProvider;
  
  @Inject
  private IWorkspaceConfigFactory workspaceConfigFactory;
  
  @Inject
  private IProjectDescriptionFactory projectDescriptionFactory;
  
  @Inject
  private BuildManager buildManager;
  
  private Map<String, ProjectManager> projectName2ProjectManager = CollectionLiterals.<String, ProjectManager>newHashMap();
  
  private URI baseDir;
  
  private IWorkspaceConfig workspaceConfig;
  
  private Map<String, ResourceDescriptionsData> fullIndex = CollectionLiterals.<String, ResourceDescriptionsData>newHashMap();
  
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
  
  public void initialize(final URI baseDir, final Procedure2<? super URI, ? super Iterable<Issue>> acceptor, final CancelIndicator cancelIndicator) {
    this.baseDir = baseDir;
    IWorkspaceConfig _workspaceConfig = this.workspaceConfigFactory.getWorkspaceConfig(baseDir);
    this.workspaceConfig = _workspaceConfig;
    Set<? extends IProjectConfig> _projects = this.workspaceConfig.getProjects();
    final Consumer<IProjectConfig> _function = (IProjectConfig projectConfig) -> {
      final ProjectManager projectManager = this.projectManagerProvider.get();
      final ProjectDescription projectDescription = this.projectDescriptionFactory.getProjectDescription(projectConfig);
      final Provider<Map<String, ResourceDescriptionsData>> _function_1 = () -> {
        return this.fullIndex;
      };
      projectManager.initialize(projectDescription, projectConfig, acceptor, this.openedDocumentsContentProvider, _function_1, cancelIndicator);
      String _name = projectDescription.getName();
      this.projectName2ProjectManager.put(_name, projectManager);
    };
    _projects.forEach(_function);
    this.buildManager.doFullBuild(cancelIndicator);
  }
  
  public void doBuild(final List<URI> dirtyFiles, final List<URI> deletedFiles, final CancelIndicator cancelIndicator) {
    this.buildManager.doBuild(dirtyFiles, deletedFiles, cancelIndicator);
  }
  
  public IResourceDescriptions getIndex() {
    return new ChunkedResourceDescriptions(this.fullIndex);
  }
  
  public URI getProjectBaseDir(final URI candidate) {
    URI _xblockexpression = null;
    {
      final IProjectConfig projectConfig = this.workspaceConfig.findProjectContaining(candidate);
      _xblockexpression = projectConfig.getPath();
    }
    return _xblockexpression;
  }
  
  public ProjectManager getProjectManager(final URI uri) {
    final IProjectConfig projectConfig = this.workspaceConfig.findProjectContaining(uri);
    String _name = projectConfig.getName();
    return this.projectName2ProjectManager.get(_name);
  }
  
  public ProjectManager getProjectManager(final String projectName) {
    return this.projectName2ProjectManager.get(projectName);
  }
  
  public List<ProjectManager> getProjectManagers() {
    Collection<ProjectManager> _values = this.projectName2ProjectManager.values();
    return new ArrayList<ProjectManager>(_values);
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

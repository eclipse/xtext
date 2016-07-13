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
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.build.IncrementalBuilder;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.ide.server.ProjectManager;
import org.eclipse.xtext.ide.server.TopologicalSorter;
import org.eclipse.xtext.ide.server.WorkspaceManager;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.UriUtil;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.11
 */
@Singleton
@SuppressWarnings("all")
public class BuildManager {
  @Data
  protected static class ProjectBuildData {
    private final ProjectManager manager;
    
    private final List<URI> dirtyFiles;
    
    private final List<URI> deletedFiles;
    
    public ProjectBuildData(final ProjectManager manager, final List<URI> dirtyFiles, final List<URI> deletedFiles) {
      super();
      this.manager = manager;
      this.dirtyFiles = dirtyFiles;
      this.deletedFiles = deletedFiles;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      result = prime * result + ((this.manager== null) ? 0 : this.manager.hashCode());
      result = prime * result + ((this.dirtyFiles== null) ? 0 : this.dirtyFiles.hashCode());
      result = prime * result + ((this.deletedFiles== null) ? 0 : this.deletedFiles.hashCode());
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
      BuildManager.ProjectBuildData other = (BuildManager.ProjectBuildData) obj;
      if (this.manager == null) {
        if (other.manager != null)
          return false;
      } else if (!this.manager.equals(other.manager))
        return false;
      if (this.dirtyFiles == null) {
        if (other.dirtyFiles != null)
          return false;
      } else if (!this.dirtyFiles.equals(other.dirtyFiles))
        return false;
      if (this.deletedFiles == null) {
        if (other.deletedFiles != null)
          return false;
      } else if (!this.deletedFiles.equals(other.deletedFiles))
        return false;
      return true;
    }
    
    @Override
    @Pure
    public String toString() {
      ToStringBuilder b = new ToStringBuilder(this);
      b.add("manager", this.manager);
      b.add("dirtyFiles", this.dirtyFiles);
      b.add("deletedFiles", this.deletedFiles);
      return b.toString();
    }
    
    @Pure
    public ProjectManager getManager() {
      return this.manager;
    }
    
    @Pure
    public List<URI> getDirtyFiles() {
      return this.dirtyFiles;
    }
    
    @Pure
    public List<URI> getDeletedFiles() {
      return this.deletedFiles;
    }
  }
  
  public final static String CYCLIC_PROJECT_DEPENDENCIES = (BuildManager.class.getCanonicalName() + ".cyclicProjectDependencies");
  
  @Inject
  private WorkspaceManager workspaceManager;
  
  @Inject
  private Provider<TopologicalSorter> sorterProvider;
  
  private final LinkedHashSet<URI> dirtyFiles = CollectionLiterals.<URI>newLinkedHashSet();
  
  private final LinkedHashSet<URI> deletedFiles = CollectionLiterals.<URI>newLinkedHashSet();
  
  public void doBuild(final List<URI> dirtyFiles, final List<URI> deletedFiles, final CancelIndicator cancelIndicator) {
    this.queue(this.dirtyFiles, deletedFiles, dirtyFiles);
    this.queue(this.deletedFiles, dirtyFiles, deletedFiles);
    this.internalBuild(cancelIndicator);
  }
  
  protected void queue(final Set<URI> files, final Collection<URI> toRemove, final Collection<URI> toAdd) {
    Iterables.removeAll(files, toRemove);
    Iterables.<URI>addAll(files, toAdd);
  }
  
  public void doFullBuild(final CancelIndicator indicator) {
    List<ProjectManager> _projectManagers = this.workspaceManager.getProjectManagers();
    final Function1<ProjectManager, ProjectDescription> _function = (ProjectManager it) -> {
      return it.getProjectDescription();
    };
    List<ProjectDescription> _map = ListExtensions.<ProjectManager, ProjectDescription>map(_projectManagers, _function);
    final List<ProjectDescription> sortedDescriptions = this.sortByDependencies(_map);
    for (final ProjectDescription it : sortedDescriptions) {
      String _name = it.getName();
      ProjectManager _projectManager = this.workspaceManager.getProjectManager(_name);
      _projectManager.doFullBuild(indicator);
    }
  }
  
  protected void internalBuild(final CancelIndicator cancelIndicator) {
    final ArrayList<URI> allDirty = new ArrayList<URI>(this.dirtyFiles);
    final List<BuildManager.ProjectBuildData> buildData = CollectionLiterals.<BuildManager.ProjectBuildData>newArrayList();
    List<ProjectManager> _projectManagers = this.workspaceManager.getProjectManagers();
    for (final ProjectManager projectManager : _projectManagers) {
      {
        final URI baseDir = projectManager.getBaseDir();
        final Function1<URI, Boolean> _function = (URI it) -> {
          return Boolean.valueOf(UriUtil.isPrefixOf(baseDir, it));
        };
        Iterable<URI> _filter = IterableExtensions.<URI>filter(allDirty, _function);
        final List<URI> projectDirtyFiles = IterableExtensions.<URI>toList(_filter);
        final Function1<URI, Boolean> _function_1 = (URI it) -> {
          return Boolean.valueOf(UriUtil.isPrefixOf(baseDir, it));
        };
        Iterable<URI> _filter_1 = IterableExtensions.<URI>filter(this.deletedFiles, _function_1);
        final List<URI> projectDeletedFiles = IterableExtensions.<URI>toList(_filter_1);
        if (((!projectDirtyFiles.isEmpty()) || (!projectDeletedFiles.isEmpty()))) {
          BuildManager.ProjectBuildData _projectBuildData = new BuildManager.ProjectBuildData(projectManager, projectDirtyFiles, projectDeletedFiles);
          buildData.add(_projectBuildData);
        }
      }
    }
    final Function1<BuildManager.ProjectBuildData, ProjectDescription> _function = (BuildManager.ProjectBuildData it) -> {
      return it.manager.getProjectDescription();
    };
    final Map<ProjectDescription, BuildManager.ProjectBuildData> description2buildData = IterableExtensions.<ProjectDescription, BuildManager.ProjectBuildData>toMap(buildData, _function);
    Set<ProjectDescription> _keySet = description2buildData.keySet();
    final List<ProjectDescription> sortedDescriptions = this.sortByDependencies(_keySet);
    final Function1<ProjectDescription, BuildManager.ProjectBuildData> _function_1 = (ProjectDescription it) -> {
      return description2buildData.get(it);
    };
    final List<BuildManager.ProjectBuildData> sortedBuildData = ListExtensions.<ProjectDescription, BuildManager.ProjectBuildData>map(sortedDescriptions, _function_1);
    for (final BuildManager.ProjectBuildData it : sortedBuildData) {
      {
        final IncrementalBuilder.Result result = it.manager.doBuild(it.dirtyFiles, it.deletedFiles, cancelIndicator);
        List<IResourceDescription.Delta> _affectedResources = result.getAffectedResources();
        final Function1<IResourceDescription.Delta, URI> _function_2 = (IResourceDescription.Delta it_1) -> {
          return it_1.getUri();
        };
        List<URI> _map = ListExtensions.<IResourceDescription.Delta, URI>map(_affectedResources, _function_2);
        allDirty.addAll(_map);
        Iterables.removeAll(this.dirtyFiles, it.dirtyFiles);
        Iterables.removeAll(this.deletedFiles, it.deletedFiles);
      }
    }
  }
  
  protected List<ProjectDescription> sortByDependencies(final Collection<ProjectDescription> projectDescriptions) {
    TopologicalSorter _get = this.sorterProvider.get();
    List<ProjectDescription> _list = IterableExtensions.<ProjectDescription>toList(projectDescriptions);
    final Procedure1<ProjectDescription> _function = (ProjectDescription it) -> {
      String _name = it.getName();
      ProjectManager _projectManager = this.workspaceManager.getProjectManager(_name);
      this.reportDependencyCycle(_projectManager);
    };
    return _get.sortByDependencies(_list, _function);
  }
  
  protected void reportDependencyCycle(final ProjectManager manager) {
    manager.reportProjectIssue("Project has cyclic dependencies", BuildManager.CYCLIC_PROJECT_DEPENDENCIES, Severity.ERROR);
  }
}

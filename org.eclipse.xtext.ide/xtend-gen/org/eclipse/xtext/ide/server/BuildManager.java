/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
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
    private final List<URI> dirtyFiles;
    
    private final List<URI> deletedFiles;
    
    public ProjectBuildData(final List<URI> dirtyFiles, final List<URI> deletedFiles) {
      super();
      this.dirtyFiles = dirtyFiles;
      this.deletedFiles = deletedFiles;
    }
    
    @Override
    @Pure
    public int hashCode() {
      final int prime = 31;
      int result = 1;
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
      b.add("dirtyFiles", this.dirtyFiles);
      b.add("deletedFiles", this.deletedFiles);
      return b.toString();
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
  
  public void doInitialBuild(final List<ProjectDescription> projects, final CancelIndicator indicator) {
    final List<ProjectDescription> sortedDescriptions = this.sortByDependencies(projects);
    for (final ProjectDescription it : sortedDescriptions) {
      String _name = it.getName();
      ProjectManager _projectManager = this.workspaceManager.getProjectManager(_name);
      _projectManager.doInitialBuild(indicator);
    }
  }
  
  protected void internalBuild(final CancelIndicator cancelIndicator) {
    final ArrayList<URI> allDirty = new ArrayList<URI>(this.dirtyFiles);
    final HashMultimap<ProjectDescription, URI> project2dirty = HashMultimap.<ProjectDescription, URI>create();
    for (final URI dirty : allDirty) {
      {
        ProjectManager _projectManager = this.workspaceManager.getProjectManager(dirty);
        final ProjectDescription projectManager = _projectManager.getProjectDescription();
        project2dirty.put(projectManager, dirty);
      }
    }
    final HashMultimap<ProjectDescription, URI> project2deleted = HashMultimap.<ProjectDescription, URI>create();
    for (final URI deleted : this.deletedFiles) {
      {
        ProjectManager _projectManager = this.workspaceManager.getProjectManager(deleted);
        final ProjectDescription projectManager = _projectManager.getProjectDescription();
        project2deleted.put(projectManager, deleted);
      }
    }
    Set<ProjectDescription> _keySet = project2dirty.keySet();
    Set<ProjectDescription> _keySet_1 = project2deleted.keySet();
    Iterable<ProjectDescription> _plus = Iterables.<ProjectDescription>concat(_keySet, _keySet_1);
    final List<ProjectDescription> sortedDescriptions = this.sortByDependencies(_plus);
    for (final ProjectDescription it : sortedDescriptions) {
      {
        String _name = it.getName();
        final ProjectManager projectManager = this.workspaceManager.getProjectManager(_name);
        Set<URI> _get = project2dirty.get(it);
        List<URI> _list = IterableExtensions.<URI>toList(_get);
        Set<URI> _get_1 = project2deleted.get(it);
        List<URI> _list_1 = IterableExtensions.<URI>toList(_get_1);
        final IncrementalBuilder.Result result = projectManager.doBuild(_list, _list_1, cancelIndicator);
        List<IResourceDescription.Delta> _affectedResources = result.getAffectedResources();
        final Function1<IResourceDescription.Delta, URI> _function = (IResourceDescription.Delta it_1) -> {
          return it_1.getUri();
        };
        List<URI> _map = ListExtensions.<IResourceDescription.Delta, URI>map(_affectedResources, _function);
        allDirty.addAll(_map);
        Iterables.removeAll(this.dirtyFiles, this.dirtyFiles);
        Iterables.removeAll(this.deletedFiles, this.deletedFiles);
      }
    }
  }
  
  protected List<ProjectDescription> sortByDependencies(final Iterable<ProjectDescription> projectDescriptions) {
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

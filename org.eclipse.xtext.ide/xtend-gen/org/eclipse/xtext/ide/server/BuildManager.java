/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
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
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
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
      return prime * result + ((this.deletedFiles== null) ? 0 : this.deletedFiles.hashCode());
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
  
  public interface Buildable {
    public abstract List<IResourceDescription.Delta> build(final CancelIndicator cancelIndicator);
  }
  
  public final static String CYCLIC_PROJECT_DEPENDENCIES = (BuildManager.class.getCanonicalName() + ".cyclicProjectDependencies");
  
  @Accessors(AccessorType.PUBLIC_SETTER)
  private WorkspaceManager workspaceManager;
  
  @Inject
  private Provider<TopologicalSorter> sorterProvider;
  
  private final LinkedHashSet<URI> dirtyFiles = CollectionLiterals.<URI>newLinkedHashSet();
  
  private final LinkedHashSet<URI> deletedFiles = CollectionLiterals.<URI>newLinkedHashSet();
  
  public BuildManager.Buildable submit(final List<URI> dirtyFiles, final List<URI> deletedFiles) {
    this.queue(this.dirtyFiles, deletedFiles, dirtyFiles);
    this.queue(this.deletedFiles, dirtyFiles, deletedFiles);
    final BuildManager.Buildable _function = (CancelIndicator cancelIndicator) -> {
      return this.internalBuild(cancelIndicator);
    };
    return _function;
  }
  
  public List<IResourceDescription.Delta> doBuild(final List<URI> dirtyFiles, final List<URI> deletedFiles, final CancelIndicator cancelIndicator) {
    return this.submit(dirtyFiles, deletedFiles).build(cancelIndicator);
  }
  
  protected void queue(final Set<URI> files, final Collection<URI> toRemove, final Collection<URI> toAdd) {
    Iterables.removeAll(files, toRemove);
    Iterables.<URI>addAll(files, toAdd);
  }
  
  public List<IResourceDescription.Delta> doInitialBuild(final List<ProjectDescription> projects, final CancelIndicator indicator) {
    final List<ProjectDescription> sortedDescriptions = this.sortByDependencies(projects);
    final ArrayList<IResourceDescription.Delta> result = CollectionLiterals.<IResourceDescription.Delta>newArrayList();
    for (final ProjectDescription description : sortedDescriptions) {
      {
        final IncrementalBuilder.Result partialresult = this.workspaceManager.getProjectManager(description.getName()).doInitialBuild(indicator);
        result.addAll(partialresult.getAffectedResources());
      }
    }
    return result;
  }
  
  protected List<IResourceDescription.Delta> internalBuild(final CancelIndicator cancelIndicator) {
    final ArrayList<URI> allDirty = new ArrayList<URI>(this.dirtyFiles);
    final HashMultimap<ProjectDescription, URI> project2dirty = HashMultimap.<ProjectDescription, URI>create();
    for (final URI dirty : allDirty) {
      {
        final ProjectDescription projectManager = this.workspaceManager.getProjectManager(dirty).getProjectDescription();
        project2dirty.put(projectManager, dirty);
      }
    }
    final HashMultimap<ProjectDescription, URI> project2deleted = HashMultimap.<ProjectDescription, URI>create();
    for (final URI deleted : this.deletedFiles) {
      {
        final ProjectDescription projectManager = this.workspaceManager.getProjectManager(deleted).getProjectDescription();
        project2deleted.put(projectManager, deleted);
      }
    }
    Set<ProjectDescription> _keySet = project2dirty.keySet();
    Set<ProjectDescription> _keySet_1 = project2deleted.keySet();
    Iterable<ProjectDescription> _plus = Iterables.<ProjectDescription>concat(_keySet, _keySet_1);
    final List<ProjectDescription> sortedDescriptions = this.sortByDependencies(_plus);
    final ArrayList<IResourceDescription.Delta> result = CollectionLiterals.<IResourceDescription.Delta>newArrayList();
    for (final ProjectDescription it : sortedDescriptions) {
      {
        final ProjectManager projectManager = this.workspaceManager.getProjectManager(it.getName());
        final List<URI> projectDirty = IterableExtensions.<URI>toList(project2dirty.get(it));
        final List<URI> projectDeleted = IterableExtensions.<URI>toList(project2deleted.get(it));
        final IncrementalBuilder.Result partialResult = projectManager.doBuild(projectDirty, projectDeleted, result, cancelIndicator);
        final Function1<IResourceDescription.Delta, URI> _function = (IResourceDescription.Delta it_1) -> {
          return it_1.getUri();
        };
        allDirty.addAll(ListExtensions.<IResourceDescription.Delta, URI>map(partialResult.getAffectedResources(), _function));
        Iterables.removeAll(this.dirtyFiles, projectDirty);
        Iterables.removeAll(this.deletedFiles, projectDeleted);
        result.addAll(partialResult.getAffectedResources());
      }
    }
    return result;
  }
  
  protected List<ProjectDescription> sortByDependencies(final Iterable<ProjectDescription> projectDescriptions) {
    final Procedure1<ProjectDescription> _function = (ProjectDescription it) -> {
      this.reportDependencyCycle(this.workspaceManager.getProjectManager(it.getName()));
    };
    return this.sorterProvider.get().sortByDependencies(IterableExtensions.<ProjectDescription>toList(projectDescriptions), _function);
  }
  
  protected void reportDependencyCycle(final ProjectManager manager) {
    manager.reportProjectIssue("Project has cyclic dependencies", BuildManager.CYCLIC_PROJECT_DEPENDENCIES, Severity.ERROR);
  }
  
  public void setWorkspaceManager(final WorkspaceManager workspaceManager) {
    this.workspaceManager = workspaceManager;
  }
}

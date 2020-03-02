/*******************************************************************************
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.server;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.build.IncrementalBuilder;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.impl.DefaultResourceDescriptionDelta;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

import com.google.common.collect.FluentIterable;
import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.11
 */
public class BuildManager {
	/**
	 * The resources that are about to be build.
	 */
	protected static class ProjectBuildData {
		private final List<URI> dirtyFiles;

		private final List<URI> deletedFiles;

		public ProjectBuildData(List<URI> dirtyFiles, List<URI> deletedFiles) {
			this.dirtyFiles = dirtyFiles;
			this.deletedFiles = deletedFiles;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((deletedFiles == null) ? 0 : deletedFiles.hashCode());
			result = prime * result + ((dirtyFiles == null) ? 0 : dirtyFiles.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			ProjectBuildData other = (ProjectBuildData) obj;
			if (deletedFiles == null) {
				if (other.deletedFiles != null)
					return false;
			} else if (!deletedFiles.equals(other.deletedFiles))
				return false;
			if (dirtyFiles == null) {
				if (other.dirtyFiles != null)
					return false;
			} else if (!dirtyFiles.equals(other.dirtyFiles))
				return false;
			return true;
		}

		@Override
		public String toString() {
			ToStringBuilder b = new ToStringBuilder(this);
			b.add("dirtyFiles", dirtyFiles);
			b.add("deletedFiles", deletedFiles);
			return b.toString();
		}

		public List<URI> getDirtyFiles() {
			return dirtyFiles;
		}

		public List<URI> getDeletedFiles() {
			return deletedFiles;
		}
	}

	/**
	 * A handle that can be used to trigger a build.
	 */
	public interface Buildable {
		/**
		 * Run the build
		 */
		List<IResourceDescription.Delta> build(CancelIndicator cancelIndicator);

		/**
		 * No build is going to happen.
		 */
		Buildable NO_BUILD = (cancelIndicator) -> Collections.emptyList();
	}

	/**
	 * Issue key for cyclic dependencies
	 */
	public static final String CYCLIC_PROJECT_DEPENDENCIES = BuildManager.class.getName()
			+ ".cyclicProjectDependencies";

	private WorkspaceManager workspaceManager;

	@Inject
	private Provider<TopologicalSorter> sorterProvider;

	private final LinkedHashSet<URI> dirtyFiles = new LinkedHashSet<>();

	private final LinkedHashSet<URI> deletedFiles = new LinkedHashSet<>();

	private List<IResourceDescription.Delta> unreportedDeltas = new ArrayList<>();

	/**
	 * Enqueue the given file collections.
	 *
	 * @return a buildable.
	 */
	public Buildable submit(List<URI> dirtyFiles, List<URI> deletedFiles) {
		queue(this.dirtyFiles, deletedFiles, dirtyFiles);
		queue(this.deletedFiles, dirtyFiles, deletedFiles);
		return this::internalBuild;
	}

	/**
	 * Update the contents of the given set.
	 */
	protected void queue(Set<URI> files, Collection<URI> toRemove, Collection<URI> toAdd) {
		files.removeAll(toRemove);
		files.addAll(toAdd);
	}

	/**
	 * Run an initial build
	 *
	 * @return the delta.
	 */
	public List<IResourceDescription.Delta> doInitialBuild(List<ProjectDescription> projects,
			CancelIndicator indicator) {
		List<ProjectDescription> sortedDescriptions = sortByDependencies(projects);
		List<IResourceDescription.Delta> result = new ArrayList<>();
		for (ProjectDescription description : sortedDescriptions) {
			IncrementalBuilder.Result partialresult = workspaceManager.getProjectManager(description.getName())
					.doInitialBuild(indicator);
			result.addAll(partialresult.getAffectedResources());
		}
		return result;
	}

	/**
	 * Run the build on all projects.
	 */
	protected List<IResourceDescription.Delta> internalBuild(CancelIndicator cancelIndicator) {
		List<URI> allDirty = new ArrayList<>(dirtyFiles);
		Multimap<ProjectDescription, URI> project2dirty = HashMultimap.create();
		for (URI dirty : allDirty) {
			project2dirty.put(workspaceManager.getProjectManager(dirty).getProjectDescription(), dirty);
		}
		Multimap<ProjectDescription, URI> project2deleted = HashMultimap.create();
		for (URI deleted : deletedFiles) {
			ProjectDescription projectManager = workspaceManager.getProjectManager(deleted).getProjectDescription();
			project2deleted.put(projectManager, deleted);
		}
		List<ProjectDescription> sortedDescriptions = sortByDependencies(
				Sets.union(project2dirty.keySet(), project2deleted.keySet()));
		for (ProjectDescription it : sortedDescriptions) {
			ProjectManager projectManager = workspaceManager.getProjectManager(it.getName());
			List<URI> projectDirty = new ArrayList<>(project2dirty.get(it));
			List<URI> projectDeleted = new ArrayList<>(project2deleted.get(it));
			IncrementalBuilder.Result partialResult = projectManager.doBuild(projectDirty, projectDeleted,
					unreportedDeltas, cancelIndicator);
			FluentIterable.from(partialResult.getAffectedResources()).transform(IResourceDescription.Delta::getUri)
					.copyInto(allDirty);
			dirtyFiles.removeAll(projectDirty);
			deletedFiles.removeAll(projectDeleted);
			mergeWithUnreportedDeltas(partialResult.getAffectedResources());
		}
		List<IResourceDescription.Delta> result = unreportedDeltas;
		unreportedDeltas = new ArrayList<>();
		return result;
	}

	/**
	 * @since 2.18
	 */
	protected void mergeWithUnreportedDeltas(List<IResourceDescription.Delta> newDeltas) {
		if (unreportedDeltas.isEmpty()) {
			unreportedDeltas.addAll(newDeltas);
		} else {
			Map<URI, IResourceDescription.Delta> unreportedByUri = IterableExtensions.toMap(unreportedDeltas,
					IResourceDescription.Delta::getUri);
			for(IResourceDescription.Delta newDelta: newDeltas) {
				IResourceDescription.Delta unreportedDelta = unreportedByUri.get(newDelta.getUri());
				if (unreportedDelta == null) {
					unreportedDeltas.add(newDelta);
				} else {
					unreportedDeltas.remove(unreportedDelta);
					IResourceDescription oldDescription = unreportedDelta.getOld();
					IResourceDescription newDescription = newDelta.getNew();
					unreportedDeltas.add(new DefaultResourceDescriptionDelta(oldDescription, newDescription));
				}
			}
		}
	}

	/**
	 * Get a sorted list of projects to be build.
	 */
	protected List<ProjectDescription> sortByDependencies(Iterable<ProjectDescription> projectDescriptions) {
		return sorterProvider.get().sortByDependencies(projectDescriptions, (it) -> {
			reportDependencyCycle(workspaceManager.getProjectManager(it.getName()));
		});
	}

	protected void reportDependencyCycle(ProjectManager manager) {
		manager.reportProjectIssue("Project has cyclic dependencies", CYCLIC_PROJECT_DEPENDENCIES, Severity.ERROR);
	}

	public void setWorkspaceManager(WorkspaceManager workspaceManager) {
		this.workspaceManager = workspaceManager;
	}
}

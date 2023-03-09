/*******************************************************************************
 * Copyright (c) 2010, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Collection;
import java.util.Queue;
import java.util.Set;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.util.Strings;

import com.google.common.collect.ImmutableSet;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BuildData {

	private final ToBeBuilt toBeBuilt;
	private final QueuedBuildData queuedBuildData;
	private final String projectName;
	/**
	 * If projects are deleted from the workspace, they are not participating in a
	 * dedicated build but may be processed along with other project builds.
	 * 
	 * The removed projects may be obtained via {@link #getRemovedProjects()}
	 * 
	 * @since 2.18
	 */
	private final ImmutableSet<String> removedProjects;
	private final ResourceSet resourceSet;
	private final boolean indexingOnly;
	private final SourceLevelURICache sourceLevelURICache;
	
	/**
	 * Encapsulates how a builder can trigger a rebuild.
	 * @since 2.17
	 */
	private final Runnable buildRequestor;
	
	public BuildData(String projectName, ResourceSet resourceSet, ToBeBuilt toBeBuilt, QueuedBuildData queuedBuildData) {
		this(projectName, resourceSet, toBeBuilt, queuedBuildData, false);
	}
	
	public BuildData(String projectName, ResourceSet resourceSet, ToBeBuilt toBeBuilt, QueuedBuildData queuedBuildData, boolean indexingOnly) {
		this(projectName, resourceSet, toBeBuilt, queuedBuildData, indexingOnly, BuildManagerAccess::requestBuild);
	}
	
	/**
	 * @since 2.17
	 */
	public BuildData(String projectName, ResourceSet resourceSet, ToBeBuilt toBeBuilt, QueuedBuildData queuedBuildData, boolean indexingOnly, Runnable buildRequestor) {
		this(projectName, resourceSet, toBeBuilt, queuedBuildData, indexingOnly, buildRequestor, ImmutableSet.of());
	}

	/**
	 * @since 2.18
	 */
	public BuildData(String projectName, ResourceSet resourceSet, ToBeBuilt toBeBuilt, QueuedBuildData queuedBuildData, boolean indexingOnly, Runnable buildRequestor, Set<String> removedProjects) {
		this.projectName = Strings.emptyIfNull(projectName);
		this.removedProjects = ImmutableSet.copyOf(removedProjects);
		this.resourceSet = resourceSet;
		this.toBeBuilt = toBeBuilt;
		this.queuedBuildData = queuedBuildData;
		this.indexingOnly = indexingOnly;
		this.sourceLevelURICache = new SourceLevelURICache();
		this.buildRequestor = buildRequestor;
	}

	public boolean isEmpty() {
		return getToBeDeleted().isEmpty() && getToBeUpdated().isEmpty() && queuedBuildData.isEmpty(projectName);
	}
	
	public boolean isIndexingOnly() {
		return indexingOnly;
	}

	public Set<URI> getToBeDeleted() {
		return toBeBuilt.getToBeDeleted();
	}

	public Set<URI> getToBeUpdated() {
		return toBeBuilt.getToBeUpdated();
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	public Set<URI> getAndRemoveToBeDeleted() {
		Set<URI> result = toBeBuilt.getAndRemoveToBeDeleted();
        return result;
	}

	public void queueURI(URI uri) {
		queuedBuildData.queueURI(uri);
	}

	public Collection<IResourceDescription.Delta> getAndRemovePendingDeltas() {
		return queuedBuildData.getAndRemovePendingDeltas();
	}

	public Queue<URI> getURIQueue() {
		return queuedBuildData.getQueue(projectName);
	}
	
	public Iterable<URI> getAllRemainingURIs() {
		return queuedBuildData.getAllRemainingURIs();
	}
	
	/**
	 * Returns the name of the currently build project if this is a regular build.
	 * If it is a cleanup-build where only removed projects are processed, returns the 
	 * empty string.
	 * 
	 * @see #getRemovedProjects()
	 */
	public String getProjectName() {
		return projectName;
	}
	
	/**
	 * Returns all the projects that are processed by the current build run.
	 * 
	 * The set may contain a single regularly build project along with all projects
	 * that are no longer available and need to be removed from the builder state.
	 * 
	 * @see #getRemovedProjects()
	 * 
	 * @since 2.18
	 */
	public ImmutableSet<String> getParticipatingProjects() {
		if (Strings.isEmpty(projectName)) {
			return removedProjects;
		}
		return ImmutableSet.<String>builder().add(projectName).addAll(removedProjects).build();
	}
	
	/**
	 * Returns the processed deleted projects.
	 * 
	 * If projects are deleted from the workspace, they are not participating in a
	 * regular build but may be processed along with other project builds or as part
	 * of a normal job.
	 * 
	 * Note: There is a slight chance, that the removed projects do contain the currently build project
	 * if the project was recreated before a job has removed its contents beforehand.
	 * 
	 * @since 2.18
	 */
	public ImmutableSet<String> getRemovedProjects() {
		return removedProjects;
	}

	public SourceLevelURICache getSourceLevelURICache() {
		return sourceLevelURICache;
	}
	
	/**
	 * @since 2.17
	 */
	public void requestRebuild() {
		buildRequestor.run();
	}
}

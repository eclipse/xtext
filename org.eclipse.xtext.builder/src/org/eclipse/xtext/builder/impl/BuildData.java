/*******************************************************************************
 * Copyright (c) 2010, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	 * The participating projects may be obtained via {@link #getParticipatingProjectNames()}
	 * 
	 * @since 2.18
	 */
	private final ImmutableSet<String> participatingProjectNames;
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
		this(projectName, resourceSet, toBeBuilt, queuedBuildData, indexingOnly, buildRequestor, projectName == null ? ImmutableSet.of() : ImmutableSet.of(projectName));
	}

	/**
	 * @since 2.18
	 */
	public BuildData(Set<String> participatingProjectNames, ResourceSet resourceSet, ToBeBuilt toBeBuilt, QueuedBuildData queuedBuildData, boolean indexingOnly, Runnable buildRequestor) {
		this(participatingProjectNames.iterator().next(), resourceSet, toBeBuilt, queuedBuildData, indexingOnly, buildRequestor, participatingProjectNames);
	}
	
	/**
	 * @since 2.18
	 */
	public BuildData(String projectName, ResourceSet resourceSet, ToBeBuilt toBeBuilt, QueuedBuildData queuedBuildData, boolean indexingOnly, Runnable buildRequestor, Set<String> participatingProjectNames) {
		this.projectName = projectName;
		if (participatingProjectNames.contains(projectName) || projectName == null) {
			this.participatingProjectNames = ImmutableSet.copyOf(participatingProjectNames);
		} else {
			this.participatingProjectNames = ImmutableSet.<String>builder().add(projectName).addAll(participatingProjectNames).build();
		}
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
	
	public String getProjectName() {
		return projectName;
	}
	
	/**
	 * If projects are deleted from the workspace, they are not participating in a
	 * dedicated build but may be processed along with other project builds.
	 * 
	 * The set contains all the participating projects.
	 * 
	 * @since 2.18
	 */
	public ImmutableSet<String> getParticipatingProjectNames() {
		return participatingProjectNames;
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

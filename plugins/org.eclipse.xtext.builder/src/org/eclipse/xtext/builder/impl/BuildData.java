/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class BuildData {

	private final ToBeBuilt toBeBuilt;
	private final QueuedBuildData queuedBuildData;
	private final IProject project;
	private final ResourceSet resourceSet;
	
	public BuildData(IProject project, ResourceSet resourceSet, ToBeBuilt toBeBuilt, QueuedBuildData queuedBuildData) {
		this.project = project;
		this.resourceSet = resourceSet;
		this.toBeBuilt = toBeBuilt;
		this.queuedBuildData = queuedBuildData;
	}

	public boolean isEmpty() {
		// TODO: queue Data
		return getToBeDeleted().isEmpty() && getToBeUpdated().isEmpty();
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
	
}

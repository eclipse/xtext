/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.builder.IXtextBuilderParticipant.BuildType;
import org.eclipse.xtext.builder.IXtextBuilderParticipant.IBuildContext;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;

public class BuildContext implements IBuildContext {
	private final ResourceSet resourceSet;
	private final List<IResourceDescription.Delta> deltas;
	private final XtextBuilder builder;
	private final BuildType type;
	private final Set<URI> sourceLevelURIs;

	public BuildContext(XtextBuilder builder, ResourceSet resourceSet, List<Delta> deltas, Set<URI> sourceLevelURIs, BuildType type) {
		super();
		this.builder = builder;
		this.resourceSet = resourceSet;
		this.deltas = deltas;
		this.sourceLevelURIs = sourceLevelURIs;
		this.type = type;
	}

	@Override
	public IProject getBuiltProject() {
		return builder.getProject();
	}

	@Override
	public List<IResourceDescription.Delta> getDeltas() {
		return deltas;
	}

	@Override
	public ResourceSet getResourceSet() {
		return resourceSet;
	}
	
	@Override
	public boolean isSourceLevelURI(URI uri) {
		return sourceLevelURIs.contains(uri);
	}
	
	@Deprecated
	@Override
	public void needRebuild() {
		builder.needRebuild();
	}
	
	@Override
	public void needRebuild(IProject project) {
		if (BuildContext.class == getClass()) {
			if (getBuiltProject().equals(project)) {
				builder.triggerRequestProjectRebuild();
			} else {
				builder.triggerRequestProjectsRebuild(project);
			}
		} else {
			needRebuild();
		}
	}
	
	@Override
	public BuildType getBuildType() {
		return type;
	}
}
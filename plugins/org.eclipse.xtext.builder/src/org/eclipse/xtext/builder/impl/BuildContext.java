/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.List;

import org.eclipse.core.resources.IProject;
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

	public BuildContext(XtextBuilder builder, ResourceSet resourceSet, List<Delta> deltas, BuildType type) {
		super();
		this.type = type;
		this.builder = builder;
		this.resourceSet = resourceSet;
		this.deltas = deltas;
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
	public void needRebuild() {
		builder.needRebuild();
	}
	
	@Override
	public BuildType getBuildType() {
		return type;
	}
}
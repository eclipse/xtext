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
import org.eclipse.xtext.builder.builderState.IBuilderState;
import org.eclipse.xtext.ui.core.resource.IResourceSetProvider;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AbstractBuildScheduler {

	@Inject
	private ToBeBuiltComputer toBeBuiltComputer;

	@Inject
	private IBuilderState builderState;

	@Inject
	private IResourceSetProvider resourceSetProvider;

	public IResourceSetProvider getResourceSetProvider() {
		return resourceSetProvider;
	}
	
	public ToBeBuiltComputer getToBeBuiltComputer() {
		return toBeBuiltComputer;
	}
	
	public IBuilderState getBuilderState() {
		return builderState;
	}
	
	protected void scheduleBuildIfNecessary(final Set<IProject> toUpdate) {
		if (!toUpdate.isEmpty()) {
			new UpdateProjectsJob("Updating projects", resourceSetProvider, toUpdate, toBeBuiltComputer,
					builderState).schedule();
		}
	}
}

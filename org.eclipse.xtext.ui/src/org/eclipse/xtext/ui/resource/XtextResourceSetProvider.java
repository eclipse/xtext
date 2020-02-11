/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.shared.contribution.ISharedStateContributionRegistry;
import org.eclipse.xtext.ui.workspace.EclipseProjectConfigProvider;
import org.eclipse.xtext.workspace.ProjectConfigAdapter;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * An extensible implementation of the {@link IResourceSetProvider}.
 * It accepts a list of contributed {@link IResourceSetInitializer initializers}
 * which may configure the newly created resource set in the context of the given
 * {@link IProject project}.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
public class XtextResourceSetProvider implements IResourceSetProvider {

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;
	
	@Inject 
	private EclipseProjectConfigProvider projectConfigProvider;

	private ImmutableList<? extends IResourceSetInitializer> initializers = ImmutableList.of();

	@Inject
	private void setContributions(ISharedStateContributionRegistry contributionRegistry) {
		initializers = contributionRegistry.getContributedInstances(IResourceSetInitializer.class);
	}

	@Override
	public ResourceSet get(IProject project) {
		XtextResourceSet set = resourceSetProvider.get();
		if (project != null) {
			ProjectConfigAdapter.install(set, projectConfigProvider.createProjectConfig(project));	
		}
		for(int i = 0; i < initializers.size(); i++) {
			initializers.get(i).initialize(set, project);
		}
		return set;
	}

}

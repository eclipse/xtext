/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.shared.contribution.SharedStateContributionRegistry;

import com.google.common.collect.ImmutableList;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
public class XtextResourceSetProvider implements IResourceSetProvider {

	@Inject
	private Provider<XtextResourceSet> resourceSetProvider;

	private ImmutableList<? extends IResourceSetInitializer> initializers = ImmutableList.of();

	@Inject
	private void setContributions(SharedStateContributionRegistry contributionRegistry) {
		initializers = contributionRegistry.getContributedInstances(IResourceSetInitializer.class);
	}

	public ResourceSet get(IProject project) {
		XtextResourceSet set = resourceSetProvider.get();
		for(int i = 0; i < initializers.size(); i++) {
			initializers.get(i).initialize(set, project);
		}
		return set;
	}

}

/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring.impl;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.resource.IExternalContentSupport;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * Provides the correctly configured {@link ResourceSet} that is used during refactoring.
 * 
 * It's based on the dirty state, i.e. the content of unsaved editors can be accessed. Furthermore changed resources
 * inside the resource set shadow existing ones. 
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class RefactoringResourceSetProvider {

	@Inject
	private IExternalContentSupport externalContentSupport;

	@Inject
	private IDirtyStateManager dirtyStateManager;

	@Inject
	private IResourceSetProvider delegate;

	public ResourceSet get(IProject project) {
		ResourceSet resourceSet = delegate.get(project);
		configure(resourceSet);
		return resourceSet;
	}

	protected void configure(ResourceSet resourceSet) {
		resourceSet.getLoadOptions().put(org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider.LIVE_SCOPE,
				Boolean.TRUE);
		if (resourceSet instanceof ResourceSetImpl) {
			((ResourceSetImpl) resourceSet).setURIResourceMap(Maps.<URI, Resource>newHashMap());
		}
		externalContentSupport.configureResourceSet(resourceSet, dirtyStateManager.getActualContentProvider());
	}
}

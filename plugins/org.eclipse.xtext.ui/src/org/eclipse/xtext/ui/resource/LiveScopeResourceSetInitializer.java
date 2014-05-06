/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IExternalContentSupport;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;

import com.google.inject.Inject;

/**
 * This class configures IResourceDescrions for a ResourceSet so that
 * 
 * - in stand-alone mode, the IResourceDescriptions are created based on the current ResourceSets contents.
 * 
 * - in workspace mode, the IResourceDescriptions is the one from the Xtext Index, shadowed by the dirty state of the
 * text editors, shadowed by the contents of the current ResourceSet.
 * 
 * During linking/content-assist/serialization, the Xtext's scope providers populate their scopes based on the
 * IResourceDescriptions' contents.
 * 
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.6
 * 
 * @see ResourceDescriptionsProvider
 */
public class LiveScopeResourceSetInitializer implements IResourceSetInitializer {

	@Inject
	private IExternalContentSupport externalContentSupport;

	@Inject
	private IDirtyStateManager dirtyStateManager;

	public void initialize(ResourceSet resourceSet, IProject project) {
		resourceSet.getLoadOptions().put(ResourceDescriptionsProvider.LIVE_SCOPE, Boolean.TRUE);
		externalContentSupport.configureResourceSet(resourceSet, dirtyStateManager.getActualContentProvider());
	}
}

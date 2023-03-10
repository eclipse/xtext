/*******************************************************************************
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.resource;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IExternalContentSupport;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;

import com.google.inject.Inject;

/**
 * This class configures {@link IResourceDescriptions} for a {@link ResourceSet} so that
 * <ul>
 * <li>in stand-alone mode, the IResourceDescriptions are created based on the current ResourceSets contents.</li>
 * <li>in workspace mode, the IResourceDescriptions is the one from the Xtext Index, shadowed by the dirty state of the
 * text editors, shadowed by the contents of the current ResourceSet.</li>
 * </ul>
 * 
 * During linking/content-assist/serialization, the Xtext's scope providers populate their scopes based on the
 * {@link IResourceDescriptions IResourceDescriptions'} contents.
 * 
 * 
 * @author Moritz Eysholdt - Initial contribution and API
 * @since 2.6
 * @see ResourceDescriptionsProvider
 */
public class LiveScopeResourceSetInitializer {

	@Inject
	private IExternalContentSupport externalContentSupport;

	@Inject
	private IDirtyStateManager dirtyStateManager;

	/**
	 * @since 2.7
	 */
	public void initialize(ResourceSet resourceSet) {
		resourceSet.getLoadOptions().put(ResourceDescriptionsProvider.LIVE_SCOPE, Boolean.TRUE);
		externalContentSupport.configureResourceSet(resourceSet, dirtyStateManager.getActualContentProvider());
	}
}

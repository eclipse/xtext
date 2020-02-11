/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.editor.DocumentBasedDirtyResource;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PersistentDataAwareDirtyResource extends DocumentBasedDirtyResource {

	@Deprecated // use ResourceDescriptionsProvider.PERSISTED_DESCRIPTIONS
	public static final String PERSISTED_DESCRIPTIONS = ResourceDescriptionsProvider.PERSISTED_DESCRIPTIONS;
	
	@Inject
	@Named(ResourceDescriptionsProvider.PERSISTED_DESCRIPTIONS)
	private IResourceDescriptions resourceDescriptions;
	
	@Override
	protected void initiallyProcessResource(XtextResource resource) {
		IResourceDescription description = resourceDescriptions.getResourceDescription(resource.getURI());
		if (description != null) {
			copyState(description);
		} else {
			super.initiallyProcessResource(resource);
		}
	}

	public void setResourceDescriptions(IResourceDescriptions resourceDescriptions) {
		this.resourceDescriptions = resourceDescriptions;
	}

	public IResourceDescriptions getResourceDescriptions() {
		return resourceDescriptions;
	}
}

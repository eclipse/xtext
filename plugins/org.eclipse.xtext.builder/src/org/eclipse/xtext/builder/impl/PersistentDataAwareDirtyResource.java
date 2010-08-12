/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.DocumentBasedDirtyResource;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PersistentDataAwareDirtyResource extends DocumentBasedDirtyResource {

	public static final String PERSISTED_DESCRIPTIONS = "org.eclipse.xtext.builder.impl.PersistentDataAwareDirtyResource.PERSISTED_DESCRIPTIONS";
	
	@Inject
	@Named(PERSISTED_DESCRIPTIONS)
	private IResourceDescriptions resourceDesriptions;
	
	@Override
	protected void initiallyProcessResource(XtextResource resource) {
		IResourceDescription description = resourceDesriptions.getResourceDescription(resource.getURI());
		if (description != null) {
			copyState(description);
		} else {
			super.initiallyProcessResource(resource);
		}
	}

	public void setResourceDesriptions(IResourceDescriptions resourceDesriptions) {
		this.resourceDesriptions = resourceDesriptions;
	}

	public IResourceDescriptions getResourceDesriptions() {
		return resourceDesriptions;
	}
}

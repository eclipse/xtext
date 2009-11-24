/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultResourceDescriptionProvider implements IResourceDescription.Provider {

	@Inject
	private Provider<AbstractResourceBasedResourceDescription> descriptionProvider;
	
	public IResourceDescription getResourceDescription(Resource resource) {
		AbstractResourceBasedResourceDescription result = descriptionProvider.get();
		result.setResource(resource);
		return result;
	}

	public void setDescriptionProvider(Provider<AbstractResourceBasedResourceDescription> descriptionProvider) {
		this.descriptionProvider = descriptionProvider;
	}

	public Provider<AbstractResourceBasedResourceDescription> getDescriptionProvider() {
		return descriptionProvider;
	}

}

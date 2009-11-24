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
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultResourceDescriptionProviderRegistry implements IResourceDescription.Provider.Registry {

	@Inject
	private Provider<IResourceDescription.Provider> resourceDescriptionProvider;
	
	public IResourceDescription.Provider getResourceDescriptionProvider(Resource resource) {
		if (resource instanceof XtextResource) {
			return ((XtextResource) resource).getResourceDescriptionProvider();
		}
		// use default impl as fallback
		return resourceDescriptionProvider.get();
	}
	
}

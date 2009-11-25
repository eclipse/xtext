/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DefaultResourceDescriptionProvider implements IResourceDescription.Provider {

	@Inject
	private IQualifiedNameProvider.Registry nameProviderRegistry;
	
	public IResourceDescription getResourceDescription(Resource resource) {
		IQualifiedNameProvider nameProvider = nameProviderRegistry.getQualifiedNameProvider(resource);
		IResourceDescription result = createResourceDescription(resource, nameProvider);
		return result;
	}

	protected IResourceDescription createResourceDescription(Resource resource,
			IQualifiedNameProvider nameProvider) {
		return new DefaultResourceDescription(resource, nameProvider);
	}

}

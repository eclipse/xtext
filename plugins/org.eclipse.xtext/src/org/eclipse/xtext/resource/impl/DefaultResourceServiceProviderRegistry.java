/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.Resource.Factory;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResource;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public class DefaultResourceServiceProviderRegistry implements IResourceServiceProvider.Registry {

	@Inject
	private Provider<IResourceServiceProvider> resourceServiceProviderProvider;

	public IResourceServiceProvider getResourceServiceProvider(URI uri, String contentType) {
		Factory factory = Resource.Factory.Registry.INSTANCE.getFactory(uri, contentType);
		if (factory != null) {
			Resource resource = factory.createResource(uri);
			if (resource instanceof XtextResource) {
				return ((XtextResource) resource).getResourceServiceProvider();
			}
		}
		return resourceServiceProviderProvider.get();
	}
	
}

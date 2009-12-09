/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.IResourceDescription.Event.Listener;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LoadOnDemandResourceDescriptions implements IResourceDescriptions {

	private IResourceDescriptions delegate;
	private Collection<URI> validUris;
	private Resource context;

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;
	
	public void initialize(IResourceDescriptions delegate, Collection<URI> validUris, Resource context) {
		this.delegate = delegate;
		this.validUris = validUris;
		this.context = context;
	}
	
	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return Iterables.filter(Iterables.transform(validUris, new Function<URI, IResourceDescription>() {
			public IResourceDescription apply(URI from) {
				return getResourceDescription(from);
			}
		}), Predicates.notNull());
	}

	public IResourceDescription getResourceDescription(URI uri) {
		IResourceDescription result = delegate.getResourceDescription(uri);
		if (result == null) {
			Resource resource = EcoreUtil2.getResource(context, uri.toString());
			if (resource != null) {
				IResourceServiceProvider serviceProvider = serviceProviderRegistry.getResourceServiceProvider(uri, null);
				result = serviceProvider.getResourceDescriptionManager().getResourceDescription(resource);
			}
		}
		return result;
	}

	public void addListener(Listener listener) {
		throw new UnsupportedOperationException();
	}

	public void removeListener(Listener listener) {
		throw new UnsupportedOperationException();
	}

}

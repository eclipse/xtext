/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.impl.AbstractCompoundSelectable;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.ISelectable;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LoadOnDemandResourceDescriptions extends AbstractCompoundSelectable implements IResourceDescriptions {

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
	
	@Override
	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		return Iterables.filter(Iterables.transform(validUris, new Function<URI, IResourceDescription>() {
			@Override
			public IResourceDescription apply(URI from) {
				return getResourceDescription(from);
			}
		}), Predicates.notNull());
	}
	
	@Override
	public boolean isEmpty() {
		return validUris.isEmpty();
	}
	
	@Override
	protected Iterable<? extends ISelectable> getSelectables() {
		return getAllResourceDescriptions();
	}

	@Override
	public IResourceDescription getResourceDescription(URI uri) {
		IResourceDescription result = delegate.getResourceDescription(uri);
		if (result == null) {
			Resource resource = EcoreUtil2.getResource(context, uri.toString());
			if (resource != null) {
				IResourceServiceProvider serviceProvider = serviceProviderRegistry.getResourceServiceProvider(uri);
				if (serviceProvider==null)
					throw new IllegalStateException("No "+IResourceServiceProvider.class.getSimpleName()+" found in registry for uri "+uri);
				final Manager resourceDescriptionManager = serviceProvider.getResourceDescriptionManager();
				if (resourceDescriptionManager == null)
					throw new IllegalStateException("No "+IResourceDescription.Manager.class.getName()+" provided by service provider for URI "+uri);
				result = resourceDescriptionManager.getResourceDescription(resource);
			}
		}
		return result;
	}

}

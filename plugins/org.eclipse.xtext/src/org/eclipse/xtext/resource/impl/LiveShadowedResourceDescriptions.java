/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import static com.google.common.collect.Iterables.*;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.1
 */
public class LiveShadowedResourceDescriptions extends ResourceSetBasedResourceDescriptions {
	
	@Inject
	private IResourceDescriptions delegate;
	
	@Override
	public void setContext(Notifier ctx) {
		super.setContext(ctx);
		if(delegate instanceof IResourceDescriptions.IContextAware)
			((IResourceDescriptions.IContextAware) delegate).setContext(ctx);
	}
	
	@Override
	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		Iterable<IResourceDescription> liveDescriptions = super.getAllResourceDescriptions();
		final Iterable<URI> liveDescriptionURIs = transform(liveDescriptions, new Function<IResourceDescription, URI>() {
			public URI apply(IResourceDescription from) {
				return from.getURI();
			}
		}); 
		return concat(liveDescriptions, filter(delegate.getAllResourceDescriptions(),(new Predicate<IResourceDescription>() {
			public boolean apply(IResourceDescription input) {
				return !contains(liveDescriptionURIs, input.getURI());
			}
		})));
	}
	
	@Override
	public IResourceDescription getResourceDescription(URI uri) {
		IResourceDescription liveResourceDescription = super.getResourceDescription(uri);
		return liveResourceDescription == null ? delegate.getResourceDescription(uri) : liveResourceDescription;
	}
	
}

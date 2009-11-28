/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.impl;

import java.util.Collections;
import java.util.Set;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceDescription.Event.Listener;
import org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ShadowingResourceDescriptions implements IResourceDescriptions, IResourceDescriptions.IContextAware {

	public static class DeletedUrisAdapter extends AdapterImpl {

		public DeletedUrisAdapter(Set<URI> deletedUris) {
			super();
			this.deletedUris = deletedUris;
		}

		private Set<URI> deletedUris = null;

		public Set<URI> getDeletedUris() {
			return deletedUris;
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return DeletedUrisAdapter.class == type;
		}
	}

	protected Set<URI> getDeletedUris(Notifier notifier) {
		DeletedUrisAdapter adapter = (DeletedUrisAdapter) EcoreUtil.getAdapter(notifier.eAdapters(),
				DeletedUrisAdapter.class);
		if (adapter == null)
			return Collections.emptySet();
		return adapter.deletedUris;
	}

	public void setContext(Notifier ctx) {
		ResourceSet resourceSet = EcoreUtil2.getResourceSet(ctx);
		if (resourceSet == null)
			throw new NullPointerException();
		ResourceSetBasedResourceDescriptions resourceSetBasedResourceDescriptions = new ResourceSetBasedResourceDescriptions();
		resourceSetBasedResourceDescriptions.setContext(resourceSet);
		this.shadow = resourceSetBasedResourceDescriptions;
		deleteUris = getDeletedUris(resourceSet);
	}

	private IResourceDescriptions descriptions;
	private IResourceDescriptions shadow;
	private Set<URI> deleteUris;

	@Inject
	public ShadowingResourceDescriptions(IResourceDescriptions descriptions) {
		this.descriptions = descriptions;
	}

	public ShadowingResourceDescriptions(IResourceDescriptions descriptions, IResourceDescriptions shadow,
			Set<URI> deletedUris) {
		this.descriptions = descriptions;
		this.shadow = shadow;
		this.deleteUris = deletedUris;
	}

	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		final ImmutableMap<URI, IResourceDescription> shadowAsSet = Maps.uniqueIndex(shadow
				.getAllResourceDescriptions(), new Function<IResourceDescription, URI>() {
			public URI apply(IResourceDescription from) {
				return from.getURI();
			}
		});
		return Iterables.concat(shadowAsSet.values(), Iterables.filter(descriptions.getAllResourceDescriptions(),
				new Predicate<IResourceDescription>() {
					public boolean apply(IResourceDescription input) {
						URI uri = input.getURI();
						return !(deleteUris.contains(uri) || shadowAsSet.containsKey(uri));
					}
				}));
	}

	public IResourceDescription getResourceDescription(URI uri) {
		IResourceDescription desc = shadow.getResourceDescription(uri);
		if (desc != null)
			return desc;
		if (deleteUris.contains(uri))
			return null;
		return descriptions.getResourceDescription(uri);
	}

	public void addListener(Listener listener) {
		this.descriptions.addListener(listener);
		this.shadow.addListener(listener);
	}

	public void removeListener(Listener listener) {
		this.descriptions.removeListener(listener);
		this.shadow.removeListener(listener);
	}

}

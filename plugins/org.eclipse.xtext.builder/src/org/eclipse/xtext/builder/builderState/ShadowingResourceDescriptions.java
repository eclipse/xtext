/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builder.builderState;

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

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class ShadowingResourceDescriptions implements IResourceDescriptions, IResourceDescriptions.IContextAware {

	public static class Adapter extends AdapterImpl {

		private IResourceDescriptions toBeShadowed;
		private Set<URI> deletedUris;

		public Adapter(IResourceDescriptions toBeShadowed, Set<URI> deletedUris) {
			super();
			this.toBeShadowed = toBeShadowed;
			this.deletedUris = deletedUris;
		}
		
		public IResourceDescriptions getToBeShadowed() {
			return toBeShadowed;
		}
		
		public Set<URI> getDeletedUris() {
			return deletedUris;
		}

		@Override
		public boolean isAdapterForType(Object type) {
			return Adapter.class == type;
		}
	}

	public void setContext(Notifier ctx) {
		ResourceSet resourceSet = EcoreUtil2.getResourceSet(ctx);
		if (resourceSet == null)
			throw new NullPointerException();
		Adapter adapter = (Adapter) EcoreUtil.getAdapter(resourceSet.eAdapters(),
				Adapter.class);
		if (adapter == null)
			throw new IllegalArgumentException("No "+ShadowingResourceDescriptions.Adapter.class.getName()+" found");
		
		ResourceSetBasedResourceDescriptions resourceSetBasedResourceDescriptions = new ResourceSetBasedResourceDescriptions();
		resourceSetBasedResourceDescriptions.setContext(resourceSet);
		setShadowing(resourceSetBasedResourceDescriptions);
		setShadowed(adapter.getToBeShadowed());
		setDeleteUris(adapter.getDeletedUris());
	}

	private IResourceDescriptions shadowed;
	private IResourceDescriptions shadowing;
	private Set<URI> deleteUris;
	public void setDeleteUris(Set<URI> deleteUris) {
		this.deleteUris = deleteUris;
	}
	
	public void setShadowing(IResourceDescriptions shadow) {
		this.shadowing = shadow;
	}
	
	public void setShadowed(IResourceDescriptions descriptions) {
		this.shadowed = descriptions;
	}

	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		final ImmutableMap<URI, IResourceDescription> shadowAsSet = Maps.uniqueIndex(shadowing
				.getAllResourceDescriptions(), new Function<IResourceDescription, URI>() {
			public URI apply(IResourceDescription from) {
				return from.getURI();
			}
		});
		return Iterables.concat(shadowAsSet.values(), Iterables.filter(shadowed.getAllResourceDescriptions(),
				new Predicate<IResourceDescription>() {
					public boolean apply(IResourceDescription input) {
						URI uri = input.getURI();
						return !(deleteUris.contains(uri) || shadowAsSet.containsKey(uri));
					}
				}));
	}

	public IResourceDescription getResourceDescription(URI uri) {
		IResourceDescription desc = shadowing.getResourceDescription(uri);
		if (desc != null)
			return desc;
		if (deleteUris.contains(uri))
			return null;
		return shadowed.getResourceDescription(uri);
	}

	public void addListener(Listener listener) {
		this.shadowed.addListener(listener);
		this.shadowing.addListener(listener);
	}

	public void removeListener(Listener listener) {
		this.shadowed.removeListener(listener);
		this.shadowing.removeListener(listener);
	}

}

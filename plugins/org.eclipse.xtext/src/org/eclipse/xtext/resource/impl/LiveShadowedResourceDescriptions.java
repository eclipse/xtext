/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Collections;
import java.util.Map;

import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.ISelectable;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sebastian Zarnekow - Applied implementation pattern from DirtyStateAwareResourceDescriptions
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
	public IResourceDescription getResourceDescription(URI uri) {
		IResourceDescription result = super.getResourceDescription(uri);
		if (result == null && !isExistingOrRenamedResourceURI(uri))
			result = delegate.getResourceDescription(uri);
		return result;
	}
	
	@Override
	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		Iterable<IResourceDescription> notInLiveResourceSet = Iterables.transform(delegate.getAllResourceDescriptions(), new Function<IResourceDescription, IResourceDescription>() {
			public IResourceDescription apply(IResourceDescription from) {
				if (isExistingOrRenamedResourceURI(from.getURI())) {
					return null;
				}
				return from;
			}
		});
		Iterable<IResourceDescription> withNullEntries = Iterables.concat(super.getAllResourceDescriptions(), notInLiveResourceSet);
		Iterable<IResourceDescription> result = Iterables.filter(withNullEntries, Predicates.notNull());
		return result;
	}

	@Override
	public boolean isEmpty() {
		return delegate.isEmpty() && super.isEmpty();
	}
	
	@Override
	protected boolean hasDescription(URI uri) {
		boolean result = super.hasDescription(uri);
		if (!result) {
			if (isExistingOrRenamedResourceURI(uri)) {
				result = false;
			} else {
				result = delegate.getResourceDescription(uri) != null;
			}
		}
		return result;
	}
	
	protected boolean isExistingOrRenamedResourceURI(URI uri) {
		ResourceSet resourceSet = getResourceSet();
		if (resourceSet instanceof ResourceSetImpl) {
			Map<URI, Resource> map = ((ResourceSetImpl) resourceSet).getURIResourceMap();
			boolean result = map.containsKey(uri.trimFragment());
			return result;
		}
		throw new IllegalStateException("ResourceSet is not a ResourceSetImpl");
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjects() {
		return Iterables.concat(Iterables.transform(getAllResourceDescriptions(), new Function<ISelectable, Iterable<IEObjectDescription>>() {
			public Iterable<IEObjectDescription> apply(ISelectable from) {
				if (from != null)
					return from.getExportedObjects();
				return Collections.emptyList();
			}
		}));
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
		Iterable<IEObjectDescription> liveDescriptions = super.getExportedObjects(type, name, ignoreCase);
		Iterable<IEObjectDescription> persistentDescriptions = delegate.getExportedObjects(type, name, ignoreCase);
		return joinIterables(liveDescriptions, persistentDescriptions);
	}

	protected Iterable<IEObjectDescription> joinIterables(Iterable<IEObjectDescription> liveDescriptions,
			Iterable<IEObjectDescription> persistentDescriptions) {
		Iterable<IEObjectDescription> filteredPersistent = Iterables.filter(persistentDescriptions, new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				URI resourceURI = input.getEObjectURI().trimFragment();
				if (isExistingOrRenamedResourceURI(resourceURI))
					return false;
				return true;
			}
		});
		return Iterables.concat(liveDescriptions, filteredPersistent);
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByType(EClass type) {
		Iterable<IEObjectDescription> liveDescriptions = super.getExportedObjectsByType(type);
		Iterable<IEObjectDescription> persistentDescriptions = delegate.getExportedObjectsByType(type);
		return joinIterables(liveDescriptions, persistentDescriptions);
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
		URI resourceURI = EcoreUtil2.getNormalizedResourceURI(object);
		if (super.hasDescription(resourceURI))
			return super.getExportedObjectsByObject(object);
		return delegate.getExportedObjectsByObject(object);
	}
	
}

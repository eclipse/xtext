/*******************************************************************************
 * Copyright (c) 2011, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

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
import org.eclipse.xtext.resource.IShadowedResourceDescriptions;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @author Sebastian Zarnekow - Applied implementation pattern from DirtyStateAwareResourceDescriptions
 * @author Knut Wannheden - Fixed performance issue caused by the inheritance from ResourceSetBasedResourceDescriptions
 *         <p>
 *         The implementation now manages local resources using an injected {@link ResourceSetBasedResourceDescriptions}
 *         field. The class only inherits from {@link ResourceSetBasedResourceDescriptions} to remain backwards
 *         compatible with the initial 2.1 release.
 * 
 * @since 2.1
 */
public class LiveShadowedResourceDescriptions extends ResourceSetBasedResourceDescriptions implements IShadowedResourceDescriptions {
	
	@Inject
	private ResourceSetBasedResourceDescriptions localDescriptions;

	@Inject
	private Provider<IResourceDescriptions> globalDescriptionsProvider;

	private IResourceDescriptions globalDescriptions;
	
	@Override
	public void setContext(Notifier ctx) {
		localDescriptions.setContext(ctx);
		localDescriptions.setData(null);
		globalDescriptions = globalDescriptionsProvider.get();
		if(globalDescriptions instanceof IResourceDescriptions.IContextAware)
			((IResourceDescriptions.IContextAware) globalDescriptions).setContext(ctx);
	}

	@Override
	public IResourceDescription getResourceDescription(URI uri) {
		IResourceDescription result = localDescriptions.getResourceDescription(uri);
		if (result == null && !isExistingOrRenamedResourceURI(uri))
			result = globalDescriptions.getResourceDescription(uri);
		return result;
	}

	@Override
	public Iterable<IResourceDescription> getAllResourceDescriptions() {
		Iterable<IResourceDescription> notInLiveResourceSet = Iterables.filter(globalDescriptions.getAllResourceDescriptions(), new Predicate<IResourceDescription>() {
			@Override
			public boolean apply(IResourceDescription input) {
				return !isExistingOrRenamedResourceURI(input.getURI());
			}
		});
		Iterable<IResourceDescription> result = Iterables.concat(localDescriptions.getAllResourceDescriptions(), notInLiveResourceSet);
		return result;
	}

	@Override
	public boolean isEmpty() {
		return globalDescriptions.isEmpty() && localDescriptions.isEmpty();
	}

	@Override
	public ResourceSet getResourceSet() {
		return localDescriptions.getResourceSet();
	}

	@Override
	protected boolean hasDescription(URI uri) {
		boolean result = localDescriptions.hasDescription(uri);
		if (!result) {
			if (isExistingOrRenamedResourceURI(uri)) {
				result = false;
			} else {
				result = globalDescriptions.getResourceDescription(uri) != null;
			}
		}
		return result;
	}

	protected boolean isExistingOrRenamedResourceURI(URI uri) {
		ResourceSet resourceSet = localDescriptions.getResourceSet();
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
			@Override
			public Iterable<IEObjectDescription> apply(ISelectable from) {
				if (from != null)
					return from.getExportedObjects();
				return ImmutableSet.of();
			}
		}));
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjects(EClass type, QualifiedName name, boolean ignoreCase) {
		Iterable<IEObjectDescription> liveDescriptions = localDescriptions.getExportedObjects(type, name, ignoreCase);
		Iterable<IEObjectDescription> persistentDescriptions = globalDescriptions.getExportedObjects(type, name, ignoreCase);
		return joinIterables(liveDescriptions, persistentDescriptions);
	}

	protected Iterable<IEObjectDescription> joinIterables(Iterable<IEObjectDescription> liveDescriptions,
			Iterable<IEObjectDescription> persistentDescriptions) {
		Iterable<IEObjectDescription> filteredPersistent = Iterables.filter(persistentDescriptions, new Predicate<IEObjectDescription>() {
			@Override
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
		Iterable<IEObjectDescription> liveDescriptions = localDescriptions.getExportedObjectsByType(type);
		Iterable<IEObjectDescription> persistentDescriptions = globalDescriptions.getExportedObjectsByType(type);
		return joinIterables(liveDescriptions, persistentDescriptions);
	}

	@Override
	public Iterable<IEObjectDescription> getExportedObjectsByObject(EObject object) {
		URI resourceURI = EcoreUtil2.getPlatformResourceOrNormalizedURI(object).trimFragment();
		if (localDescriptions.hasDescription(resourceURI))
			return localDescriptions.getExportedObjectsByObject(object);
		return globalDescriptions.getExportedObjectsByObject(object);
	}
	
	/**
	 * @since 2.6
	 */
	public IResourceDescriptions getLocalDescriptions() {
		return localDescriptions;
	}
	
	/**
	 * @since 2.6
	 */
	public IResourceDescriptions getGlobalDescriptions() {
		return globalDescriptions;
	}
	
	/**
	 * @since 2.6
	 */
	public void setGlobalDescriptions(IResourceDescriptions globalDescriptions) {
		this.globalDescriptions = globalDescriptions;
	}
	
	/**
	 * @since 2.6
	 */
	public void setLocalDescriptions(ResourceSetBasedResourceDescriptions localDescriptions) {
		this.localDescriptions = localDescriptions;
	}

	@Override
	public boolean isShadowed(EClass type, QualifiedName name, boolean ignoreCase) {
		return !Iterables.isEmpty(localDescriptions.getExportedObjects(type, name, ignoreCase))
				&& !Iterables.isEmpty(globalDescriptions.getExportedObjects(type, name, ignoreCase));
	}

}

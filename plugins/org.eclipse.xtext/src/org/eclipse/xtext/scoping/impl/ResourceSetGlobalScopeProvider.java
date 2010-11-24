/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import static com.google.common.collect.Iterables.*;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.ResourceSetReferencingResourceSet;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.ISelector;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * A {@link IGlobalScopeProvider} which puts all elements in the {@link ResourceSet} on the scope.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceSetGlobalScopeProvider extends AbstractGlobalScopeProvider {
	
	@Inject
	private GlobalResourceDescriptionProvider resourceDecriptionProvider;
	
	public void setGlobalResourceDecriptionProvider(GlobalResourceDescriptionProvider resourceDecriptionProvider) {
		this.resourceDecriptionProvider = resourceDecriptionProvider;
	}

	@Override
	protected IScope getScope(Resource resource, Predicate<IEObjectDescription> filter) {
		IScope parent = IScope.NULLSCOPE;
		if (resource == null || resource.getResourceSet() == null)
			return parent;
		final ResourceSet resourceSet = resource.getResourceSet();
		if (resourceSet instanceof ResourceSetReferencingResourceSet) {
			ResourceSetReferencingResourceSet set = (ResourceSetReferencingResourceSet) resourceSet;
			Iterable<ResourceSet> referencedSets = Iterables.reverse(set.getReferencedResourceSets());
			for (ResourceSet referencedSet : referencedSets) {
				parent = createScopeWithQualifiedNames(parent, resource, filter, referencedSet);
			}
		}
		return createScopeWithQualifiedNames(parent, resource, filter, resourceSet);
	}

	protected IScope createScopeWithQualifiedNames(final IScope parent, final Resource resource,
			final Predicate<IEObjectDescription> filter, ResourceSet resourceSet) {
		final Iterable<IResourceDescription> resourceDescriptions = Iterables.transform(resourceSet.getResources(), new Function<Resource, IResourceDescription>() {
			public IResourceDescription apply(Resource from) {
				return resourceDecriptionProvider.getResourceDescription(from);
			}
		});
		return new AbstractScope(parent) {
			
			@Override
			public Iterable<IEObjectDescription> getLocalElements(final ISelector selector) {
				Iterable<Iterable<IEObjectDescription>> result = transform(resourceDescriptions, new Function<IResourceDescription, Iterable<IEObjectDescription>>() {
					public Iterable<IEObjectDescription> apply(IResourceDescription from) {
						return from.getExportedObjects(selector);
					}
				});
				return filter(concat(result), filter);
			}
		};
	}

}

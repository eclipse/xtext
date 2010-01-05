/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.ResourceSetReferencingResourceSet;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.base.Function;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;

/**
 * A {@link IGlobalScopeProvider} which puts all elements in the {@link ResourceSet} on the scope.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceSetGlobalScopeProvider extends AbstractExportedObjectsAwareScopeProvider implements IGlobalScopeProvider {

	public IScope getScope(EObject context, EReference reference) {
		IScope parent = IScope.NULLSCOPE;
		if (context.eResource() == null || context.eResource().getResourceSet() == null)
			return parent;
		final ResourceSet resourceSet = context.eResource().getResourceSet();
		if (resourceSet instanceof ResourceSetReferencingResourceSet) {
			ResourceSetReferencingResourceSet set = (ResourceSetReferencingResourceSet) resourceSet;
			Iterable<ResourceSet> referencedSets = Iterables.reverse(set.getReferencedResourceSets());
			for (ResourceSet referencedSet : referencedSets) {
				parent = createScopeWithQualifiedNames(parent, context, reference, referencedSet);
			}
		}
		return createScopeWithQualifiedNames(parent, context, reference, resourceSet);
	}

	protected IScope createScopeWithQualifiedNames(final IScope parent, final EObject context,
			final EReference reference, ResourceSet resourceSet) {
		Iterable<IResourceDescription> descriptions = Iterables.transform(resourceSet.getResources(), new Function<Resource, IResourceDescription>() {
			public IResourceDescription apply(Resource from) {
				return getResourceDescription(from);
			}
		});
		final Iterable<IResourceDescription> filteredDescriptions = Iterables.filter(descriptions, Predicates.notNull());
		Iterable<Iterable<IEObjectDescription>> objectDescriptionsIter = Iterables.transform(filteredDescriptions, new Function<IResourceDescription, Iterable<IEObjectDescription>>() {
			public Iterable<IEObjectDescription> apply(IResourceDescription from) {
				return from.getExportedObjects(reference.getEReferenceType());
			}
		});
		Iterable<IEObjectDescription> objectDescriptions = Iterables.concat(objectDescriptionsIter);
		return new SimpleScope(parent, objectDescriptions) {
			@Override
			public IEObjectDescription getContentByName(String name) {
				IEObjectDescription result = null;
				for(IResourceDescription description: filteredDescriptions) {
					Iterable<IEObjectDescription> objects = description.getExportedObjects(reference.getEReferenceType(), name);
					Iterator<IEObjectDescription> iter = objects.iterator();
					if (iter.hasNext()) {
						if (result != null)
							return getOuterScope().getContentByName(name);
						result = iter.next();
						if (iter.hasNext())
							return getOuterScope().getContentByName(name);
					}
				}
				if (result != null)
					return result;
				return getOuterScope().getContentByName(name);
			}
		};
	}

}

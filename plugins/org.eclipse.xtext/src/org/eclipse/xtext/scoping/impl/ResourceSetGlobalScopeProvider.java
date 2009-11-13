/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import static com.google.common.collect.Iterables.*;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.IExportedEObjectsProvider;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.ResourceSetReferencingResourceSet;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * A {@link IGlobalScopeProvider} which puts all elements in the {@link ResourceSet} on the scope.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceSetGlobalScopeProvider extends AbstractScopeProvider implements IGlobalScopeProvider {

	private IResourceServiceProvider serviceProvider;

	@Inject
	public void setServiceProvider(IResourceServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

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
		List<Iterable<IEObjectDescription>> iterables = new ArrayList<Iterable<IEObjectDescription>>();

		for (Resource resource : resourceSet.getResources()) {
			IExportedEObjectsProvider service = serviceProvider.getService(resource, IExportedEObjectsProvider.class);
			if (service != null)
				iterables.add(service.getExportedObjects(resource));
		}
		Iterable<IEObjectDescription> descriptions = Iterables.concat(iterables);
		Iterable<IEObjectDescription> filtered = filter(descriptions, new Predicate<IEObjectDescription>() {
			public boolean apply(IEObjectDescription input) {
				return reference.getEReferenceType().isSuperTypeOf(input.getEClass());
			}
		});
		return new SimpleScope(parent,filtered);
	}

}

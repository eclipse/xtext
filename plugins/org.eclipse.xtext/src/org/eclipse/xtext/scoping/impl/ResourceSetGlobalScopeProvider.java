/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import static com.google.common.collect.Iterables.*;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.ResourceSetReferencingResourceSet;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IQualifiedNameProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopedElement;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;

/**
 * A {@link IGlobalScopeProvider} which puts all elements in the {@link ResourceSet} on the scope.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class ResourceSetGlobalScopeProvider extends AbstractScopeProvider implements IGlobalScopeProvider {

	private IQualifiedNameProvider nameProvider;

	@Inject
	public ResourceSetGlobalScopeProvider(IQualifiedNameProvider qualifiedNameProvider) {
		this.nameProvider = qualifiedNameProvider;
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
				parent = createScopeWithQualifiedNames(parent, reference, allEObjects(referencedSet));
			}
		}
		Iterable<EObject> filtered = allEObjects(resourceSet);
		return createScopeWithQualifiedNames(parent, reference, filtered);
	}

	protected IScope createScopeWithQualifiedNames(final IScope parent, final EReference reference,
			Iterable<EObject> eObjects) {

		eObjects = filter(eObjects, typeFilter(reference.getEReferenceType()));
		Iterable<IScopedElement> result = transform(eObjects, new Function<EObject, IScopedElement>() {

			public IScopedElement apply(EObject from) {
				String qualifiedName = nameProvider.getQualifiedName(from);
				if (qualifiedName != null) {
					return ScopedElement.create(qualifiedName, from);
				}
				return null;
			}
		});
		return new SimpleScope(parent, filter(result, Predicates.notNull()));
	}

	protected Predicate<EObject> typeFilter(final EClass type) {
		return new Predicate<EObject>() {

			public boolean apply(EObject input) {
				return type.isInstance(input);
			}
		};
	}

	private Iterable<EObject> allEObjects(final ResourceSet resourceSet) {
		Iterable<EObject> contents = new Iterable<EObject>() {
			public Iterator<EObject> iterator() {
				return EcoreUtil.getAllProperContents(resourceSet, true);
			}
		};
		Iterable<EObject> filtered = Iterables.filter(contents, EObject.class);
		return filtered;
	}

}

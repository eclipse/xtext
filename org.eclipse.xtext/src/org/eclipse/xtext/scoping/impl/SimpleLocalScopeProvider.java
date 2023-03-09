/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import java.util.Iterator;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.ISelectable;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.Tuples;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * A local scope that uses the qualified names of all elements of an {@link org.eclipse.emf.ecore.resource.Resource} and
 * delegates to a global scope.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public class SimpleLocalScopeProvider extends AbstractGlobalScopeDelegatingScopeProvider {

	@Inject
	private IQualifiedNameProvider qualifiedNameProvider;

	@Inject
	private IResourceScopeCache cache;
	
	public void setCache(IResourceScopeCache cache) {
		this.cache = cache;
	}

	public void setNameProvider(IQualifiedNameProvider nameProvider) {
		this.qualifiedNameProvider = nameProvider;
	}

	protected IQualifiedNameProvider getNameProvider() {
		return qualifiedNameProvider;
	}

	@Override
	public IScope getScope(final EObject context, final EReference reference) {
		ISelectable resourceContent = cache.get(Tuples.pair(SimpleLocalScopeProvider.class.getName(), reference), 
				context.eResource(), new Provider<ISelectable>() {
			@Override
			public ISelectable get() {
				return getAllDescriptions(context.eResource());
			}
		});
		IScope globalScope = getGlobalScope(context.eResource(), reference);
		return createScope(globalScope, resourceContent, reference.getEReferenceType(), isIgnoreCase(reference));
	}

	protected IScope createScope(IScope parent, ISelectable resourceContent, EClass type, boolean ignoreCase) {
		return SelectableBasedScope.createScope(parent, resourceContent, type, ignoreCase);
	}

	protected ISelectable getAllDescriptions(final Resource resource) {
		Iterable<EObject> allContents = new Iterable<EObject>(){
			@Override
			public Iterator<EObject> iterator() {
				return resource.getAllContents();
			}
		}; 
		Iterable<IEObjectDescription> allDescriptions = Scopes.scopedElementsFor(allContents, qualifiedNameProvider);
		return new MultimapBasedSelectable(allDescriptions);
	}
}

/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import static com.google.common.collect.Iterables.*;

import java.util.Iterator;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IgnoreCaseLinking;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.Tuples;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Multimap;
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
	private IQualifiedNameProvider nameProvider;

	@Inject
	private IResourceScopeCache cache;
	
	@Inject(optional=true)
	@IgnoreCaseLinking
	private boolean isIgnoreCase = false;

	public void setCache(IResourceScopeCache cache) {
		this.cache = cache;
	}

	public void setNameProvider(IQualifiedNameProvider nameProvider) {
		this.nameProvider = nameProvider;
	}

	protected IQualifiedNameProvider getNameProvider() {
		return nameProvider;
	}

	public IScope getScope(final EObject context, final EReference reference) {
		Multimap<QualifiedName, IEObjectDescription> map = cache.get(Tuples.pair(SimpleLocalScopeProvider.class.getName(),
				reference), context.eResource(), new Provider<Multimap<QualifiedName, IEObjectDescription>>() {

			public Multimap<QualifiedName, IEObjectDescription> get() {
				return toMap(context, reference);
			}

		});
		IScope globalScope = getGlobalScope(context, reference);
		return createScope(globalScope, map);
	}

	protected IScope createScope(IScope parent, Multimap<QualifiedName, IEObjectDescription> map) {
		return new MultimapBasedScope(parent, map);
	}

	protected IEObjectDescription createEObjectDescription(EObject next, QualifiedName qualifiedName) {
		return new EObjectDescription(qualifiedName, next, null, isIgnoreCase);
	}

	protected Multimap<QualifiedName, IEObjectDescription> toMap(final EObject context, final EReference reference) {
		Iterable<EObject> iterable = new Iterable<EObject>(){
			public Iterator<EObject> iterator() {
				return context.eResource().getAllContents();
			}}; 
		iterable = filter(iterable, new Predicate<EObject>() {
			public boolean apply(EObject input) {
				return reference.getEReferenceType().isInstance(input);
			}
		});
		Iterable<IEObjectDescription> transformed = transform(iterable, new Function<EObject,IEObjectDescription>(){
			public IEObjectDescription apply(EObject from) {
				final QualifiedName fullyQualifiedName = nameProvider.getFullyQualifiedName(from);
				if (fullyQualifiedName==null)
					return null;
				return createEObjectDescription(from, fullyQualifiedName);
			}});
		
		return Scopes.index(filter(transformed,Predicates.notNull()));
	}
}

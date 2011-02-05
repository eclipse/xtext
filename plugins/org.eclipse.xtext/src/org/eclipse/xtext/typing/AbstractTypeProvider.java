/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.typing;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.Tuples;

import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class AbstractTypeProvider<T, P extends EObject> implements ITypeProvider<T, P> {

	private final PolymorphicDispatcher<T> typeDispatcher = PolymorphicDispatcher.createForSingleTarget("_type",2,2, this);
	
	public T getType(final P astNode, final boolean selfContained) {
		if (astNode == null)
			return null;
		if (astNode.eIsProxy())
			return null;
		final Provider<T> provider = new Provider<T>() {
			public T get() {
				final T invoke = typeDispatcher.invoke(astNode, selfContained);
				return invoke;
			}
		};
		final IResourceScopeCache cache = getCache(astNode);
		if (cache == null)
			return provider.get();
		else
			return cache.get(getCachKey(astNode, selfContained), astNode.eResource(), provider);
	}

	protected Object getCachKey(final P astNode, boolean selfContained) {
		return Tuples.create(getClass(), astNode, selfContained);
	}

	private IResourceScopeCache getCache(EObject astNode) {
		if (!(astNode.eResource() instanceof XtextResource))
			return null;
		return ((XtextResource) astNode.eResource()).getCache();
	}

	public T _type(EObject stNode, boolean selfContained) {
		throw new IllegalArgumentException("Type computation is not implemented for " + stNode);
	}
	
	protected String getName(T actual) {
		return actual != null ? actual.toString() : "null";
	}

}

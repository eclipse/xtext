/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.typing;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.util.IResourceScopeCache;
import org.eclipse.xtext.util.PolymorphicDispatcher;
import org.eclipse.xtext.util.Tuples;

import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class AbstractExpectedTypeProvider<T,P extends EObject> implements IExpectedTypeProvider<T,P> {

	public T getExpectedType(P obj) {
		if (obj == null)
			return null;
		if (obj.eIsProxy())
			return null;
		EReference containmentReference = obj.eContainmentFeature();
		if(containmentReference == null)
			return null;
		EObject container = obj.eContainer();
		int index = (containmentReference.isMany()) ? ((List<?>)container.eGet(containmentReference)).indexOf(obj) : -1;
		return getExpectedType(container, containmentReference, index);
	}

	private IResourceScopeCache getCache(EObject astNode) {
		if (!(astNode.eResource() instanceof XtextResource))
			return null;
		return ((XtextResource) astNode.eResource()).getCache();
	}

	private final PolymorphicDispatcher<T> expectedTypeDispatcher = PolymorphicDispatcher.createForSingleTarget(
			"_expectedType", 3, 3, this);

	public T getExpectedType(final EObject obj, final EReference reference, final int index) {
		final Provider<T> provider = new Provider<T>() {
			public T get() {
				final T expectedType = expectedTypeDispatcher.invoke(obj, reference, index);
				return expectedType;
			}
		};
		final IResourceScopeCache cache = getCache(obj);
		if (cache == null)
			return provider.get();
		else
			return cache.get(Tuples.pair("expectedType", Tuples.create(obj,reference, index)), obj.eResource(), provider);
	}
	
	protected T _expectedType(EObject container, EReference reference, int index) {
		return null;
	}

}

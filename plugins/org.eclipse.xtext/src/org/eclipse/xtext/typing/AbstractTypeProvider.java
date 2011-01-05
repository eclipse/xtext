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
import org.eclipse.xtext.validation.ValidationMessageAcceptor;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class AbstractTypeProvider<T> implements ITypeProvider<T> {

	private final PolymorphicDispatcher<T> typeDispatcher = PolymorphicDispatcher.createForSingleTarget("_type", this);

	@Inject(optional = true)
	private IExpectedTypeProvider<T> expectedTypeProvider;

	public void setExpectedTypeProvider(IExpectedTypeProvider<T> expectedTypeProvider) {
		this.expectedTypeProvider = expectedTypeProvider;
	}

	protected T getExpectedType(EObject astNode) {
		return expectedTypeProvider != null ? expectedTypeProvider.getExpectedType(astNode) : null;
	}

	public T getType(final EObject astNode) {
		if (astNode == null)
			throw new IllegalArgumentException("expression was null");
		final Provider<T> provider = new Provider<T>() {
			public T get() {
				final T invoke = typeDispatcher.invoke(astNode);
				T actual = doConversion(invoke, astNode);
				return actual;
			}
		};
		final IResourceScopeCache cache = getCache(astNode);
		if (cache == null)
			return provider.get();
		else
			return cache.get(Tuples.pair("typeInference", astNode), astNode.eResource(), provider);
	}

	private IResourceScopeCache getCache(EObject astNode) {
		if (!(astNode.eResource() instanceof XtextResource))
			return null;
		return ((XtextResource) astNode.eResource()).getCache();
	}

	protected T doConversion(T actualType, EObject context) {
		return actualType;
	}

	public T _type(EObject stNode, T expectedType, ValidationMessageAcceptor messageAcceptor) {
		throw new IllegalArgumentException("Type computation is not implmented for AST nodes of type "
				+ stNode.getClass().getCanonicalName());
	}

	protected String getName(T actual) {
		return actual != null ? actual.toString() : "null";
	}

}

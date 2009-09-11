/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.index;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DeclarativeScopeProvider;

import com.google.inject.Inject;

/**
 * <p>Index based scope provider with support from {@link DeclarativeScopeProvider} which allows to specify scoping 
 * in a declarative way. See JavaDoc of {@link DeclarativeScopeProvider}
 * </p>
 * <p>
 * If no polymorphic signature can be found for the given EObject and EReference this implementation calls
 * {@link IndexBasedScopeProvider#getScope(EObject, EReference)}
 * 
 * </p>
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractDeclarativeIndexBasedScopeProvider extends IndexBasedScopeProvider {
	
	@Inject
	private DeclarativeScopeProvider declarativeSupport = new DeclarativeScopeProvider(this);
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		IScope scope = declarativeSupport.getScope(context, reference);
		if (scope!=null)
			return scope;
		return super.getScope(context, reference);
	}
}

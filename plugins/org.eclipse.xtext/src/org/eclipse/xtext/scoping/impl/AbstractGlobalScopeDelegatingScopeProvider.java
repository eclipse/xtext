/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractGlobalScopeDelegatingScopeProvider extends AbstractExportedObjectsAwareScopeProvider {

	@Inject
	private IGlobalScopeProvider globalScopeProvider;

	public void setGlobalScopeProvider(IGlobalScopeProvider globalScopeProvider) {
		this.globalScopeProvider = globalScopeProvider;
	}

	protected IScope getGlobalScope(final EObject context, final EReference reference) {
		return wrap(globalScopeProvider.getScope(context, reference));
	}
	
	private IScopeWrapper scopeWrapper;
	
	public void setWrapper(IScopeWrapper wrapper) {
		this.scopeWrapper = wrapper;
	}

	protected IScope wrap(IScope scope) {
		return scopeWrapper!=null ? scopeWrapper.wrap(scope) : scope;
	}

}

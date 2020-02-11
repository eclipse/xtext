/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.ICaseInsensitivityHelper;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;

import com.google.common.base.Predicate;
import com.google.inject.Inject;

/**
 * A local scope provider that can delegate to a global scope.
 *  
 * @author Sven Efftinge - Initial contribution and API
 */
public abstract class AbstractGlobalScopeDelegatingScopeProvider extends AbstractScopeProvider {

	@Inject
	private IGlobalScopeProvider globalScopeProvider;
	
	@Inject
	private ICaseInsensitivityHelper caseInsensitivityHelper;

	protected AbstractGlobalScopeDelegatingScopeProvider() {
	}
	
	protected AbstractGlobalScopeDelegatingScopeProvider(IGlobalScopeProvider globalScopeProvider, ICaseInsensitivityHelper caseInsensitivityHelper) {
		this.globalScopeProvider = globalScopeProvider;
		this.caseInsensitivityHelper = caseInsensitivityHelper;
	}

	protected IScope getGlobalScope(final Resource context, final EReference reference) {
		return getGlobalScope(context, reference, null);
	}
	
	protected IScope getGlobalScope(final Resource context, final EReference reference, final Predicate<IEObjectDescription> filter) {
		return wrap(globalScopeProvider.getScope(context, reference, filter));
	}
	
	private IScopeWrapper scopeWrapper;
	
	public void setWrapper(IScopeWrapper wrapper) {
		this.scopeWrapper = wrapper;
	}

	protected IScope wrap(IScope scope) {
		return scopeWrapper!=null ? scopeWrapper.wrap(scope) : scope;
	}
	
	protected boolean isIgnoreCase(EReference reference) {
		return caseInsensitivityHelper.isIgnoreCase(reference);
	}

}

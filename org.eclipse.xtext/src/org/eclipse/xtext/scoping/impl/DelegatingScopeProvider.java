/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * This implementation skips the declarative API of the {@link AbstractDeclarativeScopeProvider}
 * while still delegating to another {@link org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider#NAMED_DELEGATE provider}.
 * 
 * Meant to be used as the base class for custom scope providers.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.4
 */
public class DelegatingScopeProvider extends AbstractScopeProvider implements IDelegatingScopeProvider {

	@Inject
	@Named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE)
	private IScopeProvider delegate;
	
	@Override
	public IScope getScope(EObject context, EReference reference) {
		return delegateGetScope(context, reference);
	}
	
	protected IScope delegateGetScope(EObject context, EReference reference) {
		return getDelegate().getScope(context, reference);
	}

	public void setDelegate(IScopeProvider delegate) {
		this.delegate = delegate;
	}

	@Override
	public IScopeProvider getDelegate() {
		return delegate;
	}

}

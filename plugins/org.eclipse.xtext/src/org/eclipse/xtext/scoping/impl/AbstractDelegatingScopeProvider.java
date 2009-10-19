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
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AbstractDelegatingScopeProvider extends AbstractScopeProvider {

	private IScopeProvider delegate;
	
	public IScope getScope(EObject context, EReference reference) {
		return delegateGetScope(context, reference);
	}
	
	protected IScope delegateGetScope(EObject context, EReference reference) {
		return getDelegate().getScope(context, reference);
	}

	public void setDelegate(IScopeProvider delegate) {
		this.delegate = delegate;
	}

	public IScopeProvider getDelegate() {
		return delegate;
	}

}

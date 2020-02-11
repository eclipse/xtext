/*******************************************************************************
 * Copyright (c) 2011, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping.impl;

import org.eclipse.xtext.scoping.IScopeProvider;

/**
 * A delegating scope provider marks an implementation, that handles only a couple of cases
 * but will use another {@link IScopeProvider} to compute its parent scope or that takes care
 * of other cases.
 * 
 * It is used to provide (recursive) access to the implementation, that will finally delegate
 * to the global scope. This is necessary to allow wrapping of global scopes to keep track of imported names.
 * 
 * @see org.eclipse.xtext.scoping.impl.AbstractGlobalScopeDelegatingScopeProvider
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.1
 */
public interface IDelegatingScopeProvider extends IScopeProvider {

	/**
	 * Provides access to the delegate.
	 * @return the delegate. May not be <code>null</code>.
	 */
	IScopeProvider getDelegate();
	
	/**
	 * Set the wrapper this delegating scope provider. This encapsulates the traversal of the
	 * delegate and allows clients to set the wrapper on multiple delegates if necessary.
	 * 
	 * The wrapper may be <code>null</code>
	 * 
	 * @since 2.14
	 */
	default void setWrapper(IScopeWrapper wrapper) {
		setWrapper(getDelegate(), wrapper);
	}
	
	/**
	 * Set the given wrapper on the given {@link IScopeProvider} if the scope provider is either a
	 * delegating scope provider or an {@link AbstractGlobalScopeDelegatingScopeProvider}.
	 * 
	 * The wrapper may be <code>null</code>
	 * 
	 * @since 2.14
	 */
	static void setWrapper(IScopeProvider scopeProvider, IScopeWrapper wrapper) {
		if (scopeProvider instanceof AbstractGlobalScopeDelegatingScopeProvider) {
			AbstractGlobalScopeDelegatingScopeProvider provider = (AbstractGlobalScopeDelegatingScopeProvider) scopeProvider;
			provider.setWrapper(wrapper);
		} else if (scopeProvider instanceof IDelegatingScopeProvider) {
			IDelegatingScopeProvider delegatingScopeProvider = (IDelegatingScopeProvider) scopeProvider;
			delegatingScopeProvider.setWrapper(wrapper);
		}
	}
	
}

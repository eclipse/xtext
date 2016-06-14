/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
	
}

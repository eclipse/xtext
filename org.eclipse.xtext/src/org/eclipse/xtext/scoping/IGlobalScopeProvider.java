/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping;

import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IEObjectDescription;

import com.google.common.base.Predicate;

/**
 * Provides scopes for the world, that is things which are not local (i.e. within a resource).
 * 
 * Common scope providers (local ones) use them to delegate lookup for any elements, which are not
 * locally available.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IGlobalScopeProvider {

	/**
	 * Returns a global scope for the given context. The scope provides access to the
	 * {@link org.eclipse.xtext.resource.EObjectDescription} visible from the given {@link Resource}
	 * according to the definition of the global scope hierarchy (which is usually defined by 
	 * {@link org.eclipse.xtext.resource.IContainer.Manager}).
	 *
	 * @param context the resource from which the global scope is looked at.
	 * @param reference the reference for which to construct a global scope.
	 * @param filter a filter used to filter down the elements contained in each scope. Scopes will only contain elements for which the filter returned <code>true</code>.
	 * @return {@link IScope} representing the inner most {@link IScope} for the
	 *         passed context and reference. Note for implementors: The result may not be <code>null</code>.
	 *         Return <code>IScope.NULLSCOPE</code> instead.
	 */
	IScope getScope(Resource context, EReference reference, Predicate<IEObjectDescription> filter);
}

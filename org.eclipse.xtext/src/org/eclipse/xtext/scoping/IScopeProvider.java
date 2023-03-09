/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * An IScopeProvider can be used, to get access to a set of visible elements ({@link org.eclipse.xtext.resource.IEObjectDescription}). 
 * 
 * Implementations should inherit from {@link org.eclipse.xtext.scoping.impl.AbstractScopeProvider}.
 * 
 * @author Heiko Behrens - Initial contribution and API
 * @author Sven Efftinge
 * @author Sebastian Zarnekow
 */
public interface IScopeProvider {

	/**
	 * Returns a scope for the given context. The scope provides access to the compatible
	 * visible EObjects for a given reference.
	 *
	 * @param context the element from which an element shall be referenced. It doesn't need to be the element
	 * 		  containing the reference, it is just used to find the most inner scope for given {@link EReference}.
	 * @param reference the reference for which to get the scope.
	 * @return {@link IScope} representing the innermost {@link IScope} for the
	 *         passed context and reference. Note for implementors: The result may not be <code>null</code>.
	 *         Return <code>IScope.NULLSCOPE</code> instead.
	 */
	IScope getScope(EObject context, EReference reference);

}

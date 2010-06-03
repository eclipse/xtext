/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

/**
 * An IScopeProvider can be used, to get access to a set of visible elements. Basically the are retrieved by type, but
 * the API allows for more sophisticated implementations as it is possible to ask for a scope for a given reference.
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
	 * @param context the element from which an element shall be referenced
	 * @param reference the reference to be used to filter the elements.
	 * @return {@link IScope} representing the inner most {@link IScope} for the
	 *         passed context and reference. Note for implementors: The result may not be <code>null</code>.
	 *         Return <code>IScope.NULLSCOPE</code> instead.
	 */
	IScope getScope(EObject context, EReference reference);

}

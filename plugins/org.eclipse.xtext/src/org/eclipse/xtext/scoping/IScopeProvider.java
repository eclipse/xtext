/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.Stable;
import org.eclipse.xtext.scoping.impl.AbstractScopeProvider;

/**
 * An IScopeProvider can be used, to get access to a set of visible elements.
 * Basically the are retrieved by type, but the API allows for more sophisticated
 * implementations as it is possible to ask for a scope for a given reference.
 *
 * @author Heiko Behrens - Initial contribution and API
 * @author Sven Efftinge
 * @author Sebastian Zarnekow
 */
@Stable(since = "0.7.0", subClass = AbstractScopeProvider.class)
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
	public IScope getScope(EObject context, EReference reference);

	/**
	 * Returns a scope for a given context. The scope contains any visible, type-compatible
	 * element.
	 * @param context the element from which an element shall be referenced
	 * @param type the (super)type of the elements.
	 * @return {@link IScope} representing the inner most {@link IScope} for the
	 *         passed context and type. Note for implementors: The result may not be <code>null</code>.
	 *         Return <code>IScope.NULLSCOPE</code> instead.
	 */
	public IScope getScope(EObject context, EClass type);
}

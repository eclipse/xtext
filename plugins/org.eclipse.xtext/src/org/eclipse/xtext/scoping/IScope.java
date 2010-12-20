/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.scoping;

import java.util.Collections;

import org.eclipse.xtext.resource.IEObjectDescription;

/**
 * A scope defines which elements {@link IEObjectDescription} can be seen in a certain area within a model/program.
 * Scopes are used to resolve cross references during linking, content assist , serialization of cross references, etc.
 * 
 * Scopes are constructed and provided by an {@link IScopeProvider}.
 * 
 * Clients pass in an {@link ISelector} to select from the elements of each scope, only those which are
 * valid/interesting depending on the actual client (i.e. linker, content assist, etc.).
 * 
 * Scopes are usually nested and descriptions ({@link IEObjectDescription}) from nested scopes can shadow descriptions
 * from outer scopes. Usually the attribute {@link IEObjectDescription#getName() name} is used for that.
 * 
 * Clients should usually inherit from {@link org.eclipse.xtext.scoping.impl.AbstractScope AbstractScope} to implement
 * own scopes. 
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
public interface IScope {

	/**
	 * An implementation might use any strategy to find a single element, if multiple elements fulfill the given
	 * selector.
	 * 
	 * @param selector the selection critiria. May not be <code>null</code>.
	 * @return the first element that matches the {@link ISelector selector}. May be <code>null</code>.
	 */
	IEObjectDescription getSingleElement(ISelector selector);

	/**
	 * @param selector the selection critiria. May not be <code>null</code>.
	 * @return all elements which match the {@link ISelector selector}. Never <code>null</code>.
	 */
	Iterable<IEObjectDescription> getElements(ISelector selector);

	/**
	 * a NO-OP implementation.
	 */
	public final static IScope NULLSCOPE = new IScope() {

		public IEObjectDescription getSingleElement(ISelector selector) {
			return null;
		}

		public Iterable<IEObjectDescription> getElements(ISelector selector) {
			return Collections.emptySet();
		}

		@Override
		public String toString() {
			return "NULLSCOPE";
		}
	};

}

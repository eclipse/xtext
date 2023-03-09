/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Used to compute fragments (i.e. resource local IDs) for EObjects and
 * locate EObjects by fragment. Typically used within a Resource.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public interface IFragmentProvider {
	/**
	 * Computes the URI fragment (local ID) of the given object. 
	 * @param obj the EObject to compute the fragment for.
	 * @param fallback if the default behavior should be used, delegate the 
	 * 		computation of the fragment to the default implementation of 
	 * 		{@link org.eclipse.emf.ecore.resource.Resource#getURIFragment(EObject)}.
	 * @return the fragment, which can be an arbitrary string but must be unique
	 *         within a resource. May not return <code>null</code>. 
	 */
	String getFragment(EObject obj, Fallback fallback);
	
	/**
	 * Locates an EObject in a resource by its fragment. 
	 * @param resource the resource serves as context instance.
	 * @param fragment the fragment of the object.
	 * @param fallback if the fragment was not created by this provider, delegate the
	 * 		resolution to the default implementation of
	 * 		{@link org.eclipse.emf.ecore.resource.Resource#getEObject(String)}.
	 * @return the resolved object or <code>null</code> if the fragment could not be resolved to an object.
	 */
	EObject getEObject(Resource resource, String fragment, Fallback fallback);
	
	/**
	 * Delegate the resolution of EObject or the computation of fragments to
	 * the default implementation by invoking the respective methods on the given
	 * instance of this fall-back delegate.
	 * Implementations will always fall-back to the default behavior of
	 * the resource implementation that uses an {@link IFragmentProvider} to 
	 * modify the semantics of {@link Resource#getURIFragment(EObject)} and
	 * {@link Resource#getEObject(String)}. 
	 * @author Sebastian Zarnekow - Initial contribution and API
	 */
	interface Fallback {
		
		/**
		 * @see IFragmentProvider#getFragment(EObject, Fallback)
		 * @return the default fragment for the given object, never <code>null</code>.
		 */
		String getFragment(EObject obj);
		
		/**
		 * @see IFragmentProvider#getEObject(Resource, String, Fallback)
		 * @return the resolved object or <code>null</code>.
		 */
		EObject getEObject(String fragment);
	}
}

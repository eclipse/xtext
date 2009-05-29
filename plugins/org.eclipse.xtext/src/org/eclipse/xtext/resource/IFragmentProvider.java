/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * Used to compute fragments (i.e. resource local IDs) for EObjects and
 * locate EObjects by fragment. 
 * Typically used within a Resource.
 * 
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow
 */
public interface IFragmentProvider {
	/**
	 * Computes the local ID of the given object. 
	 * @param obj
	 *            The EObject to compute the fragment for
	 * @return the fragment, which can be an arbitrary string but must be unique
	 *         within a resource. Return null to use default implementation
	 */
	String getFragment(EObject obj);
	
	/**
	 * Locates an EObject in a resource by its fragment. 
	 * @param resource
	 * @param fragment
	 * @return the EObject 
	 */
	EObject getEObject(Resource resource, String fragment);
}

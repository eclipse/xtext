/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * TODO: think about an efficient way to compute fragments.
 * @author Sven Efftinge - Initial contribution and API
 * @author Peter Friese
 * @author Sebastian Zarnekow
 */
public class DefaultFragmentProvider implements IFragmentProvider {
	
	@Override
	public String getFragment(EObject obj, IFragmentProvider.Fallback fallback) {
		return fallback.getFragment(obj);
	}

	@Override
	public EObject getEObject(Resource resource, String fragment, IFragmentProvider.Fallback fallback) {
		return fallback.getEObject(fragment);
	}

}

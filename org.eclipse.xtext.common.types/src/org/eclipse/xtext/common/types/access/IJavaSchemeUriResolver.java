/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.common.types.access;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

/**
 * Capable of resolving java:/Object uris.
 */
public interface IJavaSchemeUriResolver {
	
	/**
	 * tries to resolve the given proxy.
	 * @return null if the proxy doesn't use a java scheme.
	 */
	public EObject resolveJavaObjectURIProxy(InternalEObject proxy, EObject sender);
	
}

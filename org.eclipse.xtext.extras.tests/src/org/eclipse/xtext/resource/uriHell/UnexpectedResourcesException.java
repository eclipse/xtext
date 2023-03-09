/**
 * Copyright (c) 2013, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.uriHell;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UnexpectedResourcesException extends RuntimeException {
	private static final long serialVersionUID = 4735607310874010540L;

	public UnexpectedResourcesException(ResourceSet resourceSet) {
		super(toStringRepresentation(resourceSet));
	}

	private static String toStringRepresentation(ResourceSet resourceSet) {
		return ListExtensions.map(resourceSet.getResources(), (Resource it) -> it.getURI().toString()).toString();
	}
}

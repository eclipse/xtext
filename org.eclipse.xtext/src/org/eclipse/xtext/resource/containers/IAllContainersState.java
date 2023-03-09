/*******************************************************************************
 * Copyright (c) 2010, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.containers;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescriptions;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IAllContainersState {

	boolean isEmpty(String containerHandle);
	
	List<String> getVisibleContainerHandles(String handle);

	Collection<URI> getContainedURIs(String containerHandle);

	String getContainerHandle(URI uri);
	
	default boolean containsURI(String containerHandle, URI candidateURI) {
		return getContainedURIs(containerHandle).contains(candidateURI);	
	}

	interface Provider {
		IAllContainersState get(IResourceDescriptions context);
	}

}

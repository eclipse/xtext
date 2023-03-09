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

import org.eclipse.emf.common.util.URI;

class ContainerState implements IContainerState {
	private final String root;
	private final IAllContainersState globalState;

	protected ContainerState(String root, IAllContainersState globalState) {
		this.root = root;
		this.globalState = globalState;
	}

	@Override
	public Collection<URI> getContents() {
		return globalState.getContainedURIs(root);
	}

	@Override
	public boolean contains(URI uri) {
		return globalState.containsURI(root, uri);
	}
	
	@Override
	public boolean isEmpty() {
		return globalState.isEmpty(root);
	}
	
	@Override
	public String toString() {
		return "container '" + root +"' from "+globalState;
	}
}

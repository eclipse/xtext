/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.containers;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;

class ContainerState implements IContainerState {
	private final String root;
	private final IAllContainerState globalState;

	protected ContainerState(String root, IAllContainerState globalState) {
		this.root = root;
		this.globalState = globalState;
	}

	public Collection<URI> getContents() {
		return globalState.getContainedURIs(root);
	}

	public boolean contains(URI uri) {
		return getContents().contains(uri);
	}
}
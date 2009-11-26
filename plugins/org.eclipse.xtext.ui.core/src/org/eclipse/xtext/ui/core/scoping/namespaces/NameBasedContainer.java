/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.core.scoping.namespaces;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class NameBasedContainer implements IContainer {

	private final IProject project;

	public NameBasedContainer(IProject project) {
		this.project = project;
	}

	public IResourceDescription getResourceDescription(URI uri) {
		// TODO Auto-generated method stub
		return null;
	}

	public Iterable<IResourceDescription> getResourceDescriptions() {
		// TODO Auto-generated method stub
		return null;
	}

}

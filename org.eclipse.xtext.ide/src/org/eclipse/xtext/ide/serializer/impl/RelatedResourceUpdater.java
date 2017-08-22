/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.impl.RelatedResourcesProvider.RelatedResource;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class RelatedResourceUpdater extends ResourceUpdater {

	private IChangeSerializer serializer;
	private ResourceSet resourceSet;
	private RelatedResource resource;

	public IChangeSerializer getSerializer() {
		return serializer;
	}

	public RelatedResource getResource() {
		return resource;
	}

	public ResourceSet getResourceSet() {
		return resourceSet;
	}

	public void init(IChangeSerializer serializer, ResourceSet resourceSet, RelatedResource resource) {
		this.serializer = serializer;
		this.resourceSet = resourceSet;
		this.resource = resource;
	}

}

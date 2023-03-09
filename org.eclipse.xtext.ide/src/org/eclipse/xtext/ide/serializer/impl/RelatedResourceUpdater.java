/*******************************************************************************
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.serializer.impl;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.ide.serializer.IChangeSerializer;
import org.eclipse.xtext.ide.serializer.impl.RelatedResourcesProvider.RelatedResource;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 *
 * @since 2.13
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

	@Override
	public String toString() {
		return getClass().getSimpleName() + " " + resource;
	}

}

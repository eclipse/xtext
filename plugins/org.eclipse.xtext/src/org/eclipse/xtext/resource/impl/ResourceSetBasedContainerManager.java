/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class ResourceSetBasedContainerManager implements IContainer.Manager {

	@Inject
	private IResourceDescription.Manager.Registry descriptionManagerRegistry;

	public IContainer getContainer(IResourceDescription desc) {
		if (desc instanceof DefaultResourceDescription) {
			Resource resource = ((DefaultResourceDescription) desc).getResource();
			return new ResourceSetBasedContainer(resource.getResourceSet(), descriptionManagerRegistry);
		}
		throw new IllegalArgumentException("Container manager is not responsible for given description " + desc);
	}

	public List<IContainer> getVisibleContainers(IResourceDescription desc) {
		return Collections.singletonList(getContainer(desc));
	}

}

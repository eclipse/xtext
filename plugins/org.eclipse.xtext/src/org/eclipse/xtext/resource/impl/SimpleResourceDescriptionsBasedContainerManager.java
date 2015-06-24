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

import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.ProjectDescriptionBasedContainerManager;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SimpleResourceDescriptionsBasedContainerManager implements IContainer.Manager {

	@Inject
	private ProjectDescriptionBasedContainerManager delegate;
	
	@Override
	public IContainer getContainer(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		if (delegate.shouldUseProjectDescriptionBasedContainers(resourceDescriptions)) {
			return delegate.getContainer(desc, resourceDescriptions);
		}
		ResourceDescriptionsBasedContainer result = new ResourceDescriptionsBasedContainer(resourceDescriptions);
		result.setUriToDescriptionCacheEnabled(false);
		return result;
	}

	@Override
	public List<IContainer> getVisibleContainers(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		if (delegate.shouldUseProjectDescriptionBasedContainers(resourceDescriptions)) {
			return delegate.getVisibleContainers(desc, resourceDescriptions);
		}
		return Collections.singletonList(getContainer(desc, resourceDescriptions));
	}

}

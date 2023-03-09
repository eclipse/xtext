/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.resource.impl;

import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.URI;
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
		ResourceDescriptionsBasedContainer result = new ResourceDescriptionsBasedContainer(resourceDescriptions) {
			// this used to be the default implementation, which is wrong.
			// we fixed the orginal and moved the wrong impl here since old clients might see much worse performance with the new impl. 
			@Override
			public boolean hasResourceDescription(URI uri) {
				return true;
			}
		};
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

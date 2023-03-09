/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.resource.containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.LiveShadowedChunkedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ProjectDescription;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsBasedContainer;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsData;

import com.google.common.annotations.Beta;

/**
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.9
 */
@Beta
public class ProjectDescriptionBasedContainerManager implements IContainer.Manager {
	public boolean shouldUseProjectDescriptionBasedContainers(IResourceDescriptions resourceDescriptions) {
		ChunkedResourceDescriptions descriptions = getChunkedResourceDescriptions(resourceDescriptions);
		return (descriptions != null && descriptions.getResourceSet() != null
				&& ProjectDescription.findInEmfObject(descriptions.getResourceSet()) != null);
	}

	@Override
	public IContainer getContainer(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		ChunkedResourceDescriptions descriptions = getChunkedResourceDescriptions(resourceDescriptions);
		if (descriptions == null)
			throw new IllegalArgumentException("Expected " + ChunkedResourceDescriptions.class.getName());
		return createContainer(resourceDescriptions, descriptions,
				ProjectDescription.findInEmfObject(descriptions.getResourceSet()).getName());
	}

	@Override
	public List<IContainer> getVisibleContainers(IResourceDescription desc,
			IResourceDescriptions resourceDescriptions) {
		ChunkedResourceDescriptions descriptions = getChunkedResourceDescriptions(resourceDescriptions);
		if (descriptions == null)
			throw new IllegalArgumentException("Expected " + ChunkedResourceDescriptions.class.getName());
		ProjectDescription projectDescription = ProjectDescription.findInEmfObject(descriptions.getResourceSet());
		List<IContainer> allContainers = new ArrayList<>();
		allContainers.add(createContainer(resourceDescriptions, descriptions, projectDescription.getName()));
		for (String name : projectDescription.getDependencies())
			allContainers.add(createContainer(resourceDescriptions, descriptions, name));
		return allContainers;
	}

	protected ChunkedResourceDescriptions getChunkedResourceDescriptions(IResourceDescriptions resourceDescriptions) {
		if (resourceDescriptions instanceof ChunkedResourceDescriptions)
			return (ChunkedResourceDescriptions) resourceDescriptions;
		if (resourceDescriptions instanceof LiveShadowedChunkedResourceDescriptions)
			return getChunkedResourceDescriptions(
					((LiveShadowedChunkedResourceDescriptions) resourceDescriptions).getGlobalDescriptions());
		return null;
	}

	protected IContainer createContainer(IResourceDescriptions resourceDescriptions,
			ChunkedResourceDescriptions chunkedResourceDescriptions, String projectName) {
		if (resourceDescriptions instanceof LiveShadowedChunkedResourceDescriptions) {
			return new LiveShadowedChunkedContainer((LiveShadowedChunkedResourceDescriptions) resourceDescriptions,
					projectName);
		} else {
			ResourceDescriptionsData container = chunkedResourceDescriptions.getContainer(projectName);
			return new ResourceDescriptionsBasedContainer(
					container != null ? container : new ResourceDescriptionsData(Collections.emptySet()));
		}
	}
}

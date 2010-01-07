/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.containers;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescriptions;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 */
public class StateBasedContainerManager implements IContainer.Manager {

	private final static Logger log = Logger.getLogger(StateBasedContainerManager.class);
	
	@Inject
	private IAllContainersState.Provider stateProvider;

	public IContainer getContainer(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		String root = getPackageFragmentRoot(desc, resourceDescriptions);
		if (root == null) {
			log.warn("Cannot find IPackageFragmentRoot for: " + desc.getURI());
			return IContainer.Null;
		}
		return createContainer(root, resourceDescriptions);
	}

	public List<IContainer> getVisibleContainers(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		String root = getPackageFragmentRoot(desc, resourceDescriptions);
		if (root == null) {
			log.warn("Cannot find IPackageFragmentRoot for: " + desc.getURI());
			return Collections.emptyList();
		}
		List<String> handles = getState(resourceDescriptions).getVisibleContainerHandles(root);
		return getVisibleContainers(handles, resourceDescriptions);
	}

	private IAllContainersState getState(IResourceDescriptions resourceDescriptions) {
		return stateProvider.get(resourceDescriptions);
	}

	protected IContainer createContainer(final String handle, IResourceDescriptions resourceDescriptions) {
		IContainerState containerState = new ContainerState(handle, getState(resourceDescriptions));
		StateBasedContainer result = new StateBasedContainer(resourceDescriptions, containerState);
		return result;
	}

	protected List<IContainer> getVisibleContainers(List<String> handles, IResourceDescriptions resourceDescriptions) {
		List<IContainer> result = Lists.newArrayListWithExpectedSize(handles.size());
		for(String handle: handles) {
			result.add(createContainer(handle, resourceDescriptions));
		}
		return result;
	}

	protected String getPackageFragmentRoot(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		return getState(resourceDescriptions).getContainerHandle(desc.getURI());
	}

}

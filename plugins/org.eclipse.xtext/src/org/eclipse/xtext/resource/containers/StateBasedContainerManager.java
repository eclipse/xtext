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
	
	@Inject
	private ProjectDescriptionBasedContainerManager delegate;
	
	@Override
	public IContainer getContainer(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		if (delegate.shouldUseProjectDescriptionBasedContainers(resourceDescriptions)) {
			return delegate.getContainer(desc, resourceDescriptions);
		}
		String root = internalGetContainerHandle(desc, resourceDescriptions);
		if (root == null) {
			if (log.isDebugEnabled())
				log.debug("Cannot find IContainer for: " + desc.getURI());
			return IContainer.NULL_CONTAINER;
		}
		IContainer result = createContainer(root, resourceDescriptions);
		if (!result.hasResourceDescription(desc.getURI())) {
			// desc has not been saved -> merge containers
			result = new DescriptionAddingContainer(desc, result);
		}
		return result;
	}

	@Override
	public List<IContainer> getVisibleContainers(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		if (delegate.shouldUseProjectDescriptionBasedContainers(resourceDescriptions)) {
			return delegate.getVisibleContainers(desc, resourceDescriptions);
		}
		String root = internalGetContainerHandle(desc, resourceDescriptions);
		if (root == null) {
			if (log.isDebugEnabled())
				log.debug("Cannot find IContainer for: " + desc.getURI());
			return Collections.emptyList();
		}
		List<String> handles = getState(resourceDescriptions).getVisibleContainerHandles(root);
		List<IContainer> result = getVisibleContainers(handles, resourceDescriptions);
		if (!result.isEmpty()) {
			IContainer first = result.get(0);
			if (!first.hasResourceDescription(desc.getURI())) {
				first = new DescriptionAddingContainer(desc, first);
				result.set(0, first);
			}
		}
		return result;
	}

	/**
	 * @since 2.3
	 */
	protected IAllContainersState getState(IResourceDescriptions resourceDescriptions) {
		return stateProvider.get(resourceDescriptions);
	}

	protected IContainer createContainer(String handle, IResourceDescriptions resourceDescriptions) {
		IAllContainersState state = getState(resourceDescriptions);
		IContainerState containerState = new ContainerState(handle, state);
		StateBasedContainer result = new StateBasedContainer(resourceDescriptions, containerState);
		if (state instanceof FlatResourceSetBasedAllContainersState)
			result.setUriToDescriptionCacheEnabled(false);
		return result;
	}

	protected List<IContainer> getVisibleContainers(List<String> handles, IResourceDescriptions resourceDescriptions) {
		if (handles.isEmpty())
			return Collections.emptyList();
		List<IContainer> result = Lists.newArrayListWithExpectedSize(handles.size());
		for(String handle: handles) {
			IContainer container = createContainer(handle, resourceDescriptions);
			if (!container.isEmpty() || result.isEmpty())
				result.add(container);
		}
		return result;
	}

	protected String internalGetContainerHandle(IResourceDescription desc, IResourceDescriptions resourceDescriptions) {
		return getState(resourceDescriptions).getContainerHandle(desc.getURI());
	}
	
	public IAllContainersState.Provider getStateProvider() {
		return stateProvider;
	}
	
	public void setStateProvider(IAllContainersState.Provider stateProvider) {
		this.stateProvider = stateProvider;
	}
	
	/**
	 * @since 2.9
	 */
	public void setDelegate(ProjectDescriptionBasedContainerManager delegate) {
		this.delegate = delegate;
	}

}

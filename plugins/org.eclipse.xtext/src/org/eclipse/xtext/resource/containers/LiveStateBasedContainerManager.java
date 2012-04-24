/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.containers;

import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescriptions;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class LiveStateBasedContainerManager extends StateBasedContainerManager {
	@Override
	protected IContainer createContainer(String handle, IResourceDescriptions resourceDescriptions) {
		IAllContainersState state = getState(resourceDescriptions);
		IContainerState containerState = new ContainerState(handle, state);
		StateBasedContainer result = new StateBasedContainer(resourceDescriptions, containerState);
		if (state instanceof FlatResourceSetBasedAllContainersState)
			result.setUriToDescriptionCacheEnabled(false);
		return result;
	}
}

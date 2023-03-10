/*******************************************************************************
 * Copyright (c) 2010, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.containers;

import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.containers.LiveShadowedAllContainerState;
import org.eclipse.xtext.resource.impl.LiveShadowedResourceDescriptions;

import com.google.inject.Inject;

public class ContainerStateProvider implements IAllContainersState.Provider {

	@Inject
	private IAllContainersState containerState;

	@Inject
	private LiveShadowedAllContainerState.Provider liveShadowedAllContainerStateProvider;

	@Override
	public IAllContainersState get(IResourceDescriptions context) {
		if (context instanceof LiveShadowedResourceDescriptions) {
			IResourceDescriptions local = ((LiveShadowedResourceDescriptions) context).getLocalDescriptions();
			return liveShadowedAllContainerStateProvider.get(local, containerState);
		}
		return containerState;
	}

}
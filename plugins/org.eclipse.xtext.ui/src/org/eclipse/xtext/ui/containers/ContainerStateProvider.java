package org.eclipse.xtext.ui.containers;

import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.IAllContainersState;

import com.google.inject.Inject;

public class ContainerStateProvider implements IAllContainersState.Provider {

	@Inject
	private IAllContainersState containerState;

	public IAllContainersState get(IResourceDescriptions context) {
		return containerState;
	}

}
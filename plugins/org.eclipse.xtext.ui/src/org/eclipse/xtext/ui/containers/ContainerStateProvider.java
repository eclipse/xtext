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

	public IAllContainersState get(IResourceDescriptions context) {
		if (context instanceof LiveShadowedResourceDescriptions) {
			IResourceDescriptions local = ((LiveShadowedResourceDescriptions) context).getLocalDescriptions();
			return liveShadowedAllContainerStateProvider.get(local, containerState);
		}
		return containerState;
	}

}
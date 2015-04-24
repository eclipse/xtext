package org.eclipse.xtext.psi;

import com.intellij.openapi.project.Project;
import org.eclipse.xtext.resource.IResourceDescription;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("all")
public abstract class ResourceDescriptionDeltaQueue implements IResourceDescription.Event.Listener {
  public static ResourceDescriptionDeltaQueue getInstance(@NotNull final Project project) {
    return project.<ResourceDescriptionDeltaQueue>getComponent(ResourceDescriptionDeltaQueue.class);
  }
}

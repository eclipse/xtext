package org.eclipse.xtext.psi;

import com.intellij.openapi.project.Project;
import org.eclipse.xtext.resource.IResourceDescription;

@SuppressWarnings("all")
public abstract class ResourceDescriptionEventSource implements IResourceDescription.Event.Source {
  public static IResourceDescription.Event.Source getInstance(final Project project) {
    return project.<ResourceDescriptionEventSource>getComponent(ResourceDescriptionEventSource.class);
  }
}

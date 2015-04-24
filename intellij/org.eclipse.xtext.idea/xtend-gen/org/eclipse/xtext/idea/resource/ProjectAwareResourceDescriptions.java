package org.eclipse.xtext.idea.resource;

import com.google.inject.Injector;
import com.intellij.openapi.project.Project;
import org.eclipse.xtext.idea.resource.impl.ProjectScopeBasedResourceDescriptions;
import org.eclipse.xtext.idea.shared.IdeaSharedInjectorProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;

@SuppressWarnings("all")
public class ProjectAwareResourceDescriptions extends ProjectScopeBasedResourceDescriptions implements IResourceDescriptions {
  public static IResourceDescriptions getInstance(final Project project) {
    return project.<ProjectAwareResourceDescriptions>getComponent(ProjectAwareResourceDescriptions.class);
  }
  
  public ProjectAwareResourceDescriptions(final Project project) {
    Injector _injector = IdeaSharedInjectorProvider.getInjector();
    _injector.injectMembers(this);
    this.setProject(project);
  }
}

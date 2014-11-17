package org.eclipse.xtext.idea.resource;

import com.google.inject.ImplementedBy;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.idea.resource.ProjectBasedResourceSetProvider;

@ImplementedBy(ProjectBasedResourceSetProvider.class)
@SuppressWarnings("all")
public interface IResourceSetProvider {
  public abstract ResourceSet get(final Object context);
}

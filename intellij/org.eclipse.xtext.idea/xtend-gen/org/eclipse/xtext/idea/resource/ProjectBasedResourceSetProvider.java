package org.eclipse.xtext.idea.resource;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.idea.resource.IResourceSetProvider;
import org.eclipse.xtext.resource.XtextResourceSet;

@Singleton
@SuppressWarnings("all")
public class ProjectBasedResourceSetProvider implements IResourceSetProvider {
  @Inject
  private Provider<XtextResourceSet> resourceSetProvider;
  
  public ResourceSet get(final Object context) {
    throw new Error("Unresolved compilation problems:"
      + "\nProject cannot be resolved to a type."
      + "\nPsiFile cannot be resolved to a type."
      + "\nProjectAdapter cannot be resolved."
      + "\nThe method or field GlobalSearchScope is undefined for the type ProjectBasedResourceSetProvider"
      + "\nProjectAdapter cannot be resolved."
      + "\nThe method project is undefined for the type ProjectBasedResourceSetProvider"
      + "\nThe method resolveScope is undefined for the type ProjectBasedResourceSetProvider"
      + "\nallScope cannot be resolved");
  }
}

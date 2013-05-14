package org.eclipse.xtend.ide.builder;

import com.google.inject.Inject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtend.ide.builder.FilteringResourceDescriptions;
import org.eclipse.xtext.builder.clustering.CurrentDescriptions;
import org.eclipse.xtext.builder.clustering.CurrentDescriptions.ResourceSetAware;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;

@SuppressWarnings("all")
public class XtendResourceDescriptionsProvider extends ResourceDescriptionsProvider {
  @Inject
  private IJavaProjectProvider projectProvider;
  
  public IResourceDescriptions getResourceDescriptions(final ResourceSet resourceSet) {
    final IResourceDescriptions result = super.getResourceDescriptions(resourceSet);
    boolean _matched = false;
    if (!_matched) {
      if (result instanceof ResourceSetAware) {
        final ResourceSetAware _resourceSetAware = (ResourceSetAware)result;
        _matched=true;
        IResourceDescriptions _delegate = _resourceSetAware.getDelegate();
        final IResourceDescriptions d = _delegate;
        boolean _matched_1 = false;
        if (!_matched_1) {
          if (d instanceof CurrentDescriptions) {
            final CurrentDescriptions _currentDescriptions = (CurrentDescriptions)d;
            _matched_1=true;
            IJavaProject _javaProject = this.projectProvider.getJavaProject(resourceSet);
            FilteringResourceDescriptions _filteringResourceDescriptions = new FilteringResourceDescriptions(_resourceSetAware, _javaProject);
            return _filteringResourceDescriptions;
          }
        }
      }
    }
    return result;
  }
}

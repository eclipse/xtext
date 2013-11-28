package org.eclipse.xtend.ide.builder;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtend.ide.builder.FilteringResourceDescriptions;
import org.eclipse.xtext.builder.clustering.CurrentDescriptions;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

@SuppressWarnings("all")
public class XtendResourceDescriptionsProvider extends ResourceDescriptionsProvider {
  @Inject
  private IJavaProjectProvider projectProvider;
  
  @Inject
  private CompilerPhases compilerPhases;
  
  /**
   * In the builder we use the Java representation for any upstream resources, so we filter them out here.
   * And if we are in the indexing phase, we don't even want to see the local resources.
   */
  public IResourceDescriptions getResourceDescriptions(final ResourceSet resourceSet) {
    final IResourceDescriptions result = super.getResourceDescriptions(resourceSet);
    final IJavaProject project = this.projectProvider.getJavaProject(resourceSet);
    boolean _matched = false;
    if (!_matched) {
      if (result instanceof CurrentDescriptions.ResourceSetAware) {
        _matched=true;
        IResourceDescriptions _delegate = ((CurrentDescriptions.ResourceSetAware)result).getDelegate();
        final IResourceDescriptions d = _delegate;
        boolean _matched_1 = false;
        if (!_matched_1) {
          if (d instanceof CurrentDescriptions) {
            _matched_1=true;
            boolean _isIndexing = this.compilerPhases.isIndexing(resourceSet);
            if (_isIndexing) {
              IResourceDescriptions.NullImpl _nullImpl = new IResourceDescriptions.NullImpl();
              return _nullImpl;
            }
            final Function1<URI,Boolean> _function = new Function1<URI,Boolean>() {
              public Boolean apply(final URI uri) {
                boolean _or = false;
                boolean _equals = Objects.equal(uri, null);
                if (_equals) {
                  _or = true;
                } else {
                  int _segmentCount = uri.segmentCount();
                  boolean _lessThan = (_segmentCount < 2);
                  _or = (_equals || _lessThan);
                }
                if (_or) {
                  return Boolean.valueOf(false);
                }
                String _segment = uri.segment(1);
                IProject _project = project.getProject();
                String _name = _project.getName();
                return Boolean.valueOf(Objects.equal(_segment, _name));
              }
            };
            FilteringResourceDescriptions _filteringResourceDescriptions = new FilteringResourceDescriptions(result, _function);
            return _filteringResourceDescriptions;
          }
        }
      }
    }
    boolean _isIndexing = this.compilerPhases.isIndexing(resourceSet);
    if (_isIndexing) {
      final Function1<URI,Boolean> _function = new Function1<URI,Boolean>() {
        public Boolean apply(final URI uri) {
          boolean _or = false;
          boolean _equals = Objects.equal(uri, null);
          if (_equals) {
            _or = true;
          } else {
            int _segmentCount = uri.segmentCount();
            boolean _lessThan = (_segmentCount < 2);
            _or = (_equals || _lessThan);
          }
          if (_or) {
            return Boolean.valueOf(false);
          }
          String _segment = uri.segment(1);
          IProject _project = project.getProject();
          String _name = _project.getName();
          return Boolean.valueOf((!Objects.equal(_segment, _name)));
        }
      };
      FilteringResourceDescriptions _filteringResourceDescriptions = new FilteringResourceDescriptions(result, _function);
      return _filteringResourceDescriptions;
    } else {
      return result;
    }
  }
}

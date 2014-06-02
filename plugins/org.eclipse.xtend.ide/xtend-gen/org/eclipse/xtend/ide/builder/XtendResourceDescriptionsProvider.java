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
              return new IResourceDescriptions.NullImpl();
            }
            IProject _project = project.getProject();
            String _name = _project.getName();
            final String encodedProjectName = URI.encodeSegment(_name, true);
            final Function1<URI, Boolean> _function = new Function1<URI, Boolean>() {
              public Boolean apply(final URI uri) {
                boolean _or = false;
                boolean _equals = Objects.equal(uri, null);
                if (_equals) {
                  _or = true;
                } else {
                  int _segmentCount = uri.segmentCount();
                  boolean _lessThan = (_segmentCount < 2);
                  _or = _lessThan;
                }
                if (_or) {
                  return false;
                }
                String _segment = uri.segment(1);
                return Objects.equal(_segment, encodedProjectName);
              }
            };
            return new FilteringResourceDescriptions(result, _function);
          }
        }
      }
    }
    boolean _isIndexing = this.compilerPhases.isIndexing(resourceSet);
    if (_isIndexing) {
      IProject _project = project.getProject();
      String _name = _project.getName();
      final String encodedProjectName = URI.encodeSegment(_name, true);
      final Function1<URI, Boolean> _function = new Function1<URI, Boolean>() {
        public Boolean apply(final URI uri) {
          boolean _or = false;
          boolean _equals = Objects.equal(uri, null);
          if (_equals) {
            _or = true;
          } else {
            int _segmentCount = uri.segmentCount();
            boolean _lessThan = (_segmentCount < 2);
            _or = _lessThan;
          }
          if (_or) {
            return false;
          }
          String _segment = uri.segment(1);
          return (!Objects.equal(_segment, encodedProjectName));
        }
      };
      return new FilteringResourceDescriptions(result, _function);
    } else {
      return result;
    }
  }
}

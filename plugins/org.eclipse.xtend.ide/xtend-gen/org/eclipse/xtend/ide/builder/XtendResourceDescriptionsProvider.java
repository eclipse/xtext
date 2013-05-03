package org.eclipse.xtend.ide.builder;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import java.util.Collections;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.ide.builder.FilteringResourceDescriptions;
import org.eclipse.xtext.builder.clustering.CurrentDescriptions;
import org.eclipse.xtext.builder.clustering.CurrentDescriptions.ResourceSetAware;
import org.eclipse.xtext.builder.impl.BuildData;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ObjectExtensions;

@SuppressWarnings("all")
public class XtendResourceDescriptionsProvider extends ResourceDescriptionsProvider {
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
            Iterable<URI> _elvis = null;
            Iterable<URI> _elvis_1 = null;
            BuildData _buildData = _currentDescriptions.getBuildData();
            Set<URI> _toBeDeleted = _buildData.getToBeDeleted();
            if (_toBeDeleted != null) {
              _elvis_1 = _toBeDeleted;
            } else {
              BuildData _buildData_1 = _currentDescriptions.getBuildData();
              Set<URI> _toBeUpdated = _buildData_1.getToBeUpdated();
              Iterable<URI> _plus = Iterables.<URI>concat(Collections.<URI>unmodifiableList(Lists.<URI>newArrayList()), _toBeUpdated);
              _elvis_1 = ObjectExtensions.<Iterable<URI>>operator_elvis(_toBeDeleted, _plus);
            }
            if (_elvis_1 != null) {
              _elvis = _elvis_1;
            } else {
              _elvis = ObjectExtensions.<Iterable<URI>>operator_elvis(_elvis_1, Collections.<URI>unmodifiableList(Lists.<URI>newArrayList()));
            }
            Set<URI> _set = IterableExtensions.<URI>toSet(_elvis);
            FilteringResourceDescriptions _filteringResourceDescriptions = new FilteringResourceDescriptions(_resourceSetAware, _set);
            return _filteringResourceDescriptions;
          }
        }
      }
    }
    return result;
  }
}

/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.common.types.xtext.ui;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.xtext.common.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.common.types.xtext.ui.FilteringResourceDescriptions;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

/**
 * This specialization of the {@link ResourceDescriptionsProvider} filters
 * locally defined elements from the resource descriptions that are made available
 * during the indexing phase.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.8
 */
@SuppressWarnings("all")
public class ProjectAwareResourceDescriptionsProvider extends ResourceDescriptionsProvider {
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
    boolean _isIndexing = this.compilerPhases.isIndexing(resourceSet);
    if (_isIndexing) {
      final IJavaProject javaProject = this.projectProvider.getJavaProject(resourceSet);
      String _elementName = javaProject.getElementName();
      final String encodedProjectName = URI.encodeSegment(_elementName, true);
      final Function1<URI, Boolean> _function = new Function1<URI, Boolean>() {
        public Boolean apply(final URI uri) {
          boolean _or = false;
          boolean _or_1 = false;
          boolean _equals = Objects.equal(uri, null);
          if (_equals) {
            _or_1 = true;
          } else {
            int _segmentCount = uri.segmentCount();
            boolean _lessThan = (_segmentCount < 2);
            _or_1 = _lessThan;
          }
          if (_or_1) {
            _or = true;
          } else {
            boolean _isPlatformResource = uri.isPlatformResource();
            boolean _not = (!_isPlatformResource);
            _or = _not;
          }
          if (_or) {
            return Boolean.valueOf(false);
          }
          String _segment = uri.segment(1);
          return Boolean.valueOf((!Objects.equal(_segment, encodedProjectName)));
        }
      };
      return new FilteringResourceDescriptions(result, _function);
    } else {
      return result;
    }
  }
}

/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.resource;

import com.google.common.base.Objects;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @author Sven Efftinge
 */
@SuppressWarnings("all")
public class StandaloneResourceSet extends XtextResourceSet {
  private final static Logger LOG = Logger.getLogger(StandaloneResourceSet.class);
  
  public Resource getResource(final URI uri, final boolean loadOnDemand) {
    if (loadOnDemand) {
      final Resource resource = super.getResource(uri, false);
      boolean _notEquals = (!Objects.equal(resource, null));
      if (_notEquals) {
        boolean _isLoaded = resource.isLoaded();
        boolean _not = (!_isLoaded);
        if (_not) {
          this.demandLoadHelper(resource);
        }
        return resource;
      }
      final Resource resourceWithSameLastSegment = this.getResourceByLastSegment(uri);
      boolean _notEquals_1 = (!Objects.equal(resourceWithSameLastSegment, null));
      if (_notEquals_1) {
        boolean _isLoaded_1 = resourceWithSameLastSegment.isLoaded();
        boolean _not_1 = (!_isLoaded_1);
        if (_not_1) {
          this.demandLoadHelper(resourceWithSameLastSegment);
        }
        StringConcatenation _builder = new StringConcatenation();
        _builder.append("Failed to resolve a resource by URI: \'");
        _builder.append(uri, "");
        _builder.append("\'; Using similar URI instead: \'");
        URI _uRI = resourceWithSameLastSegment.getURI();
        _builder.append(_uRI, "");
        _builder.append("\'.");
        StandaloneResourceSet.LOG.warn(_builder);
        return resourceWithSameLastSegment;
      }
      return super.getResource(uri, true);
    } else {
      final Resource superResource = super.getResource(uri, false);
      boolean _notEquals_2 = (!Objects.equal(superResource, null));
      if (_notEquals_2) {
        return superResource;
      } else {
        final Resource resourceWithSameLastSegment_1 = this.getResourceByLastSegment(uri);
        boolean _notEquals_3 = (!Objects.equal(resourceWithSameLastSegment_1, null));
        if (_notEquals_3) {
          StringConcatenation _builder_1 = new StringConcatenation();
          _builder_1.append("Failed to resolve a resource by URI: \'");
          _builder_1.append(uri, "");
          _builder_1.append("\'; Using similar URI instead: \'");
          URI _uRI_1 = resourceWithSameLastSegment_1.getURI();
          _builder_1.append(_uRI_1, "");
          _builder_1.append("\'.");
          StandaloneResourceSet.LOG.warn(_builder_1);
        }
        return resourceWithSameLastSegment_1;
      }
    }
  }
  
  public Resource getResourceByLastSegment(final URI uri) {
    String _lastSegment = null;
    if (uri!=null) {
      _lastSegment=uri.lastSegment();
    }
    final String lastSegment = _lastSegment;
    boolean _equals = Objects.equal(lastSegment, null);
    if (_equals) {
      return null;
    }
    final Function1<Resource, Boolean> _function = new Function1<Resource, Boolean>() {
      public Boolean apply(final Resource it) {
        URI _uRI = it.getURI();
        String _lastSegment = null;
        if (_uRI!=null) {
          _lastSegment=_uRI.lastSegment();
        }
        return Boolean.valueOf(Objects.equal(lastSegment, _lastSegment));
      }
    };
    Iterable<Resource> _filter = IterableExtensions.<Resource>filter(this.resources, _function);
    final List<Resource> resources = IterableExtensions.<Resource>toList(_filter);
    boolean _isEmpty = resources.isEmpty();
    if (_isEmpty) {
      return null;
    }
    int _size = resources.size();
    boolean _greaterThan = (_size > 1);
    if (_greaterThan) {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("Failed to resolve a resource by the URI\'s last segment: \'");
      String _lastSegment_1 = null;
      if (uri!=null) {
        _lastSegment_1=uri.lastSegment();
      }
      _builder.append(_lastSegment_1, "");
      _builder.append("\'. Several resources are matched: ");
      {
        final Function1<Resource, URI> _function_1 = new Function1<Resource, URI>() {
          public URI apply(final Resource it) {
            return it.getURI();
          }
        };
        List<URI> _map = ListExtensions.<Resource, URI>map(resources, _function_1);
        boolean _hasElements = false;
        for(final URI resourceURI : _map) {
          if (!_hasElements) {
            _hasElements = true;
          } else {
            _builder.appendImmediate(",", "");
          }
          _builder.append("\'");
          _builder.append(resourceURI, "");
          _builder.append("\'");
        }
      }
      _builder.append(".");
      throw new IllegalArgumentException(_builder.toString());
    }
    return IterableExtensions.<Resource>head(resources);
  }
}

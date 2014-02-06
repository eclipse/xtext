/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.resource;

import com.google.common.base.Objects;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class StandaloneResourceSet extends XtextResourceSet {
  private final static Logger LOG = Logger.getLogger(StandaloneResourceSet.class);
  
  public Resource getResource(final URI uri, final boolean loadOnDemand) {
    Resource _xblockexpression = null;
    {
      final Resource superResource = super.getResource(uri, loadOnDemand);
      Resource _xifexpression = null;
      boolean _notEquals = (!Objects.equal(superResource, null));
      if (_notEquals) {
        _xifexpression = superResource;
      } else {
        Resource _xblockexpression_1 = null;
        {
          StringConcatenation _builder = new StringConcatenation();
          _builder.append("Failed to resolve a resource by URI: \'");
          _builder.append(uri, "");
          _builder.append("\'; trying to load it by the URI\'s last segment: \'");
          String _lastSegment = null;
          if (uri!=null) {
            _lastSegment=uri.lastSegment();
          }
          _builder.append(_lastSegment, "");
          _builder.append("\'.");
          StandaloneResourceSet.LOG.warn(_builder);
          _xblockexpression_1 = (this.getResourceByLastSegment(uri));
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = (_xifexpression);
    }
    return _xblockexpression;
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
    final Function1<Resource,Boolean> _function = new Function1<Resource,Boolean>() {
      public Boolean apply(final Resource it) {
        URI _uRI = it.getURI();
        String _lastSegment = null;
        if (_uRI!=null) {
          _lastSegment=_uRI.lastSegment();
        }
        return Boolean.valueOf(Objects.equal(lastSegment, _lastSegment));
      }
    };
    final Iterable<Resource> resources = IterableExtensions.<Resource>filter(this.resources, _function);
    boolean _isEmpty = IterableExtensions.isEmpty(resources);
    if (_isEmpty) {
      return null;
    }
    int _size = IterableExtensions.size(resources);
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
        final Function1<Resource,URI> _function_1 = new Function1<Resource,URI>() {
          public URI apply(final Resource it) {
            return it.getURI();
          }
        };
        Iterable<URI> _map = IterableExtensions.<Resource, URI>map(resources, _function_1);
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
      StandaloneResourceSet.LOG.error(_builder);
      return null;
    }
    return IterableExtensions.<Resource>head(resources);
  }
}

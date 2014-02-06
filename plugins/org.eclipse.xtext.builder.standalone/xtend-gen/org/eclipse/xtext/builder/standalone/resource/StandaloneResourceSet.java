/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.resource;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class StandaloneResourceSet extends XtextResourceSet {
  public Resource getResource(final URI uri, final boolean loadOnDemand) {
    Resource _xtrycatchfinallyexpression = null;
    try {
      Resource _xblockexpression = null;
      {
        final Resource superResource = super.getResource(uri, loadOnDemand);
        Resource _xifexpression = null;
        boolean _notEquals = (!Objects.equal(superResource, null));
        if (_notEquals) {
          _xifexpression = superResource;
        } else {
          _xifexpression = this.getResourceByLastSegment(uri);
        }
        _xblockexpression = (_xifexpression);
      }
      _xtrycatchfinallyexpression = _xblockexpression;
    } catch (final Throwable _t) {
      if (_t instanceof RuntimeException) {
        final RuntimeException e = (RuntimeException)_t;
        _xtrycatchfinallyexpression = this.getResourceByLastSegment(uri);
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    return _xtrycatchfinallyexpression;
  }
  
  public Resource getResourceByLastSegment(final URI uri) {
    String _lastSegment = null;
    if (uri!=null) {
      _lastSegment=uri.lastSegment();
    }
    final String lastSegment = _lastSegment;
    boolean _notEquals = (!Objects.equal(lastSegment, null));
    if (_notEquals) {
      for (final Resource resource : this.resources) {
        URI _uRI = resource.getURI();
        String _lastSegment_1 = null;
        if (_uRI!=null) {
          _lastSegment_1=_uRI.lastSegment();
        }
        boolean _equals = Objects.equal(lastSegment, _lastSegment_1);
        if (_equals) {
          return resource;
        }
      }
    }
    throw new RuntimeException((("Cannot create a resource for \'" + uri) + "\'; a registered resource factory is needed"));
  }
}

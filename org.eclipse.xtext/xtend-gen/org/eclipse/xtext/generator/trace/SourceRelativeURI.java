/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.trace;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.generator.trace.AbstractURIWrapper;

/**
 * A source relative URI.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("all")
public class SourceRelativeURI extends AbstractURIWrapper {
  public static SourceRelativeURI fromAbsolute(final URI uri) {
    boolean _isRelative = uri.isRelative();
    if (_isRelative) {
      String _string = uri.toString();
      throw new IllegalArgumentException(_string);
    }
    String _substring = uri.path().substring(1);
    return new SourceRelativeURI(_substring);
  }
  
  public SourceRelativeURI(final URI sourceRelativeURI) {
    super(sourceRelativeURI);
    if (((!sourceRelativeURI.isRelative()) || sourceRelativeURI.path().startsWith("/"))) {
      String _valueOf = String.valueOf(sourceRelativeURI);
      throw new IllegalArgumentException(_valueOf);
    }
  }
  
  public SourceRelativeURI(final String relativeURI) {
    this(URI.createURI(relativeURI));
  }
  
  @Override
  public boolean equals(final Object obj) {
    if (((obj != null) && (!Objects.equal(obj.getClass(), SourceRelativeURI.class)))) {
      String _valueOf = String.valueOf(obj);
      String _plus = (_valueOf + " instanceof ");
      Class<?> _class = null;
      if (obj!=null) {
        _class=obj.getClass();
      }
      String _name = null;
      if (_class!=null) {
        _name=_class.getName();
      }
      String _plus_1 = (_plus + _name);
      throw new IllegalArgumentException(_plus_1);
    }
    return super.equals(obj);
  }
}

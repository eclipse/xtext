/**
 * Copyright (c) 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author Christian Dietrich - Initial contribution and API
 * @since 2.14
 */
@SuppressWarnings("all")
public class UriExtensions {
  /**
   * returns a URI with empty authority, if absent and has file scheme.
   */
  public URI toUri(final String stringUri) {
    try {
      final java.net.URI netUri = new java.net.URI(stringUri);
      return this.toEmfUri(netUri);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  /**
   * returns a URI with empty authority, if absent and has file scheme.
   */
  public URI toEmfUri(final java.net.URI netUri) {
    URI _xblockexpression = null;
    {
      final String decoded = this.toDecodedString(netUri);
      final URI uri = URI.createURI(decoded);
      final URI result = this.withEmptyAuthority(uri);
      _xblockexpression = result;
    }
    return _xblockexpression;
  }
  
  public String toDecodedString(final java.net.URI uri) {
    final String scheme = uri.getScheme();
    final String part = uri.getSchemeSpecificPart();
    if ((scheme == null)) {
      return part;
    }
    return ((scheme + ":") + part);
  }
  
  /**
   * converts the file URIs with an absent authority to one with an empty
   */
  public URI withEmptyAuthority(final URI uri) {
    URI _xifexpression = null;
    if ((uri.isFile() && (uri.authority() == null))) {
      _xifexpression = URI.createHierarchicalURI(uri.scheme(), "", uri.device(), uri.segments(), uri.query(), uri.fragment());
    } else {
      _xifexpression = uri;
    }
    return _xifexpression;
  }
}

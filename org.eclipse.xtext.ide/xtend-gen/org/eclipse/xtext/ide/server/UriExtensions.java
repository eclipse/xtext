/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import com.google.inject.Singleton;
import org.eclipse.emf.common.util.URI;

/**
 * Normalizes file uris without authorities (<code>file:/path...</code>) to contain an empty authority (i.e. starts with three slashes:<code>file:///path...</code>).
 * 
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
@SuppressWarnings("all")
public class UriExtensions {
  /**
   * returns a URI with empty authority, if absent and has file scheme.
   */
  public URI toUri(final String stringUri) {
    final URI uri = URI.createURI(stringUri);
    return this.withEmptyAuthority(uri);
  }
  
  /**
   * returns the string representation of the given URI (with empty authority, if absent and has file scheme).
   */
  public String toUriString(final URI uri) {
    return this.withEmptyAuthority(uri).toString();
  }
  
  /**
   * converts a java.net.URI into a string representation with empty authority, if absent and has file scheme.
   */
  public String toUriString(final java.net.URI uri) {
    return this.toUriString(URI.createURI(uri.normalize().toString()));
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
  
  /**
   * @deprecated use #toUriString(URI)
   */
  @Deprecated
  public String toPath(final URI uri) {
    return this.toUriString(uri);
  }
  
  /**
   * @deprecated use toUriString(URI)
   */
  @Deprecated
  public String toPath(final java.net.URI uri) {
    return this.toUriString(uri);
  }
}

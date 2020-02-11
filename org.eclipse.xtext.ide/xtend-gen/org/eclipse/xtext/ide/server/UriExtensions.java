/**
 * Copyright (c) 2016, 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
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
public class UriExtensions extends org.eclipse.xtext.util.UriExtensions {
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

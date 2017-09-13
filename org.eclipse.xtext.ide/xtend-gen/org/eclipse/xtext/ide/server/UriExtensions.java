/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import com.google.inject.Singleton;
import java.util.regex.Pattern;
import org.eclipse.emf.common.util.URI;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
@SuppressWarnings("all")
public class UriExtensions {
  /**
   * Pattern for the {@code file:/} scheme.
   */
  private final static Pattern FILE_SCHEME_1_PATTERN = Pattern.compile("^file:\\/[^\\/].*");
  
  /**
   * Pattern for the {@code file://} scheme.
   */
  private final static Pattern FILE_SCHEME_2_PATTERN = Pattern.compile("^file:\\/\\/[^\\/].*");
  
  /**
   * Converts a URI (given as a string) into an EMF URI.
   * 
   * <p>
   * If the argument URI has a {@code file} scheme, it makes sure that the {@code file} scheme
   * is followed by three forward-slashes. Leaves other schemes untouched.
   */
  public URI toUri(final String pathWithScheme) {
    return URI.createURI(this.adjustURI(pathWithScheme));
  }
  
  /**
   * Converts the EMF URI argument into a string path.
   */
  public String toPath(final URI uri) {
    return this.adjustURI(uri.toString());
  }
  
  /**
   * Converts the {@code java.net} URI argument into a string path.
   */
  public String toPath(final java.net.URI uri) {
    return this.toPath(URI.createURI(uri.toString()));
  }
  
  /**
   * Ensures that the {@code file} URI scheme is followed by three (forward) slashes.
   * Returns with the argument if the URI does not start with a {@code file} scheme.
   */
  private String adjustURI(final String uri) {
    String _xifexpression = null;
    boolean _matches = UriExtensions.FILE_SCHEME_1_PATTERN.matcher(uri).matches();
    if (_matches) {
      _xifexpression = uri.replaceFirst("file:/", "file:///");
    } else {
      String _xifexpression_1 = null;
      boolean _matches_1 = UriExtensions.FILE_SCHEME_2_PATTERN.matcher(uri).matches();
      if (_matches_1) {
        _xifexpression_1 = uri.replaceFirst("file://", "file:///");
      } else {
        _xifexpression_1 = uri;
      }
      _xifexpression = _xifexpression_1;
    }
    return _xifexpression;
  }
}

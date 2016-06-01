/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import com.google.inject.Singleton;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.eclipse.emf.common.util.URI;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
@SuppressWarnings("all")
public class UriExtensions {
  public URI toUri(final String path) {
    Path _get = Paths.get(path);
    String _string = _get.toString();
    return URI.createURI(_string);
  }
  
  public String toPath(final URI uri) {
    String _string = uri.toString();
    java.net.URI _create = java.net.URI.create(_string);
    return this.toPath(_create);
  }
  
  public String toPath(final java.net.URI uri) {
    final Path path = Paths.get(uri);
    java.net.URI _uri = path.toUri();
    return _uri.toString();
  }
}

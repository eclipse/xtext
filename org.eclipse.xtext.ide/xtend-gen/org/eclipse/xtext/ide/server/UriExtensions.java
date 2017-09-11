/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import com.google.inject.Singleton;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.xbase.lib.Exceptions;

/**
 * @author kosyakov - Initial contribution and API
 * @since 2.11
 */
@Singleton
@SuppressWarnings("all")
public class UriExtensions {
  public URI toUri(final String pathWithScheme) {
    String path = URI.createURI(pathWithScheme).path();
    return URI.createURI(this.toPath(path));
  }
  
  public String toPath(final URI uri) {
    return URI.createURI(this.toPath(uri.path())).toString();
  }
  
  public String toPath(final java.net.URI uri) {
    return this.toPath(uri.getPath());
  }
  
  /**
   * We need to check if current path represents directory in file system
   * and need to add trailing slash if path represents directory.
   */
  private String toPath(final String uri) {
    try {
      try {
        final Path path = Paths.get(uri);
        return URLDecoder.decode(path.toUri().toString(), StandardCharsets.UTF_8.name());
      } catch (final Throwable _t) {
        if (_t instanceof FileSystemNotFoundException) {
          final FileSystemNotFoundException e = (FileSystemNotFoundException)_t;
          return uri;
        } else {
          throw Exceptions.sneakyThrow(_t);
        }
      }
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}

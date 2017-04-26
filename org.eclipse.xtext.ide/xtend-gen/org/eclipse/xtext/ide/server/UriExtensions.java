/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import com.google.inject.Singleton;
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
    final java.net.URI javaNetUri = java.net.URI.create(pathWithScheme);
    final String path = this.toPath(javaNetUri);
    return URI.createURI(path);
  }
  
  public String toPath(final URI uri) {
    return this.toPath(java.net.URI.create(uri.toString()));
  }
  
  public String toPath(final java.net.URI uri) {
    try {
      final Path path = Paths.get(uri);
      return path.toUri().toString();
    } catch (final Throwable _t) {
      if (_t instanceof FileSystemNotFoundException) {
        final FileSystemNotFoundException e = (FileSystemNotFoundException)_t;
        return uri.toString();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
}

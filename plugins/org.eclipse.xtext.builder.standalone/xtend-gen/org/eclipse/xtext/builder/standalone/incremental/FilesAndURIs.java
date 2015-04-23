/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.common.base.Objects;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.builder.standalone.incremental.BuildRequest;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("all")
public class FilesAndURIs {
  /**
   * Unfortunately, {@link File#toURI} does not append '/' to directiories, making it useless for the {@link URLClassLoader}.
   */
  public static URI asURI(final File file) {
    URI _xblockexpression = null;
    {
      String _absolutePath = file.getAbsolutePath();
      final URI uri = URI.createFileURI(_absolutePath);
      URI _xifexpression = null;
      boolean _isDirectory = file.isDirectory();
      if (_isDirectory) {
        _xifexpression = uri.appendSegment("");
      } else {
        _xifexpression = uri;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public static File asFile(final URI uri) {
    String _asPath = FilesAndURIs.asPath(uri);
    return new File(_asPath);
  }
  
  public static String asPath(final URI uri) {
    String _xifexpression = null;
    boolean _isFile = uri.isFile();
    if (_isFile) {
      _xifexpression = uri.toFileString();
    } else {
      throw new IllegalArgumentException((("Cannot convert non-file URI " + uri) + " to file"));
    }
    return _xifexpression;
  }
  
  public static URI asURI(final String uri) {
    return URI.createURI(uri);
  }
  
  public static URI asFileURI(final String path) {
    return URI.createFileURI(path);
  }
  
  public static String asPath(final URL url) {
    String _string = url.toString();
    URI _asURI = FilesAndURIs.asURI(_string);
    return FilesAndURIs.asPath(_asURI);
  }
  
  public static URI findSourceRootRelativeURI(final URI uri, final BuildRequest request) {
    List<URI> _sourceRoots = request.getSourceRoots();
    for (final URI sourceRootURI : _sourceRoots) {
      {
        final URI relativeURI = uri.deresolve(sourceRootURI);
        boolean _notEquals = (!Objects.equal(relativeURI, uri));
        if (_notEquals) {
          return relativeURI;
        }
      }
    }
    return null;
  }
}

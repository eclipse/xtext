/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.util;

import com.google.inject.ImplementedBy;
import com.google.inject.Inject;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.util.UriExtensions;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.11
 */
@ImplementedBy(IFileSystemScanner.JavaIoFileSystemScanner.class)
@SuppressWarnings("all")
public interface IFileSystemScanner {
  public static class JavaIoFileSystemScanner implements IFileSystemScanner {
    @Inject
    @Extension
    private UriExtensions _uriExtensions;
    
    @Override
    public void scan(final URI root, final IAcceptor<URI> acceptor) {
      String _fileString = root.toFileString();
      final File file = new File(_fileString);
      this.scanRec(file, acceptor);
    }
    
    public void scanRec(final File file, final IAcceptor<URI> acceptor) {
      final Path path = Paths.get(file.getAbsoluteFile().toURI());
      final URI uri = this._uriExtensions.toUri(path.toUri().toString());
      acceptor.accept(uri);
      boolean _isDirectory = file.isDirectory();
      if (_isDirectory) {
        final File[] files = file.listFiles();
        if ((files != null)) {
          for (final File f : files) {
            this.scanRec(f, acceptor);
          }
        }
      }
    }
  }
  
  public abstract void scan(final URI root, final IAcceptor<URI> acceptor);
}

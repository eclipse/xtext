/**
 * Copyright (c) 2014, 2018 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro;

import java.io.InputStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.generator.FileSystemAccessQueue;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @author Arne Deutsch - Add wait to read operations
 */
@SuppressWarnings("all")
public class ParallelFileSystemSupport implements MutableFileSystemSupport {
  private final URI uri;

  private final MutableFileSystemSupport delegate;

  @Extension
  private final FileSystemAccessQueue queue;

  public ParallelFileSystemSupport(final URI uri, final MutableFileSystemSupport delegate, final FileSystemAccessQueue queue) {
    this.uri = uri;
    this.delegate = delegate;
    this.queue = queue;
  }

  @Override
  public void delete(final Path path) {
    final Runnable _function = () -> {
      this.delegate.delete(path);
    };
    this.queue.sendAsync(this.uri, _function);
  }

  @Deprecated
  @Override
  public void mkdir(final Path path) {
    final Runnable _function = () -> {
      this.delegate.mkdir(path);
    };
    this.queue.sendAsync(this.uri, _function);
  }

  @Override
  public void setContents(final Path path, final CharSequence contents) {
    final Runnable _function = () -> {
      this.delegate.setContents(path, contents);
    };
    this.queue.sendAsync(this.uri, _function);
  }

  @Override
  public void setContentsAsStream(final Path path, final InputStream source) {
    final Runnable _function = () -> {
      this.delegate.setContentsAsStream(path, source);
    };
    this.queue.sendAsync(this.uri, _function);
  }

  @Override
  public boolean exists(final Path path) {
    boolean _xblockexpression = false;
    {
      this.queue.waitForEmptyQueue();
      _xblockexpression = this.delegate.exists(path);
    }
    return _xblockexpression;
  }

  @Override
  public String getCharset(final Path path) {
    String _xblockexpression = null;
    {
      this.queue.waitForEmptyQueue();
      _xblockexpression = this.delegate.getCharset(path);
    }
    return _xblockexpression;
  }

  @Override
  public Iterable<? extends Path> getChildren(final Path path) {
    Iterable<? extends Path> _xblockexpression = null;
    {
      this.queue.waitForEmptyQueue();
      _xblockexpression = this.delegate.getChildren(path);
    }
    return _xblockexpression;
  }

  @Override
  public CharSequence getContents(final Path path) {
    CharSequence _xblockexpression = null;
    {
      this.queue.waitForEmptyQueue();
      _xblockexpression = this.delegate.getContents(path);
    }
    return _xblockexpression;
  }

  @Override
  public InputStream getContentsAsStream(final Path path) {
    InputStream _xblockexpression = null;
    {
      this.queue.waitForEmptyQueue();
      _xblockexpression = this.delegate.getContentsAsStream(path);
    }
    return _xblockexpression;
  }

  @Override
  public long getLastModification(final Path path) {
    long _xblockexpression = (long) 0;
    {
      this.queue.waitForEmptyQueue();
      _xblockexpression = this.delegate.getLastModification(path);
    }
    return _xblockexpression;
  }

  @Override
  public boolean isFile(final Path path) {
    boolean _xblockexpression = false;
    {
      this.queue.waitForEmptyQueue();
      _xblockexpression = this.delegate.isFile(path);
    }
    return _xblockexpression;
  }

  @Override
  public boolean isFolder(final Path path) {
    boolean _xblockexpression = false;
    {
      this.queue.waitForEmptyQueue();
      _xblockexpression = this.delegate.isFolder(path);
    }
    return _xblockexpression;
  }

  @Override
  public java.net.URI toURI(final Path path) {
    java.net.URI _xblockexpression = null;
    {
      this.queue.waitForEmptyQueue();
      _xblockexpression = this.delegate.toURI(path);
    }
    return _xblockexpression;
  }
}

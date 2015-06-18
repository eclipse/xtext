/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
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
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        ParallelFileSystemSupport.this.delegate.delete(path);
      }
    };
    this.queue.sendAsync(this.uri, _function);
  }
  
  @Override
  public void mkdir(final Path path) {
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        ParallelFileSystemSupport.this.delegate.mkdir(path);
      }
    };
    this.queue.sendAsync(this.uri, _function);
  }
  
  @Override
  public void setContents(final Path path, final CharSequence contents) {
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        ParallelFileSystemSupport.this.delegate.setContents(path, contents);
      }
    };
    this.queue.sendAsync(this.uri, _function);
  }
  
  @Override
  public void setContentsAsStream(final Path path, final InputStream source) {
    final Runnable _function = new Runnable() {
      @Override
      public void run() {
        ParallelFileSystemSupport.this.delegate.setContentsAsStream(path, source);
      }
    };
    this.queue.sendAsync(this.uri, _function);
  }
  
  @Override
  public boolean exists(final Path path) {
    return this.delegate.exists(path);
  }
  
  @Override
  public String getCharset(final Path path) {
    return this.delegate.getCharset(path);
  }
  
  @Override
  public Iterable<? extends Path> getChildren(final Path path) {
    return this.delegate.getChildren(path);
  }
  
  @Override
  public CharSequence getContents(final Path path) {
    return this.delegate.getContents(path);
  }
  
  @Override
  public InputStream getContentsAsStream(final Path path) {
    return this.delegate.getContentsAsStream(path);
  }
  
  @Override
  public long getLastModification(final Path path) {
    return this.delegate.getLastModification(path);
  }
  
  @Override
  public boolean isFile(final Path path) {
    return this.delegate.isFile(path);
  }
  
  @Override
  public boolean isFolder(final Path path) {
    return this.delegate.isFolder(path);
  }
  
  @Override
  public java.net.URI toURI(final Path path) {
    return this.delegate.toURI(path);
  }
}

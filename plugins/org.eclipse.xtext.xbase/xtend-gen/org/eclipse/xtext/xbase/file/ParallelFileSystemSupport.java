/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.file;

import java.io.InputStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.generator.FileSystemAccessQueue;
import org.eclipse.xtext.xbase.file.AbstractFileSystemSupport;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure0;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class ParallelFileSystemSupport implements MutableFileSystemSupport {
  private URI uri;
  
  private AbstractFileSystemSupport delegate;
  
  @Extension
  private FileSystemAccessQueue queue;
  
  public ParallelFileSystemSupport(final URI uri, final AbstractFileSystemSupport delegate, final FileSystemAccessQueue queue) {
    this.uri = uri;
    this.delegate = delegate;
    this.queue = queue;
  }
  
  public void delete(final Path path) {
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        ParallelFileSystemSupport.this.delegate.delete(path);
      }
    };
    this.queue.sendAsync(this.uri, _function);
  }
  
  public void mkdir(final Path path) {
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        ParallelFileSystemSupport.this.delegate.mkdir(path);
      }
    };
    this.queue.sendAsync(this.uri, _function);
  }
  
  public void setContents(final Path path, final CharSequence contents) {
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        ParallelFileSystemSupport.this.delegate.setContents(path, contents);
      }
    };
    this.queue.sendAsync(this.uri, _function);
  }
  
  public void setContentsAsStream(final Path path, final InputStream source) {
    final Procedure0 _function = new Procedure0() {
      public void apply() {
        ParallelFileSystemSupport.this.delegate.setContentsAsStream(path, source);
      }
    };
    this.queue.sendAsync(this.uri, _function);
  }
  
  public boolean exists(final Path path) {
    return this.delegate.exists(path);
  }
  
  public String getCharset(final Path path) {
    return this.delegate.getCharset(path);
  }
  
  public Iterable<? extends Path> getChildren(final Path path) {
    return this.delegate.getChildren(path);
  }
  
  public CharSequence getContents(final Path path) {
    return this.delegate.getContents(path);
  }
  
  public InputStream getContentsAsStream(final Path path) {
    return this.delegate.getContentsAsStream(path);
  }
  
  public long getLastModification(final Path path) {
    return this.delegate.getLastModification(path);
  }
  
  public boolean isFile(final Path path) {
    return this.delegate.isFile(path);
  }
  
  public boolean isFolder(final Path path) {
    return this.delegate.isFolder(path);
  }
  
  public java.net.URI toURI(final Path path) {
    return this.delegate.toURI(path);
  }
}

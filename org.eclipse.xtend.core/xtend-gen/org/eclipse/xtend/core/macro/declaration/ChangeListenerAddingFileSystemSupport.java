/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtend.core.macro.declaration;

import java.io.InputStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class ChangeListenerAddingFileSystemSupport implements MutableFileSystemSupport {
  private final URI resourceURI;

  private final MutableFileSystemSupport delegate;

  private final IResourceChangeRegistry resourceChangeRegistry;

  @Override
  public void delete(final Path path) {
    this.resourceChangeRegistry.registerCreateOrModify(path.toString(), this.getURI());
    this.delegate.delete(path);
  }

  @Deprecated
  @Override
  public void mkdir(final Path path) {
    this.resourceChangeRegistry.registerCreateOrModify(path.toString(), this.getURI());
    this.delegate.mkdir(path);
  }

  @Override
  public void setContents(final Path path, final CharSequence contents) {
    this.resourceChangeRegistry.registerCreateOrModify(path.toString(), this.getURI());
    this.delegate.setContents(path, contents);
  }

  @Override
  public void setContentsAsStream(final Path path, final InputStream source) {
    this.resourceChangeRegistry.registerCreateOrModify(path.toString(), this.getURI());
    this.delegate.setContentsAsStream(path, source);
  }

  @Override
  public boolean exists(final Path path) {
    this.resourceChangeRegistry.registerExists(path.toString(), this.getURI());
    return this.delegate.exists(path);
  }

  private URI getURI() {
    return this.resourceURI;
  }

  @Override
  public String getCharset(final Path path) {
    this.resourceChangeRegistry.registerGetCharset(path.toString(), this.getURI());
    return this.delegate.getCharset(path);
  }

  @Override
  public Iterable<? extends Path> getChildren(final Path path) {
    this.resourceChangeRegistry.registerGetChildren(path.toString(), this.getURI());
    return this.delegate.getChildren(path);
  }

  @Override
  public CharSequence getContents(final Path path) {
    this.resourceChangeRegistry.registerGetContents(path.toString(), this.getURI());
    return this.delegate.getContents(path);
  }

  @Override
  public InputStream getContentsAsStream(final Path path) {
    this.resourceChangeRegistry.registerGetContents(path.toString(), this.getURI());
    return this.delegate.getContentsAsStream(path);
  }

  @Override
  public long getLastModification(final Path path) {
    this.resourceChangeRegistry.registerGetContents(path.toString(), this.getURI());
    return this.delegate.getLastModification(path);
  }

  @Override
  public boolean isFile(final Path path) {
    this.resourceChangeRegistry.registerExists(path.toString(), this.getURI());
    return this.delegate.isFile(path);
  }

  @Override
  public boolean isFolder(final Path path) {
    this.resourceChangeRegistry.registerExists(path.toString(), this.getURI());
    return this.delegate.isFolder(path);
  }

  @Override
  public java.net.URI toURI(final Path path) {
    return this.delegate.toURI(path);
  }

  public ChangeListenerAddingFileSystemSupport(final URI resourceURI, final MutableFileSystemSupport delegate, final IResourceChangeRegistry resourceChangeRegistry) {
    super();
    this.resourceURI = resourceURI;
    this.delegate = delegate;
    this.resourceChangeRegistry = resourceChangeRegistry;
  }

  @Pure
  public URI getResourceURI() {
    return this.resourceURI;
  }

  @Pure
  public MutableFileSystemSupport getDelegate() {
    return this.delegate;
  }

  @Pure
  public IResourceChangeRegistry getResourceChangeRegistry() {
    return this.resourceChangeRegistry;
  }
}

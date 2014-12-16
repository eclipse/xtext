/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro.declaration;

import java.io.InputStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.core.macro.declaration.IResourceChangeRegistry;
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
  
  public void delete(final Path path) {
    String _string = path.toString();
    URI _uRI = this.getURI();
    this.resourceChangeRegistry.registerCreateOrModify(_string, _uRI);
    this.delegate.delete(path);
  }
  
  public void mkdir(final Path path) {
    String _string = path.toString();
    URI _uRI = this.getURI();
    this.resourceChangeRegistry.registerCreateOrModify(_string, _uRI);
    this.delegate.mkdir(path);
  }
  
  public void setContents(final Path path, final CharSequence contents) {
    String _string = path.toString();
    URI _uRI = this.getURI();
    this.resourceChangeRegistry.registerCreateOrModify(_string, _uRI);
    this.delegate.setContents(path, contents);
  }
  
  public void setContentsAsStream(final Path path, final InputStream source) {
    String _string = path.toString();
    URI _uRI = this.getURI();
    this.resourceChangeRegistry.registerCreateOrModify(_string, _uRI);
    this.delegate.setContentsAsStream(path, source);
  }
  
  public boolean exists(final Path path) {
    String _string = path.toString();
    URI _uRI = this.getURI();
    this.resourceChangeRegistry.registerExists(_string, _uRI);
    return this.delegate.exists(path);
  }
  
  private URI getURI() {
    return this.resourceURI;
  }
  
  public String getCharset(final Path path) {
    String _string = path.toString();
    URI _uRI = this.getURI();
    this.resourceChangeRegistry.registerGetCharset(_string, _uRI);
    return this.delegate.getCharset(path);
  }
  
  public Iterable<? extends Path> getChildren(final Path path) {
    String _string = path.toString();
    URI _uRI = this.getURI();
    this.resourceChangeRegistry.registerGetChildren(_string, _uRI);
    return this.delegate.getChildren(path);
  }
  
  public CharSequence getContents(final Path path) {
    String _string = path.toString();
    URI _uRI = this.getURI();
    this.resourceChangeRegistry.registerGetContents(_string, _uRI);
    return this.delegate.getContents(path);
  }
  
  public InputStream getContentsAsStream(final Path path) {
    String _string = path.toString();
    URI _uRI = this.getURI();
    this.resourceChangeRegistry.registerGetContents(_string, _uRI);
    return this.delegate.getContentsAsStream(path);
  }
  
  public long getLastModification(final Path path) {
    String _string = path.toString();
    URI _uRI = this.getURI();
    this.resourceChangeRegistry.registerGetContents(_string, _uRI);
    return this.delegate.getLastModification(path);
  }
  
  public boolean isFile(final Path path) {
    String _string = path.toString();
    URI _uRI = this.getURI();
    this.resourceChangeRegistry.registerExists(_string, _uRI);
    return this.delegate.isFile(path);
  }
  
  public boolean isFolder(final Path path) {
    String _string = path.toString();
    URI _uRI = this.getURI();
    this.resourceChangeRegistry.registerExists(_string, _uRI);
    return this.delegate.isFolder(path);
  }
  
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

/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.macro;

import java.io.InputStream;
import java.net.URI;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Delegate;
import org.eclipse.xtend.lib.macro.CodeGenerationContext;
import org.eclipse.xtend.lib.macro.file.FileLocations;
import org.eclipse.xtend.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class CodeGenerationContextImpl implements CodeGenerationContext {
  @Accessors
  @Delegate
  private MutableFileSystemSupport fileSystemSupport;
  
  @Accessors
  @Delegate
  private FileLocations fileLocations;
  
  @Pure
  public MutableFileSystemSupport getFileSystemSupport() {
    return this.fileSystemSupport;
  }
  
  public void setFileSystemSupport(final MutableFileSystemSupport fileSystemSupport) {
    this.fileSystemSupport = fileSystemSupport;
  }
  
  @Pure
  public FileLocations getFileLocations() {
    return this.fileLocations;
  }
  
  public void setFileLocations(final FileLocations fileLocations) {
    this.fileLocations = fileLocations;
  }
  
  public void delete(final Path path) {
    this.fileSystemSupport.delete(path);
  }
  
  public void mkdir(final Path path) {
    this.fileSystemSupport.mkdir(path);
  }
  
  public void setContents(final Path path, final CharSequence contents) {
    this.fileSystemSupport.setContents(path, contents);
  }
  
  public void setContentsAsStream(final Path path, final InputStream source) {
    this.fileSystemSupport.setContentsAsStream(path, source);
  }
  
  public boolean exists(final Path path) {
    return this.fileSystemSupport.exists(path);
  }
  
  public String getCharset(final Path path) {
    return this.fileSystemSupport.getCharset(path);
  }
  
  public Iterable<? extends Path> getChildren(final Path path) {
    return this.fileSystemSupport.getChildren(path);
  }
  
  public CharSequence getContents(final Path path) {
    return this.fileSystemSupport.getContents(path);
  }
  
  public InputStream getContentsAsStream(final Path path) {
    return this.fileSystemSupport.getContentsAsStream(path);
  }
  
  public long getLastModification(final Path path) {
    return this.fileSystemSupport.getLastModification(path);
  }
  
  public boolean isFile(final Path path) {
    return this.fileSystemSupport.isFile(path);
  }
  
  public boolean isFolder(final Path path) {
    return this.fileSystemSupport.isFolder(path);
  }
  
  public URI toURI(final Path path) {
    return this.fileSystemSupport.toURI(path);
  }
  
  public Path getProjectFolder(final Path path) {
    return this.fileLocations.getProjectFolder(path);
  }
  
  public Path getSourceFolder(final Path path) {
    return this.fileLocations.getSourceFolder(path);
  }
  
  public Path getTargetFolder(final Path sourceFolder) {
    return this.fileLocations.getTargetFolder(sourceFolder);
  }
}

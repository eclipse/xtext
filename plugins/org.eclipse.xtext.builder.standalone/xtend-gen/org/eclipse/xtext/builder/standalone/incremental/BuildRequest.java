/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

import com.google.common.io.Files;
import java.io.File;
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 */
@Accessors
@SuppressWarnings("all")
public class BuildRequest {
  private File baseDir;
  
  private File tempDir = Files.createTempDir();
  
  private List<File> classPath = CollectionLiterals.<File>newArrayList();
  
  private List<File> sourceRoots = CollectionLiterals.<File>newArrayList();
  
  private List<URI> dirtyFiles = CollectionLiterals.<URI>newArrayList();
  
  private List<URI> deletedFiles = CollectionLiterals.<URI>newArrayList();
  
  private String defaultEncoding;
  
  private boolean isFullBuild = false;
  
  private boolean failOnValidationError = true;
  
  private boolean debugLog = false;
  
  private boolean writeStorageResources = false;
  
  @Pure
  public File getBaseDir() {
    return this.baseDir;
  }
  
  public void setBaseDir(final File baseDir) {
    this.baseDir = baseDir;
  }
  
  @Pure
  public File getTempDir() {
    return this.tempDir;
  }
  
  public void setTempDir(final File tempDir) {
    this.tempDir = tempDir;
  }
  
  @Pure
  public List<File> getClassPath() {
    return this.classPath;
  }
  
  public void setClassPath(final List<File> classPath) {
    this.classPath = classPath;
  }
  
  @Pure
  public List<File> getSourceRoots() {
    return this.sourceRoots;
  }
  
  public void setSourceRoots(final List<File> sourceRoots) {
    this.sourceRoots = sourceRoots;
  }
  
  @Pure
  public List<URI> getDirtyFiles() {
    return this.dirtyFiles;
  }
  
  public void setDirtyFiles(final List<URI> dirtyFiles) {
    this.dirtyFiles = dirtyFiles;
  }
  
  @Pure
  public List<URI> getDeletedFiles() {
    return this.deletedFiles;
  }
  
  public void setDeletedFiles(final List<URI> deletedFiles) {
    this.deletedFiles = deletedFiles;
  }
  
  @Pure
  public String getDefaultEncoding() {
    return this.defaultEncoding;
  }
  
  public void setDefaultEncoding(final String defaultEncoding) {
    this.defaultEncoding = defaultEncoding;
  }
  
  @Pure
  public boolean isFullBuild() {
    return this.isFullBuild;
  }
  
  public void setIsFullBuild(final boolean isFullBuild) {
    this.isFullBuild = isFullBuild;
  }
  
  @Pure
  public boolean isFailOnValidationError() {
    return this.failOnValidationError;
  }
  
  public void setFailOnValidationError(final boolean failOnValidationError) {
    this.failOnValidationError = failOnValidationError;
  }
  
  @Pure
  public boolean isDebugLog() {
    return this.debugLog;
  }
  
  public void setDebugLog(final boolean debugLog) {
    this.debugLog = debugLog;
  }
  
  @Pure
  public boolean isWriteStorageResources() {
    return this.writeStorageResources;
  }
  
  public void setWriteStorageResources(final boolean writeStorageResources) {
    this.writeStorageResources = writeStorageResources;
  }
}

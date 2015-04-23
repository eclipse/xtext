/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.builder.standalone.incremental;

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
  private URI baseDir;
  
  private List<URI> classPath = CollectionLiterals.<URI>newArrayList();
  
  private List<URI> sourceRoots = CollectionLiterals.<URI>newArrayList();
  
  private List<URI> outputs = CollectionLiterals.<URI>newArrayList();
  
  private List<URI> dirtyFiles = CollectionLiterals.<URI>newArrayList();
  
  private List<URI> deletedFiles = CollectionLiterals.<URI>newArrayList();
  
  private String defaultEncoding;
  
  private boolean isFullBuild = false;
  
  private boolean failOnValidationError = true;
  
  private boolean debugLog = false;
  
  private boolean writeStorageResources = false;
  
  @Pure
  public URI getBaseDir() {
    return this.baseDir;
  }
  
  public void setBaseDir(final URI baseDir) {
    this.baseDir = baseDir;
  }
  
  @Pure
  public List<URI> getClassPath() {
    return this.classPath;
  }
  
  public void setClassPath(final List<URI> classPath) {
    this.classPath = classPath;
  }
  
  @Pure
  public List<URI> getSourceRoots() {
    return this.sourceRoots;
  }
  
  public void setSourceRoots(final List<URI> sourceRoots) {
    this.sourceRoots = sourceRoots;
  }
  
  @Pure
  public List<URI> getOutputs() {
    return this.outputs;
  }
  
  public void setOutputs(final List<URI> outputs) {
    this.outputs = outputs;
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

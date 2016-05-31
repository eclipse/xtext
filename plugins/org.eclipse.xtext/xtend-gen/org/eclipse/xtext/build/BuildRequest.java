/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.build;

import com.google.common.base.Objects;
import java.io.File;
import java.util.List;
import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.build.IndexState;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.UriUtil;
import org.eclipse.xtext.util.internal.Log;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure1;
import org.eclipse.xtext.xbase.lib.Procedures.Procedure2;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.9
 */
@Accessors
@SuppressWarnings("all")
public class BuildRequest {
  public interface IPostValidationCallback {
    /**
     * @return whether the build can proceed, <code>false</code> if the build should be interrupted
     */
    public abstract boolean afterValidate(final URI validated, final Iterable<Issue> issues);
  }
  
  @Log
  private static class DefaultValidationCallback implements BuildRequest.IPostValidationCallback {
    @Override
    public boolean afterValidate(final URI validated, final Iterable<Issue> issues) {
      boolean errorFree = true;
      for (final Issue issue : issues) {
        Severity _severity = issue.getSeverity();
        if (_severity != null) {
          switch (_severity) {
            case ERROR:
              String _string = issue.toString();
              BuildRequest.DefaultValidationCallback.LOG.error(_string);
              errorFree = false;
              break;
            case WARNING:
              String _string_1 = issue.toString();
              BuildRequest.DefaultValidationCallback.LOG.warn(_string_1);
              break;
            case INFO:
              String _string_2 = issue.toString();
              BuildRequest.DefaultValidationCallback.LOG.info(_string_2);
              break;
            case IGNORE:
              String _string_3 = issue.toString();
              BuildRequest.DefaultValidationCallback.LOG.debug(_string_3);
              break;
            default:
              break;
          }
        }
      }
      return errorFree;
    }
    
    private final static Logger LOG = Logger.getLogger(DefaultValidationCallback.class);
  }
  
  private URI baseDir;
  
  public URI getBaseDir() {
    boolean _equals = Objects.equal(this.baseDir, null);
    if (_equals) {
      final String userDir = System.getProperty("user.dir");
      File _file = new File(userDir);
      URI _createFolderURI = UriUtil.createFolderURI(_file);
      this.baseDir = _createFolderURI;
    }
    return this.baseDir;
  }
  
  private List<URI> dirtyFiles = CollectionLiterals.<URI>newArrayList();
  
  private List<URI> deletedFiles = CollectionLiterals.<URI>newArrayList();
  
  private List<IResourceDescription.Delta> externalDeltas = CollectionLiterals.<IResourceDescription.Delta>newArrayList();
  
  /**
   * call back after validation, return <code>false</code> will stop the build.
   */
  private BuildRequest.IPostValidationCallback afterValidate = new BuildRequest.DefaultValidationCallback();
  
  private Procedure2<? super URI, ? super URI> afterGenerateFile = new Procedure2<URI, URI>() {
    @Override
    public void apply(final URI $0, final URI $1) {
    }
  };
  
  private Procedure1<? super URI> afterDeleteFile = new Procedure1<URI>() {
    @Override
    public void apply(final URI it) {
    }
  };
  
  private IndexState state = new IndexState();
  
  private boolean writeStorageResources = false;
  
  private boolean indexOnly = false;
  
  private XtextResourceSet resourceSet;
  
  private CancelIndicator cancelIndicator = CancelIndicator.NullImpl;
  
  public void setBaseDir(final URI baseDir) {
    this.baseDir = baseDir;
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
  public List<IResourceDescription.Delta> getExternalDeltas() {
    return this.externalDeltas;
  }
  
  public void setExternalDeltas(final List<IResourceDescription.Delta> externalDeltas) {
    this.externalDeltas = externalDeltas;
  }
  
  @Pure
  public BuildRequest.IPostValidationCallback getAfterValidate() {
    return this.afterValidate;
  }
  
  public void setAfterValidate(final BuildRequest.IPostValidationCallback afterValidate) {
    this.afterValidate = afterValidate;
  }
  
  @Pure
  public Procedure2<? super URI, ? super URI> getAfterGenerateFile() {
    return this.afterGenerateFile;
  }
  
  public void setAfterGenerateFile(final Procedure2<? super URI, ? super URI> afterGenerateFile) {
    this.afterGenerateFile = afterGenerateFile;
  }
  
  @Pure
  public Procedure1<? super URI> getAfterDeleteFile() {
    return this.afterDeleteFile;
  }
  
  public void setAfterDeleteFile(final Procedure1<? super URI> afterDeleteFile) {
    this.afterDeleteFile = afterDeleteFile;
  }
  
  @Pure
  public IndexState getState() {
    return this.state;
  }
  
  public void setState(final IndexState state) {
    this.state = state;
  }
  
  @Pure
  public boolean isWriteStorageResources() {
    return this.writeStorageResources;
  }
  
  public void setWriteStorageResources(final boolean writeStorageResources) {
    this.writeStorageResources = writeStorageResources;
  }
  
  @Pure
  public boolean isIndexOnly() {
    return this.indexOnly;
  }
  
  public void setIndexOnly(final boolean indexOnly) {
    this.indexOnly = indexOnly;
  }
  
  @Pure
  public XtextResourceSet getResourceSet() {
    return this.resourceSet;
  }
  
  public void setResourceSet(final XtextResourceSet resourceSet) {
    this.resourceSet = resourceSet;
  }
  
  @Pure
  public CancelIndicator getCancelIndicator() {
    return this.cancelIndicator;
  }
  
  public void setCancelIndicator(final CancelIndicator cancelIndicator) {
    this.cancelIndicator = cancelIndicator;
  }
}

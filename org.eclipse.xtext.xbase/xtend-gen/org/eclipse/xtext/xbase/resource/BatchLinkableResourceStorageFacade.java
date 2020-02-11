/**
 * Copyright (c) 2014, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.resource;

import com.google.inject.Inject;
import java.io.InputStream;
import java.io.OutputStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.persistence.ResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.ResourceStorageLoadable;
import org.eclipse.xtext.resource.persistence.ResourceStorageWritable;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IProjectConfigProvider;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.xbase.resource.BatchLinkableResourceStorageLoadable;
import org.eclipse.xtext.xbase.resource.BatchLinkableResourceStorageWritable;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class BatchLinkableResourceStorageFacade extends ResourceStorageFacade {
  @Inject
  private IProjectConfigProvider projectConfigProvider;
  
  @Override
  public ResourceStorageLoadable createResourceStorageLoadable(final InputStream in) {
    boolean _isStoreNodeModel = this.isStoreNodeModel();
    return new BatchLinkableResourceStorageLoadable(in, _isStoreNodeModel);
  }
  
  @Override
  public ResourceStorageWritable createResourceStorageWritable(final OutputStream out) {
    boolean _isStoreNodeModel = this.isStoreNodeModel();
    return new BatchLinkableResourceStorageWritable(out, _isStoreNodeModel);
  }
  
  @Override
  protected URI getSourceContainerURI(final StorageAwareResource resource) {
    final URI uri = resource.getURI();
    final IProjectConfig mainProject = this.projectConfigProvider.getProjectConfig(resource.getResourceSet());
    if ((mainProject != null)) {
      final IProjectConfig project = mainProject.getWorkspaceConfig().findProjectContaining(uri);
      ISourceFolder _findSourceFolderContaining = null;
      if (project!=null) {
        _findSourceFolderContaining=project.findSourceFolderContaining(uri);
      }
      final ISourceFolder sourceFolder = _findSourceFolderContaining;
      if ((sourceFolder != null)) {
        return sourceFolder.getPath();
      }
    }
    return super.getSourceContainerURI(resource);
  }
}

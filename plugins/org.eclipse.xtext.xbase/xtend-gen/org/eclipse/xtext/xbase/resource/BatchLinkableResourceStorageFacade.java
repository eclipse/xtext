/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.resource;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import java.io.InputStream;
import java.io.OutputStream;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.URIConverter;
import org.eclipse.xtext.resource.persistence.ResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.ResourceStorageLoadable;
import org.eclipse.xtext.resource.persistence.ResourceStorageWritable;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfigProvider;
import org.eclipse.xtext.xbase.resource.BatchLinkableResourceStorageLoadable;
import org.eclipse.xtext.xbase.resource.BatchLinkableResourceStorageWritable;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class BatchLinkableResourceStorageFacade extends ResourceStorageFacade {
  @Inject
  private IWorkspaceConfigProvider workspaceConfigProvider;
  
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
    final IWorkspaceConfig workspaceConfig = this.workspaceConfigProvider.getWorkspaceConfig(resource);
    final URI uri = resource.getURI();
    ResourceSet _resourceSet = resource.getResourceSet();
    URIConverter _uRIConverter = _resourceSet.getURIConverter();
    final URI normalizedUri = _uRIConverter.normalize(uri);
    final IProjectConfig project = workspaceConfig.findProjectContaining(normalizedUri);
    ISourceFolder _findSourceFolderContaing = null;
    if (project!=null) {
      _findSourceFolderContaing=project.findSourceFolderContaing(normalizedUri);
    }
    final ISourceFolder sourceFolder = _findSourceFolderContaing;
    boolean _notEquals = (!Objects.equal(sourceFolder, null));
    if (_notEquals) {
      URI _path = sourceFolder.getPath();
      final URI sourceRelativeUri = normalizedUri.deresolve(_path);
      int _segmentCount = sourceRelativeUri.segmentCount();
      int _minus = (_segmentCount - 1);
      URI _trimSegments = uri.trimSegments(_minus);
      return _trimSegments.appendSegment("");
    }
    return super.getSourceContainerURI(resource);
  }
}

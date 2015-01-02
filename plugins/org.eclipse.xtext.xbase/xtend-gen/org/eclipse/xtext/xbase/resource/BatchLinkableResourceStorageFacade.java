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
import java.util.List;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.macro.file.FileLocations;
import org.eclipse.xtend.lib.macro.file.Path;
import org.eclipse.xtext.resource.persistence.ResourceStorageFacade;
import org.eclipse.xtext.resource.persistence.ResourceStorageLoadable;
import org.eclipse.xtext.resource.persistence.ResourceStorageWritable;
import org.eclipse.xtext.resource.persistence.StorageAwareResource;
import org.eclipse.xtext.xbase.file.AbstractFileSystemSupport;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.resource.BatchLinkableResourceStorageLoadable;
import org.eclipse.xtext.xbase.resource.BatchLinkableResourceStorageWritable;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@SuppressWarnings("all")
public class BatchLinkableResourceStorageFacade extends ResourceStorageFacade {
  @Inject
  private AbstractFileSystemSupport fileSystemSupport;
  
  @Inject
  @Extension
  private FileLocations fileLocations;
  
  public ResourceStorageLoadable createResourceStorageLoadable(final InputStream in) {
    return new BatchLinkableResourceStorageLoadable(in);
  }
  
  public ResourceStorageWritable createResourceStorageWritable(final OutputStream out) {
    return new BatchLinkableResourceStorageWritable(out);
  }
  
  protected URI getSourceContainerURI(final StorageAwareResource resource) {
    final Path path = this.fileSystemSupport.getPath(resource);
    final Path sourceFolder = this.fileLocations.getSourceFolder(path);
    boolean _notEquals = (!Objects.equal(sourceFolder, null));
    if (_notEquals) {
      URI _uRI = resource.getURI();
      Path _relativize = sourceFolder.relativize(path);
      List<String> _segments = _relativize.getSegments();
      int _size = _segments.size();
      URI _trimSegments = _uRI.trimSegments(_size);
      return _trimSegments.appendSegment("");
    }
    return super.getSourceContainerURI(resource);
  }
}

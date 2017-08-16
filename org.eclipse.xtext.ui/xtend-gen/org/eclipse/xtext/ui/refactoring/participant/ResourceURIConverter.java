/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.refactoring.participant;

import com.google.inject.Inject;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;

/**
 * Converts platform resource URIs to IResources and back.
 * 
 * As opposed to the common {@link IStorage2UriMapper} it also works with folders and non-existing files.
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@SuppressWarnings("all")
public class ResourceURIConverter {
  @Inject(optional = true)
  private IWorkspace workspace;
  
  public URI toURI(final IResource file) {
    return this.toURI(file.getFullPath());
  }
  
  public URI toURI(final IPath path) {
    return URI.createPlatformResourceURI(path.toString(), true);
  }
  
  public IFile toFile(final URI uri) {
    IWorkspaceRoot _root = this.workspace.getRoot();
    String _platformString = uri.toPlatformString(true);
    Path _path = new Path(_platformString);
    return _root.getFile(_path);
  }
  
  public IFolder toFolder(final URI uri) {
    IWorkspaceRoot _root = this.workspace.getRoot();
    String _platformString = uri.toPlatformString(true);
    Path _path = new Path(_platformString);
    return _root.getFolder(_path);
  }
}

/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.workspace;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.workspace.IWorkspaceConfig;

@SuppressWarnings("all")
public class WorkspaceConfigUtil {
  public static ISourceFolder getSourceFolderContaining(final IWorkspaceConfig config, final URI uri) {
    final IProjectConfig projectConfig = config.findProjectContaining(uri);
    boolean _notEquals = (!Objects.equal(projectConfig, null));
    if (_notEquals) {
      return projectConfig.findSourceFolderContaing(uri);
    }
    return null;
  }
  
  public static URI getSourceRelativeUri(final IWorkspaceConfig config, final URI uri) {
    final ISourceFolder sourceFolder = WorkspaceConfigUtil.getSourceFolderContaining(config, uri);
    boolean _notEquals = (!Objects.equal(sourceFolder, null));
    if (_notEquals) {
      URI _path = sourceFolder.getPath();
      return uri.deresolve(_path);
    }
    return null;
  }
}

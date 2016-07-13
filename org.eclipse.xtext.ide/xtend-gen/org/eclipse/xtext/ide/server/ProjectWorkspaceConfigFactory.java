/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import java.io.File;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ide.server.IWorkspaceConfigFactory;
import org.eclipse.xtext.workspace.FileProjectConfig;
import org.eclipse.xtext.workspace.FileSourceFolder;
import org.eclipse.xtext.workspace.IWorkspaceConfig;

/**
 * The workspace itself is a single project
 * 
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.11
 */
@SuppressWarnings("all")
public class ProjectWorkspaceConfigFactory implements IWorkspaceConfigFactory {
  @Override
  public IWorkspaceConfig getWorkspaceConfig(final URI workspaceBaseURI) {
    String _fileString = workspaceBaseURI.toFileString();
    final File baseFile = new File(_fileString);
    boolean _isDirectory = baseFile.isDirectory();
    if (_isDirectory) {
      final FileProjectConfig projectConfig = new FileProjectConfig(baseFile);
      Set<FileSourceFolder> _sourceFolders = projectConfig.getSourceFolders();
      FileSourceFolder _fileSourceFolder = new FileSourceFolder(projectConfig, ".");
      _sourceFolders.add(_fileSourceFolder);
      return projectConfig.getWorkspaceConfig();
    }
    return null;
  }
}

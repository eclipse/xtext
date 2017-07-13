/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ide.server.IWorkspaceConfigFactory;
import org.eclipse.xtext.workspace.FileProjectConfig;
import org.eclipse.xtext.workspace.FileSourceFolder;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.workspace.InMemoryProjectConfig;

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
    if ((workspaceBaseURI == null)) {
      final InMemoryProjectConfig projectConfig = new InMemoryProjectConfig();
      return projectConfig.getWorkspaceConfig();
    } else {
      final FileProjectConfig projectConfig_1 = new FileProjectConfig(workspaceBaseURI);
      Set<FileSourceFolder> _sourceFolders = projectConfig_1.getSourceFolders();
      FileSourceFolder _fileSourceFolder = new FileSourceFolder(projectConfig_1, ".");
      _sourceFolders.add(_fileSourceFolder);
      return projectConfig_1.getWorkspaceConfig();
    }
  }
}

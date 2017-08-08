/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import java.io.File;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ide.server.ProjectWorkspaceConfigFactory;
import org.eclipse.xtext.workspace.FileProjectConfig;
import org.eclipse.xtext.workspace.WorkspaceConfig;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.11
 */
@SuppressWarnings("all")
public class MultiProjectWorkspaceConfigFactory extends ProjectWorkspaceConfigFactory {
  @Override
  public void findProjects(final WorkspaceConfig workspaceConfig, final URI uri) {
    if ((uri == null)) {
      return;
    }
    String _fileString = uri.toFileString();
    final File baseFile = new File(_fileString);
    boolean _isDirectory = baseFile.isDirectory();
    boolean _not = (!_isDirectory);
    if (_not) {
      return;
    }
    final Function1<File, Boolean> _function = (File it) -> {
      return Boolean.valueOf(it.isDirectory());
    };
    Iterable<File> _filter = IterableExtensions.<File>filter(((Iterable<File>)Conversions.doWrapArray(baseFile.listFiles())), _function);
    for (final File file : _filter) {
      {
        final FileProjectConfig project = new FileProjectConfig(file, workspaceConfig);
        project.addSourceFolder(".");
        workspaceConfig.addProject(project);
      }
    }
  }
}

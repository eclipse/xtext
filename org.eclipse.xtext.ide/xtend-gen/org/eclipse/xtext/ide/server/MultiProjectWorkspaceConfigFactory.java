/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import java.io.File;
import java.util.HashMap;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.ide.server.IWorkspaceConfigFactory;
import org.eclipse.xtext.ide.server.MultiProjectWorkspaceConfig;
import org.eclipse.xtext.ide.server.RootSourceFolderProjectConfig;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.11
 */
@SuppressWarnings("all")
public class MultiProjectWorkspaceConfigFactory implements IWorkspaceConfigFactory {
  @Override
  public IWorkspaceConfig getWorkspaceConfig(final URI workspaceBaseURI) {
    String _fileString = workspaceBaseURI.toFileString();
    final File baseFile = new File(_fileString);
    boolean _isDirectory = baseFile.isDirectory();
    if (_isDirectory) {
      final HashMap<String, IProjectConfig> name2config = CollectionLiterals.<String, IProjectConfig>newHashMap();
      final MultiProjectWorkspaceConfig result = new MultiProjectWorkspaceConfig(name2config);
      final IAcceptor<IProjectConfig> _function = (IProjectConfig it) -> {
        String _name = it.getName();
        name2config.put(_name, it);
      };
      final IAcceptor<IProjectConfig> acceptor = _function;
      File[] _listFiles = baseFile.listFiles();
      final Function1<File, Boolean> _function_1 = (File it) -> {
        return Boolean.valueOf(it.isDirectory());
      };
      Iterable<File> _filter = IterableExtensions.<File>filter(((Iterable<File>)Conversions.doWrapArray(_listFiles)), _function_1);
      final Consumer<File> _function_2 = (File it) -> {
        this.addProjectConfigs(URI.createFileURI(it.getAbsolutePath()), result, acceptor);
      };
      _filter.forEach(_function_2);
      return result;
    }
    return null;
  }
  
  public void addProjectConfigs(final URI projectBaseURI, final IWorkspaceConfig workspaceConfig, final IAcceptor<IProjectConfig> acceptor) {
    URI _appendSegment = projectBaseURI.appendSegment("");
    String _lastSegment = projectBaseURI.lastSegment();
    RootSourceFolderProjectConfig _rootSourceFolderProjectConfig = new RootSourceFolderProjectConfig(_appendSegment, _lastSegment, workspaceConfig);
    acceptor.accept(_rootSourceFolderProjectConfig);
  }
}

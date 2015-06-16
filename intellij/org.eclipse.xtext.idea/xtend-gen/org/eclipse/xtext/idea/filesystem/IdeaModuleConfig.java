/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.filesystem;

import com.intellij.openapi.module.Module;
import com.intellij.openapi.roots.SourceFolder;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.idea.extensions.RootModelExtensions;
import org.eclipse.xtext.idea.filesystem.IdeaSourceFolder;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class IdeaModuleConfig implements IProjectConfig {
  private final Module module;
  
  @Override
  public ISourceFolder findSourceFolderContaing(final URI member) {
    Set<? extends ISourceFolder> _sourceFolders = this.getSourceFolders();
    final Function1<ISourceFolder, Boolean> _function = new Function1<ISourceFolder, Boolean>() {
      @Override
      public Boolean apply(final ISourceFolder source) {
        URI _path = source.getPath();
        URI _deresolve = member.deresolve(_path);
        return Boolean.valueOf(_deresolve.isRelative());
      }
    };
    return IterableExtensions.findFirst(_sourceFolders, _function);
  }
  
  @Override
  public String getName() {
    return this.module.getName();
  }
  
  @Override
  public URI getPath() {
    return null;
  }
  
  @Override
  public Set<? extends ISourceFolder> getSourceFolders() {
    Iterable<SourceFolder> _sourceFolders = RootModelExtensions.getSourceFolders(this.module);
    final Function1<SourceFolder, IdeaSourceFolder> _function = new Function1<SourceFolder, IdeaSourceFolder>() {
      @Override
      public IdeaSourceFolder apply(final SourceFolder it) {
        return new IdeaSourceFolder(it);
      }
    };
    Iterable<IdeaSourceFolder> _map = IterableExtensions.<SourceFolder, IdeaSourceFolder>map(_sourceFolders, _function);
    return IterableExtensions.<IdeaSourceFolder>toSet(_map);
  }
  
  public IdeaModuleConfig(final Module module) {
    super();
    this.module = module;
  }
}

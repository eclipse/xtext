/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.workspace;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.workspace.UnknownProjectConfig;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

/**
 * The default workspace consists of multiple projects and always contains the unknown project that is used for projectless files.
 * 
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class WorkspaceConfig implements IWorkspaceConfig {
  private final UnknownProjectConfig unknown = new UnknownProjectConfig(this);
  
  private final HashMap<String, IProjectConfig> projects = CollectionLiterals.<String, IProjectConfig>newHashMap();
  
  public WorkspaceConfig(final IProjectConfig... initialProjects) {
    this.addProject(this.unknown);
    final Consumer<IProjectConfig> _function = (IProjectConfig it) -> {
      this.addProject(it);
    };
    ((List<IProjectConfig>)Conversions.doWrapArray(initialProjects)).forEach(_function);
  }
  
  @Override
  public Set<? extends IProjectConfig> getProjects() {
    return IterableExtensions.<IProjectConfig>toSet(this.projects.values());
  }
  
  public void addProject(final IProjectConfig project) {
    this.projects.put(project.getName(), project);
  }
  
  @Override
  public IProjectConfig findProjectByName(final String name) {
    return this.projects.get(name);
  }
  
  @Override
  public IProjectConfig findProjectContaining(final URI member) {
    final Function1<IProjectConfig, Boolean> _function = (IProjectConfig it) -> {
      ISourceFolder _findSourceFolderContaining = it.findSourceFolderContaining(member);
      return Boolean.valueOf((_findSourceFolderContaining != null));
    };
    final Iterable<IProjectConfig> candidates = IterableExtensions.<IProjectConfig>filter(this.projects.values(), _function);
    boolean _isEmpty = IterableExtensions.isEmpty(candidates);
    boolean _not = (!_isEmpty);
    if (_not) {
      final Function1<IProjectConfig, Integer> _function_1 = (IProjectConfig it) -> {
        return Integer.valueOf(it.getPath().segmentCount());
      };
      return IterableExtensions.<IProjectConfig, Integer>maxBy(candidates, _function_1);
    } else {
      return this.unknown;
    }
  }
}

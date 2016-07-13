/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import com.google.common.base.Objects;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class MultiProjectWorkspaceConfig implements IWorkspaceConfig {
  private final Map<String, IProjectConfig> name2config;
  
  @Override
  public Set<? extends IProjectConfig> getProjects() {
    Collection<IProjectConfig> _values = this.name2config.values();
    return new HashSet<IProjectConfig>(_values);
  }
  
  @Override
  public IProjectConfig findProjectByName(final String name) {
    return this.name2config.get(name);
  }
  
  @Override
  public IProjectConfig findProjectContaining(final URI member) {
    Collection<IProjectConfig> _values = this.name2config.values();
    final Function1<IProjectConfig, Boolean> _function = (IProjectConfig it) -> {
      ISourceFolder _findSourceFolderContaining = it.findSourceFolderContaining(member);
      return Boolean.valueOf((!Objects.equal(_findSourceFolderContaining, null)));
    };
    Iterable<IProjectConfig> _filter = IterableExtensions.<IProjectConfig>filter(_values, _function);
    final Function1<IProjectConfig, Integer> _function_1 = (IProjectConfig it) -> {
      URI _path = it.getPath();
      return Integer.valueOf(_path.segmentCount());
    };
    return IterableExtensions.<IProjectConfig, Integer>maxBy(_filter, _function_1);
  }
  
  public MultiProjectWorkspaceConfig(final Map<String, IProjectConfig> name2config) {
    super();
    this.name2config = name2config;
  }
}

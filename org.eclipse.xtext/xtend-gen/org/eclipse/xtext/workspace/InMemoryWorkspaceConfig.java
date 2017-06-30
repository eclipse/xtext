/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.workspace;

import com.google.common.base.Objects;
import java.util.Collections;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.util.UriUtil;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.workspace.InMemoryProjectConfig;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;

@FinalFieldsConstructor
@SuppressWarnings("all")
public class InMemoryWorkspaceConfig implements IWorkspaceConfig {
  private final IProjectConfig projectConfig;
  
  @Override
  public IProjectConfig findProjectByName(final String name) {
    String _name = this.projectConfig.getName();
    boolean _equals = Objects.equal(_name, name);
    if (_equals) {
      return this.projectConfig;
    }
    return null;
  }
  
  @Override
  public IProjectConfig findProjectContaining(final URI member) {
    InMemoryProjectConfig _xifexpression = null;
    boolean _isPrefixOf = UriUtil.isPrefixOf(this.projectConfig.getPath(), member);
    if (_isPrefixOf) {
      return this.projectConfig;
    } else {
      URI _trimSegments = member.trimFragment().trimQuery().trimSegments(1);
      _xifexpression = new InMemoryProjectConfig(_trimSegments);
    }
    return _xifexpression;
  }
  
  @Override
  public Set<? extends IProjectConfig> getProjects() {
    return Collections.<IProjectConfig>unmodifiableSet(CollectionLiterals.<IProjectConfig>newHashSet(this.projectConfig));
  }
  
  public InMemoryWorkspaceConfig(final IProjectConfig projectConfig) {
    super();
    this.projectConfig = projectConfig;
  }
}

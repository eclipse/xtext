/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
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
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.util.UriUtil;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class SingleProjectWorkspaceConfig implements IWorkspaceConfig {
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
    URI _path = this.projectConfig.getPath();
    boolean _isPrefixOf = UriUtil.isPrefixOf(_path, member);
    if (_isPrefixOf) {
      return this.projectConfig;
    }
    return null;
  }
  
  @Override
  public Set<? extends IProjectConfig> getProjects() {
    return Collections.<IProjectConfig>unmodifiableSet(CollectionLiterals.<IProjectConfig>newHashSet(this.projectConfig));
  }
  
  public SingleProjectWorkspaceConfig(final IProjectConfig projectConfig) {
    super();
    this.projectConfig = projectConfig;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.projectConfig== null) ? 0 : this.projectConfig.hashCode());
    return result;
  }
  
  @Override
  @Pure
  public boolean equals(final Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    SingleProjectWorkspaceConfig other = (SingleProjectWorkspaceConfig) obj;
    if (this.projectConfig == null) {
      if (other.projectConfig != null)
        return false;
    } else if (!this.projectConfig.equals(other.projectConfig))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("projectConfig", this.projectConfig);
    return b.toString();
  }
  
  @Pure
  public IProjectConfig getProjectConfig() {
    return this.projectConfig;
  }
}

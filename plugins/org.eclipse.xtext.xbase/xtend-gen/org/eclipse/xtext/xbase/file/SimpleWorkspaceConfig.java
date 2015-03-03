/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.file;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.file.ProjectConfig;
import org.eclipse.xtext.xbase.file.WorkspaceConfig;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * An implementation of the workspace config that can be configured by clients.
 */
@Data
@SuppressWarnings("all")
public class SimpleWorkspaceConfig extends WorkspaceConfig {
  private final String absoluteFileSystemPath;
  
  @Accessors(AccessorType.NONE)
  private final Map<String, ProjectConfig> projects = CollectionLiterals.<String, ProjectConfig>newLinkedHashMap();
  
  public ProjectConfig addProjectConfig(final ProjectConfig config) {
    String _name = config.getName();
    return this.projects.put(_name, config);
  }
  
  @Override
  public Collection<? extends ProjectConfig> getProjects() {
    Collection<ProjectConfig> _values = this.projects.values();
    return Collections.<ProjectConfig>unmodifiableCollection(_values);
  }
  
  @Override
  public ProjectConfig getProject(final String name) {
    return this.projects.get(name);
  }
  
  public SimpleWorkspaceConfig(final String absoluteFileSystemPath) {
    super();
    this.absoluteFileSystemPath = absoluteFileSystemPath;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.absoluteFileSystemPath== null) ? 0 : this.absoluteFileSystemPath.hashCode());
    result = prime * result + ((this.projects== null) ? 0 : this.projects.hashCode());
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
    SimpleWorkspaceConfig other = (SimpleWorkspaceConfig) obj;
    if (this.absoluteFileSystemPath == null) {
      if (other.absoluteFileSystemPath != null)
        return false;
    } else if (!this.absoluteFileSystemPath.equals(other.absoluteFileSystemPath))
      return false;
    if (this.projects == null) {
      if (other.projects != null)
        return false;
    } else if (!this.projects.equals(other.projects))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    String result = new ToStringBuilder(this)
    	.addAllFields()
    	.toString();
    return result;
  }
  
  @Override
@Pure
  public String getAbsoluteFileSystemPath() {
    return this.absoluteFileSystemPath;
  }
}

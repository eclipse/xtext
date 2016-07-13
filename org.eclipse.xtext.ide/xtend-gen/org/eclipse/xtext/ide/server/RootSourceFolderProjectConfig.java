/**
 * Copyright (c) 2016 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.server;

import java.util.Collections;
import java.util.Set;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.util.UriUtil;
import org.eclipse.xtext.workspace.IProjectConfig;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Jan Koehnlein - Initial contribution and API
 * @since 2.11
 */
@Data
@SuppressWarnings("all")
public class RootSourceFolderProjectConfig implements IProjectConfig, ISourceFolder {
  private final URI path;
  
  private final String name;
  
  private final IWorkspaceConfig workspaceConfig;
  
  @Override
  public ISourceFolder findSourceFolderContaining(final URI member) {
    RootSourceFolderProjectConfig _xifexpression = null;
    boolean _isPrefixOf = UriUtil.isPrefixOf(this.path, member);
    if (_isPrefixOf) {
      _xifexpression = this;
    } else {
      _xifexpression = null;
    }
    return _xifexpression;
  }
  
  @Override
  public Set<? extends ISourceFolder> getSourceFolders() {
    return Collections.<ISourceFolder>unmodifiableSet(CollectionLiterals.<ISourceFolder>newHashSet(this));
  }
  
  public RootSourceFolderProjectConfig(final URI path, final String name, final IWorkspaceConfig workspaceConfig) {
    super();
    this.path = path;
    this.name = name;
    this.workspaceConfig = workspaceConfig;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.path== null) ? 0 : this.path.hashCode());
    result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.workspaceConfig== null) ? 0 : this.workspaceConfig.hashCode());
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
    RootSourceFolderProjectConfig other = (RootSourceFolderProjectConfig) obj;
    if (this.path == null) {
      if (other.path != null)
        return false;
    } else if (!this.path.equals(other.path))
      return false;
    if (this.name == null) {
      if (other.name != null)
        return false;
    } else if (!this.name.equals(other.name))
      return false;
    if (this.workspaceConfig == null) {
      if (other.workspaceConfig != null)
        return false;
    } else if (!this.workspaceConfig.equals(other.workspaceConfig))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("path", this.path);
    b.add("name", this.name);
    b.add("workspaceConfig", this.workspaceConfig);
    return b.toString();
  }
  
  @Pure
  public URI getPath() {
    return this.path;
  }
  
  @Pure
  public String getName() {
    return this.name;
  }
  
  @Pure
  public IWorkspaceConfig getWorkspaceConfig() {
    return this.workspaceConfig;
  }
}

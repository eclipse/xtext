/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.workspace;

import com.google.common.base.Objects;
import org.eclipse.emf.common.notify.impl.AdapterImpl;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.workspace.IWorkspaceConfig;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class WorkspaceConfigAdapter extends AdapterImpl {
  private final IWorkspaceConfig workspaceConfig;
  
  @Override
  public boolean isAdapterForType(final Object type) {
    return Objects.equal(type, WorkspaceConfigAdapter.class);
  }
  
  public WorkspaceConfigAdapter(final IWorkspaceConfig workspaceConfig) {
    super();
    this.workspaceConfig = workspaceConfig;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
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
    WorkspaceConfigAdapter other = (WorkspaceConfigAdapter) obj;
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
    String result = new ToStringBuilder(this)
    	.addAllFields()
    	.toString();
    return result;
  }
  
  @Pure
  public IWorkspaceConfig getWorkspaceConfig() {
    return this.workspaceConfig;
  }
}

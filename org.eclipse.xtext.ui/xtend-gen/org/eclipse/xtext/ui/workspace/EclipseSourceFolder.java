/**
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ui.workspace;

import org.eclipse.core.resources.IProject;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.workspace.ISourceFolder;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class EclipseSourceFolder implements ISourceFolder {
  private final IProject project;
  
  private final String name;
  
  @Override
  public String getName() {
    return this.name;
  }
  
  @Override
  public URI getPath() {
    String _name = this.project.getName();
    String _plus = ("/" + _name);
    String _plus_1 = (_plus + "/");
    String _plus_2 = (_plus_1 + this.name);
    String _plus_3 = (_plus_2 + "/");
    return URI.createPlatformResourceURI(_plus_3, true);
  }
  
  public EclipseSourceFolder(final IProject project, final String name) {
    super();
    this.project = project;
    this.name = name;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.project== null) ? 0 : this.project.hashCode());
    result = prime * result + ((this.name== null) ? 0 : this.name.hashCode());
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
    EclipseSourceFolder other = (EclipseSourceFolder) obj;
    if (this.project == null) {
      if (other.project != null)
        return false;
    } else if (!this.project.equals(other.project))
      return false;
    if (this.name == null) {
      if (other.name != null)
        return false;
    } else if (!this.name.equals(other.name))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("project", this.project);
    b.add("name", this.name);
    return b.toString();
  }
  
  @Pure
  public IProject getProject() {
    return this.project;
  }
}

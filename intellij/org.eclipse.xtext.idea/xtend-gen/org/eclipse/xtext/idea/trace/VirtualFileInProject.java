/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.trace;

import com.google.common.base.Objects;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiElement;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.psi.XtextPsiUtils;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Data
@SuppressWarnings("all")
public class VirtualFileInProject {
  public static VirtualFileInProject forPsiElement(final PsiElement element) {
    final VirtualFile virtualFile = XtextPsiUtils.findVirtualFile(element);
    boolean _equals = Objects.equal(virtualFile, null);
    if (_equals) {
      return null;
    }
    Project _project = element.getProject();
    return new VirtualFileInProject(virtualFile, _project);
  }
  
  private final VirtualFile file;
  
  private final Project project;
  
  public VirtualFileInProject(final VirtualFile file, final Project project) {
    super();
    this.file = file;
    this.project = project;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.file== null) ? 0 : this.file.hashCode());
    result = prime * result + ((this.project== null) ? 0 : this.project.hashCode());
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
    VirtualFileInProject other = (VirtualFileInProject) obj;
    if (this.file == null) {
      if (other.file != null)
        return false;
    } else if (!this.file.equals(other.file))
      return false;
    if (this.project == null) {
      if (other.project != null)
        return false;
    } else if (!this.project.equals(other.project))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("file", this.file);
    b.add("project", this.project);
    return b.toString();
  }
  
  @Pure
  public VirtualFile getFile() {
    return this.file;
  }
  
  @Pure
  public Project getProject() {
    return this.project;
  }
}

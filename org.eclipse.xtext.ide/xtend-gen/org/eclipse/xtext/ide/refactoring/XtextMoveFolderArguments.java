/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.refactoring;

import java.util.List;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.ide.refactoring.ResourceURIChange;
import org.eclipse.xtext.ide.refactoring.XtextMoveArguments;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@Data
@SuppressWarnings("all")
public class XtextMoveFolderArguments extends XtextMoveArguments {
  private final List<ResourceURIChange> folderChanges;
  
  public XtextMoveFolderArguments(final ResourceSet resourceSet, final List<ResourceURIChange> changes, final List<ResourceURIChange> folderChanges) {
    super(resourceSet, changes);
    this.folderChanges = folderChanges;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.folderChanges== null) ? 0 : this.folderChanges.hashCode());
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
    if (!super.equals(obj))
      return false;
    XtextMoveFolderArguments other = (XtextMoveFolderArguments) obj;
    if (this.folderChanges == null) {
      if (other.folderChanges != null)
        return false;
    } else if (!this.folderChanges.equals(other.folderChanges))
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
  public List<ResourceURIChange> getFolderChanges() {
    return this.folderChanges;
  }
}

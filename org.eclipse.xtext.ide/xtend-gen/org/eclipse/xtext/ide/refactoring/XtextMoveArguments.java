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
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * The arguments passed to a {@link XtextMoveResourceStrategy}.
 * 
 * In the resourceSet the refactoring is already applied, i.e. all
 * moved resources already have the new URI.
 * 
 * @author koehnlein - Initial contribution and API
 * @since 2.13
 */
@Data
@SuppressWarnings("all")
public class XtextMoveArguments {
  private final ResourceSet resourceSet;
  
  private final List<ResourceURIChange> changes;
  
  public XtextMoveArguments(final ResourceSet resourceSet, final List<ResourceURIChange> changes) {
    super();
    this.resourceSet = resourceSet;
    this.changes = changes;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.resourceSet== null) ? 0 : this.resourceSet.hashCode());
    result = prime * result + ((this.changes== null) ? 0 : this.changes.hashCode());
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
    XtextMoveArguments other = (XtextMoveArguments) obj;
    if (this.resourceSet == null) {
      if (other.resourceSet != null)
        return false;
    } else if (!this.resourceSet.equals(other.resourceSet))
      return false;
    if (this.changes == null) {
      if (other.changes != null)
        return false;
    } else if (!this.changes.equals(other.changes))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("resourceSet", this.resourceSet);
    b.add("changes", this.changes);
    return b.toString();
  }
  
  @Pure
  public ResourceSet getResourceSet() {
    return this.resourceSet;
  }
  
  @Pure
  public List<ResourceURIChange> getChanges() {
    return this.changes;
  }
}

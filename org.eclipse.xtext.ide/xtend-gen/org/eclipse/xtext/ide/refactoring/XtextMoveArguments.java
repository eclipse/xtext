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
import org.eclipse.xtext.ide.refactoring.ResourceMove;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

@Data
@SuppressWarnings("all")
public class XtextMoveArguments {
  private final ResourceSet resourceSet;
  
  private final List<ResourceMove> moves;
  
  public XtextMoveArguments(final ResourceSet resourceSet, final List<ResourceMove> moves) {
    super();
    this.resourceSet = resourceSet;
    this.moves = moves;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.resourceSet== null) ? 0 : this.resourceSet.hashCode());
    result = prime * result + ((this.moves== null) ? 0 : this.moves.hashCode());
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
    if (this.moves == null) {
      if (other.moves != null)
        return false;
    } else if (!this.moves.equals(other.moves))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("resourceSet", this.resourceSet);
    b.add("moves", this.moves);
    return b.toString();
  }
  
  @Pure
  public ResourceSet getResourceSet() {
    return this.resourceSet;
  }
  
  @Pure
  public List<ResourceMove> getMoves() {
    return this.moves;
  }
}

/**
 * Copyright (c) 2014 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.controlflow;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.util.RecursionGuard;

@Data
@SuppressWarnings("all")
public class EvaluationContext {
  private final IResolvedTypes resolvedTypes;
  
  private final RecursionGuard<EObject> visiting;
  
  public EvaluationContext(final IResolvedTypes resolvedTypes, final RecursionGuard<EObject> visiting) {
    super();
    this.resolvedTypes = resolvedTypes;
    this.visiting = visiting;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.resolvedTypes== null) ? 0 : this.resolvedTypes.hashCode());
    result = prime * result + ((this.visiting== null) ? 0 : this.visiting.hashCode());
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
    EvaluationContext other = (EvaluationContext) obj;
    if (this.resolvedTypes == null) {
      if (other.resolvedTypes != null)
        return false;
    } else if (!this.resolvedTypes.equals(other.resolvedTypes))
      return false;
    if (this.visiting == null) {
      if (other.visiting != null)
        return false;
    } else if (!this.visiting.equals(other.visiting))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("resolvedTypes", this.resolvedTypes);
    b.add("visiting", this.visiting);
    return b.toString();
  }
  
  @Pure
  public IResolvedTypes getResolvedTypes() {
    return this.resolvedTypes;
  }
  
  @Pure
  public RecursionGuard<EObject> getVisiting() {
    return this.visiting;
  }
}

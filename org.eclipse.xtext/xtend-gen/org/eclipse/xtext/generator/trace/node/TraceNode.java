/**
 * Copyright (c) 2017 TypeFox (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.trace.node;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.generator.trace.ILocationData;
import org.eclipse.xtext.generator.trace.node.CompositeGeneratorNode;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * @author Sven Efftinge - initial contribution and API
 */
@Data
@SuppressWarnings("all")
public class TraceNode extends CompositeGeneratorNode {
  private final ILocationData sourceLocation;
  
  public TraceNode(final ILocationData sourceLocation) {
    super();
    this.sourceLocation = sourceLocation;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.sourceLocation== null) ? 0 : this.sourceLocation.hashCode());
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
    TraceNode other = (TraceNode) obj;
    if (this.sourceLocation == null) {
      if (other.sourceLocation != null)
        return false;
    } else if (!this.sourceLocation.equals(other.sourceLocation))
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
  public ILocationData getSourceLocation() {
    return this.sourceLocation;
  }
}

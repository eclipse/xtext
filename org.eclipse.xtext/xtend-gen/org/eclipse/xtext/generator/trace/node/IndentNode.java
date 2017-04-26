/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.trace.node;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.EqualsHashCode;
import org.eclipse.xtext.generator.trace.node.CompositeGeneratorNode;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Accessors
@EqualsHashCode
@SuppressWarnings("all")
public class IndentNode extends CompositeGeneratorNode {
  private String indentationString;
  
  public IndentNode(final String indentationString) {
    this.indentationString = indentationString;
  }
  
  @Pure
  public String getIndentationString() {
    return this.indentationString;
  }
  
  public void setIndentationString(final String indentationString) {
    this.indentationString = indentationString;
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
    IndentNode other = (IndentNode) obj;
    if (this.indentationString == null) {
      if (other.indentationString != null)
        return false;
    } else if (!this.indentationString.equals(other.indentationString))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.indentationString== null) ? 0 : this.indentationString.hashCode());
    return result;
  }
}

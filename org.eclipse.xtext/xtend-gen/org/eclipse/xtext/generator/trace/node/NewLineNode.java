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
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.trace.node.IGeneratorNode;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Accessors
@EqualsHashCode
@SuppressWarnings("all")
public class NewLineNode implements IGeneratorNode {
  private String lineDelimiter;
  
  private boolean ifNotEmpty;
  
  public NewLineNode(final String lineDelimiter) {
    this.lineDelimiter = lineDelimiter;
  }
  
  public NewLineNode(final String lineDelimiter, final boolean ifNotEmpty) {
    this.lineDelimiter = lineDelimiter;
    this.ifNotEmpty = ifNotEmpty;
  }
  
  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    String _simpleName = this.getClass().getSimpleName();
    _builder.append(_simpleName);
    _builder.append(" \"");
    String _convertToJavaString = Strings.convertToJavaString(this.lineDelimiter);
    _builder.append(_convertToJavaString);
    _builder.append("\"");
    {
      if (this.ifNotEmpty) {
        _builder.append(" if not empty");
      }
    }
    return _builder.toString();
  }
  
  @Pure
  public String getLineDelimiter() {
    return this.lineDelimiter;
  }
  
  public void setLineDelimiter(final String lineDelimiter) {
    this.lineDelimiter = lineDelimiter;
  }
  
  @Pure
  public boolean isIfNotEmpty() {
    return this.ifNotEmpty;
  }
  
  public void setIfNotEmpty(final boolean ifNotEmpty) {
    this.ifNotEmpty = ifNotEmpty;
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
    NewLineNode other = (NewLineNode) obj;
    if (this.lineDelimiter == null) {
      if (other.lineDelimiter != null)
        return false;
    } else if (!this.lineDelimiter.equals(other.lineDelimiter))
      return false;
    if (other.ifNotEmpty != this.ifNotEmpty)
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.lineDelimiter== null) ? 0 : this.lineDelimiter.hashCode());
    result = prime * result + (this.ifNotEmpty ? 1231 : 1237);
    return result;
  }
}

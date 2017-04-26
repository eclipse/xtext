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
public class TextNode implements IGeneratorNode {
  private CharSequence text;
  
  public TextNode(final CharSequence text) {
    this.text = text;
  }
  
  @Override
  public String toString() {
    StringConcatenation _builder = new StringConcatenation();
    String _simpleName = this.getClass().getSimpleName();
    _builder.append(_simpleName);
    _builder.append(" \"");
    String _convertToJavaString = Strings.convertToJavaString(this.text.toString());
    _builder.append(_convertToJavaString);
    _builder.append("\"");
    return _builder.toString();
  }
  
  @Pure
  public CharSequence getText() {
    return this.text;
  }
  
  public void setText(final CharSequence text) {
    this.text = text;
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
    TextNode other = (TextNode) obj;
    if (this.text == null) {
      if (other.text != null)
        return false;
    } else if (!this.text.equals(other.text))
      return false;
    return true;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.text== null) ? 0 : this.text.hashCode());
    return result;
  }
}

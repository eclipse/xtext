/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.trace.node;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.trace.node.IGeneratorNode;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * A text node is a <em>leaf</em> in the code generator tree and produces arbitrary text.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@Accessors
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
}

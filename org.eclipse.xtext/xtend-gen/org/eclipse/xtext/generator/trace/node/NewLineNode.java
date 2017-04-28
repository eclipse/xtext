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
 * A new line node is a <em>leaf</em> in the code generator tree and produces line breaks.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@Accessors
@SuppressWarnings("all")
public class NewLineNode implements IGeneratorNode {
  private String lineDelimiter;
  
  /**
   * When this is set to {@code true}, the preceding line is removed if it contains only whitespace.
   */
  private boolean ifNotEmpty;
  
  public NewLineNode(final String lineDelimiter) {
    this(lineDelimiter, false);
  }
  
  public NewLineNode(final String lineDelimiter, final boolean ifNotEmpty) {
    if ((lineDelimiter == null)) {
      throw new NullPointerException();
    }
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
}

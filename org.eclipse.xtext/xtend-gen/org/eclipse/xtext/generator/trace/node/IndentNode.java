/**
 * Copyright (c) 2017 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.generator.trace.node;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.generator.trace.node.CompositeGeneratorNode;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * An indent node prepends the indentation string to each line that is generated through its children.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@Accessors
@SuppressWarnings("all")
public class IndentNode extends CompositeGeneratorNode {
  private String indentationString;
  
  /**
   * When this is set to {@code true}, the indentation is always inserted in the first line, otherwise it is
   * inserted only if the first line has no text preceding this node.
   */
  private boolean indentImmediately;
  
  /**
   * When this is set to {@code true}, all lines are indented, otherwise only lines with text content are indented.
   */
  private boolean indentEmptyLines;
  
  public IndentNode(final String indentationString) {
    this(indentationString, true, false);
  }
  
  public IndentNode(final String indentationString, final boolean indentImmediately, final boolean indentEmptyLines) {
    if ((indentationString == null)) {
      throw new NullPointerException();
    }
    this.indentationString = indentationString;
    this.indentImmediately = indentImmediately;
    this.indentEmptyLines = indentEmptyLines;
  }
  
  @Pure
  public String getIndentationString() {
    return this.indentationString;
  }
  
  public void setIndentationString(final String indentationString) {
    this.indentationString = indentationString;
  }
  
  @Pure
  public boolean isIndentImmediately() {
    return this.indentImmediately;
  }
  
  public void setIndentImmediately(final boolean indentImmediately) {
    this.indentImmediately = indentImmediately;
  }
  
  @Pure
  public boolean isIndentEmptyLines() {
    return this.indentEmptyLines;
  }
  
  public void setIndentEmptyLines(final boolean indentEmptyLines) {
    this.indentEmptyLines = indentEmptyLines;
  }
}

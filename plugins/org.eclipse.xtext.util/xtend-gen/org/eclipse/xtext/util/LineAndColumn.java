/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.util;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * A simple record with line and column information.
 * The line number is one-based, e.g. the first line in the document
 * has the line number 1.
 * The column number is one based, too, e.g the first column in a line
 * has the index 1.
 * 
 * Line breaks are part of the line itself, e.g. the first line break
 * in the document still has line number one.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.9
 */
@Data
@SuppressWarnings("all")
public class LineAndColumn {
  private final int line;
  
  private final int column;
  
  public static LineAndColumn from(final int line, final int column) {
    final LineAndColumn result = new LineAndColumn(line, column);
    if (((line <= 0) || (column <= 0))) {
      String _string = result.toString();
      throw new IllegalArgumentException(_string);
    }
    return result;
  }
  
  private LineAndColumn(final int line, final int column) {
    this.line = line;
    this.column = column;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + this.line;
    result = prime * result + this.column;
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
    LineAndColumn other = (LineAndColumn) obj;
    if (other.line != this.line)
      return false;
    if (other.column != this.column)
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("line", this.line);
    b.add("column", this.column);
    return b.toString();
  }
  
  @Pure
  public int getLine() {
    return this.line;
  }
  
  @Pure
  public int getColumn() {
    return this.column;
  }
}

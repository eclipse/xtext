/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.ide.editor.bracketmatching;

import org.eclipse.xtend.lib.annotations.Data;
import org.eclipse.xtext.xbase.lib.Pure;
import org.eclipse.xtext.xbase.lib.util.ToStringBuilder;

/**
 * Defines a single pair of braces which need to be matched when editing code.
 * 
 * @author kosyakov - Initial contribution and API
 */
@Data
@SuppressWarnings("all")
public class BracePair {
  /**
   * The length of a left brace should be one character for Eclipse.
   */
  private final String leftBrace;
  
  /**
   * The length of a right brace should be one character for Eclipse.
   */
  private final String rightBrace;
  
  /**
   * True if the brace is structural. Structural braces have higher priority than regular braces:
   * they are matched with each other even if there are unmatched braces of other types between them,
   * and an opening non-structural brace is not matched with a closing one if one of them is outside a pair
   * of matched structural braces and another is outside. In Java code, the curly braces are structural.
   * 
   * It is ignored by Eclipse.
   */
  private final boolean structural;
  
  public BracePair(final String leftBrace, final String rightBrace, final boolean structural) {
    super();
    this.leftBrace = leftBrace;
    this.rightBrace = rightBrace;
    this.structural = structural;
  }
  
  @Override
  @Pure
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((this.leftBrace== null) ? 0 : this.leftBrace.hashCode());
    result = prime * result + ((this.rightBrace== null) ? 0 : this.rightBrace.hashCode());
    return prime * result + (this.structural ? 1231 : 1237);
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
    BracePair other = (BracePair) obj;
    if (this.leftBrace == null) {
      if (other.leftBrace != null)
        return false;
    } else if (!this.leftBrace.equals(other.leftBrace))
      return false;
    if (this.rightBrace == null) {
      if (other.rightBrace != null)
        return false;
    } else if (!this.rightBrace.equals(other.rightBrace))
      return false;
    if (other.structural != this.structural)
      return false;
    return true;
  }
  
  @Override
  @Pure
  public String toString() {
    ToStringBuilder b = new ToStringBuilder(this);
    b.add("leftBrace", this.leftBrace);
    b.add("rightBrace", this.rightBrace);
    b.add("structural", this.structural);
    return b.toString();
  }
  
  @Pure
  public String getLeftBrace() {
    return this.leftBrace;
  }
  
  @Pure
  public String getRightBrace() {
    return this.rightBrace;
  }
  
  @Pure
  public boolean isStructural() {
    return this.structural;
  }
}

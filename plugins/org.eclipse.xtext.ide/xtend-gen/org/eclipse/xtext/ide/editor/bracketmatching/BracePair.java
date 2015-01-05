/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.ide.editor.bracketmatching;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * Defines a single pair of braces which need to be matched when editing code.
 * 
 * @author kosyakov - Initial contribution and API
 */
@Accessors
@FinalFieldsConstructor
@SuppressWarnings("all")
public class BracePair {
  private final String leftBrace;
  
  private final String rightBrace;
  
  private final boolean structural;
  
  public BracePair(final String leftBrace, final String rightBrace, final boolean structural) {
    super();
    this.leftBrace = leftBrace;
    this.rightBrace = rightBrace;
    this.structural = structural;
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

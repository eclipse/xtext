/**
 * Copyright (c) 2016, 2019 TypeFox GmbH (http://www.typefox.io) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.testing;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.testing.TextDocumentConfiguration;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@SuppressWarnings("all")
public class TextDocumentPositionConfiguration extends TextDocumentConfiguration {
  private int line = 0;
  
  private int column = 0;
  
  @Pure
  public int getLine() {
    return this.line;
  }
  
  public void setLine(final int line) {
    this.line = line;
  }
  
  @Pure
  public int getColumn() {
    return this.column;
  }
  
  public void setColumn(final int column) {
    this.column = column;
  }
}

/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.editorActions;

import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@Accessors
@FinalFieldsConstructor
@SuppressWarnings("all")
public class AutoEditBlock {
  private final String openingTerminal;
  
  private final String indentationTerminal;
  
  private final String closingTerminal;
  
  private final boolean nested;
  
  public AutoEditBlock(final String openingTerminal, final String indentationTerminal, final String closingTerminal) {
    this(openingTerminal, indentationTerminal, closingTerminal, false);
  }
  
  public AutoEditBlock(final String openingTerminal, final String indentationTerminal, final String closingTerminal, final boolean nested) {
    super();
    this.openingTerminal = openingTerminal;
    this.indentationTerminal = indentationTerminal;
    this.closingTerminal = closingTerminal;
    this.nested = nested;
  }
  
  @Pure
  public String getOpeningTerminal() {
    return this.openingTerminal;
  }
  
  @Pure
  public String getIndentationTerminal() {
    return this.indentationTerminal;
  }
  
  @Pure
  public String getClosingTerminal() {
    return this.closingTerminal;
  }
  
  @Pure
  public boolean isNested() {
    return this.nested;
  }
}

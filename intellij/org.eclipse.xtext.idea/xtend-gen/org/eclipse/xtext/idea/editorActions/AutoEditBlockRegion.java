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
import org.eclipse.xtext.idea.editorActions.AutoEditBlock;
import org.eclipse.xtext.util.TextRegion;
import org.eclipse.xtext.xbase.lib.Pure;

@Accessors
@FinalFieldsConstructor
@SuppressWarnings("all")
public class AutoEditBlockRegion {
  private final AutoEditBlock block;
  
  private final TextRegion openingTerminal;
  
  private final TextRegion closingTerminal;
  
  public AutoEditBlockRegion(final AutoEditBlock block, final TextRegion openingTerminal, final TextRegion closingTerminal) {
    super();
    this.block = block;
    this.openingTerminal = openingTerminal;
    this.closingTerminal = closingTerminal;
  }
  
  @Pure
  public AutoEditBlock getBlock() {
    return this.block;
  }
  
  @Pure
  public TextRegion getOpeningTerminal() {
    return this.openingTerminal;
  }
  
  @Pure
  public TextRegion getClosingTerminal() {
    return this.closingTerminal;
  }
}

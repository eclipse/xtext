/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.editorActions;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.idea.editorActions.AbstractAutoEditBlock;
import org.eclipse.xtext.idea.editorActions.AutoEditBlockRegion;
import org.eclipse.xtext.idea.editorActions.AutoEditContext;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@Accessors
@SuppressWarnings("all")
public abstract class AbstractIndentableAutoEditBlock extends AbstractAutoEditBlock {
  private final String indentationTerminal;
  
  private final boolean nested;
  
  public AbstractIndentableAutoEditBlock(final String openingTerminal, final String closingTerminal) {
    this(openingTerminal, closingTerminal, false);
  }
  
  public AbstractIndentableAutoEditBlock(final String openingTerminal, final String closingTerminal, final boolean nested) {
    this(openingTerminal, null, closingTerminal, nested);
  }
  
  public AbstractIndentableAutoEditBlock(final String openingTerminal, final String indentationTerminal, final String closingTerminal) {
    this(openingTerminal, indentationTerminal, closingTerminal, false);
  }
  
  public AbstractIndentableAutoEditBlock(final String openingTerminal, final String indentationTerminal, final String closingTerminal, final boolean nested) {
    super(openingTerminal, closingTerminal);
    this.indentationTerminal = indentationTerminal;
    this.nested = nested;
  }
  
  @Inject
  private IIndentationInformation indentationInformation;
  
  protected String getIndentationTerminal() {
    boolean _equals = Objects.equal(this.indentationTerminal, null);
    if (_equals) {
      return this.indentationInformation.getIndentString();
    }
    return this.indentationTerminal;
  }
  
  public abstract AutoEditBlockRegion findRegion(@Extension final AutoEditContext context);
  
  public abstract String indent(final AutoEditBlockRegion region, final String previousLineIndentation, @Extension final AutoEditContext context);
  
  @Pure
  public boolean isNested() {
    return this.nested;
  }
  
  @Pure
  public IIndentationInformation getIndentationInformation() {
    return this.indentationInformation;
  }
  
  public void setIndentationInformation(final IIndentationInformation indentationInformation) {
    this.indentationInformation = indentationInformation;
  }
}

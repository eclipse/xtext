/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.formatting;

import com.google.inject.Inject;
import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.ChildAttributes;
import com.intellij.formatting.Indent;
import com.intellij.formatting.Spacing;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.formatting.Wrap;
import com.intellij.openapi.util.TextRange;
import java.util.List;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.idea.formatting.ChildAttributesProvider;
import org.eclipse.xtext.idea.formatting.ModifiableBlock;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class SyntheticXtextBlock implements ModifiableBlock {
  @Accessors
  private Block parentBlock;
  
  @Accessors
  private Boolean incomplete = Boolean.valueOf(false);
  
  @Accessors
  private Indent indent = Indent.getNoneIndent();
  
  @Accessors
  private SpacingBuilder spacingBuilder;
  
  @Accessors
  private final List<Block> children = CollectionLiterals.<Block>newArrayList();
  
  @Inject
  private ChildAttributesProvider childAttributesProvider;
  
  @Override
  public boolean isIncomplete() {
    return (this.incomplete).booleanValue();
  }
  
  @Override
  public boolean isLeaf() {
    return false;
  }
  
  @Override
  public Alignment getAlignment() {
    return null;
  }
  
  @Override
  public ChildAttributes getChildAttributes(final int newChildIndex) {
    return this.childAttributesProvider.getChildAttributes(this, newChildIndex);
  }
  
  @Override
  public Spacing getSpacing(final Block child1, final Block child2) {
    Spacing _spacing = null;
    if (this.spacingBuilder!=null) {
      _spacing=this.spacingBuilder.getSpacing(this, child1, child2);
    }
    return _spacing;
  }
  
  @Override
  public List<Block> getSubBlocks() {
    return this.children;
  }
  
  @Override
  public Wrap getWrap() {
    return null;
  }
  
  @Override
  public TextRange getTextRange() {
    TextRange _xblockexpression = null;
    {
      Block _head = IterableExtensions.<Block>head(this.children);
      TextRange _textRange = _head.getTextRange();
      final int startOffset = _textRange.getStartOffset();
      Block _last = IterableExtensions.<Block>last(this.children);
      TextRange _textRange_1 = _last.getTextRange();
      final int endOffset = _textRange_1.getEndOffset();
      _xblockexpression = new TextRange(startOffset, endOffset);
    }
    return _xblockexpression;
  }
  
  @Override
  public String toString() {
    String _string = this.children.toString();
    String _plus = (_string + " ");
    TextRange _textRange = this.getTextRange();
    String _string_1 = _textRange.toString();
    return (_plus + _string_1);
  }
  
  @Pure
  public Block getParentBlock() {
    return this.parentBlock;
  }
  
  public void setParentBlock(final Block parentBlock) {
    this.parentBlock = parentBlock;
  }
  
  @Pure
  public Boolean getIncomplete() {
    return this.incomplete;
  }
  
  public void setIncomplete(final Boolean incomplete) {
    this.incomplete = incomplete;
  }
  
  @Pure
  public Indent getIndent() {
    return this.indent;
  }
  
  public void setIndent(final Indent indent) {
    this.indent = indent;
  }
  
  @Pure
  public SpacingBuilder getSpacingBuilder() {
    return this.spacingBuilder;
  }
  
  public void setSpacingBuilder(final SpacingBuilder spacingBuilder) {
    this.spacingBuilder = spacingBuilder;
  }
  
  @Pure
  public List<Block> getChildren() {
    return this.children;
  }
}

/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.formatting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.intellij.formatting.Block;
import com.intellij.formatting.ChildAttributes;
import com.intellij.formatting.Indent;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.ide.editor.bracketmatching.BracePair;
import org.eclipse.xtext.idea.formatting.BlockExtension;
import org.eclipse.xtext.idea.formatting.ChildAttributesProvider;
import org.eclipse.xtext.idea.formatting.SyntheticXtextBlock;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class DefaultChildAttributesProvider implements ChildAttributesProvider {
  @Inject
  @Extension
  private BlockExtension _blockExtension;
  
  @Override
  public ChildAttributes getChildAttributes(final Block block, final int newChildIndex) {
    Indent _elvis = null;
    Indent _childIndent = this.getChildIndent(block, newChildIndex);
    if (_childIndent != null) {
      _elvis = _childIndent;
    } else {
      Indent _noneIndent = Indent.getNoneIndent();
      _elvis = _noneIndent;
    }
    final Indent indent = _elvis;
    return new ChildAttributes(indent, null);
  }
  
  protected Indent getChildIndent(final Block block, final int newChildIndex) {
    final List<Block> children = block.getSubBlocks();
    boolean _isEmpty = children.isEmpty();
    if (_isEmpty) {
      return null;
    }
    int _size = children.size();
    boolean _greaterEqualsThan = (newChildIndex >= _size);
    if (_greaterEqualsThan) {
      int _size_1 = children.size();
      return this.getAfterChildIndent(block, _size_1);
    }
    final Indent indent = this.getBeforeChildIndent(block, newChildIndex);
    boolean _equals = Objects.equal(indent, null);
    if (_equals) {
      return this.getAfterChildIndent(block, newChildIndex);
    }
    return indent;
  }
  
  protected Indent getBeforeChildIndent(final Block block, final int newChildIndex) {
    final List<Block> children = block.getSubBlocks();
    boolean _isEmpty = children.isEmpty();
    if (_isEmpty) {
      return null;
    }
    int _size = children.size();
    boolean _greaterEqualsThan = (newChildIndex >= _size);
    if (_greaterEqualsThan) {
      return null;
    }
    final Block child = children.get(newChildIndex);
    boolean _isLeaf = child.isLeaf();
    if (_isLeaf) {
      return this.getBeforeChildIndent(child);
    }
    return this.getChildIndent(child, 0);
  }
  
  protected Indent getAfterChildIndent(final Block block, final int newChildIndex) {
    if ((newChildIndex == 0)) {
      return null;
    }
    final List<Block> children = block.getSubBlocks();
    boolean _isEmpty = children.isEmpty();
    if (_isEmpty) {
      return null;
    }
    final Block childBefore = children.get((newChildIndex - 1));
    boolean _isLeaf = childBefore.isLeaf();
    if (_isLeaf) {
      return this.getAfterChildIndent(childBefore);
    }
    List<Block> _subBlocks = childBefore.getSubBlocks();
    final int size = _subBlocks.size();
    return this.getChildIndent(childBefore, size);
  }
  
  protected Indent getAfterChildIndent(final Block block) {
    boolean _equals = Objects.equal(block, null);
    if (_equals) {
      return null;
    }
    EObject _grammarElement = this._blockExtension.getGrammarElement(block);
    final Indent grammarElementIndent = this.getIndentAfter(_grammarElement);
    boolean _notEquals = (!Objects.equal(grammarElementIndent, null));
    if (_notEquals) {
      return grammarElementIndent;
    }
    if ((block instanceof SyntheticXtextBlock)) {
      return ((SyntheticXtextBlock)block).getIndent();
    }
    boolean _isOpening = this._blockExtension.isOpening(block);
    if (_isOpening) {
      BracePair _bracePairForOpeningBrace = this._blockExtension.getBracePairForOpeningBrace(block);
      return this._blockExtension.getIndent(_bracePairForOpeningBrace, false);
    }
    return null;
  }
  
  protected Indent getIndentAfter(final EObject grammarElement) {
    return null;
  }
  
  protected Indent getBeforeChildIndent(final Block block) {
    boolean _equals = Objects.equal(block, null);
    if (_equals) {
      return null;
    }
    EObject _grammarElement = this._blockExtension.getGrammarElement(block);
    final Indent grammarElementIndent = this.getIndentBefore(_grammarElement);
    boolean _notEquals = (!Objects.equal(grammarElementIndent, null));
    if (_notEquals) {
      return grammarElementIndent;
    }
    if ((block instanceof SyntheticXtextBlock)) {
      return ((SyntheticXtextBlock)block).getIndent();
    }
    boolean _isClosing = this._blockExtension.isClosing(block);
    if (_isClosing) {
      BracePair _bracePairForClosingBrace = this._blockExtension.getBracePairForClosingBrace(block);
      return this._blockExtension.getIndent(_bracePairForClosingBrace, false);
    }
    return null;
  }
  
  protected Indent getIndentBefore(final EObject grammarElement) {
    return null;
  }
}

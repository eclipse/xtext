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
import com.google.inject.Injector;
import com.google.inject.Singleton;
import com.intellij.formatting.Block;
import com.intellij.formatting.Indent;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.lang.ASTNode;
import com.intellij.lang.Language;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.formatter.FormatterUtil;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.impl.source.tree.TreeUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.idea.formatting.BlockExtension;
import org.eclipse.xtext.idea.formatting.BlockFactory;
import org.eclipse.xtext.idea.formatting.DefaultXtextBlock;
import org.eclipse.xtext.idea.formatting.ModifiableBlock;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class DefaultBlockFactory implements BlockFactory {
  private final static char LINE_FEED = '\n';
  
  @Inject
  private Injector injector;
  
  @Inject
  @Extension
  private BlockExtension _blockExtension;
  
  @Override
  public Block createRootBlock(final PsiElement element, final CodeStyleSettings settings) {
    DefaultXtextBlock _xblockexpression = null;
    {
      ASTNode _node = element.getNode();
      final DefaultXtextBlock block = new DefaultXtextBlock(_node, null, null);
      this.injector.injectMembers(block);
      Language _language = element.getLanguage();
      SpacingBuilder _createSpacingBuilder = this.createSpacingBuilder(settings, _language);
      block.setSpacingBuilder(_createSpacingBuilder);
      _xblockexpression = block;
    }
    return _xblockexpression;
  }
  
  protected SpacingBuilder createSpacingBuilder(final CodeStyleSettings settings, final Language language) {
    return null;
  }
  
  @Override
  public DefaultXtextBlock createBlock(final ASTNode node, final Block parentBlock) {
    DefaultXtextBlock _xblockexpression = null;
    {
      boolean _isWhitespaceOrEmpty = FormatterUtil.isWhitespaceOrEmpty(node);
      if (_isWhitespaceOrEmpty) {
        return null;
      }
      final TextRange blockTextRange = this.createTextRange(node);
      if (((Objects.equal(blockTextRange, null) || blockTextRange.isEmpty()) || (!parentBlock.getTextRange().contains(blockTextRange)))) {
        return null;
      }
      SpacingBuilder _xifexpression = null;
      if ((parentBlock instanceof ModifiableBlock)) {
        _xifexpression = ((ModifiableBlock)parentBlock).getSpacingBuilder();
      }
      final SpacingBuilder spacingBuilder = _xifexpression;
      final DefaultXtextBlock block = new DefaultXtextBlock(node, null, null);
      this.injector.injectMembers(block);
      block.setTextRange(blockTextRange);
      block.setSpacingBuilder(spacingBuilder);
      block.setParentBlock(parentBlock);
      Indent _childIndent = this.getChildIndent(parentBlock, block);
      block.setIndent(_childIndent);
      _xblockexpression = block;
    }
    return _xblockexpression;
  }
  
  protected Indent getChildIndent(final Block parentBlock, final DefaultXtextBlock childBlock) {
    if ((this._blockExtension.isOpening(childBlock) || this._blockExtension.isClosing(childBlock))) {
      return Indent.getNoneIndent();
    }
    final EObject grammarElement = this._blockExtension.getGrammarElement(parentBlock);
    boolean _isContinuation = this.isContinuation(grammarElement);
    if (_isContinuation) {
      return Indent.getContinuationWithoutFirstIndent();
    }
    boolean _isStructural = this.isStructural(grammarElement);
    if (_isStructural) {
      boolean _isStructural_1 = this._blockExtension.isStructural(childBlock);
      if (_isStructural_1) {
        return Indent.getNoneIndent();
      } else {
        return Indent.getNormalIndent();
      }
    }
    return Indent.getNoneIndent();
  }
  
  protected boolean isContinuation(final EObject grammarElement) {
    return false;
  }
  
  protected boolean isStructural(final EObject grammarElement) {
    return false;
  }
  
  protected TextRange createTextRange(final ASTNode node) {
    TextRange _xblockexpression = null;
    {
      final TextRange textRange = node.getTextRange();
      if ((node instanceof PsiComment)) {
        final CharSequence chars = node.getChars();
        int _length = chars.length();
        int _minus = (_length - 1);
        char _charAt = chars.charAt(_minus);
        boolean _equals = (_charAt == DefaultBlockFactory.LINE_FEED);
        if (_equals) {
          int _startOffset = textRange.getStartOffset();
          int _endOffset = textRange.getEndOffset();
          int _minus_1 = (_endOffset - 1);
          return new TextRange(_startOffset, _minus_1);
        }
        return textRange;
      }
      ASTNode _firstChildNode = node.getFirstChildNode();
      boolean _equals_1 = Objects.equal(_firstChildNode, null);
      if (_equals_1) {
        return textRange;
      }
      LeafElement _findFirstLeaf = TreeUtil.findFirstLeaf(node);
      final Function1<ASTNode, ASTNode> _function = new Function1<ASTNode, ASTNode>() {
        @Override
        public ASTNode apply(final ASTNode it) {
          return TreeUtil.nextLeaf(it);
        }
      };
      final Function1<ASTNode, Boolean> _function_1 = new Function1<ASTNode, Boolean>() {
        @Override
        public Boolean apply(final ASTNode it) {
          return Boolean.valueOf(((!FormatterUtil.isWhitespaceOrEmpty(it)) || (!textRange.contains(it.getTextRange()))));
        }
      };
      final ASTNode firstNonHiddenLeafNode = this.findNode(_findFirstLeaf, _function, _function_1);
      if ((Objects.equal(firstNonHiddenLeafNode, null) || (!textRange.contains(firstNonHiddenLeafNode.getTextRange())))) {
        return null;
      }
      final int startOffset = firstNonHiddenLeafNode.getStartOffset();
      ASTNode _findLastLeaf = TreeUtil.findLastLeaf(node);
      final Function1<ASTNode, ASTNode> _function_2 = new Function1<ASTNode, ASTNode>() {
        @Override
        public ASTNode apply(final ASTNode it) {
          return TreeUtil.prevLeaf(it);
        }
      };
      final Function1<ASTNode, Boolean> _function_3 = new Function1<ASTNode, Boolean>() {
        @Override
        public Boolean apply(final ASTNode it) {
          boolean _isWhitespaceOrEmpty = FormatterUtil.isWhitespaceOrEmpty(it);
          return Boolean.valueOf((!_isWhitespaceOrEmpty));
        }
      };
      ASTNode _findNode = this.findNode(_findLastLeaf, _function_2, _function_3);
      TextRange _textRange = _findNode.getTextRange();
      final int endOffset = _textRange.getEndOffset();
      _xblockexpression = new TextRange(startOffset, endOffset);
    }
    return _xblockexpression;
  }
  
  protected ASTNode findNode(final ASTNode node, final Function1<? super ASTNode, ? extends ASTNode> provider, final Function1<? super ASTNode, ? extends Boolean> condition) {
    boolean _equals = Objects.equal(node, null);
    if (_equals) {
      return null;
    }
    Boolean _apply = condition.apply(node);
    if ((_apply).booleanValue()) {
      return node;
    }
    ASTNode _apply_1 = provider.apply(node);
    return this.findNode(_apply_1, provider, condition);
  }
}

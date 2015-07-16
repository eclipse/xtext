/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.formatting;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.google.common.collect.LinkedListMultimap;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.intellij.formatting.ASTBlock;
import com.intellij.formatting.Alignment;
import com.intellij.formatting.Block;
import com.intellij.formatting.ChildAttributes;
import com.intellij.formatting.Indent;
import com.intellij.formatting.Spacing;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.formatting.Wrap;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiComment;
import com.intellij.psi.formatter.FormatterUtil;
import com.intellij.psi.formatter.common.AbstractBlock;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.impl.source.tree.TreeUtil;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.ide.editor.bracketmatching.BracePair;
import org.eclipse.xtext.ide.editor.bracketmatching.IBracePairProvider;
import org.eclipse.xtext.idea.formatting.ModifiableBlock;
import org.eclipse.xtext.idea.formatting.SyntheticXtextBlock;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

/**
 * @author kosyakov - Initial contribution and API
 */
@SuppressWarnings("all")
public class DefaultXtextBlock extends AbstractBlock implements ModifiableBlock {
  private final static char LINE_FEED = '\n';
  
  @Accessors
  private TextRange textRange;
  
  @Accessors
  private Indent indent = Indent.getNoneIndent();
  
  @Accessors
  private SpacingBuilder spacingBuilder;
  
  @Inject
  private Injector injector;
  
  @Inject
  private IBracePairProvider bracePairProvider;
  
  public DefaultXtextBlock(final ASTNode node, final Wrap wrap, final Alignment alignment) {
    super(node, wrap, alignment);
  }
  
  @Override
  public TextRange getTextRange() {
    boolean _notEquals = (!Objects.equal(this.textRange, null));
    if (_notEquals) {
      return this.textRange;
    }
    return super.getTextRange();
  }
  
  @Override
  protected List<Block> buildChildren() {
    ASTNode[] _children = this.myNode.getChildren(null);
    final Function1<ASTNode, Boolean> _function = new Function1<ASTNode, Boolean>() {
      @Override
      public Boolean apply(final ASTNode it) {
        boolean _isWhitespaceOrEmpty = FormatterUtil.isWhitespaceOrEmpty(it);
        return Boolean.valueOf((!_isWhitespaceOrEmpty));
      }
    };
    Iterable<ASTNode> _filter = IterableExtensions.<ASTNode>filter(((Iterable<ASTNode>)Conversions.doWrapArray(_children)), _function);
    final Function1<ASTNode, Block> _function_1 = new Function1<ASTNode, Block>() {
      @Override
      public Block apply(final ASTNode it) {
        return DefaultXtextBlock.this.buildSubBlock(it);
      }
    };
    Iterable<Block> _map = IterableExtensions.<ASTNode, Block>map(_filter, _function_1);
    Iterable<Block> _filterNull = IterableExtensions.<Block>filterNull(_map);
    return this.group(_filterNull);
  }
  
  protected List<Block> group(final Iterable<Block> blocks) {
    LinkedList<Block> _xblockexpression = null;
    {
      final LinkedListMultimap<BracePair, Integer> openingBlockIndex = LinkedListMultimap.<BracePair, Integer>create();
      final LinkedList<Block> stack = CollectionLiterals.<Block>newLinkedList();
      for (final Block block : blocks) {
        {
          boolean _isOpening = this.isOpening(block);
          if (_isOpening) {
            ASTNode _node = this.getNode(block);
            final String openingBrace = _node.getText();
            Set<BracePair> _pairs = this.bracePairProvider.getPairs();
            final Function1<BracePair, Boolean> _function = new Function1<BracePair, Boolean>() {
              @Override
              public Boolean apply(final BracePair it) {
                String _leftBrace = it.getLeftBrace();
                return Boolean.valueOf(Objects.equal(_leftBrace, openingBrace));
              }
            };
            final BracePair bracePair = IterableExtensions.<BracePair>findFirst(_pairs, _function);
            int _size = stack.size();
            openingBlockIndex.put(bracePair, Integer.valueOf(_size));
          }
          boolean _isClosing = this.isClosing(block);
          if (_isClosing) {
            ASTNode _node_1 = this.getNode(block);
            final String closingBrace = _node_1.getText();
            Set<BracePair> _pairs_1 = this.bracePairProvider.getPairs();
            final Function1<BracePair, Boolean> _function_1 = new Function1<BracePair, Boolean>() {
              @Override
              public Boolean apply(final BracePair it) {
                String _rightBrace = it.getRightBrace();
                return Boolean.valueOf(Objects.equal(_rightBrace, closingBrace));
              }
            };
            final BracePair bracePair_1 = IterableExtensions.<BracePair>findFirst(_pairs_1, _function_1);
            List<Integer> _get = openingBlockIndex.get(bracePair_1);
            final Integer index = IterableExtensions.<Integer>last(_get);
            boolean _notEquals = (!Objects.equal(index, null));
            if (_notEquals) {
              openingBlockIndex.remove(bracePair_1, index);
              this.group(stack, index);
            }
          }
          stack.addLast(block);
        }
      }
      List<Integer> _values = openingBlockIndex.values();
      List<Integer> _sort = IterableExtensions.<Integer>sort(_values);
      List<Integer> _reverse = ListExtensions.<Integer>reverse(_sort);
      for (final Integer index : _reverse) {
        this.group(stack, index);
      }
      _xblockexpression = stack;
    }
    return _xblockexpression;
  }
  
  protected void group(final LinkedList<Block> stack, final Integer openingBlockIndex) {
    final LinkedList<Block> children = CollectionLiterals.<Block>newLinkedList();
    for (int i = (stack.size() - 1); (i > (openingBlockIndex).intValue()); i--) {
      Block _removeLast = stack.removeLast();
      children.addFirst(_removeLast);
    }
    boolean _isEmpty = children.isEmpty();
    boolean _not = (!_isEmpty);
    if (_not) {
      Indent _normalIndent = Indent.getNormalIndent();
      SyntheticXtextBlock _createGroup = this.createGroup(children, _normalIndent);
      stack.addLast(_createGroup);
    }
  }
  
  protected SyntheticXtextBlock createGroup(final Iterable<Block> children, final Indent indent) {
    SyntheticXtextBlock _xblockexpression = null;
    {
      final SyntheticXtextBlock groupBlock = new SyntheticXtextBlock();
      this.injector.injectMembers(this);
      groupBlock.setSpacingBuilder(this.spacingBuilder);
      List<Block> _children = groupBlock.getChildren();
      Iterables.<Block>addAll(_children, children);
      groupBlock.setIndent(indent);
      _xblockexpression = groupBlock;
    }
    return _xblockexpression;
  }
  
  protected Block buildSubBlock(final ASTNode node) {
    DefaultXtextBlock _xblockexpression = null;
    {
      final TextRange blockTextRange = this.createTextRange(node);
      boolean _or = false;
      boolean _or_1 = false;
      boolean _equals = Objects.equal(blockTextRange, null);
      if (_equals) {
        _or_1 = true;
      } else {
        boolean _isEmpty = blockTextRange.isEmpty();
        _or_1 = _isEmpty;
      }
      if (_or_1) {
        _or = true;
      } else {
        TextRange _textRange = this.getTextRange();
        boolean _contains = _textRange.contains(blockTextRange);
        boolean _not = (!_contains);
        _or = _not;
      }
      if (_or) {
        return null;
      }
      final DefaultXtextBlock block = new DefaultXtextBlock(node, null, null);
      this.injector.injectMembers(block);
      block.textRange = blockTextRange;
      block.spacingBuilder = this.spacingBuilder;
      _xblockexpression = block;
    }
    return _xblockexpression;
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
        boolean _equals = (_charAt == DefaultXtextBlock.LINE_FEED);
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
          boolean _or = false;
          boolean _isWhitespaceOrEmpty = FormatterUtil.isWhitespaceOrEmpty(it);
          boolean _not = (!_isWhitespaceOrEmpty);
          if (_not) {
            _or = true;
          } else {
            TextRange _textRange = it.getTextRange();
            boolean _contains = textRange.contains(_textRange);
            boolean _not_1 = (!_contains);
            _or = _not_1;
          }
          return Boolean.valueOf(_or);
        }
      };
      final ASTNode firstNonHiddenLeafNode = this.findNode(_findFirstLeaf, _function, _function_1);
      boolean _or = false;
      boolean _equals_2 = Objects.equal(firstNonHiddenLeafNode, null);
      if (_equals_2) {
        _or = true;
      } else {
        TextRange _textRange = firstNonHiddenLeafNode.getTextRange();
        boolean _contains = textRange.contains(_textRange);
        boolean _not = (!_contains);
        _or = _not;
      }
      if (_or) {
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
      TextRange _textRange_1 = _findNode.getTextRange();
      final int endOffset = _textRange_1.getEndOffset();
      _xblockexpression = new TextRange(startOffset, endOffset);
    }
    return _xblockexpression;
  }
  
  @Override
  public ChildAttributes getChildAttributes(final int newChildIndex) {
    final List<Block> children = this.getSubBlocks();
    boolean _isEmpty = children.isEmpty();
    if (_isEmpty) {
      Indent _noneIndent = Indent.getNoneIndent();
      return new ChildAttributes(_noneIndent, null);
    }
    Indent _xifexpression = null;
    int _size = children.size();
    boolean _greaterEqualsThan = (newChildIndex >= _size);
    if (_greaterEqualsThan) {
      Indent _xblockexpression = null;
      {
        int _size_1 = children.size();
        int _minus = (_size_1 - 1);
        final Block block = children.get(_minus);
        Indent _xifexpression_1 = null;
        boolean _or = false;
        boolean _or_1 = false;
        if ((block instanceof SyntheticXtextBlock)) {
          _or_1 = true;
        } else {
          boolean _isOpening = this.isOpening(block);
          _or_1 = _isOpening;
        }
        if (_or_1) {
          _or = true;
        } else {
          boolean _isBetween = this.isBetween(block);
          _or = _isBetween;
        }
        if (_or) {
          _xifexpression_1 = Indent.getNormalIndent();
        }
        _xblockexpression = _xifexpression_1;
      }
      _xifexpression = _xblockexpression;
    } else {
      Indent _xblockexpression_1 = null;
      {
        final Block block = children.get(newChildIndex);
        Indent _xifexpression_1 = null;
        boolean _or = false;
        boolean _or_1 = false;
        if ((block instanceof SyntheticXtextBlock)) {
          _or_1 = true;
        } else {
          boolean _isClosing = this.isClosing(block);
          _or_1 = _isClosing;
        }
        if (_or_1) {
          _or = true;
        } else {
          boolean _isBetween = this.isBetween(block);
          _or = _isBetween;
        }
        if (_or) {
          _xifexpression_1 = Indent.getNormalIndent();
        }
        _xblockexpression_1 = _xifexpression_1;
      }
      _xifexpression = _xblockexpression_1;
    }
    final Indent indent = _xifexpression;
    Indent _elvis = null;
    if (indent != null) {
      _elvis = indent;
    } else {
      Indent _noneIndent_1 = Indent.getNoneIndent();
      _elvis = _noneIndent_1;
    }
    return new ChildAttributes(_elvis, null);
  }
  
  protected ASTNode getNode(final Block block) {
    ASTNode _xifexpression = null;
    if ((block instanceof ASTBlock)) {
      _xifexpression = ((ASTBlock)block).getNode();
    }
    return _xifexpression;
  }
  
  protected boolean isOpening(final Block block) {
    boolean _xifexpression = false;
    if ((block instanceof ASTBlock)) {
      ASTNode _node = ((ASTBlock)block).getNode();
      _xifexpression = this.isOpening(_node);
    }
    return _xifexpression;
  }
  
  protected boolean isClosing(final Block block) {
    boolean _xifexpression = false;
    if ((block instanceof ASTBlock)) {
      ASTNode _node = ((ASTBlock)block).getNode();
      _xifexpression = this.isClosing(_node);
    }
    return _xifexpression;
  }
  
  protected boolean isBetween(final Block block) {
    boolean _xifexpression = false;
    if ((block instanceof ASTBlock)) {
      ASTNode _node = ((ASTBlock)block).getNode();
      _xifexpression = this.isBetween(_node);
    }
    return _xifexpression;
  }
  
  protected boolean isOpening(final ASTNode node) {
    boolean _xblockexpression = false;
    {
      boolean _equals = Objects.equal(node, null);
      if (_equals) {
        return false;
      }
      final String text = node.getText();
      Set<BracePair> _pairs = this.bracePairProvider.getPairs();
      final Function1<BracePair, Boolean> _function = new Function1<BracePair, Boolean>() {
        @Override
        public Boolean apply(final BracePair it) {
          String _leftBrace = it.getLeftBrace();
          return Boolean.valueOf(Objects.equal(text, _leftBrace));
        }
      };
      _xblockexpression = IterableExtensions.<BracePair>exists(_pairs, _function);
    }
    return _xblockexpression;
  }
  
  protected boolean isBetween(final ASTNode node) {
    boolean _xblockexpression = false;
    {
      boolean _or = false;
      boolean _or_1 = false;
      boolean _equals = Objects.equal(node, null);
      if (_equals) {
        _or_1 = true;
      } else {
        boolean _isOpening = this.isOpening(node);
        _or_1 = _isOpening;
      }
      if (_or_1) {
        _or = true;
      } else {
        boolean _isClosing = this.isClosing(node);
        _or = _isClosing;
      }
      if (_or) {
        return false;
      }
      Set<BracePair> _pairs = this.bracePairProvider.getPairs();
      final Function1<BracePair, Boolean> _function = new Function1<BracePair, Boolean>() {
        @Override
        public Boolean apply(final BracePair bracePair) {
          return Boolean.valueOf(DefaultXtextBlock.this.isBetween(node, bracePair));
        }
      };
      _xblockexpression = IterableExtensions.<BracePair>exists(_pairs, _function);
    }
    return _xblockexpression;
  }
  
  protected boolean isBetween(final ASTNode node, final BracePair bracePair) {
    boolean _xblockexpression = false;
    {
      ASTNode _treePrev = node.getTreePrev();
      final Function1<ASTNode, ASTNode> _function = new Function1<ASTNode, ASTNode>() {
        @Override
        public ASTNode apply(final ASTNode it) {
          return it.getTreePrev();
        }
      };
      final Function1<ASTNode, Boolean> _function_1 = new Function1<ASTNode, Boolean>() {
        @Override
        public Boolean apply(final ASTNode it) {
          boolean _or = false;
          String _text = it.getText();
          String _leftBrace = bracePair.getLeftBrace();
          boolean _equals = Objects.equal(_text, _leftBrace);
          if (_equals) {
            _or = true;
          } else {
            String _text_1 = it.getText();
            String _rightBrace = bracePair.getRightBrace();
            boolean _equals_1 = Objects.equal(_text_1, _rightBrace);
            _or = _equals_1;
          }
          return Boolean.valueOf(_or);
        }
      };
      final ASTNode foundNode = this.findNode(_treePrev, _function, _function_1);
      boolean _and = false;
      boolean _notEquals = (!Objects.equal(foundNode, null));
      if (!_notEquals) {
        _and = false;
      } else {
        String _text = foundNode.getText();
        String _leftBrace = bracePair.getLeftBrace();
        boolean _equals = Objects.equal(_text, _leftBrace);
        _and = _equals;
      }
      _xblockexpression = _and;
    }
    return _xblockexpression;
  }
  
  protected boolean isClosing(final ASTNode node) {
    boolean _xblockexpression = false;
    {
      boolean _equals = Objects.equal(node, null);
      if (_equals) {
        return false;
      }
      final String text = node.getText();
      Set<BracePair> _pairs = this.bracePairProvider.getPairs();
      final Function1<BracePair, Boolean> _function = new Function1<BracePair, Boolean>() {
        @Override
        public Boolean apply(final BracePair it) {
          String _rightBrace = it.getRightBrace();
          return Boolean.valueOf(Objects.equal(text, _rightBrace));
        }
      };
      _xblockexpression = IterableExtensions.<BracePair>exists(_pairs, _function);
    }
    return _xblockexpression;
  }
  
  @Override
  public boolean isLeaf() {
    ASTNode _firstChildNode = this.myNode.getFirstChildNode();
    return Objects.equal(_firstChildNode, null);
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
  
  @Override
  public Spacing getSpacing(final Block child1, final Block child2) {
    return this.spacingBuilder.getSpacing(this, child1, child2);
  }
  
  public void setTextRange(final TextRange textRange) {
    this.textRange = textRange;
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
}

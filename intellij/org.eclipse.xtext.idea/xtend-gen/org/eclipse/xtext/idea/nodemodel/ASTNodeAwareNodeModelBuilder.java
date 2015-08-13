/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.nodemodel;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.tree.IElementType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.idea.nodemodel.IASTNodeAwareNodeModelBuilder;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.AbstractNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.impl.NodeModelBuilder;
import org.eclipse.xtext.nodemodel.impl.RootNode;
import org.eclipse.xtext.parser.antlr.TokenTool;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class ASTNodeAwareNodeModelBuilder extends NodeModelBuilder implements IASTNodeAwareNodeModelBuilder {
  @Inject
  private IGrammarAccess grammarAccess;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final Map<ASTNode, INode> nodesMapping = CollectionLiterals.<ASTNode, INode>newHashMap();
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private final Map<INode, List<ASTNode>> reverseNodesMapping = CollectionLiterals.<INode, List<ASTNode>>newHashMap();
  
  protected void associate(final ASTNode astNode, final INode node) {
    this.nodesMapping.put(astNode, node);
    List<ASTNode> _elvis = null;
    List<ASTNode> _get = this.reverseNodesMapping.get(node);
    if (_get != null) {
      _elvis = _get;
    } else {
      ArrayList<ASTNode> _xblockexpression = null;
      {
        final ArrayList<ASTNode> result = CollectionLiterals.<ASTNode>newArrayList();
        this.reverseNodesMapping.put(node, result);
        _xblockexpression = result;
      }
      _elvis = _xblockexpression;
    }
    final List<ASTNode> reverseMapping = _elvis;
    reverseMapping.add(astNode);
  }
  
  protected void replaceAssociations(final INode oldNode, final INode newNode) {
    final List<ASTNode> mapping = this.reverseNodesMapping.remove(oldNode);
    boolean _notEquals = (!Objects.equal(mapping, null));
    if (_notEquals) {
      for (final ASTNode astNode : mapping) {
        this.associate(astNode, newNode);
      }
    }
  }
  
  @Override
  protected void replaceByRootNode(final CompositeNode oldNode, final RootNode rootNode) {
    this.replaceAssociations(oldNode, rootNode);
    final INode firstChild = rootNode.getFirstChild();
    super.replaceByRootNode(oldNode, rootNode);
    boolean _notEquals = (!Objects.equal(firstChild, oldNode));
    if (_notEquals) {
      this.replaceAssociations(firstChild, oldNode);
    }
    this.replaceAssociations(oldNode, rootNode);
  }
  
  @Override
  protected void replaceChildren(final AbstractNode oldNode, final AbstractNode newNode) {
    super.replaceChildren(oldNode, newNode);
    this.replaceAssociations(oldNode, newNode);
  }
  
  @Override
  public ILeafNode newLeafNode(final LeafElement it, final EObject grammarElement, final ICompositeNode parent) {
    ILeafNode _xblockexpression = null;
    {
      int _startOffset = it.getStartOffset();
      int _textLength = it.getTextLength();
      final ILeafNode leafNode = this.newLeafNode(_startOffset, _textLength, grammarElement, false, null, parent);
      this.associate(it, leafNode);
      _xblockexpression = leafNode;
    }
    return _xblockexpression;
  }
  
  @Override
  public ILeafNode newLeafNode(final ASTNode it, final ICompositeNode parent) {
    ILeafNode _xblockexpression = null;
    {
      final IElementType elementType = it.getElementType();
      EObject _xifexpression = null;
      if ((elementType instanceof IGrammarAwareElementType)) {
        _xifexpression = ((IGrammarAwareElementType)elementType).getGrammarElement();
      } else {
        AbstractRule _xblockexpression_1 = null;
        {
          final IElementType tokenType = it.<IElementType>getUserData(IASTNodeAwareNodeModelBuilder.TOKEN_TYPE_KEY);
          AbstractRule _xifexpression_1 = null;
          boolean _notEquals = (!Objects.equal(tokenType, null));
          if (_notEquals) {
            AbstractRule _xblockexpression_2 = null;
            {
              final String tokenName = tokenType.toString();
              AbstractRule _xifexpression_2 = null;
              boolean _isLexerRule = TokenTool.isLexerRule(tokenName);
              if (_isLexerRule) {
                AbstractRule _xblockexpression_3 = null;
                {
                  final String ruleName = TokenTool.getLexerRuleName(tokenName);
                  Grammar _grammar = this.grammarAccess.getGrammar();
                  _xblockexpression_3 = GrammarUtil.findRuleForName(_grammar, ruleName);
                }
                _xifexpression_2 = _xblockexpression_3;
              }
              _xblockexpression_2 = _xifexpression_2;
            }
            _xifexpression_1 = _xblockexpression_2;
          }
          _xblockexpression_1 = _xifexpression_1;
        }
        _xifexpression = _xblockexpression_1;
      }
      final EObject grammarElement = _xifexpression;
      Boolean _elvis = null;
      Boolean _userData = it.<Boolean>getUserData(IASTNodeAwareNodeModelBuilder.HIDDEN_KEY);
      if (_userData != null) {
        _elvis = _userData;
      } else {
        _elvis = Boolean.valueOf(false);
      }
      final Boolean hidden = _elvis;
      int _startOffset = it.getStartOffset();
      int _textLength = it.getTextLength();
      final ILeafNode leafNode = this.newLeafNode(_startOffset, _textLength, grammarElement, (hidden).booleanValue(), null, parent);
      this.associate(it, leafNode);
      _xblockexpression = leafNode;
    }
    return _xblockexpression;
  }
  
  @Override
  public ICompositeNode newCompositeNode(final CompositeElement it, final ICompositeNode parent) {
    ICompositeNode _xblockexpression = null;
    {
      final IElementType elementType = it.getElementType();
      ICompositeNode _xifexpression = null;
      if ((elementType instanceof IGrammarAwareElementType)) {
        ICompositeNode _xblockexpression_1 = null;
        {
          final EObject grammarElement = ((IGrammarAwareElementType)elementType).getGrammarElement();
          final Integer lookAhead = it.<Integer>getUserData(IASTNodeAwareNodeModelBuilder.LOOK_AHEAD_KEY);
          final ICompositeNode compositeNode = this.newCompositeNode(grammarElement, (lookAhead).intValue(), parent);
          this.associate(it, compositeNode);
          _xblockexpression_1 = compositeNode;
        }
        _xifexpression = _xblockexpression_1;
      } else {
        throw new IllegalStateException(("Composite element with unexpected element type: " + it));
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  @Override
  public ICompositeNode newCompositeNodeAsParentOf(final CompositeElement it, final EObject grammarElement, final int lookahead, final ICompositeNode existing) {
    ICompositeNode _xblockexpression = null;
    {
      final ICompositeNode compositeNode = this.newCompositeNodeAsParentOf(grammarElement, lookahead, existing);
      this.associate(it, compositeNode);
      _xblockexpression = compositeNode;
    }
    return _xblockexpression;
  }
  
  @Pure
  public Map<ASTNode, INode> getNodesMapping() {
    return this.nodesMapping;
  }
  
  @Pure
  public Map<INode, List<ASTNode>> getReverseNodesMapping() {
    return this.reverseNodesMapping;
  }
}

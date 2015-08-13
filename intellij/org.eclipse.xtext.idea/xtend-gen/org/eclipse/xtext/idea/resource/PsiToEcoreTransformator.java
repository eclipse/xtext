/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.idea.resource;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.intellij.lang.ASTNode;
import com.intellij.lang.FileASTNode;
import com.intellij.psi.PsiErrorElement;
import com.intellij.psi.impl.source.tree.CompositeElement;
import com.intellij.psi.impl.source.tree.LeafElement;
import com.intellij.psi.tree.IElementType;
import java.io.Reader;
import java.util.Arrays;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.lib.annotations.AccessorType;
import org.eclipse.xtend.lib.annotations.Accessors;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.EnumRule;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.RuleNames;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.idea.lang.GrammarAwarePsiErrorElement;
import org.eclipse.xtext.idea.resource.PsiToEcoreAdapter;
import org.eclipse.xtext.idea.resource.PsiToEcoreTransformationContext;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.parser.IParseResult;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.parser.ParseResult;
import org.eclipse.xtext.parser.impl.DatatypeRuleToken;
import org.eclipse.xtext.psi.impl.BaseXtextFile;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;
import org.eclipse.xtext.util.ReplaceRegion;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.Pure;

@SuppressWarnings("all")
public class PsiToEcoreTransformator implements IParser {
  @Accessors(AccessorType.PUBLIC_SETTER)
  private BaseXtextFile xtextFile;
  
  @Inject
  @Extension
  private RuleNames ruleNames;
  
  @Accessors(AccessorType.PUBLIC_GETTER)
  private PsiToEcoreAdapter adapter;
  
  @Inject
  @Extension
  private PsiToEcoreTransformationContext.PsiToEcoreTransformationContextProvider _psiToEcoreTransformationContextProvider;
  
  @Override
  public IParseResult parse(final Reader reader) {
    ParseResult _xblockexpression = null;
    {
      final PsiToEcoreTransformationContext transformationContext = this.transform();
      PsiToEcoreAdapter _psiToEcoreAdapter = new PsiToEcoreAdapter(transformationContext);
      this.adapter = _psiToEcoreAdapter;
      final EObject rootAstElement = transformationContext.getCurrent();
      final ICompositeNode rootNode = transformationContext.getCurrentNode();
      final boolean hadErrors = transformationContext.isHadErrors();
      _xblockexpression = new ParseResult(rootAstElement, rootNode, hadErrors);
    }
    return _xblockexpression;
  }
  
  protected PsiToEcoreTransformationContext transform() {
    PsiToEcoreTransformationContext _xblockexpression = null;
    {
      final PsiToEcoreTransformationContext transformationContext = this._psiToEcoreTransformationContextProvider.newTransformationContext(this.xtextFile);
      FileASTNode _node = this.xtextFile.getNode();
      ASTNode[] _children = _node.getChildren(null);
      for (final ASTNode child : _children) {
        this.transformNode(child, transformationContext);
      }
      _xblockexpression = transformationContext;
    }
    return _xblockexpression;
  }
  
  protected void _transformNode(final ASTNode it, @Extension final PsiToEcoreTransformationContext transformationContext) {
    throw new IllegalStateException(("Unexpected ast node: " + it));
  }
  
  protected void _transformNode(final LeafElement it, @Extension final PsiToEcoreTransformationContext transformationContext) {
    final IElementType elementType = it.getElementType();
    if ((elementType instanceof IGrammarAwareElementType)) {
      EObject _grammarElement = ((IGrammarAwareElementType)elementType).getGrammarElement();
      this.transform(it, _grammarElement, ((IGrammarAwareElementType)elementType), transformationContext);
    } else {
      transformationContext.newLeafNode(it);
    }
  }
  
  protected void _transformNode(final CompositeElement it, @Extension final PsiToEcoreTransformationContext transformationContext) {
    boolean _matched = false;
    if (!_matched) {
      if (it instanceof GrammarAwarePsiErrorElement) {
        _matched=true;
        EObject _grammarElement = ((GrammarAwarePsiErrorElement)it).getGrammarElement();
        transformationContext.ensureModelElementCreated(_grammarElement);
      }
    }
    if (!_matched) {
      if (it instanceof PsiErrorElement) {
        _matched=true;
        this.transformChildren(it, transformationContext);
        transformationContext.appendSyntaxError(((PsiErrorElement)it));
      }
    }
    if (!_matched) {
      {
        final IElementType elementType = it.getElementType();
        if ((elementType instanceof IGrammarAwareElementType)) {
          EObject _grammarElement = ((IGrammarAwareElementType)elementType).getGrammarElement();
          this.transform(it, _grammarElement, ((IGrammarAwareElementType)elementType), transformationContext);
        }
      }
    }
  }
  
  protected void _transform(final ASTNode it, final EObject grammarElement, final IGrammarAwareElementType elementType, @Extension final PsiToEcoreTransformationContext transformationContext) {
    throw new IllegalStateException(((("Unexpected grammar element: " + grammarElement) + ", for node: ") + it));
  }
  
  protected void _transform(final LeafElement it, final EnumLiteralDeclaration enumLiteralDeclaration, final IGrammarAwareElementType elementType, @Extension final PsiToEcoreTransformationContext transformationContext) {
    EEnumLiteral _enumLiteral = enumLiteralDeclaration.getEnumLiteral();
    Enumerator _instance = _enumLiteral.getInstance();
    transformationContext.setEnumerator(_instance);
    Keyword _literal = enumLiteralDeclaration.getLiteral();
    String _value = _literal.getValue();
    transformationContext.newLeafNode(it, enumLiteralDeclaration, _value);
  }
  
  protected void _transform(final LeafElement it, final Keyword keyword, final IGrammarAwareElementType elementType, @Extension final PsiToEcoreTransformationContext transformationContext) {
    String _value = keyword.getValue();
    transformationContext.newLeafNode(it, keyword, _value);
  }
  
  protected void _transform(final LeafElement it, final RuleCall ruleCall, final IGrammarAwareElementType elementType, @Extension final PsiToEcoreTransformationContext transformationContext) {
    AbstractRule _rule = ruleCall.getRule();
    final AbstractRule rule = _rule;
    boolean _matched = false;
    if (!_matched) {
      if (rule instanceof TerminalRule) {
        _matched=true;
        String _qualifiedName = this.ruleNames.getQualifiedName(rule);
        transformationContext.newLeafNode(it, ruleCall, _qualifiedName);
      }
    }
    if (!_matched) {
      throw new IllegalStateException(("Unexpected rule: " + rule));
    }
  }
  
  protected void _transform(final CompositeElement it, final ParserRule rule, final IGrammarAwareElementType elementType, @Extension final PsiToEcoreTransformationContext transformationContext) {
    transformationContext.newCompositeNode(it);
    this.transformChildren(it, transformationContext);
    transformationContext.compress();
  }
  
  protected void _transform(final CompositeElement it, final Action action, final IGrammarAwareElementType elementType, @Extension final PsiToEcoreTransformationContext transformationContext) {
    boolean _isInFragmentRule = elementType.isInFragmentRule();
    if (_isInFragmentRule) {
      transformationContext.setCreateModelInParentNode(true);
      final PsiToEcoreTransformationContext actionTransformationContext = transformationContext.branch();
      this.transformActionLeftElement(it, action, actionTransformationContext);
      transformationContext.sync(actionTransformationContext);
      final RuleCall actionRuleCall = actionTransformationContext.getActionRuleCall();
      boolean _ensureModelElementCreated = transformationContext.ensureModelElementCreated(actionRuleCall);
      if (_ensureModelElementCreated) {
        boolean _and = false;
        EObject _current = transformationContext.getCurrent();
        boolean _tripleNotEquals = (_current != null);
        if (!_tripleNotEquals) {
          _and = false;
        } else {
          EObject _current_1 = transformationContext.getCurrent();
          EObject _eContainer = _current_1.eContainer();
          boolean _tripleEquals = (_eContainer == null);
          _and = _tripleEquals;
        }
        if (_and) {
          EObject _current_2 = transformationContext.getCurrent();
          actionTransformationContext.assign(_current_2, action);
        } else {
          EObject _current_3 = actionTransformationContext.getCurrent();
          AbstractRule _rule = actionRuleCall.getRule();
          String _qualifiedName = this.ruleNames.getQualifiedName(_rule);
          transformationContext.assign(_current_3, actionRuleCall, _qualifiedName);
        }
      }
      transformationContext.merge(actionTransformationContext, true);
      transformationContext.compress();
    } else {
      transformationContext.setCreateModelInParentNode(false);
      final PsiToEcoreTransformationContext actionTransformationContext_1 = transformationContext.branch();
      this.transformActionLeftElement(it, action, actionTransformationContext_1);
      transformationContext.sync(actionTransformationContext_1);
      final RuleCall actionRuleCall_1 = actionTransformationContext_1.getActionRuleCall();
      boolean _ensureModelElementCreated_1 = transformationContext.ensureModelElementCreated(actionRuleCall_1);
      if (_ensureModelElementCreated_1) {
        EObject _current_4 = actionTransformationContext_1.getCurrent();
        AbstractRule _rule_1 = actionRuleCall_1.getRule();
        String _qualifiedName_1 = this.ruleNames.getQualifiedName(_rule_1);
        transformationContext.assign(_current_4, actionRuleCall_1, _qualifiedName_1);
      }
      transformationContext.merge(actionTransformationContext_1);
      transformationContext.compress();
    }
  }
  
  protected void _transformFirstNoneActionChild(final ASTNode it, @Extension final PsiToEcoreTransformationContext transformationContext) {
    throw new IllegalStateException(("Unexpected ast node: " + it));
  }
  
  protected void _transformFirstNoneActionChild(final LeafElement it, @Extension final PsiToEcoreTransformationContext transformationContext) {
    final IElementType elementType = it.getElementType();
    if ((elementType instanceof IGrammarAwareElementType)) {
      EObject _grammarElement = ((IGrammarAwareElementType)elementType).getGrammarElement();
      this.transform(it, _grammarElement, ((IGrammarAwareElementType)elementType), transformationContext);
    } else {
      transformationContext.newLeafNode(it);
    }
  }
  
  protected void _transformFirstNoneActionChild(final CompositeElement it, @Extension final PsiToEcoreTransformationContext transformationContext) {
    boolean _matched = false;
    if (!_matched) {
      if (it instanceof GrammarAwarePsiErrorElement) {
        _matched=true;
        EObject _grammarElement = ((GrammarAwarePsiErrorElement)it).getGrammarElement();
        transformationContext.ensureModelElementCreated(_grammarElement);
      }
    }
    if (!_matched) {
      if (it instanceof PsiErrorElement) {
        _matched=true;
        this.transformChildren(it, transformationContext);
        transformationContext.appendSyntaxError(((PsiErrorElement)it));
      }
    }
    if (!_matched) {
      {
        final IElementType elementType = it.getElementType();
        if ((elementType instanceof IGrammarAwareElementType)) {
          EObject _grammarElement = ((IGrammarAwareElementType)elementType).getGrammarElement();
          this.transformFirstNoneActionChild(it, _grammarElement, ((IGrammarAwareElementType)elementType), transformationContext);
        }
      }
    }
  }
  
  protected void _transformFirstNoneActionChild(final CompositeElement it, final EObject element, final IGrammarAwareElementType elementType, @Extension final PsiToEcoreTransformationContext transformationContext) {
    EClass _eClass = element.eClass();
    String _name = _eClass.getName();
    String _plus = ("Unexpected grammar element: " + _name);
    throw new IllegalStateException(_plus);
  }
  
  protected void _transformFirstNoneActionChild(final CompositeElement it, final Action action, final IGrammarAwareElementType elementType, @Extension final PsiToEcoreTransformationContext transformationContext) {
    ASTNode[] _children = it.getChildren(null);
    final ASTNode firstChild = IterableExtensions.<ASTNode>head(((Iterable<ASTNode>)Conversions.doWrapArray(_children)));
    this.transformFirstNoneActionChild(firstChild, transformationContext);
  }
  
  protected void _transformFirstNoneActionChild(final CompositeElement it, final AbstractElement action, final IGrammarAwareElementType elementType, @Extension final PsiToEcoreTransformationContext transformationContext) {
    this.transformNode(it, transformationContext);
  }
  
  protected void _transformFirstNoneActionChild(final CompositeElement it, final ParserRule rule, final IGrammarAwareElementType elementType, @Extension final PsiToEcoreTransformationContext transformationContext) {
    transformationContext.newCompositeNode(it);
    this.transformChildren(it, transformationContext);
  }
  
  protected void _transformActionLeftElementNode(final ASTNode it, @Extension final PsiToEcoreTransformationContext transformationContext) {
    throw new IllegalStateException(("Unexpected ast node: " + it));
  }
  
  protected void _transformActionLeftElementNode(final CompositeElement it, @Extension final PsiToEcoreTransformationContext transformationContext) {
    final IElementType elementType = it.getElementType();
    if ((elementType instanceof IGrammarAwareElementType)) {
      EObject _grammarElement = ((IGrammarAwareElementType)elementType).getGrammarElement();
      this.transformActionLeftElement(it, _grammarElement, transformationContext);
    }
  }
  
  protected void _transformActionLeftElement(final CompositeElement it, final EObject grammarElement, @Extension final PsiToEcoreTransformationContext transformationContext) {
    throw new IllegalStateException(((("Unexpected grammar element: " + grammarElement) + ", for node: ") + it));
  }
  
  protected void _transformActionLeftElement(final CompositeElement it, final ParserRule parserRule, @Extension final PsiToEcoreTransformationContext transformationContext) {
    transformationContext.newCompositeNode(it);
    this.transformChildren(it, transformationContext);
  }
  
  protected void _transformActionLeftElement(final CompositeElement it, final Action action, @Extension final PsiToEcoreTransformationContext transformationContext) {
    transformationContext.newCompositeNode(it);
    transformationContext.ensureModelElementCreated(action);
    final ASTNode[] children = it.getChildren(null);
    final ASTNode leftElement = IterableExtensions.<ASTNode>head(((Iterable<ASTNode>)Conversions.doWrapArray(children)));
    final PsiToEcoreTransformationContext leftElementTransformationContext = transformationContext.branch();
    this.transformActionLeftElementNode(leftElement, leftElementTransformationContext);
    PsiToEcoreTransformationContext _compress = leftElementTransformationContext.compress();
    transformationContext.sync(_compress);
    EObject _current = leftElementTransformationContext.getCurrent();
    transformationContext.assign(_current, action);
    RuleCall _actionRuleCall = leftElementTransformationContext.getActionRuleCall();
    transformationContext.setActionRuleCall(_actionRuleCall);
    Iterable<ASTNode> _tail = IterableExtensions.<ASTNode>tail(((Iterable<ASTNode>)Conversions.doWrapArray(children)));
    this.transformChildren(_tail, transformationContext);
  }
  
  protected void _transformActionLeftElement(final CompositeElement it, final RuleCall ruleCall, @Extension final PsiToEcoreTransformationContext transformationContext) {
    transformationContext.newCompositeNode(it);
    transformationContext.setActionRuleCall(ruleCall);
    this.transformChildren(it, transformationContext);
  }
  
  protected void _transform(final CompositeElement it, final RuleCall ruleCall, final IGrammarAwareElementType elementType, @Extension final PsiToEcoreTransformationContext transformationContext) {
    AbstractRule _rule = ruleCall.getRule();
    final AbstractRule rule = _rule;
    boolean _matched = false;
    if (!_matched) {
      if (rule instanceof ParserRule) {
        boolean _isDatatypeRule = GrammarUtil.isDatatypeRule(((ParserRule)rule));
        if (_isDatatypeRule) {
          _matched=true;
          transformationContext.newCompositeNode(it);
          PsiToEcoreTransformationContext _branch = transformationContext.branch();
          final PsiToEcoreTransformationContext childTransformationContext = _branch.withDatatypeRule();
          PsiToEcoreTransformationContext _transformChildren = this.transformChildren(it, childTransformationContext);
          transformationContext.sync(_transformChildren);
          boolean _ensureModelElementCreated = transformationContext.ensureModelElementCreated(ruleCall);
          if (_ensureModelElementCreated) {
            final DatatypeRuleToken datatypeRuleToken = childTransformationContext.getDatatypeRuleToken();
            String _qualifiedName = this.ruleNames.getQualifiedName(rule);
            transformationContext.assign(datatypeRuleToken, ruleCall, _qualifiedName);
          }
          transformationContext.merge(childTransformationContext);
          transformationContext.compress();
        }
      }
    }
    if (!_matched) {
      if (rule instanceof ParserRule) {
        boolean _isFragment = ((ParserRule)rule).isFragment();
        if (_isFragment) {
          _matched=true;
          transformationContext.ensureModelElementCreated(ruleCall);
          transformationContext.newCompositeNode(it);
          final PsiToEcoreTransformationContext childTransformationContext = transformationContext.branchAndKeepCurrent();
          PsiToEcoreTransformationContext _transformChildren = this.transformChildren(it, childTransformationContext);
          transformationContext.sync(_transformChildren);
          transformationContext.merge(childTransformationContext);
          transformationContext.compress();
        }
      }
    }
    if (!_matched) {
      if (rule instanceof EnumRule) {
        _matched=true;
      }
      if (!_matched) {
        if (rule instanceof ParserRule) {
          _matched=true;
        }
      }
      if (_matched) {
        transformationContext.newCompositeNode(it);
        final PsiToEcoreTransformationContext childTransformationContext = transformationContext.branch();
        PsiToEcoreTransformationContext _transformChildren = this.transformChildren(it, childTransformationContext);
        transformationContext.sync(_transformChildren);
        boolean _ensureModelElementCreated = transformationContext.ensureModelElementCreated(ruleCall);
        if (_ensureModelElementCreated) {
          Object _xifexpression = null;
          if ((rule instanceof ParserRule)) {
            _xifexpression = childTransformationContext.getCurrent();
          } else {
            _xifexpression = childTransformationContext.getEnumerator();
          }
          final Object child = _xifexpression;
          boolean _notEquals = (!Objects.equal(child, null));
          if (_notEquals) {
            String _qualifiedName = this.ruleNames.getQualifiedName(rule);
            transformationContext.assign(child, ruleCall, _qualifiedName);
          }
        }
        transformationContext.merge(childTransformationContext);
        transformationContext.compress();
      }
    }
    if (!_matched) {
      throw new IllegalStateException(("Unexpected rule: " + rule));
    }
  }
  
  protected void _transform(final LeafElement it, final CrossReference crossReference, final IGrammarAwareElementType elementType, @Extension final PsiToEcoreTransformationContext transformationContext) {
    transformationContext.ensureModelElementCreated(crossReference);
    transformationContext.newLeafNode(it);
  }
  
  protected void _transform(final CompositeElement it, final CrossReference crossReference, final IGrammarAwareElementType elementType, @Extension final PsiToEcoreTransformationContext transformationContext) {
    transformationContext.newCompositeNode(it);
    transformationContext.ensureModelElementCreated(crossReference);
    this.transformChildren(it, transformationContext);
    transformationContext.compress();
  }
  
  protected PsiToEcoreTransformationContext transformChildren(final CompositeElement it, @Extension final PsiToEcoreTransformationContext transformationContext) {
    PsiToEcoreTransformationContext _xblockexpression = null;
    {
      final ASTNode[] children = it.getChildren(null);
      _xblockexpression = this.transformChildren(((Iterable<ASTNode>)Conversions.doWrapArray(children)), transformationContext);
    }
    return _xblockexpression;
  }
  
  protected PsiToEcoreTransformationContext transformChildren(final Iterable<ASTNode> children, final PsiToEcoreTransformationContext transformationContext) {
    PsiToEcoreTransformationContext _xblockexpression = null;
    {
      for (final ASTNode child : children) {
        this.transformNode(child, transformationContext);
      }
      _xblockexpression = transformationContext;
    }
    return _xblockexpression;
  }
  
  @Override
  public IParseResult parse(final ParserRule rule, final Reader reader) {
    throw new UnsupportedOperationException("Unexpected invocation");
  }
  
  @Override
  public IParseResult parse(final RuleCall ruleCall, final Reader reader, final int initialLookAhead) {
    throw new UnsupportedOperationException("Unexpected invocation");
  }
  
  @Override
  public IParseResult reparse(final IParseResult previousParseResult, final ReplaceRegion replaceRegion) {
    throw new UnsupportedOperationException("Unexpected invocation");
  }
  
  protected void transformNode(final ASTNode it, final PsiToEcoreTransformationContext transformationContext) {
    if (it instanceof CompositeElement) {
      _transformNode((CompositeElement)it, transformationContext);
      return;
    } else if (it instanceof LeafElement) {
      _transformNode((LeafElement)it, transformationContext);
      return;
    } else if (it != null) {
      _transformNode(it, transformationContext);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, transformationContext).toString());
    }
  }
  
  protected void transform(final ASTNode it, final EObject action, final IGrammarAwareElementType elementType, final PsiToEcoreTransformationContext transformationContext) {
    if (it instanceof CompositeElement
         && action instanceof Action) {
      _transform((CompositeElement)it, (Action)action, elementType, transformationContext);
      return;
    } else if (it instanceof CompositeElement
         && action instanceof CrossReference) {
      _transform((CompositeElement)it, (CrossReference)action, elementType, transformationContext);
      return;
    } else if (it instanceof CompositeElement
         && action instanceof ParserRule) {
      _transform((CompositeElement)it, (ParserRule)action, elementType, transformationContext);
      return;
    } else if (it instanceof CompositeElement
         && action instanceof RuleCall) {
      _transform((CompositeElement)it, (RuleCall)action, elementType, transformationContext);
      return;
    } else if (it instanceof LeafElement
         && action instanceof CrossReference) {
      _transform((LeafElement)it, (CrossReference)action, elementType, transformationContext);
      return;
    } else if (it instanceof LeafElement
         && action instanceof EnumLiteralDeclaration) {
      _transform((LeafElement)it, (EnumLiteralDeclaration)action, elementType, transformationContext);
      return;
    } else if (it instanceof LeafElement
         && action instanceof Keyword) {
      _transform((LeafElement)it, (Keyword)action, elementType, transformationContext);
      return;
    } else if (it instanceof LeafElement
         && action instanceof RuleCall) {
      _transform((LeafElement)it, (RuleCall)action, elementType, transformationContext);
      return;
    } else if (it != null
         && action != null) {
      _transform(it, action, elementType, transformationContext);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, action, elementType, transformationContext).toString());
    }
  }
  
  protected void transformFirstNoneActionChild(final ASTNode it, final PsiToEcoreTransformationContext transformationContext) {
    if (it instanceof CompositeElement) {
      _transformFirstNoneActionChild((CompositeElement)it, transformationContext);
      return;
    } else if (it instanceof LeafElement) {
      _transformFirstNoneActionChild((LeafElement)it, transformationContext);
      return;
    } else if (it != null) {
      _transformFirstNoneActionChild(it, transformationContext);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, transformationContext).toString());
    }
  }
  
  protected void transformFirstNoneActionChild(final CompositeElement it, final EObject action, final IGrammarAwareElementType elementType, final PsiToEcoreTransformationContext transformationContext) {
    if (action instanceof Action) {
      _transformFirstNoneActionChild(it, (Action)action, elementType, transformationContext);
      return;
    } else if (action instanceof ParserRule) {
      _transformFirstNoneActionChild(it, (ParserRule)action, elementType, transformationContext);
      return;
    } else if (action instanceof AbstractElement) {
      _transformFirstNoneActionChild(it, (AbstractElement)action, elementType, transformationContext);
      return;
    } else if (action != null) {
      _transformFirstNoneActionChild(it, action, elementType, transformationContext);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, action, elementType, transformationContext).toString());
    }
  }
  
  protected void transformActionLeftElementNode(final ASTNode it, final PsiToEcoreTransformationContext transformationContext) {
    if (it instanceof CompositeElement) {
      _transformActionLeftElementNode((CompositeElement)it, transformationContext);
      return;
    } else if (it != null) {
      _transformActionLeftElementNode(it, transformationContext);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, transformationContext).toString());
    }
  }
  
  protected void transformActionLeftElement(final CompositeElement it, final EObject action, final PsiToEcoreTransformationContext transformationContext) {
    if (action instanceof Action) {
      _transformActionLeftElement(it, (Action)action, transformationContext);
      return;
    } else if (action instanceof ParserRule) {
      _transformActionLeftElement(it, (ParserRule)action, transformationContext);
      return;
    } else if (action instanceof RuleCall) {
      _transformActionLeftElement(it, (RuleCall)action, transformationContext);
      return;
    } else if (action != null) {
      _transformActionLeftElement(it, action, transformationContext);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(it, action, transformationContext).toString());
    }
  }
  
  public void setXtextFile(final BaseXtextFile xtextFile) {
    this.xtextFile = xtextFile;
  }
  
  @Pure
  public PsiToEcoreAdapter getAdapter() {
    return this.adapter;
  }
}

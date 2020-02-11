/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.xbase.ide.contentassist;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.inject.Inject;
import java.util.Arrays;
import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.common.types.TypesPackage;
import org.eclipse.xtext.common.types.descriptions.ITypeDescriptor;
import org.eclipse.xtext.ide.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ide.editor.contentassist.IIdeContentProposalAcceptor;
import org.eclipse.xtext.ide.editor.contentassist.IdeContentProposalProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.xbase.XAbstractFeatureCall;
import org.eclipse.xtext.xbase.XAssignment;
import org.eclipse.xtext.xbase.XBasicForLoopExpression;
import org.eclipse.xtext.xbase.XBinaryOperation;
import org.eclipse.xtext.xbase.XBlockExpression;
import org.eclipse.xtext.xbase.XClosure;
import org.eclipse.xtext.xbase.XExpression;
import org.eclipse.xtext.xbase.XFeatureCall;
import org.eclipse.xtext.xbase.XMemberFeatureCall;
import org.eclipse.xtext.xbase.XbasePackage;
import org.eclipse.xtext.xbase.ide.contentassist.IIdeTypesProposalProvider;
import org.eclipse.xtext.xbase.ide.contentassist.TypeFilters;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.scoping.SyntaxFilteredScopes;
import org.eclipse.xtext.xbase.scoping.batch.IIdentifiableElementDescription;
import org.eclipse.xtext.xbase.scoping.featurecalls.OperatorMapping;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;
import org.eclipse.xtext.xbase.typesystem.IBatchTypeResolver;
import org.eclipse.xtext.xbase.typesystem.IExpressionScope;
import org.eclipse.xtext.xbase.typesystem.IResolvedTypes;
import org.eclipse.xtext.xbase.typesystem.references.LightweightTypeReference;
import org.eclipse.xtext.xtype.XtypePackage;

@SuppressWarnings("all")
public class XbaseIdeContentProposalProvider extends IdeContentProposalProvider {
  public static class ValidFeatureDescription implements Predicate<IEObjectDescription> {
    @Inject
    private OperatorMapping operatorMapping;
    
    @Override
    public boolean apply(final IEObjectDescription input) {
      if ((input instanceof IIdentifiableElementDescription)) {
        if (((!((IIdentifiableElementDescription)input).isVisible()) || (!((IIdentifiableElementDescription)input).isValidStaticState()))) {
          return false;
        }
        boolean _startsWith = ((IIdentifiableElementDescription)input).getName().getFirstSegment().startsWith("operator_");
        if (_startsWith) {
          QualifiedName _operator = this.operatorMapping.getOperator(((IIdentifiableElementDescription)input).getName());
          return (_operator == null);
        }
      }
      return true;
    }
  }
  
  @Inject
  @Extension
  private XbaseGrammarAccess _xbaseGrammarAccess;
  
  @Inject
  private XbaseIdeContentProposalProvider.ValidFeatureDescription featureDescriptionPredicate;
  
  @Inject
  private IBatchTypeResolver typeResolver;
  
  @Inject
  private IIdeTypesProposalProvider typesProposalProvider;
  
  @Inject
  private SyntaxFilteredScopes syntaxFilteredScopes;
  
  @Override
  public boolean filterKeyword(final Keyword keyword, final ContentAssistContext context) {
    final String value = keyword.getValue();
    if (((value.length() > 1) && Character.isLetter(value.charAt(0)))) {
      if ((Objects.equal(value, "as") || Objects.equal(value, "instanceof"))) {
        final EObject previousModel = context.getPreviousModel();
        if ((previousModel instanceof XExpression)) {
          if (((context.getPrefix().length() == 0) && (NodeModelUtils.getNode(previousModel).getEndOffset() > context.getOffset()))) {
            return false;
          }
          final LightweightTypeReference type = this.typeResolver.resolveTypes(previousModel).getActualType(((XExpression)previousModel));
          if (((type == null) || type.isPrimitiveVoid())) {
            return false;
          }
        }
      }
      return true;
    }
    return false;
  }
  
  @Override
  protected void _createProposals(final RuleCall ruleCall, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    AbstractRule _rule = ruleCall.getRule();
    boolean _matched = false;
    ParserRule _xExpressionRule = this._xbaseGrammarAccess.getXExpressionRule();
    if (Objects.equal(_rule, _xExpressionRule)) {
      _matched=true;
      if (((ruleCall.eContainer() instanceof Group) && Objects.equal(GrammarUtil.containingRule(ruleCall).getName(), "XParenthesizedExpression"))) {
        this.createLocalVariableAndImplicitProposals(context.getCurrentModel(), IExpressionScope.Anchor.WITHIN, context, acceptor);
      }
    }
    if (!_matched) {
      super._createProposals(ruleCall, context, acceptor);
    }
  }
  
  @Override
  protected void _createProposals(final Assignment assignment, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    final EObject model = context.getCurrentModel();
    boolean _matched = false;
    Assignment _featureAssignment_2 = this._xbaseGrammarAccess.getXFeatureCallAccess().getFeatureAssignment_2();
    if (Objects.equal(assignment, _featureAssignment_2)) {
      _matched=true;
      this.completeXFeatureCall(model, context, acceptor);
    }
    if (!_matched) {
      Assignment _featureAssignment_1_0_0_0_2 = this._xbaseGrammarAccess.getXMemberFeatureCallAccess().getFeatureAssignment_1_0_0_0_2();
      if (Objects.equal(assignment, _featureAssignment_1_0_0_0_2)) {
        _matched=true;
      }
      if (!_matched) {
        Assignment _featureAssignment_1_1_2 = this._xbaseGrammarAccess.getXMemberFeatureCallAccess().getFeatureAssignment_1_1_2();
        if (Objects.equal(assignment, _featureAssignment_1_1_2)) {
          _matched=true;
        }
      }
      if (_matched) {
        this.completeXMemberFeatureCall(model, assignment, context, acceptor);
      }
    }
    if (!_matched) {
      Assignment _expressionsAssignment_2_0 = this._xbaseGrammarAccess.getXBlockExpressionAccess().getExpressionsAssignment_2_0();
      if (Objects.equal(assignment, _expressionsAssignment_2_0)) {
        _matched=true;
      }
      if (!_matched) {
        Assignment _expressionsAssignment_1_0 = this._xbaseGrammarAccess.getXExpressionInClosureAccess().getExpressionsAssignment_1_0();
        if (Objects.equal(assignment, _expressionsAssignment_1_0)) {
          _matched=true;
        }
      }
      if (_matched) {
        this.completeWithinBlock(model, context, acceptor);
      }
    }
    if (!_matched) {
      Assignment _featureAssignment_0_1 = this._xbaseGrammarAccess.getXAssignmentAccess().getFeatureAssignment_0_1();
      if (Objects.equal(assignment, _featureAssignment_0_1)) {
        _matched=true;
      }
      if (!_matched) {
        Assignment _featureAssignment_1_1_0_0_1 = this._xbaseGrammarAccess.getXAssignmentAccess().getFeatureAssignment_1_1_0_0_1();
        if (Objects.equal(assignment, _featureAssignment_1_1_0_0_1)) {
          _matched=true;
        }
      }
      if (_matched) {
        this.completeXAssignment(model, assignment, context, acceptor);
      }
    }
    if (!_matched) {
      Assignment _typeAssignment_0 = this._xbaseGrammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_0();
      if (Objects.equal(assignment, _typeAssignment_0)) {
        _matched=true;
      }
      if (!_matched) {
        Assignment _typeAssignment_1_4_1 = this._xbaseGrammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_1_4_1();
        if (Objects.equal(assignment, _typeAssignment_1_4_1)) {
          _matched=true;
        }
      }
      if (_matched) {
        this.completeJavaTypes(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, context, acceptor);
      }
    }
    if (!_matched) {
      Assignment _typeAssignment_1_0_1 = this._xbaseGrammarAccess.getXRelationalExpressionAccess().getTypeAssignment_1_0_1();
      if (Objects.equal(assignment, _typeAssignment_1_0_1)) {
        _matched=true;
        this.completeJavaTypes(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, context, acceptor);
      }
    }
    if (!_matched) {
      Assignment _importedTypeAssignment_1_0_2 = this._xbaseGrammarAccess.getXImportDeclarationAccess().getImportedTypeAssignment_1_0_2();
      if (Objects.equal(assignment, _importedTypeAssignment_1_0_2)) {
        _matched=true;
      }
      if (!_matched) {
        Assignment _importedTypeAssignment_1_1 = this._xbaseGrammarAccess.getXImportDeclarationAccess().getImportedTypeAssignment_1_1();
        if (Objects.equal(assignment, _importedTypeAssignment_1_1)) {
          _matched=true;
        }
      }
      if (_matched) {
        this.completeJavaTypes(XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE, context, acceptor);
      }
    }
    if (!_matched) {
      Assignment _typeAssignment_3 = this._xbaseGrammarAccess.getXTypeLiteralAccess().getTypeAssignment_3();
      if (Objects.equal(assignment, _typeAssignment_3)) {
        _matched=true;
        this.completeJavaTypes(XbasePackage.Literals.XTYPE_LITERAL__TYPE, context, acceptor);
      }
    }
    if (!_matched) {
      Assignment _constructorAssignment_2 = this._xbaseGrammarAccess.getXConstructorCallAccess().getConstructorAssignment_2();
      if (Objects.equal(assignment, _constructorAssignment_2)) {
        _matched=true;
        this.completeJavaTypes(TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, context, 
          TypeFilters.NON_ABSTRACT, acceptor);
      }
    }
    if (!_matched) {
      Assignment _eachExpressionAssignment_3 = this._xbaseGrammarAccess.getXForLoopExpressionAccess().getEachExpressionAssignment_3();
      if (Objects.equal(assignment, _eachExpressionAssignment_3)) {
        _matched=true;
      }
      if (!_matched) {
        Assignment _defaultAssignment_5_2 = this._xbaseGrammarAccess.getXSwitchExpressionAccess().getDefaultAssignment_5_2();
        if (Objects.equal(assignment, _defaultAssignment_5_2)) {
          _matched=true;
        }
      }
      if (!_matched) {
        Assignment _caseAssignment_2_1 = this._xbaseGrammarAccess.getXCasePartAccess().getCaseAssignment_2_1();
        if (Objects.equal(assignment, _caseAssignment_2_1)) {
          _matched=true;
        }
      }
      if (!_matched) {
        Assignment _expressionAssignment_4 = this._xbaseGrammarAccess.getXCatchClauseAccess().getExpressionAssignment_4();
        if (Objects.equal(assignment, _expressionAssignment_4)) {
          _matched=true;
        }
      }
      if (!_matched) {
        Assignment _updateExpressionsAssignment_7_0 = this._xbaseGrammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsAssignment_7_0();
        if (Objects.equal(assignment, _updateExpressionsAssignment_7_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        Assignment _updateExpressionsAssignment_7_1_1 = this._xbaseGrammarAccess.getXBasicForLoopExpressionAccess().getUpdateExpressionsAssignment_7_1_1();
        if (Objects.equal(assignment, _updateExpressionsAssignment_7_1_1)) {
          _matched=true;
        }
      }
      if (!_matched) {
        Assignment _expressionAssignment_5 = this._xbaseGrammarAccess.getXBasicForLoopExpressionAccess().getExpressionAssignment_5();
        if (Objects.equal(assignment, _expressionAssignment_5)) {
          _matched=true;
        }
      }
      if (!_matched) {
        Assignment _eachExpressionAssignment_9 = this._xbaseGrammarAccess.getXBasicForLoopExpressionAccess().getEachExpressionAssignment_9();
        if (Objects.equal(assignment, _eachExpressionAssignment_9)) {
          _matched=true;
        }
      }
      if (!_matched) {
        Assignment _expressionAssignment_2 = this._xbaseGrammarAccess.getXClosureAccess().getExpressionAssignment_2();
        if (Objects.equal(assignment, _expressionAssignment_2)) {
          _matched=true;
        }
      }
      if (!_matched) {
        Assignment _expressionAssignment_1 = this._xbaseGrammarAccess.getXShortClosureAccess().getExpressionAssignment_1();
        if (Objects.equal(assignment, _expressionAssignment_1)) {
          _matched=true;
        }
      }
      if (_matched) {
        this.createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.WITHIN, context, acceptor);
      }
    }
    if (!_matched) {
      Assignment _forExpressionAssignment_1 = this._xbaseGrammarAccess.getXForLoopExpressionAccess().getForExpressionAssignment_1();
      if (Objects.equal(assignment, _forExpressionAssignment_1)) {
        _matched=true;
      }
      if (!_matched) {
        Assignment _rightAssignment_3_1 = this._xbaseGrammarAccess.getXVariableDeclarationAccess().getRightAssignment_3_1();
        if (Objects.equal(assignment, _rightAssignment_3_1)) {
          _matched=true;
        }
      }
      if (_matched) {
        this.createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.BEFORE, context, acceptor);
      }
    }
    if (!_matched) {
      Assignment _thenAssignment_3_0_1 = this._xbaseGrammarAccess.getXCasePartAccess().getThenAssignment_3_0_1();
      if (Objects.equal(assignment, _thenAssignment_3_0_1)) {
        _matched=true;
        this.createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.AFTER, context, acceptor);
      }
    }
    if (!_matched) {
      Assignment _featureAssignment_1_0_0_1 = this._xbaseGrammarAccess.getXOrExpressionAccess().getFeatureAssignment_1_0_0_1();
      if (Objects.equal(assignment, _featureAssignment_1_0_0_1)) {
        _matched=true;
      }
      if (!_matched) {
        Assignment _featureAssignment_1_0_0_1_1 = this._xbaseGrammarAccess.getXAndExpressionAccess().getFeatureAssignment_1_0_0_1();
        if (Objects.equal(assignment, _featureAssignment_1_0_0_1_1)) {
          _matched=true;
        }
      }
      if (!_matched) {
        Assignment _featureAssignment_1_0_0_1_2 = this._xbaseGrammarAccess.getXEqualityExpressionAccess().getFeatureAssignment_1_0_0_1();
        if (Objects.equal(assignment, _featureAssignment_1_0_0_1_2)) {
          _matched=true;
        }
      }
      if (!_matched) {
        Assignment _featureAssignment_1_1_0_0_1_1 = this._xbaseGrammarAccess.getXRelationalExpressionAccess().getFeatureAssignment_1_1_0_0_1();
        if (Objects.equal(assignment, _featureAssignment_1_1_0_0_1_1)) {
          _matched=true;
        }
      }
      if (!_matched) {
        Assignment _featureAssignment_1_0_0_1_3 = this._xbaseGrammarAccess.getXOtherOperatorExpressionAccess().getFeatureAssignment_1_0_0_1();
        if (Objects.equal(assignment, _featureAssignment_1_0_0_1_3)) {
          _matched=true;
        }
      }
      if (!_matched) {
        Assignment _featureAssignment_1_0_0_1_4 = this._xbaseGrammarAccess.getXAdditiveExpressionAccess().getFeatureAssignment_1_0_0_1();
        if (Objects.equal(assignment, _featureAssignment_1_0_0_1_4)) {
          _matched=true;
        }
      }
      if (!_matched) {
        Assignment _featureAssignment_1_0_0_1_5 = this._xbaseGrammarAccess.getXMultiplicativeExpressionAccess().getFeatureAssignment_1_0_0_1();
        if (Objects.equal(assignment, _featureAssignment_1_0_0_1_5)) {
          _matched=true;
        }
      }
      if (!_matched) {
        Assignment _featureAssignment_1_0_1 = this._xbaseGrammarAccess.getXPostfixOperationAccess().getFeatureAssignment_1_0_1();
        if (Objects.equal(assignment, _featureAssignment_1_0_1)) {
          _matched=true;
        }
      }
      if (_matched) {
        this.completeBinaryOperation(model, assignment, context, acceptor);
      }
    }
    if (!_matched) {
      Assignment _initExpressionsAssignment_3_0 = this._xbaseGrammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsAssignment_3_0();
      if (Objects.equal(assignment, _initExpressionsAssignment_3_0)) {
        _matched=true;
      }
      if (!_matched) {
        Assignment _initExpressionsAssignment_3_1_1 = this._xbaseGrammarAccess.getXBasicForLoopExpressionAccess().getInitExpressionsAssignment_3_1_1();
        if (Objects.equal(assignment, _initExpressionsAssignment_3_1_1)) {
          _matched=true;
        }
      }
      if (_matched) {
        this.completeXBasicForLoopInit(model, context, acceptor);
      }
    }
    if (!_matched) {
      Assignment _featureAssignment_0_1_1 = this._xbaseGrammarAccess.getXUnaryOperationAccess().getFeatureAssignment_0_1();
      if (Objects.equal(assignment, _featureAssignment_0_1_1)) {
        _matched=true;
      }
    }
    if (!_matched) {
      super._createProposals(assignment, context, acceptor);
    }
  }
  
  protected void completeJavaTypes(final EReference reference, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    this.completeJavaTypes(reference, context, Predicates.<ITypeDescriptor>alwaysTrue(), acceptor);
  }
  
  protected void completeJavaTypes(final EReference reference, final ContentAssistContext context, final Predicate<? super ITypeDescriptor> filter, final IIdeContentProposalAcceptor acceptor) {
    this.typesProposalProvider.createTypeProposals(reference, context, filter, acceptor);
  }
  
  protected void completeXFeatureCall(final EObject model, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    if ((model != null)) {
      boolean _hasExpressionScope = this.typeResolver.resolveTypes(model).hasExpressionScope(model, IExpressionScope.Anchor.WITHIN);
      if (_hasExpressionScope) {
        return;
      }
    }
    if ((model instanceof XMemberFeatureCall)) {
      final ICompositeNode node = NodeModelUtils.getNode(model);
      boolean _isInMemberFeatureCall = this.isInMemberFeatureCall(model, node.getEndOffset(), context);
      if (_isInMemberFeatureCall) {
        return;
      }
    }
    this.createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.AFTER, context, acceptor);
  }
  
  protected void completeWithinBlock(final EObject model, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    final ICompositeNode node = NodeModelUtils.getNode(model);
    int _offset = node.getOffset();
    int _offset_1 = context.getOffset();
    boolean _greaterEqualsThan = (_offset >= _offset_1);
    if (_greaterEqualsThan) {
      this.createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.BEFORE, context, acceptor);
      return;
    }
    if ((model instanceof XBlockExpression)) {
      final EList<XExpression> children = ((XBlockExpression)model).getExpressions();
      for (int i = (children.size() - 1); (i >= 0); i--) {
        {
          final XExpression child = children.get(i);
          final ICompositeNode childNode = NodeModelUtils.getNode(child);
          int _endOffset = childNode.getEndOffset();
          int _offset_2 = context.getOffset();
          boolean _lessEqualsThan = (_endOffset <= _offset_2);
          if (_lessEqualsThan) {
            this.createLocalVariableAndImplicitProposals(child, IExpressionScope.Anchor.AFTER, context, acceptor);
            return;
          }
        }
      }
    }
    int endOffset = node.getEndOffset();
    int _offset_2 = context.getOffset();
    boolean _lessEqualsThan = (endOffset <= _offset_2);
    if (_lessEqualsThan) {
      if ((((model instanceof XFeatureCall) && (model.eContainer() instanceof XClosure)) || 
        ((endOffset == context.getOffset()) && (context.getPrefix().length() == 0)))) {
        return;
      }
      boolean _isInMemberFeatureCall = this.isInMemberFeatureCall(model, endOffset, context);
      if (_isInMemberFeatureCall) {
        return;
      }
      this.createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.AFTER, context, acceptor);
      return;
    }
    if ((this.isInMemberFeatureCall(model, endOffset, context) || (model instanceof XClosure))) {
      return;
    }
    this.createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.BEFORE, context, acceptor);
  }
  
  protected boolean isInMemberFeatureCall(final EObject model, final int endOffset, final ContentAssistContext context) {
    if (((model instanceof XMemberFeatureCall) && (endOffset >= context.getOffset()))) {
      final List<INode> featureNodes = NodeModelUtils.findNodesForFeature(model, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
      boolean _isEmpty = featureNodes.isEmpty();
      boolean _not = (!_isEmpty);
      if (_not) {
        final INode featureNode = IterableExtensions.<INode>head(featureNodes);
        if (((featureNode.getTotalOffset() < context.getOffset()) && 
          (featureNode.getTotalEndOffset() >= context.getOffset()))) {
          return true;
        }
      }
    }
    return false;
  }
  
  protected void completeXAssignment(final EObject model, final Assignment assignment, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    final String ruleName = this.getConcreteSyntaxRuleName(assignment);
    boolean _isOperatorRule = this.isOperatorRule(ruleName);
    if (_isOperatorRule) {
      this.completeBinaryOperation(model, assignment, context, acceptor);
    }
  }
  
  protected boolean isOperatorRule(final String ruleName) {
    return ((ruleName != null) && ruleName.startsWith("Op"));
  }
  
  protected void completeBinaryOperation(final EObject model, final Assignment assignment, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    if ((model instanceof XBinaryOperation)) {
      int _length = context.getPrefix().length();
      boolean _tripleEquals = (_length == 0);
      if (_tripleEquals) {
        final INode currentNode = context.getCurrentNode();
        final int offset = currentNode.getOffset();
        final int endOffset = currentNode.getEndOffset();
        if ((((offset < context.getOffset()) && (endOffset >= context.getOffset())) && (currentNode.getGrammarElement() instanceof CrossReference))) {
          return;
        }
      }
      int _endOffset = NodeModelUtils.findActualNodeFor(model).getEndOffset();
      int _offset = context.getOffset();
      boolean _lessEqualsThan = (_endOffset <= _offset);
      if (_lessEqualsThan) {
        AbstractElement _terminal = assignment.getTerminal();
        this.createReceiverProposals(((XExpression) model), ((CrossReference) _terminal), context, acceptor);
      } else {
        AbstractElement _terminal_1 = assignment.getTerminal();
        this.createReceiverProposals(((XBinaryOperation)model).getLeftOperand(), 
          ((CrossReference) _terminal_1), context, acceptor);
      }
    } else {
      final EObject previousModel = context.getPreviousModel();
      if ((previousModel instanceof XExpression)) {
        if (((context.getPrefix().length() == 0) && (NodeModelUtils.getNode(previousModel).getEndOffset() > context.getOffset()))) {
          return;
        }
        AbstractElement _terminal_2 = assignment.getTerminal();
        this.createReceiverProposals(((XExpression)previousModel), 
          ((CrossReference) _terminal_2), context, acceptor);
      }
    }
  }
  
  protected void completeXBasicForLoopInit(final EObject model, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    final ICompositeNode node = NodeModelUtils.getNode(model);
    int _offset = node.getOffset();
    int _offset_1 = context.getOffset();
    boolean _greaterEqualsThan = (_offset >= _offset_1);
    if (_greaterEqualsThan) {
      this.createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.BEFORE, context, acceptor);
      return;
    }
    if ((model instanceof XBasicForLoopExpression)) {
      final EList<XExpression> children = ((XBasicForLoopExpression)model).getInitExpressions();
      for (int i = (children.size() - 1); (i >= 0); i--) {
        {
          final XExpression child = children.get(i);
          final ICompositeNode childNode = NodeModelUtils.getNode(child);
          int _endOffset = childNode.getEndOffset();
          int _offset_2 = context.getOffset();
          boolean _lessEqualsThan = (_endOffset <= _offset_2);
          if (_lessEqualsThan) {
            this.createLocalVariableAndImplicitProposals(child, IExpressionScope.Anchor.AFTER, context, acceptor);
            return;
          }
        }
      }
    }
    this.createLocalVariableAndImplicitProposals(model, IExpressionScope.Anchor.BEFORE, context, acceptor);
  }
  
  protected void completeXMemberFeatureCall(final EObject model, final Assignment assignment, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    if ((model instanceof XMemberFeatureCall)) {
      AbstractElement _terminal = assignment.getTerminal();
      this.createReceiverProposals(((XMemberFeatureCall)model).getMemberCallTarget(), 
        ((CrossReference) _terminal), context, acceptor);
    } else {
      if ((model instanceof XAssignment)) {
        AbstractElement _terminal_1 = assignment.getTerminal();
        this.createReceiverProposals(((XAssignment)model).getAssignable(), 
          ((CrossReference) _terminal_1), context, acceptor);
      }
    }
  }
  
  protected void createLocalVariableAndImplicitProposals(final EObject model, final IExpressionScope.Anchor anchor, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    String prefix = context.getPrefix();
    if (((prefix.length() > 0) && (!Character.isJavaIdentifierStart(prefix.charAt(0))))) {
      return;
    }
    IResolvedTypes _xifexpression = null;
    if ((model != null)) {
      _xifexpression = this.typeResolver.resolveTypes(model);
    } else {
      _xifexpression = this.typeResolver.resolveTypes(context.getResource());
    }
    final IResolvedTypes resolvedTypes = _xifexpression;
    final IExpressionScope expressionScope = resolvedTypes.getExpressionScope(model, anchor);
    final IScope scope = expressionScope.getFeatureScope();
    this.getCrossrefProposalProvider().lookupCrossReference(scope, this._xbaseGrammarAccess.getXFeatureCallAccess().getFeatureJvmIdentifiableElementCrossReference_2_0(), context, acceptor, this.featureDescriptionPredicate);
  }
  
  protected void createReceiverProposals(final XExpression receiver, final CrossReference crossReference, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    final IResolvedTypes resolvedTypes = this.typeResolver.resolveTypes(receiver);
    final LightweightTypeReference receiverType = resolvedTypes.getActualType(receiver);
    if (((receiverType == null) || receiverType.isPrimitiveVoid())) {
      return;
    }
    final IExpressionScope expressionScope = resolvedTypes.getExpressionScope(receiver, IExpressionScope.Anchor.RECEIVER);
    IScope scope = null;
    final EObject currentModel = context.getCurrentModel();
    if ((currentModel != receiver)) {
      if (((currentModel instanceof XMemberFeatureCall) && 
        (((XMemberFeatureCall) currentModel).getMemberCallTarget() == receiver))) {
        scope = this.syntaxFilteredScopes.create(expressionScope.getFeatureScope(((XAbstractFeatureCall) currentModel)), crossReference);
      } else {
        scope = this.syntaxFilteredScopes.create(expressionScope.getFeatureScope(), crossReference);
      }
    } else {
      scope = this.syntaxFilteredScopes.create(expressionScope.getFeatureScope(), crossReference);
    }
    this.getCrossrefProposalProvider().lookupCrossReference(scope, crossReference, context, acceptor, this.featureDescriptionPredicate);
  }
  
  protected String _getConcreteSyntaxRuleName(final Assignment assignment) {
    return this.getConcreteSyntaxRuleName(assignment.getTerminal());
  }
  
  protected String _getConcreteSyntaxRuleName(final CrossReference crossReference) {
    String _xifexpression = null;
    AbstractElement _terminal = crossReference.getTerminal();
    if ((_terminal instanceof RuleCall)) {
      _xifexpression = this.getConcreteSyntaxRuleName(crossReference.getTerminal());
    }
    return _xifexpression;
  }
  
  protected String _getConcreteSyntaxRuleName(final RuleCall ruleCall) {
    return ruleCall.getRule().getName();
  }
  
  @Override
  public void createProposals(final AbstractElement assignment, final ContentAssistContext context, final IIdeContentProposalAcceptor acceptor) {
    if (assignment instanceof Assignment) {
      _createProposals((Assignment)assignment, context, acceptor);
      return;
    } else if (assignment instanceof CrossReference) {
      _createProposals((CrossReference)assignment, context, acceptor);
      return;
    } else if (assignment instanceof Keyword) {
      _createProposals((Keyword)assignment, context, acceptor);
      return;
    } else if (assignment instanceof RuleCall) {
      _createProposals((RuleCall)assignment, context, acceptor);
      return;
    } else if (assignment != null) {
      _createProposals(assignment, context, acceptor);
      return;
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(assignment, context, acceptor).toString());
    }
  }
  
  protected String getConcreteSyntaxRuleName(final AbstractElement assignment) {
    if (assignment instanceof Assignment) {
      return _getConcreteSyntaxRuleName((Assignment)assignment);
    } else if (assignment instanceof CrossReference) {
      return _getConcreteSyntaxRuleName((CrossReference)assignment);
    } else if (assignment instanceof RuleCall) {
      return _getConcreteSyntaxRuleName((RuleCall)assignment);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(assignment).toString());
    }
  }
}

/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.xbase.idea.formatting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.intellij.formatting.SpacingBuilder;
import com.intellij.lang.Language;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import java.util.Collections;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.idea.formatting.DefaultBlockFactory;
import org.eclipse.xtext.idea.lang.IElementTypeProvider;
import org.eclipse.xtext.psi.tree.IGrammarAwareElementType;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class XbaseBlockFactory extends DefaultBlockFactory {
  @Inject
  @Extension
  private XbaseGrammarAccess _xbaseGrammarAccess;
  
  @Inject
  @Extension
  private IElementTypeProvider elementTypeProvider;
  
  @Override
  protected SpacingBuilder createSpacingBuilder(final CodeStyleSettings settings, final Language language) {
    SpacingBuilder _xblockexpression = null;
    {
      final SpacingBuilder spacingBuilder = new SpacingBuilder(settings, language);
      List<Pair<Keyword, Keyword>> _findKeywordPairs = this._xbaseGrammarAccess.findKeywordPairs("{", "}");
      final Function1<Pair<Keyword, Keyword>, org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType>> _function = new Function1<Pair<Keyword, Keyword>, org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType>>() {
        @Override
        public org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType> apply(final Pair<Keyword, Keyword> it) {
          Keyword _first = it.getFirst();
          IGrammarAwareElementType _findElementType = XbaseBlockFactory.this.elementTypeProvider.findElementType(_first);
          Keyword _second = it.getSecond();
          IGrammarAwareElementType _findElementType_1 = XbaseBlockFactory.this.elementTypeProvider.findElementType(_second);
          return org.eclipse.xtext.xbase.lib.Pair.<IGrammarAwareElementType, IGrammarAwareElementType>of(_findElementType, _findElementType_1);
        }
      };
      List<org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType>> _map = ListExtensions.<Pair<Keyword, Keyword>, org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType>>map(_findKeywordPairs, _function);
      for (final org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType> pair : _map) {
        {
          IGrammarAwareElementType _key = pair.getKey();
          SpacingBuilder.RuleBuilder _before = spacingBuilder.before(_key);
          _before.spaces(1);
          IGrammarAwareElementType _key_1 = pair.getKey();
          IGrammarAwareElementType _value = pair.getValue();
          SpacingBuilder.RuleBuilder _withinPair = spacingBuilder.withinPair(_key_1, _value);
          _withinPair.lineBreakInCode();
        }
      }
      List<Keyword> _findKeywords = this._xbaseGrammarAccess.findKeywords(((String[])Conversions.unwrapArray(Collections.<String>unmodifiableList(CollectionLiterals.<String>newArrayList(",")), String.class)));
      final Function1<Keyword, IGrammarAwareElementType> _function_1 = new Function1<Keyword, IGrammarAwareElementType>() {
        @Override
        public IGrammarAwareElementType apply(final Keyword it) {
          return XbaseBlockFactory.this.elementTypeProvider.findElementType(it);
        }
      };
      List<IGrammarAwareElementType> _map_1 = ListExtensions.<Keyword, IGrammarAwareElementType>map(_findKeywords, _function_1);
      for (final IGrammarAwareElementType commaType : _map_1) {
        {
          SpacingBuilder.RuleBuilder _before = spacingBuilder.before(commaType);
          _before.spaces(0);
          SpacingBuilder.RuleBuilder _after = spacingBuilder.after(commaType);
          _after.spaces(1);
        }
      }
      List<Pair<Keyword, Keyword>> _findKeywordPairs_1 = this._xbaseGrammarAccess.findKeywordPairs("(", ")");
      final Function1<Pair<Keyword, Keyword>, org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType>> _function_2 = new Function1<Pair<Keyword, Keyword>, org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType>>() {
        @Override
        public org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType> apply(final Pair<Keyword, Keyword> it) {
          Keyword _first = it.getFirst();
          IGrammarAwareElementType _findElementType = XbaseBlockFactory.this.elementTypeProvider.findElementType(_first);
          Keyword _second = it.getSecond();
          IGrammarAwareElementType _findElementType_1 = XbaseBlockFactory.this.elementTypeProvider.findElementType(_second);
          return org.eclipse.xtext.xbase.lib.Pair.<IGrammarAwareElementType, IGrammarAwareElementType>of(_findElementType, _findElementType_1);
        }
      };
      List<org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType>> _map_2 = ListExtensions.<Pair<Keyword, Keyword>, org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType>>map(_findKeywordPairs_1, _function_2);
      for (final org.eclipse.xtext.xbase.lib.Pair<IGrammarAwareElementType, IGrammarAwareElementType> pair_1 : _map_2) {
        {
          IGrammarAwareElementType _key = pair_1.getKey();
          IGrammarAwareElementType _value = pair_1.getValue();
          SpacingBuilder.RuleBuilder _withinPair = spacingBuilder.withinPair(_key, _value);
          _withinPair.none();
          IGrammarAwareElementType _key_1 = pair_1.getKey();
          SpacingBuilder.RuleBuilder _around = spacingBuilder.around(_key_1);
          _around.spaces(0);
          IGrammarAwareElementType _value_1 = pair_1.getValue();
          SpacingBuilder.RuleBuilder _before = spacingBuilder.before(_value_1);
          _before.spaces(0);
          IGrammarAwareElementType _value_2 = pair_1.getValue();
          SpacingBuilder.RuleBuilder _after = spacingBuilder.after(_value_2);
          _after.spaces(1);
        }
      }
      _xblockexpression = spacingBuilder;
    }
    return _xblockexpression;
  }
  
  @Override
  protected boolean isContinuation(final EObject grammarElement) {
    boolean _xblockexpression = false;
    {
      boolean _equals = Objects.equal(grammarElement, null);
      if (_equals) {
        return false;
      }
      boolean _switchResult = false;
      boolean _matched = false;
      XbaseGrammarAccess.XAssignmentElements _xAssignmentAccess = this._xbaseGrammarAccess.getXAssignmentAccess();
      Action _xAssignmentAction_0_0 = _xAssignmentAccess.getXAssignmentAction_0_0();
      if (Objects.equal(grammarElement, _xAssignmentAction_0_0)) {
        _matched=true;
      }
      if (!_matched) {
        XbaseGrammarAccess.XAssignmentElements _xAssignmentAccess_1 = this._xbaseGrammarAccess.getXAssignmentAccess();
        Action _xBinaryOperationLeftOperandAction_1_1_0_0_0 = _xAssignmentAccess_1.getXBinaryOperationLeftOperandAction_1_1_0_0_0();
        if (Objects.equal(grammarElement, _xBinaryOperationLeftOperandAction_1_1_0_0_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XOrExpressionElements _xOrExpressionAccess = this._xbaseGrammarAccess.getXOrExpressionAccess();
        Action _xBinaryOperationLeftOperandAction_1_0_0_0 = _xOrExpressionAccess.getXBinaryOperationLeftOperandAction_1_0_0_0();
        if (Objects.equal(grammarElement, _xBinaryOperationLeftOperandAction_1_0_0_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XAndExpressionElements _xAndExpressionAccess = this._xbaseGrammarAccess.getXAndExpressionAccess();
        Action _xBinaryOperationLeftOperandAction_1_0_0_0_1 = _xAndExpressionAccess.getXBinaryOperationLeftOperandAction_1_0_0_0();
        if (Objects.equal(grammarElement, _xBinaryOperationLeftOperandAction_1_0_0_0_1)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XEqualityExpressionElements _xEqualityExpressionAccess = this._xbaseGrammarAccess.getXEqualityExpressionAccess();
        Action _xBinaryOperationLeftOperandAction_1_0_0_0_2 = _xEqualityExpressionAccess.getXBinaryOperationLeftOperandAction_1_0_0_0();
        if (Objects.equal(grammarElement, _xBinaryOperationLeftOperandAction_1_0_0_0_2)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XRelationalExpressionElements _xRelationalExpressionAccess = this._xbaseGrammarAccess.getXRelationalExpressionAccess();
        Action _xInstanceOfExpressionExpressionAction_1_0_0_0_0 = _xRelationalExpressionAccess.getXInstanceOfExpressionExpressionAction_1_0_0_0_0();
        if (Objects.equal(grammarElement, _xInstanceOfExpressionExpressionAction_1_0_0_0_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XRelationalExpressionElements _xRelationalExpressionAccess_1 = this._xbaseGrammarAccess.getXRelationalExpressionAccess();
        Action _xBinaryOperationLeftOperandAction_1_1_0_0_0_1 = _xRelationalExpressionAccess_1.getXBinaryOperationLeftOperandAction_1_1_0_0_0();
        if (Objects.equal(grammarElement, _xBinaryOperationLeftOperandAction_1_1_0_0_0_1)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XOtherOperatorExpressionElements _xOtherOperatorExpressionAccess = this._xbaseGrammarAccess.getXOtherOperatorExpressionAccess();
        Action _xBinaryOperationLeftOperandAction_1_0_0_0_3 = _xOtherOperatorExpressionAccess.getXBinaryOperationLeftOperandAction_1_0_0_0();
        if (Objects.equal(grammarElement, _xBinaryOperationLeftOperandAction_1_0_0_0_3)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XAdditiveExpressionElements _xAdditiveExpressionAccess = this._xbaseGrammarAccess.getXAdditiveExpressionAccess();
        Action _xBinaryOperationLeftOperandAction_1_0_0_0_4 = _xAdditiveExpressionAccess.getXBinaryOperationLeftOperandAction_1_0_0_0();
        if (Objects.equal(grammarElement, _xBinaryOperationLeftOperandAction_1_0_0_0_4)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XMultiplicativeExpressionElements _xMultiplicativeExpressionAccess = this._xbaseGrammarAccess.getXMultiplicativeExpressionAccess();
        Action _xBinaryOperationLeftOperandAction_1_0_0_0_5 = _xMultiplicativeExpressionAccess.getXBinaryOperationLeftOperandAction_1_0_0_0();
        if (Objects.equal(grammarElement, _xBinaryOperationLeftOperandAction_1_0_0_0_5)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XUnaryOperationElements _xUnaryOperationAccess = this._xbaseGrammarAccess.getXUnaryOperationAccess();
        Action _xUnaryOperationAction_0_0 = _xUnaryOperationAccess.getXUnaryOperationAction_0_0();
        if (Objects.equal(grammarElement, _xUnaryOperationAction_0_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XCastedExpressionElements _xCastedExpressionAccess = this._xbaseGrammarAccess.getXCastedExpressionAccess();
        Action _xCastedExpressionTargetAction_1_0_0_0 = _xCastedExpressionAccess.getXCastedExpressionTargetAction_1_0_0_0();
        if (Objects.equal(grammarElement, _xCastedExpressionTargetAction_1_0_0_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XPostfixOperationElements _xPostfixOperationAccess = this._xbaseGrammarAccess.getXPostfixOperationAccess();
        Action _xPostfixOperationOperandAction_1_0_0 = _xPostfixOperationAccess.getXPostfixOperationOperandAction_1_0_0();
        if (Objects.equal(grammarElement, _xPostfixOperationOperandAction_1_0_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XMemberFeatureCallElements _xMemberFeatureCallAccess = this._xbaseGrammarAccess.getXMemberFeatureCallAccess();
        Action _xAssignmentAssignableAction_1_0_0_0_0 = _xMemberFeatureCallAccess.getXAssignmentAssignableAction_1_0_0_0_0();
        if (Objects.equal(grammarElement, _xAssignmentAssignableAction_1_0_0_0_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XShortClosureElements _xShortClosureAccess = this._xbaseGrammarAccess.getXShortClosureAccess();
        Action _xClosureAction_0_0_0 = _xShortClosureAccess.getXClosureAction_0_0_0();
        if (Objects.equal(grammarElement, _xClosureAction_0_0_0)) {
          _matched=true;
        }
      }
      if (_matched) {
        _switchResult = true;
      }
      if (!_matched) {
        _switchResult = false;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
  
  @Override
  protected boolean isStructural(final EObject grammarElement) {
    boolean _xblockexpression = false;
    {
      boolean _equals = Objects.equal(grammarElement, null);
      if (_equals) {
        return false;
      }
      boolean _switchResult = false;
      boolean _matched = false;
      XbaseGrammarAccess.XIfExpressionElements _xIfExpressionAccess = this._xbaseGrammarAccess.getXIfExpressionAccess();
      RuleCall _thenXExpressionParserRuleCall_5_0 = _xIfExpressionAccess.getThenXExpressionParserRuleCall_5_0();
      if (Objects.equal(grammarElement, _thenXExpressionParserRuleCall_5_0)) {
        _matched=true;
      }
      if (!_matched) {
        XbaseGrammarAccess.XIfExpressionElements _xIfExpressionAccess_1 = this._xbaseGrammarAccess.getXIfExpressionAccess();
        RuleCall _elseXExpressionParserRuleCall_6_1_0 = _xIfExpressionAccess_1.getElseXExpressionParserRuleCall_6_1_0();
        if (Objects.equal(grammarElement, _elseXExpressionParserRuleCall_6_1_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XSwitchExpressionElements _xSwitchExpressionAccess = this._xbaseGrammarAccess.getXSwitchExpressionAccess();
        RuleCall _defaultXExpressionParserRuleCall_5_2_0 = _xSwitchExpressionAccess.getDefaultXExpressionParserRuleCall_5_2_0();
        if (Objects.equal(grammarElement, _defaultXExpressionParserRuleCall_5_2_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XCasePartElements _xCasePartAccess = this._xbaseGrammarAccess.getXCasePartAccess();
        RuleCall _thenXExpressionParserRuleCall_3_0_1_0 = _xCasePartAccess.getThenXExpressionParserRuleCall_3_0_1_0();
        if (Objects.equal(grammarElement, _thenXExpressionParserRuleCall_3_0_1_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XForLoopExpressionElements _xForLoopExpressionAccess = this._xbaseGrammarAccess.getXForLoopExpressionAccess();
        RuleCall _eachExpressionXExpressionParserRuleCall_3_0 = _xForLoopExpressionAccess.getEachExpressionXExpressionParserRuleCall_3_0();
        if (Objects.equal(grammarElement, _eachExpressionXExpressionParserRuleCall_3_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XBasicForLoopExpressionElements _xBasicForLoopExpressionAccess = this._xbaseGrammarAccess.getXBasicForLoopExpressionAccess();
        RuleCall _eachExpressionXExpressionParserRuleCall_9_0 = _xBasicForLoopExpressionAccess.getEachExpressionXExpressionParserRuleCall_9_0();
        if (Objects.equal(grammarElement, _eachExpressionXExpressionParserRuleCall_9_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XWhileExpressionElements _xWhileExpressionAccess = this._xbaseGrammarAccess.getXWhileExpressionAccess();
        RuleCall _bodyXExpressionParserRuleCall_5_0 = _xWhileExpressionAccess.getBodyXExpressionParserRuleCall_5_0();
        if (Objects.equal(grammarElement, _bodyXExpressionParserRuleCall_5_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XDoWhileExpressionElements _xDoWhileExpressionAccess = this._xbaseGrammarAccess.getXDoWhileExpressionAccess();
        RuleCall _bodyXExpressionParserRuleCall_2_0 = _xDoWhileExpressionAccess.getBodyXExpressionParserRuleCall_2_0();
        if (Objects.equal(grammarElement, _bodyXExpressionParserRuleCall_2_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XVariableDeclarationElements _xVariableDeclarationAccess = this._xbaseGrammarAccess.getXVariableDeclarationAccess();
        RuleCall _rightXExpressionParserRuleCall_3_1_0 = _xVariableDeclarationAccess.getRightXExpressionParserRuleCall_3_1_0();
        if (Objects.equal(grammarElement, _rightXExpressionParserRuleCall_3_1_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XThrowExpressionElements _xThrowExpressionAccess = this._xbaseGrammarAccess.getXThrowExpressionAccess();
        RuleCall _expressionXExpressionParserRuleCall_2_0 = _xThrowExpressionAccess.getExpressionXExpressionParserRuleCall_2_0();
        if (Objects.equal(grammarElement, _expressionXExpressionParserRuleCall_2_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XReturnExpressionElements _xReturnExpressionAccess = this._xbaseGrammarAccess.getXReturnExpressionAccess();
        RuleCall _expressionXExpressionParserRuleCall_2_0_1 = _xReturnExpressionAccess.getExpressionXExpressionParserRuleCall_2_0();
        if (Objects.equal(grammarElement, _expressionXExpressionParserRuleCall_2_0_1)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XTryCatchFinallyExpressionElements _xTryCatchFinallyExpressionAccess = this._xbaseGrammarAccess.getXTryCatchFinallyExpressionAccess();
        RuleCall _expressionXExpressionParserRuleCall_2_0_2 = _xTryCatchFinallyExpressionAccess.getExpressionXExpressionParserRuleCall_2_0();
        if (Objects.equal(grammarElement, _expressionXExpressionParserRuleCall_2_0_2)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XTryCatchFinallyExpressionElements _xTryCatchFinallyExpressionAccess_1 = this._xbaseGrammarAccess.getXTryCatchFinallyExpressionAccess();
        RuleCall _finallyExpressionXExpressionParserRuleCall_3_0_1_1_0 = _xTryCatchFinallyExpressionAccess_1.getFinallyExpressionXExpressionParserRuleCall_3_0_1_1_0();
        if (Objects.equal(grammarElement, _finallyExpressionXExpressionParserRuleCall_3_0_1_1_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XTryCatchFinallyExpressionElements _xTryCatchFinallyExpressionAccess_2 = this._xbaseGrammarAccess.getXTryCatchFinallyExpressionAccess();
        RuleCall _finallyExpressionXExpressionParserRuleCall_3_1_1_0 = _xTryCatchFinallyExpressionAccess_2.getFinallyExpressionXExpressionParserRuleCall_3_1_1_0();
        if (Objects.equal(grammarElement, _finallyExpressionXExpressionParserRuleCall_3_1_1_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XCatchClauseElements _xCatchClauseAccess = this._xbaseGrammarAccess.getXCatchClauseAccess();
        RuleCall _expressionXExpressionParserRuleCall_4_0 = _xCatchClauseAccess.getExpressionXExpressionParserRuleCall_4_0();
        if (Objects.equal(grammarElement, _expressionXExpressionParserRuleCall_4_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XSynchronizedExpressionElements _xSynchronizedExpressionAccess = this._xbaseGrammarAccess.getXSynchronizedExpressionAccess();
        RuleCall _expressionXExpressionParserRuleCall_3_0 = _xSynchronizedExpressionAccess.getExpressionXExpressionParserRuleCall_3_0();
        if (Objects.equal(grammarElement, _expressionXExpressionParserRuleCall_3_0)) {
          _matched=true;
        }
      }
      if (_matched) {
        _switchResult = true;
      }
      if (!_matched) {
        _switchResult = false;
      }
      _xblockexpression = _switchResult;
    }
    return _xblockexpression;
  }
}

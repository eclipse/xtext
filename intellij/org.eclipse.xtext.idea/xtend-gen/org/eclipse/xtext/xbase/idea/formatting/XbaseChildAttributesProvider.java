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
import com.intellij.formatting.Indent;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.idea.formatting.DefaultChildAttributesProvider;
import org.eclipse.xtext.xbase.lib.Extension;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class XbaseChildAttributesProvider extends DefaultChildAttributesProvider {
  @Inject
  @Extension
  private XbaseGrammarAccess _xbaseGrammarAccess;
  
  @Override
  protected Indent getIndentAfter(final EObject grammarElement) {
    boolean _equals = Objects.equal(grammarElement, null);
    if (_equals) {
      return null;
    }
    boolean _matched = false;
    if (!_matched) {
      XbaseGrammarAccess.XSwitchExpressionElements _xSwitchExpressionAccess = this._xbaseGrammarAccess.getXSwitchExpressionAccess();
      Keyword _colonKeyword_5_1 = _xSwitchExpressionAccess.getColonKeyword_5_1();
      if (Objects.equal(grammarElement, _colonKeyword_5_1)) {
        _matched=true;
      }
      if (!_matched) {
        XbaseGrammarAccess.XReturnExpressionElements _xReturnExpressionAccess = this._xbaseGrammarAccess.getXReturnExpressionAccess();
        Keyword _returnKeyword_1 = _xReturnExpressionAccess.getReturnKeyword_1();
        if (Objects.equal(grammarElement, _returnKeyword_1)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XSynchronizedExpressionElements _xSynchronizedExpressionAccess = this._xbaseGrammarAccess.getXSynchronizedExpressionAccess();
        Keyword _rightParenthesisKeyword_2 = _xSynchronizedExpressionAccess.getRightParenthesisKeyword_2();
        if (Objects.equal(grammarElement, _rightParenthesisKeyword_2)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XForLoopExpressionElements _xForLoopExpressionAccess = this._xbaseGrammarAccess.getXForLoopExpressionAccess();
        Keyword _rightParenthesisKeyword_2_1 = _xForLoopExpressionAccess.getRightParenthesisKeyword_2();
        if (Objects.equal(grammarElement, _rightParenthesisKeyword_2_1)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XBasicForLoopExpressionElements _xBasicForLoopExpressionAccess = this._xbaseGrammarAccess.getXBasicForLoopExpressionAccess();
        Keyword _rightParenthesisKeyword_8 = _xBasicForLoopExpressionAccess.getRightParenthesisKeyword_8();
        if (Objects.equal(grammarElement, _rightParenthesisKeyword_8)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XWhileExpressionElements _xWhileExpressionAccess = this._xbaseGrammarAccess.getXWhileExpressionAccess();
        Keyword _rightParenthesisKeyword_4 = _xWhileExpressionAccess.getRightParenthesisKeyword_4();
        if (Objects.equal(grammarElement, _rightParenthesisKeyword_4)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XDoWhileExpressionElements _xDoWhileExpressionAccess = this._xbaseGrammarAccess.getXDoWhileExpressionAccess();
        Keyword _doKeyword_1 = _xDoWhileExpressionAccess.getDoKeyword_1();
        if (Objects.equal(grammarElement, _doKeyword_1)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XIfExpressionElements _xIfExpressionAccess = this._xbaseGrammarAccess.getXIfExpressionAccess();
        Keyword _rightParenthesisKeyword_4_1 = _xIfExpressionAccess.getRightParenthesisKeyword_4();
        if (Objects.equal(grammarElement, _rightParenthesisKeyword_4_1)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XIfExpressionElements _xIfExpressionAccess_1 = this._xbaseGrammarAccess.getXIfExpressionAccess();
        Keyword _elseKeyword_6_0 = _xIfExpressionAccess_1.getElseKeyword_6_0();
        if (Objects.equal(grammarElement, _elseKeyword_6_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XCasePartElements _xCasePartAccess = this._xbaseGrammarAccess.getXCasePartAccess();
        Keyword _colonKeyword_3_0_0 = _xCasePartAccess.getColonKeyword_3_0_0();
        if (Objects.equal(grammarElement, _colonKeyword_3_0_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XCatchClauseElements _xCatchClauseAccess = this._xbaseGrammarAccess.getXCatchClauseAccess();
        Keyword _rightParenthesisKeyword_3 = _xCatchClauseAccess.getRightParenthesisKeyword_3();
        if (Objects.equal(grammarElement, _rightParenthesisKeyword_3)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XThrowExpressionElements _xThrowExpressionAccess = this._xbaseGrammarAccess.getXThrowExpressionAccess();
        Keyword _throwKeyword_1 = _xThrowExpressionAccess.getThrowKeyword_1();
        if (Objects.equal(grammarElement, _throwKeyword_1)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XTryCatchFinallyExpressionElements _xTryCatchFinallyExpressionAccess = this._xbaseGrammarAccess.getXTryCatchFinallyExpressionAccess();
        Keyword _tryKeyword_1 = _xTryCatchFinallyExpressionAccess.getTryKeyword_1();
        if (Objects.equal(grammarElement, _tryKeyword_1)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XTryCatchFinallyExpressionElements _xTryCatchFinallyExpressionAccess_1 = this._xbaseGrammarAccess.getXTryCatchFinallyExpressionAccess();
        Keyword _finallyKeyword_3_1_0 = _xTryCatchFinallyExpressionAccess_1.getFinallyKeyword_3_1_0();
        if (Objects.equal(grammarElement, _finallyKeyword_3_1_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XTryCatchFinallyExpressionElements _xTryCatchFinallyExpressionAccess_2 = this._xbaseGrammarAccess.getXTryCatchFinallyExpressionAccess();
        Keyword _finallyKeyword_3_0_1_0 = _xTryCatchFinallyExpressionAccess_2.getFinallyKeyword_3_0_1_0();
        if (Objects.equal(grammarElement, _finallyKeyword_3_0_1_0)) {
          _matched=true;
        }
      }
      if (!_matched) {
        XbaseGrammarAccess.XVariableDeclarationElements _xVariableDeclarationAccess = this._xbaseGrammarAccess.getXVariableDeclarationAccess();
        Keyword _equalsSignKeyword_3_0 = _xVariableDeclarationAccess.getEqualsSignKeyword_3_0();
        if (Objects.equal(grammarElement, _equalsSignKeyword_3_0)) {
          _matched=true;
        }
      }
      if (_matched) {
        return Indent.getNormalIndent();
      }
    }
    return null;
  }
}

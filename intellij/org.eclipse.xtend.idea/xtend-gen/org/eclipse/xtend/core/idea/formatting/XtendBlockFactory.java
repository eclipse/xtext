/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtend.core.idea.formatting;

import com.google.common.base.Objects;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtend.core.services.XtendGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.xbase.idea.formatting.XbaseBlockFactory;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * @author kosyakov - Initial contribution and API
 */
@Singleton
@SuppressWarnings("all")
public class XtendBlockFactory extends XbaseBlockFactory {
  @Inject
  @Extension
  private XtendGrammarAccess _xtendGrammarAccess;
  
  @Override
  protected boolean isStructural(final EObject grammarElement) {
    boolean _switchResult = false;
    boolean _matched = false;
    XtendGrammarAccess.XVariableDeclarationElements _xVariableDeclarationAccess = this._xtendGrammarAccess.getXVariableDeclarationAccess();
    RuleCall _rightXExpressionParserRuleCall_2_1_0 = _xVariableDeclarationAccess.getRightXExpressionParserRuleCall_2_1_0();
    if (Objects.equal(grammarElement, _rightXExpressionParserRuleCall_2_1_0)) {
      _matched=true;
    }
    if (!_matched) {
      XtendGrammarAccess.XSwitchExpressionElements _xSwitchExpressionAccess = this._xtendGrammarAccess.getXSwitchExpressionAccess();
      RuleCall _defaultXExpressionParserRuleCall_5_2_0 = _xSwitchExpressionAccess.getDefaultXExpressionParserRuleCall_5_2_0();
      if (Objects.equal(grammarElement, _defaultXExpressionParserRuleCall_5_2_0)) {
        _matched=true;
      }
    }
    if (_matched) {
      _switchResult = true;
    }
    if (!_matched) {
      _switchResult = super.isStructural(grammarElement);
    }
    return _switchResult;
  }
}

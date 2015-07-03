/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.test.languages.formatting;

import com.google.inject.Inject;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.web.example.statemachine.services.StatemachineGrammarAccess;
import org.eclipse.xtext.xbase.lib.Extension;

/**
 * This class contains custom formatting declarations.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#formatting
 * on how and when to use it.
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
@SuppressWarnings("all")
public class StatemachineFormatter extends AbstractDeclarativeFormatter {
  @Inject
  @Extension
  private StatemachineGrammarAccess _statemachineGrammarAccess;
  
  @Override
  protected void configureFormatting(final FormattingConfig c) {
    FormattingConfig.LinewrapLocator _setLinewrap = c.setLinewrap(0, 1, 2);
    TerminalRule _sL_COMMENTRule = this._statemachineGrammarAccess.getSL_COMMENTRule();
    _setLinewrap.before(_sL_COMMENTRule);
    FormattingConfig.LinewrapLocator _setLinewrap_1 = c.setLinewrap(0, 1, 2);
    TerminalRule _mL_COMMENTRule = this._statemachineGrammarAccess.getML_COMMENTRule();
    _setLinewrap_1.before(_mL_COMMENTRule);
    FormattingConfig.LinewrapLocator _setLinewrap_2 = c.setLinewrap(0, 1, 1);
    TerminalRule _mL_COMMENTRule_1 = this._statemachineGrammarAccess.getML_COMMENTRule();
    _setLinewrap_2.after(_mL_COMMENTRule_1);
    FormattingConfig.LinewrapLocator _setLinewrap_3 = c.setLinewrap();
    StatemachineGrammarAccess.InputSignalElements _inputSignalAccess = this._statemachineGrammarAccess.getInputSignalAccess();
    Keyword _inputKeyword_1 = _inputSignalAccess.getInputKeyword_1();
    _setLinewrap_3.before(_inputKeyword_1);
    FormattingConfig.LinewrapLocator _setLinewrap_4 = c.setLinewrap();
    StatemachineGrammarAccess.OutputSignalElements _outputSignalAccess = this._statemachineGrammarAccess.getOutputSignalAccess();
    Keyword _outputKeyword_1 = _outputSignalAccess.getOutputKeyword_1();
    _setLinewrap_4.before(_outputKeyword_1);
    FormattingConfig.LinewrapLocator _setLinewrap_5 = c.setLinewrap(1, 1, 2);
    StatemachineGrammarAccess.StateElements _stateAccess = this._statemachineGrammarAccess.getStateAccess();
    Keyword _stateKeyword_0 = _stateAccess.getStateKeyword_0();
    _setLinewrap_5.before(_stateKeyword_0);
    FormattingConfig.IndentationLocatorStart _setIndentationIncrement = c.setIndentationIncrement();
    StatemachineGrammarAccess.StateElements _stateAccess_1 = this._statemachineGrammarAccess.getStateAccess();
    Assignment _nameAssignment_1 = _stateAccess_1.getNameAssignment_1();
    _setIndentationIncrement.after(_nameAssignment_1);
    FormattingConfig.LinewrapLocator _setLinewrap_6 = c.setLinewrap();
    StatemachineGrammarAccess.CommandElements _commandAccess = this._statemachineGrammarAccess.getCommandAccess();
    Keyword _setKeyword_0 = _commandAccess.getSetKeyword_0();
    _setLinewrap_6.before(_setKeyword_0);
    FormattingConfig.LinewrapLocator _setLinewrap_7 = c.setLinewrap();
    StatemachineGrammarAccess.TransitionElements _transitionAccess = this._statemachineGrammarAccess.getTransitionAccess();
    Keyword _ifKeyword_0 = _transitionAccess.getIfKeyword_0();
    _setLinewrap_7.before(_ifKeyword_0);
    FormattingConfig.LinewrapLocator _setLinewrap_8 = c.setLinewrap();
    StatemachineGrammarAccess.StateElements _stateAccess_2 = this._statemachineGrammarAccess.getStateAccess();
    Keyword _endKeyword_4 = _stateAccess_2.getEndKeyword_4();
    _setLinewrap_8.before(_endKeyword_4);
    FormattingConfig.IndentationLocatorEnd _setIndentationDecrement = c.setIndentationDecrement();
    StatemachineGrammarAccess.StateElements _stateAccess_3 = this._statemachineGrammarAccess.getStateAccess();
    Keyword _endKeyword_4_1 = _stateAccess_3.getEndKeyword_4();
    _setIndentationDecrement.before(_endKeyword_4_1);
  }
}

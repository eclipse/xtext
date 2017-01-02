/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.server.test.languages.formatting;

import com.google.inject.Inject;
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
    c.setLinewrap(0, 1, 2).before(this._statemachineGrammarAccess.getSL_COMMENTRule());
    c.setLinewrap(0, 1, 2).before(this._statemachineGrammarAccess.getML_COMMENTRule());
    c.setLinewrap(0, 1, 1).after(this._statemachineGrammarAccess.getML_COMMENTRule());
    c.setLinewrap().before(this._statemachineGrammarAccess.getInputSignalAccess().getInputKeyword_1());
    c.setLinewrap().before(this._statemachineGrammarAccess.getOutputSignalAccess().getOutputKeyword_1());
    c.setLinewrap(1, 1, 2).before(this._statemachineGrammarAccess.getStateAccess().getStateKeyword_0());
    c.setIndentationIncrement().after(this._statemachineGrammarAccess.getStateAccess().getNameAssignment_1());
    c.setLinewrap().before(this._statemachineGrammarAccess.getCommandAccess().getSetKeyword_0());
    c.setLinewrap().before(this._statemachineGrammarAccess.getTransitionAccess().getIfKeyword_0());
    c.setLinewrap().before(this._statemachineGrammarAccess.getStateAccess().getEndKeyword_5());
    c.setIndentationDecrement().before(this._statemachineGrammarAccess.getStateAccess().getEndKeyword_5());
  }
}

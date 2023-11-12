/**
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 */
package org.eclipse.xtext.web.server.test.languages.formatting;

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.web.example.statemachine.services.StatemachineGrammarAccess;

import com.google.inject.Inject;

/**
 * This class contains custom formatting declarations.
 * 
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#formatting
 * on how and when to use it.
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormatter} as an
 * example
 */
public class StatemachineFormatter extends AbstractDeclarativeFormatter {
	@Inject
	private StatemachineGrammarAccess statemachineGrammarAccess;

	@Override
	protected void configureFormatting(FormattingConfig c) {
		c.setLinewrap(0, 1, 2).before(statemachineGrammarAccess.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 2).before(statemachineGrammarAccess.getML_COMMENTRule());
		c.setLinewrap(0, 1, 1).after(statemachineGrammarAccess.getML_COMMENTRule());
		c.setLinewrap().before(statemachineGrammarAccess.getInputSignalAccess().getInputKeyword_1());
		c.setLinewrap().before(statemachineGrammarAccess.getOutputSignalAccess().getOutputKeyword_1());
		c.setLinewrap(1, 1, 2).before(statemachineGrammarAccess.getStateAccess().getStateKeyword_0());
		c.setIndentationIncrement().after(statemachineGrammarAccess.getStateAccess().getNameAssignment_1());
		c.setLinewrap().before(statemachineGrammarAccess.getCommandAccess().getSetKeyword_0());
		c.setLinewrap().before(statemachineGrammarAccess.getTransitionAccess().getIfKeyword_0());
		c.setLinewrap().before(statemachineGrammarAccess.getStateAccess().getEndKeyword_5());
		c.setIndentationDecrement().before(statemachineGrammarAccess.getStateAccess().getEndKeyword_5());
	}
}

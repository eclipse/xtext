/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.testlanguages.parser.antlr.internal.InternalActionTestLanguage3Parser;
import org.eclipse.xtext.testlanguages.services.ActionTestLanguage3GrammarAccess;

public class ActionTestLanguage3Parser extends AbstractAntlrParser {

	@Inject
	private ActionTestLanguage3GrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalActionTestLanguage3Parser createParser(XtextTokenStream stream) {
		return new InternalActionTestLanguage3Parser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "ProductionRules";
	}

	public ActionTestLanguage3GrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(ActionTestLanguage3GrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}

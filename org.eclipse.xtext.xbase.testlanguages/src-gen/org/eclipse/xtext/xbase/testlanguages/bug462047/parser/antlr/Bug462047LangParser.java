/*******************************************************************************
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.testlanguages.bug462047.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.xbase.testlanguages.bug462047.parser.antlr.internal.InternalBug462047LangParser;
import org.eclipse.xtext.xbase.testlanguages.bug462047.services.Bug462047LangGrammarAccess;

public class Bug462047LangParser extends AbstractAntlrParser {

	@Inject
	private Bug462047LangGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalBug462047LangParser createParser(XtextTokenStream stream) {
		return new InternalBug462047LangParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Bug462047Root";
	}

	public Bug462047LangGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(Bug462047LangGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}

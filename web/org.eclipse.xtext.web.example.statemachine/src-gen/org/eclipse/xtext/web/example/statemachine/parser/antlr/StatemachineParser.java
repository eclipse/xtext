/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.statemachine.parser.antlr;

import com.google.inject.Inject;

import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.web.example.statemachine.services.StatemachineGrammarAccess;

public class StatemachineParser extends org.eclipse.xtext.parser.antlr.AbstractAntlrParser {
	
	@Inject
	private StatemachineGrammarAccess grammarAccess;
	
	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	
	@Override
	protected org.eclipse.xtext.web.example.statemachine.parser.antlr.internal.InternalStatemachineParser createParser(XtextTokenStream stream) {
		return new org.eclipse.xtext.web.example.statemachine.parser.antlr.internal.InternalStatemachineParser(stream, getGrammarAccess());
	}
	
	@Override 
	protected String getDefaultRuleName() {
		return "Statemachine";
	}
	
	public StatemachineGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(StatemachineGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
	
}

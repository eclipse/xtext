/*******************************************************************************
 * Copyright (c) 2010, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 * 
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.xbase.parser.antlr.internal.InternalXbaseParser;
import org.eclipse.xtext.xbase.services.XbaseGrammarAccess;

public class XbaseParser extends AbstractAntlrParser {

	@Inject
	private XbaseGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalXbaseParser createParser(XtextTokenStream stream) {
		return new InternalXbaseParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "XExpression";
	}

	public XbaseGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(XbaseGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}

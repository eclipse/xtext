/*******************************************************************************
 * Copyright (c) 2015, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.ui.codetemplates.parser.antlr.internal.InternalCodetemplatesParser;
import org.eclipse.xtext.ui.codetemplates.services.CodetemplatesGrammarAccess;

public class CodetemplatesParser extends AbstractAntlrParser {

	@Inject
	private CodetemplatesGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS");
	}
	

	@Override
	protected InternalCodetemplatesParser createParser(XtextTokenStream stream) {
		return new InternalCodetemplatesParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Codetemplates";
	}

	public CodetemplatesGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(CodetemplatesGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}

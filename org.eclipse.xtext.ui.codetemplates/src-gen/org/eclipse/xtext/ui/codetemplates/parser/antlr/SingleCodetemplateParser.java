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
import org.eclipse.xtext.ui.codetemplates.parser.antlr.internal.InternalSingleCodetemplateParser;
import org.eclipse.xtext.ui.codetemplates.services.SingleCodetemplateGrammarAccess;

public class SingleCodetemplateParser extends AbstractAntlrParser {

	@Inject
	private SingleCodetemplateGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS");
	}
	

	@Override
	protected InternalSingleCodetemplateParser createParser(XtextTokenStream stream) {
		return new InternalSingleCodetemplateParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Codetemplates";
	}

	public SingleCodetemplateGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(SingleCodetemplateGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}

/*******************************************************************************
 * Copyright (c) 2011, 2023 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.purexbase.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.purexbase.parser.antlr.internal.InternalPureXbaseParser;
import org.eclipse.xtext.purexbase.services.PureXbaseGrammarAccess;

public class PureXbaseParser extends AbstractAntlrParser {

	@Inject
	private PureXbaseGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalPureXbaseParser createParser(XtextTokenStream stream) {
		return new InternalPureXbaseParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "Model";
	}

	public PureXbaseGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(PureXbaseGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}

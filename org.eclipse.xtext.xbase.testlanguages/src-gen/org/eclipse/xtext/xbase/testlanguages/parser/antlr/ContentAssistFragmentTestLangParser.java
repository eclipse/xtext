/*******************************************************************************
 * Copyright (c) 2011, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.xbase.testlanguages.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.xbase.testlanguages.parser.antlr.internal.InternalContentAssistFragmentTestLangParser;
import org.eclipse.xtext.xbase.testlanguages.services.ContentAssistFragmentTestLangGrammarAccess;

public class ContentAssistFragmentTestLangParser extends AbstractAntlrParser {

	@Inject
	private ContentAssistFragmentTestLangGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalContentAssistFragmentTestLangParser createParser(XtextTokenStream stream) {
		return new InternalContentAssistFragmentTestLangParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "ContentAssistFragmentTestLanguageRoot";
	}

	public ContentAssistFragmentTestLangGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(ContentAssistFragmentTestLangGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}

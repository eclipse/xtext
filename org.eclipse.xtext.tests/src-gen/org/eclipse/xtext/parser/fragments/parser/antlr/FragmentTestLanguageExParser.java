/*******************************************************************************
 * Copyright (c) 2010, 2024 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.parser.fragments.parser.antlr;

import com.google.inject.Inject;
import org.eclipse.xtext.parser.antlr.AbstractAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.fragments.parser.antlr.internal.InternalFragmentTestLanguageExParser;
import org.eclipse.xtext.parser.fragments.services.FragmentTestLanguageExGrammarAccess;

public class FragmentTestLanguageExParser extends AbstractAntlrParser {

	@Inject
	private FragmentTestLanguageExGrammarAccess grammarAccess;

	@Override
	protected void setInitialHiddenTokens(XtextTokenStream tokenStream) {
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
	}
	

	@Override
	protected InternalFragmentTestLanguageExParser createParser(XtextTokenStream stream) {
		return new InternalFragmentTestLanguageExParser(stream, getGrammarAccess());
	}

	@Override 
	protected String getDefaultRuleName() {
		return "ParserRuleFragmentsEx";
	}

	public FragmentTestLanguageExGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(FragmentTestLanguageExGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}

/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal;

import java.util.Set;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.contentassist.antlr.internal.InternalXtextGrammarUiTestLanguageLexer;
import org.eclipse.xtext.contentassist.antlr.internal.InternalXtextGrammarUiTestLanguageParser;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.AbstractParserTest;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.ObservableXtextTokenStream;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.FollowElement;


/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class InternalParserTest extends AbstractParserTest {

	protected InternalXtextGrammarUiTestLanguageParser createParser(String input) {
		CharStream stream = new ANTLRStringStream(input);
		InternalXtextGrammarUiTestLanguageLexer lexer = new InternalXtextGrammarUiTestLanguageLexer(stream);
		ObservableXtextTokenStream tokenStream = new ObservableXtextTokenStream(lexer, get(ITokenDefProvider.class));
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
		InternalXtextGrammarUiTestLanguageParser result = new InternalXtextGrammarUiTestLanguageParser(tokenStream);
		tokenStream.setListener(result);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	public void testSetup() {
		String input = "";
		InternalXtextGrammarUiTestLanguageParser parser = createParser(input);
		assertNotNull(parser);
	}
	
	@Override
	protected Set<FollowElement> getFollowSet(String input) throws RecognitionException {
		InternalXtextGrammarUiTestLanguageParser parser = createParser(input);
		parser.entryRuleGrammar();
		return parser.getFollowElements();
	}
}

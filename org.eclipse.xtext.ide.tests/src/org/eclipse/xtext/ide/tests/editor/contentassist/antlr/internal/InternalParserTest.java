/*******************************************************************************
 * Copyright (c) 2009, 2016 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.tests.editor.contentassist.antlr.internal;

import static org.junit.Assert.*;

import java.util.Set;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ObservableXtextTokenStream;
import org.eclipse.xtext.ide.tests.editor.contentassist.antlr.AbstractParserTest;
import org.eclipse.xtext.testlanguages.xtextgrammar.ide.contentassist.antlr.internal.InternalXtextGrammarTestLanguageLexer;
import org.eclipse.xtext.testlanguages.xtextgrammar.ide.contentassist.antlr.internal.InternalXtextGrammarTestLanguageParser;
import org.junit.Test;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class InternalParserTest extends AbstractParserTest {

	protected InternalXtextGrammarTestLanguageParser createParser(String input) {
		CharStream stream = new ANTLRStringStream(input);
		InternalXtextGrammarTestLanguageLexer lexer = new InternalXtextGrammarTestLanguageLexer(stream);
		InternalXtextGrammarTestLanguageParser result = new InternalXtextGrammarTestLanguageParser(null);
		ObservableXtextTokenStream tokenStream = new ObservableXtextTokenStream(lexer, result);
		tokenStream.setInitialHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");
		tokenStream.setListener(result);
		result.setGrammarAccess(grammarAccess);
		result.setTokenStream(tokenStream);
		return result;
	}

	@Test
	public void testSetup() {
		String input = "";
		InternalXtextGrammarTestLanguageParser parser = createParser(input);
		assertNotNull(parser);
	}

	@Override
	protected Set<FollowElement> getFollowSet(String input) throws RecognitionException {
		InternalXtextGrammarTestLanguageParser parser = createParser(input);
		parser.entryRuleGrammar();
		return parser.getFollowElements();
	}
}

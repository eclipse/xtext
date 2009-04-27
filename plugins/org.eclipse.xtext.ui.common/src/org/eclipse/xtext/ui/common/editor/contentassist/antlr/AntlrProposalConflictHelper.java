/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.antlr;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.Token;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.ui.common.editor.contentassist.ProposalConflictHelper;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AntlrProposalConflictHelper extends ProposalConflictHelper {

	@Inject
	private Lexer lexer;
	
	public void setLexer(Lexer lexer) {
		this.lexer = lexer;
	}

	public Lexer getLexer() {
		return lexer;
	}

	@Override
	public boolean existsConflict(String proposal, String lastCompleteText) {
		String combinedText = lastCompleteText.concat(proposal);
		CharStream stream = new ANTLRStringStream(combinedText);
		lexer.setCharStream(stream);

		String[] expectedTexts = new String[] { lastCompleteText, proposal };
		for(String expected: expectedTexts) {
			Token nextToken = lexer.nextToken();
			if (nextToken.equals(Token.EOF_TOKEN))
				return true;
			String tokenText = nextToken.getText();
			if (!expected.equals(tokenText))
				return true;
		}
		Token lastToken = lexer.nextToken();
		if (!lastToken.equals(Token.EOF_TOKEN))
			return true;
		return false;
	}
	
}

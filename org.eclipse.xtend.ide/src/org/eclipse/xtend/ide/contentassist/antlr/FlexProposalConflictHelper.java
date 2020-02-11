/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtend.ide.contentassist.antlr;

import java.io.IOException;
import java.io.StringReader;

import org.antlr.runtime.Token;
import org.eclipse.xtend.core.parser.InternalFlexer;
import org.eclipse.xtend.core.parser.antlr.internal.FlexerFactory;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ProposalConflictHelper;

import com.google.inject.Inject;

/**
 * <p>An implementation that relies on the lexer to detect proposals that conflict
 * with the input in the document.</p>
 * <p>A proposal is considered to be conflicting if the lexer would not produce
 * two distinct tokens for the previous sibling and the proposal itself but consume
 * parts of the proposal as part of the first token. 
 * Example:</p>
 * <code>
 * === Grammar:<br/>
 * 	MyParserRule: name=ID other=[MyParserRule];<br/>
 * === Input:<br/>
 *  MyId|<br/>
 * </code>
 * <p>where <code>|</code> denotes the cursor position. A valid follow
 * token for the parser is the ID of the cross reference. However, since
 * <code>MyIdSomethingElse</code> would be consumed as a single ID by the lexer,
 * the proposal <code>SomethingElse</code> is invalid.</p> 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FlexProposalConflictHelper extends ProposalConflictHelper {

	private InternalFlexer proposalFlexer;

	private InternalFlexer lastCompleteFlexer;
	
	private InternalFlexer combinedFlexer;
	
	@Inject
	private void initializeFlexers(FlexerFactory factory) {
		proposalFlexer = factory.createFlexer(null);
		lastCompleteFlexer = factory.createFlexer(null);
		combinedFlexer = factory.createFlexer(null);
	}

	@Override
	public boolean existsConflict(String lastCompleteText, String proposal, ContentAssistContext context) {
		initTokenSources(lastCompleteText, proposal, context);
		try {
			if (!equalTokenSequence(lastCompleteFlexer, combinedFlexer))
				return true;
			if (!equalTokenSequence(proposalFlexer, combinedFlexer))
				return true;
			int lastToken = proposalFlexer.advance();
			if (lastToken != Token.EOF)
				return true;
			return false;
		} catch(IOException e) {
			throw new RuntimeException(e);
		}
	}

	protected boolean equalTokenSequence(InternalFlexer first, InternalFlexer second) throws IOException {
		int token;
		while((token = first.advance()) != Token.EOF) {
			int otherToken = second.advance();
			if (token != otherToken) {
				return false;
			}
			if (first.getTokenLength() != second.getTokenLength()) {
				return false;
			}
		}
		return true;
	}
	
	protected void initTokenSources(String lastCompleteText, String proposal, ContentAssistContext context) {
		String combinedText = lastCompleteText.concat(proposal);
		initTokenSource(combinedText, combinedFlexer, context);
		initTokenSource(lastCompleteText, lastCompleteFlexer, context);
		initTokenSource(proposal, proposalFlexer, context);
	}

	protected void initTokenSource(String text, InternalFlexer tokenSource, ContentAssistContext context) {
		tokenSource.yyreset(new StringReader(text));
	}

}

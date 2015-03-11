/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.highlighting;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.Token;
import org.eclipse.xtext.ide.LexerIdeBindings;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.TokenTool;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TemplateBodyHighlighter {

	@Inject
	@Named(LexerIdeBindings.HIGHLIGHTING)
	private Lexer lexer;

	@Inject
	private AbstractAntlrTokenToAttributeIdMapper tokenIdMapper;
	
	public void provideHighlightingFor(String body, IHighlightedPositionAcceptor acceptor) {
		lexer.setCharStream(new ANTLRStringStream(body));
		Token token = lexer.nextToken();
		while(token != Token.EOF_TOKEN) {
			String id = tokenIdMapper.getId(token.getType());
			int offset = TokenTool.getOffset(token);
			int length = TokenTool.getLength(token);
			acceptor.addPosition(offset, length, id);
			token = lexer.nextToken();
		}
	}
	
}

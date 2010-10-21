/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.codetemplates.ui.contentassist;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.Region;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.parser.antlr.Lexer;
import org.eclipse.xtext.parser.antlr.LexerBindings;
import org.eclipse.xtext.parsetree.AbstractNode;
import org.eclipse.xtext.parsetree.NodeUtil;
import org.eclipse.xtext.ui.codetemplates.templates.TemplateBody;
import org.eclipse.xtext.ui.codetemplates.templates.Variable;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.IProposalConflictHelper;
import org.eclipse.xtext.util.Strings;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * Mostly copied from default ANTLR based implementation with added possibility to
 * initialize the internal state of the lexer.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractProposalConflictHelper implements IProposalConflictHelper {

	@Inject
	@Named(LexerBindings.RUNTIME)
	private Lexer proposalLexer;
	@Inject
	@Named(LexerBindings.RUNTIME)
	private Lexer lastCompleteLexer;
	@Inject
	@Named(LexerBindings.RUNTIME)
	private Lexer combinedLexer;

	public AbstractProposalConflictHelper() {
		super();
	}

	public boolean existsConflict(String proposal, ContentAssistContext context) {
		// hidden node between lastCompleteNode and currentNode?
		AbstractNode lastCompleteNode = context.getLastCompleteNode();
		Region replaceRegion = context.getReplaceRegion();
		int nodeEnd = lastCompleteNode.getOffset() + lastCompleteNode.getLength();
		if (nodeEnd < replaceRegion.getOffset())
			return false;
		
		return existsConflict(lastCompleteNode, replaceRegion.getOffset(), proposal, context);
	}

	public boolean existsConflict(AbstractNode lastCompleteNode, int offset, String proposal, ContentAssistContext context) {
		String lastCompleteText = lastCompleteNode.serialize();
		lastCompleteText = lastCompleteText.substring(0, offset - lastCompleteNode.getTotalOffset());
		if (Strings.isEmpty(lastCompleteText))
			return false;
		return existsConflict(lastCompleteText, proposal, context);
	}

	public boolean existsConflict(String lastCompleteText, String proposal, ContentAssistContext context) {
		initTokenSources(lastCompleteText, proposal, context);
		if (!equalTokenSequence(lastCompleteLexer, combinedLexer))
			return true;
		if (!equalTokenSequence(proposalLexer, combinedLexer))
			return true;
		Token lastToken = proposalLexer.nextToken();
		if (!lastToken.equals(Token.EOF_TOKEN))
			return true;
		return false;
	}

	protected boolean equalTokenSequence(TokenSource first, TokenSource second) {
		Token token = null;
		while(!(token = first.nextToken()).equals(Token.EOF_TOKEN)) {
			Token otherToken = second.nextToken();
			if (otherToken.equals(Token.EOF_TOKEN)) {
				return false;
			}
			if (!token.getText().equals(otherToken.getText())) {
				return false;
			}
		}
		return true;
	}

	protected void initTokenSources(String lastCompleteText, String proposal, ContentAssistContext context) {
		String combinedText = lastCompleteText.concat(proposal);
		initTokenSource(combinedText, combinedLexer, context);
		initTokenSource(lastCompleteText, lastCompleteLexer, context);
		initTokenSource(proposal, proposalLexer, context);
	}

	protected void initTokenSource(String text, Lexer lexer, ContentAssistContext context) {
		EObject currentModel = NodeUtil.findASTElement(context.getLastCompleteNode());
		Variable variable = currentModel != null ? EcoreUtil2.getContainerOfType(currentModel, Variable.class) : null;
		TemplateBody body = currentModel != null ? EcoreUtil2.getContainerOfType(currentModel, TemplateBody.class) : null;
		CharStream stream = new ANTLRStringStream(text);
		lexer.setCharStream(stream);
		initLexer(lexer, body != null, variable != null);
	}
	
	protected abstract void initLexer(Lexer lexer, boolean literal, boolean variable);

}
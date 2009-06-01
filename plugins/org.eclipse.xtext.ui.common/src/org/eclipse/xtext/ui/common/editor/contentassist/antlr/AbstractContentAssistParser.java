/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.antlr;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractContentAssistParser implements IContentAssistParser {

	public Collection<FollowElement> getFollowElements(FollowElement element) {
		if (element.getLookAhead() <= 1)
			throw new IllegalArgumentException("lookahead my not be less than or equal to 1");
		Collection<FollowElement> result = new ArrayList<FollowElement>();
		for(AbstractElement elementToParse: getElementsToParse(element)) {
			AbstractInternalContentAssistParser parser = createParser();
			final Iterator<LookAheadTerminal> iter = element.getLookAheadTerminals().iterator();
			ObservableXtextTokenStream tokens = new ObservableXtextTokenStream(new TokenSource(){
				public Token nextToken() {
					if (iter.hasNext()) {
						LookAheadTerminal lookAhead = iter.next();
						return lookAhead.getToken();
					}
					return Token.EOF_TOKEN;
				}
			}, parser);
			parser.setTokenStream(tokens);
			tokens.setListener(parser);
			result.addAll(getFollowElements(parser, elementToParse));
		}
		return result;
	}
	
	private Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser,
			AbstractElement elementToParse) {
		String ruleName = getRuleName(elementToParse);
		if (ruleName == null) {
			if (elementToParse instanceof RuleCall) {
				ruleName = "rule" + ((RuleCall) elementToParse).getRule().getName();
			} else {
				return Collections.emptyList();
			}
		}
		try {
			Method method = parser.getClass().getDeclaredMethod(ruleName);
			method.setAccessible(true);
			method.invoke(parser);
			return parser.getFollowElements();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private Collection<AbstractElement> getElementsToParse(FollowElement element) {
		AbstractElement root = element.getGrammarElement();
		if (root instanceof Alternatives) {
			return ((Alternatives) root).getGroups();
		}
		return Collections.singleton(root);
	}

	protected abstract String getRuleName(AbstractElement element);
		
	protected abstract Lexer createLexer(CharStream stream);
	
	protected abstract AbstractInternalContentAssistParser createParser();
	
	protected abstract Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser);
	
	protected abstract String[] getInitialHiddenTokens();
	
	public Collection<FollowElement> getFollowElements(String input) {
		CharStream stream = new ANTLRStringStream(input);
		Lexer lexer = createLexer(stream);
		AbstractInternalContentAssistParser parser = createParser();
		ObservableXtextTokenStream tokens = new ObservableXtextTokenStream(lexer, parser);
		tokens.setInitialHiddenTokens(getInitialHiddenTokens());
		parser.setTokenStream(tokens);
		tokens.setListener(parser);
		return getFollowElements(parser);
	}
}

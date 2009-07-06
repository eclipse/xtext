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
import java.util.List;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenSource;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Alternatives;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.Group;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.ObservableXtextTokenStream.StreamListener;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal.Lexer;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractContentAssistParser implements IContentAssistParser {

	public Collection<FollowElement> getFollowElements(FollowElement element) {
		if (element.getLookAhead() <= 1)
			throw new IllegalArgumentException("lookahead may not be less than or equal to 1");
		Collection<FollowElement> result = new ArrayList<FollowElement>();
		for(AbstractElement elementToParse: getElementsToParse(element)) {
			String ruleName = getRuleName(elementToParse);
			String[][] allRuleNames = getRequiredRuleNames(ruleName, elementToParse);
			for (String[] ruleNames: allRuleNames) {
				for(int i = 0; i < ruleNames.length; i++) {
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
					parser.getGrammarElements().addAll(element.getTrace());
					parser.getGrammarElements().add(elementToParse);
					parser.getLocalTrace().addAll(element.getLocalTrace());
					parser.getLocalTrace().add(elementToParse);
					Collection<FollowElement> elements = getFollowElements(parser, elementToParse, ruleNames, i);
					result.addAll(elements);
				}
			}
		}
		return result;
	}
	
	private Collection<FollowElement> getFollowElements(final AbstractInternalContentAssistParser parser,
			AbstractElement elementToParse, String[] ruleNames, int startIndex) {
		try {
			final boolean[] wasEof = new boolean[] { false };
			final boolean[] consumedSomething = new boolean[] { true };
			ObservableXtextTokenStream stream = (ObservableXtextTokenStream) parser.getTokenStream();
			stream.setListener(new StreamListener() {
				public void announceEof(int lookAhead) {
					parser.announceEof(lookAhead);
					wasEof[0] = true;
				}
				
				public void announceConsume() {
					parser.announceConsume();
					consumedSomething[0] = true;
				}
			});
			int i = startIndex;
			Collection<FollowElement> result = null;
			while(i < ruleNames.length && !wasEof[0] && consumedSomething[0]) {
				consumedSomething[0] = false;
				Method method = parser.getClass().getDeclaredMethod(ruleNames[i]);
				method.setAccessible(true);
				method.invoke(parser);
				result = parser.getFollowElements();
				if (i == ruleNames.length - 1 && !GrammarUtil.isMultipleCardinality(elementToParse))
					return result;
				if (!wasEof[0] && ruleNames.length != 1)
					i++;
				if (ruleNames.length > 2)
					throw new IllegalArgumentException("The following lines assume that we have at most two rules to call.");
				int lastGrammarElement = parser.getGrammarElements().size() - 1;
				if (parser.getGrammarElements().get(lastGrammarElement) != elementToParse)
					throw new IllegalStateException("Stack of grammar elements seems to be corrupt.");
				parser.getGrammarElements().remove(lastGrammarElement);
				int lastLocalTrace = parser.getLocalTrace().size() - 1;
				if (lastLocalTrace != -1) {
					parser.getLocalTrace().remove(lastLocalTrace);
				}
			}
			return result;
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private String[][] getRequiredRuleNames(String ruleName, AbstractElement elementToParse) {
		if (ruleName == null) {
			if (elementToParse instanceof RuleCall)
				return new String[][] {{ "rule" + ((RuleCall) elementToParse).getRule().getName() }};
			else
				return new String[0][];
		}
		if (!(GrammarUtil.isOptionalCardinality(elementToParse) || GrammarUtil.isOneOrMoreCardinality(elementToParse)))
			return new String[][] {{ ruleName }};
		if ((elementToParse.eContainer() instanceof Group)) {
			List<AbstractElement> tokens = ((Group) elementToParse.eContainer()).getTokens();
			int idx = tokens.indexOf(elementToParse) + 1;
			if (idx != tokens.size()) {
				String secondRule = getRuleName((AbstractElement) elementToParse.eContainer());
				secondRule = secondRule.substring(0, secondRule.length() - Integer.toString(idx - 1).length()) + idx;
				if (GrammarUtil.isMultipleCardinality(elementToParse))
					return new String[][] {{ ruleName }, {ruleName, secondRule}};
				return new String[][] { {ruleName, secondRule} };
			}
		}
		return new String[][] {{ ruleName }};
	}

	private Collection<AbstractElement> getElementsToParse(FollowElement element) {
		AbstractElement root = element.getGrammarElement();
		return getElementsToParse(root);
	}

	private Collection<AbstractElement> getElementsToParse(AbstractElement root) {
		if (root instanceof Alternatives)
			return ((Alternatives) root).getGroups();
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

/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.common.editor.contentassist.antlr.internal;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.runtime.BitSet;
import org.antlr.runtime.IntStream;
import org.antlr.runtime.Parser;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.parser.antlr.ITokenDefProvider;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.LookAheadTerminal;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.LookAheadTerminalRuleCall;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.LookaheadKeyword;
import org.eclipse.xtext.ui.common.editor.contentassist.antlr.ObservableXtextTokenStream;

import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractInternalContentAssistParser extends Parser implements
		ObservableXtextTokenStream.StreamListener, ITokenDefProvider {

	private final List<EObject> grammarElements;
	private final List<EObject> localTrace;
	private int stackSize;
	private final Set<FollowElement> followElements;
	private ObservableXtextTokenStream.StreamListener delegate;
	private List<TerminalRule> terminalRules;
	private boolean mismatch;

	public AbstractInternalContentAssistParser(TokenStream input) {
		super(input);
		this.grammarElements = new ArrayList<EObject>();
		this.localTrace = new ArrayList<EObject>();
		this.followElements = new LinkedHashSet<FollowElement>();
	}

	public void before(EObject grammarElement) {
		grammarElements.add(grammarElement);
		localTrace.add(grammarElement);
	}

	public void after(EObject grammarElement) {
		EObject foundGrammarElement = grammarElements.remove(grammarElements.size() - 1);
		if (grammarElement != foundGrammarElement)
			throw new IllegalStateException("expected element: '" + grammarElement + "', but was: '"
					+ foundGrammarElement + "'");
	}

	@Override
	public void recover(IntStream stream, RecognitionException ex) {
		removeUnexpectedElements();
		super.recover(stream, ex);
	}

	private void removeUnexpectedElements() {
		while (stackSize < grammarElements.size())
			grammarElements.remove(grammarElements.size() - 1);
	}

	@Override
	public void emitErrorMessage(String msg) {
		// don't call super, since it would do a plain vanilla
		// System.err.println(msg);
	}

	protected abstract Grammar getGrammar();

	protected int keepStackSize() {
		int result = stackSize;
		stackSize = grammarElements.size();
		return result;
	}

	protected void restoreStackSize(int stackSize) {
		if (backtracking == 0) {
			removeUnexpectedElements();
			this.stackSize = stackSize;
		}
	}

	protected void selectEofStrategy() {
		if (mismatch) {
			delegate = new ObservableXtextTokenStream.StreamListener() {
				
				private boolean wasErrorRecovery = false;
				
				public void announceEof(int lookAhead) {
					wasErrorRecovery = wasErrorRecovery || errorRecovery;
					if (!wasErrorRecovery && !mismatch) {
						AbstractElement current = getCurrentGrammarElement();
						if (current != null)
							followElements.add(createFollowElement(current, lookAhead));
					}
				}

				public void announceConsume() {
					AbstractInternalContentAssistParser.this.announceConsume();
				}
			};
		} else if (!errorRecovery) {
			delegate = new ObservableXtextTokenStream.StreamListener() {

				public void announceEof(int lookAhead) {
					if (!errorRecovery && !mismatch) {
						AbstractElement current = getCurrentGrammarElement();
						if (current != null)
							followElements.add(createFollowElement(current, lookAhead));
					}
				}

				public void announceConsume() {
					AbstractInternalContentAssistParser.this.announceConsume();
				}

			};
		}
		else {
			delegate = new ObservableXtextTokenStream.StreamListener() {

				private AbstractElement lastAddedElement;

				public void announceEof(int lookAhead) {
					AbstractElement current = getCurrentGrammarElement();
					if (current != null
							&& (lastAddedElement == null || 
								!EcoreUtil.isAncestor(current, lastAddedElement))) {
						followElements.add(createFollowElement(current, lookAhead));
						lastAddedElement = current;
					}
				}

				public void announceConsume() {
					AbstractInternalContentAssistParser.this.announceConsume();
				}

			};
		}
	}

	@Override
	protected void mismatch(IntStream input, int ttype, BitSet follow) throws RecognitionException {
		try {
			mismatch = true;
			super.mismatch(input, ttype, follow);
		}
		finally {
			mismatch = false;
		}
	}

	private AbstractElement getCurrentGrammarElement() {
		for (int i = grammarElements.size() - 1; i >= 0; i--) {
			EObject result = grammarElements.get(grammarElements.size() - 1);
			if (result instanceof AbstractElement)
				return (AbstractElement) result;
		}
		return null;
	}

	private FollowElement createFollowElement(AbstractElement current, int lookAhead) {
		FollowElement result = new FollowElement();
		result.setLookAhead(lookAhead);
		if (lookAhead != 1) {
			List<LookAheadTerminal> lookAheadTerminals = Lists
					.<LookAheadTerminal> newArrayListWithExpectedSize(lookAhead - 1);
			for (int i = 1; i < lookAhead; i++) {
				Token token = input.LT(i);
				if (token == Token.EOF_TOKEN) {
					result.setLookAhead(i);
					break;
				}
				LookAheadTerminal lookAheadTerminal = createLookAheadTerminal(token);
				lookAheadTerminals.add(lookAheadTerminal);
			}
			if (!lookAheadTerminals.isEmpty())
				result.setLookAheadTerminals(lookAheadTerminals);
		}
		result.setGrammarElement(current);
		result.setTrace(Lists.newArrayList(Iterators.filter(grammarElements.iterator(), AbstractElement.class)));
		result.setLocalTrace(Lists.newArrayList(Iterators.filter(localTrace.iterator(), AbstractElement.class)));
		return result;
	}

	public LookAheadTerminal createLookAheadTerminal(Token token) {
		Grammar grammar = getGrammar();
		String tokenName = getTokenNames()[token.getType()];
		if (tokenName.charAt(0) == '\'') {
			LookaheadKeyword result = new LookaheadKeyword();
			result.setKeyword(tokenName.substring(1, tokenName.length() - 1));
			result.setToken(token);
			return result;
		}
		LookAheadTerminalRuleCall result = new LookAheadTerminalRuleCall();
		result.setToken(token);
		String ruleName = tokenName.substring(5);
		//		GrammarUtil.findRuleForName(grammar, tokenName); // does not work, as we change the terminal rule 'id' to antlr rule 'ID'
		if (terminalRules == null)
			terminalRules = GrammarUtil.allTerminalRules(grammar);
		for (TerminalRule rule : terminalRules) {
			if (rule.getName().equalsIgnoreCase(ruleName)) {
				result.setRule(rule);
				return result;
			}
		}
		throw new IllegalArgumentException("tokenType " + token.getType() + " seems to be invalid.");
	}

	public void announceEof(int lookAhead) {
		if (delegate == null) {
			selectEofStrategy();
		}
		if (grammarElements.isEmpty() || delegate == null)
			return;
		delegate.announceEof(lookAhead);
	}

	public void announceConsume() {
		localTrace.clear();
	}

	public Set<FollowElement> getFollowElements() {
		return followElements;
	}

	public Map<Integer, String> getTokenDefMap() {
		String[] names = getTokenNames();
		Map<Integer, String> result = Maps.newHashMapWithExpectedSize(names.length - Token.MIN_TOKEN_TYPE);
		for (int i = Token.MIN_TOKEN_TYPE; i < names.length; i++) {
			result.put(i, names[i]);
		}
		return result;
	}

	public List<EObject> getGrammarElements() {
		return grammarElements;
	}

	public List<EObject> getLocalTrace() {
		return localTrace;
	}
}

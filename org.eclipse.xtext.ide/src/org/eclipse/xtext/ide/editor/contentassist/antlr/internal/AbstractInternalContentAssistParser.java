/*******************************************************************************
 * Copyright (c) 2014, 2017 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.ide.editor.contentassist.antlr.internal;

import org.antlr.runtime.RecognizerSharedState;
import org.antlr.runtime.Token;
import org.antlr.runtime.TokenStream;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.ide.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.LookAheadTerminal;
import org.eclipse.xtext.ide.editor.contentassist.antlr.LookAheadTerminalRuleCall;
import org.eclipse.xtext.ide.editor.contentassist.antlr.LookaheadKeyword;
import org.eclipse.xtext.ide.editor.contentassist.antlr.ObservableXtextTokenStream;
import org.eclipse.xtext.parser.antlr.TokenTool;

/**
 * @since 2.9
 */
public abstract class AbstractInternalContentAssistParser extends BaseInternalContentAssistParser<FollowElement, LookAheadTerminal> implements
		ObservableXtextTokenStream.StreamListener {

	protected class DefaultFollowElementFactory extends AbstractFollowElementFactory<FollowElement, LookAheadTerminal> implements IFollowElementFactory {

		protected DefaultFollowElementFactory() {
			super(AbstractInternalContentAssistParser.this);
		}

		@Override
		protected FollowElement doCreateElement() {
			return new FollowElement();
		}

		@Override
		protected LookAheadTerminal doCreateLookAheadTerminal(Token token) {
			return createLookAheadTerminal(token);
		}
		
	}

	public interface RecoveryListener extends BaseInternalContentAssistParser.RecoveryListener {
	}
	
	interface IFollowElementFactory extends BaseInternalContentAssistParser.IFollowElementFactory<FollowElement, LookAheadTerminal> {
	}
	
	public AbstractInternalContentAssistParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}
	
	public AbstractInternalContentAssistParser(TokenStream input) {
		super(input);
	}
	
	@Override
	protected DefaultFollowElementFactory newFollowElementFactory() {
		return new DefaultFollowElementFactory();
	}
	
	protected abstract class StreamAdapter extends BaseInternalContentAssistParser<FollowElement, LookAheadTerminal>.StreamAdapter {
	}
	
	protected StreamAdapter delegate(BaseInternalContentAssistParser<FollowElement, LookAheadTerminal>.StreamAdapter delegate) {
		return new StreamAdapter() {

			@Override
			public void announceEof(int lookAhead) {
				delegate.announceEof(lookAhead);
			}

			@Override
			public void announceConsume() {
				delegate.announceConsume();
			}

			@Override
			public void announceMark(int marker) {
				delegate.announceMark(marker);
			}

			@Override
			public void announceRewind(int marker) {
				delegate.announceRewind(marker);
			}
		};
	}

	@Override
	protected StreamAdapter createNoOpStrategy() {
		return delegate(super.createNoOpStrategy());
	}

	@Override
	protected StreamAdapter createPredictionStrategy() {
		return delegate(super.createPredictionStrategy());
	}

	@Override
	protected StreamAdapter createErrorRecoveryStrategy() {
		return delegate(super.createErrorRecoveryStrategy());
	}

	@Override
	protected StreamAdapter createNotErrorRecoveryStrategy() {
		return delegate(super.createNotErrorRecoveryStrategy());
	}

	@Override
	protected StreamAdapter createMismatchStrategy() {
		return delegate(super.createMismatchStrategy());
	}
	
	@Override
	public LookAheadTerminal createLookAheadTerminal(Token token) {
		Grammar grammar = getGrammar();
		String tokenName = getTokenNames()[token.getType()];
		tokenName = getValueForTokenName(tokenName);
		if (tokenName.charAt(0) == '\'') {
			LookaheadKeyword result = new LookaheadKeyword();
			result.setKeyword(tokenName.substring(1, tokenName.length() - 1));
			result.setToken(token);
			return result;
		}
		LookAheadTerminalRuleCall result = new LookAheadTerminalRuleCall();
		result.setToken(token);
		String ruleName = TokenTool.getLexerRuleName(tokenName);
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

	@Override
	public RecoveryListener getRecoveryListener() {
		return (RecoveryListener) super.getRecoveryListener();
	}

	public void setRecoveryListener(RecoveryListener recoveryListener) {
		this.recoveryListener = recoveryListener;
	}

}

/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class LexerRuleAwareTerminalConsumer extends TerminalConsumer {
	
	protected LexerRuleAwareTerminalConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor) {
		super(input, markerFactory, tokenAcceptor);
		// TODO Auto-generated constructor stub
	}

	private LexerRule rule;
	
	public final LexerRule getGrammarElement() {
		if (rule == null) {
			rule = doGetLexerRule();
		}
		return rule;
	}
	
	@Override
	protected String getLexerRuleName() {
		return getGrammarElement().getName();
	}
	
	protected abstract LexerRule doGetLexerRule();
	
	@Override
	public String toString() {
		return super.toString() + " for rule " + getGrammarElement().getName();
	}
	
}
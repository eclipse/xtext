/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.builtin.parser.packrat.consumers;

import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.consumers.LexerRuleAwareTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.services.XtextGrammarAccess;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class XtextBuiltinANY_OTHERConsumer extends LexerRuleAwareTerminalConsumer {
	/**
	 * @param input
	 * @param markerFactory
	 * @param tokenAcceptor
	 */
	public XtextBuiltinANY_OTHERConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor) {
		super(input, markerFactory, tokenAcceptor);
	}

	public boolean doConsume() {
		return readAnyChar();
	}

	@Override
	protected LexerRule doGetLexerRule() {
		return (LexerRule) GrammarUtil.findRuleForName(XtextGrammarAccess.INSTANCE.getGrammar(), "ANY_OTHER");
	}
}
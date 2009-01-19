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
import org.eclipse.xtext.parser.packrat.consumers.AbstractRuleAwareTerminalConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.services.XtextGrammarAccess;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class XtextBuiltinSL_COMMENTConsumer extends AbstractRuleAwareTerminalConsumer {
	
	static final ICharacterClass SL_COMMENTConsumer$$$1 = ICharacterClass.Factory.invert(ICharacterClass.Factory.create('\n', '\r'));
	
	/**
	 * @param input
	 * @param markerFactory
	 * @param tokenAcceptor
	 */
	public XtextBuiltinSL_COMMENTConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor) {
		super(input, markerFactory, tokenAcceptor);
	}

	public boolean doConsume() {
		boolean result = true;
		// '//'
		result = readString("//"); 
		if (result) {
			readChars(SL_COMMENTConsumer$$$1);
			readChar('\r');
			result = readChar('\n');
		}
		return result;
	}

	@Override
	protected LexerRule doGetRule() {
		return (LexerRule) GrammarUtil.findRuleForName(XtextGrammarAccess.INSTANCE.getGrammar(), "SL_COMMENT");
	}
}
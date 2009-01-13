/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.parser.handwritten.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarAccess.LexerRuleElements;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LexerRuleConsumer extends NonTerminalConsumer {

	private ITerminalConsumer idConsumer;
	private INonTerminalConsumer typeRefConsumer;
	private ITerminalConsumer stringConsumer;

	public LexerRuleConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}

	@Override
	protected boolean doConsume() throws Exception {
		SEQUENCE$0: {
			ALTERNATIVE$1: {
				if (consumeKeyword(getRule().ele000000KeywordNative(), null, false, false))
					break ALTERNATIVE$1;
				if (consumeKeyword(getRule().ele000001KeywordLexer(), null, false, false))
					break ALTERNATIVE$1;
				break SEQUENCE$0;
			}
			if (!consumeTerminal(idConsumer, "name", false, false, getRule().ele000010LexerRuleCallID()))
				break SEQUENCE$0;
			
			OPTION$2: do {
				SEQUENCE$3: {
					IMarker marker$4 = mark();
					if (!consumeKeyword(getRule().ele00010KeywordReturns(), null, false, false)) break SEQUENCE$3;
					if (!consumeNonTerminal(typeRefConsumer, "type", false, false, getRule().ele000110ParserRuleCallTypeRef())) {
						marker$4.rollback();
						break SEQUENCE$3;
					}
					continue OPTION$2;
				}
				break OPTION$2;
			} while(false);
			
			if (!consumeKeyword(getRule().ele001KeywordColon(), null, false, false))
				break SEQUENCE$0;
			if (!consumeTerminal(stringConsumer, "body", false, false, getRule().ele010LexerRuleCallSTRING()))
				break SEQUENCE$0;
			if (!consumeKeyword(getRule().ele1KeywordSemicolon(), null, false, false))
				break SEQUENCE$0;
			return true;
		}
		return false;
	}

	private LexerRuleElements getRule() {
		return XtextGrammarAccess.INSTANCE.prLexerRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "LexerRule";
	}

	@Override
	protected EObject getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prLexerRule().getRule();
	}

	public void setIdConsumer(ITerminalConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}

	public void setTypeRefConsumer(INonTerminalConsumer typeRefConsumer) {
		this.typeRefConsumer = typeRefConsumer;
	}

	public void setStringConsumer(ITerminalConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
}

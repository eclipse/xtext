/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.xtext.parser.handwritten.consumers.methodCalls;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.services.XtextGrammarAccess;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AbstractRuleConsumer extends NonTerminalConsumer {

	private INonTerminalConsumer lexerRuleConsumer;

	private INonTerminalConsumer parserRuleConsumer;

	public AbstractRuleConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}

	protected boolean doConsume() throws Exception {
		if (consumeNonTerminal(lexerRuleConsumer, null, false, false, XtextGrammarAccess.INSTANCE.prAbstractRule().ele00ParserRuleCallLexerRule()))
			return true;
		if (consumeNonTerminal(parserRuleConsumer, null, false, false, XtextGrammarAccess.INSTANCE.prAbstractRule().ele01ParserRuleCallParserRule()))
			return true;
		if (consumeNonTerminal(parserRuleConsumer, null, false, false, XtextGrammarAccess.INSTANCE.prAbstractRule().ele1ParserRuleCallTerminalRule()))
			return true;
		return false;
	}

	protected EObject getGrammarElement() {
		return XtextGrammarAccess.INSTANCE.prAbstractRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractRule";
	}

	public void setLexerRuleConsumer(INonTerminalConsumer lexerRuleConsumer) {
		this.lexerRuleConsumer = lexerRuleConsumer;
	}

	public void setParserRuleConsumer(INonTerminalConsumer parserRuleConsumer) {
		this.parserRuleConsumer = parserRuleConsumer;
	}

}

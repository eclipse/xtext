/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.grammarinheritance.parser.packrat.consumers;

import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.AbstractTestLanguageParserConfiguration;
import org.eclipse.xtext.grammarinheritance.parser.packrat.ConcreteTestLanguageParserConfiguration;
import org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IParserConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.AbstractRuleAwareTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AbstractTestLanguageREALConsumer extends AbstractRuleAwareTerminalConsumer {

	private XtextBuiltinINTConsumer intConsumer;
	
	public AbstractTestLanguageREALConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor) {
		super(input, markerFactory, tokenAcceptor);
	}

	@Override
	protected LexerRule doGetRule() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.lrREAL();
	}

	@Override
	protected int doConsume() {
		if (intConsumer.consume()!=ConsumeResult.SUCCESS) return ConsumeResult.EMPTY_MATCH;
		if (!readChar('.')) return ConsumeResult.EMPTY_MATCH;
		if (intConsumer.consume()!=ConsumeResult.SUCCESS) return ConsumeResult.EMPTY_MATCH;
		return ConsumeResult.SUCCESS;
	}

}

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
import org.eclipse.xtext.parser.packrat.consumers.LexerRuleAwareTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AbstractTestLanguageREALConsumer extends LexerRuleAwareTerminalConsumer {

	private XtextBuiltinINTConsumer intConsumer;
	
	public AbstractTestLanguageREALConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor) {
		super(input, markerFactory, tokenAcceptor);
	}

	@Override
	protected LexerRule doGetLexerRule() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.lrREAL();
	}

	@Override
	protected boolean doConsume() {
		if (!intConsumer.consume()) return false;
		if (!readChar('.')) return false;
		if (!intConsumer.consume()) return false;
		return true;
	}

	@Override
	public void initFields(IParserConfiguration configuration) {
		super.initFields(configuration);
		if (configuration instanceof AbstractTestLanguageParserConfiguration)
			intConsumer = ((AbstractTestLanguageParserConfiguration)configuration).getIntConsumer();
		else if (configuration instanceof ConcreteTestLanguageParserConfiguration)
			intConsumer = ((ConcreteTestLanguageParserConfiguration)configuration).getIntConsumer();
	}

}

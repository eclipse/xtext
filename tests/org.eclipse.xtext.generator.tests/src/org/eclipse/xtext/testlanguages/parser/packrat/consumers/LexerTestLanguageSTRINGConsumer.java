/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.testlanguages.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.consumers.AbstractRuleAwareTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;
import org.eclipse.xtext.testlanguages.services.LexerTestLanguageGrammarAccess;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LexerTestLanguageSTRINGConsumer extends AbstractRuleAwareTerminalConsumer {

	public LexerTestLanguageSTRINGConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor) {
		super(input, markerFactory, tokenAcceptor);
	}

	@Override
	protected boolean doConsume() {
		if (!readChar('#')) return false;
		if (!readChar('B')) return false;
		readChars('B');
 		return true;
	}

	@Override
	protected LexerRule doGetRule() {
		return LexerTestLanguageGrammarAccess.INSTANCE.lrSTRING();
	}

	

}

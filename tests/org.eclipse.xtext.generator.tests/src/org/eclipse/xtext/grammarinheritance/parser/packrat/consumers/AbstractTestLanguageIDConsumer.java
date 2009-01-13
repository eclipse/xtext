/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.grammarinheritance.parser.packrat.consumers;

import org.eclipse.xtext.LexerRule;
import org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.characters.ICharacterClass;
import org.eclipse.xtext.parser.packrat.consumers.LexerRuleAwareTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AbstractTestLanguageIDConsumer extends LexerRuleAwareTerminalConsumer {

	// ('a'..'z'|'A'..'Z'|'_')
	static final ICharacterClass IDConsumer$$1 = ICharacterClass.Factory.join(
			ICharacterClass.Factory.createRange('a', 'z'),
			ICharacterClass.Factory.createRange('A', 'Z'),
			ICharacterClass.Factory.create('ö', 'ä', 'ü'),
			ICharacterClass.Factory.create('_')
	);
	// ('a'..'z'|'A'..'Z'|'_'|'0'..'9')
	static final ICharacterClass IDConsumer$$2 = ICharacterClass.Factory.join(
			ICharacterClass.Factory.createRange('a', 'z'),
			ICharacterClass.Factory.createRange('A', 'Z'),
			ICharacterClass.Factory.create('_'),
			ICharacterClass.Factory.createRange('0', '9')
	);
	
	public AbstractTestLanguageIDConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor) {
		super(input, markerFactory, tokenAcceptor);
	}

	public boolean doConsume() {
		boolean result = true;
		readChar('^');
		if (result) {
			result = readChar(IDConsumer$$1);
			if (result) {
				readChars(IDConsumer$$2);
			}
		}
		return result;
	}

	@Override
	protected LexerRule doGetLexerRule() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.lrID();
	}

}

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
import org.eclipse.xtext.parser.packrat.consumers.AbstractRuleAwareTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AbstractTestLanguageIDConsumer extends AbstractRuleAwareTerminalConsumer {

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
	
	public AbstractTestLanguageIDConsumer(ITerminalConsumerConfiguration configuration) {
		super(configuration);
	}

	public int doConsume() {
		boolean result = true;
		readChar('^');
		if (result) {
			result = readChar(IDConsumer$$1);
			if (result) {
				readChars(IDConsumer$$2);
			}
		}
		return result ? ConsumeResult.SUCCESS : ConsumeResult.EMPTY_MATCH;
	}

	@Override
	protected LexerRule doGetRule() {
		return AbstractTestLanguageGrammarAccess.INSTANCE.lrID();
	}

}

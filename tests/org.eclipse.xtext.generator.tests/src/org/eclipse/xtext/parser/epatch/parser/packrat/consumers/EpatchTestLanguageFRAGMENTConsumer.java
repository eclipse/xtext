/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parser.epatch.parser.packrat.consumers;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.packrat.consumers.AbstractRuleAwareTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EpatchTestLanguageFRAGMENTConsumer extends AbstractRuleAwareTerminalConsumer {

	private static ICharacterClass fragmentPart = ICharacterClass.Factory.join(
			ICharacterClass.Factory.createRange('a', 'z'),
			ICharacterClass.Factory.createRange('A', 'Z'),
			ICharacterClass.Factory.createRange('0', '9'),
			ICharacterClass.Factory.create('_', '/', '[', ']', '{', '}', '.', '@')	
	);
	public EpatchTestLanguageFRAGMENTConsumer(ITerminalConsumerConfiguration configuration) {
		super(configuration);
	}

	@Override
	protected AbstractRule doGetRule() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.lrFRAGMENT();
	}

	@Override
	protected int doConsume() {
		// '#' ('a'..'z'|'A'..'Z'|'0'..'9'|'_'|'/'|'['|']'|'{'|'}'|'.'|'@')+;
		if (readChar('#')) {
			if (readChar(fragmentPart)) {
				readChars(fragmentPart);
				return ConsumeResult.SUCCESS;
			}
		} 
		return ConsumeResult.EMPTY_MATCH;
	}

}

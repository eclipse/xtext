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
import org.eclipse.xtext.parser.packrat.consumers.AbstractRuleAwareTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.services.XtextGrammarAccess;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public final class XtextBuiltinIDConsumer extends AbstractRuleAwareTerminalConsumer {
	
	// ('a'..'z'|'A'..'Z'|'_')
	public static final ICharacterClass IDConsumer$$1 = ICharacterClass.Factory.join(
			ICharacterClass.Factory.createRange('a', 'z'),
			ICharacterClass.Factory.createRange('A', 'Z'),
			ICharacterClass.Factory.create('_')
	);
	// ('a'..'z'|'A'..'Z'|'_'|'0'..'9')
	public static final ICharacterClass IDConsumer$$2 = ICharacterClass.Factory.join(
			ICharacterClass.Factory.createRange('a', 'z'),
			ICharacterClass.Factory.createRange('A', 'Z'),
			ICharacterClass.Factory.create('_'),
			ICharacterClass.Factory.createRange('0', '9')
	);
	
	public XtextBuiltinIDConsumer(ITerminalConsumerConfiguration configuration) {
		super(configuration);
	}

	public int doConsume() {
		//			Marker marker = mark(); // not needed because we have no alternatives
		boolean result = true;
		// ('^')?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*
		// sequence
		// ('^')?
		readChar('^'); // cardinality ? does not affect result
		if (result) {
			// ('a'..'z'|'A'..'Z'|'_')
			result = readChar(IDConsumer$$1);
			if (result) {
				// ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*
				readChars(IDConsumer$$2); // cardinality * does not affect result
			}
		}
		return result ? ConsumeResult.SUCCESS : ConsumeResult.EMPTY_MATCH;
	}

	@Override
	protected LexerRule doGetRule() {
		return (LexerRule) GrammarUtil.findRuleForName(XtextGrammarAccess.INSTANCE.getGrammar(), "ID");
	}
}
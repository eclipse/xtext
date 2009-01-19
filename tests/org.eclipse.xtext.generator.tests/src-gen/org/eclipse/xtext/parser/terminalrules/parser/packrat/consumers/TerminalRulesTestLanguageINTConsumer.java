/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.AbstractRuleAwareTerminalConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.parser.terminalrules.services.TerminalRulesTestLanguageGrammarAccess;


@SuppressWarnings("unused")
public final class TerminalRulesTestLanguageINTConsumer extends AbstractRuleAwareTerminalConsumer {


	public TerminalRulesTestLanguageINTConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor) {
		super(input, markerFactory, tokenAcceptor);
	}
	
	protected boolean doConsume() {
		return consumeCharacterRange$1();
	}

	protected boolean consumeCharacterRange$1() {
		if (doConsumeCharacterRange$1()) {
			while(doConsumeCharacterRange$1()) {}
			return true;
		}
		return false;
	}

	protected boolean doConsumeCharacterRange$1() {
		return readCharBetween('0', '9');
	}

	public AbstractRule doGetRule() {
		return TerminalRulesTestLanguageGrammarAccess.INSTANCE.prINT().getRule();
	}
	
}

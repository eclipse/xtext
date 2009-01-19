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
public final class TerminalRulesTestLanguageANY_OTHERConsumer extends AbstractRuleAwareTerminalConsumer {


	public TerminalRulesTestLanguageANY_OTHERConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor) {
		super(input, markerFactory, tokenAcceptor);
	}
	
	protected boolean doConsume() {
		return consumeWildcard$1();
	}

	protected boolean consumeWildcard$1() {
		return readAnyChar();
	}

	public AbstractRule doGetRule() {
		return TerminalRulesTestLanguageGrammarAccess.INSTANCE.prANY_OTHER().getRule();
	}
	
}

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
public final class TerminalRulesTestLanguageWSConsumer extends AbstractRuleAwareTerminalConsumer {


	public TerminalRulesTestLanguageWSConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor) {
		super(input, markerFactory, tokenAcceptor);
	}
	
	protected boolean doConsume() {
		return consumeAlternatives$1();
	}

	protected boolean consumeAlternatives$1() {
		if (doConsumeAlternatives$1()) {
			while(doConsumeAlternatives$1()) {}
			return true;
		}
		return false;
	}

	protected boolean doConsumeAlternatives$1() {
		if (consumeKeyword$4())
			return true;
		if (consumeKeyword$5())
			return true;
		if (consumeKeyword$6())
			return true;
		if (consumeKeyword$7())
			return true;
		return false;
	}

	protected boolean consumeKeyword$4() {
		return readChar(' ');
	}

	protected boolean consumeKeyword$5() {
		return readString("\t");
	}

	protected boolean consumeKeyword$6() {
		return readString("\r");
	}

	protected boolean consumeKeyword$7() {
		return readString("\n");
	}

	public AbstractRule doGetRule() {
		return TerminalRulesTestLanguageGrammarAccess.INSTANCE.prWS().getRule();
	}
	
}

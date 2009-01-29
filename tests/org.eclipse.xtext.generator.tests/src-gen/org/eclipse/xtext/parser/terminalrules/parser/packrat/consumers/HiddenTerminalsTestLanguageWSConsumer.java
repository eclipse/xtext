/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.consumers.AbstractRuleAwareTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.parser.terminalrules.services.HiddenTerminalsTestLanguageGrammarAccess;


@SuppressWarnings("unused")
public final class HiddenTerminalsTestLanguageWSConsumer extends AbstractRuleAwareTerminalConsumer {


	public HiddenTerminalsTestLanguageWSConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor) {
		super(input, markerFactory, tokenAcceptor);
	}
	
	protected int doConsume() {
		return consumeAlternatives$1() ? ConsumeResult.SUCCESS : ConsumeResult.EMPTY_MATCH;
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
		return readChar('\t');
	}

	protected boolean consumeKeyword$6() {
		return readChar('\r');
	}

	protected boolean consumeKeyword$7() {
		return readChar('\n');
	}

	public AbstractRule doGetRule() {
		return HiddenTerminalsTestLanguageGrammarAccess.INSTANCE.prWS().getRule();
	}
	
}

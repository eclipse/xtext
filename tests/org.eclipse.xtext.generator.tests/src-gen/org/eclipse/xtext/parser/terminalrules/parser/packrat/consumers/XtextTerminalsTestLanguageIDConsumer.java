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

import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;


@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageIDConsumer extends AbstractRuleAwareTerminalConsumer {


	public XtextTerminalsTestLanguageIDConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor) {
		super(input, markerFactory, tokenAcceptor);
	}
	
	protected boolean doConsume() {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() {
		final IMarker marker = mark();
		if (!consumeKeyword$3()) {
			marker.rollback();
			return false;
		}
		if (!consumeAlternatives$4()) {
			marker.rollback();
			return false;
		}
		if (!consumeAlternatives$13()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$3() {
		doConsumeKeyword$3();
		return true;
	}

	protected boolean doConsumeKeyword$3() {
		return readChar('^');
	}

	protected boolean consumeAlternatives$4() {
		if (consumeCharacterRange$6())
			return true;
		if (consumeCharacterRange$9())
			return true;
		if (consumeKeyword$12())
			return true;
		return false;
	}

	protected boolean consumeCharacterRange$6() {
		return readCharBetween('a', 'z');
	}

	protected boolean consumeCharacterRange$9() {
		return readCharBetween('A', 'Z');
	}

	protected boolean consumeKeyword$12() {
		return readChar('_');
	}

	protected boolean consumeAlternatives$13() {
		while(doConsumeAlternatives$13()) {}
		return true;
	}

	protected boolean doConsumeAlternatives$13() {
		if (consumeCharacterRange$16())
			return true;
		if (consumeCharacterRange$19())
			return true;
		if (consumeKeyword$22())
			return true;
		if (consumeCharacterRange$23())
			return true;
		return false;
	}

	protected boolean consumeCharacterRange$16() {
		return readCharBetween('a', 'z');
	}

	protected boolean consumeCharacterRange$19() {
		return readCharBetween('A', 'Z');
	}

	protected boolean consumeKeyword$22() {
		return readChar('_');
	}

	protected boolean consumeCharacterRange$23() {
		return readCharBetween('0', '9');
	}

	public AbstractRule doGetRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prID().getRule();
	}
	
}

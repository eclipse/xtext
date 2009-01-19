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
public final class TerminalRulesTestLanguageML_COMMENTConsumer extends AbstractRuleAwareTerminalConsumer {


	public TerminalRulesTestLanguageML_COMMENTConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor) {
		super(input, markerFactory, tokenAcceptor);
	}
	
	protected boolean doConsume() {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() {
		final IMarker marker = mark();
		if (!consumeKeyword$2()) {
			marker.rollback();
			return false;
		}
		if (!consumeUpToToken$3()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$2() {
		return readString("/*");
	}

	protected boolean consumeUpToToken$3() {
		final IMarker marker = mark();
		while(!eof()) {
			if(consumeKeyword$4())
				return true;
			incOffset();
		}
		marker.rollback();
		return false;
	}

	protected boolean consumeKeyword$4() {
		return readString("*/");
	}

	public AbstractRule doGetRule() {
		return TerminalRulesTestLanguageGrammarAccess.INSTANCE.prML_COMMENT().getRule();
	}
	
}

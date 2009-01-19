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
public final class XtextTerminalsTestLanguageSL_COMMENTConsumer extends AbstractRuleAwareTerminalConsumer {


	public XtextTerminalsTestLanguageSL_COMMENTConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		if (!consumeNegatedToken$4()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$8()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$3() {
		return readString("//");
	}

	protected boolean consumeNegatedToken$4() {
		while(doConsumeNegatedToken$4()) {}
		return true;
	}

	protected boolean doConsumeNegatedToken$4() {
		final IMarker marker = mark();
		if (!eof() && !consumeAlternatives$5()) {
			incOffset();
			return true;
		}
		marker.rollback();
		return false;
	}

	protected boolean consumeAlternatives$5() {
		if (consumeKeyword$6())
			return true;
		if (consumeKeyword$7())
			return true;
		return false;
	}

	protected boolean consumeKeyword$6() {
		return readString("\n");
	}

	protected boolean consumeKeyword$7() {
		return readString("\r");
	}

	protected boolean consumeGroup$8() {
		doConsumeGroup$8();
		return true;
	}

	protected boolean doConsumeGroup$8() {
		final IMarker marker = mark();
		if (!consumeKeyword$9()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$10()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$9() {
		doConsumeKeyword$9();
		return true;
	}

	protected boolean doConsumeKeyword$9() {
		return readString("\r");
	}

	protected boolean consumeKeyword$10() {
		return readString("\n");
	}

	public AbstractRule doGetRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prSL_COMMENT().getRule();
	}
	
}

/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.AbstractRuleAwareTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;

import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;


@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageSL_COMMENTConsumer extends AbstractRuleAwareTerminalConsumer {


	public XtextTerminalsTestLanguageSL_COMMENTConsumer(ITerminalConsumerConfiguration configuration) {
		super(configuration);
	}
	
	protected int doConsume() {
		return consumeGroup$1() ? ConsumeResult.SUCCESS : ConsumeResult.EMPTY_MATCH;
	}

	protected boolean consumeGroup$1() {
		final int marker = mark();
		if (!consumeKeyword$3()) {
			rollbackTo(marker);
			return false;
		}
		if (!consumeNegatedToken$4()) {
			rollbackTo(marker);
			return false;
		}
		if (!consumeGroup$8()) {
			rollbackTo(marker);
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
		final int marker = mark();
		if (!eof() && !consumeAlternatives$5()) {
			incOffset();
			return true;
		}
		rollbackTo(marker);
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
		return readChar('\n');
	}

	protected boolean consumeKeyword$7() {
		return readChar('\r');
	}

	protected boolean consumeGroup$8() {
		doConsumeGroup$8();
		return true;
	}

	protected boolean doConsumeGroup$8() {
		final int marker = mark();
		if (!consumeKeyword$9()) {
			rollbackTo(marker);
			return false;
		}
		if (!consumeKeyword$10()) {
			rollbackTo(marker);
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$9() {
		doConsumeKeyword$9();
		return true;
	}

	protected boolean doConsumeKeyword$9() {
		return readChar('\r');
	}

	protected boolean consumeKeyword$10() {
		return readChar('\n');
	}

	public AbstractRule doGetRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prSL_COMMENT().getRule();
	}
	
}

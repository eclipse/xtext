/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.AbstractRuleAwareTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;

import org.eclipse.xtext.parser.terminalrules.services.TerminalRulesTestLanguageGrammarAccess;


@SuppressWarnings("unused")
public final class TerminalRulesTestLanguageSTRINGConsumer extends AbstractRuleAwareTerminalConsumer {


	public TerminalRulesTestLanguageSTRINGConsumer(ITerminalConsumerConfiguration configuration) {
		super(configuration);
	}
	
	protected int doConsume() {
		return consumeAlternatives$1() ? ConsumeResult.SUCCESS : ConsumeResult.EMPTY_MATCH;
	}

	protected boolean consumeAlternatives$1() {
		if (consumeGroup$2())
			return true;
		if (consumeGroup$28())
			return true;
		return false;
	}

	protected boolean consumeGroup$2() {
		final int marker = mark();
		if (!consumeKeyword$4()) {
			rollbackTo(marker);
			return false;
		}
		if (!consumeAlternatives$5()) {
			rollbackTo(marker);
			return false;
		}
		if (!consumeKeyword$27()) {
			rollbackTo(marker);
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$4() {
		return readChar('\"');
	}

	protected boolean consumeAlternatives$5() {
		while(doConsumeAlternatives$5()) {}
		return true;
	}

	protected boolean doConsumeAlternatives$5() {
		if (consumeGroup$6())
			return true;
		if (consumeNegatedToken$23())
			return true;
		return false;
	}

	protected boolean consumeGroup$6() {
		final int marker = mark();
		if (!consumeKeyword$7()) {
			rollbackTo(marker);
			return false;
		}
		if (!consumeAlternatives$8()) {
			rollbackTo(marker);
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$7() {
		return readChar('\\');
	}

	protected boolean consumeAlternatives$8() {
		if (consumeKeyword$15())
			return true;
		if (consumeKeyword$16())
			return true;
		if (consumeKeyword$17())
			return true;
		if (consumeKeyword$18())
			return true;
		if (consumeKeyword$19())
			return true;
		if (consumeKeyword$20())
			return true;
		if (consumeKeyword$21())
			return true;
		if (consumeKeyword$22())
			return true;
		return false;
	}

	protected boolean consumeKeyword$15() {
		return readChar('b');
	}

	protected boolean consumeKeyword$16() {
		return readChar('t');
	}

	protected boolean consumeKeyword$17() {
		return readChar('n');
	}

	protected boolean consumeKeyword$18() {
		return readChar('f');
	}

	protected boolean consumeKeyword$19() {
		return readChar('r');
	}

	protected boolean consumeKeyword$20() {
		return readChar('\"');
	}

	protected boolean consumeKeyword$21() {
		return readChar('\'');
	}

	protected boolean consumeKeyword$22() {
		return readChar('\\');
	}

	protected boolean consumeNegatedToken$23() {
		final int marker = mark();
		if (!eof() && !consumeAlternatives$24()) {
			incOffset();
			return true;
		}
		rollbackTo(marker);
		return false;
	}

	protected boolean consumeAlternatives$24() {
		if (consumeKeyword$25())
			return true;
		if (consumeKeyword$26())
			return true;
		return false;
	}

	protected boolean consumeKeyword$25() {
		return readChar('\\');
	}

	protected boolean consumeKeyword$26() {
		return readChar('\"');
	}

	protected boolean consumeKeyword$27() {
		return readChar('\"');
	}

	protected boolean consumeGroup$28() {
		final int marker = mark();
		if (!consumeKeyword$30()) {
			rollbackTo(marker);
			return false;
		}
		if (!consumeAlternatives$31()) {
			rollbackTo(marker);
			return false;
		}
		if (!consumeKeyword$53()) {
			rollbackTo(marker);
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$30() {
		return readChar('\'');
	}

	protected boolean consumeAlternatives$31() {
		while(doConsumeAlternatives$31()) {}
		return true;
	}

	protected boolean doConsumeAlternatives$31() {
		if (consumeGroup$32())
			return true;
		if (consumeNegatedToken$49())
			return true;
		return false;
	}

	protected boolean consumeGroup$32() {
		final int marker = mark();
		if (!consumeKeyword$33()) {
			rollbackTo(marker);
			return false;
		}
		if (!consumeAlternatives$34()) {
			rollbackTo(marker);
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$33() {
		return readChar('\\');
	}

	protected boolean consumeAlternatives$34() {
		if (consumeKeyword$41())
			return true;
		if (consumeKeyword$42())
			return true;
		if (consumeKeyword$43())
			return true;
		if (consumeKeyword$44())
			return true;
		if (consumeKeyword$45())
			return true;
		if (consumeKeyword$46())
			return true;
		if (consumeKeyword$47())
			return true;
		if (consumeKeyword$48())
			return true;
		return false;
	}

	protected boolean consumeKeyword$41() {
		return readChar('b');
	}

	protected boolean consumeKeyword$42() {
		return readChar('t');
	}

	protected boolean consumeKeyword$43() {
		return readChar('n');
	}

	protected boolean consumeKeyword$44() {
		return readChar('f');
	}

	protected boolean consumeKeyword$45() {
		return readChar('r');
	}

	protected boolean consumeKeyword$46() {
		return readChar('\"');
	}

	protected boolean consumeKeyword$47() {
		return readChar('\'');
	}

	protected boolean consumeKeyword$48() {
		return readChar('\\');
	}

	protected boolean consumeNegatedToken$49() {
		final int marker = mark();
		if (!eof() && !consumeAlternatives$50()) {
			incOffset();
			return true;
		}
		rollbackTo(marker);
		return false;
	}

	protected boolean consumeAlternatives$50() {
		if (consumeKeyword$51())
			return true;
		if (consumeKeyword$52())
			return true;
		return false;
	}

	protected boolean consumeKeyword$51() {
		return readChar('\\');
	}

	protected boolean consumeKeyword$52() {
		return readChar('\'');
	}

	protected boolean consumeKeyword$53() {
		return readChar('\'');
	}

	public AbstractRule doGetRule() {
		return TerminalRulesTestLanguageGrammarAccess.INSTANCE.prSTRING().getRule();
	}
	
}

/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers;

import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.AbstractRuleAwareTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;



@SuppressWarnings("unused")
public final class TerminalRulesTestLanguageIDConsumer extends AbstractRuleAwareTerminalConsumer {


	public TerminalRulesTestLanguageIDConsumer(ITerminalConsumerConfiguration configuration) {
		super(configuration);
	}
	
	@Override
	protected int doConsume() {
		return consumeGroup$1() ? ConsumeResult.SUCCESS : ConsumeResult.EMPTY_MATCH;
	}

	protected boolean consumeGroup$1() {
		final int marker = mark();
		if (!consumeKeyword$3()) {
			rollbackTo(marker);
			return false;
		}
		if (!consumeAlternatives$4()) {
			rollbackTo(marker);
			return false;
		}
		if (!consumeAlternatives$13()) {
			rollbackTo(marker);
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
	
}

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
public final class TerminalRulesTestLanguageANY_OTHERConsumer extends AbstractRuleAwareTerminalConsumer {


	public TerminalRulesTestLanguageANY_OTHERConsumer(ITerminalConsumerConfiguration configuration) {
		super(configuration);
	}
	
	protected int doConsume() {
		return consumeWildcard$1() ? ConsumeResult.SUCCESS : ConsumeResult.EMPTY_MATCH;
	}

	protected boolean consumeWildcard$1() {
		return readAnyChar();
	}

	public AbstractRule doGetRule() {
		return TerminalRulesTestLanguageGrammarAccess.INSTANCE.prANY_OTHER().getRule();
	}
	
}

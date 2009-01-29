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
public final class XtextTerminalsTestLanguageINTConsumer extends AbstractRuleAwareTerminalConsumer {


	public XtextTerminalsTestLanguageINTConsumer(ITerminalConsumerConfiguration configuration) {
		super(configuration);
	}
	
	protected int doConsume() {
		return consumeCharacterRange$1() ? ConsumeResult.SUCCESS : ConsumeResult.EMPTY_MATCH;
	}

	protected boolean consumeCharacterRange$1() {
		if (doConsumeCharacterRange$1()) {
			while(doConsumeCharacterRange$1()) {}
			return true;
		}
		return false;
	}

	protected boolean doConsumeCharacterRange$1() {
		return readCharBetween('0', '9');
	}

	public AbstractRule doGetRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prINT().getRule();
	}
	
}

/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess.AbstractNegatedTokenElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageNegatedTokenConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageUpToTokenConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageAbstractNegatedTokenConsumer extends NonTerminalConsumer {

	private XtextTerminalsTestLanguageNegatedTokenConsumer negatedTokenConsumer;
	private XtextTerminalsTestLanguageUpToTokenConsumer upToTokenConsumer;

	public XtextTerminalsTestLanguageAbstractNegatedTokenConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
	protected int doConsume(int entryPoint) throws Exception {
		return consumeAlternatives$1(entryPoint);
	}

	protected int consumeAlternatives$1(int entryPoint) throws Exception {
		AlternativesResult result = createAlternativesResult();
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result.reset();
			case 0:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$2(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$3(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}

	protected int consumeRuleCall$2(int entryPoint) throws Exception {
		return consumeNonTerminal(negatedTokenConsumer, null, false, false, false, getRule().ele0ParserRuleCallNegatedToken());
	}

	protected int consumeRuleCall$3(int entryPoint) throws Exception {
		return consumeNonTerminal(upToTokenConsumer, null, false, false, false, getRule().ele1ParserRuleCallUpToToken());
	}

	public AbstractNegatedTokenElements getRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractNegatedToken();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractNegatedToken";
	}
	
	public void setNegatedTokenConsumer(XtextTerminalsTestLanguageNegatedTokenConsumer negatedTokenConsumer) {
		this.negatedTokenConsumer = negatedTokenConsumer;
	}
	
	public void setUpToTokenConsumer(XtextTerminalsTestLanguageUpToTokenConsumer upToTokenConsumer) {
		this.upToTokenConsumer = upToTokenConsumer;
	}
	
}

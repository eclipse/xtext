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
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess.AbstractTerminalElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageCrossReferenceConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageKeywordConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageParenthesizedElementConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageRuleCallConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageAbstractTerminalConsumer extends NonTerminalConsumer {

	private XtextTerminalsTestLanguageCrossReferenceConsumer crossReferenceConsumer;
	private XtextTerminalsTestLanguageKeywordConsumer keywordConsumer;
	private XtextTerminalsTestLanguageParenthesizedElementConsumer parenthesizedElementConsumer;
	private XtextTerminalsTestLanguageRuleCallConsumer ruleCallConsumer;

	public XtextTerminalsTestLanguageAbstractTerminalConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
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
				if (result.isAlternativeDone(consumeRuleCall$4(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$5(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 2:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$6(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 3:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$7(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}

	protected int consumeRuleCall$4(int entryPoint) throws Exception {
		return consumeNonTerminal(keywordConsumer, null, false, false, false, getRule().ele000ParserRuleCallKeyword());
	}

	protected int consumeRuleCall$5(int entryPoint) throws Exception {
		return consumeNonTerminal(ruleCallConsumer, null, false, false, false, getRule().ele001ParserRuleCallRuleCall());
	}

	protected int consumeRuleCall$6(int entryPoint) throws Exception {
		return consumeNonTerminal(parenthesizedElementConsumer, null, false, false, false, getRule().ele01ParserRuleCallParenthesizedElement());
	}

	protected int consumeRuleCall$7(int entryPoint) throws Exception {
		return consumeNonTerminal(crossReferenceConsumer, null, false, false, false, getRule().ele1ParserRuleCallCrossReference());
	}

	public AbstractTerminalElements getRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractTerminal();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setCrossReferenceConsumer(XtextTerminalsTestLanguageCrossReferenceConsumer crossReferenceConsumer) {
		this.crossReferenceConsumer = crossReferenceConsumer;
	}
	
	public void setKeywordConsumer(XtextTerminalsTestLanguageKeywordConsumer keywordConsumer) {
		this.keywordConsumer = keywordConsumer;
	}
	
	public void setParenthesizedElementConsumer(XtextTerminalsTestLanguageParenthesizedElementConsumer parenthesizedElementConsumer) {
		this.parenthesizedElementConsumer = parenthesizedElementConsumer;
	}
	
	public void setRuleCallConsumer(XtextTerminalsTestLanguageRuleCallConsumer ruleCallConsumer) {
		this.ruleCallConsumer = ruleCallConsumer;
	}
	
}

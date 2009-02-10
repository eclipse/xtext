/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarAccess.AbstractTerminalElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextCrossReferenceConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextKeywordConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextParenthesizedElementConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextRuleCallConsumer;

@SuppressWarnings("unused")
public final class XtextAbstractTerminalConsumer extends NonTerminalConsumer {

	private XtextCrossReferenceConsumer crossReferenceConsumer;
	private XtextKeywordConsumer keywordConsumer;
	private XtextParenthesizedElementConsumer parenthesizedElementConsumer;
	private XtextRuleCallConsumer ruleCallConsumer;

	public XtextAbstractTerminalConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
	@Override
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
		return XtextGrammarAccess.INSTANCE.prAbstractTerminal();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setCrossReferenceConsumer(XtextCrossReferenceConsumer crossReferenceConsumer) {
		this.crossReferenceConsumer = crossReferenceConsumer;
	}
	
	public void setKeywordConsumer(XtextKeywordConsumer keywordConsumer) {
		this.keywordConsumer = keywordConsumer;
	}
	
	public void setParenthesizedElementConsumer(XtextParenthesizedElementConsumer parenthesizedElementConsumer) {
		this.parenthesizedElementConsumer = parenthesizedElementConsumer;
	}
	
	public void setRuleCallConsumer(XtextRuleCallConsumer ruleCallConsumer) {
		this.ruleCallConsumer = ruleCallConsumer;
	}
	
}

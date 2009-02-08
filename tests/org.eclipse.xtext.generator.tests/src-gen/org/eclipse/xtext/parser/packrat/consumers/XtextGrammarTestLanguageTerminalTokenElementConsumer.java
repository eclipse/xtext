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

import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.TerminalTokenElementElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageAbstractNegatedTokenConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageCharacterRangeConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageParenthesizedTerminalElementConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageRuleCallConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageWildcardConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarTestLanguageTerminalTokenElementConsumer extends NonTerminalConsumer {

	private XtextGrammarTestLanguageAbstractNegatedTokenConsumer abstractNegatedTokenConsumer;
	private XtextGrammarTestLanguageCharacterRangeConsumer characterRangeConsumer;
	private XtextGrammarTestLanguageParenthesizedTerminalElementConsumer parenthesizedTerminalElementConsumer;
	private XtextGrammarTestLanguageRuleCallConsumer ruleCallConsumer;
	private XtextGrammarTestLanguageWildcardConsumer wildcardConsumer;

	public XtextGrammarTestLanguageTerminalTokenElementConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
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
				if (result.isAlternativeDone(consumeRuleCall$5(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$6(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 2:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$7(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 3:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$8(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 4:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$9(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}

	protected int consumeRuleCall$5(int entryPoint) throws Exception {
		return consumeNonTerminal(characterRangeConsumer, null, false, false, false, getRule().ele0000ParserRuleCallCharacterRange());
	}

	protected int consumeRuleCall$6(int entryPoint) throws Exception {
		return consumeNonTerminal(ruleCallConsumer, null, false, false, false, getRule().ele0001ParserRuleCallRuleCall());
	}

	protected int consumeRuleCall$7(int entryPoint) throws Exception {
		return consumeNonTerminal(parenthesizedTerminalElementConsumer, null, false, false, false, getRule().ele001ParserRuleCallParenthesizedTerminalElement());
	}

	protected int consumeRuleCall$8(int entryPoint) throws Exception {
		return consumeNonTerminal(abstractNegatedTokenConsumer, null, false, false, false, getRule().ele01ParserRuleCallAbstractNegatedToken());
	}

	protected int consumeRuleCall$9(int entryPoint) throws Exception {
		return consumeNonTerminal(wildcardConsumer, null, false, false, false, getRule().ele1ParserRuleCallWildcard());
	}

	public TerminalTokenElementElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prTerminalTokenElement();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setAbstractNegatedTokenConsumer(XtextGrammarTestLanguageAbstractNegatedTokenConsumer abstractNegatedTokenConsumer) {
		this.abstractNegatedTokenConsumer = abstractNegatedTokenConsumer;
	}
	
	public void setCharacterRangeConsumer(XtextGrammarTestLanguageCharacterRangeConsumer characterRangeConsumer) {
		this.characterRangeConsumer = characterRangeConsumer;
	}
	
	public void setParenthesizedTerminalElementConsumer(XtextGrammarTestLanguageParenthesizedTerminalElementConsumer parenthesizedTerminalElementConsumer) {
		this.parenthesizedTerminalElementConsumer = parenthesizedTerminalElementConsumer;
	}
	
	public void setRuleCallConsumer(XtextGrammarTestLanguageRuleCallConsumer ruleCallConsumer) {
		this.ruleCallConsumer = ruleCallConsumer;
	}
	
	public void setWildcardConsumer(XtextGrammarTestLanguageWildcardConsumer wildcardConsumer) {
		this.wildcardConsumer = wildcardConsumer;
	}
	
}

/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess.TerminalTokenElementElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageAbstractNegatedTokenConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageCharacterRangeConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageParenthesizedTerminalElementConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageRuleCallConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageWildcardConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageTerminalTokenElementConsumer extends NonTerminalConsumer {

	private XtextTerminalsTestLanguageAbstractNegatedTokenConsumer abstractNegatedTokenConsumer;
	private XtextTerminalsTestLanguageCharacterRangeConsumer characterRangeConsumer;
	private XtextTerminalsTestLanguageParenthesizedTerminalElementConsumer parenthesizedTerminalElementConsumer;
	private XtextTerminalsTestLanguageRuleCallConsumer ruleCallConsumer;
	private XtextTerminalsTestLanguageWildcardConsumer wildcardConsumer;

	public XtextTerminalsTestLanguageTerminalTokenElementConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected int doConsume() throws Exception {
		return consumeAlternatives$1();
	}

	protected int consumeAlternatives$1() throws Exception {
		int result = ConsumeResult.SUCCESS;
		IMarker bestMarker = mark();
		IMarker currentMarker;
		int tempResult;
		currentMarker = bestMarker.copy();
		tempResult = consumeRuleCall$5(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			if (bestMarker != currentMarker) {
				bestMarker.discard();
			}
			currentMarker.release();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker.discard();
			bestMarker = currentMarker;			
			result = tempResult;
		} else {
			currentMarker.discard();
		}
		currentMarker = null;
		bestMarker.activate();
		currentMarker = bestMarker.copy();
		tempResult = consumeRuleCall$6(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			if (bestMarker != currentMarker) {
				bestMarker.discard();
			}
			currentMarker.release();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker.discard();
			bestMarker = currentMarker;			
			result = tempResult;
		} else {
			currentMarker.discard();
		}
		currentMarker = null;
		bestMarker.activate();
		currentMarker = bestMarker.copy();
		tempResult = consumeRuleCall$7(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			if (bestMarker != currentMarker) {
				bestMarker.discard();
			}
			currentMarker.release();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker.discard();
			bestMarker = currentMarker;			
			result = tempResult;
		} else {
			currentMarker.discard();
		}
		currentMarker = null;
		bestMarker.activate();
		currentMarker = bestMarker.copy();
		tempResult = consumeRuleCall$8(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			if (bestMarker != currentMarker) {
				bestMarker.discard();
			}
			currentMarker.release();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker.discard();
			bestMarker = currentMarker;			
			result = tempResult;
		} else {
			currentMarker.discard();
		}
		currentMarker = null;
		bestMarker.activate();
		currentMarker = bestMarker.copy();
		tempResult = consumeRuleCall$9(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			if (bestMarker != currentMarker) {
				bestMarker.discard();
			}
			currentMarker.release();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker.discard();
			bestMarker = currentMarker;			
			result = tempResult;
		} else {
			currentMarker.discard();
		}
		currentMarker = null;
		bestMarker.activate();
		bestMarker.release();
		return result;
	}

	protected int consumeRuleCall$5() throws Exception {
		return consumeNonTerminal(characterRangeConsumer, null, false, false, getRule().ele0000ParserRuleCallCharacterRange());
	}

	protected int consumeRuleCall$6() throws Exception {
		return consumeNonTerminal(ruleCallConsumer, null, false, false, getRule().ele0001ParserRuleCallRuleCall());
	}

	protected int consumeRuleCall$7() throws Exception {
		return consumeNonTerminal(parenthesizedTerminalElementConsumer, null, false, false, getRule().ele001ParserRuleCallParenthesizedTerminalElement());
	}

	protected int consumeRuleCall$8() throws Exception {
		return consumeNonTerminal(abstractNegatedTokenConsumer, null, false, false, getRule().ele01ParserRuleCallAbstractNegatedToken());
	}

	protected int consumeRuleCall$9() throws Exception {
		return consumeNonTerminal(wildcardConsumer, null, false, false, getRule().ele1ParserRuleCallWildcard());
	}

	public TerminalTokenElementElements getRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalTokenElement();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setAbstractNegatedTokenConsumer(XtextTerminalsTestLanguageAbstractNegatedTokenConsumer abstractNegatedTokenConsumer) {
		this.abstractNegatedTokenConsumer = abstractNegatedTokenConsumer;
	}
	
	public void setCharacterRangeConsumer(XtextTerminalsTestLanguageCharacterRangeConsumer characterRangeConsumer) {
		this.characterRangeConsumer = characterRangeConsumer;
	}
	
	public void setParenthesizedTerminalElementConsumer(XtextTerminalsTestLanguageParenthesizedTerminalElementConsumer parenthesizedTerminalElementConsumer) {
		this.parenthesizedTerminalElementConsumer = parenthesizedTerminalElementConsumer;
	}
	
	public void setRuleCallConsumer(XtextTerminalsTestLanguageRuleCallConsumer ruleCallConsumer) {
		this.ruleCallConsumer = ruleCallConsumer;
	}
	
	public void setWildcardConsumer(XtextTerminalsTestLanguageWildcardConsumer wildcardConsumer) {
		this.wildcardConsumer = wildcardConsumer;
	}
	
}

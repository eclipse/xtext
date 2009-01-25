/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.packrat.consumers;

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

	public XtextGrammarTestLanguageTerminalTokenElementConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		currentMarker = bestMarker.fork();
		tempResult = consumeRuleCall$5(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			bestMarker = currentMarker.join(bestMarker);
			bestMarker.commit();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker = currentMarker.join(bestMarker);
			result = tempResult;
		} else {
			bestMarker = bestMarker.join(currentMarker);
		}
		currentMarker = null;
		currentMarker = bestMarker.fork();
		tempResult = consumeRuleCall$6(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			bestMarker = currentMarker.join(bestMarker);
			bestMarker.commit();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker = currentMarker.join(bestMarker);
			result = tempResult;
		} else {
			bestMarker = bestMarker.join(currentMarker);
		}
		currentMarker = null;
		currentMarker = bestMarker.fork();
		tempResult = consumeRuleCall$7(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			bestMarker = currentMarker.join(bestMarker);
			bestMarker.commit();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker = currentMarker.join(bestMarker);
			result = tempResult;
		} else {
			bestMarker = bestMarker.join(currentMarker);
		}
		currentMarker = null;
		currentMarker = bestMarker.fork();
		tempResult = consumeRuleCall$8(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			bestMarker = currentMarker.join(bestMarker);
			bestMarker.commit();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker = currentMarker.join(bestMarker);
			result = tempResult;
		} else {
			bestMarker = bestMarker.join(currentMarker);
		}
		currentMarker = null;
		currentMarker = bestMarker.fork();
		tempResult = consumeRuleCall$9(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			bestMarker = currentMarker.join(bestMarker);
			bestMarker.commit();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker = currentMarker.join(bestMarker);
			result = tempResult;
		} else {
			bestMarker = bestMarker.join(currentMarker);
		}
		currentMarker = null;
		bestMarker.commit();
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

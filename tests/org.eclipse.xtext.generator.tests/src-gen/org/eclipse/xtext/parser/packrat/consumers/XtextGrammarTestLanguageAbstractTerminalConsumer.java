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
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.AbstractTerminalElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageCrossReferenceConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageKeywordConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageParenthesizedElementConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageRuleCallConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarTestLanguageAbstractTerminalConsumer extends NonTerminalConsumer {

	private XtextGrammarTestLanguageCrossReferenceConsumer crossReferenceConsumer;
	private XtextGrammarTestLanguageKeywordConsumer keywordConsumer;
	private XtextGrammarTestLanguageParenthesizedElementConsumer parenthesizedElementConsumer;
	private XtextGrammarTestLanguageRuleCallConsumer ruleCallConsumer;

	public XtextGrammarTestLanguageAbstractTerminalConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		tempResult = consumeRuleCall$4(); 
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
		bestMarker.release();
		return result;
	}

	protected int consumeRuleCall$4() throws Exception {
		return consumeNonTerminal(keywordConsumer, null, false, false, getRule().ele000ParserRuleCallKeyword());
	}

	protected int consumeRuleCall$5() throws Exception {
		return consumeNonTerminal(ruleCallConsumer, null, false, false, getRule().ele001ParserRuleCallRuleCall());
	}

	protected int consumeRuleCall$6() throws Exception {
		return consumeNonTerminal(parenthesizedElementConsumer, null, false, false, getRule().ele01ParserRuleCallParenthesizedElement());
	}

	protected int consumeRuleCall$7() throws Exception {
		return consumeNonTerminal(crossReferenceConsumer, null, false, false, getRule().ele1ParserRuleCallCrossReference());
	}

	public AbstractTerminalElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prAbstractTerminal();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setCrossReferenceConsumer(XtextGrammarTestLanguageCrossReferenceConsumer crossReferenceConsumer) {
		this.crossReferenceConsumer = crossReferenceConsumer;
	}
	
	public void setKeywordConsumer(XtextGrammarTestLanguageKeywordConsumer keywordConsumer) {
		this.keywordConsumer = keywordConsumer;
	}
	
	public void setParenthesizedElementConsumer(XtextGrammarTestLanguageParenthesizedElementConsumer parenthesizedElementConsumer) {
		this.parenthesizedElementConsumer = parenthesizedElementConsumer;
	}
	
	public void setRuleCallConsumer(XtextGrammarTestLanguageRuleCallConsumer ruleCallConsumer) {
		this.ruleCallConsumer = ruleCallConsumer;
	}
	
}

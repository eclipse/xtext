/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat.consumers;

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

import org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageGrammarAccess.TermElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.SimpleExpressionsTestLanguageAtomConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.SimpleExpressionsTestLanguageParensConsumer;

@SuppressWarnings("unused")
public final class SimpleExpressionsTestLanguageTermConsumer extends NonTerminalConsumer {

	private SimpleExpressionsTestLanguageAtomConsumer atomConsumer;
	private SimpleExpressionsTestLanguageParensConsumer parensConsumer;

	public SimpleExpressionsTestLanguageTermConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		tempResult = consumeRuleCall$2(); 
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
		tempResult = consumeRuleCall$3(); 
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

	protected int consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(atomConsumer, null, false, false, getRule().ele0ParserRuleCallAtom());
	}

	protected int consumeRuleCall$3() throws Exception {
		return consumeNonTerminal(parensConsumer, null, false, false, getRule().ele1ParserRuleCallParens());
	}

	public TermElements getRule() {
		return SimpleExpressionsTestLanguageGrammarAccess.INSTANCE.prTerm();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Expression";
	}
	
	public void setAtomConsumer(SimpleExpressionsTestLanguageAtomConsumer atomConsumer) {
		this.atomConsumer = atomConsumer;
	}
	
	public void setParensConsumer(SimpleExpressionsTestLanguageParensConsumer parensConsumer) {
		this.parensConsumer = parensConsumer;
	}
	
}

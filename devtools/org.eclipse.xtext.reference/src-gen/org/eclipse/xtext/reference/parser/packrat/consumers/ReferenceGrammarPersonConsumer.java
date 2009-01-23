/*
Generated with Xtext
*/
package org.eclipse.xtext.reference.parser.packrat.consumers;

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

import org.eclipse.xtext.reference.services.ReferenceGrammarGrammarAccess;
import org.eclipse.xtext.reference.services.ReferenceGrammarGrammarAccess.PersonElements;

import org.eclipse.xtext.reference.parser.packrat.consumers.ReferenceGrammarErwachsenerConsumer;
import org.eclipse.xtext.reference.parser.packrat.consumers.ReferenceGrammarKindConsumer;

@SuppressWarnings("unused")
public final class ReferenceGrammarPersonConsumer extends NonTerminalConsumer {

	private ReferenceGrammarErwachsenerConsumer erwachsenerConsumer;
	private ReferenceGrammarKindConsumer kindConsumer;

	public ReferenceGrammarPersonConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		return consumeNonTerminal(kindConsumer, null, false, false, getRule().ele0ParserRuleCallKind());
	}

	protected int consumeRuleCall$3() throws Exception {
		return consumeNonTerminal(erwachsenerConsumer, null, false, false, getRule().ele1ParserRuleCallErwachsener());
	}

	public PersonElements getRule() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prPerson();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Person";
	}
	
	public void setErwachsenerConsumer(ReferenceGrammarErwachsenerConsumer erwachsenerConsumer) {
		this.erwachsenerConsumer = erwachsenerConsumer;
	}
	
	public void setKindConsumer(ReferenceGrammarKindConsumer kindConsumer) {
		this.kindConsumer = kindConsumer;
	}
	
}

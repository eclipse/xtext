/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat.consumers;

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

import org.eclipse.xtext.example.services.DomainmodelGrammarAccess;
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess.TypedElementElements;

import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelFeatureConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelParameterConsumer;

@SuppressWarnings("unused")
public final class DomainmodelTypedElementConsumer extends NonTerminalConsumer {

	private DomainmodelFeatureConsumer featureConsumer;
	private DomainmodelParameterConsumer parameterConsumer;

	public DomainmodelTypedElementConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		tempResult = consumeRuleCall$2(); 
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
		tempResult = consumeRuleCall$3(); 
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

	protected int consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(featureConsumer, null, false, false, getRule().ele0ParserRuleCallFeature());
	}

	protected int consumeRuleCall$3() throws Exception {
		return consumeNonTerminal(parameterConsumer, null, false, false, getRule().ele1ParserRuleCallParameter());
	}

	public TypedElementElements getRule() {
		return DomainmodelGrammarAccess.INSTANCE.prTypedElement();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TypedElement";
	}
	
	public void setFeatureConsumer(DomainmodelFeatureConsumer featureConsumer) {
		this.featureConsumer = featureConsumer;
	}
	
	public void setParameterConsumer(DomainmodelParameterConsumer parameterConsumer) {
		this.parameterConsumer = parameterConsumer;
	}
	
}

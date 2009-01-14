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
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.example.services.DomainmodelGrammarAccess;
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess.TypedElementElements;

import org.eclipse.xtext.example.parser.packrat.DomainmodelDelimiters;

import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelParameterConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelFeatureConsumer;

@SuppressWarnings("unused")
public final class DomainmodelTypedElementConsumer extends NonTerminalConsumer {

	private DomainmodelParameterConsumer parameterConsumer;
	private DomainmodelFeatureConsumer featureConsumer;

	public DomainmodelTypedElementConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeAlternatives$1();
	}

	protected boolean consumeAlternatives$1() throws Exception {
		if (consumeRuleCall$2())
			return true;
		if (consumeRuleCall$3())
			return true;
		return false;
	}

	protected boolean consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(featureConsumer, null, false, false, getRule().ele0ParserRuleCallFeature());
	}

	protected boolean consumeRuleCall$3() throws Exception {
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
	
	public void setParameterConsumer(DomainmodelParameterConsumer parameterConsumer) {
		this.parameterConsumer = parameterConsumer;
	}
	
	public void setFeatureConsumer(DomainmodelFeatureConsumer featureConsumer) {
		this.featureConsumer = featureConsumer;
	}
	
}

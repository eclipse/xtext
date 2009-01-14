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
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess.FeatureElements;

import org.eclipse.xtext.example.parser.packrat.DomainmodelDelimiters;

import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelStructuralFeatureConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelOperationConsumer;

@SuppressWarnings("unused")
public final class DomainmodelFeatureConsumer extends NonTerminalConsumer {

	private DomainmodelStructuralFeatureConsumer structuralFeatureConsumer;
	private DomainmodelOperationConsumer operationConsumer;

	public DomainmodelFeatureConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		return consumeNonTerminal(structuralFeatureConsumer, null, false, false, getRule().ele0ParserRuleCallStructuralFeature());
	}

	protected boolean consumeRuleCall$3() throws Exception {
		return consumeNonTerminal(operationConsumer, null, false, false, getRule().ele1ParserRuleCallOperation());
	}

	public FeatureElements getRule() {
		return DomainmodelGrammarAccess.INSTANCE.prFeature();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Feature";
	}
	
	public void setStructuralFeatureConsumer(DomainmodelStructuralFeatureConsumer structuralFeatureConsumer) {
		this.structuralFeatureConsumer = structuralFeatureConsumer;
	}
	
	public void setOperationConsumer(DomainmodelOperationConsumer operationConsumer) {
		this.operationConsumer = operationConsumer;
	}
	
}

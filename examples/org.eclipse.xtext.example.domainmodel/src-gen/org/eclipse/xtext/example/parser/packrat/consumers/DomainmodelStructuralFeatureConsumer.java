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
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.example.services.DomainmodelGrammarAccess;
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess.StructuralFeatureElements;

import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelAttributeConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelReferenceConsumer;

@SuppressWarnings("unused")
public final class DomainmodelStructuralFeatureConsumer extends NonTerminalConsumer {

	private DomainmodelAttributeConsumer attributeConsumer;
	private DomainmodelReferenceConsumer referenceConsumer;

	public DomainmodelStructuralFeatureConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		return consumeNonTerminal(attributeConsumer, null, false, false, getRule().ele0ParserRuleCallAttribute());
	}

	protected boolean consumeRuleCall$3() throws Exception {
		return consumeNonTerminal(referenceConsumer, null, false, false, getRule().ele1ParserRuleCallReference());
	}

	public StructuralFeatureElements getRule() {
		return DomainmodelGrammarAccess.INSTANCE.prStructuralFeature();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "StructuralFeature";
	}
	
	public void setAttributeConsumer(DomainmodelAttributeConsumer attributeConsumer) {
		this.attributeConsumer = attributeConsumer;
	}
	
	public void setReferenceConsumer(DomainmodelReferenceConsumer referenceConsumer) {
		this.referenceConsumer = referenceConsumer;
	}
	
}

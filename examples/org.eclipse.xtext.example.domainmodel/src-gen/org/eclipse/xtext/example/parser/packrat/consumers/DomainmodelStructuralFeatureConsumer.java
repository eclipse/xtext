/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.example.services.DomainmodelGrammarAccess;
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess.StructuralFeatureElements;

import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelAttributeConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelReferenceConsumer;

@SuppressWarnings("unused")
public final class DomainmodelStructuralFeatureConsumer extends NonTerminalConsumer {

	private StructuralFeatureElements rule;
	
	private INonTerminalConsumer attributeConsumer;
	private INonTerminalConsumer referenceConsumer;

	public DomainmodelStructuralFeatureConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
	@Override
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
				if (result.isAlternativeDone(consumeRuleCall$2(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$3(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}

	protected int consumeRuleCall$2(int entryPoint) throws Exception {
		return consumeNonTerminal(attributeConsumer, null, false, false, false, getRule().ele0ParserRuleCallAttribute());
	}

	protected int consumeRuleCall$3(int entryPoint) throws Exception {
		return consumeNonTerminal(referenceConsumer, null, false, false, false, getRule().ele1ParserRuleCallReference());
	}

	public StructuralFeatureElements getRule() {
	// DomainmodelGrammarAccess.INSTANCE.prStructuralFeature()
		return rule;
	}
	
	public void setRule(StructuralFeatureElements rule) {
		this.rule = rule;
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "StructuralFeature";
	}
	
	public void setAttributeConsumer(INonTerminalConsumer attributeConsumer) {
		this.attributeConsumer = attributeConsumer;
	}
	
	public void setReferenceConsumer(INonTerminalConsumer referenceConsumer) {
		this.referenceConsumer = referenceConsumer;
	}
	
}

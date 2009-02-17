/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat.consumers;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.AbstractRule;

import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.example.services.DomainmodelGrammarAccess.TypedElementElements;

import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelFeatureConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelParameterConsumer;

@SuppressWarnings("unused")
public final class DomainmodelTypedElementConsumer extends NonTerminalConsumer {

	private TypedElementElements rule;
	
	private INonTerminalConsumer featureConsumer;
	private INonTerminalConsumer parameterConsumer;

	public DomainmodelTypedElementConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
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
		return consumeNonTerminal(featureConsumer, null, false, false, false, getRule().ele0ParserRuleCallFeature());
	}

	protected int consumeRuleCall$3(int entryPoint) throws Exception {
		return consumeNonTerminal(parameterConsumer, null, false, false, false, getRule().ele1ParserRuleCallParameter());
	}

	public TypedElementElements getRule() {
		return rule;
	}
	
	public void setRule(TypedElementElements rule) {
		this.rule = rule;
	}
	
	@Override
	protected AbstractRule getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected EClassifier getDefaultType() {
		return getGrammarElement().getType().getType();
	}
	
	public void setFeatureConsumer(INonTerminalConsumer featureConsumer) {
		this.featureConsumer = featureConsumer;
	}
	
	public void setParameterConsumer(INonTerminalConsumer parameterConsumer) {
		this.parameterConsumer = parameterConsumer;
	}
	
}

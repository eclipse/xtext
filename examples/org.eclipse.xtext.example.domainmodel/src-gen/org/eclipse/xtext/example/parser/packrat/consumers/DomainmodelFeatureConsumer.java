/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.example.services.DomainmodelGrammarAccess;
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess.FeatureElements;

import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelOperationConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelStructuralFeatureConsumer;

@SuppressWarnings("unused")
public final class DomainmodelFeatureConsumer extends NonTerminalConsumer {

	private DomainmodelOperationConsumer operationConsumer;
	private DomainmodelStructuralFeatureConsumer structuralFeatureConsumer;

	public DomainmodelFeatureConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
	protected int doConsume(int entryPoint) throws Exception {
		return consumeAlternatives$1(entryPoint);
	}

	protected int consumeAlternatives$1(int entryPoint) throws Exception {
		announceNextLevel();
		int result = ConsumeResult.SUCCESS;
		IMarker bestMarker = mark();
		IMarker currentMarker;
		int tempResult;
		switch(entryPoint) {
			case -1: // use fallthrough semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextPath();
				currentMarker = bestMarker.fork();
				tempResult = consumeRuleCall$2(nextEntryPoint()); 
				if (tempResult == ConsumeResult.SUCCESS) {
					bestMarker = currentMarker.join(bestMarker);
					bestMarker.commit();
					announceLevelFinished();
					return tempResult;
				}
				if (tempResult > result) {
					bestMarker = currentMarker.join(bestMarker);
					result = tempResult;
				} else {
					bestMarker = bestMarker.join(currentMarker);
				}
				currentMarker = null;
			case 1:
				announceNextPath();
				currentMarker = bestMarker.fork();
				tempResult = consumeRuleCall$3(nextEntryPoint()); 
				if (tempResult == ConsumeResult.SUCCESS) {
					bestMarker = currentMarker.join(bestMarker);
					bestMarker.commit();
					announceLevelFinished();
					return tempResult;
				}
				if (tempResult > result) {
					bestMarker = currentMarker.join(bestMarker);
					result = tempResult;
				} else {
					bestMarker = bestMarker.join(currentMarker);
				}
				currentMarker = null;
		}
		bestMarker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeRuleCall$2(int entryPoint) throws Exception {
		return consumeNonTerminal(structuralFeatureConsumer, null, false, false, getRule().ele0ParserRuleCallStructuralFeature());
	}

	protected int consumeRuleCall$3(int entryPoint) throws Exception {
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
	
	public void setOperationConsumer(DomainmodelOperationConsumer operationConsumer) {
		this.operationConsumer = operationConsumer;
	}
	
	public void setStructuralFeatureConsumer(DomainmodelStructuralFeatureConsumer structuralFeatureConsumer) {
		this.structuralFeatureConsumer = structuralFeatureConsumer;
	}
	
}

/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers;

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

import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess.CompositeModelElements;

import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageModelConsumer;

@SuppressWarnings("unused")
public final class DatatypeRulesTestLanguageCompositeModelConsumer extends NonTerminalConsumer {

	private CompositeModelElements rule;
	
	private INonTerminalConsumer modelConsumer;

	public DatatypeRulesTestLanguageCompositeModelConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
	@Override
	protected int doConsume(int entryPoint) throws Exception {
		return consumeAssignment$1(entryPoint);
	}

	protected int consumeAssignment$1(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		announceNextLevel();
		switch(entryPoint) {
			case -1:
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = doConsumeAssignment$1(nextEntryPoint());
			case 1:
				announceNextStep();
				if (result == ConsumeResult.SUCCESS) {
					marker.flush();
					while(doConsumeAssignment$1(nextEntryPoint())==ConsumeResult.SUCCESS) {
						marker.flush();
					}
					marker.rollback();
					announceLevelFinished();
					return ConsumeResult.SUCCESS;
				}
				error("Could not find token.", getRule().eleAssignmentModel());
		}
		announceLevelFinished();
		marker.commit();
		return result;
	}

	protected int doConsumeAssignment$1(int entryPoint) throws Exception {
		return consumeRuleCall$2(entryPoint);
	}

	protected int consumeRuleCall$2(int entryPoint) throws Exception {
		return consumeNonTerminal(modelConsumer, "model", true, false, false, getRule().ele0ParserRuleCallModel());
	}

	public CompositeModelElements getRule() {
		return rule;
	}
	
	public void setRule(CompositeModelElements rule) {
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
	
	public void setModelConsumer(INonTerminalConsumer modelConsumer) {
		this.modelConsumer = modelConsumer;
	}
	
}

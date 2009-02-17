/*
Generated with Xtext
*/
package org.eclipse.xtext.dummy.parser.packrat.consumers;

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

import org.eclipse.xtext.dummy.services.DummyTestLanguageGrammarAccess.ModelElements;

import org.eclipse.xtext.dummy.parser.packrat.consumers.DummyTestLanguageElementConsumer;

@SuppressWarnings("unused")
public final class DummyTestLanguageModelConsumer extends NonTerminalConsumer {

	private ModelElements rule;
	
	private INonTerminalConsumer elementConsumer;

	public DummyTestLanguageModelConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
	@Override
	protected int doConsume(int entryPoint) throws Exception {
		return consumeAssignment$1(entryPoint);
	}

	protected int consumeAssignment$1(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeAssignment$1(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$1(int entryPoint) throws Exception {
		return consumeRuleCall$2(entryPoint);
	}

	protected int consumeRuleCall$2(int entryPoint) throws Exception {
		return consumeNonTerminal(elementConsumer, "elements", true, false, false, getRule().ele0ParserRuleCallElement());
	}

	public ModelElements getRule() {
		return rule;
	}
	
	public void setRule(ModelElements rule) {
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
	
	public void setElementConsumer(INonTerminalConsumer elementConsumer) {
		this.elementConsumer = elementConsumer;
	}
	
}

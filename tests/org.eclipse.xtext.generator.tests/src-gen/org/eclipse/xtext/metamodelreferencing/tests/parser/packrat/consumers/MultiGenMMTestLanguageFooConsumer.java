/*
Generated with Xtext
*/
package org.eclipse.xtext.metamodelreferencing.tests.parser.packrat.consumers;

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

import org.eclipse.xtext.metamodelreferencing.tests.services.MultiGenMMTestLanguageGrammarAccess.FooElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.metamodelreferencing.tests.parser.packrat.consumers.MultiGenMMTestLanguageNameRefConsumer;

@SuppressWarnings("unused")
public final class MultiGenMMTestLanguageFooConsumer extends NonTerminalConsumer {

	private FooElements rule;
	
	private ITerminalConsumer idConsumer;
	private INonTerminalConsumer nameRefConsumer;

	private ISequenceMatcher ruleCall$3$Delimiter;
	
	public MultiGenMMTestLanguageFooConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		ruleCall$3$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	@Override
	protected int doConsume(int entryPoint) throws Exception {
		return consumeGroup$1(entryPoint);
	}

	protected int consumeGroup$1(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeAssignment$2(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0AssignmentName());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$4(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1AssignmentNameRefs());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$2(int entryPoint) throws Exception {
		return consumeRuleCall$3(entryPoint);
	}

	protected int consumeRuleCall$3(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, "name", false, false, getRule().ele00LexerRuleCallID(), getRuleCall$3$Delimiter());
	}

	protected int consumeAssignment$4(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeAssignment$4(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$4(int entryPoint) throws Exception {
		return consumeRuleCall$5(entryPoint);
	}

	protected int consumeRuleCall$5(int entryPoint) throws Exception {
		return consumeNonTerminal(nameRefConsumer, "nameRefs", true, false, false, getRule().ele10ParserRuleCallNameRef());
	}

	public FooElements getRule() {
		return rule;
	}
	
	public void setRule(FooElements rule) {
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
	
	public void setIdConsumer(ITerminalConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setNameRefConsumer(INonTerminalConsumer nameRefConsumer) {
		this.nameRefConsumer = nameRefConsumer;
	}
	
	public ISequenceMatcher getRuleCall$3$Delimiter() {
		return ruleCall$3$Delimiter;
	}
	
	public void setRuleCall$3$Delimiter(ISequenceMatcher matcher) {
		ruleCall$3$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

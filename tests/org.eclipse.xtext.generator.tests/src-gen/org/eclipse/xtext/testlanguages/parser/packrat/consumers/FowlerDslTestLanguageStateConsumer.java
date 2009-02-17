/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat.consumers;

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

import org.eclipse.xtext.testlanguages.services.FowlerDslTestLanguageGrammarAccess.StateElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.FowlerDslTestLanguageTransitionConsumer;

@SuppressWarnings("unused")
public final class FowlerDslTestLanguageStateConsumer extends NonTerminalConsumer {

	private StateElements rule;
	
	private ITerminalConsumer idConsumer;
	private INonTerminalConsumer transitionConsumer;

	private ISequenceMatcher crossReference$14$Delimiter;
	
	private ICharacterClass keyword$5$Delimiter;
	
	private ICharacterClass keyword$11$Delimiter;
	
	private ICharacterClass keyword$12$Delimiter;
	
	private ICharacterClass keyword$16$Delimiter;
	
	private ICharacterClass keyword$19$Delimiter;
	
	private ISequenceMatcher ruleCall$7$Delimiter;
	
	public FowlerDslTestLanguageStateConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		crossReference$14$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$5$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$12$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$16$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$19$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$7$Delimiter = ISequenceMatcher.Factory.nullMatcher();
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
				result = consumeKeyword$5(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0000KeywordState());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$6(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0001AssignmentName());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeGroup$8(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele001Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 3:
				announceNextStep();
				result = consumeAssignment$17(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele01AssignmentTransitions());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 4:
				announceNextStep();
				result = consumeKeyword$19(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1KeywordEnd());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$5(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0000KeywordState(), null, false, false, getKeyword$5$Delimiter());
	}

	protected int consumeAssignment$6(int entryPoint) throws Exception {
		return consumeRuleCall$7(entryPoint);
	}

	protected int consumeRuleCall$7(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, "name", false, false, getRule().ele00010LexerRuleCallID(), getRuleCall$7$Delimiter());
	}

	protected int consumeGroup$8(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$8(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$8(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$11(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele001000KeywordActions());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeKeyword$12(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele001001KeywordLeftCurlyBracket());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeAssignment$13(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00101AssignmentActions());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 3:
				announceNextStep();
				result = consumeKeyword$16(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0011KeywordRightCurlyBracket());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$11(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele001000KeywordActions(), null, false, false, getKeyword$11$Delimiter());
	}

	protected int consumeKeyword$12(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele001001KeywordLeftCurlyBracket(), null, false, false, getKeyword$12$Delimiter());
	}

	protected int consumeAssignment$13(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		announceNextLevel();
		switch(entryPoint) {
			case -1:
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = doConsumeAssignment$13(nextEntryPoint());
			case 1:
				announceNextStep();
				if (result == ConsumeResult.SUCCESS) {
					marker.flush();
					while(doConsumeAssignment$13(nextEntryPoint())==ConsumeResult.SUCCESS) {
						marker.flush();
					}
					marker.rollback();
					announceLevelFinished();
					return ConsumeResult.SUCCESS;
				}
				error("Could not find token.", getRule().ele00101AssignmentActions());
		}
		announceLevelFinished();
		marker.commit();
		return result;
	}

	protected int doConsumeAssignment$13(int entryPoint) throws Exception {
		return consumeCrossReference$14(entryPoint);
	}

	protected int consumeCrossReference$14(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, "actions", true, false, getRule().ele001010CrossReferenceEStringCommand(), getCrossReference$14$Delimiter());
	}

	protected int consumeKeyword$16(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0011KeywordRightCurlyBracket(), null, false, false, getKeyword$16$Delimiter());
	}

	protected int consumeAssignment$17(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeAssignment$17(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$17(int entryPoint) throws Exception {
		return consumeRuleCall$18(entryPoint);
	}

	protected int consumeRuleCall$18(int entryPoint) throws Exception {
		return consumeNonTerminal(transitionConsumer, "transitions", true, false, false, getRule().ele010ParserRuleCallTransition());
	}

	protected int consumeKeyword$19(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele1KeywordEnd(), null, false, false, getKeyword$19$Delimiter());
	}

	public StateElements getRule() {
		return rule;
	}
	
	public void setRule(StateElements rule) {
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
	
	public void setTransitionConsumer(INonTerminalConsumer transitionConsumer) {
		this.transitionConsumer = transitionConsumer;
	}
	
	public ISequenceMatcher getCrossReference$14$Delimiter() {
		return crossReference$14$Delimiter;
	}
	
	public void setCrossReference$14$Delimiter(ISequenceMatcher matcher) {
		crossReference$14$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$5$Delimiter() {
		return keyword$5$Delimiter;
	}
	
	public void setKeyword$5$Delimiter(ICharacterClass characterClass) {
		keyword$5$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$11$Delimiter() {
		return keyword$11$Delimiter;
	}
	
	public void setKeyword$11$Delimiter(ICharacterClass characterClass) {
		keyword$11$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$12$Delimiter() {
		return keyword$12$Delimiter;
	}
	
	public void setKeyword$12$Delimiter(ICharacterClass characterClass) {
		keyword$12$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$16$Delimiter() {
		return keyword$16$Delimiter;
	}
	
	public void setKeyword$16$Delimiter(ICharacterClass characterClass) {
		keyword$16$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$19$Delimiter() {
		return keyword$19$Delimiter;
	}
	
	public void setKeyword$19$Delimiter(ICharacterClass characterClass) {
		keyword$19$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$7$Delimiter() {
		return ruleCall$7$Delimiter;
	}
	
	public void setRuleCall$7$Delimiter(ISequenceMatcher matcher) {
		ruleCall$7$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

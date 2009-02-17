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

import org.eclipse.xtext.example.services.FowlerDslGrammarAccess.StatemachineElements;

import org.eclipse.xtext.example.parser.packrat.consumers.FowlerDslCommandConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.FowlerDslEventConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.FowlerDslStateConsumer;

@SuppressWarnings("unused")
public final class FowlerDslStatemachineConsumer extends NonTerminalConsumer {

	private StatemachineElements rule;
	
	private INonTerminalConsumer commandConsumer;
	private INonTerminalConsumer eventConsumer;
	private INonTerminalConsumer stateConsumer;

	private ICharacterClass keyword$10$Delimiter;
	
	private ICharacterClass keyword$11$Delimiter;
	
	private ICharacterClass keyword$14$Delimiter;
	
	private ICharacterClass keyword$7$Delimiter;
	
	public FowlerDslStatemachineConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		keyword$10$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$14$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$7$Delimiter = ICharacterClass.Factory.nullClass();
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
				result = consumeKeyword$7(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele000000KeywordEvents());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$8(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele000001AssignmentEvents());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeKeyword$10(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00001KeywordEnd());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 3:
				announceNextStep();
				result = consumeKeyword$11(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0001KeywordCommands());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 4:
				announceNextStep();
				result = consumeAssignment$12(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele001AssignmentCommands());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 5:
				announceNextStep();
				result = consumeKeyword$14(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele01KeywordEnd());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 6:
				announceNextStep();
				result = consumeAssignment$15(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1AssignmentStates());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$7(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele000000KeywordEvents(), null, false, false, getKeyword$7$Delimiter());
	}

	protected int consumeAssignment$8(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeAssignment$8(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$8(int entryPoint) throws Exception {
		return consumeRuleCall$9(entryPoint);
	}

	protected int consumeRuleCall$9(int entryPoint) throws Exception {
		return consumeNonTerminal(eventConsumer, "events", true, false, false, getRule().ele0000010ParserRuleCallEvent());
	}

	protected int consumeKeyword$10(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele00001KeywordEnd(), null, false, false, getKeyword$10$Delimiter());
	}

	protected int consumeKeyword$11(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0001KeywordCommands(), null, false, false, getKeyword$11$Delimiter());
	}

	protected int consumeAssignment$12(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeAssignment$12(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$12(int entryPoint) throws Exception {
		return consumeRuleCall$13(entryPoint);
	}

	protected int consumeRuleCall$13(int entryPoint) throws Exception {
		return consumeNonTerminal(commandConsumer, "commands", true, false, false, getRule().ele0010ParserRuleCallCommand());
	}

	protected int consumeKeyword$14(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele01KeywordEnd(), null, false, false, getKeyword$14$Delimiter());
	}

	protected int consumeAssignment$15(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeAssignment$15(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$15(int entryPoint) throws Exception {
		return consumeRuleCall$16(entryPoint);
	}

	protected int consumeRuleCall$16(int entryPoint) throws Exception {
		return consumeNonTerminal(stateConsumer, "states", true, false, false, getRule().ele10ParserRuleCallState());
	}

	public StatemachineElements getRule() {
		return rule;
	}
	
	public void setRule(StatemachineElements rule) {
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
	
	public void setCommandConsumer(INonTerminalConsumer commandConsumer) {
		this.commandConsumer = commandConsumer;
	}
	
	public void setEventConsumer(INonTerminalConsumer eventConsumer) {
		this.eventConsumer = eventConsumer;
	}
	
	public void setStateConsumer(INonTerminalConsumer stateConsumer) {
		this.stateConsumer = stateConsumer;
	}
	
	public ICharacterClass getKeyword$10$Delimiter() {
		return keyword$10$Delimiter;
	}
	
	public void setKeyword$10$Delimiter(ICharacterClass characterClass) {
		keyword$10$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$11$Delimiter() {
		return keyword$11$Delimiter;
	}
	
	public void setKeyword$11$Delimiter(ICharacterClass characterClass) {
		keyword$11$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$14$Delimiter() {
		return keyword$14$Delimiter;
	}
	
	public void setKeyword$14$Delimiter(ICharacterClass characterClass) {
		keyword$14$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$7$Delimiter() {
		return keyword$7$Delimiter;
	}
	
	public void setKeyword$7$Delimiter(ICharacterClass characterClass) {
		keyword$7$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}

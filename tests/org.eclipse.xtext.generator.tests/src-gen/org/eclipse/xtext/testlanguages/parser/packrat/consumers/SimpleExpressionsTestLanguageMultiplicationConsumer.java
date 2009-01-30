/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageGrammarAccess.MultiplicationElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.SimpleExpressionsTestLanguageTermConsumer;

@SuppressWarnings("unused")
public final class SimpleExpressionsTestLanguageMultiplicationConsumer extends NonTerminalConsumer {

	private SimpleExpressionsTestLanguageTermConsumer termConsumer;

	private ICharacterClass keyword$9$Delimiter;
	
	private ICharacterClass keyword$10$Delimiter;
	
	public SimpleExpressionsTestLanguageMultiplicationConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		keyword$9$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$10$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected int doConsume(int entryPoint) throws Exception {
		return consumeGroup$1(entryPoint);
	}

	protected int consumeGroup$1(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fallthrough semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeRuleCall$2(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0ParserRuleCallTerm());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeGroup$3(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeRuleCall$2(int entryPoint) throws Exception {
		return consumeNonTerminal(termConsumer, null, false, false, getRule().ele0ParserRuleCallTerm());
	}

	protected int consumeGroup$3(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeGroup$3(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$3(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fallthrough semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeAction$5(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele100ActionOpvalues());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$7(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele101AssignmentOperator());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeAssignment$11(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele11AssignmentValues());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}
	protected int consumeAction$5(int entryPoint) {
		consumeAction(getRule().ele100ActionOpvalues(), "Op", true);
		return ConsumeResult.SUCCESS;	
	}

	protected int consumeAssignment$7(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		// TODO use markers in assignments of alternatives to recover
		announceNextPath();
		tempResult = consumeKeyword(getRule().ele10100KeywordAsterisk(), "operator", false, false, getKeyword$9$Delimiter()); 
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 

		announceNextPath();
		tempResult = consumeKeyword(getRule().ele10101KeywordSolidus(), "operator", false, false, getKeyword$10$Delimiter()); 
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 

		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$11(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeNonTerminal(termConsumer, "values", true, false, getRule().ele110ParserRuleCallTerm());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	public MultiplicationElements getRule() {
		return SimpleExpressionsTestLanguageGrammarAccess.INSTANCE.prMultiplication();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Expression";
	}
	
	public void setTermConsumer(SimpleExpressionsTestLanguageTermConsumer termConsumer) {
		this.termConsumer = termConsumer;
	}
	
	public ICharacterClass getKeyword$9$Delimiter() {
		return keyword$9$Delimiter;
	}
	
	public void setKeyword$9$Delimiter(ICharacterClass characterClass) {
		keyword$9$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$10$Delimiter() {
		return keyword$10$Delimiter;
	}
	
	public void setKeyword$10$Delimiter(ICharacterClass characterClass) {
		keyword$10$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}

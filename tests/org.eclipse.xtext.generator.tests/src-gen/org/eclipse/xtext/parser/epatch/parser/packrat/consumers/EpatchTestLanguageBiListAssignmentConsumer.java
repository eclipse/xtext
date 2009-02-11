/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.epatch.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess.BiListAssignmentElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageListAssignmentValueConsumer;

@SuppressWarnings("unused")
public final class EpatchTestLanguageBiListAssignmentConsumer extends NonTerminalConsumer {

	private ITerminalConsumer idConsumer;
	private INonTerminalConsumer listAssignmentValueConsumer;

	private ICharacterClass keyword$10$Delimiter;
	
	private ICharacterClass keyword$11$Delimiter;
	
	private ICharacterClass keyword$16$Delimiter;
	
	private ICharacterClass keyword$19$Delimiter;
	
	private ICharacterClass keyword$24$Delimiter;
	
	private ICharacterClass keyword$27$Delimiter;
	
	private ICharacterClass keyword$28$Delimiter;
	
	private ISequenceMatcher ruleCall$9$Delimiter;
	
	public EpatchTestLanguageBiListAssignmentConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		keyword$10$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$16$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$19$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$24$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$27$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$28$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$9$Delimiter = ISequenceMatcher.Factory.nullMatcher();
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
				result = consumeAssignment$8(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0000000AssignmentFeature());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeKeyword$10(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0000001KeywordEqualsSign());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeKeyword$11(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele000001KeywordLeftSquareBracket());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 3:
				announceNextStep();
				result = consumeGroup$12(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00001Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 4:
				announceNextStep();
				result = consumeKeyword$19(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0001KeywordVerticalLine());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 5:
				announceNextStep();
				result = consumeGroup$20(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele001Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 6:
				announceNextStep();
				result = consumeKeyword$27(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele01KeywordRightSquareBracket());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 7:
				announceNextStep();
				result = consumeKeyword$28(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1KeywordSemicolon());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$8(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(idConsumer, "feature", false, false, getRule().ele00000000LexerRuleCallID(), getRuleCall$9$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$10(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0000001KeywordEqualsSign(), null, false, false, getKeyword$10$Delimiter());
	}

	protected int consumeKeyword$11(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele000001KeywordLeftSquareBracket(), null, false, false, getKeyword$11$Delimiter());
	}

	protected int consumeGroup$12(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$12(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$12(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeAssignment$13(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele000010AssignmentLeftValues());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeGroup$15(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele000011Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$13(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeNonTerminal(listAssignmentValueConsumer, "leftValues", true, false, false, getRule().ele0000100ParserRuleCallListAssignmentValue());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeGroup$15(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeGroup$15(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$15(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$16(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0000110KeywordComma());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$17(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0000111AssignmentLeftValues());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$16(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0000110KeywordComma(), null, false, false, getKeyword$16$Delimiter());
	}

	protected int consumeAssignment$17(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeNonTerminal(listAssignmentValueConsumer, "leftValues", true, false, false, getRule().ele00001110ParserRuleCallListAssignmentValue());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$19(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0001KeywordVerticalLine(), null, false, false, getKeyword$19$Delimiter());
	}

	protected int consumeGroup$20(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$20(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$20(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeAssignment$21(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0010AssignmentRightValues());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeGroup$23(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0011Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$21(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeNonTerminal(listAssignmentValueConsumer, "rightValues", true, false, false, getRule().ele00100ParserRuleCallListAssignmentValue());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeGroup$23(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeGroup$23(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$23(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$24(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00110KeywordComma());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$25(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00111AssignmentRightValues());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$24(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele00110KeywordComma(), null, false, false, getKeyword$24$Delimiter());
	}

	protected int consumeAssignment$25(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeNonTerminal(listAssignmentValueConsumer, "rightValues", true, false, false, getRule().ele001110ParserRuleCallListAssignmentValue());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$27(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele01KeywordRightSquareBracket(), null, false, false, getKeyword$27$Delimiter());
	}

	protected int consumeKeyword$28(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele1KeywordSemicolon(), null, false, false, getKeyword$28$Delimiter());
	}

	public BiListAssignmentElements getRule() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prBiListAssignment();
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "ListAssignment";
	}
	
	public void setIdConsumer(ITerminalConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setListAssignmentValueConsumer(INonTerminalConsumer listAssignmentValueConsumer) {
		this.listAssignmentValueConsumer = listAssignmentValueConsumer;
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
	
	public ICharacterClass getKeyword$24$Delimiter() {
		return keyword$24$Delimiter;
	}
	
	public void setKeyword$24$Delimiter(ICharacterClass characterClass) {
		keyword$24$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$27$Delimiter() {
		return keyword$27$Delimiter;
	}
	
	public void setKeyword$27$Delimiter(ICharacterClass characterClass) {
		keyword$27$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$28$Delimiter() {
		return keyword$28$Delimiter;
	}
	
	public void setKeyword$28$Delimiter(ICharacterClass characterClass) {
		keyword$28$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$9$Delimiter() {
		return ruleCall$9$Delimiter;
	}
	
	public void setRuleCall$9$Delimiter(ISequenceMatcher matcher) {
		ruleCall$9$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

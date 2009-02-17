/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.epatch.parser.packrat.consumers;

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

import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess.SingleAssignmentValueElements;

import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageCreatedObjectConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageFRAGMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;

@SuppressWarnings("unused")
public final class EpatchTestLanguageSingleAssignmentValueConsumer extends NonTerminalConsumer {

	private SingleAssignmentValueElements rule;
	
	private INonTerminalConsumer createdObjectConsumer;
	private ITerminalConsumer fragmentConsumer;
	private ITerminalConsumer idConsumer;
	private ITerminalConsumer intConsumer;
	private ITerminalConsumer stringConsumer;

	private ISequenceMatcher crossReference$11$Delimiter;
	
	private ISequenceMatcher crossReference$28$Delimiter;
	
	private ICharacterClass keyword$6$Delimiter;
	
	private ICharacterClass keyword$15$Delimiter;
	
	private ICharacterClass keyword$20$Delimiter;
	
	private ICharacterClass keyword$23$Delimiter;
	
	private ISequenceMatcher ruleCall$8$Delimiter;
	
	private ISequenceMatcher ruleCall$17$Delimiter;
	
	private ISequenceMatcher ruleCall$22$Delimiter;
	
	private ISequenceMatcher ruleCall$31$Delimiter;
	
	public EpatchTestLanguageSingleAssignmentValueConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		crossReference$11$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		crossReference$28$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$6$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$15$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$20$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$23$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$8$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$17$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$22$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$31$Delimiter = ISequenceMatcher.Factory.nullMatcher();
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
				if (result.isAlternativeDone(consumeAssignment$5(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeAssignment$7(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 2:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeGroup$9(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 3:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeAssignment$24(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 4:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeGroup$26(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}

	protected int consumeAssignment$5(int entryPoint) throws Exception {
		return consumeKeyword$6(entryPoint);
	}

	protected int consumeKeyword$6(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele00000KeywordNull(), "keyword", false, false, getKeyword$6$Delimiter());
	}

	protected int consumeAssignment$7(int entryPoint) throws Exception {
		return consumeRuleCall$8(entryPoint);
	}

	protected int consumeRuleCall$8(int entryPoint) throws Exception {
		return consumeTerminal(stringConsumer, "value", false, false, getRule().ele00010LexerRuleCallSTRING(), getRuleCall$8$Delimiter());
	}

	protected int consumeGroup$9(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeAssignment$10(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0010AssignmentRefObject());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeGroup$13(nextEntryPoint());
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

	protected int consumeAssignment$10(int entryPoint) throws Exception {
		return consumeCrossReference$11(entryPoint);
	}

	protected int consumeCrossReference$11(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, "refObject", false, false, getRule().ele00100CrossReferenceEStringNamedObject(), getCrossReference$11$Delimiter());
	}

	protected int consumeGroup$13(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$13(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$13(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$15(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele001100KeywordFullStop());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$16(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele001101AssignmentRefFeature());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeGroup$18(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00111Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$15(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele001100KeywordFullStop(), null, false, false, getKeyword$15$Delimiter());
	}

	protected int consumeAssignment$16(int entryPoint) throws Exception {
		return consumeRuleCall$17(entryPoint);
	}

	protected int consumeRuleCall$17(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, "refFeature", false, false, getRule().ele0011010LexerRuleCallID(), getRuleCall$17$Delimiter());
	}

	protected int consumeGroup$18(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$18(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$18(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$20(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0011100KeywordLeftSquareBracket());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$21(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0011101AssignmentRefIndex());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeKeyword$23(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele001111KeywordRightSquareBracket());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$20(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0011100KeywordLeftSquareBracket(), null, false, false, getKeyword$20$Delimiter());
	}

	protected int consumeAssignment$21(int entryPoint) throws Exception {
		return consumeRuleCall$22(entryPoint);
	}

	protected int consumeRuleCall$22(int entryPoint) throws Exception {
		return consumeTerminal(intConsumer, "refIndex", false, false, getRule().ele00111010LexerRuleCallINT(), getRuleCall$22$Delimiter());
	}

	protected int consumeKeyword$23(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele001111KeywordRightSquareBracket(), null, false, false, getKeyword$23$Delimiter());
	}

	protected int consumeAssignment$24(int entryPoint) throws Exception {
		return consumeRuleCall$25(entryPoint);
	}

	protected int consumeRuleCall$25(int entryPoint) throws Exception {
		return consumeNonTerminal(createdObjectConsumer, "newObject", false, false, false, getRule().ele010ParserRuleCallCreatedObject());
	}

	protected int consumeGroup$26(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeAssignment$27(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele10AssignmentImport());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$30(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele11AssignmentImpFrag());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$27(int entryPoint) throws Exception {
		return consumeCrossReference$28(entryPoint);
	}

	protected int consumeCrossReference$28(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, "import", false, false, getRule().ele100CrossReferenceEStringImport(), getCrossReference$28$Delimiter());
	}

	protected int consumeAssignment$30(int entryPoint) throws Exception {
		return consumeRuleCall$31(entryPoint);
	}

	protected int consumeRuleCall$31(int entryPoint) throws Exception {
		return consumeTerminal(fragmentConsumer, "impFrag", false, false, getRule().ele110LexerRuleCallFRAGMENT(), getRuleCall$31$Delimiter());
	}

	public SingleAssignmentValueElements getRule() {
		return rule;
	}
	
	public void setRule(SingleAssignmentValueElements rule) {
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
	
	public void setCreatedObjectConsumer(INonTerminalConsumer createdObjectConsumer) {
		this.createdObjectConsumer = createdObjectConsumer;
	}
	
	public void setFragmentConsumer(ITerminalConsumer fragmentConsumer) {
		this.fragmentConsumer = fragmentConsumer;
	}
	
	public void setIdConsumer(ITerminalConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setIntConsumer(ITerminalConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	
	public void setStringConsumer(ITerminalConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public ISequenceMatcher getCrossReference$11$Delimiter() {
		return crossReference$11$Delimiter;
	}
	
	public void setCrossReference$11$Delimiter(ISequenceMatcher matcher) {
		crossReference$11$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getCrossReference$28$Delimiter() {
		return crossReference$28$Delimiter;
	}
	
	public void setCrossReference$28$Delimiter(ISequenceMatcher matcher) {
		crossReference$28$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$6$Delimiter() {
		return keyword$6$Delimiter;
	}
	
	public void setKeyword$6$Delimiter(ICharacterClass characterClass) {
		keyword$6$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$15$Delimiter() {
		return keyword$15$Delimiter;
	}
	
	public void setKeyword$15$Delimiter(ICharacterClass characterClass) {
		keyword$15$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$20$Delimiter() {
		return keyword$20$Delimiter;
	}
	
	public void setKeyword$20$Delimiter(ICharacterClass characterClass) {
		keyword$20$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$23$Delimiter() {
		return keyword$23$Delimiter;
	}
	
	public void setKeyword$23$Delimiter(ICharacterClass characterClass) {
		keyword$23$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$8$Delimiter() {
		return ruleCall$8$Delimiter;
	}
	
	public void setRuleCall$8$Delimiter(ISequenceMatcher matcher) {
		ruleCall$8$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$17$Delimiter() {
		return ruleCall$17$Delimiter;
	}
	
	public void setRuleCall$17$Delimiter(ISequenceMatcher matcher) {
		ruleCall$17$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$22$Delimiter() {
		return ruleCall$22$Delimiter;
	}
	
	public void setRuleCall$22$Delimiter(ISequenceMatcher matcher) {
		ruleCall$22$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$31$Delimiter() {
		return ruleCall$31$Delimiter;
	}
	
	public void setRuleCall$31$Delimiter(ISequenceMatcher matcher) {
		ruleCall$31$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

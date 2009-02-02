/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.epatch.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess.ListAssignmentValueElements;

import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageCreatedObjectConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageFRAGMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;

@SuppressWarnings("unused")
public final class EpatchTestLanguageListAssignmentValueConsumer extends NonTerminalConsumer {

	private EpatchTestLanguageCreatedObjectConsumer createdObjectConsumer;
	private EpatchTestLanguageFRAGMENTConsumer fragmentConsumer;
	private XtextBuiltinIDConsumer idConsumer;
	private XtextBuiltinINTConsumer intConsumer;
	private XtextBuiltinSTRINGConsumer stringConsumer;

	private ISequenceMatcher crossReference$20$Delimiter;
	
	private ISequenceMatcher crossReference$37$Delimiter;
	
	private ICharacterClass keyword$5$Delimiter;
	
	private ICharacterClass keyword$12$Delimiter;
	
	private ICharacterClass keyword$15$Delimiter;
	
	private ICharacterClass keyword$24$Delimiter;
	
	private ICharacterClass keyword$29$Delimiter;
	
	private ICharacterClass keyword$32$Delimiter;
	
	private ISequenceMatcher ruleCall$4$Delimiter;
	
	private ISequenceMatcher ruleCall$14$Delimiter;
	
	private ISequenceMatcher ruleCall$17$Delimiter;
	
	private ISequenceMatcher ruleCall$26$Delimiter;
	
	private ISequenceMatcher ruleCall$31$Delimiter;
	
	private ISequenceMatcher ruleCall$40$Delimiter;
	
	public EpatchTestLanguageListAssignmentValueConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		crossReference$20$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		crossReference$37$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$5$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$12$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$15$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$24$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$29$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$32$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$4$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$14$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$17$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$26$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$31$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$40$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
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
				result = consumeAssignment$3(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00AssignmentIndex());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeKeyword$5(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele01KeywordColon());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeAlternatives$6(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1Alternatives());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$3(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(intConsumer, "index", false, false, getRule().ele000LexerRuleCallINT(), getRuleCall$4$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$5(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele01KeywordColon(), null, false, false, getKeyword$5$Delimiter());
	}

	protected int consumeAlternatives$6(int entryPoint) throws Exception {
		AlternativesResult result = createAlternativesResult();
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result.reset();
			case 0:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeGroup$10(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeAssignment$16(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 2:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeGroup$18(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 3:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeAssignment$33(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 4:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeGroup$35(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}

	protected int consumeGroup$10(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$12(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1000000KeywordLeftSquareBracket());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$13(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1000001AssignmentRefIndex());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeKeyword$15(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele100001KeywordRightSquareBracket());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$12(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele1000000KeywordLeftSquareBracket(), null, false, false, getKeyword$12$Delimiter());
	}

	protected int consumeAssignment$13(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(intConsumer, "refIndex", false, false, getRule().ele10000010LexerRuleCallINT(), getRuleCall$14$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$15(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele100001KeywordRightSquareBracket(), null, false, false, getKeyword$15$Delimiter());
	}

	protected int consumeAssignment$16(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(stringConsumer, "value", false, false, getRule().ele100010LexerRuleCallSTRING(), getRuleCall$17$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeGroup$18(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeAssignment$19(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele10010AssignmentRefObject());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeGroup$22(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele10011Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$19(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(idConsumer, "refObject", false, false, getRule().ele100100CrossReferenceEStringNamedObject(), getCrossReference$20$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeGroup$22(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$22(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$22(int entryPoint) throws Exception {
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
					error("Another token expected.", getRule().ele1001100KeywordFullStop());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$25(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1001101AssignmentRefFeature());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeGroup$27(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele100111Group());
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
		return consumeKeyword(getRule().ele1001100KeywordFullStop(), null, false, false, getKeyword$24$Delimiter());
	}

	protected int consumeAssignment$25(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(idConsumer, "refFeature", false, false, getRule().ele10011010LexerRuleCallID(), getRuleCall$26$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeGroup$27(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$27(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$27(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$29(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele10011100KeywordLeftSquareBracket());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$30(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele10011101AssignmentRefIndex());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeKeyword$32(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1001111KeywordRightSquareBracket());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$29(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele10011100KeywordLeftSquareBracket(), null, false, false, getKeyword$29$Delimiter());
	}

	protected int consumeAssignment$30(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(intConsumer, "refIndex", false, false, getRule().ele100111010LexerRuleCallINT(), getRuleCall$31$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$32(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele1001111KeywordRightSquareBracket(), null, false, false, getKeyword$32$Delimiter());
	}

	protected int consumeAssignment$33(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeNonTerminal(createdObjectConsumer, "newObject", false, false, getRule().ele1010ParserRuleCallCreatedObject());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeGroup$35(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeAssignment$36(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele110AssignmentImport());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$39(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele111AssignmentImpFrag());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$36(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(idConsumer, "import", false, false, getRule().ele1100CrossReferenceEStringImport(), getCrossReference$37$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$39(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(fragmentConsumer, "impFrag", false, false, getRule().ele1110LexerRuleCallFRAGMENT(), getRuleCall$40$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	public ListAssignmentValueElements getRule() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prListAssignmentValue();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AssignmentValue";
	}
	
	public void setCreatedObjectConsumer(EpatchTestLanguageCreatedObjectConsumer createdObjectConsumer) {
		this.createdObjectConsumer = createdObjectConsumer;
	}
	
	public void setFragmentConsumer(EpatchTestLanguageFRAGMENTConsumer fragmentConsumer) {
		this.fragmentConsumer = fragmentConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setIntConsumer(XtextBuiltinINTConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public ISequenceMatcher getCrossReference$20$Delimiter() {
		return crossReference$20$Delimiter;
	}
	
	public void setCrossReference$20$Delimiter(ISequenceMatcher matcher) {
		crossReference$20$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getCrossReference$37$Delimiter() {
		return crossReference$37$Delimiter;
	}
	
	public void setCrossReference$37$Delimiter(ISequenceMatcher matcher) {
		crossReference$37$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$5$Delimiter() {
		return keyword$5$Delimiter;
	}
	
	public void setKeyword$5$Delimiter(ICharacterClass characterClass) {
		keyword$5$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$12$Delimiter() {
		return keyword$12$Delimiter;
	}
	
	public void setKeyword$12$Delimiter(ICharacterClass characterClass) {
		keyword$12$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$15$Delimiter() {
		return keyword$15$Delimiter;
	}
	
	public void setKeyword$15$Delimiter(ICharacterClass characterClass) {
		keyword$15$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$24$Delimiter() {
		return keyword$24$Delimiter;
	}
	
	public void setKeyword$24$Delimiter(ICharacterClass characterClass) {
		keyword$24$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$29$Delimiter() {
		return keyword$29$Delimiter;
	}
	
	public void setKeyword$29$Delimiter(ICharacterClass characterClass) {
		keyword$29$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$32$Delimiter() {
		return keyword$32$Delimiter;
	}
	
	public void setKeyword$32$Delimiter(ICharacterClass characterClass) {
		keyword$32$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$4$Delimiter() {
		return ruleCall$4$Delimiter;
	}
	
	public void setRuleCall$4$Delimiter(ISequenceMatcher matcher) {
		ruleCall$4$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$14$Delimiter() {
		return ruleCall$14$Delimiter;
	}
	
	public void setRuleCall$14$Delimiter(ISequenceMatcher matcher) {
		ruleCall$14$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$17$Delimiter() {
		return ruleCall$17$Delimiter;
	}
	
	public void setRuleCall$17$Delimiter(ISequenceMatcher matcher) {
		ruleCall$17$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$26$Delimiter() {
		return ruleCall$26$Delimiter;
	}
	
	public void setRuleCall$26$Delimiter(ISequenceMatcher matcher) {
		ruleCall$26$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$31$Delimiter() {
		return ruleCall$31$Delimiter;
	}
	
	public void setRuleCall$31$Delimiter(ISequenceMatcher matcher) {
		ruleCall$31$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$40$Delimiter() {
		return ruleCall$40$Delimiter;
	}
	
	public void setRuleCall$40$Delimiter(ISequenceMatcher matcher) {
		ruleCall$40$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

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
import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess.SingleAssignmentValueElements;

import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageCreatedObjectConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageFRAGMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;

@SuppressWarnings("unused")
public final class EpatchTestLanguageSingleAssignmentValueConsumer extends NonTerminalConsumer {

	private EpatchTestLanguageCreatedObjectConsumer createdObjectConsumer;
	private EpatchTestLanguageFRAGMENTConsumer fragmentConsumer;
	private XtextBuiltinIDConsumer idConsumer;
	private XtextBuiltinINTConsumer intConsumer;
	private XtextBuiltinSTRINGConsumer stringConsumer;

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
				tempResult = consumeAssignment$5(nextEntryPoint()); 
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
				tempResult = consumeAssignment$7(nextEntryPoint()); 
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
			case 2:
				announceNextPath();
				currentMarker = bestMarker.fork();
				tempResult = consumeGroup$9(nextEntryPoint()); 
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
			case 3:
				announceNextPath();
				currentMarker = bestMarker.fork();
				tempResult = consumeAssignment$24(nextEntryPoint()); 
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
			case 4:
				announceNextPath();
				currentMarker = bestMarker.fork();
				tempResult = consumeGroup$26(nextEntryPoint()); 
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

	protected int consumeAssignment$5(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeKeyword(getRule().ele00000KeywordNull(), "keyword", false, false, getKeyword$6$Delimiter()); 
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$7(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(stringConsumer, "value", false, false, getRule().ele00010LexerRuleCallSTRING(), getRuleCall$8$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeGroup$9(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fallthrough semantics of switch case
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
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(idConsumer, "refObject", false, false, getRule().ele00100CrossReferenceEStringNamedObject(), getCrossReference$11$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
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
			case -1: // use fallthrough semantics of switch case
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
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(idConsumer, "refFeature", false, false, getRule().ele0011010LexerRuleCallID(), getRuleCall$17$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
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
			case -1: // use fallthrough semantics of switch case
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
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(intConsumer, "refIndex", false, false, getRule().ele00111010LexerRuleCallINT(), getRuleCall$22$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$23(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele001111KeywordRightSquareBracket(), null, false, false, getKeyword$23$Delimiter());
	}

	protected int consumeAssignment$24(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeNonTerminal(createdObjectConsumer, "newObject", false, false, getRule().ele010ParserRuleCallCreatedObject());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeGroup$26(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fallthrough semantics of switch case
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
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(idConsumer, "import", false, false, getRule().ele100CrossReferenceEStringImport(), getCrossReference$28$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$30(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(fragmentConsumer, "impFrag", false, false, getRule().ele110LexerRuleCallFRAGMENT(), getRuleCall$31$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	public SingleAssignmentValueElements getRule() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prSingleAssignmentValue();
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

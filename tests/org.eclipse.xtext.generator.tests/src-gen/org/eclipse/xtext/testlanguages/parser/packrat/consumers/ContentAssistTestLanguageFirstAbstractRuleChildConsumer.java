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

import org.eclipse.xtext.testlanguages.services.ContentAssistTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.ContentAssistTestLanguageGrammarAccess.FirstAbstractRuleChildElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ContentAssistTestLanguageAbstractRuleConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class ContentAssistTestLanguageFirstAbstractRuleChildConsumer extends NonTerminalConsumer {

	private ContentAssistTestLanguageAbstractRuleConsumer abstractRuleConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	private ICharacterClass keyword$7$Delimiter;
	
	private ICharacterClass keyword$10$Delimiter;
	
	private ICharacterClass keyword$11$Delimiter;
	
	private ISequenceMatcher ruleCall$6$Delimiter;
	
	public ContentAssistTestLanguageFirstAbstractRuleChildConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		keyword$7$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$10$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$6$Delimiter = ISequenceMatcher.Factory.nullMatcher();
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
				result = consumeAssignment$5(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0000AssignmentName());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeKeyword$7(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0001KeywordLeftParenthesis());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeAssignment$8(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele001AssignmentElements());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 3:
				announceNextStep();
				result = consumeKeyword$10(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele01KeywordRightParenthesis());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 4:
				announceNextStep();
				result = consumeKeyword$11(nextEntryPoint());
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

	protected int consumeAssignment$5(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(idConsumer, "name", false, false, getRule().ele00000LexerRuleCallID(), getRuleCall$6$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$7(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0001KeywordLeftParenthesis(), null, false, false, getKeyword$7$Delimiter());
	}

	protected int consumeAssignment$8(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		announceNextLevel();
		switch(entryPoint) {
			case -1:
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = doConsumeAssignment$8(nextEntryPoint());
			case 1:
				announceNextStep();
				if (result == ConsumeResult.SUCCESS) {
					marker.flush();
					while(doConsumeAssignment$8(nextEntryPoint())==ConsumeResult.SUCCESS) {
						marker.flush();
					}
					marker.rollback();
					announceLevelFinished();
					return ConsumeResult.SUCCESS;
				} else {
					error("Could not find token.", getRule().ele001AssignmentElements());
				}
		}
		announceLevelFinished();
		marker.commit();
		return result;
	}

	protected int doConsumeAssignment$8(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeNonTerminal(abstractRuleConsumer, "elements", true, false, getRule().ele0010ParserRuleCallAbstractRule());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$10(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele01KeywordRightParenthesis(), null, false, false, getKeyword$10$Delimiter());
	}

	protected int consumeKeyword$11(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele1KeywordSemicolon(), null, false, false, getKeyword$11$Delimiter());
	}

	public FirstAbstractRuleChildElements getRule() {
		return ContentAssistTestLanguageGrammarAccess.INSTANCE.prFirstAbstractRuleChild();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "FirstAbstractRuleChild";
	}
	
	public void setAbstractRuleConsumer(ContentAssistTestLanguageAbstractRuleConsumer abstractRuleConsumer) {
		this.abstractRuleConsumer = abstractRuleConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public ICharacterClass getKeyword$7$Delimiter() {
		return keyword$7$Delimiter;
	}
	
	public void setKeyword$7$Delimiter(ICharacterClass characterClass) {
		keyword$7$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
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
	
	public ISequenceMatcher getRuleCall$6$Delimiter() {
		return ruleCall$6$Delimiter;
	}
	
	public void setRuleCall$6$Delimiter(ISequenceMatcher matcher) {
		ruleCall$6$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

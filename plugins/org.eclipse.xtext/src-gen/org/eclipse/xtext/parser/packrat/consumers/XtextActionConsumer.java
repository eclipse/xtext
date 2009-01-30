/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarAccess.ActionElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextTypeRefConsumer;

@SuppressWarnings("unused")
public final class XtextActionConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private XtextTypeRefConsumer typeRefConsumer;

	private ICharacterClass keyword$8$Delimiter;
	
	private ICharacterClass keyword$10$Delimiter;
	
	private ICharacterClass keyword$11$Delimiter;
	
	private ICharacterClass keyword$14$Delimiter;
	
	private ICharacterClass keyword$19$Delimiter;
	
	private ICharacterClass keyword$20$Delimiter;
	
	private ICharacterClass keyword$21$Delimiter;
	
	private ICharacterClass keyword$22$Delimiter;
	
	private ISequenceMatcher ruleCall$16$Delimiter;
	
	public XtextActionConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		keyword$8$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$10$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$14$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$19$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$20$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$21$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$22$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$16$Delimiter = ISequenceMatcher.Factory.nullMatcher();
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
				result = consumeKeyword$8(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0000000KeywordLeftCurlyBracket());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeGroup$9(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0000001Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeAssignment$12(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele000001AssignmentTypeName());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 3:
				announceNextStep();
				result = consumeKeyword$14(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00001KeywordFullStop());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 4:
				announceNextStep();
				result = consumeAssignment$15(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0001AssignmentFeature());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 5:
				announceNextStep();
				result = consumeAssignment$17(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele001AssignmentOperator());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 6:
				announceNextStep();
				result = consumeKeyword$21(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele01KeywordCurrent());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 7:
				announceNextStep();
				result = consumeKeyword$22(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1KeywordRightCurlyBracket());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$8(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0000000KeywordLeftCurlyBracket(), null, false, false, getKeyword$8$Delimiter());
	}

	protected int consumeGroup$9(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$9(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$9(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fallthrough semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$10(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00000010KeywordCurrent());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeKeyword$11(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00000011KeywordEqualsSign());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$10(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele00000010KeywordCurrent(), null, false, false, getKeyword$10$Delimiter());
	}

	protected int consumeKeyword$11(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele00000011KeywordEqualsSign(), null, false, false, getKeyword$11$Delimiter());
	}

	protected int consumeAssignment$12(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeNonTerminal(typeRefConsumer, "typeName", false, false, getRule().ele0000010ParserRuleCallTypeRef());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$14(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele00001KeywordFullStop(), null, false, false, getKeyword$14$Delimiter());
	}

	protected int consumeAssignment$15(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(idConsumer, "feature", false, false, getRule().ele00010LexerRuleCallID(), getRuleCall$16$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$17(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		// TODO use markers in assignments of alternatives to recover
		announceNextPath();
		tempResult = consumeKeyword(getRule().ele00100KeywordEqualsSign(), "operator", false, false, getKeyword$19$Delimiter()); 
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 

		announceNextPath();
		tempResult = consumeKeyword(getRule().ele00101KeywordPlusSignEqualsSign(), "operator", false, false, getKeyword$20$Delimiter()); 
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 

		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$21(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele01KeywordCurrent(), null, false, false, getKeyword$21$Delimiter());
	}

	protected int consumeKeyword$22(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightCurlyBracket(), null, false, false, getKeyword$22$Delimiter());
	}

	public ActionElements getRule() {
		return XtextGrammarAccess.INSTANCE.prAction();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Action";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setTypeRefConsumer(XtextTypeRefConsumer typeRefConsumer) {
		this.typeRefConsumer = typeRefConsumer;
	}
	
	public ICharacterClass getKeyword$8$Delimiter() {
		return keyword$8$Delimiter;
	}
	
	public void setKeyword$8$Delimiter(ICharacterClass characterClass) {
		keyword$8$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
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
	
	public ICharacterClass getKeyword$19$Delimiter() {
		return keyword$19$Delimiter;
	}
	
	public void setKeyword$19$Delimiter(ICharacterClass characterClass) {
		keyword$19$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$20$Delimiter() {
		return keyword$20$Delimiter;
	}
	
	public void setKeyword$20$Delimiter(ICharacterClass characterClass) {
		keyword$20$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$21$Delimiter() {
		return keyword$21$Delimiter;
	}
	
	public void setKeyword$21$Delimiter(ICharacterClass characterClass) {
		keyword$21$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$22$Delimiter() {
		return keyword$22$Delimiter;
	}
	
	public void setKeyword$22$Delimiter(ICharacterClass characterClass) {
		keyword$22$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$16$Delimiter() {
		return ruleCall$16$Delimiter;
	}
	
	public void setRuleCall$16$Delimiter(ISequenceMatcher matcher) {
		ruleCall$16$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

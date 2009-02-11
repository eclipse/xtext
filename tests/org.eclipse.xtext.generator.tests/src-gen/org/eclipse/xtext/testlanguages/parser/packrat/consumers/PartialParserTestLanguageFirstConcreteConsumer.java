/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess.FirstConcreteElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageNamedConsumer;

@SuppressWarnings("unused")
public final class PartialParserTestLanguageFirstConcreteConsumer extends NonTerminalConsumer {

	private ITerminalConsumer idConsumer;
	private INonTerminalConsumer namedConsumer;

	private ISequenceMatcher crossReference$12$Delimiter;
	
	private ICharacterClass keyword$6$Delimiter;
	
	private ICharacterClass keyword$7$Delimiter;
	
	private ICharacterClass keyword$8$Delimiter;
	
	private ICharacterClass keyword$14$Delimiter;
	
	public PartialParserTestLanguageFirstConcreteConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		crossReference$12$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$6$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$7$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$8$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$14$Delimiter = ICharacterClass.Factory.nullClass();
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
				result = consumeKeyword$6(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00000KeywordHyphenMinusGreaterThanSign());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeKeyword$7(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00001KeywordF());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeKeyword$8(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0001KeywordLeftParenthesis());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 3:
				announceNextStep();
				result = consumeAssignment$9(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele001AssignmentValue());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 4:
				announceNextStep();
				result = consumeAssignment$11(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele01AssignmentReferencedContainer());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 5:
				announceNextStep();
				result = consumeKeyword$14(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1KeywordRightParenthesis());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$6(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele00000KeywordHyphenMinusGreaterThanSign(), null, false, false, getKeyword$6$Delimiter());
	}

	protected int consumeKeyword$7(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele00001KeywordF(), null, false, false, getKeyword$7$Delimiter());
	}

	protected int consumeKeyword$8(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0001KeywordLeftParenthesis(), null, false, false, getKeyword$8$Delimiter());
	}

	protected int consumeAssignment$9(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeNonTerminal(namedConsumer, "value", false, false, false, getRule().ele0010ParserRuleCallNamed());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$11(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeAssignment$11(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$11(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(idConsumer, "referencedContainer", false, false, getRule().ele010CrossReferenceEStringContainer(), getCrossReference$12$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$14(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightParenthesis(), null, false, false, getKeyword$14$Delimiter());
	}

	public FirstConcreteElements getRule() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prFirstConcrete();
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "FirstConcrete";
	}
	
	public void setIdConsumer(ITerminalConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setNamedConsumer(INonTerminalConsumer namedConsumer) {
		this.namedConsumer = namedConsumer;
	}
	
	public ISequenceMatcher getCrossReference$12$Delimiter() {
		return crossReference$12$Delimiter;
	}
	
	public void setCrossReference$12$Delimiter(ISequenceMatcher matcher) {
		crossReference$12$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$6$Delimiter() {
		return keyword$6$Delimiter;
	}
	
	public void setKeyword$6$Delimiter(ICharacterClass characterClass) {
		keyword$6$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$7$Delimiter() {
		return keyword$7$Delimiter;
	}
	
	public void setKeyword$7$Delimiter(ICharacterClass characterClass) {
		keyword$7$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$8$Delimiter() {
		return keyword$8$Delimiter;
	}
	
	public void setKeyword$8$Delimiter(ICharacterClass characterClass) {
		keyword$8$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$14$Delimiter() {
		return keyword$14$Delimiter;
	}
	
	public void setKeyword$14$Delimiter(ICharacterClass characterClass) {
		keyword$14$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}

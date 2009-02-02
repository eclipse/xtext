/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess.ModelElements;

import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageDotsConsumer;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageFractionConsumer;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageNestedModelIdConsumer;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageVectorConsumer;

@SuppressWarnings("unused")
public final class DatatypeRulesTestLanguageModelConsumer extends NonTerminalConsumer {

	private DatatypeRulesTestLanguageDotsConsumer dotsConsumer;
	private DatatypeRulesTestLanguageFractionConsumer fractionConsumer;
	private DatatypeRulesTestLanguageNestedModelIdConsumer nestedModelIdConsumer;
	private DatatypeRulesTestLanguageVectorConsumer vectorConsumer;

	private ICharacterClass keyword$8$Delimiter;
	
	private ICharacterClass keyword$12$Delimiter;
	
	private ICharacterClass keyword$16$Delimiter;
	
	private ICharacterClass keyword$19$Delimiter;
	
	public DatatypeRulesTestLanguageModelConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		keyword$8$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$12$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$16$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$19$Delimiter = ICharacterClass.Factory.nullClass();
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
				result = consumeAssignment$5(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0000AssignmentId());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeGroup$7(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0001Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeGroup$11(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele001Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 3:
				announceNextStep();
				result = consumeGroup$15(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele01Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 4:
				announceNextStep();
				result = consumeKeyword$19(nextEntryPoint());
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
		tempResult = consumeNonTerminal(nestedModelIdConsumer, "id", false, true, getRule().ele00000ParserRuleCallNestedModelId());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeGroup$7(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$7(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$7(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$8(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00010KeywordColon());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$9(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00011AssignmentValue());
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
		return consumeKeyword(getRule().ele00010KeywordColon(), null, false, false, getKeyword$8$Delimiter());
	}

	protected int consumeAssignment$9(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeNonTerminal(fractionConsumer, "value", false, true, getRule().ele000110ParserRuleCallFraction());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeGroup$11(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$11(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$11(int entryPoint) throws Exception {
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
					error("Another token expected.", getRule().ele0010KeywordNumberSign());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$13(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0011AssignmentVector());
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
		return consumeKeyword(getRule().ele0010KeywordNumberSign(), null, false, false, getKeyword$12$Delimiter());
	}

	protected int consumeAssignment$13(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeNonTerminal(vectorConsumer, "vector", false, true, getRule().ele00110ParserRuleCallVector());
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
		int result = doConsumeGroup$15(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
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
					error("Another token expected.", getRule().ele010KeywordPlusSign());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$17(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele011AssignmentDots());
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
		return consumeKeyword(getRule().ele010KeywordPlusSign(), null, false, false, getKeyword$16$Delimiter());
	}

	protected int consumeAssignment$17(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeNonTerminal(dotsConsumer, "dots", false, true, getRule().ele0110ParserRuleCallDots());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$19(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele1KeywordSemicolon(), null, false, false, getKeyword$19$Delimiter());
	}

	public ModelElements getRule() {
		return DatatypeRulesTestLanguageGrammarAccess.INSTANCE.prModel();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Model";
	}
	
	public void setDotsConsumer(DatatypeRulesTestLanguageDotsConsumer dotsConsumer) {
		this.dotsConsumer = dotsConsumer;
	}
	
	public void setFractionConsumer(DatatypeRulesTestLanguageFractionConsumer fractionConsumer) {
		this.fractionConsumer = fractionConsumer;
	}
	
	public void setNestedModelIdConsumer(DatatypeRulesTestLanguageNestedModelIdConsumer nestedModelIdConsumer) {
		this.nestedModelIdConsumer = nestedModelIdConsumer;
	}
	
	public void setVectorConsumer(DatatypeRulesTestLanguageVectorConsumer vectorConsumer) {
		this.vectorConsumer = vectorConsumer;
	}
	
	public ICharacterClass getKeyword$8$Delimiter() {
		return keyword$8$Delimiter;
	}
	
	public void setKeyword$8$Delimiter(ICharacterClass characterClass) {
		keyword$8$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
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
	
}

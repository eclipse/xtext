/*
Generated with Xtext
*/
package org.eclipse.xtext.reference.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.reference.services.ReferenceGrammarGrammarAccess;
import org.eclipse.xtext.reference.services.ReferenceGrammarGrammarAccess.FarbeElements;


@SuppressWarnings("unused")
public final class ReferenceGrammarFarbeConsumer extends NonTerminalConsumer {


	private ICharacterClass keyword$5$Delimiter;
	
	private ICharacterClass keyword$6$Delimiter;
	
	private ICharacterClass keyword$7$Delimiter;
	
	private ICharacterClass keyword$8$Delimiter;
	
	public ReferenceGrammarFarbeConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		keyword$5$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$6$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$7$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$8$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected int doConsume(int entryPoint) throws Exception {
		return consumeAssignment$1(entryPoint);
	}

	protected int consumeAssignment$1(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		// TODO use markers in assignments of alternatives to recover
		announceNextPath();
		// TODO use markers in assignments of alternatives to recover
		announceNextPath();
		// TODO use markers in assignments of alternatives to recover
		announceNextPath();
		tempResult = consumeKeyword(getRule().ele0000KeywordROT(), "wert", false, false, getKeyword$5$Delimiter()); 
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 

		announceNextPath();
		tempResult = consumeKeyword(getRule().ele0001KeywordBLAU(), "wert", false, false, getKeyword$6$Delimiter()); 
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 


		announceNextPath();
		tempResult = consumeKeyword(getRule().ele001KeywordGELB(), "wert", false, false, getKeyword$7$Delimiter()); 
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 


		announceNextPath();
		tempResult = consumeKeyword(getRule().ele01KeywordGRÜN(), "wert", false, false, getKeyword$8$Delimiter()); 
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 

		announceLevelFinished();
		return result;
	}

	public FarbeElements getRule() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prFarbe();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Farbe";
	}
	
	public ICharacterClass getKeyword$5$Delimiter() {
		return keyword$5$Delimiter;
	}
	
	public void setKeyword$5$Delimiter(ICharacterClass characterClass) {
		keyword$5$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
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
	
}

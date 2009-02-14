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

import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess.LookAhead4Elements;


@SuppressWarnings("unused")
public final class LookaheadTestLanguageLookAhead4Consumer extends NonTerminalConsumer {

	private LookAhead4Elements rule;
	

	private ICharacterClass keyword$3$Delimiter;
	
	private ICharacterClass keyword$5$Delimiter;
	
	public LookaheadTestLanguageLookAhead4Consumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		keyword$3$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$5$Delimiter = ICharacterClass.Factory.nullClass();
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
				if (result.isAlternativeDone(consumeAssignment$2(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeAssignment$4(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}

	protected int consumeAssignment$2(int entryPoint) throws Exception {
		return consumeKeyword$3(entryPoint);
	}

	protected int consumeKeyword$3(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele00KeywordC(), "x", false, false, getKeyword$3$Delimiter());
	}

	protected int consumeAssignment$4(int entryPoint) throws Exception {
		return consumeKeyword$5(entryPoint);
	}

	protected int consumeKeyword$5(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele10KeywordD(), "x", false, false, getKeyword$5$Delimiter());
	}

	public LookAhead4Elements getRule() {
	// LookaheadTestLanguageGrammarAccess.INSTANCE.prLookAhead4()
		return rule;
	}
	
	public void setRule(LookAhead4Elements rule) {
		this.rule = rule;
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "LookAhead4";
	}
	
	public ICharacterClass getKeyword$3$Delimiter() {
		return keyword$3$Delimiter;
	}
	
	public void setKeyword$3$Delimiter(ICharacterClass characterClass) {
		keyword$3$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$5$Delimiter() {
		return keyword$5$Delimiter;
	}
	
	public void setKeyword$5$Delimiter(ICharacterClass characterClass) {
		keyword$5$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}

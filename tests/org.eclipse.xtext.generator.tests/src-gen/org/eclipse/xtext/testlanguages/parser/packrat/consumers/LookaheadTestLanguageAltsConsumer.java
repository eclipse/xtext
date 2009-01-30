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

import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess.AltsElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LookaheadTestLanguageLookAhead0Consumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LookaheadTestLanguageLookAhead1Consumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LookaheadTestLanguageLookAhead3Consumer;

@SuppressWarnings("unused")
public final class LookaheadTestLanguageAltsConsumer extends NonTerminalConsumer {

	private LookaheadTestLanguageLookAhead0Consumer lookAhead0Consumer;
	private LookaheadTestLanguageLookAhead1Consumer lookAhead1Consumer;
	private LookaheadTestLanguageLookAhead3Consumer lookAhead3Consumer;

	public LookaheadTestLanguageAltsConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
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
				tempResult = consumeRuleCall$3(nextEntryPoint()); 
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
				tempResult = consumeRuleCall$4(nextEntryPoint()); 
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
				tempResult = consumeRuleCall$5(nextEntryPoint()); 
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

	protected int consumeRuleCall$3(int entryPoint) throws Exception {
		return consumeNonTerminal(lookAhead0Consumer, null, false, false, getRule().ele00ParserRuleCallLookAhead0());
	}

	protected int consumeRuleCall$4(int entryPoint) throws Exception {
		return consumeNonTerminal(lookAhead1Consumer, null, false, false, getRule().ele01ParserRuleCallLookAhead1());
	}

	protected int consumeRuleCall$5(int entryPoint) throws Exception {
		return consumeNonTerminal(lookAhead3Consumer, null, false, false, getRule().ele1ParserRuleCallLookAhead3());
	}

	public AltsElements getRule() {
		return LookaheadTestLanguageGrammarAccess.INSTANCE.prAlts();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Alts";
	}
	
	public void setLookAhead0Consumer(LookaheadTestLanguageLookAhead0Consumer lookAhead0Consumer) {
		this.lookAhead0Consumer = lookAhead0Consumer;
	}
	
	public void setLookAhead1Consumer(LookaheadTestLanguageLookAhead1Consumer lookAhead1Consumer) {
		this.lookAhead1Consumer = lookAhead1Consumer;
	}
	
	public void setLookAhead3Consumer(LookaheadTestLanguageLookAhead3Consumer lookAhead3Consumer) {
		this.lookAhead3Consumer = lookAhead3Consumer;
	}
	
}

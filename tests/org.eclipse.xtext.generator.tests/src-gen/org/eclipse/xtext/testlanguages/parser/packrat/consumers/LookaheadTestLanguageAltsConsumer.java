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
		AlternativesResult result = createAlternativesResult();
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result.reset();
			case 0:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$3(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$4(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 2:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$5(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
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

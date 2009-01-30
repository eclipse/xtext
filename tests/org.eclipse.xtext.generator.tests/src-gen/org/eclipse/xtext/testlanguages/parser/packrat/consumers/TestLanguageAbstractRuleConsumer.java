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

import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess.AbstractRuleElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.TestLanguageChoiceRuleConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.TestLanguageReducibleRuleConsumer;

@SuppressWarnings("unused")
public final class TestLanguageAbstractRuleConsumer extends NonTerminalConsumer {

	private TestLanguageChoiceRuleConsumer choiceRuleConsumer;
	private TestLanguageReducibleRuleConsumer reducibleRuleConsumer;

	public TestLanguageAbstractRuleConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
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
				tempResult = consumeRuleCall$2(nextEntryPoint()); 
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
		}
		bestMarker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeRuleCall$2(int entryPoint) throws Exception {
		return consumeNonTerminal(choiceRuleConsumer, null, false, false, getRule().ele0ParserRuleCallChoiceRule());
	}

	protected int consumeRuleCall$3(int entryPoint) throws Exception {
		return consumeNonTerminal(reducibleRuleConsumer, null, false, false, getRule().ele1ParserRuleCallReducibleRule());
	}

	public AbstractRuleElements getRule() {
		return TestLanguageGrammarAccess.INSTANCE.prAbstractRule();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setChoiceRuleConsumer(TestLanguageChoiceRuleConsumer choiceRuleConsumer) {
		this.choiceRuleConsumer = choiceRuleConsumer;
	}
	
	public void setReducibleRuleConsumer(TestLanguageReducibleRuleConsumer reducibleRuleConsumer) {
		this.reducibleRuleConsumer = reducibleRuleConsumer;
	}
	
}

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

import org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageGrammarAccess.ParensElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.SimpleExpressionsTestLanguageAdditionConsumer;

@SuppressWarnings("unused")
public final class SimpleExpressionsTestLanguageParensConsumer extends NonTerminalConsumer {

	private SimpleExpressionsTestLanguageAdditionConsumer additionConsumer;

	private ICharacterClass keyword$3$Delimiter;
	
	private ICharacterClass keyword$5$Delimiter;
	
	public SimpleExpressionsTestLanguageParensConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		keyword$3$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$5$Delimiter = ICharacterClass.Factory.nullClass();
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
				result = consumeKeyword$3(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00KeywordLeftParenthesis());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeRuleCall$4(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele01ParserRuleCallAddition());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeKeyword$5(nextEntryPoint());
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

	protected int consumeKeyword$3(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele00KeywordLeftParenthesis(), null, false, false, getKeyword$3$Delimiter());
	}

	protected int consumeRuleCall$4(int entryPoint) throws Exception {
		return consumeNonTerminal(additionConsumer, null, false, false, getRule().ele01ParserRuleCallAddition());
	}

	protected int consumeKeyword$5(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightParenthesis(), null, false, false, getKeyword$5$Delimiter());
	}

	public ParensElements getRule() {
		return SimpleExpressionsTestLanguageGrammarAccess.INSTANCE.prParens();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Expression";
	}
	
	public void setAdditionConsumer(SimpleExpressionsTestLanguageAdditionConsumer additionConsumer) {
		this.additionConsumer = additionConsumer;
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

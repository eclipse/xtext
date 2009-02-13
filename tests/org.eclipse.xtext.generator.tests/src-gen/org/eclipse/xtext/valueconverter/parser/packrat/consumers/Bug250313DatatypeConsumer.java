/*
Generated with Xtext
*/
package org.eclipse.xtext.valueconverter.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.valueconverter.services.Bug250313GrammarAccess;
import org.eclipse.xtext.valueconverter.services.Bug250313GrammarAccess.DatatypeElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class Bug250313DatatypeConsumer extends NonTerminalConsumer {

	private ITerminalConsumer idConsumer;

	private ICharacterClass keyword$4$Delimiter;
	
	private ICharacterClass keyword$6$Delimiter;
	
	private ISequenceMatcher ruleCall$5$Delimiter;
	
	private ISequenceMatcher ruleCall$7$Delimiter;
	
	public Bug250313DatatypeConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		keyword$4$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$6$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$5$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$7$Delimiter = ISequenceMatcher.Factory.nullMatcher();
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
				result = consumeKeyword$4(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele000KeywordGreaterThanSignGreaterThanSign());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeRuleCall$5(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele001LexerRuleCallID());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeKeyword$6(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele01KeywordHyphenMinus());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 3:
				announceNextStep();
				result = consumeRuleCall$7(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1LexerRuleCallID());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$4(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele000KeywordGreaterThanSignGreaterThanSign(), null, false, false, getKeyword$4$Delimiter());
	}

	protected int consumeRuleCall$5(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, null, false, false, getRule().ele001LexerRuleCallID(), getRuleCall$5$Delimiter());
	}

	protected int consumeKeyword$6(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele01KeywordHyphenMinus(), null, false, false, getKeyword$6$Delimiter());
	}

	protected int consumeRuleCall$7(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, null, false, false, getRule().ele1LexerRuleCallID(), getRuleCall$7$Delimiter());
	}

	public DatatypeElements getRule() {
		return Bug250313GrammarAccess.INSTANCE.prDatatype();
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "EString";
	}
	
	public void setIdConsumer(ITerminalConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public ICharacterClass getKeyword$4$Delimiter() {
		return keyword$4$Delimiter;
	}
	
	public void setKeyword$4$Delimiter(ICharacterClass characterClass) {
		keyword$4$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$6$Delimiter() {
		return keyword$6$Delimiter;
	}
	
	public void setKeyword$6$Delimiter(ICharacterClass characterClass) {
		keyword$6$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$5$Delimiter() {
		return ruleCall$5$Delimiter;
	}
	
	public void setRuleCall$5$Delimiter(ISequenceMatcher matcher) {
		ruleCall$5$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$7$Delimiter() {
		return ruleCall$7$Delimiter;
	}
	
	public void setRuleCall$7$Delimiter(ISequenceMatcher matcher) {
		ruleCall$7$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

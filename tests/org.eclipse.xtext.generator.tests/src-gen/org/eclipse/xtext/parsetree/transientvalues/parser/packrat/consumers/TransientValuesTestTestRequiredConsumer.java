/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess;
import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess.TestRequiredElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;

@SuppressWarnings("unused")
public final class TransientValuesTestTestRequiredConsumer extends NonTerminalConsumer {

	private ITerminalConsumer intConsumer;

	private ICharacterClass keyword$3$Delimiter;
	
	private ISequenceMatcher ruleCall$5$Delimiter;
	
	private ISequenceMatcher ruleCall$7$Delimiter;
	
	public TransientValuesTestTestRequiredConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		keyword$3$Delimiter = ICharacterClass.Factory.nullClass();
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
				result = consumeKeyword$3(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00KeywordRequired());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$4(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele01AssignmentRequired1());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeAssignment$6(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1AssignmentRequired2());
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
		return consumeKeyword(getRule().ele00KeywordRequired(), null, false, false, getKeyword$3$Delimiter());
	}

	protected int consumeAssignment$4(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(intConsumer, "required1", false, false, getRule().ele010LexerRuleCallINT(), getRuleCall$5$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$6(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(intConsumer, "required2", false, false, getRule().ele10LexerRuleCallINT(), getRuleCall$7$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	public TestRequiredElements getRule() {
		return TransientValuesTestGrammarAccess.INSTANCE.prTestRequired();
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TestRequired";
	}
	
	public void setIntConsumer(ITerminalConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	
	public ICharacterClass getKeyword$3$Delimiter() {
		return keyword$3$Delimiter;
	}
	
	public void setKeyword$3$Delimiter(ICharacterClass characterClass) {
		keyword$3$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
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

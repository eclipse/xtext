/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.AbstractRule;

import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.parser.terminalrules.services.HiddenTerminalsTestLanguageGrammarAccess.HidingHiddensElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.HiddenTerminalsTestLanguageInheritingHiddensCallConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.HiddenTerminalsTestLanguageWSConsumer;

@SuppressWarnings("unused")
public final class HiddenTerminalsTestLanguageHidingHiddensConsumer extends NonTerminalConsumer {

	private HidingHiddensElements rule;
	
	private INonTerminalConsumer inheritingHiddensCallConsumer;
	private ITerminalConsumer wsConsumer;

	private ICharacterClass keyword$3$Delimiter;
	
	private ISequenceMatcher ruleCall$5$Delimiter;
	
	public HiddenTerminalsTestLanguageHidingHiddensConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		keyword$3$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$5$Delimiter = ISequenceMatcher.Factory.nullMatcher();
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
					error("Another token expected.", getRule().ele00KeywordHiding());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$4(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele01AssignmentSpace());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeAssignment$6(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1AssignmentCalled());
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
		return consumeKeyword(getRule().ele00KeywordHiding(), null, false, false, getKeyword$3$Delimiter());
	}

	protected int consumeAssignment$4(int entryPoint) throws Exception {
		return consumeRuleCall$5(entryPoint);
	}

	protected int consumeRuleCall$5(int entryPoint) throws Exception {
		return consumeTerminal(wsConsumer, "space", false, false, getRule().ele010ParserRuleCallWS(), getRuleCall$5$Delimiter());
	}

	protected int consumeAssignment$6(int entryPoint) throws Exception {
		return consumeRuleCall$7(entryPoint);
	}

	protected int consumeRuleCall$7(int entryPoint) throws Exception {
		return consumeNonTerminal(inheritingHiddensCallConsumer, "called", false, false, false, getRule().ele10ParserRuleCallInheritingHiddensCall());
	}

	public HidingHiddensElements getRule() {
		return rule;
	}
	
	public void setRule(HidingHiddensElements rule) {
		this.rule = rule;
	}
	
	@Override
	protected AbstractRule getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected EClassifier getDefaultType() {
		return getGrammarElement().getType().getType();
	}
	
	public void setInheritingHiddensCallConsumer(INonTerminalConsumer inheritingHiddensCallConsumer) {
		this.inheritingHiddensCallConsumer = inheritingHiddensCallConsumer;
	}
	
	public void setWsConsumer(ITerminalConsumer wsConsumer) {
		this.wsConsumer = wsConsumer;
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
	
}

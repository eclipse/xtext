/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.TerminalAlternativesElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageTerminalGroupConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarTestLanguageTerminalAlternativesConsumer extends NonTerminalConsumer {

	private TerminalAlternativesElements rule;
	
	private INonTerminalConsumer terminalGroupConsumer;

	private ICharacterClass keyword$7$Delimiter;
	
	public XtextGrammarTestLanguageTerminalAlternativesConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		keyword$7$Delimiter = ICharacterClass.Factory.nullClass();
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
				result = consumeRuleCall$2(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0ParserRuleCallTerminalGroup());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeGroup$3(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeRuleCall$2(int entryPoint) throws Exception {
		return consumeNonTerminal(terminalGroupConsumer, null, false, false, false, getRule().ele0ParserRuleCallTerminalGroup());
	}

	protected int consumeGroup$3(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeGroup$3(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$3(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeAction$5(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele100ActionAlternativesgroups());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeKeyword$7(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele101KeywordVerticalLine());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeAssignment$8(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele11AssignmentGroups());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}
	protected int consumeAction$5(int entryPoint) {
		consumeAction(getRule().ele100ActionAlternativesgroups(), "Alternatives", true);
		return ConsumeResult.SUCCESS;	
	}

	protected int consumeKeyword$7(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele101KeywordVerticalLine(), null, false, false, getKeyword$7$Delimiter());
	}

	protected int consumeAssignment$8(int entryPoint) throws Exception {
		return consumeRuleCall$9(entryPoint);
	}

	protected int consumeRuleCall$9(int entryPoint) throws Exception {
		return consumeNonTerminal(terminalGroupConsumer, "groups", true, false, false, getRule().ele110ParserRuleCallTerminalGroup());
	}

	public TerminalAlternativesElements getRule() {
	// XtextGrammarTestLanguageGrammarAccess.INSTANCE.prTerminalAlternatives()
		return rule;
	}
	
	public void setRule(TerminalAlternativesElements rule) {
		this.rule = rule;
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setTerminalGroupConsumer(INonTerminalConsumer terminalGroupConsumer) {
		this.terminalGroupConsumer = terminalGroupConsumer;
	}
	
	public ICharacterClass getKeyword$7$Delimiter() {
		return keyword$7$Delimiter;
	}
	
	public void setKeyword$7$Delimiter(ICharacterClass characterClass) {
		keyword$7$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}

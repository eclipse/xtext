/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers;

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

import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.TrickyAElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageTrickyA1Consumer;

@SuppressWarnings("unused")
public final class ComplexReconstrTestLanguageTrickyAConsumer extends NonTerminalConsumer {

	private TrickyAElements rule;
	
	private ITerminalConsumer idConsumer;
	private ITerminalConsumer stringConsumer;
	private INonTerminalConsumer trickyA1Consumer;

	private ICharacterClass keyword$5$Delimiter;
	
	private ICharacterClass keyword$13$Delimiter;
	
	private ICharacterClass keyword$17$Delimiter;
	
	private ISequenceMatcher ruleCall$8$Delimiter;
	
	private ISequenceMatcher ruleCall$19$Delimiter;
	
	public ComplexReconstrTestLanguageTrickyAConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		keyword$5$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$13$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$17$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$8$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$19$Delimiter = ISequenceMatcher.Factory.nullMatcher();
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
				result = consumeKeyword$5(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0000KeywordTA());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeRuleCall$6(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0001ParserRuleCallTrickyA1());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeAssignment$7(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele001AssignmentName());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 3:
				announceNextStep();
				result = consumeAlternatives$9(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele01Alternatives());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 4:
				announceNextStep();
				result = consumeAssignment$18(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1AssignmentName());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$5(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0000KeywordTA(), null, false, false, getKeyword$5$Delimiter());
	}

	protected int consumeRuleCall$6(int entryPoint) throws Exception {
		return consumeNonTerminal(trickyA1Consumer, null, false, false, false, getRule().ele0001ParserRuleCallTrickyA1());
	}

	protected int consumeAssignment$7(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeAssignment$7(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$7(int entryPoint) throws Exception {
		return consumeRuleCall$8(entryPoint);
	}

	protected int consumeRuleCall$8(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, "name", true, false, getRule().ele0010LexerRuleCallID(), getRuleCall$8$Delimiter());
	}

	protected int consumeAlternatives$9(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeAlternatives$9(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAlternatives$9(int entryPoint) throws Exception {
		AlternativesResult result = createAlternativesResult();
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result.reset();
			case 0:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeGroup$10(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeGroup$14(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}

	protected int consumeGroup$10(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeAction$11(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0100ActionTypeBx());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeKeyword$13(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0101KeywordX());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}
	protected int consumeAction$11(int entryPoint) {
		consumeAction(getRule().ele0100ActionTypeBx(), false);
		return ConsumeResult.SUCCESS;	
	}

	protected int consumeKeyword$13(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0101KeywordX(), null, false, false, getKeyword$13$Delimiter());
	}

	protected int consumeGroup$14(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeAction$15(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0110ActionTypeCx());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeKeyword$17(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0111KeywordY());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}
	protected int consumeAction$15(int entryPoint) {
		consumeAction(getRule().ele0110ActionTypeCx(), false);
		return ConsumeResult.SUCCESS;	
	}

	protected int consumeKeyword$17(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0111KeywordY(), null, false, false, getKeyword$17$Delimiter());
	}

	protected int consumeAssignment$18(int entryPoint) throws Exception {
		return consumeRuleCall$19(entryPoint);
	}

	protected int consumeRuleCall$19(int entryPoint) throws Exception {
		return consumeTerminal(stringConsumer, "name", true, false, getRule().ele10LexerRuleCallSTRING(), getRuleCall$19$Delimiter());
	}

	public TrickyAElements getRule() {
		return rule;
	}
	
	public void setRule(TrickyAElements rule) {
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
	
	public void setIdConsumer(ITerminalConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setStringConsumer(ITerminalConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public void setTrickyA1Consumer(INonTerminalConsumer trickyA1Consumer) {
		this.trickyA1Consumer = trickyA1Consumer;
	}
	
	public ICharacterClass getKeyword$5$Delimiter() {
		return keyword$5$Delimiter;
	}
	
	public void setKeyword$5$Delimiter(ICharacterClass characterClass) {
		keyword$5$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$13$Delimiter() {
		return keyword$13$Delimiter;
	}
	
	public void setKeyword$13$Delimiter(ICharacterClass characterClass) {
		keyword$13$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$17$Delimiter() {
		return keyword$17$Delimiter;
	}
	
	public void setKeyword$17$Delimiter(ICharacterClass characterClass) {
		keyword$17$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$8$Delimiter() {
		return ruleCall$8$Delimiter;
	}
	
	public void setRuleCall$8$Delimiter(ISequenceMatcher matcher) {
		ruleCall$8$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$19$Delimiter() {
		return ruleCall$19$Delimiter;
	}
	
	public void setRuleCall$19$Delimiter(ISequenceMatcher matcher) {
		ruleCall$19$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

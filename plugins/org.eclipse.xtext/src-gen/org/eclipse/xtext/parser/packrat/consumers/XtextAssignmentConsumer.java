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

import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarAccess.AssignmentElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextAbstractTerminalConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class XtextAssignmentConsumer extends NonTerminalConsumer {

	private AssignmentElements rule;
	
	private INonTerminalConsumer abstractTerminalConsumer;
	private ITerminalConsumer idConsumer;

	private ICharacterClass keyword$8$Delimiter;
	
	private ICharacterClass keyword$9$Delimiter;
	
	private ICharacterClass keyword$10$Delimiter;
	
	private ISequenceMatcher ruleCall$4$Delimiter;
	
	public XtextAssignmentConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		keyword$8$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$9$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$10$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$4$Delimiter = ISequenceMatcher.Factory.nullMatcher();
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
				result = consumeAssignment$3(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00AssignmentFeature());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$5(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele01AssignmentOperator());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeAssignment$11(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1AssignmentTerminal());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$3(int entryPoint) throws Exception {
		return consumeRuleCall$4(entryPoint);
	}

	protected int consumeRuleCall$4(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, "feature", false, false, getRule().ele000LexerRuleCallID(), getRuleCall$4$Delimiter());
	}

	protected int consumeAssignment$5(int entryPoint) throws Exception {
		return consumeAlternatives$6(entryPoint);
	}
	protected int consumeAlternatives$6(int entryPoint) throws Exception {
		AlternativesResult result = createAlternativesResult();
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result.reset();
			case 0:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeKeyword$8(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeKeyword$9(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 2:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeKeyword$10(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}
	

	protected int consumeKeyword$8(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele01000KeywordPlusSignEqualsSign(), "operator", false, false, getKeyword$8$Delimiter());
	}

	protected int consumeKeyword$9(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele01001KeywordEqualsSign(), "operator", false, false, getKeyword$9$Delimiter());
	}

	protected int consumeKeyword$10(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0101KeywordQuestionMarkEqualsSign(), "operator", false, false, getKeyword$10$Delimiter());
	}

	protected int consumeAssignment$11(int entryPoint) throws Exception {
		return consumeRuleCall$12(entryPoint);
	}

	protected int consumeRuleCall$12(int entryPoint) throws Exception {
		return consumeNonTerminal(abstractTerminalConsumer, "terminal", false, false, false, getRule().ele10ParserRuleCallAbstractTerminal());
	}

	public AssignmentElements getRule() {
	// XtextGrammarAccess.INSTANCE.prAssignment()
		return rule;
	}
	
	public void setRule(AssignmentElements rule) {
		this.rule = rule;
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Assignment";
	}
	
	public void setAbstractTerminalConsumer(INonTerminalConsumer abstractTerminalConsumer) {
		this.abstractTerminalConsumer = abstractTerminalConsumer;
	}
	
	public void setIdConsumer(ITerminalConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public ICharacterClass getKeyword$8$Delimiter() {
		return keyword$8$Delimiter;
	}
	
	public void setKeyword$8$Delimiter(ICharacterClass characterClass) {
		keyword$8$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$9$Delimiter() {
		return keyword$9$Delimiter;
	}
	
	public void setKeyword$9$Delimiter(ICharacterClass characterClass) {
		keyword$9$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$10$Delimiter() {
		return keyword$10$Delimiter;
	}
	
	public void setKeyword$10$Delimiter(ICharacterClass characterClass) {
		keyword$10$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$4$Delimiter() {
		return ruleCall$4$Delimiter;
	}
	
	public void setRuleCall$4$Delimiter(ISequenceMatcher matcher) {
		ruleCall$4$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

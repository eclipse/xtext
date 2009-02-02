/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess.AbstractTokenElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageAbstractTerminalConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageActionConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageAssignmentConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageAbstractTokenConsumer extends NonTerminalConsumer {

	private XtextTerminalsTestLanguageAbstractTerminalConsumer abstractTerminalConsumer;
	private XtextTerminalsTestLanguageActionConsumer actionConsumer;
	private XtextTerminalsTestLanguageAssignmentConsumer assignmentConsumer;

	private ICharacterClass keyword$10$Delimiter;
	
	private ICharacterClass keyword$11$Delimiter;
	
	private ICharacterClass keyword$12$Delimiter;
	
	public XtextTerminalsTestLanguageAbstractTokenConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		keyword$10$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$12$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
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
				result = consumeAlternatives$2(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0Alternatives());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$7(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1AssignmentCardinality());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeAlternatives$2(int entryPoint) throws Exception {
		AlternativesResult result = createAlternativesResult();
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result.reset();
			case 0:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$4(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$5(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 2:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$6(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}

	protected int consumeRuleCall$4(int entryPoint) throws Exception {
		return consumeNonTerminal(assignmentConsumer, null, false, false, getRule().ele000ParserRuleCallAssignment());
	}

	protected int consumeRuleCall$5(int entryPoint) throws Exception {
		return consumeNonTerminal(actionConsumer, null, false, false, getRule().ele001ParserRuleCallAction());
	}

	protected int consumeRuleCall$6(int entryPoint) throws Exception {
		return consumeNonTerminal(abstractTerminalConsumer, null, false, false, getRule().ele01ParserRuleCallAbstractTerminal());
	}

	protected int consumeAssignment$7(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeAssignment$7(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$7(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		// TODO use markers in assignments of alternatives to recover
		announceNextPath();
		// TODO use markers in assignments of alternatives to recover
		announceNextPath();
		tempResult = consumeKeyword(getRule().ele1000KeywordQuestionMark(), "cardinality", false, false, getKeyword$10$Delimiter()); 
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 

		announceNextPath();
		tempResult = consumeKeyword(getRule().ele1001KeywordAsterisk(), "cardinality", false, false, getKeyword$11$Delimiter()); 
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 


		announceNextPath();
		tempResult = consumeKeyword(getRule().ele101KeywordPlusSign(), "cardinality", false, false, getKeyword$12$Delimiter()); 
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 

		announceLevelFinished();
		return result;
	}

	public AbstractTokenElements getRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractToken();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setAbstractTerminalConsumer(XtextTerminalsTestLanguageAbstractTerminalConsumer abstractTerminalConsumer) {
		this.abstractTerminalConsumer = abstractTerminalConsumer;
	}
	
	public void setActionConsumer(XtextTerminalsTestLanguageActionConsumer actionConsumer) {
		this.actionConsumer = actionConsumer;
	}
	
	public void setAssignmentConsumer(XtextTerminalsTestLanguageAssignmentConsumer assignmentConsumer) {
		this.assignmentConsumer = assignmentConsumer;
	}
	
	public ICharacterClass getKeyword$10$Delimiter() {
		return keyword$10$Delimiter;
	}
	
	public void setKeyword$10$Delimiter(ICharacterClass characterClass) {
		keyword$10$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$11$Delimiter() {
		return keyword$11$Delimiter;
	}
	
	public void setKeyword$11$Delimiter(ICharacterClass characterClass) {
		keyword$11$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$12$Delimiter() {
		return keyword$12$Delimiter;
	}
	
	public void setKeyword$12$Delimiter(ICharacterClass characterClass) {
		keyword$12$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}

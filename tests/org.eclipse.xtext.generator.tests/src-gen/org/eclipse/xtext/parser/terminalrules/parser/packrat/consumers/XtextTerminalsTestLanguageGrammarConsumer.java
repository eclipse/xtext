/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess.GrammarElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageAbstractMetamodelDeclarationConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageAbstractRuleConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageIDConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageGrammarConsumer extends NonTerminalConsumer {

	private INonTerminalConsumer abstractMetamodelDeclarationConsumer;
	private INonTerminalConsumer abstractRuleConsumer;
	private ITerminalConsumer idConsumer;

	private ICharacterClass keyword$8$Delimiter;
	
	private ICharacterClass keyword$9$Delimiter;
	
	private ICharacterClass keyword$13$Delimiter;
	
	private ICharacterClass keyword$18$Delimiter;
	
	private ICharacterClass keyword$22$Delimiter;
	
	private ISequenceMatcher ruleCall$11$Delimiter;
	
	private ISequenceMatcher ruleCall$15$Delimiter;
	
	private ISequenceMatcher ruleCall$20$Delimiter;
	
	private ISequenceMatcher ruleCall$24$Delimiter;
	
	public XtextTerminalsTestLanguageGrammarConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		keyword$8$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$9$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$13$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$18$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$22$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$11$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$15$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$20$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$24$Delimiter = ISequenceMatcher.Factory.nullMatcher();
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
				result = consumeAlternatives$6(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00000Alternatives());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$10(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00001AssignmentIdElements());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeGroup$12(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0001Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 3:
				announceNextStep();
				result = consumeGroup$16(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele001Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 4:
				announceNextStep();
				result = consumeAssignment$25(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele01AssignmentMetamodelDeclarations());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 5:
				announceNextStep();
				result = consumeAssignment$27(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1AssignmentRules());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeAlternatives$6(int entryPoint) throws Exception {
		AlternativesResult result = createAlternativesResult();
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result.reset();
			case 0:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeAssignment$7(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeKeyword$9(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}

	protected int consumeAssignment$7(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeKeyword(getRule().ele0000000KeywordAbstractLanguage(), "abstract", false, true, getKeyword$8$Delimiter()); 
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$9(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele000001KeywordLanguage(), null, false, false, getKeyword$9$Delimiter());
	}

	protected int consumeAssignment$10(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(idConsumer, "idElements", true, false, getRule().ele000010ParserRuleCallID(), getRuleCall$11$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeGroup$12(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeGroup$12(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$12(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$13(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00010KeywordFullStop());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$14(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00011AssignmentIdElements());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$13(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele00010KeywordFullStop(), null, false, false, getKeyword$13$Delimiter());
	}

	protected int consumeAssignment$14(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(idConsumer, "idElements", true, false, getRule().ele000110ParserRuleCallID(), getRuleCall$15$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeGroup$16(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$16(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$16(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$18(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00100KeywordExtends());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$19(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00101AssignmentSuperGrammarIdElements());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeGroup$21(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0011Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$18(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele00100KeywordExtends(), null, false, false, getKeyword$18$Delimiter());
	}

	protected int consumeAssignment$19(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(idConsumer, "superGrammarIdElements", true, false, getRule().ele001010ParserRuleCallID(), getRuleCall$20$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeGroup$21(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeGroup$21(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$21(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$22(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00110KeywordFullStop());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$23(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00111AssignmentSuperGrammarIdElements());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$22(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele00110KeywordFullStop(), null, false, false, getKeyword$22$Delimiter());
	}

	protected int consumeAssignment$23(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(idConsumer, "superGrammarIdElements", true, false, getRule().ele001110ParserRuleCallID(), getRuleCall$24$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$25(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeAssignment$25(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$25(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeNonTerminal(abstractMetamodelDeclarationConsumer, "metamodelDeclarations", true, false, false, getRule().ele010ParserRuleCallAbstractMetamodelDeclaration());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$27(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		announceNextLevel();
		switch(entryPoint) {
			case -1:
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = doConsumeAssignment$27(nextEntryPoint());
			case 1:
				announceNextStep();
				if (result == ConsumeResult.SUCCESS) {
					marker.flush();
					while(doConsumeAssignment$27(nextEntryPoint())==ConsumeResult.SUCCESS) {
						marker.flush();
					}
					marker.rollback();
					announceLevelFinished();
					return ConsumeResult.SUCCESS;
				} else {
					error("Could not find token.", getRule().ele1AssignmentRules());
				}
		}
		announceLevelFinished();
		marker.commit();
		return result;
	}

	protected int doConsumeAssignment$27(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeNonTerminal(abstractRuleConsumer, "rules", true, false, false, getRule().ele10ParserRuleCallAbstractRule());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	public GrammarElements getRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prGrammar();
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Grammar";
	}
	
	public void setAbstractMetamodelDeclarationConsumer(INonTerminalConsumer abstractMetamodelDeclarationConsumer) {
		this.abstractMetamodelDeclarationConsumer = abstractMetamodelDeclarationConsumer;
	}
	
	public void setAbstractRuleConsumer(INonTerminalConsumer abstractRuleConsumer) {
		this.abstractRuleConsumer = abstractRuleConsumer;
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
	
	public ICharacterClass getKeyword$13$Delimiter() {
		return keyword$13$Delimiter;
	}
	
	public void setKeyword$13$Delimiter(ICharacterClass characterClass) {
		keyword$13$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$18$Delimiter() {
		return keyword$18$Delimiter;
	}
	
	public void setKeyword$18$Delimiter(ICharacterClass characterClass) {
		keyword$18$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$22$Delimiter() {
		return keyword$22$Delimiter;
	}
	
	public void setKeyword$22$Delimiter(ICharacterClass characterClass) {
		keyword$22$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$11$Delimiter() {
		return ruleCall$11$Delimiter;
	}
	
	public void setRuleCall$11$Delimiter(ISequenceMatcher matcher) {
		ruleCall$11$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$15$Delimiter() {
		return ruleCall$15$Delimiter;
	}
	
	public void setRuleCall$15$Delimiter(ISequenceMatcher matcher) {
		ruleCall$15$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$20$Delimiter() {
		return ruleCall$20$Delimiter;
	}
	
	public void setRuleCall$20$Delimiter(ISequenceMatcher matcher) {
		ruleCall$20$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$24$Delimiter() {
		return ruleCall$24$Delimiter;
	}
	
	public void setRuleCall$24$Delimiter(ISequenceMatcher matcher) {
		ruleCall$24$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

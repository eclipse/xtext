/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.TrickyCElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class ComplexReconstrTestLanguageTrickyCConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;

	private ICharacterClass keyword$19$Delimiter;
	
	private ICharacterClass keyword$5$Delimiter;
	
	private ICharacterClass keyword$11$Delimiter;
	
	private ICharacterClass keyword$15$Delimiter;
	
	private ISequenceMatcher ruleCall$7$Delimiter;
	
	public ComplexReconstrTestLanguageTrickyCConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		keyword$19$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$5$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$15$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$7$Delimiter = ISequenceMatcher.Factory.nullMatcher();
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
				result = consumeKeyword$5(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0000KeywordTC());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$6(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0001AssignmentName());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeGroup$8(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele001Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 3:
				announceNextStep();
				result = consumeGroup$12(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele01Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 4:
				announceNextStep();
				result = consumeGroup$16(nextEntryPoint());
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

	protected int consumeKeyword$5(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0000KeywordTC(), null, false, false, getKeyword$5$Delimiter());
	}

	protected int consumeAssignment$6(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(idConsumer, "name", false, false, getRule().ele00010LexerRuleCallID(), getRuleCall$7$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeGroup$8(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$8(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$8(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fallthrough semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeAction$9(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0010ActionC1x());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeKeyword$11(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0011KeywordX());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}
	protected int consumeAction$9(int entryPoint) {
		consumeAction(getRule().ele0010ActionC1x(), "C1", false);
		return ConsumeResult.SUCCESS;	
	}

	protected int consumeKeyword$11(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0011KeywordX(), null, false, false, getKeyword$11$Delimiter());
	}

	protected int consumeGroup$12(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$12(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$12(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fallthrough semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeAction$13(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele010ActionC2y());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeKeyword$15(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele011KeywordY());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}
	protected int consumeAction$13(int entryPoint) {
		consumeAction(getRule().ele010ActionC2y(), "C2", false);
		return ConsumeResult.SUCCESS;	
	}

	protected int consumeKeyword$15(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele011KeywordY(), null, false, false, getKeyword$15$Delimiter());
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
			case -1: // use fallthrough semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeAction$17(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele10ActionC3z());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeKeyword$19(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele11KeywordZ());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}
	protected int consumeAction$17(int entryPoint) {
		consumeAction(getRule().ele10ActionC3z(), "C3", false);
		return ConsumeResult.SUCCESS;	
	}

	protected int consumeKeyword$19(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele11KeywordZ(), null, false, false, getKeyword$19$Delimiter());
	}

	public TrickyCElements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyC();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TrickyC";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public ICharacterClass getKeyword$19$Delimiter() {
		return keyword$19$Delimiter;
	}
	
	public void setKeyword$19$Delimiter(ICharacterClass characterClass) {
		keyword$19$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$5$Delimiter() {
		return keyword$5$Delimiter;
	}
	
	public void setKeyword$5$Delimiter(ICharacterClass characterClass) {
		keyword$5$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$11$Delimiter() {
		return keyword$11$Delimiter;
	}
	
	public void setKeyword$11$Delimiter(ICharacterClass characterClass) {
		keyword$11$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$15$Delimiter() {
		return keyword$15$Delimiter;
	}
	
	public void setKeyword$15$Delimiter(ICharacterClass characterClass) {
		keyword$15$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$7$Delimiter() {
		return ruleCall$7$Delimiter;
	}
	
	public void setRuleCall$7$Delimiter(ISequenceMatcher matcher) {
		ruleCall$7$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

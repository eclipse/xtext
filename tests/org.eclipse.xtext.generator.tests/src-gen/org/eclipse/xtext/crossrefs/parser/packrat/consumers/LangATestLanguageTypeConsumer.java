/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.crossrefs.services.LangATestLanguageGrammarAccess;
import org.eclipse.xtext.crossrefs.services.LangATestLanguageGrammarAccess.TypeElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class LangATestLanguageTypeConsumer extends NonTerminalConsumer {

	private TypeElements rule;
	
	private ITerminalConsumer idConsumer;

	private ISequenceMatcher crossReference$9$Delimiter;
	
	private ICharacterClass keyword$4$Delimiter;
	
	private ICharacterClass keyword$7$Delimiter;
	
	private ISequenceMatcher ruleCall$6$Delimiter;
	
	public LangATestLanguageTypeConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		crossReference$9$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$4$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$7$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$6$Delimiter = ISequenceMatcher.Factory.nullMatcher();
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
					error("Another token expected.", getRule().ele000KeywordType());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$5(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele001AssignmentName());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeKeyword$7(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele01KeywordExtends());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 3:
				announceNextStep();
				result = consumeAssignment$8(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1AssignmentExtends());
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
		return consumeKeyword(getRule().ele000KeywordType(), null, false, false, getKeyword$4$Delimiter());
	}

	protected int consumeAssignment$5(int entryPoint) throws Exception {
		return consumeRuleCall$6(entryPoint);
	}

	protected int consumeRuleCall$6(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, "name", false, false, getRule().ele0010LexerRuleCallID(), getRuleCall$6$Delimiter());
	}

	protected int consumeKeyword$7(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele01KeywordExtends(), null, false, false, getKeyword$7$Delimiter());
	}

	protected int consumeAssignment$8(int entryPoint) throws Exception {
		return consumeCrossReference$9(entryPoint);
	}

	protected int consumeCrossReference$9(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, "extends", false, false, getRule().ele10CrossReferenceEStringType(), getCrossReference$9$Delimiter());
	}

	public TypeElements getRule() {
	// LangATestLanguageGrammarAccess.INSTANCE.prType()
		return rule;
	}
	
	public void setRule(TypeElements rule) {
		this.rule = rule;
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Type";
	}
	
	public void setIdConsumer(ITerminalConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public ISequenceMatcher getCrossReference$9$Delimiter() {
		return crossReference$9$Delimiter;
	}
	
	public void setCrossReference$9$Delimiter(ISequenceMatcher matcher) {
		crossReference$9$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$4$Delimiter() {
		return keyword$4$Delimiter;
	}
	
	public void setKeyword$4$Delimiter(ICharacterClass characterClass) {
		keyword$4$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$7$Delimiter() {
		return keyword$7$Delimiter;
	}
	
	public void setKeyword$7$Delimiter(ICharacterClass characterClass) {
		keyword$7$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$6$Delimiter() {
		return ruleCall$6$Delimiter;
	}
	
	public void setRuleCall$6$Delimiter(ISequenceMatcher matcher) {
		ruleCall$6$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

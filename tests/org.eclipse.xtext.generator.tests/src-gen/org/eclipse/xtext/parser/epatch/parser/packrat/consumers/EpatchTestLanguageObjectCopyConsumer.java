/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.epatch.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess.ObjectCopyElements;

import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageFRAGMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class EpatchTestLanguageObjectCopyConsumer extends NonTerminalConsumer {

	private EpatchTestLanguageFRAGMENTConsumer fragmentConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	private ISequenceMatcher crossReference$5$Delimiter;
	
	private ICharacterClass keyword$3$Delimiter;
	
	private ISequenceMatcher ruleCall$8$Delimiter;
	
	public EpatchTestLanguageObjectCopyConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		crossReference$5$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$3$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$8$Delimiter = ISequenceMatcher.Factory.nullMatcher();
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
				result = consumeKeyword$3(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00KeywordCopy());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$4(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele01AssignmentResource());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeAssignment$7(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1AssignmentFragment());
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
		return consumeKeyword(getRule().ele00KeywordCopy(), null, false, false, getKeyword$3$Delimiter());
	}

	protected int consumeAssignment$4(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(idConsumer, "resource", false, false, getRule().ele010CrossReferenceEStringNamedResource(), getCrossReference$5$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$7(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeTerminal(fragmentConsumer, "fragment", false, false, getRule().ele10LexerRuleCallFRAGMENT(), getRuleCall$8$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	public ObjectCopyElements getRule() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectCopy();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "ObjectCopy";
	}
	
	public void setFragmentConsumer(EpatchTestLanguageFRAGMENTConsumer fragmentConsumer) {
		this.fragmentConsumer = fragmentConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public ISequenceMatcher getCrossReference$5$Delimiter() {
		return crossReference$5$Delimiter;
	}
	
	public void setCrossReference$5$Delimiter(ISequenceMatcher matcher) {
		crossReference$5$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$3$Delimiter() {
		return keyword$3$Delimiter;
	}
	
	public void setKeyword$3$Delimiter(ICharacterClass characterClass) {
		keyword$3$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$8$Delimiter() {
		return ruleCall$8$Delimiter;
	}
	
	public void setRuleCall$8$Delimiter(ISequenceMatcher matcher) {
		ruleCall$8$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat.consumers;

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

import org.eclipse.xtext.example.services.FowlerDslGrammarAccess.TransitionElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class FowlerDslTransitionConsumer extends NonTerminalConsumer {

	private TransitionElements rule;
	
	private ITerminalConsumer idConsumer;

	private ISequenceMatcher crossReference$4$Delimiter;
	
	private ISequenceMatcher crossReference$8$Delimiter;
	
	private ICharacterClass keyword$6$Delimiter;
	
	public FowlerDslTransitionConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		crossReference$4$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		crossReference$8$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$6$Delimiter = ICharacterClass.Factory.nullClass();
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
					error("Another token expected.", getRule().ele00AssignmentEvent());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeKeyword$6(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele01KeywordEqualsSignGreaterThanSign());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeAssignment$7(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1AssignmentState());
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
		return consumeCrossReference$4(entryPoint);
	}

	protected int consumeCrossReference$4(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, "event", false, false, getRule().ele000CrossReferenceEStringEvent(), getCrossReference$4$Delimiter());
	}

	protected int consumeKeyword$6(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele01KeywordEqualsSignGreaterThanSign(), null, false, false, getKeyword$6$Delimiter());
	}

	protected int consumeAssignment$7(int entryPoint) throws Exception {
		return consumeCrossReference$8(entryPoint);
	}

	protected int consumeCrossReference$8(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, "state", false, false, getRule().ele10CrossReferenceEStringState(), getCrossReference$8$Delimiter());
	}

	public TransitionElements getRule() {
		return rule;
	}
	
	public void setRule(TransitionElements rule) {
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
	
	public ISequenceMatcher getCrossReference$4$Delimiter() {
		return crossReference$4$Delimiter;
	}
	
	public void setCrossReference$4$Delimiter(ISequenceMatcher matcher) {
		crossReference$4$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getCrossReference$8$Delimiter() {
		return crossReference$8$Delimiter;
	}
	
	public void setCrossReference$8$Delimiter(ISequenceMatcher matcher) {
		crossReference$8$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$6$Delimiter() {
		return keyword$6$Delimiter;
	}
	
	public void setKeyword$6$Delimiter(ICharacterClass characterClass) {
		keyword$6$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}

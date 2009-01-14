/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.example.services.FowlerDslGrammarAccess;
import org.eclipse.xtext.example.services.FowlerDslGrammarAccess.StateElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.FowlerDslTransitionConsumer;

@SuppressWarnings("unused")
public final class FowlerDslStateConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private FowlerDslTransitionConsumer transitionConsumer;

	private ISequenceMatcher ruleCall$7$Delimiter;
	
	private ISequenceMatcher crossReference$14$Delimiter;
	
	private ICharacterClass keyword$11$Delimiter;
	
	private ICharacterClass keyword$12$Delimiter;
	
	private ICharacterClass keyword$5$Delimiter;
	
	private ICharacterClass keyword$19$Delimiter;
	
	private ICharacterClass keyword$16$Delimiter;
	
	public FowlerDslStateConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		ruleCall$7$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		crossReference$14$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$12$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$5$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$19$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$16$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$5()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$6()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$8()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$17()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$19()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$5() throws Exception {
		return consumeKeyword(getRule().ele0000KeywordState(), null, false, false, getKeyword$5$Delimiter());
	}

	protected boolean consumeAssignment$6() throws Exception {
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele00010LexerRuleCallID(), getRuleCall$7$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeGroup$8() throws Exception {
		doConsumeGroup$8();
		return true;
	}

	protected boolean doConsumeGroup$8() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$11()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$12()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$13()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$16()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele001000KeywordActions(), null, false, false, getKeyword$11$Delimiter());
	}

	protected boolean consumeKeyword$12() throws Exception {
		return consumeKeyword(getRule().ele001001KeywordLeftCurlyBracket(), null, false, false, getKeyword$12$Delimiter());
	}

	protected boolean consumeAssignment$13() throws Exception {
		if (doConsumeAssignment$13()) {
			while(doConsumeAssignment$13()) {}
			return true;
		}
		return false;
	}

	protected boolean doConsumeAssignment$13() throws Exception {
		if (consumeTerminal(idConsumer, null, true, false, getRule().ele001010CrossReferenceEStringCommand(), getCrossReference$14$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$16() throws Exception {
		return consumeKeyword(getRule().ele0011KeywordRightCurlyBracket(), null, false, false, getKeyword$16$Delimiter());
	}

	protected boolean consumeAssignment$17() throws Exception {
		while(doConsumeAssignment$17()) {}
		return true;
	}

	protected boolean doConsumeAssignment$17() throws Exception {
		if (consumeNonTerminal(transitionConsumer, "transitions", true, false, getRule().ele010ParserRuleCallTransition()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$19() throws Exception {
		return consumeKeyword(getRule().ele1KeywordEnd(), null, false, false, getKeyword$19$Delimiter());
	}

	public StateElements getRule() {
		return FowlerDslGrammarAccess.INSTANCE.prState();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "State";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setTransitionConsumer(FowlerDslTransitionConsumer transitionConsumer) {
		this.transitionConsumer = transitionConsumer;
	}
	
	public ISequenceMatcher getRuleCall$7$Delimiter() {
		return ruleCall$7$Delimiter;
	}
	
	public void setRuleCall$7$Delimiter(ISequenceMatcher matcher) {
		ruleCall$7$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getCrossReference$14$Delimiter() {
		return crossReference$14$Delimiter;
	}
	
	public void setCrossReference$14$Delimiter(ISequenceMatcher matcher) {
		crossReference$14$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
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
	
	public ICharacterClass getKeyword$5$Delimiter() {
		return keyword$5$Delimiter;
	}
	
	public void setKeyword$5$Delimiter(ICharacterClass characterClass) {
		keyword$5$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$19$Delimiter() {
		return keyword$19$Delimiter;
	}
	
	public void setKeyword$19$Delimiter(ICharacterClass characterClass) {
		keyword$19$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$16$Delimiter() {
		return keyword$16$Delimiter;
	}
	
	public void setKeyword$16$Delimiter(ICharacterClass characterClass) {
		keyword$16$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}

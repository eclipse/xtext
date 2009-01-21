/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat.consumers;

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

import org.eclipse.xtext.testlanguages.services.FowlerDslTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.FowlerDslTestLanguageGrammarAccess.EventElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class FowlerDslTestLanguageEventConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;

	private ICharacterClass keyword$4$Delimiter;
	
	private ISequenceMatcher ruleCall$6$Delimiter;
	
	private ISequenceMatcher ruleCall$8$Delimiter;
	
	public FowlerDslTestLanguageEventConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$4$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$6$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$8$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeAssignment$3()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$5()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$7()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}

	protected boolean consumeAssignment$3() throws Exception {
		doConsumeAssignment$3();
		return true;
	}

	protected boolean doConsumeAssignment$3() throws Exception {
		if (consumeKeyword(getRule().ele000KeywordResetting(), "resetting", false, true, getKeyword$4$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$5() throws Exception {
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele010LexerRuleCallID(), getRuleCall$6$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$7() throws Exception {
		if (consumeTerminal(idConsumer, "code", false, false, getRule().ele10LexerRuleCallID(), getRuleCall$8$Delimiter()))
			return true;
		return false;
	}

	public EventElements getRule() {
		return FowlerDslTestLanguageGrammarAccess.INSTANCE.prEvent();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Event";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public ICharacterClass getKeyword$4$Delimiter() {
		return keyword$4$Delimiter;
	}
	
	public void setKeyword$4$Delimiter(ICharacterClass characterClass) {
		keyword$4$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$6$Delimiter() {
		return ruleCall$6$Delimiter;
	}
	
	public void setRuleCall$6$Delimiter(ISequenceMatcher matcher) {
		ruleCall$6$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$8$Delimiter() {
		return ruleCall$8$Delimiter;
	}
	
	public void setRuleCall$8$Delimiter(ISequenceMatcher matcher) {
		ruleCall$8$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

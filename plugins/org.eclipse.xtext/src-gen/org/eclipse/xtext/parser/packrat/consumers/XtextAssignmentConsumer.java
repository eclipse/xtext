/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.packrat.consumers;

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

import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarAccess.AssignmentElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextAbstractTerminalConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class XtextAssignmentConsumer extends NonTerminalConsumer {

	private XtextAbstractTerminalConsumer abstractTerminalConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	private ICharacterClass keyword$8$Delimiter;
	
	private ICharacterClass keyword$9$Delimiter;
	
	private ICharacterClass keyword$10$Delimiter;
	
	private ISequenceMatcher ruleCall$4$Delimiter;
	
	public XtextAssignmentConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$8$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$9$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$10$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$4$Delimiter = ISequenceMatcher.Factory.nullMatcher();
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
		if (!consumeAssignment$11()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}

	protected boolean consumeAssignment$3() throws Exception {
		if (consumeTerminal(idConsumer, "feature", false, false, getRule().ele000LexerRuleCallID(), getRuleCall$4$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$5() throws Exception {
		if (consumeKeyword(getRule().ele01000KeywordPlusSignEqualsSign(), "operator", false, false, getKeyword$8$Delimiter()))
			return true;
		if (consumeKeyword(getRule().ele01001KeywordEqualsSign(), "operator", false, false, getKeyword$9$Delimiter()))
			return true;
		if (consumeKeyword(getRule().ele0101KeywordQuestionMarkEqualsSign(), "operator", false, false, getKeyword$10$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$11() throws Exception {
		if (consumeNonTerminal(abstractTerminalConsumer, "terminal", false, false, getRule().ele10ParserRuleCallAbstractTerminal()))
			return true;
		return false;
	}

	public AssignmentElements getRule() {
		return XtextGrammarAccess.INSTANCE.prAssignment();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Assignment";
	}
	
	public void setAbstractTerminalConsumer(XtextAbstractTerminalConsumer abstractTerminalConsumer) {
		this.abstractTerminalConsumer = abstractTerminalConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
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

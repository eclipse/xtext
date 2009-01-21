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

import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess.ErwachsenerElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;

@SuppressWarnings("unused")
public final class ReferenceGrammarTestLanguageErwachsenerConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private XtextBuiltinINTConsumer intConsumer;

	private ICharacterClass keyword$5$Delimiter;
	
	private ICharacterClass keyword$6$Delimiter;
	
	private ICharacterClass keyword$11$Delimiter;
	
	private ISequenceMatcher ruleCall$8$Delimiter;
	
	private ISequenceMatcher ruleCall$10$Delimiter;
	
	public ReferenceGrammarTestLanguageErwachsenerConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$5$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$6$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$8$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$10$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$5()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeKeyword$6()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$7()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$9()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeKeyword$11()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}

	protected boolean consumeKeyword$5() throws Exception {
		return consumeKeyword(getRule().ele0000KeywordErwachsener(), null, false, false, getKeyword$5$Delimiter());
	}

	protected boolean consumeKeyword$6() throws Exception {
		return consumeKeyword(getRule().ele0001KeywordLeftParenthesis(), null, false, false, getKeyword$6$Delimiter());
	}

	protected boolean consumeAssignment$7() throws Exception {
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele0010LexerRuleCallID(), getRuleCall$8$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$9() throws Exception {
		if (consumeTerminal(intConsumer, "age", false, false, getRule().ele010LexerRuleCallINT(), getRuleCall$10$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightParenthesis(), null, false, false, getKeyword$11$Delimiter());
	}

	public ErwachsenerElements getRule() {
		return ReferenceGrammarTestLanguageGrammarAccess.INSTANCE.prErwachsener();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Erwachsener";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setIntConsumer(XtextBuiltinINTConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	
	public ICharacterClass getKeyword$5$Delimiter() {
		return keyword$5$Delimiter;
	}
	
	public void setKeyword$5$Delimiter(ICharacterClass characterClass) {
		keyword$5$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$6$Delimiter() {
		return keyword$6$Delimiter;
	}
	
	public void setKeyword$6$Delimiter(ICharacterClass characterClass) {
		keyword$6$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$11$Delimiter() {
		return keyword$11$Delimiter;
	}
	
	public void setKeyword$11$Delimiter(ICharacterClass characterClass) {
		keyword$11$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$8$Delimiter() {
		return ruleCall$8$Delimiter;
	}
	
	public void setRuleCall$8$Delimiter(ISequenceMatcher matcher) {
		ruleCall$8$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$10$Delimiter() {
		return ruleCall$10$Delimiter;
	}
	
	public void setRuleCall$10$Delimiter(ISequenceMatcher matcher) {
		ruleCall$10$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

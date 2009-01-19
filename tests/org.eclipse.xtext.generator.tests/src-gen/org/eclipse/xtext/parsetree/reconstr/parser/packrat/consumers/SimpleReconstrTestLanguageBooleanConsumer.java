/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers;

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

import org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestLanguageGrammarAccess.BooleanElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class SimpleReconstrTestLanguageBooleanConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;

	private ICharacterClass keyword$4$Delimiter;
	
	private ISequenceMatcher ruleCall$9$Delimiter;
	
	private ICharacterClass keyword$7$Delimiter;
	
	private ICharacterClass keyword$6$Delimiter;
	
	public SimpleReconstrTestLanguageBooleanConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$4$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$9$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$7$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$6$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$4()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$5()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$7()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$8()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$4() throws Exception {
		return consumeKeyword(getRule().ele000KeywordNumberSignDigitFour(), null, false, false, getKeyword$4$Delimiter());
	}

	protected boolean consumeAssignment$5() throws Exception {
		doConsumeAssignment$5();
		return true;
	}

	protected boolean doConsumeAssignment$5() throws Exception {
		if (consumeKeyword(getRule().ele0010KeywordMyoption(), "bool", false, true, getKeyword$6$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$7() throws Exception {
		return consumeKeyword(getRule().ele01KeywordKw(), null, false, false, getKeyword$7$Delimiter());
	}

	protected boolean consumeAssignment$8() throws Exception {
		if (consumeTerminal(idConsumer, "value", false, false, getRule().ele10LexerRuleCallID(), getRuleCall$9$Delimiter()))
			return true;
		return false;
	}

	public BooleanElements getRule() {
		return SimpleReconstrTestLanguageGrammarAccess.INSTANCE.prBoolean();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Boolean";
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
	
	public ISequenceMatcher getRuleCall$9$Delimiter() {
		return ruleCall$9$Delimiter;
	}
	
	public void setRuleCall$9$Delimiter(ISequenceMatcher matcher) {
		ruleCall$9$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$7$Delimiter() {
		return keyword$7$Delimiter;
	}
	
	public void setKeyword$7$Delimiter(ICharacterClass characterClass) {
		keyword$7$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$6$Delimiter() {
		return keyword$6$Delimiter;
	}
	
	public void setKeyword$6$Delimiter(ICharacterClass characterClass) {
		keyword$6$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}

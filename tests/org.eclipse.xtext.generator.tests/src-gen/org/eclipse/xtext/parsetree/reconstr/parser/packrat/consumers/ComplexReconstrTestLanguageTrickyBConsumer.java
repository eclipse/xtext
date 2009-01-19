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

import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.TrickyBElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;

@SuppressWarnings("unused")
public final class ComplexReconstrTestLanguageTrickyBConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private XtextBuiltinINTConsumer intConsumer;

	private ISequenceMatcher ruleCall$6$Delimiter;
	
	private ISequenceMatcher ruleCall$10$Delimiter;
	
	private ISequenceMatcher ruleCall$8$Delimiter;
	
	private ICharacterClass keyword$3$Delimiter;
	
	public ComplexReconstrTestLanguageTrickyBConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		ruleCall$6$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$10$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$8$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$3$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$3()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$4()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$9()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$3() throws Exception {
		return consumeKeyword(getRule().ele00KeywordTB(), null, false, false, getKeyword$3$Delimiter());
	}

	protected boolean consumeGroup$4() throws Exception {
		doConsumeGroup$4();
		return true;
	}

	protected boolean doConsumeGroup$4() throws Exception {
		final IMarker marker = mark();
		if (!consumeAssignment$5()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$7()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeAssignment$5() throws Exception {
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele0100LexerRuleCallID(), getRuleCall$6$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$7() throws Exception {
		if (consumeTerminal(intConsumer, "type", true, false, getRule().ele0110LexerRuleCallINT(), getRuleCall$8$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$9() throws Exception {
		while(doConsumeAssignment$9()) {}
		return true;
	}

	protected boolean doConsumeAssignment$9() throws Exception {
		if (consumeTerminal(intConsumer, "type", true, false, getRule().ele10LexerRuleCallINT(), getRuleCall$10$Delimiter()))
			return true;
		return false;
	}

	public TrickyBElements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyB();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TrickyB";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setIntConsumer(XtextBuiltinINTConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	
	public ISequenceMatcher getRuleCall$6$Delimiter() {
		return ruleCall$6$Delimiter;
	}
	
	public void setRuleCall$6$Delimiter(ISequenceMatcher matcher) {
		ruleCall$6$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$10$Delimiter() {
		return ruleCall$10$Delimiter;
	}
	
	public void setRuleCall$10$Delimiter(ISequenceMatcher matcher) {
		ruleCall$10$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$8$Delimiter() {
		return ruleCall$8$Delimiter;
	}
	
	public void setRuleCall$8$Delimiter(ISequenceMatcher matcher) {
		ruleCall$8$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$3$Delimiter() {
		return keyword$3$Delimiter;
	}
	
	public void setKeyword$3$Delimiter(ICharacterClass characterClass) {
		keyword$3$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}

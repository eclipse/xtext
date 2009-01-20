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
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.TrickyDElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;

@SuppressWarnings("unused")
public final class ComplexReconstrTestLanguageTrickyDConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private XtextBuiltinINTConsumer intConsumer;
	private XtextBuiltinSTRINGConsumer stringConsumer;

	private ICharacterClass keyword$4$Delimiter;
	
	private ISequenceMatcher ruleCall$8$Delimiter;
	
	private ISequenceMatcher ruleCall$10$Delimiter;
	
	private ISequenceMatcher ruleCall$12$Delimiter;
	
	private ISequenceMatcher ruleCall$15$Delimiter;
	
	private ISequenceMatcher ruleCall$17$Delimiter;
	
	private ISequenceMatcher ruleCall$19$Delimiter;
	
	public ComplexReconstrTestLanguageTrickyDConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$4$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$8$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$10$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$12$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$15$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$17$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$19$Delimiter = ISequenceMatcher.Factory.nullMatcher();
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
		if (!consumeGroup$5()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$13()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$18()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$4() throws Exception {
		return consumeKeyword(getRule().ele000KeywordTD(), null, false, false, getKeyword$4$Delimiter());
	}

	protected boolean consumeGroup$5() throws Exception {
		doConsumeGroup$5();
		return true;
	}

	protected boolean doConsumeGroup$5() throws Exception {
		final IMarker marker = mark();
		if (!consumeAssignment$7()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$9()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$11()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeAssignment$7() throws Exception {
		if (consumeTerminal(intConsumer, "name", true, false, getRule().ele001000LexerRuleCallINT(), getRuleCall$8$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$9() throws Exception {
		if (consumeTerminal(stringConsumer, "foo", false, false, getRule().ele001010LexerRuleCallSTRING(), getRuleCall$10$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$11() throws Exception {
		if (consumeTerminal(idConsumer, "type", true, false, getRule().ele00110LexerRuleCallID(), getRuleCall$12$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeGroup$13() throws Exception {
		doConsumeGroup$13();
		return true;
	}

	protected boolean doConsumeGroup$13() throws Exception {
		final IMarker marker = mark();
		if (!consumeAssignment$14()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$16()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeAssignment$14() throws Exception {
		if (consumeTerminal(intConsumer, "name", true, false, getRule().ele0100LexerRuleCallINT(), getRuleCall$15$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$16() throws Exception {
		if (consumeTerminal(idConsumer, "type", true, false, getRule().ele0110LexerRuleCallID(), getRuleCall$17$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$18() throws Exception {
		while(doConsumeAssignment$18()) {}
		return true;
	}

	protected boolean doConsumeAssignment$18() throws Exception {
		if (consumeTerminal(idConsumer, "type", true, false, getRule().ele10LexerRuleCallID(), getRuleCall$19$Delimiter()))
			return true;
		return false;
	}

	public TrickyDElements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyD();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TrickyD";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setIntConsumer(XtextBuiltinINTConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public ICharacterClass getKeyword$4$Delimiter() {
		return keyword$4$Delimiter;
	}
	
	public void setKeyword$4$Delimiter(ICharacterClass characterClass) {
		keyword$4$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
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
	
	public ISequenceMatcher getRuleCall$12$Delimiter() {
		return ruleCall$12$Delimiter;
	}
	
	public void setRuleCall$12$Delimiter(ISequenceMatcher matcher) {
		ruleCall$12$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$15$Delimiter() {
		return ruleCall$15$Delimiter;
	}
	
	public void setRuleCall$15$Delimiter(ISequenceMatcher matcher) {
		ruleCall$15$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$17$Delimiter() {
		return ruleCall$17$Delimiter;
	}
	
	public void setRuleCall$17$Delimiter(ISequenceMatcher matcher) {
		ruleCall$17$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$19$Delimiter() {
		return ruleCall$19$Delimiter;
	}
	
	public void setRuleCall$19$Delimiter(ISequenceMatcher matcher) {
		ruleCall$19$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

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
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.TrickyAElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageTrickyA1Consumer;

@SuppressWarnings("unused")
public final class ComplexReconstrTestLanguageTrickyAConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private XtextBuiltinSTRINGConsumer stringConsumer;
	private ComplexReconstrTestLanguageTrickyA1Consumer trickyA1Consumer;

	private ICharacterClass keyword$5$Delimiter;
	
	private ICharacterClass keyword$13$Delimiter;
	
	private ICharacterClass keyword$17$Delimiter;
	
	private ISequenceMatcher ruleCall$8$Delimiter;
	
	private ISequenceMatcher ruleCall$19$Delimiter;
	
	public ComplexReconstrTestLanguageTrickyAConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$5$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$13$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$17$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$8$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$19$Delimiter = ISequenceMatcher.Factory.nullMatcher();
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
		if (!consumeRuleCall$6()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$7()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAlternatives$9()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$18()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}

	protected boolean consumeKeyword$5() throws Exception {
		return consumeKeyword(getRule().ele0000KeywordTA(), null, false, false, getKeyword$5$Delimiter());
	}

	protected boolean consumeRuleCall$6() throws Exception {
		return consumeNonTerminal(trickyA1Consumer, null, false, false, getRule().ele0001ParserRuleCallTrickyA1());
	}

	protected boolean consumeAssignment$7() throws Exception {
		while(doConsumeAssignment$7()) {}
		return true;
	}

	protected boolean doConsumeAssignment$7() throws Exception {
		if (consumeTerminal(idConsumer, "name", true, false, getRule().ele0010LexerRuleCallID(), getRuleCall$8$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAlternatives$9() throws Exception {
		doConsumeAlternatives$9();
		return true;
	}

	protected boolean doConsumeAlternatives$9() throws Exception {
		if (consumeGroup$10())
			return true;
		if (consumeGroup$14())
			return true;
		return false;
	}

	protected boolean consumeGroup$10() throws Exception {
		final IMarker marker = mark();
		if (!consumeAction$11()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeKeyword$13()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}
	protected boolean consumeAction$11() {
		consumeAction("TypeB", "x", false);
		return true;	
	}

	protected boolean consumeKeyword$13() throws Exception {
		return consumeKeyword(getRule().ele0101KeywordX(), null, false, false, getKeyword$13$Delimiter());
	}

	protected boolean consumeGroup$14() throws Exception {
		final IMarker marker = mark();
		if (!consumeAction$15()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeKeyword$17()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}
	protected boolean consumeAction$15() {
		consumeAction("TypeC", "x", false);
		return true;	
	}

	protected boolean consumeKeyword$17() throws Exception {
		return consumeKeyword(getRule().ele0111KeywordY(), null, false, false, getKeyword$17$Delimiter());
	}

	protected boolean consumeAssignment$18() throws Exception {
		if (consumeTerminal(stringConsumer, "name", true, false, getRule().ele10LexerRuleCallSTRING(), getRuleCall$19$Delimiter()))
			return true;
		return false;
	}

	public TrickyAElements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyA();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TypeA1";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public void setTrickyA1Consumer(ComplexReconstrTestLanguageTrickyA1Consumer trickyA1Consumer) {
		this.trickyA1Consumer = trickyA1Consumer;
	}
	
	public ICharacterClass getKeyword$5$Delimiter() {
		return keyword$5$Delimiter;
	}
	
	public void setKeyword$5$Delimiter(ICharacterClass characterClass) {
		keyword$5$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$13$Delimiter() {
		return keyword$13$Delimiter;
	}
	
	public void setKeyword$13$Delimiter(ICharacterClass characterClass) {
		keyword$13$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$17$Delimiter() {
		return keyword$17$Delimiter;
	}
	
	public void setKeyword$17$Delimiter(ICharacterClass characterClass) {
		keyword$17$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$8$Delimiter() {
		return ruleCall$8$Delimiter;
	}
	
	public void setRuleCall$8$Delimiter(ISequenceMatcher matcher) {
		ruleCall$8$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$19$Delimiter() {
		return ruleCall$19$Delimiter;
	}
	
	public void setRuleCall$19$Delimiter(ISequenceMatcher matcher) {
		ruleCall$19$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

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
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.TrickyCElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class ComplexReconstrTestLanguageTrickyCConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;

	private ISequenceMatcher ruleCall$7$Delimiter;
	
	private ICharacterClass keyword$5$Delimiter;
	
	private ICharacterClass keyword$11$Delimiter;
	
	private ICharacterClass keyword$15$Delimiter;
	
	private ICharacterClass keyword$19$Delimiter;
	
	public ComplexReconstrTestLanguageTrickyCConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		ruleCall$7$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$5$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$15$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$19$Delimiter = ICharacterClass.Factory.nullClass();
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
		if (!consumeGroup$12()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$16()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$5() throws Exception {
		return consumeKeyword(getRule().ele0000KeywordTC(), null, false, false, getKeyword$5$Delimiter());
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
		if (!consumeAction$9()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$11()) {
			marker.rollback();
			return false;
		}
		return true;
	}
	protected boolean consumeAction$9() {
		consumeAction("C1", "x", false);
		return true;	
	}

	protected boolean consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele0011KeywordX(), null, false, false, getKeyword$11$Delimiter());
	}

	protected boolean consumeGroup$12() throws Exception {
		doConsumeGroup$12();
		return true;
	}

	protected boolean doConsumeGroup$12() throws Exception {
		final IMarker marker = mark();
		if (!consumeAction$13()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$15()) {
			marker.rollback();
			return false;
		}
		return true;
	}
	protected boolean consumeAction$13() {
		consumeAction("C2", "y", false);
		return true;	
	}

	protected boolean consumeKeyword$15() throws Exception {
		return consumeKeyword(getRule().ele011KeywordY(), null, false, false, getKeyword$15$Delimiter());
	}

	protected boolean consumeGroup$16() throws Exception {
		doConsumeGroup$16();
		return true;
	}

	protected boolean doConsumeGroup$16() throws Exception {
		final IMarker marker = mark();
		if (!consumeAction$17()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$19()) {
			marker.rollback();
			return false;
		}
		return true;
	}
	protected boolean consumeAction$17() {
		consumeAction("C3", "z", false);
		return true;	
	}

	protected boolean consumeKeyword$19() throws Exception {
		return consumeKeyword(getRule().ele11KeywordZ(), null, false, false, getKeyword$19$Delimiter());
	}

	public TrickyCElements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyC();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TrickyC";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public ISequenceMatcher getRuleCall$7$Delimiter() {
		return ruleCall$7$Delimiter;
	}
	
	public void setRuleCall$7$Delimiter(ISequenceMatcher matcher) {
		ruleCall$7$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$5$Delimiter() {
		return keyword$5$Delimiter;
	}
	
	public void setKeyword$5$Delimiter(ICharacterClass characterClass) {
		keyword$5$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$11$Delimiter() {
		return keyword$11$Delimiter;
	}
	
	public void setKeyword$11$Delimiter(ICharacterClass characterClass) {
		keyword$11$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$15$Delimiter() {
		return keyword$15$Delimiter;
	}
	
	public void setKeyword$15$Delimiter(ICharacterClass characterClass) {
		keyword$15$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$19$Delimiter() {
		return keyword$19$Delimiter;
	}
	
	public void setKeyword$19$Delimiter(ICharacterClass characterClass) {
		keyword$19$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}

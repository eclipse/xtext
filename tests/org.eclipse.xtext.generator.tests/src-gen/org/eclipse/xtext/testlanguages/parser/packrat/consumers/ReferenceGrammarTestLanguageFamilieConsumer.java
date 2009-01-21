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
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess.FamilieElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;

@SuppressWarnings("unused")
public final class ReferenceGrammarTestLanguageFamilieConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private XtextBuiltinSTRINGConsumer stringConsumer;

	private ISequenceMatcher crossReference$20$Delimiter;
	
	private ISequenceMatcher crossReference$23$Delimiter;
	
	private ISequenceMatcher crossReference$28$Delimiter;
	
	private ISequenceMatcher crossReference$17$Delimiter;
	
	private ICharacterClass keyword$26$Delimiter;
	
	private ICharacterClass keyword$30$Delimiter;
	
	private ICharacterClass keyword$8$Delimiter;
	
	private ICharacterClass keyword$9$Delimiter;
	
	private ICharacterClass keyword$13$Delimiter;
	
	private ISequenceMatcher ruleCall$14$Delimiter;
	
	private ISequenceMatcher ruleCall$15$Delimiter;
	
	public ReferenceGrammarTestLanguageFamilieConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		crossReference$20$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		crossReference$23$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		crossReference$28$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		crossReference$17$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$26$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$30$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$8$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$9$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$13$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$14$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$15$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$8()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeKeyword$9()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$10()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$16()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$19()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$22()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeGroup$25()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeKeyword$30()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}

	protected boolean consumeKeyword$8() throws Exception {
		return consumeKeyword(getRule().ele0000000KeywordFamilie(), null, false, false, getKeyword$8$Delimiter());
	}

	protected boolean consumeKeyword$9() throws Exception {
		return consumeKeyword(getRule().ele0000001KeywordLeftParenthesis(), null, false, false, getKeyword$9$Delimiter());
	}

	protected boolean consumeAssignment$10() throws Exception {
		if (consumeKeyword(getRule().ele000001000KeywordKeyword(), "name", false, false, getKeyword$13$Delimiter()))
			return true;
		if (consumeTerminal(stringConsumer, "name", false, false, getRule().ele000001001LexerRuleCallSTRING(), getRuleCall$14$Delimiter()))
			return true;
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele00000101LexerRuleCallID(), getRuleCall$15$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$16() throws Exception {
		if (consumeTerminal(idConsumer, null, false, false, getRule().ele000010CrossReferenceEStringErwachsener(), getCrossReference$17$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$19() throws Exception {
		if (consumeTerminal(idConsumer, null, false, false, getRule().ele00010CrossReferenceEStringErwachsener(), getCrossReference$20$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$22() throws Exception {
		if (consumeTerminal(idConsumer, null, true, false, getRule().ele0010CrossReferenceEStringKind(), getCrossReference$23$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeGroup$25() throws Exception {
		while(doConsumeGroup$25()) {}
		return true;
	}

	protected boolean doConsumeGroup$25() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$26()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$27()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}

	protected boolean consumeKeyword$26() throws Exception {
		return consumeKeyword(getRule().ele010KeywordComma(), null, false, false, getKeyword$26$Delimiter());
	}

	protected boolean consumeAssignment$27() throws Exception {
		if (consumeTerminal(idConsumer, null, true, false, getRule().ele0110CrossReferenceEStringKind(), getCrossReference$28$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$30() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightParenthesis(), null, false, false, getKeyword$30$Delimiter());
	}

	public FamilieElements getRule() {
		return ReferenceGrammarTestLanguageGrammarAccess.INSTANCE.prFamilie();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Familie";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public ISequenceMatcher getCrossReference$20$Delimiter() {
		return crossReference$20$Delimiter;
	}
	
	public void setCrossReference$20$Delimiter(ISequenceMatcher matcher) {
		crossReference$20$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getCrossReference$23$Delimiter() {
		return crossReference$23$Delimiter;
	}
	
	public void setCrossReference$23$Delimiter(ISequenceMatcher matcher) {
		crossReference$23$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getCrossReference$28$Delimiter() {
		return crossReference$28$Delimiter;
	}
	
	public void setCrossReference$28$Delimiter(ISequenceMatcher matcher) {
		crossReference$28$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getCrossReference$17$Delimiter() {
		return crossReference$17$Delimiter;
	}
	
	public void setCrossReference$17$Delimiter(ISequenceMatcher matcher) {
		crossReference$17$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$26$Delimiter() {
		return keyword$26$Delimiter;
	}
	
	public void setKeyword$26$Delimiter(ICharacterClass characterClass) {
		keyword$26$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$30$Delimiter() {
		return keyword$30$Delimiter;
	}
	
	public void setKeyword$30$Delimiter(ICharacterClass characterClass) {
		keyword$30$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
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
	
	public ICharacterClass getKeyword$13$Delimiter() {
		return keyword$13$Delimiter;
	}
	
	public void setKeyword$13$Delimiter(ICharacterClass characterClass) {
		keyword$13$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$14$Delimiter() {
		return ruleCall$14$Delimiter;
	}
	
	public void setRuleCall$14$Delimiter(ISequenceMatcher matcher) {
		ruleCall$14$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$15$Delimiter() {
		return ruleCall$15$Delimiter;
	}
	
	public void setRuleCall$15$Delimiter(ISequenceMatcher matcher) {
		ruleCall$15$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

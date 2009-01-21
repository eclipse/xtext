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

import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.ParserRuleElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageAlternativesConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageTypeRefConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarTestLanguageParserRuleConsumer extends NonTerminalConsumer {

	private XtextGrammarTestLanguageAlternativesConsumer alternativesConsumer;
	private XtextBuiltinIDConsumer idConsumer;
	private XtextGrammarTestLanguageTypeRefConsumer typeRefConsumer;

	private ISequenceMatcher crossReference$20$Delimiter;
	
	private ISequenceMatcher crossReference$25$Delimiter;
	
	private ICharacterClass keyword$9$Delimiter;
	
	private ICharacterClass keyword$17$Delimiter;
	
	private ICharacterClass keyword$18$Delimiter;
	
	private ICharacterClass keyword$23$Delimiter;
	
	private ICharacterClass keyword$27$Delimiter;
	
	private ICharacterClass keyword$28$Delimiter;
	
	private ICharacterClass keyword$31$Delimiter;
	
	private ISequenceMatcher ruleCall$7$Delimiter;
	
	public XtextGrammarTestLanguageParserRuleConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		crossReference$20$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		crossReference$25$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$9$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$17$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$18$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$23$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$27$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$28$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$31$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$7$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeAssignment$6()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeGroup$8()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeGroup$12()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeKeyword$28()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$29()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeKeyword$31()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}

	protected boolean consumeAssignment$6() throws Exception {
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele000000LexerRuleCallID(), getRuleCall$7$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeGroup$8() throws Exception {
		doConsumeGroup$8();
		return true;
	}

	protected boolean doConsumeGroup$8() throws Exception {
		final IMarker marker = mark();
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
		marker.release();
		return true;
	}

	protected boolean consumeKeyword$9() throws Exception {
		return consumeKeyword(getRule().ele000010KeywordReturns(), null, false, false, getKeyword$9$Delimiter());
	}

	protected boolean consumeAssignment$10() throws Exception {
		if (consumeNonTerminal(typeRefConsumer, "type", false, false, getRule().ele0000110ParserRuleCallTypeRef()))
			return true;
		return false;
	}

	protected boolean consumeGroup$12() throws Exception {
		doConsumeGroup$12();
		return true;
	}

	protected boolean doConsumeGroup$12() throws Exception {
		final IMarker marker = mark();
		if (!consumeAssignment$16()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeKeyword$18()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$19()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeKeyword$23()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$24()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeKeyword$27()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}

	protected boolean consumeAssignment$16() throws Exception {
		if (consumeKeyword(getRule().ele000100000KeywordHidden(), "definesHiddenTokens", false, true, getKeyword$17$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$18() throws Exception {
		return consumeKeyword(getRule().ele00010001KeywordLeftParenthesis(), null, false, false, getKeyword$18$Delimiter());
	}

	protected boolean consumeAssignment$19() throws Exception {
		if (consumeTerminal(idConsumer, null, true, false, getRule().ele00010010CrossReferenceEStringAbstractRule(), getCrossReference$20$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$23() throws Exception {
		return consumeKeyword(getRule().ele0001010KeywordComma(), null, false, false, getKeyword$23$Delimiter());
	}

	protected boolean consumeAssignment$24() throws Exception {
		if (consumeTerminal(idConsumer, null, true, false, getRule().ele00010110CrossReferenceEStringAbstractRule(), getCrossReference$25$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$27() throws Exception {
		return consumeKeyword(getRule().ele00011KeywordRightParenthesis(), null, false, false, getKeyword$27$Delimiter());
	}

	protected boolean consumeKeyword$28() throws Exception {
		return consumeKeyword(getRule().ele001KeywordColon(), null, false, false, getKeyword$28$Delimiter());
	}

	protected boolean consumeAssignment$29() throws Exception {
		if (consumeNonTerminal(alternativesConsumer, "alternatives", false, false, getRule().ele010ParserRuleCallAlternatives()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$31() throws Exception {
		return consumeKeyword(getRule().ele1KeywordSemicolon(), null, false, false, getKeyword$31$Delimiter());
	}

	public ParserRuleElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prParserRule();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "ParserRule";
	}
	
	public void setAlternativesConsumer(XtextGrammarTestLanguageAlternativesConsumer alternativesConsumer) {
		this.alternativesConsumer = alternativesConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setTypeRefConsumer(XtextGrammarTestLanguageTypeRefConsumer typeRefConsumer) {
		this.typeRefConsumer = typeRefConsumer;
	}
	
	public ISequenceMatcher getCrossReference$20$Delimiter() {
		return crossReference$20$Delimiter;
	}
	
	public void setCrossReference$20$Delimiter(ISequenceMatcher matcher) {
		crossReference$20$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getCrossReference$25$Delimiter() {
		return crossReference$25$Delimiter;
	}
	
	public void setCrossReference$25$Delimiter(ISequenceMatcher matcher) {
		crossReference$25$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$9$Delimiter() {
		return keyword$9$Delimiter;
	}
	
	public void setKeyword$9$Delimiter(ICharacterClass characterClass) {
		keyword$9$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$17$Delimiter() {
		return keyword$17$Delimiter;
	}
	
	public void setKeyword$17$Delimiter(ICharacterClass characterClass) {
		keyword$17$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$18$Delimiter() {
		return keyword$18$Delimiter;
	}
	
	public void setKeyword$18$Delimiter(ICharacterClass characterClass) {
		keyword$18$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$23$Delimiter() {
		return keyword$23$Delimiter;
	}
	
	public void setKeyword$23$Delimiter(ICharacterClass characterClass) {
		keyword$23$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$27$Delimiter() {
		return keyword$27$Delimiter;
	}
	
	public void setKeyword$27$Delimiter(ICharacterClass characterClass) {
		keyword$27$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$28$Delimiter() {
		return keyword$28$Delimiter;
	}
	
	public void setKeyword$28$Delimiter(ICharacterClass characterClass) {
		keyword$28$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$31$Delimiter() {
		return keyword$31$Delimiter;
	}
	
	public void setKeyword$31$Delimiter(ICharacterClass characterClass) {
		keyword$31$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$7$Delimiter() {
		return ruleCall$7$Delimiter;
	}
	
	public void setRuleCall$7$Delimiter(ISequenceMatcher matcher) {
		ruleCall$7$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

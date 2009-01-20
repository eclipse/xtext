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
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.ActionElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageTypeRefConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarTestLanguageActionConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private XtextGrammarTestLanguageTypeRefConsumer typeRefConsumer;

	private ICharacterClass keyword$8$Delimiter;
	
	private ICharacterClass keyword$10$Delimiter;
	
	private ICharacterClass keyword$11$Delimiter;
	
	private ICharacterClass keyword$14$Delimiter;
	
	private ICharacterClass keyword$19$Delimiter;
	
	private ICharacterClass keyword$20$Delimiter;
	
	private ICharacterClass keyword$21$Delimiter;
	
	private ICharacterClass keyword$22$Delimiter;
	
	private ISequenceMatcher ruleCall$16$Delimiter;
	
	public XtextGrammarTestLanguageActionConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$8$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$10$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$14$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$19$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$20$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$21$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$22$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$16$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$8()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$9()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$12()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$14()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$15()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$17()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$21()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$22()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$8() throws Exception {
		return consumeKeyword(getRule().ele0000000KeywordLeftCurlyBracket(), null, false, false, getKeyword$8$Delimiter());
	}

	protected boolean consumeGroup$9() throws Exception {
		doConsumeGroup$9();
		return true;
	}

	protected boolean doConsumeGroup$9() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$10()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$11()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$10() throws Exception {
		return consumeKeyword(getRule().ele00000010KeywordCurrent(), null, false, false, getKeyword$10$Delimiter());
	}

	protected boolean consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele00000011KeywordEqualsSign(), null, false, false, getKeyword$11$Delimiter());
	}

	protected boolean consumeAssignment$12() throws Exception {
		if (consumeNonTerminal(typeRefConsumer, "typeName", false, false, getRule().ele0000010ParserRuleCallTypeRef()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$14() throws Exception {
		return consumeKeyword(getRule().ele00001KeywordFullStop(), null, false, false, getKeyword$14$Delimiter());
	}

	protected boolean consumeAssignment$15() throws Exception {
		if (consumeTerminal(idConsumer, "feature", false, false, getRule().ele00010LexerRuleCallID(), getRuleCall$16$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$17() throws Exception {
		if (consumeKeyword(getRule().ele00100KeywordEqualsSign(), "operator", false, false, getKeyword$19$Delimiter()))
			return true;
		if (consumeKeyword(getRule().ele00101KeywordPlusSignEqualsSign(), "operator", false, false, getKeyword$20$Delimiter()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$21() throws Exception {
		return consumeKeyword(getRule().ele01KeywordCurrent(), null, false, false, getKeyword$21$Delimiter());
	}

	protected boolean consumeKeyword$22() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightCurlyBracket(), null, false, false, getKeyword$22$Delimiter());
	}

	public ActionElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prAction();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Action";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setTypeRefConsumer(XtextGrammarTestLanguageTypeRefConsumer typeRefConsumer) {
		this.typeRefConsumer = typeRefConsumer;
	}
	
	public ICharacterClass getKeyword$8$Delimiter() {
		return keyword$8$Delimiter;
	}
	
	public void setKeyword$8$Delimiter(ICharacterClass characterClass) {
		keyword$8$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$10$Delimiter() {
		return keyword$10$Delimiter;
	}
	
	public void setKeyword$10$Delimiter(ICharacterClass characterClass) {
		keyword$10$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$11$Delimiter() {
		return keyword$11$Delimiter;
	}
	
	public void setKeyword$11$Delimiter(ICharacterClass characterClass) {
		keyword$11$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$14$Delimiter() {
		return keyword$14$Delimiter;
	}
	
	public void setKeyword$14$Delimiter(ICharacterClass characterClass) {
		keyword$14$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$19$Delimiter() {
		return keyword$19$Delimiter;
	}
	
	public void setKeyword$19$Delimiter(ICharacterClass characterClass) {
		keyword$19$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$20$Delimiter() {
		return keyword$20$Delimiter;
	}
	
	public void setKeyword$20$Delimiter(ICharacterClass characterClass) {
		keyword$20$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$21$Delimiter() {
		return keyword$21$Delimiter;
	}
	
	public void setKeyword$21$Delimiter(ICharacterClass characterClass) {
		keyword$21$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$22$Delimiter() {
		return keyword$22$Delimiter;
	}
	
	public void setKeyword$22$Delimiter(ICharacterClass characterClass) {
		keyword$22$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$16$Delimiter() {
		return ruleCall$16$Delimiter;
	}
	
	public void setRuleCall$16$Delimiter(ISequenceMatcher matcher) {
		ruleCall$16$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

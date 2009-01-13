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
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess.SpielplatzElements;

import org.eclipse.xtext.testlanguages.parser.packrat.ReferenceGrammarTestLanguageDelimiters;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ReferenceGrammarTestLanguageFamilieConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ReferenceGrammarTestLanguageKindConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ReferenceGrammarTestLanguageSpielzeugConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ReferenceGrammarTestLanguageErwachsenerConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;

@SuppressWarnings("unused")
public final class ReferenceGrammarTestLanguageSpielplatzConsumer extends NonTerminalConsumer {

	private ReferenceGrammarTestLanguageFamilieConsumer familieConsumer;
	private ReferenceGrammarTestLanguageKindConsumer kindConsumer;
	private ReferenceGrammarTestLanguageSpielzeugConsumer spielzeugConsumer;
	private ReferenceGrammarTestLanguageErwachsenerConsumer erwachsenerConsumer;
	private XtextBuiltinSTRINGConsumer stringConsumer;
	private XtextBuiltinINTConsumer intConsumer;

	public ReferenceGrammarTestLanguageSpielplatzConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		doConsumeGroup$1();
		return true;
	}

	protected boolean doConsumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$6()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$7()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$9()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$11()) {
			marker.rollback();
			return false;
		}
		if (!consumeAlternatives$12()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$23()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$6() throws Exception {
		return consumeKeyword(getRule().ele00000KeywordSpielplatz(), null, false, false, ReferenceGrammarTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$7() throws Exception {
		if (consumeTerminal(intConsumer, "groesse", false, false, getRule().ele000010LexerRuleCallINT(), ReferenceGrammarTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeAssignment$9() throws Exception {
		doConsumeAssignment$9();
		return true;
	}

	protected boolean doConsumeAssignment$9() throws Exception {
		if (consumeTerminal(stringConsumer, "beschreibung", false, false, getRule().ele00010LexerRuleCallSTRING(), ReferenceGrammarTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele001KeywordLeftCurlyBracket(), null, false, false, ReferenceGrammarTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAlternatives$12() throws Exception {
		while(doConsumeAlternatives$12()) {}
		return true;
	}

	protected boolean doConsumeAlternatives$12() throws Exception {
		if (consumeAssignment$15())
			return true;
		if (consumeAssignment$17())
			return true;
		if (consumeAssignment$19())
			return true;
		if (consumeAssignment$21())
			return true;
		return false;
	}

	protected boolean consumeAssignment$15() throws Exception {
		if (consumeNonTerminal(kindConsumer, "kinder", true, false, getRule().ele010000ParserRuleCallKind()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$17() throws Exception {
		if (consumeNonTerminal(erwachsenerConsumer, "erzieher", true, false, getRule().ele010010ParserRuleCallErwachsener()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$19() throws Exception {
		if (consumeNonTerminal(spielzeugConsumer, "spielzeuge", true, false, getRule().ele01010ParserRuleCallSpielzeug()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$21() throws Exception {
		if (consumeNonTerminal(familieConsumer, "familie", true, false, getRule().ele0110ParserRuleCallFamilie()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$23() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightCurlyBracket(), null, false, false, ReferenceGrammarTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	public SpielplatzElements getRule() {
		return ReferenceGrammarTestLanguageGrammarAccess.INSTANCE.prSpielplatz();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Spielplatz";
	}
	
	public void setFamilieConsumer(ReferenceGrammarTestLanguageFamilieConsumer familieConsumer) {
		this.familieConsumer = familieConsumer;
	}
	
	public void setKindConsumer(ReferenceGrammarTestLanguageKindConsumer kindConsumer) {
		this.kindConsumer = kindConsumer;
	}
	
	public void setSpielzeugConsumer(ReferenceGrammarTestLanguageSpielzeugConsumer spielzeugConsumer) {
		this.spielzeugConsumer = spielzeugConsumer;
	}
	
	public void setErwachsenerConsumer(ReferenceGrammarTestLanguageErwachsenerConsumer erwachsenerConsumer) {
		this.erwachsenerConsumer = erwachsenerConsumer;
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public void setIntConsumer(XtextBuiltinINTConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	
}

/*
Generated with Xtext
*/
package org.eclipse.xtext.reference.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.reference.services.ReferenceGrammarGrammarAccess;
import org.eclipse.xtext.reference.services.ReferenceGrammarGrammarAccess.SpielplatzElements;

import org.eclipse.xtext.reference.parser.packrat.ReferenceGrammarDelimiters;

import org.eclipse.xtext.reference.parser.packrat.consumers.ReferenceGrammarErwachsenerConsumer;
import org.eclipse.xtext.reference.parser.packrat.consumers.ReferenceGrammarSpielzeugConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.reference.parser.packrat.consumers.ReferenceGrammarFamilieConsumer;
import org.eclipse.xtext.reference.parser.packrat.consumers.ReferenceGrammarKindConsumer;
import org.eclipse.xtext.reference.parser.packrat.consumers.ReferenceGrammarCustomTypeParserRuleConsumer;

@SuppressWarnings("unused")
public final class ReferenceGrammarSpielplatzConsumer extends NonTerminalConsumer {

	private ReferenceGrammarErwachsenerConsumer erwachsenerConsumer;
	private ReferenceGrammarSpielzeugConsumer spielzeugConsumer;
	private XtextBuiltinINTConsumer intConsumer;
	private XtextBuiltinSTRINGConsumer stringConsumer;
	private ReferenceGrammarFamilieConsumer familieConsumer;
	private ReferenceGrammarKindConsumer kindConsumer;
	private ReferenceGrammarCustomTypeParserRuleConsumer customTypeParserRuleConsumer;

	public ReferenceGrammarSpielplatzConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		if (!consumeKeyword$26()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$6() throws Exception {
		return consumeKeyword(getRule().ele00000KeywordSpielplatz(), null, false, false, ReferenceGrammarDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$7() throws Exception {
		if (consumeTerminal(intConsumer, "groesse", false, false, getRule().ele000010LexerRuleCallINT(), ReferenceGrammarDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeAssignment$9() throws Exception {
		doConsumeAssignment$9();
		return true;
	}

	protected boolean doConsumeAssignment$9() throws Exception {
		if (consumeTerminal(stringConsumer, "beschreibung", false, false, getRule().ele00010LexerRuleCallSTRING(), ReferenceGrammarDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele001KeywordLeftCurlyBracket(), null, false, false, ReferenceGrammarDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAlternatives$12() throws Exception {
		while(doConsumeAlternatives$12()) {}
		return true;
	}

	protected boolean doConsumeAlternatives$12() throws Exception {
		if (consumeAssignment$16())
			return true;
		if (consumeAssignment$18())
			return true;
		if (consumeAssignment$20())
			return true;
		if (consumeAssignment$22())
			return true;
		if (consumeAssignment$24())
			return true;
		return false;
	}

	protected boolean consumeAssignment$16() throws Exception {
		if (consumeNonTerminal(kindConsumer, "kinder", true, false, getRule().ele0100000ParserRuleCallKind()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$18() throws Exception {
		if (consumeNonTerminal(erwachsenerConsumer, "erzieher", true, false, getRule().ele0100010ParserRuleCallErwachsener()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$20() throws Exception {
		if (consumeNonTerminal(spielzeugConsumer, "spielzeuge", true, false, getRule().ele010010ParserRuleCallSpielzeug()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$22() throws Exception {
		if (consumeNonTerminal(familieConsumer, "familie", true, false, getRule().ele01010ParserRuleCallFamilie()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$24() throws Exception {
		if (consumeNonTerminal(customTypeParserRuleConsumer, "types", true, false, getRule().ele0110ParserRuleCallCustomTypeParserRule()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$26() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightCurlyBracket(), null, false, false, ReferenceGrammarDelimiters.ANY_OTHER_DELIMITER);
	}

	public SpielplatzElements getRule() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prSpielplatz();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Spielplatz";
	}
	
	public void setErwachsenerConsumer(ReferenceGrammarErwachsenerConsumer erwachsenerConsumer) {
		this.erwachsenerConsumer = erwachsenerConsumer;
	}
	
	public void setSpielzeugConsumer(ReferenceGrammarSpielzeugConsumer spielzeugConsumer) {
		this.spielzeugConsumer = spielzeugConsumer;
	}
	
	public void setIntConsumer(XtextBuiltinINTConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public void setFamilieConsumer(ReferenceGrammarFamilieConsumer familieConsumer) {
		this.familieConsumer = familieConsumer;
	}
	
	public void setKindConsumer(ReferenceGrammarKindConsumer kindConsumer) {
		this.kindConsumer = kindConsumer;
	}
	
	public void setCustomTypeParserRuleConsumer(ReferenceGrammarCustomTypeParserRuleConsumer customTypeParserRuleConsumer) {
		this.customTypeParserRuleConsumer = customTypeParserRuleConsumer;
	}
	
}

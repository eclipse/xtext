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
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.ParserRuleElements;

import org.eclipse.xtext.parser.packrat.XtextGrammarTestLanguageDelimiters;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageAlternativesConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageTypeRefConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarTestLanguageParserRuleConsumer extends NonTerminalConsumer {

	private XtextGrammarTestLanguageAlternativesConsumer alternativesConsumer;
	private XtextGrammarTestLanguageTypeRefConsumer typeRefConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	public XtextGrammarTestLanguageParserRuleConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeAssignment$5()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$7()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$11()) {
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
		return true;
	}

	protected boolean consumeAssignment$5() throws Exception {
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele00000LexerRuleCallID(), XtextGrammarTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeGroup$7() throws Exception {
		doConsumeGroup$7();
		return true;
	}

	protected boolean doConsumeGroup$7() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$8()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$9()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$8() throws Exception {
		return consumeKeyword(getRule().ele00010KeywordReturns(), null, false, false, XtextGrammarTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$9() throws Exception {
		if (consumeNonTerminal(typeRefConsumer, "type", false, false, getRule().ele000110ParserRuleCallTypeRef()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele001KeywordColon(), null, false, false, XtextGrammarTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$12() throws Exception {
		if (consumeNonTerminal(alternativesConsumer, "alternatives", false, false, getRule().ele010ParserRuleCallAlternatives()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$14() throws Exception {
		return consumeKeyword(getRule().ele1KeywordSemicolon(), null, false, false, XtextGrammarTestLanguageDelimiters.ANY_OTHER_DELIMITER);
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
	
	public void setTypeRefConsumer(XtextGrammarTestLanguageTypeRefConsumer typeRefConsumer) {
		this.typeRefConsumer = typeRefConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
}

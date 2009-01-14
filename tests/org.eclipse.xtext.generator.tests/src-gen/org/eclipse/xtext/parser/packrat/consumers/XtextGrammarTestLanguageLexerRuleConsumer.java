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
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.LexerRuleElements;

import org.eclipse.xtext.parser.packrat.XtextGrammarTestLanguageDelimiters;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageTypeRefConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarTestLanguageLexerRuleConsumer extends NonTerminalConsumer {

	private XtextBuiltinSTRINGConsumer stringConsumer;
	private XtextGrammarTestLanguageTypeRefConsumer typeRefConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	public XtextGrammarTestLanguageLexerRuleConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeAlternatives$6()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$9()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$11()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$15()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$16()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$18()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeAlternatives$6() throws Exception {
		if (consumeKeyword$7())
			return true;
		if (consumeKeyword$8())
			return true;
		return false;
	}

	protected boolean consumeKeyword$7() throws Exception {
		return consumeKeyword(getRule().ele000000KeywordNative(), null, false, false, XtextGrammarTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeKeyword$8() throws Exception {
		return consumeKeyword(getRule().ele000001KeywordLexer(), null, false, false, XtextGrammarTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$9() throws Exception {
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele000010LexerRuleCallID(), XtextGrammarTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeGroup$11() throws Exception {
		doConsumeGroup$11();
		return true;
	}

	protected boolean doConsumeGroup$11() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$12()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$13()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$12() throws Exception {
		return consumeKeyword(getRule().ele00010KeywordReturns(), null, false, false, XtextGrammarTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$13() throws Exception {
		if (consumeNonTerminal(typeRefConsumer, "type", false, false, getRule().ele000110ParserRuleCallTypeRef()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$15() throws Exception {
		return consumeKeyword(getRule().ele001KeywordColon(), null, false, false, XtextGrammarTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$16() throws Exception {
		if (consumeTerminal(stringConsumer, "body", false, false, getRule().ele010LexerRuleCallSTRING(), XtextGrammarTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeKeyword$18() throws Exception {
		return consumeKeyword(getRule().ele1KeywordSemicolon(), null, false, false, XtextGrammarTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	public LexerRuleElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prLexerRule();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "LexerRule";
	}
	
	public void setStringConsumer(XtextBuiltinSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public void setTypeRefConsumer(XtextGrammarTestLanguageTypeRefConsumer typeRefConsumer) {
		this.typeRefConsumer = typeRefConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
}

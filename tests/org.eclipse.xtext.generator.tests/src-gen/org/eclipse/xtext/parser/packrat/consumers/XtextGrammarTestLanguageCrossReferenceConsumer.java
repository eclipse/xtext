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
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.CrossReferenceElements;

import org.eclipse.xtext.parser.packrat.XtextGrammarTestLanguageDelimiters;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageTypeRefConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarTestLanguageCrossReferenceConsumer extends NonTerminalConsumer {

	private XtextGrammarTestLanguageTypeRefConsumer typeRefConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	public XtextGrammarTestLanguageCrossReferenceConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
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
		if (!consumeAssignment$5()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$7()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$12()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$4() throws Exception {
		return consumeKeyword(getRule().ele000KeywordLeftSquareBracket(), null, false, false, XtextGrammarTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$5() throws Exception {
		if (consumeNonTerminal(typeRefConsumer, "type", false, false, getRule().ele0010ParserRuleCallTypeRef()))
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
		return consumeKeyword(getRule().ele010KeywordVerticalLine(), null, false, false, XtextGrammarTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$9() throws Exception {
		if (consumeTerminal(idConsumer, null, false, false, getRule().ele0110CrossReferenceEStringAbstractRule(), XtextGrammarTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeKeyword$12() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightSquareBracket(), null, false, false, XtextGrammarTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	public CrossReferenceElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prCrossReference();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "CrossReference";
	}
	
	public void setTypeRefConsumer(XtextGrammarTestLanguageTypeRefConsumer typeRefConsumer) {
		this.typeRefConsumer = typeRefConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
}

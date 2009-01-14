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
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.ActionElements;

import org.eclipse.xtext.parser.packrat.XtextGrammarTestLanguageDelimiters;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageTypeRefConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarTestLanguageActionConsumer extends NonTerminalConsumer {

	private XtextGrammarTestLanguageTypeRefConsumer typeRefConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	public XtextGrammarTestLanguageActionConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
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
		return consumeKeyword(getRule().ele0000000KeywordLeftCurlyBracket(), null, false, false, XtextGrammarTestLanguageDelimiters.ANY_OTHER_DELIMITER);
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
		return consumeKeyword(getRule().ele00000010KeywordCurrent(), null, false, false, XtextGrammarTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele00000011KeywordEqualsSign(), null, false, false, XtextGrammarTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$12() throws Exception {
		if (consumeNonTerminal(typeRefConsumer, "typeName", false, false, getRule().ele0000010ParserRuleCallTypeRef()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$14() throws Exception {
		return consumeKeyword(getRule().ele00001KeywordFullStop(), null, false, false, XtextGrammarTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$15() throws Exception {
		if (consumeTerminal(idConsumer, "feature", false, false, getRule().ele00010LexerRuleCallID(), XtextGrammarTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeAssignment$17() throws Exception {
		if (consumeKeyword(getRule().ele00100KeywordEqualsSign(), "operator", false, false, XtextGrammarTestLanguageDelimiters.ANY_OTHER_DELIMITER))
			return true;
		if (consumeKeyword(getRule().ele00101KeywordPlusSignEqualsSign(), "operator", false, false, XtextGrammarTestLanguageDelimiters.ANY_OTHER_DELIMITER))
			return true;
		return false;
	}

	protected boolean consumeKeyword$21() throws Exception {
		return consumeKeyword(getRule().ele01KeywordCurrent(), null, false, false, XtextGrammarTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeKeyword$22() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightCurlyBracket(), null, false, false, XtextGrammarTestLanguageDelimiters.ANY_OTHER_DELIMITER);
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
	
	public void setTypeRefConsumer(XtextGrammarTestLanguageTypeRefConsumer typeRefConsumer) {
		this.typeRefConsumer = typeRefConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
}

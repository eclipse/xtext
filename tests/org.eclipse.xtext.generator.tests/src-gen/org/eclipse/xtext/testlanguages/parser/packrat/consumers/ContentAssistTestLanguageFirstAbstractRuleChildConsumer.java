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

import org.eclipse.xtext.testlanguages.services.ContentAssistTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.ContentAssistTestLanguageGrammarAccess.FirstAbstractRuleChildElements;

import org.eclipse.xtext.testlanguages.parser.packrat.ContentAssistTestLanguageDelimiters;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ContentAssistTestLanguageAbstractRuleConsumer;

@SuppressWarnings("unused")
public final class ContentAssistTestLanguageFirstAbstractRuleChildConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private ContentAssistTestLanguageAbstractRuleConsumer abstractRuleConsumer;

	public ContentAssistTestLanguageFirstAbstractRuleChildConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		if (!consumeKeyword$7()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$8()) {
			marker.rollback();
			return false;
		}
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

	protected boolean consumeAssignment$5() throws Exception {
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele00000LexerRuleCallID(), ContentAssistTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeKeyword$7() throws Exception {
		return consumeKeyword(getRule().ele0001KeywordLeftParenthesis(), null, false, false, ContentAssistTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$8() throws Exception {
		if (doConsumeAssignment$8()) {
			while(doConsumeAssignment$8()) {}
			return true;
		}
		return false;
	}

	protected boolean doConsumeAssignment$8() throws Exception {
		if (consumeNonTerminal(abstractRuleConsumer, "elements", true, false, getRule().ele0010ParserRuleCallAbstractRule()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$10() throws Exception {
		return consumeKeyword(getRule().ele01KeywordRightParenthesis(), null, false, false, ContentAssistTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele1KeywordSemicolon(), null, false, false, ContentAssistTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	public FirstAbstractRuleChildElements getRule() {
		return ContentAssistTestLanguageGrammarAccess.INSTANCE.prFirstAbstractRuleChild();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "FirstAbstractRuleChild";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setAbstractRuleConsumer(ContentAssistTestLanguageAbstractRuleConsumer abstractRuleConsumer) {
		this.abstractRuleConsumer = abstractRuleConsumer;
	}
	
}

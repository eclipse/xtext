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
import org.eclipse.xtext.testlanguages.services.ContentAssistTestLanguageGrammarAccess.SecondAbstractRuleChildElements;

import org.eclipse.xtext.testlanguages.parser.packrat.ContentAssistTestLanguageDelimiters;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ContentAssistTestLanguageAbstractRuleCallConsumer;

@SuppressWarnings("unused")
public final class ContentAssistTestLanguageSecondAbstractRuleChildConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private ContentAssistTestLanguageAbstractRuleCallConsumer abstractRuleCallConsumer;

	public ContentAssistTestLanguageSecondAbstractRuleChildConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		if (!consumeKeyword$8()) {
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
		return true;
	}

	protected boolean consumeAssignment$5() throws Exception {
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele00000LexerRuleCallID(), ContentAssistTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeKeyword$7() throws Exception {
		return consumeKeyword(getRule().ele0001KeywordRule(), null, false, false, ContentAssistTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeKeyword$8() throws Exception {
		return consumeKeyword(getRule().ele001KeywordColon(), null, false, false, ContentAssistTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$9() throws Exception {
		if (consumeNonTerminal(abstractRuleCallConsumer, "rule", false, false, getRule().ele010ParserRuleCallAbstractRuleCall()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele1KeywordSemicolon(), null, false, false, ContentAssistTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	public SecondAbstractRuleChildElements getRule() {
		return ContentAssistTestLanguageGrammarAccess.INSTANCE.prSecondAbstractRuleChild();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "SecondAbstractRuleChild";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setAbstractRuleCallConsumer(ContentAssistTestLanguageAbstractRuleCallConsumer abstractRuleCallConsumer) {
		this.abstractRuleCallConsumer = abstractRuleCallConsumer;
	}
	
}

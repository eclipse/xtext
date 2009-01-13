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

import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess.ContainerElements;

import org.eclipse.xtext.testlanguages.parser.packrat.PartialParserTestLanguageDelimiters;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageContentConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageNestedConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class PartialParserTestLanguageContainerConsumer extends NonTerminalConsumer {

	private PartialParserTestLanguageContentConsumer contentConsumer;
	private PartialParserTestLanguageNestedConsumer nestedConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	public PartialParserTestLanguageContainerConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$5()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$6()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$8()) {
			marker.rollback();
			return false;
		}
		if (!consumeAlternatives$9()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$14()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$5() throws Exception {
		return consumeKeyword(getRule().ele0000KeywordContainer(), null, false, false, PartialParserTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$6() throws Exception {
		if (consumeTerminal(idConsumer, "name", false, false, getRule().ele00010LexerRuleCallID(), PartialParserTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeKeyword$8() throws Exception {
		return consumeKeyword(getRule().ele001KeywordLeftCurlyBracket(), null, false, false, PartialParserTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAlternatives$9() throws Exception {
		while(doConsumeAlternatives$9()) {}
		return true;
	}

	protected boolean doConsumeAlternatives$9() throws Exception {
		if (consumeAssignment$10())
			return true;
		if (consumeAssignment$12())
			return true;
		return false;
	}

	protected boolean consumeAssignment$10() throws Exception {
		if (consumeNonTerminal(nestedConsumer, "nested", true, false, getRule().ele0100ParserRuleCallNested()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$12() throws Exception {
		if (consumeNonTerminal(contentConsumer, "content", true, false, getRule().ele0110ParserRuleCallContent()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$14() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightCurlyBracket(), null, false, false, PartialParserTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	public ContainerElements getRule() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prContainer();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Container";
	}
	
	public void setContentConsumer(PartialParserTestLanguageContentConsumer contentConsumer) {
		this.contentConsumer = contentConsumer;
	}
	
	public void setNestedConsumer(PartialParserTestLanguageNestedConsumer nestedConsumer) {
		this.nestedConsumer = nestedConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
}

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
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess.NestedElements;

import org.eclipse.xtext.testlanguages.parser.packrat.PartialParserTestLanguageDelimiters;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageContainerConsumer;

@SuppressWarnings("unused")
public final class PartialParserTestLanguageNestedConsumer extends NonTerminalConsumer {

	private PartialParserTestLanguageContainerConsumer containerConsumer;

	public PartialParserTestLanguageNestedConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		return true;
	}

	protected boolean consumeKeyword$4() throws Exception {
		return consumeKeyword(getRule().ele000KeywordNested(), null, false, false, PartialParserTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeKeyword$5() throws Exception {
		return consumeKeyword(getRule().ele001KeywordLeftCurlyBracket(), null, false, false, PartialParserTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$6() throws Exception {
		if (doConsumeAssignment$6()) {
			while(doConsumeAssignment$6()) {}
			return true;
		}
		return false;
	}

	protected boolean doConsumeAssignment$6() throws Exception {
		if (consumeNonTerminal(containerConsumer, "nested", true, false, getRule().ele010ParserRuleCallContainer()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$8() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightCurlyBracket(), null, false, false, PartialParserTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	public NestedElements getRule() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prNested();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Nested";
	}
	
	public void setContainerConsumer(PartialParserTestLanguageContainerConsumer containerConsumer) {
		this.containerConsumer = containerConsumer;
	}
	
}

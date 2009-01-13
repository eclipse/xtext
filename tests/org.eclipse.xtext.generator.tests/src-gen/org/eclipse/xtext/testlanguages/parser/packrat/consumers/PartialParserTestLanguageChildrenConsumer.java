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
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess.ChildrenElements;

import org.eclipse.xtext.testlanguages.parser.packrat.PartialParserTestLanguageDelimiters;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageChildConsumer;

@SuppressWarnings("unused")
public final class PartialParserTestLanguageChildrenConsumer extends NonTerminalConsumer {

	private PartialParserTestLanguageChildConsumer childConsumer;

	public PartialParserTestLanguageChildrenConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		if (!consumeKeyword$6()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$7()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$9()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$13()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$5() throws Exception {
		return consumeKeyword(getRule().ele0000KeywordChildren(), null, false, false, PartialParserTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeKeyword$6() throws Exception {
		return consumeKeyword(getRule().ele0001KeywordLeftCurlyBracket(), null, false, false, PartialParserTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$7() throws Exception {
		if (consumeNonTerminal(childConsumer, "children", true, false, getRule().ele0010ParserRuleCallChild()))
			return true;
		return false;
	}

	protected boolean consumeGroup$9() throws Exception {
		while(doConsumeGroup$9()) {}
		return true;
	}

	protected boolean doConsumeGroup$9() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$10()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$11()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$10() throws Exception {
		return consumeKeyword(getRule().ele010KeywordComma(), null, false, false, PartialParserTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$11() throws Exception {
		if (consumeNonTerminal(childConsumer, "children", true, false, getRule().ele0110ParserRuleCallChild()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$13() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightCurlyBracket(), null, false, false, PartialParserTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	public ChildrenElements getRule() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prChildren();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Children";
	}
	
	public void setChildConsumer(PartialParserTestLanguageChildConsumer childConsumer) {
		this.childConsumer = childConsumer;
	}
	
}

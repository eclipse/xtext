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
import org.eclipse.xtext.testlanguages.services.PartialParserTestLanguageGrammarAccess.SecondConcreteElements;

import org.eclipse.xtext.testlanguages.parser.packrat.PartialParserTestLanguageDelimiters;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.PartialParserTestLanguageNamedConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class PartialParserTestLanguageSecondConcreteConsumer extends NonTerminalConsumer {

	private PartialParserTestLanguageNamedConsumer namedConsumer;
	private XtextBuiltinIDConsumer idConsumer;

	public PartialParserTestLanguageSecondConcreteConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$7()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$8()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$9()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$10()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$11()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$13()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$16()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$7() throws Exception {
		return consumeKeyword(getRule().ele000000KeywordHyphenMinusGreaterThanSign(), null, false, false, PartialParserTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeKeyword$8() throws Exception {
		return consumeKeyword(getRule().ele000001KeywordF(), null, false, false, PartialParserTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeKeyword$9() throws Exception {
		return consumeKeyword(getRule().ele00001KeywordS(), null, false, false, PartialParserTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeKeyword$10() throws Exception {
		return consumeKeyword(getRule().ele0001KeywordLeftParenthesis(), null, false, false, PartialParserTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeAssignment$11() throws Exception {
		if (consumeNonTerminal(namedConsumer, "value", false, false, getRule().ele0010ParserRuleCallNamed()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$13() throws Exception {
		doConsumeAssignment$13();
		return true;
	}

	protected boolean doConsumeAssignment$13() throws Exception {
		if (consumeTerminal(idConsumer, null, true, false, getRule().ele010CrossReferenceEStringChild(), PartialParserTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
	}

	protected boolean consumeKeyword$16() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightParenthesis(), null, false, false, PartialParserTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	public SecondConcreteElements getRule() {
		return PartialParserTestLanguageGrammarAccess.INSTANCE.prSecondConcrete();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "SecondConcrete";
	}
	
	public void setNamedConsumer(PartialParserTestLanguageNamedConsumer namedConsumer) {
		this.namedConsumer = namedConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
}

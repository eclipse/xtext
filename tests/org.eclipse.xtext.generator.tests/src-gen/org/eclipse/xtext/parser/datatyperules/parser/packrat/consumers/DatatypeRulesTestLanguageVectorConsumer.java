/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess.VectorElements;

import org.eclipse.xtext.parser.datatyperules.parser.packrat.DatatypeRulesTestLanguageDelimiters;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;

@SuppressWarnings("unused")
public final class DatatypeRulesTestLanguageVectorConsumer extends NonTerminalConsumer {

	private XtextBuiltinINTConsumer intConsumer;

	public DatatypeRulesTestLanguageVectorConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		if (!consumeRuleCall$5()) {
			marker.rollback();
			return false;
		}
		if (!consumeRuleCall$6()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$7()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$4() throws Exception {
		return consumeKeyword(getRule().ele000KeywordLeftParenthesis(), null, false, false, DatatypeRulesTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeRuleCall$5() throws Exception {
		return consumeTerminal(intConsumer, null, false, false, getRule().ele001LexerRuleCallINT(), DatatypeRulesTestLanguageDelimiters.ALL_KEYWORDS);
	}

	protected boolean consumeRuleCall$6() throws Exception {
		return consumeTerminal(intConsumer, null, false, false, getRule().ele01LexerRuleCallINT(), DatatypeRulesTestLanguageDelimiters.ALL_KEYWORDS);
	}

	protected boolean consumeKeyword$7() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightParenthesis(), null, false, false, DatatypeRulesTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	public VectorElements getRule() {
		return DatatypeRulesTestLanguageGrammarAccess.INSTANCE.prVector();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "EString";
	}
	
	public void setIntConsumer(XtextBuiltinINTConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	
}

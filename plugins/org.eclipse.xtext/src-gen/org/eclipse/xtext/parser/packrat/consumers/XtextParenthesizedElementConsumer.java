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

import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarAccess.ParenthesizedElementElements;

import org.eclipse.xtext.parser.packrat.XtextDelimiters;

import org.eclipse.xtext.parser.packrat.consumers.XtextAlternativesConsumer;

@SuppressWarnings("unused")
public final class XtextParenthesizedElementConsumer extends NonTerminalConsumer {

	private XtextAlternativesConsumer alternativesConsumer;

	public XtextParenthesizedElementConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$3()) {
			marker.rollback();
			return false;
		}
		if (!consumeRuleCall$4()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$5()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$3() throws Exception {
		return consumeKeyword(getRule().ele00KeywordLeftParenthesis(), null, false, false, XtextDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeRuleCall$4() throws Exception {
		return consumeNonTerminal(alternativesConsumer, null, false, false, getRule().ele01ParserRuleCallAlternatives());
	}

	protected boolean consumeKeyword$5() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightParenthesis(), null, false, false, XtextDelimiters.ANY_OTHER_DELIMITER);
	}

	public ParenthesizedElementElements getRule() {
		return XtextGrammarAccess.INSTANCE.prParenthesizedElement();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setAlternativesConsumer(XtextAlternativesConsumer alternativesConsumer) {
		this.alternativesConsumer = alternativesConsumer;
	}
	
}

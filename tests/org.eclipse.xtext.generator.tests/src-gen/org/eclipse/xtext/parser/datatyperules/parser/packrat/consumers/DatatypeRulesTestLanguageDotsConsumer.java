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
import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess.DotsElements;

import org.eclipse.xtext.parser.datatyperules.parser.packrat.DatatypeRulesTestLanguageDelimiters;


@SuppressWarnings("unused")
public final class DatatypeRulesTestLanguageDotsConsumer extends NonTerminalConsumer {


	public DatatypeRulesTestLanguageDotsConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeAlternatives$1();
	}

	protected boolean consumeAlternatives$1() throws Exception {
		if (consumeGroup$2())
			return true;
		if (consumeKeyword$5())
			return true;
		return false;
	}

	protected boolean consumeGroup$2() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$3()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$4()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$3() throws Exception {
		return consumeKeyword(getRule().ele00KeywordFullStop(), null, false, false, DatatypeRulesTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeKeyword$4() throws Exception {
		return consumeKeyword(getRule().ele01KeywordFullStop(), null, false, false, DatatypeRulesTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	protected boolean consumeKeyword$5() throws Exception {
		return consumeKeyword(getRule().ele1KeywordFullStopFullStop(), null, false, false, DatatypeRulesTestLanguageDelimiters.ANY_OTHER_DELIMITER);
	}

	public DotsElements getRule() {
		return DatatypeRulesTestLanguageGrammarAccess.INSTANCE.prDots();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "EString";
	}
	
}

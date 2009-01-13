/*
Generated with Xtext
*/
package org.eclipse.xtext.reference.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.reference.services.ReferenceGrammarGrammarAccess;
import org.eclipse.xtext.reference.services.ReferenceGrammarGrammarAccess.FarbeElements;

import org.eclipse.xtext.reference.parser.packrat.ReferenceGrammarDelimiters;


@SuppressWarnings("unused")
public final class ReferenceGrammarFarbeConsumer extends NonTerminalConsumer {


	public ReferenceGrammarFarbeConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeAssignment$1();
	}

	protected boolean consumeAssignment$1() throws Exception {
		if (consumeKeyword(getRule().ele0000KeywordROT(), "wert", false, false, ReferenceGrammarDelimiters.ID_DELIMITER))
			return true;
		if (consumeKeyword(getRule().ele0001KeywordBLAU(), "wert", false, false, ReferenceGrammarDelimiters.ID_DELIMITER))
			return true;
		if (consumeKeyword(getRule().ele001KeywordGELB(), "wert", false, false, ReferenceGrammarDelimiters.ID_DELIMITER))
			return true;
		if (consumeKeyword(getRule().ele01KeywordGRÜN(), "wert", false, false, ReferenceGrammarDelimiters.ID_DELIMITER))
			return true;
		return false;
	}

	public FarbeElements getRule() {
		return ReferenceGrammarGrammarAccess.INSTANCE.prFarbe();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Farbe";
	}
	
}

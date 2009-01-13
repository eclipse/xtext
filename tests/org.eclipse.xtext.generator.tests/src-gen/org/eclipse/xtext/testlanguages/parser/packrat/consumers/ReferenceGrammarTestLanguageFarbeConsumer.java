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

import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess.FarbeElements;

import org.eclipse.xtext.testlanguages.parser.packrat.ReferenceGrammarTestLanguageDelimiters;


@SuppressWarnings("unused")
public final class ReferenceGrammarTestLanguageFarbeConsumer extends NonTerminalConsumer {


	public ReferenceGrammarTestLanguageFarbeConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeAlternatives$1();
	}

	protected boolean consumeAlternatives$1() throws Exception {
		if (consumeKeyword$4())
			return true;
		if (consumeKeyword$5())
			return true;
		if (consumeKeyword$6())
			return true;
		if (consumeKeyword$7())
			return true;
		return false;
	}

	protected boolean consumeKeyword$4() throws Exception {
		return consumeKeyword(getRule().ele000KeywordROT(), null, false, false, ReferenceGrammarTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeKeyword$5() throws Exception {
		return consumeKeyword(getRule().ele001KeywordBLAU(), null, false, false, ReferenceGrammarTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeKeyword$6() throws Exception {
		return consumeKeyword(getRule().ele01KeywordGELB(), null, false, false, ReferenceGrammarTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeKeyword$7() throws Exception {
		return consumeKeyword(getRule().ele1KeywordGRÜN(), null, false, false, ReferenceGrammarTestLanguageDelimiters.ID_DELIMITER);
	}

	public FarbeElements getRule() {
		return ReferenceGrammarTestLanguageGrammarAccess.INSTANCE.prFarbe();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Farbe";
	}
	
}

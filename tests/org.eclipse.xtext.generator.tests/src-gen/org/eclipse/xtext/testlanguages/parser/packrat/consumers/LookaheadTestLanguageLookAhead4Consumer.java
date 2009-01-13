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

import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess.LookAhead4Elements;

import org.eclipse.xtext.testlanguages.parser.packrat.LookaheadTestLanguageDelimiters;


@SuppressWarnings("unused")
public final class LookaheadTestLanguageLookAhead4Consumer extends NonTerminalConsumer {


	public LookaheadTestLanguageLookAhead4Consumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeAlternatives$1();
	}

	protected boolean consumeAlternatives$1() throws Exception {
		if (consumeAssignment$2())
			return true;
		if (consumeAssignment$4())
			return true;
		return false;
	}

	protected boolean consumeAssignment$2() throws Exception {
		if (consumeKeyword(getRule().ele00KeywordC(), "x", false, false, LookaheadTestLanguageDelimiters.ID_DELIMITER))
			return true;
		return false;
	}

	protected boolean consumeAssignment$4() throws Exception {
		if (consumeKeyword(getRule().ele10KeywordD(), "x", false, false, LookaheadTestLanguageDelimiters.ID_DELIMITER))
			return true;
		return false;
	}

	public LookAhead4Elements getRule() {
		return LookaheadTestLanguageGrammarAccess.INSTANCE.prLookAhead4();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "LookAhead4";
	}
	
}

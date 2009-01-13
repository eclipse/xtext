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
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess.LookAhead2Elements;

import org.eclipse.xtext.testlanguages.parser.packrat.LookaheadTestLanguageDelimiters;


@SuppressWarnings("unused")
public final class LookaheadTestLanguageLookAhead2Consumer extends NonTerminalConsumer {


	public LookaheadTestLanguageLookAhead2Consumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeAlternatives$2()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$7()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeAlternatives$2() throws Exception {
		if (consumeAssignment$3())
			return true;
		if (consumeAssignment$5())
			return true;
		return false;
	}

	protected boolean consumeAssignment$3() throws Exception {
		if (consumeKeyword(getRule().ele000KeywordFoo(), "z", false, false, LookaheadTestLanguageDelimiters.ID_DELIMITER))
			return true;
		return false;
	}

	protected boolean consumeAssignment$5() throws Exception {
		if (consumeKeyword(getRule().ele010KeywordBar(), "z", false, false, LookaheadTestLanguageDelimiters.ID_DELIMITER))
			return true;
		return false;
	}

	protected boolean consumeKeyword$7() throws Exception {
		return consumeKeyword(getRule().ele1KeywordC(), null, false, false, LookaheadTestLanguageDelimiters.ID_DELIMITER);
	}

	public LookAhead2Elements getRule() {
		return LookaheadTestLanguageGrammarAccess.INSTANCE.prLookAhead2();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "LookAhead2";
	}
	
}

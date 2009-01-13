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
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess.LookAhead1Elements;

import org.eclipse.xtext.testlanguages.parser.packrat.LookaheadTestLanguageDelimiters;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LookaheadTestLanguageLookAhead2Consumer;

@SuppressWarnings("unused")
public final class LookaheadTestLanguageLookAhead1Consumer extends NonTerminalConsumer {

	private LookaheadTestLanguageLookAhead2Consumer lookAhead2Consumer;

	public LookaheadTestLanguageLookAhead1Consumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		if (!consumeAssignment$5()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$7()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$9()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$4() throws Exception {
		return consumeKeyword(getRule().ele000KeywordFoo(), null, false, false, LookaheadTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$5() throws Exception {
		if (consumeNonTerminal(lookAhead2Consumer, "y", false, false, getRule().ele0010ParserRuleCallLookAhead2()))
			return true;
		return false;
	}

	protected boolean consumeAssignment$7() throws Exception {
		if (consumeKeyword(getRule().ele010KeywordB(), "x", false, false, LookaheadTestLanguageDelimiters.ID_DELIMITER))
			return true;
		return false;
	}

	protected boolean consumeAssignment$9() throws Exception {
		if (consumeKeyword(getRule().ele10KeywordD(), "x", false, false, LookaheadTestLanguageDelimiters.ID_DELIMITER))
			return true;
		return false;
	}

	public LookAhead1Elements getRule() {
		return LookaheadTestLanguageGrammarAccess.INSTANCE.prLookAhead1();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "LookAhead1";
	}
	
	public void setLookAhead2Consumer(LookaheadTestLanguageLookAhead2Consumer lookAhead2Consumer) {
		this.lookAhead2Consumer = lookAhead2Consumer;
	}
	
}

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
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess.LookAhead3Elements;

import org.eclipse.xtext.testlanguages.parser.packrat.LookaheadTestLanguageDelimiters;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LookaheadTestLanguageLookAhead4Consumer;

@SuppressWarnings("unused")
public final class LookaheadTestLanguageLookAhead3Consumer extends NonTerminalConsumer {

	private LookaheadTestLanguageLookAhead4Consumer lookAhead4Consumer;

	public LookaheadTestLanguageLookAhead3Consumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		if (!consumeKeyword$5()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$6()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$8()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$4() throws Exception {
		return consumeKeyword(getRule().ele000KeywordFoo(), null, false, false, LookaheadTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeKeyword$5() throws Exception {
		return consumeKeyword(getRule().ele001KeywordBar(), null, false, false, LookaheadTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$6() throws Exception {
		if (consumeKeyword(getRule().ele010KeywordB(), "x", false, false, LookaheadTestLanguageDelimiters.ID_DELIMITER))
			return true;
		return false;
	}

	protected boolean consumeAssignment$8() throws Exception {
		if (consumeNonTerminal(lookAhead4Consumer, "z", false, false, getRule().ele10ParserRuleCallLookAhead4()))
			return true;
		return false;
	}

	public LookAhead3Elements getRule() {
		return LookaheadTestLanguageGrammarAccess.INSTANCE.prLookAhead3();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "LookAhead3";
	}
	
	public void setLookAhead4Consumer(LookaheadTestLanguageLookAhead4Consumer lookAhead4Consumer) {
		this.lookAhead4Consumer = lookAhead4Consumer;
	}
	
}

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
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess.AltsElements;

import org.eclipse.xtext.testlanguages.parser.packrat.LookaheadTestLanguageDelimiters;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LookaheadTestLanguageLookAhead3Consumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LookaheadTestLanguageLookAhead0Consumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LookaheadTestLanguageLookAhead1Consumer;

@SuppressWarnings("unused")
public final class LookaheadTestLanguageAltsConsumer extends NonTerminalConsumer {

	private LookaheadTestLanguageLookAhead3Consumer lookAhead3Consumer;
	private LookaheadTestLanguageLookAhead0Consumer lookAhead0Consumer;
	private LookaheadTestLanguageLookAhead1Consumer lookAhead1Consumer;

	public LookaheadTestLanguageAltsConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeAlternatives$1();
	}

	protected boolean consumeAlternatives$1() throws Exception {
		if (consumeRuleCall$3())
			return true;
		if (consumeRuleCall$4())
			return true;
		if (consumeRuleCall$5())
			return true;
		return false;
	}

	protected boolean consumeRuleCall$3() throws Exception {
		return consumeNonTerminal(lookAhead0Consumer, null, false, false, getRule().ele00ParserRuleCallLookAhead0());
	}

	protected boolean consumeRuleCall$4() throws Exception {
		return consumeNonTerminal(lookAhead1Consumer, null, false, false, getRule().ele01ParserRuleCallLookAhead1());
	}

	protected boolean consumeRuleCall$5() throws Exception {
		return consumeNonTerminal(lookAhead3Consumer, null, false, false, getRule().ele1ParserRuleCallLookAhead3());
	}

	public AltsElements getRule() {
		return LookaheadTestLanguageGrammarAccess.INSTANCE.prAlts();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Alts";
	}
	
	public void setLookAhead3Consumer(LookaheadTestLanguageLookAhead3Consumer lookAhead3Consumer) {
		this.lookAhead3Consumer = lookAhead3Consumer;
	}
	
	public void setLookAhead0Consumer(LookaheadTestLanguageLookAhead0Consumer lookAhead0Consumer) {
		this.lookAhead0Consumer = lookAhead0Consumer;
	}
	
	public void setLookAhead1Consumer(LookaheadTestLanguageLookAhead1Consumer lookAhead1Consumer) {
		this.lookAhead1Consumer = lookAhead1Consumer;
	}
	
}

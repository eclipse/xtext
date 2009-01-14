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
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess.EntryElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.LookaheadTestLanguageAltsConsumer;

@SuppressWarnings("unused")
public final class LookaheadTestLanguageEntryConsumer extends NonTerminalConsumer {

	private LookaheadTestLanguageAltsConsumer altsConsumer;

	public LookaheadTestLanguageEntryConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeAssignment$1();
	}

	protected boolean consumeAssignment$1() throws Exception {
		while(doConsumeAssignment$1()) {}
		return true;
	}

	protected boolean doConsumeAssignment$1() throws Exception {
		if (consumeNonTerminal(altsConsumer, "contents", true, false, getRule().ele0ParserRuleCallAlts()))
			return true;
		return false;
	}

	public EntryElements getRule() {
		return LookaheadTestLanguageGrammarAccess.INSTANCE.prEntry();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Entry";
	}
	
	public void setAltsConsumer(LookaheadTestLanguageAltsConsumer altsConsumer) {
		this.altsConsumer = altsConsumer;
	}
	
}

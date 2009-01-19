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
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.AbstractNegatedTokenElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageNegatedTokenConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageUpToTokenConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarTestLanguageAbstractNegatedTokenConsumer extends NonTerminalConsumer {

	private XtextGrammarTestLanguageNegatedTokenConsumer negatedTokenConsumer;
	private XtextGrammarTestLanguageUpToTokenConsumer upToTokenConsumer;

	public XtextGrammarTestLanguageAbstractNegatedTokenConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeAlternatives$1();
	}

	protected boolean consumeAlternatives$1() throws Exception {
		if (consumeRuleCall$2())
			return true;
		if (consumeRuleCall$3())
			return true;
		return false;
	}

	protected boolean consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(negatedTokenConsumer, null, false, false, getRule().ele0ParserRuleCallNegatedToken());
	}

	protected boolean consumeRuleCall$3() throws Exception {
		return consumeNonTerminal(upToTokenConsumer, null, false, false, getRule().ele1ParserRuleCallUpToToken());
	}

	public AbstractNegatedTokenElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prAbstractNegatedToken();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractNegatedToken";
	}
	
	public void setNegatedTokenConsumer(XtextGrammarTestLanguageNegatedTokenConsumer negatedTokenConsumer) {
		this.negatedTokenConsumer = negatedTokenConsumer;
	}
	
	public void setUpToTokenConsumer(XtextGrammarTestLanguageUpToTokenConsumer upToTokenConsumer) {
		this.upToTokenConsumer = upToTokenConsumer;
	}
	
}

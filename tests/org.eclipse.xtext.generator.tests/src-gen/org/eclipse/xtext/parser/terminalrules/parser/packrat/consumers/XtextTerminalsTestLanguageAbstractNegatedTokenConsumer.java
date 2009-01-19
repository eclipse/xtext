/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers;

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

import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess.AbstractNegatedTokenElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageNegatedTokenConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageUpToTokenConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageAbstractNegatedTokenConsumer extends NonTerminalConsumer {

	private XtextTerminalsTestLanguageNegatedTokenConsumer negatedTokenConsumer;
	private XtextTerminalsTestLanguageUpToTokenConsumer upToTokenConsumer;

	public XtextTerminalsTestLanguageAbstractNegatedTokenConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractNegatedToken();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractNegatedToken";
	}
	
	public void setNegatedTokenConsumer(XtextTerminalsTestLanguageNegatedTokenConsumer negatedTokenConsumer) {
		this.negatedTokenConsumer = negatedTokenConsumer;
	}
	
	public void setUpToTokenConsumer(XtextTerminalsTestLanguageUpToTokenConsumer upToTokenConsumer) {
		this.upToTokenConsumer = upToTokenConsumer;
	}
	
}

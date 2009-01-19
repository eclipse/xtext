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
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.AbstractRuleElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageLexerRuleConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageParserRuleConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageTerminalRuleConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarTestLanguageAbstractRuleConsumer extends NonTerminalConsumer {

	private XtextGrammarTestLanguageLexerRuleConsumer lexerRuleConsumer;
	private XtextGrammarTestLanguageParserRuleConsumer parserRuleConsumer;
	private XtextGrammarTestLanguageTerminalRuleConsumer terminalRuleConsumer;

	public XtextGrammarTestLanguageAbstractRuleConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
		return consumeNonTerminal(lexerRuleConsumer, null, false, false, getRule().ele00ParserRuleCallLexerRule());
	}

	protected boolean consumeRuleCall$4() throws Exception {
		return consumeNonTerminal(parserRuleConsumer, null, false, false, getRule().ele01ParserRuleCallParserRule());
	}

	protected boolean consumeRuleCall$5() throws Exception {
		return consumeNonTerminal(terminalRuleConsumer, null, false, false, getRule().ele1ParserRuleCallTerminalRule());
	}

	public AbstractRuleElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prAbstractRule();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractRule";
	}
	
	public void setLexerRuleConsumer(XtextGrammarTestLanguageLexerRuleConsumer lexerRuleConsumer) {
		this.lexerRuleConsumer = lexerRuleConsumer;
	}
	
	public void setParserRuleConsumer(XtextGrammarTestLanguageParserRuleConsumer parserRuleConsumer) {
		this.parserRuleConsumer = parserRuleConsumer;
	}
	
	public void setTerminalRuleConsumer(XtextGrammarTestLanguageTerminalRuleConsumer terminalRuleConsumer) {
		this.terminalRuleConsumer = terminalRuleConsumer;
	}
	
}

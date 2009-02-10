/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

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

	public XtextGrammarTestLanguageAbstractRuleConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
	@Override
	protected int doConsume(int entryPoint) throws Exception {
		return consumeAlternatives$1(entryPoint);
	}

	protected int consumeAlternatives$1(int entryPoint) throws Exception {
		AlternativesResult result = createAlternativesResult();
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result.reset();
			case 0:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$3(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$4(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 2:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$5(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}

	protected int consumeRuleCall$3(int entryPoint) throws Exception {
		return consumeNonTerminal(lexerRuleConsumer, null, false, false, false, getRule().ele00ParserRuleCallLexerRule());
	}

	protected int consumeRuleCall$4(int entryPoint) throws Exception {
		return consumeNonTerminal(parserRuleConsumer, null, false, false, false, getRule().ele01ParserRuleCallParserRule());
	}

	protected int consumeRuleCall$5(int entryPoint) throws Exception {
		return consumeNonTerminal(terminalRuleConsumer, null, false, false, false, getRule().ele1ParserRuleCallTerminalRule());
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

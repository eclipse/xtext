/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess.AbstractRuleElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageLexerRuleConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageParserRuleConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageTerminalRuleConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageAbstractRuleConsumer extends NonTerminalConsumer {

	private XtextTerminalsTestLanguageLexerRuleConsumer lexerRuleConsumer;
	private XtextTerminalsTestLanguageParserRuleConsumer parserRuleConsumer;
	private XtextTerminalsTestLanguageTerminalRuleConsumer terminalRuleConsumer;

	public XtextTerminalsTestLanguageAbstractRuleConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
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
		return consumeNonTerminal(lexerRuleConsumer, null, false, false, getRule().ele00ParserRuleCallLexerRule());
	}

	protected int consumeRuleCall$4(int entryPoint) throws Exception {
		return consumeNonTerminal(parserRuleConsumer, null, false, false, getRule().ele01ParserRuleCallParserRule());
	}

	protected int consumeRuleCall$5(int entryPoint) throws Exception {
		return consumeNonTerminal(terminalRuleConsumer, null, false, false, getRule().ele1ParserRuleCallTerminalRule());
	}

	public AbstractRuleElements getRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractRule();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractRule";
	}
	
	public void setLexerRuleConsumer(XtextTerminalsTestLanguageLexerRuleConsumer lexerRuleConsumer) {
		this.lexerRuleConsumer = lexerRuleConsumer;
	}
	
	public void setParserRuleConsumer(XtextTerminalsTestLanguageParserRuleConsumer parserRuleConsumer) {
		this.parserRuleConsumer = parserRuleConsumer;
	}
	
	public void setTerminalRuleConsumer(XtextTerminalsTestLanguageTerminalRuleConsumer terminalRuleConsumer) {
		this.terminalRuleConsumer = terminalRuleConsumer;
	}
	
}

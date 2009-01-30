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

import org.eclipse.xtext.services.XtextGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarAccess.AbstractRuleElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextLexerRuleConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextParserRuleConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextTerminalRuleConsumer;

@SuppressWarnings("unused")
public final class XtextAbstractRuleConsumer extends NonTerminalConsumer {

	private XtextLexerRuleConsumer lexerRuleConsumer;
	private XtextParserRuleConsumer parserRuleConsumer;
	private XtextTerminalRuleConsumer terminalRuleConsumer;

	public XtextAbstractRuleConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
	protected int doConsume(int entryPoint) throws Exception {
		return consumeAlternatives$1(entryPoint);
	}

	protected int consumeAlternatives$1(int entryPoint) throws Exception {
		announceNextLevel();
		int result = ConsumeResult.SUCCESS;
		IMarker bestMarker = mark();
		IMarker currentMarker;
		int tempResult;
		switch(entryPoint) {
			case -1: // use fallthrough semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextPath();
				currentMarker = bestMarker.fork();
				tempResult = consumeRuleCall$3(nextEntryPoint()); 
				if (tempResult == ConsumeResult.SUCCESS) {
					bestMarker = currentMarker.join(bestMarker);
					bestMarker.commit();
					announceLevelFinished();
					return tempResult;
				}
				if (tempResult > result) {
					bestMarker = currentMarker.join(bestMarker);
					result = tempResult;
				} else {
					bestMarker = bestMarker.join(currentMarker);
				}
				currentMarker = null;
			case 1:
				announceNextPath();
				currentMarker = bestMarker.fork();
				tempResult = consumeRuleCall$4(nextEntryPoint()); 
				if (tempResult == ConsumeResult.SUCCESS) {
					bestMarker = currentMarker.join(bestMarker);
					bestMarker.commit();
					announceLevelFinished();
					return tempResult;
				}
				if (tempResult > result) {
					bestMarker = currentMarker.join(bestMarker);
					result = tempResult;
				} else {
					bestMarker = bestMarker.join(currentMarker);
				}
				currentMarker = null;
			case 2:
				announceNextPath();
				currentMarker = bestMarker.fork();
				tempResult = consumeRuleCall$5(nextEntryPoint()); 
				if (tempResult == ConsumeResult.SUCCESS) {
					bestMarker = currentMarker.join(bestMarker);
					bestMarker.commit();
					announceLevelFinished();
					return tempResult;
				}
				if (tempResult > result) {
					bestMarker = currentMarker.join(bestMarker);
					result = tempResult;
				} else {
					bestMarker = bestMarker.join(currentMarker);
				}
				currentMarker = null;
		}
		bestMarker.commit();
		announceLevelFinished();
		return result;
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
		return XtextGrammarAccess.INSTANCE.prAbstractRule();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractRule";
	}
	
	public void setLexerRuleConsumer(XtextLexerRuleConsumer lexerRuleConsumer) {
		this.lexerRuleConsumer = lexerRuleConsumer;
	}
	
	public void setParserRuleConsumer(XtextParserRuleConsumer parserRuleConsumer) {
		this.parserRuleConsumer = parserRuleConsumer;
	}
	
	public void setTerminalRuleConsumer(XtextTerminalRuleConsumer terminalRuleConsumer) {
		this.terminalRuleConsumer = terminalRuleConsumer;
	}
	
}

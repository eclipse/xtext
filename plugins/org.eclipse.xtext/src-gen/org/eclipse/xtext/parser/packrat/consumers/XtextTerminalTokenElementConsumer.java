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
import org.eclipse.xtext.services.XtextGrammarAccess.TerminalTokenElementElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextAbstractNegatedTokenConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextCharacterRangeConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextParenthesizedTerminalElementConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextRuleCallConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextWildcardConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalTokenElementConsumer extends NonTerminalConsumer {

	private XtextAbstractNegatedTokenConsumer abstractNegatedTokenConsumer;
	private XtextCharacterRangeConsumer characterRangeConsumer;
	private XtextParenthesizedTerminalElementConsumer parenthesizedTerminalElementConsumer;
	private XtextRuleCallConsumer ruleCallConsumer;
	private XtextWildcardConsumer wildcardConsumer;

	public XtextTerminalTokenElementConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
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
			case 1:
				announceNextPath();
				currentMarker = bestMarker.fork();
				tempResult = consumeRuleCall$6(nextEntryPoint()); 
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
				tempResult = consumeRuleCall$7(nextEntryPoint()); 
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
			case 3:
				announceNextPath();
				currentMarker = bestMarker.fork();
				tempResult = consumeRuleCall$8(nextEntryPoint()); 
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
			case 4:
				announceNextPath();
				currentMarker = bestMarker.fork();
				tempResult = consumeRuleCall$9(nextEntryPoint()); 
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

	protected int consumeRuleCall$5(int entryPoint) throws Exception {
		return consumeNonTerminal(characterRangeConsumer, null, false, false, getRule().ele0000ParserRuleCallCharacterRange());
	}

	protected int consumeRuleCall$6(int entryPoint) throws Exception {
		return consumeNonTerminal(ruleCallConsumer, null, false, false, getRule().ele0001ParserRuleCallRuleCall());
	}

	protected int consumeRuleCall$7(int entryPoint) throws Exception {
		return consumeNonTerminal(parenthesizedTerminalElementConsumer, null, false, false, getRule().ele001ParserRuleCallParenthesizedTerminalElement());
	}

	protected int consumeRuleCall$8(int entryPoint) throws Exception {
		return consumeNonTerminal(abstractNegatedTokenConsumer, null, false, false, getRule().ele01ParserRuleCallAbstractNegatedToken());
	}

	protected int consumeRuleCall$9(int entryPoint) throws Exception {
		return consumeNonTerminal(wildcardConsumer, null, false, false, getRule().ele1ParserRuleCallWildcard());
	}

	public TerminalTokenElementElements getRule() {
		return XtextGrammarAccess.INSTANCE.prTerminalTokenElement();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setAbstractNegatedTokenConsumer(XtextAbstractNegatedTokenConsumer abstractNegatedTokenConsumer) {
		this.abstractNegatedTokenConsumer = abstractNegatedTokenConsumer;
	}
	
	public void setCharacterRangeConsumer(XtextCharacterRangeConsumer characterRangeConsumer) {
		this.characterRangeConsumer = characterRangeConsumer;
	}
	
	public void setParenthesizedTerminalElementConsumer(XtextParenthesizedTerminalElementConsumer parenthesizedTerminalElementConsumer) {
		this.parenthesizedTerminalElementConsumer = parenthesizedTerminalElementConsumer;
	}
	
	public void setRuleCallConsumer(XtextRuleCallConsumer ruleCallConsumer) {
		this.ruleCallConsumer = ruleCallConsumer;
	}
	
	public void setWildcardConsumer(XtextWildcardConsumer wildcardConsumer) {
		this.wildcardConsumer = wildcardConsumer;
	}
	
}

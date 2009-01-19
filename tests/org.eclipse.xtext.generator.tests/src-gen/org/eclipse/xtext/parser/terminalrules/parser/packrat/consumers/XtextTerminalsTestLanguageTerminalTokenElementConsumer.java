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
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess.TerminalTokenElementElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageAbstractNegatedTokenConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageCharacterRangeConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageParenthesizedTerminalElementConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageRuleCallConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageWildcardConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageTerminalTokenElementConsumer extends NonTerminalConsumer {

	private XtextTerminalsTestLanguageAbstractNegatedTokenConsumer abstractNegatedTokenConsumer;
	private XtextTerminalsTestLanguageCharacterRangeConsumer characterRangeConsumer;
	private XtextTerminalsTestLanguageParenthesizedTerminalElementConsumer parenthesizedTerminalElementConsumer;
	private XtextTerminalsTestLanguageRuleCallConsumer ruleCallConsumer;
	private XtextTerminalsTestLanguageWildcardConsumer wildcardConsumer;

	public XtextTerminalsTestLanguageTerminalTokenElementConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeAlternatives$1();
	}

	protected boolean consumeAlternatives$1() throws Exception {
		if (consumeRuleCall$5())
			return true;
		if (consumeRuleCall$6())
			return true;
		if (consumeRuleCall$7())
			return true;
		if (consumeRuleCall$8())
			return true;
		if (consumeRuleCall$9())
			return true;
		return false;
	}

	protected boolean consumeRuleCall$5() throws Exception {
		return consumeNonTerminal(characterRangeConsumer, null, false, false, getRule().ele0000ParserRuleCallCharacterRange());
	}

	protected boolean consumeRuleCall$6() throws Exception {
		return consumeNonTerminal(ruleCallConsumer, null, false, false, getRule().ele0001ParserRuleCallRuleCall());
	}

	protected boolean consumeRuleCall$7() throws Exception {
		return consumeNonTerminal(parenthesizedTerminalElementConsumer, null, false, false, getRule().ele001ParserRuleCallParenthesizedTerminalElement());
	}

	protected boolean consumeRuleCall$8() throws Exception {
		return consumeNonTerminal(abstractNegatedTokenConsumer, null, false, false, getRule().ele01ParserRuleCallAbstractNegatedToken());
	}

	protected boolean consumeRuleCall$9() throws Exception {
		return consumeNonTerminal(wildcardConsumer, null, false, false, getRule().ele1ParserRuleCallWildcard());
	}

	public TerminalTokenElementElements getRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prTerminalTokenElement();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setAbstractNegatedTokenConsumer(XtextTerminalsTestLanguageAbstractNegatedTokenConsumer abstractNegatedTokenConsumer) {
		this.abstractNegatedTokenConsumer = abstractNegatedTokenConsumer;
	}
	
	public void setCharacterRangeConsumer(XtextTerminalsTestLanguageCharacterRangeConsumer characterRangeConsumer) {
		this.characterRangeConsumer = characterRangeConsumer;
	}
	
	public void setParenthesizedTerminalElementConsumer(XtextTerminalsTestLanguageParenthesizedTerminalElementConsumer parenthesizedTerminalElementConsumer) {
		this.parenthesizedTerminalElementConsumer = parenthesizedTerminalElementConsumer;
	}
	
	public void setRuleCallConsumer(XtextTerminalsTestLanguageRuleCallConsumer ruleCallConsumer) {
		this.ruleCallConsumer = ruleCallConsumer;
	}
	
	public void setWildcardConsumer(XtextTerminalsTestLanguageWildcardConsumer wildcardConsumer) {
		this.wildcardConsumer = wildcardConsumer;
	}
	
}

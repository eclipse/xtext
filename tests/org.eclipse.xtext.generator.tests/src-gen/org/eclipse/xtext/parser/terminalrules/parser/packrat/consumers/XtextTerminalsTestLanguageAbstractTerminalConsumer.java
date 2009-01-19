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
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess.AbstractTerminalElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageCrossReferenceConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageKeywordConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageParenthesizedElementConsumer;
import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageRuleCallConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageAbstractTerminalConsumer extends NonTerminalConsumer {

	private XtextTerminalsTestLanguageCrossReferenceConsumer crossReferenceConsumer;
	private XtextTerminalsTestLanguageKeywordConsumer keywordConsumer;
	private XtextTerminalsTestLanguageParenthesizedElementConsumer parenthesizedElementConsumer;
	private XtextTerminalsTestLanguageRuleCallConsumer ruleCallConsumer;

	public XtextTerminalsTestLanguageAbstractTerminalConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeAlternatives$1();
	}

	protected boolean consumeAlternatives$1() throws Exception {
		if (consumeRuleCall$4())
			return true;
		if (consumeRuleCall$5())
			return true;
		if (consumeRuleCall$6())
			return true;
		if (consumeRuleCall$7())
			return true;
		return false;
	}

	protected boolean consumeRuleCall$4() throws Exception {
		return consumeNonTerminal(keywordConsumer, null, false, false, getRule().ele000ParserRuleCallKeyword());
	}

	protected boolean consumeRuleCall$5() throws Exception {
		return consumeNonTerminal(ruleCallConsumer, null, false, false, getRule().ele001ParserRuleCallRuleCall());
	}

	protected boolean consumeRuleCall$6() throws Exception {
		return consumeNonTerminal(parenthesizedElementConsumer, null, false, false, getRule().ele01ParserRuleCallParenthesizedElement());
	}

	protected boolean consumeRuleCall$7() throws Exception {
		return consumeNonTerminal(crossReferenceConsumer, null, false, false, getRule().ele1ParserRuleCallCrossReference());
	}

	public AbstractTerminalElements getRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prAbstractTerminal();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setCrossReferenceConsumer(XtextTerminalsTestLanguageCrossReferenceConsumer crossReferenceConsumer) {
		this.crossReferenceConsumer = crossReferenceConsumer;
	}
	
	public void setKeywordConsumer(XtextTerminalsTestLanguageKeywordConsumer keywordConsumer) {
		this.keywordConsumer = keywordConsumer;
	}
	
	public void setParenthesizedElementConsumer(XtextTerminalsTestLanguageParenthesizedElementConsumer parenthesizedElementConsumer) {
		this.parenthesizedElementConsumer = parenthesizedElementConsumer;
	}
	
	public void setRuleCallConsumer(XtextTerminalsTestLanguageRuleCallConsumer ruleCallConsumer) {
		this.ruleCallConsumer = ruleCallConsumer;
	}
	
}

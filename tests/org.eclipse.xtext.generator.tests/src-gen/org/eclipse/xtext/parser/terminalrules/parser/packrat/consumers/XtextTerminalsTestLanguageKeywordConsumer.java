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
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess.KeywordElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageSTRINGConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageKeywordConsumer extends NonTerminalConsumer {

	private XtextTerminalsTestLanguageSTRINGConsumer stringConsumer;

	private ISequenceMatcher ruleCall$2$Delimiter;
	
	public XtextTerminalsTestLanguageKeywordConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		ruleCall$2$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeAssignment$1();
	}

	protected boolean consumeAssignment$1() throws Exception {
		if (consumeTerminal(stringConsumer, "value", false, false, getRule().ele0ParserRuleCallSTRING(), getRuleCall$2$Delimiter()))
			return true;
		return false;
	}

	public KeywordElements getRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prKeyword();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Keyword";
	}
	
	public void setStringConsumer(XtextTerminalsTestLanguageSTRINGConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public ISequenceMatcher getRuleCall$2$Delimiter() {
		return ruleCall$2$Delimiter;
	}
	
	public void setRuleCall$2$Delimiter(ISequenceMatcher matcher) {
		ruleCall$2$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

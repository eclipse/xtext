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
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.terminalrules.services.XtextTerminalsTestLanguageGrammarAccess.RuleCallElements;

import org.eclipse.xtext.parser.terminalrules.parser.packrat.consumers.XtextTerminalsTestLanguageIDConsumer;

@SuppressWarnings("unused")
public final class XtextTerminalsTestLanguageRuleCallConsumer extends NonTerminalConsumer {

	private XtextTerminalsTestLanguageIDConsumer idConsumer;

	private ISequenceMatcher crossReference$2$Delimiter;
	
	public XtextTerminalsTestLanguageRuleCallConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		crossReference$2$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected int doConsume() throws Exception {
		return consumeAssignment$1();
	}

	protected int consumeAssignment$1() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(idConsumer, "rule", false, false, getRule().ele0CrossReferenceEStringAbstractRule(), getCrossReference$2$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	public RuleCallElements getRule() {
		return XtextTerminalsTestLanguageGrammarAccess.INSTANCE.prRuleCall();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "RuleCall";
	}
	
	public void setIdConsumer(XtextTerminalsTestLanguageIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public ISequenceMatcher getCrossReference$2$Delimiter() {
		return crossReference$2$Delimiter;
	}
	
	public void setCrossReference$2$Delimiter(ISequenceMatcher matcher) {
		crossReference$2$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

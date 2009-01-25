/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers;

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

import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.TrickyG2Elements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageTrickyG1Consumer;

@SuppressWarnings("unused")
public final class ComplexReconstrTestLanguageTrickyG2Consumer extends NonTerminalConsumer {

	private XtextBuiltinINTConsumer intConsumer;
	private ComplexReconstrTestLanguageTrickyG1Consumer trickyG1Consumer;

	private ISequenceMatcher ruleCall$4$Delimiter;
	
	public ComplexReconstrTestLanguageTrickyG2Consumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		ruleCall$4$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected int doConsume() throws Exception {
		return consumeAlternatives$1();
	}

	protected int consumeAlternatives$1() throws Exception {
		int result = ConsumeResult.SUCCESS;
		IMarker bestMarker = mark();
		IMarker currentMarker;
		int tempResult;
		currentMarker = bestMarker.fork();
		tempResult = consumeRuleCall$2(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			bestMarker = currentMarker.join(bestMarker);
			bestMarker.commit();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker = currentMarker.join(bestMarker);
			result = tempResult;
		} else {
			bestMarker = bestMarker.join(currentMarker);
		}
		currentMarker = null;
		currentMarker = bestMarker.fork();
		tempResult = consumeAssignment$3(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			bestMarker = currentMarker.join(bestMarker);
			bestMarker.commit();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker = currentMarker.join(bestMarker);
			result = tempResult;
		} else {
			bestMarker = bestMarker.join(currentMarker);
		}
		currentMarker = null;
		bestMarker.commit();
		return result;
	}

	protected int consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(trickyG1Consumer, null, false, false, getRule().ele0ParserRuleCallTrickyG1());
	}

	protected int consumeAssignment$3() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(intConsumer, "val", false, false, getRule().ele10LexerRuleCallINT(), getRuleCall$4$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	public TrickyG2Elements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyG2();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TrickyG2";
	}
	
	public void setIntConsumer(XtextBuiltinINTConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	
	public void setTrickyG1Consumer(ComplexReconstrTestLanguageTrickyG1Consumer trickyG1Consumer) {
		this.trickyG1Consumer = trickyG1Consumer;
	}
	
	public ISequenceMatcher getRuleCall$4$Delimiter() {
		return ruleCall$4$Delimiter;
	}
	
	public void setRuleCall$4$Delimiter(ISequenceMatcher matcher) {
		ruleCall$4$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

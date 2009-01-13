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
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.TrickyG2Elements;

import org.eclipse.xtext.parsetree.reconstr.parser.packrat.ComplexReconstrTestLanguageDelimiters;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageTrickyG1Consumer;

@SuppressWarnings("unused")
public final class ComplexReconstrTestLanguageTrickyG2Consumer extends NonTerminalConsumer {

	private XtextBuiltinINTConsumer intConsumer;
	private ComplexReconstrTestLanguageTrickyG1Consumer trickyG1Consumer;

	public ComplexReconstrTestLanguageTrickyG2Consumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeAlternatives$1();
	}

	protected boolean consumeAlternatives$1() throws Exception {
		if (consumeRuleCall$2())
			return true;
		if (consumeAssignment$3())
			return true;
		return false;
	}

	protected boolean consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(trickyG1Consumer, null, false, false, getRule().ele0ParserRuleCallTrickyG1());
	}

	protected boolean consumeAssignment$3() throws Exception {
		if (consumeTerminal(intConsumer, "val", false, false, getRule().ele10LexerRuleCallINT(), ComplexReconstrTestLanguageDelimiters.ALL_KEYWORDS))
			return true;
		return false;
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
	
}

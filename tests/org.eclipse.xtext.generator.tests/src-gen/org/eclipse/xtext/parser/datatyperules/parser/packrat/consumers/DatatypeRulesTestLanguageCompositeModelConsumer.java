/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess.CompositeModelElements;

import org.eclipse.xtext.parser.datatyperules.parser.packrat.DatatypeRulesTestLanguageDelimiters;

import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageModelConsumer;

@SuppressWarnings("unused")
public final class DatatypeRulesTestLanguageCompositeModelConsumer extends NonTerminalConsumer {

	private DatatypeRulesTestLanguageModelConsumer modelConsumer;

	public DatatypeRulesTestLanguageCompositeModelConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeAssignment$1();
	}

	protected boolean consumeAssignment$1() throws Exception {
		if (doConsumeAssignment$1()) {
			while(doConsumeAssignment$1()) {}
			return true;
		}
		return false;
	}

	protected boolean doConsumeAssignment$1() throws Exception {
		if (consumeNonTerminal(modelConsumer, "model", true, false, getRule().ele0ParserRuleCallModel()))
			return true;
		return false;
	}

	public CompositeModelElements getRule() {
		return DatatypeRulesTestLanguageGrammarAccess.INSTANCE.prCompositeModel();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "CompositeModel";
	}
	
	public void setModelConsumer(DatatypeRulesTestLanguageModelConsumer modelConsumer) {
		this.modelConsumer = modelConsumer;
	}
	
}

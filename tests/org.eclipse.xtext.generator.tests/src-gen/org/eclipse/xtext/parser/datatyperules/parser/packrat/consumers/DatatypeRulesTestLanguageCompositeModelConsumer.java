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
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess.CompositeModelElements;

import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageModelConsumer;

@SuppressWarnings("unused")
public final class DatatypeRulesTestLanguageCompositeModelConsumer extends NonTerminalConsumer {

	private DatatypeRulesTestLanguageModelConsumer modelConsumer;

	public DatatypeRulesTestLanguageCompositeModelConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected int doConsume() throws Exception {
		return consumeAssignment$1();
	}

	protected int consumeAssignment$1() throws Exception {
		IMarker marker = mark();
		int result = doConsumeAssignment$1();
		if (result == ConsumeResult.SUCCESS) {
			marker.release();
			marker = mark();
			while(doConsumeAssignment$1()==ConsumeResult.SUCCESS) {
				marker.release();
				marker = mark();
			}
			marker.rollback();
			marker.release();
			return ConsumeResult.SUCCESS;
		} else {
			error("Could not find token.", getRule().eleAssignmentModel());
		}
		marker.release();
		return result;
	}

	protected int doConsumeAssignment$1() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(modelConsumer, "model", true, false, getRule().ele0ParserRuleCallModel());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
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

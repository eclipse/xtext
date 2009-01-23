/*
Generated with Xtext
*/
package org.eclipse.xtext.dummy.parser.packrat.consumers;

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

import org.eclipse.xtext.dummy.services.DummyTestLanguageGrammarAccess;
import org.eclipse.xtext.dummy.services.DummyTestLanguageGrammarAccess.ModelElements;

import org.eclipse.xtext.dummy.parser.packrat.consumers.DummyTestLanguageElementConsumer;

@SuppressWarnings("unused")
public final class DummyTestLanguageModelConsumer extends NonTerminalConsumer {

	private DummyTestLanguageElementConsumer elementConsumer;

	public DummyTestLanguageModelConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected int doConsume() throws Exception {
		return consumeAssignment$1();
	}

	protected int consumeAssignment$1() throws Exception {
		IMarker marker = mark();
		while(doConsumeAssignment$1() == ConsumeResult.SUCCESS) {
			marker.release();
			marker = mark();
		}
		marker.rollback();
		marker.release();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$1() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(elementConsumer, "elements", true, false, getRule().ele0ParserRuleCallElement());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	public ModelElements getRule() {
		return DummyTestLanguageGrammarAccess.INSTANCE.prModel();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Model";
	}
	
	public void setElementConsumer(DummyTestLanguageElementConsumer elementConsumer) {
		this.elementConsumer = elementConsumer;
	}
	
}

/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers;

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

import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess;
import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess.RootElements;

import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestTestListConsumer;
import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestTestOptionalConsumer;
import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestTestRequiredConsumer;

@SuppressWarnings("unused")
public final class TransientValuesTestRootConsumer extends NonTerminalConsumer {

	private TransientValuesTestTestListConsumer testListConsumer;
	private TransientValuesTestTestOptionalConsumer testOptionalConsumer;
	private TransientValuesTestTestRequiredConsumer testRequiredConsumer;

	private ICharacterClass keyword$2$Delimiter;
	
	public TransientValuesTestRootConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$2$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected int doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected int consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$2(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0KeywordTest());
			marker.commit();
			return result;
		}
		result = consumeAlternatives$3(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1Alternatives());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$2() throws Exception {
		return consumeKeyword(getRule().ele0KeywordTest(), null, false, false, getKeyword$2$Delimiter());
	}

	protected int consumeAlternatives$3() throws Exception {
		int result = ConsumeResult.SUCCESS;
		IMarker bestMarker = mark();
		IMarker currentMarker;
		int tempResult;
		currentMarker = bestMarker.fork();
		tempResult = consumeRuleCall$5(); 
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
		tempResult = consumeRuleCall$6(); 
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
		tempResult = consumeRuleCall$7(); 
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

	protected int consumeRuleCall$5() throws Exception {
		return consumeNonTerminal(testRequiredConsumer, null, false, false, getRule().ele100ParserRuleCallTestRequired());
	}

	protected int consumeRuleCall$6() throws Exception {
		return consumeNonTerminal(testOptionalConsumer, null, false, false, getRule().ele101ParserRuleCallTestOptional());
	}

	protected int consumeRuleCall$7() throws Exception {
		return consumeNonTerminal(testListConsumer, null, false, false, getRule().ele11ParserRuleCallTestList());
	}

	public RootElements getRule() {
		return TransientValuesTestGrammarAccess.INSTANCE.prRoot();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Root";
	}
	
	public void setTestListConsumer(TransientValuesTestTestListConsumer testListConsumer) {
		this.testListConsumer = testListConsumer;
	}
	
	public void setTestOptionalConsumer(TransientValuesTestTestOptionalConsumer testOptionalConsumer) {
		this.testOptionalConsumer = testOptionalConsumer;
	}
	
	public void setTestRequiredConsumer(TransientValuesTestTestRequiredConsumer testRequiredConsumer) {
		this.testRequiredConsumer = testRequiredConsumer;
	}
	
	public ICharacterClass getKeyword$2$Delimiter() {
		return keyword$2$Delimiter;
	}
	
	public void setKeyword$2$Delimiter(ICharacterClass characterClass) {
		keyword$2$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}

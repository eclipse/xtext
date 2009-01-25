/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat.consumers;

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

import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.ReferenceGrammarTestLanguageGrammarAccess.PersonElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ReferenceGrammarTestLanguageErwachsenerConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.ReferenceGrammarTestLanguageKindConsumer;

@SuppressWarnings("unused")
public final class ReferenceGrammarTestLanguagePersonConsumer extends NonTerminalConsumer {

	private ReferenceGrammarTestLanguageErwachsenerConsumer erwachsenerConsumer;
	private ReferenceGrammarTestLanguageKindConsumer kindConsumer;

	public ReferenceGrammarTestLanguagePersonConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
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
		tempResult = consumeRuleCall$3(); 
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
		return consumeNonTerminal(kindConsumer, null, false, false, getRule().ele0ParserRuleCallKind());
	}

	protected int consumeRuleCall$3() throws Exception {
		return consumeNonTerminal(erwachsenerConsumer, null, false, false, getRule().ele1ParserRuleCallErwachsener());
	}

	public PersonElements getRule() {
		return ReferenceGrammarTestLanguageGrammarAccess.INSTANCE.prPerson();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Person";
	}
	
	public void setErwachsenerConsumer(ReferenceGrammarTestLanguageErwachsenerConsumer erwachsenerConsumer) {
		this.erwachsenerConsumer = erwachsenerConsumer;
	}
	
	public void setKindConsumer(ReferenceGrammarTestLanguageKindConsumer kindConsumer) {
		this.kindConsumer = kindConsumer;
	}
	
}

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

import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.LookaheadTestLanguageGrammarAccess.LookAhead0Elements;


@SuppressWarnings("unused")
public final class LookaheadTestLanguageLookAhead0Consumer extends NonTerminalConsumer {


	private ICharacterClass keyword$2$Delimiter;
	
	private ICharacterClass keyword$4$Delimiter;
	
	public LookaheadTestLanguageLookAhead0Consumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$2$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$4$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected int doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected int consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$2(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0KeywordBar());
			marker.commit();
			return result;
		}
		result = consumeAssignment$3(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1AssignmentX());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$2() throws Exception {
		return consumeKeyword(getRule().ele0KeywordBar(), null, false, false, getKeyword$2$Delimiter());
	}

	protected int consumeAssignment$3() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeKeyword(getRule().ele10KeywordA(), "x", false, false, getKeyword$4$Delimiter()); 
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	public LookAhead0Elements getRule() {
		return LookaheadTestLanguageGrammarAccess.INSTANCE.prLookAhead0();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "LookAhead0";
	}
	
	public ICharacterClass getKeyword$2$Delimiter() {
		return keyword$2$Delimiter;
	}
	
	public void setKeyword$2$Delimiter(ICharacterClass characterClass) {
		keyword$2$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$4$Delimiter() {
		return keyword$4$Delimiter;
	}
	
	public void setKeyword$4$Delimiter(ICharacterClass characterClass) {
		keyword$4$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}

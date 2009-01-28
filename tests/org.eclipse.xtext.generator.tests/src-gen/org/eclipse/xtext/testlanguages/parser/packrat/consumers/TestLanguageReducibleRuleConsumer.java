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

import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess.ReducibleRuleElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.TestLanguageTerminalRuleConsumer;

@SuppressWarnings("unused")
public final class TestLanguageReducibleRuleConsumer extends NonTerminalConsumer {

	private TestLanguageTerminalRuleConsumer terminalRuleConsumer;

	private ICharacterClass keyword$3$Delimiter;
	
	public TestLanguageReducibleRuleConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$3$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected int doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected int consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$3(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00KeywordReducible());
			marker.commit();
			return result;
		}
		result = consumeRuleCall$4(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele01ParserRuleCallTerminalRule());
			marker.commit();
			return result;
		}
		result = consumeGroup$5(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1Group());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$3() throws Exception {
		return consumeKeyword(getRule().ele00KeywordReducible(), null, false, false, getKeyword$3$Delimiter());
	}

	protected int consumeRuleCall$4() throws Exception {
		return consumeNonTerminal(terminalRuleConsumer, null, false, false, getRule().ele01ParserRuleCallTerminalRule());
	}

	protected int consumeGroup$5() throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$5();
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$5() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeAction$6(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele10ActionReducibleCompositeactionFeature());
			marker.commit();
			return result;
		}
		result = consumeAssignment$8(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele11AssignmentActionFeature());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}
	protected int consumeAction$6() {
		consumeAction(getRule().ele10ActionReducibleCompositeactionFeature(), "ReducibleComposite", true);
		return ConsumeResult.SUCCESS;	
	}

	protected int consumeAssignment$8() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(terminalRuleConsumer, "actionFeature", true, false, getRule().ele110ParserRuleCallTerminalRule());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	public ReducibleRuleElements getRule() {
		return TestLanguageGrammarAccess.INSTANCE.prReducibleRule();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "ReducibleElement";
	}
	
	public void setTerminalRuleConsumer(TestLanguageTerminalRuleConsumer terminalRuleConsumer) {
		this.terminalRuleConsumer = terminalRuleConsumer;
	}
	
	public ICharacterClass getKeyword$3$Delimiter() {
		return keyword$3$Delimiter;
	}
	
	public void setKeyword$3$Delimiter(ICharacterClass characterClass) {
		keyword$3$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}

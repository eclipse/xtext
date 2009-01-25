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
import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess.NestedModelIdElements;

import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageModelIdConsumer;

@SuppressWarnings("unused")
public final class DatatypeRulesTestLanguageNestedModelIdConsumer extends NonTerminalConsumer {

	private DatatypeRulesTestLanguageModelIdConsumer modelIdConsumer;

	private ICharacterClass keyword$4$Delimiter;
	
	public DatatypeRulesTestLanguageNestedModelIdConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$4$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected int doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected int consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeRuleCall$3(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00ParserRuleCallModelId());
			marker.commit();
			return result;
		}
		result = consumeKeyword$4(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele01KeywordFullStop());
			marker.commit();
			return result;
		}
		result = consumeRuleCall$5(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1ParserRuleCallModelId());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeRuleCall$3() throws Exception {
		return consumeNonTerminal(modelIdConsumer, null, false, true, getRule().ele00ParserRuleCallModelId());
	}

	protected int consumeKeyword$4() throws Exception {
		return consumeKeyword(getRule().ele01KeywordFullStop(), null, false, false, getKeyword$4$Delimiter());
	}

	protected int consumeRuleCall$5() throws Exception {
		return consumeNonTerminal(modelIdConsumer, null, false, true, getRule().ele1ParserRuleCallModelId());
	}

	public NestedModelIdElements getRule() {
		return DatatypeRulesTestLanguageGrammarAccess.INSTANCE.prNestedModelId();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "EString";
	}
	
	public void setModelIdConsumer(DatatypeRulesTestLanguageModelIdConsumer modelIdConsumer) {
		this.modelIdConsumer = modelIdConsumer;
	}
	
	public ICharacterClass getKeyword$4$Delimiter() {
		return keyword$4$Delimiter;
	}
	
	public void setKeyword$4$Delimiter(ICharacterClass characterClass) {
		keyword$4$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}

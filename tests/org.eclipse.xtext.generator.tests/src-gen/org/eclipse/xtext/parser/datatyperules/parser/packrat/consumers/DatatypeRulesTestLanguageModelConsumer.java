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
import org.eclipse.xtext.parser.datatyperules.services.DatatypeRulesTestLanguageGrammarAccess.ModelElements;

import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageDotsConsumer;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageFractionConsumer;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageNestedModelIdConsumer;
import org.eclipse.xtext.parser.datatyperules.parser.packrat.consumers.DatatypeRulesTestLanguageVectorConsumer;

@SuppressWarnings("unused")
public final class DatatypeRulesTestLanguageModelConsumer extends NonTerminalConsumer {

	private DatatypeRulesTestLanguageDotsConsumer dotsConsumer;
	private DatatypeRulesTestLanguageFractionConsumer fractionConsumer;
	private DatatypeRulesTestLanguageNestedModelIdConsumer nestedModelIdConsumer;
	private DatatypeRulesTestLanguageVectorConsumer vectorConsumer;

	private ICharacterClass keyword$8$Delimiter;
	
	private ICharacterClass keyword$12$Delimiter;
	
	private ICharacterClass keyword$16$Delimiter;
	
	private ICharacterClass keyword$19$Delimiter;
	
	public DatatypeRulesTestLanguageModelConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$8$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$12$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$16$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$19$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected int doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected int consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeAssignment$5(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0000AssignmentId());
			marker.release();
			return result;
		}
		result = consumeGroup$7(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0001Group());
			marker.release();
			return result;
		}
		result = consumeGroup$11(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele001Group());
			marker.release();
			return result;
		}
		result = consumeGroup$15(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele01Group());
			marker.release();
			return result;
		}
		result = consumeKeyword$19(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1KeywordSemicolon());
			marker.release();
			return result;
		}
		marker.release();
		return result;
	}

	protected int consumeAssignment$5() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(nestedModelIdConsumer, "id", false, true, getRule().ele00000ParserRuleCallNestedModelId());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeGroup$7() throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$7();
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		marker.release();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$7() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$8(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00010KeywordColon());
			marker.release();
			return result;
		}
		result = consumeAssignment$9(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00011AssignmentValue());
			marker.release();
			return result;
		}
		marker.release();
		return result;
	}

	protected int consumeKeyword$8() throws Exception {
		return consumeKeyword(getRule().ele00010KeywordColon(), null, false, false, getKeyword$8$Delimiter());
	}

	protected int consumeAssignment$9() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(fractionConsumer, "value", false, true, getRule().ele000110ParserRuleCallFraction());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeGroup$11() throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$11();
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		marker.release();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$11() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$12(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0010KeywordNumberSign());
			marker.release();
			return result;
		}
		result = consumeAssignment$13(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0011AssignmentVector());
			marker.release();
			return result;
		}
		marker.release();
		return result;
	}

	protected int consumeKeyword$12() throws Exception {
		return consumeKeyword(getRule().ele0010KeywordNumberSign(), null, false, false, getKeyword$12$Delimiter());
	}

	protected int consumeAssignment$13() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(vectorConsumer, "vector", false, true, getRule().ele00110ParserRuleCallVector());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeGroup$15() throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$15();
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		marker.release();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$15() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$16(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele010KeywordPlusSign());
			marker.release();
			return result;
		}
		result = consumeAssignment$17(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele011AssignmentDots());
			marker.release();
			return result;
		}
		marker.release();
		return result;
	}

	protected int consumeKeyword$16() throws Exception {
		return consumeKeyword(getRule().ele010KeywordPlusSign(), null, false, false, getKeyword$16$Delimiter());
	}

	protected int consumeAssignment$17() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(dotsConsumer, "dots", false, true, getRule().ele0110ParserRuleCallDots());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeKeyword$19() throws Exception {
		return consumeKeyword(getRule().ele1KeywordSemicolon(), null, false, false, getKeyword$19$Delimiter());
	}

	public ModelElements getRule() {
		return DatatypeRulesTestLanguageGrammarAccess.INSTANCE.prModel();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Model";
	}
	
	public void setDotsConsumer(DatatypeRulesTestLanguageDotsConsumer dotsConsumer) {
		this.dotsConsumer = dotsConsumer;
	}
	
	public void setFractionConsumer(DatatypeRulesTestLanguageFractionConsumer fractionConsumer) {
		this.fractionConsumer = fractionConsumer;
	}
	
	public void setNestedModelIdConsumer(DatatypeRulesTestLanguageNestedModelIdConsumer nestedModelIdConsumer) {
		this.nestedModelIdConsumer = nestedModelIdConsumer;
	}
	
	public void setVectorConsumer(DatatypeRulesTestLanguageVectorConsumer vectorConsumer) {
		this.vectorConsumer = vectorConsumer;
	}
	
	public ICharacterClass getKeyword$8$Delimiter() {
		return keyword$8$Delimiter;
	}
	
	public void setKeyword$8$Delimiter(ICharacterClass characterClass) {
		keyword$8$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$12$Delimiter() {
		return keyword$12$Delimiter;
	}
	
	public void setKeyword$12$Delimiter(ICharacterClass characterClass) {
		keyword$12$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$16$Delimiter() {
		return keyword$16$Delimiter;
	}
	
	public void setKeyword$16$Delimiter(ICharacterClass characterClass) {
		keyword$16$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$19$Delimiter() {
		return keyword$19$Delimiter;
	}
	
	public void setKeyword$19$Delimiter(ICharacterClass characterClass) {
		keyword$19$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}

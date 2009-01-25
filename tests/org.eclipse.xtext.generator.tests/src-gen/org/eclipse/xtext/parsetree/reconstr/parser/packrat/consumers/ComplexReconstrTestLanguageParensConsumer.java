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
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.ParensElements;

import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageOpConsumer;

@SuppressWarnings("unused")
public final class ComplexReconstrTestLanguageParensConsumer extends NonTerminalConsumer {

	private ComplexReconstrTestLanguageOpConsumer opConsumer;

	private ICharacterClass keyword$4$Delimiter;
	
	private ICharacterClass keyword$6$Delimiter;
	
	private ICharacterClass keyword$8$Delimiter;
	
	public ComplexReconstrTestLanguageParensConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$4$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$6$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$8$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected int doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected int consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$4(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele000KeywordLeftParenthesis());
			marker.commit();
			return result;
		}
		result = consumeRuleCall$5(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele001ParserRuleCallOp());
			marker.commit();
			return result;
		}
		result = consumeKeyword$6(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele01KeywordRightParenthesis());
			marker.commit();
			return result;
		}
		result = consumeAssignment$7(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1AssignmentEm());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$4() throws Exception {
		return consumeKeyword(getRule().ele000KeywordLeftParenthesis(), null, false, false, getKeyword$4$Delimiter());
	}

	protected int consumeRuleCall$5() throws Exception {
		return consumeNonTerminal(opConsumer, null, false, false, getRule().ele001ParserRuleCallOp());
	}

	protected int consumeKeyword$6() throws Exception {
		return consumeKeyword(getRule().ele01KeywordRightParenthesis(), null, false, false, getKeyword$6$Delimiter());
	}

	protected int consumeAssignment$7() throws Exception {
		IMarker marker = mark();
		int result = doConsumeAssignment$7();
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$7() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeKeyword(getRule().ele10KeywordExclamationMark(), "em", false, false, getKeyword$8$Delimiter()); 
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	public ParensElements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prParens();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Expression";
	}
	
	public void setOpConsumer(ComplexReconstrTestLanguageOpConsumer opConsumer) {
		this.opConsumer = opConsumer;
	}
	
	public ICharacterClass getKeyword$4$Delimiter() {
		return keyword$4$Delimiter;
	}
	
	public void setKeyword$4$Delimiter(ICharacterClass characterClass) {
		keyword$4$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$6$Delimiter() {
		return keyword$6$Delimiter;
	}
	
	public void setKeyword$6$Delimiter(ICharacterClass characterClass) {
		keyword$6$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$8$Delimiter() {
		return keyword$8$Delimiter;
	}
	
	public void setKeyword$8$Delimiter(ICharacterClass characterClass) {
		keyword$8$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}

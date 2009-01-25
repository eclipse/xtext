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
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.TrickyG1Elements;

import org.eclipse.xtext.parsetree.reconstr.parser.packrat.consumers.ComplexReconstrTestLanguageTrickyG2Consumer;

@SuppressWarnings("unused")
public final class ComplexReconstrTestLanguageTrickyG1Consumer extends NonTerminalConsumer {

	private ComplexReconstrTestLanguageTrickyG2Consumer trickyG2Consumer;

	private ICharacterClass keyword$3$Delimiter;
	
	private ICharacterClass keyword$8$Delimiter;
	
	private ICharacterClass keyword$11$Delimiter;
	
	public ComplexReconstrTestLanguageTrickyG1Consumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$3$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$8$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected int doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected int consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$3(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00KeywordLeftSquareBracket());
			marker.commit();
			return result;
		}
		result = consumeGroup$4(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele01Group());
			marker.commit();
			return result;
		}
		result = consumeKeyword$11(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1KeywordRightSquareBracket());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$3() throws Exception {
		return consumeKeyword(getRule().ele00KeywordLeftSquareBracket(), null, false, false, getKeyword$3$Delimiter());
	}

	protected int consumeGroup$4() throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$4();
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$4() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeAssignment$5(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele010AssignmentVals());
			marker.commit();
			return result;
		}
		result = consumeGroup$7(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele011Group());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeAssignment$5() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(trickyG2Consumer, "vals", true, false, getRule().ele0100ParserRuleCallTrickyG2());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeGroup$7() throws Exception {
		IMarker marker = mark();
		while(doConsumeGroup$7() == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$7() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$8(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0110KeywordComma());
			marker.commit();
			return result;
		}
		result = consumeAssignment$9(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0111AssignmentVals());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$8() throws Exception {
		return consumeKeyword(getRule().ele0110KeywordComma(), null, false, false, getKeyword$8$Delimiter());
	}

	protected int consumeAssignment$9() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(trickyG2Consumer, "vals", true, false, getRule().ele01110ParserRuleCallTrickyG2());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightSquareBracket(), null, false, false, getKeyword$11$Delimiter());
	}

	public TrickyG1Elements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyG1();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TrickyG1";
	}
	
	public void setTrickyG2Consumer(ComplexReconstrTestLanguageTrickyG2Consumer trickyG2Consumer) {
		this.trickyG2Consumer = trickyG2Consumer;
	}
	
	public ICharacterClass getKeyword$3$Delimiter() {
		return keyword$3$Delimiter;
	}
	
	public void setKeyword$3$Delimiter(ICharacterClass characterClass) {
		keyword$3$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$8$Delimiter() {
		return keyword$8$Delimiter;
	}
	
	public void setKeyword$8$Delimiter(ICharacterClass characterClass) {
		keyword$8$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$11$Delimiter() {
		return keyword$11$Delimiter;
	}
	
	public void setKeyword$11$Delimiter(ICharacterClass characterClass) {
		keyword$11$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}

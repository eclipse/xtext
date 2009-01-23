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
import org.eclipse.xtext.parsetree.reconstr.services.ComplexReconstrTestLanguageGrammarAccess.TrickyCElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class ComplexReconstrTestLanguageTrickyCConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;

	private ICharacterClass keyword$19$Delimiter;
	
	private ICharacterClass keyword$5$Delimiter;
	
	private ICharacterClass keyword$11$Delimiter;
	
	private ICharacterClass keyword$15$Delimiter;
	
	private ISequenceMatcher ruleCall$7$Delimiter;
	
	public ComplexReconstrTestLanguageTrickyCConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$19$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$5$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$15$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$7$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected int doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected int consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$5(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0000KeywordTC());
			marker.release();
			return result;
		}
		result = consumeAssignment$6(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0001AssignmentName());
			marker.release();
			return result;
		}
		result = consumeGroup$8(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele001Group());
			marker.release();
			return result;
		}
		result = consumeGroup$12(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele01Group());
			marker.release();
			return result;
		}
		result = consumeGroup$16(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1Group());
			marker.release();
			return result;
		}
		marker.release();
		return result;
	}

	protected int consumeKeyword$5() throws Exception {
		return consumeKeyword(getRule().ele0000KeywordTC(), null, false, false, getKeyword$5$Delimiter());
	}

	protected int consumeAssignment$6() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(idConsumer, "name", false, false, getRule().ele00010LexerRuleCallID(), getRuleCall$7$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeGroup$8() throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$8();
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		marker.release();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$8() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeAction$9(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0010ActionC1x());
			marker.release();
			return result;
		}
		result = consumeKeyword$11(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0011KeywordX());
			marker.release();
			return result;
		}
		marker.release();
		return result;
	}
	protected int consumeAction$9() {
		consumeAction("C1", "x", false);
		return ConsumeResult.SUCCESS;	
	}

	protected int consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele0011KeywordX(), null, false, false, getKeyword$11$Delimiter());
	}

	protected int consumeGroup$12() throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$12();
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		marker.release();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$12() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeAction$13(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele010ActionC2y());
			marker.release();
			return result;
		}
		result = consumeKeyword$15(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele011KeywordY());
			marker.release();
			return result;
		}
		marker.release();
		return result;
	}
	protected int consumeAction$13() {
		consumeAction("C2", "y", false);
		return ConsumeResult.SUCCESS;	
	}

	protected int consumeKeyword$15() throws Exception {
		return consumeKeyword(getRule().ele011KeywordY(), null, false, false, getKeyword$15$Delimiter());
	}

	protected int consumeGroup$16() throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$16();
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		marker.release();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$16() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeAction$17(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele10ActionC3z());
			marker.release();
			return result;
		}
		result = consumeKeyword$19(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele11KeywordZ());
			marker.release();
			return result;
		}
		marker.release();
		return result;
	}
	protected int consumeAction$17() {
		consumeAction("C3", "z", false);
		return ConsumeResult.SUCCESS;	
	}

	protected int consumeKeyword$19() throws Exception {
		return consumeKeyword(getRule().ele11KeywordZ(), null, false, false, getKeyword$19$Delimiter());
	}

	public TrickyCElements getRule() {
		return ComplexReconstrTestLanguageGrammarAccess.INSTANCE.prTrickyC();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "TrickyC";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public ICharacterClass getKeyword$19$Delimiter() {
		return keyword$19$Delimiter;
	}
	
	public void setKeyword$19$Delimiter(ICharacterClass characterClass) {
		keyword$19$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$5$Delimiter() {
		return keyword$5$Delimiter;
	}
	
	public void setKeyword$5$Delimiter(ICharacterClass characterClass) {
		keyword$5$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$11$Delimiter() {
		return keyword$11$Delimiter;
	}
	
	public void setKeyword$11$Delimiter(ICharacterClass characterClass) {
		keyword$11$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$15$Delimiter() {
		return keyword$15$Delimiter;
	}
	
	public void setKeyword$15$Delimiter(ICharacterClass characterClass) {
		keyword$15$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$7$Delimiter() {
		return ruleCall$7$Delimiter;
	}
	
	public void setRuleCall$7$Delimiter(ISequenceMatcher matcher) {
		ruleCall$7$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

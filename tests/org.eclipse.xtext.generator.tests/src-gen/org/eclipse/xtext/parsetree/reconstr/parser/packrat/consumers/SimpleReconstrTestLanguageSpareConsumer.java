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

import org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestLanguageGrammarAccess;
import org.eclipse.xtext.parsetree.reconstr.services.SimpleReconstrTestLanguageGrammarAccess.SpareElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class SimpleReconstrTestLanguageSpareConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;

	private ICharacterClass keyword$3$Delimiter;
	
	private ICharacterClass keyword$7$Delimiter;
	
	private ISequenceMatcher ruleCall$5$Delimiter;
	
	private ISequenceMatcher ruleCall$9$Delimiter;
	
	public SimpleReconstrTestLanguageSpareConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$3$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$7$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$5$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$9$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected int doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected int consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$3(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00KeywordNumberSignDigitThree());
			marker.commit();
			return result;
		}
		result = consumeAssignment$4(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele01AssignmentId());
			marker.commit();
			return result;
		}
		result = consumeGroup$6(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1Group());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$3() throws Exception {
		return consumeKeyword(getRule().ele00KeywordNumberSignDigitThree(), null, false, false, getKeyword$3$Delimiter());
	}

	protected int consumeAssignment$4() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(idConsumer, "id", true, false, getRule().ele010LexerRuleCallID(), getRuleCall$5$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeGroup$6() throws Exception {
		IMarker marker = mark();
		while(doConsumeGroup$6() == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$6() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$7(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele10KeywordFullStop());
			marker.commit();
			return result;
		}
		result = consumeAssignment$8(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele11AssignmentId());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$7() throws Exception {
		return consumeKeyword(getRule().ele10KeywordFullStop(), null, false, false, getKeyword$7$Delimiter());
	}

	protected int consumeAssignment$8() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(idConsumer, "id", true, false, getRule().ele110LexerRuleCallID(), getRuleCall$9$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	public SpareElements getRule() {
		return SimpleReconstrTestLanguageGrammarAccess.INSTANCE.prSpare();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Spare";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public ICharacterClass getKeyword$3$Delimiter() {
		return keyword$3$Delimiter;
	}
	
	public void setKeyword$3$Delimiter(ICharacterClass characterClass) {
		keyword$3$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$7$Delimiter() {
		return keyword$7$Delimiter;
	}
	
	public void setKeyword$7$Delimiter(ICharacterClass characterClass) {
		keyword$7$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$5$Delimiter() {
		return ruleCall$5$Delimiter;
	}
	
	public void setRuleCall$5$Delimiter(ISequenceMatcher matcher) {
		ruleCall$5$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$9$Delimiter() {
		return ruleCall$9$Delimiter;
	}
	
	public void setRuleCall$9$Delimiter(ISequenceMatcher matcher) {
		ruleCall$9$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

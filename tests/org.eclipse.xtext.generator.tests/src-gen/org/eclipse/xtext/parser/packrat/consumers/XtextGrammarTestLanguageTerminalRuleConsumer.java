/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.packrat.consumers;

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

import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess;
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.TerminalRuleElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageTerminalAlternativesConsumer;
import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageTypeRefConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarTestLanguageTerminalRuleConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private XtextGrammarTestLanguageTerminalAlternativesConsumer terminalAlternativesConsumer;
	private XtextGrammarTestLanguageTypeRefConsumer typeRefConsumer;

	private ICharacterClass keyword$7$Delimiter;
	
	private ICharacterClass keyword$11$Delimiter;
	
	private ICharacterClass keyword$14$Delimiter;
	
	private ICharacterClass keyword$17$Delimiter;
	
	private ISequenceMatcher ruleCall$9$Delimiter;
	
	public XtextGrammarTestLanguageTerminalRuleConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$7$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$14$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$17$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$9$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected int doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected int consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeAssignment$6(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00000AssignmentTerminal());
			marker.commit();
			return result;
		}
		result = consumeAssignment$8(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00001AssignmentName());
			marker.commit();
			return result;
		}
		result = consumeGroup$10(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0001Group());
			marker.commit();
			return result;
		}
		result = consumeKeyword$14(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele001KeywordColon());
			marker.commit();
			return result;
		}
		result = consumeAssignment$15(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele01AssignmentAlternatives());
			marker.commit();
			return result;
		}
		result = consumeKeyword$17(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1KeywordSemicolon());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeAssignment$6() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeKeyword(getRule().ele000000KeywordTerminal(), "terminal", false, true, getKeyword$7$Delimiter()); 
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeAssignment$8() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(idConsumer, "name", false, false, getRule().ele000010LexerRuleCallID(), getRuleCall$9$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeGroup$10() throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$10();
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$10() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$11(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00010KeywordReturns());
			marker.commit();
			return result;
		}
		result = consumeAssignment$12(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00011AssignmentType());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele00010KeywordReturns(), null, false, false, getKeyword$11$Delimiter());
	}

	protected int consumeAssignment$12() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(typeRefConsumer, "type", false, false, getRule().ele000110ParserRuleCallTypeRef());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeKeyword$14() throws Exception {
		return consumeKeyword(getRule().ele001KeywordColon(), null, false, false, getKeyword$14$Delimiter());
	}

	protected int consumeAssignment$15() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(terminalAlternativesConsumer, "alternatives", false, false, getRule().ele010ParserRuleCallTerminalAlternatives());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeKeyword$17() throws Exception {
		return consumeKeyword(getRule().ele1KeywordSemicolon(), null, false, false, getKeyword$17$Delimiter());
	}

	public TerminalRuleElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prTerminalRule();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "ParserRule";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setTerminalAlternativesConsumer(XtextGrammarTestLanguageTerminalAlternativesConsumer terminalAlternativesConsumer) {
		this.terminalAlternativesConsumer = terminalAlternativesConsumer;
	}
	
	public void setTypeRefConsumer(XtextGrammarTestLanguageTypeRefConsumer typeRefConsumer) {
		this.typeRefConsumer = typeRefConsumer;
	}
	
	public ICharacterClass getKeyword$7$Delimiter() {
		return keyword$7$Delimiter;
	}
	
	public void setKeyword$7$Delimiter(ICharacterClass characterClass) {
		keyword$7$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$11$Delimiter() {
		return keyword$11$Delimiter;
	}
	
	public void setKeyword$11$Delimiter(ICharacterClass characterClass) {
		keyword$11$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$14$Delimiter() {
		return keyword$14$Delimiter;
	}
	
	public void setKeyword$14$Delimiter(ICharacterClass characterClass) {
		keyword$14$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$17$Delimiter() {
		return keyword$17$Delimiter;
	}
	
	public void setKeyword$17$Delimiter(ICharacterClass characterClass) {
		keyword$17$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$9$Delimiter() {
		return ruleCall$9$Delimiter;
	}
	
	public void setRuleCall$9$Delimiter(ISequenceMatcher matcher) {
		ruleCall$9$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

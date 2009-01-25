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
import org.eclipse.xtext.services.XtextGrammarTestLanguageGrammarAccess.TerminalTokenElements;

import org.eclipse.xtext.parser.packrat.consumers.XtextGrammarTestLanguageTerminalTokenElementConsumer;

@SuppressWarnings("unused")
public final class XtextGrammarTestLanguageTerminalTokenConsumer extends NonTerminalConsumer {

	private XtextGrammarTestLanguageTerminalTokenElementConsumer terminalTokenElementConsumer;

	private ICharacterClass keyword$6$Delimiter;
	
	private ICharacterClass keyword$7$Delimiter;
	
	private ICharacterClass keyword$8$Delimiter;
	
	public XtextGrammarTestLanguageTerminalTokenConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$6$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$7$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$8$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected int doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected int consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeRuleCall$2(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0ParserRuleCallTerminalTokenElement());
			marker.commit();
			return result;
		}
		result = consumeAssignment$3(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1AssignmentCardinality());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(terminalTokenElementConsumer, null, false, false, getRule().ele0ParserRuleCallTerminalTokenElement());
	}

	protected int consumeAssignment$3() throws Exception {
		IMarker marker = mark();
		int result = doConsumeAssignment$3();
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$3() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeKeyword(getRule().ele1000KeywordQuestionMark(), "cardinality", false, false, getKeyword$6$Delimiter()); 
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		tempResult = consumeKeyword(getRule().ele1001KeywordAsterisk(), "cardinality", false, false, getKeyword$7$Delimiter()); 
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		tempResult = consumeKeyword(getRule().ele101KeywordPlusSign(), "cardinality", false, false, getKeyword$8$Delimiter()); 
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	public TerminalTokenElements getRule() {
		return XtextGrammarTestLanguageGrammarAccess.INSTANCE.prTerminalToken();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setTerminalTokenElementConsumer(XtextGrammarTestLanguageTerminalTokenElementConsumer terminalTokenElementConsumer) {
		this.terminalTokenElementConsumer = terminalTokenElementConsumer;
	}
	
	public ICharacterClass getKeyword$6$Delimiter() {
		return keyword$6$Delimiter;
	}
	
	public void setKeyword$6$Delimiter(ICharacterClass characterClass) {
		keyword$6$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$7$Delimiter() {
		return keyword$7$Delimiter;
	}
	
	public void setKeyword$7$Delimiter(ICharacterClass characterClass) {
		keyword$7$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$8$Delimiter() {
		return keyword$8$Delimiter;
	}
	
	public void setKeyword$8$Delimiter(ICharacterClass characterClass) {
		keyword$8$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}

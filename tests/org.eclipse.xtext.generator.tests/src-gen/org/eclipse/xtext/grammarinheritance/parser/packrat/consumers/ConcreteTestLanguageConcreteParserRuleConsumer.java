/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.parser.packrat.consumers;

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

import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess;
import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess.ConcreteParserRuleElements;

import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageInheritedParserRuleConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageREALConsumer;

@SuppressWarnings("unused")
public final class ConcreteTestLanguageConcreteParserRuleConsumer extends NonTerminalConsumer {

	private AbstractTestLanguageInheritedParserRuleConsumer inheritedParserRuleConsumer;
	private AbstractTestLanguageREALConsumer realConsumer;

	private ICharacterClass keyword$4$Delimiter;
	
	private ICharacterClass keyword$7$Delimiter;
	
	private ISequenceMatcher ruleCall$6$Delimiter;
	
	public ConcreteTestLanguageConcreteParserRuleConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$4$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$7$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$6$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected int doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected int consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$4(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele000KeywordModel());
			marker.commit();
			return result;
		}
		result = consumeAssignment$5(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele001AssignmentMagicNumber());
			marker.commit();
			return result;
		}
		result = consumeKeyword$7(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele01KeywordColon());
			marker.commit();
			return result;
		}
		result = consumeAssignment$8(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1AssignmentElements());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$4() throws Exception {
		return consumeKeyword(getRule().ele000KeywordModel(), null, false, false, getKeyword$4$Delimiter());
	}

	protected int consumeAssignment$5() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(realConsumer, "magicNumber", false, false, getRule().ele0010LexerRuleCallREAL(), getRuleCall$6$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeKeyword$7() throws Exception {
		return consumeKeyword(getRule().ele01KeywordColon(), null, false, false, getKeyword$7$Delimiter());
	}

	protected int consumeAssignment$8() throws Exception {
		IMarker marker = mark();
		while(doConsumeAssignment$8() == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$8() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(inheritedParserRuleConsumer, "elements", true, false, getRule().ele10ParserRuleCallInheritedParserRule());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	public ConcreteParserRuleElements getRule() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prConcreteParserRule();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "ConcreteParserRule";
	}
	
	public void setInheritedParserRuleConsumer(AbstractTestLanguageInheritedParserRuleConsumer inheritedParserRuleConsumer) {
		this.inheritedParserRuleConsumer = inheritedParserRuleConsumer;
	}
	
	public void setRealConsumer(AbstractTestLanguageREALConsumer realConsumer) {
		this.realConsumer = realConsumer;
	}
	
	public ICharacterClass getKeyword$4$Delimiter() {
		return keyword$4$Delimiter;
	}
	
	public void setKeyword$4$Delimiter(ICharacterClass characterClass) {
		keyword$4$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$7$Delimiter() {
		return keyword$7$Delimiter;
	}
	
	public void setKeyword$7$Delimiter(ICharacterClass characterClass) {
		keyword$7$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$6$Delimiter() {
		return ruleCall$6$Delimiter;
	}
	
	public void setRuleCall$6$Delimiter(ISequenceMatcher matcher) {
		ruleCall$6$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess;
import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess.CallOverridenParserRuleElements;

import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageAbstractCallOverridenParserRuleConsumer;

@SuppressWarnings("unused")
public final class ConcreteTestLanguageCallOverridenParserRuleConsumer extends NonTerminalConsumer {

	private INonTerminalConsumer abstractCallOverridenParserRuleConsumer;

	public ConcreteTestLanguageCallOverridenParserRuleConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
	@Override
	protected int doConsume(int entryPoint) throws Exception {
		return consumeAssignment$1(entryPoint);
	}

	protected int consumeAssignment$1(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeNonTerminal(abstractCallOverridenParserRuleConsumer, "call", false, false, false, getRule().ele0ParserRuleCallAbstractCallOverridenParserRule());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	public CallOverridenParserRuleElements getRule() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prCallOverridenParserRule();
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "CallOverridenParserRule";
	}
	
	public void setAbstractCallOverridenParserRuleConsumer(INonTerminalConsumer abstractCallOverridenParserRuleConsumer) {
		this.abstractCallOverridenParserRuleConsumer = abstractCallOverridenParserRuleConsumer;
	}
	
}

/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess;
import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess.RootRuleElements;

import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.ConcreteTestLanguageConcreteParserRuleConsumer;

@SuppressWarnings("unused")
public final class ConcreteTestLanguageRootRuleConsumer extends NonTerminalConsumer {

	private ConcreteTestLanguageConcreteParserRuleConsumer concreteParserRuleConsumer;

	public ConcreteTestLanguageRootRuleConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
	@Override
	protected int doConsume(int entryPoint) throws Exception {
		return consumeRuleCall$1(entryPoint);
	}

	protected int consumeRuleCall$1(int entryPoint) throws Exception {
		return consumeNonTerminal(concreteParserRuleConsumer, null, false, false, false, getRule().eleParserRuleCallConcreteParserRule());
	}

	public RootRuleElements getRule() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prRootRule();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "RootRule";
	}
	
	public void setConcreteParserRuleConsumer(ConcreteTestLanguageConcreteParserRuleConsumer concreteParserRuleConsumer) {
		this.concreteParserRuleConsumer = concreteParserRuleConsumer;
	}
	
}

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
import org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageGrammarAccess.RootRuleElements;

import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.ConcreteTestLanguageCallExtendedParserRuleConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.ConcreteTestLanguageCallOverridenParserRuleConsumer;
import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.ConcreteTestLanguageConcreteParserRuleConsumer;

@SuppressWarnings("unused")
public final class ConcreteTestLanguageRootRuleConsumer extends NonTerminalConsumer {

	private INonTerminalConsumer callExtendedParserRuleConsumer;
	private INonTerminalConsumer callOverridenParserRuleConsumer;
	private INonTerminalConsumer concreteParserRuleConsumer;

	public ConcreteTestLanguageRootRuleConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
	@Override
	protected int doConsume(int entryPoint) throws Exception {
		return consumeAlternatives$1(entryPoint);
	}

	protected int consumeAlternatives$1(int entryPoint) throws Exception {
		AlternativesResult result = createAlternativesResult();
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result.reset();
			case 0:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$3(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$4(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 2:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$5(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}

	protected int consumeRuleCall$3(int entryPoint) throws Exception {
		return consumeNonTerminal(concreteParserRuleConsumer, null, false, false, false, getRule().ele00ParserRuleCallConcreteParserRule());
	}

	protected int consumeRuleCall$4(int entryPoint) throws Exception {
		return consumeNonTerminal(callOverridenParserRuleConsumer, null, false, false, false, getRule().ele01ParserRuleCallCallOverridenParserRule());
	}

	protected int consumeRuleCall$5(int entryPoint) throws Exception {
		return consumeNonTerminal(callExtendedParserRuleConsumer, null, false, false, false, getRule().ele1ParserRuleCallCallExtendedParserRule());
	}

	public RootRuleElements getRule() {
		return ConcreteTestLanguageGrammarAccess.INSTANCE.prRootRule();
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "RootRule";
	}
	
	public void setCallExtendedParserRuleConsumer(INonTerminalConsumer callExtendedParserRuleConsumer) {
		this.callExtendedParserRuleConsumer = callExtendedParserRuleConsumer;
	}
	
	public void setCallOverridenParserRuleConsumer(INonTerminalConsumer callOverridenParserRuleConsumer) {
		this.callOverridenParserRuleConsumer = callOverridenParserRuleConsumer;
	}
	
	public void setConcreteParserRuleConsumer(INonTerminalConsumer concreteParserRuleConsumer) {
		this.concreteParserRuleConsumer = concreteParserRuleConsumer;
	}
	
}

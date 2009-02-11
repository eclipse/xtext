/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.example.services.DomainmodelGrammarAccess;
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess.TypeElements;

import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelDataTypeConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelEntityConsumer;

@SuppressWarnings("unused")
public final class DomainmodelTypeConsumer extends NonTerminalConsumer {

	private INonTerminalConsumer dataTypeConsumer;
	private INonTerminalConsumer entityConsumer;

	public DomainmodelTypeConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
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
				if (result.isAlternativeDone(consumeRuleCall$2(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$3(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}

	protected int consumeRuleCall$2(int entryPoint) throws Exception {
		return consumeNonTerminal(entityConsumer, null, false, false, false, getRule().ele0ParserRuleCallEntity());
	}

	protected int consumeRuleCall$3(int entryPoint) throws Exception {
		return consumeNonTerminal(dataTypeConsumer, null, false, false, false, getRule().ele1ParserRuleCallDataType());
	}

	public TypeElements getRule() {
		return DomainmodelGrammarAccess.INSTANCE.prType();
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Type";
	}
	
	public void setDataTypeConsumer(INonTerminalConsumer dataTypeConsumer) {
		this.dataTypeConsumer = dataTypeConsumer;
	}
	
	public void setEntityConsumer(INonTerminalConsumer entityConsumer) {
		this.entityConsumer = entityConsumer;
	}
	
}

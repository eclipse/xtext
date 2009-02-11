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
import org.eclipse.xtext.example.services.DomainmodelGrammarAccess.NamedElementElements;

import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelPackageConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.DomainmodelTypeConsumer;

@SuppressWarnings("unused")
public final class DomainmodelNamedElementConsumer extends NonTerminalConsumer {

	private INonTerminalConsumer packageConsumer;
	private INonTerminalConsumer typeConsumer;

	public DomainmodelNamedElementConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
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
		return consumeNonTerminal(packageConsumer, null, false, false, false, getRule().ele0ParserRuleCallPackage());
	}

	protected int consumeRuleCall$3(int entryPoint) throws Exception {
		return consumeNonTerminal(typeConsumer, null, false, false, false, getRule().ele1ParserRuleCallType());
	}

	public NamedElementElements getRule() {
		return DomainmodelGrammarAccess.INSTANCE.prNamedElement();
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "NamedElement";
	}
	
	public void setPackageConsumer(INonTerminalConsumer packageConsumer) {
		this.packageConsumer = packageConsumer;
	}
	
	public void setTypeConsumer(INonTerminalConsumer typeConsumer) {
		this.typeConsumer = typeConsumer;
	}
	
}

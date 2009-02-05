/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.example.services.EcoreDslGrammarAccess;
import org.eclipse.xtext.example.services.EcoreDslGrammarAccess.EClassifierDeclElements;

import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEClassDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEDataTypeDeclConsumer;

@SuppressWarnings("unused")
public final class EcoreDslEClassifierDeclConsumer extends NonTerminalConsumer {

	private EcoreDslEClassDeclConsumer eClassDeclConsumer;
	private EcoreDslEDataTypeDeclConsumer eDataTypeDeclConsumer;

	public EcoreDslEClassifierDeclConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
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
		return consumeNonTerminal(eClassDeclConsumer, null, false, false, getRule().ele0ParserRuleCallEClassDecl());
	}

	protected int consumeRuleCall$3(int entryPoint) throws Exception {
		return consumeNonTerminal(eDataTypeDeclConsumer, null, false, false, getRule().ele1ParserRuleCallEDataTypeDecl());
	}

	public EClassifierDeclElements getRule() {
		return EcoreDslGrammarAccess.INSTANCE.prEClassifierDecl();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "EClassifier";
	}
	
	public void setEClassDeclConsumer(EcoreDslEClassDeclConsumer eClassDeclConsumer) {
		this.eClassDeclConsumer = eClassDeclConsumer;
	}
	
	public void setEDataTypeDeclConsumer(EcoreDslEDataTypeDeclConsumer eDataTypeDeclConsumer) {
		this.eDataTypeDeclConsumer = eDataTypeDeclConsumer;
	}
	
}

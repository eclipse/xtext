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
import org.eclipse.xtext.example.services.EcoreDslGrammarAccess.EStructuralFeatureDeclElements;

import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEAttributeDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEReferenceDeclConsumer;

@SuppressWarnings("unused")
public final class EcoreDslEStructuralFeatureDeclConsumer extends NonTerminalConsumer {

	private EcoreDslEAttributeDeclConsumer eAttributeDeclConsumer;
	private EcoreDslEReferenceDeclConsumer eReferenceDeclConsumer;

	public EcoreDslEStructuralFeatureDeclConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
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
		return consumeNonTerminal(eAttributeDeclConsumer, null, false, false, false, getRule().ele0ParserRuleCallEAttributeDecl());
	}

	protected int consumeRuleCall$3(int entryPoint) throws Exception {
		return consumeNonTerminal(eReferenceDeclConsumer, null, false, false, false, getRule().ele1ParserRuleCallEReferenceDecl());
	}

	public EStructuralFeatureDeclElements getRule() {
		return EcoreDslGrammarAccess.INSTANCE.prEStructuralFeatureDecl();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "EStructuralFeature";
	}
	
	public void setEAttributeDeclConsumer(EcoreDslEAttributeDeclConsumer eAttributeDeclConsumer) {
		this.eAttributeDeclConsumer = eAttributeDeclConsumer;
	}
	
	public void setEReferenceDeclConsumer(EcoreDslEReferenceDeclConsumer eReferenceDeclConsumer) {
		this.eReferenceDeclConsumer = eReferenceDeclConsumer;
	}
	
}

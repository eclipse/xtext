/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.epatch.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess.ModelImportElements;

import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageEPackageImportConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageResourceImportConsumer;

@SuppressWarnings("unused")
public final class EpatchTestLanguageModelImportConsumer extends NonTerminalConsumer {

	private INonTerminalConsumer ePackageImportConsumer;
	private INonTerminalConsumer resourceImportConsumer;

	public EpatchTestLanguageModelImportConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
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
		return consumeNonTerminal(resourceImportConsumer, null, false, false, false, getRule().ele0ParserRuleCallResourceImport());
	}

	protected int consumeRuleCall$3(int entryPoint) throws Exception {
		return consumeNonTerminal(ePackageImportConsumer, null, false, false, false, getRule().ele1ParserRuleCallEPackageImport());
	}

	public ModelImportElements getRule() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prModelImport();
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "ModelImport";
	}
	
	public void setEPackageImportConsumer(INonTerminalConsumer ePackageImportConsumer) {
		this.ePackageImportConsumer = ePackageImportConsumer;
	}
	
	public void setResourceImportConsumer(INonTerminalConsumer resourceImportConsumer) {
		this.resourceImportConsumer = resourceImportConsumer;
	}
	
}

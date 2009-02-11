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
import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess.ImportElements;

import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageExtensionImportConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageJavaImportConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageModelImportConsumer;

@SuppressWarnings("unused")
public final class EpatchTestLanguageImportConsumer extends NonTerminalConsumer {

	private INonTerminalConsumer extensionImportConsumer;
	private INonTerminalConsumer javaImportConsumer;
	private INonTerminalConsumer modelImportConsumer;

	public EpatchTestLanguageImportConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
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
		return consumeNonTerminal(modelImportConsumer, null, false, false, false, getRule().ele00ParserRuleCallModelImport());
	}

	protected int consumeRuleCall$4(int entryPoint) throws Exception {
		return consumeNonTerminal(javaImportConsumer, null, false, false, false, getRule().ele01ParserRuleCallJavaImport());
	}

	protected int consumeRuleCall$5(int entryPoint) throws Exception {
		return consumeNonTerminal(extensionImportConsumer, null, false, false, false, getRule().ele1ParserRuleCallExtensionImport());
	}

	public ImportElements getRule() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prImport();
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Import";
	}
	
	public void setExtensionImportConsumer(INonTerminalConsumer extensionImportConsumer) {
		this.extensionImportConsumer = extensionImportConsumer;
	}
	
	public void setJavaImportConsumer(INonTerminalConsumer javaImportConsumer) {
		this.javaImportConsumer = javaImportConsumer;
	}
	
	public void setModelImportConsumer(INonTerminalConsumer modelImportConsumer) {
		this.modelImportConsumer = modelImportConsumer;
	}
	
}

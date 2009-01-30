/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.epatch.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
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

	private EpatchTestLanguageExtensionImportConsumer extensionImportConsumer;
	private EpatchTestLanguageJavaImportConsumer javaImportConsumer;
	private EpatchTestLanguageModelImportConsumer modelImportConsumer;

	public EpatchTestLanguageImportConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
	protected int doConsume(int entryPoint) throws Exception {
		return consumeAlternatives$1(entryPoint);
	}

	protected int consumeAlternatives$1(int entryPoint) throws Exception {
		announceNextLevel();
		int result = ConsumeResult.SUCCESS;
		IMarker bestMarker = mark();
		IMarker currentMarker;
		int tempResult;
		switch(entryPoint) {
			case -1: // use fallthrough semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextPath();
				currentMarker = bestMarker.fork();
				tempResult = consumeRuleCall$3(nextEntryPoint()); 
				if (tempResult == ConsumeResult.SUCCESS) {
					bestMarker = currentMarker.join(bestMarker);
					bestMarker.commit();
					announceLevelFinished();
					return tempResult;
				}
				if (tempResult > result) {
					bestMarker = currentMarker.join(bestMarker);
					result = tempResult;
				} else {
					bestMarker = bestMarker.join(currentMarker);
				}
				currentMarker = null;
			case 1:
				announceNextPath();
				currentMarker = bestMarker.fork();
				tempResult = consumeRuleCall$4(nextEntryPoint()); 
				if (tempResult == ConsumeResult.SUCCESS) {
					bestMarker = currentMarker.join(bestMarker);
					bestMarker.commit();
					announceLevelFinished();
					return tempResult;
				}
				if (tempResult > result) {
					bestMarker = currentMarker.join(bestMarker);
					result = tempResult;
				} else {
					bestMarker = bestMarker.join(currentMarker);
				}
				currentMarker = null;
			case 2:
				announceNextPath();
				currentMarker = bestMarker.fork();
				tempResult = consumeRuleCall$5(nextEntryPoint()); 
				if (tempResult == ConsumeResult.SUCCESS) {
					bestMarker = currentMarker.join(bestMarker);
					bestMarker.commit();
					announceLevelFinished();
					return tempResult;
				}
				if (tempResult > result) {
					bestMarker = currentMarker.join(bestMarker);
					result = tempResult;
				} else {
					bestMarker = bestMarker.join(currentMarker);
				}
				currentMarker = null;
		}
		bestMarker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeRuleCall$3(int entryPoint) throws Exception {
		return consumeNonTerminal(modelImportConsumer, null, false, false, getRule().ele00ParserRuleCallModelImport());
	}

	protected int consumeRuleCall$4(int entryPoint) throws Exception {
		return consumeNonTerminal(javaImportConsumer, null, false, false, getRule().ele01ParserRuleCallJavaImport());
	}

	protected int consumeRuleCall$5(int entryPoint) throws Exception {
		return consumeNonTerminal(extensionImportConsumer, null, false, false, getRule().ele1ParserRuleCallExtensionImport());
	}

	public ImportElements getRule() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prImport();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Import";
	}
	
	public void setExtensionImportConsumer(EpatchTestLanguageExtensionImportConsumer extensionImportConsumer) {
		this.extensionImportConsumer = extensionImportConsumer;
	}
	
	public void setJavaImportConsumer(EpatchTestLanguageJavaImportConsumer javaImportConsumer) {
		this.javaImportConsumer = javaImportConsumer;
	}
	
	public void setModelImportConsumer(EpatchTestLanguageModelImportConsumer modelImportConsumer) {
		this.modelImportConsumer = modelImportConsumer;
	}
	
}

/*
Generated with Xtext
*/
package org.eclipse.xtext.crossrefs.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.crossrefs.services.ImportUriTestLanguageGrammarAccess;
import org.eclipse.xtext.crossrefs.services.ImportUriTestLanguageGrammarAccess.MainElements;

import org.eclipse.xtext.crossrefs.parser.packrat.consumers.ImportUriTestLanguageImportConsumer;
import org.eclipse.xtext.crossrefs.parser.packrat.consumers.ImportUriTestLanguageTypeConsumer;

@SuppressWarnings("unused")
public final class ImportUriTestLanguageMainConsumer extends NonTerminalConsumer {

	private INonTerminalConsumer importConsumer;
	private INonTerminalConsumer typeConsumer;

	public ImportUriTestLanguageMainConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
	@Override
	protected int doConsume(int entryPoint) throws Exception {
		return consumeGroup$1(entryPoint);
	}

	protected int consumeGroup$1(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeAssignment$2(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0AssignmentImports());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$4(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1AssignmentTypes());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$2(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeAssignment$2(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$2(int entryPoint) throws Exception {
		return consumeRuleCall$3(entryPoint);
	}

	protected int consumeRuleCall$3(int entryPoint) throws Exception {
		return consumeNonTerminal(importConsumer, "imports", true, false, false, getRule().ele00ParserRuleCallImport());
	}

	protected int consumeAssignment$4(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeAssignment$4(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$4(int entryPoint) throws Exception {
		return consumeRuleCall$5(entryPoint);
	}

	protected int consumeRuleCall$5(int entryPoint) throws Exception {
		return consumeNonTerminal(typeConsumer, "types", true, false, false, getRule().ele10ParserRuleCallType());
	}

	public MainElements getRule() {
		return ImportUriTestLanguageGrammarAccess.INSTANCE.prMain();
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Main";
	}
	
	public void setImportConsumer(INonTerminalConsumer importConsumer) {
		this.importConsumer = importConsumer;
	}
	
	public void setTypeConsumer(INonTerminalConsumer typeConsumer) {
		this.typeConsumer = typeConsumer;
	}
	
}

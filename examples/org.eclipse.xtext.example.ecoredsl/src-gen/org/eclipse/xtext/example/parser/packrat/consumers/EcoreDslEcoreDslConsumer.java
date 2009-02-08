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
import org.eclipse.xtext.example.services.EcoreDslGrammarAccess.EcoreDslElements;

import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEPackageDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslImportStatementDeclConsumer;

@SuppressWarnings("unused")
public final class EcoreDslEcoreDslConsumer extends NonTerminalConsumer {

	private EcoreDslEPackageDeclConsumer ePackageDeclConsumer;
	private EcoreDslImportStatementDeclConsumer importStatementDeclConsumer;

	public EcoreDslEcoreDslConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
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
					error("Another token expected.", getRule().ele1AssignmentPackage());
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
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeNonTerminal(importStatementDeclConsumer, "imports", true, false, false, getRule().ele00ParserRuleCallImportStatementDecl());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$4(int entryPoint) throws Exception {
		int result = ConsumeResult.EMPTY_MATCH;
		int tempResult;
		announceNextLevel();
		tempResult = consumeNonTerminal(ePackageDeclConsumer, "package", false, false, false, getRule().ele10ParserRuleCallEPackageDecl());
		if (tempResult == ConsumeResult.SUCCESS) {
			announceLevelFinished();
			return tempResult;
		}
		result = tempResult >= result ? tempResult : result; 
		announceLevelFinished();
		return result;
	}

	public EcoreDslElements getRule() {
		return EcoreDslGrammarAccess.INSTANCE.prEcoreDsl();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "EcoreDsl";
	}
	
	public void setEPackageDeclConsumer(EcoreDslEPackageDeclConsumer ePackageDeclConsumer) {
		this.ePackageDeclConsumer = ePackageDeclConsumer;
	}
	
	public void setImportStatementDeclConsumer(EcoreDslImportStatementDeclConsumer importStatementDeclConsumer) {
		this.importStatementDeclConsumer = importStatementDeclConsumer;
	}
	
}

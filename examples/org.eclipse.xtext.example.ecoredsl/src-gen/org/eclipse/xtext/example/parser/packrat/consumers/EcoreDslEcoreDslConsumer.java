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

import org.eclipse.xtext.example.services.EcoreDslGrammarAccess;
import org.eclipse.xtext.example.services.EcoreDslGrammarAccess.EcoreDslElements;

import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEPackageDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslImportStatementDeclConsumer;

@SuppressWarnings("unused")
public final class EcoreDslEcoreDslConsumer extends NonTerminalConsumer {

	private EcoreDslElements rule;
	
	private INonTerminalConsumer ePackageDeclConsumer;
	private INonTerminalConsumer importStatementDeclConsumer;

	public EcoreDslEcoreDslConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
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
		return consumeRuleCall$3(entryPoint);
	}

	protected int consumeRuleCall$3(int entryPoint) throws Exception {
		return consumeNonTerminal(importStatementDeclConsumer, "imports", true, false, false, getRule().ele00ParserRuleCallImportStatementDecl());
	}

	protected int consumeAssignment$4(int entryPoint) throws Exception {
		return consumeRuleCall$5(entryPoint);
	}

	protected int consumeRuleCall$5(int entryPoint) throws Exception {
		return consumeNonTerminal(ePackageDeclConsumer, "package", false, false, false, getRule().ele10ParserRuleCallEPackageDecl());
	}

	public EcoreDslElements getRule() {
	// EcoreDslGrammarAccess.INSTANCE.prEcoreDsl()
		return rule;
	}
	
	public void setRule(EcoreDslElements rule) {
		this.rule = rule;
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "EcoreDsl";
	}
	
	public void setEPackageDeclConsumer(INonTerminalConsumer ePackageDeclConsumer) {
		this.ePackageDeclConsumer = ePackageDeclConsumer;
	}
	
	public void setImportStatementDeclConsumer(INonTerminalConsumer importStatementDeclConsumer) {
		this.importStatementDeclConsumer = importStatementDeclConsumer;
	}
	
}

/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat.consumers;

import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;

import org.eclipse.xtext.AbstractRule;

import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.example.services.EcoreDslGrammarAccess.SubEPackageDeclElements;

import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEAnnotationDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEClassifierDeclConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslSubEPackageDeclConsumer;

@SuppressWarnings("unused")
public final class EcoreDslSubEPackageDeclConsumer extends NonTerminalConsumer {

	private SubEPackageDeclElements rule;
	
	private INonTerminalConsumer eAnnotationDeclConsumer;
	private INonTerminalConsumer eClassifierDeclConsumer;
	private ITerminalConsumer idConsumer;
	private INonTerminalConsumer subEPackageDeclConsumer;

	private ICharacterClass keyword$8$Delimiter;
	
	private ICharacterClass keyword$11$Delimiter;
	
	private ICharacterClass keyword$17$Delimiter;
	
	private ISequenceMatcher ruleCall$10$Delimiter;
	
	public EcoreDslSubEPackageDeclConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		keyword$8$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$17$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$10$Delimiter = ISequenceMatcher.Factory.nullMatcher();
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
				result = consumeAssignment$6(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00000AssignmentEAnnotations());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeKeyword$8(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00001KeywordPackage());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeAssignment$9(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0001AssignmentName());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 3:
				announceNextStep();
				result = consumeKeyword$11(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele001KeywordLeftCurlyBracket());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 4:
				announceNextStep();
				result = consumeAlternatives$12(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele01Alternatives());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 5:
				announceNextStep();
				result = consumeKeyword$17(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1KeywordRightCurlyBracket());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$6(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeAssignment$6(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$6(int entryPoint) throws Exception {
		return consumeRuleCall$7(entryPoint);
	}

	protected int consumeRuleCall$7(int entryPoint) throws Exception {
		return consumeNonTerminal(eAnnotationDeclConsumer, "eAnnotations", true, false, false, getRule().ele000000ParserRuleCallEAnnotationDecl());
	}

	protected int consumeKeyword$8(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele00001KeywordPackage(), null, false, false, getKeyword$8$Delimiter());
	}

	protected int consumeAssignment$9(int entryPoint) throws Exception {
		return consumeRuleCall$10(entryPoint);
	}

	protected int consumeRuleCall$10(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, "name", false, false, getRule().ele00010LexerRuleCallID(), getRuleCall$10$Delimiter());
	}

	protected int consumeKeyword$11(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele001KeywordLeftCurlyBracket(), null, false, false, getKeyword$11$Delimiter());
	}

	protected int consumeAlternatives$12(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeAlternatives$12(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAlternatives$12(int entryPoint) throws Exception {
		AlternativesResult result = createAlternativesResult();
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result.reset();
			case 0:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeAssignment$13(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeAssignment$15(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}

	protected int consumeAssignment$13(int entryPoint) throws Exception {
		return consumeRuleCall$14(entryPoint);
	}

	protected int consumeRuleCall$14(int entryPoint) throws Exception {
		return consumeNonTerminal(subEPackageDeclConsumer, "eSubpackages", true, false, false, getRule().ele0100ParserRuleCallSubEPackageDecl());
	}

	protected int consumeAssignment$15(int entryPoint) throws Exception {
		return consumeRuleCall$16(entryPoint);
	}

	protected int consumeRuleCall$16(int entryPoint) throws Exception {
		return consumeNonTerminal(eClassifierDeclConsumer, "eClassifiers", true, false, false, getRule().ele0110ParserRuleCallEClassifierDecl());
	}

	protected int consumeKeyword$17(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele1KeywordRightCurlyBracket(), null, false, false, getKeyword$17$Delimiter());
	}

	public SubEPackageDeclElements getRule() {
		return rule;
	}
	
	public void setRule(SubEPackageDeclElements rule) {
		this.rule = rule;
	}
	
	@Override
	protected AbstractRule getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected EClassifier getDefaultType() {
		return getGrammarElement().getType().getType();
	}
	
	public void setEAnnotationDeclConsumer(INonTerminalConsumer eAnnotationDeclConsumer) {
		this.eAnnotationDeclConsumer = eAnnotationDeclConsumer;
	}
	
	public void setEClassifierDeclConsumer(INonTerminalConsumer eClassifierDeclConsumer) {
		this.eClassifierDeclConsumer = eClassifierDeclConsumer;
	}
	
	public void setIdConsumer(ITerminalConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setSubEPackageDeclConsumer(INonTerminalConsumer subEPackageDeclConsumer) {
		this.subEPackageDeclConsumer = subEPackageDeclConsumer;
	}
	
	public ICharacterClass getKeyword$8$Delimiter() {
		return keyword$8$Delimiter;
	}
	
	public void setKeyword$8$Delimiter(ICharacterClass characterClass) {
		keyword$8$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$11$Delimiter() {
		return keyword$11$Delimiter;
	}
	
	public void setKeyword$11$Delimiter(ICharacterClass characterClass) {
		keyword$11$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$17$Delimiter() {
		return keyword$17$Delimiter;
	}
	
	public void setKeyword$17$Delimiter(ICharacterClass characterClass) {
		keyword$17$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$10$Delimiter() {
		return ruleCall$10$Delimiter;
	}
	
	public void setRuleCall$10$Delimiter(ISequenceMatcher matcher) {
		ruleCall$10$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

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

import org.eclipse.xtext.example.services.EcoreDslGrammarAccess.EReferenceDeclElements;

import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEAnnotationDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEGenericTypeReferenceDeclConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslSINTConsumer;

@SuppressWarnings("unused")
public final class EcoreDslEReferenceDeclConsumer extends NonTerminalConsumer {

	private EReferenceDeclElements rule;
	
	private INonTerminalConsumer eAnnotationDeclConsumer;
	private INonTerminalConsumer eGenericTypeReferenceDeclConsumer;
	private ITerminalConsumer idConsumer;
	private ITerminalConsumer intConsumer;
	private INonTerminalConsumer sintConsumer;

	private ISequenceMatcher crossReference$53$Delimiter;
	
	private ICharacterClass keyword$18$Delimiter;
	
	private ICharacterClass keyword$20$Delimiter;
	
	private ICharacterClass keyword$22$Delimiter;
	
	private ICharacterClass keyword$24$Delimiter;
	
	private ICharacterClass keyword$26$Delimiter;
	
	private ICharacterClass keyword$28$Delimiter;
	
	private ICharacterClass keyword$30$Delimiter;
	
	private ICharacterClass keyword$32$Delimiter;
	
	private ICharacterClass keyword$35$Delimiter;
	
	private ICharacterClass keyword$36$Delimiter;
	
	private ICharacterClass keyword$42$Delimiter;
	
	private ICharacterClass keyword$46$Delimiter;
	
	private ICharacterClass keyword$49$Delimiter;
	
	private ICharacterClass keyword$51$Delimiter;
	
	private ICharacterClass keyword$57$Delimiter;
	
	private ISequenceMatcher ruleCall$44$Delimiter;
	
	private ISequenceMatcher ruleCall$56$Delimiter;
	
	public EcoreDslEReferenceDeclConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		crossReference$53$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$18$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$20$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$22$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$24$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$26$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$28$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$30$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$32$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$35$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$36$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$42$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$46$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$49$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$51$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$57$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$44$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$56$Delimiter = ISequenceMatcher.Factory.nullMatcher();
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
				result = consumeAssignment$8(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0000000AssignmentEAnnotations());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAlternatives$10(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0000001Alternatives());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeAlternatives$33(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele000001Alternatives());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 3:
				announceNextStep();
				result = consumeAssignment$37(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00001AssignmentEGenericType());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 4:
				announceNextStep();
				result = consumeGroup$39(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0001Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 5:
				announceNextStep();
				result = consumeGroup$50(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele001Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 6:
				announceNextStep();
				result = consumeAssignment$55(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele01AssignmentName());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 7:
				announceNextStep();
				result = consumeKeyword$57(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1KeywordSemicolon());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeAssignment$8(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeAssignment$8(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$8(int entryPoint) throws Exception {
		return consumeRuleCall$9(entryPoint);
	}

	protected int consumeRuleCall$9(int entryPoint) throws Exception {
		return consumeNonTerminal(eAnnotationDeclConsumer, "eAnnotations", true, false, false, getRule().ele00000000ParserRuleCallEAnnotationDecl());
	}

	protected int consumeAlternatives$10(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeAlternatives$10(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAlternatives$10(int entryPoint) throws Exception {
		AlternativesResult result = createAlternativesResult();
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result.reset();
			case 0:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeAssignment$17(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeAssignment$19(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 2:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeAssignment$21(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 3:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeAssignment$23(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 4:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeAssignment$25(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 5:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeAssignment$27(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 6:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeAssignment$29(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 7:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeAssignment$31(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}

	protected int consumeAssignment$17(int entryPoint) throws Exception {
		return consumeKeyword$18(entryPoint);
	}

	protected int consumeKeyword$18(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele000000100000000KeywordLocal(), "resolveProxies", false, true, getKeyword$18$Delimiter());
	}

	protected int consumeAssignment$19(int entryPoint) throws Exception {
		return consumeKeyword$20(entryPoint);
	}

	protected int consumeKeyword$20(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele000000100000010KeywordBag(), "unique", false, true, getKeyword$20$Delimiter());
	}

	protected int consumeAssignment$21(int entryPoint) throws Exception {
		return consumeKeyword$22(entryPoint);
	}

	protected int consumeKeyword$22(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele00000010000010KeywordRandom(), "ordered", false, true, getKeyword$22$Delimiter());
	}

	protected int consumeAssignment$23(int entryPoint) throws Exception {
		return consumeKeyword$24(entryPoint);
	}

	protected int consumeKeyword$24(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0000001000010KeywordReadonly(), "changeable", false, true, getKeyword$24$Delimiter());
	}

	protected int consumeAssignment$25(int entryPoint) throws Exception {
		return consumeKeyword$26(entryPoint);
	}

	protected int consumeKeyword$26(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele000000100010KeywordVolatile(), "volatile", false, true, getKeyword$26$Delimiter());
	}

	protected int consumeAssignment$27(int entryPoint) throws Exception {
		return consumeKeyword$28(entryPoint);
	}

	protected int consumeKeyword$28(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele00000010010KeywordTransient(), "transient", false, true, getKeyword$28$Delimiter());
	}

	protected int consumeAssignment$29(int entryPoint) throws Exception {
		return consumeKeyword$30(entryPoint);
	}

	protected int consumeKeyword$30(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0000001010KeywordUnsettable(), "unsettable", false, true, getKeyword$30$Delimiter());
	}

	protected int consumeAssignment$31(int entryPoint) throws Exception {
		return consumeKeyword$32(entryPoint);
	}

	protected int consumeKeyword$32(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele000000110KeywordDerived(), "derived", false, true, getKeyword$32$Delimiter());
	}

	protected int consumeAlternatives$33(int entryPoint) throws Exception {
		AlternativesResult result = createAlternativesResult();
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result.reset();
			case 0:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeAssignment$34(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeKeyword$36(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}

	protected int consumeAssignment$34(int entryPoint) throws Exception {
		return consumeKeyword$35(entryPoint);
	}

	protected int consumeKeyword$35(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele00000100KeywordVal(), "containment", false, true, getKeyword$35$Delimiter());
	}

	protected int consumeKeyword$36(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0000011KeywordRef(), null, false, false, getKeyword$36$Delimiter());
	}

	protected int consumeAssignment$37(int entryPoint) throws Exception {
		return consumeRuleCall$38(entryPoint);
	}

	protected int consumeRuleCall$38(int entryPoint) throws Exception {
		return consumeNonTerminal(eGenericTypeReferenceDeclConsumer, "eGenericType", false, false, false, getRule().ele000010ParserRuleCallEGenericTypeReferenceDecl());
	}

	protected int consumeGroup$39(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$39(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$39(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$42(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0001000KeywordLeftSquareBracket());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$43(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0001001AssignmentLowerBound());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeGroup$45(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele000101Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 3:
				announceNextStep();
				result = consumeKeyword$49(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00011KeywordRightSquareBracket());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$42(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0001000KeywordLeftSquareBracket(), null, false, false, getKeyword$42$Delimiter());
	}

	protected int consumeAssignment$43(int entryPoint) throws Exception {
		return consumeRuleCall$44(entryPoint);
	}

	protected int consumeRuleCall$44(int entryPoint) throws Exception {
		return consumeTerminal(intConsumer, "lowerBound", false, false, getRule().ele00010010LexerRuleCallINT(), getRuleCall$44$Delimiter());
	}

	protected int consumeGroup$45(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$45(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$45(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$46(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0001010KeywordFullStopFullStop());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$47(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0001011AssignmentUpperBound());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$46(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0001010KeywordFullStopFullStop(), null, false, false, getKeyword$46$Delimiter());
	}

	protected int consumeAssignment$47(int entryPoint) throws Exception {
		return consumeRuleCall$48(entryPoint);
	}

	protected int consumeRuleCall$48(int entryPoint) throws Exception {
		return consumeNonTerminal(sintConsumer, "upperBound", false, true, false, getRule().ele00010110ParserRuleCallSINT());
	}

	protected int consumeKeyword$49(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele00011KeywordRightSquareBracket(), null, false, false, getKeyword$49$Delimiter());
	}

	protected int consumeGroup$50(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$50(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$50(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$51(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0010KeywordNumberSign());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$52(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0011AssignmentEOpposite());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$51(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0010KeywordNumberSign(), null, false, false, getKeyword$51$Delimiter());
	}

	protected int consumeAssignment$52(int entryPoint) throws Exception {
		return consumeCrossReference$53(entryPoint);
	}

	protected int consumeCrossReference$53(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, "eOpposite", false, false, getRule().ele00110CrossReferenceEStringEReference(), getCrossReference$53$Delimiter());
	}

	protected int consumeAssignment$55(int entryPoint) throws Exception {
		return consumeRuleCall$56(entryPoint);
	}

	protected int consumeRuleCall$56(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, "name", false, false, getRule().ele010LexerRuleCallID(), getRuleCall$56$Delimiter());
	}

	protected int consumeKeyword$57(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele1KeywordSemicolon(), null, false, false, getKeyword$57$Delimiter());
	}

	public EReferenceDeclElements getRule() {
		return rule;
	}
	
	public void setRule(EReferenceDeclElements rule) {
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
	
	public void setEGenericTypeReferenceDeclConsumer(INonTerminalConsumer eGenericTypeReferenceDeclConsumer) {
		this.eGenericTypeReferenceDeclConsumer = eGenericTypeReferenceDeclConsumer;
	}
	
	public void setIdConsumer(ITerminalConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setIntConsumer(ITerminalConsumer intConsumer) {
		this.intConsumer = intConsumer;
	}
	
	public void setSintConsumer(INonTerminalConsumer sintConsumer) {
		this.sintConsumer = sintConsumer;
	}
	
	public ISequenceMatcher getCrossReference$53$Delimiter() {
		return crossReference$53$Delimiter;
	}
	
	public void setCrossReference$53$Delimiter(ISequenceMatcher matcher) {
		crossReference$53$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$18$Delimiter() {
		return keyword$18$Delimiter;
	}
	
	public void setKeyword$18$Delimiter(ICharacterClass characterClass) {
		keyword$18$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$20$Delimiter() {
		return keyword$20$Delimiter;
	}
	
	public void setKeyword$20$Delimiter(ICharacterClass characterClass) {
		keyword$20$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$22$Delimiter() {
		return keyword$22$Delimiter;
	}
	
	public void setKeyword$22$Delimiter(ICharacterClass characterClass) {
		keyword$22$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$24$Delimiter() {
		return keyword$24$Delimiter;
	}
	
	public void setKeyword$24$Delimiter(ICharacterClass characterClass) {
		keyword$24$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$26$Delimiter() {
		return keyword$26$Delimiter;
	}
	
	public void setKeyword$26$Delimiter(ICharacterClass characterClass) {
		keyword$26$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$28$Delimiter() {
		return keyword$28$Delimiter;
	}
	
	public void setKeyword$28$Delimiter(ICharacterClass characterClass) {
		keyword$28$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$30$Delimiter() {
		return keyword$30$Delimiter;
	}
	
	public void setKeyword$30$Delimiter(ICharacterClass characterClass) {
		keyword$30$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$32$Delimiter() {
		return keyword$32$Delimiter;
	}
	
	public void setKeyword$32$Delimiter(ICharacterClass characterClass) {
		keyword$32$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$35$Delimiter() {
		return keyword$35$Delimiter;
	}
	
	public void setKeyword$35$Delimiter(ICharacterClass characterClass) {
		keyword$35$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$36$Delimiter() {
		return keyword$36$Delimiter;
	}
	
	public void setKeyword$36$Delimiter(ICharacterClass characterClass) {
		keyword$36$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$42$Delimiter() {
		return keyword$42$Delimiter;
	}
	
	public void setKeyword$42$Delimiter(ICharacterClass characterClass) {
		keyword$42$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$46$Delimiter() {
		return keyword$46$Delimiter;
	}
	
	public void setKeyword$46$Delimiter(ICharacterClass characterClass) {
		keyword$46$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$49$Delimiter() {
		return keyword$49$Delimiter;
	}
	
	public void setKeyword$49$Delimiter(ICharacterClass characterClass) {
		keyword$49$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$51$Delimiter() {
		return keyword$51$Delimiter;
	}
	
	public void setKeyword$51$Delimiter(ICharacterClass characterClass) {
		keyword$51$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$57$Delimiter() {
		return keyword$57$Delimiter;
	}
	
	public void setKeyword$57$Delimiter(ICharacterClass characterClass) {
		keyword$57$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$44$Delimiter() {
		return ruleCall$44$Delimiter;
	}
	
	public void setRuleCall$44$Delimiter(ISequenceMatcher matcher) {
		ruleCall$44$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$56$Delimiter() {
		return ruleCall$56$Delimiter;
	}
	
	public void setRuleCall$56$Delimiter(ISequenceMatcher matcher) {
		ruleCall$56$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

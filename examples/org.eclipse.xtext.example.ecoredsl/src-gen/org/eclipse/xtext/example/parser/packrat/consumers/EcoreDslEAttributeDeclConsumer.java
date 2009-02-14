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
import org.eclipse.xtext.example.services.EcoreDslGrammarAccess.EAttributeDeclElements;

import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEAnnotationDeclConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEGenericTypeReferenceDeclConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinINTConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslSINTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;

@SuppressWarnings("unused")
public final class EcoreDslEAttributeDeclConsumer extends NonTerminalConsumer {

	private EAttributeDeclElements rule;
	
	private INonTerminalConsumer eAnnotationDeclConsumer;
	private INonTerminalConsumer eGenericTypeReferenceDeclConsumer;
	private ITerminalConsumer idConsumer;
	private ITerminalConsumer intConsumer;
	private INonTerminalConsumer sintConsumer;
	private ITerminalConsumer stringConsumer;

	private ICharacterClass keyword$18$Delimiter;
	
	private ICharacterClass keyword$20$Delimiter;
	
	private ICharacterClass keyword$22$Delimiter;
	
	private ICharacterClass keyword$24$Delimiter;
	
	private ICharacterClass keyword$26$Delimiter;
	
	private ICharacterClass keyword$28$Delimiter;
	
	private ICharacterClass keyword$30$Delimiter;
	
	private ICharacterClass keyword$32$Delimiter;
	
	private ICharacterClass keyword$33$Delimiter;
	
	private ICharacterClass keyword$39$Delimiter;
	
	private ICharacterClass keyword$43$Delimiter;
	
	private ICharacterClass keyword$46$Delimiter;
	
	private ICharacterClass keyword$50$Delimiter;
	
	private ICharacterClass keyword$53$Delimiter;
	
	private ISequenceMatcher ruleCall$41$Delimiter;
	
	private ISequenceMatcher ruleCall$48$Delimiter;
	
	private ISequenceMatcher ruleCall$52$Delimiter;
	
	public EcoreDslEAttributeDeclConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		keyword$18$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$20$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$22$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$24$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$26$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$28$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$30$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$32$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$33$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$39$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$43$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$46$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$50$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$53$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$41$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$48$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$52$Delimiter = ISequenceMatcher.Factory.nullMatcher();
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
				result = consumeKeyword$33(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele000001KeywordAttr());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 3:
				announceNextStep();
				result = consumeAssignment$34(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00001AssignmentEGenericType());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 4:
				announceNextStep();
				result = consumeGroup$36(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0001Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 5:
				announceNextStep();
				result = consumeAssignment$47(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele001AssignmentName());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 6:
				announceNextStep();
				result = consumeGroup$49(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele01Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 7:
				announceNextStep();
				result = consumeKeyword$53(nextEntryPoint());
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
		return consumeKeyword(getRule().ele000000100000000KeywordID(), "iD", false, true, getKeyword$18$Delimiter());
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

	protected int consumeKeyword$33(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele000001KeywordAttr(), null, false, false, getKeyword$33$Delimiter());
	}

	protected int consumeAssignment$34(int entryPoint) throws Exception {
		return consumeRuleCall$35(entryPoint);
	}

	protected int consumeRuleCall$35(int entryPoint) throws Exception {
		return consumeNonTerminal(eGenericTypeReferenceDeclConsumer, "eGenericType", false, false, false, getRule().ele000010ParserRuleCallEGenericTypeReferenceDecl());
	}

	protected int consumeGroup$36(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$36(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$36(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$39(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0001000KeywordLeftSquareBracket());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$40(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0001001AssignmentLowerBound());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeGroup$42(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele000101Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 3:
				announceNextStep();
				result = consumeKeyword$46(nextEntryPoint());
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

	protected int consumeKeyword$39(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0001000KeywordLeftSquareBracket(), null, false, false, getKeyword$39$Delimiter());
	}

	protected int consumeAssignment$40(int entryPoint) throws Exception {
		return consumeRuleCall$41(entryPoint);
	}

	protected int consumeRuleCall$41(int entryPoint) throws Exception {
		return consumeTerminal(intConsumer, "lowerBound", false, false, getRule().ele00010010LexerRuleCallINT(), getRuleCall$41$Delimiter());
	}

	protected int consumeGroup$42(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$42(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$42(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$43(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0001010KeywordFullStopFullStop());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$44(nextEntryPoint());
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

	protected int consumeKeyword$43(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0001010KeywordFullStopFullStop(), null, false, false, getKeyword$43$Delimiter());
	}

	protected int consumeAssignment$44(int entryPoint) throws Exception {
		return consumeRuleCall$45(entryPoint);
	}

	protected int consumeRuleCall$45(int entryPoint) throws Exception {
		return consumeNonTerminal(sintConsumer, "upperBound", false, true, false, getRule().ele00010110ParserRuleCallSINT());
	}

	protected int consumeKeyword$46(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele00011KeywordRightSquareBracket(), null, false, false, getKeyword$46$Delimiter());
	}

	protected int consumeAssignment$47(int entryPoint) throws Exception {
		return consumeRuleCall$48(entryPoint);
	}

	protected int consumeRuleCall$48(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, "name", false, false, getRule().ele0010LexerRuleCallID(), getRuleCall$48$Delimiter());
	}

	protected int consumeGroup$49(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$49(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$49(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$50(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele010KeywordEqualsSign());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$51(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele011AssignmentDefaultValueLiteral());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$50(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele010KeywordEqualsSign(), null, false, false, getKeyword$50$Delimiter());
	}

	protected int consumeAssignment$51(int entryPoint) throws Exception {
		return consumeRuleCall$52(entryPoint);
	}

	protected int consumeRuleCall$52(int entryPoint) throws Exception {
		return consumeTerminal(stringConsumer, "defaultValueLiteral", false, false, getRule().ele0110LexerRuleCallSTRING(), getRuleCall$52$Delimiter());
	}

	protected int consumeKeyword$53(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele1KeywordSemicolon(), null, false, false, getKeyword$53$Delimiter());
	}

	public EAttributeDeclElements getRule() {
	// EcoreDslGrammarAccess.INSTANCE.prEAttributeDecl()
		return rule;
	}
	
	public void setRule(EAttributeDeclElements rule) {
		this.rule = rule;
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "EAttribute";
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
	
	public void setStringConsumer(ITerminalConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
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
	
	public ICharacterClass getKeyword$33$Delimiter() {
		return keyword$33$Delimiter;
	}
	
	public void setKeyword$33$Delimiter(ICharacterClass characterClass) {
		keyword$33$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$39$Delimiter() {
		return keyword$39$Delimiter;
	}
	
	public void setKeyword$39$Delimiter(ICharacterClass characterClass) {
		keyword$39$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$43$Delimiter() {
		return keyword$43$Delimiter;
	}
	
	public void setKeyword$43$Delimiter(ICharacterClass characterClass) {
		keyword$43$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$46$Delimiter() {
		return keyword$46$Delimiter;
	}
	
	public void setKeyword$46$Delimiter(ICharacterClass characterClass) {
		keyword$46$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$50$Delimiter() {
		return keyword$50$Delimiter;
	}
	
	public void setKeyword$50$Delimiter(ICharacterClass characterClass) {
		keyword$50$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$53$Delimiter() {
		return keyword$53$Delimiter;
	}
	
	public void setKeyword$53$Delimiter(ICharacterClass characterClass) {
		keyword$53$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$41$Delimiter() {
		return ruleCall$41$Delimiter;
	}
	
	public void setRuleCall$41$Delimiter(ISequenceMatcher matcher) {
		ruleCall$41$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$48$Delimiter() {
		return ruleCall$48$Delimiter;
	}
	
	public void setRuleCall$48$Delimiter(ISequenceMatcher matcher) {
		ruleCall$48$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$52$Delimiter() {
		return ruleCall$52$Delimiter;
	}
	
	public void setRuleCall$52$Delimiter(ISequenceMatcher matcher) {
		ruleCall$52$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

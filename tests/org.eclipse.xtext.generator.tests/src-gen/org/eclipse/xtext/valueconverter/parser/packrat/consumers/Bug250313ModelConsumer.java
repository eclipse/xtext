/*
Generated with Xtext
*/
package org.eclipse.xtext.valueconverter.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.valueconverter.services.Bug250313GrammarAccess;
import org.eclipse.xtext.valueconverter.services.Bug250313GrammarAccess.ModelElements;

import org.eclipse.xtext.valueconverter.parser.packrat.consumers.Bug250313ChildConsumer;
import org.eclipse.xtext.valueconverter.parser.packrat.consumers.Bug250313DatatypeConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.valueconverter.parser.packrat.consumers.Bug250313NestedDatatypeConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinSTRINGConsumer;

@SuppressWarnings("unused")
public final class Bug250313ModelConsumer extends NonTerminalConsumer {

	private INonTerminalConsumer childConsumer;
	private INonTerminalConsumer datatypeConsumer;
	private ITerminalConsumer idConsumer;
	private INonTerminalConsumer nestedDatatypeConsumer;
	private ITerminalConsumer stringConsumer;

	private ISequenceMatcher crossReference$66$Delimiter;
	
	private ISequenceMatcher crossReference$68$Delimiter;
	
	private ICharacterClass keyword$10$Delimiter;
	
	private ICharacterClass keyword$16$Delimiter;
	
	private ICharacterClass keyword$22$Delimiter;
	
	private ICharacterClass keyword$28$Delimiter;
	
	private ICharacterClass keyword$34$Delimiter;
	
	private ICharacterClass keyword$38$Delimiter;
	
	private ICharacterClass keyword$42$Delimiter;
	
	private ICharacterClass keyword$46$Delimiter;
	
	private ICharacterClass keyword$50$Delimiter;
	
	private ICharacterClass keyword$54$Delimiter;
	
	private ICharacterClass keyword$59$Delimiter;
	
	private ICharacterClass keyword$63$Delimiter;
	
	private ISequenceMatcher ruleCall$17$Delimiter;
	
	private ISequenceMatcher ruleCall$20$Delimiter;
	
	private ISequenceMatcher ruleCall$29$Delimiter;
	
	private ISequenceMatcher ruleCall$32$Delimiter;
	
	private ISequenceMatcher ruleCall$36$Delimiter;
	
	private ISequenceMatcher ruleCall$40$Delimiter;
	
	public Bug250313ModelConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		crossReference$66$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		crossReference$68$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$10$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$16$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$22$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$28$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$34$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$38$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$42$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$46$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$50$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$54$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$59$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$63$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$17$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$20$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$29$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$32$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$36$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$40$Delimiter = ISequenceMatcher.Factory.nullMatcher();
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
				if (result.isAlternativeDone(consumeGroup$9(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeGroup$21(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 2:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeGroup$33(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 3:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeGroup$37(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 4:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeGroup$41(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 5:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeGroup$45(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 6:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeGroup$49(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 7:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeGroup$53(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 8:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeGroup$57(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}

	protected int consumeGroup$9(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$10(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele000000000KeywordDigitOne());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$11(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele000000001AssignmentValue());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$10(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeKeyword$10(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeKeyword$10(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele000000000KeywordDigitOne(), null, false, false, getKeyword$10$Delimiter());
	}

	protected int consumeAssignment$11(int entryPoint) throws Exception {
		return consumeAlternatives$12(entryPoint);
	}
	protected int consumeAlternatives$12(int entryPoint) throws Exception {
		AlternativesResult result = createAlternativesResult();
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result.reset();
			case 0:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeKeyword$16(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$17(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 2:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$18(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 3:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$19(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 4:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$20(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}
	

	protected int consumeKeyword$16(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele00000000100000KeywordMykeyword1(), "value", false, false, getKeyword$16$Delimiter());
	}

	protected int consumeRuleCall$17(int entryPoint) throws Exception {
		return consumeTerminal(stringConsumer, "value", false, false, getRule().ele00000000100001LexerRuleCallSTRING(), getRuleCall$17$Delimiter());
	}

	protected int consumeRuleCall$18(int entryPoint) throws Exception {
		return consumeNonTerminal(nestedDatatypeConsumer, "value", false, true, false, getRule().ele0000000010001ParserRuleCallNestedDatatype());
	}

	protected int consumeRuleCall$19(int entryPoint) throws Exception {
		return consumeNonTerminal(datatypeConsumer, "value", false, true, false, getRule().ele000000001001ParserRuleCallDatatype());
	}

	protected int consumeRuleCall$20(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, "value", false, false, getRule().ele00000000101LexerRuleCallID(), getRuleCall$20$Delimiter());
	}

	protected int consumeGroup$21(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$22(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele000000010KeywordDigitOnePlusSign());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$23(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele000000011AssignmentMultiValue());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$22(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele000000010KeywordDigitOnePlusSign(), null, false, false, getKeyword$22$Delimiter());
	}

	protected int consumeAssignment$23(int entryPoint) throws Exception {
		return consumeAlternatives$24(entryPoint);
	}
	protected int consumeAlternatives$24(int entryPoint) throws Exception {
		AlternativesResult result = createAlternativesResult();
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result.reset();
			case 0:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeKeyword$28(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$29(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 2:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$30(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 3:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$31(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 4:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$32(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}
	

	protected int consumeKeyword$28(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele00000001100000KeywordMykeyword1(), "multiValue", true, false, getKeyword$28$Delimiter());
	}

	protected int consumeRuleCall$29(int entryPoint) throws Exception {
		return consumeTerminal(stringConsumer, "multiValue", true, false, getRule().ele00000001100001LexerRuleCallSTRING(), getRuleCall$29$Delimiter());
	}

	protected int consumeRuleCall$30(int entryPoint) throws Exception {
		return consumeNonTerminal(nestedDatatypeConsumer, "multiValue", true, true, false, getRule().ele0000000110001ParserRuleCallNestedDatatype());
	}

	protected int consumeRuleCall$31(int entryPoint) throws Exception {
		return consumeNonTerminal(datatypeConsumer, "multiValue", true, true, false, getRule().ele000000011001ParserRuleCallDatatype());
	}

	protected int consumeRuleCall$32(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, "multiValue", true, false, getRule().ele00000001101LexerRuleCallID(), getRuleCall$32$Delimiter());
	}

	protected int consumeGroup$33(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$34(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00000010KeywordDigitTwo());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$35(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00000011AssignmentValue());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$34(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele00000010KeywordDigitTwo(), null, false, false, getKeyword$34$Delimiter());
	}

	protected int consumeAssignment$35(int entryPoint) throws Exception {
		return consumeRuleCall$36(entryPoint);
	}

	protected int consumeRuleCall$36(int entryPoint) throws Exception {
		return consumeTerminal(stringConsumer, "value", false, false, getRule().ele000000110LexerRuleCallSTRING(), getRuleCall$36$Delimiter());
	}

	protected int consumeGroup$37(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$38(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0000010KeywordDigitTwoPlusSign());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$39(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0000011AssignmentMultiValue());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$38(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0000010KeywordDigitTwoPlusSign(), null, false, false, getKeyword$38$Delimiter());
	}

	protected int consumeAssignment$39(int entryPoint) throws Exception {
		return consumeRuleCall$40(entryPoint);
	}

	protected int consumeRuleCall$40(int entryPoint) throws Exception {
		return consumeTerminal(stringConsumer, "multiValue", true, false, getRule().ele00000110LexerRuleCallSTRING(), getRuleCall$40$Delimiter());
	}

	protected int consumeGroup$41(int entryPoint) throws Exception {
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
					error("Another token expected.", getRule().ele000010KeywordDigitThree());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$43(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele000011AssignmentValue());
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
		return consumeKeyword(getRule().ele000010KeywordDigitThree(), null, false, false, getKeyword$42$Delimiter());
	}

	protected int consumeAssignment$43(int entryPoint) throws Exception {
		return consumeRuleCall$44(entryPoint);
	}

	protected int consumeRuleCall$44(int entryPoint) throws Exception {
		return consumeNonTerminal(datatypeConsumer, "value", false, true, false, getRule().ele0000110ParserRuleCallDatatype());
	}

	protected int consumeGroup$45(int entryPoint) throws Exception {
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
					error("Another token expected.", getRule().ele00010KeywordDigitThreePlusSign());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$47(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele00011AssignmentMultiValue());
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
		return consumeKeyword(getRule().ele00010KeywordDigitThreePlusSign(), null, false, false, getKeyword$46$Delimiter());
	}

	protected int consumeAssignment$47(int entryPoint) throws Exception {
		return consumeRuleCall$48(entryPoint);
	}

	protected int consumeRuleCall$48(int entryPoint) throws Exception {
		return consumeNonTerminal(datatypeConsumer, "multiValue", true, true, false, getRule().ele000110ParserRuleCallDatatype());
	}

	protected int consumeGroup$49(int entryPoint) throws Exception {
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
					error("Another token expected.", getRule().ele0010KeywordDigitFour());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$51(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0011AssignmentValue());
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
		return consumeKeyword(getRule().ele0010KeywordDigitFour(), null, false, false, getKeyword$50$Delimiter());
	}

	protected int consumeAssignment$51(int entryPoint) throws Exception {
		return consumeRuleCall$52(entryPoint);
	}

	protected int consumeRuleCall$52(int entryPoint) throws Exception {
		return consumeNonTerminal(nestedDatatypeConsumer, "value", false, true, false, getRule().ele00110ParserRuleCallNestedDatatype());
	}

	protected int consumeGroup$53(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$54(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele010KeywordDigitFourPlusSign());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$55(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele011AssignmentMultiValue());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$54(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele010KeywordDigitFourPlusSign(), null, false, false, getKeyword$54$Delimiter());
	}

	protected int consumeAssignment$55(int entryPoint) throws Exception {
		return consumeRuleCall$56(entryPoint);
	}

	protected int consumeRuleCall$56(int entryPoint) throws Exception {
		return consumeNonTerminal(nestedDatatypeConsumer, "multiValue", true, true, false, getRule().ele0110ParserRuleCallNestedDatatype());
	}

	protected int consumeGroup$57(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$59(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele100KeywordContent());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$60(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele101AssignmentChildren());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 2:
				announceNextStep();
				result = consumeGroup$62(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele11Group());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$59(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele100KeywordContent(), null, false, false, getKeyword$59$Delimiter());
	}

	protected int consumeAssignment$60(int entryPoint) throws Exception {
		return consumeRuleCall$61(entryPoint);
	}

	protected int consumeRuleCall$61(int entryPoint) throws Exception {
		return consumeNonTerminal(childConsumer, "children", false, false, false, getRule().ele1010ParserRuleCallChild());
	}

	protected int consumeGroup$62(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$62(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$62(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$63(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele110KeywordRef());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$64(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele111AssignmentRef());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$63(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele110KeywordRef(), null, false, false, getKeyword$63$Delimiter());
	}

	protected int consumeAssignment$64(int entryPoint) throws Exception {
		return consumeAlternatives$65(entryPoint);
	}
	protected int consumeAlternatives$65(int entryPoint) throws Exception {
		AlternativesResult result = createAlternativesResult();
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result.reset();
			case 0:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeCrossReference$66(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeCrossReference$68(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}
	

	protected int consumeCrossReference$66(int entryPoint) throws Exception {
		return consumeTerminal(stringConsumer, "ref", false, false, getRule().ele11100CrossReferenceEStringChild1(), getCrossReference$66$Delimiter());
	}

	protected int consumeCrossReference$68(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, "ref", false, false, getRule().ele11101CrossReferenceEStringChild2(), getCrossReference$68$Delimiter());
	}

	public ModelElements getRule() {
		return Bug250313GrammarAccess.INSTANCE.prModel();
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Model";
	}
	
	public void setChildConsumer(INonTerminalConsumer childConsumer) {
		this.childConsumer = childConsumer;
	}
	
	public void setDatatypeConsumer(INonTerminalConsumer datatypeConsumer) {
		this.datatypeConsumer = datatypeConsumer;
	}
	
	public void setIdConsumer(ITerminalConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setNestedDatatypeConsumer(INonTerminalConsumer nestedDatatypeConsumer) {
		this.nestedDatatypeConsumer = nestedDatatypeConsumer;
	}
	
	public void setStringConsumer(ITerminalConsumer stringConsumer) {
		this.stringConsumer = stringConsumer;
	}
	
	public ISequenceMatcher getCrossReference$66$Delimiter() {
		return crossReference$66$Delimiter;
	}
	
	public void setCrossReference$66$Delimiter(ISequenceMatcher matcher) {
		crossReference$66$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getCrossReference$68$Delimiter() {
		return crossReference$68$Delimiter;
	}
	
	public void setCrossReference$68$Delimiter(ISequenceMatcher matcher) {
		crossReference$68$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$10$Delimiter() {
		return keyword$10$Delimiter;
	}
	
	public void setKeyword$10$Delimiter(ICharacterClass characterClass) {
		keyword$10$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$16$Delimiter() {
		return keyword$16$Delimiter;
	}
	
	public void setKeyword$16$Delimiter(ICharacterClass characterClass) {
		keyword$16$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$22$Delimiter() {
		return keyword$22$Delimiter;
	}
	
	public void setKeyword$22$Delimiter(ICharacterClass characterClass) {
		keyword$22$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$28$Delimiter() {
		return keyword$28$Delimiter;
	}
	
	public void setKeyword$28$Delimiter(ICharacterClass characterClass) {
		keyword$28$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$34$Delimiter() {
		return keyword$34$Delimiter;
	}
	
	public void setKeyword$34$Delimiter(ICharacterClass characterClass) {
		keyword$34$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$38$Delimiter() {
		return keyword$38$Delimiter;
	}
	
	public void setKeyword$38$Delimiter(ICharacterClass characterClass) {
		keyword$38$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
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
	
	public ICharacterClass getKeyword$50$Delimiter() {
		return keyword$50$Delimiter;
	}
	
	public void setKeyword$50$Delimiter(ICharacterClass characterClass) {
		keyword$50$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$54$Delimiter() {
		return keyword$54$Delimiter;
	}
	
	public void setKeyword$54$Delimiter(ICharacterClass characterClass) {
		keyword$54$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$59$Delimiter() {
		return keyword$59$Delimiter;
	}
	
	public void setKeyword$59$Delimiter(ICharacterClass characterClass) {
		keyword$59$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$63$Delimiter() {
		return keyword$63$Delimiter;
	}
	
	public void setKeyword$63$Delimiter(ICharacterClass characterClass) {
		keyword$63$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$17$Delimiter() {
		return ruleCall$17$Delimiter;
	}
	
	public void setRuleCall$17$Delimiter(ISequenceMatcher matcher) {
		ruleCall$17$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$20$Delimiter() {
		return ruleCall$20$Delimiter;
	}
	
	public void setRuleCall$20$Delimiter(ISequenceMatcher matcher) {
		ruleCall$20$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$29$Delimiter() {
		return ruleCall$29$Delimiter;
	}
	
	public void setRuleCall$29$Delimiter(ISequenceMatcher matcher) {
		ruleCall$29$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$32$Delimiter() {
		return ruleCall$32$Delimiter;
	}
	
	public void setRuleCall$32$Delimiter(ISequenceMatcher matcher) {
		ruleCall$32$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$36$Delimiter() {
		return ruleCall$36$Delimiter;
	}
	
	public void setRuleCall$36$Delimiter(ISequenceMatcher matcher) {
		ruleCall$36$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$40$Delimiter() {
		return ruleCall$40$Delimiter;
	}
	
	public void setRuleCall$40$Delimiter(ISequenceMatcher matcher) {
		ruleCall$40$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

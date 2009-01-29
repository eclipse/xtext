/*
Generated with Xtext
*/
package org.eclipse.xtext.parser.epatch.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess;
import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess.CreatedObjectElements;

import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageMigrationConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageMonoListAssignmentConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageMonoSingleAssignmentConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageObjectCopyConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageObjectNewConsumer;

@SuppressWarnings("unused")
public final class EpatchTestLanguageCreatedObjectConsumer extends NonTerminalConsumer {

	private XtextBuiltinIDConsumer idConsumer;
	private EpatchTestLanguageMigrationConsumer migrationConsumer;
	private EpatchTestLanguageMonoListAssignmentConsumer monoListAssignmentConsumer;
	private EpatchTestLanguageMonoSingleAssignmentConsumer monoSingleAssignmentConsumer;
	private EpatchTestLanguageObjectCopyConsumer objectCopyConsumer;
	private EpatchTestLanguageObjectNewConsumer objectNewConsumer;

	private ICharacterClass keyword$11$Delimiter;
	
	private ICharacterClass keyword$19$Delimiter;
	
	private ISequenceMatcher ruleCall$7$Delimiter;
	
	public EpatchTestLanguageCreatedObjectConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$19$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$7$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected int doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected int consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeAlternatives$3(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00Alternatives());
			marker.commit();
			return result;
		}
		result = consumeAssignment$6(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele01AssignmentName());
			marker.commit();
			return result;
		}
		result = consumeGroup$8(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1Group());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeAlternatives$3() throws Exception {
		int result = ConsumeResult.SUCCESS;
		IMarker bestMarker = mark();
		IMarker currentMarker;
		int tempResult;
		currentMarker = bestMarker.fork();
		tempResult = consumeRuleCall$4(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			bestMarker = currentMarker.join(bestMarker);
			bestMarker.commit();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker = currentMarker.join(bestMarker);
			result = tempResult;
		} else {
			bestMarker = bestMarker.join(currentMarker);
		}
		currentMarker = null;
		currentMarker = bestMarker.fork();
		tempResult = consumeRuleCall$5(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			bestMarker = currentMarker.join(bestMarker);
			bestMarker.commit();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker = currentMarker.join(bestMarker);
			result = tempResult;
		} else {
			bestMarker = bestMarker.join(currentMarker);
		}
		currentMarker = null;
		bestMarker.commit();
		return result;
	}

	protected int consumeRuleCall$4() throws Exception {
		return consumeNonTerminal(objectNewConsumer, null, false, false, getRule().ele000ParserRuleCallObjectNew());
	}

	protected int consumeRuleCall$5() throws Exception {
		return consumeNonTerminal(objectCopyConsumer, null, false, false, getRule().ele001ParserRuleCallObjectCopy());
	}

	protected int consumeAssignment$6() throws Exception {
		IMarker marker = mark();
		int result = doConsumeAssignment$6();
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$6() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(idConsumer, "name", false, false, getRule().ele010LexerRuleCallID(), getRuleCall$7$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeGroup$8() throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$8();
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$8() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$11(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1000KeywordLeftCurlyBracket());
			marker.commit();
			return result;
		}
		result = consumeAlternatives$12(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1001Alternatives());
			marker.commit();
			return result;
		}
		result = consumeAssignment$17(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele101AssignmentLeftMig());
			marker.commit();
			return result;
		}
		result = consumeKeyword$19(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele11KeywordRightCurlyBracket());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele1000KeywordLeftCurlyBracket(), null, false, false, getKeyword$11$Delimiter());
	}

	protected int consumeAlternatives$12() throws Exception {
		IMarker marker = mark();
		int result = doConsumeAlternatives$12();
		if (result == ConsumeResult.SUCCESS) {
			marker.flush();
			while(doConsumeAlternatives$12()==ConsumeResult.SUCCESS) {
				marker.flush();
			}
			marker.rollback();
			return ConsumeResult.SUCCESS;
		} else {
			error("Could not find token.", getRule().ele1001Alternatives());
		}
		marker.commit();
		return result;
	}

	protected int doConsumeAlternatives$12() throws Exception {
		int result = ConsumeResult.SUCCESS;
		IMarker bestMarker = mark();
		IMarker currentMarker;
		int tempResult;
		currentMarker = bestMarker.fork();
		tempResult = consumeAssignment$13(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			bestMarker = currentMarker.join(bestMarker);
			bestMarker.commit();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker = currentMarker.join(bestMarker);
			result = tempResult;
		} else {
			bestMarker = bestMarker.join(currentMarker);
		}
		currentMarker = null;
		currentMarker = bestMarker.fork();
		tempResult = consumeAssignment$15(); 
		if (tempResult == ConsumeResult.SUCCESS) {
			bestMarker = currentMarker.join(bestMarker);
			bestMarker.commit();
			return tempResult;
		}
		if (tempResult > result) {
			bestMarker = currentMarker.join(bestMarker);
			result = tempResult;
		} else {
			bestMarker = bestMarker.join(currentMarker);
		}
		currentMarker = null;
		bestMarker.commit();
		return result;
	}

	protected int consumeAssignment$13() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(monoSingleAssignmentConsumer, "assignments", true, false, getRule().ele100100ParserRuleCallMonoSingleAssignment());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeAssignment$15() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(monoListAssignmentConsumer, "assignments", true, false, getRule().ele100110ParserRuleCallMonoListAssignment());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeAssignment$17() throws Exception {
		IMarker marker = mark();
		int result = doConsumeAssignment$17();
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$17() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(migrationConsumer, "leftMig", false, false, getRule().ele1010ParserRuleCallMigration());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeKeyword$19() throws Exception {
		return consumeKeyword(getRule().ele11KeywordRightCurlyBracket(), null, false, false, getKeyword$19$Delimiter());
	}

	public CreatedObjectElements getRule() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prCreatedObject();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "CreatedObject";
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setMigrationConsumer(EpatchTestLanguageMigrationConsumer migrationConsumer) {
		this.migrationConsumer = migrationConsumer;
	}
	
	public void setMonoListAssignmentConsumer(EpatchTestLanguageMonoListAssignmentConsumer monoListAssignmentConsumer) {
		this.monoListAssignmentConsumer = monoListAssignmentConsumer;
	}
	
	public void setMonoSingleAssignmentConsumer(EpatchTestLanguageMonoSingleAssignmentConsumer monoSingleAssignmentConsumer) {
		this.monoSingleAssignmentConsumer = monoSingleAssignmentConsumer;
	}
	
	public void setObjectCopyConsumer(EpatchTestLanguageObjectCopyConsumer objectCopyConsumer) {
		this.objectCopyConsumer = objectCopyConsumer;
	}
	
	public void setObjectNewConsumer(EpatchTestLanguageObjectNewConsumer objectNewConsumer) {
		this.objectNewConsumer = objectNewConsumer;
	}
	
	public ICharacterClass getKeyword$11$Delimiter() {
		return keyword$11$Delimiter;
	}
	
	public void setKeyword$11$Delimiter(ICharacterClass characterClass) {
		keyword$11$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$19$Delimiter() {
		return keyword$19$Delimiter;
	}
	
	public void setKeyword$19$Delimiter(ICharacterClass characterClass) {
		keyword$19$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$7$Delimiter() {
		return ruleCall$7$Delimiter;
	}
	
	public void setRuleCall$7$Delimiter(ISequenceMatcher matcher) {
		ruleCall$7$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

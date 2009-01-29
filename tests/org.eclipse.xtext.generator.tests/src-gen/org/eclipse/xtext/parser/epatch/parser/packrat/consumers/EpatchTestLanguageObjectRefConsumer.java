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
import org.eclipse.xtext.parser.epatch.services.EpatchTestLanguageGrammarAccess.ObjectRefElements;

import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageBiListAssignmentConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageBiSingleAssignmentConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageFRAGMENTConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;
import org.eclipse.xtext.parser.epatch.parser.packrat.consumers.EpatchTestLanguageMigrationConsumer;

@SuppressWarnings("unused")
public final class EpatchTestLanguageObjectRefConsumer extends NonTerminalConsumer {

	private EpatchTestLanguageBiListAssignmentConsumer biListAssignmentConsumer;
	private EpatchTestLanguageBiSingleAssignmentConsumer biSingleAssignmentConsumer;
	private EpatchTestLanguageFRAGMENTConsumer fragmentConsumer;
	private XtextBuiltinIDConsumer idConsumer;
	private EpatchTestLanguageMigrationConsumer migrationConsumer;

	private ISequenceMatcher crossReference$10$Delimiter;
	
	private ISequenceMatcher crossReference$21$Delimiter;
	
	private ISequenceMatcher crossReference$27$Delimiter;
	
	private ICharacterClass keyword$4$Delimiter;
	
	private ICharacterClass keyword$19$Delimiter;
	
	private ICharacterClass keyword$25$Delimiter;
	
	private ICharacterClass keyword$35$Delimiter;
	
	private ICharacterClass keyword$42$Delimiter;
	
	private ICharacterClass keyword$46$Delimiter;
	
	private ICharacterClass keyword$49$Delimiter;
	
	private ISequenceMatcher ruleCall$6$Delimiter;
	
	private ISequenceMatcher ruleCall$13$Delimiter;
	
	private ISequenceMatcher ruleCall$24$Delimiter;
	
	private ISequenceMatcher ruleCall$30$Delimiter;
	
	public EpatchTestLanguageObjectRefConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		crossReference$10$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		crossReference$21$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		crossReference$27$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		keyword$4$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$19$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$25$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$35$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$42$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$46$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$49$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$6$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$13$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$24$Delimiter = ISequenceMatcher.Factory.nullMatcher();
		ruleCall$30$Delimiter = ISequenceMatcher.Factory.nullMatcher();
	}
	
	protected int doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected int consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$4(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele000KeywordObject());
			marker.commit();
			return result;
		}
		result = consumeAssignment$5(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele001AssignmentName());
			marker.commit();
			return result;
		}
		result = consumeAlternatives$7(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele01Alternatives());
			marker.commit();
			return result;
		}
		result = consumeGroup$31(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1Group());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$4() throws Exception {
		return consumeKeyword(getRule().ele000KeywordObject(), null, false, false, getKeyword$4$Delimiter());
	}

	protected int consumeAssignment$5() throws Exception {
		IMarker marker = mark();
		int result = doConsumeAssignment$5();
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$5() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(idConsumer, "name", false, false, getRule().ele0010LexerRuleCallID(), getRuleCall$6$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeAlternatives$7() throws Exception {
		int result = ConsumeResult.SUCCESS;
		IMarker bestMarker = mark();
		IMarker currentMarker;
		int tempResult;
		currentMarker = bestMarker.fork();
		tempResult = consumeGroup$8(); 
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
		tempResult = consumeGroup$14(); 
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

	protected int consumeGroup$8() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeAssignment$9(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0100AssignmentLeftRes());
			marker.commit();
			return result;
		}
		result = consumeAssignment$12(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0101AssignmentLeftFrag());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeAssignment$9() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(idConsumer, "leftRes", false, false, getRule().ele01000CrossReferenceEStringNamedResource(), getCrossReference$10$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeAssignment$12() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(fragmentConsumer, "leftFrag", false, false, getRule().ele01010LexerRuleCallFRAGMENT(), getRuleCall$13$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeGroup$14() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$19(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele01100000KeywordLeft());
			marker.commit();
			return result;
		}
		result = consumeAssignment$20(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele01100001AssignmentLeftRes());
			marker.commit();
			return result;
		}
		result = consumeAssignment$23(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0110001AssignmentLeftFrag());
			marker.commit();
			return result;
		}
		result = consumeKeyword$25(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele011001KeywordRight());
			marker.commit();
			return result;
		}
		result = consumeAssignment$26(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele01101AssignmentRightRes());
			marker.commit();
			return result;
		}
		result = consumeAssignment$29(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0111AssignmentRightFrag());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$19() throws Exception {
		return consumeKeyword(getRule().ele01100000KeywordLeft(), null, false, false, getKeyword$19$Delimiter());
	}

	protected int consumeAssignment$20() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(idConsumer, "leftRes", false, false, getRule().ele011000010CrossReferenceEStringNamedResource(), getCrossReference$21$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeAssignment$23() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(fragmentConsumer, "leftFrag", false, false, getRule().ele01100010LexerRuleCallFRAGMENT(), getRuleCall$24$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeKeyword$25() throws Exception {
		return consumeKeyword(getRule().ele011001KeywordRight(), null, false, false, getKeyword$25$Delimiter());
	}

	protected int consumeAssignment$26() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(idConsumer, "rightRes", false, false, getRule().ele011010CrossReferenceEStringNamedResource(), getCrossReference$27$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeAssignment$29() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeTerminal(fragmentConsumer, "rightFrag", false, false, getRule().ele01110LexerRuleCallFRAGMENT(), getRuleCall$30$Delimiter());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeGroup$31() throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$31();
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$31() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$35(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele10000KeywordLeftCurlyBracket());
			marker.commit();
			return result;
		}
		result = consumeAlternatives$36(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele10001Alternatives());
			marker.commit();
			return result;
		}
		result = consumeGroup$41(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1001Group());
			marker.commit();
			return result;
		}
		result = consumeGroup$45(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele101Group());
			marker.commit();
			return result;
		}
		result = consumeKeyword$49(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele11KeywordRightCurlyBracket());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$35() throws Exception {
		return consumeKeyword(getRule().ele10000KeywordLeftCurlyBracket(), null, false, false, getKeyword$35$Delimiter());
	}

	protected int consumeAlternatives$36() throws Exception {
		IMarker marker = mark();
		int result = doConsumeAlternatives$36();
		if (result == ConsumeResult.SUCCESS) {
			marker.flush();
			while(doConsumeAlternatives$36()==ConsumeResult.SUCCESS) {
				marker.flush();
			}
			marker.rollback();
			return ConsumeResult.SUCCESS;
		} else {
			error("Could not find token.", getRule().ele10001Alternatives());
		}
		marker.commit();
		return result;
	}

	protected int doConsumeAlternatives$36() throws Exception {
		int result = ConsumeResult.SUCCESS;
		IMarker bestMarker = mark();
		IMarker currentMarker;
		int tempResult;
		currentMarker = bestMarker.fork();
		tempResult = consumeAssignment$37(); 
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
		tempResult = consumeAssignment$39(); 
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

	protected int consumeAssignment$37() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(biSingleAssignmentConsumer, "assignments", true, false, getRule().ele1000100ParserRuleCallBiSingleAssignment());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeAssignment$39() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(biListAssignmentConsumer, "assignments", true, false, getRule().ele1000110ParserRuleCallBiListAssignment());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeGroup$41() throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$41();
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$41() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$42(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele10010KeywordLeft());
			marker.commit();
			return result;
		}
		result = consumeAssignment$43(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele10011AssignmentLeftMig());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$42() throws Exception {
		return consumeKeyword(getRule().ele10010KeywordLeft(), null, false, false, getKeyword$42$Delimiter());
	}

	protected int consumeAssignment$43() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(migrationConsumer, "leftMig", false, false, getRule().ele100110ParserRuleCallMigration());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeGroup$45() throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$45();
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$45() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$46(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1010KeywordRight());
			marker.commit();
			return result;
		}
		result = consumeAssignment$47(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1011AssignmentRightMig());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$46() throws Exception {
		return consumeKeyword(getRule().ele1010KeywordRight(), null, false, false, getKeyword$46$Delimiter());
	}

	protected int consumeAssignment$47() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(migrationConsumer, "rightMig", false, false, getRule().ele10110ParserRuleCallMigration());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeKeyword$49() throws Exception {
		return consumeKeyword(getRule().ele11KeywordRightCurlyBracket(), null, false, false, getKeyword$49$Delimiter());
	}

	public ObjectRefElements getRule() {
		return EpatchTestLanguageGrammarAccess.INSTANCE.prObjectRef();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "ObjectRef";
	}
	
	public void setBiListAssignmentConsumer(EpatchTestLanguageBiListAssignmentConsumer biListAssignmentConsumer) {
		this.biListAssignmentConsumer = biListAssignmentConsumer;
	}
	
	public void setBiSingleAssignmentConsumer(EpatchTestLanguageBiSingleAssignmentConsumer biSingleAssignmentConsumer) {
		this.biSingleAssignmentConsumer = biSingleAssignmentConsumer;
	}
	
	public void setFragmentConsumer(EpatchTestLanguageFRAGMENTConsumer fragmentConsumer) {
		this.fragmentConsumer = fragmentConsumer;
	}
	
	public void setIdConsumer(XtextBuiltinIDConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public void setMigrationConsumer(EpatchTestLanguageMigrationConsumer migrationConsumer) {
		this.migrationConsumer = migrationConsumer;
	}
	
	public ISequenceMatcher getCrossReference$10$Delimiter() {
		return crossReference$10$Delimiter;
	}
	
	public void setCrossReference$10$Delimiter(ISequenceMatcher matcher) {
		crossReference$10$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getCrossReference$21$Delimiter() {
		return crossReference$21$Delimiter;
	}
	
	public void setCrossReference$21$Delimiter(ISequenceMatcher matcher) {
		crossReference$21$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getCrossReference$27$Delimiter() {
		return crossReference$27$Delimiter;
	}
	
	public void setCrossReference$27$Delimiter(ISequenceMatcher matcher) {
		crossReference$27$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ICharacterClass getKeyword$4$Delimiter() {
		return keyword$4$Delimiter;
	}
	
	public void setKeyword$4$Delimiter(ICharacterClass characterClass) {
		keyword$4$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$19$Delimiter() {
		return keyword$19$Delimiter;
	}
	
	public void setKeyword$19$Delimiter(ICharacterClass characterClass) {
		keyword$19$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$25$Delimiter() {
		return keyword$25$Delimiter;
	}
	
	public void setKeyword$25$Delimiter(ICharacterClass characterClass) {
		keyword$25$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$35$Delimiter() {
		return keyword$35$Delimiter;
	}
	
	public void setKeyword$35$Delimiter(ICharacterClass characterClass) {
		keyword$35$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
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
	
	public ISequenceMatcher getRuleCall$6$Delimiter() {
		return ruleCall$6$Delimiter;
	}
	
	public void setRuleCall$6$Delimiter(ISequenceMatcher matcher) {
		ruleCall$6$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$13$Delimiter() {
		return ruleCall$13$Delimiter;
	}
	
	public void setRuleCall$13$Delimiter(ISequenceMatcher matcher) {
		ruleCall$13$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$24$Delimiter() {
		return ruleCall$24$Delimiter;
	}
	
	public void setRuleCall$24$Delimiter(ISequenceMatcher matcher) {
		ruleCall$24$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
	public ISequenceMatcher getRuleCall$30$Delimiter() {
		return ruleCall$30$Delimiter;
	}
	
	public void setRuleCall$30$Delimiter(ISequenceMatcher matcher) {
		ruleCall$30$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

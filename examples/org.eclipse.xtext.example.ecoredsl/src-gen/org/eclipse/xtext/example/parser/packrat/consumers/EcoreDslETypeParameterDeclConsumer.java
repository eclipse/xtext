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
import org.eclipse.xtext.example.services.EcoreDslGrammarAccess.ETypeParameterDeclElements;

import org.eclipse.xtext.example.parser.packrat.consumers.EcoreDslEGenericTypeDeclConsumer;
import org.eclipse.xtext.builtin.parser.packrat.consumers.XtextBuiltinIDConsumer;

@SuppressWarnings("unused")
public final class EcoreDslETypeParameterDeclConsumer extends NonTerminalConsumer {

	private ETypeParameterDeclElements rule;
	
	private INonTerminalConsumer eGenericTypeDeclConsumer;
	private ITerminalConsumer idConsumer;

	private ICharacterClass keyword$5$Delimiter;
	
	private ISequenceMatcher ruleCall$3$Delimiter;
	
	public EcoreDslETypeParameterDeclConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		keyword$5$Delimiter = ICharacterClass.Factory.nullClass();
		ruleCall$3$Delimiter = ISequenceMatcher.Factory.nullMatcher();
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
					error("Another token expected.", getRule().ele0AssignmentName());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeGroup$4(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1Group());
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
		return consumeRuleCall$3(entryPoint);
	}

	protected int consumeRuleCall$3(int entryPoint) throws Exception {
		return consumeTerminal(idConsumer, "name", false, false, getRule().ele00LexerRuleCallID(), getRuleCall$3$Delimiter());
	}

	protected int consumeGroup$4(int entryPoint) throws Exception {
		IMarker marker = mark();
		int result = doConsumeGroup$4(entryPoint);
		if (result != ConsumeResult.SUCCESS)
			marker.rollback();
		else
			marker.commit();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeGroup$4(int entryPoint) throws Exception {
		announceNextLevel();
		final IMarker marker = mark();
		int result = ConsumeResult.SUCCESS;
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result = ConsumeResult.EMPTY_MATCH;
			case 0:
				announceNextStep();
				result = consumeKeyword$5(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele10KeywordExtends());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$6(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele11AssignmentEBounds());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$5(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele10KeywordExtends(), null, false, false, getKeyword$5$Delimiter());
	}

	protected int consumeAssignment$6(int entryPoint) throws Exception {
		return consumeRuleCall$7(entryPoint);
	}

	protected int consumeRuleCall$7(int entryPoint) throws Exception {
		return consumeNonTerminal(eGenericTypeDeclConsumer, "eBounds", true, false, false, getRule().ele110ParserRuleCallEGenericTypeDecl());
	}

	public ETypeParameterDeclElements getRule() {
	// EcoreDslGrammarAccess.INSTANCE.prETypeParameterDecl()
		return rule;
	}
	
	public void setRule(ETypeParameterDeclElements rule) {
		this.rule = rule;
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "ETypeParameter";
	}
	
	public void setEGenericTypeDeclConsumer(INonTerminalConsumer eGenericTypeDeclConsumer) {
		this.eGenericTypeDeclConsumer = eGenericTypeDeclConsumer;
	}
	
	public void setIdConsumer(ITerminalConsumer idConsumer) {
		this.idConsumer = idConsumer;
	}
	
	public ICharacterClass getKeyword$5$Delimiter() {
		return keyword$5$Delimiter;
	}
	
	public void setKeyword$5$Delimiter(ICharacterClass characterClass) {
		keyword$5$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ISequenceMatcher getRuleCall$3$Delimiter() {
		return ruleCall$3$Delimiter;
	}
	
	public void setRuleCall$3$Delimiter(ISequenceMatcher matcher) {
		ruleCall$3$Delimiter = matcher != null ? matcher : ISequenceMatcher.Factory.nullMatcher();
	}
	
}

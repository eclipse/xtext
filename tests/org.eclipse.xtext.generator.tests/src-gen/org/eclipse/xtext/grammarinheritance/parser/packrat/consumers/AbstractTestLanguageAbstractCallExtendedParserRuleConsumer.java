/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance.parser.packrat.consumers;

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

import org.eclipse.xtext.grammarinheritance.services.AbstractTestLanguageGrammarAccess.AbstractCallExtendedParserRuleElements;

import org.eclipse.xtext.grammarinheritance.parser.packrat.consumers.AbstractTestLanguageExtendableParserRuleConsumer;

@SuppressWarnings("unused")
public final class AbstractTestLanguageAbstractCallExtendedParserRuleConsumer extends NonTerminalConsumer {

	private AbstractCallExtendedParserRuleElements rule;
	
	private INonTerminalConsumer extendableParserRuleConsumer;

	private ICharacterClass keyword$2$Delimiter;
	
	public AbstractTestLanguageAbstractCallExtendedParserRuleConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
		keyword$2$Delimiter = ICharacterClass.Factory.nullClass();
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
				result = consumeKeyword$2(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele0KeywordExtendedmodel());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAssignment$3(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1AssignmentElements());
					marker.commit();
					announceLevelFinished();
					return result;
				}
		}
		marker.commit();
		announceLevelFinished();
		return result;
	}

	protected int consumeKeyword$2(int entryPoint) throws Exception {
		return consumeKeyword(getRule().ele0KeywordExtendedmodel(), null, false, false, getKeyword$2$Delimiter());
	}

	protected int consumeAssignment$3(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeAssignment$3(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$3(int entryPoint) throws Exception {
		return consumeRuleCall$4(entryPoint);
	}

	protected int consumeRuleCall$4(int entryPoint) throws Exception {
		return consumeNonTerminal(extendableParserRuleConsumer, "elements", true, false, false, getRule().ele10ParserRuleCallExtendableParserRule());
	}

	public AbstractCallExtendedParserRuleElements getRule() {
		return rule;
	}
	
	public void setRule(AbstractCallExtendedParserRuleElements rule) {
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
	
	public void setExtendableParserRuleConsumer(INonTerminalConsumer extendableParserRuleConsumer) {
		this.extendableParserRuleConsumer = extendableParserRuleConsumer;
	}
	
	public ICharacterClass getKeyword$2$Delimiter() {
		return keyword$2$Delimiter;
	}
	
	public void setKeyword$2$Delimiter(ICharacterClass characterClass) {
		keyword$2$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}

/*
Generated with Xtext
*/
package org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess;
import org.eclipse.xtext.parsetree.transientvalues.services.TransientValuesTestGrammarAccess.RootElements;

import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestTestListConsumer;
import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestTestOptionalConsumer;
import org.eclipse.xtext.parsetree.transientvalues.parser.packrat.consumers.TransientValuesTestTestRequiredConsumer;

@SuppressWarnings("unused")
public final class TransientValuesTestRootConsumer extends NonTerminalConsumer {

	private INonTerminalConsumer testListConsumer;
	private INonTerminalConsumer testOptionalConsumer;
	private INonTerminalConsumer testRequiredConsumer;

	private ICharacterClass keyword$2$Delimiter;
	
	public TransientValuesTestRootConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
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
					error("Another token expected.", getRule().ele0KeywordTest());
					marker.commit();
					announceLevelFinished();
					return result;
				}
			case 1:
				announceNextStep();
				result = consumeAlternatives$3(nextEntryPoint());
				if (result!=ConsumeResult.SUCCESS) {
					error("Another token expected.", getRule().ele1Alternatives());
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
		return consumeKeyword(getRule().ele0KeywordTest(), null, false, false, getKeyword$2$Delimiter());
	}

	protected int consumeAlternatives$3(int entryPoint) throws Exception {
		AlternativesResult result = createAlternativesResult();
		switch(entryPoint) {
			case -1: // use fall through semantics of switch case
				result.reset();
			case 0:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$5(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 1:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$6(nextEntryPoint()))) { 
					return result.getResult(); 
				}
			case 2:
				result.nextAlternative();
				if (result.isAlternativeDone(consumeRuleCall$7(nextEntryPoint()))) { 
					return result.getResult(); 
				}
		}
		return result.getResult();
	}

	protected int consumeRuleCall$5(int entryPoint) throws Exception {
		return consumeNonTerminal(testRequiredConsumer, null, false, false, false, getRule().ele100ParserRuleCallTestRequired());
	}

	protected int consumeRuleCall$6(int entryPoint) throws Exception {
		return consumeNonTerminal(testOptionalConsumer, null, false, false, false, getRule().ele101ParserRuleCallTestOptional());
	}

	protected int consumeRuleCall$7(int entryPoint) throws Exception {
		return consumeNonTerminal(testListConsumer, null, false, false, false, getRule().ele11ParserRuleCallTestList());
	}

	public RootElements getRule() {
		return TransientValuesTestGrammarAccess.INSTANCE.prRoot();
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Root";
	}
	
	public void setTestListConsumer(INonTerminalConsumer testListConsumer) {
		this.testListConsumer = testListConsumer;
	}
	
	public void setTestOptionalConsumer(INonTerminalConsumer testOptionalConsumer) {
		this.testOptionalConsumer = testOptionalConsumer;
	}
	
	public void setTestRequiredConsumer(INonTerminalConsumer testRequiredConsumer) {
		this.testRequiredConsumer = testRequiredConsumer;
	}
	
	public ICharacterClass getKeyword$2$Delimiter() {
		return keyword$2$Delimiter;
	}
	
	public void setKeyword$2$Delimiter(ICharacterClass characterClass) {
		keyword$2$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}

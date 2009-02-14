/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.INonTerminalConsumerConfiguration;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;

import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess.EntryRuleElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.TestLanguageAbstractRuleConsumer;

@SuppressWarnings("unused")
public final class TestLanguageEntryRuleConsumer extends NonTerminalConsumer {

	private INonTerminalConsumer abstractRuleConsumer;

	public TestLanguageEntryRuleConsumer(INonTerminalConsumerConfiguration configuration, ITerminalConsumer[] hiddenTokens) {
		super(configuration, hiddenTokens);
	}
	
	@Override
	protected int doConsume(int entryPoint) throws Exception {
		return consumeAssignment$1(entryPoint);
	}

	protected int consumeAssignment$1(int entryPoint) throws Exception {
		IMarker marker = mark();
		while(doConsumeAssignment$1(entryPoint) == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$1(int entryPoint) throws Exception {
		return consumeRuleCall$2(entryPoint);
	}

	protected int consumeRuleCall$2(int entryPoint) throws Exception {
		return consumeNonTerminal(abstractRuleConsumer, "multiFeature", true, false, false, getRule().ele0ParserRuleCallAbstractRule());
	}

	public EntryRuleElements getRule() {
		return TestLanguageGrammarAccess.INSTANCE.prEntryRule();
	}
	
	@Override
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Model";
	}
	
	public void setAbstractRuleConsumer(INonTerminalConsumer abstractRuleConsumer) {
		this.abstractRuleConsumer = abstractRuleConsumer;
	}
	
}

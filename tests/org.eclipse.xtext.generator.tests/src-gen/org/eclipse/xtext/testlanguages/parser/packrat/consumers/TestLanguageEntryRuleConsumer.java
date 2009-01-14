/*
Generated with Xtext
*/
package org.eclipse.xtext.testlanguages.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess.EntryRuleElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.TestLanguageAbstractRuleConsumer;

@SuppressWarnings("unused")
public final class TestLanguageEntryRuleConsumer extends NonTerminalConsumer {

	private TestLanguageAbstractRuleConsumer abstractRuleConsumer;

	public TestLanguageEntryRuleConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeAssignment$1();
	}

	protected boolean consumeAssignment$1() throws Exception {
		while(doConsumeAssignment$1()) {}
		return true;
	}

	protected boolean doConsumeAssignment$1() throws Exception {
		if (consumeNonTerminal(abstractRuleConsumer, "multiFeature", true, false, getRule().ele0ParserRuleCallAbstractRule()))
			return true;
		return false;
	}

	public EntryRuleElements getRule() {
		return TestLanguageGrammarAccess.INSTANCE.prEntryRule();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Model";
	}
	
	public void setAbstractRuleConsumer(TestLanguageAbstractRuleConsumer abstractRuleConsumer) {
		this.abstractRuleConsumer = abstractRuleConsumer;
	}
	
}

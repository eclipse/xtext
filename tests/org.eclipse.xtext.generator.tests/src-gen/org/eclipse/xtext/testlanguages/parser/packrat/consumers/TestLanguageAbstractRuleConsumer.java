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
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess.AbstractRuleElements;

import org.eclipse.xtext.testlanguages.parser.packrat.TestLanguageDelimiters;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.TestLanguageChoiceRuleConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.TestLanguageReducibleRuleConsumer;

@SuppressWarnings("unused")
public final class TestLanguageAbstractRuleConsumer extends NonTerminalConsumer {

	private TestLanguageChoiceRuleConsumer choiceRuleConsumer;
	private TestLanguageReducibleRuleConsumer reducibleRuleConsumer;

	public TestLanguageAbstractRuleConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeAlternatives$1();
	}

	protected boolean consumeAlternatives$1() throws Exception {
		if (consumeRuleCall$2())
			return true;
		if (consumeRuleCall$3())
			return true;
		return false;
	}

	protected boolean consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(choiceRuleConsumer, null, false, false, getRule().ele0ParserRuleCallChoiceRule());
	}

	protected boolean consumeRuleCall$3() throws Exception {
		return consumeNonTerminal(reducibleRuleConsumer, null, false, false, getRule().ele1ParserRuleCallReducibleRule());
	}

	public AbstractRuleElements getRule() {
		return TestLanguageGrammarAccess.INSTANCE.prAbstractRule();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "AbstractElement";
	}
	
	public void setChoiceRuleConsumer(TestLanguageChoiceRuleConsumer choiceRuleConsumer) {
		this.choiceRuleConsumer = choiceRuleConsumer;
	}
	
	public void setReducibleRuleConsumer(TestLanguageReducibleRuleConsumer reducibleRuleConsumer) {
		this.reducibleRuleConsumer = reducibleRuleConsumer;
	}
	
}

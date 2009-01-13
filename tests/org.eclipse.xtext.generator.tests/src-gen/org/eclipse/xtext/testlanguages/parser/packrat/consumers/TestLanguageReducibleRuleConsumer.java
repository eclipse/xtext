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
import org.eclipse.xtext.testlanguages.services.TestLanguageGrammarAccess.ReducibleRuleElements;

import org.eclipse.xtext.testlanguages.parser.packrat.TestLanguageDelimiters;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.TestLanguageTerminalRuleConsumer;

@SuppressWarnings("unused")
public final class TestLanguageReducibleRuleConsumer extends NonTerminalConsumer {

	private TestLanguageTerminalRuleConsumer terminalRuleConsumer;

	public TestLanguageReducibleRuleConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$3()) {
			marker.rollback();
			return false;
		}
		if (!consumeRuleCall$4()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$5()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$3() throws Exception {
		return consumeKeyword(getRule().ele00KeywordReducible(), null, false, false, TestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeRuleCall$4() throws Exception {
		return consumeNonTerminal(terminalRuleConsumer, null, false, false, getRule().ele01ParserRuleCallTerminalRule());
	}

	protected boolean consumeGroup$5() throws Exception {
		doConsumeGroup$5();
		return true;
	}

	protected boolean doConsumeGroup$5() throws Exception {
		final IMarker marker = mark();
		if (!consumeAction$6()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$8()) {
			marker.rollback();
			return false;
		}
		return true;
	}
	protected boolean consumeAction$6() {
		consumeAction("ReducibleComposite", "actionFeature", true);
		return true;	
	}

	protected boolean consumeAssignment$8() throws Exception {
		if (consumeNonTerminal(terminalRuleConsumer, "actionFeature", true, false, getRule().ele110ParserRuleCallTerminalRule()))
			return true;
		return false;
	}

	public ReducibleRuleElements getRule() {
		return TestLanguageGrammarAccess.INSTANCE.prReducibleRule();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "ReducibleElement";
	}
	
	public void setTerminalRuleConsumer(TestLanguageTerminalRuleConsumer terminalRuleConsumer) {
		this.terminalRuleConsumer = terminalRuleConsumer;
	}
	
}

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

import org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageGrammarAccess.AdditionElements;

import org.eclipse.xtext.testlanguages.parser.packrat.SimpleExpressionsTestLanguageDelimiters;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.SimpleExpressionsTestLanguageMultiplicationConsumer;

@SuppressWarnings("unused")
public final class SimpleExpressionsTestLanguageAdditionConsumer extends NonTerminalConsumer {

	private SimpleExpressionsTestLanguageMultiplicationConsumer multiplicationConsumer;

	public SimpleExpressionsTestLanguageAdditionConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeRuleCall$2()) {
			marker.rollback();
			return false;
		}
		if (!consumeGroup$3()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(multiplicationConsumer, null, false, false, getRule().ele0ParserRuleCallMultiplication());
	}

	protected boolean consumeGroup$3() throws Exception {
		while(doConsumeGroup$3()) {}
		return true;
	}

	protected boolean doConsumeGroup$3() throws Exception {
		final IMarker marker = mark();
		if (!consumeAction$5()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$7()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$11()) {
			marker.rollback();
			return false;
		}
		return true;
	}
	protected boolean consumeAction$5() {
		consumeAction("Op", "values", true);
		return true;	
	}

	protected boolean consumeAssignment$7() throws Exception {
		if (consumeKeyword(getRule().ele10100KeywordPlusSign(), "operator", false, false, SimpleExpressionsTestLanguageDelimiters.ANY_OTHER_DELIMITER))
			return true;
		if (consumeKeyword(getRule().ele10101KeywordHyphenMinus(), "operator", false, false, SimpleExpressionsTestLanguageDelimiters.ANY_OTHER_DELIMITER))
			return true;
		return false;
	}

	protected boolean consumeAssignment$11() throws Exception {
		if (consumeNonTerminal(multiplicationConsumer, "values", true, false, getRule().ele110ParserRuleCallMultiplication()))
			return true;
		return false;
	}

	public AdditionElements getRule() {
		return SimpleExpressionsTestLanguageGrammarAccess.INSTANCE.prAddition();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Expression";
	}
	
	public void setMultiplicationConsumer(SimpleExpressionsTestLanguageMultiplicationConsumer multiplicationConsumer) {
		this.multiplicationConsumer = multiplicationConsumer;
	}
	
}

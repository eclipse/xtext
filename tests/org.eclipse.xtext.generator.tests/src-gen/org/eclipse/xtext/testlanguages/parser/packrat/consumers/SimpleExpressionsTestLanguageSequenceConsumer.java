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

import org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.SimpleExpressionsTestLanguageGrammarAccess.SequenceElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.SimpleExpressionsTestLanguageAdditionConsumer;

@SuppressWarnings("unused")
public final class SimpleExpressionsTestLanguageSequenceConsumer extends NonTerminalConsumer {

	private SimpleExpressionsTestLanguageAdditionConsumer additionConsumer;

	public SimpleExpressionsTestLanguageSequenceConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
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
			marker.release();
			return false;
		}
		if (!consumeGroup$3()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}

	protected boolean consumeRuleCall$2() throws Exception {
		return consumeNonTerminal(additionConsumer, null, false, false, getRule().ele0ParserRuleCallAddition());
	}

	protected boolean consumeGroup$3() throws Exception {
		while(doConsumeGroup$3()) {}
		return true;
	}

	protected boolean doConsumeGroup$3() throws Exception {
		final IMarker marker = mark();
		if (!consumeAction$4()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$6()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}
	protected boolean consumeAction$4() {
		consumeAction("Sequence", "expressions", true);
		return true;	
	}

	protected boolean consumeAssignment$6() throws Exception {
		if (consumeNonTerminal(additionConsumer, "expressions", true, false, getRule().ele110ParserRuleCallAddition()))
			return true;
		return false;
	}

	public SequenceElements getRule() {
		return SimpleExpressionsTestLanguageGrammarAccess.INSTANCE.prSequence();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Sequence";
	}
	
	public void setAdditionConsumer(SimpleExpressionsTestLanguageAdditionConsumer additionConsumer) {
		this.additionConsumer = additionConsumer;
	}
	
}

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

import org.eclipse.xtext.testlanguages.services.FowlerDslTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.FowlerDslTestLanguageGrammarAccess.StatemachineElements;

import org.eclipse.xtext.testlanguages.parser.packrat.FowlerDslTestLanguageDelimiters;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.FowlerDslTestLanguageEventConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.FowlerDslTestLanguageStateConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.FowlerDslTestLanguageCommandConsumer;

@SuppressWarnings("unused")
public final class FowlerDslTestLanguageStatemachineConsumer extends NonTerminalConsumer {

	private FowlerDslTestLanguageEventConsumer eventConsumer;
	private FowlerDslTestLanguageStateConsumer stateConsumer;
	private FowlerDslTestLanguageCommandConsumer commandConsumer;

	public FowlerDslTestLanguageStatemachineConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$7()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$8()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$10()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$11()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$12()) {
			marker.rollback();
			return false;
		}
		if (!consumeKeyword$14()) {
			marker.rollback();
			return false;
		}
		if (!consumeAssignment$15()) {
			marker.rollback();
			return false;
		}
		return true;
	}

	protected boolean consumeKeyword$7() throws Exception {
		return consumeKeyword(getRule().ele000000KeywordEvents(), null, false, false, FowlerDslTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$8() throws Exception {
		while(doConsumeAssignment$8()) {}
		return true;
	}

	protected boolean doConsumeAssignment$8() throws Exception {
		if (consumeNonTerminal(eventConsumer, "events", true, false, getRule().ele0000010ParserRuleCallEvent()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$10() throws Exception {
		return consumeKeyword(getRule().ele00001KeywordEnd(), null, false, false, FowlerDslTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele0001KeywordCommands(), null, false, false, FowlerDslTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$12() throws Exception {
		while(doConsumeAssignment$12()) {}
		return true;
	}

	protected boolean doConsumeAssignment$12() throws Exception {
		if (consumeNonTerminal(commandConsumer, "commands", true, false, getRule().ele0010ParserRuleCallCommand()))
			return true;
		return false;
	}

	protected boolean consumeKeyword$14() throws Exception {
		return consumeKeyword(getRule().ele01KeywordEnd(), null, false, false, FowlerDslTestLanguageDelimiters.ID_DELIMITER);
	}

	protected boolean consumeAssignment$15() throws Exception {
		while(doConsumeAssignment$15()) {}
		return true;
	}

	protected boolean doConsumeAssignment$15() throws Exception {
		if (consumeNonTerminal(stateConsumer, "states", true, false, getRule().ele10ParserRuleCallState()))
			return true;
		return false;
	}

	public StatemachineElements getRule() {
		return FowlerDslTestLanguageGrammarAccess.INSTANCE.prStatemachine();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Statemachine";
	}
	
	public void setEventConsumer(FowlerDslTestLanguageEventConsumer eventConsumer) {
		this.eventConsumer = eventConsumer;
	}
	
	public void setStateConsumer(FowlerDslTestLanguageStateConsumer stateConsumer) {
		this.stateConsumer = stateConsumer;
	}
	
	public void setCommandConsumer(FowlerDslTestLanguageCommandConsumer commandConsumer) {
		this.commandConsumer = commandConsumer;
	}
	
}

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

import org.eclipse.xtext.testlanguages.services.FowlerDslTestLanguageGrammarAccess;
import org.eclipse.xtext.testlanguages.services.FowlerDslTestLanguageGrammarAccess.StatemachineElements;

import org.eclipse.xtext.testlanguages.parser.packrat.consumers.FowlerDslTestLanguageCommandConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.FowlerDslTestLanguageEventConsumer;
import org.eclipse.xtext.testlanguages.parser.packrat.consumers.FowlerDslTestLanguageStateConsumer;

@SuppressWarnings("unused")
public final class FowlerDslTestLanguageStatemachineConsumer extends NonTerminalConsumer {

	private FowlerDslTestLanguageCommandConsumer commandConsumer;
	private FowlerDslTestLanguageEventConsumer eventConsumer;
	private FowlerDslTestLanguageStateConsumer stateConsumer;

	private ICharacterClass keyword$10$Delimiter;
	
	private ICharacterClass keyword$11$Delimiter;
	
	private ICharacterClass keyword$14$Delimiter;
	
	private ICharacterClass keyword$7$Delimiter;
	
	public FowlerDslTestLanguageStatemachineConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$10$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$14$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$7$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected boolean doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected boolean consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		if (!consumeKeyword$7()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$8()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeKeyword$10()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeKeyword$11()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$12()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeKeyword$14()) {
			marker.rollback();
			marker.release();
			return false;
		}
		if (!consumeAssignment$15()) {
			marker.rollback();
			marker.release();
			return false;
		}
		marker.release();
		return true;
	}

	protected boolean consumeKeyword$7() throws Exception {
		return consumeKeyword(getRule().ele000000KeywordEvents(), null, false, false, getKeyword$7$Delimiter());
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
		return consumeKeyword(getRule().ele00001KeywordEnd(), null, false, false, getKeyword$10$Delimiter());
	}

	protected boolean consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele0001KeywordCommands(), null, false, false, getKeyword$11$Delimiter());
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
		return consumeKeyword(getRule().ele01KeywordEnd(), null, false, false, getKeyword$14$Delimiter());
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
	
	public void setCommandConsumer(FowlerDslTestLanguageCommandConsumer commandConsumer) {
		this.commandConsumer = commandConsumer;
	}
	
	public void setEventConsumer(FowlerDslTestLanguageEventConsumer eventConsumer) {
		this.eventConsumer = eventConsumer;
	}
	
	public void setStateConsumer(FowlerDslTestLanguageStateConsumer stateConsumer) {
		this.stateConsumer = stateConsumer;
	}
	
	public ICharacterClass getKeyword$10$Delimiter() {
		return keyword$10$Delimiter;
	}
	
	public void setKeyword$10$Delimiter(ICharacterClass characterClass) {
		keyword$10$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$11$Delimiter() {
		return keyword$11$Delimiter;
	}
	
	public void setKeyword$11$Delimiter(ICharacterClass characterClass) {
		keyword$11$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$14$Delimiter() {
		return keyword$14$Delimiter;
	}
	
	public void setKeyword$14$Delimiter(ICharacterClass characterClass) {
		keyword$14$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
	public ICharacterClass getKeyword$7$Delimiter() {
		return keyword$7$Delimiter;
	}
	
	public void setKeyword$7$Delimiter(ICharacterClass characterClass) {
		keyword$7$Delimiter = characterClass != null ? characterClass : ICharacterClass.Factory.nullClass();
	}
	
}

/*
Generated with Xtext
*/
package org.eclipse.xtext.example.parser.packrat.consumers;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.packrat.ICharSequenceWithOffset;
import org.eclipse.xtext.parser.packrat.IHiddenTokenHandler;
import org.eclipse.xtext.parser.packrat.IMarkerFactory;
import org.eclipse.xtext.parser.packrat.IMarkerFactory.IMarker;
import org.eclipse.xtext.parser.packrat.consumers.IConsumerUtility;
import org.eclipse.xtext.parser.packrat.consumers.ITerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.NonTerminalConsumer;
import org.eclipse.xtext.parser.packrat.consumers.ConsumeResult;
import org.eclipse.xtext.parser.packrat.matching.ICharacterClass;
import org.eclipse.xtext.parser.packrat.matching.ISequenceMatcher;
import org.eclipse.xtext.parser.packrat.tokens.IParsedTokenAcceptor;

import org.eclipse.xtext.example.services.FowlerDslGrammarAccess;
import org.eclipse.xtext.example.services.FowlerDslGrammarAccess.StatemachineElements;

import org.eclipse.xtext.example.parser.packrat.consumers.FowlerDslCommandConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.FowlerDslEventConsumer;
import org.eclipse.xtext.example.parser.packrat.consumers.FowlerDslStateConsumer;

@SuppressWarnings("unused")
public final class FowlerDslStatemachineConsumer extends NonTerminalConsumer {

	private FowlerDslCommandConsumer commandConsumer;
	private FowlerDslEventConsumer eventConsumer;
	private FowlerDslStateConsumer stateConsumer;

	private ICharacterClass keyword$10$Delimiter;
	
	private ICharacterClass keyword$11$Delimiter;
	
	private ICharacterClass keyword$14$Delimiter;
	
	private ICharacterClass keyword$7$Delimiter;
	
	public FowlerDslStatemachineConsumer(ICharSequenceWithOffset input, IMarkerFactory markerFactory,
			IParsedTokenAcceptor tokenAcceptor, IHiddenTokenHandler hiddenTokenHandler, IConsumerUtility consumerUtil,
			ITerminalConsumer[] hiddenTokens) {
		super(input, markerFactory, tokenAcceptor, hiddenTokenHandler, consumerUtil, hiddenTokens);
		keyword$10$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$11$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$14$Delimiter = ICharacterClass.Factory.nullClass();
		keyword$7$Delimiter = ICharacterClass.Factory.nullClass();
	}
	
	protected int doConsume() throws Exception {
		return consumeGroup$1();
	}

	protected int consumeGroup$1() throws Exception {
		final IMarker marker = mark();
		int result;
		result = consumeKeyword$7(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele000000KeywordEvents());
			marker.commit();
			return result;
		}
		result = consumeAssignment$8(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele000001AssignmentEvents());
			marker.commit();
			return result;
		}
		result = consumeKeyword$10(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele00001KeywordEnd());
			marker.commit();
			return result;
		}
		result = consumeKeyword$11(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele0001KeywordCommands());
			marker.commit();
			return result;
		}
		result = consumeAssignment$12(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele001AssignmentCommands());
			marker.commit();
			return result;
		}
		result = consumeKeyword$14(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele01KeywordEnd());
			marker.commit();
			return result;
		}
		result = consumeAssignment$15(); 
		if (result!=ConsumeResult.SUCCESS) {
			error("Another token expected.", getRule().ele1AssignmentStates());
			marker.commit();
			return result;
		}
		marker.commit();
		return result;
	}

	protected int consumeKeyword$7() throws Exception {
		return consumeKeyword(getRule().ele000000KeywordEvents(), null, false, false, getKeyword$7$Delimiter());
	}

	protected int consumeAssignment$8() throws Exception {
		IMarker marker = mark();
		while(doConsumeAssignment$8() == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$8() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(eventConsumer, "events", true, false, getRule().ele0000010ParserRuleCallEvent());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeKeyword$10() throws Exception {
		return consumeKeyword(getRule().ele00001KeywordEnd(), null, false, false, getKeyword$10$Delimiter());
	}

	protected int consumeKeyword$11() throws Exception {
		return consumeKeyword(getRule().ele0001KeywordCommands(), null, false, false, getKeyword$11$Delimiter());
	}

	protected int consumeAssignment$12() throws Exception {
		IMarker marker = mark();
		while(doConsumeAssignment$12() == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$12() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(commandConsumer, "commands", true, false, getRule().ele0010ParserRuleCallCommand());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	protected int consumeKeyword$14() throws Exception {
		return consumeKeyword(getRule().ele01KeywordEnd(), null, false, false, getKeyword$14$Delimiter());
	}

	protected int consumeAssignment$15() throws Exception {
		IMarker marker = mark();
		while(doConsumeAssignment$15() == ConsumeResult.SUCCESS) {
			marker.flush();
		}
		marker.rollback();
		return ConsumeResult.SUCCESS;
	}

	protected int doConsumeAssignment$15() throws Exception {
		int result = Integer.MIN_VALUE;
		int tempResult;
		tempResult = consumeNonTerminal(stateConsumer, "states", true, false, getRule().ele10ParserRuleCallState());
		if (tempResult == ConsumeResult.SUCCESS)
			return tempResult;
		result = tempResult >= result ? tempResult : result; 
		return result;
	}

	public StatemachineElements getRule() {
		return FowlerDslGrammarAccess.INSTANCE.prStatemachine();
	}
	
	protected EObject getGrammarElement() {
		return getRule().getRule();
	}

	@Override
	protected String getDefaultTypeName() {
		return "Statemachine";
	}
	
	public void setCommandConsumer(FowlerDslCommandConsumer commandConsumer) {
		this.commandConsumer = commandConsumer;
	}
	
	public void setEventConsumer(FowlerDslEventConsumer eventConsumer) {
		this.eventConsumer = eventConsumer;
	}
	
	public void setStateConsumer(FowlerDslStateConsumer stateConsumer) {
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

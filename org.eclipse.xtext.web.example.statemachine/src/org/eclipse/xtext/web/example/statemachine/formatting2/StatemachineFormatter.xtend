/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.statemachine.formatting2;

import com.google.inject.Inject
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.web.example.statemachine.services.StatemachineGrammarAccess
import org.eclipse.xtext.web.example.statemachine.statemachine.Command
import org.eclipse.xtext.web.example.statemachine.statemachine.Condition
import org.eclipse.xtext.web.example.statemachine.statemachine.Event
import org.eclipse.xtext.web.example.statemachine.statemachine.Signal
import org.eclipse.xtext.web.example.statemachine.statemachine.State
import org.eclipse.xtext.web.example.statemachine.statemachine.Statemachine
import org.eclipse.xtext.web.example.statemachine.statemachine.Transition

class StatemachineFormatter extends AbstractFormatter2 {
	
	@Inject extension StatemachineGrammarAccess
	
	def dispatch void format(Statemachine statemachine, extension IFormattableDocument document) {
		for (signal : statemachine.signals) {
			format(signal, document)
			signal.append[setNewLines(1, 1, 2)]
		}
		for (state : statemachine.states) {
			format(state, document)
			state.append[setNewLines(1, 1, 2)]
		}
	}

	def dispatch void format(Signal signal, extension IFormattableDocument document) {
		signal.regionFor.keyword(signalAccess.signalKeyword_1).prepend[oneSpace].append[oneSpace]
	}

	def dispatch void format(State state, extension IFormattableDocument document) {
		state.regionFor.keyword(stateAccess.stateKeyword_0).append[oneSpace]
		interior(
			state.regionFor.assignment(stateAccess.nameAssignment_1).append[newLine],
			state.regionFor.keyword(stateAccess.endKeyword_5),
			[indent]
		)
		for (command : state.commands) {
			format(command, document)
			command.append[newLine]
		}
		for (transition : state.transitions) {
			format(transition, document)
			transition.append[newLine]
		}
		for (nestedState : state.nestedStates) {
			format(nestedState, document)
			nestedState.append[newLine]
		}
	}

	def dispatch void format(Command command, extension IFormattableDocument document) {
		command.regionFor.keyword(commandAccess.setKeyword_0).append[oneSpace]
		command.regionFor.keyword(commandAccess.equalsSignKeyword_2).prepend[oneSpace].append[oneSpace]
	}

	def dispatch void format(Transition transition, extension IFormattableDocument document) {
		transition.regionFor.keyword(transitionAccess.ifKeyword_0).append[oneSpace]
		transition.regionFor.keyword(transitionAccess.gotoKeyword_2).prepend[oneSpace].append[oneSpace]
		if (transition.condition !== null)
			format(transition.condition, document);
	}

	def dispatch void format(Condition condition, extension IFormattableDocument document) {
		condition.regionFor.keywords(conditionAccess.andKeyword_1_0).forEach[prepend[oneSpace].append[oneSpace]]
		for (event : condition.events) {
			format(event, document);
		}
	}
	
	def dispatch void format(Event event, extension IFormattableDocument document) {
		event.regionFor.keyword(eventAccess.equalsSignEqualsSignKeyword_1).prepend[oneSpace].append[oneSpace]
	}
	
}

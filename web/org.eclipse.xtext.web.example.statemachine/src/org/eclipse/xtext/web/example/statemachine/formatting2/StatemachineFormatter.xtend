/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.statemachine.formatting2;

import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument
import org.eclipse.xtext.web.example.statemachine.statemachine.Command
import org.eclipse.xtext.web.example.statemachine.statemachine.Condition
import org.eclipse.xtext.web.example.statemachine.statemachine.Signal
import org.eclipse.xtext.web.example.statemachine.statemachine.State
import org.eclipse.xtext.web.example.statemachine.statemachine.Statemachine
import org.eclipse.xtext.web.example.statemachine.statemachine.Transition

class StatemachineFormatter extends AbstractFormatter2 {
	
	def dispatch void format(Statemachine statemachine, extension IFormattableDocument document) {
		for (signal : statemachine.getSignals()) {
			format(signal, document);
		}
		for (state : statemachine.getStates()) {
			format(state, document);
		}
	}

	def dispatch void format(Signal signal, extension IFormattableDocument document) {
		signal.prepend[newLine]
	}

	def dispatch void format(State state, extension IFormattableDocument document) {
		state.prepend[setNewLines(1, 1, 2)]
		state.regionFor.keyword('end').prepend[newLine]
		interior(state.regionFor.keyword('state') -> state.regionFor.keyword('end'), [indent])
		for (command : state.getCommands()) {
			format(command, document);
		}
		for (transition : state.getTransitions()) {
			format(transition, document);
		}
	}

	def dispatch void format(Command command, extension IFormattableDocument document) {
		command.prepend[newLine]
	}

	def dispatch void format(Transition transition, extension IFormattableDocument document) {
		transition.prepend[newLine] 
		format(transition.getCondition(), document);
	}

	def dispatch void format(Condition condition, extension IFormattableDocument document) {
		for (event : condition.getEvents()) {
			format(event, document);
		}
	}
}

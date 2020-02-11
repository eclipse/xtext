/*******************************************************************************
 * Copyright (c) 2018, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.fowlerdsl.formatting2

import com.google.inject.Inject
import java.util.List
import org.eclipse.xtext.example.fowlerdsl.services.StatemachineGrammarAccess
import org.eclipse.xtext.example.fowlerdsl.statemachine.Command
import org.eclipse.xtext.example.fowlerdsl.statemachine.Event
import org.eclipse.xtext.example.fowlerdsl.statemachine.State
import org.eclipse.xtext.example.fowlerdsl.statemachine.Statemachine
import org.eclipse.xtext.example.fowlerdsl.statemachine.Transition
import org.eclipse.xtext.formatting2.AbstractFormatter2
import org.eclipse.xtext.formatting2.IFormattableDocument

import static org.eclipse.xtext.example.fowlerdsl.statemachine.StatemachinePackage.Literals.*

import static extension com.google.common.base.Strings.repeat

class StatemachineFormatter extends AbstractFormatter2 {

	@Inject extension StatemachineGrammarAccess

	def dispatch void format(Statemachine it, extension IFormattableDocument document) {

		formatEvents(document)

		formatResetEvents(document)

		formatCommands(document)

		formatStates(document)
	}

	def void formatEvents(Statemachine it, extension IFormattableDocument document) {
		// indent the event definitions between the 'events' keyword and the 'end' keyword
		val begin = regionFor.keyword("events")
		val end = regionFor.keyword(statemachineAccess.getEndKeyword_1_2)

		begin.append[newLine]
		interior(begin, end)[indent]

		events.forEach[format]

		if(hasResetEvents || hasCommands || hasStates) {
			end.append[setNewLines(2)]
		}
	}

	def void formatResetEvents(Statemachine it, extension IFormattableDocument document) {
		// indent the event references between the 'resetEvents' keyword and the 'end' keyword
		val begin = regionFor.keyword("resetEvents")
		val end = regionFor.keyword(statemachineAccess.endKeyword_2_2)

		begin.append[newLine]
		interior(begin, end)[indent]

		// format each event reference
		regionFor.assignment(statemachineAccess.resetEventsAssignment_2_1).append[newLine]

		end.prepend[newLine]

		if(hasCommands || hasStates) {
			end.append[setNewLines(2)]
		}
	}

	def void formatCommands(Statemachine it, extension IFormattableDocument document) {
		// indent the command definitions between the 'commands' keyword and the 'end' keyword
		val begin = regionFor.keyword("commands")
		var end = regionFor.keyword(statemachineAccess.endKeyword_3_2)

		begin.append[newLine]
		interior(begin, end)[indent]

		commands.forEach[format]

		if(hasStates) {
			end.append[setNewLines(2)]
		}
	}

	def void formatStates(Statemachine it, extension IFormattableDocument document) {
		states.forEach[format]
	}

	def dispatch void format(Event event, extension IFormattableDocument document) {
		// align the event name and the event code in columns based on the longest event name
		event.regionFor.feature(EVENT__NAME).
		append[space = event.additionalSpaces]

		// line break after each event definition
		event.append[newLine]
	}

	def dispatch void format(Command command, extension IFormattableDocument document) {
		// align the command name and the command code in columns based on the longest command name
		command.regionFor.feature(COMMAND__NAME).
		append[space = command.additionalSpaces]

		// line break after each command definition
		command.append[newLine]
	}

	def dispatch void format(State it, extension IFormattableDocument document) {
		// indent the state elements between the name of the state and the 'end' keyword
		val begin = regionFor.feature(STATE__NAME)
		var end = regionFor.keyword(stateAccess.endKeyword_4)

		begin.append[newLine]
		interior(begin, end)[indent]

		formatActions(document)

		transitions.forEach[format]

		if(isLastState) {
			append[newLine]
		} else {
			append[setNewLines(2)]
		}
	}

	def formatActions(State it, extension IFormattableDocument document) {
		// line break after the action definitions
		regionFor.keyword("}").append[newLine]
	}

	def dispatch void format(Transition transition, extension IFormattableDocument document) {
		// align the event name and the transition's state in columns based on the longest event name
		transition.regionFor.assignment(transitionAccess.eventAssignment_0).
		append[space = transition.additionalSpaces]

		// line break after each transition
		transition.append[newLine]
	}

	private def additionalSpaces(Event it) {
		val statemachine = eContainer as Statemachine
		statemachine.events.map[name].additionalSpaces(name)
	}

	private def additionalSpaces(Command it) {
		val statemachine = eContainer as Statemachine
		statemachine.commands.map[name].additionalSpaces(name)
	}

	private def additionalSpaces(Transition it) {
		val state = eContainer as State
		state.transitions.map[event.name].additionalSpaces(event.name)
	}

	private def additionalSpaces(List<String> it, String name) {
		" ".repeat(longestName.length - name.length + 1)
	}

	private def getLongestName(List<String> it) {
		sortBy[-length].head
	}

	private def hasResetEvents(Statemachine it) {
		!resetEvents.isEmpty
	}

	private def hasCommands(Statemachine it) {
		!commands.isEmpty
	}

	private def hasStates(Statemachine it) {
		!states.isEmpty
	}

	private def isLastState(State it) {
		val statemachine = eContainer as Statemachine
		it == statemachine.states.last
	}
}

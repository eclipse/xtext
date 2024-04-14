/*******************************************************************************
 * Copyright (c) 2018, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.example.fowlerdsl.formatting2;

import static org.eclipse.xtext.example.fowlerdsl.statemachine.StatemachinePackage.Literals.COMMAND__NAME;
import static org.eclipse.xtext.example.fowlerdsl.statemachine.StatemachinePackage.Literals.EVENT__NAME;
import static org.eclipse.xtext.example.fowlerdsl.statemachine.StatemachinePackage.Literals.STATE__NAME;

import java.util.List;
import java.util.Objects;

import org.eclipse.xtext.example.fowlerdsl.services.StatemachineGrammarAccess;
import org.eclipse.xtext.example.fowlerdsl.statemachine.Command;
import org.eclipse.xtext.example.fowlerdsl.statemachine.Event;
import org.eclipse.xtext.example.fowlerdsl.statemachine.State;
import org.eclipse.xtext.example.fowlerdsl.statemachine.Statemachine;
import org.eclipse.xtext.example.fowlerdsl.statemachine.Transition;
import org.eclipse.xtext.formatting2.AbstractJavaFormatter;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

import com.google.common.base.Strings;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;

public class StatemachineFormatter extends AbstractJavaFormatter {

	@Inject
	private StatemachineGrammarAccess ga;

	protected void format(Statemachine sm, IFormattableDocument document) {
		formatEvents(sm, document);
		formatResetEvents(sm, document);
		formatCommands(sm, document);
		formatStates(sm, document);
	}

	protected void formatEvents(Statemachine sm, IFormattableDocument doc) {
		// indent the event definitions between the 'events' keyword and the 'end'
		// keyword
		ISemanticRegion begin = regionFor(sm).keyword("events");
		ISemanticRegion end = regionFor(sm).keyword(ga.getStatemachineAccess().getEndKeyword_1_2());

		doc.append(begin, it -> it.newLine());
		doc.interior(begin, end, it -> it.indent());

		for (Event event : sm.getEvents()) {
			format(event, doc);
		}

		if (hasResetEvents(sm) || hasCommands(sm) || hasStates(sm)) {
			doc.append(end, it -> it.setNewLines(2));
		}
	}

	protected void formatResetEvents(Statemachine sm, IFormattableDocument doc) {
		// indent the event references between the 'resetEvents' keyword and the 'end'
		// keyword
		ISemanticRegion begin = regionFor(sm).keyword("resetEvents");
		ISemanticRegion end = regionFor(sm).keyword(ga.getStatemachineAccess().getEndKeyword_2_2());

		doc.append(begin, it -> it.newLine());
		doc.interior(begin, end, it -> it.indent());

		// format each event reference
		doc.append(regionFor(sm).assignment(ga.getStatemachineAccess().getResetEventsAssignment_2_1()),
				it -> it.newLine());

		doc.prepend(end, it -> it.newLine());

		if (hasCommands(sm) || hasStates(sm)) {
			doc.append(end, it -> it.setNewLines(2));
		}
	}

	protected void formatCommands(Statemachine sm, IFormattableDocument doc) {
		// indent the command definitions between the 'commands' keyword and the 'end'
		// keyword
		ISemanticRegion begin = regionFor(sm).keyword("commands");
		ISemanticRegion end = regionFor(sm).keyword(ga.getStatemachineAccess().getEndKeyword_3_2());

		doc.append(begin, it -> it.newLine());
		doc.interior(begin, end, it -> it.indent());

		for (Command command : sm.getCommands()) {
			format(command, doc);
		}

		if (hasStates(sm)) {
			doc.append(end, it -> it.setNewLines(2));
		}
	}

	protected void formatStates(Statemachine sm, IFormattableDocument doc) {
		for (State state : sm.getStates()) {
			format(state, doc);
		}
	}

	protected void format(Event event, IFormattableDocument doc) {
		// align the event name and the event code in columns based on the longest event
		// name
		doc.append(regionFor(event).feature(EVENT__NAME), it -> it.setSpace(additionalSpaces(event)));
		// line break after each event definition
		doc.append(event, it -> it.newLine());
	}

	protected void format(Command command, IFormattableDocument doc) {
		// align the command name and the command code in columns based on the longest
		// command name
		doc.append(regionFor(command).feature(COMMAND__NAME), it -> it.setSpace(additionalSpaces(command)));
		// line break after each command definition
		doc.append(command, it -> it.newLine());
	}

	protected void format(State s, IFormattableDocument doc) {
		// indent the state elements between the name of the state and the 'end' keyword
		ISemanticRegion begin = regionFor(s).feature(STATE__NAME);
		ISemanticRegion end = regionFor(s).keyword(ga.getStateAccess().getEndKeyword_4());

		doc.append(begin, it -> it.newLine());
		doc.interior(begin, end, it -> it.indent());

		formatActions(s, doc);

		for (Transition transition : s.getTransitions()) {
			format(transition, doc);
		}

		if (isLastState(s)) {
			doc.append(s, it -> it.newLine());
		} else {
			doc.append(s, it -> it.setNewLines(2));
		}
	}

	protected void formatActions(State s, IFormattableDocument doc) {
		// line break after the action definitions
		doc.append(regionFor(s).keyword("}"), it -> it.newLine());
	}

	protected void format(Transition transition, IFormattableDocument doc) {
		// align the event name and the transition's state in columns based on the
		// longest event name
		doc.append(regionFor(transition).assignment(ga.getTransitionAccess().getEventAssignment_0()),
				it -> it.setSpace(additionalSpaces(transition)));
		// line break after each transition
		doc.append(transition, it -> it.newLine());
	}

	private String additionalSpaces(Event event) {
		Statemachine statemachine = (Statemachine) event.eContainer();
		return additionalSpaces(Lists.transform(statemachine.getEvents(), Event::getName), event.getName());
	}

	private String additionalSpaces(Command command) {
		Statemachine statemachine = (Statemachine) command.eContainer();
		return additionalSpaces(Lists.transform(statemachine.getCommands(), Command::getName), command.getName());
	}

	private String additionalSpaces(Transition transition) {
		State state = (State) transition.eContainer();
		return additionalSpaces(Lists.transform(state.getTransitions(), it -> it.getEvent().getName()),
				transition.getEvent().getName());
	}

	private String additionalSpaces(List<String> allNames, String name) {
		return Strings.repeat(" ", getLongestName(allNames).length() - name.length() + 1);
	}

	private String getLongestName(List<String> names) {
		return Iterables.getFirst(IterableExtensions.sortBy(names, n -> -n.length()), null);
	}

	private boolean hasResetEvents(Statemachine sm) {
		return !sm.getResetEvents().isEmpty();
	}

	private boolean hasCommands(Statemachine sm) {
		return !sm.getCommands().isEmpty();
	}

	private boolean hasStates(Statemachine sm) {
		return !sm.getStates().isEmpty();
	}

	private boolean isLastState(State state) {
		Statemachine statemachine = (Statemachine) state.eContainer();
		return Objects.equals(state, Iterables.getLast(statemachine.getStates()));
	}

}

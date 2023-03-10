/*******************************************************************************
 * Copyright (c) 2015, 2020 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.web.example.statemachine.formatting2;

import org.eclipse.xtext.formatting2.AbstractJavaFormatter;
import org.eclipse.xtext.formatting2.IFormattableDocument;
import org.eclipse.xtext.formatting2.regionaccess.ISemanticRegion;
import org.eclipse.xtext.web.example.statemachine.services.StatemachineGrammarAccess;
import org.eclipse.xtext.web.example.statemachine.statemachine.Command;
import org.eclipse.xtext.web.example.statemachine.statemachine.Condition;
import org.eclipse.xtext.web.example.statemachine.statemachine.Event;
import org.eclipse.xtext.web.example.statemachine.statemachine.Signal;
import org.eclipse.xtext.web.example.statemachine.statemachine.State;
import org.eclipse.xtext.web.example.statemachine.statemachine.Statemachine;
import org.eclipse.xtext.web.example.statemachine.statemachine.Transition;

import com.google.inject.Inject;

public class StatemachineFormatter extends AbstractJavaFormatter {

	@Inject
	private StatemachineGrammarAccess ga;

	protected void format(Statemachine statemachine, IFormattableDocument doc) {
		for (Signal signal : statemachine.getSignals()) {
			doc.format(signal);
			doc.append(signal, it -> it.setNewLines(1, 1, 2));
		}
		for (State state : statemachine.getStates()) {
			doc.format(state);
			doc.append(state, it -> it.setNewLines(1, 1, 2));
		}
	}

	protected void format(Signal signal, IFormattableDocument doc) {
		ISemanticRegion signalKeyword = regionFor(signal).keyword(ga.getSignalAccess().getSignalKeyword_1());
		doc.prepend(signalKeyword, it -> it.oneSpace());
		doc.append(signalKeyword, it -> it.oneSpace());
	}

	protected void format(State state, IFormattableDocument doc) {
		doc.append(regionFor(state).keyword(ga.getStateAccess().getStateKeyword_0()), it -> it.oneSpace());
		ISemanticRegion nameAssignment = regionFor(state).assignment(ga.getStateAccess().getNameAssignment_1());
		doc.append(nameAssignment, it -> it.newLine());
		doc.interior(nameAssignment, regionFor(state).keyword(ga.getStateAccess().getEndKeyword_5()),
				it -> it.indent());
		for (Command command : state.getCommands()) {
			doc.format(command);
			doc.append(command, it -> it.newLine());
		}
		for (Transition transition : state.getTransitions()) {
			doc.format(transition);
			doc.append(transition, it -> it.newLine());
		}
		for (State nestedState : state.getNestedStates()) {
			doc.format(nestedState);
			doc.append(nestedState, it -> it.newLine());
		}
	}

	protected void format(Command command, IFormattableDocument doc) {
		doc.append(regionFor(command).keyword(ga.getCommandAccess().getSetKeyword_0()), it -> it.oneSpace());
		ISemanticRegion equalsSignKeyword = regionFor(command).keyword(ga.getCommandAccess().getEqualsSignKeyword_2());
		doc.prepend(equalsSignKeyword, it -> it.oneSpace());
		doc.append(equalsSignKeyword, it -> it.oneSpace());
	}

	protected void format(Transition transition, IFormattableDocument doc) {
		doc.append(regionFor(transition).keyword(ga.getTransitionAccess().getIfKeyword_0()), it -> it.oneSpace());
		ISemanticRegion gotoKeyword = regionFor(transition).keyword(ga.getTransitionAccess().getGotoKeyword_2());
		doc.prepend(gotoKeyword, it -> it.oneSpace());
		doc.append(gotoKeyword, it -> it.oneSpace());
		if (transition.getCondition() != null) {
			doc.format(transition.getCondition());
		}
	}

	protected void format(Condition condition, IFormattableDocument doc) {
		ISemanticRegion andKeyword = regionFor(condition).keyword(ga.getConditionAccess().getAndKeyword_1_0());
		doc.prepend(andKeyword, it -> it.oneSpace());
		doc.append(andKeyword, it -> it.oneSpace());
		for (Event event : condition.getEvents()) {
			doc.format(event);
		}

	}

	protected void format(Event event, IFormattableDocument doc) {
		ISemanticRegion equalsSignEqualsSignKeyword = regionFor(event)
				.keyword(ga.getEventAccess().getEqualsSignEqualsSignKeyword_1());
		doc.prepend(equalsSignEqualsSignKeyword, it -> it.oneSpace());
		doc.append(equalsSignEqualsSignKeyword, it -> it.oneSpace());
	}

}

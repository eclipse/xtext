/*******************************************************************************
 * Copyright (c) 2015, 2019 itemis AG (http://www.itemis.eu) and others.
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * SPDX-License-Identifier: EPL-2.0
 *******************************************************************************/
package org.eclipse.xtext.web.example.statemachine.validation;

import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.web.example.statemachine.statemachine.Command;
import org.eclipse.xtext.web.example.statemachine.statemachine.Event;
import org.eclipse.xtext.web.example.statemachine.statemachine.InputSignal;
import org.eclipse.xtext.web.example.statemachine.statemachine.OutputSignal;

import static org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage.Literals.*;

/**
 * This class contains custom validation rules.
 *
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class StatemachineValidator extends AbstractStatemachineValidator {

	@Check
	public void checkEventUsesInputSignal(Event event) {
		if (event.getSignal() != null && !event.getSignal().eIsProxy() && !(event.getSignal() instanceof InputSignal)) {
			error("Only input signals are allowed for read access.", event, EVENT__SIGNAL);
		}
	}

	@Check
	public void checkCommandUsesOutputSignal(Command command) {
		if (command.getSignal() != null && !command.getSignal().eIsProxy()
				&& !(command.getSignal() instanceof OutputSignal)) {
			error("Only output signals are allowed for write access.", command, COMMAND__SIGNAL);
		}
	}

}

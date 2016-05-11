/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.example.statemachine.validation;

import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.web.example.statemachine.statemachine.Command;
import org.eclipse.xtext.web.example.statemachine.statemachine.Event;
import org.eclipse.xtext.web.example.statemachine.statemachine.InputSignal;
import org.eclipse.xtext.web.example.statemachine.statemachine.OutputSignal;
import org.eclipse.xtext.web.example.statemachine.statemachine.StatemachinePackage;
import org.eclipse.xtext.web.example.statemachine.validation.AbstractStatemachineValidator;

/**
 * This class contains custom validation rules.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
@SuppressWarnings("all")
public class StatemachineValidator extends AbstractStatemachineValidator {
  @Check
  public void checkEventUsesInputSignal(final Event event) {
    if ((((event.getSignal() != null) && (!event.getSignal().eIsProxy())) && (!(event.getSignal() instanceof InputSignal)))) {
      this.error("Only input signals are allowed for read access.", event, StatemachinePackage.Literals.EVENT__SIGNAL);
    }
  }
  
  @Check
  public void checkCommandUsesOutputSignal(final Command command) {
    if ((((command.getSignal() != null) && (!command.getSignal().eIsProxy())) && (!(command.getSignal() instanceof OutputSignal)))) {
      this.error("Only output signals are allowed for write access.", command, StatemachinePackage.Literals.COMMAND__SIGNAL);
    }
  }
}

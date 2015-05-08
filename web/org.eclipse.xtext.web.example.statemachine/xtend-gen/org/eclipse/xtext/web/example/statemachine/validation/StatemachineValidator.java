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
import org.eclipse.xtext.web.example.statemachine.statemachine.Signal;
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
    boolean _and = false;
    boolean _and_1 = false;
    Signal _signal = event.getSignal();
    boolean _tripleNotEquals = (_signal != null);
    if (!_tripleNotEquals) {
      _and_1 = false;
    } else {
      Signal _signal_1 = event.getSignal();
      boolean _eIsProxy = _signal_1.eIsProxy();
      boolean _not = (!_eIsProxy);
      _and_1 = _not;
    }
    if (!_and_1) {
      _and = false;
    } else {
      _and = (!(event.getSignal() instanceof InputSignal));
    }
    if (_and) {
      this.error("Only input signals are allowed for read access.", event, StatemachinePackage.Literals.EVENT__SIGNAL);
    }
  }
  
  @Check
  public void checkCommandUsesOutputSignal(final Command command) {
    boolean _and = false;
    boolean _and_1 = false;
    Signal _signal = command.getSignal();
    boolean _tripleNotEquals = (_signal != null);
    if (!_tripleNotEquals) {
      _and_1 = false;
    } else {
      Signal _signal_1 = command.getSignal();
      boolean _eIsProxy = _signal_1.eIsProxy();
      boolean _not = (!_eIsProxy);
      _and_1 = _not;
    }
    if (!_and_1) {
      _and = false;
    } else {
      _and = (!(command.getSignal() instanceof OutputSignal));
    }
    if (_and) {
      this.error("Only output signals are allowed for write access.", command, StatemachinePackage.Literals.COMMAND__SIGNAL);
    }
  }
}

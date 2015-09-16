/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.example.statemachine;

import org.eclipse.xtext.web.example.statemachine.StatemachineStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages
 * without equinox extension registry
 */
@SuppressWarnings("all")
public class StatemachineStandaloneSetup extends StatemachineStandaloneSetupGenerated {
  public static void doSetup() {
    StatemachineStandaloneSetup _statemachineStandaloneSetup = new StatemachineStandaloneSetup();
    _statemachineStandaloneSetup.createInjectorAndDoEMFRegistration();
  }
}

/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.arithmetics;

import org.eclipse.xtext.example.arithmetics.ArithmeticsStandaloneSetupGenerated;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class ArithmeticsStandaloneSetup extends ArithmeticsStandaloneSetupGenerated {
  public static void doSetup() {
    ArithmeticsStandaloneSetup _arithmeticsStandaloneSetup = new ArithmeticsStandaloneSetup();
    _arithmeticsStandaloneSetup.createInjectorAndDoEMFRegistration();
  }
}

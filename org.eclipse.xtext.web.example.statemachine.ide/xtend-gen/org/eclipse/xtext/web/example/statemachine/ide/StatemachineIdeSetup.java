/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.example.statemachine.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.web.example.statemachine.StatemachineRuntimeModule;
import org.eclipse.xtext.web.example.statemachine.StatemachineStandaloneSetup;
import org.eclipse.xtext.web.example.statemachine.ide.StatemachineIdeModule;

/**
 * Initialization support for running Xtext languages as language servers.
 */
@SuppressWarnings("all")
public class StatemachineIdeSetup extends StatemachineStandaloneSetup {
  @Override
  public Injector createInjector() {
    StatemachineRuntimeModule _statemachineRuntimeModule = new StatemachineRuntimeModule();
    StatemachineIdeModule _statemachineIdeModule = new StatemachineIdeModule();
    Module _mixin = Modules2.mixin(_statemachineRuntimeModule, _statemachineIdeModule);
    return Guice.createInjector(_mixin);
  }
}

/**
 * Copyright (c) 2016, 2017 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.example.homeautomation.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.example.homeautomation.RuleEngineRuntimeModule;
import org.eclipse.xtext.example.homeautomation.RuleEngineStandaloneSetup;
import org.eclipse.xtext.example.homeautomation.ide.RuleEngineIdeModule;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages without Equinox extension registry.
 */
@SuppressWarnings("all")
public class RuleEngineIdeSetup extends RuleEngineStandaloneSetup {
  @Override
  public Injector createInjector() {
    RuleEngineRuntimeModule _ruleEngineRuntimeModule = new RuleEngineRuntimeModule();
    RuleEngineIdeModule _ruleEngineIdeModule = new RuleEngineIdeModule();
    return Guice.createInjector(Modules2.mixin(_ruleEngineRuntimeModule, _ruleEngineIdeModule));
  }
}

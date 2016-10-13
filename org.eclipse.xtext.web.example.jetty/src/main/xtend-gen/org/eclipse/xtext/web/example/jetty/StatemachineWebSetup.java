/**
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.xtext.web.example.jetty;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.Provider;
import java.util.concurrent.ExecutorService;
import org.eclipse.xtend.lib.annotations.FinalFieldsConstructor;
import org.eclipse.xtext.util.Modules2;
import org.eclipse.xtext.web.example.jetty.StatemachineWebModule;
import org.eclipse.xtext.web.example.statemachine.StatemachineRuntimeModule;
import org.eclipse.xtext.web.example.statemachine.StatemachineStandaloneSetup;
import org.eclipse.xtext.web.example.statemachine.ide.StatemachineIdeModule;
import org.eclipse.xtext.web.server.persistence.IResourceBaseProvider;

/**
 * Initialization support for running Xtext languages in web applications.
 */
@FinalFieldsConstructor
@SuppressWarnings("all")
public class StatemachineWebSetup extends StatemachineStandaloneSetup {
  private final Provider<ExecutorService> executorServiceProvider;
  
  private final IResourceBaseProvider resourceBaseProvider;
  
  @Override
  public Injector createInjector() {
    final StatemachineRuntimeModule runtimeModule = new StatemachineRuntimeModule();
    final StatemachineIdeModule ideModule = new StatemachineIdeModule(this.executorServiceProvider);
    final StatemachineWebModule webModule = new StatemachineWebModule(this.executorServiceProvider, this.resourceBaseProvider);
    Module _mixin = Modules2.mixin(runtimeModule, ideModule, webModule);
    return Guice.createInjector(_mixin);
  }
  
  public StatemachineWebSetup(final Provider<ExecutorService> executorServiceProvider, final IResourceBaseProvider resourceBaseProvider) {
    super();
    this.executorServiceProvider = executorServiceProvider;
    this.resourceBaseProvider = resourceBaseProvider;
  }
}

/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.statemachine.web;

import com.google.inject.Guice;
import com.google.inject.Module;
import com.google.inject.Provider;
import com.google.inject.util.Modules;
import java.util.concurrent.ExecutorService;
import org.eclipse.xtext.web.example.statemachine.StatemachineStandaloneSetup;

/**
 * Initialization support for running Xtext languages in web applications.
 */
public class StatemachineWebSetup extends StatemachineStandaloneSetup {
	
	private final Provider<ExecutorService> executorServiceProvider;
	
	public StatemachineWebSetup(Provider<ExecutorService> executorServiceProvider) {
		this.executorServiceProvider = executorServiceProvider;
	}
	
	@Override
	public Injector createInjector() {
		Module runtimeModule = new StatemachineRuntimeModule();
		Module webModule = new StatemachineWebModule(executorServiceProvider);
		return Guice.createInjector(Modules.override(runtimeModule).with(webModule));
	}
	
}

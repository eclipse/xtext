/*******************************************************************************
 * Copyright (c) 2016, 2019 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.example.homeautomation.ide;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.eclipse.xtext.example.homeautomation.RuleEngineRuntimeModule;
import org.eclipse.xtext.example.homeautomation.RuleEngineStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

/**
 * Initialization support for running Xtext languages as language servers.
 */
public class RuleEngineIdeSetup extends RuleEngineStandaloneSetup {

	@Override
	public Injector createInjector() {
		return Guice.createInjector(Modules2.mixin(new RuleEngineRuntimeModule(), new RuleEngineIdeModule()));
	}
	
}

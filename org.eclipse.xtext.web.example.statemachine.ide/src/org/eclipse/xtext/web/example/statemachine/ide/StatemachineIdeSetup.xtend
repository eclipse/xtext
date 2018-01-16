/*******************************************************************************
 * Copyright (c) 2015, 2016 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.web.example.statemachine.ide

import com.google.inject.Guice
import org.eclipse.xtext.util.Modules2
import org.eclipse.xtext.web.example.statemachine.StatemachineRuntimeModule
import org.eclipse.xtext.web.example.statemachine.StatemachineStandaloneSetup

/**
 * Initialization support for running Xtext languages as language servers.
 */
class StatemachineIdeSetup extends StatemachineStandaloneSetup {

	override createInjector() {
		Guice.createInjector(Modules2.mixin(new StatemachineRuntimeModule, new StatemachineIdeModule))
	}
	
}

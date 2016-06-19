/*******************************************************************************
 * Copyright (c) 2015 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.index

import com.google.inject.Injector
import org.eclipse.xtext.testing.GlobalRegistries
import org.eclipse.xtext.testing.GlobalRegistries.GlobalStateMemento
import org.eclipse.xtext.testing.IInjectorProvider
import org.eclipse.xtext.testing.IRegistryConfigurator

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class IndexTestLanguageInjectorProvider implements IInjectorProvider, IRegistryConfigurator {

	protected GlobalStateMemento stateBeforeInjectorCreation
	protected GlobalStateMemento stateAfterInjectorCreation
	protected Injector injector

	new() {
		GlobalRegistries.initializeDefaults()
	}

	override Injector getInjector() {
		if (injector === null) {
			stateBeforeInjectorCreation = GlobalRegistries.makeCopyOfGlobalState()
			this.injector = internalCreateInjector()
			stateAfterInjectorCreation = GlobalRegistries.makeCopyOfGlobalState()
		}
		return injector
	}

	def protected Injector internalCreateInjector() {
		new IndexTestLanguageStandaloneSetup().createInjectorAndDoEMFRegistration()
	}

	override void restoreRegistry() {
		stateBeforeInjectorCreation.restoreGlobalState()
	}

	override void setupRegistry() {
		getInjector()
		stateAfterInjectorCreation.restoreGlobalState()
	}

}
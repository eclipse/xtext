package org.eclipse.xtext.java.tests

import com.google.inject.Injector
import org.eclipse.xtext.testing.IInjectorProvider
import org.eclipse.xtext.testing.IRegistryConfigurator
import org.eclipse.xtext.java.JavaSourceLanguageSetup

class JavaInjectorProvider implements IInjectorProvider, IRegistryConfigurator {
	
	val setup = new JavaSourceLanguageSetup
	Injector injector
	
	override getInjector() {
		if (injector == null) {
			this.injector = setup.createInjector
		}
		return injector
	}
	
	override restoreRegistry() {
	}
	
	override setupRegistry() {
		setup.register(getInjector, 'txt')
		setup.register(getInjector, 'java')
	}
	
}
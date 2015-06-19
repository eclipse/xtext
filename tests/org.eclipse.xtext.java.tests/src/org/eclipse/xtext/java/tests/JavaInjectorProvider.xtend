package org.eclipse.xtext.java.tests

import com.google.inject.Injector
import org.eclipse.xtext.java.JavaSourceLanguageSetup
import org.eclipse.xtext.junit4.IInjectorProvider
import org.eclipse.xtext.junit4.IRegistryConfigurator

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
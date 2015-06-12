package org.eclipse.xtext.java.tests

import org.eclipse.xtext.junit4.IInjectorProvider
import com.google.inject.Guice
import org.eclipse.xtext.java.resource.JavaRuntimeModule
import org.eclipse.xtext.junit4.IRegistryConfigurator
import org.eclipse.emf.ecore.resource.Resource

class JavaInjectorProvider implements IInjectorProvider, IRegistryConfigurator {
	
	val injector = Guice.createInjector(new JavaRuntimeModule)
	
	override getInjector() {
		injector
	}
	
	override restoreRegistry() {
	}
	
	override setupRegistry() {
		val factory = injector.getInstance(Resource.Factory)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put('txt',factory)
		Resource.Factory.Registry.INSTANCE.extensionToFactoryMap.put('java',factory)
	}
	
}
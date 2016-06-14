package org.eclipse.xtext.java

import com.google.inject.Guice
import com.google.inject.Injector
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.ISetup
import org.eclipse.xtext.resource.IResourceServiceProvider

class JavaSourceLanguageSetup implements ISetup {
	
	override createInjectorAndDoEMFRegistration() {
		val injector = createInjector();
		register(injector, 'java');
		return injector;
	}
	
	def Injector createInjector() {
		return Guice.createInjector(new JavaSourceLanguageRuntimeModule());
	}
	
	def void register(Injector injector, String fileExtension) {
		val resourceFactory = injector.getInstance(Resource.Factory);
		val serviceProvider = injector.getInstance(IResourceServiceProvider);
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(fileExtension, resourceFactory);
		IResourceServiceProvider.Registry.INSTANCE.getExtensionToFactoryMap().put(fileExtension, serviceProvider);
	}
}
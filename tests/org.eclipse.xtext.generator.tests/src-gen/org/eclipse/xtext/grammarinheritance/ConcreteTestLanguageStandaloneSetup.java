/*
Generated with Xtext
*/
package org.eclipse.xtext.grammarinheritance;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.eclipse.xtext.grammarinheritance.IConcreteTestLanguage;

public abstract class ConcreteTestLanguageStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
		    
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.grammarinheritance.ConcreteTestLanguageRuntimeModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.grammarinheritance.IConcreteTestLanguage.SCOPE, injector);
			
			
			
			org.eclipse.xtext.grammarinheritance.AbstractTestLanguageStandaloneSetup.doSetup();
			
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.grammarinheritance.services.ConcreteTestLanguageResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("concretetestlanguage", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://holla")) {
					EPackage foo = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/grammarinheritance/foo.ecore",
							ConcreteTestLanguageStandaloneSetup.class.getClassLoader());
					if (foo == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/grammarinheritance/foo.ecore'");
					EPackage.Registry.INSTANCE.put("http://holla", foo);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.grammarinheritance.IConcreteTestLanguage.SCOPE;
	}
	
}

/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.IResourceFactory;
import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

import org.eclipse.xtext.example.IFowlerDsl;

public abstract class FowlerDslStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
		    
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.example.FowlerDslRuntimeModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.example.IFowlerDsl.SCOPE, injector);
			
			
			
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.example.services.FowlerDslResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("fowlerdsl", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://example.xtext.org/FowlerDsl")) {
					EPackage fowlerdsl = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/example/fowlerdsl.ecore",
							FowlerDslStandaloneSetup.class.getClassLoader());
					if (fowlerdsl == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/example/fowlerdsl.ecore'");
					EPackage.Registry.INSTANCE.put("http://example.xtext.org/FowlerDsl", fowlerdsl);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.example.IFowlerDsl.SCOPE;
	}
	
}

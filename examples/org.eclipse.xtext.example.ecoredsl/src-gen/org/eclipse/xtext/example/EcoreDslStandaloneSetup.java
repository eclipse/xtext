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

import org.eclipse.xtext.example.IEcoreDsl;

public abstract class EcoreDslStandaloneSetup {

	private static boolean isInitialized = false;

	public synchronized static void doSetup() {
		if(!isInitialized) {
		    
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.example.EcoreDslRuntimeModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.example.IEcoreDsl.SCOPE, injector);
			
			
			
			org.eclipse.xtext.builtin.XtextBuiltinStandaloneSetup.doSetup();
			
			
			// register resource factory to EMF
			IResourceFactory resourceFactory = new org.eclipse.xtext.example.services.EcoreDslResourceFactory();
			Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put("ecoredsl", resourceFactory);
			
			
			// initialize EPackages
			
				if (!EPackage.Registry.INSTANCE.containsKey("http://example.xtext.org/EcoreDsl")) {
					EPackage ecoredsl = EcoreUtil2.loadEPackage(
							"classpath:/org/eclipse/xtext/example/ecoredsl.ecore",
							EcoreDslStandaloneSetup.class.getClassLoader());
					if (ecoredsl == null)
						throw new IllegalStateException(
								"Couldn't load EPackage from 'classpath:/org/eclipse/xtext/example/ecoredsl.ecore'");
					EPackage.Registry.INSTANCE.put("http://example.xtext.org/EcoreDsl", ecoredsl);
				}
			
			isInitialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.example.IEcoreDsl.SCOPE;
	}
	
}

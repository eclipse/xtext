/*
Generated with Xtext
*/
package org.eclipse.xtext.example;

import org.eclipse.xtext.service.IServiceScope;
import org.eclipse.xtext.service.ServiceRegistry;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * GENERATED! 
 */
public class DomainmodelUiSetup {

	private static boolean initialized = false;
	
	public synchronized static void doSetup() {
		if (!initialized) {
			org.eclipse.xtext.example.DomainmodelStandaloneSetup.doSetup();
			
			// overwriting runtime configuration
		    Injector injector = Guice.createInjector(new org.eclipse.xtext.example.DomainmodelRuntimeModule(), new org.eclipse.xtext.example.DomainmodelUIModule());
			ServiceRegistry.registerInjector(org.eclipse.xtext.example.IDomainmodel.SCOPE, injector);
					   
		   initialized = true;
		}
	}
	
	public static IServiceScope getServiceScope() {
	   doSetup();
	   return org.eclipse.xtext.example.IDomainmodel.SCOPE;
	}
	
}
